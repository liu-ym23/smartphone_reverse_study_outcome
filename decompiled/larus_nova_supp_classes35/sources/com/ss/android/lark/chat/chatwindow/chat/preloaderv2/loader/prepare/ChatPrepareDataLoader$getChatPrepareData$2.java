package com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.prepare;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.biz.im.api.ChatWindowPrepareData;
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
@DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.prepare.ChatPrepareDataLoader$getChatPrepareData$2", f = "ChatPrepareDataLoader.kt", i = {}, l = {99}, m = "invokeSuspend", n = {}, s = {})
final class ChatPrepareDataLoader$getChatPrepareData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IGetDataCallback<ChatWindowPrepareData> $callback;
    final /* synthetic */ String $chatId;
    int label;
    final /* synthetic */ a this$0;

    public ChatPrepareDataLoader$getChatPrepareData$2(a r1, String r2, IGetDataCallback<ChatWindowPrepareData> r3, Continuation<? super ChatPrepareDataLoader$getChatPrepareData$2> r4) {
        this.this$0 = r1;
        this.$chatId = r2;
        this.$callback = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ChatPrepareDataLoader$getChatPrepareData$2(this.this$0, this.$chatId, this.$callback, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        ChatWindowPrepareData r5 = (ChatWindowPrepareData) r4;
        IGetDataCallback<ChatWindowPrepareData> r2 = this.$callback;
        if (r2 == null) goto L15;
        r2.onSuccess(r5);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        a r6 = this.this$0;
        String r3 = this.$chatId;
        this.label = 1;
        int r7 = a.k;
        r4 = r6.c(r3);
        if (r4 != r0) goto L11;
        return r0;
    }
}
