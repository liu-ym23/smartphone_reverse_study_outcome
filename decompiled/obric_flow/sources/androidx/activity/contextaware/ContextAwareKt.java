package androidx.activity.contextaware;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.l;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a@\u0010\u0000\u001a\u0007H\u0001¢\u0006\u0002\b\u0002\"\u0004\b\u0000\u0010\u0001*\u00020\u00032\u001e\b\u0004\u0010\u0004\u001a\u0018\u0012\t\u0012\u00070\u0006¢\u0006\u0002\b\u0002\u0012\t\u0012\u0007H\u0001¢\u0006\u0002\b\u00020\u0005H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"withContextAvailable", "R", "Lkotlin/jvm/JvmSuppressWildcards;", "Landroidx/activity/contextaware/ContextAware;", "onContextAvailable", "Lkotlin/Function1;", "Landroid/content/Context;", "(Landroidx/activity/contextaware/ContextAware;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "activity_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nContextAware.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContextAware.kt\nandroidx/activity/contextaware/ContextAwareKt\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,94:1\n314#2,11:95\n*S KotlinDebug\n*F\n+ 1 ContextAware.kt\nandroidx/activity/contextaware/ContextAwareKt\n*L\n81#1:95,11\n*E\n"})
public final class ContextAwareKt {
    public static final <R> Object withContextAvailable(ContextAware r5, Function1<Context, R> r10, Continuation<R> r11) {
        Context r12 = r5.peekAvailableContext();
        if (r12 != null) goto L5;
        l r13 = new l(1, IntrinsicsKt.intercepted(r11));
        r13.w();
        ContextAwareKt$withContextAvailable$2$listener$1 r14 = new ContextAwareKt$withContextAvailable$2$listener$1(r13, r10);
        r5.addOnContextAvailableListener(r14);
        r13.y(new ContextAwareKt$withContextAvailable$2$1(r5, r14));
        Object r15 = r13.v();
        if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        DebugProbesKt.probeCoroutineSuspended(r11);
    L9:
        return r15;
    L5:
        return r10.invoke(r12);
    }

    private static final <R> Object withContextAvailable$$forInline(ContextAware r5, Function1<Context, R> r10, Continuation<R> r11) {
        Context r12 = r5.peekAvailableContext();
        if (r12 != null) goto L5;
        InlineMarker.mark(0);
        l r13 = new l(1, IntrinsicsKt.intercepted(r11));
        r13.w();
        ContextAwareKt$withContextAvailable$2$listener$1 r14 = new ContextAwareKt$withContextAvailable$2$listener$1(r13, r10);
        r5.addOnContextAvailableListener(r14);
        r13.y(new ContextAwareKt$withContextAvailable$2$1(r5, r14));
        Unit r15 = Unit.INSTANCE;
        Object r16 = r13.v();
        if (r16 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        DebugProbesKt.probeCoroutineSuspended(r11);
    L9:
        InlineMarker.mark(1);
        return r16;
    L5:
        return r10.invoke(r12);
    }
}
