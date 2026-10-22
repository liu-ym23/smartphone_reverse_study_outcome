package kotlinx.coroutines.a;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.internal.m;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001c\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a#\u0010\u0006\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0082\b\u001a\u001e\u0010\t\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00032\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0000\u001a;\u0010\t\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u000b*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u0003\u0012\u0006\u0012\u0004\u0018\u00010\r0\f2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0003H\u0007¢\u0006\u0002\u0010\u000e\u001av\u0010\t\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\u000b*\u001e\b\u0001\u0012\u0004\u0012\u0002H\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u0003\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00102\u0006\u0010\u0011\u001a\u0002H\u000f2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u00032%\b\u0002\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fH\u0000¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"dispatcherFailure", "", "completion", "Lkotlin/coroutines/Continuation;", "e", "", "runSafely", "block", "Lkotlin/Function0;", "startCoroutineCancellable", "fatalCompletion", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "receiver", "onCancellation", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "cause", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;Lkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class a {
    private static final void a(Continuation<?> r2, Throwable r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin");
        Result.Companion r0 = Result.Companion;
        r4.resumeWith(Result.m1421constructorimpl(ResultKt.createFailure(r3)));
        throw r3;
    }

    public static final void a(Continuation<? super Unit> r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        Continuation r7 = IntrinsicsKt.intercepted(r5);     // Catch: Throwable -> L5
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        m.a(r7, Result.m1421constructorimpl(Unit.INSTANCE), null, 2, null);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        a(r6, th);
    }

    public static final <R, T> void a(Function2<? super R, ? super Continuation<? super T>, ? extends Object> r2, R r3, Continuation<? super T> r4, Function1<? super Throwable, Unit> r5) {
        Function2 r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r2, Function2.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Continuation r9 = IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(r6, r3, r7));     // Catch: Throwable -> L5
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L5
        m.a(r9, Result.m1421constructorimpl(Unit.INSTANCE), r8);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        a(r7, th);
    }

    public static /* synthetic */ void a(Function2 r1, Object r2, Continuation r3, Function1 r4, int r5, Object r6) {
        Function2 r7 = (Function2) ZeusTransformUtils.wrapperContextForParams(r1, Function2.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        if ((r5 & 4) == 0) goto L5;
        r9 = null;
    L5:
        a(r7, r2, r8, r9);
    }
}
