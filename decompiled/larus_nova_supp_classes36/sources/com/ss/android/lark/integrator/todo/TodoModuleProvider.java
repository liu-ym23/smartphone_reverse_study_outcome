package com.ss.android.lark.integrator.todo;

import e7c.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class TodoModuleProvider {
    public static final Lazy<jnb.a> a = null;

    public static final class a {
    }

    static {
        a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, TodoModuleProvider$Companion$instance$2.INSTANCE);
    }

    @JvmStatic
    public static final c a() {
        return (c) a.getValue();
    }
}
