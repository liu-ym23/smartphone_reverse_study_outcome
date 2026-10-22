package xs8;

import android.content.Context;
import com.larus.bmhome.actionbar.model.i0;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.bmhome.view.actionbar.edit.component.TabSelectorWidget;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import wa8.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class n extends up8.b {
    public i0 l;

    @Override // up8.d
    public final boolean a() {
        return true;
    }

    @Override // up8.b
    public int getType() {
        return 7;
    }

    @Override // up8.d
    public final String g() {
        i0 r0 = this.l;
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
        if (r3 == false) goto L27;
        return null;
    L27:
        if (this.l == null) goto L29;
        i0 r9 = new i0(r4);
    L40:
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L32
        Object r11 = Result.constructor-impl(xt7.d.b.a(kuc.a.d(i0.Companion.serializer()), r9));     // Catch: Throwable -> L32
    L35:
        if (Result.isFailure-impl(r11) == true) goto L39;
        r1 = r11;
    L39:
        return (String) r1;
    L32:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L35
    L29:
        r9 = null;
        goto L40
    L22:
        if (r4.isEmpty() == false) goto L24;
    L19:
        r4 = null;
        goto L20
    }

    public n() {
    }

    @Override // up8.b
    public final AbsInstructionWidget e(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new TabSelectorWidget(r2);
    }

    @Override // up8.b
    public final a0 n(String r5) {
        boolean r0 = true;
        if (r5 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L14
        Object r6 = Result.constructor-impl((i0) xt7.d.b.c(i0.Companion.serializer(), r5));     // Catch: Throwable -> L14
    L16:
        Throwable r4 = Result.exceptionOrNull-impl(r6);
        if (r4 != null) goto L34;
        i0 r7 = (i0) r6;
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
        return new a0(Boolean.FALSE, "tab option list is empty");
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
        return new a0(Boolean.FALSE, "tab selector is empty template");
    L5:
        if (r5.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    @Override // up8.b
    public final void k(String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "defaultStateTemplate");
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L5
        Object r8 = Result.constructor-impl((i0) xt7.d.b.c(i0.Companion.serializer(), r5));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r8) == false) goto L10;
        r8 = null;
    L10:
        i0 r9 = (i0) r8;
        if (r9 != null) goto L13;
        return;
    L13:
        List r10 = r9.a;
        if (r10 == null) goto L29;
        Iterator r11 = r10.iterator();
    L17:
        if (r11.hasNext() == false) goto L44;
        w r12 = (w) r11.next();
        i0 r0 = this.l;
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
