package xs8;

import android.content.Context;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.bmhome.view.actionbar.edit.component.ButtonRouterWidget;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import wa8.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a extends up8.b {
    public com.larus.bmhome.actionbar.model.a l;

    @Override // up8.b
    public int getType() {
        return 16;
    }

    @Override // up8.b
    public final int i() {
        return 7;
    }

    @Override // up8.d
    public final boolean a() {
        com.larus.bmhome.actionbar.model.a r0 = this.l;
        if (r0 == null) goto L28;
        String r2 = null;
        if (r0 == null) goto L7;
        String r1 = r0.b;
    L9:
        if (r1 != null) goto L11;
    L14:
        boolean r3 = true;
    L15:
        if (r3 == true) goto L29;
        com.larus.bmhome.actionbar.model.a r4 = this.l;
        if (r4 == null) goto L19;
        r2 = r4.c;
    L19:
        if (r2 != null) goto L21;
    L24:
        boolean r5 = true;
    L25:
        if (r5 == true) goto L30;
        return true;
    L30:
        return false;
    L21:
        if (r2.length() == 0) goto L24;
        r5 = false;
        goto L25
    L29:
        return false;
    L11:
        if (r1.length() == 0) goto L14;
        r3 = false;
        goto L15
    L7:
        r1 = null;
        goto L9
    L28:
        return false;
    }

    @Override // up8.d
    public final String g() {
        com.larus.bmhome.actionbar.model.a r0 = this.l;
        Object r1 = null;
        if (r0 != null) goto L15;
        return null;
    L15:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L7
        Object r3 = Result.constructor-impl(xt7.d.b.a(com.larus.bmhome.actionbar.model.a.Companion.serializer(), r0));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r3) == true) goto L14;
        r1 = r3;
    L14:
        return (String) r1;
    L7:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public a() {
    }

    @Override // up8.b
    public final AbsInstructionWidget e(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new ButtonRouterWidget(r2);
    }

    @Override // up8.b
    public final void m(Map<String, ?> r4) {
        Intrinsics.checkNotNullParameter(r4, "instructionDefaultParams");
        Intrinsics.checkNotNullParameter(r4, "instructionDefaultParams");
        FLogger.a.d("ButtonRouterController", "Restoring button router state by default params: " + r4);
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
        Object r7 = Result.constructor-impl((com.larus.bmhome.actionbar.model.a) xt7.d.b.c(com.larus.bmhome.actionbar.model.a.Companion.serializer(), r6));     // Catch: Throwable -> L14
    L16:
        Throwable r4 = Result.exceptionOrNull-impl(r7);
        if (r4 != null) goto L41;
        com.larus.bmhome.actionbar.model.a r8 = (com.larus.bmhome.actionbar.model.a) r7;
        if (r8 == null) goto L21;
        String r5 = r8.b;
    L22:
        if (r5 != null) goto L24;
    L27:
        boolean r9 = true;
    L28:
        if (r9 == true) goto L40;
        String r10 = r8.c;
        if (r10 != null) goto L32;
    L35:
        if (r0 == true) goto L40;
        this.l = r8;
        FLogger.a.d("ButtonRouterController", "Button router template parsed successfully: " + r8);
        return new a0(Boolean.TRUE, "");
    L32:
        if (r10.length() == 0) goto L35;
        r0 = false;
    L40:
        return new a0(Boolean.FALSE, "ButtonRouter info is required displayText=" + r8.b + " schema=" + r8.c);
    L24:
        if (r5.length() == 0) goto L27;
        r9 = false;
        goto L28
    L21:
        r5 = null;
        goto L22
    L41:
        FLogger.a.e("ButtonRouterController", "Failed to parse button router template: " + r4.getMessage());
        return new a0(Boolean.FALSE, "Failed to parse button router template: " + r4.getMessage());
    L14:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L11:
        return new a0(Boolean.FALSE, "Button router template is empty");
    L5:
        if (r6.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    @Override // up8.b
    public final void k(String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "defaultStateTemplate");
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L5
        Object r7 = Result.constructor-impl((com.larus.bmhome.actionbar.model.a) xt7.d.b.c(com.larus.bmhome.actionbar.model.a.Companion.serializer(), r4));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r7) == false) goto L10;
        r7 = null;
    L10:
        com.larus.bmhome.actionbar.model.a r8 = (com.larus.bmhome.actionbar.model.a) r7;
        if (r8 != null) goto L14;
        FLogger.a.w("ButtonRouterController", "Failed to restore button router state");
        return;
    L14:
        this.l = r8;
        FLogger.a.d("ButtonRouterController", "Button router state restored: " + r8);
        return;
    L5:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
