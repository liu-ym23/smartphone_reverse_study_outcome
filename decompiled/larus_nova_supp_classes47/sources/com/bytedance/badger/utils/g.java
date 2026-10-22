package com.bytedance.badger.utils;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g {
    public static final /* synthetic */ KProperty[] b = null;
    public final Lazy a;

    static {
        b = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(g.class), "list", "getList()[Ljava/lang/String;"))};
    }

    public g() {
        this.a = LazyKt.lazy(a.a);
    }
}
