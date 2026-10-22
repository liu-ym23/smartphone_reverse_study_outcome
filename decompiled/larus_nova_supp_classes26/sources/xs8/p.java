package xs8;

import android.content.Context;
import com.larus.bmhome.actionbar.model.l0;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.bmhome.view.actionbar.edit.component.TranslatorWidgetV2;
import com.larus.bmhome.view.actionbar.edit.component.TranslatorWidgetV3;
import com.larus.common.apphost.AppHost;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import wa8.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class p extends up8.b {
    public l0 l;

    @Override // up8.d
    public final boolean a() {
        return true;
    }

    @Override // up8.b
    public int getType() {
        return 5;
    }

    @Override // up8.d
    public final String g() {
        l0 r0 = this.l;
        Object r2 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        com.larus.bmhome.actionbar.model.h r1 = r0.a;
        if (r1 == null) goto L22;
        List r3 = r1.e;
        if (r3 == null) goto L22;
        ArrayList r5 = new ArrayList();
        Iterator r4 = r3.iterator();
    L11:
        if (r4.hasNext() == false) goto L21;
        Object r6 = r4.next();
        Integer r7 = ((w) r6).s;
        if (r7 != null) goto L16;
    L18:
        boolean r8 = false;
    L19:
        if (r8 == false) goto L11;
        r5.add(r6);
        goto L11
    L16:
        if (r7.intValue() != 1) goto L18;
        r8 = true;
        goto L19
    L21:
        ArrayList r12 = r5;
    L23:
        l0 r9 = this.l;
        if (r9 == null) goto L28;
        com.larus.bmhome.actionbar.model.h r10 = r9.a;
        if (r10 == null) goto L28;
        com.larus.bmhome.actionbar.model.h r11 = com.larus.bmhome.actionbar.model.h.a(r10, null, null, null, r12, null, null, 4079);
    L29:
        l0 r13 = this.l;
        if (r13 == null) goto L48;
        com.larus.bmhome.actionbar.model.h r14 = r13.b;
        if (r14 == null) goto L48;
        List r15 = r14.e;
        if (r15 == null) goto L48;
        ArrayList r16 = new ArrayList();
        Iterator r17 = r15.iterator();
    L37:
        if (r17.hasNext() == false) goto L47;
        Object r18 = r17.next();
        Integer r19 = ((w) r18).s;
        if (r19 != null) goto L42;
    L44:
        boolean r20 = false;
    L45:
        if (r20 == false) goto L37;
        r16.add(r18);
        goto L37
    L42:
        if (r19.intValue() != 1) goto L44;
        r20 = true;
        goto L45
    L47:
        ArrayList r110 = r16;
    L49:
        l0 r21 = this.l;
        if (r21 == null) goto L54;
        com.larus.bmhome.actionbar.model.h r22 = r21.b;
        if (r22 == null) goto L54;
        com.larus.bmhome.actionbar.model.h r23 = com.larus.bmhome.actionbar.model.h.a(r22, null, null, null, r110, null, null, 4079);
    L55:
        l0 r24 = this.l;
        if (r24 == null) goto L58;
        l0 r25 = l0.d(r24, r11, r23, null, 28);
    L69:
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L61
        Object r27 = Result.constructor-impl(xt7.d.b.a(kuc.a.d(l0.Companion.serializer()), r25));     // Catch: Throwable -> L61
    L64:
        if (Result.isFailure-impl(r27) == true) goto L68;
        r2 = r27;
    L68:
        return (String) r2;
    L61:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r27 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L64
    L58:
        r25 = null;
    L54:
        r23 = null;
    L48:
        r110 = null;
    L28:
        r11 = null;
    L22:
        r12 = null;
        goto L23
    }

    public p() {
    }

    @Override // up8.b
    public final AbsInstructionWidget e(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (AppHost.a.isOversea() == false) goto L6;
        return new TranslatorWidgetV2(r2);
    L6:
        return new TranslatorWidgetV3(r2);
    }

    @Override // up8.b
    public final a0 n(String r3) {
        if (r3 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == true) goto L10;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L13
        Object r4 = Result.constructor-impl((l0) xt7.d.b.c(l0.Companion.serializer(), r3));     // Catch: Throwable -> L13
    L15:
        Throwable r2 = Result.exceptionOrNull-impl(r4);
        if (r2 != null) goto L31;
        l0 r5 = (l0) r4;
        com.larus.bmhome.actionbar.model.h r6 = null;
        if (r5 == null) goto L20;
        com.larus.bmhome.actionbar.model.h r7 = r5.a;
    L21:
        if (r7 == null) goto L29;
        if (r5 == null) goto L24;
        r6 = r5.b;
    L24:
        if (r6 == null) goto L29;
        this.l = r5;
        return new a0(Boolean.TRUE, "");
    L29:
        return new a0(Boolean.FALSE, "translator source or target is null");
    L20:
        r7 = null;
        goto L21
    L31:
        return new a0(Boolean.FALSE, r2.getMessage());
    L13:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L10:
        return new a0(Boolean.FALSE, "translator is empty template");
    L4:
        if (r3.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    @Override // up8.b
    public final void k(String r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "defaultStateTemplate");
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L5
        Object r10 = Result.constructor-impl((l0) xt7.d.b.c(l0.Companion.serializer(), r7));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r10) == false) goto L10;
        r10 = null;
    L10:
        l0 r11 = (l0) r10;
        if (r11 != null) goto L13;
        return;
    L13:
        com.larus.bmhome.actionbar.model.h r12 = r11.a;
        if (r12 == null) goto L32;
        List r13 = r12.e;
        if (r13 == null) goto L32;
        w r14 = (w) CollectionsKt.firstOrNull(r13);
        if (r14 == null) goto L32;
        l0 r2 = this.l;
        if (r2 == null) goto L32;
        com.larus.bmhome.actionbar.model.h r3 = r2.a;
        if (r3 == null) goto L32;
        List r4 = r3.e;
        if (r4 == null) goto L32;
        Iterator r5 = r4.iterator();
    L27:
        if (r5.hasNext() == false) goto L32;
        w r6 = (w) r5.next();
        if (Intrinsics.areEqual(r6.a, r14.a) == true) goto L30;
        r6.s = 0;
        goto L27
    L30:
        r6.s = 1;
    L32:
        com.larus.bmhome.actionbar.model.h r15 = r11.b;
        if (r15 == null) goto L51;
        List r16 = r15.e;
        if (r16 == null) goto L66;
        w r17 = (w) CollectionsKt.firstOrNull(r16);
        if (r17 == null) goto L67;
        l0 r18 = this.l;
        if (r18 == null) goto L68;
        com.larus.bmhome.actionbar.model.h r19 = r18.b;
        if (r19 == null) goto L69;
        List r20 = r19.e;
        if (r20 == null) goto L70;
        Iterator r21 = r20.iterator();
    L46:
        if (r21.hasNext() == false) goto L71;
        w r22 = (w) r21.next();
        if (Intrinsics.areEqual(r22.a, r17.a) == true) goto L49;
        r22.s = 0;
        goto L46
    L49:
        r22.s = 1;
        goto L46
    L71:
        return;
    L70:
        return;
    L69:
        return;
    L68:
        return;
    L67:
        return;
    L66:
        return;
    L51:
        return;
    L5:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
