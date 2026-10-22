package com.bytedance.frameworks.baselib.network.http.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class h implements d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f1665c = "h";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map<String, String> f1666d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f1667e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SharedPreferences f1668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<URI, Set<SerializableHttpCookie>> f1669b;

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ h f1670c;

        a(h r10) {
            this.f1670c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            h.c(this.f1670c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            th.printStackTrace();
        }
    }

    static {
        f1666d = new LinkedHashMap();
    }

    public h(Context r10) {
        this.f1669b = new LinkedHashMap();
        String r11 = f1667e;
        if (r11 != null) goto L6;
        r11 = "cookieStore";
    L6:
        if (Build.VERSION.SDK_INT >= 11) goto L8;
        int r12 = 0;
    L9:
        SharedPreferences r13 = r10.getSharedPreferences(r11, r12);
        this.f1668a = r13;
        h(r13.getAll(), true);
        h(f1666d, false);
        return;
    L8:
        r12 = 4;
        goto L9
    }

    static /* synthetic */ void c(h r10) {
        r10.k();
    }

    private boolean d(String r10, String r11) {
        if (r10 == null) goto L16;
        if (r11 != null) goto L7;
        return false;
    L7:
        if (r11.length() >= r10.length()) goto L11;
        return r10.equalsIgnoreCase("." + r11);
    L11:
        if (r11.equalsIgnoreCase(r10) == false) goto L13;
    L14:
        return true;
    L13:
        if (r11.toLowerCase().endsWith("." + r10.toLowerCase()) == true) goto L14;
        return false;
    L16:
        return false;
    }

    private boolean e(String r10, String r11) {
        if (r11.equals(r10) == true) goto L13;
        if (r11.startsWith(r10) == false) goto L9;
        if (r10.charAt(r10.length() - 1) == '/') goto L13;
    L9:
        if (r11.startsWith(r10) == true) goto L11;
        return false;
    L11:
        if (r11.substring(r10.length()).charAt(0) == '/') goto L13;
        return false;
    L13:
        return true;
    }

    private static URI f(URI r10, f r11) {
        if (r11.y() == null) goto L18;
        String r12 = r11.y();
        if (r12.charAt(0) != '.') goto L16;
        r12 = r12.substring(1);
    L16:
    L13:
        e = move-exception;
        Log.w(f1665c, e);
        return r10;
    L8:
        if (r11.C() != null) goto L10;
        String r13 = "/";
    L11:
        return new URI("http", r12, r13, null);
    L10:
        r13 = r11.C();     // Catch: URISyntaxException -> L13
        goto L11
    L18:
        return r10;
    }

    private List<f> g(URI r10) {
        ArrayList r11 = new ArrayList();
        Iterator<URI> r12 = this.f1669b.keySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L13;
        URI r13 = r12.next();
        if (d(r13.getHost(), r10.getHost()) == false) goto L4;
        String r14 = r10.getPath();
        if (TextUtils.isEmpty(r14) == false) goto L11;
        r14 = "/";
    L11:
        if (e(r13.getPath(), r14) == false) goto L4;
        r11.addAll(this.f1669b.get(r13));
        goto L4
    L13:
        ArrayList r15 = new ArrayList();
        ArrayList r16 = new ArrayList();
        Iterator r17 = r11.iterator();
    L15:
        if (r17.hasNext() == false) goto L21;
        SerializableHttpCookie r18 = (SerializableHttpCookie) r17.next();
        if (r18.hasExpired() == true) goto L18;
        r15.add(r18.getHttpCookie());
        goto L15
    L18:
        r16.add(r18);
        goto L15
    L21:
        if (r16.isEmpty() == true) goto L23;
        i(r10, r16);
    L23:
        return r15;
    }

    private synchronized void h(Map<String, ?> r10, boolean r11) {
        monitor-enter(this);
        if (r10 != null) goto L35;
    L29:
        monitor-exit(this);
        return;
    L35:
    L26:
        th = move-exception;
        throw th;
    L5:
        if (r10.isEmpty() == true) goto L29;
        Iterator<Map.Entry<String, ?>> r12 = r10.entrySet().iterator();     // Catch: Throwable -> L22
    L9:
        if (r12.hasNext() == false) goto L19;
        Map.Entry<String, ?> r13 = r12.next();     // Catch: Throwable -> L22
        URI r14 = new URI(r13.getKey().split("\\|", 2)[0]);     // Catch: URISyntaxException -> L17 Throwable -> L22
        SerializableHttpCookie r15 = SerializableHttpCookie.decode((String) r13.getValue());     // Catch: URISyntaxException -> L17 Throwable -> L22
        Set<SerializableHttpCookie> r16 = this.f1669b.get(r14);     // Catch: URISyntaxException -> L17 Throwable -> L22
    L12:
        if (r16 != null) goto L14;
        r16 = new HashSet();     // Catch: URISyntaxException -> L17 Throwable -> L22
        this.f1669b.put(r14, r16);     // Catch: URISyntaxException -> L17 Throwable -> L22
    L14:
        if (r15 == null) goto L9;
        r16.add(r15);     // Catch: URISyntaxException -> L17 Throwable -> L22
    L17:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L22
        goto L9
    L19:
        if (r11 == false) goto L24;
        r1.c.b(new a(this));     // Catch: Throwable -> L22
    L24:
        monitor-exit(this);
        return;
    L22:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L26
        goto L24
    }

    private void i(URI r10, List<SerializableHttpCookie> r11) {
        SharedPreferences.Editor r12 = this.f1668a.edit();
        Iterator<SerializableHttpCookie> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        String r14 = r10.toString() + "|" + r13.next().getHttpCookie().B();
        r12.remove(r14);
        f1666d.remove(r14);
        goto L4
    L6:
        r12.apply();
    }

    private void j(URI r10, SerializableHttpCookie r11) {
        String r12 = r10.toString() + "|" + r11.getHttpCookie().B();
        String r13 = r11.encode();
        if (r11.getHttpCookie().A() <= 0) goto L5;
        SharedPreferences.Editor r14 = this.f1668a.edit();
        r14.putString(r12, r13);
        r14.apply();
        return;
    L5:
        f1666d.put(r12, r13);
    }

    private synchronized void k() {
        monitor-enter(this);
        Map<URI, Set<SerializableHttpCookie>> r10 = this.f1669b;     // Catch: Throwable -> L90
        if (r10 != null) goto L6;
    L88:
        monitor-exit(this);
        return;
    L6:
        if (r10.isEmpty() == true) goto L88;
        LinkedHashMap r11 = new LinkedHashMap();     // Catch: Throwable -> L90
        Iterator<Map.Entry<URI, Set<SerializableHttpCookie>>> r12 = this.f1669b.entrySet().iterator();     // Catch: Throwable -> L90
    L10:
        if (r12.hasNext() == false) goto L20;
        Map.Entry<URI, Set<SerializableHttpCookie>> r13 = r12.next();     // Catch: Throwable -> L90
        if (r13 == null) goto L10;
        URI r14 = r13.getKey();     // Catch: Throwable -> L90
        if (r14.getScheme() == null) goto L10;
        if (r14.getScheme().equals("https") == false) goto L10;
        r11.put(r13.getKey(), r13.getValue());     // Catch: Throwable -> L90
        goto L10
    L20:
        if (r11.isEmpty() == false) goto L23;
        monitor-exit(this);
        return;
    L23:
        Iterator r15 = r11.entrySet().iterator();     // Catch: Throwable -> L90
    L25:
        if (r15.hasNext() == false) goto L94;
        Map.Entry r16 = (Map.Entry) r15.next();     // Catch: Throwable -> L90
        if (r16 == null) goto L25;
        URI r17 = (URI) r16.getKey();     // Catch: Throwable -> L90
        Set<SerializableHttpCookie> r18 = (Set) r16.getValue();     // Catch: Throwable -> L90
        URI r19 = new URI(r17.toString().replace("https:", "http:"));     // Catch: Throwable -> L62
        Set<SerializableHttpCookie> r20 = this.f1669b.get(r19);     // Catch: Throwable -> L62
    L31:
        if (r20 == null) goto L60;
        if (r20.isEmpty() == true) goto L60;
        LinkedHashSet r21 = new LinkedHashSet();     // Catch: Throwable -> L62
        Iterator<SerializableHttpCookie> r22 = r20.iterator();     // Catch: Throwable -> L62
    L37:
        if (r22.hasNext() == false) goto L52;
        SerializableHttpCookie r23 = r22.next();     // Catch: Throwable -> L62
        boolean r24 = false;
        Iterator<SerializableHttpCookie> r25 = r18.iterator();     // Catch: Throwable -> L62
    L40:
        if (r25.hasNext() == false) goto L50;
        SerializableHttpCookie r26 = r25.next();     // Catch: Throwable -> L62
        if (r23 == null) goto L40;
        if (r26 == null) goto L40;
        if (r23.getHttpCookie().equals(r26.getHttpCookie()) == false) goto L40;
        if (r26.getWhenCreated().longValue() < r23.getWhenCreated().longValue()) goto L40;
        r21.add(r26);     // Catch: Throwable -> L62
        r24 = true;
        goto L40
    L50:
        if (r24 == true) goto L37;
        r21.add(r23);     // Catch: Throwable -> L62
        goto L37
    L52:
        Iterator<SerializableHttpCookie> r27 = r18.iterator();     // Catch: Throwable -> L62
    L54:
        if (r27.hasNext() == false) goto L59;
        SerializableHttpCookie r28 = r27.next();     // Catch: Throwable -> L62
        if (r21.contains(r28) == true) goto L54;
        r21.add(r28);     // Catch: Throwable -> L62
        goto L54
    L59:
        this.f1669b.remove(r17);     // Catch: Throwable -> L62
        this.f1669b.put(r19, r21);     // Catch: Throwable -> L62
    L60:
        this.f1669b.remove(r17);     // Catch: Throwable -> L62
        this.f1669b.put(r19, r18);     // Catch: Throwable -> L62
    L62:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L90
        goto L25
    L94:
        Map<URI, Set<SerializableHttpCookie>> r29 = this.f1669b;     // Catch: Throwable -> L84
        if (r29 != null) goto L68;
    L82:
        monitor-exit(this);
        return;
    L68:
        if (r29.isEmpty() == true) goto L82;
        SharedPreferences.Editor r30 = this.f1668a.edit();     // Catch: Throwable -> L84
        r30.clear();     // Catch: Throwable -> L84
        Iterator<Map.Entry<URI, Set<SerializableHttpCookie>>> r31 = this.f1669b.entrySet().iterator();     // Catch: Throwable -> L84
    L72:
        if (r31.hasNext() == false) goto L80;
        Map.Entry<URI, Set<SerializableHttpCookie>> r32 = r31.next();     // Catch: Throwable -> L84
        URI r33 = r32.getKey();     // Catch: Throwable -> L84
        Iterator<SerializableHttpCookie> r34 = r32.getValue().iterator();     // Catch: Throwable -> L84
    L75:
        if (r34.hasNext() == false) goto L72;
        SerializableHttpCookie r35 = r34.next();     // Catch: Throwable -> L84
        String r36 = r33.toString() + "|" + r35.getHttpCookie().B();     // Catch: Throwable -> L84
        String r37 = r35.encode();     // Catch: Throwable -> L84
        if (r35.getHttpCookie().A() > 0) goto L78;
        f1666d.put(r36, r37);     // Catch: Throwable -> L84
        goto L75
    L78:
        r30.putString(r36, r37);     // Catch: Throwable -> L84
        goto L75
    L80:
        t1.a.a(r30);     // Catch: Throwable -> L84
    L86:
        monitor-exit(this);
        return;
    L84:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L90
    L90:
        th = move-exception;
        throw th;
    }

    public static void l() {
        f1667e = "ttnetCookieStore";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.d
    public synchronized void a(URI r10, f r11) {
        monitor-enter(this);
        URI r12 = f(r10, r11);     // Catch: Throwable -> L10
        Set<SerializableHttpCookie> r13 = this.f1669b.get(r12);     // Catch: Throwable -> L10
        SerializableHttpCookie r14 = new SerializableHttpCookie(r11);     // Catch: Throwable -> L10
        if (r13 != null) goto L6;
        r13 = new HashSet();     // Catch: Throwable -> L10
        this.f1669b.put(r12, r13);     // Catch: Throwable -> L10
    L7:
        r13.add(r14);     // Catch: Throwable -> L10
        j(r12, r14);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L6:
        r13.remove(r14);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.d
    public synchronized List<f> b(URI r10) {
        monitor-enter(this);
        List<f> r11 = g(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r11;
    L6:
        th = move-exception;
        throw th;
    }
}
