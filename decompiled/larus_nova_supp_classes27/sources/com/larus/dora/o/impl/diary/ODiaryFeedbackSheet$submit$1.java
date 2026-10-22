package com.larus.dora.o.impl.diary;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.oui.sheet.v2.OSheet;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.o.impl.diary.ODiaryFeedbackSheet$submit$1", f = "ODiaryFeedbackSheet.kt", i = {}, l = {126}, m = "invokeSuspend", n = {}, s = {})
final class ODiaryFeedbackSheet$submit$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $content;
    int label;
    final /* synthetic */ i0 this$0;

    public ODiaryFeedbackSheet$submit$1(i0 r1, String r2, Continuation<? super ODiaryFeedbackSheet$submit$1> r3) {
        this.this$0 = r1;
        this.$content = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ODiaryFeedbackSheet$submit$1(this.this$0, this.$content, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static void INVOKEVIRTUAL_com_larus_dora_o_impl_diary_ODiaryFeedbackSheet$submit$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(OSheet r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        boolean r11 = ((Boolean) r10).booleanValue();
        this.this$0.n = false;
        FLogger.a.i("ODiaryFeedbackSheet", "feedback submitted diary=" + this.this$0.c + " action=" + this.this$0.d + " ok=" + r11);
        i0 r2 = this.this$0;
        Function2<String, Boolean, Unit> r3 = r2.g;
        Context r4 = r2.a;
        if (r11 == false) goto L14;
        int r5 = 2131903890;
    L15:
        r3.invoke(r4.getString(r5), Boxing.boxBoolean(r11));
        if (r11 == false) goto L19;
        i0 r12 = this.this$0;
        r12.h.invoke(Boxing.boxInt(r12.d));
        INVOKEVIRTUAL_com_larus_dora_o_impl_diary_ODiaryFeedbackSheet$submit$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this.this$0.i);
    L19:
        return Unit.INSTANCE;
    L14:
        r5 = 2131903889;
        goto L15
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        DoraODiaryRepo r6 = DoraODiaryRepo.a;
        i0 r13 = this.this$0;
        String r7 = r13.c;
        int r8 = r13.d;
        List<String> r14 = CollectionsKt.toList(r13.j);
        String r9 = this.$content;
        Integer r15 = Boxing.boxInt(this.this$0.e);
        l0 r16 = this.this$0.f;
        this.label = 1;
        r10 = r6.i(r7, r8, r14, r9, r15, r16, this);
        if (r10 != r0) goto L11;
        return r0;
    }
}
