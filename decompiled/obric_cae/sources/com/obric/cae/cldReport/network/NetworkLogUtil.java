package com.obric.cae.cldReport.network;

/* JADX INFO: loaded from: classes.dex */
public class NetworkLogUtil {
    public NetworkLogUtil() {
    }

    public static int getHandoverReason(int r8) {
        if (r8 != 1) goto L5;
        return 3;
    L5:
        if (r8 == 2) goto L10;
        if (r8 == 3) goto L9;
        return 0;
    L9:
        return 2;
    L10:
        return 1;
    }
}
