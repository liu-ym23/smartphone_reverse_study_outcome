package com.bytedance.android.ec.core.opt.ab;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i implements ReadOnlyProperty<Object, Object> {
    public static final /* synthetic */ KProperty[] g = null;
    public final LazyOptHostSettings a;
    public Object b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Function0 e;
    public final /* synthetic */ Function2 f;

    static {
        g = new KProperty[]{Reflection.property1(new PropertyReference1Impl(i.class, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "getValue()Ljava/lang/Object;", 0))};
    }

    public final Object getValue(Object r10, KProperty<?> r11) {
        Intrinsics.checkNotNullParameter(r10, "thisRef");
        Intrinsics.checkNotNullParameter(r11, "property");
        if (this.b != null) goto L5;
        LazyOptHostSettings r12 = this.a;
        KProperty<?>[] r0 = g;
        if (r12.getValue(this, r0[0]) == this.d) goto L15;
        this.b = this.a.getValue(this, r0[0]);
        if (ColdLaunchExpFilter.e.b(this.c) == true) goto L15;
        return this.b;
    L15:
        return null;
    L5:
        if (ColdLaunchExpFilter.e.b(this.c) == false) goto L8;
        return null;
    L8:
        return this.b;
    }

    public i(String r1, Object r10, com.bytedance.android.ec.core.imagex.opt.w.b r11, Function0 r12, Function2 r13) {
        this.c = r1;
        this.d = r10;
        this.e = r12;
        this.f = r13;
        this.a = h.a(r1, r10, r11, r12, r13);
    }
}
