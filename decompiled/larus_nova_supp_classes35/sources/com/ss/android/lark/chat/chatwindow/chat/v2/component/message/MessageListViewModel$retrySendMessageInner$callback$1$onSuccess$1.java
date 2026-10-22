package com.ss.android.lark.chat.chatwindow.chat.v2.component.message;

import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.service.impl.b2;
import com.ss.android.lark.chat.service.impl.r;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.v2.component.message.MessageListViewModel$retrySendMessageInner$callback$1$onSuccess$1", f = "MessageListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MessageListViewModel$retrySendMessageInner$callback$1$onSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Chat $chat;
    int label;
    final /* synthetic */ MessageListViewModel this$0;

    public static final class a implements r.a {
        public final /* synthetic */ MessageListViewModel a;
        public final /* synthetic */ Chat b;

        public a(MessageListViewModel r1, Chat r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.ss.android.lark.chat.service.impl.r.a
        public final Boolean a() {
            if (this.a.getChatContainer().C().isEnable("lark.chat.reset.sync") == true) goto L5;
        L7:
            boolean r0 = false;
        L9:
            return Boolean.valueOf(r0);
        L5:
            if (this.b.isSecret() == true) goto L7;
            r0 = true;
            goto L9
        }
    }

    public MessageListViewModel$retrySendMessageInner$callback$1$onSuccess$1(MessageListViewModel r1, Chat r2, Continuation<? super MessageListViewModel$retrySendMessageInner$callback$1$onSuccess$1> r3) {
        this.this$0 = r1;
        this.$chat = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MessageListViewModel$retrySendMessageInner$callback$1$onSuccess$1(this.this$0, this.$chat, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r5);
        MessageListViewModel r0 = this.this$0;
        a r6 = new a(r0, this.$chat);
        r0.getChatContainer().D().o5(new b2.a(this.$chat.getId(), this.$chat.getLastDraftId()), ChatParamUtils.c(this.$chat), ChatParamUtils.d(this.$chat), r6);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
