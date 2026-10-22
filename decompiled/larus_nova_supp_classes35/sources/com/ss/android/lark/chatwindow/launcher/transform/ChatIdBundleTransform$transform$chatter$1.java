package com.ss.android.lark.chatwindow.launcher.transform;

import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/chat/entity/chatter/Chatter;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chatwindow.launcher.transform.ChatIdBundleTransform$transform$chatter$1", f = "ChatIdBundleTransform.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
public final class ChatIdBundleTransform$transform$chatter$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Chatter>, Object> {
    final /* synthetic */ Chat $chat;
    int label;
    final /* synthetic */ ChatIdBundleTransform this$0;

    public ChatIdBundleTransform$transform$chatter$1(Chat r1, ChatIdBundleTransform r2, Continuation<? super ChatIdBundleTransform$transform$chatter$1> r3) {
        this.$chat = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatIdBundleTransform$transform$chatter$1(this.$chat, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Chatter> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        Object r2 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
        Object r6 = ((Result) r5).unbox-impl();
    L14:
        if (Result.isFailure-impl(r6) == true) goto L18;
        r2 = r6;
    L18:
        return (Chatter) r2;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        if (this.$chat.isP2PChat() == false) goto L19;
        b r7 = this.this$0.a;
        String r3 = this.$chat.getP2pChatterId();
        this.label = 1;
        r6 = r7.c(r3, this);
        if (r6 != r0) goto L14;
        return r0;
    L19:
        return null;
    }
}
