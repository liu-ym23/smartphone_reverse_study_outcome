package com.bytedance.applog.e;

import android.content.Context;
import com.bytedance.applog.log.j;
import com.bytedance.applog.m;
import com.bytedance.applog.util.l;
import com.bytedance.applog.util.o;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.Level;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class b extends a {
    private static final List<String> f = null;

    static {
        f = Collections.singletonList("Configer");
    }

    b(c r9) {
        super(r9, r9.m().j());
        long r0 = b().bc();
        long r2 = e();
        if (r0 <= 0) goto L7;
        long r4 = (b().aj() + r0) - r2;
        if (r4 <= c()) goto L7;
        a(r4);
    L7:
        b().aA().a(f, "Configer firstDelay={}, interval={}, nextTime={}, newLastTime={}", new Object[]{Long.valueOf(r0), Long.valueOf(r2), Long.valueOf(c())});
    }

    private boolean a(JSONObject r12, int r13) {
        j r2 = b().aA();
        List<String> r3 = f;
        r2.a(r3, "doRequest start requestFrom = {}", new Object[]{Integer.valueOf(r13)});
        long r5 = System.currentTimeMillis();
        JSONObject r8 = new JSONObject();     // Catch: Throwable -> L31
        r8.put(Api.KEY_MAGIC, Api.MSG_MAGIC);     // Catch: Throwable -> L31
        r8.put("header", r12);     // Catch: Throwable -> L31
        r8.put("_gen_time", System.currentTimeMillis());     // Catch: Throwable -> L31
        JSONObject r14 = new JSONObject();     // Catch: Throwable -> L31
        if (b().aQ() == false) goto L7;
        r14.put("params_block_enable", 1);     // Catch: Throwable -> L31
    L7:
        if (b().aR() == false) goto L10;
        r14.put("header_custom_allow_enable", 1);     // Catch: Throwable -> L31
    L10:
        if (r14.length() <= 0) goto L12;
        r8.put("options", r14);     // Catch: Throwable -> L31
    L12:
        b().aw().a(r8, false);     // Catch: Throwable -> L31
        JSONObject r15 = b().aw().a(com.bytedance.applog.m.a.a(b().a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f1568a.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this.f1568a.i().e(), true, Level.L1), com.bytedance.applog.util.f.f1884b), r8);     // Catch: Throwable -> L31
        com.bytedance.applog.k.b r0 = this.f1568a.m();     // Catch: Throwable -> L31
        if (b().ar() == null) goto L19;
        com.bytedance.applog.util.b r9 = b().ar();     // Catch: Throwable -> L31
        if (o.a(r15, r0.h()) == true) goto L17;
        boolean r10 = true;
    L18:
        r9.a(r10, r15);     // Catch: Throwable -> L31
        goto L19
    L17:
        r10 = false;
    L19:
        if (r15 == null) goto L30;
        r0.a(r15);     // Catch: Throwable -> L31
        if (this.f1568a.m().c().J() == true) goto L23;
    L27:
        b().aA().a(r3, "Configer fetch config success", new Object[0]);     // Catch: Throwable -> L31
        b().aA().a(r3, "end doWork duration = {}, requestFrom = {}", new Object[]{Long.valueOf(System.currentTimeMillis() - r5), Integer.valueOf(r13)});
        return true;
    L23:
        if (b().ba() == false) goto L26;
        c r1 = this.f1568a;     // Catch: Throwable -> L31
        com.bytedance.applog.filter.a r16 = com.bytedance.applog.filter.a.a(this.f1568a.a(), r15);     // Catch: Throwable -> L31
    L25:
        r1.a(r16);     // Catch: Throwable -> L31
        goto L27
    L26:
        r1 = this.f1568a;     // Catch: Throwable -> L31
        r16 = com.bytedance.applog.filter.a.a(this.f1568a.a(), com.bytedance.applog.a.a(this.f1568a.a(), "sp_filter_name"), r15);     // Catch: Throwable -> L31
        goto L25
    L30:
        b().aA().a(r3, "end doWork duration = {}, requestFrom = {}", new Object[]{Long.valueOf(System.currentTimeMillis() - r5), Integer.valueOf(r13)});
    L34:
        return false;
    L31:
        th = move-exception;
        j r4 = b().aA();     // Catch: Throwable -> L35
        List<String> r6 = f;     // Catch: Throwable -> L35
        r4.d(r6, "config error, requestFrom = {}", new Object[]{Integer.valueOf(r13), th});     // Catch: Throwable -> L35
        b().ab().a("Configer doRequest error, requestFrom = " + r13, th);     // Catch: Throwable -> L35
        b().aA().a(r6, "end doWork duration = {}, requestFrom = {}", new Object[]{Long.valueOf(System.currentTimeMillis() - r5), Integer.valueOf(r13)});
    L35:
        th = move-exception;
        b().aA().a(f, "end doWork duration = {}, requestFrom = {}", new Object[]{Long.valueOf(System.currentTimeMillis() - r5), Integer.valueOf(r13)});
        throw th;
    }

    @Override // com.bytedance.applog.e.a
    public boolean b(int r7) {
        b().aA().b(f, g() + " start doWork curTs = {}", new Object[]{Long.valueOf(System.currentTimeMillis())});
        com.bytedance.applog.k.c r0 = this.f1568a.h();
        if (r0.e() == false) goto L12;
        JSONObject r1 = l.a(r0.a());
        m r2 = b().A();
        if (r2 == null) goto L11;
        r2.a(r1);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        b().aA().a(f, "header custom callback updateHeaderFromLogSettings error", th, new Object[0]);
        b().ab().a("Configer IHeaderCustomTimelyCallback updateHeaderFromLogSettings failed", th);
    L11:
        return a(r1, r7);
    L12:
        return false;
    }

    @Override // com.bytedance.applog.e.a
    public boolean d() {
        return true;
    }

    @Override // com.bytedance.applog.e.a
    public long e() {
        return this.f1568a.m().x();
    }

    @Override // com.bytedance.applog.e.a
    public long[] f() {
        return e;
    }

    @Override // com.bytedance.applog.e.a
    public String g() {
        return "configer";
    }
}
