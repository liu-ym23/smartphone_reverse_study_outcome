package com.larus.bmhome.chat.deepresearch.component;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.deepresearch.component.TimedBlockingQueue$startConsuming$1", f = "TimedBlockingQueue.kt", i = {0}, l = {22}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class TimedBlockingQueue$startConsuming$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Object, Unit> $onConsume;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ m0<Object> this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.deepresearch.component.TimedBlockingQueue$startConsuming$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.deepresearch.component.TimedBlockingQueue$startConsuming$1$1", f = "TimedBlockingQueue.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Object $item;
        final /* synthetic */ Function1<Object, Unit> $onConsume;
        int label;

        public AnonymousClass1(Function1<Object, Unit> r1, Object r2, Continuation<? super AnonymousClass1> r3) {
            this.$onConsume = r1;
            this.$item = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$onConsume, this.$item, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            this.$onConsume.invoke(this.$item);
            FLogger.a.d("TimedBlockingQueue", "onConsume");
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public TimedBlockingQueue$startConsuming$1(m0<Object> r1, Function1<Object, Unit> r2, Continuation<? super TimedBlockingQueue$startConsuming$1> r3) {
        this.this$0 = r1;
        this.$onConsume = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        TimedBlockingQueue$startConsuming$1 r0 = new TimedBlockingQueue$startConsuming$1(this.this$0, this.$onConsume, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r9);
    L11:
        if (CoroutineScopeKt.isActive(r2) == false) goto L19;
        m0<Object> r3 = this.this$0;
        Object r4 = r3.b.poll(r3.a, TimeUnit.MILLISECONDS);
        if (r4 == null) goto L14;
        MainCoroutineDispatcher r5 = Dispatchers.getMain();
        AnonymousClass1 r6 = new AnonymousClass1(this.$onConsume, r4, null);
        this.L$0 = r2;
        this.label = 1;
        if (BuildersKt.withContext(r5, r6, this) != r0) goto L11;
        return r0;
    L14:
        FLogger.a.d("TimedBlockingQueue", "poll:null");
        goto L11
    L19:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        r2 = (CoroutineScope) this.L$0;
        goto L11
    }
}
