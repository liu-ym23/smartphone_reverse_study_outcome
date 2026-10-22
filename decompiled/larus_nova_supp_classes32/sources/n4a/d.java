package n4a;

import android.content.Context;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d {
    public static d c;
    public final Context a;
    public final String b;

    public static d a(Context r2) {
        if (c != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (c != null) goto L9;
        c = new d(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return c;
    }

    public d(Context r2) {
        this.a = r2.getApplicationContext();
        String r3 = f5.o("RYW1hcF9kZXZpY2VfYWRpdQ");
        byte[] r0 = k.a;
        this.b = b5.a(r3);
    }
}
