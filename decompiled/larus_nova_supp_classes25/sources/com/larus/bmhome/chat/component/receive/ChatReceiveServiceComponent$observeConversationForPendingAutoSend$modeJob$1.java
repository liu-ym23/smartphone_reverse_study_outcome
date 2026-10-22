package com.larus.bmhome.chat.component.receive;

import androidx.lifecycle.FlowLiveDataConversions;
import com.larus.bmhome.auth.ConversationMode;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.v0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.receive.ChatReceiveServiceComponent$observeConversationForPendingAutoSend$modeJob$1", f = "ChatReceiveServiceComponent.kt", i = {}, l = {287}, m = "invokeSuspend", n = {}, s = {})
final class ChatReceiveServiceComponent$observeConversationForPendingAutoSend$modeJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.bmhome.chat.mode.e $modeAbility;
    int label;
    final /* synthetic */ ChatReceiveServiceComponent this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.receive.ChatReceiveServiceComponent$observeConversationForPendingAutoSend$modeJob$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/auth/ConversationMode;", "Lcom/larus/bmhome/chat/model/api/ConversationMode;", "<unused var>", "Lcom/larus/bmhome/chat/api/LaunchInfoWithStatus;", "mode"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.receive.ChatReceiveServiceComponent$observeConversationForPendingAutoSend$modeJob$1$1", f = "ChatReceiveServiceComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function3<e0, ConversationMode, Continuation<? super ConversationMode>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(3, r2);
        }

        public final Object invoke(e0 r1, ConversationMode r2, Continuation<? super ConversationMode> r3) {
            AnonymousClass1 r4 = new AnonymousClass1(r3);
            r4.L$0 = r2;
            return r4.invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
            return invoke((e0) r1, (ConversationMode) r2, (Continuation) r3);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            return (ConversationMode) this.L$0;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ ChatReceiveServiceComponent a;

        public a(ChatReceiveServiceComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r2) {
            ConversationMode r3 = (ConversationMode) r1;
            this.a.yy();
            return Unit.INSTANCE;
        }
    }

    public ChatReceiveServiceComponent$observeConversationForPendingAutoSend$modeJob$1(com.larus.bmhome.chat.mode.e r1, ChatReceiveServiceComponent r2, Continuation<? super ChatReceiveServiceComponent$observeConversationForPendingAutoSend$modeJob$1> r3) {
        this.$modeAbility = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatReceiveServiceComponent$observeConversationForPendingAutoSend$modeJob$1(this.$modeAbility, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        v0 r4 = new v0(FlowLiveDataConversions.asFlow(AuthModelDelegate.b.e()), this.$modeAbility.Si(), new AnonymousClass1(null));
        a r7 = new a(this.this$0);
        this.label = 1;
        if (r4.collect(r7, this) != r0) goto L12;
        return r0;
    }
}
