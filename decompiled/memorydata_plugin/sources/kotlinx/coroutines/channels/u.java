package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.ag;
import kotlinx.coroutines.al;
import kotlinx.coroutines.bx;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a&\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00022\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0086@¢\u0006\u0002\u0010\u0005\u001a\u009b\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b*\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2-\b\u0002\u0010\u0010\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011j\u0004\u0018\u0001`\u00162/\b\u0001\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0017¢\u0006\u0002\b\u001aH\u0007¢\u0006\u0002\u0010\u001b\u001a¥\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b*\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2-\b\u0002\u0010\u0010\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011j\u0004\u0018\u0001`\u00162/\b\u0001\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0017¢\u0006\u0002\b\u001aH\u0000¢\u0006\u0002\u0010\u001e\u001ab\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b*\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2/\b\u0001\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0017¢\u0006\u0002\b\u001aH\u0007¢\u0006\u0002\u0010\u001f¨\u0006 "}, d2 = {"awaitClose", "", "Lkotlinx/coroutines/channels/ProducerScope;", "block", "Lkotlin/Function0;", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "produce", "Lkotlinx/coroutines/channels/ReceiveChannel;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", CommonConsts.APM_INNER_EVENT_COST_START, "Lkotlinx/coroutines/CoroutineStart;", "onCompletion", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "cause", "Lkotlinx/coroutines/CompletionHandler;", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class u {
    public static final Object a(w<?> r6, Function0<Unit> r7, Continuation<? super Unit> r8) {
        w r9 = (w) ZeusTransformUtils.wrapperContextForParams(r6, w.class, "com.obric.memorydata.plugin");
        Function0 r10 = (Function0) ZeusTransformUtils.wrapperContextForParams(r7, Function0.class, "com.obric.memorydata.plugin");
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r11, ProduceKt$awaitClose$1.class) == false) goto L7;
        ProduceKt$awaitClose$1 r0 = (ProduceKt$awaitClose$1) ZeusTransformUtils.preCheckCast(r11, ProduceKt$awaitClose$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        r10 = (Function0) ZeusTransformUtils.preCheckCast(r0.L$1, Function0.class, "com.obric.memorydata.plugin");
        w r13 = (w) ZeusTransformUtils.preCheckCast(r0.L$0, w.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L14
    L28:
        r10.invoke();
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r12);
        if (r0.getContext().get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(bx.f17252a, CoroutineContext.Key.class, "com.obric.memorydata.plugin")) != r9) goto L21;
        boolean r14 = true;
    L22:
        if (r14 == false) goto L33;
        r0.L$0 = r9;     // Catch: Throwable -> L14
        r0.L$1 = r10;     // Catch: Throwable -> L14
        r0.label = 1;     // Catch: Throwable -> L14
        kotlinx.coroutines.o r4 = new kotlinx.coroutines.o(IntrinsicsKt.intercepted((Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin")), 1);     // Catch: Throwable -> L14
        r4.e();     // Catch: Throwable -> L14
        final kotlinx.coroutines.n r15 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r4, kotlinx.coroutines.n.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        r9.invokeOnClose((Function1) ZeusTransformUtils.preCheckCast(new ProduceKt$awaitClose$4$1(r15), Function1.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L14
        Object r16 = r4.h();     // Catch: Throwable -> L14
        if (r16 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L26;
        DebugProbesKt.probeCoroutineSuspended((Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L14
    L26:
        if (r16 != r2) goto L28;
        return r2;
    L33:
        throw new IllegalStateException("awaitClose() can only be invoked from the producer context".toString());
    L21:
        r14 = false;
    L14:
        th = move-exception;
        r10.invoke();
        throw th;
    L7:
        r0 = new ProduceKt$awaitClose$1(r11);
        goto L8
    }

    public static final <E> y<E> a(al r9, CoroutineContext r10, int r11, Function2<? super w<? super E>, ? super Continuation<? super Unit>, ? extends Object> r12) {
        al r2 = (al) ZeusTransformUtils.wrapperContextForParams(r9, al.class, "com.obric.memorydata.plugin");
        CoroutineContext r3 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r10, CoroutineContext.class, "com.obric.memorydata.plugin");
        Function2 r8 = (Function2) ZeusTransformUtils.wrapperContextForParams(r12, Function2.class, "com.obric.memorydata.plugin");
        return a(r2, r3, r11, BufferOverflow.SUSPEND, CoroutineStart.DEFAULT, null, r8);
    }

    public static /* synthetic */ y a(al r1, CoroutineContext r2, int r3, Function2 r4, int r5, Object r6) {
        al r7 = (al) ZeusTransformUtils.wrapperContextForParams(r1, al.class, "com.obric.memorydata.plugin");
        CoroutineContext r8 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r2, CoroutineContext.class, "com.obric.memorydata.plugin");
        Function2 r9 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r8 = (CoroutineContext) ZeusTransformUtils.preCheckCast(EmptyCoroutineContext.INSTANCE, CoroutineContext.class, "com.obric.memorydata.plugin");
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = 0;
    L9:
        return a(r7, r8, r3, r9);
    }

    public static final <E> y<E> a(al r3, CoroutineContext r4, int r5, BufferOverflow r6, CoroutineStart r7, Function1<? super Throwable, Unit> r8, Function2<? super w<? super E>, ? super Continuation<? super Unit>, ? extends Object> r9) {
        al r10 = (al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin");
        CoroutineContext r11 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r4, CoroutineContext.class, "com.obric.memorydata.plugin");
        Function1<? super Throwable, Unit> r12 = (Function1) ZeusTransformUtils.wrapperContextForParams(r8, Function1.class, "com.obric.memorydata.plugin");
        Function2 r13 = (Function2) ZeusTransformUtils.wrapperContextForParams(r9, Function2.class, "com.obric.memorydata.plugin");
        i r14 = l.a(r5, r6, null, 4, null);
        v r15 = new v(ag.a(r10, r11), r14);
        if (r12 == null) goto L5;
        r15.a(r12);
    L5:
        r15.a(r7, r15, r13);
        return (y) ZeusTransformUtils.preCheckCast(r15, y.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ y a(al r3, CoroutineContext r4, int r5, BufferOverflow r6, CoroutineStart r7, Function1 r8, Function2 r9, int r10, Object r11) {
        al r12 = (al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin");
        CoroutineContext r13 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r4, CoroutineContext.class, "com.obric.memorydata.plugin");
        Function1 r14 = (Function1) ZeusTransformUtils.wrapperContextForParams(r8, Function1.class, "com.obric.memorydata.plugin");
        Function2 r15 = (Function2) ZeusTransformUtils.wrapperContextForParams(r9, Function2.class, "com.obric.memorydata.plugin");
        if ((r10 & 1) == 0) goto L5;
        r13 = (CoroutineContext) ZeusTransformUtils.preCheckCast(EmptyCoroutineContext.INSTANCE, CoroutineContext.class, "com.obric.memorydata.plugin");
    L5:
        CoroutineContext r16 = r13;
        if ((r10 & 2) == 0) goto L8;
        r5 = 0;
    L8:
        int r0 = r5;
        if ((r10 & 4) == 0) goto L11;
        r6 = BufferOverflow.SUSPEND;
    L11:
        BufferOverflow r1 = r6;
        if ((r10 & 8) == 0) goto L14;
        r7 = CoroutineStart.DEFAULT;
    L14:
        CoroutineStart r2 = r7;
        if ((r10 & 16) == 0) goto L17;
        Function1 r17 = null;
    L19:
        return a(r12, r16, r0, r1, r2, r17, r15);
    L17:
        r17 = r14;
        goto L19
    }
}
