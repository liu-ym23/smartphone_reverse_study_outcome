package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.bx;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ae\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012B\u0010\u0003\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0004¢\u0006\u0002\b\r¢\u0006\u0002\u0010\u000e\u001a.\u0010\u000f\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0080@¢\u0006\u0002\u0010\u0011\u001a\u0019\u0010\u0012\u001a\u00020\u0013*\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015H\u0002¢\u0006\u0002\b\u0016\u001a\u001b\u0010\u0017\u001a\u00020\u0013*\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0002\b\u0019\u001a`\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\b\b\u0002\u0010\u001b\u001a\u00020\u001c23\b\u0002\u0010\u001d\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u001e¢\u0006\u0002\u0010\u001f\u001az\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012W\u0010\u001d\u001aS\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\n\u0012\u0006\u0012\u0004\u0018\u00010\f0!¢\u0006\u0002\b\r¢\u0006\u0002\u0010#¨\u0006$"}, d2 = {"catch", "Lkotlinx/coroutines/flow/Flow;", ExifInterface.GPS_DIRECTION_TRUE, "action", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "cause", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "catchImpl", "collector", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isCancellationCause", "", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "isCancellationCause$FlowKt__ErrorsKt", "isSameExceptionAs", "other", "isSameExceptionAs$FlowKt__ErrorsKt", "retry", "retries", "", "predicate", "Lkotlin/Function2;", "(Lkotlinx/coroutines/flow/Flow;JLkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "retryWhen", "Lkotlin/Function4;", "attempt", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function4;)Lkotlinx/coroutines/flow/Flow;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 9, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class u {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class a<T> implements i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f17504a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function3 f17505b;

        public a(i r3, Function3 r4) {
            i r5 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.memorydata.plugin");
            Function3 r6 = (Function3) ZeusTransformUtils.wrapperContextForParams(r4, Function3.class, "com.obric.memorydata.plugin");
            this.f17504a = r5;
            this.f17505b = r6;
        }

        @Override // kotlinx.coroutines.flow.i
        public Object collect(j<? super T> r7, Continuation<? super Unit> r8) {
            j r9 = (j) ZeusTransformUtils.wrapperContextForParams(r7, j.class, "com.obric.memorydata.plugin");
            Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r10, FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1.class) == false) goto L7;
            FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1 r0 = (FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1) ZeusTransformUtils.preCheckCast(r10, FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1.class, "com.obric.memorydata.plugin");
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
        L25:
            return Unit.INSTANCE;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            r9 = (j) ZeusTransformUtils.preCheckCast(r0.L$1, j.class, "com.obric.memorydata.plugin");
            a<T> this = (a) ZeusTransformUtils.preCheckCast(r0.L$0, a.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r11);
        L19:
            Throwable r12 = (Throwable) ZeusTransformUtils.preCheckCast(r11, Throwable.class, "com.obric.memorydata.plugin");
            if (r12 == null) goto L25;
            Function3 r6 = this.f17505b;
            r0.L$0 = null;
            r0.L$1 = null;
            r0.label = 2;
            InlineMarker.mark(6);
            Object r13 = r6.invoke(r9, r12, r0);
            InlineMarker.mark(7);
            if (r13 != r2) goto L25;
            return r2;
        L16:
            ResultKt.throwOnFailure(r11);
            Continuation r14 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            i r15 = this.f17504a;
            r0.L$0 = this;
            r0.L$1 = r9;
            r0.label = 1;
            r11 = k.a(r15, r9, r0);
            if (r11 != r2) goto L19;
            return r2;
        L7:
            r0 = new FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1(this, r10);
            goto L8
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "it", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class b<T> implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ j<T> f17506a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<Throwable> f17507b;

        b(j<? super T> r3, Ref.ObjectRef<Throwable> r4) {
            this.f17506a = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin");
            this.f17507b = r4;
        }

        /* JADX WARN: Type inference failed for: r6v1, types: [T, java.lang.Throwable] */
        @Override // kotlinx.coroutines.flow.j
        public final Object emit(T r6, Continuation<? super Unit> r7) {
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r8, FlowKt__ErrorsKt$catchImpl$2$emit$1.class) == false) goto L7;
            FlowKt__ErrorsKt$catchImpl$2$emit$1 r0 = (FlowKt__ErrorsKt$catchImpl$2$emit$1) ZeusTransformUtils.preCheckCast(r8, FlowKt__ErrorsKt$catchImpl$2$emit$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r9 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L16;
            if (r3 != 1) goto L15;
            b r5 = (b) ZeusTransformUtils.preCheckCast(r0.L$0, b.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L22
        L20:
            b<T> this = (b<T>) Unit.INSTANCE;
            return this;
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L16:
            ResultKt.throwOnFailure(r9);
            j<T> r10 = this.f17506a;     // Catch: Throwable -> L22
            r0.L$0 = this;     // Catch: Throwable -> L22
            r0.label = 1;     // Catch: Throwable -> L22
            if (r10.emit(r6, r0) != r2) goto L20;
            return r2;
        L22:
            th = move-exception;
            r6 = (T) th;
            this.f17507b.element = r6;
            throw r6;
        L7:
            r0 = new FlowKt__ErrorsKt$catchImpl$2$emit$1(this, r8);
            goto L8
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class c<T> implements i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f17508a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function4 f17509b;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00e4 -> B:28:0x00e9). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00ff -> B:33:0x0103). Please report as a decompilation issue!!! */
        @Override // kotlinx.coroutines.flow.i
        public Object collect(j<? super T> r13, Continuation<? super Unit> r14) {
            j r15 = (j) ZeusTransformUtils.wrapperContextForParams(r13, j.class, "com.obric.memorydata.plugin");
            Continuation r16 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r14, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r16, FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$1.class) == false) goto L7;
            FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$1 r1 = (FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$1) ZeusTransformUtils.preCheckCast(r16, FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$1.class, "com.obric.memorydata.plugin");
            if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
            r1.label -= Integer.MIN_VALUE;
        L8:
            Object r17 = r1.result;
            Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r4 = r1.label;
            if (r4 == 0) goto L17;
            if (r4 == 1) goto L15;
            if (r4 != 2) goto L14;
            long r12 = r1.J$0;
            Throwable r5 = (Throwable) ZeusTransformUtils.preCheckCast(r1.L$2, Throwable.class, "com.obric.memorydata.plugin");
            j r7 = (j) ZeusTransformUtils.preCheckCast(r1.L$1, j.class, "com.obric.memorydata.plugin");
            c<T> r0 = (c) ZeusTransformUtils.preCheckCast(r1.L$0, c.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r17);
        L29:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r17, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L31;
            int r18 = 1;
            long r10 = r12 + 1;
            c<T> this = r0;
        L33:
            r15 = r7;
            long r8 = r10;
            if (r18 == 0) goto L36;
        L18:
            r18 = 0;
            i r2 = this.f17508a;
            r1.L$0 = this;
            r1.L$1 = r15;
            r1.L$2 = null;
            r1.J$0 = r8;
            r1.I$0 = 0;
            r1.label = 1;
            Object r6 = k.a(r2, r15, r1);
            if (r6 != r3) goto L21;
            return r3;
        L21:
            Object r9 = r3;
            FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$1 r11 = r1;
            c<T> r19 = this;
        L16:
            long r110 = r8;
            r7 = r15;
            r12 = r110;
            Throwable r20 = (Throwable) ZeusTransformUtils.preCheckCast(r6, Throwable.class, "com.obric.memorydata.plugin");
            if (r20 == null) goto L32;
            Function4 r111 = r19.f17509b;
            Long r21 = Boxing.boxLong(r12);
            r11.L$0 = r19;
            r11.L$1 = r7;
            r11.L$2 = r20;
            r11.J$0 = r12;
            r11.label = 2;
            InlineMarker.mark(6);
            r17 = r111.invoke(r7, r20, r21, r11);
            InlineMarker.mark(7);
            if (r17 != r9) goto L27;
            return r9;
        L27:
            Object r112 = r9;
            r5 = r20;
            r0 = r19;
            r1 = r11;
            r3 = r112;
            goto L29
        L32:
            r10 = r12;
            this = r19;
            r1 = r11;
            r3 = r9;
            goto L33
        L36:
            return Unit.INSTANCE;
        L31:
            throw r5;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            int r113 = r1.I$0;
            r8 = r1.J$0;
            r15 = (j) ZeusTransformUtils.preCheckCast(r1.L$1, j.class, "com.obric.memorydata.plugin");
            c<T> r22 = (c) ZeusTransformUtils.preCheckCast(r1.L$0, c.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r17);
            r9 = r3;
            r11 = r1;
            r19 = r22;
            r6 = r17;
            r18 = r113;
            goto L16
        L17:
            ResultKt.throwOnFailure(r17);
            Continuation r114 = (Continuation) ZeusTransformUtils.preCheckCast(r1, Continuation.class, "com.obric.memorydata.plugin");
            r8 = 0;
        L7:
            r1 = new FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$1(this, r16);
            goto L8
        }
    }

    public static final <T> Object a(i<? extends T> r5, j<? super T> r6, Continuation<? super Throwable> r7) {
        i r8 = (i) ZeusTransformUtils.wrapperContextForParams(r5, i.class, "com.obric.memorydata.plugin");
        j r9 = (j) ZeusTransformUtils.wrapperContextForParams(r6, j.class, "com.obric.memorydata.plugin");
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, FlowKt__ErrorsKt$catchImpl$1.class) == false) goto L7;
        FlowKt__ErrorsKt$catchImpl$1 r0 = (FlowKt__ErrorsKt$catchImpl$1) ZeusTransformUtils.preCheckCast(r10, FlowKt__ErrorsKt$catchImpl$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        Ref.ObjectRef r12 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r0.L$0, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L14
        return null;
    L14:
        th = th;
    L26:
        Throwable r13 = (Throwable) ZeusTransformUtils.preCheckCast(r12.element, Throwable.class, "com.obric.memorydata.plugin");
        if (a(th, r13) == false) goto L29;
    L38:
        throw th;
    L29:
        if (a(th, r0.getContext()) == true) goto L38;
        if (r13 != null) goto L33;
        return th;
    L33:
        if (ZeusTransformUtils.instanceOf(th, CancellationException.class) == false) goto L36;
        ExceptionsKt.addSuppressed(r13, th);
        throw r13;
    L36:
        ExceptionsKt.addSuppressed(th, r13);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r11);
        Ref.ObjectRef r14 = new Ref.ObjectRef();
        j<? super T> r15 = (j) ZeusTransformUtils.preCheckCast(new b(r9, r14), j.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        r0.L$0 = r14;     // Catch: Throwable -> L24
        r0.label = 1;     // Catch: Throwable -> L24
        if (r8.collect(r15, r0) != r2) goto L22;
        return r2;
    L22:
        return null;
    L24:
        th = th;
        r12 = r14;
    L7:
        r0 = new FlowKt__ErrorsKt$catchImpl$1(r10);
        goto L8
    }

    public static final <T> i<T> a(i<? extends T> r2, Function3<? super j<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> r3) {
        return (i) ZeusTransformUtils.preCheckCast(new a((i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin"), (Function3) ZeusTransformUtils.wrapperContextForParams(r3, Function3.class, "com.obric.memorydata.plugin")), i.class, "com.obric.memorydata.plugin");
    }

    private static final boolean a(Throwable r1, Throwable r2) {
        if (r2 != null) goto L4;
    L14:
        return false;
    L4:
        if (kotlinx.coroutines.an.c() == false) goto L8;
        r2 = kotlinx.coroutines.internal.ai.b(r2);
    L8:
        if (kotlinx.coroutines.an.c() == false) goto L12;
        r1 = kotlinx.coroutines.internal.ai.b(r1);
    L12:
        if (Intrinsics.areEqual(r2, r1) == false) goto L14;
        return true;
    }

    private static final boolean a(Throwable r3, CoroutineContext r4) {
        bx r5 = (bx) ZeusTransformUtils.preCheckCast(((CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r4, CoroutineContext.class, "com.obric.memorydata.plugin")).get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(bx.f17252a, CoroutineContext.Key.class, "com.obric.memorydata.plugin")), bx.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return false;
    L5:
        if (r5.r_() == true) goto L8;
        return false;
    L8:
        return a(r3, (Throwable) ZeusTransformUtils.preCheckCast(r5.t_(), Throwable.class, "com.obric.memorydata.plugin"));
    }
}
