package androidx.lifecycle;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.oui.window.listener.NextLiveData;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.Duration;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.channels.u;
import kotlinx.coroutines.channels.w;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.j;
import kotlinx.coroutines.flow.k;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001a0\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a2\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"asFlow", "Lkotlinx/coroutines/flow/Flow;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/LiveData;", "asLiveData", "context", "Lkotlin/coroutines/CoroutineContext;", LocationMonitorConst.TIMEOUT, "Ljava/time/Duration;", "timeoutInMs", "", "lifecycle-livedata-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FlowLiveDataConversions {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1", f = "FlowLiveData.kt", i = {0, 0}, l = {110, 114}, m = "invokeSuspend", n = {"$this$callbackFlow", "observer"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1<T> extends SuspendLambda implements Function2<w<? super T>, Continuation<? super Unit>, Object> {
        final /* synthetic */ LiveData<T> $this_asFlow;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX INFO: renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1", f = "FlowLiveData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00251 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
            final /* synthetic */ Observer<T> $observer;
            final /* synthetic */ LiveData<T> $this_asFlow;
            int label;

            C00251(LiveData<T> r3, Observer<T> r4, Continuation<? super C00251> r5) {
                Observer<T> r6 = (Observer) ZeusTransformUtils.wrapperContextForParams(r4, Observer.class, "com.obric.memorydata.plugin");
                Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
                this.$this_asFlow = r3;
                this.$observer = r6;
                super(2, r7);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                return (Continuation) ZeusTransformUtils.preCheckCast(new C00251(this.$this_asFlow, this.$observer, r5), Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
                return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(al r3, Continuation<? super Unit> r4) {
                return ((C00251) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C00251.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                this.$this_asFlow.observeForever((Observer<? super T>) this.$observer);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        AnonymousClass1(LiveData<T> r3, Continuation<? super AnonymousClass1> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.$this_asFlow = r3;
            super(2, r5);
        }

        private static final void invokeSuspend$lambda$0(w r2, Object r3) {
            ((w) ZeusTransformUtils.wrapperContextForParams(r2, w.class, "com.obric.memorydata.plugin")).mo54trySendJP2dKIU(r3);
        }

        /* JADX INFO: renamed from: lambda$tTeUbxSp8jF-Y_DF-Te5rSvtJ1s, reason: not valid java name */
        public static /* synthetic */ void m48lambda$tTeUbxSp8jFY_DFTe5rSvtJ1s(w r0, Object r1) {
            invokeSuspend$lambda$0(r0, r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass1 r0 = new AnonymousClass1(this.$this_asFlow, r5);
            r0.L$0 = r3;
            return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(Object r3, Continuation<? super Unit> r4) {
            return invoke((w) ZeusTransformUtils.preCheckCast(r3, w.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        public final Object invoke(w<? super T> r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((w) ZeusTransformUtils.wrapperContextForParams(r3, w.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r10);
        L18:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            final Observer r2 = (Observer) ZeusTransformUtils.preCheckCast(this.L$1, Observer.class, "com.obric.memorydata.plugin");
            w r3 = (w) ZeusTransformUtils.preCheckCast(this.L$0, w.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r10);
        L14:
            final LiveData<T> r6 = this.$this_asFlow;
            Function0 r11 = (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r6, r2), Function0.class, "com.obric.memorydata.plugin");
            Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = null;
            this.L$1 = null;
            this.label = 2;
            if (u.a(r3, r11, r4) != r0) goto L18;
            return r0;
        L10:
            ResultKt.throwOnFailure(r10);
            final w r12 = (w) ZeusTransformUtils.preCheckCast(this.L$0, w.class, "com.obric.memorydata.plugin");
            r2 = new $$Lambda$FlowLiveDataConversions$asFlow$1$tTeUbxSp8jFY_DFTe5rSvtJ1s(r12);
            CoroutineContext r7 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.b().a(), CoroutineContext.class, "com.obric.memorydata.plugin");
            Function2 r8 = (Function2) ZeusTransformUtils.preCheckCast(new C00251(this.$this_asFlow, r2, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r9 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = r12;
            this.L$1 = r2;
            this.label = 1;
            if (i.a(r7, r8, r9) != r0) goto L13;
            return r0;
        L13:
            r3 = r12;
            goto L14
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.lifecycle.FlowLiveDataConversions$asLiveData$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/LiveDataScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asLiveData$1", f = "FlowLiveData.kt", i = {}, l = {80}, m = "invokeSuspend", n = {}, s = {})
    static final class C09301<T> extends SuspendLambda implements Function2<LiveDataScope<T>, Continuation<? super Unit>, Object> {
        final /* synthetic */ kotlinx.coroutines.flow.i<T> $this_asLiveData;
        private /* synthetic */ Object L$0;
        int label;

        C09301(kotlinx.coroutines.flow.i<? extends T> r3, Continuation<? super C09301> r4) {
            kotlinx.coroutines.flow.i<T> r5 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.$this_asLiveData = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            C09301 r0 = new C09301(this.$this_asLiveData, r5);
            r0.L$0 = r3;
            return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        }

        public final Object invoke(LiveDataScope<T> r3, Continuation<? super Unit> r4) {
            return ((C09301) ZeusTransformUtils.preCheckCast(create((LiveDataScope) ZeusTransformUtils.wrapperContextForParams(r3, LiveDataScope.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C09301.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(Object r3, Continuation<? super Unit> r4) {
            return invoke((LiveDataScope) ZeusTransformUtils.preCheckCast(r3, LiveDataScope.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
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
            final LiveDataScope r7 = (LiveDataScope) ZeusTransformUtils.preCheckCast(this.L$0, LiveDataScope.class, "com.obric.memorydata.plugin");
            kotlinx.coroutines.flow.i<T> r2 = this.$this_asLiveData;
            j<? super T> r8 = (j) ZeusTransformUtils.preCheckCast(new C00271(r7), j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r2.collect(r8, r3) != r0) goto L12;
            return r0;
        }
    }

    public static final <T> kotlinx.coroutines.flow.i<T> asFlow(LiveData<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return k.a(k.b((Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r2, null), Function2.class, "com.obric.memorydata.plugin")));
    }

    public static final <T> LiveData<T> asLiveData(kotlinx.coroutines.flow.i<? extends T> r6) {
        kotlinx.coroutines.flow.i r0 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r6, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r0, "<this>");
        return asLiveData$default(r0, null, 0, 3, null);
    }

    public static final <T> LiveData<T> asLiveData(kotlinx.coroutines.flow.i<? extends T> r8, CoroutineContext r9) {
        kotlinx.coroutines.flow.i r2 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r8, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        CoroutineContext r3 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r9, CoroutineContext.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "context");
        return asLiveData$default(r2, r3, 0, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> LiveData<T> asLiveData(kotlinx.coroutines.flow.i<? extends T> r3, CoroutineContext r4, long r5) {
        kotlinx.coroutines.flow.i r6 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        CoroutineContext r7 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r4, CoroutineContext.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "context");
        NextLiveData r8 = (LiveData<T>) CoroutineLiveDataKt.liveData(r7, r5, (Function2) ZeusTransformUtils.preCheckCast(new C09301(r6, null), Function2.class, "com.obric.memorydata.plugin"));
        if (ZeusTransformUtils.instanceOf(r6, ar.class) == true) goto L5;
    L8:
        return r8;
    L5:
        if (ArchTaskExecutor.getInstance().isMainThread() == false) goto L7;
        r8.setValue(((ar) ZeusTransformUtils.preCheckCast(r6, ar.class, "com.obric.memorydata.plugin")).c());
        goto L8
    L7:
        r8.postValue(((ar) ZeusTransformUtils.preCheckCast(r6, ar.class, "com.obric.memorydata.plugin")).c());
        goto L8
    }

    public static final <T> LiveData<T> asLiveData(kotlinx.coroutines.flow.i<? extends T> r2, CoroutineContext r3, Duration r4) {
        kotlinx.coroutines.flow.i r5 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        CoroutineContext r6 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r4, LocationMonitorConst.TIMEOUT);
        return asLiveData(r5, r6, Api26Impl.INSTANCE.toMillis(r4));
    }

    public static /* synthetic */ LiveData asLiveData$default(kotlinx.coroutines.flow.i r1, CoroutineContext r2, long r3, int r5, Object r6) {
        kotlinx.coroutines.flow.i r4 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r1, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        CoroutineContext r7 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r2, CoroutineContext.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r7 = (CoroutineContext) ZeusTransformUtils.preCheckCast(EmptyCoroutineContext.INSTANCE, CoroutineContext.class, "com.obric.memorydata.plugin");
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = 5000;
    L9:
        return asLiveData(r4, r7, r3);
    }

    public static /* synthetic */ LiveData asLiveData$default(kotlinx.coroutines.flow.i r1, CoroutineContext r2, Duration r3, int r4, Object r5) {
        kotlinx.coroutines.flow.i r6 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r1, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        CoroutineContext r7 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r2, CoroutineContext.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r7 = (CoroutineContext) ZeusTransformUtils.preCheckCast(EmptyCoroutineContext.INSTANCE, CoroutineContext.class, "com.obric.memorydata.plugin");
    L6:
        return asLiveData(r6, r7, r3);
    }
}
