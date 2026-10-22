package com.larus.dora.impl.device.settings.lab.headdown;

import android.content.Context;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.common_ui.dialog.CommonDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class f<T> implements FlowCollector {
    public final /* synthetic */ HeadDownDetectionFragment a;

    public f(HeadDownDetectionFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r5, Continuation r6) {
        b r7 = (b) r5;
        if (Intrinsics.areEqual(r7, b.a.a) == false) goto L8;
        FragmentActivity r8 = this.a.getActivity();
        if (r8 == null) goto L30;
        r8.finish();
    L30:
        return Unit.INSTANCE;
    L8:
        if (Intrinsics.areEqual(r7, b.c.a) == false) goto L11;
        s r9 = s.a;
        Context r10 = this.a.getContext();
        r9.getClass();
        s.s(r10, 2131902985);
        goto L30
    L11:
        if (Intrinsics.areEqual(r7, b.C0050b.a) == false) goto L32;
        HeadDownDetectionFragment r11 = this.a;
        int r12 = HeadDownDetectionFragment.i;
        if (r11.getChildFragmentManager().isStateSaved() == true) goto L30;
        CommonDialog r13 = r11.g;
        if (r13 != null) goto L36;
    L23:
        CommonDialog.a r14 = new CommonDialog.a();
        r14.g(r11.getString(2131902985));
        CommonDialog.a.f(r14, new h(r11), r11.getString(2131902762), false, 12);
        r14.q = ContextCompat.getColor(r11.requireContext(), 2131103136);
        r14.z = false;
        r14.A = false;
        CommonDialog r15 = r14.a();
        FragmentManager r0 = r11.getChildFragmentManager();
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r15, null, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r0, r15, r1) == false) goto L34;
    L28:
        r11.g = r15;
        goto L30
    L34:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L33
    L27:
        r15.show(r0, null);
        goto L28
    L36:
        r13.dismissAllowingStateLoss();     // Catch: Exception -> L19
    L19:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r16 = DialogFragmentLancet.sLastShowStack;
        if (r16 == null) goto L23;
        com.bytedance.crash.d.d(r16, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L23
    L32:
        throw new NoWhenBranchMatchedException();
    }
}
