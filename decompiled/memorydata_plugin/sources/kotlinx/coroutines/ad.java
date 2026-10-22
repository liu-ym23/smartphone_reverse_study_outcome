package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a1\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0000¢\u0006\u0002\u0010\u0007\u001aF\u0010\b\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012%\b\u0002\u0010\t\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nH\u0000¢\u0006\u0002\u0010\u0010\u001a+\u0010\b\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0000¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"recoverResult", "Lkotlin/Result;", ExifInterface.GPS_DIRECTION_TRUE, "state", "", "uCont", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toState", "onCancellation", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "cause", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "caller", "Lkotlinx/coroutines/CancellableContinuation;", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ad {
    public static final <T> Object a(Object r2, Continuation<? super T> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, ab.class) == false) goto L11;
        Result.Companion r0 = Result.Companion;
        Throwable r5 = ((ab) ZeusTransformUtils.preCheckCast(r2, ab.class, "com.obric.memorydata.plugin")).f17205a;
        if (an.c() == true) goto L7;
    L10:
        r2 = ResultKt.createFailure(r5);
    L13:
        return Result.m1421constructorimpl(r2);
    L7:
        if (ZeusTransformUtils.instanceOf(r4, CoroutineStackFrame.class) == false) goto L10;
        r5 = kotlinx.coroutines.internal.ai.a(r5, (CoroutineStackFrame) ZeusTransformUtils.preCheckCast(r4, CoroutineStackFrame.class, "com.obric.memorydata.plugin"));
        goto L10
    L11:
        Result.Companion r6 = Result.Companion;
        goto L13
    }

    public static final <T> Object a(Object r3, Function1<? super Throwable, Unit> r4) {
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Throwable r0 = Result.m1424exceptionOrNullimpl(r3);
        if (r0 != null) goto L7;
        if (r5 != null) goto L9;
        return r3;
    L9:
        return new ac(r3, r5);
    L7:
        return new ab(r0, false, 2, null);
    }

    public static /* synthetic */ Object a(Object r1, Function1 r2, int r3, Object r4) {
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L6;
        r5 = null;
    L6:
        return a(r1, r5);
    }

    public static final <T> Object a(Object r4, n<?> r5) {
        n r6 = (n) ZeusTransformUtils.wrapperContextForParams(r5, n.class, "com.obric.memorydata.plugin");
        Throwable r0 = Result.m1424exceptionOrNullimpl(r4);
        if (r0 != null) goto L6;
    L12:
        return r4;
    L6:
        if (an.c() == true) goto L8;
    L11:
        r4 = new ab(r0, false, 2, null);
        goto L12
    L8:
        if (ZeusTransformUtils.instanceOf((Continuation) ZeusTransformUtils.preCheckCast(r6, Continuation.class, "com.obric.memorydata.plugin"), CoroutineStackFrame.class) == false) goto L11;
        r0 = kotlinx.coroutines.internal.ai.a(r0, (CoroutineStackFrame) ZeusTransformUtils.preCheckCast((Continuation) ZeusTransformUtils.preCheckCast(r6, Continuation.class, "com.obric.memorydata.plugin"), CoroutineStackFrame.class, "com.obric.memorydata.plugin"));
        goto L11
    }
}
