package com.larus.bot.impl.feature.botmaker;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.chat.ChatLandingChannel;
import com.larus.bot.impl.common.util.BitmapHelperKt;
import com.larus.bot.impl.feature.edit.BotCreateViewModel;
import com.larus.common_ui.dialog.l0;
import com.larus.im.bean.bot.BgImageInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.conversation.IconImage;
import com.larus.im.bean.message.ImageObj;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.botmaker.BotMakerEventListener$requireConversationDetail$1", f = "BotMakerEventListener.kt", i = {1}, l = {443, 444}, m = "invokeSuspend", n = {"conversation"}, s = {"L$0"})
final class BotMakerEventListener$requireConversationDetail$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BotModel $bot;
    Object L$0;
    int label;
    final /* synthetic */ f this$0;

    public BotMakerEventListener$requireConversationDetail$1(f r1, BotModel r2, Continuation<? super BotMakerEventListener$requireConversationDetail$1> r3) {
        this.this$0 = r1;
        this.$bot = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new BotMakerEventListener$requireConversationDetail$1(this.this$0, this.$bot, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static void INVOKEVIRTUAL_com_larus_bot_impl_feature_botmaker_BotMakerEventListener$requireConversationDetail$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(l0 r3) {
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

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        String r2 = null;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        wc9.e r3 = (wc9.e) this.L$0;
        ResultKt.throwOnFailure(r12);
    L28:
        f r13 = this.this$0;
        int r4 = f.f;
        l0 r14 = (l0) r13.e.getValue();
        if (r14 == null) goto L31;
        INVOKEVIRTUAL_com_larus_bot_impl_feature_botmaker_BotMakerEventListener$requireConversationDetail$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r14);
    L31:
        f r15 = this.this$0;
        String r5 = this.$bot.getBotId();
        if (r3 == null) goto L34;
        r2 = r3.a;
    L34:
        String r6 = this.$bot.getBgImgUrl();
        String r7 = this.$bot.getBgImgColor();
        BgImageInfo r8 = this.$bot.getBgImgInfo();
        if (r8 == null) goto L39;
        Boolean r9 = r8.getBgImgOpen();
        if (r9 == null) goto L39;
        boolean r10 = r9.booleanValue();
    L40:
        r15.getClass();
        if (r5 != null) goto L43;
    L46:
        boolean r11 = true;
    L47:
        if (r11 == true) goto L57;
        if (r2 != null) goto L50;
    L53:
        boolean r16 = true;
    L54:
        if (r16 == true) goto L57;
        com.bytedance.router.i r17 = SmartRouter.buildRoute(r15.a.getContext(), "//flow/chat_page");
        Boolean r18 = Boolean.TRUE;
        Bundle r19 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("argConversationId", r2), TuplesKt.to("argBotId", r5), TuplesKt.to("argImmerseForceStartTts", r18), TuplesKt.to("landing_channel", ChatLandingChannel.CREATE_NEW_BOT.getChannel()), TuplesKt.to("argCvsBgImgUrl", r6), TuplesKt.to("argCvsBgImgColor", r7), TuplesKt.to("argCvsBgImgOpen", Boolean.valueOf(r10)), TuplesKt.to("argImmerseForceStartTts", r18)});
        by7.h.k(r19, r15.c);
        r17.c.putExtras(r19);
        r17.d();
    L59:
        return Unit.INSTANCE;
    L50:
        if (r2.length() == 0) goto L53;
        r16 = false;
    L57:
        s r20 = s.a;
        Context r110 = r15.a.getContext();
        r20.getClass();
        s.b(r110, 2131901062, false);
        goto L59
    L43:
        if (r5.length() == 0) goto L46;
        r11 = false;
    L39:
        r10 = false;
        goto L40
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r12);
    L16:
        wc9.e r111 = (wc9.e) r12;
        String[] r21 = new String[2];
        if (r111 == null) goto L23;
        IconImage r22 = r111.b;
        if (r22 == null) goto L23;
        ImageObj r23 = r22.imageOri;
        if (r23 == null) goto L23;
        String r24 = r23.url;
    L24:
        r21[0] = r24;
        r21[1] = this.$bot.getBgImgUrl();
        List r25 = CollectionsKt.listOf(r21);
        this.L$0 = r111;
        this.label = 2;
        if (BitmapHelperKt.f(r25, this) != r0) goto L27;
        return r0;
    L27:
        r3 = r111;
    L23:
        r24 = null;
        goto L24
    L10:
        ResultKt.throwOnFailure(r12);
        f r112 = this.this$0;
        int r26 = f.f;
        BotCreateViewModel r113 = r112.e();
        String r27 = this.$bot.getBotId();
        if (r27 != null) goto L13;
        r27 = "";
    L13:
        this.label = 1;
        r12 = r113.createBotConversation(r27, this);
        if (r12 != r0) goto L16;
        return r0;
    }
}
