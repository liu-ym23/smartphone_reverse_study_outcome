package l0;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f10764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, i> f10765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, i> f10766c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f10767d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f10768e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f10769f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f10770g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f10771h;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f10772a = null;

        static {
            f10772a = new c();
        }

        static /* synthetic */ c a() {
            return f10772a;
        }
    }

    public c() {
        this.f10767d = 50;
        this.f10768e = 20;
        this.f10769f = 50;
        this.f10770g = Math.min(3, 50 / 2);
        this.f10771h = 0;
    }

    public static c d() {
        return a.a();
    }

    public synchronized void a(long r11, String r13, String r14) {
        monitor-enter(this);
    L44:
        th = move-exception;
        throw th;
    L4:
        if (this.f10766c != null) goto L7;
        this.f10766c = new HashMap();     // Catch: Throwable -> L44
    L7:
        if (this.f10766c.containsKey(r13) == false) goto L11;
        i r12 = this.f10766c.get(r13);     // Catch: Throwable -> L44
        r12.f10823i++;     // Catch: Throwable -> L44
        r12.f10824j = System.currentTimeMillis();     // Catch: Throwable -> L44
        int r15 = r12.f10823i;     // Catch: Throwable -> L44
        if (r15 <= this.f10771h) goto L42;
        this.f10771h = r15;     // Catch: Throwable -> L44
    L42:
        monitor-exit(this);
        return;
    L11:
        Map<String, i> r10 = this.f10765b;     // Catch: Throwable -> L44
        if (r10 == null) goto L41;
        long r16 = Long.MAX_VALUE;
        String r17 = null;
        if (r10.containsKey(r13) == false) goto L31;
        i r18 = this.f10765b.get(r13);     // Catch: Throwable -> L44
        int r19 = r18.f10823i;     // Catch: Throwable -> L44
        r18.f10823i = r19 + 1;     // Catch: Throwable -> L44
        r18.f10824j = System.currentTimeMillis();     // Catch: Throwable -> L44
        if (r19 <= this.f10770g) goto L42;
        this.f10765b.remove(r13);     // Catch: Throwable -> L44
        if (this.f10766c.size() < this.f10768e) goto L29;
        long r20 = this.f10764a + ((System.currentTimeMillis() - this.f10764a) / 2);     // Catch: Throwable -> L44
        Iterator<Map.Entry<String, i>> r110 = this.f10766c.entrySet().iterator();     // Catch: Throwable -> L44
    L21:
        if (r110.hasNext() == false) goto L27;
        Map.Entry<String, i> r111 = r110.next();     // Catch: Throwable -> L44
        if (r111.getValue().f10824j >= r20) goto L21;
        if (r111.getValue().f10823i >= r16) goto L21;
        long r21 = r111.getValue().f10823i;     // Catch: Throwable -> L44
        r17 = r111.getValue().f10820c;     // Catch: Throwable -> L44
        r16 = r21;
        goto L21
    L27:
        if (r17 == null) goto L29;
        this.f10766c.remove(r17);     // Catch: Throwable -> L44
    L29:
        this.f10766c.put(r13, r18);     // Catch: Throwable -> L44
        goto L42
    L31:
        if (this.f10765b.size() < this.f10767d) goto L40;
        Iterator<Map.Entry<String, i>> r22 = this.f10765b.entrySet().iterator();     // Catch: Throwable -> L44
    L34:
        if (r22.hasNext() == false) goto L38;
        Map.Entry<String, i> r23 = r22.next();     // Catch: Throwable -> L44
        if (r23.getValue().f10824j >= r16) goto L34;
        r16 = r23.getValue().f10824j;     // Catch: Throwable -> L44
        r17 = r23.getValue().f10820c;     // Catch: Throwable -> L44
        goto L34
    L38:
        if (r17 == null) goto L40;
        this.f10765b.remove(r17);     // Catch: Throwable -> L44
    L40:
        this.f10765b.put(r13, new i(r13, r11, r14));     // Catch: Throwable -> L44
        goto L42
    L41:
        HashMap r24 = new HashMap();     // Catch: Throwable -> L44
        this.f10765b = r24;     // Catch: Throwable -> L44
        r24.put(r13, new i(r13, r11, r14));     // Catch: Throwable -> L44
        goto L42
    }

    public void b() {
        this.f10764a = 0;
        this.f10771h = 0;
        Map<String, i> r10 = this.f10765b;
        if (r10 == null) goto L5;
        r10.clear();
        this.f10765b = null;
    L5:
        Map<String, i> r11 = this.f10766c;
        if (r11 == null) goto L9;
        r11.clear();
        this.f10766c = null;
        return;
    }

    public synchronized Map<String, i> c() {
        monitor-enter(this);
        Map<String, i> r10 = this.f10766c;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public int e() {
        return this.f10771h;
    }
}
