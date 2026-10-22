package com.ss.android.lark.coremd.base.theme;

import com.ss.android.lark.coremd.base.parse.a0;
import com.ss.android.lark.coremd.ext.c;
import com.ss.android.lark.coremd.ext.d;
import com.ss.android.lark.coremd.ext.e;
import com.ss.android.lark.coremd.ext.j;
import com.ss.android.lark.coremd.ext.m;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class HeadingThemeData extends a0 {
    public static final /* synthetic */ KProperty<Object>[] g = null;
    public static final List<Float> h = null;
    public final c d;
    public final m e;
    public final c f;

    public static final class a {
    }

    static {
        g = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(HeadingThemeData.class, "showHeading", "getShowHeading()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(HeadingThemeData.class, "headingTypeface", "getHeadingTypeface()Landroid/graphics/Typeface;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(HeadingThemeData.class, "headingTextSizeMultiplier", "getHeadingTextSizeMultiplier()Ljava/util/List;", 0))};
        h = CollectionsKt.listOf(new Float[]{Float.valueOf(2.0f), Float.valueOf(1.5f), Float.valueOf(1.17f), Float.valueOf(1.0f), Float.valueOf(0.83f), Float.valueOf(0.67f)});
    }

    public final List<Float> h() {
        return (List) this.f.getValue(this, g[2]);
    }

    public HeadingThemeData(j r9) {
        Intrinsics.checkNotNullParameter(r9, "host");
        super(r9);
        final Boolean r10 = Boolean.TRUE;
        Function1<j, Boolean> r0 = new HeadingThemeData$special$$inlined$extend$1(r10);
        Intrinsics.checkNotNullParameter(r0, "defaultProvider");
        KProperty<Object>[] r1 = g;
        KProperty<Object> r2 = r1[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r2, "property");
        ConcurrentHashMap<Object, Function1<j, Object>> r5 = d.a;
        Intrinsics.checkNotNullParameter(r2, "kProperty");
        Intrinsics.checkNotNullParameter(r0, "value");
        ConcurrentHashMap<Object, Function1<j, Object>> r7 = d.a;
        r7.put(e.a(r2), r0);
        this.d = new c();
        KProperty<Object> r3 = r1[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r3, "property");
        this.e = new m();
        final List<Float> r4 = h;
        Function1<j, List<? extends Float>> r6 = new HeadingThemeData$special$$inlined$extend$2(r4);
        Intrinsics.checkNotNullParameter(r6, "defaultProvider");
        KProperty<Object> r11 = r1[2];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r11, "property");
        Intrinsics.checkNotNullParameter(r11, "kProperty");
        Intrinsics.checkNotNullParameter(r6, "value");
        r7.put(e.a(r11), r6);
        this.f = new c();
    }
}
