package com.miui.easygo.util;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.miui.easygo.callback.IEasyGoCallback;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class EasyGoUtil extends FunctionUtil {
    private static final String TAG = "EasyGoUtil";

    public EasyGoUtil() {
    }

    public static int getRomSupStatus(Context r0, String r1) {
        if (DatabaseUtil.isDbSupport(r0) == true) goto L7;
        return 505;
    L7:
        if (FunctionUtil.isLibSupprt(r1) == true) goto L10;
        return 504;
    L10:
        return 0;
    }

    public static void callbackMsg(IEasyGoCallback r0, int r1, Bundle r2) {
        if (r0 == null) goto L8;
        r0.callback(r1, r2);     // Catch: RemoteException -> L5
        return;
    L9:
        return;
    }
}
