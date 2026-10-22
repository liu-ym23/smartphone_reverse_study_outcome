package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.chat.model.repo.ChatRepo;
import com.larus.bmhome.chat.model.repo.ChatSender;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.chat.model.repo.u1$a;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.list.ChatListComponentViewModel$replaceMessageForAuth$1", f = "ChatListComponentViewModel.kt", i = {}, l = {1194, 1196}, m = "invokeSuspend", n = {}, s = {})
public final class ChatListComponentViewModel$replaceMessageForAuth$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isMessageIdFromQuery;
    final /* synthetic */ Message $message;
    int label;
    final /* synthetic */ ChatListComponentViewModel this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.list.ChatListComponentViewModel$replaceMessageForAuth$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.list.ChatListComponentViewModel$replaceMessageForAuth$1$1", f = "ChatListComponentViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Message $question;
        int label;
        final /* synthetic */ ChatListComponentViewModel this$0;

        public AnonymousClass1(Message r1, ChatListComponentViewModel r2, Continuation<? super AnonymousClass1> r3) {
            this.$question = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$question, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L13;
            ResultKt.throwOnFailure(r5);
            String r6 = d.r(this.$question);
            if (r6 != null) goto L14;
            r6 = "";
        L14:
            r6 = new JSONObject(r6).optString(ChatDraftItem.TYPE_TEXT);     // Catch: JSONException -> L9
        L10:
            RepoDispatcher.a.getClass();
            ChatSender r0 = RepoDispatcher.d.e;
            Message r1 = this.$question;
            Intrinsics.checkNotNull(r6);
            u1$a.c(r0, r1, r6, this.$question.getExt(), ChatListComponentViewModel.access$getChatPageContext$p(this.this$0));
            return Unit.INSTANCE;
        L9:
            FLogger.a.e("ChatListComponentViewModel", "replaceMessageForAuth, contentText is not json");
            goto L10
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ChatListComponentViewModel$replaceMessageForAuth$1(boolean r1, Message r2, ChatListComponentViewModel r3, Continuation<? super ChatListComponentViewModel$replaceMessageForAuth$1> r4) {
        this.$isMessageIdFromQuery = r1;
        this.$message = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ChatListComponentViewModel$replaceMessageForAuth$1(this.$isMessageIdFromQuery, this.$message, this.this$0, r5);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r7);
    L24:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
    L16:
        Message r8 = (Message) r7;
        if (r8 == null) goto L19;
    L20:
        MainCoroutineDispatcher r2 = Dispatchers.getMain();
        AnonymousClass1 r3 = new AnonymousClass1(r8, this.this$0, null);
        this.label = 2;
        if (BuildersKt.withContext(r2, r3, this) != r0) goto L24;
        return r0;
    L19:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r7);
        if (this.$isMessageIdFromQuery == false) goto L13;
        r8 = this.$message;
        goto L20
    L13:
        RepoDispatcher.a.getClass();
        ChatRepo r9 = RepoDispatcher.d;
        Message r4 = this.$message;
        this.label = 1;
        r7 = r9.y1(r4, this);
        if (r7 != r0) goto L16;
        return r0;
    }
}
