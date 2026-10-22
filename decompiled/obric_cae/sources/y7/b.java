package y7;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class b extends UnsatisfiedLinkError {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList<b> f14061a = null;

    static {
        f14061a = new ArrayList();
    }

    public b(String r8) {
        super(r8);
        ArrayList<b> r10 = f14061a;
        monitor-enter(r10);
        r10.add(this);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public b(String r8, Throwable r10) {
        super(r8);
        initCause(r10);
        ArrayList<b> r11 = f14061a;
        monitor-enter(r11);
        r11.add(this);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
