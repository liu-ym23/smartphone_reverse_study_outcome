package com.larus.agents.impl.ui;

import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.widget.AppCompatImageView;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.agents.impl.databinding.LarusFragmentWorkExperienceEditorBinding;
import com.larus.agents.impl.experience.WorkExperienceMutationResult;
import com.larus.agents.impl.network.CachedWorkExperienceRepository;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
@DebugMetadata(c = "com.larus.agents.impl.ui.WorkExperienceEditorFragment$save$1", f = "WorkExperienceEditorFragment.kt", i = {}, l = {227, 229}, m = "invokeSuspend", n = {}, s = {})
final class WorkExperienceEditorFragment$save$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.agents.impl.experience.p $draft;
    int label;
    final /* synthetic */ WorkExperienceEditorFragment this$0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[WorkExperienceMutationResult.values().length];
            r0[WorkExperienceMutationResult.SECURITY_RISK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[WorkExperienceMutationResult.DUPLICATE_NAME.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[WorkExperienceMutationResult.SUCCESS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[WorkExperienceMutationResult.FAILURE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public WorkExperienceEditorFragment$save$1(WorkExperienceEditorFragment r1, com.larus.agents.impl.experience.p r2, Continuation<? super WorkExperienceEditorFragment$save$1> r3) {
        this.this$0 = r1;
        this.$draft = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new WorkExperienceEditorFragment$save$1(this.this$0, this.$draft, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static void INVOKEVIRTUAL_com_larus_agents_impl_ui_WorkExperienceEditorFragment$save$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(WorkExperienceEditorFragment r1) {
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

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r7);
    L19:
        WorkExperienceMutationResult r8 = (WorkExperienceMutationResult) r7;
    L20:
        WorkExperienceEditorFragment r2 = this.this$0;
        LarusFragmentWorkExperienceEditorBinding r3 = r2.f;
        if (r3 != null) goto L25;
        return Unit.INSTANCE;
    L25:
        if (r8 != WorkExperienceMutationResult.SUCCESS) goto L27;
        r2.getParentFragmentManager().setFragmentResult("work_experience_changed", Bundle.EMPTY);
        t19.s r9 = t19.s.a;
        Context r4 = this.this$0.getContext();
        r9.getClass();
        t19.s.o(r4, 2131907647, false);
        INVOKEVIRTUAL_com_larus_agents_impl_ui_WorkExperienceEditorFragment$save$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(this.this$0);
    L45:
        return Unit.INSTANCE;
    L27:
        r2.i = false;
        AppCompatImageView r5 = r3.b;
        if (r5 == null) goto L30;
        r5.setEnabled(true);
    L30:
        this.this$0.aa0(false, false);
        t19.s r6 = t19.s.a;
        Context r10 = this.this$0.getContext();
        int r11 = a.a[r8.ordinal()];
        if (r11 == 1) goto L42;
        if (r11 != 2) goto L34;
        int r12 = 2131907644;
    L43:
        r6.getClass();
        t19.s.s(r10, r12);
        goto L45
    L34:
        if (r11 != 3) goto L36;
    L40:
        r12 = 2131907645;
        goto L43
    L36:
        if (r11 == 4) goto L40;
        throw new NoWhenBranchMatchedException();
    L42:
        r12 = 2131907646;
        goto L43
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
    L15:
        r8 = (WorkExperienceMutationResult) r7;
        goto L20
    L10:
        ResultKt.throwOnFailure(r7);
        WorkExperienceEditorFragment r13 = this.this$0;
        int r14 = WorkExperienceEditorFragment.k;
        String r15 = r13.Z90();
        if (r15 != null) goto L16;
        CachedWorkExperienceRepository r16 = this.this$0.g;
        com.larus.agents.impl.experience.p r17 = this.$draft;
        this.label = 1;
        r7 = r16.a(r17, this);
        if (r7 != r0) goto L15;
        return r0;
    L16:
        CachedWorkExperienceRepository r19 = this.this$0.g;
        com.larus.agents.impl.experience.p r20 = this.$draft;
        this.label = 2;
        r7 = r19.update(r15, r20, this);
        if (r7 != r0) goto L19;
        return r0;
    }
}
