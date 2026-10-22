package l9;

import android.util.Printer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class m {
    public static Printer e;
    public static m f;
    public static final jg.g g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f19576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f19577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f19578c;
    public boolean d;

    static {
        g = new jg.g(1);
    }

    public m() {
        this.f19576a = -1;
        this.f19577b = new ArrayList();
        this.f19578c = new ArrayList();
    }

    public static m a() {
        if (f != null) goto L16;
        monitor-enter(m.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f != null) goto L11;
        f = new m();     // Catch: Throwable -> L9
    L11:
        monitor-exit(m.class);     // Catch: Throwable -> L9
    L16:
        return f;
    }

    public static void b(String r5, ArrayList r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L22;
        int r11 = r10.size();     // Catch: Throwable -> L13
        int r12 = 0;
    L7:
        if (r12 >= r11) goto L23;
        Printer r13 = (Printer) r10.get(r12);     // Catch: Throwable -> L13
        if (r13 == null) goto L21;
        r13.println(r5);     // Catch: Throwable -> L13
        r12 = r12 + 1;
        goto L7
    L21:
        return;
    L23:
        return;
    L13:
        th = move-exception;
        io.reactivex.exceptions.a.f(th);
        return;
    }
}
