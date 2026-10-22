package androidx.activity.contextaware;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a1\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00010\u0004H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"withContextAvailable", "R", "Landroidx/activity/contextaware/ContextAware;", "onContextAvailable", "Lkotlin/Function1;", "Landroid/content/Context;", "(Landroidx/activity/contextaware/ContextAware;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "activity-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ContextAwareKt {
    public static final <R> Object withContextAvailable(ContextAware r4, Function1<? super Context, ? extends R> r5, Continuation<? super R> r6) {
        ContextAware r7 = (ContextAware) ZeusTransformUtils.wrapperContextForParams(r4, ContextAware.class, "com.obric.memorydata.plugin");
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.peekAvailableContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        o r1 = new o(IntrinsicsKt.intercepted(r9), 1);
        r1.e();
        n r2 = (n) ZeusTransformUtils.preCheckCast(r1, n.class, "com.obric.memorydata.plugin");
        ContextAwareKt$withContextAvailable$2$listener$1 r3 = new ContextAwareKt$withContextAvailable$2$listener$1(r2, r8);
        r7.addOnContextAvailableListener((OnContextAvailableListener) ZeusTransformUtils.preCheckCast(r3, OnContextAvailableListener.class, "com.obric.memorydata.plugin"));
        r2.a((Function1) ZeusTransformUtils.preCheckCast(new ContextAwareKt$withContextAvailable$2$1(r7, r3), Function1.class, "com.obric.memorydata.plugin"));
        Object r10 = r1.h();
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        DebugProbesKt.probeCoroutineSuspended(r9);
    L9:
        return r10;
    L5:
        return r8.invoke(r0);
    }

    private static final <R> Object withContextAvailable$$forInline(ContextAware r5, Function1<? super Context, ? extends R> r6, Continuation<? super R> r7) {
        ContextAware r8 = (ContextAware) ZeusTransformUtils.wrapperContextForParams(r5, ContextAware.class, "com.obric.memorydata.plugin");
        Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.peekAvailableContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        InlineMarker.mark(0);
        o r1 = new o(IntrinsicsKt.intercepted(r10), 1);
        r1.e();
        n r2 = (n) ZeusTransformUtils.preCheckCast(r1, n.class, "com.obric.memorydata.plugin");
        ContextAwareKt$withContextAvailable$2$listener$1 r4 = new ContextAwareKt$withContextAvailable$2$listener$1(r2, r9);
        r8.addOnContextAvailableListener((OnContextAvailableListener) ZeusTransformUtils.preCheckCast(r4, OnContextAvailableListener.class, "com.obric.memorydata.plugin"));
        r2.a((Function1) ZeusTransformUtils.preCheckCast(new ContextAwareKt$withContextAvailable$2$1(r8, r4), Function1.class, "com.obric.memorydata.plugin"));
        Object r11 = r1.h();
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        DebugProbesKt.probeCoroutineSuspended(r10);
    L9:
        InlineMarker.mark(1);
        return r11;
    L5:
        return r9.invoke(r0);
    }
}
