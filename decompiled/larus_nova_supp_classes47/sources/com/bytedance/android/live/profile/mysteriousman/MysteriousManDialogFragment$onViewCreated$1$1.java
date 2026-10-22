package com.bytedance.android.live.profile.mysteriousman;

import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class MysteriousManDialogFragment$onViewCreated$1$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public MysteriousManDialogFragment$onViewCreated$1$1(MysteriousManDialogFragment r8) {
        super(0, r8, MysteriousManDialogFragment.class, "dismiss", "dismiss()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m19invoke() {
        INVOKEVIRTUAL_com_bytedance_android_live_profile_mysteriousman_MysteriousManDialogFragment$onViewCreated$1$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismiss((MysteriousManDialogFragment) ((CallableReference) this).receiver);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m19invoke();
        return Unit.INSTANCE;
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_live_profile_mysteriousman_MysteriousManDialogFragment$onViewCreated$1$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismiss(MysteriousManDialogFragment r1) {
        r1.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }
}
