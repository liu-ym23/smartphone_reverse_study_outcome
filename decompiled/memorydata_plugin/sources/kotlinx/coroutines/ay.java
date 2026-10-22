package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\f\u001a\u00020\r\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u000f2\u0006\u0010\u0010\u001a\u00020\u0001H\u0000\u001a.\u0010\u0011\u001a\u00020\r\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00132\u0006\u0010\u0014\u001a\u00020\tH\u0000\u001a\u0010\u0010\u0015\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\u000fH\u0002\u001a\u0019\u0010\u0016\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0080\b\u001a'\u0010\u0019\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u001dH\u0080\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0003\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0018\u0010\b\u001a\u00020\t*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\n\"\u0018\u0010\u000b\u001a\u00020\t*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\n¨\u0006\u001e"}, d2 = {"MODE_ATOMIC", "", "MODE_CANCELLABLE", "getMODE_CANCELLABLE$annotations", "()V", "MODE_CANCELLABLE_REUSABLE", "MODE_UNDISPATCHED", "MODE_UNINITIALIZED", "isCancellableMode", "", "(I)Z", "isReusableMode", "dispatch", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/DispatchedTask;", "mode", "resume", "delegate", "Lkotlin/coroutines/Continuation;", "undispatched", "resumeUnconfined", "resumeWithStackTrace", CommonConsts.LOG_REPORT_TYPE_EXCEPTION, "", "runUnconfinedEventLoop", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "block", "Lkotlin/Function0;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ay {
    private static final void a(ax<?> r4) {
        bg r0 = cx.f17302a.a();
        if (r0.h() == false) goto L5;
        r0.a(r4);
        return;
    L5:
        r0.a(true);
        a(r4, r4.c(), true);     // Catch: Throwable -> L10
    L7:
        if (r0.f() == true) goto L7;
    L13:
        r0.b(true);
        return;
    L10:
        th = move-exception;
        r4.a(th, null);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r0.b(true);
        throw th;
    }

    public static final <T> void a(ax<? super T> r4, int r5) {
        boolean r1 = true;
        if (an.a() == true) goto L5;
    L12:
        Continuation<? super T> r0 = r4.c();
        if (r5 == 4) goto L16;
        r1 = false;
    L16:
        if (r1 == false) goto L18;
    L25:
        a(r4, r0, r1);
        return;
    L18:
        if (ZeusTransformUtils.instanceOf(r0, kotlinx.coroutines.internal.l.class) == false) goto L25;
        if (a(r5) != a(r4.f17224a)) goto L25;
        ah r6 = ((kotlinx.coroutines.internal.l) ZeusTransformUtils.preCheckCast(r0, kotlinx.coroutines.internal.l.class, "com.obric.memorydata.plugin")).f17584b;
        CoroutineContext r2 = r0.getContext();
        if (r6.isDispatchNeeded(r2) == false) goto L24;
        r6.dispatch(r2, (Runnable) ZeusTransformUtils.preCheckCast(r4, Runnable.class, "com.obric.memorydata.plugin"));
        return;
    L24:
        a(r4);
        return;
    L5:
        if (r5 == (-1)) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L12;
        throw new AssertionError();
    L7:
        r3 = false;
        goto L8
    }

    public static final <T> void a(ax<? super T> r3, Continuation<? super T> r4, boolean r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        Object r0 = r3.g();
        Throwable r2 = r3.c(r0);
        if (r2 == null) goto L5;
        Result.Companion r7 = Result.Companion;
        Object r8 = ResultKt.createFailure(r2);
    L6:
        Object r9 = Result.m1421constructorimpl(r8);
        if (r5 == false) goto L23;
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
        kotlinx.coroutines.internal.l r10 = (kotlinx.coroutines.internal.l) ZeusTransformUtils.preCheckCast(r6, kotlinx.coroutines.internal.l.class, "com.obric.memorydata.plugin");
        Continuation<T> r11 = r10.c;
        Object r1 = r10.e;
        CoroutineContext r12 = r11.getContext();
        Object r13 = kotlinx.coroutines.internal.an.a(r12, r1);
        if (r13 == kotlinx.coroutines.internal.an.f17564a) goto L11;
        dc<?> r14 = ag.a(r11, r12, r13);
    L25:
        r10.c.resumeWith(r9);     // Catch: Throwable -> L17
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L17
        if (r14 != null) goto L15;
    L16:
        kotlinx.coroutines.internal.an.b(r12, r13);
        return;
    L15:
        if (r14.g() == true) goto L16;
        return;
    L17:
        th = move-exception;
        if (r14 != null) goto L20;
    L21:
        kotlinx.coroutines.internal.an.b(r12, r13);
    L22:
        throw th;
    L20:
        if (r14.g() == false) goto L22;
    L11:
        r14 = null;
        goto L25
    L23:
        r6.resumeWith(r9);
        return;
    L5:
        Result.Companion r16 = Result.Companion;
        r8 = r3.b(r0);
        goto L6
    }

    public static final boolean a(int r2) {
        if (r2 != 1) goto L5;
        return true;
    L5:
        if (r2 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    public static final boolean b(int r1) {
        if (r1 != 2) goto L5;
        return true;
    L5:
        return false;
    }
}
