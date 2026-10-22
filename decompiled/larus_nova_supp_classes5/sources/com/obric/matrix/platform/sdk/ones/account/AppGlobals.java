package com.obric.matrix.platform.sdk.ones.account;

import android.app.Application;
import android.content.Context;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class AppGlobals {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(AppGlobals$app$2.INSTANCE);
    }

    public static Context a() {
        return ((Application) a.getValue()).getApplicationContext();
    }
}
