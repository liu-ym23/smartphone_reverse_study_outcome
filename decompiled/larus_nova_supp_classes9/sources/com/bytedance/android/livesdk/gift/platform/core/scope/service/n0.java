package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n0<T> implements SingleOnSubscribe {
    public final /* synthetic */ m0 a;
    public final /* synthetic */ long b;
    public final /* synthetic */ Ref.ObjectRef c;

    public n0(m0 r1, long r2, Ref.ObjectRef r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    public final void subscribe(SingleEmitter<Boolean> r6) {
        Intrinsics.checkNotNullParameter(r6, "it");
        m0.a(this.a, this.b, (sz1.a) this.c.element, null);
        r6.onSuccess(Boolean.TRUE);
    }
}
