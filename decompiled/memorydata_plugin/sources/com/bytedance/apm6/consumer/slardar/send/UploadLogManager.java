package com.bytedance.apm6.consumer.slardar.send;

import com.bytedance.apm.e.a;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.consumer.slardar.header.HeaderManager;
import com.bytedance.apm6.consumer.slardar.persistent.LogFile;
import com.bytedance.apm6.consumer.slardar.persistent.LogItem;
import com.bytedance.apm6.consumer.slardar.send.downgrade.DowngradeController;
import com.bytedance.apm6.consumer.slardar.send.downgrade.DowngradeDataStorage;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.log.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class UploadLogManager {
    private static final String KEY_DEBUG_LEFT_COUNT = "debug_left_file_count";
    private static final String KEY_DEBUG_MERGE_COUNT = "debug_merge_file_count";
    private static final String KEY_DEBUG_SECOND_LEFT_COUNT = "debug_second_file_count";
    private static final String KEY_DEBUG_SEQ_NUM = "debug_sender_number";
    private static final String KEY_DEBUG_SID = "debug_sender_sid";
    private static final String KEY_DEBUG_TOTAL_BYTES = "debug_total_bytes";
    private static final String KEY_DEBUG_TOTAL_COUNT = "debug_total_count";
    private static final String KEY_SELF_DEBUG_MESSAGE = "_debug_self";
    private static final UploadLogInfo.ExceptionLogInfo exceptionLogInfo = null;
    private static final UploadLogInfo.MonitorLogInfo monitorLogInfo = null;
    private static AtomicInteger seqNum;
    private static final UploadLogInfo.TraceLogInfo traceLogInfo = null;
    private static final List<String> uploadTypeListInTraceType = null;
    private static final List<UploadLogInfo> uploadTypes = null;

    static {
        seqNum = new AtomicInteger(0);
        uploadTypeListInTraceType = Arrays.asList(new String[]{"tracing"});
        UploadLogInfo.ExceptionLogInfo r0 = new UploadLogInfo.ExceptionLogInfo();
        exceptionLogInfo = r0;
        UploadLogInfo.TraceLogInfo r1 = new UploadLogInfo.TraceLogInfo();
        traceLogInfo = r1;
        UploadLogInfo.MonitorLogInfo r2 = new UploadLogInfo.MonitorLogInfo();
        monitorLogInfo = r2;
        ArrayList r3 = new ArrayList();
        uploadTypes = r3;
        r3.add(r0);
        r3.add(r1);
        r3.add(r2);
    }

    UploadLogManager() {
    }

    private static void debugPrint(Map<Long, List<LogItem>> r11) {
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        if (ApmContext.isDebugMode() == false) goto L12;
        Logger.d(Constants.TAG, "sendLog: input sendList merged into " + r12.size() + " group(s)");
        Iterator r0 = r12.keySet().iterator();
        int r3 = 0;
    L6:
        if (r0.hasNext() == false) goto L15;
        Long r4 = (Long) ZeusTransformUtils.preCheckCast(r0.next(), Long.class, "com.obric.memorydata.plugin");
        List r5 = (List) ZeusTransformUtils.preCheckCast(r12.get(r4), List.class, "com.obric.memorydata.plugin");
        Logger.d(Constants.TAG, "----------------");
        int r9 = r3 + 1;
        Logger.d(Constants.TAG, "group " + r3 + " header:" + HeaderManager.getInstance().getHeaderInfo(String.valueOf(r4)));
        int r6 = 0;
    L9:
        if (r6 >= r5.size()) goto L11;
        Logger.d(Constants.TAG, "  log[" + r6 + "]=" + ((LogItem) ZeusTransformUtils.preCheckCast(r5.get(r6), LogItem.class, "com.obric.memorydata.plugin")).toString());
        r6 = r6 + 1;
        goto L9
    L11:
        Logger.d(Constants.TAG, "----------------");
        r3 = r9;
        goto L6
    L15:
        return;
    }

    private static UploadLogInfo getUploadLogInfo(JSONObject r1) {
        String r2 = r1.optString("log_type");
        if (Constants.EXCEPTION_TYPE.contains(r2) == false) goto L7;
        return exceptionLogInfo;
    L7:
        if (uploadTypeListInTraceType.contains(r2) == false) goto L11;
        return traceLogInfo;
    L11:
        return monitorLogInfo;
    }

    public static List<UploadLogInfo> getUploadType() {
        return uploadTypes;
    }

    public static Map<UploadLogInfo, byte[]> serialize(List<LogFile> r23, int r24) {
        String r1 = KEY_SELF_DEBUG_MESSAGE;
        String r3 = "com.obric.memorydata.plugin";
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r23, List.class, "com.obric.memorydata.plugin");
        HashMap r4 = new HashMap();     // Catch: Throwable -> L77
        long r5 = r2.size();     // Catch: Throwable -> L77
        Iterator r6 = r2.iterator();     // Catch: Throwable -> L77
        long r7 = 0;
        long r9 = 0;
    L5:
        if (r6.hasNext() == false) goto L10;
        LogFile r11 = (LogFile) ZeusTransformUtils.preCheckCast(r6.next(), LogFile.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L77
        long r12 = r11.getStartID();     // Catch: Throwable -> L77
        List r14 = (List) ZeusTransformUtils.preCheckCast(r4.get(Long.valueOf(r12)), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L77
        if (r14 != null) goto L9;
        r14 = new ArrayList();     // Catch: Throwable -> L77
        r4.put(Long.valueOf(r12), r14);     // Catch: Throwable -> L77
    L9:
        r7 = r7 + ((long) r11.getTotalBytes());     // Catch: Throwable -> L77
        r9 = r9 + ((long) r11.getTotalCount());     // Catch: Throwable -> L77
        r14.addAll(r11.getLogList());     // Catch: Throwable -> L77
        goto L5
    L10:
        debugPrint(r4);     // Catch: Throwable -> L77
        File r8 = DiskFileHelper.getInstance().getDirectory();     // Catch: Throwable -> L77
        if (r8 == null) goto L15;
        String[] r10 = r8.list();     // Catch: Throwable -> L77
        if (r10 == null) goto L15;
        int r13 = r10.length;     // Catch: Throwable -> L77
    L16:
        HashMap r15 = new HashMap();     // Catch: Throwable -> L77
        ArrayList r16 = new ArrayList();     // Catch: Throwable -> L77
        Iterator r17 = r4.keySet().iterator();     // Catch: Throwable -> L77
    L18:
        if (r17.hasNext() == false) goto L69;
        Long r18 = (Long) ZeusTransformUtils.preCheckCast(r17.next(), Long.class, r3);     // Catch: Throwable -> L77
        r4 = r4;
        List r19 = (List) ZeusTransformUtils.preCheckCast(r4.get(r18), List.class, r3);     // Catch: Throwable -> L77
        if (r19 == null) goto L18;
        Iterator r110 = r17;
        int r111 = 0;
    L24:
        if (r111 >= r19.size()) goto L68;
        List r112 = r19;
        int r113 = r111;
        JSONObject r114 = new JSONObject(new String(((LogItem) ZeusTransformUtils.preCheckCast(r19.get(r111), LogItem.class, r3)).getData()));     // Catch: Exception -> L83 Throwable -> L77
        if (DowngradeController.getInstance().uploadEnabled(r114, ApmContext.getAid()) == false) goto L32;
        UploadLogInfo r20 = getUploadLogInfo(r114);     // Catch: Throwable -> L77
        if (ZeusTransformUtils.instanceOf(r20, UploadLogInfo.MonitorLogInfo.class) == true) goto L94;
        r1 = r1;
        Long r22 = r18;
        String r115 = r3;
        UploadLogInfo r21 = r20;
    L59:
        Map r25 = (Map) ZeusTransformUtils.preCheckCast(r15.get(r21), Map.class, r115);     // Catch: Throwable -> L77
        if (r25 != null) goto L62;
        r25 = new HashMap();     // Catch: Throwable -> L77
        r15.put(r21, r25);     // Catch: Throwable -> L77
    L62:
        r18 = r22;
        if (r25.containsKey(r18) == true) goto L65;
        r25.put(r18, new JSONArray());     // Catch: Throwable -> L77
    L65:
        ((JSONArray) ZeusTransformUtils.preCheckCast(r25.get(r18), JSONArray.class, r115)).put(r114);     // Catch: Throwable -> L77
    L67:
        r111 = r113 + 1;     // Catch: Throwable -> L77
        r3 = r115;
        r19 = r112;
        r18 = r18;
        r1 = r1;
        goto L24
    L94:
        JSONObject r116 = r114.optJSONObject(r1);     // Catch: Exception -> L51 Throwable -> L77
        if (r116 != null) goto L41;
        r116 = new JSONObject();     // Catch: Exception -> L51 Throwable -> L77
        r114.put(r1, r116);     // Catch: Exception -> L51 Throwable -> L77
    L41:
        r1 = r1;
        r22 = r18;
        r116.put(KEY_DEBUG_SEQ_NUM, seqNum.getAndIncrement());     // Catch: Exception -> L50 Throwable -> L77
        r115 = r3;
        UploadLogInfo r26 = r20;
        r116.put(KEY_DEBUG_SID, ApmContext.getStartId());     // Catch: Exception -> L81 Throwable -> L77
        r116.put(KEY_DEBUG_TOTAL_BYTES, r7);     // Catch: Exception -> L81 Throwable -> L77
        r116.put(KEY_DEBUG_TOTAL_COUNT, r9);     // Catch: Exception -> L81 Throwable -> L77
        r116.put(KEY_DEBUG_MERGE_COUNT, r5);     // Catch: Exception -> L81 Throwable -> L77
        r116.put(KEY_DEBUG_SECOND_LEFT_COUNT, r13);     // Catch: Exception -> L81 Throwable -> L77
        r116.put(KEY_DEBUG_LEFT_COUNT, r24);     // Catch: Exception -> L80 Throwable -> L77
    L55:
        if (r114.has(Constants.KEY_SEQ_NO) == false) goto L57;
        r16.add(String.valueOf(r114.get(Constants.KEY_SEQ_NO)));     // Catch: Throwable -> L77
    L57:
        r21 = r26;
    L50:
        r115 = r3;
        r26 = r20;
    L52:
        r26 = r20;
        r22 = r18;
        r115 = r3;
    L51:
        r1 = r1;
        goto L52
    L32:
        if (ApmContext.isDebugMode() == false) goto L35;
        Logger.d(DowngradeDataStorage.TAG, r114.toString());     // Catch: Throwable -> L77
    L35:
        r115 = r3;
    L66:
        r113 = r111;
        goto L35
    L68:
        r3 = r3;
        r17 = r110;
        goto L18
    L69:
        String r117 = r3;
        HashMap r0 = new HashMap();     // Catch: Throwable -> L77
        Iterator r27 = r15.keySet().iterator();     // Catch: Throwable -> L77
    L71:
        if (r27.hasNext() == false) goto L74;
        UploadLogInfo r28 = (UploadLogInfo) ZeusTransformUtils.preCheckCast(r27.next(), UploadLogInfo.class, r117);     // Catch: Throwable -> L77
        r0.put(r28, r28.serialize((HashMap) ZeusTransformUtils.preCheckCast(r15.get(r28), HashMap.class, r117)));     // Catch: Throwable -> L77
        goto L71
    L74:
        if (a.c() == null) goto L76;
        a.c().b(Constants.TAG, "seqNoList:" + r16.toString());     // Catch: Throwable -> L77
    L76:
        return r0;
    L15:
        r13 = 0;
    L77:
        th = move-exception;
        Logger.e(Constants.TAG, "LogSender serialize failed.", th);
        return null;
    }
}
