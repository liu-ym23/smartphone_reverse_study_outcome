package com.ss.android.lark.coremdbiz.facade.bizext.theme;

import com.ss.android.lark.coremd.base.parse.a0;
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
public class LarkAtThemeData extends a0 {
    public static final /* synthetic */ KProperty<Object>[] k = null;
    public final c d;
    public final c e;
    public final c f;
    public final c g;
    public final c h;
    public final c i;
    public final c j;

    static {
        k = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkAtThemeData.class, "showAt", "getShowAt()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkAtThemeData.class, "atColorRes", "getAtColorRes()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkAtThemeData.class, "showAtSelfStyle", "getShowAtSelfStyle()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkAtThemeData.class, "atSelfTextColorRes", "getAtSelfTextColorRes()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkAtThemeData.class, "atSelfBgColor", "getAtSelfBgColor()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkAtThemeData.class, "atTextSize", "getAtTextSize()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkAtThemeData.class, "enableUnifyAtStyle", "getEnableUnifyAtStyle()Lcom/ss/android/lark/coremdbiz/facade/bizext/configs/UnifyAtStyleConfig;", 0))};
    }

    public final int h() {
        return ((Number) this.e.getValue(this, k[1])).intValue();
    }

    public final z9b.c i() {
        return (z9b.c) this.j.getValue(this, k[6]);
    }

    public final boolean j() {
        return ((Boolean) this.d.getValue(this, k[0])).booleanValue();
    }

    public LarkAtThemeData(j r10) {
        Intrinsics.checkNotNullParameter(r10, "host");
        super(r10);
        final Boolean r11 = Boolean.TRUE;
        Function1<j, Boolean> r0 = new LarkAtThemeData$special$$inlined$extend$1(r11);
        Intrinsics.checkNotNullParameter(r0, "defaultProvider");
        KProperty<Object>[] r2 = k;
        KProperty<Object> r3 = r2[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r3, "property");
        ConcurrentHashMap<Object, Function1<j, Object>> r6 = d.a;
        Intrinsics.checkNotNullParameter(r3, "kProperty");
        Intrinsics.checkNotNullParameter(r0, "value");
        ConcurrentHashMap<Object, Function1<j, Object>> r8 = d.a;
        r8.put(e.a(r3), r0);
        this.d = new c();
        final int r1 = 2131102465;
        Function1<j, Integer> r4 = new LarkAtThemeData$special$$inlined$extend$2(r1);
        Intrinsics.checkNotNullParameter(r4, "defaultProvider");
        KProperty<Object> r5 = r2[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r5, "property");
        Intrinsics.checkNotNullParameter(r5, "kProperty");
        Intrinsics.checkNotNullParameter(r4, "value");
        r8.put(e.a(r5), r4);
        this.e = new c();
        Function1<j, Boolean> r7 = new LarkAtThemeData$special$$inlined$extend$3(r11);
        Intrinsics.checkNotNullParameter(r7, "defaultProvider");
        KProperty<Object> r12 = r2[2];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r12, "property");
        Intrinsics.checkNotNullParameter(r12, "kProperty");
        Intrinsics.checkNotNullParameter(r7, "value");
        r8.put(e.a(r12), r7);
        this.f = new c();
        final int r13 = 2131106521;
        Function1<j, Integer> r9 = new LarkAtThemeData$special$$inlined$extend$4(r13);
        Intrinsics.checkNotNullParameter(r9, "defaultProvider");
        KProperty<Object> r14 = r2[3];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r14, "property");
        Intrinsics.checkNotNullParameter(r14, "kProperty");
        Intrinsics.checkNotNullParameter(r9, "value");
        r8.put(e.a(r14), r9);
        this.g = new c();
        final int r15 = 2131105548;
        Function1<j, Integer> r16 = new LarkAtThemeData$special$$inlined$extend$5(r15);
        Intrinsics.checkNotNullParameter(r16, "defaultProvider");
        KProperty<Object> r17 = r2[4];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r17, "property");
        Intrinsics.checkNotNullParameter(r17, "kProperty");
        Intrinsics.checkNotNullParameter(r16, "value");
        r8.put(e.a(r17), r16);
        this.h = new c();
        final Float r18 = Float.valueOf(17.0f);
        Function1<j, Float> r19 = new LarkAtThemeData$special$$inlined$extend$6(r18);
        Intrinsics.checkNotNullParameter(r19, "defaultProvider");
        KProperty<Object> r110 = r2[5];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r110, "property");
        Intrinsics.checkNotNullParameter(r110, "kProperty");
        Intrinsics.checkNotNullParameter(r19, "value");
        r8.put(e.a(r110), r19);
        this.i = new c();
        int r20 = 2131106500;
        final z9b.c r111 = new z9b.c(r20, r20, 8);
        Function1<j, z9b.c> r21 = new LarkAtThemeData$special$$inlined$extend$7(r111);
        Intrinsics.checkNotNullParameter(r21, "defaultProvider");
        KProperty<Object> r112 = r2[6];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r112, "property");
        Intrinsics.checkNotNullParameter(r112, "kProperty");
        Intrinsics.checkNotNullParameter(r21, "value");
        r8.put(e.a(r112), r21);
        this.j = new c();
    }

    public final void k(float r4) {
        this.i.setValue(this, k[5], Float.valueOf(r4));
    }
}
