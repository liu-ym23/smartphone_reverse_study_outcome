package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.constants.Constants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001aR\u0010\u0004\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\t¢\u0006\u0002\b\rH\u0086@\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\u000e\u001aX\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0010\"\u0004\b\u0000\u0010\u0005*\u00020\n2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00122'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\t¢\u0006\u0002\b\r¢\u0006\u0002\u0010\u0013\u001aC\u0010\u0014\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u0005*\u00020\u00152)\b\b\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\t¢\u0006\u0002\b\rH\u0086J¢\u0006\u0002\u0010\u0016\u001aL\u0010\u0017\u001a\u00020\u0018*\u00020\n2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00122'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\t¢\u0006\u0002\b\r¢\u0006\u0002\u0010\u001a\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"RESUMED", "", "SUSPENDED", "UNDECIDED", "withContext", ExifInterface.GPS_DIRECTION_TRUE, "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "async", "Lkotlinx/coroutines/Deferred;", CommonConsts.APM_INNER_EVENT_COST_START, "Lkotlinx/coroutines/CoroutineStart;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Deferred;", "invoke", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", Constants.LAUNCH_TAG, "Lkotlinx/coroutines/Job;", "", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 9, 0}, xi = 48, xs = "kotlinx/coroutines/BuildersKt")
final /* synthetic */ class k {
    public static final <T> Object a(CoroutineContext r8, Function2<? super al, ? super Continuation<? super T>, ? extends Object> r9, Continuation<? super T> r10) {
        CoroutineContext r11 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r8, CoroutineContext.class, "com.obric.memorydata.plugin");
        Function2 r2 = (Function2) ZeusTransformUtils.wrapperContextForParams(r9, Function2.class, "com.obric.memorydata.plugin");
        Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        CoroutineContext r13 = r12.getContext();
        CoroutineContext r14 = ag.a(r13, r11);
        ca.a(r14);
        if (r14 != r13) goto L6;
        kotlinx.coroutines.internal.af r15 = new kotlinx.coroutines.internal.af(r14, r12);
        Object r16 = kotlinx.coroutines.a.b.a(r15, r15, r2);
    L15:
        if (r16 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        DebugProbesKt.probeCoroutineSuspended(r12);
    L17:
        return r16;
    L6:
        if (Intrinsics.areEqual(r14.get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(ContinuationInterceptor.Key, CoroutineContext.Key.class, "com.obric.memorydata.plugin")), r13.get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(ContinuationInterceptor.Key, CoroutineContext.Key.class, "com.obric.memorydata.plugin"))) == false) goto L13;
        dc r17 = new dc(r14, r12);
        CoroutineContext r18 = r17.getContext();
        Object r0 = kotlinx.coroutines.internal.an.a(r18, null);
        Object r19 = kotlinx.coroutines.a.b.a((kotlinx.coroutines.internal.af) ZeusTransformUtils.preCheckCast(r17, kotlinx.coroutines.internal.af.class, "com.obric.memorydata.plugin"), r17, r2);     // Catch: Throwable -> L10
        kotlinx.coroutines.internal.an.b(r18, r0);
        r16 = r19;
    L10:
        th = move-exception;
        kotlinx.coroutines.internal.an.b(r18, r0);
        throw th;
    L13:
        aw r110 = new aw(r14, r12);
        kotlinx.coroutines.a.a.a(r2, r110, (Continuation) ZeusTransformUtils.preCheckCast(r110, Continuation.class, "com.obric.memorydata.plugin"), null, 4, null);
        r16 = r110.f();
        goto L15
    }

    public static final bx a(al r2, CoroutineContext r3, CoroutineStart r4, Function2<? super al, ? super Continuation<? super Unit>, ? extends Object> r5) {
        al r6 = (al) ZeusTransformUtils.wrapperContextForParams(r2, al.class, "com.obric.memorydata.plugin");
        CoroutineContext r7 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin");
        Function2 r8 = (Function2) ZeusTransformUtils.wrapperContextForParams(r5, Function2.class, "com.obric.memorydata.plugin");
        CoroutineContext r9 = ag.a(r6, r7);
        if (r4.isLazy() == false) goto L5;
        cr r10 = (cr) ZeusTransformUtils.preCheckCast(new ch(r9, r8), cr.class, "com.obric.memorydata.plugin");
    L6:
        r10.a(r4, r10, r8);
        return (bx) ZeusTransformUtils.preCheckCast(r10, bx.class, "com.obric.memorydata.plugin");
    L5:
        r10 = new cr(r9, true);
        goto L6
    }

    public static /* synthetic */ bx a(al r1, CoroutineContext r2, CoroutineStart r3, Function2 r4, int r5, Object r6) {
        al r7 = (al) ZeusTransformUtils.wrapperContextForParams(r1, al.class, "com.obric.memorydata.plugin");
        CoroutineContext r8 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r2, CoroutineContext.class, "com.obric.memorydata.plugin");
        Function2 r9 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r8 = (CoroutineContext) ZeusTransformUtils.preCheckCast(EmptyCoroutineContext.INSTANCE, CoroutineContext.class, "com.obric.memorydata.plugin");
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = CoroutineStart.DEFAULT;
    L9:
        return i.a(r7, r8, r3, r9);
    }

    public static final <T> ar<T> b(al r2, CoroutineContext r3, CoroutineStart r4, Function2<? super al, ? super Continuation<? super T>, ? extends Object> r5) {
        al r6 = (al) ZeusTransformUtils.wrapperContextForParams(r2, al.class, "com.obric.memorydata.plugin");
        CoroutineContext r7 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin");
        Function2 r8 = (Function2) ZeusTransformUtils.wrapperContextForParams(r5, Function2.class, "com.obric.memorydata.plugin");
        CoroutineContext r9 = ag.a(r6, r7);
        if (r4.isLazy() == false) goto L5;
        as r10 = (as) ZeusTransformUtils.preCheckCast(new cg(r9, r8), as.class, "com.obric.memorydata.plugin");
    L6:
        r10.a(r4, r10, r8);
        return (ar) ZeusTransformUtils.preCheckCast(r10, ar.class, "com.obric.memorydata.plugin");
    L5:
        r10 = new as(r9, true);
        goto L6
    }

    public static /* synthetic */ ar b(al r1, CoroutineContext r2, CoroutineStart r3, Function2 r4, int r5, Object r6) {
        al r7 = (al) ZeusTransformUtils.wrapperContextForParams(r1, al.class, "com.obric.memorydata.plugin");
        CoroutineContext r8 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r2, CoroutineContext.class, "com.obric.memorydata.plugin");
        Function2 r9 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r8 = (CoroutineContext) ZeusTransformUtils.preCheckCast(EmptyCoroutineContext.INSTANCE, CoroutineContext.class, "com.obric.memorydata.plugin");
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = CoroutineStart.DEFAULT;
    L9:
        return i.b(r7, r8, r3, r9);
    }
}
