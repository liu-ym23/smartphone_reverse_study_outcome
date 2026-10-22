package com.bytedance.android.anniex.base.depend;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f3112a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f3113b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f3114c = null;

    static {
        f3112a = LazyKt.lazy(AnnieXRuntime$hostDepend$2.f3111a);
        f3113b = LazyKt.lazy(AnnieXRuntime$applicationDepend$2.f3109a);
        f3114c = LazyKt.lazy(AnnieXRuntime$deviceDepend$2.f3110a);
    }
}
