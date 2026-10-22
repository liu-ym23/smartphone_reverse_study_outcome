package kotlinx.coroutines.flow.internal;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.IntCompanionObject;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.f2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "R", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", f = "Combine.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {51, 73, 76}, m = "invokeSuspend", n = {"latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch", "latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch", "latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"})
public final class CombineKt$combineInternal$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<T[]> $arrayFactory;
    final /* synthetic */ Flow<T>[] $flows;
    final /* synthetic */ FlowCollector<R> $this_combineInternal;
    final /* synthetic */ Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> $transform;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "R", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1", f = "Combine.kt", i = {}, l = {28}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Flow<T>[] $flows;
        final /* synthetic */ int $i;
        final /* synthetic */ AtomicInteger $nonClosed;
        final /* synthetic */ Channel<IndexedValue<Object>> $resultChannel;
        int label;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00231<T> implements FlowCollector {
            public final /* synthetic */ Channel<IndexedValue<Object>> a;
            public final /* synthetic */ int b;

            public C00231(Channel<IndexedValue<Object>> r1, int r2) {
                this.a = r1;
                this.b = r2;
            }

            public final Object emit(T r7, Continuation<? super Unit> r8) {
                if ((r8 instanceof CombineKt$combineInternal$2$1$1$emit$1) == false) goto L7;
                CombineKt$combineInternal$2$1$1$emit$1 r0 = (CombineKt$combineInternal$2$1$1$emit$1) r8;
                int r1 = r0.label;
                if ((r1 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
                r0.label = r1 - IntCompanionObject.MIN_VALUE;
            L8:
                Object r9 = r0.result;
                Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r3 = r0.label;
                if (r3 == 0) goto L16;
                if (r3 == 1) goto L15;
                if (r3 != 2) goto L14;
                ResultKt.throwOnFailure(r9);
            L23:
                return Unit.INSTANCE;
            L14:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L15:
                ResultKt.throwOnFailure(r9);
            L19:
                r0.label = 2;
                if (f2.a(r0) != r2) goto L23;
                return r2;
            L16:
                ResultKt.throwOnFailure(r9);
                Channel<IndexedValue<Object>> r10 = this.a;
                IndexedValue<Object> r4 = new IndexedValue(this.b, r7);
                r0.label = 1;
                if (r10.send(r4, r0) != r2) goto L19;
                return r2;
            L7:
                r0 = new CombineKt$combineInternal$2$1$1$emit$1(this, r8);
                goto L8
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Flow<? extends T>[] r1, int r2, AtomicInteger r3, Channel<IndexedValue<Object>> r4, Continuation<? super AnonymousClass1> r5) {
            this.$flows = r1;
            this.$i = r2;
            this.$nonClosed = r3;
            this.$resultChannel = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.$flows, this.$i, this.$nonClosed, this.$resultChannel, r8);
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
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L18
        L13:
            if (this.$nonClosed.decrementAndGet() != 0) goto L17;
            SendChannel.a.a(this.$resultChannel);
        L17:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r6);
            Flow[] r7 = this.$flows;     // Catch: Throwable -> L18
            int r2 = this.$i;     // Catch: Throwable -> L18
            Flow r8 = r7[r2];     // Catch: Throwable -> L18
            C00231 r3 = new C00231(this.$resultChannel, r2);     // Catch: Throwable -> L18
            this.label = 1;     // Catch: Throwable -> L18
            if (r8.collect(r3, this) != r0) goto L13;
            return r0;
        L18:
            th = move-exception;
            if (this.$nonClosed.decrementAndGet() != 0) goto L22;
            SendChannel.a.a(this.$resultChannel);
        L22:
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CombineKt$combineInternal$2(Flow<? extends T>[] r1, Function0<T[]> r2, Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> r3, FlowCollector<? super R> r4, Continuation<? super CombineKt$combineInternal$2> r5) {
        this.$flows = r1;
        this.$arrayFactory = r2;
        this.$transform = r3;
        this.$this_combineInternal = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        CombineKt$combineInternal$2 r6 = new CombineKt$combineInternal$2(this.$flows, this.$arrayFactory, this.$transform, this.$this_combineInternal, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x012b -> B:20:0x00c0). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r23) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        int r4 = 2;
        if (r2 == 0) goto L12;
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L10;
        if (r2 != 3) goto L9;
        int r3 = this.I$1;
        int r6 = this.I$0;
        byte[] r7 = (byte[]) this.L$2;
        Channel r8 = (Channel) this.L$1;
        Object[] r9 = (Object[]) this.L$0;
        ResultKt.throwOnFailure(r23);
        int r21 = r3;
        byte[] r5 = r7;
        Channel r10 = r8;
        Object[] r13 = r9;
        CombineKt$combineInternal$2 r11 = this;
    L45:
        r4 = 2;
    L20:
        byte r12 = (byte) (r21 + 1);
        r11.L$0 = r13;
        r11.L$1 = r10;
        r11.L$2 = r5;
        r11.I$0 = r6;
        r11.I$1 = r12;
        r11.label = 1;
        Object r14 = r10.mo528receiveCatchingJP2dKIU(r11);
        if (r14 != r1) goto L23;
        return r1;
    L23:
        int r15 = r12;
        Object[] r16 = r13;
    L24:
        IndexedValue r17 = (IndexedValue) kotlinx.coroutines.channels.g.b(r14);
        if (r17 == null) goto L27;
    L28:
        int r18 = r17.getIndex();
        Object r19 = r16[r18];
        r16[r18] = r17.getValue();
        if (r19 != o.b) goto L32;
        r6 = r6 - 1;
    L32:
        if (r5[r18] == r15) goto L35;
        r5[r18] = (byte) r15;
        r17 = (IndexedValue) kotlinx.coroutines.channels.g.b(r10.mo529tryReceivePtdJZtk());
        if (r17 != null) goto L28;
    L35:
        if (r6 != 0) goto L48;
        Object[] r110 = (Object[]) r11.$arrayFactory.invoke();
        if (r110 != null) goto L42;
        Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> r111 = r11.$transform;
        FlowCollector<R> r112 = r11.$this_combineInternal;
        r11.L$0 = r16;
        r11.L$1 = r10;
        r11.L$2 = r5;
        r11.I$0 = r6;
        r11.I$1 = r15;
        r11.label = r4;
        if (r111.invoke(r112, r16, r11) != r1) goto L41;
        return r1;
    L41:
        r13 = r16;
        r21 = r15;
        goto L20
    L42:
        int r20 = r15;
        ArraysKt.copyInto$default(r16, r110, 0, 0, 0, 14, null);
        Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> r113 = r11.$transform;
        FlowCollector<R> r114 = r11.$this_combineInternal;
        r11.L$0 = r16;
        r11.L$1 = r10;
        r11.L$2 = r5;
        r11.I$0 = r6;
        r11.I$1 = r20;
        r11.label = 3;
        if (r113.invoke(r114, r110, r11) != r1) goto L47;
        return r1;
    L47:
        r21 = r20;
        r13 = r16;
        goto L45
    L48:
        r21 = r15;
        r13 = r16;
        goto L45
    L27:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        int r22 = this.I$1;
        r6 = this.I$0;
        byte[] r24 = (byte[]) this.L$2;
        Channel r25 = (Channel) this.L$1;
        Object[] r26 = (Object[]) this.L$0;
        ResultKt.throwOnFailure(r23);
        r21 = r22;
        r5 = r24;
        r10 = r25;
        r13 = r26;
        r11 = this;
        goto L20
    L11:
        int r27 = this.I$1;
        r6 = this.I$0;
        byte[] r28 = (byte[]) this.L$2;
        Channel r29 = (Channel) this.L$1;
        r16 = (Object[]) this.L$0;
        ResultKt.throwOnFailure(r23);
        r14 = ((kotlinx.coroutines.channels.g) r23).a;
        r15 = r27;
        r5 = r28;
        r10 = r29;
        r11 = this;
        goto L24
    L12:
        ResultKt.throwOnFailure(r23);
        CoroutineScope r30 = (CoroutineScope) this.L$0;
        int r115 = this.$flows.length;
        if (r115 == 0) goto L15;
        r13 = new Object[r115];
        ArraysKt.fill$default(r13, o.b, 0, 0, 6, null);
        Channel r210 = ChannelKt.Channel$default(r115, null, null, 6, null);
        AtomicInteger r116 = new AtomicInteger(r115);
        r21 = 0;
        int r117 = 0;
    L17:
        if (r117 >= r115) goto L19;
        int r118 = r117;
        BuildersKt.launch$default(r30, null, null, new AnonymousClass1(this.$flows, r118, r116, r210, null), 3, null);
        r117 = r118 + 1;
        r116 = r116;
        goto L17
    L19:
        r5 = new byte[r115];
        r11 = this;
        r6 = r115;
        r10 = r210;
        goto L20
    L15:
        return Unit.INSTANCE;
    }
}
