package com.ss.android.lark.passportc.impl.v2.action;

import com.ss.android.lark.passportc.entity.UserState;
import com.ss.android.lark.passportc.impl.v2.entity.UpdateUserContext;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d implements c {
    public final List<c> a;

    public d(c... r2) {
        Intrinsics.checkNotNullParameter(r2, "actions");
        this.a = ArraysKt.toList(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i0c.b
    public final h0c.b a(UpdateUserContext r7, Object r8, Object r9) {
        UserState r10 = (UserState) r8;
        UserState r11 = (UserState) r9;
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r10, "from");
        Intrinsics.checkNotNullParameter(r11, "to");
        j0c.a r0 = com.ss.android.lark.passportc.task.i.a;
        Iterator<c> r1 = this.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L21;
        c r2 = r1.next();
        h0c.a<UserState, UpdateUserContext, j0c.a> r3 = r7.h;
        if (r3 == null) goto L8;
        r3.b(r2);
    L8:
        h0c.b r4 = r2.a(r7, r10, r11);
        T r5 = r4.a;
        j0c.a r6 = com.ss.android.lark.passportc.task.i.a;
        if (r5 == r6) goto L15;
        j0c.a r12 = (j0c.a) r5;
        if (r12 == null) goto L14;
        r6 = r12;
    L14:
        r0 = r6;
    L15:
        h0c.a<UserState, UpdateUserContext, j0c.a> r13 = r7.h;
        if (r13 == null) goto L19;
        r13.a(r7, r2, r4);
    L19:
        if (r0.a == true) goto L4;
        int r14 = h0c.b.b;
        return new h0c.b.C0143b(r0);
    L21:
        int r15 = h0c.b.b;
        return new h0c.b.c(r0);
    }
}
