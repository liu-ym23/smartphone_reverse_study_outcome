package hpc;

import com.bytedance.i18n.claymore.ClaymoreServiceLoader;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public static volatile b a;
    public static volatile ipc.a b;

    public b() {
    }

    public static ipc.a a() {
        if (b != null) goto L15;
        monitor-enter(ipc.a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L9;
        b = (ipc.a) ClaymoreServiceLoader.loadFirst(ipc.a.class);     // Catch: Throwable -> L11
    L9:
        monitor-exit(ipc.a.class);     // Catch: Throwable -> L11
    L15:
        return b;
    }

    public static b b() {
        if (a != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (a != null) goto L9;
        a = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return a;
    }
}
