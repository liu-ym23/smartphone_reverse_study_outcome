package n4a;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class m0 {
    public static m0 d;
    public final Map<String, Map<String, List<String>>> a;
    public final Map<String, List<String>> b;
    public final List<String> c;

    public static class a {
        public final String a;
        public final String b;
        public String c;

        public a(String r2, String r3) {
            this.a = null;
            this.b = r2;
            this.c = r3;
        }

        public a(URL r2) {
            this.a = r2.getProtocol();
            this.b = r2.getHost();
            this.c = r2.getPath();
        }
    }

    static {
    }

    public m0() {
        this.a = new HashMap();
        this.b = new HashMap();
        this.c = new ArrayList();
    }

    public static synchronized m0 a() {
        monitor-enter(m0.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (d != null) goto L7;
        d = new m0();     // Catch: Throwable -> L10
    L7:
        m0 r1 = d;     // Catch: Throwable -> L10
        monitor-exit(m0.class);
        return r1;
    }

    public final boolean b(String r10) {
        if (r10 != null) goto L5;
    L88:
        return false;
    L5:
        if (r10.length() == 0) goto L88;
        a r3 = null;
        a r4 = new a(new URL(r10));     // Catch: MalformedURLException -> L10
    L33:
        if (r4 == null) goto L48;
        String r11 = r4.c;
        if (r11 != null) goto L39;
    L47:
        r3 = r4;
        goto L48
    L39:
        if (r11.length() == 0) goto L47;
    L41:
        String r12 = r4.c;
        if (r12.charAt(r12.length() - 1) != '/') goto L45;
        String r13 = r4.c;
        r4.c = r13.substring(0, r13.length() - 1);
    L45:
        if (r4.c.charAt(0) != '/') goto L47;
        r4.c = r4.c.substring(1);
    L48:
        if (r3 != null) goto L50;
        return false;
    L50:
        monitor-enter(this);
    L85:
        th = move-exception;
        throw th;
    L52:
        if (r3.c.length() == 0) goto L83;
        Map<String, List<String>> r14 = this.b;     // Catch: Throwable -> L85
        String r2 = r3.a;     // Catch: Throwable -> L85
        if (r2 != null) goto L57;
    L59:
        List<String> r5 = this.c;     // Catch: Throwable -> L85
        String r6 = r3.b;     // Catch: Throwable -> L85
        if (r6 != null) goto L62;
    L64:
        Iterator<String> r15 = r5.iterator();     // Catch: Throwable -> L85
    L65:
        if (r15.hasNext() == false) goto L83;
        String r7 = r15.next();     // Catch: Throwable -> L85
        String r8 = r3.c;     // Catch: Throwable -> L85
        String[] r9 = r7.split("/");     // Catch: Throwable -> L85
        String[] r16 = r8.split("/");     // Catch: Throwable -> L85
        if (r16.length < r9.length) goto L77;
        int r17 = 0;
    L72:
        if (r17 >= r9.length) goto L79;
        if (r9[r17].equals("*") == true) goto L78;
        if (r9[r17].equals(r16[r17]) == false) goto L77;
    L78:
        r17 = r17 + 1;
        goto L72
    L79:
        boolean r18 = true;
    L80:
        if (r18 == false) goto L65;
        monitor-exit(this);
        return true;
    L77:
        r18 = false;
        goto L80
    L62:
        if (r14.containsKey(r6) == false) goto L64;
        r5 = r14.get(r3.b);     // Catch: Throwable -> L85
        goto L64
    L57:
        if (((HashMap) this.a).containsKey(r2) == false) goto L59;
        r14 = (Map) ((HashMap) this.a).get(r3.a);     // Catch: Throwable -> L85
    L83:
        monitor-exit(this);
        return false;
    L11:
        if (r10.contains("://") == false) goto L14;
        r4 = null;
    L14:
        if (r10.startsWith("/") == false) goto L16;
        r10 = r10.substring(1);
        goto L14
    L16:
        String[] r19 = r10.split("/");
        if (r19[0].contains(".") == false) goto L19;
        String r20 = r19[0];
        int r21 = 1;
    L20:
        StringBuilder r22 = new StringBuilder();
    L22:
        if (r21 >= r19.length) goto L28;
        if (r22.length() <= 0) goto L26;
        r22.append("/");
    L26:
        r22.append(r19[r21]);
        r21 = r21 + 1;
        goto L22
    L28:
        if (r22.length() > 0) goto L30;
    L32:
        r4 = new a(r20, r22.toString());
        goto L33
    L30:
        if (r22.charAt(r22.length() - 1) != '/') goto L32;
        r22.deleteCharAt(r22.length() - 1);
        goto L32
    L19:
        r20 = null;
        r21 = 0;
        goto L20
    }
}
