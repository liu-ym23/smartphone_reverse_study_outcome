package zoa;

import java.security.KeyStore;
import xoa.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a {
    public static KeyStore b;
    public static a c;
    public final C0035a a;

    /* JADX INFO: renamed from: zoa.a$a, reason: collision with other inner class name */
    public class C0035a {
        public final /* synthetic */ a a;

        public C0035a(a r1) {
            this.a = r1;
        }
    }

    public static synchronized void a() {
        monitor-enter(a.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (c == null) goto L8;
        monitor-exit(a.class);
        return;
    L8:
        apa.a.a("AzerothKeyStore", "init");     // Catch: Throwable -> L16
        KeyStore r1 = KeyStore.getInstance("AndroidKeyStore");     // Catch: Exception -> L11 Throwable -> L16
        r1.load(null);     // Catch: Exception -> L11 Throwable -> L16
        b = r1;     // Catch: Exception -> L11 Throwable -> L16
        apa.a.a("AzerothKeyStore", "AndroidKeyStore init success");     // Catch: Exception -> L11 Throwable -> L16
    L13:
        c = new a();     // Catch: Throwable -> L16
        monitor-exit(a.class);
        return;
    L11:
        e = move-exception;
        b r2 = xoa.a.a;     // Catch: Throwable -> L16
        xoa.a.a(e, "AndroidKeyStore init fail", fpa.a.a());     // Catch: Throwable -> L16
        goto L13
    }

    public a() {
        this.a = new C0035a(this);
    }
}
