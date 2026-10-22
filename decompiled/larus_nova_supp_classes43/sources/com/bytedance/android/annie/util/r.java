package com.bytedance.android.annie.util;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class r<T, R> implements Function {
    public final /* synthetic */ Ref.IntRef a;

    public r(Ref.IntRef r1) {
        this.a = r1;
    }

    public final Object apply(Object r10) {
        Long r11 = (Long) r10;
        Intrinsics.checkNotNullParameter(r11, "it");
        return Integer.valueOf(this.a.element - ((int) r11.longValue()));
    }
}
