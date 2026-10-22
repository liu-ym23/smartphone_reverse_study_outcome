package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001aJ\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012$\b\u0004\u0010\u0003\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H\u0086\b¢\u0006\u0002\u0010\b\u001a\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\n0\u0001\"\u0006\b\u0000\u0010\n\u0018\u0001*\u0006\u0012\u0002\b\u00030\u0001H\u0086\b\u001a,\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\n0\u0001\"\b\b\u0000\u0010\n*\u00020\u0007*\u0006\u0012\u0002\b\u00030\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\f\u001aJ\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012$\b\u0004\u0010\u0003\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H\u0086\b¢\u0006\u0002\u0010\b\u001a\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0007*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001\u001a_\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\n0\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n*\b\u0012\u0004\u0012\u0002H\u00020\u000123\b\u0004\u0010\u0010\u001a-\b\u0001\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H\u0086\b¢\u0006\u0002\u0010\b\u001ae\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\n0\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\n*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\u00020\u000125\b\u0004\u0010\u0010\u001a/\b\u0001\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\n0\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H\u0086\b¢\u0006\u0002\u0010\b\u001aE\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\"\u0010\u0016\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004¢\u0006\u0002\u0010\b\u001ay\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\n0\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0019\u001a\u0002H\n2H\b\u0001\u0010\u001a\u001aB\b\u0001\u0012\u0013\u0012\u0011H\n¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u001b¢\u0006\u0002\u0010\u001d\u001ai\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012F\u0010\u001a\u001aB\b\u0001\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u001b¢\u0006\u0002\u0010\u001f\u001ay\u0010 \u001a\b\u0012\u0004\u0012\u0002H\n0\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0019\u001a\u0002H\n2H\b\u0001\u0010\u001a\u001aB\b\u0001\u0012\u0013\u0012\u0011H\n¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u001b¢\u0006\u0002\u0010\u001d\u001a\"\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\"0\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001¨\u0006#"}, d2 = {"filter", "Lkotlinx/coroutines/flow/Flow;", ExifInterface.GPS_DIRECTION_TRUE, "predicate", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "filterIsInstance", "R", "klass", "Lkotlin/reflect/KClass;", "filterNot", "filterNotNull", "map", "transform", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, EventBody.KEY_VALUE, "mapNotNull", "onEach", "action", "", "runningFold", "initial", "operation", "Lkotlin/Function3;", "accumulator", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "runningReduce", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "scan", "withIndex", "Lkotlin/collections/IndexedValue;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 9, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class aa {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\b"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1"}, k = 1, mv = {1, 9, 0}, xi = 176)
    public static final class a<T> implements kotlinx.coroutines.flow.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f17356a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function2 f17357b;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.aa$a$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1"}, k = 3, mv = {1, 9, 0}, xi = 176)
        public static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j f17358a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Function2 f17359b;

            public AnonymousClass1(kotlinx.coroutines.flow.j r3, Function2 r4) {
                kotlinx.coroutines.flow.j r5 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                Function2 r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
                this.f17358a = r5;
                this.f17359b = r6;
            }

            @Override // kotlinx.coroutines.flow.j
            public final Object emit(T r8, Continuation<? super Unit> r9) {
                Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r10, FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2$1.class) == false) goto L7;
                FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2$1 r0 = (FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2$1) ZeusTransformUtils.preCheckCast(r10, FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2$1.class, "com.obric.memorydata.plugin");
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
            L26:
                return Unit.INSTANCE;
            L14:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L15:
                kotlinx.coroutines.flow.j r7 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(r0.L$1, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                r8 = (T) r0.L$0;
                ResultKt.throwOnFailure(r11);
            L21:
                if (((Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L26;
                r0.L$0 = null;
                r0.L$1 = null;
                r0.label = 2;
                if (r7.emit(r8, r0) != r2) goto L26;
                return r2;
            L16:
                ResultKt.throwOnFailure(r11);
                kotlinx.coroutines.flow.j r12 = this.f17358a;
                Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                Function2 r13 = this.f17359b;
                r0.L$0 = r8;
                r0.L$1 = r12;
                r0.label = 1;
                Object r14 = r13.invoke(r8, r0);
                if (r14 != r2) goto L19;
                return r2;
            L19:
                r11 = r14;
                r7 = r12;
            L7:
                r0 = new FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2$1(this, r10);
                goto L8
            }
        }

        @Override // kotlinx.coroutines.flow.i
        public Object collect(kotlinx.coroutines.flow.j r4, Continuation r5) {
            kotlinx.coroutines.flow.j r6 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            Object r3 = this.f17356a.collect((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r6, this.f17357b), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), r7);
            if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r3;
        L6:
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1"}, k = 1, mv = {1, 9, 0}, xi = 176)
    public static final class b implements kotlinx.coroutines.flow.i<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f17360a;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.aa$b$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 176)
        public static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j f17361a;

            public AnonymousClass1(kotlinx.coroutines.flow.j r3) {
                this.f17361a = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlinx.coroutines.flow.j
            public final Object emit(Object r6, Continuation r7) {
                Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r8, FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2$1.class) == false) goto L7;
                FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2$1 r0 = (FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2$1) ZeusTransformUtils.preCheckCast(r8, FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2$1.class, "com.obric.memorydata.plugin");
                if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
                r0.label -= Integer.MIN_VALUE;
            L8:
                Object r9 = r0.result;
                Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r3 = r0.label;
                if (r3 == 0) goto L14;
                if (r3 != 1) goto L13;
                ResultKt.throwOnFailure(r9);
            L20:
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r9);
                kotlinx.coroutines.flow.j r5 = this.f17361a;
                Continuation r10 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                Intrinsics.reifiedOperationMarker(3, "R");
                if (ZeusTransformUtils.instanceOf(r6, Object.class) == false) goto L20;
                r0.label = 1;
                if (r5.emit(r6, r0) != r2) goto L20;
                return r2;
            L7:
                r0 = new FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2$1(this, r8);
                goto L8
            }
        }

        @Override // kotlinx.coroutines.flow.i
        public Object collect(kotlinx.coroutines.flow.j<? super Object> r3, Continuation r4) {
            kotlinx.coroutines.flow.j r5 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            kotlinx.coroutines.flow.i r2 = this.f17360a;
            Intrinsics.needClassReification();
            Object r7 = r2.collect((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), r6);
            if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r7;
        L6:
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class c implements kotlinx.coroutines.flow.i<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f17362a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ KClass f17363b;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.aa$c$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j f17364a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ KClass f17365b;

            public AnonymousClass1(kotlinx.coroutines.flow.j r3, KClass r4) {
                kotlinx.coroutines.flow.j r5 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                KClass r6 = (KClass) ZeusTransformUtils.wrapperContextForParams(r4, KClass.class, "com.obric.memorydata.plugin");
                this.f17364a = r5;
                this.f17365b = r6;
            }

            @Override // kotlinx.coroutines.flow.j
            public final Object emit(Object r6, Continuation r7) {
                Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r8, FlowKt__TransformKt$filterIsInstance$$inlined$filter$2$2$1.class) == false) goto L7;
                FlowKt__TransformKt$filterIsInstance$$inlined$filter$2$2$1 r0 = (FlowKt__TransformKt$filterIsInstance$$inlined$filter$2$2$1) ZeusTransformUtils.preCheckCast(r8, FlowKt__TransformKt$filterIsInstance$$inlined$filter$2$2$1.class, "com.obric.memorydata.plugin");
                if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
                r0.label -= Integer.MIN_VALUE;
            L8:
                Object r9 = r0.result;
                Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r3 = r0.label;
                if (r3 == 0) goto L14;
                if (r3 != 1) goto L13;
                ResultKt.throwOnFailure(r9);
            L20:
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r9);
                kotlinx.coroutines.flow.j r10 = this.f17364a;
                Continuation r1 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                if (this.f17365b.isInstance(r6) == false) goto L20;
                r0.label = 1;
                if (r10.emit(r6, r0) != r2) goto L20;
                return r2;
            L7:
                r0 = new FlowKt__TransformKt$filterIsInstance$$inlined$filter$2$2$1(this, r8);
                goto L8
            }
        }

        @Override // kotlinx.coroutines.flow.i
        public Object collect(kotlinx.coroutines.flow.j<? super Object> r4, Continuation r5) {
            kotlinx.coroutines.flow.j r6 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            Object r3 = this.f17362a.collect((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r6, this.f17363b), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), r7);
            if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r3;
        L6:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\b"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1"}, k = 1, mv = {1, 9, 0}, xi = 176)
    public static final class d<T> implements kotlinx.coroutines.flow.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f17366a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function2 f17367b;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.aa$d$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1"}, k = 3, mv = {1, 9, 0}, xi = 176)
        public static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j f17368a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Function2 f17369b;

            public AnonymousClass1(kotlinx.coroutines.flow.j r3, Function2 r4) {
                kotlinx.coroutines.flow.j r5 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                Function2 r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
                this.f17368a = r5;
                this.f17369b = r6;
            }

            @Override // kotlinx.coroutines.flow.j
            public final Object emit(T r8, Continuation<? super Unit> r9) {
                Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r10, FlowKt__TransformKt$filterNot$$inlined$unsafeTransform$1$2$1.class) == false) goto L7;
                FlowKt__TransformKt$filterNot$$inlined$unsafeTransform$1$2$1 r0 = (FlowKt__TransformKt$filterNot$$inlined$unsafeTransform$1$2$1) ZeusTransformUtils.preCheckCast(r10, FlowKt__TransformKt$filterNot$$inlined$unsafeTransform$1$2$1.class, "com.obric.memorydata.plugin");
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
            L26:
                return Unit.INSTANCE;
            L14:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L15:
                kotlinx.coroutines.flow.j r7 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(r0.L$1, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                r8 = (T) r0.L$0;
                ResultKt.throwOnFailure(r11);
            L21:
                if (((Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L26;
                r0.L$0 = null;
                r0.L$1 = null;
                r0.label = 2;
                if (r7.emit(r8, r0) != r2) goto L26;
                return r2;
            L16:
                ResultKt.throwOnFailure(r11);
                kotlinx.coroutines.flow.j r12 = this.f17368a;
                Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                Function2 r13 = this.f17369b;
                r0.L$0 = r8;
                r0.L$1 = r12;
                r0.label = 1;
                Object r14 = r13.invoke(r8, r0);
                if (r14 != r2) goto L19;
                return r2;
            L19:
                r11 = r14;
                r7 = r12;
            L7:
                r0 = new FlowKt__TransformKt$filterNot$$inlined$unsafeTransform$1$2$1(this, r10);
                goto L8
            }
        }

        @Override // kotlinx.coroutines.flow.i
        public Object collect(kotlinx.coroutines.flow.j r4, Continuation r5) {
            kotlinx.coroutines.flow.j r6 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            Object r3 = this.f17366a.collect((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r6, this.f17367b), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), r7);
            if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r3;
        L6:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\b"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class e<T> implements kotlinx.coroutines.flow.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f17370a;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.aa$e$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1"}, k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j f17371a;

            public AnonymousClass1(kotlinx.coroutines.flow.j r3) {
                this.f17371a = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlinx.coroutines.flow.j
            public final Object emit(T r6, Continuation<? super Unit> r7) {
                Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r8, FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$1.class) == false) goto L7;
                FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$1 r0 = (FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$1) ZeusTransformUtils.preCheckCast(r8, FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$1.class, "com.obric.memorydata.plugin");
                if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
                r0.label -= Integer.MIN_VALUE;
            L8:
                Object r9 = r0.result;
                Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r3 = r0.label;
                if (r3 == 0) goto L14;
                if (r3 != 1) goto L13;
                ResultKt.throwOnFailure(r9);
            L20:
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r9);
                kotlinx.coroutines.flow.j r5 = this.f17371a;
                Continuation r10 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                if (r6 == null) goto L20;
                r0.label = 1;
                if (r5.emit(r6, r0) != r2) goto L20;
                return r2;
            L7:
                r0 = new FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$1(this, r8);
                goto L8
            }
        }

        public e(kotlinx.coroutines.flow.i r3) {
            this.f17370a = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlinx.coroutines.flow.i
        public Object collect(kotlinx.coroutines.flow.j r3, Continuation r4) {
            kotlinx.coroutines.flow.j r5 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            Object r2 = this.f17370a.collect((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), r6);
            if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r2;
        L6:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\b"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1"}, k = 1, mv = {1, 9, 0}, xi = 176)
    public static final class f<R> implements kotlinx.coroutines.flow.i<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f17372a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function2 f17373b;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.aa$f$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1"}, k = 3, mv = {1, 9, 0}, xi = 176)
        public static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j f17374a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Function2 f17375b;

            public AnonymousClass1(kotlinx.coroutines.flow.j r3, Function2 r4) {
                kotlinx.coroutines.flow.j r5 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                Function2 r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
                this.f17374a = r5;
                this.f17375b = r6;
            }

            @Override // kotlinx.coroutines.flow.j
            public final Object emit(T r8, Continuation<? super Unit> r9) {
                Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r10, FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2$1.class) == false) goto L7;
                FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2$1 r0 = (FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2$1) ZeusTransformUtils.preCheckCast(r10, FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2$1.class, "com.obric.memorydata.plugin");
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
                kotlinx.coroutines.flow.j r7 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(r0.L$0, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                ResultKt.throwOnFailure(r11);
                kotlinx.coroutines.flow.j r12 = r7;
            L20:
                r0.L$0 = null;
                r0.label = 2;
                if (r12.emit(r11, r0) != r2) goto L24;
                return r2;
            L16:
                ResultKt.throwOnFailure(r11);
                kotlinx.coroutines.flow.j r13 = this.f17374a;
                Continuation r1 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                Function2 r14 = this.f17375b;
                r0.L$0 = r13;
                r0.label = 1;
                Object r15 = r14.invoke(r8, r0);
                if (r15 != r2) goto L19;
                return r2;
            L19:
                r11 = r15;
                r12 = r13;
            L7:
                r0 = new FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2$1(this, r10);
                goto L8
            }
        }

        @Override // kotlinx.coroutines.flow.i
        public Object collect(kotlinx.coroutines.flow.j r4, Continuation r5) {
            kotlinx.coroutines.flow.j r6 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            Object r3 = this.f17372a.collect((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r6, this.f17373b), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), r7);
            if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r3;
        L6:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\b"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1"}, k = 1, mv = {1, 9, 0}, xi = 176)
    public static final class g<R> implements kotlinx.coroutines.flow.i<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f17376a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function2 f17377b;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.aa$g$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1"}, k = 3, mv = {1, 9, 0}, xi = 176)
        public static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j f17378a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Function2 f17379b;

            public AnonymousClass1(kotlinx.coroutines.flow.j r3, Function2 r4) {
                kotlinx.coroutines.flow.j r5 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                Function2 r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
                this.f17378a = r5;
                this.f17379b = r6;
            }

            @Override // kotlinx.coroutines.flow.j
            public final Object emit(T r8, Continuation<? super Unit> r9) {
                Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r10, FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2$1.class) == false) goto L7;
                FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2$1 r0 = (FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2$1) ZeusTransformUtils.preCheckCast(r10, FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2$1.class, "com.obric.memorydata.plugin");
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
            L26:
                return Unit.INSTANCE;
            L14:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L15:
                kotlinx.coroutines.flow.j r7 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(r0.L$0, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                ResultKt.throwOnFailure(r11);
                kotlinx.coroutines.flow.j r12 = r7;
            L20:
                if (r11 == null) goto L26;
                r0.L$0 = null;
                r0.label = 2;
                if (r12.emit(r11, r0) != r2) goto L26;
                return r2;
            L16:
                ResultKt.throwOnFailure(r11);
                kotlinx.coroutines.flow.j r13 = this.f17378a;
                Continuation r1 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                Function2 r14 = this.f17379b;
                r0.L$0 = r13;
                r0.label = 1;
                Object r15 = r14.invoke(r8, r0);
                if (r15 != r2) goto L19;
                return r2;
            L19:
                r11 = r15;
                r12 = r13;
            L7:
                r0 = new FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2$1(this, r10);
                goto L8
            }
        }

        @Override // kotlinx.coroutines.flow.i
        public Object collect(kotlinx.coroutines.flow.j r4, Continuation r5) {
            kotlinx.coroutines.flow.j r6 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            Object r3 = this.f17376a.collect((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r6, this.f17377b), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), r7);
            if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r3;
        L6:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\b"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class h<T> implements kotlinx.coroutines.flow.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f17380a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function2 f17381b;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.aa$h$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1"}, k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j f17382a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Function2 f17383b;

            public AnonymousClass1(kotlinx.coroutines.flow.j r3, Function2 r4) {
                kotlinx.coroutines.flow.j r5 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                Function2 r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
                this.f17382a = r5;
                this.f17383b = r6;
            }

            @Override // kotlinx.coroutines.flow.j
            public final Object emit(T r7, Continuation<? super Unit> r8) {
                Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r9, FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1.class) == false) goto L7;
                FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1 r0 = (FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1) ZeusTransformUtils.preCheckCast(r9, FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1.class, "com.obric.memorydata.plugin");
                if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
                r0.label -= Integer.MIN_VALUE;
            L8:
                Object r10 = r0.result;
                Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r3 = r0.label;
                if (r3 == 0) goto L16;
                if (r3 == 1) goto L15;
                if (r3 != 2) goto L14;
                ResultKt.throwOnFailure(r10);
            L24:
                return Unit.INSTANCE;
            L14:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L15:
                kotlinx.coroutines.flow.j r6 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(r0.L$1, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                r7 = (T) r0.L$0;
                ResultKt.throwOnFailure(r10);
            L20:
                r0.L$0 = null;
                r0.L$1 = null;
                r0.label = 2;
                if (r6.emit(r7, r0) != r2) goto L24;
                return r2;
            L16:
                ResultKt.throwOnFailure(r10);
                kotlinx.coroutines.flow.j r11 = this.f17382a;
                Continuation r1 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                Function2 r12 = this.f17383b;
                r0.L$0 = r7;
                r0.L$1 = r11;
                r0.label = 1;
                InlineMarker.mark(6);
                Object r13 = r12.invoke(r7, r0);
                InlineMarker.mark(7);
                if (r13 != r2) goto L19;
                return r2;
            L19:
                r6 = r11;
            L7:
                r0 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1(this, r9);
                goto L8
            }
        }

        public h(kotlinx.coroutines.flow.i r3, Function2 r4) {
            kotlinx.coroutines.flow.i r5 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            Function2 r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
            this.f17380a = r5;
            this.f17381b = r6;
        }

        @Override // kotlinx.coroutines.flow.i
        public Object collect(kotlinx.coroutines.flow.j r4, Continuation r5) {
            kotlinx.coroutines.flow.j r6 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            Object r3 = this.f17380a.collect((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r6, this.f17381b), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), r7);
            if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r3;
        L6:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class i<R> implements kotlinx.coroutines.flow.i<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f17384a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f17385b;
        final /* synthetic */ Function3 c;

        public i(Object r3, kotlinx.coroutines.flow.i r4, Function3 r5) {
            kotlinx.coroutines.flow.i r6 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            Function3 r7 = (Function3) ZeusTransformUtils.wrapperContextForParams(r5, Function3.class, "com.obric.memorydata.plugin");
            this.f17384a = r3;
            this.f17385b = r6;
            this.c = r7;
        }

        /* JADX WARN: Type inference failed for: r3v1, types: [T, java.lang.Object] */
        @Override // kotlinx.coroutines.flow.i
        public Object collect(kotlinx.coroutines.flow.j<? super R> r7, Continuation<? super Unit> r8) {
            kotlinx.coroutines.flow.j r9 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r7, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r10, FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1$1.class) == false) goto L7;
            FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1$1 r0 = (FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1$1) ZeusTransformUtils.preCheckCast(r10, FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1$1.class, "com.obric.memorydata.plugin");
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
        L23:
            return Unit.INSTANCE;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            Ref.ObjectRef r6 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r0.L$2, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
            r9 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(r0.L$1, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            i<R> r4 = (i) ZeusTransformUtils.preCheckCast(r0.L$0, i.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r11);
            Ref.ObjectRef r12 = r6;
            i<R> this = r4;
        L19:
            kotlinx.coroutines.flow.i r5 = this.f17385b;
            kotlinx.coroutines.flow.j r13 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new j(r12, this.c, r9), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            r0.L$0 = null;
            r0.L$1 = null;
            r0.L$2 = null;
            r0.label = 2;
            if (r5.collect(r13, r0) != r2) goto L23;
            return r2;
        L16:
            ResultKt.throwOnFailure(r11);
            Continuation r14 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            r12 = new Ref.ObjectRef();
            r12.element = this.f17384a;
            T r15 = r12.element;
            r0.L$0 = this;
            r0.L$1 = r9;
            r0.L$2 = r12;
            r0.label = 1;
            if (r9.emit(r15, r0) != r2) goto L19;
            return r2;
        L7:
            r0 = new FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1$1(this, r10);
            goto L8
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class j<T> implements kotlinx.coroutines.flow.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<R> f17386a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function3<R, T, Continuation<? super R>, Object> f17387b;
        final /* synthetic */ kotlinx.coroutines.flow.j<R> c;

        j(Ref.ObjectRef<R> r3, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> r4, kotlinx.coroutines.flow.j<? super R> r5) {
            Function3<R, T, Continuation<? super R>, Object> r6 = (Function3) ZeusTransformUtils.wrapperContextForParams(r4, Function3.class, "com.obric.memorydata.plugin");
            kotlinx.coroutines.flow.j<R> r7 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r5, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            this.f17386a = r3;
            this.f17387b = r6;
            this.c = r7;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlinx.coroutines.flow.j
        public final Object emit(T r8, Continuation<? super Unit> r9) {
            Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r10, FlowKt__TransformKt$runningFold$1$1$emit$1.class) == false) goto L7;
            FlowKt__TransformKt$runningFold$1$1$emit$1 r0 = (FlowKt__TransformKt$runningFold$1$1$emit$1) ZeusTransformUtils.preCheckCast(r10, FlowKt__TransformKt$runningFold$1$1$emit$1.class, "com.obric.memorydata.plugin");
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
            Ref.ObjectRef r7 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r0.L$1, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
            j<T> r12 = (j) ZeusTransformUtils.preCheckCast(r0.L$0, j.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r11);
        L20:
            r7.element = (T) r11;
            kotlinx.coroutines.flow.j<R> r13 = r12.c;
            T r14 = r12.f17386a.element;
            r0.L$0 = null;
            r0.L$1 = null;
            r0.label = 2;
            if (r13.emit((R) r14, r0) != r2) goto L24;
            return r2;
        L16:
            ResultKt.throwOnFailure(r11);
            Ref.ObjectRef r15 = this.f17386a;
            Function3<R, T, Continuation<? super R>, Object> r1 = this.f17387b;
            T r4 = r15.element;
            r0.L$0 = this;
            r0.L$1 = r15;
            r0.label = 1;
            Object r16 = r1.invoke((R) r4, r8, r0);
            if (r16 != r2) goto L19;
            return r2;
        L19:
            r12 = this;
            r7 = r15;
            r11 = (T) r16;
        L7:
            r0 = new FlowKt__TransformKt$runningFold$1$1$emit$1(this, r10);
            goto L8
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class k<T> implements kotlinx.coroutines.flow.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<Object> f17388a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function3<T, T, Continuation<? super T>, Object> f17389b;
        final /* synthetic */ kotlinx.coroutines.flow.j<T> c;

        @Override // kotlinx.coroutines.flow.j
        public final Object emit(T r8, Continuation<? super Unit> r9) {
            Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r10, FlowKt__TransformKt$runningReduce$1$1$emit$1.class) == false) goto L7;
            FlowKt__TransformKt$runningReduce$1$1$emit$1 r0 = (FlowKt__TransformKt$runningReduce$1$1$emit$1) ZeusTransformUtils.preCheckCast(r10, FlowKt__TransformKt$runningReduce$1$1$emit$1.class, "com.obric.memorydata.plugin");
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
            k<T> r12 = (k) ZeusTransformUtils.preCheckCast(r0.L$0, k.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r11);
        L23:
            Object r6 = r11;
            Ref.ObjectRef<Object> r13 = r7;
            k<T> this = r12;
            r8 = (T) r6;
        L24:
            r13.element = r8;
            kotlinx.coroutines.flow.j<T> r14 = this.c;
            T r15 = this.f17388a.element;
            r0.L$0 = null;
            r0.L$1 = null;
            r0.label = 2;
            if (r14.emit(r15, r0) != r2) goto L28;
            return r2;
        L16:
            ResultKt.throwOnFailure(r11);
            r13 = this.f17388a;
            if (r13.element == kotlinx.coroutines.flow.internal.s.f17463a) goto L24;
            Function3<T, T, Continuation<? super T>, Object> r1 = this.f17389b;
            T r4 = this.f17388a.element;
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
            r0 = new FlowKt__TransformKt$runningReduce$1$1$emit$1(this, r10);
            goto L8
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class l<T> implements kotlinx.coroutines.flow.i<IndexedValue<? extends T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f17390a;

        public l(kotlinx.coroutines.flow.i r3) {
            this.f17390a = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlinx.coroutines.flow.i
        public Object collect(kotlinx.coroutines.flow.j<? super IndexedValue<? extends T>> r4, Continuation<? super Unit> r5) {
            kotlinx.coroutines.flow.j r6 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            Ref.IntRef r0 = new Ref.IntRef();
            Object r3 = this.f17390a.collect((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new m(r6, r0), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), r7);
            if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r3;
        L6:
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class m<T> implements kotlinx.coroutines.flow.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.j<IndexedValue<? extends T>> f17391a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f17392b;

        m(kotlinx.coroutines.flow.j<? super IndexedValue<? extends T>> r3, Ref.IntRef r4) {
            this.f17391a = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            this.f17392b = r4;
        }

        @Override // kotlinx.coroutines.flow.j
        public final Object emit(T r7, Continuation<? super Unit> r8) {
            Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r9, FlowKt__TransformKt$withIndex$1$1$emit$1.class) == false) goto L7;
            FlowKt__TransformKt$withIndex$1$1$emit$1 r0 = (FlowKt__TransformKt$withIndex$1$1$emit$1) ZeusTransformUtils.preCheckCast(r9, FlowKt__TransformKt$withIndex$1$1$emit$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r10 = r0.result;
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = r0.label;
            if (r2 == 0) goto L14;
            if (r2 != 1) goto L13;
            ResultKt.throwOnFailure(r10);
        L20:
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r10);
            kotlinx.coroutines.flow.j<IndexedValue<? extends T>> r11 = this.f17391a;
            int r4 = this.f17392b.element;
            this.f17392b.element = r4 + 1;
            if (r4 < 0) goto L22;
            IndexedValue<? extends T> r3 = new IndexedValue(r4, r7);
            r0.label = 1;
            if (r11.emit(r3, r0) != r1) goto L20;
            return r1;
        L22:
            throw new ArithmeticException("Index overflow has happened");
        L7:
            r0 = new FlowKt__TransformKt$withIndex$1$1$emit$1(this, r9);
            goto L8
        }
    }

    public static final <T> kotlinx.coroutines.flow.i<T> a(kotlinx.coroutines.flow.i<? extends T> r2) {
        return (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new e((kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
    }

    public static final <T, R> kotlinx.coroutines.flow.i<R> a(kotlinx.coroutines.flow.i<? extends T> r2, R r3, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> r4) {
        return kotlinx.coroutines.flow.k.b((kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), r3, (Function3) ZeusTransformUtils.wrapperContextForParams(r4, Function3.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> kotlinx.coroutines.flow.i<T> a(kotlinx.coroutines.flow.i<? extends T> r2, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> r3) {
        return (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new h((kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
    }

    public static final <T> kotlinx.coroutines.flow.i<IndexedValue<T>> b(kotlinx.coroutines.flow.i<? extends T> r2) {
        return (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new l((kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
    }

    public static final <T, R> kotlinx.coroutines.flow.i<R> b(kotlinx.coroutines.flow.i<? extends T> r2, R r3, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> r4) {
        return (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new i(r3, (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), (Function3) ZeusTransformUtils.wrapperContextForParams(r4, Function3.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
    }
}
