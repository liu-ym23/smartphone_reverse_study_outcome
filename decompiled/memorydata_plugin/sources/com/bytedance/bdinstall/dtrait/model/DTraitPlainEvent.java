package com.bytedance.bdinstall.dtrait.model;

import com.bytedance.bdinstall.dtrait.DTLog;
import com.bytedance.bdinstall.dtrait.config.DTraitConfig;
import com.bytedance.bdinstall.dtrait.constant.DTraitConstant;
import com.bytedance.bdinstall.dtrait.interfaces.IDTraitInitConfig;
import com.bytedance.bdinstall.dtrait.utils.DTraitTraceUtil;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DTraitPlainEvent {
    private static String businessPath = "";
    private static long duration = -2147483648L;
    private static String error = null;
    private static boolean plainResult = false;

    static {
    }

    public DTraitPlainEvent() {
    }

    private static void clear() {
        plainResult = false;
        businessPath = "";
        duration = -2147483648L;
        error = "";
    }

    public static String getBusinessPath() {
        return businessPath;
    }

    public static long getDuration() {
        return duration;
    }

    public static boolean getPlainResult() {
        return plainResult;
    }

    public static void onEvent() {
        if (DTLog.debug() == false) goto L5;
        DTLog.d("[dt] [onEvent] dtrait_plaintext: " + toJSON());
    L5:
        IDTraitInitConfig r0 = DTraitConfig.getDtraitInterface();
        if (r0 != null) goto L8;
        return;
    L8:
        r0.onEvent(DTraitConstant.EVENT_DTRAIT_PLAINTEXT, toJSON());
        clear();
    }

    public static void setBusinessPath(String r0) {
        businessPath = r0;
    }

    public static void setDuration(long r0) {
        duration = r0;
    }

    public static void setError(String r0) {
        error = r0;
    }

    public static void setPlainResult(boolean r0) {
        plainResult = r0;
    }

    private static JSONObject toJSON() {
        JSONObject r0 = new JSONObject();
        r0.putOpt("result", Boolean.valueOf(getPlainResult()));     // Catch: Exception -> L5
        r0.putOpt("duration", Long.valueOf(getDuration() + DTraitTraceUtil.getElapsedTime(DTraitConstant.METHOD_COLLECT_DTRAIT_MAP)));     // Catch: Exception -> L5
        r0.putOpt("path", getBusinessPath());     // Catch: Exception -> L5
        r0.putOpt("params_for_special", "uc_login");     // Catch: Exception -> L5
        r0.putOpt("error", error);     // Catch: Exception -> L5
    L4:
        return r0;
    }
}
