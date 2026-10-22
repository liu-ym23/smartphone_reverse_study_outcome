package d0;

import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArrayDeque f16563b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f16564a;

    static {
        char[] r5 = q0.i.f21459a;
        f16563b = new ArrayDeque(0);
    }

    public static p a(Object r5) {
        ArrayDeque r10 = f16563b;
        monitor-enter(r10);
        p r11 = (p) r10.poll();     // Catch: Throwable -> L10
        monitor-exit(r10);     // Catch: Throwable -> L10
        if (r11 != null) goto L8;
        r11 = new p();
    L8:
        r11.f16564a = r5;
        return r11;
    L10:
        th = move-exception;
        throw th;
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof p) == false) goto L6;
        p r10 = (p) r5;
        r10.getClass();
        return this.f16564a.equals(r10.f16564a);
    L6:
        return false;
    }

    public final int hashCode() {
        return this.f16564a.hashCode();
    }
}
