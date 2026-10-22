package kotlinx.coroutines.sync;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.internal.aj;
import kotlinx.coroutines.internal.ak;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u001a\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0002\u001a3\u0010\u0011\u001a\u0002H\u0012\"\u0004\b\u0000\u0010\u0012*\u00020\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0014H\u0086H\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0015\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"BROKEN", "Lkotlinx/coroutines/internal/Symbol;", "CANCELLED", "MAX_SPIN_CYCLES", "", "PERMIT", "SEGMENT_SIZE", "TAKEN", "Semaphore", "Lkotlinx/coroutines/sync/Semaphore;", "permits", "acquiredPermits", "createSegment", "Lkotlinx/coroutines/sync/SemaphoreSegment;", OaidModel.KEY_ID, "", "prev", "withPermit", ExifInterface.GPS_DIRECTION_TRUE, "action", "Lkotlin/Function0;", "(Lkotlinx/coroutines/sync/Semaphore;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f17658a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final aj f17659b = null;
    private static final aj c = null;
    private static final aj d = null;
    private static final aj e = null;
    private static final int f = 0;

    static {
        f17658a = ak.a("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, null);
        f17659b = new aj("PERMIT");
        c = new aj("TAKEN");
        d = new aj("BROKEN");
        e = new aj("CANCELLED");
        f = ak.a("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, null);
    }

    public static final /* synthetic */ int a() {
        return f;
    }

    public static final <T> Object a(d r5, Function0<? extends T> r6, Continuation<? super T> r7) {
        d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.memorydata.plugin");
        Function0 r9 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, SemaphoreKt$withPermit$1.class) == false) goto L7;
        SemaphoreKt$withPermit$1 r0 = (SemaphoreKt$withPermit$1) ZeusTransformUtils.preCheckCast(r10, SemaphoreKt$withPermit$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r9 = (Function0) ZeusTransformUtils.preCheckCast(r0.L$1, Function0.class, "com.obric.memorydata.plugin");
        r8 = (d) ZeusTransformUtils.preCheckCast(r0.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r11);
    L23:
        Object r12 = r9.invoke();     // Catch: Throwable -> L20
        InlineMarker.finallyStart(1);
        r8.c();
        InlineMarker.finallyEnd(1);
        return r12;
    L20:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r8.c();
        InlineMarker.finallyEnd(1);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        r0.L$0 = r8;
        r0.L$1 = r9;
        r0.label = 1;
        if (r8.a(r0) != r2) goto L23;
        return r2;
    L7:
        r0 = new SemaphoreKt$withPermit$1(r10);
        goto L8
    }

    public static final d a(int r1, int r2) {
        return (d) ZeusTransformUtils.preCheckCast(new e(r1, r2), d.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ d a(int r0, int r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L6;
        r1 = 0;
    L6:
        return a(r0, r1);
    }

    public static final /* synthetic */ g a(long r0, g r2) {
        return b(r0, r2);
    }

    public static final /* synthetic */ aj b() {
        return f17659b;
    }

    private static final g b(long r2, g r4) {
        return new g(r2, r4, 0);
    }

    public static final /* synthetic */ aj c() {
        return c;
    }

    public static final /* synthetic */ int d() {
        return f17658a;
    }

    public static final /* synthetic */ aj e() {
        return d;
    }

    public static final /* synthetic */ aj f() {
        return e;
    }
}
