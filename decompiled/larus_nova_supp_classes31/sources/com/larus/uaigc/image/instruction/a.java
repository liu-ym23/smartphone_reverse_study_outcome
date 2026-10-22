package com.larus.uaigc.image.instruction;

import android.content.Context;
import com.larus.bmhome.actionbar.model.l;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import wa8.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a extends up8.b {
    public l l;

    public int getType() {
        return 6;
    }

    public final boolean a() {
        l r0 = this.l;
        if (r0 == null) goto L5;
        boolean r1 = Intrinsics.areEqual(r0.c, Boolean.TRUE);
    L6:
        if (r1 == true) goto L8;
    L9:
        return true;
    L8:
        if (g() != null) goto L9;
        return false;
    L5:
        r1 = false;
        goto L6
    }

    public final String g() {
        l r0 = this.l;
        Object r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        List r2 = r0.a;
        boolean r3 = false;
        if (r2 == null) goto L19;
        ArrayList r4 = new ArrayList();
        Iterator r5 = r2.iterator();
    L9:
        if (r5.hasNext() == false) goto L20;
        Object r6 = r5.next();
        Integer r7 = ((w) r6).s;
        if (r7 != null) goto L14;
    L16:
        boolean r8 = false;
    L17:
        if (r8 == false) goto L9;
        r4.add(r6);
        goto L9
    L14:
        if (r7.intValue() != 1) goto L16;
        r8 = true;
    L20:
        if (r4 != null) goto L22;
    L23:
        r3 = true;
    L24:
        if (r3 == false) goto L26;
        return null;
    L26:
        l r9 = this.l;
        if (r9 == null) goto L29;
        l r10 = new l(r4, r9.b, r9.c);
    L40:
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L32
        Object r12 = Result.constructor-impl(xt7.d.b.a(kuc.a.d(l.Companion.serializer()), r10));     // Catch: Throwable -> L32
    L35:
        if (Result.isFailure-impl(r12) == true) goto L39;
        r1 = r12;
    L39:
        return (String) r1;
    L32:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L35
    L29:
        r10 = null;
        goto L40
    L22:
        if (r4.isEmpty() == false) goto L24;
    L19:
        r4 = null;
        goto L20
    }

    public a() {
    }

    public final AbsInstructionWidget e(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new ImageListSelectorWidget(r2);
    }

    public final a0 n(String r5) {
        boolean r0 = true;
        if (r5 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L14
        Object r6 = Result.constructor-impl((l) xt7.d.b.c(l.Companion.serializer(), r5));     // Catch: Throwable -> L14
    L16:
        Throwable r4 = Result.exceptionOrNull-impl(r6);
        if (r4 != null) goto L34;
        l r7 = (l) r6;
        if (r7 == null) goto L21;
        List r8 = r7.a;
    L22:
        List r9 = r8;
        if (r9 != null) goto L25;
    L28:
        if (r0 == true) goto L30;
        this.l = r7;
        return new a0(Boolean.TRUE, "");
    L30:
        return new a0(Boolean.FALSE, "imageList is empty");
    L25:
        if (r9.isEmpty() == true) goto L28;
        r0 = false;
        goto L28
    L21:
        r8 = null;
        goto L22
    L34:
        return new a0(Boolean.FALSE, r4.getMessage());
    L14:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L11:
        return new a0(Boolean.FALSE, "image list selector is empty template");
    L5:
        if (r5.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public final void k(String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "defaultStateTemplate");
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L5
        Object r8 = Result.constructor-impl((l) xt7.d.b.c(l.Companion.serializer(), r5));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r8) == false) goto L10;
        r8 = null;
    L10:
        l r9 = (l) r8;
        if (r9 != null) goto L13;
        return;
    L13:
        List r10 = r9.a;
        if (r10 == null) goto L29;
        Iterator r11 = r10.iterator();
    L17:
        if (r11.hasNext() == false) goto L44;
        w r12 = (w) r11.next();
        l r0 = this.l;
        if (r0 == null) goto L17;
        List r1 = r0.a;
        if (r1 == null) goto L17;
        Iterator r2 = r1.iterator();
    L24:
        if (r2.hasNext() == false) goto L17;
        w r3 = (w) r2.next();
        if (Intrinsics.areEqual(r3.a, r12.a) == true) goto L27;
        r3.s = 0;
        goto L24
    L27:
        r3.s = 1;
        goto L24
    L44:
        return;
    L29:
        return;
    L5:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
