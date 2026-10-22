package xs8;

import android.content.Context;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.bmhome.view.actionbar.edit.component.InputBoxWidget;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import wa8.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i extends up8.b {
    public com.larus.bmhome.actionbar.model.p l;
    public String m;

    @Override // up8.b
    public int getType() {
        return 3;
    }

    @Override // up8.d
    public final boolean a() {
        com.larus.bmhome.actionbar.model.p r0 = this.l;
        if (r0 == null) goto L5;
        boolean r1 = Intrinsics.areEqual(r0.b, Boolean.TRUE);
    L6:
        if (r1 == false) goto L19;
        String r2 = this.m;
        if (r2 != null) goto L10;
    L15:
        boolean r3 = false;
    L16:
        if (r3 == false) goto L20;
        return true;
    L20:
        return false;
    L10:
        if (r2.length() <= 0) goto L12;
        boolean r4 = true;
    L13:
        if (r4 != true) goto L15;
        r3 = true;
        goto L16
    L12:
        r4 = false;
        goto L13
    L19:
        return false;
    L5:
        r1 = false;
        goto L6
    }

    @Override // up8.d
    public final String g() {
        Object r1 = null;
        if (this.l != null) goto L15;
        return null;
    L15:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        Object r2 = Result.constructor-impl(xt7.d.b.a(kuc.a.d(com.larus.bmhome.actionbar.model.p.Companion.serializer()), this.l));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r2) == true) goto L14;
        r1 = r2;
    L14:
        return (String) r1;
    L7:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public i() {
    }

    @Override // up8.b
    public final AbsInstructionWidget e(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new InputBoxWidget(r2);
    }

    @Override // up8.b
    public final a0 n(String r3) {
        if (r3 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == true) goto L10;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L13
        Object r4 = Result.constructor-impl((com.larus.bmhome.actionbar.model.p) xt7.d.b.c(kuc.a.d(com.larus.bmhome.actionbar.model.p.Companion.serializer()), r3));     // Catch: Throwable -> L13
    L15:
        Throwable r2 = Result.exceptionOrNull-impl(r4);
        if (r2 != null) goto L20;
        this.l = (com.larus.bmhome.actionbar.model.p) r4;
        return new a0(Boolean.TRUE, "");
    L20:
        return new a0(Boolean.FALSE, r2.getMessage());
    L13:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L10:
        return new a0(Boolean.FALSE, "input box is empty template");
    L4:
        if (r3.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    @Override // up8.b
    public final void k(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "defaultStateTemplate");
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L5
        Object r5 = Result.constructor-impl((com.larus.bmhome.actionbar.model.p) xt7.d.b.c(com.larus.bmhome.actionbar.model.p.Companion.serializer(), r2));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r5) == false) goto L10;
        r5 = null;
    L10:
        com.larus.bmhome.actionbar.model.p r6 = (com.larus.bmhome.actionbar.model.p) r5;
        if (r6 != null) goto L13;
        return;
    L13:
        this.l = r6;
        return;
    L5:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
