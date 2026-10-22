package com.bytedance.android.ec.core.imagex.opt;

import com.bytedance.android.ec.core.opt.ab.ColdLaunchExpFilter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class n0 implements ReadOnlyProperty<Object, com.bytedance.android.ec.core.imagex.common.p<com.bytedance.android.ec.core.imagex.common.z>> {
    public static final /* synthetic */ KProperty[] b = null;
    public boolean a;

    static {
        b = new KProperty[]{Reflection.property1(new PropertyReference1Impl(n0.class, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "getValue()Lcom/google/gson/internal/LinkedTreeMap;", 0))};
    }

    public final Object getValue(Object r10, KProperty r11) {
        Intrinsics.checkNotNullParameter(r10, "thisRef");
        Intrinsics.checkNotNullParameter(r11, "property");
        if (this.a == false) goto L6;
        ColdLaunchExpFilter.e.b(null);
        throw null;
    L6:
        KProperty r12 = b[0];
        throw null;
    }
}
