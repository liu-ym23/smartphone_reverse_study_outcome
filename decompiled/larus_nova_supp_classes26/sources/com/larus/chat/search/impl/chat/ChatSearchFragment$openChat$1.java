package com.larus.chat.search.impl.chat;

import com.larus.bmhome.chat.f5;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.ConversationPage;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.search.impl.chat.ChatSearchFragment$openChat$1", f = "ChatSearchFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatSearchFragment$openChat$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BotModel $botModel;
    final /* synthetic */ wc9.e $conversation;
    final /* synthetic */ boolean $isShowTab;
    final /* synthetic */ long $localIndex;
    final /* synthetic */ String $messageId;
    final /* synthetic */ String $searchHighlightKeyword;
    int label;
    final /* synthetic */ ChatSearchFragment this$0;

    public ChatSearchFragment$openChat$1(wc9.e r1, BotModel r2, ChatSearchFragment r3, boolean r4, long r5, String r7, String r8, Continuation<? super ChatSearchFragment$openChat$1> r9) {
        this.$conversation = r1;
        this.$botModel = r2;
        this.this$0 = r3;
        this.$isShowTab = r4;
        this.$localIndex = r5;
        this.$messageId = r7;
        this.$searchHighlightKeyword = r8;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        return new ChatSearchFragment$openChat$1(this.$conversation, this.$botModel, this.this$0, this.$isShowTab, this.$localIndex, this.$messageId, this.$searchHighlightKeyword, r12);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r30) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L47;
        ResultKt.throwOnFailure(r30);
        String r3 = this.$conversation.a;
        BotModel r1 = this.$botModel;
        Integer r2 = null;
        if (r1 == null) goto L7;
        String r4 = r1.getBgImgUrl();
    L8:
        BotModel r5 = this.$botModel;
        if (r5 == null) goto L11;
        String r6 = r5.getBgImgColor();
    L12:
        BotModel r7 = this.$botModel;
        if (r7 == null) goto L15;
        boolean r8 = r7.getBgImgOpen();
    L16:
        int r9 = f5.a;
        wc9.e r10 = this.$conversation;
        if (r10 == null) goto L21;
        ConversationPage r11 = r10.g;
        if (r11 == null) goto L21;
        Integer r12 = r11.getDefaultStatus();
    L22:
        int r13 = f5.a(r12);
        BotModel r14 = this.$botModel;
        if (r14 == null) goto L25;
        String r15 = r14.getBotId();
    L26:
        wc9.e r16 = this.$conversation;
        if (r16 == null) goto L32;
        ConversationPage r17 = r16.g;
        if (r17 == null) goto L32;
        List r18 = r17.getPageList();
        if (r18 == null) goto L32;
    L33:
        List r19 = r18;
        ConversationPage r110 = this.$conversation.g;
        BotModel r20 = this.$botModel;
        if (r20 == null) goto L36;
        Integer r111 = r20.getBotType();
    L37:
        wc9.e r21 = this.$conversation;
        if (r21 == null) goto L40;
        r2 = r21.j;
    L40:
        Integer r112 = r2;
        String r113 = this.this$0.k;
        Integer r22 = r21.v;
        if (r22 == null) goto L43;
        int r24 = r22.intValue();
    L44:
        ChatSearchFragment.V90(this.this$0, new ni8.e(r3, r4, r6, r8, this.$isShowTab, false, r13, r110, r15, null, r112, r19, r111, this.$localIndex, null, this.$messageId, r113, this.$searchHighlightKeyword, null, null, r24, 0, 0, 14189856));
        return Unit.INSTANCE;
    L43:
        r24 = 0;
        goto L44
    L36:
        r111 = null;
    L32:
        r18 = CollectionsKt.emptyList();
        goto L33
    L25:
        r15 = null;
    L21:
        r12 = null;
        goto L22
    L15:
        r8 = true;
        goto L16
    L11:
        r6 = null;
        goto L12
    L7:
        r4 = null;
        goto L8
    L47:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
