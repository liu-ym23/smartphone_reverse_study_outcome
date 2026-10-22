package xs8;

import android.content.Context;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.bmhome.view.actionbar.edit.component.CommandWidget;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import wa8.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e extends up8.b {
    public final int l;
    public com.larus.bmhome.actionbar.model.c m;
    public boolean n;

    public e() {
        this(0);
    }

    @Override // up8.d
    public final boolean a() {
        return false;
    }

    @Override // up8.b
    public int getType() {
        return 0;
    }

    @Override // up8.b
    public final int i() {
        return 5;
    }

    @Override // up8.d
    public final String g() {
        Object r1 = null;
        if (this.m != null) goto L6;
        return null;
    L6:
        if (this.n == true) goto L18;
        return null;
    L18:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L10
        Object r2 = Result.constructor-impl(xt7.d.b.a(kuc.a.d(com.larus.bmhome.actionbar.model.c.Companion.serializer()), this.m));     // Catch: Throwable -> L10
    L13:
        if (Result.isFailure-impl(r2) == true) goto L17;
        r1 = r2;
    L17:
        return (String) r1;
    L10:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public final void s() {
        up8.b r0 = this.f;
        if (r0 == null) goto L12;
        List<up8.b> r1 = r0.f();
        if (r1 == null) goto L12;
        Iterator<T> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L12;
        up8.b r3 = (up8.b) r2.next();
        if ((r3 instanceof e) == false) goto L8;
        ((e) r3).n = false;
    L12:
        this.n = true;
    }

    public e(int r1) {
        this.l = -1;
    }

    @Override // up8.b
    public final AbsInstructionWidget e(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new CommandWidget(r2);
    }

    @Override // up8.b
    public final a0 n(String r6) {
        boolean r0 = true;
        if (r6 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L14
        Object r7 = Result.constructor-impl((com.larus.bmhome.actionbar.model.c) xt7.d.b.c(com.larus.bmhome.actionbar.model.c.Companion.serializer(), r6));     // Catch: Throwable -> L14
    L16:
        Throwable r4 = Result.exceptionOrNull-impl(r7);
        if (r4 != null) goto L37;
        com.larus.bmhome.actionbar.model.c r8 = (com.larus.bmhome.actionbar.model.c) r7;
        if (r8 == null) goto L21;
        this.m = r8;
        String r5 = r8.b;
        if (r5 != null) goto L25;
    L28:
        if (r0 == true) goto L30;
        String r9 = r8.d;
        if (CollectionsKt.contains(CollectionsKt.listOf(new String[]{"sync_calendar", "universal_camera", "send_user_message", "single_file", "paste_url"}), r9) == false) goto L35;
    L35:
        return new a0(Boolean.TRUE, 2);
    L30:
        return new a0(Boolean.FALSE, "display text is empty");
    L25:
        if (r5.length() == 0) goto L28;
        r0 = false;
        goto L28
    L21:
        return new a0(Boolean.FALSE, "parse template result is null");
    L37:
        return new a0(Boolean.FALSE, r4.getMessage());
    L14:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L11:
        return new a0(Boolean.FALSE, "text template is empty");
    L5:
        if (r6.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    @Override // up8.b
    public final void p(boolean r2) {
        com.larus.bmhome.actionbar.model.c r0 = this.m;
        if (r0 == null) goto L6;
        r0.k = r2;
        return;
    }

    @Override // up8.b
    public final void k(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "defaultStateTemplate");
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L5
        Object r5 = Result.constructor-impl((com.larus.bmhome.actionbar.model.c) xt7.d.b.c(com.larus.bmhome.actionbar.model.c.Companion.serializer(), r2));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r5) == false) goto L10;
        r5 = null;
    L10:
        com.larus.bmhome.actionbar.model.c r6 = (com.larus.bmhome.actionbar.model.c) r5;
        if (r6 != null) goto L13;
        return;
    L13:
        this.m = r6;
        return;
    L5:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
