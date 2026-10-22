package kotlinx.coroutines.a;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.ab;
import kotlinx.coroutines.an;
import kotlinx.coroutines.cf;
import kotlinx.coroutines.internal.af;
import kotlinx.coroutines.internal.ai;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a9\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u001a\u0010\u0005\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0082\b\u001aO\u0010\b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\u0002*\u001e\b\u0001\u0012\u0004\u0012\u0002H\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\n2\u0006\u0010\u000b\u001a\u0002H\t2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0000¢\u0006\u0002\u0010\f\u001a;\u0010\r\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0000¢\u0006\u0002\u0010\u000e\u001aV\u0010\u000f\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\t*\b\u0012\u0004\u0012\u0002H\u00020\u00102\u0006\u0010\u000b\u001a\u0002H\t2'\u0010\u0005\u001a#\b\u0001\u0012\u0004\u0012\u0002H\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\n¢\u0006\u0002\b\u0011H\u0000¢\u0006\u0002\u0010\u0012\u001aV\u0010\u0013\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\t*\b\u0012\u0004\u0012\u0002H\u00020\u00102\u0006\u0010\u000b\u001a\u0002H\t2'\u0010\u0005\u001a#\b\u0001\u0012\u0004\u0012\u0002H\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\n¢\u0006\u0002\b\u0011H\u0000¢\u0006\u0002\u0010\u0012\u001a?\u0010\u0014\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00102\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00062\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0019H\u0082\b¨\u0006\u001a"}, d2 = {"startDirect", "", ExifInterface.GPS_DIRECTION_TRUE, "completion", "Lkotlin/coroutines/Continuation;", "block", "Lkotlin/Function1;", "", "startCoroutineUndispatched", "R", "Lkotlin/Function2;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "startCoroutineUnintercepted", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "startUndispatchedOrReturn", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/internal/ScopeCoroutine;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "startUndispatchedOrReturnIgnoreTimeout", "undispatchedResult", "shouldThrow", "", "", "startBlock", "Lkotlin/Function0;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class b {
    public static final <T, R> Object a(af<? super T> r4, R r5, Function2<? super R, ? super Continuation<? super T>, ? extends Object> r6) {
        Function2 r7 = (Function2) ZeusTransformUtils.wrapperContextForParams(r6, Function2.class, "com.obric.memorydata.plugin");
    L8:
        th = move-exception;
        Object r8 = new ab(th, false, 2, null);
    L11:
        if (r8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L32;
        Object r9 = r4.g(r8);
        if (r9 == cf.f17268a) goto L32;
        if (ZeusTransformUtils.instanceOf(r9, ab.class) == false) goto L26;
        Throwable r10 = ((ab) ZeusTransformUtils.preCheckCast(r9, ab.class, "com.obric.memorydata.plugin")).f17205a;
        Throwable r11 = ((ab) ZeusTransformUtils.preCheckCast(r9, ab.class, "com.obric.memorydata.plugin")).f17205a;
        Continuation<? super T> r12 = r4.c;
        if (an.c() == true) goto L21;
        throw r11;
    L21:
        if (ZeusTransformUtils.instanceOf(r12, CoroutineStackFrame.class) == true) goto L24;
        throw r11;
    L24:
        throw ai.a(r11, (CoroutineStackFrame) ZeusTransformUtils.preCheckCast(r12, CoroutineStackFrame.class, "com.obric.memorydata.plugin"));
    L26:
        return cf.b(r9);
    L32:
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    L4:
        if (ZeusTransformUtils.instanceOf(r7, BaseContinuationImpl.class) == true) goto L6;
        r8 = IntrinsicsKt.wrapWithContinuationImpl(r7, r5, (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L8
    L27:
        goto L11
    L6:
        r8 = ((Function2) ZeusTransformUtils.preCheckCast(TypeIntrinsics.beforeCheckcastToFunctionOfArity(r7, 2), Function2.class, "com.obric.memorydata.plugin")).invoke(r5, (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L8
        goto L27
    }

    public static final <R, T> void a(Function2<? super R, ? super Continuation<? super T>, ? extends Object> r4, R r5, Continuation<? super T> r6) {
        Function2 r7 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        Continuation r0 = DebugProbesKt.probeCoroutineCreated(r8);
        CoroutineContext r9 = r8.getContext();     // Catch: Throwable -> L15
        Object r2 = kotlinx.coroutines.internal.an.a(r9, null);     // Catch: Throwable -> L15
    L12:
        th = move-exception;
        kotlinx.coroutines.internal.an.b(r9, r2);     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L5:
        if (ZeusTransformUtils.instanceOf(r7, BaseContinuationImpl.class) == true) goto L7;
        Object r10 = IntrinsicsKt.wrapWithContinuationImpl(r7, r5, r0);     // Catch: Throwable -> L12
    L8:
        kotlinx.coroutines.internal.an.b(r9, r2);     // Catch: Throwable -> L15
        if (r10 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L21;
        Result.Companion r11 = Result.Companion;
    L17:
        r0.resumeWith(Result.m1421constructorimpl(r10));
        return;
    L21:
        return;
    L7:
        r10 = ((Function2) ZeusTransformUtils.preCheckCast(TypeIntrinsics.beforeCheckcastToFunctionOfArity(r7, 2), Function2.class, "com.obric.memorydata.plugin")).invoke(r5, r0);     // Catch: Throwable -> L12
    L15:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r10 = ResultKt.createFailure(th);
        goto L17
    }

    public static final <T, R> Object b(af<? super T> r4, R r5, Function2<? super R, ? super Continuation<? super T>, ? extends Object> r6) {
        Function2 r7 = (Function2) ZeusTransformUtils.wrapperContextForParams(r6, Function2.class, "com.obric.memorydata.plugin");
        boolean r2 = false;
    L8:
        th = move-exception;
        Object r8 = new ab(th, false, 2, null);
    L11:
        if (r8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L50;
        Object r9 = r4.g(r8);
        if (r9 == cf.f17268a) goto L50;
        if (ZeusTransformUtils.instanceOf(r9, ab.class) == false) goto L40;
        Throwable r0 = ((ab) ZeusTransformUtils.preCheckCast(r9, ab.class, "com.obric.memorydata.plugin")).f17205a;
        if (ZeusTransformUtils.instanceOf(r0, TimeoutCancellationException.class) == true) goto L21;
    L22:
        r2 = true;
    L23:
        if (r2 == false) goto L32;
        Throwable r10 = ((ab) ZeusTransformUtils.preCheckCast(r9, ab.class, "com.obric.memorydata.plugin")).f17205a;
        Continuation<? super T> r11 = r4.c;
        if (an.c() == true) goto L27;
        throw r10;
    L27:
        if (ZeusTransformUtils.instanceOf(r11, CoroutineStackFrame.class) == true) goto L30;
        throw r10;
    L30:
        throw ai.a(r10, (CoroutineStackFrame) ZeusTransformUtils.preCheckCast(r11, CoroutineStackFrame.class, "com.obric.memorydata.plugin"));
    L32:
        if (ZeusTransformUtils.instanceOf(r8, ab.class) == false) goto L42;
        Throwable r12 = ((ab) ZeusTransformUtils.preCheckCast(r8, ab.class, "com.obric.memorydata.plugin")).f17205a;
        Continuation<? super T> r13 = r4.c;
        if (an.c() == true) goto L36;
        throw r12;
    L36:
        if (ZeusTransformUtils.instanceOf(r13, CoroutineStackFrame.class) == true) goto L39;
        throw r12;
    L39:
        throw ai.a(r12, (CoroutineStackFrame) ZeusTransformUtils.preCheckCast(r13, CoroutineStackFrame.class, "com.obric.memorydata.plugin"));
    L42:
        return r8;
    L21:
        if (((TimeoutCancellationException) ZeusTransformUtils.preCheckCast(r0, TimeoutCancellationException.class, "com.obric.memorydata.plugin")).coroutine == r4) goto L23;
    L40:
        r8 = cf.b(r9);
    L50:
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    L4:
        if (ZeusTransformUtils.instanceOf(r7, BaseContinuationImpl.class) == true) goto L6;
        r8 = IntrinsicsKt.wrapWithContinuationImpl(r7, r5, (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L8
    L43:
        goto L11
    L6:
        r8 = ((Function2) ZeusTransformUtils.preCheckCast(TypeIntrinsics.beforeCheckcastToFunctionOfArity(r7, 2), Function2.class, "com.obric.memorydata.plugin")).invoke(r5, (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L8
        goto L43
    }
}
