package u3;

import android.annotation.SuppressLint;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import x4.a0;
import x4.h;
import x4.i0;
import x4.j;
import x4.j0;
import x4.k;
import x4.u;
import x4.v;

/* JADX INFO: loaded from: classes.dex */
public final class e implements g, a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    public volatile k f12436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile j0 f12437b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile f f12438c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r3.c f12439d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile j f12440e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConcurrentHashMap<String, Object> f12441f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public i0 f12442g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f12443h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f12444i;

    public static class a implements a0, u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a0 f12445a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b f12446b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public JSONObject f12447c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public i0 f12448d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f12449e;

        public a(e r8, y3.c.a r10) {
            this.f12449e = false;
            this.f12445a = r8;
            this.f12446b = r10;
        }

        @Override // x4.a0
        public final void a(i0 r8) {
            this.f12445a.a(r8);
            this.f12448d = r8;
            c();
        }

        @Override // x4.u
        public final void b(JSONObject r8) {
            this.f12447c = r8;
            c();
        }

        public final void c() {
            monitor-enter(this);
        L19:
            th = move-exception;
            throw th;
        L4:
            if (this.f12449e == false) goto L9;
            b r8 = this.f12446b;     // Catch: Throwable -> L19
            JSONObject r10 = this.f12447c;     // Catch: Throwable -> L19
            y3.c.a r11 = (y3.c.a) r8;     // Catch: Throwable -> L19
            r11.f13951a.C |= 4;     // Catch: Throwable -> L19
            y3.c r12 = r11.f13951a;     // Catch: Throwable -> L19
            r12.f13942r.e(r10);     // Catch: Throwable -> L19
            if ((r12.C & 8) != 0) goto L8;
            r12.f13947w.removeMessages(2);     // Catch: Throwable -> L19
            r12.f13947w.sendEmptyMessage(2);     // Catch: Throwable -> L19
        L8:
            r11.f13951a.f13937m.H.g(0, y3.c.G, "bdinstall onUpdate", new Object[0]);     // Catch: Throwable -> L19
        L17:
            monitor-exit(this);     // Catch: Throwable -> L19
            return;
        L9:
            JSONObject r13 = this.f12447c;     // Catch: Throwable -> L19
            if (r13 == null) goto L17;
            if (this.f12448d == null) goto L17;
            this.f12449e = true;     // Catch: Throwable -> L19
            y3.c.a r14 = (y3.c.a) this.f12446b;     // Catch: Throwable -> L19
            r14.f13951a.C |= 2;     // Catch: Throwable -> L19
            y3.c r15 = r14.f13951a;     // Catch: Throwable -> L19
            r15.f13942r.e(r13);     // Catch: Throwable -> L19
            if ((r15.C & 8) != 0) goto L16;
            r15.f13947w.removeMessages(2);     // Catch: Throwable -> L19
            r15.f13947w.sendEmptyMessage(2);     // Catch: Throwable -> L19
        L16:
            r14.f13951a.f13937m.H.g(0, y3.c.G, "bdinstall onLoad", new Object[0]);     // Catch: Throwable -> L19
            goto L17
        }
    }

    public interface b {
    }

    public e(r3.c r8) {
        this.f12436a = new k();
        this.f12441f = new ConcurrentHashMap();
        this.f12439d = r8;
    }

    @Override // x4.a0
    public final void a(i0 r8) {
        this.f12442g = r8;
    }

    public final v b() {
        if (this.f12440e != null) goto L21;
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L6:
        if (this.f12440e != null) goto L15;
        r3.c r8 = this.f12439d;     // Catch: Throwable -> L17
        if (r3.a.f11390a != r8) goto L10;
        boolean r10 = true;
    L11:
        if (r10 == false) goto L13;
        j r11 = h.f13430b;     // Catch: Throwable -> L17
    L14:
        this.f12440e = r11;     // Catch: Throwable -> L17
        goto L15
    L13:
        y4.a r12 = h.f13429a;     // Catch: Throwable -> L17
        r11 = new j();     // Catch: Throwable -> L17
        goto L14
    L10:
        r10 = false;
    L15:
        monitor-exit(this);     // Catch: Throwable -> L17
    L21:
        return this.f12440e;
    }
}
