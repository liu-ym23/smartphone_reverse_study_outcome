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
public final class InlineCodeThemeData extends a0 {
    public static final /* synthetic */ KProperty<Object>[] h = null;
    public final c d;
    public final c e;
    public final c f;
    public final c g;

    static {
        h = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(InlineCodeThemeData.class, "showInlineCode", "getShowInlineCode()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(InlineCodeThemeData.class, "inlineCodeTextColorRes", "getInlineCodeTextColorRes()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(InlineCodeThemeData.class, "inlineCodeBackgroundColorRes", "getInlineCodeBackgroundColorRes()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(InlineCodeThemeData.class, "inlineCodeTextSize", "getInlineCodeTextSize()I", 0))};
    }

    public InlineCodeThemeData(j r9) {
        Intrinsics.checkNotNullParameter(r9, "host");
        super(r9);
        final Boolean r10 = Boolean.TRUE;
        Function1<j, Boolean> r0 = new InlineCodeThemeData$special$$inlined$extend$1(r10);
        Intrinsics.checkNotNullParameter(r0, "defaultProvider");
        KProperty<Object>[] r1 = h;
        KProperty<Object> r2 = r1[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r2, "property");
        ConcurrentHashMap<Object, Function1<j, Object>> r5 = d.a;
        Intrinsics.checkNotNullParameter(r2, "kProperty");
        Intrinsics.checkNotNullParameter(r0, "value");
        ConcurrentHashMap<Object, Function1<j, Object>> r7 = d.a;
        r7.put(e.a(r2), r0);
        this.d = new c();
        final int r3 = 2131106784;
        Function1<j, Integer> r4 = new InlineCodeThemeData$special$$inlined$extend$2(r3);
        Intrinsics.checkNotNullParameter(r4, "defaultProvider");
        KProperty<Object> r6 = r1[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r6, "property");
        Intrinsics.checkNotNullParameter(r6, "kProperty");
        Intrinsics.checkNotNullParameter(r4, "value");
        r7.put(e.a(r6), r4);
        this.e = new c();
        final int r8 = 2131100548;
        Function1<j, Integer> r11 = new InlineCodeThemeData$special$$inlined$extend$3(r8);
        Intrinsics.checkNotNullParameter(r11, "defaultProvider");
        KProperty<Object> r12 = r1[2];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r12, "property");
        Intrinsics.checkNotNullParameter(r12, "kProperty");
        Intrinsics.checkNotNullParameter(r11, "value");
        r7.put(e.a(r12), r11);
        this.f = new c();
        final int r13 = 17;
        Function1<j, Integer> r14 = new InlineCodeThemeData$special$$inlined$extend$4(r13);
        Intrinsics.checkNotNullParameter(r14, "defaultProvider");
        KProperty<Object> r15 = r1[3];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r15, "property");
        Intrinsics.checkNotNullParameter(r15, "kProperty");
        Intrinsics.checkNotNullParameter(r14, "value");
        r7.put(e.a(r15), r14);
        this.g = new c();
    }
}
