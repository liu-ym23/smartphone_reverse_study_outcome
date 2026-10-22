package com.bytedance.android.livesdk.jsbridge.methods;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h1 implements km3.g.a {
    public final /* synthetic */ d1 a;

    public h1(d1 r1) {
        this.a = r1;
    }

    public final void onClose() {
        d1 r0 = this.a;
        Disposable r1 = r0.d;
        if (r1 == null) goto L6;
        CompositeDisposable r2 = r0.c;
        Intrinsics.checkNotNull(r1);
        r2.remove(r1);
        r0.d = null;
        return;
    }
}
