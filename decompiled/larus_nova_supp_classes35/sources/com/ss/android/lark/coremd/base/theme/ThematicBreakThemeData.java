package com.ss.android.lark.coremd.base.theme;

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
public final class ThematicBreakThemeData extends a0 {
    public static final /* synthetic */ KProperty<Object>[] g = null;
    public final c d;
    public final c e;
    public final c f;

    static {
        g = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(ThematicBreakThemeData.class, "showThematicBreak", "getShowThematicBreak()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ThematicBreakThemeData.class, "thematicBreakColorRes", "getThematicBreakColorRes()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ThematicBreakThemeData.class, "thematicBreakHeight", "getThematicBreakHeight()I", 0))};
    }

    public ThematicBreakThemeData(j r10) {
        Intrinsics.checkNotNullParameter(r10, "host");
        super(r10);
        final Boolean r11 = Boolean.TRUE;
        Function1<j, Boolean> r0 = new ThematicBreakThemeData$special$$inlined$extend$1(r11);
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
        final int r3 = 2131103353;
        Function1<j, Integer> r4 = new ThematicBreakThemeData$special$$inlined$extend$2(r3);
        Intrinsics.checkNotNullParameter(r4, "defaultProvider");
        KProperty<Object> r8 = r1[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r8, "property");
        Intrinsics.checkNotNullParameter(r8, "kProperty");
        Intrinsics.checkNotNullParameter(r4, "value");
        r7.put(e.a(r8), r4);
        this.e = new c();
        final int r6 = 1;
        Function1<j, Integer> r9 = new ThematicBreakThemeData$special$$inlined$extend$3(r6);
        Intrinsics.checkNotNullParameter(r9, "defaultProvider");
        KProperty<Object> r12 = r1[2];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r12, "property");
        Intrinsics.checkNotNullParameter(r12, "kProperty");
        Intrinsics.checkNotNullParameter(r9, "value");
        r7.put(e.a(r12), r9);
        this.f = new c();
    }
}
