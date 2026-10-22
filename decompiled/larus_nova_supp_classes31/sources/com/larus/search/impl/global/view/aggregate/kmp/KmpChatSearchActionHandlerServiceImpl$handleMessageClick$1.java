package com.larus.search.impl.global.view.aggregate.kmp;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.flow.search.kmp.api.model.FlowQuery;
import com.bytedance.flow.search.kmp.api.model.ISearchDataPayload;
import com.bytedance.flow.search.kmp.api.model.payload.MessagePayload;
import com.bytedance.flow.search.kmp.api.model.payload.model.MessageSearchResult;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.chat.helper.d0;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.search.impl.global.view.aggregate.kmp.KmpChatSearchActionHandlerServiceImpl$handleMessageClick$1", f = "KmpChatSearchActionHandlerServiceImpl.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
final class KmpChatSearchActionHandlerServiceImpl$handleMessageClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ wc9.e $conversation;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ String $highlightKeyword;
    final /* synthetic */ Function0<Unit> $onSearchDataChanged;
    final /* synthetic */ MessagePayload $payload;
    final /* synthetic */ MessageSearchResult $result;
    int label;
    final /* synthetic */ KmpChatSearchActionHandlerServiceImpl this$0;

    public KmpChatSearchActionHandlerServiceImpl$handleMessageClick$1(KmpChatSearchActionHandlerServiceImpl r1, String r2, wc9.e r3, Context r4, Function0<Unit> r5, MessagePayload r6, String r7, MessageSearchResult r8, Continuation<? super KmpChatSearchActionHandlerServiceImpl$handleMessageClick$1> r9) {
        this.this$0 = r1;
        this.$conversationId = r2;
        this.$conversation = r3;
        this.$context = r4;
        this.$onSearchDataChanged = r5;
        this.$payload = r6;
        this.$highlightKeyword = r7;
        this.$result = r8;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        return new KmpChatSearchActionHandlerServiceImpl$handleMessageClick$1(this.this$0, this.$conversationId, this.$conversation, this.$context, this.$onSearchDataChanged, this.$payload, this.$highlightKeyword, this.$result, r12);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L11:
        KmpChatSearchActionHandlerServiceImpl r2 = this.this$0;
        String r3 = this.$conversationId;
        Bundle r10 = KmpChatSearchActionHandlerServiceImpl.u(r2, r3, (BotModel) r9, this.$conversation);
        MessagePayload r4 = this.$payload;
        String r5 = this.$highlightKeyword;
        MessageSearchResult r6 = this.$result;
        FlowQuery r7 = ((ISearchDataPayload) r4).e;
        if (r7 == null) goto L14;
        String r8 = r7.a;
    L15:
        if (r8 != null) goto L17;
        r8 = "";
    L17:
        r10.putString("search_keyword", r8);
        r10.putString("search_highlight_keyword", r5);
        long r11 = r6.h;
        if (r11 <= 0) goto L20;
        r10.putLong("target_middle_msg_local_index", r11);
    L20:
        Message r12 = r6.k;
        if (r12 == null) goto L25;
        String r13 = r12.getMessageId();
        if (r13 == null) goto L25;
        r10.putString("target_middle_msg_id", r13);
        r10.putString("message_id", r13);
    L25:
        KmpChatSearchActionHandlerServiceImpl.H2(this.this$0, this.$conversationId, Boxing.boxInt(3), "handleMessageClickBot");
        com.bytedance.router.i r14 = SmartRouter.buildRoute(this.$context, "//flow/chat_page");
        r14.c.putExtras(r10);
        r14.d();
        d0.a.b(this.$conversation, "search_landing_page", "search_result", "search_result", this.$onSearchDataChanged);
        return Unit.INSTANCE;
    L14:
        r8 = null;
        goto L15
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        KmpChatSearchActionHandlerServiceImpl r15 = this.this$0;
        String r16 = this.$conversationId;
        this.label = 1;
        r9 = KmpChatSearchActionHandlerServiceImpl.z0(r15, r16, this);
        if (r9 != r0) goto L11;
        return r0;
    }
}
