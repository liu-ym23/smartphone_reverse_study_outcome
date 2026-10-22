package gb;

import android.os.SystemClock;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public class b implements nb.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f9033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f9034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f9035c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f9036d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AtomicLong f9037e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<a> f9038f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f9039g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f9040h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f9041i;

    public interface a {
        void b();
    }

    public b(int r10, long r11, int r12) {
        this.f9033a = false;
        this.f9037e = new AtomicLong(0);
        this.f9038f = new CopyOnWriteArrayList();
        this.f9041i = r10;
        this.f9039g = r11;
        this.f9040h = r12;
        if (r11 <= 0) goto L7;
        if (r12 <= 0) goto L8;
        nb.b.d().g(this);
        return;
    L8:
        return;
    }

    private void c(long r10, long r11) {
        if (r11 != 0) goto L5;
        return;
    L5:
        long r12 = r10 / r11;
        if (lb.a.a() == false) goto L9;
        lb.a.g("PCDNBandwidthSampler", this.f9041i, "addSampleImpl", "Speed:" + r12 + " byteDiff:" + r10 + " timeDiff:" + r11);
    L9:
        if (r12 >= this.f9039g) goto L16;
        int r13 = this.f9034b + 1;
        this.f9034b = r13;
        if (r13 <= this.f9040h) goto L19;
        Iterator<a> r14 = this.f9038f.iterator();
    L14:
        if (r14.hasNext() == false) goto L16;
        r14.next().b();
        goto L14
    L19:
        return;
    L16:
        this.f9034b = 0;
    }

    @Override // nb.b.a
    public void a() {
        if (this.f9033a == true) goto L5;
        return;
    L5:
        long r10 = SystemClock.uptimeMillis();
        long r11 = this.f9037e.get();
        long r12 = this.f9035c;
        if (r12 > 0) goto L9;
    L7:
        this.f9035c = r10;
        this.f9036d = r11;
        return;
    L9:
        c(r11 - this.f9036d, r10 - r12);
        goto L7
    }

    public void b(long r10) {
        this.f9037e.addAndGet(r10);
    }

    public void d(a r10) {
        this.f9038f.add(r10);
    }

    public void e() {
        this.f9033a = true;
    }

    public void f() {
        this.f9033a = false;
        nb.b.d().h(this);
    }
}
