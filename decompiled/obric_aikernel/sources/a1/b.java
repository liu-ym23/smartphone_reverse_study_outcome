package a1;

import com.bytedance.applog.monitor.MonitorKey;
import com.bytedance.applog.monitor.MonitorState;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.Level;
import java.util.Collections;
import java.util.List;
import o1.g;
import o1.p;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class b extends a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final List<String> f15h = null;

    static {
        f15h = Collections.singletonList("Configer");
    }

    b(c r10) {
        super(r10, r10.v().j());
    }

    @Override // a1.a
    public boolean c(int r14) {
        if (this.f14f != 0) goto L5;
        this.f14f = System.currentTimeMillis();
    L5:
        long r10 = System.currentTimeMillis();
        d().P().o(f15h, f() + " start doWork curTs=" + r10, new Object[0]);
        g1.c r15 = this.f9a.y();
        if (r15.k() == false) goto L18;
        JSONObject r11 = new JSONObject();
        r11.put(Api.KEY_MAGIC, Api.MSG_MAGIC);
        r11.put("header", r15.e());
        r11.put("_gen_time", System.currentTimeMillis());
        g1.b r16 = this.f9a.v();
        d().r().d(r11, false);
        JSONObject r12 = d().r().c(k1.a.e(d().addNetCommonParams(this.f9a.w(), this.f9a.E().e(), true, Level.L1), g.f11382d), r11);
        if (d().A() == null) goto L10;
        d().A().a(!p.n(r12, r16.h()), r12);
    L10:
        if (r12 != null) goto L12;
    L19:
        return false;
    L12:
        if (this.f14f == 0) goto L14;
        d().R().o(MonitorKey.config, MonitorState.total_success, System.currentTimeMillis() - this.f14f);
        this.f14f = 0;
    L14:
        d().R().o(MonitorKey.config, MonitorState.success, System.currentTimeMillis() - r10);
        r16.K(r12);
        if (this.f9a.v().q().O() == false) goto L17;
        c r17 = this.f9a;
        r17.R(c1.a.f(r17.s(), com.bytedance.applog.b.b(this.f9a.s(), "sp_filter_name"), r12));
    L17:
        return true;
    L18:
        d().R().h(MonitorKey.config, MonitorState.f_device_none);
        goto L19
    }

    @Override // a1.a
    protected String f() {
        return "configer";
    }

    @Override // a1.a
    protected long[] g() {
        return a.f8g;
    }

    @Override // a1.a
    protected boolean i() {
        return true;
    }

    @Override // a1.a
    protected long j() {
        return this.f9a.v().i();
    }
}
