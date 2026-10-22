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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class LarkTableThemeData extends a0 {
    public static final /* synthetic */ KProperty<Object>[] e = null;
    public final c d;

    static {
        e = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(LarkTableThemeData.class, "showTableDetail", "getShowTableDetail()Z", 0))};
    }

    public final void h() {
        this.d.setValue(this, e[0], Boolean.TRUE);
    }

    public LarkTableThemeData(j r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        super(r3);
        final Boolean r4 = Boolean.FALSE;
        Function1<j, Boolean> r0 = new LarkTableThemeData$special$$inlined$extend$1(r4);
        Intrinsics.checkNotNullParameter(r0, "defaultProvider");
        KProperty<Object> r5 = e[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r5, "property");
        ConcurrentHashMap<Object, Function1<j, Object>> r1 = d.a;
        Intrinsics.checkNotNullParameter(r5, "kProperty");
        Intrinsics.checkNotNullParameter(r0, "value");
        d.a.put(e.a(r5), r0);
        this.d = new c();
    }
}
