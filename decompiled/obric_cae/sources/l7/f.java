package l7;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f9173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9174b;

    public f(String r8) {
        this.f9173a = new LinkedHashMap();
        this.f9174b = r8;
    }

    public final void a(int r8, String r10) {
        LinkedHashMap r11 = this.f9173a;
        List r12 = (List) r11.get(r10);
        if (r12 != null) goto L5;
        r12 = new LinkedList();
    L5:
        r12.add(String.valueOf(r8));
        r11.put(r10, r12);
    }

    public final void b(String r8, String r10) {
        LinkedHashMap r11 = this.f9173a;
        List r12 = (List) r11.get(r8);
        if (r12 != null) goto L5;
        r12 = new LinkedList();
    L5:
        r12.add(String.valueOf(r10));
        r11.put(r8, r12);
    }

    public final String c() {
        LinkedHashMap r8 = this.f9173a;
        boolean r10 = r8.isEmpty();
        String r11 = this.f9174b;
        if (r10 == false) goto L5;
        return r11;
    L5:
        Pattern r12 = g.f9175a;
        StringBuilder r13 = new StringBuilder();
        Iterator r14 = r8.entrySet().iterator();
    L7:
        if (r14.hasNext() == false) goto L34;
        Map.Entry r15 = (Map.Entry) r14.next();
        String r16 = URLEncoder.encode((String) r15.getKey(), "UTF-8");     // Catch: UnsupportedEncodingException -> L31
        List r17 = (List) r15.getValue();
        if (r17 == null) goto L7;
        if (r17.size() <= 0) goto L7;
        Iterator r18 = r17.iterator();
    L16:
        if (r18.hasNext() == false) goto L7;
        String r19 = (String) r18.next();
        if (r19 != null) goto L46;
        String r20 = "";
    L26:
        if (r13.length() <= 0) goto L28;
        r13.append("&");
    L28:
        r13.append(r16);
        if (r20.isEmpty() == true) goto L16;
        r13.append("=");
        r13.append(r20);
        goto L16
    L46:
        r20 = URLEncoder.encode(r19, "UTF-8");     // Catch: UnsupportedEncodingException -> L21
    L21:
        e = move-exception;
        throw new IllegalArgumentException(e);
    L31:
        e = move-exception;
        throw new IllegalArgumentException(e);
    L34:
        String r21 = r13.toString();
        if (r11 != null) goto L37;
    L45:
        return r21;
    L37:
        if (r11.length() == 0) goto L45;
        if (r11.indexOf(63) < 0) goto L42;
        StringBuilder r22 = android.aimedia.a.k(r11, "&");
    L43:
        r22.append(r21);
        return r22.toString();
    L42:
        r22 = android.aimedia.a.k(r11, "?");
        goto L43
    }

    public final String toString() {
        return c();
    }
}
