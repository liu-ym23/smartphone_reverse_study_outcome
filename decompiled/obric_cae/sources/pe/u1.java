package pe;

/* JADX INFO: loaded from: classes2.dex */
public final class u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<s0> f10076a = null;

    static {
        new b9.a("ThreadLocalEventLoop", 4);
        f10076a = new ThreadLocal();
    }

    public static s0 a() {
        ThreadLocal<s0> r8 = f10076a;
        s0 r10 = r8.get();
        if (r10 != null) goto L6;
        d r11 = new d(Thread.currentThread());
        r8.set(r11);
        return r11;
    L6:
        return r10;
    }
}
