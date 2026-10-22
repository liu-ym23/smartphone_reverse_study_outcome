package com.larus.agents.impl.ui;

import android.content.Context;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.agents.impl.databinding.LarusFragmentWorkExperienceDetailBinding;
import com.larus.agents.impl.network.CachedWorkExperienceRepository;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.agents.impl.ui.WorkExperienceDetailFragment$loadDetail$1", f = "WorkExperienceDetailFragment.kt", i = {1}, l = {70, 77}, m = "invokeSuspend", n = {"cachedDetail"}, s = {"L$0"})
final class WorkExperienceDetailFragment$loadDetail$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $experienceId;
    Object L$0;
    int label;
    final /* synthetic */ WorkExperienceDetailFragment this$0;

    public WorkExperienceDetailFragment$loadDetail$1(WorkExperienceDetailFragment r1, String r2, Continuation<? super WorkExperienceDetailFragment$loadDetail$1> r3) {
        this.this$0 = r1;
        this.$experienceId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new WorkExperienceDetailFragment$loadDetail$1(this.this$0, this.$experienceId, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static void INVOKEVIRTUAL_com_larus_agents_impl_ui_WorkExperienceDetailFragment$loadDetail$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(WorkExperienceDetailFragment r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        com.larus.agents.impl.experience.n r2 = (com.larus.agents.impl.experience.n) this.L$0;
        ResultKt.throwOnFailure(r8);
        Object r9 = ((Result) r8).unbox-impl();
    L23:
        if (Result.isFailure-impl(r9) == false) goto L25;
        r9 = null;
    L25:
        com.larus.agents.impl.experience.n r10 = (com.larus.agents.impl.experience.n) r9;
        LarusFragmentWorkExperienceDetailBinding r3 = this.this$0.f;
        if (r3 == null) goto L28;
        r3.e.setVisibility(8);
        if (r10 != null) goto L35;
        if (r2 != null) goto L34;
        t19.s r11 = t19.s.a;
        Context r4 = this.this$0.getContext();
        r11.getClass();
        t19.s.s(r4, 2131902015);
        INVOKEVIRTUAL_com_larus_agents_impl_ui_WorkExperienceDetailFragment$loadDetail$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(this.this$0);
    L34:
        return Unit.INSTANCE;
    L35:
        WorkExperienceDetailFragment.X90(this.this$0, r3, r10, true);
        return Unit.INSTANCE;
    L28:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
    L13:
        com.larus.agents.impl.experience.n r12 = (com.larus.agents.impl.experience.n) r8;
        if (r12 == null) goto L18;
        WorkExperienceDetailFragment r5 = this.this$0;
        LarusFragmentWorkExperienceDetailBinding r6 = r5.f;
        if (r6 == null) goto L18;
        WorkExperienceDetailFragment.X90(r5, r6, r12, false);
        r6.e.setVisibility(8);
    L18:
        CachedWorkExperienceRepository r7 = this.this$0.g;
        String r13 = this.$experienceId;
        this.L$0 = r12;
        this.label = 2;
        Object r14 = r7.c(r13, this);
        if (r14 != r0) goto L21;
        return r0;
    L21:
        r2 = r12;
        r9 = r14;
        goto L23
    L10:
        ResultKt.throwOnFailure(r8);
        CachedWorkExperienceRepository r15 = this.this$0.g;
        String r16 = this.$experienceId;
        this.label = 1;
        r8 = r15.k(r16, this);
        if (r8 != r0) goto L13;
        return r0;
    }
}
