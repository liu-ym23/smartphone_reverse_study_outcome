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
public class LarkMediaThemeData extends a0 {
    public static final /* synthetic */ KProperty<Object>[] j = null;
    public final c d;
    public final c e;
    public final c f;
    public final c g;
    public final c h;
    public final c i;

    static {
        j = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkMediaThemeData.class, "showMediaDetail", "getShowMediaDetail()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkMediaThemeData.class, "paddingLeft", "getPaddingLeft()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkMediaThemeData.class, "paddingTop", "getPaddingTop()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkMediaThemeData.class, "paddingRight", "getPaddingRight()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkMediaThemeData.class, "paddingBottom", "getPaddingBottom()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkMediaThemeData.class, "alignment", "getAlignment()I", 0))};
    }

    public LarkMediaThemeData(j r11) {
        Intrinsics.checkNotNullParameter(r11, "host");
        super(r11);
        final Boolean r12 = Boolean.TRUE;
        Function1<j, Boolean> r0 = new LarkMediaThemeData$special$$inlined$extend$1(r12);
        Intrinsics.checkNotNullParameter(r0, "defaultProvider");
        KProperty<Object>[] r1 = j;
        KProperty<Object> r3 = r1[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r3, "property");
        ConcurrentHashMap<Object, Function1<j, Object>> r6 = d.a;
        Intrinsics.checkNotNullParameter(r3, "kProperty");
        Intrinsics.checkNotNullParameter(r0, "value");
        ConcurrentHashMap<Object, Function1<j, Object>> r8 = d.a;
        r8.put(e.a(r3), r0);
        this.d = new c();
        final Float r2 = Float.valueOf(0.0f);
        Function1<j, Float> r4 = new LarkMediaThemeData$special$$inlined$extend$2(r2);
        Intrinsics.checkNotNullParameter(r4, "defaultProvider");
        KProperty<Object> r9 = r1[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r9, "property");
        Intrinsics.checkNotNullParameter(r9, "kProperty");
        Intrinsics.checkNotNullParameter(r4, "value");
        r8.put(e.a(r9), r4);
        this.e = new c();
        Function1<j, Float> r5 = new LarkMediaThemeData$special$$inlined$extend$3(r2);
        Intrinsics.checkNotNullParameter(r5, "defaultProvider");
        KProperty<Object> r10 = r1[2];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r10, "property");
        Intrinsics.checkNotNullParameter(r10, "kProperty");
        Intrinsics.checkNotNullParameter(r5, "value");
        r8.put(e.a(r10), r5);
        this.f = new c();
        Function1<j, Float> r7 = new LarkMediaThemeData$special$$inlined$extend$4(r2);
        Intrinsics.checkNotNullParameter(r7, "defaultProvider");
        KProperty<Object> r13 = r1[3];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r13, "property");
        Intrinsics.checkNotNullParameter(r13, "kProperty");
        Intrinsics.checkNotNullParameter(r7, "value");
        r8.put(e.a(r13), r7);
        this.g = new c();
        Function1<j, Float> r14 = new LarkMediaThemeData$special$$inlined$extend$5(r2);
        Intrinsics.checkNotNullParameter(r14, "defaultProvider");
        KProperty<Object> r15 = r1[4];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r15, "property");
        Intrinsics.checkNotNullParameter(r15, "kProperty");
        Intrinsics.checkNotNullParameter(r14, "value");
        r8.put(e.a(r15), r14);
        this.h = new c();
        final int r16 = 0;
        Function1<j, Integer> r17 = new LarkMediaThemeData$special$$inlined$extend$6(r16);
        Intrinsics.checkNotNullParameter(r17, "defaultProvider");
        KProperty<Object> r18 = r1[5];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r18, "property");
        Intrinsics.checkNotNullParameter(r18, "kProperty");
        Intrinsics.checkNotNullParameter(r17, "value");
        r8.put(e.a(r18), r17);
        this.i = new c();
    }
}
