package com.ss.android.lark.chat.chatwindow.chat.v2.component.message;

import com.ss.android.lark.chat.chatwindow.chat.v2.push.x;
import com.ss.android.lark.chat.core.model.entity.ChatMessageResponse;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/ss/android/lark/chat/core/model/entity/ChatMessageResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.v2.component.message.DefaultMessageListRepository$loadFirstPageV2$result$1", f = "DefaultMessageListRepository.kt", i = {}, l = {79, 81}, m = "invokeSuspend", n = {}, s = {})
final class DefaultMessageListRepository$loadFirstPageV2$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends ChatMessageResponse>>, Object> {
    final /* synthetic */ String $chatId;
    final /* synthetic */ x $loader;
    final /* synthetic */ u3b.a $task;
    int label;
    final /* synthetic */ j this$0;

    public DefaultMessageListRepository$loadFirstPageV2$result$1(u3b.a r1, x r2, String r3, j r4, Continuation<? super DefaultMessageListRepository$loadFirstPageV2$result$1> r5) {
        this.$task = r1;
        this.$loader = r2;
        this.$chatId = r3;
        this.this$0 = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new DefaultMessageListRepository$loadFirstPageV2$result$1(this.$task, this.$loader, this.$chatId, this.this$0, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<? extends ChatMessageResponse>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 == 1) goto L6;
        if (r1 == 2) goto L6;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L6:
        ResultKt.throwOnFailure(r5);
        Object r6 = ((Result) r5).unbox-impl();
    L18:
        return Result.box-impl(r6);
    L9:
        ResultKt.throwOnFailure(r5);
        if ((this.$task instanceof u3b.c) == false) goto L14;
        x r7 = this.$loader;
        String r2 = this.$chatId;
        int r3 = this.this$0.e;
        this.label = 1;
        r6 = r7.b(r2, r3, this);
        if (r6 != r0) goto L18;
        return r0;
    L14:
        x r8 = this.$loader;
        String r4 = this.$chatId;
        int r9 = this.this$0.e;
        this.label = 2;
        r6 = r8.a(r4, r9, this);
        if (r6 != r0) goto L18;
        return r0;
    }
}
