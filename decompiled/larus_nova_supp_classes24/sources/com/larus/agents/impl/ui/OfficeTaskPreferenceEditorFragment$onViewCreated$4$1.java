package com.larus.agents.impl.ui;

import android.content.Context;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.agents.api.OfficeTaskPreferenceSaveResult;
import com.larus.agents.api.OfficeTaskSettingsServiceDelegate;
import com.larus.agents.impl.databinding.LarusFragmentOfficeTaskPreferenceEditorBinding;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.concurrent.CancellationException;
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
@DebugMetadata(c = "com.larus.agents.impl.ui.OfficeTaskPreferenceEditorFragment$onViewCreated$4$1", f = "OfficeTaskPreferenceEditorFragment.kt", i = {}, l = {115}, m = "invokeSuspend", n = {}, s = {})
public final class OfficeTaskPreferenceEditorFragment$onViewCreated$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $instruction;
    final /* synthetic */ LarusFragmentOfficeTaskPreferenceEditorBinding $panelBinding;
    int label;
    final /* synthetic */ OfficeTaskPreferenceEditorFragment this$0;

    public OfficeTaskPreferenceEditorFragment$onViewCreated$4$1(String r1, OfficeTaskPreferenceEditorFragment r2, LarusFragmentOfficeTaskPreferenceEditorBinding r3, Continuation<? super OfficeTaskPreferenceEditorFragment$onViewCreated$4$1> r4) {
        this.$instruction = r1;
        this.this$0 = r2;
        this.$panelBinding = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new OfficeTaskPreferenceEditorFragment$onViewCreated$4$1(this.$instruction, this.this$0, this.$panelBinding, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L9;
        if (r2 != 1) goto L8;
        ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L17 Exception -> L19 CancellationException -> L46
    L13:
        OfficeTaskPreferenceSaveResult r7 = (OfficeTaskPreferenceSaveResult) r6;     // Catch: Throwable -> L17 Exception -> L19 CancellationException -> L46
        OfficeTaskPreferenceEditorFragment r0 = this.this$0;
        int r3 = OfficeTaskPreferenceEditorFragment.m;
        r0.dismissLoading();
        LarusFragmentOfficeTaskPreferenceEditorBinding r4 = this.this$0.f;
        LarusFragmentOfficeTaskPreferenceEditorBinding r5 = this.$panelBinding;
        if (r4 == r5) goto L23;
    L24:
        OfficeTaskPreferenceEditorFragment r8 = this.this$0;
        r8.getClass();
        int r9 = OfficeTaskPreferenceEditorFragment.b.a[r7.ordinal()];
        if (r9 != 1) goto L27;
        t19.s r10 = t19.s.a;
        Context r11 = r8.getContext();
        r10.getClass();
        t19.s.o(r11, 2131899418, false);
        r8.dismissAllowingStateLoss();     // Catch: Exception -> L40
    L45:
        return Unit.INSTANCE;
    L40:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r12 = DialogFragmentLancet.sLastShowStack;
        if (r12 == null) goto L45;
        com.bytedance.crash.d.d(r12, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L45
    L27:
        if (r9 != 2) goto L29;
        t19.s r13 = t19.s.a;
        Context r14 = r8.getContext();
        r13.getClass();
        t19.s.s(r14, 2131899416);
        goto L45
    L29:
        if (r9 != 3) goto L31;
        t19.s r15 = t19.s.a;
        Context r16 = r8.getContext();
        r15.getClass();
        t19.s.s(r16, 2131899417);
        goto L45
    L31:
        if (r9 != 4) goto L34;
        t19.s r17 = t19.s.a;
        Context r19 = r8.getContext();
        r17.getClass();
        t19.s.s(r19, 2131899415);
        goto L45
    L34:
        throw new NoWhenBranchMatchedException();
    L23:
        r5.d.setEnabled(true);
        this.$panelBinding.c.setEnabled(true);
        goto L24
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
        OfficeTaskSettingsServiceDelegate r20 = OfficeTaskSettingsServiceDelegate.a;     // Catch: Throwable -> L17 Exception -> L19 CancellationException -> L46
        String r21 = this.$instruction;     // Catch: Throwable -> L17 Exception -> L19 CancellationException -> L46
        this.label = 1;     // Catch: Throwable -> L17 Exception -> L19 CancellationException -> L46
        r6 = r20.a(r21, this);     // Catch: Throwable -> L17 Exception -> L19 CancellationException -> L46
        if (r6 != r1) goto L13;
        return r1;
    L17:
        th = move-exception;
        OfficeTaskPreferenceEditorFragment r22 = this.this$0;
        int r23 = OfficeTaskPreferenceEditorFragment.m;
        r22.dismissLoading();
        LarusFragmentOfficeTaskPreferenceEditorBinding r24 = this.this$0.f;
        LarusFragmentOfficeTaskPreferenceEditorBinding r25 = this.$panelBinding;
        if (r24 != r25) goto L51;
        r25.d.setEnabled(true);
        this.$panelBinding.c.setEnabled(true);
    L51:
        throw th;
    L46:
        e = move-exception;
        throw e;     // Catch: Throwable -> L17
    L19:
        e = move-exception;
        FLogger.a.e("OfficeTaskPreferenceEditorFragment", "save preference failed: ".concat(e.getClass().getSimpleName()));     // Catch: Throwable -> L17
        r7 = OfficeTaskPreferenceSaveResult.FAILURE;     // Catch: Throwable -> L17
        OfficeTaskPreferenceEditorFragment r26 = this.this$0;
        int r27 = OfficeTaskPreferenceEditorFragment.m;
        r26.dismissLoading();
        LarusFragmentOfficeTaskPreferenceEditorBinding r29 = this.this$0.f;
        r5 = this.$panelBinding;
        if (r29 != r5) goto L24;
        goto L23
    }
}
