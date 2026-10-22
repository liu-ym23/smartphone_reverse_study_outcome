package com.larus.chat.gallery.impl.preview.toolbar.action;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.tipoff.TipOffDialogParams;
import com.larus.platform.spi.IAIChatService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import jr9.a;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g0 implements com.larus.bmhome.share.panel.d {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ FragmentManager c;
    public final /* synthetic */ Ref.ObjectRef<Function0<Unit>> d;

    @Override // com.larus.bmhome.share.panel.d
    public final boolean d(String r1, String r2, Boolean r3) {
        return true;
    }

    @Override // com.larus.bmhome.share.panel.d
    public final void f() {
    }

    @Override // com.larus.bmhome.share.panel.d
    public final void onDismiss() {
        Ref.ObjectRef<Function0<Unit>> r0 = this.d;
        Function0 r1 = (Function0) r0.element;
        r0.element = null;
        if (r1 == null) goto L6;
        r1.invoke();
        return;
    }

    @Override // com.larus.bmhome.share.panel.d
    public final void e(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.d.element = r2;
    }

    public g0(String r1, String r2, FragmentManager r3, Ref.ObjectRef<Function0<Unit>> r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.share.panel.d
    public final boolean b(Context r41, DialogFragment r42, View r43, a r44) {
        Intrinsics.checkNotNullParameter(r44, "shareItemConfig");
        String r6 = this.a;
        String r3 = this.b;
        FragmentManager r15 = this.c;
        Ref.ObjectRef<Function0<Unit>> r14 = this.d;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L49
        String r7 = "report";
        if (Intrinsics.areEqual(r44.b(), "report") == false) goto L47;
        FLogger.a.i("ShareAction", "buildReportCallback: 拦截 REPORT 点击, creationId=" + r6 + ", messageId=" + r3);     // Catch: Throwable -> L49
        if (r6 != null) goto L8;
    L11:
        boolean r0 = true;
    L13:
        if (r0 == false) goto L15;
        r7 = null;
        String r4 = String.valueOf(r3);     // Catch: Throwable -> L44
        Intrinsics.checkNotNullParameter(r4, "entityId");     // Catch: Throwable -> L44
        TipOffDialogParams r8 = new TipOffDialogParams(2, r4, null, null, "", "", 0, null, null, null, null, null, null, null, null);     // Catch: Throwable -> L44
        r8.g = 0;     // Catch: Throwable -> L44
        TipOffDialogParams r9 = r8;
    L19:
        Fragment r10 = IAIChatService.a.g8(r9);     // Catch: Throwable -> L44
        if (r42 == null) goto L23;
        FragmentManager r16 = r42.getParentFragmentManager();     // Catch: Throwable -> L44
        if (r16 == null) goto L23;
    L25:
        if ((r10 instanceof Fragment) == false) goto L27;
        Fragment r1 = r10;
    L28:
        LandscapeRestrictionOperation r11 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Throwable -> L44
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r1, null, r11);     // Catch: Throwable -> L44
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r16, r1, r11) == false) goto L57;
    L33:
        if (r42 != null) goto L61;
    L41:
        Function0 r2 = (Function0) r14.element;     // Catch: Throwable -> L44
        r14.element = null;     // Catch: Throwable -> L44
        if (r2 == null) goto L46;
        r2.invoke();     // Catch: Throwable -> L44
    L46:
        return true;
    L61:
        r42.dismiss();     // Catch: Exception -> L36 Throwable -> L44
    L36:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");     // Catch: Throwable -> L44
        Throwable r12 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L44
        if (r12 == null) goto L41;
        com.bytedance.crash.d.d(r12, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L44
        goto L41
    L57:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L56 Throwable -> L44
    L32:
        r10.show(r16, null);     // Catch: Throwable -> L44
        goto L33
    L27:
        r1 = null;
    L23:
        r16 = r15;
        goto L25
    L15:
        Intrinsics.checkNotNullParameter(r6, "entityId");     // Catch: Throwable -> L49
        r9 = new TipOffDialogParams(8, r6, null, null, "", "", 0, null, null, null, null, null, null, null, null);     // Catch: Throwable -> L49
        r7 = null;
        r9.g = 0;     // Catch: Throwable -> L44
        goto L19
    L8:
        if (r6.length() == 0) goto L11;
        r0 = false;
        goto L13
    L47:
        boolean r13 = 0;
        Object r17 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L44
    L52:
        Throwable r18 = Result.exceptionOrNull-impl(r17);
        if (r18 == null) goto L55;
        FLogger.a.e("ShareAction", "buildReportCallback: intercept error", r18);
    L55:
        return r13;
    L44:
        th = th;
        String r19 = r7;
    L51:
        Result.Companion r20 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        r13 = r19;
    L49:
        th = th;
        r19 = null;
        goto L51
    }
}
