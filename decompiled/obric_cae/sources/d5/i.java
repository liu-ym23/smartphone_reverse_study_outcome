package d5;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;
import x4.j0;
import x4.x0;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f6793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f6795c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f6796d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f6797e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j0 f6798f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final x4.s f6799g;

    public i(Context r8, x4.s r10, j0 r11) {
        this.f6793a = new LinkedHashMap(32);
        this.f6794b = false;
        this.f6795c = new JSONObject();
        this.f6797e = r8;
        this.f6799g = r10;
        this.f6798f = r11;
    }

    public final synchronized boolean a() {
        monitor-enter(this);
    L38:
        th = move-exception;
        throw th;
    L4:
        if (this.f6796d == false) goto L9;
        Objects.toString(this.f6795c);     // Catch: Throwable -> L38
        int r8 = x4.r.f13543a;     // Catch: Throwable -> L38
        monitor-exit(this);
        return true;
    L9:
        if (this.f6794b == true) goto L11;
        this.f6794b = true;     // Catch: Throwable -> L38
        this.f6793a.put(e.class, new e());     // Catch: Throwable -> L38
        this.f6793a.put(o.class, new o(this.f6797e));     // Catch: Throwable -> L38
        this.f6793a.put(s.class, new s(this.f6797e));     // Catch: Throwable -> L38
        this.f6793a.put(v.class, new v());     // Catch: Throwable -> L38
        this.f6793a.put(r.class, new r(this.f6797e, this.f6798f));     // Catch: Throwable -> L38
        this.f6793a.put(y.class, new y(this.f6798f));     // Catch: Throwable -> L38
        this.f6793a.put(n.class, new n(this.f6799g, this.f6798f));     // Catch: Throwable -> L38
        this.f6793a.put(p.class, new p());     // Catch: Throwable -> L38
    L11:
        JSONObject r10 = this.f6795c;     // Catch: Throwable -> L38
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L38
        x0.d(r11, r10);     // Catch: Throwable -> L38
        Iterator r12 = this.f6793a.values().iterator();     // Catch: Throwable -> L38
        boolean r13 = true;
    L13:
        if (r12.hasNext() == false) goto L35;
        d r14 = (d) r12.next();     // Catch: Throwable -> L38
        boolean r15 = false;
        if (r14.f6786a == true) goto L17;
    L43:
        r14.b(r11);     // Catch: JSONException -> L28 SecurityException -> L41 Throwable -> L38
        r14.f6786a = r14.a(r11);     // Catch: JSONException -> L28 SecurityException -> L41 Throwable -> L38
    L28:
        int r16 = x4.r.f13543a;     // Catch: Throwable -> L38
    L30:
        if (r14.f6786a == false) goto L32;
    L33:
        r15 = true;
    L34:
        r13 = r13 & r15;     // Catch: Throwable -> L38
        this.f6795c = r11;     // Catch: Throwable -> L38
        Objects.toString(this.f6795c);     // Catch: Throwable -> L38
        int r17 = x4.r.f13543a;     // Catch: Throwable -> L38
        this.f6796d = r13;     // Catch: Throwable -> L38
        goto L13
    L32:
        if (r14.f6787b == false) goto L34;
    L17:
        if (r14.f6788c == true) goto L43;
        if (x0.f(this.f6798f.f13465c) == false) goto L21;
    L23:
        boolean r18 = false;
    L24:
        int r19 = x4.r.f13543a;     // Catch: Throwable -> L38
        if (r18 == false) goto L30;
    L21:
        if (r14.f6789d == false) goto L23;
        r18 = true;
        goto L24
    L35:
        boolean r20 = this.f6796d;     // Catch: Throwable -> L38
        monitor-exit(this);
        return r20;
    }
}
