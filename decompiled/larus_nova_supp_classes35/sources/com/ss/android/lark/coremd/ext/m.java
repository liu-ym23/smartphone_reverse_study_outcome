package com.ss.android.lark.coremd.ext;

import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class m<T> implements ReadWriteProperty<j, T> {
    public m() {
    }

    public final Object getValue(Object r2, KProperty r3) {
        j r4 = (j) r2;
        Intrinsics.checkNotNullParameter(r4, "thisRef");
        Intrinsics.checkNotNullParameter(r3, "property");
        Object r5 = r4.getValues().get(e.a(r3));
        if (r5 != null) goto L6;
        return null;
    L6:
        return r5;
    }

    public final void setValue(Object r2, KProperty r3, Object r4) {
        j r5 = (j) r2;
        Intrinsics.checkNotNullParameter(r5, "thisRef");
        Intrinsics.checkNotNullParameter(r3, "property");
        r5.getValues().put(e.a(r3), r4);
    }
}
