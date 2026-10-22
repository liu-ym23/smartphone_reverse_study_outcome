package com.larus.chat.gallery.api;

import com.larus.bmhome.chat.f5;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.ConversationPage;
import com.larus.im.bean.message.Message;
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
@DebugMetadata(c = "com.larus.chat.gallery.api.BaseChatTopProvider$onTitleClick$1", f = "BaseChatTopProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class BaseChatTopProvider$onTitleClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BotModel $botModel;
    final /* synthetic */ wc9.e $conversation;
    final /* synthetic */ boolean $isShowTab;
    int label;
    final /* synthetic */ g<Object> this$0;

    public BaseChatTopProvider$onTitleClick$1(wc9.e r1, BotModel r2, g<Object> r3, boolean r4, Continuation<? super BaseChatTopProvider$onTitleClick$1> r5) {
        this.$conversation = r1;
        this.$botModel = r2;
        this.this$0 = r3;
        this.$isShowTab = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new BaseChatTopProvider$onTitleClick$1(this.$conversation, this.$botModel, this.this$0, this.$isShowTab, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r30) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L60;
        ResultKt.throwOnFailure(r30);
        String r3 = this.$conversation.a;
        BotModel r1 = this.$botModel;
        if (r1 == null) goto L7;
        String r4 = r1.getBgImgUrl();
    L8:
        BotModel r2 = this.$botModel;
        if (r2 == null) goto L11;
        String r5 = r2.getBgImgColor();
    L12:
        BotModel r6 = this.$botModel;
        if (r6 == null) goto L15;
        boolean r7 = r6.getBgImgOpen();
    L16:
        int r8 = f5.a;
        wc9.e r9 = this.$conversation;
        if (r9 == null) goto L21;
        ConversationPage r10 = r9.g;
        if (r10 == null) goto L21;
        Integer r11 = r10.getDefaultStatus();
    L22:
        int r12 = f5.a(r11);
        BotModel r13 = this.$botModel;
        if (r13 == null) goto L25;
        String r14 = r13.getBotId();
    L26:
        wc9.e r15 = this.$conversation;
        if (r15 == null) goto L32;
        ConversationPage r16 = r15.g;
        if (r16 == null) goto L32;
        List r17 = r16.getPageList();
        if (r17 == null) goto L32;
    L33:
        List r18 = r17;
        ConversationPage r19 = this.$conversation.g;
        BotModel r20 = this.$botModel;
        if (r20 == null) goto L36;
        Integer r110 = r20.getBotType();
    L37:
        wc9.e r21 = this.$conversation;
        if (r21 == null) goto L40;
        Integer r111 = r21.j;
    L41:
        bb9.a r22 = this.this$0.C();
        if (r22 == null) goto L46;
        Message r23 = r22.a;
        if (r23 == null) goto L46;
        long r24 = r23.getLocalIndex();
    L47:
        long r112 = r24;
        bb9.a r25 = this.this$0.C();
        if (r25 == null) goto L52;
        Message r26 = r25.a;
        if (r26 == null) goto L52;
        String r113 = r26.getMessageId();
    L53:
        Integer r27 = this.$conversation.v;
        if (r27 == null) goto L56;
        int r28 = r27.intValue();
    L57:
        g.y(this.this$0, new ni8.e(r3, r4, r5, r7, this.$isShowTab, false, r12, r19, r14, null, r111, r18, r110, r112, null, r113, null, null, null, null, r28, 0, 0, 14583072));
        return Unit.INSTANCE;
    L56:
        r28 = 0;
    L52:
        r113 = null;
    L46:
        r24 = -1;
        goto L47
    L40:
        r111 = null;
        goto L41
    L36:
        r110 = null;
    L32:
        r17 = CollectionsKt.emptyList();
        goto L33
    L25:
        r14 = null;
    L21:
        r11 = null;
        goto L22
    L15:
        r7 = true;
        goto L16
    L11:
        r5 = null;
        goto L12
    L7:
        r4 = null;
        goto L8
    L60:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
