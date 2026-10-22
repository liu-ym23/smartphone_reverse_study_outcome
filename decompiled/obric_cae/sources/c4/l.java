package c4;

import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Boolean f3350a;

    static {
        f3350a = Boolean.FALSE;
    }

    public static String a(r4.a r8) {
        if (r8 != null) goto L6;
        return "";
    L6:
        if ((r8 instanceof r4.f) == false) goto L10;
        return "FORWARD_EVENT";
    L10:
        if ((r8 instanceof r4.e) == false) goto L17;
        if ("applog_trace".equals(((r4.e) r8).J) == false) goto L15;
        return "TRACE";
    L15:
        return "EVENT_V3";
    L17:
        if ((r8 instanceof r4.j) == false) goto L20;
        return "EVENT_V3";
    L20:
        if ((r8 instanceof r4.c) == false) goto L24;
        return ((r4.c) r8).H.toUpperCase(Locale.ROOT);
    L24:
        if ((r8 instanceof r4.g) == false) goto L28;
        return "LAUNCH";
    L28:
        if ((r8 instanceof r4.k) == false) goto L32;
        return "TERMINATE";
    L32:
        if ((r8 instanceof r4.d) == false) goto L35;
        return "LOG_DATA";
    L35:
        return "";
    }

    public static boolean b() {
        return !f3350a.booleanValue();
    }

    public static void c(String r8, e.b r10) {
        if (b() == false) goto L5;
        return;
    L5:
        if (v4.i.g(r8) == true) goto L10;
        ((e) e.f3331o.b(new Object[0])).b(e(r8), r10);
        return;
    }

    public static void d(Object r8, String r10) {
        if (b() == false) goto L5;
        return;
    L5:
        if (v4.i.g(r10) == false) goto L8;
        return;
    L8:
        if ((r8 instanceof r4.a) == false) goto L10;
        ((e) e.f3331o.b(new Object[0])).b(e(r10), new k(r8));
        return;
    L10:
        ((e) e.f3331o.b(new Object[0])).a(r8, e(r10));
    }

    public static String e(String r8) {
        return "applog_".concat(r8);
    }
}
