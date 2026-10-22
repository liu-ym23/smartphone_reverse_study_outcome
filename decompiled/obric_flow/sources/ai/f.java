package ai;

import android.os.SystemClock;
import com.bytedance.retrofit2.client.Request;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements ei.b, n, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l0 f204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile bi.f f205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Request f206c;
    public volatile boolean d;
    public Throwable e;
    public volatile boolean f;
    public volatile long g;

    public f(l0 r5) {
        this.f204a = r5;
    }

    @Override // ai.n
    public final void doCollect() {
        if ((this.f205b instanceof n) == false) goto L6;
        ((n) this.f205b).doCollect();
        return;
    }

    @Override // ai.o
    public final Object getRequestInfo() {
        if ((this.f205b instanceof o) == false) goto L7;
        ((o) this.f205b).getRequestInfo();
        return null;
    L7:
        return null;
    }

    @Override // ei.b
    public final q0 intercept(ei.a r10) {
        com.bumptech.glide.load.engine.bitmap_recycle.f r11 = (com.bumptech.glide.load.engine.bitmap_recycle.f) r10;
        i0 r5 = (i0) r11.f;
        if (r5 == null) goto L5;
        r5.f220h = System.currentTimeMillis();
    L5:
        long r12 = SystemClock.uptimeMillis();
        this.f206c = (Request) r11.d;
        monitor-enter(this);
    L72:
        th = move-exception;
        throw th;
    L8:
        if (this.f == true) goto L75;
        this.f = true;     // Catch: Throwable -> L72
        monitor-exit(this);     // Catch: Throwable -> L72
        Throwable r13 = this.e;
        if (r13 != null) goto L14;
        this.f206c.setMetrics(r5);
        this.f204a.getClass();
        Request r14 = this.f206c;     // Catch: Throwable -> L24 Throwable -> L26
        this.f205b = this.f204a.f265a.get().b(r14);     // Catch: Throwable -> L24 Throwable -> L26
        if (this.g <= 0) goto L29;
        this.f205b.a(this.g);     // Catch: Throwable -> L24 Throwable -> L26
    L29:
        if (this.d == false) goto L31;
        this.f205b.cancel();
    L31:
        if (r5 == null) goto L33;
        r5.f234w.put("CallServerInterceptor", Long.valueOf(SystemClock.uptimeMillis() - r12));
    L33:
        bi.f r15 = this.f205b;
        if (r5 == null) goto L36;
        r5.s = SystemClock.uptimeMillis();
    L36:
        bi.e r16 = r15.execute();
        this.f204a.getClass();
        long r17 = SystemClock.uptimeMillis();
        fi.i r18 = (fi.i) r16.e;
        int r19 = r16.f930b;
        if (r19 >= 200) goto L39;
    L53:
        if (r18 == null) goto L63;
        if (r16.w() == true) goto L61;
        q0 r20 = new q0(r16, null);
    L57:
        if (r5 == null) goto L59;
        r5.f235x.put("CallServerInterceptor", Long.valueOf(SystemClock.uptimeMillis() - r17));
    L59:
        return r20;
    L61:
        throw new IllegalArgumentException("rawResponse should not be successful response");
    L63:
        throw new NullPointerException("body == null");
    L39:
        if (r19 >= 300) goto L53;
        if (r19 != 204) goto L44;
    L52:
        r20 = q0.a(r16, null);
        goto L57
    L44:
        if (r19 == 205) goto L52;
        if (r5 == null) goto L48;
        r5.f232u = SystemClock.uptimeMillis();
    L48:
        Object r21 = this.f204a.f271k.convert(r18);
        if (r5 == null) goto L51;
        r5.f233v = SystemClock.uptimeMillis();
    L51:
        r20 = q0.a(r16, r21);
    L26:
        e = move-exception;
        this.e = e;
        throw e;
    L24:
        th = move-exception;
        this.e = th;
        if ((th instanceof Exception) == false) goto L69;
        throw th;
    L69:
        throw new Exception(th);
    L14:
        if ((r13 instanceof IOException) == false) goto L18;
        throw ((IOException) r13);
    L18:
        throw new Exception(this.e);
    L75:
        throw new IllegalStateException("Already executed.");     // Catch: Throwable -> L72
    }
}
