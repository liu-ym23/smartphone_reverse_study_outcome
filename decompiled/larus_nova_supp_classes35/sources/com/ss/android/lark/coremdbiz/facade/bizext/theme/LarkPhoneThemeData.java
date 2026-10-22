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
import z9b.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class LarkPhoneThemeData extends a0 {
    public static final /* synthetic */ KProperty<Object>[] g = null;
    public final c d;
    public final c e;
    public final c f;

    static {
        g = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkPhoneThemeData.class, "showPhoneNumber", "getShowPhoneNumber()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkPhoneThemeData.class, "phoneNumberColorRes", "getPhoneNumberColorRes()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkPhoneThemeData.class, "phoneStyleConfig", "getPhoneStyleConfig()Lcom/ss/android/lark/coremdbiz/facade/bizext/configs/PhoneStyleConfig;", 0))};
    }

    public LarkPhoneThemeData(j r10) {
        Intrinsics.checkNotNullParameter(r10, "host");
        super(r10);
        final Boolean r11 = Boolean.TRUE;
        Function1<j, Boolean> r0 = new LarkPhoneThemeData$special$$inlined$extend$1(r11);
        Intrinsics.checkNotNullParameter(r0, "defaultProvider");
        KProperty<Object>[] r1 = g;
        KProperty<Object> r3 = r1[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r3, "property");
        ConcurrentHashMap<Object, Function1<j, Object>> r6 = d.a;
        Intrinsics.checkNotNullParameter(r3, "kProperty");
        Intrinsics.checkNotNullParameter(r0, "value");
        ConcurrentHashMap<Object, Function1<j, Object>> r8 = d.a;
        r8.put(e.a(r3), r0);
        this.d = new c();
        final int r2 = 2131106616;
        Function1<j, Integer> r4 = new LarkPhoneThemeData$special$$inlined$extend$2(r2);
        Intrinsics.checkNotNullParameter(r4, "defaultProvider");
        KProperty<Object> r5 = r1[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r5, "property");
        Intrinsics.checkNotNullParameter(r5, "kProperty");
        Intrinsics.checkNotNullParameter(r4, "value");
        r8.put(e.a(r5), r4);
        this.e = new c();
        final b r7 = new b(false, 0, 0);
        Function1<j, b> r9 = new LarkPhoneThemeData$special$$inlined$extend$3(r7);
        Intrinsics.checkNotNullParameter(r9, "defaultProvider");
        KProperty<Object> r12 = r1[2];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r12, "property");
        Intrinsics.checkNotNullParameter(r12, "kProperty");
        Intrinsics.checkNotNullParameter(r9, "value");
        r8.put(e.a(r12), r9);
        this.f = new c();
    }
}
