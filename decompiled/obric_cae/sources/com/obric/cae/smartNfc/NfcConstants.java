package com.obric.cae.smartNfc;

/* JADX INFO: loaded from: classes2.dex */
public class NfcConstants {
    public static final String ACTION_POLLING_FRAME_LOG = "com.obric.cae.action.nfc.polling_frame_log";
    public static final String CAE_NFC_ACCESS_PERM = "com.obric.permission.NFC_CAE_ACCESS_PERMISSION";
    public static final int CAE_NFC_CLOUD_CONFIG_ENABLE_CMD = 1;
    public static final String EXTRA_POLLING_FRAME_LOG = "polling_frame_log";
    public static final String REVERSE_CHARGING_STATE = "Obric_reverse_charging_state";
    public static final int REVERSE_CHARGING_STATE_CHARGING = 2;
    public static final int REVERSE_CHARGING_STATE_IDLE = 0;
    public static final int REVERSE_CHARGING_STATE_PROTECTION = 3;
    public static final int REVERSE_CHARGING_STATE_WAITING = 1;

    private NfcConstants() {
    }

    public static boolean isReverseChargingBlockingState(int r8) {
        if (r8 != 2) goto L5;
    L8:
        return true;
    L5:
        if (r8 == 3) goto L8;
        return false;
    }
}
