package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.chat.api.ChatApi;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.ChatRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.chat.resp.MessageList;
import com.larus.im.bean.IMMsg;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.list.ChatListComponentViewModel$requirePushContent$1", f = "ChatListComponentViewModel.kt", i = {0, 1, 1}, l = {1013, 1018}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "it"}, s = {"L$0", "L$0", "L$2"})
public final class ChatListComponentViewModel$requirePushContent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $groupId;
    final /* synthetic */ String $userId;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public ChatListComponentViewModel$requirePushContent$1(String r1, String r2, Continuation<? super ChatListComponentViewModel$requirePushContent$1> r3) {
        this.$groupId = r1;
        this.$userId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        ChatListComponentViewModel$requirePushContent$1 r0 = new ChatListComponentViewModel$requirePushContent$1(this.$groupId, this.$userId, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00a0 -> B:35:0x00da). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00b8 -> B:30:0x00c0). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        String r2 = "ChatListComponentViewModel";
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        IMMsg r3 = (IMMsg) this.L$2;
        Iterator r4 = (Iterator) this.L$1;
        CoroutineScope r5 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r13);
        CoroutineScope r6 = r5;
        Iterator r7 = r4;
        String r8 = "ChatListComponentViewModel";
        IMMsg r9 = r3;
        Object r10 = r0;
        ChatListComponentViewModel$requirePushContent$1 r11 = this;
    L30:
        Message r14 = (Message) r13;
        if (r14 == null) goto L33;
        int r15 = (int) (r14.getLocalIndex() + 1);
    L34:
        r9.r(Boxing.boxInt(r15));
        ChatListComponentViewModel$requirePushContent$1 r16 = r11;
        r0 = r10;
        r2 = r8;
        Iterator r12 = r7;
        CoroutineScope r17 = r6;
    L35:
        Unit r18 = Unit.INSTANCE;
    L21:
        if (r12.hasNext() == false) goto L37;
        IMMsg r19 = (IMMsg) r12.next();
        if (r19.g() != null) goto L21;
        FLogger.a.i(r2, "requirePushContent: server index is null");
        String r20 = r19.c();
        if (r20 == null) goto L35;
        RepoDispatcher.a.getClass();
        ChatRepo r21 = RepoDispatcher.d;
        r16.L$0 = r17;
        r16.L$1 = r12;
        r16.L$2 = r19;
        r16.label = 2;
        Object r22 = r21.K1(r20, r16);
        if (r22 != r0) goto L29;
        return r0;
    L29:
        Object r110 = r0;
        r11 = r16;
        r13 = r22;
        r6 = r17;
        r7 = r12;
        r8 = r2;
        r9 = r19;
        r10 = r110;
    L37:
        return Unit.INSTANCE;
    L33:
        r15 = 0;
        goto L34
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        CoroutineScope r23 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r13);
    L13:
        MessageList r111 = (MessageList) r13;
        if (r111 == null) goto L37;
        List<IMMsg> r112 = r111.getMessageList();
        if (r112 == null) goto L37;
        List r113 = CollectionsKt.filterNotNull(r112);
        if (r113 == null) goto L37;
        r12 = r113.iterator();
        r17 = r23;
        r16 = this;
        goto L21
    L10:
        ResultKt.throwOnFailure(r13);
        r23 = (CoroutineScope) this.L$0;
        FLogger.a.i("ChatListComponentViewModel", "requirePushContent invoke...");
        RepoDispatcher.a.getClass();
        ChatRepo r114 = RepoDispatcher.d;
        String r24 = this.$groupId;
        String r25 = this.$userId;
        this.L$0 = r23;
        this.label = 1;
        r114.getClass();
        Lazy<ChatApi> r115 = ChatApi.a;
        ChatApi.a.a().getClass();
        r13 = ChatApi.f(r24, r25, this);
        if (r13 != r0) goto L13;
        return r0;
    }
}
