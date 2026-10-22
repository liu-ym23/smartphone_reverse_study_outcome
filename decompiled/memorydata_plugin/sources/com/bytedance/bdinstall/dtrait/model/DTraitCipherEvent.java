package com.bytedance.bdinstall.dtrait.model;

import com.bytedance.bdinstall.dtrait.DTLog;
import com.bytedance.bdinstall.dtrait.config.DTraitConfig;
import com.bytedance.bdinstall.dtrait.constant.DTraitConstant;
import com.bytedance.bdinstall.dtrait.interfaces.IDTraitInitConfig;
import com.bytedance.bdinstall.dtrait.utils.DTraitTraceUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DTraitCipherEvent {
    private static final long REPORT_INTERVAL = 900000;
    private static volatile String businessPath = "";
    private static volatile String dT = "";
    private static volatile long duration = -2147483648L;
    private static volatile boolean encryptResult = false;
    private static volatile int expectedTime = Integer.MIN_VALUE;
    private static volatile int riskType = -1;
    private static volatile boolean useCache = false;

    static {
    }

    public DTraitCipherEvent() {
    }

    private static void clear() {
        encryptResult = false;
        businessPath = "";
        riskType = -1;
        dT = "";
        useCache = false;
        expectedTime = Integer.MIN_VALUE;
        duration = -2147483648L;
    }

    public static String getBusinessPath() {
        return businessPath;
    }

    public static long getDuration() {
        return duration;
    }

    public static boolean getEncryptResult() {
        return encryptResult;
    }

    public static int getExpectedTime() {
        return expectedTime;
    }

    public static int getRiskType() {
        return riskType;
    }

    public static String getdT() {
        return dT;
    }

    public static boolean isUseCache() {
        return useCache;
    }

    public static void onEvent() {
        List<String> r0 = DTraitConfig.getDtraitEventWhiteList();
        int r1 = DTraitConfig.getDTraitCiphertextSamplingPercentage();
        if (r0 == null) goto L36;
        if (r0.isEmpty() == true) goto L36;
        Iterator<String> r3 = r0.iterator();
    L8:
        boolean r6 = false;
        if (r3.hasNext() == false) goto L13;
        if (businessPath.contains((String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin")) == false) goto L8;
        boolean r2 = DTraitTraceUtil.reportBySimple(r1);
    L14:
        Iterator<String> r4 = r0.iterator();
    L16:
        if (r4.hasNext() == false) goto L20;
        if (businessPath.contains((String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin")) == false) goto L16;
        r6 = true;
    L20:
        if (r2 == true) goto L23;
        if (r6 == true) goto L23;
        r2 = true;
    L23:
        boolean r5 = DTLog.debug();
        if (r2 == true) goto L28;
        if (r5 == false) goto L47;
        DTLog.d("[dt] [onEvent] simple report, not report dtrait_ciphertext");
        return;
    L47:
        return;
    L28:
        if (r5 == false) goto L30;
        DTLog.d("[dt] [onEvent] report dtrait_ciphertext: " + toJSON());
    L30:
        IDTraitInitConfig r7 = DTraitConfig.getDtraitInterface();
        if (r7 != null) goto L33;
        return;
    L33:
        r7.onEvent(DTraitConstant.EVENT_DTRAIT_CIPHERTEXT, toJSON());
        clear();
        return;
    L13:
        r2 = false;
    L36:
        if (DTLog.debug() == false) goto L38;
        DTLog.d("[dt] [onEvent] dtrait_ciphertext: " + toJSON());
    L38:
        r7 = DTraitConfig.getDtraitInterface();
        if (r7 != null) goto L33;
    }

    public static void setBusinessPath(String r0) {
        businessPath = r0;
    }

    public static void setDuration(long r0) {
        duration = r0;
    }

    public static void setEncryptResult(boolean r0) {
        encryptResult = r0;
    }

    public static void setExpectedTime(int r0) {
        expectedTime = r0;
    }

    public static void setRiskType(int r0) {
        riskType = r0;
    }

    public static void setUseCache(boolean r0) {
        useCache = r0;
    }

    public static void setdT(String r0) {
        dT = r0;
    }

    private static JSONObject toJSON() {
        JSONObject r0 = new JSONObject();
        r0.putOpt("result", Boolean.valueOf(getEncryptResult()));     // Catch: Exception -> L5
        r0.putOpt("duration", Long.valueOf(getDuration()));     // Catch: Exception -> L5
        r0.putOpt("riskType", Integer.valueOf(getRiskType()));     // Catch: Exception -> L5
        r0.putOpt("path", getBusinessPath());     // Catch: Exception -> L5
        r0.putOpt("expectedTime", Integer.valueOf(getExpectedTime()));     // Catch: Exception -> L5
        r0.putOpt("useCache", Boolean.valueOf(isUseCache()));     // Catch: Exception -> L5
        r0.putOpt("dt", getdT());     // Catch: Exception -> L5
        r0.putOpt("params_for_special", "uc_login");     // Catch: Exception -> L5
    L4:
        return r0;
    }
}
