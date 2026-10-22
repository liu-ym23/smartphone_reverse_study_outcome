package c7;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.bytedance.bdlocation.client.LocationInfoConst;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class e implements c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LinkedHashMap f3392c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f3393d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f3394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f3395b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f3396a;

        public a(e r8) {
            this.f3396a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            e.b(this.f3396a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            th.printStackTrace();
        }
    }

    static {
        f3392c = new LinkedHashMap();
    }

    public e(Context r8) {
        this.f3395b = new LinkedHashMap();
        String r10 = f3393d;
        if (r10 != null) goto L5;
        r10 = "cookieStore";
    L5:
        SharedPreferences r11 = r8.getSharedPreferences(r10, 4);
        this.f3394a = r11;
        d(r11.getAll(), true);
        d(f3392c, false);
    }

    public static void b(e r14) {
        monitor-enter(r14);
        LinkedHashMap r8 = r14.f3395b;     // Catch: Throwable -> L86
        if (r8 != null) goto L6;
    L84:
        monitor-exit(r14);
        return;
    L6:
        if (r8.isEmpty() == true) goto L84;
        LinkedHashMap r10 = new LinkedHashMap();     // Catch: Throwable -> L86
        Iterator r11 = r14.f3395b.entrySet().iterator();     // Catch: Throwable -> L86
    L10:
        if (r11.hasNext() == false) goto L20;
        Map.Entry r12 = (Map.Entry) r11.next();     // Catch: Throwable -> L86
        if (r12 == null) goto L10;
        URI r13 = (URI) r12.getKey();     // Catch: Throwable -> L86
        if (r13.getScheme() == null) goto L10;
        if (r13.getScheme().equals(LocationInfoConst.HTTPS) == false) goto L10;
        r10.put(r12.getKey(), r12.getValue());     // Catch: Throwable -> L86
        goto L10
    L20:
        if (r10.isEmpty() == true) goto L84;
        Iterator r15 = r10.entrySet().iterator();     // Catch: Throwable -> L86
    L24:
        if (r15.hasNext() == false) goto L90;
        Map.Entry r16 = (Map.Entry) r15.next();     // Catch: Throwable -> L86
        if (r16 == null) goto L24;
        URI r17 = (URI) r16.getKey();     // Catch: Throwable -> L86
        Set r18 = (Set) r16.getValue();     // Catch: Throwable -> L86
        URI r19 = new URI(r17.toString().replace("https:", "http:"));     // Catch: Throwable -> L49
        Set r20 = (Set) r14.f3395b.get(r19);     // Catch: Throwable -> L49
    L30:
        if (r20 == null) goto L61;
        if (r20.isEmpty() == true) goto L61;
        LinkedHashSet r21 = new LinkedHashSet();     // Catch: Throwable -> L49
        Iterator r22 = r20.iterator();     // Catch: Throwable -> L49
    L36:
        if (r22.hasNext() == false) goto L53;
        h r23 = (h) r22.next();     // Catch: Throwable -> L49
        Iterator r24 = r18.iterator();     // Catch: Throwable -> L49
        boolean r25 = false;
    L39:
        if (r24.hasNext() == false) goto L51;
        h r26 = (h) r24.next();     // Catch: Throwable -> L49
        if (r23 == null) goto L39;
        if (r26 == null) goto L39;
        if (r23.f3405a.equals(r26.f3405a) == false) goto L39;
        if (Long.valueOf(r26.f3406b).longValue() < Long.valueOf(r23.f3406b).longValue()) goto L39;
        r21.add(r26);     // Catch: Throwable -> L49
        r25 = true;
        goto L39
    L51:
        if (r25 == true) goto L36;
        r21.add(r23);     // Catch: Throwable -> L49
        goto L36
    L53:
        Iterator r27 = r18.iterator();     // Catch: Throwable -> L49
    L55:
        if (r27.hasNext() == false) goto L60;
        h r28 = (h) r27.next();     // Catch: Throwable -> L49
        if (r21.contains(r28) == true) goto L55;
        r21.add(r28);     // Catch: Throwable -> L49
        goto L55
    L60:
        r14.f3395b.remove(r17);     // Catch: Throwable -> L49
        r14.f3395b.put(r19, r21);     // Catch: Throwable -> L49
    L61:
        r14.f3395b.remove(r17);     // Catch: Throwable -> L49
        r14.f3395b.put(r19, r18);     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L86
        goto L24
    L90:
        LinkedHashMap r29 = r14.f3395b;     // Catch: Throwable -> L82
        if (r29 == null) goto L84;
        if (r29.isEmpty() == true) goto L84;
        SharedPreferences.Editor r30 = r14.f3394a.edit();     // Catch: Throwable -> L82
        r30.clear();     // Catch: Throwable -> L82
        Iterator r31 = r14.f3395b.entrySet().iterator();     // Catch: Throwable -> L82
    L72:
        if (r31.hasNext() == false) goto L80;
        Map.Entry r32 = (Map.Entry) r31.next();     // Catch: Throwable -> L82
        URI r33 = (URI) r32.getKey();     // Catch: Throwable -> L82
        Iterator r34 = ((Set) r32.getValue()).iterator();     // Catch: Throwable -> L82
    L75:
        if (r34.hasNext() == false) goto L72;
        h r35 = (h) r34.next();     // Catch: Throwable -> L82
        String r36 = r33.toString() + "|" + r35.f3405a.f3380o;     // Catch: Throwable -> L82
        String r37 = r35.b();     // Catch: Throwable -> L82
        if (r35.f3405a.f3379n > 0) goto L78;
        f3392c.put(r36, r37);     // Catch: Throwable -> L82
        goto L75
    L78:
        r30.putString(r36, r37);     // Catch: Throwable -> L82
        goto L75
    L80:
        r30.apply();     // Catch: Throwable -> L82
    L82:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L86
    L86:
        th = move-exception;
        throw th;
    }

    @Override // c7.c
    public final synchronized void a(d r8, URI r10) {
        monitor-enter(this);
        String r11 = r8.f3378m;     // Catch: Throwable -> L22
        if (r11 != null) goto L6;
    L15:
        Set r12 = (Set) this.f3395b.get(r10);     // Catch: Throwable -> L22
        h r13 = new h(r8);     // Catch: Throwable -> L22
        if (r12 != null) goto L18;
        r12 = new HashSet();     // Catch: Throwable -> L22
        this.f3395b.put(r10, r12);     // Catch: Throwable -> L22
    L19:
        r12.add(r13);     // Catch: Throwable -> L22
        e(r10, r13);     // Catch: Throwable -> L22
        monitor-exit(this);
        return;
    L18:
        r12.remove(r13);     // Catch: Throwable -> L22
        goto L19
    L6:
        if (r11.charAt(0) != '.') goto L25;
        r11 = r11.substring(1);     // Catch: Throwable -> L22
    L25:
        String r14 = r8.f3381p;     // Catch: URISyntaxException -> L13 Throwable -> L22
        if (r14 != null) goto L11;
        r14 = "/";
    L11:
        r10 = new URI("http", r11, r14, null);     // Catch: URISyntaxException -> L13 Throwable -> L22
        goto L15
    L13:
        e = move-exception;
        Log.w("e", e);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    public final ArrayList c(URI r13) {
        ArrayList r8 = new ArrayList();
        LinkedHashMap r10 = this.f3395b;
        Iterator r11 = r10.keySet().iterator();
    L3:
        boolean r12 = false;
        if (r11.hasNext() == false) goto L26;
        URI r14 = (URI) r11.next();
        String r15 = r14.getHost();
        String r16 = r13.getHost();
        if (r16.equals(r15) == false) goto L8;
    L11:
        boolean r17 = true;
    L12:
        if (r17 == false) goto L3;
        String r18 = r14.getPath();
        String r19 = r13.getPath();
        if (r19.equals(r18) == false) goto L16;
    L23:
        r12 = true;
    L24:
        if (r12 == false) goto L3;
        r8.addAll((Collection) r10.get(r14));
        goto L3
    L16:
        if (r19.startsWith(r18) == false) goto L20;
        if (r18.charAt(r18.length() - 1) == '/') goto L23;
    L20:
        if (r19.startsWith(r18) == false) goto L24;
        if (r19.substring(r18.length()).charAt(0) != '/') goto L24;
    L8:
        if (r16.endsWith("." + r15) == true) goto L11;
        r17 = false;
        goto L12
    L26:
        ArrayList r20 = new ArrayList();
        ArrayList r21 = new ArrayList();
        Iterator r22 = r8.iterator();
    L28:
        if (r22.hasNext() == false) goto L40;
        h r23 = (h) r22.next();
        long r24 = r23.f3405a.f3379n;
        if (r24 != (-1)) goto L33;
    L35:
        boolean r25 = false;
    L36:
        if (r25 == true) goto L37;
        r20.add(r23.f3405a);
        goto L28
    L37:
        r21.add(r23);
        goto L28
    L33:
        if (((System.currentTimeMillis() - r23.f3406b) / 1000) <= r24) goto L35;
        r25 = true;
        goto L36
    L40:
        if (r21.isEmpty() == true) goto L46;
        SharedPreferences.Editor r110 = this.f3394a.edit();
        Iterator r26 = r21.iterator();
    L43:
        if (r26.hasNext() == false) goto L45;
        String r27 = r13.toString() + "|" + ((h) r26.next()).f3405a.f3380o;
        r110.remove(r27);
        f3392c.remove(r27);
        goto L43
    L45:
        r110.apply();
    L46:
        return r20;
    }

    public final synchronized void d(Map<String, ?> r8, boolean r10) {
        monitor-enter(this);
        if (r8 != null) goto L35;
    L29:
        monitor-exit(this);
        return;
    L35:
    L26:
        th = move-exception;
        throw th;
    L5:
        if (r8.isEmpty() == true) goto L29;
        Iterator<Map.Entry<String, ?>> r11 = r8.entrySet().iterator();     // Catch: Throwable -> L22
    L9:
        if (r11.hasNext() == false) goto L19;
        Map.Entry<String, ?> r12 = r11.next();     // Catch: Throwable -> L22
        URI r13 = new URI(r12.getKey().split("\\|", 2)[0]);     // Catch: URISyntaxException -> L17 Throwable -> L22
        h r14 = h.a((String) r12.getValue());     // Catch: URISyntaxException -> L17 Throwable -> L22
        Set r15 = (Set) this.f3395b.get(r13);     // Catch: URISyntaxException -> L17 Throwable -> L22
    L12:
        if (r15 != null) goto L14;
        r15 = new HashSet();     // Catch: URISyntaxException -> L17 Throwable -> L22
        this.f3395b.put(r13, r15);     // Catch: URISyntaxException -> L17 Throwable -> L22
    L14:
        if (r14 == null) goto L9;
        r15.add(r14);     // Catch: URISyntaxException -> L17 Throwable -> L22
    L17:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L22
        goto L9
    L19:
        if (r10 == false) goto L24;
        a r16 = new a(this);     // Catch: Throwable -> L22
        s5.c.f12034b.submit(r16);     // Catch: Throwable -> L22
    L24:
        monitor-exit(this);
        return;
    L22:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L26
        goto L24
    }

    public final void e(URI r8, h r10) {
        StringBuilder r11 = new StringBuilder();
        r11.append(r8.toString());
        r11.append("|");
        d r12 = r10.f3405a;
        r11.append(r12.f3380o);
        String r13 = r11.toString();
        String r14 = r10.b();
        if (r12.f3379n <= 0) goto L5;
        SharedPreferences.Editor r15 = this.f3394a.edit();
        r15.putString(r13, r14);
        r15.apply();
        return;
    L5:
        f3392c.put(r13, r14);
    }

    @Override // c7.c
    public final synchronized List<d> get(URI r8) {
        monitor-enter(this);
        ArrayList r10 = c(r8);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }
}
