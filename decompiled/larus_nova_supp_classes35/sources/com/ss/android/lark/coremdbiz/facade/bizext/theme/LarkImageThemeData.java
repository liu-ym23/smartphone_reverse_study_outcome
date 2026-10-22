package com.ss.android.lark.coremdbiz.facade.bizext.theme;

import com.ss.android.lark.coremd.base.theme.ImageThemeData;
import com.ss.android.lark.coremd.ext.c;
import com.ss.android.lark.coremd.ext.d;
import com.ss.android.lark.coremd.ext.e;
import com.ss.android.lark.coremd.ext.j;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class LarkImageThemeData extends ImageThemeData {
    public static final /* synthetic */ KProperty<Object>[] l = null;
    public final c g;
    public final c h;
    public final c i;
    public final c j;
    public final c k;

    static {
        l = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkImageThemeData.class, "paddingLeft", "getPaddingLeft()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkImageThemeData.class, "paddingTop", "getPaddingTop()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkImageThemeData.class, "paddingRight", "getPaddingRight()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkImageThemeData.class, "paddingBottom", "getPaddingBottom()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkImageThemeData.class, "alignment", "getAlignment()I", 0))};
    }

    public final float h() {
        return ((Number) this.j.getValue(this, l[3])).floatValue();
    }

    public final float i() {
        return ((Number) this.g.getValue(this, l[0])).floatValue();
    }

    public final float j() {
        return ((Number) this.h.getValue(this, l[1])).floatValue();
    }

    public LarkImageThemeData(j r11) {
        Intrinsics.checkNotNullParameter(r11, "host");
        super(r11);
        final Float r12 = Float.valueOf(0.0f);
        Function1<j, Float> r0 = new LarkImageThemeData$special$$inlined$extend$1(r12);
        Intrinsics.checkNotNullParameter(r0, "defaultProvider");
        KProperty<Object>[] r2 = l;
        KProperty<Object> r4 = r2[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r4, "property");
        ConcurrentHashMap<Object, Function1<j, Object>> r7 = d.a;
        Intrinsics.checkNotNullParameter(r4, "kProperty");
        Intrinsics.checkNotNullParameter(r0, "value");
        ConcurrentHashMap<Object, Function1<j, Object>> r9 = d.a;
        r9.put(e.a(r4), r0);
        this.g = new c();
        Function1<j, Float> r1 = new LarkImageThemeData$special$$inlined$extend$2(r12);
        Intrinsics.checkNotNullParameter(r1, "defaultProvider");
        KProperty<Object> r5 = r2[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r5, "property");
        Intrinsics.checkNotNullParameter(r5, "kProperty");
        Intrinsics.checkNotNullParameter(r1, "value");
        r9.put(e.a(r5), r1);
        this.h = new c();
        Function1<j, Float> r3 = new LarkImageThemeData$special$$inlined$extend$3(r12);
        Intrinsics.checkNotNullParameter(r3, "defaultProvider");
        KProperty<Object> r6 = r2[2];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r6, "property");
        Intrinsics.checkNotNullParameter(r6, "kProperty");
        Intrinsics.checkNotNullParameter(r3, "value");
        r9.put(e.a(r6), r3);
        this.i = new c();
        Function1<j, Float> r8 = new LarkImageThemeData$special$$inlined$extend$4(r12);
        Intrinsics.checkNotNullParameter(r8, "defaultProvider");
        KProperty<Object> r13 = r2[3];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r13, "property");
        Intrinsics.checkNotNullParameter(r13, "kProperty");
        Intrinsics.checkNotNullParameter(r8, "value");
        r9.put(e.a(r13), r8);
        this.j = new c();
        final int r14 = 0;
        Function1<j, Integer> r10 = new LarkImageThemeData$special$$inlined$extend$5(r14);
        Intrinsics.checkNotNullParameter(r10, "defaultProvider");
        KProperty<Object> r15 = r2[4];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r15, "property");
        Intrinsics.checkNotNullParameter(r15, "kProperty");
        Intrinsics.checkNotNullParameter(r10, "value");
        r9.put(e.a(r15), r10);
        this.k = new c();
    }
}
