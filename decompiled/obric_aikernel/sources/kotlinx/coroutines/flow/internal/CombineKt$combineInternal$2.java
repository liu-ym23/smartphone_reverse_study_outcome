package kotlinx.coroutines.flow.internal;

import java.util.concurrent.atomic.AtomicInteger;
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
import kotlinx.coroutines.e3;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", f = "Combine.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {54, 76, 79}, m = "invokeSuspend", n = {"latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch", "latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch", "latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"})
final class CombineKt$combineInternal$2 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<T[]> $arrayFactory;
    final /* synthetic */ kotlinx.coroutines.flow.c<T>[] $flows;
    final /* synthetic */ kotlinx.coroutines.flow.d<R> $this_combineInternal;
    final /* synthetic */ Function3<kotlinx.coroutines.flow.d<? super R>, T[], Continuation<? super Unit>, Object> $transform;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1, reason: invalid class name */
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1", f = "Combine.kt", i = {}, l = {31}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
        final /* synthetic */ kotlinx.coroutines.flow.c<T>[] $flows;
        final /* synthetic */ int $i;
        final /* synthetic */ AtomicInteger $nonClosed;
        final /* synthetic */ kotlinx.coroutines.channels.d<IndexedValue<Object>> $resultChannel;
        int label;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02251<T> implements kotlinx.coroutines.flow.d {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.channels.d<IndexedValue<Object>> f10473c;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ int f10474g;

            C02251(kotlinx.coroutines.channels.d<IndexedValue<Object>> r10, int r11) {
                this.f10473c = r10;
                this.f10474g = r11;
            }

            @Override // kotlinx.coroutines.flow.d
            public final Object emit(T r10, Continuation<? super Unit> r11) {
                if ((r11 instanceof CombineKt$combineInternal$2$1$1$emit$1) == false) goto L7;
                CombineKt$combineInternal$2$1$1$emit$1 r12 = (CombineKt$combineInternal$2$1$1$emit$1) r11;
                int r13 = r12.label;
                if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
                r12.label = r13 - Integer.MIN_VALUE;
            L8:
                Object r14 = r12.result;
                Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r16 = r12.label;
                if (r16 == 0) goto L16;
                if (r16 == 1) goto L15;
                if (r16 != 2) goto L14;
                ResultKt.throwOnFailure(r14);
            L23:
                return Unit.INSTANCE;
            L14:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L15:
                ResultKt.throwOnFailure(r14);
            L19:
                r12.label = 2;
                if (e3.a(r12) != r15) goto L23;
                return r15;
            L16:
                ResultKt.throwOnFailure(r14);
                kotlinx.coroutines.channels.d<IndexedValue<Object>> r17 = this.f10473c;
                IndexedValue<Object> r18 = new IndexedValue(this.f10474g, r10);
                r12.label = 1;
                if (r17.H(r18, r12) != r15) goto L19;
                return r15;
            L7:
                r12 = new CombineKt$combineInternal$2$1$1$emit$1(this, r11);
                goto L8
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(kotlinx.coroutines.flow.c<? extends T>[] r10, int r11, AtomicInteger r12, kotlinx.coroutines.channels.d<IndexedValue<Object>> r13, Continuation<? super AnonymousClass1> r14) {
            this.$flows = r10;
            this.$i = r11;
            this.$nonClosed = r12;
            this.$resultChannel = r13;
            super(2, r14);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.$flows, this.$i, this.$nonClosed, this.$resultChannel, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r12 = this.label;
            if (r12 == 0) goto L11;
            if (r12 != 1) goto L10;
            ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L7
        L15:
            if (this.$nonClosed.decrementAndGet() != 0) goto L19;
            kotlinx.coroutines.channels.n.a.a(this.$resultChannel, null, 1, null);
        L19:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r10);
            kotlinx.coroutines.flow.c[] r13 = this.$flows;     // Catch: Throwable -> L7
            int r14 = this.$i;     // Catch: Throwable -> L7
            kotlinx.coroutines.flow.c r15 = r13[r14];     // Catch: Throwable -> L7
            C02251 r16 = new C02251(this.$resultChannel, r14);     // Catch: Throwable -> L7
            this.label = 1;     // Catch: Throwable -> L7
            if (r15.a(r16, this) != r11) goto L15;
            return r11;
        L7:
            th = move-exception;
            if (this.$nonClosed.decrementAndGet() != 0) goto L23;
            kotlinx.coroutines.channels.n.a.a(this.$resultChannel, null, 1, null);
        L23:
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    CombineKt$combineInternal$2(kotlinx.coroutines.flow.c<? extends T>[] r10, Function0<T[]> r11, Function3<? super kotlinx.coroutines.flow.d<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> r12, kotlinx.coroutines.flow.d<? super R> r13, Continuation<? super CombineKt$combineInternal$2> r14) {
        this.$flows = r10;
        this.$arrayFactory = r11;
        this.$transform = r12;
        this.$this_combineInternal = r13;
        super(2, r14);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        CombineKt$combineInternal$2 r12 = new CombineKt$combineInternal$2(this.$flows, this.$arrayFactory, this.$transform, this.$this_combineInternal, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((CombineKt$combineInternal$2) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0138 -> B:20:0x00a9). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r24) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        int r12 = 0;
        if (r11 == 0) goto L12;
        if (r11 == 1) goto L11;
        if (r11 == 2) goto L10;
        if (r11 == 3) goto L10;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        int r13 = this.I$1;
        int r14 = this.I$0;
        byte[] r15 = (byte[]) this.L$2;
        kotlinx.coroutines.channels.d r16 = (kotlinx.coroutines.channels.d) this.L$1;
        Object[] r17 = (Object[]) this.L$0;
        ResultKt.throwOnFailure(r24);
        int r18 = r14;
        Object[] r19 = r17;
        r12 = r13;
        byte[] r20 = r15;
        kotlinx.coroutines.channels.d r21 = r16;
    L20:
        byte r22 = (byte) (r12 + 1);
        this.L$0 = r19;
        this.L$1 = r21;
        this.L$2 = r20;
        this.I$0 = r18;
        this.I$1 = r22;
        this.label = 1;
        Object r110 = r21.g(this);
        if (r110 != r10) goto L23;
        return r10;
    L23:
        kotlinx.coroutines.channels.d r23 = r21;
        Object[] r25 = r19;
        int r26 = r22;
        int r27 = r18;
    L24:
        IndexedValue r111 = (IndexedValue) kotlinx.coroutines.channels.g.f(r110);
        if (r111 == null) goto L27;
    L28:
        int r112 = r111.getIndex();
        Object r113 = r25[r112];
        r25[r112] = r111.getValue();
        if (r113 != n.f10496b) goto L32;
        r27 = r27 - 1;
    L32:
        if (r20[r112] == r26) goto L35;
        r20[r112] = (byte) r26;
        r111 = (IndexedValue) kotlinx.coroutines.channels.g.f(r23.e());
        if (r111 != null) goto L28;
    L35:
        if (r27 != 0) goto L44;
        Object[] r114 = (Object[]) this.$arrayFactory.invoke();
        if (r114 != null) goto L41;
        Function3<kotlinx.coroutines.flow.d<? super R>, T[], Continuation<? super Unit>, Object> r115 = this.$transform;
        Object r116 = this.$this_combineInternal;
        this.L$0 = r25;
        this.L$1 = r23;
        this.L$2 = r20;
        this.I$0 = r27;
        this.I$1 = r26;
        this.label = 2;
        if (r115.invoke(r116, r25, this) != r10) goto L44;
        return r10;
    L41:
        ArraysKt.copyInto$default(r25, r114, 0, 0, 0, 14, null);
        Function3<kotlinx.coroutines.flow.d<? super R>, T[], Continuation<? super Unit>, Object> r117 = this.$transform;
        Object r118 = this.$this_combineInternal;
        this.L$0 = r25;
        this.L$1 = r23;
        this.L$2 = r20;
        this.I$0 = r27;
        this.I$1 = r26;
        this.label = 3;
        if (r117.invoke(r118, r114, this) != r10) goto L44;
        return r10;
    L44:
        r18 = r27;
        r12 = r26;
        r21 = r23;
        r19 = r25;
        goto L20
    L27:
        return Unit.INSTANCE;
    L11:
        int r28 = this.I$1;
        r27 = this.I$0;
        byte[] r29 = (byte[]) this.L$2;
        r23 = (kotlinx.coroutines.channels.d) this.L$1;
        r25 = (Object[]) this.L$0;
        ResultKt.throwOnFailure(r24);
        r110 = ((kotlinx.coroutines.channels.g) r24).k();
        r26 = r28;
        r20 = r29;
        goto L24
    L12:
        ResultKt.throwOnFailure(r24);
        l0 r30 = (l0) this.L$0;
        r18 = this.$flows.length;
        if (r18 == 0) goto L15;
        r19 = new Object[r18];
        ArraysKt.fill$default(r19, n.f10496b, 0, 0, 6, null);
        kotlinx.coroutines.channels.d r210 = kotlinx.coroutines.channels.f.b(r18, null, null, 6, null);
        AtomicInteger r119 = new AtomicInteger(r18);
        int r120 = 0;
    L17:
        if (r120 >= r18) goto L19;
        int r121 = r120;
        kotlinx.coroutines.h.d(r30, null, null, new AnonymousClass1(this.$flows, r121, r119, r210, null), 3, null);
        r120 = r121 + 1;
        r119 = r119;
        goto L17
    L19:
        r20 = new byte[r18];
        r21 = r210;
        goto L20
    L15:
        return Unit.INSTANCE;
    }
}
