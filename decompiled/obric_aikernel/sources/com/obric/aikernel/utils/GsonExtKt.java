package com.obric.aikernel.utils;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes2.dex */
public final class GsonExtKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Lazy f5579a = null;

    static {
        f5579a = LazyKt.lazy(GsonExtKt$GSON$2.INSTANCE);
    }

    public static final com.google.gson.d a() {
        return (com.google.gson.d) f5579a.getValue();
    }
}
