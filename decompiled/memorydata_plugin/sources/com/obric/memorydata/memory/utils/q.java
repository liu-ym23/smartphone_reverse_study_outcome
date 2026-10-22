package com.obric.memorydata.memory.utils;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.bx;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a2\u0010\u0004\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u0005*\u00020\u00012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\tH\u0086H¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"ReentrantMutex", "Lcom/obric/memorydata/memory/utils/ReentrantMutex;", "locked", "", "withLock", ExifInterface.GPS_DIRECTION_TRUE, "owner", "", "action", "Lkotlin/Function0;", "(Lcom/obric/memorydata/memory/utils/ReentrantMutex;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "memory_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class q {
    public static final o a(boolean r2) {
        return (o) ZeusTransformUtils.preCheckCast(new p(r2), o.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ o a(boolean r0, int r1, Object r2) {
        if ((r1 & 1) == 0) goto L6;
        r0 = false;
    L6:
        return a(r0);
    }

    public static final <T> Object a(o r8, Object r9, Function0<? extends T> r10, Continuation<? super T> r11) {
        o r12 = (o) ZeusTransformUtils.wrapperContextForParams(r8, o.class, "com.obric.memorydata.plugin");
        Function0 r13 = (Function0) ZeusTransformUtils.wrapperContextForParams(r10, Function0.class, "com.obric.memorydata.plugin");
        Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r14, ReentrantMutexKt$withLock$1.class) == false) goto L7;
        ReentrantMutexKt$withLock$1 r0 = (ReentrantMutexKt$withLock$1) ZeusTransformUtils.preCheckCast(r14, ReentrantMutexKt$withLock$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L14;
        Throwable r16 = (Throwable) ZeusTransformUtils.preCheckCast(r0.L$0, Throwable.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r15);
    L37:
        InlineMarker.finallyEnd(1);
        throw r16;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        Object r17 = r0.L$0;
        ResultKt.throwOnFailure(r15);
    L30:
        InlineMarker.finallyEnd(1);
        return r17;
    L17:
        Object r18 = r0.L$2;
        r13 = (Function0) ZeusTransformUtils.preCheckCast(r0.L$1, Function0.class, "com.obric.memorydata.plugin");
        o r19 = (o) ZeusTransformUtils.preCheckCast(r0.L$0, o.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r15);
        r9 = r18;
        r12 = r19;
    L39:
        Object r110 = r13.invoke();     // Catch: Throwable -> L32
        InlineMarker.finallyStart(1);
        r0.L$0 = r110;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 2;
        if (r12.b(r9, r0) != r2) goto L29;
        return r2;
    L29:
        r17 = r110;
    L32:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r0.L$0 = th;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 3;
        if (r12.b(r9, r0) != r2) goto L36;
        return r2;
    L36:
        r16 = th;
        goto L37
    L18:
        ResultKt.throwOnFailure(r15);
        if (r9 != null) goto L21;
        r9 = r0.getContext().get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(bx.f17252a, CoroutineContext.Key.class, "com.obric.memorydata.plugin"));
    L21:
        r0.L$0 = r12;
        r0.L$1 = r13;
        r0.L$2 = r9;
        r0.label = 1;
        if (r12.a(r9, r0) != r2) goto L39;
        return r2;
    L7:
        r0 = new ReentrantMutexKt$withLock$1(r14);
        goto L8
    }
}
