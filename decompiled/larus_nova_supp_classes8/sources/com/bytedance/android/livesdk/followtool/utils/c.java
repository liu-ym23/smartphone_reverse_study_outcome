package com.bytedance.android.livesdk.followtool.utils;

import com.bytedance.android.livesdk.user.m;
import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c<T, R> implements Function {
    public final /* synthetic */ Function1 a;

    public c(Function1 r1) {
        this.a = r1;
    }

    public final Object apply(Object r3) {
        Boolean r4 = (Boolean) r3;
        Intrinsics.checkNotNullParameter(r4, "allow");
        return a.d().i((m) this.a.invoke(r4));
    }
}
