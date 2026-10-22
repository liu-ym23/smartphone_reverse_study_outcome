package com.ss.android.lark.forwardv3.configuration;

import android.os.RemoteException;
import com.ss.android.lark.forwardv3.RemoteOnCloseForwardListener;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements oib.b {
    public final /* synthetic */ ForwardCommonConfig a;

    @Override // oib.b
    public final void onClose() {
        RemoteOnCloseForwardListener r0 = this.a.h;     // Catch: RemoteException -> L6
        if (r0 == null) goto L11;
        r0.onClose();     // Catch: RemoteException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        Log.e("ForwardCommonConfig", "onClose onCloseForwardListener: " + e, e);
    }

    public c(ForwardCommonConfig r1) {
        this.a = r1;
    }
}
