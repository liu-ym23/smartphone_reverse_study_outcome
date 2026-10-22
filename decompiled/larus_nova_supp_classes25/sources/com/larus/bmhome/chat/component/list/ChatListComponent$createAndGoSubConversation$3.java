package com.larus.bmhome.chat.component.list;

import android.os.Bundle;
import com.larus.bmhome.chat.bean.ChatPassThroughParams;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.helper.ChatRouterHelper;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import s1a.a;
import s1a.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.list.ChatListComponent$createAndGoSubConversation$3", f = "ChatListComponent.kt", i = {}, l = {5919}, m = "invokeSuspend", n = {}, s = {})
public final class ChatListComponent$createAndGoSubConversation$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ qy8.f $createSubCvsInterceptor;
    final /* synthetic */ String $messageId;
    final /* synthetic */ List<Message> $result;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ChatListComponent this$0;

    public ChatListComponent$createAndGoSubConversation$3(ChatListComponent r1, qy8.f r2, List<Message> r3, String r4, String r5, Continuation<? super ChatListComponent$createAndGoSubConversation$3> r6) {
        this.this$0 = r1;
        this.$createSubCvsInterceptor = r2;
        this.$result = r3;
        this.$botId = r4;
        this.$messageId = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        ChatListComponent$createAndGoSubConversation$3 r7 = new ChatListComponent$createAndGoSubConversation$3(this.this$0, this.$createSubCvsInterceptor, this.$result, this.$botId, this.$messageId, r10);
        r7.L$0 = r9;
        return r7;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        Object r15 = null;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r19);     // Catch: Throwable -> L19
        Object r2 = r19;
    L17:
        Object r3 = Result.constructor-impl((Bundle) r2);     // Catch: Throwable -> L19
    L21:
        ChatListComponent r4 = this.this$0;
        Throwable r5 = Result.exceptionOrNull-impl(r3);
        if (r5 == null) goto L25;
        FLogger.a.e(r4.n, "createAndGoSubConversation get bundle failed", r5);
    L25:
        if (Result.isFailure-impl(r3) == true) goto L28;
        r15 = r3;
    L28:
        Bundle r16 = (Bundle) r15;
        if (r16 != null) goto L32;
        FLogger.a.w(this.this$0.n, "createAndGoSubConversation skip because chatBundle is null");
        return Unit.INSTANCE;
    L32:
        this.$createSubCvsInterceptor.b(a.c(this.this$0), r16);
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r19);
        CoroutineScope r6 = (CoroutineScope) this.L$0;
        ChatListComponent r7 = this.this$0;
        List<Message> r8 = this.$result;
        String r9 = this.$botId;
        String r10 = this.$messageId;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L19
        ChatRouterHelper r12 = ChatRouterHelper.a;     // Catch: Throwable -> L19
        int r13 = ChatListComponent.W3;     // Catch: Throwable -> L19
        wc9.e r14 = r7.R4();     // Catch: Throwable -> L19
        String r17 = r7.f1().k();     // Catch: Throwable -> L19
        List r18 = CollectionsKt.take(r8, 100);     // Catch: Throwable -> L19
        Intrinsics.checkNotNullParameter(r7, "<this>");     // Catch: Throwable -> L19
        by7.e r20 = com.larus.ui.arch.component.internal.attach.a.b(r7, r7);     // Catch: Throwable -> L19
        if ((r20 instanceof by7.e) == false) goto L13;
        by7.e r21 = r20;
    L14:
        ChatPassThroughParams r110 = (ChatPassThroughParams) d.a(r7).a(ChatPassThroughParams.class);     // Catch: Throwable -> L19
        this.label = 1;     // Catch: Throwable -> L19
        r2 = ChatRouterHelper.g(r9, r14, r10, r17, "chat", r18, false, false, r21, r110, null, this, 352160);     // Catch: Throwable -> L19
        if (r2 != r0) goto L17;
        return r0;
    L13:
        r21 = null;
    L19:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    }
}
