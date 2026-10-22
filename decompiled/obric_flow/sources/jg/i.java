package jg;

import android.os.Message;
import android.os.SystemClock;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f18332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static g f18333b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CopyOnWriteArrayList f18334c = null;
    public static d6.a d;
    public static volatile r6.a e;
    public static volatile boolean f;
    public static long g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f18335h;

    static {
        f18334c = new CopyOnWriteArrayList();
        f = false;
        g = 0;
        f18335h = 0;
    }

    public static void a(boolean r10, String r11, Message r12) {
        long r5 = System.nanoTime();
        a.f18319b = r5 / 1000000;
        a.f18320c = SystemClock.currentThreadTimeMillis();
        if (r10 == false) goto L45;
        d6.a r13 = d;
        if (r13 == null) goto L45;
        if (r13.d.f16599a == false) goto L45;
        d.b(r11);
    L45:
        CopyOnWriteArrayList r14 = f18334c;     // Catch: Exception -> L44
        int r15 = 0;
    L11:
        if (r15 >= r14.size()) goto L29;
        a r16 = (a) r14.get(r15);     // Catch: Exception -> L44
        if (r16 != null) goto L16;
    L24:
        if (r10 == true) goto L28;
        if (r16.f18321a == false) goto L28;
        r16.a();     // Catch: Exception -> L44
    L28:
        r15 = r15 + 1;
        goto L11
    L16:
        if (r16.c() == false) goto L24;
        if (r10 == false) goto L22;
        if (r16.f18321a == true) goto L28;
        r16.b(r11);     // Catch: Exception -> L44
        goto L28
    L22:
        if (r16.f18321a == false) goto L28;
        r16.a();     // Catch: Exception -> L44
    L29:
        if (r10 == true) goto L36;
        d6.a r17 = d;
        if (r17 == null) goto L36;
        if (r17.d.f16599a == false) goto L36;
        d.a();
    L36:
        if (f == false) goto L55;
        g = (System.nanoTime() - r5) + g;
        int r18 = f18335h;
        f18335h = r18 + 1;
        if (r18 >= 1000) goto L40;
        return;
    L40:
        if (e == null) goto L42;
        r6.a r19 = e;
        long r20 = g;
        r19.getClass();
        z6.b.f23409a.d(new com.bytedance.ies.bullet.ui.common.e(r19, r20, 2));
    L42:
        f18335h = 0;
        g = 0;
        f = false;
        return;
    }
}
