package com.bytedance.android.livesdk.interactivity.chatchannel.manager;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k<T, R> implements Function {
    public final /* synthetic */ AtomicInteger a;

    public k(AtomicInteger r1) {
        this.a = r1;
    }

    public final Object apply(Object r2) {
        Observable r3 = (Observable) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return r3.flatMap(new j(this));
    }
}
