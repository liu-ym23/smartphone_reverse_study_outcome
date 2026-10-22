package com.obric.matrix.platform.sdk.ones.account;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"PrivateApi"})
public final class AppGlobals {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppGlobals f5799a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f5800b = null;

    static {
        f5799a = new AppGlobals();
        f5800b = LazyKt.lazy(AppGlobals$app$2.INSTANCE);
    }

    private AppGlobals() {
    }

    private final Application a() {
        return (Application) f5800b.getValue();
    }

    public final Application b() {
        return a();
    }

    public final Context c() {
        Context r10 = b().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r10, "getApplication().applicationContext");
        return r10;
    }
}
