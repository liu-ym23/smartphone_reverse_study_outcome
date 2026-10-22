package com.ss.android.lark.chatwindow.launcher.transform;

import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.feed.app.entity.RankConstants;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chatwindow.launcher.transform.ChatIdBundleTransform$transform$chat$1", f = "ChatIdBundleTransform.kt", i = {}, l = {RankConstants.PRIORITY_FILTER_ITEM}, m = "invokeSuspend", n = {}, s = {})
public final class ChatIdBundleTransform$transform$chat$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Chat>, Object> {
    final /* synthetic */ String $chatId;
    int label;
    final /* synthetic */ ChatIdBundleTransform this$0;

    public ChatIdBundleTransform$transform$chat$1(ChatIdBundleTransform r1, String r2, Continuation<? super ChatIdBundleTransform$transform$chat$1> r3) {
        this.this$0 = r1;
        this.$chatId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatIdBundleTransform$transform$chat$1(this.this$0, this.$chatId, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Chat> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
        Object r5 = ((Result) r4).unbox-impl();
    L12:
        if (Result.isFailure-impl(r5) == false) goto L15;
        return null;
    L15:
        return r5;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        b r6 = this.this$0.a;
        String r2 = this.$chatId;
        this.label = 1;
        r5 = r6.b(r2, this);
        if (r5 != r0) goto L12;
        return r0;
    }
}
