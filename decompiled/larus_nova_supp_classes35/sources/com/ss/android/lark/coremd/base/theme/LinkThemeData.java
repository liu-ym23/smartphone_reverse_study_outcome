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
public class LinkThemeData extends a0 {
    public static final /* synthetic */ KProperty<Object>[] f = null;
    public final c d;
    public final c e;

    static {
        f = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(LinkThemeData.class, "showLink", "getShowLink()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(LinkThemeData.class, "linkColorRes", "getLinkColorRes()I", 0))};
    }

    public final int h() {
        return ((Number) this.e.getValue(this, f[1])).intValue();
    }

    public final boolean i() {
        return ((Boolean) this.d.getValue(this, f[0])).booleanValue();
    }

    public LinkThemeData(j r9) {
        Intrinsics.checkNotNullParameter(r9, "host");
        super(r9);
        final Boolean r10 = Boolean.TRUE;
        Function1<j, Boolean> r0 = new LinkThemeData$special$$inlined$extend$1(r10);
        Intrinsics.checkNotNullParameter(r0, "defaultProvider");
        KProperty<Object>[] r1 = f;
        KProperty<Object> r2 = r1[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r2, "property");
        ConcurrentHashMap<Object, Function1<j, Object>> r5 = d.a;
        Intrinsics.checkNotNullParameter(r2, "kProperty");
        Intrinsics.checkNotNullParameter(r0, "value");
        ConcurrentHashMap<Object, Function1<j, Object>> r7 = d.a;
        r7.put(e.a(r2), r0);
        this.d = new c();
        final int r3 = 2131106616;
        Function1<j, Integer> r4 = new LinkThemeData$special$$inlined$extend$2(r3);
        Intrinsics.checkNotNullParameter(r4, "defaultProvider");
        KProperty<Object> r11 = r1[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r11, "property");
        Intrinsics.checkNotNullParameter(r11, "kProperty");
        Intrinsics.checkNotNullParameter(r4, "value");
        r7.put(e.a(r11), r4);
        this.e = new c();
    }
}
