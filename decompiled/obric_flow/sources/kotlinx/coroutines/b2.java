package kotlinx.coroutines;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f18773a = null;

    static {
        f18773a = new ThreadLocal();
    }

    public static b1 a() {
        ThreadLocal r5 = f18773a;
        b1 r10 = (b1) r5.get();
        if (r10 != null) goto L6;
        g r11 = new g(Thread.currentThread());
        r5.set(r11);
        return r11;
    L6:
        return r10;
    }
}
