package com.bytedance.android.livesdk.followtool.utils;

import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b<T, R> implements Function {
    public final /* synthetic */ Function1 a;

    public b(Function1 r1) {
        this.a = r1;
    }

    public final Object apply(Object r3) {
        Boolean r4 = (Boolean) r3;
        Intrinsics.checkNotNullParameter(r4, "allow");
        return a.d().h((com.bytedance.android.livesdk.user.b) this.a.invoke(r4));
    }
}
