package com.ss.android.lark.compose.chatsetting.common.repository;

import com.lark.kmp.pb.basic.v1.Chat;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", "Lcom/lark/kmp/pb/basic/v1/Chat;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.common.repository.ChatSettingRepository$observeChat$3", f = "ChatSettingRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ChatSettingRepository$observeChat$3 extends SuspendLambda implements Function2<Chat, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $chatId;
    /* synthetic */ Object L$0;
    int label;

    public ChatSettingRepository$observeChat$3(String r1, Continuation<? super ChatSettingRepository$observeChat$3> r2) {
        this.$chatId = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ChatSettingRepository$observeChat$3 r0 = new ChatSettingRepository$observeChat$3(this.$chatId, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(Chat r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((Chat) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r2);
        if (((Chat) this.L$0) != null) goto L8;
        int r3 = c8b.a.a;
        c8b.a.a("[ChatSettingRepository.observeChat] chat not found in push entity, chatId: " + this.$chatId);
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
