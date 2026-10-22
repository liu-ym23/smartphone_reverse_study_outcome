package p0c;

import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static volatile q0c.b a;

    /* JADX INFO: renamed from: p0c.a$a, reason: collision with other inner class name */
    public static final class C0176a {
    }

    static {
    }

    public a() {
    }

    @JvmStatic
    public static final q0c.b a() {
        if (a != null) goto L16;
        monitor-enter(a.class);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (a != null) goto L9;
        a = (q0c.b) ClaymoreServiceLoader.loadFirst(q0c.b.class);     // Catch: Throwable -> L12
    L9:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(a.class);
    L16:
        return a;
    }
}
