package com.larus.account.saas.ui.internal;

import c48.a;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class DimensExtKt {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;

    static {
        a = LazyKt.lazy(DimensExtKt$dp_20$2.INSTANCE);
        b = LazyKt.lazy(DimensExtKt$dp_24$2.INSTANCE);
        c = LazyKt.lazy(DimensExtKt$dp_48$2.INSTANCE);
        d = LazyKt.lazy(DimensExtKt$dp_294$2.INSTANCE);
    }

    public static final int a(int r1) {
        a.a().a();
        return com.larus.init.task.accountsdk.a.a.getApplication().getResources().getDimensionPixelSize(r1);
    }
}
