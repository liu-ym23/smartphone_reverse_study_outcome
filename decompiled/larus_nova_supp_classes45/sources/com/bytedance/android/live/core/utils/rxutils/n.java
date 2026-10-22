package com.bytedance.android.live.core.utils.rxutils;

import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n implements Function {
    public final /* synthetic */ Function1 a;

    public n(Function1 r1) {
        this.a = r1;
    }

    public final /* synthetic */ Object apply(Object r2) {
        return this.a.invoke(r2);
    }
}
