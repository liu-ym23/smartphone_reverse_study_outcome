package com.bytedance.android.live.profit.livepet.container;

import android.view.ViewGroup;
import io.reactivex.functions.Function;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h<T, R> implements Function {
    public final /* synthetic */ ViewGroup a;

    public h(ViewGroup r1) {
        this.a = r1;
    }

    public final Object apply(Object r2) {
        Intrinsics.checkNotNullParameter((Unit) r2, "it");
        return TuplesKt.to(Integer.valueOf(this.a.getWidth()), Integer.valueOf(this.a.getHeight()));
    }
}
