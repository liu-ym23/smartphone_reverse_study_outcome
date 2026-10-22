package dbb;

import com.bytedance.i18n.claymore.ClaymoreServiceLoader;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static b a;

    /* JADX INFO: renamed from: dbb.a$a, reason: collision with other inner class name */
    public interface InterfaceC0210a {
    }

    public interface b {
        InterfaceC0210a getDiskSP();
    }

    public a() {
    }

    public static b a() {
        if (a != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (a != null) goto L9;
        a = (b) ClaymoreServiceLoader.loadFirst(b.class);     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return a;
    }

    public static InterfaceC0210a b() {
        if (a() != null) goto L5;
        return null;
    L5:
        return a().getDiskSP();
    }
}
