package com.bytedance.android.ec.core.utils;

import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h1 implements Function {
    public final /* synthetic */ Function1 a;

    public h1(Function1 r1) {
        this.a = r1;
    }

    public final /* synthetic */ Object apply(Object r10) {
        return this.a.invoke(r10);
    }
}
