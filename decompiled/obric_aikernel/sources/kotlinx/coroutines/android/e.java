package kotlinx.coroutines.android;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.annotation.VisibleForTesting;
import java.lang.reflect.Constructor;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nHandlerDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HandlerDispatcher.kt\nkotlinx/coroutines/android/HandlerDispatcherKt\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 3 Runnable.kt\nkotlinx/coroutines/RunnableKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,217:1\n314#2,11:218\n314#2,9:229\n323#2,2:239\n17#3:238\n1#4:241\n*S KotlinDebug\n*F\n+ 1 HandlerDispatcher.kt\nkotlinx/coroutines/android/HandlerDispatcherKt\n*L\n189#1:218,11\n197#1:229,9\n197#1:239,2\n201#1:238\n*E\n"})
public final class e {
    private static volatile Choreographer choreographer;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Object r10 = null;
        Object[] r11 = 0;
        Object[] r12 = 0;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L5
        Object[] r14 = r12 == true ? 1 : 0;
        Object r15 = Result.m32constructorimpl(new HandlerContext(a(Looper.getMainLooper(), true), r14, 2, r11 == true ? 1 : 0));     // Catch: Throwable -> L5
    L8:
        if (Result.m38isFailureimpl(r15) == true) goto L11;
        r10 = r15;
    L11:
        d r16 = (d) r10;
        return;
    L5:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    @VisibleForTesting
    public static final Handler a(Looper r10, boolean r11) {
        if (r11 == false) goto L16;
        int r12 = Build.VERSION.SDK_INT;
        if (r12 < 16) goto L16;
        if (r12 < 28) goto L17;
        Object r13 = Handler.class.getDeclaredMethod("createAsync", new Class[]{Looper.class}).invoke(null, new Object[]{r10});
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type android.os.Handler");
    L10:
        return (Handler) r13;
    L17:
        Constructor r14 = Handler.class.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE});     // Catch: NoSuchMethodException -> L13
        r13 = r14.newInstance(new Object[]{r10, null, Boolean.TRUE});
    L14:
        return new Handler(r10);
    L16:
        return new Handler(r10);
    }
}
