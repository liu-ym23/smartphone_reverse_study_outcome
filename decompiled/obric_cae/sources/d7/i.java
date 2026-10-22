package d7;

import com.ttnet.org.chromium.net.urlconnection.CronetHttpURLConnection;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import we.a0;
import we.y;

/* JADX INFO: loaded from: classes.dex */
public final class i implements we.s {
    @Override // we.s
    public final a0 a(af.f r11) {
        y r10 = r11.f364f;
        URI r8 = r10.f13337a.n();     // Catch: Exception -> L5
    L6:
        r10.getClass();
        y.a r12 = new y.a(r10);
        CookieHandler r13 = CookieHandler.getDefault();
        HashMap r14 = new HashMap();     // Catch: Throwable -> L48
        we.q r15 = r10.f13340d;
        if (r15 == null) goto L19;
        Set<String> r16 = r15.f();     // Catch: Throwable -> L48
        if (r16 == null) goto L19;
        if (r16.isEmpty() == true) goto L19;
        Iterator<String> r17 = r16.iterator();     // Catch: Throwable -> L48
    L16:
        if (r17.hasNext() == false) goto L19;
        String r18 = r17.next();     // Catch: Throwable -> L48
        r14.put(r18, r15.k(r18));     // Catch: Throwable -> L48
    L19:
        if (r13 != null) goto L76;
    L24:
        Map<String, List<String>> r19 = null;
    L25:
        if (r19 != null) goto L27;
    L74:
        r10 = r12.a();     // Catch: Throwable -> L52
    L54:
        a0 r110 = r11.e(r10);
        HashMap r111 = new HashMap();
        we.q r20 = r110.f13119p;
        if (r20 == null) goto L64;
        Set<String> r21 = r20.f();
        if (r21 == null) goto L64;
        if (r21.isEmpty() == true) goto L64;
        Iterator<String> r22 = r21.iterator();
    L62:
        if (r22.hasNext() == false) goto L64;
        String r23 = r22.next();
        r111.put(r23, r20.k(r23));
    L64:
        if (r13 != null) goto L70;
    L69:
        return r110;
    L70:
        r13.put(r8, r111);     // Catch: IOException -> L67
    L67:
        e = move-exception;
        e.printStackTrace();
    L52:
        th = move-exception;
        th.printStackTrace();
        goto L54
    L27:
        if (r19.size() <= 0) goto L74;
        Iterator<Map.Entry<String, List<String>>> r24 = r19.entrySet().iterator();     // Catch: Throwable -> L48
    L29:
        if (r24.hasNext() == false) goto L74;
        Map.Entry<String, List<String>> r25 = r24.next();     // Catch: Throwable -> L48
        String r26 = r25.getKey();     // Catch: Throwable -> L48
        StringBuilder r27 = new StringBuilder();     // Catch: Throwable -> L48
        if (CronetHttpURLConnection.SS_COOKIE.equalsIgnoreCase(r26) == true) goto L38;
        if ("Cookie".equalsIgnoreCase(r26) == true) goto L38;
        if ("Cookie2".equalsIgnoreCase(r26) == false) goto L29;
    L38:
        if (r25.getValue().isEmpty() == true) goto L29;
        Iterator<String> r28 = r25.getValue().iterator();     // Catch: Throwable -> L48
        int r29 = 0;
    L41:
        if (r28.hasNext() == false) goto L46;
        String r30 = r28.next();     // Catch: Throwable -> L48
        if (r29 <= 0) goto L45;
        r27.append("; ");     // Catch: Throwable -> L48
    L45:
        r27.append(r30);     // Catch: Throwable -> L48
        r29 = r29 + 1;     // Catch: Throwable -> L48
        goto L41
    L46:
        String r31 = r27.toString();     // Catch: Throwable -> L48
        r12.f13347d.a(r26, r31);     // Catch: Throwable -> L48
        goto L29
    L76:
        r19 = r13.get(r8, r14);     // Catch: IOException -> L22 Throwable -> L48
    L22:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        th.printStackTrace();
    L5:
        r8 = t2.b.s(r10.f13337a.f13249i);
        goto L6
    }
}
