package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.auth.douyin.IAiChatOpenDouyinAuthService;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.ChatRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.im.bean.message.Message;
import com.larus.platform.model.music.ThirdPartyMusicPlatform;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
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
@DebugMetadata(c = "com.larus.bmhome.chat.component.list.ChatListComponent$processAuthResult$1", f = "ChatListComponent.kt", i = {}, l = {2344}, m = "invokeSuspend", n = {}, s = {})
final class ChatListComponent$processAuthResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isMessageIdFromQuery;
    final /* synthetic */ Message $message;
    final /* synthetic */ ThirdPartyMusicPlatform $musicPlatform;
    int label;
    final /* synthetic */ ChatListComponent this$0;

    public ChatListComponent$processAuthResult$1(boolean r1, Message r2, ThirdPartyMusicPlatform r3, ChatListComponent r4, Continuation<? super ChatListComponent$processAuthResult$1> r5) {
        this.$isMessageIdFromQuery = r1;
        this.$message = r2;
        this.$musicPlatform = r3;
        this.this$0 = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ChatListComponent$processAuthResult$1(this.$isMessageIdFromQuery, this.$message, this.$musicPlatform, this.this$0, r8);
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
        String r3 = "";
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L20:
        if (((Message) r7) == null) goto L37;
        Message r8 = this.$message;
        ThirdPartyMusicPlatform r2 = this.$musicPlatform;
        ChatListComponent r4 = this.this$0;
        IAiChatOpenDouyinAuthService r5 = (IAiChatOpenDouyinAuthService) ServiceManager.get().getService(IAiChatOpenDouyinAuthService.class);
        if (r5 == null) goto L37;
        String r6 = r8.getMessageId();
        if (r6 != null) goto L26;
        r6 = "";
    L26:
        String r9 = r2.getValue();
        String r10 = r8.getConversationId();
        if (r10 != null) goto L29;
        r10 = "";
    L29:
        int r11 = ChatListComponent.W3;
        com.larus.bmhome.chat.component.cvs.y r12 = r4.u0();
        if (r12 == null) goto L35;
        String r13 = r12.getBotId();
        if (r13 == null) goto L35;
        r3 = r13;
    L35:
        r5.k(r6, r9, r10, r3);
    L37:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        if (this.$isMessageIdFromQuery == false) goto L13;
        String r14 = this.$message.getMessageId();
        if (r14 == null) goto L15;
    L16:
        RepoDispatcher.a.getClass();
        ChatRepo r15 = RepoDispatcher.d;
        this.label = 1;
        r7 = r15.E1(r14, this);
        if (r7 != r0) goto L20;
        return r0;
    L15:
        r14 = "";
        goto L16
    L13:
        r14 = this.$message.getReplyId();
        if (r14 != null) goto L16;
        goto L15
    }
}
