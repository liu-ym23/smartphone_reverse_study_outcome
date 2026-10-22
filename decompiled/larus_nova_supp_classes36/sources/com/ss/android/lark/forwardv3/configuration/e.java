package com.ss.android.lark.forwardv3.configuration;

import android.os.RemoteException;
import com.ss.android.lark.forwardv3.RemoteOnCancelMultiSelectListener;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements oib.a {
    public final /* synthetic */ ForwardSelectConfig a;

    @Override // oib.a
    public final void cancel() {
        RemoteOnCancelMultiSelectListener r0 = this.a.e;     // Catch: RemoteException -> L6
        if (r0 == null) goto L11;
        r0.cancel();     // Catch: RemoteException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        Log.e("ForwardSelectConfig", "cancel cancelMultiSelectListener error: " + e, e);
    }

    public e(ForwardSelectConfig r1) {
        this.a = r1;
    }
}
