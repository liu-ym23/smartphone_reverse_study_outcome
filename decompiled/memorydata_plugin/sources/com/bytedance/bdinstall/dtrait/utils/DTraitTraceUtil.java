package com.bytedance.bdinstall.dtrait.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdinstall.dtrait.DTLog;
import com.bytedance.bdinstall.dtrait.config.DTraitConfig;
import com.bytedance.bdinstall.dtrait.constant.DTraitConstant;
import com.bytedance.bdinstall.dtrait.interfaces.IDTraitInitConfig;
import com.bytedance.bdinstall.dtrait.model.DTraitLogEntry;
import com.bytedance.bdinstall.dtrait.model.DTraitLogLevel;
import com.bytedance.common.utility.Logger;
import com.bytedance.rpc.internal.RpcUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DTraitTraceUtil {
    private static final long LOGS_REPORT_INTERVAL = 600000;
    private static final Map<String, Long> endTimeMap = null;
    private static final Map<String, List<DTraitLogEntry>> logMap = null;
    private static final Random random = null;
    private static final SimpleDateFormat simpleDateFormat = null;
    private static final Map<String, Long> startTimeMap = null;

    /* JADX INFO: renamed from: com.bytedance.bdinstall.dtrait.utils.DTraitTraceUtil$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$bdinstall$dtrait$model$DTraitLogLevel = null;

        static {
            int[] r0 = new int[DTraitLogLevel.values().length];
            $SwitchMap$com$bytedance$bdinstall$dtrait$model$DTraitLogLevel = r0;
            r0[DTraitLogLevel.DEBUG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$bytedance$bdinstall$dtrait$model$DTraitLogLevel[DTraitLogLevel.WARN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$bytedance$bdinstall$dtrait$model$DTraitLogLevel[DTraitLogLevel.ERROR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static {
        startTimeMap = new ConcurrentHashMap();
        endTimeMap = new ConcurrentHashMap();
        logMap = new ConcurrentHashMap();
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        random = new SecureRandom();
    }

    public DTraitTraceUtil() {
    }

    private static void clear() {
        startTimeMap.clear();
        endTimeMap.clear();
        logMap.clear();
    }

    public static long getElapsedTime(String r5) {
        Map<String, Long> r0 = startTimeMap;
        if (r0.containsKey(r5) == false) goto L8;
        Map<String, Long> r1 = endTimeMap;
        if (r1.containsKey(r5) == true) goto L7;
        return 0;
    L7:
        return ((Long) ZeusTransformUtils.preCheckCast(r1.get(r5), Long.class, "com.obric.memorydata.plugin")).longValue() - ((Long) ZeusTransformUtils.preCheckCast(r0.get(r5), Long.class, "com.obric.memorydata.plugin")).longValue();
    L8:
        return 0;
    }

    private static String getStackTrace(Throwable r2) {
        StringWriter r0 = new StringWriter();
        r2.printStackTrace(new PrintWriter(r0));
        return r0.toString();
    }

    public static boolean isExpire(String r6, Context r7, long r8) {
        SharedPreferences r9 = Utils.getCommonSp((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin"));
        long r0 = r9.getLong(r6, 0);
        long r2 = System.currentTimeMillis();
        if ((r2 - r0) >= r8) goto L6;
        Logger.d(DTraitConstant.TAG_DTRAIT + r6 + "# it's time not yet, next time: " + simpleDateFormat.format(new Date(r0 + r8)));
        return false;
    L6:
        r9.edit().putLong(r6, r2).apply();
        return true;
    }

    public static void log(DTraitLogLevel r1, String r2, String r3, String r4) {
        log(r1, r2, r3, r4, null);
    }

    public static void log(DTraitLogLevel r6, String r7, String r8, String r9, Throwable r10) {
        if (r10 == null) goto L4;
        String r11 = getStackTrace(r10);
    L5:
        DTraitLogEntry r12 = new DTraitLogEntry(r6, r7, r8, r9, r11);
        Map<String, List<DTraitLogEntry>> r13 = logMap;
        List<DTraitLogEntry> r0 = (List) ZeusTransformUtils.preCheckCast(r13.get(r8), List.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L8;
        r0 = new ArrayList();
        r13.put(r8, r0);
    L8:
        r0.add(r12);
        if (DTLog.debug() == false) goto L21;
        int r14 = AnonymousClass1.$SwitchMap$com$bytedance$bdinstall$dtrait$model$DTraitLogLevel[r6.ordinal()];
        if (r14 != 1) goto L13;
        DTLog.d(DTraitConstant.TAG_DTRAIT + r8 + ", " + r9 + ", cost time: " + getElapsedTime(r8));
        return;
    L13:
        if (r14 != 2) goto L15;
        DTLog.w(DTraitConstant.TAG_DTRAIT + r8 + ", " + r9 + ", cost time: " + getElapsedTime(r8), null);
        return;
    L15:
        if (r14 != 3) goto L24;
        DTLog.e(DTraitConstant.TAG_DTRAIT + r8 + ", " + r9 + ", cost time: " + getElapsedTime(r8));
        return;
    L24:
        return;
    L21:
        return;
    L4:
        r11 = "";
        goto L5
    }

    public static boolean reportBySimple(int r2) {
        if (random.nextInt(100) >= r2) goto L5;
        return true;
    L5:
        return false;
    }

    public static void reportLogs(Context r13) {
        if (isExpire(DTraitConstant.KEY_DTRAIT_REPORT_TIME, (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.memorydata.plugin"), 600000) == true) goto L31;
        return;
    L31:
        IDTraitInitConfig r14 = DTraitConfig.getDtraitInterface();     // Catch: Throwable -> L25 Exception -> L30
        if (r14 != null) goto L9;
        clear();
        return;
    L9:
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L25 Exception -> L30
        Iterator<Map.Entry<String, List<DTraitLogEntry>>> r2 = logMap.entrySet().iterator();     // Catch: Throwable -> L25 Exception -> L30
    L11:
        if (r2.hasNext() == false) goto L21;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25 Exception -> L30
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25 Exception -> L30
        List r5 = (List) ZeusTransformUtils.preCheckCast(r3.getValue(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25 Exception -> L30
        long r6 = getElapsedTime(r4);     // Catch: Throwable -> L25 Exception -> L30
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L25 Exception -> L30
        JSONArray r8 = new JSONArray();     // Catch: Throwable -> L25 Exception -> L30
        Iterator r9 = r5.iterator();     // Catch: Throwable -> L25 Exception -> L30
    L14:
        if (r9.hasNext() == false) goto L17;
        DTraitLogEntry r10 = (DTraitLogEntry) ZeusTransformUtils.preCheckCast(r9.next(), DTraitLogEntry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25 Exception -> L30
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L25 Exception -> L30
        r11.put("businessTag", r10.getBusinessTag());     // Catch: Throwable -> L25 Exception -> L30
        r11.put("level", r10.getLevel().toString());     // Catch: Throwable -> L25 Exception -> L30
        r11.put(NotificationCompat.CATEGORY_MESSAGE, r10.getMsg());     // Catch: Throwable -> L25 Exception -> L30
        r11.put("error", r10.getError());     // Catch: Throwable -> L25 Exception -> L30
        r8.put(r11);     // Catch: Throwable -> L25 Exception -> L30
        goto L14
    L17:
        if (r6 >= 0) goto L20;
        r6 = -1;
    L20:
        r7.put("duration", r6);     // Catch: Throwable -> L25 Exception -> L30
        r7.put("logs", r8);     // Catch: Throwable -> L25 Exception -> L30
        r7.put("params_for_special", "uc_login");     // Catch: Throwable -> L25 Exception -> L30
        r0.put(r4, r7);     // Catch: Throwable -> L25 Exception -> L30
        goto L11
    L21:
        int r1 = r0.toString().getBytes(RpcUtils.CHARSET_UTF8).length;     // Catch: Throwable -> L25 Exception -> L30
        r14.onEvent(DTraitConstant.EVENT_DTRAIT_LOGS, r0);     // Catch: Throwable -> L25 Exception -> L30
        if (DTLog.debug() == false) goto L28;
        DTLog.d("[dt] total size " + r1 + ", \n" + r0);     // Catch: Throwable -> L25 Exception -> L30
    L25:
        th = move-exception;
        clear();
        throw th;
    L28:
        clear();
    }

    public static void start(String r3) {
        startTimeMap.put(r3, Long.valueOf(System.currentTimeMillis()));
    }

    public static void stop(String r3) {
        endTimeMap.put(r3, Long.valueOf(System.currentTimeMillis()));
    }
}
