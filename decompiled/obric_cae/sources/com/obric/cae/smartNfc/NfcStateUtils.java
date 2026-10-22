package com.obric.cae.smartNfc;

import android.aimedia.a;

/* JADX INFO: loaded from: classes2.dex */
public final class NfcStateUtils {
    private NfcStateUtils() {
    }

    public static String adapterStateToString(int r8) {
        if (r8 != 1) goto L5;
        return "STATE_OFF";
    L5:
        if (r8 != 2) goto L7;
        return "STATE_TURNING_ON";
    L7:
        if (r8 != 3) goto L9;
        return "STATE_ON";
    L9:
        if (r8 != 4) goto L11;
        return "STATE_TURNING_OFF";
    L11:
        return a.c("STATE_UNKNOWN(", r8, ")");
    }
}
