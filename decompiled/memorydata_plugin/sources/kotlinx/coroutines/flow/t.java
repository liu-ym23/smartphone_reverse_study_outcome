package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.SafeCollector;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0010\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0002H\u0000\u001ap\u0010\u0003\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00022D\u0010\u0005\u001a@\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u0002\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0006¢\u0006\u0002\b\r2\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0082@¢\u0006\u0004\b\u000e\u0010\u000f\u001ag\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0011\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00112D\u0010\u0005\u001a@\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u0002\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0006¢\u0006\u0002\b\r¢\u0006\u0002\u0010\u0012\u001aP\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0011\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00112-\u0010\u0005\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0014¢\u0006\u0002\b\r¢\u0006\u0002\u0010\u0015\u001aP\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0011\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00112-\u0010\u0005\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0014¢\u0006\u0002\b\r¢\u0006\u0002\u0010\u0015\u001ap\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0011\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0018*\b\u0012\u0004\u0012\u0002H\u00040\u00112D\b\u0005\u0010\u0017\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180\u0002\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0006¢\u0006\u0002\b\rH\u0086\b¢\u0006\u0002\u0010\u0012\u001ap\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0011\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0018*\b\u0012\u0004\u0012\u0002H\u00040\u00112D\b\u0005\u0010\u0017\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180\u0002\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0006¢\u0006\u0002\b\rH\u0081\b¢\u0006\u0002\u0010\u0012¨\u0006\u001b"}, d2 = {"ensureActive", "", "Lkotlinx/coroutines/flow/FlowCollector;", "invokeSafely", ExifInterface.GPS_DIRECTION_TRUE, "action", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "cause", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "invokeSafely$FlowKt__EmittersKt", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/jvm/functions/Function3;Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCompletion", "Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "onEmpty", "Lkotlin/Function2;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "onStart", "transform", "R", EventBody.KEY_VALUE, "unsafeTransform", "kotlinx-coroutines-core"}, k = 5, mv = {1, 9, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class t {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class a<T> implements i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f17492a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function3 f17493b;

        public a(i r3, Function3 r4) {
            i r5 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.memorydata.plugin");
            Function3 r6 = (Function3) ZeusTransformUtils.wrapperContextForParams(r4, Function3.class, "com.obric.memorydata.plugin");
            this.f17492a = r5;
            this.f17493b = r6;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r1v2, types: [kotlin.coroutines.CoroutineContext] */
        @Override // kotlinx.coroutines.flow.i
        public Object collect(j<? super T> r10, Continuation<? super Unit> r11) {
            String r1 = "com.obric.memorydata.plugin";
            j<? super T> r12 = (j) ZeusTransformUtils.wrapperContextForParams(r10, j.class, "com.obric.memorydata.plugin");
            Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r13, FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1.class) == false) goto L7;
            FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1 r0 = (FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1) ZeusTransformUtils.preCheckCast(r13, FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r14 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L24;
            if (r3 == 1) goto L21;
            if (r3 == 2) goto L20;
            if (r3 != 3) goto L19;
            SafeCollector r9 = (SafeCollector) ZeusTransformUtils.preCheckCast(r0.L$0, SafeCollector.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L16
        L33:
            r9.releaseIntercepted();
            return Unit.INSTANCE;
        L16:
            th = th;
        L37:
            r9.releaseIntercepted();
            throw th;
        L19:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L20:
            Throwable r15 = (Throwable) ZeusTransformUtils.preCheckCast(r0.L$0, Throwable.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r14);
            throw r15;
        L21:
            r12 = (j) ZeusTransformUtils.preCheckCast(r0.L$1, j.class, "com.obric.memorydata.plugin");
            a<T> this = (a) ZeusTransformUtils.preCheckCast(r0.L$0, a.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L39
        L28:
            r1 = r0.getContext();
            SafeCollector r16 = new SafeCollector(r12, r1);
            Function3 r17 = this.f17493b;     // Catch: Throwable -> L35
            r0.L$0 = r16;     // Catch: Throwable -> L35
            r0.L$1 = null;     // Catch: Throwable -> L35
            r0.label = 3;     // Catch: Throwable -> L35
            InlineMarker.mark(6);     // Catch: Throwable -> L35
            Object r18 = r17.invoke(r16, null, r0);     // Catch: Throwable -> L35
            InlineMarker.mark(7);     // Catch: Throwable -> L35
            if (r18 != r2) goto L32;
            return r2;
        L32:
            r9 = r16;
        L35:
            th = th;
            r9 = r16;
            goto L37
        L24:
            ResultKt.throwOnFailure(r14);
            Continuation r19 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            i r110 = this.f17492a;     // Catch: Throwable -> L39
            r0.L$0 = this;     // Catch: Throwable -> L39
            r0.L$1 = r12;     // Catch: Throwable -> L39
            r0.label = 1;     // Catch: Throwable -> L39
            if (r110.collect(r12, r0) != r2) goto L28;
            return r2;
        L39:
            th = move-exception;
            j r111 = (j) ZeusTransformUtils.preCheckCast(new ax(th), j.class, r1);
            Function3 r112 = this.f17493b;
            r0.L$0 = th;
            r0.L$1 = null;
            r0.label = 2;
            if (t.a(r111, r112, th, r0) != r2) goto L50;
            return r2;
        L50:
            throw th;
        L7:
            r0 = new FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1(this, r13);
            goto L8
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class b<T> implements i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f17494a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function2 f17495b;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v5, types: [kotlinx.coroutines.flow.t$b] */
        /* JADX WARN: Type inference failed for: r1v8 */
        /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.Object, kotlinx.coroutines.flow.t$b, kotlinx.coroutines.flow.t$b<T>] */
        /* JADX WARN: Type inference failed for: r8v1, types: [kotlinx.coroutines.flow.internal.SafeCollector] */
        /* JADX WARN: Type inference failed for: r8v17 */
        /* JADX WARN: Type inference failed for: r8v18 */
        /* JADX WARN: Type inference failed for: r8v7, types: [kotlinx.coroutines.flow.internal.SafeCollector] */
        @Override // kotlinx.coroutines.flow.i
        public Object collect(j<? super T> r9, Continuation<? super Unit> r10) {
            j r11 = (j) ZeusTransformUtils.wrapperContextForParams(r9, j.class, "com.obric.memorydata.plugin");
            Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r12, FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1$1.class) == false) goto L7;
            FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1$1 r0 = (FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1$1) ZeusTransformUtils.preCheckCast(r12, FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r13 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L20;
            if (r3 == 1) goto L19;
            if (r3 != 2) goto L18;
            boolean r8 = (b<T>) ((SafeCollector) ZeusTransformUtils.preCheckCast(r0.L$0, SafeCollector.class, "com.obric.memorydata.plugin"));
            ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L15
            b<T> this = r8;
        L30:
            ((SafeCollector) this).releaseIntercepted();
        L34:
            return Unit.INSTANCE;
        L18:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L19:
            Ref.BooleanRef r14 = (Ref.BooleanRef) ZeusTransformUtils.preCheckCast(r0.L$2, Ref.BooleanRef.class, "com.obric.memorydata.plugin");
            r11 = (j) ZeusTransformUtils.preCheckCast(r0.L$1, j.class, "com.obric.memorydata.plugin");
            b r1 = (b) ZeusTransformUtils.preCheckCast(r0.L$0, b.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r13);
            ?? r4 = r1;
        L25:
            if (r14.element == false) goto L34;
            SafeCollector r15 = new SafeCollector(r11, r0.getContext());
            Function2 r16 = r4.f17495b;     // Catch: Throwable -> L15
            r0.L$0 = r15;     // Catch: Throwable -> L15
            r0.L$1 = null;     // Catch: Throwable -> L15
            r0.L$2 = null;     // Catch: Throwable -> L15
            r0.label = 2;     // Catch: Throwable -> L15
            InlineMarker.mark(6);     // Catch: Throwable -> L15
            Object r17 = r16.invoke(r15, r0);     // Catch: Throwable -> L15
            InlineMarker.mark(7);     // Catch: Throwable -> L15
            this = r15;
            if (r17 != r2) goto L30;
            return r2;
        L20:
            ResultKt.throwOnFailure(r13);
            Continuation r18 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            Ref.BooleanRef r19 = new Ref.BooleanRef();
            r19.element = true;
            i r5 = this.f17494a;
            j<? super T> r6 = (j) ZeusTransformUtils.preCheckCast(new c(r19, r11), j.class, "com.obric.memorydata.plugin");
            r0.L$0 = this;
            r0.L$1 = r11;
            r0.L$2 = r19;
            r0.label = 1;
            if (r5.collect(r6, r0) != r2) goto L23;
            return r2;
        L23:
            r4 = this;
            r14 = r19;
        L15:
            th = move-exception;
            this.releaseIntercepted();
            throw th;
        L7:
            r0 = new FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1$1(this, r12);
            goto L8
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "it", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class c<T> implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f17496a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ j<T> f17497b;

        c(Ref.BooleanRef r3, j<? super T> r4) {
            j<T> r5 = (j) ZeusTransformUtils.wrapperContextForParams(r4, j.class, "com.obric.memorydata.plugin");
            this.f17496a = r3;
            this.f17497b = r5;
        }

        @Override // kotlinx.coroutines.flow.j
        public final Object emit(T r5, Continuation<? super Unit> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r7, FlowKt__EmittersKt$onEmpty$1$1$emit$1.class) == false) goto L7;
            FlowKt__EmittersKt$onEmpty$1$1$emit$1 r0 = (FlowKt__EmittersKt$onEmpty$1$1$emit$1) ZeusTransformUtils.preCheckCast(r7, FlowKt__EmittersKt$onEmpty$1$1$emit$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r8 = r0.result;
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = r0.label;
            if (r2 == 0) goto L14;
            if (r2 != 1) goto L13;
            ResultKt.throwOnFailure(r8);
        L18:
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r8);
            this.f17496a.element = false;
            j<T> r4 = this.f17497b;
            r0.label = 1;
            if (r4.emit(r5, r0) != r1) goto L18;
            return r1;
        L7:
            r0 = new FlowKt__EmittersKt$onEmpty$1$1$emit$1(this, r7);
            goto L8
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class d<T> implements i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2 f17498a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i f17499b;

        public d(Function2 r3, i r4) {
            Function2 r5 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
            i r6 = (i) ZeusTransformUtils.wrapperContextForParams(r4, i.class, "com.obric.memorydata.plugin");
            this.f17498a = r5;
            this.f17499b = r6;
        }

        @Override // kotlinx.coroutines.flow.i
        public Object collect(j<? super T> r7, Continuation<? super Unit> r8) {
            j<? super T> r9 = (j) ZeusTransformUtils.wrapperContextForParams(r7, j.class, "com.obric.memorydata.plugin");
            Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r10, FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1.class) == false) goto L7;
            FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1 r0 = (FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1) ZeusTransformUtils.preCheckCast(r10, FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r11 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L20;
            if (r3 == 1) goto L15;
            if (r3 != 2) goto L14;
            ResultKt.throwOnFailure(r11);
        L29:
            return Unit.INSTANCE;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            SafeCollector r6 = (SafeCollector) ZeusTransformUtils.preCheckCast(r0.L$2, SafeCollector.class, "com.obric.memorydata.plugin");
            r9 = (j) ZeusTransformUtils.preCheckCast(r0.L$1, j.class, "com.obric.memorydata.plugin");
            d<T> r1 = (d) ZeusTransformUtils.preCheckCast(r0.L$0, d.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L18
        L25:
            r6.releaseIntercepted();
            i r12 = r1.f17499b;
            r0.L$0 = null;
            r0.L$1 = null;
            r0.L$2 = null;
            r0.label = 2;
            if (r12.collect(r9, r0) != r2) goto L29;
            return r2;
        L18:
            th = th;
        L32:
            r6.releaseIntercepted();
            throw th;
        L20:
            ResultKt.throwOnFailure(r11);
            Continuation r13 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            SafeCollector r14 = new SafeCollector(r9, r0.getContext());
            Function2 r4 = this.f17498a;     // Catch: Throwable -> L30
            r0.L$0 = this;     // Catch: Throwable -> L30
            r0.L$1 = r9;     // Catch: Throwable -> L30
            r0.L$2 = r14;     // Catch: Throwable -> L30
            r0.label = 1;     // Catch: Throwable -> L30
            InlineMarker.mark(6);     // Catch: Throwable -> L30
            Object r5 = r4.invoke(r14, r0);     // Catch: Throwable -> L30
            InlineMarker.mark(7);     // Catch: Throwable -> L30
            if (r5 != r2) goto L24;
            return r2;
        L24:
            r1 = this;
            r6 = r14;
        L30:
            th = th;
            r6 = r14;
        L7:
            r0 = new FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1(this, r10);
            goto L8
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 176)
    public static final class e<R> implements i<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f17500a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function3 f17501b;

        @Override // kotlinx.coroutines.flow.i
        public Object collect(j<? super R> r4, Continuation<? super Unit> r5) {
            j r6 = (j) ZeusTransformUtils.wrapperContextForParams(r4, j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            Object r3 = this.f17500a.collect((j) ZeusTransformUtils.preCheckCast(new f(this.f17501b, r6), j.class, "com.obric.memorydata.plugin"), r7);
            if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r3;
        L6:
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 176)
    public static final class f<T> implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function3<j<? super R>, T, Continuation<? super Unit>, Object> f17502a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ j<R> f17503b;

        public f(Function3<? super j<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> r3, j<? super R> r4) {
            Function3<j<? super R>, T, Continuation<? super Unit>, Object> r5 = (Function3) ZeusTransformUtils.wrapperContextForParams(r3, Function3.class, "com.obric.memorydata.plugin");
            j<R> r6 = (j) ZeusTransformUtils.wrapperContextForParams(r4, j.class, "com.obric.memorydata.plugin");
            this.f17502a = r5;
            this.f17503b = r6;
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
        public final Object emit(T r5, Continuation<? super Unit> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r7, FlowKt__EmittersKt$unsafeTransform$1$1$emit$1.class) == false) goto L7;
            FlowKt__EmittersKt$unsafeTransform$1$1$emit$1 r0 = (FlowKt__EmittersKt$unsafeTransform$1$1$emit$1) ZeusTransformUtils.preCheckCast(r7, FlowKt__EmittersKt$unsafeTransform$1$1$emit$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r8 = r0.result;
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = r0.label;
            if (r2 == 0) goto L14;
            if (r2 != 1) goto L13;
            ResultKt.throwOnFailure(r8);
        L18:
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r8);
            Function3<j<? super R>, T, Continuation<? super Unit>, Object> r9 = this.f17502a;
            Object r4 = this.f17503b;
            r0.label = 1;
            if (r9.invoke(r4, r5, r0) != r1) goto L18;
            return r1;
        L7:
            r0 = new FlowKt__EmittersKt$unsafeTransform$1$1$emit$1(this, r7);
            goto L8
        }
    }

    public static final /* synthetic */ Object a(j r2, Function3 r3, Throwable r4, Continuation r5) {
        return b((j) ZeusTransformUtils.wrapperContextForParams(r2, j.class, "com.obric.memorydata.plugin"), (Function3) ZeusTransformUtils.wrapperContextForParams(r3, Function3.class, "com.obric.memorydata.plugin"), r4, (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> i<T> a(i<? extends T> r2, Function2<? super j<? super T>, ? super Continuation<? super Unit>, ? extends Object> r3) {
        i r4 = (i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin");
        return (i) ZeusTransformUtils.preCheckCast(new d((Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin"), r4), i.class, "com.obric.memorydata.plugin");
    }

    public static final <T> i<T> a(i<? extends T> r2, Function3<? super j<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> r3) {
        return (i) ZeusTransformUtils.preCheckCast(new a((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"), (Function3) ZeusTransformUtils.wrapperContextForParams(r3, Function3.class, "com.obric.memorydata.plugin")), i.class, "com.obric.memorydata.plugin");
    }

    public static final void a(j<?> r2) {
        j r3 = (j) ZeusTransformUtils.wrapperContextForParams(r2, j.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, ax.class) == true) goto L6;
        return;
    L6:
        throw ((ax) ZeusTransformUtils.preCheckCast(r3, ax.class, "com.obric.memorydata.plugin")).f17435a;
    }

    private static final <T> Object b(j<? super T> r5, Function3<? super j<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> r6, Throwable r7, Continuation<? super Unit> r8) {
        j r9 = (j) ZeusTransformUtils.wrapperContextForParams(r5, j.class, "com.obric.memorydata.plugin");
        Function3 r10 = (Function3) ZeusTransformUtils.wrapperContextForParams(r6, Function3.class, "com.obric.memorydata.plugin");
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r11, FlowKt__EmittersKt$invokeSafely$1.class) == false) goto L7;
        FlowKt__EmittersKt$invokeSafely$1 r0 = (FlowKt__EmittersKt$invokeSafely$1) ZeusTransformUtils.preCheckCast(r11, FlowKt__EmittersKt$invokeSafely$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        r7 = (Throwable) ZeusTransformUtils.preCheckCast(r0.L$0, Throwable.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L22
    L20:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r12);
        r0.L$0 = r7;     // Catch: Throwable -> L22
        r0.label = 1;     // Catch: Throwable -> L22
        if (r10.invoke(r9, r7, r0) != r2) goto L20;
        return r2;
    L22:
        th = move-exception;
        if (r7 == null) goto L26;
        if (r7 == th) goto L26;
        ExceptionsKt.addSuppressed(th, r7);
    L26:
        throw th;
    L7:
        r0 = new FlowKt__EmittersKt$invokeSafely$1(r11);
        goto L8
    }
}
