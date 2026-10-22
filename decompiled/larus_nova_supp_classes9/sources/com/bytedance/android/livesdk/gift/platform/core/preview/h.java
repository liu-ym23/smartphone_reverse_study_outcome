package com.bytedance.android.livesdk.gift.platform.core.preview;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ RequestTimer a;
    public final /* synthetic */ Function4 b;

    public h(RequestTimer r1, Function4 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r5) {
        Long r6 = (Long) r5;
        Function4 r7 = this.b;
        RequestTimer r0 = this.a;
        r7.invoke(r0.c, r0.d, Integer.valueOf(r0.e), this.a.f);
        RequestTimer r8 = this.a;
        Disposable r1 = r8.a;
        if (r1 == null) goto L5;
        r1.dispose();
    L5:
        r8.a = null;
    }
}
