package hs9;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.share.panel.d;
import com.larus.bmhome.tipoff.TipOffDialogParams;
import com.larus.platform.spi.IAIChatService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b implements d {
    public final String a;

    public final boolean d(String r1, String r2, Boolean r3) {
        return true;
    }

    public final void f() {
    }

    public final void onDismiss() {
    }

    public b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "creationId");
        this.a = r2;
    }

    public final void e(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
    }

    public final boolean b(Context r22, DialogFragment r23, View r24, jr9.a r25) {
        Intrinsics.checkNotNullParameter(r25, "shareItemConfig");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L34
        if (Intrinsics.areEqual(r25.b(), "report") == false) goto L30;
        IAIChatService.Companion r1 = IAIChatService.a;     // Catch: Throwable -> L34
        String r5 = this.a;     // Catch: Throwable -> L32
        Intrinsics.checkNotNullParameter(r5, "entityId");     // Catch: Throwable -> L32
        TipOffDialogParams r15 = new TipOffDialogParams(8, r5, null, null, "", "", 0, null, null, null, null, null, null, null, null);     // Catch: Throwable -> L32
        r15.g = 0;     // Catch: Throwable -> L32
        Fragment r2 = r1.g8(r15);     // Catch: Throwable -> L32
        if (r23 == null) goto L20;
        FragmentManager r3 = r23.getParentFragmentManager();     // Catch: Throwable -> L32
        if (r3 == null) goto L20;
        if ((r2 instanceof Fragment) == false) goto L14;
        Fragment r4 = r2;
    L15:
        LandscapeRestrictionOperation r6 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Throwable -> L32
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r4, null, r6);     // Catch: Throwable -> L32
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r4, r6) == true) goto L20;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L41 Throwable -> L32
    L19:
        r2.show(r3, null);     // Catch: Throwable -> L32
        goto L20
    L14:
        r4 = null;
    L20:
        if (r23 == null) goto L49;
        r23.dismiss();     // Catch: Exception -> L23 Throwable -> L32
    L51:
        return true;
    L23:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");     // Catch: Throwable -> L32
        Throwable r7 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L32
        if (r7 == null) goto L50;
        com.bytedance.crash.d.d(r7, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L32
        return true;
    L50:
        return true;
    L49:
        return true;
    L30:
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L32
    L37:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L40;
        FLogger.a.e("MusicShareApi", "Save music video error state ", r9);
    L40:
        return false;
    L32:
        th = th;
    L36:
        Result.Companion r10 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
    L34:
        th = th;
        goto L36
    }
}
