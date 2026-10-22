package kotlinx.coroutines.sync;

import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.internal.i0;
import kotlinx.coroutines.internal.j0;

/* JADX INFO: loaded from: classes3.dex */
public final class SemaphoreKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f10711a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final i0 f10712b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final i0 f10713c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final i0 f10714d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final i0 f10715e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f10716f = 0;

    static {
        f10711a = j0.g("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, null);
        f10712b = new i0("PERMIT");
        f10713c = new i0("TAKEN");
        f10714d = new i0("BROKEN");
        f10715e = new i0("CANCELLED");
        f10716f = j0.g("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, null);
    }

    public static final /* synthetic */ c a(long r10, c r11) {
        return h(r10, r11);
    }

    public static final /* synthetic */ i0 b() {
        return f10714d;
    }

    public static final /* synthetic */ i0 c() {
        return f10715e;
    }

    public static final /* synthetic */ int d() {
        return f10711a;
    }

    public static final /* synthetic */ i0 e() {
        return f10712b;
    }

    public static final /* synthetic */ int f() {
        return f10716f;
    }

    public static final /* synthetic */ i0 g() {
        return f10713c;
    }

    private static final c h(long r10, c r11) {
        return new c(r10, r11, 0);
    }

    public static final <T> Object i(b r10, Function0<? extends T> r11, Continuation<? super T> r12) {
        if ((r12 instanceof SemaphoreKt$withPermit$1) == false) goto L7;
        SemaphoreKt$withPermit$1 r13 = (SemaphoreKt$withPermit$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r13.label;
        if (r17 == 0) goto L14;
        if (r17 != 1) goto L13;
        r11 = (Function0) r13.L$1;
        r10 = (b) r13.L$0;
        ResultKt.throwOnFailure(r15);
    L23:
        T r18 = r11.invoke();     // Catch: Throwable -> L20
        InlineMarker.finallyStart(1);
        r10.release();
        InlineMarker.finallyEnd(1);
        return r18;
    L20:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r10.release();
        InlineMarker.finallyEnd(1);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        r13.L$0 = r10;
        r13.L$1 = r11;
        r13.label = 1;
        if (r10.a(r13) != r16) goto L23;
        return r16;
    L7:
        r13 = new SemaphoreKt$withPermit$1(r12);
        goto L8
    }
}
