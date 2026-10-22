package com.bytedance.android.anniex.scene.handler.idle;

import java.util.ArrayList;
import java.util.function.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g<T, R> implements Function {
    public static final g<T, R> a = null;

    static {
        a = new g();
    }

    public g() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object r10) {
        Intrinsics.checkNotNullParameter((TaskType) r10, "it");
        return new ArrayList();
    }
}
