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
public class CodeBlockThemeData extends a0 {
    public static final /* synthetic */ KProperty<Object>[] j = null;
    public final c d;
    public final c e;
    public final c f;
    public final c g;
    public final c h;
    public final c i;

    static {
        j = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(CodeBlockThemeData.class, "showCodeBlock", "getShowCodeBlock()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(CodeBlockThemeData.class, "codeBlockBaseColorRes", "getCodeBlockBaseColorRes()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(CodeBlockThemeData.class, "codeBlockHeadingColorRes", "getCodeBlockHeadingColorRes()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(CodeBlockThemeData.class, "codeBlockBackgroundColorRes", "getCodeBlockBackgroundColorRes()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(CodeBlockThemeData.class, "codeBlockTextSize", "getCodeBlockTextSize()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(CodeBlockThemeData.class, "codeBlockRadius", "getCodeBlockRadius()F", 0))};
    }

    public final boolean h() {
        return ((Boolean) this.d.getValue(this, j[0])).booleanValue();
    }

    public CodeBlockThemeData(j r9) {
        Intrinsics.checkNotNullParameter(r9, "host");
        super(r9);
        final Boolean r10 = Boolean.TRUE;
        Function1<j, Boolean> r0 = new CodeBlockThemeData$special$$inlined$extend$1(r10);
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
        final int r3 = 2131108730;
        Function1<j, Integer> r4 = new CodeBlockThemeData$special$$inlined$extend$2(r3);
        Intrinsics.checkNotNullParameter(r4, "defaultProvider");
        KProperty<Object> r6 = r1[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r6, "property");
        Intrinsics.checkNotNullParameter(r6, "kProperty");
        Intrinsics.checkNotNullParameter(r4, "value");
        r7.put(e.a(r6), r4);
        this.e = new c();
        final int r8 = 2131108723;
        Function1<j, Integer> r11 = new CodeBlockThemeData$special$$inlined$extend$3(r8);
        Intrinsics.checkNotNullParameter(r11, "defaultProvider");
        KProperty<Object> r12 = r1[2];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r12, "property");
        Intrinsics.checkNotNullParameter(r12, "kProperty");
        Intrinsics.checkNotNullParameter(r11, "value");
        r7.put(e.a(r12), r11);
        this.f = new c();
        final int r13 = 2131108717;
        Function1<j, Integer> r14 = new CodeBlockThemeData$special$$inlined$extend$4(r13);
        Intrinsics.checkNotNullParameter(r14, "defaultProvider");
        KProperty<Object> r15 = r1[3];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r15, "property");
        Intrinsics.checkNotNullParameter(r15, "kProperty");
        Intrinsics.checkNotNullParameter(r14, "value");
        r7.put(e.a(r15), r14);
        this.g = new c();
        final int r16 = 14;
        Function1<j, Integer> r17 = new CodeBlockThemeData$special$$inlined$extend$5(r16);
        Intrinsics.checkNotNullParameter(r17, "defaultProvider");
        KProperty<Object> r18 = r1[4];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r18, "property");
        Intrinsics.checkNotNullParameter(r18, "kProperty");
        Intrinsics.checkNotNullParameter(r17, "value");
        r7.put(e.a(r18), r17);
        this.h = new c();
        final Float r19 = Float.valueOf(12.0f);
        Function1<j, Float> r20 = new CodeBlockThemeData$special$$inlined$extend$6(r19);
        Intrinsics.checkNotNullParameter(r20, "defaultProvider");
        KProperty<Object> r21 = r1[5];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r21, "property");
        Intrinsics.checkNotNullParameter(r21, "kProperty");
        Intrinsics.checkNotNullParameter(r20, "value");
        r7.put(e.a(r21), r20);
        this.i = new c();
    }
}
