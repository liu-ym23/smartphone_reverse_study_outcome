package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0002\b\u000bJ\r\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0002\b\u000eJ\u0015\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0010R\u0014\u0010\u0003\u001a\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u0007\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00040\bj\n\u0012\u0006\u0012\u0004\u0018\u00010\u0004`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/ThreadLocalEventLoop;", "", "()V", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "getEventLoop$kotlinx_coroutines_core", "()Lkotlinx/coroutines/EventLoop;", "ref", "Ljava/lang/ThreadLocal;", "Lkotlinx/coroutines/internal/CommonThreadLocal;", "currentOrNull", "currentOrNull$kotlinx_coroutines_core", "resetEventLoop", "", "resetEventLoop$kotlinx_coroutines_core", "setEventLoop", "setEventLoop$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class cx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final cx f17302a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<bg> f17303b = null;

    static {
        f17302a = new cx();
        f17303b = kotlinx.coroutines.internal.aq.a(new kotlinx.coroutines.internal.aj("ThreadLocalEventLoop"));
    }

    private cx() {
    }

    public final bg a() {
        ThreadLocal<bg> r3 = f17303b;
        bg r0 = (bg) ZeusTransformUtils.preCheckCast(r3.get(), bg.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        bg r1 = bj.a();
        r3.set(r1);
        return r1;
    L6:
        return r0;
    }

    public final void a(bg r1) {
        f17303b.set(r1);
    }

    public final bg b() {
        return (bg) ZeusTransformUtils.preCheckCast(f17303b.get(), bg.class, "com.obric.memorydata.plugin");
    }

    public final void c() {
        f17303b.set(null);
    }
}
