package com.larus.bmhome.bot.share;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common_ui.dialog.l0;
import com.larus.im.bean.bot.BotModel;
import com.larus.utils.logger.FLogger;
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
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.bot.share.ShareBotController$performShareBot$1$onInterceptClick$1", f = "ShareBotController.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
public final class ShareBotController$performShareBot$1$onInterceptClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BotModel $botModel;
    final /* synthetic */ Context $context;
    final /* synthetic */ wc9.e $conversation;
    final /* synthetic */ jr9.a $shareItemConfig;
    int label;
    final /* synthetic */ ShareBotController this$0;

    public ShareBotController$performShareBot$1$onInterceptClick$1(ShareBotController r1, Context r2, jr9.a r3, wc9.e r4, BotModel r5, Continuation<? super ShareBotController$performShareBot$1$onInterceptClick$1> r6) {
        this.this$0 = r1;
        this.$context = r2;
        this.$shareItemConfig = r3;
        this.$conversation = r4;
        this.$botModel = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ShareBotController$performShareBot$1$onInterceptClick$1(this.this$0, this.$context, this.$shareItemConfig, this.$conversation, this.$botModel, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static void INVOKEVIRTUAL_com_larus_bmhome_bot_share_ShareBotController$performShareBot$1$onInterceptClick$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(l0 r3) {
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
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        i r11 = (i) r10;
        Fragment r3 = this.this$0.a;     // Catch: IllegalArgumentException -> L32
        if (r3 == null) goto L19;
        FragmentActivity r4 = r3.getActivity();     // Catch: IllegalArgumentException -> L32
        if (r4 == null) goto L19;
        if (r4.isFinishing() == true) goto L19;
        boolean r5 = true;
    L20:
        if (r5 == false) goto L35;
        FragmentActivity r6 = this.this$0.a.getActivity();     // Catch: IllegalArgumentException -> L32
        if (r6 != null) goto L24;
    L26:
        r2 = false;
    L27:
        if (r2 == false) goto L35;
        l0 r7 = (l0) this.this$0.e.getValue();     // Catch: IllegalArgumentException -> L32
        if (r7 == null) goto L35;
        INVOKEVIRTUAL_com_larus_bmhome_bot_share_ShareBotController$performShareBot$1$onInterceptClick$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r7);     // Catch: IllegalArgumentException -> L32
        goto L35
    L24:
        if (r6.isDestroyed() == true) goto L26;
    L35:
        if ((r11 instanceof i.c) == false) goto L38;
        ((i.c) r11).a.recycle();
    L41:
        return Unit.INSTANCE;
    L38:
        if ((r11 instanceof i.a) == false) goto L41;
        s.a.g(this.$context, 2131900870, false);
    L19:
        r5 = false;
    L32:
        e = move-exception;
        FLogger.a.i("ShareBotController", "dismiss loadingDialog error " + e.getMessage());
        goto L35
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        ShareBotController r8 = this.this$0;
        Context r9 = this.$context;
        jr9.a r12 = this.$shareItemConfig;
        wc9.e r13 = this.$conversation;
        BotModel r14 = this.$botModel;
        this.label = 1;
        r10 = ShareBotController.a(r8, r9, r12, r13, r14, this);
        if (r10 != r0) goto L11;
        return r0;
    }
}
