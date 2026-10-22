package f1;

import java.util.Locale;
import o1.p;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Boolean f8836a;

    static class a implements e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f8837a;

        a(Object r10) {
            this.f8837a = r10;
        }

        @Override // f1.e.b
        public Object a() {
            JSONObject r10 = ((l1.a) this.f8837a).z();
            JSONObject r11 = new JSONObject();
            o1.j.b(r10, r11);
            r11.put("$$APP_ID", ((l1.a) this.f8837a).j());     // Catch: JSONException -> L5
            r11.put("$$EVENT_TYPE", m.a((l1.a) this.f8837a));     // Catch: JSONException -> L5
            r11.put("$$EVENT_LOCAL_ID", ((l1.a) this.f8837a).f10843v);     // Catch: JSONException -> L5
        L4:
            return r11;
        }
    }

    static {
        f8836a = Boolean.FALSE;
    }

    static /* synthetic */ String a(l1.a r10) {
        return b(r10);
    }

    private static String b(l1.a r10) {
        if (r10 != null) goto L6;
        return "";
    L6:
        if ((r10 instanceof l1.e) == false) goto L13;
        if ("applog_trace".equals(((l1.e) r10).F()) == false) goto L11;
        return "TRACE";
    L11:
        return "EVENT_V3";
    L13:
        if ((r10 instanceof l1.h) == false) goto L16;
        return "EVENT_V3";
    L16:
        if ((r10 instanceof l1.c) == false) goto L20;
        return ((l1.c) r10).f10857z.toUpperCase(Locale.ROOT);
    L20:
        if ((r10 instanceof l1.f) == false) goto L24;
        return "LAUNCH";
    L24:
        if ((r10 instanceof l1.i) == false) goto L28;
        return "TERMINATE";
    L28:
        if ((r10 instanceof l1.d) == false) goto L31;
        return "LOG_DATA";
    L31:
        return "";
    }

    public static boolean c() {
        return !f8836a.booleanValue();
    }

    public static void d(String r10, e.b r11) {
        if (c() == false) goto L5;
        return;
    L5:
        if (p.l(r10) == true) goto L10;
        e.f8791i.b(new Object[0]).c(g(r10), r11);
        return;
    }

    public static void e(String r10, Object r11) {
        if (c() == false) goto L5;
        return;
    L5:
        if (p.l(r10) == false) goto L8;
        return;
    L8:
        if ((r11 instanceof l1.a) == false) goto L10;
        e.f8791i.b(new Object[0]).c(g(r10), new a(r11));
        return;
    L10:
        e.f8791i.b(new Object[0]).d(g(r10), r11);
    }

    public static void f(String r10, String r11) {
        if (c() == false) goto L5;
        return;
    L5:
        if (p.l(r10) == true) goto L10;
        e.f8791i.b(new Object[0]).d(g(r10), r11);
        return;
    }

    private static String g(String r10) {
        return "applog_" + r10;
    }
}
