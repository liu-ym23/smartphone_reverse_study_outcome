package com.ss.android.lark.forwardv3.configuration;

import android.os.RemoteException;
import com.ss.android.lark.forwardv3.RemoteOnForwardNoteListener;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements oib.d {
    public final /* synthetic */ ForwardAdditionNoteConfig a;

    public b(ForwardAdditionNoteConfig r1) {
        this.a = r1;
    }

    @Override // oib.d
    public final void onFailed(String r2, String r3) {
        RemoteOnForwardNoteListener r0 = this.a.d;     // Catch: RemoteException -> L6
        if (r0 == null) goto L11;
        r0.onFailed(r2, r3);     // Catch: RemoteException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        Log.e("ForwardAdditionNoteConfig", "onFailed forwardNoteListener error, " + e, e);
    }

    @Override // oib.d
    public final void onSuccess(String r2, String r3, String r4) {
        RemoteOnForwardNoteListener r0 = this.a.d;     // Catch: RemoteException -> L6
        if (r0 == null) goto L11;
        r0.onSuccess(r2, r3, r4);     // Catch: RemoteException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        Log.e("ForwardAdditionNoteConfig", "onSuccess forwardNoteListener error, " + e, e);
    }
}
