package com.ss.android.lark.coremdbiz.facade.bizext.theme;

import com.ss.android.lark.coremd.base.theme.CodeBlockThemeData;
import com.ss.android.lark.coremd.ext.c;
import com.ss.android.lark.coremd.ext.d;
import com.ss.android.lark.coremd.ext.e;
import com.ss.android.lark.coremd.ext.j;
import com.ss.android.lark.coremdbiz.facade.codeblock.a;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class LarkCodeBlockThemeData extends CodeBlockThemeData {
    public static final /* synthetic */ KProperty<Object>[] n = null;
    public final c k;
    public final c l;
    public final c m;

    static {
        n = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkCodeBlockThemeData.class, "alignment", "getAlignment()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkCodeBlockThemeData.class, "codeBlockParamsProvider", "getCodeBlockParamsProvider()Lcom/ss/android/lark/coremdbiz/facade/codeblock/ICodeBlockParamsProvider;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkCodeBlockThemeData.class, "verticalPadding", "getVerticalPadding()F", 0))};
    }

    public LarkCodeBlockThemeData(j r9) {
        Intrinsics.checkNotNullParameter(r9, "host");
        super(r9);
        final int r0 = 0;
        Function1<j, Integer> r1 = new LarkCodeBlockThemeData$special$$inlined$extend$1(r0);
        Intrinsics.checkNotNullParameter(r1, "defaultProvider");
        KProperty<Object>[] r2 = n;
        KProperty<Object> r10 = r2[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r10, "property");
        ConcurrentHashMap<Object, Function1<j, Object>> r5 = d.a;
        Intrinsics.checkNotNullParameter(r10, "kProperty");
        Intrinsics.checkNotNullParameter(r1, "value");
        ConcurrentHashMap<Object, Function1<j, Object>> r7 = d.a;
        r7.put(e.a(r10), r1);
        this.k = new c();
        final a.C0188a r11 = a.a;
        Function1<j, a> r3 = new LarkCodeBlockThemeData$special$$inlined$extend$2(r11);
        Intrinsics.checkNotNullParameter(r3, "defaultProvider");
        KProperty<Object> r12 = r2[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r12, "property");
        Intrinsics.checkNotNullParameter(r12, "kProperty");
        Intrinsics.checkNotNullParameter(r3, "value");
        r7.put(e.a(r12), r3);
        this.l = new c();
        final Float r13 = Float.valueOf(0.0f);
        Function1<j, Float> r4 = new LarkCodeBlockThemeData$special$$inlined$extend$3(r13);
        Intrinsics.checkNotNullParameter(r4, "defaultProvider");
        KProperty<Object> r14 = r2[2];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r14, "property");
        Intrinsics.checkNotNullParameter(r14, "kProperty");
        Intrinsics.checkNotNullParameter(r4, "value");
        r7.put(e.a(r14), r4);
        this.m = new c();
    }
}
