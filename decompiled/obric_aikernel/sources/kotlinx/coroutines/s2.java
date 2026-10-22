package kotlinx.coroutines;

import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nEventLoop.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/ThreadLocalEventLoop\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,543:1\n1#2:544\n*E\n"})
public final class s2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s2 f10631a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<f1> f10632b = null;

    static {
        f10631a = new s2();
        f10632b = kotlinx.coroutines.internal.m0.a(new kotlinx.coroutines.internal.i0("ThreadLocalEventLoop"));
    }

    private s2() {
    }

    public final f1 a() {
        return f10632b.get();
    }

    public final f1 b() {
        ThreadLocal<f1> r10 = f10632b;
        f1 r11 = r10.get();
        if (r11 != null) goto L6;
        f1 r12 = i1.a();
        r10.set(r12);
        return r12;
    L6:
        return r11;
    }

    public final void c() {
        f10632b.set(null);
    }

    public final void d(f1 r10) {
        f10632b.set(r10);
    }
}
