package com.larus.agents.impl.ui;

import android.content.Context;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.agents.impl.databinding.LarusFragmentWorkExperienceEditorBinding;
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
@DebugMetadata(c = "com.larus.agents.impl.ui.WorkExperienceEditorFragment$loadDetail$1", f = "WorkExperienceEditorFragment.kt", i = {1}, l = {163, 170}, m = "invokeSuspend", n = {"cachedDetail"}, s = {"L$0"})
final class WorkExperienceEditorFragment$loadDetail$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $id;
    Object L$0;
    int label;
    final /* synthetic */ WorkExperienceEditorFragment this$0;

    public WorkExperienceEditorFragment$loadDetail$1(WorkExperienceEditorFragment r1, String r2, Continuation<? super WorkExperienceEditorFragment$loadDetail$1> r3) {
        this.this$0 = r1;
        this.$id = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new WorkExperienceEditorFragment$loadDetail$1(this.this$0, this.$id, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static void INVOKEVIRTUAL_com_larus_agents_impl_ui_WorkExperienceEditorFragment$loadDetail$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(WorkExperienceEditorFragment r1) {
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

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        com.larus.agents.impl.experience.n r2 = (com.larus.agents.impl.experience.n) this.L$0;
        ResultKt.throwOnFailure(r5);
        Object r6 = ((Result) r5).unbox-impl();
    L23:
        if (Result.isFailure-impl(r6) == false) goto L25;
        r6 = null;
    L25:
        com.larus.agents.impl.experience.n r7 = (com.larus.agents.impl.experience.n) r6;
        WorkExperienceEditorFragment r3 = this.this$0;
        LarusFragmentWorkExperienceEditorBinding r4 = r3.f;
        if (r4 != null) goto L30;
        return Unit.INSTANCE;
    L30:
        if (r3.i == true) goto L32;
        if (r7 != null) goto L38;
        if (r2 != null) goto L37;
        t19.s r8 = t19.s.a;
        Context r9 = r3.getContext();
        r8.getClass();
        t19.s.s(r9, 2131902015);
        INVOKEVIRTUAL_com_larus_agents_impl_ui_WorkExperienceEditorFragment$loadDetail$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(this.this$0);
    L37:
        return Unit.INSTANCE;
    L38:
        WorkExperienceEditorFragment.X90(r3, r4, r7);
        this.this$0.aa0(false, false);
        return Unit.INSTANCE;
    L32:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
    L13:
        com.larus.agents.impl.experience.n r10 = (com.larus.agents.impl.experience.n) r5;
        if (r10 == null) goto L18;
        WorkExperienceEditorFragment r11 = this.this$0;
        LarusFragmentWorkExperienceEditorBinding r12 = r11.f;
        if (r12 == null) goto L18;
        WorkExperienceEditorFragment.X90(r11, r12, r10);
        r12.g.setVisibility(8);
    L18:
        CachedWorkExperienceRepository r13 = this.this$0.g;
        String r14 = this.$id;
        this.L$0 = r10;
        this.label = 2;
        Object r15 = r13.c(r14, this);
        if (r15 != r0) goto L21;
        return r0;
    L21:
        r2 = r10;
        r6 = r15;
        goto L23
    L10:
        ResultKt.throwOnFailure(r5);
        CachedWorkExperienceRepository r16 = this.this$0.g;
        String r17 = this.$id;
        this.label = 1;
        r5 = r16.k(r17, this);
        if (r5 != r0) goto L13;
        return r0;
    }
}
