package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f10609a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f10610b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final boolean f10611c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final AtomicLong f10612d = null;

    static {
        String r10 = kotlinx.coroutines.internal.j0.d("kotlinx.coroutines.debug");
        boolean r11 = true;
        if (r10 == null) goto L26;
        int r12 = r10.hashCode();
        if (r12 == 0) goto L22;
        if (r12 == 3551) goto L19;
        if (r12 == 109935) goto L16;
        if (r12 != 3005871) goto L25;
        if (r10.equals("auto") == true) goto L26;
    L25:
        throw new IllegalStateException(("System property 'kotlinx.coroutines.debug' has unrecognized value '" + r10 + '\'').toString());
    L16:
        if (r10.equals("off") == false) goto L25;
    L19:
        if (r10.equals("on") == false) goto L25;
    L23:
        boolean r13 = true;
    L27:
        f10610b = r13;
        if (r13 == true) goto L30;
    L32:
        r11 = false;
    L33:
        f10611c = r11;
        f10612d = new AtomicLong(0);
        return;
    L30:
        if (kotlinx.coroutines.internal.j0.f("kotlinx.coroutines.stacktrace.recovery", true) == false) goto L32;
    L22:
        if (r10.equals("") == false) goto L25;
    L26:
        r13 = false;
        goto L27
    }

    public static final boolean a() {
        return f10609a;
    }

    public static final AtomicLong b() {
        return f10612d;
    }

    public static final boolean c() {
        return f10610b;
    }

    public static final boolean d() {
        return f10611c;
    }
}
