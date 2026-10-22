package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.ChatRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.im.bean.message.Message;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.list.ChatListComponent$initMusicAuthHandler$1$handleMusicAuthResultFrom$1", f = "ChatListComponent.kt", i = {}, l = {2268}, m = "invokeSuspend", n = {}, s = {})
public final class ChatListComponent$initMusicAuthHandler$1$handleMusicAuthResultFrom$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.platform.api.o4 $musicAuthResultData;
    int label;
    final /* synthetic */ ChatListComponent this$0;

    public ChatListComponent$initMusicAuthHandler$1$handleMusicAuthResultFrom$1(com.larus.platform.api.o4 r1, ChatListComponent r2, Continuation<? super ChatListComponent$initMusicAuthHandler$1$handleMusicAuthResultFrom$1> r3) {
        this.$musicAuthResultData = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatListComponent$initMusicAuthHandler$1$handleMusicAuthResultFrom$1(this.$musicAuthResultData, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L18:
        Message r2 = (Message) r7;
        ChatListComponent r3 = this.this$0;
        com.larus.platform.api.o4 r8 = this.$musicAuthResultData;
        ChatListComponent.C3(r3, r2, r8.d, r8.c, r8.b, r8.a);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        if (this.$musicAuthResultData.f.length() != 0) goto L11;
        boolean r9 = true;
    L12:
        if (r9 == true) goto L14;
        RepoDispatcher.a.getClass();
        ChatRepo r10 = RepoDispatcher.d;
        String r4 = this.$musicAuthResultData.f;
        this.label = 1;
        r7 = r10.E1(r4, this);
        if (r7 != r0) goto L18;
        return r0;
    L14:
        return Unit.INSTANCE;
    L11:
        r9 = false;
        goto L12
    }
}
