package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.trace.TraceCons;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u001a\u001e\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0086@¢\u0006\u0002\u0010\u0003\u001aB\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005H\u0086@¢\u0006\u0002\u0010\t\u001a \u0010\n\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0086@¢\u0006\u0002\u0010\u0003\u001aD\u0010\n\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005H\u0086@¢\u0006\u0002\u0010\t\u001av\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\f*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\r\u001a\u0002H\f2H\b\u0004\u0010\u000e\u001aB\b\u0001\u0012\u0013\u0012\u0011H\f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u0011H\u0001¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\f0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000fH\u0086H¢\u0006\u0002\u0010\u0014\u001a\u001e\u0010\u0015\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0086@¢\u0006\u0002\u0010\u0003\u001a \u0010\u0016\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0086@¢\u0006\u0002\u0010\u0003\u001ap\u0010\u0017\u001a\u0002H\u0018\"\u0004\b\u0000\u0010\u0018\"\b\b\u0001\u0010\u0001*\u0002H\u0018*\b\u0012\u0004\u0012\u0002H\u00010\u00022F\u0010\u000e\u001aB\b\u0001\u0012\u0013\u0012\u0011H\u0018¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u0001¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000fH\u0086@¢\u0006\u0002\u0010\u001a\u001a\u001e\u0010\u001b\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0086@¢\u0006\u0002\u0010\u0003\u001a \u0010\u001c\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0086@¢\u0006\u0002\u0010\u0003¨\u0006\u001d"}, d2 = {"first", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "predicate", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "firstOrNull", "fold", "R", "initial", "operation", "Lkotlin/Function3;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "acc", EventBody.KEY_VALUE, "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "last", "lastOrNull", TraceCons.METRIC_REDUCE, "S", "accumulator", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", LocationInfoConst.SINGLE, "singleOrNull", "kotlinx-coroutines-core"}, k = 5, mv = {1, 9, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class y {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u0005¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", EventBody.KEY_VALUE, "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class a<T> implements kotlinx.coroutines.flow.j<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f17537a;

        public a(Ref.ObjectRef r1) {
            this.f17537a = r1;
        }

        @Override // kotlinx.coroutines.flow.j
        public Object emit(T r3, Continuation<? super Unit> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.f17537a.element = r3;
            throw new AbortFlowException(this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u0005¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", EventBody.KEY_VALUE, "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class b<T> implements kotlinx.coroutines.flow.j<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2 f17538a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f17539b;

        public b(Function2 r3, Ref.ObjectRef r4) {
            this.f17538a = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
            this.f17539b = r4;
        }

        @Override // kotlinx.coroutines.flow.j
        public Object emit(T r6, Continuation<? super Unit> r7) {
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r8, FlowKt__ReduceKt$first$$inlined$collectWhile$2$1.class) == false) goto L7;
            FlowKt__ReduceKt$first$$inlined$collectWhile$2$1 r0 = (FlowKt__ReduceKt$first$$inlined$collectWhile$2$1) ZeusTransformUtils.preCheckCast(r8, FlowKt__ReduceKt$first$$inlined$collectWhile$2$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r9 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            boolean r4 = true;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            r6 = (T) r0.L$1;
            b<T> this = (b) ZeusTransformUtils.preCheckCast(r0.L$0, b.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r9);
        L18:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L20;
            this.f17539b.element = r6;
            r4 = false;
        L20:
            if (r4 == false) goto L24;
            return Unit.INSTANCE;
        L24:
            throw new AbortFlowException(this);
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r9);
            Continuation r10 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            Function2 r11 = this.f17538a;
            r0.L$0 = this;
            r0.L$1 = r6;
            r0.label = 1;
            InlineMarker.mark(6);
            r9 = r11.invoke(r6, r0);
            InlineMarker.mark(7);
            if (r9 != r2) goto L18;
            return r2;
        L7:
            r0 = new FlowKt__ReduceKt$first$$inlined$collectWhile$2$1(this, r8);
            goto L8
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u0005¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", EventBody.KEY_VALUE, "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class c<T> implements kotlinx.coroutines.flow.j<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f17540a;

        public c(Ref.ObjectRef r1) {
            this.f17540a = r1;
        }

        @Override // kotlinx.coroutines.flow.j
        public Object emit(T r3, Continuation<? super Unit> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.f17540a.element = r3;
            throw new AbortFlowException(this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u0005¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", EventBody.KEY_VALUE, "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class d<T> implements kotlinx.coroutines.flow.j<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2 f17541a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f17542b;

        public d(Function2 r3, Ref.ObjectRef r4) {
            this.f17541a = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
            this.f17542b = r4;
        }

        @Override // kotlinx.coroutines.flow.j
        public Object emit(T r6, Continuation<? super Unit> r7) {
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r8, FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1.class) == false) goto L7;
            FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1 r0 = (FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1) ZeusTransformUtils.preCheckCast(r8, FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r9 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            boolean r4 = true;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            r6 = (T) r0.L$1;
            d<T> this = (d) ZeusTransformUtils.preCheckCast(r0.L$0, d.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r9);
        L18:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L20;
            this.f17542b.element = r6;
            r4 = false;
        L20:
            if (r4 == false) goto L24;
            return Unit.INSTANCE;
        L24:
            throw new AbortFlowException(this);
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r9);
            Continuation r10 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            Function2 r11 = this.f17541a;
            r0.L$0 = this;
            r0.L$1 = r6;
            r0.label = 1;
            InlineMarker.mark(6);
            r9 = r11.invoke(r6, r0);
            InlineMarker.mark(7);
            if (r9 != r2) goto L18;
            return r2;
        L7:
            r0 = new FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1(this, r8);
            goto L8
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 176)
    public static final class e<T> implements kotlinx.coroutines.flow.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<R> f17543a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function3<R, T, Continuation<? super R>, Object> f17544b;

        public e(Ref.ObjectRef<R> r3, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> r4) {
            Function3<R, T, Continuation<? super R>, Object> r5 = (Function3) ZeusTransformUtils.wrapperContextForParams(r4, Function3.class, "com.obric.memorydata.plugin");
            this.f17543a = r3;
            this.f17544b = r5;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlinx.coroutines.flow.j
        public final Object emit(T r7, Continuation<? super Unit> r8) {
            Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r9, FlowKt__ReduceKt$fold$2$emit$1.class) == false) goto L7;
            FlowKt__ReduceKt$fold$2$emit$1 r0 = (FlowKt__ReduceKt$fold$2$emit$1) ZeusTransformUtils.preCheckCast(r9, FlowKt__ReduceKt$fold$2$emit$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r10 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            Ref.ObjectRef r6 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r0.L$0, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r10);
        L18:
            r6.element = (T) r10;
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r10);
            Ref.ObjectRef r11 = this.f17543a;
            Function3<R, T, Continuation<? super R>, Object> r12 = this.f17544b;
            T r1 = r11.element;
            r0.L$0 = r11;
            r0.label = 1;
            Object r13 = r12.invoke((R) r1, r7, r0);
            if (r13 != r2) goto L17;
            return r2;
        L17:
            r10 = (T) r13;
            r6 = r11;
        L7:
            r0 = new FlowKt__ReduceKt$fold$2$emit$1(this, r9);
            goto L8
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "it", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class f<T> implements kotlinx.coroutines.flow.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<Object> f17545a;

        f(Ref.ObjectRef<Object> r1) {
            this.f17545a = r1;
        }

        @Override // kotlinx.coroutines.flow.j
        public final Object emit(T r3, Continuation<? super Unit> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.f17545a.element = r3;
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "it", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class g<T> implements kotlinx.coroutines.flow.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<T> f17546a;

        g(Ref.ObjectRef<T> r1) {
            this.f17546a = r1;
        }

        @Override // kotlinx.coroutines.flow.j
        public final Object emit(T r3, Continuation<? super Unit> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.f17546a.element = r3;
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u0002H\u00022\u0006\u0010\u0004\u001a\u0002H\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "S", ExifInterface.GPS_DIRECTION_TRUE, EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class h<T> implements kotlinx.coroutines.flow.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<Object> f17547a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function3<S, T, Continuation<? super S>, Object> f17548b;

        h(Ref.ObjectRef<Object> r3, Function3<? super S, ? super T, ? super Continuation<? super S>, ? extends Object> r4) {
            Function3<S, T, Continuation<? super S>, Object> r5 = (Function3) ZeusTransformUtils.wrapperContextForParams(r4, Function3.class, "com.obric.memorydata.plugin");
            this.f17547a = r3;
            this.f17548b = r5;
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
        @Override // kotlinx.coroutines.flow.j
        public final Object emit(T r6, Continuation<? super Unit> r7) {
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r8, FlowKt__ReduceKt$reduce$2$emit$1.class) == false) goto L7;
            FlowKt__ReduceKt$reduce$2$emit$1 r0 = (FlowKt__ReduceKt$reduce$2$emit$1) ZeusTransformUtils.preCheckCast(r8, FlowKt__ReduceKt$reduce$2$emit$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r9 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            Ref.ObjectRef<Object> r5 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r0.L$0, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r9);
            Object r10 = (T) r9;
        L20:
            Ref.ObjectRef<Object> r11 = r5;
            Object r12 = r10;
        L21:
            r11.element = (T) r12;
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r9);
            r11 = this.f17547a;
            r12 = r6;
            if (r11.element == kotlinx.coroutines.flow.internal.s.f17463a) goto L21;
            Function3<S, T, Continuation<? super S>, Object> r1 = this.f17548b;
            Object r13 = this.f17547a.element;
            r0.L$0 = r11;
            r0.label = 1;
            Object r14 = r1.invoke((S) r13, r6, r0);
            if (r14 != r2) goto L19;
            return r2;
        L19:
            r10 = r14;
            r5 = r11;
        L7:
            r0 = new FlowKt__ReduceKt$reduce$2$emit$1(this, r8);
            goto L8
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class i<T> implements kotlinx.coroutines.flow.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<Object> f17549a;

        i(Ref.ObjectRef<Object> r1) {
            this.f17549a = r1;
        }

        @Override // kotlinx.coroutines.flow.j
        public final Object emit(T r3, Continuation<? super Unit> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            if (this.f17549a.element != kotlinx.coroutines.flow.internal.s.f17463a) goto L5;
            boolean r6 = true;
        L6:
            if (r6 == false) goto L10;
            this.f17549a.element = r3;
            return Unit.INSTANCE;
        L10:
            throw new IllegalArgumentException("Flow has more than one element".toString());
        L5:
            r6 = false;
            goto L6
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u0005¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", EventBody.KEY_VALUE, "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class j<T> implements kotlinx.coroutines.flow.j<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f17550a;

        public j(Ref.ObjectRef r1) {
            this.f17550a = r1;
        }

        @Override // kotlinx.coroutines.flow.j
        public Object emit(T r3, Continuation<? super Unit> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            if (this.f17550a.element != kotlinx.coroutines.flow.internal.s.f17463a) goto L5;
            this.f17550a.element = r3;
            boolean r6 = true;
        L6:
            if (r6 == false) goto L10;
            return Unit.INSTANCE;
        L10:
            throw new AbortFlowException(this);
        L5:
            Ref.ObjectRef r7 = this.f17550a;
            r7.element = (T) kotlinx.coroutines.flow.internal.s.f17463a;
            r6 = false;
            goto L6
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> Object a(kotlinx.coroutines.flow.i<? extends T> r5, R r6, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> r7, Continuation<? super R> r8) {
        kotlinx.coroutines.flow.i r9 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r5, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        Function3 r10 = (Function3) ZeusTransformUtils.wrapperContextForParams(r7, Function3.class, "com.obric.memorydata.plugin");
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r11, FlowKt__ReduceKt$fold$1.class) == false) goto L7;
        FlowKt__ReduceKt$fold$1 r0 = (FlowKt__ReduceKt$fold$1) ZeusTransformUtils.preCheckCast(r11, FlowKt__ReduceKt$fold$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Ref.ObjectRef r13 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r0.L$0, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r12);
    L19:
        return r13.element;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        Ref.ObjectRef r14 = new Ref.ObjectRef();
        r14.element = r6;
        kotlinx.coroutines.flow.j<? super T> r15 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new e(r14, r10), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
        r0.L$0 = r14;
        r0.label = 1;
        if (r9.collect(r15, r0) != r2) goto L17;
        return r2;
    L17:
        r13 = r14;
    L7:
        r0 = new FlowKt__ReduceKt$fold$1(r11);
        goto L8
    }

    public static final <T> Object a(kotlinx.coroutines.flow.i<? extends T> r6, Continuation<? super T> r7) {
        kotlinx.coroutines.flow.i r8 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r6, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, FlowKt__ReduceKt$single$1.class) == false) goto L7;
        FlowKt__ReduceKt$single$1 r0 = (FlowKt__ReduceKt$single$1) ZeusTransformUtils.preCheckCast(r9, FlowKt__ReduceKt$single$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Ref.ObjectRef r11 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r0.L$0, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r10);
    L19:
        if (r11.element == kotlinx.coroutines.flow.internal.s.f17463a) goto L23;
        return r11.element;
    L23:
        throw new NoSuchElementException("Flow is empty");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        Ref.ObjectRef r12 = new Ref.ObjectRef();
        r12.element = (T) kotlinx.coroutines.flow.internal.s.f17463a;
        kotlinx.coroutines.flow.j<? super T> r1 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new i(r12), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
        r0.L$0 = r12;
        r0.label = 1;
        if (r8.collect(r1, r0) != r2) goto L17;
        return r2;
    L17:
        r11 = r12;
    L7:
        r0 = new FlowKt__ReduceKt$single$1(r9);
        goto L8
    }

    public static final <T> Object a(kotlinx.coroutines.flow.i<? extends T> r6, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r7, Continuation<? super T> r8) {
        kotlinx.coroutines.flow.i r9 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r6, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        Function2 r10 = (Function2) ZeusTransformUtils.wrapperContextForParams(r7, Function2.class, "com.obric.memorydata.plugin");
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r11, FlowKt__ReduceKt$first$3.class) == false) goto L7;
        FlowKt__ReduceKt$first$3 r0 = (FlowKt__ReduceKt$first$3) ZeusTransformUtils.preCheckCast(r11, FlowKt__ReduceKt$first$3.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        b r13 = (b) ZeusTransformUtils.preCheckCast(r0.L$2, b.class, "com.obric.memorydata.plugin");
        Ref.ObjectRef r14 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r0.L$1, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        Function2 r1 = (Function2) ZeusTransformUtils.preCheckCast(r0.L$0, Function2.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r12);     // Catch: AbortFlowException -> L14
    L27:
        if (r14.element == kotlinx.coroutines.flow.internal.s.f17463a) goto L31;
        return r14.element;
    L31:
        throw new NoSuchElementException("Expected at least one element matching the predicate " + r1);
    L14:
        AbortFlowException e2 = e;
    L25:
        kotlinx.coroutines.flow.internal.o.a(e2, r13);
        goto L27
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r12);
        Ref.ObjectRef r15 = new Ref.ObjectRef();
        r15.element = (T) kotlinx.coroutines.flow.internal.s.f17463a;
        b r4 = new b(r10, r15);
        kotlinx.coroutines.flow.j<? super T> r5 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(r4, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");     // Catch: AbortFlowException -> L23
        r0.L$0 = r10;     // Catch: AbortFlowException -> L23
        r0.L$1 = r15;     // Catch: AbortFlowException -> L23
        r0.L$2 = r4;     // Catch: AbortFlowException -> L23
        r0.label = 1;     // Catch: AbortFlowException -> L23
        if (r9.collect(r5, r0) != r2) goto L22;
        return r2;
    L22:
        r1 = r10;
        r14 = r15;
    L23:
        e = move-exception;
        r1 = r10;
        r14 = r15;
        e2 = e;
        r13 = r4;
    L7:
        r0 = new FlowKt__ReduceKt$first$3(r11);
        goto L8
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [T, kotlinx.coroutines.internal.aj] */
    public static final <S, T extends S> Object a(kotlinx.coroutines.flow.i<? extends T> r5, Function3<? super S, ? super T, ? super Continuation<? super S>, ? extends Object> r6, Continuation<? super S> r7) {
        kotlinx.coroutines.flow.i r8 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r5, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        Function3 r9 = (Function3) ZeusTransformUtils.wrapperContextForParams(r6, Function3.class, "com.obric.memorydata.plugin");
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, FlowKt__ReduceKt$reduce$1.class) == false) goto L7;
        FlowKt__ReduceKt$reduce$1 r0 = (FlowKt__ReduceKt$reduce$1) ZeusTransformUtils.preCheckCast(r10, FlowKt__ReduceKt$reduce$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Ref.ObjectRef r12 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r0.L$0, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r11);
    L19:
        if (r12.element == kotlinx.coroutines.flow.internal.s.f17463a) goto L23;
        return r12.element;
    L23:
        throw new NoSuchElementException("Empty flow can't be reduced");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        Ref.ObjectRef r13 = new Ref.ObjectRef();
        r13.element = kotlinx.coroutines.flow.internal.s.f17463a;
        kotlinx.coroutines.flow.j r14 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new h(r13, r9), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
        r0.L$0 = r13;
        r0.label = 1;
        if (r8.collect(r14, r0) != r2) goto L17;
        return r2;
    L17:
        r12 = r13;
    L7:
        r0 = new FlowKt__ReduceKt$reduce$1(r10);
        goto L8
    }

    public static final <T> Object b(kotlinx.coroutines.flow.i<? extends T> r6, Continuation<? super T> r7) {
        kotlinx.coroutines.flow.i r8 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r6, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, FlowKt__ReduceKt$singleOrNull$1.class) == false) goto L7;
        FlowKt__ReduceKt$singleOrNull$1 r0 = (FlowKt__ReduceKt$singleOrNull$1) ZeusTransformUtils.preCheckCast(r9, FlowKt__ReduceKt$singleOrNull$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        j r11 = (j) ZeusTransformUtils.preCheckCast(r0.L$1, j.class, "com.obric.memorydata.plugin");
        Ref.ObjectRef r1 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r0.L$0, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r10);     // Catch: AbortFlowException -> L14
    L27:
        if (r1.element != kotlinx.coroutines.flow.internal.s.f17463a) goto L30;
        return null;
    L30:
        return r1.element;
    L14:
        AbortFlowException e2 = e;
    L25:
        kotlinx.coroutines.flow.internal.o.a(e2, r11);
        goto L27
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r10);
        Ref.ObjectRef r12 = new Ref.ObjectRef();
        r12.element = (T) kotlinx.coroutines.flow.internal.s.f17463a;
        j r4 = new j(r12);
        kotlinx.coroutines.flow.j<? super T> r5 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(r4, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");     // Catch: AbortFlowException -> L23
        r0.L$0 = r12;     // Catch: AbortFlowException -> L23
        r0.L$1 = r4;     // Catch: AbortFlowException -> L23
        r0.label = 1;     // Catch: AbortFlowException -> L23
        if (r8.collect(r5, r0) != r2) goto L22;
        return r2;
    L22:
        r1 = r12;
    L23:
        e = move-exception;
        r1 = r12;
        e2 = e;
        r11 = r4;
    L7:
        r0 = new FlowKt__ReduceKt$singleOrNull$1(r9);
        goto L8
    }

    public static final <T> Object b(kotlinx.coroutines.flow.i<? extends T> r5, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r6, Continuation<? super T> r7) {
        kotlinx.coroutines.flow.i r8 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r5, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        Function2 r9 = (Function2) ZeusTransformUtils.wrapperContextForParams(r6, Function2.class, "com.obric.memorydata.plugin");
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, FlowKt__ReduceKt$firstOrNull$3.class) == false) goto L7;
        FlowKt__ReduceKt$firstOrNull$3 r0 = (FlowKt__ReduceKt$firstOrNull$3) ZeusTransformUtils.preCheckCast(r10, FlowKt__ReduceKt$firstOrNull$3.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        d r12 = (d) ZeusTransformUtils.preCheckCast(r0.L$1, d.class, "com.obric.memorydata.plugin");
        Ref.ObjectRef r13 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r0.L$0, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r11);     // Catch: AbortFlowException -> L14
    L27:
        return r13.element;
    L14:
        AbortFlowException e2 = e;
    L25:
        kotlinx.coroutines.flow.internal.o.a(e2, r12);
        goto L27
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r11);
        Ref.ObjectRef r14 = new Ref.ObjectRef();
        d r4 = new d(r9, r14);
        kotlinx.coroutines.flow.j<? super T> r15 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(r4, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");     // Catch: AbortFlowException -> L23
        r0.L$0 = r14;     // Catch: AbortFlowException -> L23
        r0.L$1 = r4;     // Catch: AbortFlowException -> L23
        r0.label = 1;     // Catch: AbortFlowException -> L23
        if (r8.collect(r15, r0) != r2) goto L22;
        return r2;
    L22:
        r13 = r14;
    L23:
        e = move-exception;
        r13 = r14;
        e2 = e;
        r12 = r4;
    L7:
        r0 = new FlowKt__ReduceKt$firstOrNull$3(r10);
        goto L8
    }

    public static final <T> Object c(kotlinx.coroutines.flow.i<? extends T> r6, Continuation<? super T> r7) {
        kotlinx.coroutines.flow.i r8 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r6, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, FlowKt__ReduceKt$first$1.class) == false) goto L7;
        FlowKt__ReduceKt$first$1 r0 = (FlowKt__ReduceKt$first$1) ZeusTransformUtils.preCheckCast(r9, FlowKt__ReduceKt$first$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        a r11 = (a) ZeusTransformUtils.preCheckCast(r0.L$1, a.class, "com.obric.memorydata.plugin");
        Ref.ObjectRef r1 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r0.L$0, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r10);     // Catch: AbortFlowException -> L14
    L27:
        if (r1.element == kotlinx.coroutines.flow.internal.s.f17463a) goto L31;
        return r1.element;
    L31:
        throw new NoSuchElementException("Expected at least one element");
    L14:
        AbortFlowException e2 = e;
    L25:
        kotlinx.coroutines.flow.internal.o.a(e2, r11);
        goto L27
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r10);
        Ref.ObjectRef r12 = new Ref.ObjectRef();
        r12.element = (T) kotlinx.coroutines.flow.internal.s.f17463a;
        a r4 = new a(r12);
        kotlinx.coroutines.flow.j<? super T> r5 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(r4, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");     // Catch: AbortFlowException -> L23
        r0.L$0 = r12;     // Catch: AbortFlowException -> L23
        r0.L$1 = r4;     // Catch: AbortFlowException -> L23
        r0.label = 1;     // Catch: AbortFlowException -> L23
        if (r8.collect(r5, r0) != r2) goto L22;
        return r2;
    L22:
        r1 = r12;
    L23:
        e = move-exception;
        r1 = r12;
        e2 = e;
        r11 = r4;
    L7:
        r0 = new FlowKt__ReduceKt$first$1(r9);
        goto L8
    }

    public static final <T> Object d(kotlinx.coroutines.flow.i<? extends T> r6, Continuation<? super T> r7) {
        kotlinx.coroutines.flow.i r8 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r6, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, FlowKt__ReduceKt$firstOrNull$1.class) == false) goto L7;
        FlowKt__ReduceKt$firstOrNull$1 r0 = (FlowKt__ReduceKt$firstOrNull$1) ZeusTransformUtils.preCheckCast(r9, FlowKt__ReduceKt$firstOrNull$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        c r11 = (c) ZeusTransformUtils.preCheckCast(r0.L$1, c.class, "com.obric.memorydata.plugin");
        Ref.ObjectRef r1 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r0.L$0, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r10);     // Catch: AbortFlowException -> L14
    L27:
        return r1.element;
    L14:
        AbortFlowException e2 = e;
    L25:
        kotlinx.coroutines.flow.internal.o.a(e2, r11);
        goto L27
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r10);
        Ref.ObjectRef r12 = new Ref.ObjectRef();
        c r4 = new c(r12);
        kotlinx.coroutines.flow.j<? super T> r5 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(r4, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");     // Catch: AbortFlowException -> L23
        r0.L$0 = r12;     // Catch: AbortFlowException -> L23
        r0.L$1 = r4;     // Catch: AbortFlowException -> L23
        r0.label = 1;     // Catch: AbortFlowException -> L23
        if (r8.collect(r5, r0) != r2) goto L22;
        return r2;
    L22:
        r1 = r12;
    L23:
        e = move-exception;
        r1 = r12;
        e2 = e;
        r11 = r4;
    L7:
        r0 = new FlowKt__ReduceKt$firstOrNull$1(r9);
        goto L8
    }

    public static final <T> Object e(kotlinx.coroutines.flow.i<? extends T> r6, Continuation<? super T> r7) {
        kotlinx.coroutines.flow.i r8 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r6, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, FlowKt__ReduceKt$last$1.class) == false) goto L7;
        FlowKt__ReduceKt$last$1 r0 = (FlowKt__ReduceKt$last$1) ZeusTransformUtils.preCheckCast(r9, FlowKt__ReduceKt$last$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Ref.ObjectRef r11 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r0.L$0, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r10);
    L19:
        if (r11.element == kotlinx.coroutines.flow.internal.s.f17463a) goto L23;
        return r11.element;
    L23:
        throw new NoSuchElementException("Expected at least one element");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        Ref.ObjectRef r12 = new Ref.ObjectRef();
        r12.element = (T) kotlinx.coroutines.flow.internal.s.f17463a;
        kotlinx.coroutines.flow.j<? super T> r1 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new f(r12), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
        r0.L$0 = r12;
        r0.label = 1;
        if (r8.collect(r1, r0) != r2) goto L17;
        return r2;
    L17:
        r11 = r12;
    L7:
        r0 = new FlowKt__ReduceKt$last$1(r9);
        goto L8
    }

    public static final <T> Object f(kotlinx.coroutines.flow.i<? extends T> r6, Continuation<? super T> r7) {
        kotlinx.coroutines.flow.i r8 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r6, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, FlowKt__ReduceKt$lastOrNull$1.class) == false) goto L7;
        FlowKt__ReduceKt$lastOrNull$1 r0 = (FlowKt__ReduceKt$lastOrNull$1) ZeusTransformUtils.preCheckCast(r9, FlowKt__ReduceKt$lastOrNull$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Ref.ObjectRef r11 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r0.L$0, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r10);
    L19:
        return r11.element;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        Ref.ObjectRef r12 = new Ref.ObjectRef();
        kotlinx.coroutines.flow.j<? super T> r1 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new g(r12), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
        r0.L$0 = r12;
        r0.label = 1;
        if (r8.collect(r1, r0) != r2) goto L17;
        return r2;
    L17:
        r11 = r12;
    L7:
        r0 = new FlowKt__ReduceKt$lastOrNull$1(r9);
        goto L8
    }
}
