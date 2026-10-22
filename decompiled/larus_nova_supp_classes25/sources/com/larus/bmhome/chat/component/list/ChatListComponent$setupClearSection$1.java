package com.larus.bmhome.chat.component.list;

import android.content.Context;
import com.larus.bmhome.bot.utils.a;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.list.ChatListComponent$setupClearSection$1", f = "ChatListComponent.kt", i = {}, l = {3733}, m = "invokeSuspend", n = {}, s = {})
final class ChatListComponent$setupClearSection$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ChatListComponent this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.list.ChatListComponent$setupClearSection$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.list.ChatListComponent$setupClearSection$1$1", f = "ChatListComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ChatListComponent this$0;

        public AnonymousClass1(ChatListComponent r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((String) r1, (Continuation) r2);
        }

        public final Object invoke(String r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L21;
            ResultKt.throwOnFailure(r5);
            String r6 = (String) this.L$0;
            ChatListComponent r0 = this.this$0;
            int r1 = ChatListComponent.W3;
            r0.getClass();
            boolean r2 = true;
            if (ic8.n.s(r6) == false) goto L7;
            t19.s r7 = t19.s.a;
            Context r3 = r0.getContext();
            int r4 = ChatListComponent.a.a(true);
            r7.getClass();
            t19.s.o(r3, r4, false);
        L8:
            this.this$0.TP(false);
            com.larus.bmhome.instruction.g r8 = this.this$0.vc();
            if (r8 != null) goto L11;
        L13:
            r2 = false;
        L14:
            if (r2 == false) goto L18;
            FLogger.a.i(this.this$0.n, "receive clear section event ,close instruction");
            com.larus.bmhome.instruction.g r9 = this.this$0.vc();
            if (r9 == null) goto L18;
            r9.A1();
        L18:
            this.this$0.U5().checkAndUpdateAudioBtnClearCtxState(this.this$0.V0);
            return Unit.INSTANCE;
        L11:
            if (r8.z0() != true) goto L13;
        L7:
            r0.U5().clearSection(r6);
            goto L8
        L21:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ChatListComponent$setupClearSection$1(ChatListComponent r1, Continuation<? super ChatListComponent$setupClearSection$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ChatListComponent$setupClearSection$1(this.this$0, r3);
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
        MutableSharedFlow<wc9.e> r7 = a.a;
        MutableSharedFlow<String> r8 = a.b;
        AnonymousClass1 r2 = new AnonymousClass1(this.this$0, null);
        this.label = 1;
        if (kotlinx.coroutines.flow.e.i(r8, r2, this) != r0) goto L12;
        return r0;
    }
}
