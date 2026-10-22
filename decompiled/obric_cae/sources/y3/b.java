package y3;

import android.app.Application;
import c4.m;
import com.obric.cae.cloud.CloudServiceConstants;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.json.JSONObject;
import x4.o0;

/* JADX INFO: loaded from: classes.dex */
public final class b extends a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final List<String> f13934f = null;

    static {
        f13934f = Collections.singletonList("Configer");
    }

    public b(c r8) {
        long r10 = r8.f13938n.f6761e.getLong("app_log_last_config_time", 0);
        super(r8);
        this.f13933d = r10;
        r3.c r11 = r8.f13937m;
        r11.getClass();
        long r12 = g();
        m r13 = r11.H;
        Object[] r14 = {0L, Long.valueOf(r12), Long.valueOf(this.f13933d)};
        r13.g(0, f13934f, "Configer firstDelay={}, interval={}, nextTime={}, newLastTime={}", r14);
    }

    @Override // y3.a
    public final boolean c(int r13) {
        long r8 = System.currentTimeMillis();
        m r10 = this.f13930a.f13937m.H;
        List<String> r11 = f13934f;
        r10.l(0, r11, "configer start doWork curTs = {}", new Object[]{Long.valueOf(r8)});
        d4.d r12 = this.f13930a.f13942r;
        if (r12.f6776c == false) goto L30;
        JSONObject r14 = r12.a();
        defpackage.c.n0(r14);
        this.f13930a.f13937m.getClass();
        this.f13930a.f13937m.H.g(0, r11, "doRequest start requestFrom = {}", new Object[]{Integer.valueOf(r13)});
        long r15 = System.currentTimeMillis();
        JSONObject r16 = new JSONObject();     // Catch: Throwable -> L23
        r16.put("magic_tag", "ss_app_log");     // Catch: Throwable -> L23
        r16.put(CloudServiceConstants.OCloud.HEADER, r14);     // Catch: Throwable -> L23
        r16.put("_gen_time", System.currentTimeMillis());     // Catch: Throwable -> L23
        JSONObject r17 = new JSONObject();     // Catch: Throwable -> L23
        this.f13930a.f13937m.getClass();     // Catch: Throwable -> L23
        this.f13930a.f13937m.getClass();     // Catch: Throwable -> L23
        if (r17.length() <= 0) goto L8;
        r16.put("options", r17);     // Catch: Throwable -> L23
    L8:
        this.f13930a.f13937m.f11397e.b(r16, false);     // Catch: Throwable -> L23
        r3.c r18 = this.f13930a.f13937m;     // Catch: Throwable -> L23
        Application r19 = r18.f11402j;     // Catch: Throwable -> L23
        String r110 = this.f13930a.d().f11441c;     // Catch: Throwable -> L23
        o0 r111 = o0.f13535a;     // Catch: Throwable -> L23
        JSONObject r20 = this.f13930a.f13937m.f11397e.a(q4.a.c(r18.a(r19, r110), v4.b.f12722d), r16);     // Catch: Throwable -> L23
        c r21 = this.f13930a;     // Catch: Throwable -> L23
        d4.c r22 = r21.f13938n;     // Catch: Throwable -> L23
        v4.a r23 = r21.f13937m.f11408p;     // Catch: Throwable -> L23
        if (r23 == null) goto L19;
        JSONObject r112 = r22.f6762f;     // Catch: Throwable -> L23
        if (r20 == null) goto L14;
        if (r112 == null) goto L14;
        boolean r113 = r20.toString().equals(r112.toString());     // Catch: Throwable -> L23
    L15:
        if (r113 == true) goto L17;
        boolean r114 = true;
    L18:
        r23.onRemoteConfigGet(r114, r20);     // Catch: Throwable -> L23
        goto L19
    L17:
        r114 = false;
    L14:
        r113 = Objects.equals(r20, r112);     // Catch: Throwable -> L23
    L19:
        if (r20 == null) goto L22;
        r22.f(r20);     // Catch: Throwable -> L23
        this.f13930a.f13938n.f6758b.getClass();     // Catch: Throwable -> L23
        this.f13930a.f13937m.H.g(0, r11, "Configer fetch config success", new Object[0]);     // Catch: Throwable -> L23
        this.f13930a.f13937m.H.g(0, r11, "end doWork duration = {}, requestFrom = {}", new Object[]{Long.valueOf(System.currentTimeMillis() - r15), Integer.valueOf(r13)});
        return true;
    L22:
        this.f13930a.f13937m.H.g(0, r11, "end doWork duration = {}, requestFrom = {}", new Object[]{Long.valueOf(System.currentTimeMillis() - r15), Integer.valueOf(r13)});
        return false;
    L23:
        th = move-exception;
        m r24 = this.f13930a.f13937m.H;     // Catch: Throwable -> L27
        List<String> r25 = f13934f;     // Catch: Throwable -> L27
        r24.i(r25, "config error, requestFrom = {}", null, new Object[]{Integer.valueOf(r13), th});     // Catch: Throwable -> L27
        this.f13930a.f13937m.f11417y.g("Configer doRequest error, requestFrom = " + r13, th);     // Catch: Throwable -> L27
        this.f13930a.f13937m.H.g(0, r25, "end doWork duration = {}, requestFrom = {}", new Object[]{Long.valueOf(System.currentTimeMillis() - r15), Integer.valueOf(r13)});
        return false;
    L27:
        th = move-exception;
        this.f13930a.f13937m.H.g(0, f13934f, "end doWork duration = {}, requestFrom = {}", new Object[]{Long.valueOf(System.currentTimeMillis() - r15), Integer.valueOf(r13)});
        throw th;
    L30:
        return false;
    }

    @Override // y3.a
    public final String d() {
        return "configer";
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
        return this.f13930a.f13938n.f6761e.getLong("fetch_interval", 21600000);
    }
}
