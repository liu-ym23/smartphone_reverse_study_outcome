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
public final class BlockQuoteThemeData extends a0 {
    public static final /* synthetic */ KProperty<Object>[] j = null;
    public final c d;
    public final c e;
    public final c f;
    public final c g;
    public final c h;
    public final c i;

    static {
        j = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(BlockQuoteThemeData.class, "showBlockQuote", "getShowBlockQuote()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(BlockQuoteThemeData.class, "blockQuoteWidth", "getBlockQuoteWidth()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(BlockQuoteThemeData.class, "blockQuoteVerticalPadding", "getBlockQuoteVerticalPadding()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(BlockQuoteThemeData.class, "blockQuoteColorRes", "getBlockQuoteColorRes()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(BlockQuoteThemeData.class, "blockQuoteTextMargin", "getBlockQuoteTextMargin()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(BlockQuoteThemeData.class, "quoteTextColorRes", "getQuoteTextColorRes()I", 0))};
    }

    public BlockQuoteThemeData(j r11) {
        Intrinsics.checkNotNullParameter(r11, "host");
        super(r11);
        final Boolean r12 = Boolean.TRUE;
        Function1<j, Boolean> r0 = new BlockQuoteThemeData$special$$inlined$extend$1(r12);
        Intrinsics.checkNotNullParameter(r0, "defaultProvider");
        KProperty<Object>[] r1 = j;
        KProperty<Object> r2 = r1[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r2, "property");
        ConcurrentHashMap<Object, Function1<j, Object>> r5 = d.a;
        Intrinsics.checkNotNullParameter(r2, "kProperty");
        Intrinsics.checkNotNullParameter(r0, "value");
        ConcurrentHashMap<Object, Function1<j, Object>> r7 = d.a;
        r7.put(e.a(r2), r0);
        this.d = new c();
        final int r3 = 2;
        Function1<j, Integer> r8 = new BlockQuoteThemeData$special$$inlined$extend$2(r3);
        Intrinsics.checkNotNullParameter(r8, "defaultProvider");
        KProperty<Object> r4 = r1[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r4, "property");
        Intrinsics.checkNotNullParameter(r4, "kProperty");
        Intrinsics.checkNotNullParameter(r8, "value");
        r7.put(e.a(r4), r8);
        this.e = new c();
        final int r9 = 4;
        Function1<j, Integer> r10 = new BlockQuoteThemeData$special$$inlined$extend$3(r9);
        Intrinsics.checkNotNullParameter(r10, "defaultProvider");
        KProperty<Object> r6 = r1[2];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r6, "property");
        Intrinsics.checkNotNullParameter(r6, "kProperty");
        Intrinsics.checkNotNullParameter(r10, "value");
        r7.put(e.a(r6), r10);
        this.f = new c();
        final int r13 = 2131109077;
        Function1<j, Integer> r14 = new BlockQuoteThemeData$special$$inlined$extend$4(r13);
        Intrinsics.checkNotNullParameter(r14, "defaultProvider");
        KProperty<Object> r15 = r1[3];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r15, "property");
        Intrinsics.checkNotNullParameter(r15, "kProperty");
        Intrinsics.checkNotNullParameter(r14, "value");
        r7.put(e.a(r15), r14);
        this.g = new c();
        final int r16 = 10;
        Function1<j, Integer> r17 = new BlockQuoteThemeData$special$$inlined$extend$5(r16);
        Intrinsics.checkNotNullParameter(r17, "defaultProvider");
        KProperty<Object> r18 = r1[4];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r18, "property");
        Intrinsics.checkNotNullParameter(r18, "kProperty");
        Intrinsics.checkNotNullParameter(r17, "value");
        r7.put(e.a(r18), r17);
        this.h = new c();
        final int r19 = 2131106607;
        Function1<j, Integer> r20 = new BlockQuoteThemeData$special$$inlined$extend$6(r19);
        Intrinsics.checkNotNullParameter(r20, "defaultProvider");
        KProperty<Object> r110 = r1[5];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r110, "property");
        Intrinsics.checkNotNullParameter(r110, "kProperty");
        Intrinsics.checkNotNullParameter(r20, "value");
        r7.put(e.a(r110), r20);
        this.i = new c();
    }
}
