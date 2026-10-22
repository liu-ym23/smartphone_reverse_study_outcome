package com.ss.android.lark.coremd.ext;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c<T> implements ReadWriteProperty<j, T> {
    public c() {
    }

    public final Object getValue(Object r4, KProperty r5) {
        j r6 = (j) r4;
        Intrinsics.checkNotNullParameter(r6, "thisRef");
        Intrinsics.checkNotNullParameter(r5, "property");
        Map<Object, Object> r0 = r6.getValues();
        String r1 = e.a(r5);
        Object r2 = r0.get(r1);
        if (r2 != null) goto L10;
        ConcurrentHashMap<Object, Function1<j, Object>> r3 = d.a;
        Intrinsics.checkNotNullParameter(r6, "host");
        Intrinsics.checkNotNullParameter(r5, "kProperty");
        Function1<j, Object> r7 = d.a.get(e.a(r5));
        if (r7 == null) goto L7;
        Object r8 = r7.invoke(r6);
    L8:
        Object r9 = r8;
        r0.put(r1, r9);
        return r9;
    L7:
        r8 = null;
        goto L8
    L10:
        return r2;
    }

    public final void setValue(Object r2, KProperty r3, Object r4) {
        j r5 = (j) r2;
        Intrinsics.checkNotNullParameter(r5, "thisRef");
        Intrinsics.checkNotNullParameter(r3, "property");
        r5.getValues().put(e.a(r3), r4);
    }
}
