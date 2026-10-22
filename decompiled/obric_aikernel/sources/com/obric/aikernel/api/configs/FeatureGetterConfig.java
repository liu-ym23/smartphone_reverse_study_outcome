package com.obric.aikernel.api.configs;

import com.obric.aikernel.api.d;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public final class FeatureGetterConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FeatureGetterConfig f4440a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Function1<Class<?>, d> f4441b = null;

    static {
        f4440a = new FeatureGetterConfig();
        f4441b = FeatureGetterConfig$getter$1.INSTANCE;
    }

    private FeatureGetterConfig() {
    }

    public final Function1<Class<?>, d> a() {
        return f4441b;
    }
}
