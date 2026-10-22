package w4;

import com.bytedance.apm6.util.constant.ReportConsts;
import com.bytedance.bdinstall.Api;
import com.bytedance.common.utility.Logger;
import java.net.CookieHandler;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile g f13380a;

    class a extends r1.c {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ String f13381j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ String f13382k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ g f13383l;

        a(g r10, String r11, String r12, String r13) {
            this.f13383l = r10;
            this.f13381j = r12;
            this.f13382k = r13;
            super(r11);
        }

        @Override // r1.c, java.lang.Runnable
        public void run() {
            g.a(this.f13383l, this.f13381j, this.f13382k);
        }
    }

    public g() {
    }

    static /* synthetic */ void a(g r10, String r11, String r12) {
        r10.b(r11, r12);
    }

    private void b(String r10, String r11) {
        CookieHandler r12 = CookieHandler.getDefault();
        if (r12 != null) goto L6;
        Logger.e("ShareCookieHostsSync", "Default CookieHandler is null.");
        return;
    L6:
        List<String> r13 = e(r10);
        List<String> r14 = e(r11);
        ArrayList r15 = new ArrayList();
        ArrayList r16 = new ArrayList();
        Iterator<String> r17 = r14.iterator();
    L8:
        if (r17.hasNext() == false) goto L20;
        String r18 = r17.next();
        if (com.bytedance.ttnet.utils.d.a(r18, r13) == true) goto L12;
        if (Logger.debug() == false) goto L18;
        Logger.d("ShareCookieHostsSync", "added hosts add: " + r18);
    L18:
        r16.add(r18);
        goto L8
    L12:
        if (Logger.debug() == false) goto L14;
        Logger.d("ShareCookieHostsSync", "kept hosts add: " + r18);
    L14:
        r15.add(r18);
        goto L8
    L20:
        if (r16.isEmpty() == false) goto L23;
        return;
    L23:
        if (r15.isEmpty() == false) goto L26;
        r15 = r16;
    L26:
        Map<String, List<String>> r19 = new HashMap();
        Iterator r110 = r15.iterator();
    L28:
        if (r110.hasNext() == false) goto L38;
        String r20 = (String) r110.next();
        r19 = r12.get(new URI(ReportConsts.HTTPS + r20 + "/"), null);     // Catch: Throwable -> L36
        if (r19.size() <= 0) goto L28;
        if (Logger.debug() == false) goto L38;
        Logger.d("ShareCookieHostsSync", "Sync cookie from host: " + r20 + " sync cookies: " + r19.toString());     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        th.printStackTrace();
    L38:
        if (r19 != null) goto L40;
        return;
    L40:
        if (r19.isEmpty() == true) goto L94;
        List<String> r111 = r19.get("Cookie");
        if (r111 != null) goto L45;
    L46:
        r111 = r19.get("cookie");
        if (r111 != null) goto L49;
        return;
    L49:
        if (r111.isEmpty() == true) goto L95;
    L51:
        LinkedHashMap r112 = new LinkedHashMap();
        List<String> r21 = f(r111);
        Iterator r113 = r16.iterator();
    L53:
        if (r113.hasNext() == false) goto L96;
        String r22 = (String) r113.next();
        ArrayList r23 = new ArrayList();
        URI r24 = new URI(ReportConsts.HTTPS + r22 + "/");     // Catch: Throwable -> L63
        Iterator<String> r25 = r21.iterator();     // Catch: Throwable -> L63
    L57:
        if (r25.hasNext() == false) goto L61;
        String r26 = r25.next();     // Catch: Throwable -> L63
        if (com.bytedance.common.utility.g.b(r26) == true) goto L57;
        r23.add(r26 + "; Domain=" + r22);     // Catch: Throwable -> L63
        goto L57
    L61:
        r112.put(Api.KEY_SET_COOKIE, r23);     // Catch: Throwable -> L63
        r12.put(r24, r112);     // Catch: Throwable -> L63
    L63:
        th = move-exception;
        th.printStackTrace();
        goto L53
    L96:
        return;
    L95:
        return;
    L45:
        if (r111.isEmpty() == false) goto L51;
    }

    public static g c() {
        if (f13380a != null) goto L15;
        monitor-enter(g.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f13380a != null) goto L9;
        f13380a = new g();     // Catch: Throwable -> L11
    L9:
        monitor-exit(g.class);     // Catch: Throwable -> L11
    L15:
        return f13380a;
    }

    private List<String> e(String r10) {
        ArrayList r11 = new ArrayList();
        if (com.bytedance.common.utility.g.b(r10) == false) goto L5;
        return r11;
    L5:
        String[] r12 = r10.split(",");
        int r13 = r12.length;
        int r14 = 0;
    L6:
        if (r14 >= r13) goto L11;
        String r15 = r12[r14];
        if (com.bytedance.common.utility.g.b(r15) == true) goto L10;
        r11.add(r15.trim());
    L10:
        r14 = r14 + 1;
        goto L6
    L11:
        return r11;
    }

    private List<String> f(List<String> r10) {
        ArrayList r11 = new ArrayList();
        Iterator<String> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L11;
        String[] r13 = r12.next().split(";");
        int r14 = r13.length;
        int r15 = 0;
    L6:
        if (r15 >= r14) goto L4;
        String r16 = r13[r15];
        if (com.bytedance.common.utility.g.b(r16) == true) goto L10;
        r11.add(r16.trim());
    L10:
        r15 = r15 + 1;
        goto L6
    L11:
        return r11;
    }

    public void d(String r10, String r11) {
        if (r11.equals(r10) == false) goto L5;
        return;
    L5:
        new a(this, "Sync-Cookie", r10, r11).a();
    }
}
