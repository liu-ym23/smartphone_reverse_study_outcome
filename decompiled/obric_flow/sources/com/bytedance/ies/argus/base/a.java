package com.bytedance.ies.argus.base;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.internal.c;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f5012b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f5013a;

    static {
        f5012b = LazyKt.lazy(ArgusEnv$Companion$instance$2.f4998a);
    }

    public a() {
        LazyKt.lazy(new ArgusEnv$ttmParam$2(this));
        this.f5013a = h0.a(Dispatchers.getIO());
    }
}
