package com.larus.bmhome.chat.deepresearch.component;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.DialogFragment;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.deepresearch.DeepReSearchParam;
import com.larus.bmhome.chat.deepresearch.network.PreloadDeepResearchShareHelper;
import com.larus.bmhome.share.api.IShareService;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.im.bean.bot.BotModel;
import com.larus.network.bean.BizResponse;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.deepresearch.component.DeepReSearchTitleComponent$performShare$1$onInterceptClick$1", f = "DeepReSearchTitleComponent.kt", i = {}, l = {92}, m = "invokeSuspend", n = {}, s = {})
public final class DeepReSearchTitleComponent$performShare$1$onInterceptClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ jr9.a $shareItemConfig;
    int label;
    final /* synthetic */ DeepReSearchTitleComponent this$0;

    public DeepReSearchTitleComponent$performShare$1$onInterceptClick$1(DeepReSearchTitleComponent r1, Context r2, jr9.a r3, Continuation<? super DeepReSearchTitleComponent$performShare$1$onInterceptClick$1> r4) {
        this.this$0 = r1;
        this.$context = r2;
        this.$shareItemConfig = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DeepReSearchTitleComponent$performShare$1$onInterceptClick$1(this.this$0, this.$context, this.$shareItemConfig, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static void INVOKEVIRTUAL_com_larus_bmhome_chat_deepresearch_component_DeepReSearchTitleComponent$performShare$1$onInterceptClick$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(DialogFragment r1) {
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

    public static void INVOKEVIRTUAL_com_larus_bmhome_chat_deepresearch_component_DeepReSearchTitleComponent$performShare$1$onInterceptClick$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(com.larus.common_ui.dialog.l0 r3) {
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

    public final Object invokeSuspend(Object r39) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        String r4 = null;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r39);
        Object r3 = r39;
    L19:
        BizResponse r5 = (BizResponse) r3;
        if (r5.isSuccess() == false) goto L60;
        com.larus.bmhome.chat.deepresearch.network.a r6 = (com.larus.bmhome.chat.deepresearch.network.a) r5.getData();
        if (r6 == null) goto L24;
        String r7 = r6.a();
    L26:
        if (o0.d(r7) == false) goto L60;
        FLogger.a.d(this.this$0.m, "[biz_deep_search] performShareLink -> " + r5 + ".data?.shareUrl ");
        ShareServiceDelegate r8 = ShareServiceDelegate.b;
        Context r9 = this.$context;
        String r10 = this.$shareItemConfig.b();
        String r11 = this.$shareItemConfig.c();
        com.larus.bmhome.chat.deepresearch.network.a r12 = (com.larus.bmhome.chat.deepresearch.network.a) r5.getData();
        if (r12 == null) goto L30;
        String r13 = r12.a();
    L31:
        com.larus.bmhome.chat.deepresearch.network.a r14 = (com.larus.bmhome.chat.deepresearch.network.a) r5.getData();
        if (r14 == null) goto L34;
        String r15 = r14.c();
    L36:
        if (o0.d(r15) == true) goto L39;
        r15 = null;
    L39:
        if (r15 != null) goto L45;
        Context r16 = s1a.a.c(this.this$0).getContext();
        DeepReSearchParam r17 = this.this$0.Y2();
        if (r17 == null) goto L43;
        BotModel r18 = r17.g;
    L44:
        r15 = r8.p(r16, r18);
        goto L45
    L43:
        r18 = null;
    L45:
        String r19 = r15;
        com.larus.bmhome.chat.deepresearch.network.a r20 = (com.larus.bmhome.chat.deepresearch.network.a) r5.getData();
        if (r20 == null) goto L48;
        String r21 = r20.b();
    L50:
        if (o0.d(r21) == true) goto L53;
        r21 = null;
    L53:
        if (r21 != null) goto L58;
        Context r22 = this.$context;
        if (r22 == null) goto L57;
        r4 = r22.getString(2131909359);
    L57:
        String r110 = r4;
    L59:
        IShareService.a.d(r8, r9, r10, r11, new com.larus.bmhome.share.panel.b(null, null, r13, null, null, null, null, r19, r110, null, null, null, null, null, null, null, false, false, null, null, false, false, null, false, null, null, 67108475), null, 48);
    L61:
        INVOKEVIRTUAL_com_larus_bmhome_chat_deepresearch_component_DeepReSearchTitleComponent$performShare$1$onInterceptClick$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss((com.larus.common_ui.dialog.l0) this.this$0.s.getValue());
        DialogFragment r23 = this.this$0.t;
        if (r23 == null) goto L65;
        INVOKEVIRTUAL_com_larus_bmhome_chat_deepresearch_component_DeepReSearchTitleComponent$performShare$1$onInterceptClick$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(r23);
    L65:
        return Unit.INSTANCE;
    L58:
        r110 = r21;
        goto L59
    L48:
        r21 = null;
        goto L50
    L34:
        r15 = null;
        goto L36
    L30:
        r13 = null;
        goto L31
    L24:
        r7 = null;
    L60:
        t19.s.a.g(this.$context, 2131900870, false);
        goto L61
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r39);
        DeepReSearchTitleComponent r24 = this.this$0;
        int r25 = DeepReSearchTitleComponent.u;
        PreloadDeepResearchShareHelper r26 = r24.h3();
        DeepReSearchParam r27 = this.this$0.Y2();
        if (r27 == null) goto L11;
        String r28 = r27.l;
    L12:
        DeepReSearchParam r29 = this.this$0.Y2();
        if (r29 == null) goto L15;
        String r30 = r29.a;
    L16:
        com.larus.bmhome.chat.deepresearch.network.b r31 = new com.larus.bmhome.chat.deepresearch.network.b(r28, r30);
        this.label = 1;
        r3 = r26.b(r31, this);
        if (r3 != r1) goto L19;
        return r1;
    L15:
        r30 = null;
        goto L16
    L11:
        r28 = null;
        goto L12
    }
}
