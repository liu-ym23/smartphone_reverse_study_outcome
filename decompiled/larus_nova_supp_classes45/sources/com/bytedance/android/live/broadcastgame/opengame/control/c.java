package com.bytedance.android.live.broadcastgame.opengame.control;

import android.content.DialogInterface;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements DialogInterface.OnDismissListener {
    public final /* synthetic */ OpenPlatformControlService.e a;
    public final /* synthetic */ Function0 b;
    public final /* synthetic */ Function0 c;
    public final /* synthetic */ Function0 d;

    public c(OpenPlatformControlService.e r1, Function0 r2, Function0 r3, Function0 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r2) {
        OpenPlatformControlService r3 = this.a.c;
        int r0 = OpenPlatformControlService.j;
        r3.i();
        Disposable r4 = this.a.a;
        if (r4 == null) goto L6;
        r4.dispose();
        return;
    }
}
