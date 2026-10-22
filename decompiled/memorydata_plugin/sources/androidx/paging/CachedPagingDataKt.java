package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.flow.an;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.j;
import kotlinx.coroutines.flow.k;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a6\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u001aB\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0000¨\u0006\t"}, d2 = {"cachedIn", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", ExifInterface.GPS_DIRECTION_TRUE, "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "tracker", "Landroidx/paging/ActiveFlowTracker;", "paging-common"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CachedPagingDataKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.paging.CachedPagingDataKt$cachedIn$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Landroidx/paging/MulticastedPagingData;", ExifInterface.GPS_DIRECTION_TRUE, "", "prev", "next"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.CachedPagingDataKt$cachedIn$2", f = "CachedPagingData.kt", i = {0}, l = {104}, m = "invokeSuspend", n = {"next"}, s = {"L$0"})
    static final class AnonymousClass2<T> extends SuspendLambda implements Function3<MulticastedPagingData<T>, MulticastedPagingData<T>, Continuation<? super MulticastedPagingData<T>>, Object> {
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> r3) {
            super(3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        public final Object invoke(MulticastedPagingData<T> r2, MulticastedPagingData<T> r3, Continuation<? super MulticastedPagingData<T>> r4) {
            AnonymousClass2 r5 = new AnonymousClass2((Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
            r5.L$0 = r2;
            r5.L$1 = r3;
            return r5.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* synthetic */ Object invoke(Object r3, Object r4, Object r5) {
            return invoke((MulticastedPagingData) ZeusTransformUtils.preCheckCast(r3, MulticastedPagingData.class, "com.obric.memorydata.plugin"), (MulticastedPagingData) ZeusTransformUtils.preCheckCast(r4, MulticastedPagingData.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            MulticastedPagingData r5 = (MulticastedPagingData) ZeusTransformUtils.preCheckCast(this.L$0, MulticastedPagingData.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r6);
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            MulticastedPagingData r7 = (MulticastedPagingData) ZeusTransformUtils.preCheckCast(this.L$0, MulticastedPagingData.class, "com.obric.memorydata.plugin");
            MulticastedPagingData r2 = (MulticastedPagingData) ZeusTransformUtils.preCheckCast(this.L$1, MulticastedPagingData.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = r2;
            this.label = 1;
            if (r7.close(r3) != r0) goto L12;
            return r0;
        L12:
            return r2;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.paging.CachedPagingDataKt$cachedIn$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/coroutines/flow/FlowCollector;", "Landroidx/paging/PagingData;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.CachedPagingDataKt$cachedIn$4", f = "CachedPagingData.kt", i = {}, l = {109}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass4<T> extends SuspendLambda implements Function2<j<? super PagingData<T>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ActiveFlowTracker $tracker;
        int label;

        AnonymousClass4(ActiveFlowTracker r3, Continuation<? super AnonymousClass4> r4) {
            ActiveFlowTracker r5 = (ActiveFlowTracker) ZeusTransformUtils.wrapperContextForParams(r3, ActiveFlowTracker.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.$tracker = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass4(this.$tracker, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(Object r3, Continuation<? super Unit> r4) {
            return invoke((j) ZeusTransformUtils.preCheckCast(r3, j.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        public final Object invoke(j<? super PagingData<T>> r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass4) ZeusTransformUtils.preCheckCast(create((j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass4.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L14:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            ActiveFlowTracker r7 = this.$tracker;
            if (r7 == null) goto L14;
            ActiveFlowTracker.FlowType r2 = ActiveFlowTracker.FlowType.PAGED_DATA_FLOW;
            Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.onStart(r2, r3) != r0) goto L14;
            return r0;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.paging.CachedPagingDataKt$cachedIn$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/coroutines/flow/FlowCollector;", "Landroidx/paging/PagingData;", "it", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.CachedPagingDataKt$cachedIn$5", f = "CachedPagingData.kt", i = {}, l = {111}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass5<T> extends SuspendLambda implements Function3<j<? super PagingData<T>>, Throwable, Continuation<? super Unit>, Object> {
        final /* synthetic */ ActiveFlowTracker $tracker;
        int label;

        AnonymousClass5(ActiveFlowTracker r3, Continuation<? super AnonymousClass5> r4) {
            ActiveFlowTracker r5 = (ActiveFlowTracker) ZeusTransformUtils.wrapperContextForParams(r3, ActiveFlowTracker.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.$tracker = r5;
            super(3, r6);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* synthetic */ Object invoke(Object r3, Throwable r4, Continuation<? super Unit> r5) {
            return invoke((j) ZeusTransformUtils.preCheckCast(r3, j.class, "com.obric.memorydata.plugin"), (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin"));
        }

        public final Object invoke(j<? super PagingData<T>> r2, Throwable r3, Continuation<? super Unit> r4) {
            j r5 = (j) ZeusTransformUtils.wrapperContextForParams(r2, j.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return new AnonymousClass5(this.$tracker, r6).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L14:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            ActiveFlowTracker r7 = this.$tracker;
            if (r7 == null) goto L14;
            ActiveFlowTracker.FlowType r2 = ActiveFlowTracker.FlowType.PAGED_DATA_FLOW;
            Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.onComplete(r2, r3) != r0) goto L14;
            return r0;
        }
    }

    public static final <T> i<PagingData<T>> cachedIn(i<PagingData<T>> r2, al r3) {
        i r4 = (i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin");
        al r5 = (al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "scope");
        return cachedIn(r4, r5, null);
    }

    public static final <T> i<PagingData<T>> cachedIn(i<PagingData<T>> r4, al r5, ActiveFlowTracker r6) {
        i r7 = (i) ZeusTransformUtils.wrapperContextForParams(r4, i.class, "com.obric.memorydata.plugin");
        al r8 = (al) ZeusTransformUtils.wrapperContextForParams(r5, al.class, "com.obric.memorydata.plugin");
        ActiveFlowTracker r9 = (ActiveFlowTracker) ZeusTransformUtils.wrapperContextForParams(r6, ActiveFlowTracker.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "scope");
        final i r10 = FlowExtKt.simpleRunningReduce(FlowExtKt.simpleTransformLatest(r7, (Function3) ZeusTransformUtils.preCheckCast(new CachedPagingDataKt$cachedIn$$inlined$simpleMapLatest$1(null, r8, r9), Function3.class, "com.obric.memorydata.plugin")), (Function3) ZeusTransformUtils.preCheckCast(new AnonymousClass2(null), Function3.class, "com.obric.memorydata.plugin"));
        return (i) ZeusTransformUtils.preCheckCast(k.a(k.a(k.b((i) ZeusTransformUtils.preCheckCast(new CachedPagingDataKt$cachedIn$$inlined$map$1(r10), i.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass4(r9, null), Function2.class, "com.obric.memorydata.plugin")), (Function3) ZeusTransformUtils.preCheckCast(new AnonymousClass5(r9, null), Function3.class, "com.obric.memorydata.plugin")), r8, an.f17422a.b(), 1), i.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ i cachedIn$default(i r1, al r2, ActiveFlowTracker r3, int r4, Object r5) {
        i r6 = (i) ZeusTransformUtils.wrapperContextForParams(r1, i.class, "com.obric.memorydata.plugin");
        al r7 = (al) ZeusTransformUtils.wrapperContextForParams(r2, al.class, "com.obric.memorydata.plugin");
        ActiveFlowTracker r8 = (ActiveFlowTracker) ZeusTransformUtils.wrapperContextForParams(r3, ActiveFlowTracker.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L6;
        r8 = null;
    L6:
        return cachedIn(r6, r7, r8);
    }
}
