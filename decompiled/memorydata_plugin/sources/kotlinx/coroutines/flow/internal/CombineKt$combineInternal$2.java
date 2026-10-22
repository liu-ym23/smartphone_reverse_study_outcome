package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
import kotlinx.coroutines.al;
import kotlinx.coroutines.channels.z;
import kotlinx.coroutines.dg;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "R", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", f = "Combine.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {51, 73, 76}, m = "invokeSuspend", n = {"latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch", "latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch", "latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"})
final class CombineKt$combineInternal$2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<T[]> $arrayFactory;
    final /* synthetic */ kotlinx.coroutines.flow.i<T>[] $flows;
    final /* synthetic */ kotlinx.coroutines.flow.j<R> $this_combineInternal;
    final /* synthetic */ Function3<kotlinx.coroutines.flow.j<? super R>, T[], Continuation<? super Unit>, Object> $transform;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "R", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1", f = "Combine.kt", i = {}, l = {28}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ kotlinx.coroutines.flow.i<T>[] $flows;
        final /* synthetic */ int $i;
        final /* synthetic */ AtomicInteger $nonClosed;
        final /* synthetic */ kotlinx.coroutines.channels.i<IndexedValue<Object>> $resultChannel;
        int label;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "R", ExifInterface.GPS_DIRECTION_TRUE, EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        static final class C08811<T> implements kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.channels.i<IndexedValue<Object>> f17445a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f17446b;

            C08811(kotlinx.coroutines.channels.i<IndexedValue<Object>> r3, int r4) {
                this.f17445a = (kotlinx.coroutines.channels.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.channels.i.class, "com.obric.memorydata.plugin");
                this.f17446b = r4;
            }

            @Override // kotlinx.coroutines.flow.j
            public final Object emit(T r6, Continuation<? super Unit> r7) {
                Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r8, CombineKt$combineInternal$2$1$1$emit$1.class) == false) goto L7;
                CombineKt$combineInternal$2$1$1$emit$1 r0 = (CombineKt$combineInternal$2$1$1$emit$1) ZeusTransformUtils.preCheckCast(r8, CombineKt$combineInternal$2$1$1$emit$1.class, "com.obric.memorydata.plugin");
                if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
                r0.label -= Integer.MIN_VALUE;
            L8:
                Object r9 = r0.result;
                Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r2 = r0.label;
                if (r2 == 0) goto L16;
                if (r2 == 1) goto L15;
                if (r2 != 2) goto L14;
                ResultKt.throwOnFailure(r9);
            L23:
                return Unit.INSTANCE;
            L14:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L15:
                ResultKt.throwOnFailure(r9);
            L19:
                r0.label = 2;
                if (dg.a(r0) != r1) goto L23;
                return r1;
            L16:
                ResultKt.throwOnFailure(r9);
                kotlinx.coroutines.channels.i<IndexedValue<Object>> r10 = this.f17445a;
                IndexedValue<Object> r3 = new IndexedValue(this.f17446b, r6);
                r0.label = 1;
                if (r10.send(r3, r0) != r1) goto L19;
                return r1;
            L7:
                r0 = new CombineKt$combineInternal$2$1$1$emit$1(this, r8);
                goto L8
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(kotlinx.coroutines.flow.i<? extends T>[] r3, int r4, AtomicInteger r5, kotlinx.coroutines.channels.i<IndexedValue<Object>> r6, Continuation<? super AnonymousClass1> r7) {
            kotlinx.coroutines.channels.i<IndexedValue<Object>> r8 = (kotlinx.coroutines.channels.i) ZeusTransformUtils.wrapperContextForParams(r6, kotlinx.coroutines.channels.i.class, "com.obric.memorydata.plugin");
            Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
            this.$flows = r3;
            this.$i = r4;
            this.$nonClosed = r5;
            this.$resultChannel = r8;
            super(2, r9);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$flows, this.$i, this.$nonClosed, this.$resultChannel, r6), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L11;
            if (r1 != 1) goto L10;
            ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L7
        L15:
            if (this.$nonClosed.decrementAndGet() != 0) goto L19;
            z.a.a((z) ZeusTransformUtils.preCheckCast(this.$resultChannel, z.class, "com.obric.memorydata.plugin"), null, 1, null);
        L19:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r8);
            kotlinx.coroutines.flow.i r9 = this.$flows[this.$i];     // Catch: Throwable -> L7
            kotlinx.coroutines.flow.j r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new C08811(this.$resultChannel, this.$i), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            this.label = 1;     // Catch: Throwable -> L7
            if (r9.collect(r2, r5) != r0) goto L15;
            return r0;
        L7:
            th = move-exception;
            if (this.$nonClosed.decrementAndGet() != 0) goto L23;
            z.a.a((z) ZeusTransformUtils.preCheckCast(this.$resultChannel, z.class, "com.obric.memorydata.plugin"), null, 1, null);
        L23:
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    CombineKt$combineInternal$2(kotlinx.coroutines.flow.i<? extends T>[] r3, Function0<T[]> r4, Function3<? super kotlinx.coroutines.flow.j<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> r5, kotlinx.coroutines.flow.j<? super R> r6, Continuation<? super CombineKt$combineInternal$2> r7) {
        Function0<T[]> r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Function3<kotlinx.coroutines.flow.j<? super R>, T[], Continuation<? super Unit>, Object> r9 = (Function3) ZeusTransformUtils.wrapperContextForParams(r5, Function3.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.flow.j<R> r10 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r6, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        this.$flows = r3;
        this.$arrayFactory = r8;
        this.$transform = r9;
        this.$this_combineInternal = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        CombineKt$combineInternal$2 r11 = new CombineKt$combineInternal$2(this.$flows, this.$arrayFactory, this.$transform, this.$this_combineInternal, r7);
        r11.L$0 = r9;
        return (Continuation) ZeusTransformUtils.preCheckCast(r11, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((CombineKt$combineInternal$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), CombineKt$combineInternal$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0164 -> B:44:0x018b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0188 -> B:44:0x018b). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r25) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = this.label;
        int r4 = 0;
        if (r3 == 0) goto L12;
        if (r3 == 1) goto L11;
        if (r3 == 2) goto L10;
        if (r3 == 3) goto L10;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        int r5 = this.I$1;
        int r6 = this.I$0;
        byte[] r1 = (byte[]) ZeusTransformUtils.preCheckCast(this.L$2, byte[].class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.channels.i r9 = (kotlinx.coroutines.channels.i) ZeusTransformUtils.preCheckCast(this.L$1, kotlinx.coroutines.channels.i.class, "com.obric.memorydata.plugin");
        Object[] r10 = (Object[]) ZeusTransformUtils.preCheckCast(this.L$0, Object[].class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r25);
    L44:
        Object[] r15 = r10;
        int r23 = r6;
        r4 = r5;
        int r7 = r23;
    L20:
        byte r8 = (byte) (r4 + 1);
        Continuation r11 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r15;
        this.L$1 = r9;
        this.L$2 = r1;
        this.I$0 = r7;
        this.I$1 = r8;
        this.label = 1;
        Object r12 = r9.b(r11);
        if (r12 != r2) goto L23;
        return r2;
    L23:
        r10 = r15;
        r6 = r7;
        r5 = r8;
    L24:
        IndexedValue r13 = (IndexedValue) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.channels.m.d(r12), IndexedValue.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L27;
    L28:
        int r14 = r13.getIndex();
        Object r16 = r10[r14];
        r10[r14] = r13.getValue();
        if (r16 != s.f17464b) goto L32;
        r6 = r6 - 1;
    L32:
        if (r1[r14] == r5) goto L35;
        r1[r14] = (byte) r5;
        r13 = (IndexedValue) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.channels.m.d(r9.i()), IndexedValue.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L28;
    L35:
        if (r6 != 0) goto L44;
        Object[] r17 = (Object[]) ZeusTransformUtils.preCheckCast(this.$arrayFactory.invoke(), Object[].class, "com.obric.memorydata.plugin");
        if (r17 != null) goto L41;
        Function3<kotlinx.coroutines.flow.j<? super R>, T[], Continuation<? super Unit>, Object> r18 = this.$transform;
        Object r19 = this.$this_combineInternal;
        this.L$0 = r10;
        this.L$1 = r9;
        this.L$2 = r1;
        this.I$0 = r6;
        this.I$1 = r5;
        this.label = 2;
        if (r18.invoke(r19, r10, this) != r2) goto L44;
        return r2;
    L41:
        ArraysKt.copyInto$default(r10, r17, 0, 0, 0, 14, null);
        Function3<kotlinx.coroutines.flow.j<? super R>, T[], Continuation<? super Unit>, Object> r110 = this.$transform;
        Object r111 = this.$this_combineInternal;
        this.L$0 = r10;
        this.L$1 = r9;
        this.L$2 = r1;
        this.I$0 = r6;
        this.I$1 = r5;
        this.label = 3;
        if (r110.invoke(r111, r17, this) != r2) goto L44;
        return r2;
    L45:
        if (r6 != 0) goto L44;
        goto L44
    L27:
        return Unit.INSTANCE;
    L11:
        r5 = this.I$1;
        r6 = this.I$0;
        r1 = (byte[]) ZeusTransformUtils.preCheckCast(this.L$2, byte[].class, "com.obric.memorydata.plugin");
        r9 = (kotlinx.coroutines.channels.i) ZeusTransformUtils.preCheckCast(this.L$1, kotlinx.coroutines.channels.i.class, "com.obric.memorydata.plugin");
        r10 = (Object[]) ZeusTransformUtils.preCheckCast(this.L$0, Object[].class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r25);
        r12 = ((kotlinx.coroutines.channels.m) ZeusTransformUtils.preCheckCast(r25, kotlinx.coroutines.channels.m.class, "com.obric.memorydata.plugin")).a();
        goto L24
    L12:
        ResultKt.throwOnFailure(r25);
        al r20 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        r7 = this.$flows.length;
        if (r7 == 0) goto L15;
        r15 = new Object[r7];
        ArraysKt.fill$default(r15, s.f17464b, 0, 0, 6, null);
        kotlinx.coroutines.channels.i r22 = kotlinx.coroutines.channels.l.a(r7, null, null, 6, null);
        AtomicInteger r112 = new AtomicInteger(r7);
        int r113 = 0;
    L17:
        if (r113 >= r7) goto L19;
        int r114 = r113;
        kotlinx.coroutines.i.a(r20, null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$flows, r114, r112, r22, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        r113 = r114 + 1;
        r112 = r112;
        goto L17
    L19:
        r1 = new byte[r7];
        r9 = r22;
        goto L20
    L15:
        return Unit.INSTANCE;
    }
}
