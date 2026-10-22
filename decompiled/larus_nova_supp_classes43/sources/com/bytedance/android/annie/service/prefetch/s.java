package com.bytedance.android.annie.service.prefetch;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class s<T, R> implements Function {
    public final /* synthetic */ n a;

    public s(r r1, n r10) {
        this.a = r10;
    }

    public final Object apply(Object r10) {
        String r11 = (String) r10;
        Intrinsics.checkNotNullParameter(r11, "node");
        return new r.a(this.a, r11);
    }
}
