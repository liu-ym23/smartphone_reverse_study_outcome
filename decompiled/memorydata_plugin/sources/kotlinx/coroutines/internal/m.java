package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.cx;
import kotlinx.coroutines.dc;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a;\u0010\u0003\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0082\b\u001aR\u0010\u000e\u001a\u00020\r\"\u0004\b\u0000\u0010\u000f*\b\u0012\u0004\u0012\u0002H\u000f0\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00122%\b\u0002\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\r\u0018\u00010\u0014H\u0007¢\u0006\u0002\u0010\u0019\u001a\u0012\u0010\u001a\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\r0\u0005H\u0000\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"REUSABLE_CLAIMED", "Lkotlinx/coroutines/internal/Symbol;", "UNDEFINED", "executeUnconfined", "", "Lkotlinx/coroutines/internal/DispatchedContinuation;", "contState", "", "mode", "", "doYield", "block", "Lkotlin/Function0;", "", "resumeCancellableWith", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/Continuation;", "result", "Lkotlin/Result;", "onCancellation", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "cause", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "yieldUndispatched", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final aj f17585a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final aj f17586b = null;

    static {
        f17586b = new aj("UNDEFINED");
        f17585a = new aj("REUSABLE_CLAIMED");
    }

    public static final /* synthetic */ aj a() {
        return f17586b;
    }

    public static final <T> void a(Continuation<? super T> r8, Object r9, Function1<? super Throwable, Unit> r10) {
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        Function1 r12 = (Function1) ZeusTransformUtils.wrapperContextForParams(r10, Function1.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r11, l.class) == false) goto L43;
        l r13 = (l) ZeusTransformUtils.preCheckCast(r11, l.class, "com.obric.memorydata.plugin");
        Object r14 = kotlinx.coroutines.ad.a(r9, r12);
        if (r13.f17584b.isDispatchNeeded(r13.getContext()) == false) goto L7;
        r13.d = r14;
        r13.f17224a = 1;
        r13.f17584b.dispatch(r13.getContext(), (Runnable) ZeusTransformUtils.preCheckCast(r13, Runnable.class, "com.obric.memorydata.plugin"));
        return;
    L7:
        kotlinx.coroutines.an.a();
        bg r0 = cx.f17302a.a();
        if (r0.h() == false) goto L10;
        r13.d = r14;
        r13.f17224a = 1;
        r0.a((ax) ZeusTransformUtils.preCheckCast(r13, ax.class, "com.obric.memorydata.plugin"));
        return;
    L10:
        ax r3 = (ax) ZeusTransformUtils.preCheckCast(r13, ax.class, "com.obric.memorydata.plugin");
        r0.a(true);
        bx r5 = (bx) ZeusTransformUtils.preCheckCast(r13.getContext().get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(bx.f17252a, CoroutineContext.Key.class, "com.obric.memorydata.plugin")), bx.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        if (r5 != null) goto L14;
    L16:
        boolean r15 = false;
    L17:
        if (r15 == true) goto L35;
        Continuation<T> r16 = r13.c;     // Catch: Throwable -> L37
        Object r1 = r13.e;     // Catch: Throwable -> L37
        CoroutineContext r6 = r16.getContext();     // Catch: Throwable -> L37
        Object r2 = an.a(r6, r1);     // Catch: Throwable -> L37
        if (r2 == an.f17564a) goto L22;
        dc<?> r17 = kotlinx.coroutines.ag.a(r16, r6, r2);     // Catch: Throwable -> L37
    L45:
        r13.c.resumeWith(r9);     // Catch: Throwable -> L28
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L28
        if (r17 != null) goto L26;
    L27:
        an.b(r6, r2);     // Catch: Throwable -> L37
        goto L35
    L26:
        if (r17.g() == false) goto L35;
    L28:
        th = move-exception;
        if (r17 != null) goto L31;
    L32:
        an.b(r6, r2);     // Catch: Throwable -> L37
    L33:
        throw th;     // Catch: Throwable -> L37
    L31:
        if (r17.g() == false) goto L33;
    L22:
        r17 = null;
    L35:
        if (r0.f() == true) goto L35;
    L39:
        r0.b(true);
        return;
    L14:
        if (r5.a() == true) goto L16;
        CancellationException r7 = r5.t_();     // Catch: Throwable -> L37
        r13.a(r14, (Throwable) ZeusTransformUtils.preCheckCast(r7, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L37
        Continuation r19 = (Continuation) ZeusTransformUtils.preCheckCast(r13, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L37
        r19.resumeWith(Result.m1421constructorimpl(ResultKt.createFailure((Throwable) ZeusTransformUtils.preCheckCast(r7, Throwable.class, "com.obric.memorydata.plugin"))));     // Catch: Throwable -> L37
        r15 = true;
    L37:
        th = move-exception;
        r3.a(th, null);     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        r0.b(true);
        throw th;
    L43:
        r11.resumeWith(r9);
    }

    public static /* synthetic */ void a(Continuation r1, Object r2, Function1 r3, int r4, Object r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r1, Continuation.class, "com.obric.memorydata.plugin");
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        a(r6, r2, r7);
    }

    public static final boolean a(l<? super Unit> r6) {
        Unit r0 = Unit.INSTANCE;
        kotlinx.coroutines.an.a();
        bg r1 = cx.f17302a.a();
        if (r1.i() == false) goto L6;
        return false;
    L6:
        if (r1.h() == false) goto L8;
        r6.d = r0;
        r6.f17224a = 1;
        r1.a((ax) ZeusTransformUtils.preCheckCast(r6, ax.class, "com.obric.memorydata.plugin"));
        return true;
    L8:
        ax r2 = (ax) ZeusTransformUtils.preCheckCast(r6, ax.class, "com.obric.memorydata.plugin");
        r1.a(true);
        r6.run();     // Catch: Throwable -> L13
    L10:
        if (r1.f() == true) goto L10;
    L16:
        r1.b(true);
        return false;
    L13:
        th = move-exception;
        r2.a(th, null);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        r1.b(true);
        throw th;
    }
}
