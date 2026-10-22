package xs8;

import android.content.Context;
import com.google.gson.Gson;
import com.larus.bmhome.actionbar.model.k0;
import com.larus.bmhome.actionbar.model.y1;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.bmhome.view.actionbar.edit.component.TextListSelectorWidget;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import wa8.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public class o extends up8.b {
    public k0 l;
    public final String m;
    public boolean n;

    @Override // up8.b
    public int getType() {
        return 1;
    }

    @Override // up8.d
    public final boolean a() {
        k0 r0 = this.l;
        if (r0 == null) goto L5;
        boolean r1 = Intrinsics.areEqual(r0.e, Boolean.TRUE);
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

    @Override // up8.d
    public final String g() {
        k0 r0 = this.l;
        Object r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        List r2 = r0.c;
        boolean r3 = false;
        if (r2 == null) goto L19;
        ArrayList r4 = new ArrayList();
        Iterator r5 = r2.iterator();
    L9:
        if (r5.hasNext() == false) goto L20;
        Object r6 = r5.next();
        Integer r7 = ((y1) r6).g;
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
        k0 r9 = this.l;
        if (r9 == null) goto L32;
        if (r4 != null) goto L24;
    L27:
        boolean r10 = true;
    L28:
        if (r10 == false) goto L30;
        ArrayList r11 = null;
    L31:
        k0 r12 = k0.d(r9, r11);
    L33:
        if (r4 != null) goto L35;
    L36:
        r3 = true;
    L37:
        if (r3 == false) goto L44;
        k0 r13 = this.l;
        if (r13 == null) goto L41;
        y1 r14 = r13.b;
    L42:
        if (r14 != null) goto L44;
        return null;
    L41:
        r14 = null;
    L44:
        Gson r15 = (Gson) this.a.getValue();
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L47
        Object r17 = Result.constructor-impl(xt7.d.b.a(kuc.a.d(k0.Companion.serializer()), r12));     // Catch: Throwable -> L47
    L50:
        if (Result.isFailure-impl(r17) == true) goto L53;
        r1 = r17;
    L53:
        String r18 = (String) r1;
        FLogger.a.i(this.m, "collectData, result=" + r18);
        return r18;
    L47:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L50
    L35:
        if (r4.isEmpty() == false) goto L37;
    L30:
        r11 = r4;
        goto L31
    L24:
        if (r4.isEmpty() == true) goto L27;
        r10 = false;
        goto L28
    L32:
        r12 = null;
        goto L33
    L19:
        r4 = null;
        goto L20
    }

    public o() {
        this.m = "TextListSelectorController";
    }

    @Override // up8.b
    public final boolean j() {
        return this.n;
    }

    @Override // up8.b
    public /* bridge */ /* synthetic */ AbsInstructionWidget e(Context r1) {
        return s(r1);
    }

    @Override // up8.b
    public final a0 n(String r6) {
        boolean r0 = true;
        if (r6 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        Gson r3 = (Gson) this.a.getValue();
        List r4 = null;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L21
        k0 r7 = (k0) xt7.d.b.c(kuc.a.d(k0.Companion.serializer()), r6);     // Catch: Throwable -> L21
        if (r7 != null) goto L16;
        r7 = null;
    L19:
        Object r8 = Result.constructor-impl(r7);     // Catch: Throwable -> L21
    L23:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 != null) goto L40;
        k0 r10 = (k0) r8;
        if (r10 == null) goto L28;
        r4 = r10.c;
    L28:
        List r11 = r4;
        if (r11 != null) goto L31;
    L34:
        if (r0 == true) goto L36;
        this.l = r10;
        return new a0(Boolean.TRUE, "");
    L36:
        return new a0(Boolean.FALSE, "text list option list is empty");
    L31:
        if (r11.isEmpty() == true) goto L34;
        r0 = false;
        goto L34
    L40:
        return new a0(Boolean.FALSE, r9.getMessage());
    L16:
        if (getType() != 13) goto L19;
        r7.d = -1;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    L11:
        return new a0(Boolean.FALSE, "text list selector is empty template");
    L5:
        if (r6.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public TextListSelectorWidget s(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new TextListSelectorWidget(r2);
    }

    @Override // up8.b
    public final void k(String r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "defaultStateTemplate");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r11 = Result.constructor-impl((k0) xt7.d.b.c(k0.Companion.serializer(), r9));     // Catch: Throwable -> L5
    L7:
        k0 r1 = null;
        if (Result.isFailure-impl(r11) == false) goto L10;
        r11 = null;
    L10:
        k0 r12 = (k0) r11;
        int r2 = -1;
        if (r12 != null) goto L13;
    L16:
        if (r1 != null) goto L18;
        return;
    L18:
        List r13 = r1.c;
        if (r13 == null) goto L34;
        Iterator r14 = r13.iterator();
    L22:
        if (r14.hasNext() == false) goto L34;
        y1 r3 = (y1) r14.next();
        k0 r4 = this.l;
        if (r4 == null) goto L22;
        List r5 = r4.c;
        if (r5 == null) goto L22;
        Iterator r6 = r5.iterator();
    L29:
        if (r6.hasNext() == false) goto L22;
        y1 r7 = (y1) r6.next();
        if (Intrinsics.areEqual(r7.a, r3.a) == true) goto L32;
        r7.g = 0;
        goto L29
    L32:
        r7.g = 1;
    L34:
        k0 r15 = this.l;
        if (r15 == null) goto L51;
        List r16 = r15.c;
        if (r16 == null) goto L51;
        Iterator r17 = r16.iterator();
        int r8 = 0;
    L40:
        if (r17.hasNext() == false) goto L51;
        Integer r18 = ((y1) r17.next()).g;
        if (r18 != null) goto L45;
    L47:
        boolean r19 = false;
    L48:
        if (r19 == true) goto L49;
        r8 = r8 + 1;
        goto L40
    L49:
        r2 = r8;
        goto L51
    L45:
        if (r18.intValue() != 1) goto L47;
        r19 = true;
    L51:
        if (r2 < 0) goto L71;
        if (r10 == false) goto L72;
        this.n = true;
        return;
    L72:
        return;
    L71:
        return;
    L13:
        if (getType() != 13) goto L15;
        r12.d = -1;
    L15:
        r1 = r12;
    L5:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
