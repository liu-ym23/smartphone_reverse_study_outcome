package com.ss.android.lark.forwardv3.configuration;

import android.os.RemoteException;
import com.ss.android.lark.forwardv3.RemoteOnForwardTargetCustomDisableListener;
import com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements oib.e {
    public final /* synthetic */ ForwardTargetConfig a;

    @Override // oib.e
    public final String customDisableToastText() {
        RemoteOnForwardTargetCustomDisableListener r1 = this.a.g;     // Catch: RemoteException -> L10
        if (r1 == null) goto L15;
        String r2 = r1.customDisableToastText();     // Catch: RemoteException -> L10
        if (r2 != null) goto L9;
        return "";
    L9:
        return r2;
    L15:
        return "";
    L10:
        e = move-exception;
        Log.e("ForwardTargetConfig", "customDisableToastText customDisableListener error: " + e, e);
        return "";
    }

    public f(ForwardTargetConfig r1) {
        this.a = r1;
    }

    @Override // oib.e
    public final boolean customDisable(ForwardTargetBaseInfoNew r4) {
        RemoteOnForwardTargetCustomDisableListener r1 = this.a.g;     // Catch: RemoteException -> L7
        if (r1 == null) goto L12;
        return r1.customDisable(r4);
    L12:
        return false;
    L7:
        e = move-exception;
        Log.e("ForwardTargetConfig", "customDisable customDisableListener error: " + e, e);
        return false;
    }
}
