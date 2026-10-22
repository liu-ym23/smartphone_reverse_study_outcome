package com.larus.voice_setting.voice.utils;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.chat.f5;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.ConversationPage;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import ic8.l0;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voice_setting.voice.utils.OpenBotHelper$openChatPage$1", f = "OpenBotHelper.kt", i = {0, 0}, l = {45}, m = "invokeSuspend", n = {"$this$launch", "it"}, s = {"L$0", "L$4"})
final class OpenBotHelper$openChatPage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ BotModel $botInfo;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ String $currentPageName;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    public OpenBotHelper$openChatPage$1(String r1, BotModel r2, Context r3, String r4, String r5, Continuation<? super OpenBotHelper$openChatPage$1> r6) {
        this.$conversationId = r1;
        this.$botInfo = r2;
        this.$context = r3;
        this.$currentPageName = r4;
        this.$botId = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        OpenBotHelper$openChatPage$1 r7 = new OpenBotHelper$openChatPage$1(this.$conversationId, this.$botInfo, this.$context, this.$currentPageName, this.$botId, r10);
        r7.L$0 = r9;
        return r7;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        Integer r3 = null;
        boolean r4 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        BotModel r2 = (BotModel) this.L$4;
        String r5 = (String) this.L$3;
        BotModel r6 = (BotModel) this.L$2;
        Context r7 = (Context) this.L$1;
        CoroutineScope r8 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r12);
    L18:
        String r13 = (String) r12;
        if (r13 != null) goto L21;
    L24:
        boolean r9 = true;
    L25:
        if (r9 == false) goto L27;
        FLogger.a.i("Voice-Setting-OpenBotHelper", "[handleBackToChatPage] cvsId isNullOrEmpty, open by bot");
        OpenBotHelper.a(OpenBotHelper.a, r7, r6.getBotId());
    L48:
        return Unit.INSTANCE;
    L27:
        FLogger r10 = FLogger.a;
        r10.i("Voice-Setting-OpenBotHelper", "[handleBackToChatPage] cvsId not empty with value(" + r13 + ')');
        OpenBotHelper.a.getClass();
        Pair[] r11 = new Pair[9];
        r11[0] = TuplesKt.to("argPreviousPage", r5);
        r11[1] = TuplesKt.to("argConversationId", r13);
        r11[2] = TuplesKt.to("argBotId", r2.getBotId());
        r11[3] = TuplesKt.to("argBotType", r2.getBotType());
        r11[4] = TuplesKt.to("argCvsBgImgUrl", r2.getBgImgUrl());
        r11[5] = TuplesKt.to("argCvsBgImgColor", r2.getBgImgColor());
        r11[6] = TuplesKt.to("argCvsBgImgOpen", Boolean.valueOf(r2.getBgImgOpen()));
        r11[7] = TuplesKt.to("immersive_new_task_and_clear_top", Boolean.TRUE);
        if (z2.a.o() == false) goto L30;
        String r14 = "1";
    L31:
        r11[8] = TuplesKt.to("is_side_bar", r14);
        Bundle r15 = com.larus.utils.f.c(r11);
        ConversationPage r16 = r2.getConversationPage();
        if (r16 == null) goto L38;
        List r17 = r16.getPageList();
        if (r17 == null) goto L38;
        if (l0.b(r17) != true) goto L38;
    L40:
        if (r4 == false) goto L45;
        r10.i("Voice-Setting-OpenBotHelper", "[handleBackToChatPage]: jumpToChatFragment open double tab page");
        com.bytedance.router.i r18 = SmartRouter.buildRoute(r7, "//flow/chat_page_double_tab");
        r15.putBoolean("is_create_sub_conversation", false);
        int r19 = f5.a;
        ConversationPage r20 = r2.getConversationPage();
        if (r20 == null) goto L44;
        r3 = r20.getDefaultStatus();
    L44:
        r15.putInt("default_tab", f5.a(r3));
        r15.putSerializable("conversation_page", r2.getConversationPage());
        r18.c.putExtras(r15);
        r18.d = 2130772399;
        r18.e = 2130772399;
        r18.c.addFlags(335544320);
        r18.d();
        goto L48
    L45:
        r10.i("Voice-Setting-OpenBotHelper", "[handleBackToChatPage]: jumpToChatFragment open normal page");
        com.bytedance.router.i r21 = SmartRouter.buildRoute(r7, "//flow/chat_page");
        r21.c.putExtras(r15);
        r21.d = 2130772399;
        r21.e = 2130772399;
        r21.c.addFlags(335544320);
        r21.d();
    L38:
        r4 = false;
        goto L40
    L30:
        r14 = "0";
        goto L31
    L21:
        if (r13.length() == 0) goto L24;
        r9 = false;
        goto L25
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        CoroutineScope r110 = (CoroutineScope) this.L$0;
        FLogger r22 = FLogger.a;
        StringBuilder r23 = new StringBuilder("[handleBackToChatPage] openByConversationId conversationId:");
        r23.append(this.$conversationId);
        r23.append(", botId:");
        BotModel r24 = this.$botInfo;
        if (r24 == null) goto L11;
        String r25 = r24.getBotId();
    L12:
        r23.append(r25);
        r22.i("Voice-Setting-OpenBotHelper", r23.toString());
        r6 = this.$botInfo;
        if (r6 == null) goto L46;
        String r26 = this.$conversationId;
        Context r27 = this.$context;
        String r28 = this.$currentPageName;
        r22.i("Voice-Setting-OpenBotHelper", "[handleBackToChatPage] botInfo is NOT NULL");
        OpenBotHelper r29 = OpenBotHelper.a;
        this.L$0 = r110;
        this.L$1 = r27;
        this.L$2 = r6;
        this.L$3 = r28;
        this.L$4 = r6;
        this.label = 1;
        r29.getClass();
        r12 = BuildersKt.withContext(Dispatchers.getIO(), new OpenBotHelper$findOrCreateConversationId$2(r26, r6, null), this);
        if (r12 != r0) goto L17;
        return r0;
    L17:
        r2 = r6;
        r7 = r27;
        r5 = r28;
        goto L18
    L46:
        String r111 = this.$botId;
        Context r30 = this.$context;
        r22.i("Voice-Setting-OpenBotHelper", "[handleBackToChatPage] botInfo is NULL, use botId(" + r111 + ')');
        OpenBotHelper.a(OpenBotHelper.a, r30, r111);
        goto L48
    L11:
        r25 = null;
        goto L12
    }
}
