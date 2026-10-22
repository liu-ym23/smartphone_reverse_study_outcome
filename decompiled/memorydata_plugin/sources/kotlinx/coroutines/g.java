package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\u000b\u0010\u0011\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\f¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/BlockingCoroutine;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/AbstractCoroutine;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "blockedThread", "Ljava/lang/Thread;", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Thread;Lkotlinx/coroutines/EventLoop;)V", "isScopedCoroutine", "", "()Z", "afterCompletion", "", "state", "", "joinBlocking", "()Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class g<T> extends a<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Thread f17551b;
    private final bg c;

    public g(CoroutineContext r3, Thread r4, bg r5) {
        super((CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin"), true, true);
        this.f17551b = r4;
        this.c = r5;
    }

    @Override // kotlinx.coroutines.ce
    public void d(Object r2) {
        if (Intrinsics.areEqual(Thread.currentThread(), this.f17551b) == true) goto L11;
        Thread r1 = this.f17551b;
        b r3 = c.a();
        if (r3 == null) goto L7;
        r3.a(r1);
        Unit r4 = Unit.INSTANCE;
    L8:
        if (r4 != null) goto L12;
        LockSupport.unpark(r1);
        return;
    L12:
        return;
    L7:
        r4 = null;
        goto L8
    }

    @Override // kotlinx.coroutines.ce
    public boolean d() {
        return true;
    }

    public final T e() {
        b r0 = c.a();
        if (r0 == null) goto L49;
        r0.d();
    L49:
        bg r1 = this.c;     // Catch: Throwable -> L44
        ab r3 = null;
        if (r1 == null) goto L50;
        bg.a(r1, false, 1, null);     // Catch: Throwable -> L44
    L50:
    L39:
        th = move-exception;
        bg r7 = this.c;     // Catch: Throwable -> L44
        if (r7 == null) goto L43;
        bg.b(r7, false, 1, null);     // Catch: Throwable -> L44
    L43:
        throw th;     // Catch: Throwable -> L44
    L10:
        if (Thread.interrupted() == true) goto L37;
        bg r2 = this.c;     // Catch: Throwable -> L39
        if (r2 == null) goto L14;
        long r5 = r2.c();     // Catch: Throwable -> L39
    L16:
        if (q_() == true) goto L24;
        b r4 = c.a();     // Catch: Throwable -> L39
        if (r4 == null) goto L20;
        r4.a(this, r5);     // Catch: Throwable -> L39
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L39
    L21:
        if (r6 != null) goto L50;
        LockSupport.parkNanos(this, r5);     // Catch: Throwable -> L39
        goto L50
    L20:
        r6 = null;
        goto L21
    L24:
        bg r8 = this.c;     // Catch: Throwable -> L44
        if (r8 == null) goto L27;
        bg.b(r8, false, 1, null);     // Catch: Throwable -> L44
    L27:
        b r9 = c.a();
        if (r9 == null) goto L30;
        r9.e();
    L30:
        T r10 = (T) cf.b(o());
        if (ZeusTransformUtils.instanceOf(r10, ab.class) == false) goto L33;
        r3 = (ab) ZeusTransformUtils.preCheckCast(r10, ab.class, "com.obric.memorydata.plugin");
    L33:
        if (r3 != null) goto L36;
        return r10;
    L36:
        throw r3.f17205a;
    L14:
        r5 = Long.MAX_VALUE;
        goto L16
    L37:
        InterruptedException r11 = new InterruptedException();     // Catch: Throwable -> L39
        d((Throwable) ZeusTransformUtils.preCheckCast(r11, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L39
        throw ((Throwable) ZeusTransformUtils.preCheckCast(r11, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L39
    L44:
        th = move-exception;
        b r12 = c.a();
        if (r12 == null) goto L48;
        r12.e();
    L48:
        throw th;
    }
}
