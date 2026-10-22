package ms.bd.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a4 {
    public static volatile a4 c;
    public int a;
    public Throwable b;

    public static a4 a() {
        if (c != null) goto L15;
        monitor-enter(a4.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (c != null) goto L9;
        c = new a4();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a4.class);     // Catch: Throwable -> L11
    L15:
        return c;
    }

    public a4() {
        this.a = 0;
        this.b = null;
    }
}
