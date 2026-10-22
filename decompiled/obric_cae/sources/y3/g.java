package y3;

import c4.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class g extends a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final List<String> f13960f = null;

    static {
        f13960f = Collections.singletonList("ForwardSender");
    }

    public g(c r8, t2.b r10) {
        super(r8);
    }

    @Override // y3.a
    public final synchronized boolean c(int r10) {
        monitor-enter(this);
        long r8 = System.currentTimeMillis();     // Catch: Throwable -> L10
        c r11 = this.f13930a;     // Catch: Throwable -> L10
        j r12 = r11.f13945u;     // Catch: Throwable -> L10
        m r13 = r11.f13937m.H;     // Catch: Throwable -> L10
        List<String> r14 = f13960f;     // Catch: Throwable -> L10
        Object[] r15 = new Object[4];     // Catch: Throwable -> L10
        r15[0] = "ForwardSender";     // Catch: Throwable -> L10
        r15[1] = Long.valueOf(r8);     // Catch: Throwable -> L10
        if (r12 == null) goto L6;
        String r16 = r12.f13979e;     // Catch: Throwable -> L10
    L7:
        r15[2] = r16;     // Catch: Throwable -> L10
        r15[3] = Integer.valueOf(r10);     // Catch: Throwable -> L10
        r13.l(0, r14, "{} start doWork curTs={}, curSid={}, requestFrom={}", r15);     // Catch: Throwable -> L10
        this.f13930a.b();     // Catch: Throwable -> L10
        boolean r17 = this.f13930a.f13942r.f6776c;     // Catch: Throwable -> L10
        monitor-exit(this);
        return false;
    L6:
        r16 = "null";
    L10:
        th = move-exception;
        throw th;
    }

    @Override // y3.a
    public final String d() {
        return "ForwardSender";
    }

    @Override // y3.a
    public final long[] e() {
        return a.f13929e;
    }

    @Override // y3.a
    public final boolean f() {
        return true;
    }

    @Override // y3.a
    public final long g() {
        return this.f13930a.f13938n.b();
    }

    public final void h(ArrayList r8, JSONObject r10, int r11) {
    }
}
