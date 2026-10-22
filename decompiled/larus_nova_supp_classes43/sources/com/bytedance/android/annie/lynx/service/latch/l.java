package com.bytedance.android.annie.lynx.service.latch;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l<T, R> implements Function {
    public final /* synthetic */ com.bytedance.android.annie.service.prefetch.n a;

    public l(k r1, com.bytedance.android.annie.service.prefetch.n r10) {
        this.a = r10;
    }

    public final Object apply(Object r10) {
        String r11 = (String) r10;
        Intrinsics.checkNotNullParameter(r11, "node");
        return new k.a(this.a, r11);
    }
}
