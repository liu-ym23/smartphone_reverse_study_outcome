package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.platform.IFlowSdkDepend;
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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.list.ChatListComponent$setupAiRecordingStatusObserver$1", f = "ChatListComponent.kt", i = {}, l = {1808, 1808}, m = "invokeSuspend", n = {}, s = {})
final class ChatListComponent$setupAiRecordingStatusObserver$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ChatListComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ ChatListComponent a;

        public a(ChatListComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            final boolean r4 = ((Boolean) r2).booleanValue();
            final ChatListComponent r5 = this.a;
            com.larus.utils.t0.c(new l6(r4, r5));
            return Unit.INSTANCE;
        }
    }

    public ChatListComponent$setupAiRecordingStatusObserver$1(ChatListComponent r1, Continuation<? super ChatListComponent$setupAiRecordingStatusObserver$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ChatListComponent$setupAiRecordingStatusObserver$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r5);
    L21:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
    L15:
        Flow r6 = (Flow) r5;
        if (r6 == null) goto L21;
        a r2 = new a(this.this$0);
        this.label = 2;
        if (r6.collect(r2, this) != r0) goto L21;
        return r0;
    L10:
        ResultKt.throwOnFailure(r5);
        IFlowSdkDepend r7 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r7 == null) goto L21;
        r7.y();
        com.larus.home.impl.sdk.t1 r8 = com.larus.home.impl.sdk.t1.a;
        this.label = 1;
        r5 = r8.h(this);
        if (r5 != r0) goto L15;
        return r0;
    }
}
