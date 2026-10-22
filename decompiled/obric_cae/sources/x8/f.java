package x8;

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
public final class f extends s5.c {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ String f13705o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ String f13706p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final /* synthetic */ g f13707q;

    public f(g r8, String r10, String r11) {
        this.f13707q = r8;
        this.f13705o = r10;
        this.f13706p = r11;
        super(0);
    }

    @Override // s5.c, java.lang.Runnable
    public final void run() {
        this.f13707q.getClass();
        CookieHandler r8 = CookieHandler.getDefault();
        if (r8 != null) goto L5;
        Logger.e("ShareCookieHostsSync", "Default CookieHandler is null.");
        return;
    L5:
        ArrayList r10 = g.a(this.f13705o);
        ArrayList r11 = g.a(this.f13706p);
        ArrayList r12 = new ArrayList();
        ArrayList r13 = new ArrayList();
        Iterator r14 = r11.iterator();
    L7:
        if (r14.hasNext() == false) goto L13;
        String r15 = (String) r14.next();
        if (defpackage.c.O(r15, r10) == true) goto L10;
        Logger.d("ShareCookieHostsSync", "added hosts add: " + r15);
        r13.add(r15);
        goto L7
    L10:
        Logger.d("ShareCookieHostsSync", "kept hosts add: " + r15);
        r12.add(r15);
        goto L7
    L13:
        if (r13.isEmpty() == false) goto L16;
        return;
    L16:
        if (r12.isEmpty() == false) goto L19;
        r12 = r13;
    L19:
        Map<String, List<String>> r16 = new HashMap();
        Iterator r17 = r12.iterator();
    L21:
        if (r17.hasNext() == false) goto L29;
        String r18 = (String) r17.next();
        r16 = r8.get(new URI("https://" + r18 + "/"), null);     // Catch: Throwable -> L27
        if (r16.size() <= 0) goto L21;
        Logger.d("ShareCookieHostsSync", "Sync cookie from host: " + r18 + " sync cookies: " + r16.toString());     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        th.printStackTrace();
    L29:
        if (r16 != null) goto L31;
        return;
    L31:
        if (r16.isEmpty() == true) goto L99;
        List<String> r19 = r16.get("Cookie");
        if (r19 != null) goto L36;
    L37:
        r19 = r16.get("cookie");
        if (r19 != null) goto L40;
        return;
    L40:
        if (r19.isEmpty() == true) goto L100;
    L42:
        LinkedHashMap r110 = new LinkedHashMap();
        ArrayList r20 = new ArrayList();
        Iterator<String> r21 = r19.iterator();
    L44:
        if (r21.hasNext() == false) goto L51;
        String[] r22 = r21.next().split(";");
        int r23 = r22.length;
        int r24 = 0;
    L46:
        if (r24 >= r23) goto L44;
        String r25 = r22[r24];
        if (r5.f.b(r25) == true) goto L50;
        r20.add(r25.trim());
    L50:
        r24 = r24 + 1;
        goto L46
    L51:
        Iterator r26 = r13.iterator();
    L53:
        if (r26.hasNext() == false) goto L101;
        String r27 = (String) r26.next();
        ArrayList r28 = new ArrayList();
        URI r29 = new URI("https://" + r27 + "/");     // Catch: Throwable -> L63
        Iterator r30 = r20.iterator();     // Catch: Throwable -> L63
    L57:
        if (r30.hasNext() == false) goto L61;
        String r31 = (String) r30.next();     // Catch: Throwable -> L63
        if (r5.f.b(r31) == true) goto L57;
        r28.add(r31 + "; Domain=" + r27);     // Catch: Throwable -> L63
        goto L57
    L61:
        r110.put("Set-Cookie", r28);     // Catch: Throwable -> L63
        r8.put(r29, r110);     // Catch: Throwable -> L63
    L63:
        th = move-exception;
        th.printStackTrace();
        goto L53
    L101:
        return;
    L100:
        return;
    L36:
        if (r19.isEmpty() == false) goto L42;
    }
}
