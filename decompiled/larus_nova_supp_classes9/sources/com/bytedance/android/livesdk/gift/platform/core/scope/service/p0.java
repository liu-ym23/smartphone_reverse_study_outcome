package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p0<T> implements SingleOnSubscribe {
    public final /* synthetic */ m0 a;
    public final /* synthetic */ long b;
    public final /* synthetic */ ArrayList c;

    public p0(m0 r1, long r2, ArrayList r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    public final void subscribe(SingleEmitter<Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        m0.a(this.a, this.b, null, this.c);
    }
}
