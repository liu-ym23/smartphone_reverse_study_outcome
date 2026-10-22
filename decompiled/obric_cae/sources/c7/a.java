package c7;

import com.bytedance.bdlocation.client.LocationInfoConst;
import java.net.CookieManager;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class a extends CookieManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f3368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f3369b;

    public a(e r8) {
        b.a r10 = b.f3370a;
        this.f3368a = r8;
        this.f3369b = r10;
    }

    @Override // java.net.CookieManager, java.net.CookieHandler
    public final Map<String, List<String>> get(URI r8, Map<String, List<String>> r10) {
        if (r8 == null) goto L49;
        if (r10 == null) goto L49;
        ArrayList r11 = new ArrayList();
        Iterator<d> r12 = this.f3368a.get(r8).iterator();
    L5:
        int r13 = 1;
        if (r12.hasNext() == false) goto L34;
        d r14 = r12.next();
        HashSet r15 = d.f3371u;
        String r16 = r8.getPath();
        String r17 = "/";
        if (r16 != null) goto L11;
        r16 = "/";
    L14:
        String r18 = r14.f3381p;
        if (r18 == null) goto L22;
        if (r18.endsWith("/") == false) goto L20;
        r17 = r18;
        goto L22
    L20:
        r17 = r18.concat("/");
    L22:
        if (r16.startsWith(r17) == false) goto L5;
        if (r14.f3383r == true) goto L26;
    L29:
        if (r13 == 0) goto L5;
        if (d.e(r14, r8) == false) goto L5;
        r11.add(r14);
        goto L5
    L26:
        if (LocationInfoConst.HTTPS.equalsIgnoreCase(r8.getScheme()) == true) goto L29;
        r13 = 0;
        goto L29
    L11:
        if (r16.endsWith("/") == true) goto L14;
        r16 = r16.concat("/");
        goto L14
    L34:
        if (r11.isEmpty() == true) goto L61;
        StringBuilder r19 = new StringBuilder();
        Iterator r20 = r11.iterator();
        int r21 = 1;
    L38:
        if (r20.hasNext() == false) goto L40;
        r21 = Math.min(r21, ((d) r20.next()).f3385t);
        goto L38
    L40:
        if (r21 != 1) goto L42;
        r19.append("$Version=\"1\"; ");
    L42:
        r19.append(((d) r11.get(0)).toString());
    L44:
        if (r13 >= r11.size()) goto L47;
        r19.append("; ");
        r19.append(((d) r11.get(r13)).toString());
        r13 = r13 + 1;
        goto L44
    L47:
        return Collections.singletonMap("Cookie", Collections.singletonList(r19.toString()));
    L61:
        return Collections.emptyMap();
    L49:
        throw new IllegalArgumentException();
    }

    @Override // java.net.CookieManager, java.net.CookieHandler
    public final void put(URI r8, Map<String, List<String>> r10) {
        if (r8 == null) goto L79;
        if (r10 == null) goto L79;
        ArrayList r11 = new ArrayList();
        Iterator<Map.Entry<String, List<String>>> r12 = r10.entrySet().iterator();
    L6:
        if (r12.hasNext() == false) goto L22;
        Map.Entry<String, List<String>> r13 = r12.next();
        String r14 = r13.getKey();
        if (r14 == null) goto L6;
        if (r14.equalsIgnoreCase("Set-cookie") == true) goto L13;
        if (r14.equalsIgnoreCase("Set-cookie2") == false) goto L6;
    L13:
        Iterator<String> r15 = r13.getValue().iterator();
    L15:
        if (r15.hasNext() == false) goto L6;
        Iterator r16 = d.d(r15.next()).iterator();     // Catch: IllegalArgumentException -> L80
    L19:
        if (r16.hasNext() == false) goto L15;
        r11.add((d) r16.next());     // Catch: IllegalArgumentException -> L80
    L22:
        Iterator r17 = r11.iterator();
    L24:
        if (r17.hasNext() == false) goto L77;
        d r18 = (d) r17.next();
        if (r18.f3378m != null) goto L32;
        String r19 = r8.getHost();
        if (r19 != null) goto L30;
        String r20 = null;
    L31:
        r18.f3378m = r20;
        goto L32
    L30:
        r20 = r19.toLowerCase(Locale.US);
    L32:
        String r21 = "/";
        if (r18.f3381p == null) goto L34;
        String r22 = r8.getPath();
        if (r22 != null) goto L43;
        r22 = "/";
    L46:
        String r23 = r18.f3381p;
        if (r23 == null) goto L54;
        if (r23.endsWith("/") == false) goto L52;
        r21 = r23;
        goto L54
    L52:
        r21 = r23.concat("/");
    L54:
        if (r22.startsWith(r21) == false) goto L24;
    L57:
        if ("".equals(r18.f3382q) == true) goto L58;
        if (r18.f3382q == null) goto L75;
        if (d.e(r18, r8) == false) goto L24;
    L75:
        if (this.f3369b.a(r18, r8) == false) goto L24;
        this.f3368a.a(r18, r8);
        goto L24
    L58:
        String r24 = r8.getScheme();
        int r25 = r8.getPort();
        int r26 = h.f3404m;
        if (r25 == (-1)) goto L62;
    L68:
        r18.f3382q = Integer.toString(r25);
        goto L75
    L62:
        if ("http".equalsIgnoreCase(r24) == false) goto L65;
        r25 = 80;
        goto L68
    L65:
        if (LocationInfoConst.HTTPS.equalsIgnoreCase(r24) == false) goto L67;
        r25 = 443;
        goto L68
    L67:
        r25 = -1;
        goto L68
    L43:
        if (r22.endsWith("/") == true) goto L46;
        r22 = r22.concat("/");
        goto L46
    L34:
        String r27 = r8.getPath();
        if (r27 == null) goto L38;
        r21 = r27.substring(0, r27.lastIndexOf(47) + 1);
    L38:
        r18.f3381p = r21;
        goto L57
    L77:
        return;
    L79:
        throw new IllegalArgumentException();
    }
}
