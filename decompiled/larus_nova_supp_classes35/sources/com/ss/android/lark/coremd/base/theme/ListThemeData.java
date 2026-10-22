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
public final class ListThemeData extends a0 {
    public static final /* synthetic */ KProperty<Object>[] i = null;
    public final c d;
    public final c e;
    public final c f;
    public final c g;
    public final c h;

    static {
        i = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(ListThemeData.class, "showList", "getShowList()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ListThemeData.class, "listItemColorRes", "getListItemColorRes()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ListThemeData.class, "listFloorWidth", "getListFloorWidth()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ListThemeData.class, "listRightMargin", "getListRightMargin()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ListThemeData.class, "listLabelSize", "getListLabelSize()I", 0))};
    }

    public final int h() {
        return ((Number) this.f.getValue(this, i[2])).intValue();
    }

    public final int i() {
        return ((Number) this.e.getValue(this, i[1])).intValue();
    }

    public final int j() {
        return ((Number) this.h.getValue(this, i[4])).intValue();
    }

    public final float k() {
        return ((Number) this.g.getValue(this, i[3])).floatValue();
    }

    public final boolean l() {
        return ((Boolean) this.d.getValue(this, i[0])).booleanValue();
    }

    public ListThemeData(j r9) {
        Intrinsics.checkNotNullParameter(r9, "host");
        super(r9);
        final Boolean r10 = Boolean.TRUE;
        Function1<j, Boolean> r0 = new ListThemeData$special$$inlined$extend$1(r10);
        Intrinsics.checkNotNullParameter(r0, "defaultProvider");
        KProperty<Object>[] r1 = i;
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
        Function1<j, Integer> r4 = new ListThemeData$special$$inlined$extend$2(r3);
        Intrinsics.checkNotNullParameter(r4, "defaultProvider");
        KProperty<Object> r6 = r1[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r6, "property");
        Intrinsics.checkNotNullParameter(r6, "kProperty");
        Intrinsics.checkNotNullParameter(r4, "value");
        r7.put(e.a(r6), r4);
        this.e = new c();
        final int r8 = 24;
        Function1<j, Integer> r11 = new ListThemeData$special$$inlined$extend$3(r8);
        Intrinsics.checkNotNullParameter(r11, "defaultProvider");
        KProperty<Object> r12 = r1[2];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r12, "property");
        Intrinsics.checkNotNullParameter(r12, "kProperty");
        Intrinsics.checkNotNullParameter(r11, "value");
        r7.put(e.a(r12), r11);
        this.f = new c();
        final Float r13 = Float.valueOf(2.0f);
        Function1<j, Float> r14 = new ListThemeData$special$$inlined$extend$4(r13);
        Intrinsics.checkNotNullParameter(r14, "defaultProvider");
        KProperty<Object> r15 = r1[3];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r15, "property");
        Intrinsics.checkNotNullParameter(r15, "kProperty");
        Intrinsics.checkNotNullParameter(r14, "value");
        r7.put(e.a(r15), r14);
        this.g = new c();
        final int r16 = 16;
        Function1<j, Integer> r17 = new ListThemeData$special$$inlined$extend$5(r16);
        Intrinsics.checkNotNullParameter(r17, "defaultProvider");
        KProperty<Object> r18 = r1[4];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r18, "property");
        Intrinsics.checkNotNullParameter(r18, "kProperty");
        Intrinsics.checkNotNullParameter(r17, "value");
        r7.put(e.a(r18), r17);
        this.h = new c();
    }
}
