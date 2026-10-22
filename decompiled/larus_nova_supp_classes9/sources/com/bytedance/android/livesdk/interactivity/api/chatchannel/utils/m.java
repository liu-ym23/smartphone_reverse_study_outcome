package com.bytedance.android.livesdk.interactivity.api.chatchannel.utils;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m implements Action {
    public final /* synthetic */ Disposable a;
    public final /* synthetic */ Disposable b;

    public m(Disposable r1, Disposable r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void run() {
        this.a.dispose();
        Disposable r0 = this.b;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }
}
