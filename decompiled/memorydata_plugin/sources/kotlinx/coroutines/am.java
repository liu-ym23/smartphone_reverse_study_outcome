package kotlinx.coroutines;

import android.security.obric.guard.ObricSecurityGuardStub;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b\u001a\u0006\u0010\t\u001a\u00020\u0002\u001aJ\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b2'\u0010\f\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r¢\u0006\u0002\b\u0010H\u0086@\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0011\u001a\u000e\u0010\u0012\u001a\u00020\bH\u0086H¢\u0006\u0002\u0010\u0013\u001a\u001e\u0010\u0014\u001a\u00020\u0015*\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u001a\u001c\u0010\u0014\u001a\u00020\u0015*\u00020\u00022\u0010\b\u0002\u0010\u0018\u001a\n\u0018\u00010\u001aj\u0004\u0018\u0001`\u001b\u001a\n\u0010\u001c\u001a\u00020\u0015*\u00020\u0002\u001a\u0015\u0010\u001d\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0086\u0002\"\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0000\u0010\u0005¨\u0006\u001e"}, d2 = {"isActive", "", "Lkotlinx/coroutines/CoroutineScope;", "isActive$annotations", "(Lkotlinx/coroutines/CoroutineScope;)V", "(Lkotlinx/coroutines/CoroutineScope;)Z", "CoroutineScope", "context", "Lkotlin/coroutines/CoroutineContext;", "MainScope", "coroutineScope", "R", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "currentCoroutineContext", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "", "message", "", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "ensureActive", "plus", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class am {
    public static final <R> Object a(Function2<? super al, ? super Continuation<? super R>, ? extends Object> r2, Continuation<? super R> r3) {
        Function2 r4 = (Function2) ZeusTransformUtils.wrapperContextForParams(r2, Function2.class, "com.obric.memorydata.plugin");
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.internal.af r0 = new kotlinx.coroutines.internal.af(r5.getContext(), r5);
        Object r6 = kotlinx.coroutines.a.b.a(r0, r0, r4);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L5:
        return r6;
    }

    public static final al a() {
        return (al) ZeusTransformUtils.preCheckCast(new kotlinx.coroutines.internal.h(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.b(), CoroutineContext.class, "com.obric.memorydata.plugin"))), al.class, "com.obric.memorydata.plugin");
    }

    public static final al a(CoroutineContext r4) {
        CoroutineContext r5 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r4, CoroutineContext.class, "com.obric.memorydata.plugin");
        if (r5.get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(bx.f17252a, CoroutineContext.Key.class, "com.obric.memorydata.plugin")) != null) goto L7;
        r5 = r5.plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ca.a(null, 1, null), CoroutineContext.class, "com.obric.memorydata.plugin"));
    L7:
        return (al) ZeusTransformUtils.preCheckCast(new kotlinx.coroutines.internal.h(r5), al.class, "com.obric.memorydata.plugin");
    }

    public static final void a(al r4, CancellationException r5) {
        al r6 = (al) ZeusTransformUtils.wrapperContextForParams(r4, al.class, "com.obric.memorydata.plugin");
        bx r0 = (bx) ZeusTransformUtils.preCheckCast(r6.getCoroutineContext().get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(bx.f17252a, CoroutineContext.Key.class, "com.obric.memorydata.plugin")), bx.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L7;
        r0.a(r5);
        return;
    L7:
        throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + r6).toString());
    }

    public static /* synthetic */ void a(al r1, CancellationException r2, int r3, Object r4) {
        al r5 = (al) ZeusTransformUtils.wrapperContextForParams(r1, al.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L5;
        r2 = null;
    L5:
        a(r5, r2);
    }

    public static final boolean a(al r3) {
        bx r4 = (bx) ZeusTransformUtils.preCheckCast(((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin")).getCoroutineContext().get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(bx.f17252a, CoroutineContext.Key.class, "com.obric.memorydata.plugin")), bx.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L7;
        return true;
    L7:
        return r4.a();
    }

    public static final void b(al r2) {
        ca.a(((al) ZeusTransformUtils.wrapperContextForParams(r2, al.class, "com.obric.memorydata.plugin")).getCoroutineContext());
    }
}
