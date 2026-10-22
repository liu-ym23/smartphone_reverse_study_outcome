package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.al;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.j;
import kotlinx.coroutines.flow.k;
import kotlinx.coroutines.z;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0082\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u0006\"\u0004\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00050\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00032?\b\u0004\u0010\b\u001a9\b\u0001\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u0006\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tH\u0080Hø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001ah\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0011\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00110\u000329\b\u0004\u0010\b\u001a3\b\u0001\u0012\u0013\u0012\u0011H\u0011¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0013\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012H\u0080\bø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001ab\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0011\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00110\u000323\b\u0004\u0010\b\u001a-\b\u0001\u0012\u0013\u0012\u0011H\u0011¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012H\u0080\bø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001an\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0003\"\u0004\b\u0000\u0010\u0011*\b\u0012\u0004\u0012\u0002H\u00110\u00032F\u0010\u0017\u001aB\b\u0001\u0012\u0013\u0012\u0011H\u0011¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u0011¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0018H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u001a\u001a|\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0011\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00110\u00032\u0006\u0010\u001c\u001a\u0002H\u00042F\u0010\u0017\u001aB\b\u0001\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u0011¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0018H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u001d\u001ap\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0011\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00110\u00032B\u0010\b\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u001f\u0012\u0013\u0012\u0011H\u0011¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0018¢\u0006\u0002\b!H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u001a\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"NULL", "", "combineWithoutBatching", "Lkotlinx/coroutines/flow/Flow;", "R", "T1", "T2", "otherFlow", "transform", "Lkotlin/Function4;", "Landroidx/paging/CombineSource;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "updateFrom", "Lkotlin/coroutines/Continuation;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function4;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "simpleFlatMapLatest", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function2;", EventBody.KEY_VALUE, "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "simpleMapLatest", "simpleRunningReduce", "operation", "Lkotlin/Function3;", "accumulator", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "simpleScan", "initial", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "simpleTransformLatest", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lkotlin/ExtensionFunctionType;", "paging-common"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FlowExtKt {
    private static final Object NULL = null;

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.paging.FlowExtKt$combineWithoutBatching$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H\u008a@"}, d2 = {"<anonymous>", "", "T1", "T2", "R", "Landroidx/paging/SimpleProducerScope;"}, k = 3, mv = {1, 8, 0}, xi = 176)
    @DebugMetadata(c = "androidx.paging.FlowExtKt$combineWithoutBatching$2", f = "FlowExt.kt", i = {}, l = {162}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2<R> extends SuspendLambda implements Function2<SimpleProducerScope<R>, Continuation<? super Unit>, Object> {
        final /* synthetic */ i<T2> $otherFlow;
        final /* synthetic */ i<T1> $this_combineWithoutBatching;
        final /* synthetic */ Function4<T1, T2, CombineSource, Continuation<? super R>, Object> $transform;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.paging.FlowExtKt$combineWithoutBatching$2$2, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T1", "T2", "R", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
        public static final class C00292 extends Lambda implements Function0<Unit> {
            final /* synthetic */ z $parentJob;

            public C00292(z r3) {
                this.$parentJob = (z) ZeusTransformUtils.wrapperContextForParams(r3, z.class, "com.obric.memorydata.plugin");
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                bx.a.a((bx) ZeusTransformUtils.preCheckCast(this.$parentJob, bx.class, "com.obric.memorydata.plugin"), null, 1, null);
            }
        }

        public AnonymousClass2(i<? extends T1> r3, i<? extends T2> r4, Function4<? super T1, ? super T2, ? super CombineSource, ? super Continuation<? super R>, ? extends Object> r5, Continuation<? super AnonymousClass2> r6) {
            i<T1> r7 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.memorydata.plugin");
            i<T2> r8 = (i) ZeusTransformUtils.wrapperContextForParams(r4, i.class, "com.obric.memorydata.plugin");
            Function4<T1, T2, CombineSource, Continuation<? super R>, Object> r9 = (Function4) ZeusTransformUtils.wrapperContextForParams(r5, Function4.class, "com.obric.memorydata.plugin");
            Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.$this_combineWithoutBatching = r7;
            this.$otherFlow = r8;
            this.$transform = r9;
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass2 r0 = new AnonymousClass2(this.$this_combineWithoutBatching, this.$otherFlow, this.$transform, r7);
            r0.L$0 = r5;
            return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        }

        public final Object invoke(SimpleProducerScope<R> r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((SimpleProducerScope) ZeusTransformUtils.wrapperContextForParams(r3, SimpleProducerScope.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(Object r3, Continuation<? super Unit> r4) {
            return invoke((SimpleProducerScope) ZeusTransformUtils.preCheckCast(r3, SimpleProducerScope.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r26) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            ResultKt.throwOnFailure(r26);
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r26);
            SimpleProducerScope r3 = (SimpleProducerScope) ZeusTransformUtils.preCheckCast(this.L$0, SimpleProducerScope.class, "com.obric.memorydata.plugin");
            int r13 = 2;
            AtomicInteger r4 = new AtomicInteger(2);
            UnbatchedFlowCombiner r14 = new UnbatchedFlowCombiner((Function4) ZeusTransformUtils.preCheckCast(new FlowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1(r3, this.$transform, null), Function4.class, "com.obric.memorydata.plugin"));
            z r15 = ca.a(null, 1, null);
            i[] r12 = {this.$this_combineWithoutBatching, this.$otherFlow};
            int r11 = 0;
            int r16 = 0;
        L9:
            if (r11 >= r13) goto L11;
            kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (CoroutineContext) ZeusTransformUtils.preCheckCast(r15, CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new FlowExtKt$combineWithoutBatching$2$1$1(r12[r11], r4, r3, r14, r16, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
            r11 = r11 + 1;
            r12 = r12;
            r16 = r16 + 1;
            r13 = 2;
            goto L9
        L11:
            Function0<Unit> r5 = (Function0) ZeusTransformUtils.preCheckCast(new C00292(r15), Function0.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r3.awaitClose(r5, r6) != r1) goto L15;
            return r1;
        }

        public final Object invokeSuspend$$forInline(Object r26) {
            SimpleProducerScope r1 = (SimpleProducerScope) ZeusTransformUtils.preCheckCast(this.L$0, SimpleProducerScope.class, "com.obric.memorydata.plugin");
            int r11 = 2;
            AtomicInteger r2 = new AtomicInteger(2);
            UnbatchedFlowCombiner r12 = new UnbatchedFlowCombiner((Function4) ZeusTransformUtils.preCheckCast(new FlowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1(r1, this.$transform, null), Function4.class, "com.obric.memorydata.plugin"));
            z r14 = ca.a(null, 1, null);
            i[] r15 = {this.$this_combineWithoutBatching, this.$otherFlow};
            int r4 = 0;
            int r10 = 0;
        L3:
            if (r10 >= r11) goto L5;
            int r17 = r4 + 1;
            kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(r1, al.class, "com.obric.memorydata.plugin"), (CoroutineContext) ZeusTransformUtils.preCheckCast(r14, CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new FlowExtKt$combineWithoutBatching$2$1$1((i) ZeusTransformUtils.preCheckCast(r15[r10], i.class, "com.obric.memorydata.plugin"), r2, r1, r12, ((Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(r4), Number.class, "com.obric.memorydata.plugin")).intValue(), null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
            Unit r5 = Unit.INSTANCE;
            r10 = r10 + 1;
            r4 = r17;
            r11 = 2;
            goto L3
        L5:
            Function0<Unit> r3 = (Function0) ZeusTransformUtils.preCheckCast(new C00292(r14), Function0.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r0 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            InlineMarker.mark(0);
            r1.awaitClose(r3, r0);
            InlineMarker.mark(1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R, T] */
    /* JADX INFO: renamed from: androidx.paging.FlowExtKt$simpleFlatMapLatest$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it"}, k = 3, mv = {1, 8, 0}, xi = 176)
    @DebugMetadata(c = "androidx.paging.FlowExtKt$simpleFlatMapLatest$1", f = "FlowExt.kt", i = {}, l = {99, 99}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1<R, T> extends SuspendLambda implements Function3<j<? super R>, T, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<T, Continuation<? super i<? extends R>>, Object> $transform;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        public AnonymousClass1(Function2<? super T, ? super Continuation<? super i<? extends R>>, ? extends Object> r3, Continuation<? super AnonymousClass1> r4) {
            Function2<T, Continuation<? super i<? extends R>>, Object> r5 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.$transform = r5;
            super(3, r6);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function3
        public /* synthetic */ Object invoke(Object r3, Object r4, Continuation<? super Unit> r5) {
            return invoke((j) ZeusTransformUtils.preCheckCast(r3, j.class, "com.obric.memorydata.plugin"), r4, (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin"));
        }

        public final Object invoke(j<? super R> r3, T r4, Continuation<? super Unit> r5) {
            j r6 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin");
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass1 r0 = new AnonymousClass1(this.$transform, r7);
            r0.L$0 = r6;
            r0.L$1 = r4;
            return r0.invokeSuspend(Unit.INSTANCE);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to androidx.paging.FlowExtKt$simpleFlatMapLatest$1<R, T> for r6v4 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = r6.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L7;
            kotlin.ResultKt.throwOnFailure(r7);
        L16:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE;
            return r6;
        L7:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw r6;
        L9:
            java.lang.Object r1 = r6.L$0;
            java.lang.Object r1 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r1, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            kotlinx.coroutines.flow.j r1 = (kotlinx.coroutines.flow.j) r1;
            kotlin.ResultKt.throwOnFailure(r7);
        L13:
            java.lang.Object r7 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r7, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            kotlinx.coroutines.flow.i r7 = (kotlinx.coroutines.flow.i) r7;
            java.lang.Object r3 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r6, kotlin.coroutines.Continuation.class, "com.obric.memorydata.plugin");
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3;
            r6.L$0 = null;
            r6.label = 2;
            java.lang.Object r6 = kotlinx.coroutines.flow.k.a(r1, r7, r3);
            if (r6 != r0) goto L16;
            return r0;
        L10:
            kotlin.ResultKt.throwOnFailure(r7);
            java.lang.Object r7 = r6.L$0;
            java.lang.Object r7 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r7, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            r1 = (kotlinx.coroutines.flow.j) r7;
            java.lang.Object r7 = r6.L$1;
            kotlin.jvm.functions.Function2<T, kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.i<? extends R>>, java.lang.Object> r5 = r6.$transform;
            r6.L$0 = r1;
            r6.label = 1;
            T r7 = (T) r7;
            java.lang.Object r6 = (kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.i<? extends R>>) r6;
            r7 = r5.invoke(r7, r6);
            if (r7 != r0) goto L13;
            return r0;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to androidx.paging.FlowExtKt$simpleFlatMapLatest$1<R, T> for r3v5 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        public final java.lang.Object invokeSuspend$$forInline(java.lang.Object r4) {
            java.lang.Object r4 = r3.L$0;
            java.lang.Object r4 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r4, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            kotlinx.coroutines.flow.j r4 = (kotlinx.coroutines.flow.j) r4;
            java.lang.Object r0 = r3.L$1;
            kotlin.jvm.functions.Function2<T, kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.i<? extends R>>, java.lang.Object> r2 = r3.$transform;
            T r0 = (T) r0;
            java.lang.Object r3 = (kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.i<? extends R>>) r3;
            java.lang.Object r0 = r2.invoke(r0, r3);
            java.lang.Object r0 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r0, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            kotlinx.coroutines.flow.i r0 = (kotlinx.coroutines.flow.i) r0;
            java.lang.Object r3 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r3, kotlin.coroutines.Continuation.class, "com.obric.memorydata.plugin");
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3;
            kotlin.jvm.internal.InlineMarker.mark(0);
            kotlinx.coroutines.flow.k.a(r4, r0, r3);
            kotlin.jvm.internal.InlineMarker.mark(1);
            kotlin.Unit r3 = kotlin.Unit.INSTANCE;
            return r3;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R, T] */
    /* JADX INFO: renamed from: androidx.paging.FlowExtKt$simpleMapLatest$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it"}, k = 3, mv = {1, 8, 0}, xi = 176)
    @DebugMetadata(c = "androidx.paging.FlowExtKt$simpleMapLatest$1", f = "FlowExt.kt", i = {}, l = {106, 106}, m = "invokeSuspend", n = {}, s = {})
    public static final class C09381<R, T> extends SuspendLambda implements Function3<j<? super R>, T, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<T, Continuation<? super R>, Object> $transform;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        public C09381(Function2<? super T, ? super Continuation<? super R>, ? extends Object> r3, Continuation<? super C09381> r4) {
            Function2<T, Continuation<? super R>, Object> r5 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.$transform = r5;
            super(3, r6);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function3
        public /* synthetic */ Object invoke(Object r3, Object r4, Continuation<? super Unit> r5) {
            return invoke((j) ZeusTransformUtils.preCheckCast(r3, j.class, "com.obric.memorydata.plugin"), r4, (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin"));
        }

        public final Object invoke(j<? super R> r3, T r4, Continuation<? super Unit> r5) {
            j r6 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin");
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            C09381 r0 = new C09381(this.$transform, r7);
            r0.L$0 = r6;
            r0.L$1 = r4;
            return r0.invokeSuspend(Unit.INSTANCE);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to androidx.paging.FlowExtKt$simpleMapLatest$1<R, T> for r6v4 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = r6.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L7;
            kotlin.ResultKt.throwOnFailure(r7);
        L16:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE;
            return r6;
        L7:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw r6;
        L9:
            java.lang.Object r1 = r6.L$0;
            java.lang.Object r1 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r1, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            kotlinx.coroutines.flow.j r1 = (kotlinx.coroutines.flow.j) r1;
            kotlin.ResultKt.throwOnFailure(r7);
            kotlinx.coroutines.flow.j r1 = r1;
        L13:
            java.lang.Object r3 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r6, kotlin.coroutines.Continuation.class, "com.obric.memorydata.plugin");
            kotlin.coroutines.Continuation<? super kotlin.Unit> r3 = (kotlin.coroutines.Continuation) r3;
            r6.L$0 = null;
            r6.label = 2;
            java.lang.Object r6 = r1.emit(r7, r3);
            if (r6 != r0) goto L16;
            return r0;
        L10:
            kotlin.ResultKt.throwOnFailure(r7);
            java.lang.Object r7 = r6.L$0;
            java.lang.Object r7 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r7, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            kotlinx.coroutines.flow.j r1 = (kotlinx.coroutines.flow.j) r7;
            java.lang.Object r7 = r6.L$1;
            kotlin.jvm.functions.Function2<T, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r5 = r6.$transform;
            r6.L$0 = r1;
            r6.label = 1;
            T r7 = (T) r7;
            java.lang.Object r6 = (kotlin.coroutines.Continuation<? super R>) r6;
            r7 = r5.invoke(r7, r6);
            r1 = r1;
            if (r7 != r0) goto L13;
            return r0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to androidx.paging.FlowExtKt$simpleMapLatest$1<R, T> for r3v5 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        public final java.lang.Object invokeSuspend$$forInline(java.lang.Object r4) {
            java.lang.Object r4 = r3.L$0;
            java.lang.Object r4 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r4, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            kotlinx.coroutines.flow.j r4 = (kotlinx.coroutines.flow.j) r4;
            java.lang.Object r0 = r3.L$1;
            kotlin.jvm.functions.Function2<T, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r2 = r3.$transform;
            T r0 = (T) r0;
            java.lang.Object r3 = (kotlin.coroutines.Continuation<? super R>) r3;
            java.lang.Object r0 = r2.invoke(r0, r3);
            java.lang.Object r3 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r3, kotlin.coroutines.Continuation.class, "com.obric.memorydata.plugin");
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3;
            kotlin.jvm.internal.InlineMarker.mark(0);
            r4.emit(r0, r3);
            kotlin.jvm.internal.InlineMarker.mark(1);
            kotlin.Unit r3 = kotlin.Unit.INSTANCE;
            return r3;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.paging.FlowExtKt$simpleRunningReduce$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.FlowExtKt$simpleRunningReduce$1", f = "FlowExt.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
    static final class C09391<T> extends SuspendLambda implements Function2<j<? super T>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<T, T, Continuation<? super T>, Object> $operation;
        final /* synthetic */ i<T> $this_simpleRunningReduce;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.paging.FlowExtKt$simpleRunningReduce$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        static final class C00301<T> implements j {
            final /* synthetic */ j<T> $$this$flow;
            final /* synthetic */ Ref.ObjectRef<Object> $accumulator;
            final /* synthetic */ Function3<T, T, Continuation<? super T>, Object> $operation;

            C00301(Ref.ObjectRef<Object> r3, Function3<? super T, ? super T, ? super Continuation<? super T>, ? extends Object> r4, j<? super T> r5) {
                Function3<T, T, Continuation<? super T>, Object> r6 = (Function3) ZeusTransformUtils.wrapperContextForParams(r4, Function3.class, "com.obric.memorydata.plugin");
                j<T> r7 = (j) ZeusTransformUtils.wrapperContextForParams(r5, j.class, "com.obric.memorydata.plugin");
                this.$accumulator = r3;
                this.$operation = r6;
                this.$$this$flow = r7;
            }

            @Override // kotlinx.coroutines.flow.j
            public final Object emit(T r8, Continuation<? super Unit> r9) {
                Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r10, FlowExtKt$simpleRunningReduce$1$1$emit$1.class) == false) goto L7;
                FlowExtKt$simpleRunningReduce$1$1$emit$1 r0 = (FlowExtKt$simpleRunningReduce$1$1$emit$1) ZeusTransformUtils.preCheckCast(r10, FlowExtKt$simpleRunningReduce$1$1$emit$1.class, "com.obric.memorydata.plugin");
                if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
                r0.label -= Integer.MIN_VALUE;
            L8:
                Object r11 = r0.result;
                Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r3 = r0.label;
                if (r3 == 0) goto L16;
                if (r3 == 1) goto L15;
                if (r3 != 2) goto L14;
                ResultKt.throwOnFailure(r11);
            L28:
                return Unit.INSTANCE;
            L14:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L15:
                Ref.ObjectRef<Object> r7 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r0.L$1, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
                C00301<T> r12 = (C00301) ZeusTransformUtils.preCheckCast(r0.L$0, C00301.class, "com.obric.memorydata.plugin");
                ResultKt.throwOnFailure(r11);
            L23:
                Object r6 = r11;
                Ref.ObjectRef<Object> r13 = r7;
                C00301<T> this = r12;
                r8 = (T) r6;
            L24:
                r13.element = r8;
                j<T> r14 = this.$$this$flow;
                T r15 = this.$accumulator.element;
                r0.L$0 = null;
                r0.L$1 = null;
                r0.label = 2;
                if (r14.emit(r15, r0) != r2) goto L28;
                return r2;
            L16:
                ResultKt.throwOnFailure(r11);
                r13 = this.$accumulator;
                if (r13.element == FlowExtKt.access$getNULL$p()) goto L24;
                Function3<T, T, Continuation<? super T>, Object> r1 = this.$operation;
                T r4 = this.$accumulator.element;
                r0.L$0 = this;
                r0.L$1 = r13;
                r0.label = 1;
                Object r16 = r1.invoke(r4, r8, r0);
                if (r16 != r2) goto L22;
                return r2;
            L22:
                r12 = this;
                r7 = r13;
                r11 = r16;
            L7:
                r0 = new FlowExtKt$simpleRunningReduce$1$1$emit$1(this, r10);
                goto L8
            }
        }

        C09391(i<? extends T> r3, Function3<? super T, ? super T, ? super Continuation<? super T>, ? extends Object> r4, Continuation<? super C09391> r5) {
            i<T> r6 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.memorydata.plugin");
            Function3<T, T, Continuation<? super T>, Object> r7 = (Function3) ZeusTransformUtils.wrapperContextForParams(r4, Function3.class, "com.obric.memorydata.plugin");
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.$this_simpleRunningReduce = r6;
            this.$operation = r7;
            super(2, r8);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            C09391 r0 = new C09391(this.$this_simpleRunningReduce, this.$operation, r6);
            r0.L$0 = r4;
            return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(Object r3, Continuation<? super Unit> r4) {
            return invoke((j) ZeusTransformUtils.preCheckCast(r3, j.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        public final Object invoke(j<? super T> r3, Continuation<? super Unit> r4) {
            return ((C09391) ZeusTransformUtils.preCheckCast(create((j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C09391.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            j r9 = (j) ZeusTransformUtils.preCheckCast(this.L$0, j.class, "com.obric.memorydata.plugin");
            Ref.ObjectRef r2 = new Ref.ObjectRef();
            r2.element = (T) FlowExtKt.access$getNULL$p();
            i<T> r4 = this.$this_simpleRunningReduce;
            j<? super T> r10 = (j) ZeusTransformUtils.preCheckCast(new C00301(r2, this.$operation, r9), j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r4.collect(r10, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.paging.FlowExtKt$simpleScan$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.FlowExtKt$simpleScan$1", f = "FlowExt.kt", i = {0, 0}, l = {55, 56}, m = "invokeSuspend", n = {"$this$flow", "accumulator"}, s = {"L$0", "L$1"})
    static final class C09401<R> extends SuspendLambda implements Function2<j<? super R>, Continuation<? super Unit>, Object> {
        final /* synthetic */ R $initial;
        final /* synthetic */ Function3<R, T, Continuation<? super R>, Object> $operation;
        final /* synthetic */ i<T> $this_simpleScan;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX INFO: renamed from: androidx.paging.FlowExtKt$simpleScan$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        static final class C00311<T> implements j {
            final /* synthetic */ j<R> $$this$flow;
            final /* synthetic */ Ref.ObjectRef<R> $accumulator;
            final /* synthetic */ Function3<R, T, Continuation<? super R>, Object> $operation;

            C00311(Ref.ObjectRef<R> r3, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> r4, j<? super R> r5) {
                Function3<R, T, Continuation<? super R>, Object> r6 = (Function3) ZeusTransformUtils.wrapperContextForParams(r4, Function3.class, "com.obric.memorydata.plugin");
                j<R> r7 = (j) ZeusTransformUtils.wrapperContextForParams(r5, j.class, "com.obric.memorydata.plugin");
                this.$accumulator = r3;
                this.$operation = r6;
                this.$$this$flow = r7;
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // kotlinx.coroutines.flow.j
            public final Object emit(T r8, Continuation<? super Unit> r9) {
                Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r10, FlowExtKt$simpleScan$1$1$emit$1.class) == false) goto L7;
                FlowExtKt$simpleScan$1$1$emit$1 r0 = (FlowExtKt$simpleScan$1$1$emit$1) ZeusTransformUtils.preCheckCast(r10, FlowExtKt$simpleScan$1$1$emit$1.class, "com.obric.memorydata.plugin");
                if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
                r0.label -= Integer.MIN_VALUE;
            L8:
                Object r11 = r0.result;
                Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r3 = r0.label;
                if (r3 == 0) goto L16;
                if (r3 == 1) goto L15;
                if (r3 != 2) goto L14;
                ResultKt.throwOnFailure(r11);
            L24:
                return Unit.INSTANCE;
            L14:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L15:
                Ref.ObjectRef<R> r7 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r0.L$1, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
                C00311<T> r12 = (C00311) ZeusTransformUtils.preCheckCast(r0.L$0, C00311.class, "com.obric.memorydata.plugin");
                ResultKt.throwOnFailure(r11);
            L20:
                r7.element = (T) r11;
                j<R> r13 = r12.$$this$flow;
                R r14 = r12.$accumulator.element;
                r0.L$0 = null;
                r0.L$1 = null;
                r0.label = 2;
                if (r13.emit(r14, r0) != r2) goto L24;
                return r2;
            L16:
                ResultKt.throwOnFailure(r11);
                Ref.ObjectRef<R> r15 = this.$accumulator;
                Function3<R, T, Continuation<? super R>, Object> r1 = this.$operation;
                R r4 = r15.element;
                r0.L$0 = this;
                r0.L$1 = r15;
                r0.label = 1;
                Object r16 = r1.invoke(r4, r8, r0);
                if (r16 != r2) goto L19;
                return r2;
            L19:
                r12 = this;
                r7 = r15;
                r11 = (T) r16;
            L7:
                r0 = new FlowExtKt$simpleScan$1$1$emit$1(this, r10);
                goto L8
            }
        }

        C09401(R r3, i<? extends T> r4, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> r5, Continuation<? super C09401> r6) {
            i<T> r7 = (i) ZeusTransformUtils.wrapperContextForParams(r4, i.class, "com.obric.memorydata.plugin");
            Function3<R, T, Continuation<? super R>, Object> r8 = (Function3) ZeusTransformUtils.wrapperContextForParams(r5, Function3.class, "com.obric.memorydata.plugin");
            Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.$initial = r3;
            this.$this_simpleScan = r7;
            this.$operation = r8;
            super(2, r9);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            C09401 r0 = new C09401(this.$initial, this.$this_simpleScan, this.$operation, r7);
            r0.L$0 = r5;
            return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(Object r3, Continuation<? super Unit> r4) {
            return invoke((j) ZeusTransformUtils.preCheckCast(r3, j.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        public final Object invoke(j<? super R> r3, Continuation<? super Unit> r4) {
            return ((C09401) ZeusTransformUtils.preCheckCast(create((j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C09401.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r8);
        L18:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            Ref.ObjectRef r2 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(this.L$1, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
            j r3 = (j) ZeusTransformUtils.preCheckCast(this.L$0, j.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r8);
        L14:
            i<T> r9 = this.$this_simpleScan;
            j r4 = (j) ZeusTransformUtils.preCheckCast(new C00311(r2, this.$operation, r3), j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = null;
            this.L$1 = null;
            this.label = 2;
            if (r9.collect((j<? super T>) r4, r5) != r0) goto L18;
            return r0;
        L10:
            ResultKt.throwOnFailure(r8);
            j r10 = (j) ZeusTransformUtils.preCheckCast(this.L$0, j.class, "com.obric.memorydata.plugin");
            r2 = new Ref.ObjectRef();
            r2.element = this.$initial;
            T r6 = r2.element;
            Continuation<? super Unit> r7 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = r10;
            this.L$1 = r2;
            this.label = 1;
            if (r10.emit(r6, r7) != r0) goto L13;
            return r0;
        L13:
            r3 = r10;
            goto L14
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.paging.FlowExtKt$simpleTransformLatest$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "Landroidx/paging/SimpleProducerScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.FlowExtKt$simpleTransformLatest$1", f = "FlowExt.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
    static final class C09411<R> extends SuspendLambda implements Function2<SimpleProducerScope<R>, Continuation<? super Unit>, Object> {
        final /* synthetic */ i<T> $this_simpleTransformLatest;
        final /* synthetic */ Function3<j<? super R>, T, Continuation<? super Unit>, Object> $transform;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: Add missing generic type declarations: [T] */
        /* JADX INFO: renamed from: androidx.paging.FlowExtKt$simpleTransformLatest$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.paging.FlowExtKt$simpleTransformLatest$1$1", f = "FlowExt.kt", i = {}, l = {90}, m = "invokeSuspend", n = {}, s = {})
        static final class C00321<T> extends SuspendLambda implements Function2<T, Continuation<? super Unit>, Object> {
            final /* synthetic */ ChannelFlowCollector<R> $collector;
            final /* synthetic */ Function3<j<? super R>, T, Continuation<? super Unit>, Object> $transform;
            /* synthetic */ Object L$0;
            int label;

            C00321(Function3<? super j<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> r3, ChannelFlowCollector<R> r4, Continuation<? super C00321> r5) {
                Function3<j<? super R>, T, Continuation<? super Unit>, Object> r6 = (Function3) ZeusTransformUtils.wrapperContextForParams(r3, Function3.class, "com.obric.memorydata.plugin");
                Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
                this.$transform = r6;
                this.$collector = r4;
                super(2, r7);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
                C00321 r0 = new C00321(this.$transform, this.$collector, r6);
                r0.L$0 = r4;
                return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(Object r3, Continuation<? super Unit> r4) {
                return invoke2(r3, (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(T r3, Continuation<? super Unit> r4) {
                return ((C00321) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C00321.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
                jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to androidx.paging.FlowExtKt$simpleTransformLatest$1$1<T> for r4v4 'this'  java.lang.Object
                	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
                	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
                	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
                	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
                	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
                */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final java.lang.Object invokeSuspend(java.lang.Object r5) {
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = r4.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L6;
                kotlin.ResultKt.throwOnFailure(r5);
            L11:
                kotlin.Unit r4 = kotlin.Unit.INSTANCE;
                return r4;
            L6:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw r4;
            L8:
                kotlin.ResultKt.throwOnFailure(r5);
                java.lang.Object r5 = r4.L$0;
                kotlin.jvm.functions.Function3<kotlinx.coroutines.flow.j<? super R>, T, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r1 = r4.$transform;
                androidx.paging.ChannelFlowCollector<R> r3 = r4.$collector;
                r4.label = 1;
                androidx.paging.ChannelFlowCollector<R> r3 = r3;
                T r5 = (T) r5;
                java.lang.Object r4 = (kotlin.coroutines.Continuation<? super kotlin.Unit>) r4;
                java.lang.Object r4 = r1.invoke(r3, r5, r4);
                if (r4 != r0) goto L11;
                return r0;
            }
        }

        C09411(i<? extends T> r3, Function3<? super j<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> r4, Continuation<? super C09411> r5) {
            i<T> r6 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.memorydata.plugin");
            Function3<j<? super R>, T, Continuation<? super Unit>, Object> r7 = (Function3) ZeusTransformUtils.wrapperContextForParams(r4, Function3.class, "com.obric.memorydata.plugin");
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.$this_simpleTransformLatest = r6;
            this.$transform = r7;
            super(2, r8);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            C09411 r0 = new C09411(this.$this_simpleTransformLatest, this.$transform, r6);
            r0.L$0 = r4;
            return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        }

        public final Object invoke(SimpleProducerScope<R> r3, Continuation<? super Unit> r4) {
            return ((C09411) ZeusTransformUtils.preCheckCast(create((SimpleProducerScope) ZeusTransformUtils.wrapperContextForParams(r3, SimpleProducerScope.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C09411.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(Object r3, Continuation<? super Unit> r4) {
            return invoke((SimpleProducerScope) ZeusTransformUtils.preCheckCast(r3, SimpleProducerScope.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            SimpleProducerScope r9 = (SimpleProducerScope) ZeusTransformUtils.preCheckCast(this.L$0, SimpleProducerScope.class, "com.obric.memorydata.plugin");
            i<T> r2 = this.$this_simpleTransformLatest;
            ChannelFlowCollector r4 = new ChannelFlowCollector((kotlinx.coroutines.channels.z) ZeusTransformUtils.preCheckCast(r9, kotlinx.coroutines.channels.z.class, "com.obric.memorydata.plugin"));
            Function2 r10 = (Function2) ZeusTransformUtils.preCheckCast(new C00321(this.$transform, r4, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (k.a(r2, r10, r3) != r0) goto L12;
            return r0;
        }
    }

    static {
        NULL = new Object();
    }

    public static final /* synthetic */ Object access$getNULL$p() {
        return NULL;
    }

    public static final <T1, T2, R> Object combineWithoutBatching(i<? extends T1> r2, i<? extends T2> r3, Function4<? super T1, ? super T2, ? super CombineSource, ? super Continuation<? super R>, ? extends Object> r4, Continuation<? super i<? extends R>> r5) {
        i r6 = (i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin");
        i r7 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.memorydata.plugin");
        Function4 r8 = (Function4) ZeusTransformUtils.wrapperContextForParams(r4, Function4.class, "com.obric.memorydata.plugin");
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return SimpleChannelFlowKt.simpleChannelFlow((Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r6, r7, r8, null), Function2.class, "com.obric.memorydata.plugin"));
    }

    private static final <T1, T2, R> Object combineWithoutBatching$$forInline(i<? extends T1> r2, i<? extends T2> r3, Function4<? super T1, ? super T2, ? super CombineSource, ? super Continuation<? super R>, ? extends Object> r4, Continuation<? super i<? extends R>> r5) {
        i r6 = (i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin");
        i r7 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.memorydata.plugin");
        Function4 r8 = (Function4) ZeusTransformUtils.wrapperContextForParams(r4, Function4.class, "com.obric.memorydata.plugin");
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return SimpleChannelFlowKt.simpleChannelFlow((Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r6, r7, r8, null), Function2.class, "com.obric.memorydata.plugin"));
    }

    public static final <T, R> i<R> simpleFlatMapLatest(i<? extends T> r3, Function2<? super T, ? super Continuation<? super i<? extends R>>, ? extends Object> r4) {
        i r5 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.memorydata.plugin");
        Function2 r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "transform");
        return simpleTransformLatest(r5, (Function3) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r6, null), Function3.class, "com.obric.memorydata.plugin"));
    }

    public static final <T, R> i<R> simpleMapLatest(i<? extends T> r3, Function2<? super T, ? super Continuation<? super R>, ? extends Object> r4) {
        i r5 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.memorydata.plugin");
        Function2 r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "transform");
        return simpleTransformLatest(r5, (Function3) ZeusTransformUtils.preCheckCast(new C09381(r6, null), Function3.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> i<T> simpleRunningReduce(i<? extends T> r3, Function3<? super T, ? super T, ? super Continuation<? super T>, ? extends Object> r4) {
        i r5 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.memorydata.plugin");
        Function3 r6 = (Function3) ZeusTransformUtils.wrapperContextForParams(r4, Function3.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "operation");
        return k.a((Function2) ZeusTransformUtils.preCheckCast(new C09391(r5, r6, null), Function2.class, "com.obric.memorydata.plugin"));
    }

    public static final <T, R> i<R> simpleScan(i<? extends T> r3, R r4, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> r5) {
        i r6 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.memorydata.plugin");
        Function3 r7 = (Function3) ZeusTransformUtils.wrapperContextForParams(r5, Function3.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "operation");
        return k.a((Function2) ZeusTransformUtils.preCheckCast(new C09401(r4, r6, r7, null), Function2.class, "com.obric.memorydata.plugin"));
    }

    public static final <T, R> i<R> simpleTransformLatest(i<? extends T> r3, Function3<? super j<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> r4) {
        i r5 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.memorydata.plugin");
        Function3 r6 = (Function3) ZeusTransformUtils.wrapperContextForParams(r4, Function3.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "transform");
        return SimpleChannelFlowKt.simpleChannelFlow((Function2) ZeusTransformUtils.preCheckCast(new C09411(r5, r6, null), Function2.class, "com.obric.memorydata.plugin"));
    }
}
