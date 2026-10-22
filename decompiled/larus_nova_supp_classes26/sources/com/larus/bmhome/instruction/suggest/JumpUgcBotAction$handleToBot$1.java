package com.larus.bmhome.instruction.suggest;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import com.larus.bmhome.chat.f5;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.ConversationPage;
import com.larus.platform.model.RecommendFrom;
import com.larus.utils.f;
import com.larus.utils.logger.FLogger;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.instruction.suggest.JumpUgcBotAction$handleToBot$1", f = "JumpUgcBotAction.kt", i = {0}, l = {45}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class JumpUgcBotAction$handleToBot$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ BotModel $botModel;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ a this$0;

    public JumpUgcBotAction$handleToBot$1(BotModel r1, a r2, String r3, Continuation<? super JumpUgcBotAction$handleToBot$1> r4) {
        this.$botModel = r1;
        this.this$0 = r2;
        this.$botId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        JumpUgcBotAction$handleToBot$1 r0 = new JumpUgcBotAction$handleToBot$1(this.$botModel, this.this$0, this.$botId, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        String r2 = "";
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        BotModel r3 = (BotModel) this.L$4;
        String r4 = (String) this.L$3;
        a r5 = (a) this.L$2;
        BotModel r6 = (BotModel) this.L$1;
        CoroutineScope r7 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r14);
    L20:
        String r15 = (String) r14;
        if (r15 != null) goto L23;
    L26:
        boolean r8 = true;
    L27:
        if (r8 == false) goto L29;
        a.b(r5, r4);
    L52:
        if (r6 != null) goto L55;
    L53:
        a.b(this.this$0, this.$botId);
    L55:
        return Unit.INSTANCE;
    L29:
        if (r4 != null) goto L33;
        r4 = r3.getBotId();
        if (r4 != null) goto L33;
    L34:
        String r9 = r5.b;
        FLogger.a.i("JumpUgcBotAction", "toChatFragment");
        String r10 = r5.c;
        Context r11 = null;
        Integer r12 = null;
        RecommendFrom r13 = new RecommendFrom(r10, null, r10, 2);
        Boolean r16 = Boolean.FALSE;
        Bundle r17 = f.c(new Pair[]{TuplesKt.to("argPreviousPage", "chat"), TuplesKt.to("argConversationId", r15), TuplesKt.to("argClickEnterFrom", r9), TuplesKt.to("argBotId", r2), TuplesKt.to("argCvsBgImgUrl", r3.getBgImgUrl()), TuplesKt.to("argCvsBgImgColor", r3.getBgImgColor()), TuplesKt.to("argCvsBgImgOpen", Boolean.valueOf(r3.getBgImgOpen())), TuplesKt.to("enter_method", r5.b), TuplesKt.to("navigate_up_from", r5.b), TuplesKt.to("argBotRecommendFrom", r13), TuplesKt.to("is_need_fixed_bottom_tab", r16)});
        ConversationPage r18 = r3.getConversationPage();
        if (r18 == null) goto L37;
        List r19 = r18.getPageList();
    L39:
        if (l0.b(r19) == false) goto L48;
        Fragment r20 = r5.a;
        if (r20 == null) goto L43;
        Context r21 = r20.getContext();
    L44:
        i r22 = SmartRouter.buildRoute(r21, "//flow/chat_page_double_tab");
        r22.c.putExtras(r17);
        Pair[] r23 = new Pair[3];
        r23[0] = TuplesKt.to("is_create_sub_conversation", r16);
        int r110 = f5.a;
        ConversationPage r111 = r3.getConversationPage();
        if (r111 == null) goto L47;
        r12 = r111.getDefaultStatus();
    L47:
        r23[1] = TuplesKt.to("default_tab", Integer.valueOf(f5.a(r12)));
        r23[2] = TuplesKt.to("conversation_page", r3.getConversationPage());
        r22.c.putExtras(f.c(r23));
        r22.d = 2130772401;
        r22.e = 2130772399;
        r22.d();
        goto L52
    L43:
        r21 = null;
        goto L44
    L48:
        Fragment r112 = r5.a;
        if (r112 == null) goto L51;
        r11 = r112.getContext();
    L51:
        i r113 = SmartRouter.buildRoute(r11, "//flow/chat_page");
        r113.c.putExtras(r17);
        r113.d = 2130772401;
        r113.e = 2130772399;
        r113.d();
        goto L52
    L37:
        r19 = null;
    L33:
        r2 = r4;
        goto L34
    L23:
        if (r15.length() == 0) goto L26;
        r8 = false;
        goto L27
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        CoroutineScope r114 = (CoroutineScope) this.L$0;
        BotModel r24 = this.$botModel;
        if (r24 == null) goto L53;
        r5 = this.this$0;
        String r25 = this.$botId;
        if (r25 != null) goto L15;
        String r26 = r24.getBotId();
        if (r26 != null) goto L16;
        r26 = "";
    L16:
        this.L$0 = r114;
        this.L$1 = r24;
        this.L$2 = r5;
        this.L$3 = r25;
        this.L$4 = r24;
        this.label = 1;
        r14 = a.a(r5, r26, r24, this);
        if (r14 != r0) goto L19;
        return r0;
    L19:
        r3 = r24;
        r4 = r25;
        r6 = r3;
        goto L20
    L15:
        r26 = r25;
        goto L16
    }
}
