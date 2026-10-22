package com.larus.bmhome.actionbar.model;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import nuc.m2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class r1 implements juc.d<c2> {
    public static final r1 a = null;
    public static final m2 b = null;

    public r1() {
    }

    static {
        a = new r1();
        b = luc.n.a("NullableSwitchMenuItemTagFromAnySerializer", luc.e.i.a);
    }

    public final luc.f getDescriptor() {
        return b;
    }

    public final Object deserialize(muc.e r4) {
        Intrinsics.checkNotNullParameter(r4, "decoder");
        Object r1 = null;
        if ((r4 instanceof ouc.h) == false) goto L5;
        ouc.h r5 = (ouc.h) r4;
    L6:
        if (r5 == null) goto L26;
        ouc.i r6 = r5.a();
        if (Intrinsics.areEqual(r6, ouc.a0.INSTANCE) == false) goto L12;
        return null;
    L12:
        if ((r6 instanceof ouc.g0) == true) goto L28;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L16
        Object r7 = Result.constructor-impl((c2) xt7.d.b.c(c2.Companion.serializer(), r6.toString()));     // Catch: Throwable -> L16
    L19:
        if (Result.isFailure-impl(r7) == true) goto L23;
        r1 = r7;
    L23:
        return (c2) r1;
    L16:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    L28:
        return null;
    L26:
        return null;
    L5:
        r5 = null;
        goto L6
    }

    public final void serialize(muc.f r2, Object r3) {
        c2 r4 = (c2) r3;
        Intrinsics.checkNotNullParameter(r2, "encoder");
        if (r4 != null) goto L5;
        r2.encodeNull();
        return;
    L5:
        r2.encodeSerializableValue(c2.Companion.serializer(), r4);
    }
}
