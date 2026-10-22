package com.bytedance.apm6.consumer.slardar.send;

import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.consumer.slardar.header.HeaderInfo;
import com.bytedance.apm6.consumer.slardar.header.HeaderManager;
import com.bytedance.apm6.consumer.slardar.persistent.LogFile;
import com.bytedance.apm6.consumer.slardar.persistent.LogItem;
import com.bytedance.apm6.consumer.slardar.send.downgrade.DowngradeController;
import com.bytedance.apm6.consumer.slardar.send.downgrade.DowngradeDataStorage;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.log.Logger;
import e0.a;
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
        UploadLogInfo.ExceptionLogInfo r10 = new UploadLogInfo.ExceptionLogInfo();
        exceptionLogInfo = r10;
        UploadLogInfo.TraceLogInfo r11 = new UploadLogInfo.TraceLogInfo();
        traceLogInfo = r11;
        UploadLogInfo.MonitorLogInfo r12 = new UploadLogInfo.MonitorLogInfo();
        monitorLogInfo = r12;
        ArrayList r13 = new ArrayList();
        uploadTypes = r13;
        r13.add(r10);
        r13.add(r11);
        r13.add(r12);
    }

    UploadLogManager() {
    }

    private static void debugPrint(Map<Long, List<LogItem>> r10) {
        if (ApmBaseContext.isDebugMode() == false) goto L12;
        Logger.d(Constants.TAG, "sendLog: input sendList merged into " + r10.size() + " group(s)");
        Iterator<Long> r11 = r10.keySet().iterator();
        int r12 = 0;
    L6:
        if (r11.hasNext() == false) goto L15;
        Long r13 = r11.next();
        List<LogItem> r14 = r10.get(r13);
        Logger.d(Constants.TAG, "----------------");
        HeaderInfo r15 = HeaderManager.getInstance().getHeaderInfo(String.valueOf(r13));
        String r16 = Constants.TAG;
        StringBuilder r17 = new StringBuilder();
        r17.append("group ");
        int r18 = r12 + 1;
        r17.append(r12);
        r17.append(" header:");
        r17.append(r15);
        Logger.d(r16, r17.toString());
        int r19 = 0;
    L9:
        if (r19 >= r14.size()) goto L11;
        Logger.d(Constants.TAG, "  log[" + r19 + "]=" + r14.get(r19).toString());
        r19 = r19 + 1;
        goto L9
    L11:
        Logger.d(Constants.TAG, "----------------");
        r12 = r18;
        goto L6
    L15:
        return;
    }

    private static UploadLogInfo getUploadLogInfo(JSONObject r10) {
        String r11 = r10.optString("log_type");
        if (Constants.EXCEPTION_TYPE.contains(r11) == false) goto L7;
        return exceptionLogInfo;
    L7:
        if (uploadTypeListInTraceType.contains(r11) == false) goto L11;
        return traceLogInfo;
    L11:
        return monitorLogInfo;
    }

    public static List<UploadLogInfo> getUploadType() {
        return uploadTypes;
    }

    public static Map<UploadLogInfo, byte[]> serialize(List<LogFile> r22, int r23) {
        String r10 = KEY_SELF_DEBUG_MESSAGE;
        HashMap r11 = new HashMap();     // Catch: Throwable -> L78
        long r12 = r22.size();     // Catch: Throwable -> L78
        Iterator<LogFile> r13 = r22.iterator();     // Catch: Throwable -> L78
        long r14 = 0;
        long r15 = 0;
    L5:
        if (r13.hasNext() == false) goto L10;
        LogFile r16 = r13.next();     // Catch: Throwable -> L78
        long r17 = r16.getStartID();     // Catch: Throwable -> L78
        List r18 = (List) r11.get(Long.valueOf(r17));     // Catch: Throwable -> L78
        if (r18 != null) goto L9;
        r18 = new ArrayList();     // Catch: Throwable -> L78
        r11.put(Long.valueOf(r17), r18);     // Catch: Throwable -> L78
    L9:
        r14 = r14 + ((long) r16.getTotalBytes());     // Catch: Throwable -> L78
        r15 = r15 + ((long) r16.getTotalCount());     // Catch: Throwable -> L78
        r18.addAll(r16.getLogList());     // Catch: Throwable -> L78
        goto L5
    L10:
        debugPrint(r11);     // Catch: Throwable -> L78
        File r19 = DiskFileHelper.getInstance().getDirectory();     // Catch: Throwable -> L78
        if (r19 == null) goto L15;
        String[] r20 = r19.list();     // Catch: Throwable -> L78
        if (r20 == null) goto L15;
        int r21 = r20.length;     // Catch: Throwable -> L78
    L16:
        HashMap r110 = new HashMap();     // Catch: Throwable -> L78
        ArrayList r111 = new ArrayList();     // Catch: Throwable -> L78
        Iterator r112 = r11.keySet().iterator();     // Catch: Throwable -> L78
    L18:
        if (r112.hasNext() == false) goto L70;
        Long r113 = (Long) r112.next();     // Catch: Throwable -> L78
        List r114 = (List) r11.get(r113);     // Catch: Throwable -> L78
        if (r114 == null) goto L18;
        HashMap r115 = r11;
        int r116 = 0;
    L24:
        if (r116 >= r114.size()) goto L69;
        Iterator r117 = r112;
        List r118 = r114;
        JSONObject r119 = new JSONObject(new String(((LogItem) r114.get(r116)).getData()));     // Catch: Exception -> L84 Throwable -> L78
        if (DowngradeController.getInstance().uploadEnabled(r119, ApmContext.getAid()) == false) goto L33;
        UploadLogInfo r24 = getUploadLogInfo(r119);     // Catch: Throwable -> L78
        if ((r24 instanceof UploadLogInfo.MonitorLogInfo) == true) goto L95;
        r10 = r10;
        r116 = r116;
        r110 = r110;
    L60:
        Map r120 = (Map) r110.get(r24);     // Catch: Throwable -> L78
        if (r120 != null) goto L64;
        r120 = new HashMap();     // Catch: Throwable -> L78
        r110.put(r24, r120);     // Catch: Throwable -> L78
    L64:
        if (r120.containsKey(r113) == true) goto L66;
        r120.put(r113, new JSONArray());     // Catch: Throwable -> L78
    L66:
        ((JSONArray) r120.get(r113)).put(r119);     // Catch: Throwable -> L78
        goto L68
    L95:
        JSONObject r121 = r119.optJSONObject(r10);     // Catch: Exception -> L52 Throwable -> L78
        if (r121 != null) goto L42;
        r121 = new JSONObject();     // Catch: Exception -> L52 Throwable -> L78
        r119.put(r10, r121);     // Catch: Exception -> L52 Throwable -> L78
    L42:
        r10 = r10;
        r116 = r116;
        r121.put(KEY_DEBUG_SEQ_NUM, seqNum.getAndIncrement());     // Catch: Exception -> L51 Throwable -> L78
        HashMap r25 = r110;
        r121.put(KEY_DEBUG_SID, ApmContext.getStartId());     // Catch: Exception -> L82 Throwable -> L78
        r121.put(KEY_DEBUG_TOTAL_BYTES, r14);     // Catch: Exception -> L82 Throwable -> L78
        r121.put(KEY_DEBUG_TOTAL_COUNT, r15);     // Catch: Exception -> L82 Throwable -> L78
        r121.put(KEY_DEBUG_MERGE_COUNT, r12);     // Catch: Exception -> L82 Throwable -> L78
        r121.put(KEY_DEBUG_SECOND_LEFT_COUNT, r21);     // Catch: Exception -> L82 Throwable -> L78
        r121.put(KEY_DEBUG_LEFT_COUNT, r23);     // Catch: Exception -> L81 Throwable -> L78
    L56:
        if (r119.has(Constants.KEY_SEQ_NO) == false) goto L58;
        r111.add(String.valueOf(r119.get(Constants.KEY_SEQ_NO)));     // Catch: Throwable -> L78
    L58:
        r110 = r25;
    L51:
        r25 = r110;
    L53:
        r116 = r116;
        r25 = r110;
    L52:
        r10 = r10;
        goto L53
    L33:
        if (ApmBaseContext.isDebugMode() == false) goto L68;
        Logger.d(DowngradeDataStorage.TAG, r119.toString());     // Catch: Throwable -> L78
    L68:
        r110 = r110;
        r116 = r116 + 1;     // Catch: Throwable -> L78
        r112 = r117;
        r114 = r118;
        r10 = r10;
    L67:
        r118 = r114;
        goto L68
    L69:
        r11 = r115;
        goto L18
    L70:
        HashMap r26 = r110;
        HashMap r27 = new HashMap();     // Catch: Throwable -> L78
        Iterator r28 = r26.keySet().iterator();     // Catch: Throwable -> L78
    L72:
        if (r28.hasNext() == false) goto L75;
        UploadLogInfo r29 = (UploadLogInfo) r28.next();     // Catch: Throwable -> L78
        r27.put(r29, r29.serialize((HashMap) r26.get(r29)));     // Catch: Throwable -> L78
        goto L72
    L75:
        if (a.c() == null) goto L77;
        a.c().d(Constants.TAG, "seqNoList:" + r111.toString());     // Catch: Throwable -> L78
    L77:
        return r27;
    L15:
        r21 = 0;
    L78:
        th = move-exception;
        Logger.e(Constants.TAG, "LogSender serialize failed.", th);
        return null;
    }
}
