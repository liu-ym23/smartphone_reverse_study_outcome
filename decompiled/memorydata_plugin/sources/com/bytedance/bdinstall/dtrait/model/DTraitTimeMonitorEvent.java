package com.bytedance.bdinstall.dtrait.model;

import com.bytedance.bdinstall.dtrait.DTLog;
import com.bytedance.bdinstall.dtrait.config.DTraitConfig;
import com.bytedance.bdinstall.dtrait.constant.DTraitConstant;
import com.bytedance.bdinstall.dtrait.interfaces.IDTraitInitConfig;
import com.bytedance.bdinstall.dtrait.utils.DTraitTraceUtil;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DTraitTimeMonitorEvent {
    private static long deviceIDCallbackFinish = -1;
    private static long deviceIDCallbackStart = -1;
    private static long deviceRegisterFinish = -1;
    private static long deviceRegisterStart = -1;
    private static long preHandleDTraitFinish = -1;
    private static long preHandleDTraitStart = -1;
    private static long sdkInitFinish = -1;
    private static long sdkInitStart = -1;

    static {
    }

    public DTraitTimeMonitorEvent() {
    }

    private static void clear() {
        sdkInitStart = -1;
        sdkInitFinish = -1;
        preHandleDTraitStart = -1;
        preHandleDTraitFinish = -1;
        deviceRegisterStart = -1;
        deviceRegisterFinish = -1;
        deviceIDCallbackStart = -1;
        deviceIDCallbackFinish = -1;
    }

    public static void onEvent() {
        if (DTraitTraceUtil.reportBySimple(DTraitConfig.getDTraitCiphertextSamplingPercentage()) == true) goto L7;
        DTLog.d("[dt] dtrait_time 被抽样不上报");
        return;
    L7:
        if (DTLog.debug() == false) goto L9;
        DTLog.d("[dt] [onEvent] dtrait_time: " + toJSON());
    L9:
        IDTraitInitConfig r0 = DTraitConfig.getDtraitInterface();
        if (r0 != null) goto L12;
        return;
    L12:
        r0.onEvent(DTraitConstant.EVENT_DTRAIT_TIME, toJSON());
        clear();
    }

    public static void setDeviceIDCallbackFinish() {
        deviceIDCallbackFinish = System.currentTimeMillis();
    }

    public static void setDeviceIDCallbackStart() {
        deviceIDCallbackStart = System.currentTimeMillis();
    }

    public static void setDeviceRegisterFinish() {
        deviceRegisterFinish = System.currentTimeMillis();
    }

    public static void setDeviceRegisterStart() {
        deviceRegisterStart = System.currentTimeMillis();
    }

    public static void setPreHandleDTraitFinish() {
        preHandleDTraitFinish = System.currentTimeMillis();
    }

    public static void setPreHandleDTraitStart() {
        preHandleDTraitStart = System.currentTimeMillis();
    }

    public static void setSdkInitFinish() {
        sdkInitFinish = System.currentTimeMillis();
    }

    public static void setSdkInitStart() {
        sdkInitStart = System.currentTimeMillis();
    }

    private static JSONObject toJSON() {
        JSONObject r0 = new JSONObject();
        r0.putOpt("params_for_special", "uc_login");     // Catch: Exception -> L24
        long r1 = sdkInitFinish;     // Catch: Exception -> L24
        if (r1 <= 0) goto L8;
        long r5 = sdkInitStart;     // Catch: Exception -> L24
        if (r5 <= 0) goto L8;
        r0.putOpt("sdk_init_to_start_time", Long.valueOf(r1 - r5));     // Catch: Exception -> L24
    L8:
        long r2 = preHandleDTraitFinish;     // Catch: Exception -> L24
        if (r2 <= 0) goto L13;
        long r6 = preHandleDTraitStart;     // Catch: Exception -> L24
        if (r6 <= 0) goto L13;
        r0.putOpt("pre_handle_dtrait_time", Long.valueOf(r2 - r6));     // Catch: Exception -> L24
    L13:
        long r3 = deviceRegisterFinish;     // Catch: Exception -> L24
        if (r3 <= 0) goto L18;
        long r7 = deviceRegisterStart;     // Catch: Exception -> L24
        if (r7 <= 0) goto L18;
        r0.putOpt("device_register_time", Long.valueOf(r3 - r7));     // Catch: Exception -> L24
    L18:
        long r4 = deviceIDCallbackFinish;     // Catch: Exception -> L24
        if (r4 <= 0) goto L23;
        long r8 = deviceIDCallbackStart;     // Catch: Exception -> L24
        if (r8 <= 0) goto L23;
        r0.putOpt("device_id_callback_time", Long.valueOf(r4 - r8));     // Catch: Exception -> L24
    L23:
        return r0;
    }
}
