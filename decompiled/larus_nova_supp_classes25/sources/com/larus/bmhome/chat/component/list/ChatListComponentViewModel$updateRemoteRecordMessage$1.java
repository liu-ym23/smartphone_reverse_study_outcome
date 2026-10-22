package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.ChatRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.list.ChatListComponentViewModel$updateRemoteRecordMessage$1", f = "ChatListComponentViewModel.kt", i = {}, l = {1226}, m = "invokeSuspend", n = {}, s = {})
public final class ChatListComponentViewModel$updateRemoteRecordMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $messageId;
    final /* synthetic */ ic8.p0 $recordCardData;
    int label;

    public ChatListComponentViewModel$updateRemoteRecordMessage$1(String r1, ic8.p0 r2, Continuation<? super ChatListComponentViewModel$updateRemoteRecordMessage$1> r3) {
        this.$messageId = r1;
        this.$recordCardData = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatListComponentViewModel$updateRemoteRecordMessage$1(this.$messageId, this.$recordCardData, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        RepoDispatcher.a.getClass();
        ChatRepo r3 = RepoDispatcher.d;
        String r4 = this.$messageId;
        Integer r11 = this.$recordCardData.d();
        Intrinsics.checkNotNull(r11);
        int r5 = r11.intValue();
        Integer r6 = this.$recordCardData.b();
        String r12 = this.$recordCardData.c();
        if (r12 == null) goto L11;
        Long r13 = StringsKt.toLongOrNull(r12);
    L12:
        this.label = 1;
        if (r3.q1(r4, r5, r6, r13, this) != r0) goto L16;
        return r0;
    L11:
        r13 = null;
        goto L12
    }
}
