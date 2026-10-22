package a8;

import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Printer;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropUtils;
import java.lang.reflect.Field;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static c f122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CopyOnWriteArrayList<a8.a> f123c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static a8.a f124d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile a f125e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile boolean f126f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static long f127g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f128h;

    public interface a {
    }

    static {
        f123c = new CopyOnWriteArrayList();
        f126f = false;
        f127g = 0;
        f128h = 0;
    }

    public static void a(boolean r8, String r10, Message r11) {
        long r12 = System.nanoTime();
        a8.a.f118b = r12 / BwdlDropUtils.DROP_SHOW_MEGABYTES;
        a8.a.f119c = SystemClock.currentThreadTimeMillis();
        if (r8 == false) goto L45;
        a8.a r13 = f124d;
        if (r13 == null) goto L45;
        if (r13.c() == false) goto L45;
        f124d.b(r10);
    L45:
        CopyOnWriteArrayList<a8.a> r14 = f123c;     // Catch: Exception -> L44
        int r15 = 0;
    L11:
        if (r15 >= r14.size()) goto L29;
        a8.a r16 = r14.get(r15);     // Catch: Exception -> L44
        if (r16 != null) goto L16;
    L24:
        if (r8 == true) goto L28;
        if (r16.f120a == false) goto L28;
    L23:
        r16.a();     // Catch: Exception -> L44
    L28:
        r15 = r15 + 1;
        goto L11
    L16:
        if (r16.c() == false) goto L24;
        if (r8 == false) goto L22;
        if (r16.f120a == true) goto L28;
        r16.b(r10);     // Catch: Exception -> L44
        goto L28
    L22:
        if (r16.f120a == false) goto L28;
    L29:
        if (r8 == true) goto L36;
        a8.a r17 = f124d;
        if (r17 == null) goto L36;
        if (r17.c() == false) goto L36;
        f124d.a();
    L36:
        if (f126f == false) goto L54;
        f127g = (System.nanoTime() - r12) + f127g;
        int r18 = f128h;
        f128h = r18 + 1;
        if (r18 >= 1000) goto L40;
        return;
    L40:
        if (f125e == null) goto L42;
        a r19 = f125e;
        long r20 = f127g;
        j2.d.a r21 = (j2.d.a) r19;
        r21.getClass();
        b3.b.C0032b.f3038a.c(new j2.c(r21, r20));
    L42:
        f128h = 0;
        f127g = 0;
        f126f = false;
        return;
    }

    public static void b() {
        if (r5.b.f11495b == true) goto L12;
        r5.b.f11495b = true;
        r5.b.f11494a = new r5.b.a();
        Field r8 = Class.forName("android.os.Looper").getDeclaredField("mLogging");     // Catch: Exception -> L8
        r8.setAccessible(true);     // Catch: Exception -> L8
        Printer r10 = (Printer) r8.get(Looper.getMainLooper());     // Catch: Exception -> L8
    L9:
        if (r10 == null) goto L11;
        r5.b.f11494a.f11496a.add(r10);
    L11:
        Looper.getMainLooper().setMessageLogging(r5.b.f11494a);
    L8:
        r10 = null;
    L12:
        c r11 = f122b;
        if (r11 != null) goto L15;
        return;
    L15:
        if (r5.b.f11494a.f11498c.contains(r11) == true) goto L21;
        r5.b.f11494a.f11498c.add(r11);
        r5.b.f11494a.f11500e = true;
        return;
    }
}
