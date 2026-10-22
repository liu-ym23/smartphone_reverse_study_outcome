package com.obric.aikernel.api;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public final class DefaultFeatureProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DefaultFeatureProvider f4428a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f4429b = null;

    static {
        f4428a = new DefaultFeatureProvider();
        f4429b = LazyKt.lazy(DefaultFeatureProvider$defaultProvider$2.INSTANCE);
    }

    private DefaultFeatureProvider() {
    }

    public final Function1<Class<?>, d> a() {
        return (Function1) f4429b.getValue();
    }
}
