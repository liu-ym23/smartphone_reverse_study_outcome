package nk;

import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HashMap f20268a;

    static {
        f20268a = new HashMap();
    }

    public static void a() {
        vk.a r5 = (vk.a) f20268a.get("webx_webkit");
        if (r5 != null) goto L17;
        monitor-enter(a.class);
        vk.a r10 = (vk.a) f20268a.get("webx_webkit");     // Catch: Throwable -> L11
        if (r10 == null) goto L13;
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L10:
        r5 = r10;
        goto L17
    L13:
        r10 = new vk.a();     // Catch: Throwable -> L11
        HashMap r11 = new HashMap(f20268a);     // Catch: Throwable -> L11
        r11.put("webx_webkit", r10);     // Catch: Throwable -> L11
        f20268a = r11;     // Catch: Throwable -> L11
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L17:
        if (r5.f22586b.get(sk.a.class) != null) goto L40;
        monitor-enter(a.class);
    L29:
        th = move-exception;
        throw th;
    L21:
        if (r5.f22586b.get(sk.a.class) != null) goto L36;
        if (b.a(r5.f22585a) == null) goto L34;
        if (vk.a.a() != null) goto L32;
        HashMap r12 = new HashMap(r5.f22586b);     // Catch: Throwable -> L29
        r12.put(sk.a.class, null);     // Catch: Throwable -> L29
        r5.f22586b = r12;     // Catch: Throwable -> L29
        monitor-exit(a.class);     // Catch: Throwable -> L29
        return;
    L32:
        throw new ClassCastException();     // Catch: Throwable -> L29
    L34:
        throw new Error("nameSpace " + r5.f22585a + "& class " + sk.a.class.getCanonicalName() + " 's env is null");     // Catch: Throwable -> L29
    L36:
        throw new ClassCastException();     // Catch: Throwable -> L29
    L40:
        throw new ClassCastException();
    }
}
