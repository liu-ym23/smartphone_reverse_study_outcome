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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", f = "Combine.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {51, 73, 76}, m = "invokeSuspend", n = {"latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch", "latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch", "latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"})
final class CombineKt$combineInternal$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Object[]> $arrayFactory;
    final /* synthetic */ kotlinx.coroutines.flow.g[] $flows;
    final /* synthetic */ kotlinx.coroutines.flow.h $this_combineInternal;
    final /* synthetic */ Function3<kotlinx.coroutines.flow.h, Object[], Continuation<? super Unit>, Object> $transform;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1", f = "Combine.kt", i = {}, l = {28}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ kotlinx.coroutines.flow.g[] $flows;
        final /* synthetic */ int $i;
        final /* synthetic */ AtomicInteger $nonClosed;
        final /* synthetic */ kotlinx.coroutines.channels.i $resultChannel;
        int label;

        public AnonymousClass1(kotlinx.coroutines.flow.g[] r5, int r10, AtomicInteger r11, kotlinx.coroutines.channels.i r12, Continuation<? super AnonymousClass1> r13) {
            this.$flows = r5;
            this.$i = r10;
            this.$nonClosed = r11;
            this.$resultChannel = r12;
            super(2, r13);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.$flows, this.$i, this.$nonClosed, this.$resultChannel, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            return invoke2(r5, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.label;
            if (r11 == 0) goto L11;
            if (r11 != 1) goto L10;
            ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L7
        L15:
            if (this.$nonClosed.decrementAndGet() != 0) goto L19;
            this.$resultChannel.o(null);
        L19:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r10);
            kotlinx.coroutines.flow.g[] r12 = this.$flows;     // Catch: Throwable -> L7
            int r13 = this.$i;     // Catch: Throwable -> L7
            kotlinx.coroutines.flow.g r14 = r12[r13];     // Catch: Throwable -> L7
            k r15 = new k(this.$resultChannel, r13);     // Catch: Throwable -> L7
            this.label = 1;     // Catch: Throwable -> L7
            if (r14.collect(r15, this) != r5) goto L15;
            return r5;
        L7:
            th = move-exception;
            if (this.$nonClosed.decrementAndGet() != 0) goto L23;
            this.$resultChannel.o(null);
        L23:
            throw th;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
            return ((AnonymousClass1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CombineKt$combineInternal$2(kotlinx.coroutines.flow.g[] r5, Function0<Object[]> r10, Function3<? super kotlinx.coroutines.flow.h, ? super Object[], ? super Continuation<? super Unit>, ? extends Object> r11, kotlinx.coroutines.flow.h r12, Continuation<? super CombineKt$combineInternal$2> r13) {
        this.$flows = r5;
        this.$arrayFactory = r10;
        this.$transform = r11;
        this.$this_combineInternal = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        CombineKt$combineInternal$2 r12 = new CombineKt$combineInternal$2(this.$flows, this.$arrayFactory, this.$transform, this.$this_combineInternal, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return invoke2(r5, r10);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x011b -> B:20:0x00b3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0137 -> B:20:0x00b3). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r26) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.label;
        g8.g r11 = b.f18864c;
        if (r10 == 0) goto L12;
        if (r10 == 1) goto L11;
        if (r10 == 2) goto L10;
        if (r10 == 3) goto L10;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        int r12 = this.I$1;
        int r13 = this.I$0;
        byte[] r14 = (byte[]) this.L$2;
        kotlinx.coroutines.channels.i r15 = (kotlinx.coroutines.channels.i) this.L$1;
        Object[] r16 = (Object[]) this.L$0;
        ResultKt.throwOnFailure(r26);
        Object[] r17 = r16;
        int r18 = r12;
        byte[] r19 = r14;
        kotlinx.coroutines.channels.i r110 = r15;
    L20:
        r18 = (byte) (r18 + 1);
        this.L$0 = r17;
        this.L$1 = r110;
        this.L$2 = r19;
        this.I$0 = r13;
        this.I$1 = r18;
        this.label = 1;
        Object r111 = r110.a(this);
        if (r111 != r5) goto L24;
        return r5;
    L24:
        if ((r111 instanceof kotlinx.coroutines.channels.m) == false) goto L27;
        r111 = null;
    L27:
        IndexedValue r112 = (IndexedValue) r111;
        if (r112 == null) goto L30;
    L31:
        int r113 = r112.getIndex();
        Object r114 = r17[r113];
        r17[r113] = r112.getValue();
        if (r114 != r11) goto L35;
        r13 = r13 - 1;
    L35:
        if (r19[r113] == r18) goto L42;
        r19[r113] = (byte) r18;
        Object r115 = r110.j();
        if ((r115 instanceof kotlinx.coroutines.channels.m) == false) goto L40;
        r115 = null;
    L40:
        r112 = (IndexedValue) r115;
        if (r112 != null) goto L31;
    L42:
        if (r13 != 0) goto L20;
        Object[] r116 = this.$arrayFactory.invoke();
        if (r116 != null) goto L48;
        Function3<kotlinx.coroutines.flow.h, Object[], Continuation<? super Unit>, Object> r117 = this.$transform;
        kotlinx.coroutines.flow.h r118 = this.$this_combineInternal;
        this.L$0 = r17;
        this.L$1 = r110;
        this.L$2 = r19;
        this.I$0 = r13;
        this.I$1 = r18;
        this.label = 2;
        if (r117.invoke(r118, r17, this) != r5) goto L20;
        return r5;
    L48:
        ArraysKt.f(r17, r116, 0, 0, 14);
        Function3<kotlinx.coroutines.flow.h, Object[], Continuation<? super Unit>, Object> r119 = this.$transform;
        kotlinx.coroutines.flow.h r120 = this.$this_combineInternal;
        this.L$0 = r17;
        this.L$1 = r110;
        this.L$2 = r19;
        this.I$0 = r13;
        this.I$1 = r18;
        this.label = 3;
        if (r119.invoke(r120, r116, this) != r5) goto L20;
        return r5;
    L51:
        if (r13 != 0) goto L20;
        goto L20
    L30:
        return Unit.INSTANCE;
    L11:
        int r20 = this.I$1;
        r13 = this.I$0;
        byte[] r121 = (byte[]) this.L$2;
        kotlinx.coroutines.channels.i r122 = (kotlinx.coroutines.channels.i) this.L$1;
        Object[] r123 = (Object[]) this.L$0;
        ResultKt.throwOnFailure(r26);
        r111 = ((kotlinx.coroutines.channels.n) r26).f18815a;
        r17 = r123;
        r18 = r20;
        r19 = r121;
        r110 = r122;
        goto L24
    L12:
        ResultKt.throwOnFailure(r26);
        CoroutineScope r21 = (CoroutineScope) this.L$0;
        int r124 = this.$flows.length;
        if (r124 == 0) goto L15;
        r17 = new Object[r124];
        ArraysKt.j(r17, r11);
        kotlinx.coroutines.channels.f r22 = kotlinx.coroutines.channels.p.a(r124, 6, null);
        AtomicInteger r125 = new AtomicInteger(r124);
        int r126 = 0;
    L17:
        if (r126 >= r124) goto L19;
        int r127 = r126;
        AtomicInteger r128 = r125;
        BuildersKt.launch$default(r21, null, null, new AnonymousClass1(this.$flows, r127, r128, r22, null), 3, null);
        r126 = r127 + 1;
        r17 = r17;
        r125 = r128;
        goto L17
    L19:
        r19 = new byte[r124];
        r18 = 0;
        r13 = r124;
        r110 = r22;
        goto L20
    L15:
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((CombineKt$combineInternal$2) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
