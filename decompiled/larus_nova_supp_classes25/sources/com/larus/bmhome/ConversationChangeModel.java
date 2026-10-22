package com.larus.bmhome;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
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
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\bJ\u000e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\bR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\n8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/larus/bmhome/ConversationChangeModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "_conversationListSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "conversationListSharedFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getConversationListSharedFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "_botListSharedFlow", "botListSharedFlow", "getBotListSharedFlow", "newChat", "Landroidx/lifecycle/MutableLiveData;", "", "getNewChat", "()Landroidx/lifecycle/MutableLiveData;", "sendConversationListChangeEvent", "Lkotlinx/coroutines/Job;", "botId", "sendBotListChangeEvent", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ConversationChangeModel extends AndroidViewModel {
    private final MutableSharedFlow<String> _botListSharedFlow;
    private final MutableSharedFlow<String> _conversationListSharedFlow;
    private final MutableLiveData<Boolean> newChat;

    /* JADX INFO: renamed from: com.larus.bmhome.ConversationChangeModel$sendBotListChangeEvent$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.ConversationChangeModel$sendBotListChangeEvent$1", f = "ConversationChangeModel.kt", i = {}, l = {MessageCellStateTransformerType.FORM_MSG}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $botId;
        int label;
        final /* synthetic */ ConversationChangeModel this$0;

        public AnonymousClass1(ConversationChangeModel r1, String r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$botId = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$botId, r4);
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
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            MutableSharedFlow r5 = ConversationChangeModel.access$get_botListSharedFlow$p(this.this$0);
            String r2 = this.$botId;
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.ConversationChangeModel$sendConversationListChangeEvent$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.ConversationChangeModel$sendConversationListChangeEvent$1", f = "ConversationChangeModel.kt", i = {}, l = {MessageCellStateTransformerType.NESTED_FILE}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01291 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $botId;
        int label;
        final /* synthetic */ ConversationChangeModel this$0;

        public C01291(ConversationChangeModel r1, String r2, Continuation<? super C01291> r3) {
            this.this$0 = r1;
            this.$botId = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01291(this.this$0, this.$botId, r4);
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
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            MutableSharedFlow r5 = ConversationChangeModel.access$get_conversationListSharedFlow$p(this.this$0);
            String r2 = this.$botId;
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    public final d1<String> getBotListSharedFlow() {
        return this._botListSharedFlow;
    }

    public final d1<String> getConversationListSharedFlow() {
        return this._conversationListSharedFlow;
    }

    public final MutableLiveData<Boolean> getNewChat() {
        return this.newChat;
    }

    public ConversationChangeModel(Application r4) {
        Intrinsics.checkNotNullParameter(r4, "application");
        super(r4);
        this._conversationListSharedFlow = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._botListSharedFlow = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.newChat = new MutableLiveData();
    }

    public static final /* synthetic */ MutableSharedFlow access$get_botListSharedFlow$p(ConversationChangeModel r0) {
        return r0._botListSharedFlow;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_conversationListSharedFlow$p(ConversationChangeModel r0) {
        return r0._conversationListSharedFlow;
    }

    public final Job sendBotListChangeEvent(String r8) {
        Intrinsics.checkNotNullParameter(r8, "botId");
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(this, r8, null), 2, null);
    }

    public final Job sendConversationListChangeEvent(String r8) {
        Intrinsics.checkNotNullParameter(r8, "botId");
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C01291(this, r8, null), 2, null);
    }
}
