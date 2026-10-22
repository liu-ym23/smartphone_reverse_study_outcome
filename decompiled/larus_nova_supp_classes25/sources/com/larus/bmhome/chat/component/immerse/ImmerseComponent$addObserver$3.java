package com.larus.bmhome.chat.component.immerse;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.instruction.g;
import com.larus.utils.o0;
import de8.c;
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
import s1a.a;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.immerse.ImmerseComponent$addObserver$3", f = "ImmerseComponent.kt", i = {}, l = {116}, m = "invokeSuspend", n = {}, s = {})
final class ImmerseComponent$addObserver$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ImmerseComponent this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.immerse.ImmerseComponent$addObserver$3$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/im/bean/conversation/Conversation;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.immerse.ImmerseComponent$addObserver$3$1", f = "ImmerseComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<e, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ImmerseComponent this$0;

        public AnonymousClass1(ImmerseComponent r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((e) r1, (Continuation) r2);
        }

        public final Object invoke(e r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L16;
            ResultKt.throwOnFailure(r3);
            ImmerseComponent r4 = this.this$0;
            int r0 = ImmerseComponent.t;
            c r5 = r4.f1();
            if (r5 == null) goto L7;
            String r6 = r5.h();
        L9:
            if (o0.d(r6) == false) goto L14;
            this.this$0.aq(false, true);
            g r7 = a.g(a.c(this.this$0)).getAbility(g.class);
            if (r7 == null) goto L14;
            r7.K90();
        L14:
            return Unit.INSTANCE;
        L7:
            r6 = null;
            goto L9
        L16:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ImmerseComponent$addObserver$3(ImmerseComponent r1, Continuation<? super ImmerseComponent$addObserver$3> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ImmerseComponent$addObserver$3(this.this$0, r3);
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
        MutableSharedFlow<e> r7 = com.larus.bmhome.bot.utils.a.a;
        MutableSharedFlow<e> r8 = com.larus.bmhome.bot.utils.a.a;
        AnonymousClass1 r2 = new AnonymousClass1(this.this$0, null);
        this.label = 1;
        if (kotlinx.coroutines.flow.e.i(r8, r2, this) != r0) goto L12;
        return r0;
    }
}
