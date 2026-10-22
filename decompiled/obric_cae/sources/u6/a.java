package u6;

import com.bytedance.common.utility.Logger;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f12475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f12476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference<u6.b> f12477c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AtomicReference<u6.b> f12478d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList<b> f12479e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f12480f;

    /* JADX INFO: renamed from: u6.a$a, reason: collision with other inner class name */
    public static class C0171a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f12481a = null;

        static {
            f12481a = new a();
        }
    }

    public interface b {
        void h(u6.b r8);
    }

    public a() {
        this.f12475a = new d();
        this.f12476b = false;
        this.f12477c = new AtomicReference(u6.b.f12486o);
        this.f12479e = new ArrayList();
    }

    public final synchronized void a(long r10, long r12) {
        monitor-enter(this);
        double r8 = ((r10 * 1.0d) / r12) * 8.0d;
        if (r12 != 0) goto L7;
    L68:
        monitor-exit(this);
        return;
    L7:
        if (r8 < 3.0d) goto L68;
        if (Logger.debug() == false) goto L12;
        Logger.d("ConnectionClassManager", "bytes = " + r10 + " timeInMs = " + r12 + " bandwidth = " + r8);     // Catch: Throwable -> L70
    L12:
        d r11 = this.f12475a;     // Catch: Throwable -> L70
        r11.getClass();     // Catch: Throwable -> L70
        int r13 = r11.f12498c;     // Catch: Throwable -> L70
        if (r13 <= r11.f12496a) goto L15;
        double r14 = Math.log(r11.f12497b) * 0.95d;     // Catch: Throwable -> L70
        double r15 = Math.log(r8) * 0.05d;     // Catch: Throwable -> L70
    L17:
        r8 = Math.exp(r15 + r14);     // Catch: Throwable -> L70
    L18:
        r11.f12497b = r8;     // Catch: Throwable -> L70
        r11.f12498c++;     // Catch: Throwable -> L70
        if (this.f12476b == false) goto L64;
        this.f12480f++;     // Catch: Throwable -> L70
        int r16 = 0;
        if (b() == this.f12478d.get()) goto L24;
        this.f12476b = false;     // Catch: Throwable -> L70
        this.f12480f = 1;     // Catch: Throwable -> L70
    L24:
        if (this.f12480f < 5.0d) goto L61;
        d r17 = this.f12475a;     // Catch: Throwable -> L70
        if (r17 != null) goto L71;
    L52:
        boolean r18 = false;
    L53:
        if (r18 == false) goto L61;
        this.f12476b = false;     // Catch: Throwable -> L70
        this.f12480f = 1;     // Catch: Throwable -> L70
        this.f12477c.set(this.f12478d.get());     // Catch: Throwable -> L70
        ArrayList<b> r19 = this.f12479e;     // Catch: Throwable -> L70
        int r110 = r19.size();     // Catch: Throwable -> L59
    L56:
        if (r16 >= r110) goto L61;
        r19.get(r16).h(this.f12477c.get());     // Catch: Throwable -> L59
        r16 = r16 + 1;
        goto L56
    L59:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L70
        goto L61
    L71:
        u6.b r111 = this.f12477c.get();     // Catch: Throwable -> L50
        double r20 = 28.0d;
        if (u6.b.f12482a != r111) goto L31;
        double r21 = 0.0d;
    L41:
        double r112 = r17.f12497b;     // Catch: Throwable -> L50
        goto L66
    L43:
        if (r112 <= r20) goto L48;
        if (r112 <= (r20 * 1.25d)) goto L52;
    L49:
        r18 = true;
        goto L53
    L48:
        if (r112 >= (r21 * 0.8d)) goto L52;
    L31:
        r21 = 112.0d;
        if (u6.b.f12483b == r111) goto L40;
        r20 = 560.0d;
        if (u6.b.f12484m == r111) goto L41;
        if (u6.b.f12485n != r111) goto L49;
        r21 = 3.4028234663852886E38d;
    L40:
        double r22 = r20;
        r20 = r21;
        r21 = r22;
    L50:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L70
    L61:
        monitor-exit(this);
        return;
    L64:
        if (this.f12477c.get() == b()) goto L66;
        this.f12476b = true;     // Catch: Throwable -> L70
        this.f12478d = new AtomicReference(b());     // Catch: Throwable -> L70
        goto L66
    L15:
        if (r13 <= 0) goto L18;
        double r113 = r13;
        double r23 = (0.95d * r113) / (r113 + 1.0d);     // Catch: Throwable -> L70
        r14 = Math.log(r11.f12497b) * r23;     // Catch: Throwable -> L70
        r15 = Math.log(r8) * (1.0d - r23);     // Catch: Throwable -> L70
    L66:
        monitor-exit(this);
    }

    public final synchronized u6.b b() {
        monitor-enter(this);
        d r8 = this.f12475a;     // Catch: Throwable -> L28
        if (r8 != null) goto L31;
        u6.b r10 = u6.b.f12486o;     // Catch: Throwable -> L28
        monitor-exit(this);
        return r10;
    L31:
        double r11 = r8.f12497b;     // Catch: Throwable -> L20
        if (r11 >= 0.0d) goto L12;
        u6.b r12 = u6.b.f12486o;     // Catch: Throwable -> L20
    L23:
        monitor-exit(this);
        return r12;
    L12:
        if (r11 >= 28.0d) goto L15;
        r12 = u6.b.f12482a;     // Catch: Throwable -> L20
        goto L23
    L15:
        if (r11 >= 112.0d) goto L18;
        r12 = u6.b.f12483b;     // Catch: Throwable -> L20
        goto L23
    L18:
        if (r11 >= 560.0d) goto L22;
        r12 = u6.b.f12484m;     // Catch: Throwable -> L20
        goto L23
    L22:
        r12 = u6.b.f12485n;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L28
        return u6.b.f12486o;
    L28:
        th = move-exception;
        throw th;
    }
}
