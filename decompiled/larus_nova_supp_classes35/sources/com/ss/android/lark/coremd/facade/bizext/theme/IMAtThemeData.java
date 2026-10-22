package com.ss.android.lark.coremd.facade.bizext.theme;

import com.ss.android.lark.coremd.ext.c;
import com.ss.android.lark.coremd.ext.d;
import com.ss.android.lark.coremd.ext.e;
import com.ss.android.lark.coremd.ext.j;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkAtThemeData;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class IMAtThemeData extends LarkAtThemeData {
    public static final /* synthetic */ KProperty<Object>[] s = null;
    public final c l;
    public final c m;
    public final c n;
    public final c o;
    public final c p;
    public final c q;
    public final c r;

    static {
        s = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(IMAtThemeData.class, "showAtReadDot", "getShowAtReadDot()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(IMAtThemeData.class, "enableAtClickable", "getEnableAtClickable()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(IMAtThemeData.class, "atOtherChatUserTextColorRes", "getAtOtherChatUserTextColorRes()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(IMAtThemeData.class, "atAnonymousTextColorRes", "getAtAnonymousTextColorRes()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(IMAtThemeData.class, "atAnonymousAsNormalText", "getAtAnonymousAsNormalText()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(IMAtThemeData.class, "atReadDotColorRes", "getAtReadDotColorRes()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(IMAtThemeData.class, "atUnreadDotColorRes", "getAtUnreadDotColorRes()I", 0))};
    }

    public IMAtThemeData(j r10) {
        Intrinsics.checkNotNullParameter(r10, "host");
        super(r10);
        final Boolean r11 = Boolean.FALSE;
        Function1<j, Boolean> r0 = new IMAtThemeData$special$$inlined$extend$1(r11);
        Intrinsics.checkNotNullParameter(r0, "defaultProvider");
        KProperty<Object>[] r1 = s;
        KProperty<Object> r2 = r1[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r2, "property");
        ConcurrentHashMap<Object, Function1<j, Object>> r5 = d.a;
        Intrinsics.checkNotNullParameter(r2, "kProperty");
        Intrinsics.checkNotNullParameter(r0, "value");
        ConcurrentHashMap<Object, Function1<j, Object>> r7 = d.a;
        r7.put(e.a(r2), r0);
        this.l = new c();
        final Boolean r3 = Boolean.TRUE;
        Function1<j, Boolean> r4 = new IMAtThemeData$special$$inlined$extend$2(r3);
        Intrinsics.checkNotNullParameter(r4, "defaultProvider");
        KProperty<Object> r8 = r1[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r8, "property");
        Intrinsics.checkNotNullParameter(r8, "kProperty");
        Intrinsics.checkNotNullParameter(r4, "value");
        r7.put(e.a(r8), r4);
        this.m = new c();
        final int r6 = 2131106607;
        Function1<j, Integer> r9 = new IMAtThemeData$special$$inlined$extend$3(r6);
        Intrinsics.checkNotNullParameter(r9, "defaultProvider");
        KProperty<Object> r12 = r1[2];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r12, "property");
        Intrinsics.checkNotNullParameter(r12, "kProperty");
        Intrinsics.checkNotNullParameter(r9, "value");
        r7.put(e.a(r12), r9);
        this.n = new c();
        final int r13 = 2131106622;
        Function1<j, Integer> r14 = new IMAtThemeData$special$$inlined$extend$4(r13);
        Intrinsics.checkNotNullParameter(r14, "defaultProvider");
        KProperty<Object> r15 = r1[3];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r15, "property");
        Intrinsics.checkNotNullParameter(r15, "kProperty");
        Intrinsics.checkNotNullParameter(r14, "value");
        r7.put(e.a(r15), r14);
        this.o = new c();
        Function1<j, Boolean> r16 = new IMAtThemeData$special$$inlined$extend$5(r3);
        Intrinsics.checkNotNullParameter(r16, "defaultProvider");
        KProperty<Object> r17 = r1[4];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r17, "property");
        Intrinsics.checkNotNullParameter(r17, "kProperty");
        Intrinsics.checkNotNullParameter(r16, "value");
        r7.put(e.a(r17), r16);
        this.p = new c();
        final int r18 = 2131102454;
        Function1<j, Integer> r19 = new IMAtThemeData$special$$inlined$extend$6(r18);
        Intrinsics.checkNotNullParameter(r19, "defaultProvider");
        KProperty<Object> r20 = r1[5];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r20, "property");
        Intrinsics.checkNotNullParameter(r20, "kProperty");
        Intrinsics.checkNotNullParameter(r19, "value");
        r7.put(e.a(r20), r19);
        this.q = new c();
        final int r21 = 2131102456;
        Function1<j, Integer> r22 = new IMAtThemeData$special$$inlined$extend$7(r21);
        Intrinsics.checkNotNullParameter(r22, "defaultProvider");
        KProperty<Object> r110 = r1[6];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r110, "property");
        Intrinsics.checkNotNullParameter(r110, "kProperty");
        Intrinsics.checkNotNullParameter(r22, "value");
        r7.put(e.a(r110), r22);
        this.r = new c();
    }
}
