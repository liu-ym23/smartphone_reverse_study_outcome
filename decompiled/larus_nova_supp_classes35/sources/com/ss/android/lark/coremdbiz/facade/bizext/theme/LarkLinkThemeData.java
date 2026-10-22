package com.ss.android.lark.coremdbiz.facade.bizext.theme;

import com.ss.android.lark.coremd.base.theme.LinkThemeData;
import com.ss.android.lark.coremd.ext.c;
import com.ss.android.lark.coremd.ext.d;
import com.ss.android.lark.coremd.ext.e;
import com.ss.android.lark.coremd.ext.j;
import com.ss.android.lark.coremdbiz.facade.link.parser.b;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import z9b.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class LarkLinkThemeData extends LinkThemeData {
    public static final /* synthetic */ KProperty<Object>[] n = null;
    public final c g;
    public final c h;
    public final c i;
    public final c j;
    public final c k;
    public final c l;
    public final c m;

    static {
        n = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkLinkThemeData.class, "linkPreviewLoader", "getLinkPreviewLoader()Lcom/ss/android/lark/coremdbiz/facade/link/LinkPreviewLoader;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkLinkThemeData.class, "linkIconSize", "getLinkIconSize()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkLinkThemeData.class, "linkIconColor", "getLinkIconColor()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkLinkThemeData.class, "linkIconMarginStart", "getLinkIconMarginStart()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkLinkThemeData.class, "linkIconMarginEnd", "getLinkIconMarginEnd()F", 0)), Reflection.property1(new PropertyReference1Impl(LarkLinkThemeData.class, "linkIconParser", "getLinkIconParser()Lcom/ss/android/lark/coremdbiz/facade/link/parser/LinkIconParser;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkLinkThemeData.class, "linkStyleConfig", "getLinkStyleConfig()Lcom/ss/android/lark/coremdbiz/facade/bizext/configs/LinkStyleConfig;", 0))};
    }

    public final int j() {
        return ((Number) this.i.getValue(this, n[2])).intValue();
    }

    public final b k() {
        return (b) this.l.getValue(this, n[5]);
    }

    public final float l() {
        return ((Number) this.h.getValue(this, n[1])).floatValue();
    }

    public final a m() {
        return (a) this.m.getValue(this, n[6]);
    }

    public LarkLinkThemeData(j r11) {
        Intrinsics.checkNotNullParameter(r11, "host");
        super(r11);
        LarkLinkThemeData$linkPreviewLoader$2 r12 = LarkLinkThemeData$linkPreviewLoader$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r12, "defaultProvider");
        KProperty<Object>[] r1 = n;
        KProperty<Object> r3 = r1[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r3, "property");
        ConcurrentHashMap<Object, Function1<j, Object>> r6 = d.a;
        Intrinsics.checkNotNullParameter(r3, "kProperty");
        Intrinsics.checkNotNullParameter(r12, "value");
        ConcurrentHashMap<Object, Function1<j, Object>> r8 = d.a;
        r8.put(e.a(r3), r12);
        this.g = new c();
        final Float r13 = Float.valueOf(17.0f);
        Function1<j, Float> r4 = new LarkLinkThemeData$special$$inlined$extend$1(r13);
        Intrinsics.checkNotNullParameter(r4, "defaultProvider");
        KProperty<Object> r14 = r1[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r14, "property");
        Intrinsics.checkNotNullParameter(r14, "kProperty");
        Intrinsics.checkNotNullParameter(r4, "value");
        r8.put(e.a(r14), r4);
        this.h = new c();
        final int r15 = 0;
        Function1<j, Integer> r5 = new LarkLinkThemeData$special$$inlined$extend$2(r15);
        Intrinsics.checkNotNullParameter(r5, "defaultProvider");
        KProperty<Object> r16 = r1[2];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r16, "property");
        Intrinsics.checkNotNullParameter(r16, "kProperty");
        Intrinsics.checkNotNullParameter(r5, "value");
        r8.put(e.a(r16), r5);
        this.i = new c();
        final Float r17 = Float.valueOf(3.0f);
        Function1<j, Float> r7 = new LarkLinkThemeData$special$$inlined$extend$3(r17);
        Intrinsics.checkNotNullParameter(r7, "defaultProvider");
        KProperty<Object> r9 = r1[3];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r9, "property");
        Intrinsics.checkNotNullParameter(r9, "kProperty");
        Intrinsics.checkNotNullParameter(r7, "value");
        r8.put(e.a(r9), r7);
        this.j = new c();
        Function1<j, Float> r10 = new LarkLinkThemeData$special$$inlined$extend$4(r17);
        Intrinsics.checkNotNullParameter(r10, "defaultProvider");
        KProperty<Object> r18 = r1[4];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r18, "property");
        Intrinsics.checkNotNullParameter(r18, "kProperty");
        Intrinsics.checkNotNullParameter(r10, "value");
        r8.put(e.a(r18), r10);
        this.k = new c();
        LarkLinkThemeData$linkIconParser$2 r19 = LarkLinkThemeData$linkIconParser$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r19, "defaultProvider");
        KProperty<Object> r20 = r1[5];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r20, "property");
        Intrinsics.checkNotNullParameter(r20, "kProperty");
        Intrinsics.checkNotNullParameter(r19, "value");
        r8.put(e.a(r20), r19);
        this.l = new c();
        final a r110 = new a(false, 0, 0);
        Function1<j, a> r2 = new LarkLinkThemeData$special$$inlined$extend$5(r110);
        Intrinsics.checkNotNullParameter(r2, "defaultProvider");
        KProperty<Object> r111 = r1[6];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r111, "property");
        Intrinsics.checkNotNullParameter(r111, "kProperty");
        Intrinsics.checkNotNullParameter(r2, "value");
        r8.put(e.a(r111), r2);
        this.m = new c();
    }

    public final void n(float r4) {
        this.h.setValue(this, n[1], Float.valueOf(r4));
    }
}
