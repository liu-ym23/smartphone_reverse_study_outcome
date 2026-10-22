package com.ss.android.lark.coremd.base.parse;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class a0 implements com.ss.android.lark.coremd.ext.j, com.ss.android.lark.coremd.ext.f {
    public final Map<Object, Object> c;

    public final int hashCode() {
        return getClass().hashCode();
    }

    @Override // com.ss.android.lark.coremd.ext.j
    public final Map<Object, Object> getValues() {
        return this.c;
    }

    public a0(com.ss.android.lark.coremd.ext.j r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        this.c = r2.getValues();
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        Class<?> r0 = getClass();
        if (r3 == null) goto L8;
        Class<?> r1 = r3.getClass();
    L10:
        if (Intrinsics.areEqual(r0, r1) == true) goto L13;
        return false;
    L13:
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.ss.android.lark.coremd.base.parse.ThemeExtendData");
        return Intrinsics.areEqual(this.c, ((a0) r3).c);
    L8:
        r1 = null;
        goto L10
    }
}
