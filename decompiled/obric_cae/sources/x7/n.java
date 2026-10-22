package x7;

import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, m> f13664a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, List<String>> f13665b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, List<String>> f13666c = null;

    static {
        f13664a = new ConcurrentHashMap();
        f13665b = new ConcurrentHashMap();
        f13666c = new ConcurrentHashMap();
    }

    public n() {
    }

    public static LinkedList a(List r8) {
        LinkedList r10 = new LinkedList();
        Iterator r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        r10.add(("https://" + new URL((String) r11.next()).getHost()) + "/monitor/collect/");     // Catch: MalformedURLException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L4
    L10:
        return r10;
    }

    public static m b(String r8) {
        if (TextUtils.isEmpty(r8) == true) goto L19;
        ConcurrentHashMap<String, m> r10 = f13664a;
        if (r10.get(r8) != null) goto L17;
        monitor-enter(n.class);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (r10.get(r8) != null) goto L11;
        r10.put(r8, new m(r8));     // Catch: Throwable -> L13
    L11:
        monitor-exit(n.class);     // Catch: Throwable -> L13
    L17:
        return r10.get(r8);
    L19:
        throw new IllegalArgumentException("param 'aid' is not allowed to assigned empty string");
    }

    public static synchronized void c(String r8, List<String> r10) {
        monitor-enter(n.class);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r8) == false) goto L7;
    L20:
        monitor-exit(n.class);
        return;
    L7:
        if (defpackage.c.P(r10) == true) goto L20;
        LinkedList r11 = new LinkedList();     // Catch: Throwable -> L22
        Iterator<String> r12 = r10.iterator();     // Catch: Throwable -> L22
    L11:
        if (r12.hasNext() == false) goto L17;
        r11.add(("https://" + new URL(r12.next()).getHost()) + "/monitor/appmonitor/v3/settings");     // Catch: MalformedURLException -> L15 Throwable -> L22
    L15:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L22
        goto L11
    L17:
        f13666c.put(r8, r11);     // Catch: Throwable -> L22
        monitor-exit(n.class);
    }

    public static synchronized void d(String r8, List<String> r10) {
        monitor-enter(n.class);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r8) == false) goto L7;
    L12:
        monitor-exit(n.class);
        return;
    L7:
        if (defpackage.c.P(r10) == true) goto L12;
        f13665b.put(r8, a(r10));     // Catch: Throwable -> L14
        monitor-exit(n.class);
    }
}
