package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import xc8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.list.ChatListComponentViewModel$init$1", f = "ChatListComponentViewModel.kt", i = {}, l = {313}, m = "invokeSuspend", n = {}, s = {})
public final class ChatListComponentViewModel$init$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<wc9.e> $getConversation;
    int label;
    final /* synthetic */ ChatListComponentViewModel this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ Function0<wc9.e> a;
        public final /* synthetic */ ChatListComponentViewModel b;

        public a(Function0<wc9.e> r1, ChatListComponentViewModel r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object emit(Object r3, Continuation r4) {
            String r5 = (String) r3;
            Function0<wc9.e> r6 = this.a;
            Message r0 = null;
            if (r6 == null) goto L5;
            wc9.e r7 = (wc9.e) r6.invoke();
        L6:
            if (r7 == null) goto L8;
            String r8 = r7.a;
        L10:
            if (Intrinsics.areEqual(r5, r8) == false) goto L31;
            com.larus.bmhome.social.page.datasource.event.c r9 = ChatListComponentViewModel.access$getCurrentMessageListData$p(this.b);
            if (r9 == null) goto L26;
            List r10 = r9.a;
            if (r10 == null) goto L26;
            Iterator<T> r11 = r10.iterator();
        L18:
            if (r11.hasNext() == false) goto L22;
            T r12 = r11.next();
            if (d.G0(((b) r12).getMessage()) == false) goto L18;
        L23:
            b r13 = r12;
            if (r13 == null) goto L26;
            r0 = r13.getMessage();
            goto L26
        L22:
            r12 = (T) null;
        L26:
            FLogger.a.i("ChatListComponentViewModel", "receive clearContextSuccessEvent latestMsgSendBySelf " + r0);
            ChatListComponentViewModel.access$setSelfSendMsgTriggerNoLoading(this.b, r0);
            return Unit.INSTANCE;
        L31:
            return Unit.INSTANCE;
        L8:
            r8 = null;
            goto L10
        L5:
            r7 = null;
            goto L6
        }
    }

    public ChatListComponentViewModel$init$1(Function0<wc9.e> r1, ChatListComponentViewModel r2, Continuation<? super ChatListComponentViewModel$init$1> r3) {
        this.$getConversation = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatListComponentViewModel$init$1(this.$getConversation, this.this$0, r4);
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
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r6);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        RepoDispatcher.a.getClass();
        MutableSharedFlow r7 = RepoDispatcher.f.e;
        a r2 = new a(this.$getConversation, this.this$0);
        this.label = 1;
        if (r7.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
