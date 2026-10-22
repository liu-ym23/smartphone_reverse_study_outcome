package xh;

import com.google.gson.Gson;
import dm.d;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public final Gson a;
    public final ThreadLocal<String> b;

    public a() {
        this.a = new Gson();
        this.b = new ThreadLocal();
    }

    public final void g(Object r10) {
        Intrinsics.checkNotNullParameter("good_list", "module");
        b r0 = new b();
        r0.c("good_list");
        r0.b("long_press_cell_blank");
        r0.a(r10);
        f(4, r0);
    }

    public final void a(String r10, b.a r11) {
        b r0 = new b();
        r0.c(r10);
        r0.b("api_request_begin");
        r0.a(r11);
        f(4, r0);
    }

    public final void b(String r10, b.C0213b r11) {
        b r0 = new b();
        r0.c(r10);
        r0.b("api_request_fail");
        r0.a(r11);
        f(5, r0);
    }

    public final void c(String r10, b.c r11) {
        b r0 = new b();
        r0.c(r10);
        r0.b("api_request_success");
        r0.a(r11);
        f(4, r0);
    }

    public final void f(int r10, b r11) {
        String r0 = this.b.get();
        String r1 = "";
        if (r0 == null) goto L5;
        this.b.remove();
    L23:
        String r12 = this.a.toJson(r11);     // Catch: Throwable -> L10
        if (r12 == null) goto L12;
        r1 = r12;
    L12:
        if (r1.length() > 3072) goto L14;
        e(r10, r0, r1);
        return;
    L14:
        ArrayList r13 = new ArrayList();
    L15:
        int r14 = 0;
        if (r1.length() <= 3072) goto L18;
        r13.add(r1.substring(0, 3072));
        r1 = r1.substring(3072);
        goto L15
    L18:
        r13.add(r1);
        int r15 = r13.size();
        Iterator r16 = r13.iterator();
    L20:
        if (r16.hasNext() == false) goto L27;
        String r17 = (String) r16.next();
        StringBuilder r18 = new StringBuilder("[Part ");
        r14 = r14 + 1;
        r18.append(r14);
        r18.append('/');
        r18.append(r15);
        r18.append("] ");
        r18.append(r17);
        e(r10, r0, r18.toString());
        goto L20
    L27:
        return;
    L10:
        r1 = "toJson error";
        goto L12
    L5:
        r0 = "";
        goto L23
    }

    public final void i(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "module");
        Intrinsics.checkNotNullParameter(r11, "pageName");
        String r12 = "page_hide_".concat(r11);
        b r0 = new b();
        r0.c(r10);
        r0.b(r12);
        r0.a(null);
        f(4, r0);
    }

    public static void e(int r10, String r11, String r12) {
        if (r10 != 3) goto L5;
        dm.a.a(r11).a(r12);
        return;
    L5:
        if (r10 != 4) goto L7;
        dm.a.a(r11).i(r12);
        return;
    L7:
        if (r10 != 5) goto L9;
        dm.a.a(r11).w(r12, null);
        return;
    L9:
        if (r10 != 6) goto L20;
        dm.a.a(r11).b(r12, null);
        return;
    L20:
        d r0 = dm.a.a(r11).a;     // Catch: Exception -> L13
        r0.g(2, r0.d(), r0.e(), r0.c(), r12, null);     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        dm.c.b(e);
    }

    public final void d(String r10, String r11, Object r12) {
        Intrinsics.checkNotNullParameter(r10, "module");
        b r0 = new b();
        r0.c(r10);
        r0.b("click_" + r11);
        r0.a(r12);
        f(4, r0);
    }

    public final void j(String r10, String r11, Object r12) {
        Intrinsics.checkNotNullParameter(r10, "module");
        Intrinsics.checkNotNullParameter(r11, "pageName");
        String r13 = "page_show_".concat(r11);
        b r0 = new b();
        r0.c(r10);
        r0.b(r13);
        r0.a(r12);
        f(4, r0);
    }

    public final void h(String r10, String r11, b.d r12, int r13) {
        b r0 = new b();
        r0.c(r10);
        r0.b("msg_recv_" + r11);
        r0.a(r12);
        f(r13, r0);
    }
}
