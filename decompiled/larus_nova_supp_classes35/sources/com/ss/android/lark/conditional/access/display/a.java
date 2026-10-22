package com.ss.android.lark.conditional.access.display;

import com.bytedance.lark.pb.security.v1.CustomDisplayModelResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a<T, R> implements Function {
    public static final a<T, R> a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public final Object apply(Object r2) {
        CustomDisplayModelResponse r3 = (CustomDisplayModelResponse) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return r3.config;
    }
}
