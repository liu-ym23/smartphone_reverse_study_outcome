package h3;

import android.os.Process;
import com.bytedance.framwork.core.sdklib.apm6.j;
import j3.c;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile a f9156c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<Long, ConcurrentHashMap<Long, JSONObject>> f9157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f9158b;

    public a() {
        this.f9157a = new ConcurrentHashMap();
        this.f9158b = false;
    }

    private synchronized void a() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f9158b == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.f9158b = true;     // Catch: Throwable -> L11
        b.e().b();     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    private String b(long r10, long r11) {
        return r10 + "_" + r11;
    }

    private static long d() {
        return (System.currentTimeMillis() << 16) | ((long) Process.myPid());
    }

    public static a e() {
        if (f9156c != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f9156c != null) goto L9;
        f9156c = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f9156c;
    }

    public JSONObject c(long r10, long r11) {
        ConcurrentHashMap<Long, JSONObject> r12 = this.f9157a.get(Long.valueOf(r10));
        if (r12 != null) goto L5;
    L8:
        JSONObject r13 = b.e().d(b(r10, r11));
        if (j.f() == false) goto L12;
        c.a("APM-SDK", "header init:" + r10 + ":" + r11 + " " + b(r10, r11));
    L12:
        if (this.f9157a.containsKey(Long.valueOf(r10)) == true) goto L14;
        this.f9157a.put(Long.valueOf(r10), new ConcurrentHashMap());
    L14:
        if (r13 == null) goto L16;
        this.f9157a.get(Long.valueOf(r10)).put(Long.valueOf(r11), r13);
    L17:
        if (r13 != null) goto L19;
        c.b("APM-SDK", "header==null " + r10);
    L19:
        return r13;
    L16:
        r13 = j.e(r10);
        goto L17
    L5:
        if (r12.containsKey(Long.valueOf(r11)) == false) goto L8;
        return r12.get(Long.valueOf(r11));
    }

    public long f(long r10, JSONObject r11) {
        long r12 = d();
        if (this.f9157a.containsKey(Long.valueOf(r10)) == true) goto L5;
        this.f9157a.put(Long.valueOf(r10), new ConcurrentHashMap());
    L5:
        this.f9157a.get(Long.valueOf(r10)).put(Long.valueOf(r12), r11);
        String r13 = b(r10, r12);
        if (j.f() == false) goto L8;
        c.a("APM-SDK", "header init:" + r10 + ":" + r13 + " " + r11);
    L8:
        b.e().h(r13, l3.b.a(r11));
        a();
        return r12;
    }
}
