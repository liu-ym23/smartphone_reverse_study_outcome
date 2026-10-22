package bsb;

import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static volatile a b;
    public final ArrayList<InterfaceC0014a> a;

    /* JADX INFO: renamed from: bsb.a$a, reason: collision with other inner class name */
    public interface InterfaceC0014a {
        void onExit();
    }

    public static a a() {
        if (b != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L9;
        b = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return b;
    }

    public a() {
        this.a = new ArrayList();
    }
}
