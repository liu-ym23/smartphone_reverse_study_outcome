package com.bytedance.android.live.core.utils.rxutils;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class t extends w<Object> {
    public final /* synthetic */ Function1 a;

    public t(Function1 r1) {
        this.a = r1;
    }

    public final void onNext(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "t");
        this.a.invoke(r2);
    }
}
