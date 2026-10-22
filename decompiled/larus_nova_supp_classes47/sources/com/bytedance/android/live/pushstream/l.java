package com.bytedance.android.live.pushstream;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l<T, R> implements Function {
    public static final l a = null;

    static {
        a = new l();
    }

    public l() {
    }

    public final Object apply(Object r2) {
        String r3 = (String) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return new PolarisFileWrapper(r3);
    }
}
