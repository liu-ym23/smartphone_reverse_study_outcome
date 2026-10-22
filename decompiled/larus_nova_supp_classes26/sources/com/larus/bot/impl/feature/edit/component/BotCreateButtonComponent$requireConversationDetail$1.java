package com.larus.bot.impl.feature.edit.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.chat.ChatLandingChannel;
import com.larus.bmhome.chat.j4;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.bot.impl.common.util.BitmapHelperKt;
import com.larus.bot.impl.feature.edit.BotCreateViewModel;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BgImageInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.conversation.IconImage;
import com.larus.im.bean.message.ImageObj;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.logger.FLogger;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.component.BotCreateButtonComponent$requireConversationDetail$1", f = "BotCreateButtonComponent.kt", i = {1}, l = {271, 273}, m = "invokeSuspend", n = {"conversation"}, s = {"L$0"})
final class BotCreateButtonComponent$requireConversationDetail$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BotModel $bot;
    Object L$0;
    int label;
    final /* synthetic */ BotCreateButtonComponent this$0;

    public BotCreateButtonComponent$requireConversationDetail$1(BotModel r1, BotCreateButtonComponent r2, Continuation<? super BotCreateButtonComponent$requireConversationDetail$1> r3) {
        this.$bot = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new BotCreateButtonComponent$requireConversationDetail$1(this.$bot, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static void INVOKEVIRTUAL_com_larus_bot_impl_feature_edit_component_BotCreateButtonComponent$requireConversationDetail$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(com.larus.common_ui.dialog.l0 r3) {
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

    public final Object invokeSuspend(Object r17) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        wc9.e r3 = (wc9.e) this.L$0;
        ResultKt.throwOnFailure(r17);
    L37:
        BotCreateButtonComponent r4 = this.this$0;
        int r8 = BotCreateButtonComponent.j;
        ru8.e r5 = r4.L2();
        if (r5 == null) goto L42;
        com.larus.common_ui.dialog.l0 r6 = r5.uL();
        if (r6 == null) goto L42;
        INVOKEVIRTUAL_com_larus_bot_impl_feature_edit_component_BotCreateButtonComponent$requireConversationDetail$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r6);
    L42:
        BotCreateButtonComponent r7 = this.this$0;
        String r9 = this.$bot.getBotId();
        if (r3 == null) goto L45;
        String r10 = r3.a;
    L46:
        String r11 = this.$bot.getBgImgUrl();
        String r12 = this.$bot.getBgImgColor();
        BgImageInfo r13 = this.$bot.getBgImgInfo();
        if (r13 == null) goto L51;
        Boolean r14 = r13.getBgImgOpen();
        if (r14 == null) goto L51;
        boolean r15 = r14.booleanValue();
    L52:
        r7.getClass();
        FLogger.a.d("BotCreateButtonComponent", "handleCreateSuccess, botId = " + r9 + ", conversationId = " + r10);
        Intrinsics.checkNotNullParameter(r7, "<this>");
        if ((com.larus.ui.arch.component.internal.attach.a.b(r7, r7) instanceof TraceFragment) == false) goto L103;
        ru8.a r16 = r7.F2();
        if (r16 == null) goto L103;
        BotCreateViewModel r18 = r16.a1();
        if (r18 == null) goto L103;
        if (r9 != null) goto L62;
    L65:
        boolean r19 = true;
    L67:
        if (r19 == true) goto L101;
        if (r10 != null) goto L70;
    L73:
        boolean r110 = true;
    L74:
        if (r110 == true) goto L101;
        qu8.b.d("bot_create", 0);
        r18.onCreateSuccess();
        qu8.b.d("bot_create/io", 0);
        Intrinsics.checkNotNullParameter(r7, "<this>");
        FragmentActivity r20 = com.larus.ui.arch.component.internal.attach.a.b(r7, r7).getActivity();
        if (r20 == null) goto L79;
        r20.setResult(11, new Intent().putExtras(com.larus.utils.f.c(new Pair[]{TuplesKt.to("step_by_step_success", Boolean.TRUE)})));
    L79:
        Intrinsics.checkNotNullParameter(r7, "<this>");
        FragmentActivity r21 = com.larus.ui.arch.component.internal.attach.a.b(r7, r7).getActivity();
        if (r21 == null) goto L82;
        r21.finish();
    L82:
        Intrinsics.checkNotNullParameter(r7, "<this>");
        FragmentActivity r22 = com.larus.ui.arch.component.internal.attach.a.b(r7, r7).getActivity();
        if (r22 == null) goto L85;
        r22.overridePendingTransition(0, 2130772402);
    L85:
        com.bytedance.router.i r23 = SmartRouter.buildRoute(r7.getContext(), "//flow/chat_page");
        Pair[] r24 = new Pair[10];
        r24[0] = TuplesKt.to("landing_channel", ChatLandingChannel.BOT_CREATE.getChannel());
        r24[1] = TuplesKt.to("argConversationId", r10);
        r24[2] = TuplesKt.to("argBotId", r9);
        r24[3] = TuplesKt.to("argCvsBgImgUrl", r11);
        r24[4] = TuplesKt.to("argCvsBgImgColor", r12);
        r24[5] = TuplesKt.to("argCvsBgImgOpen", Boolean.valueOf(r15));
        r24[6] = TuplesKt.to("argPreviousPage", "bot_create_page");
        r24[7] = TuplesKt.to("argImmerseForceStartTts", Boolean.TRUE);
        AppHost.Companion r25 = AppHost.a;
        Activity r26 = r25.a().getCurrentActivity();
        if (r26 == null) goto L96;
        j4 r27 = r25.a().a(r26, null);
        if (r27 == null) goto L96;
        if ((r27 instanceof j4) == false) goto L96;
        if (r27.B0() == false) goto L96;
        boolean r111 = true;
    L97:
        if (r111 == false) goto L99;
        String r28 = "1";
    L100:
        r24[8] = TuplesKt.to("is_side_bar", r28);
        r24[9] = TuplesKt.to("navigate_up_from", "new_chat_setting");
        Bundle r29 = com.larus.utils.f.c(r24);
        Intrinsics.checkNotNullParameter(r7, "<this>");
        TraceFragment r30 = com.larus.ui.arch.component.internal.attach.a.b(r7, r7);
        Intrinsics.checkNotNull(r30, "null cannot be cast to non-null type com.larus.trace.tracknode.TraceFragment");
        by7.h.k(r29, r30);
        r23.c.putExtras(r29);
        r23.d = 2130772401;
        r23.e = 2130772399;
        r23.d();
        goto L103
    L99:
        r28 = TriggerSendLoading.NO_LOADING;
    L96:
        r111 = false;
        goto L97
    L70:
        if (r10.length() == 0) goto L73;
        r110 = false;
    L101:
        qu8.b.d("bot_create/io", -2);
        t19.s r31 = t19.s.a;
        Context r32 = r7.getContext();
        r31.getClass();
        t19.s.b(r32, 2131901062, false);
        goto L103
    L62:
        if (r9.length() == 0) goto L65;
        r19 = false;
    L103:
        return Unit.INSTANCE;
    L51:
        r15 = false;
        goto L52
    L45:
        r10 = null;
        goto L46
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r17);
        Object r33 = r17;
    L25:
        wc9.e r34 = (wc9.e) r33;
        String[] r35 = new String[2];
        if (r34 == null) goto L32;
        IconImage r36 = r34.b;
        if (r36 == null) goto L32;
        ImageObj r37 = r36.imageOri;
        if (r37 == null) goto L32;
        String r38 = r37.url;
    L33:
        r35[0] = r38;
        r35[1] = this.$bot.getBgImgUrl();
        List r39 = CollectionsKt.listOf(r35);
        this.L$0 = r34;
        this.label = 2;
        if (BitmapHelperKt.f(r39, this) != r1) goto L36;
        return r1;
    L36:
        r3 = r34;
    L32:
        r38 = null;
        goto L33
    L10:
        ResultKt.throwOnFailure(r17);
        if (this.$bot == null) goto L13;
        BotCreateButtonComponent r40 = this.this$0;
        int r41 = BotCreateButtonComponent.j;
        ru8.a r42 = r40.F2();
        if (r42 == null) goto L105;
        BotCreateViewModel r43 = r42.a1();
        if (r43 == null) goto L105;
        FLogger.a.d("BotCreateButtonComponent", "requireConversationDetail, sync create bot conv");
        String r44 = this.$bot.getBotId();
        if (r44 != null) goto L22;
        r44 = "";
    L22:
        this.label = 1;
        r33 = r43.createBotConversation(r44, this);
        if (r33 != r1) goto L25;
        return r1;
    L105:
        return Unit.INSTANCE;
    L13:
        return Unit.INSTANCE;
    }
}
