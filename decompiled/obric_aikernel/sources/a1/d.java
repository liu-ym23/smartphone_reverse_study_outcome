package a1;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.work.WorkRequest;
import com.bytedance.applog.isolate.DataIsolateKey;
import com.bytedance.applog.j;
import com.bytedance.applog.monitor.MonitorKey;
import com.bytedance.applog.monitor.MonitorState;
import f1.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import l1.g;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class d extends a1.a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final List<String> f48m = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long[] f49h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final n1.b f50i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final h1.b f51j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f52k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f53l;

    class a implements f1.e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Set f54a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f55b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f56c;

        a(d r10, Set r11, boolean r12) {
            this.f56c = r10;
            this.f54a = r11;
            this.f55b = r12;
        }

        @Override // f1.e.b
        public Object a() {
            JSONObject r10 = new JSONObject();
            r10.put("$$APP_ID", this.f56c.f9a.s().getAppId());     // Catch: JSONException -> L13
            JSONArray r11 = new JSONArray();     // Catch: JSONException -> L13
            Iterator r12 = this.f54a.iterator();     // Catch: JSONException -> L13
        L5:
            if (r12.hasNext() == false) goto L7;
            r11.put((String) r12.next());     // Catch: JSONException -> L13
            goto L5
        L7:
            r10.put("$$EVENT_LOCAL_ID_ARRAY", r11);     // Catch: JSONException -> L13
            if (this.f55b == false) goto L10;
            String r13 = "success";
        L11:
            r10.put("$$UPLOAD_STATUS", r13);     // Catch: JSONException -> L13
            goto L12
        L10:
            r13 = "failed";
        L12:
            return r10;
        }
    }

    static {
        f48m = Collections.singletonList("Sender");
    }

    d(@NonNull c r10) {
        super(r10);
        this.f49h = new long[]{WorkRequest.MIN_BACKOFF_MILLIS};
        this.f53l = 0;
        this.f51j = null;
        this.f52k = "Sender";
        this.f50i = new n1.b("Sender", r10.v(), null);
    }

    d(c r10, @NonNull h1.b r11) {
        super(r10);
        long[] r12 = {WorkRequest.MIN_BACKOFF_MILLIS};
        this.f49h = r12;
        this.f53l = 0;
        this.f51j = r11;
        String r13 = "Sender_p_" + r11.f();
        this.f52k = r13;
        long r14 = r11.c();
        if (r14 >= WorkRequest.MIN_BACKOFF_MILLIS) goto L5;
        r12[0] = r14;
    L5:
        this.f50i = new n1.b(r13, r10.v(), r11);
    }

    private n1.a m(g1.b r10) {
        h1.b r11 = this.f51j;
        if (r11 == null) goto L7;
        return r11.b();
    L7:
        return r10.l();
    }

    private boolean n(long r10) {
        if (this.f53l > 0) goto L6;
        return false;
    L6:
        if ((System.currentTimeMillis() - r10) < this.f53l) goto L9;
        return true;
    L9:
        return false;
    }

    private c.g o(g1.b r21, String[] r22, List<g> r23, int r24, long r25) {
        c.g r10 = new c.g();
        Iterator<g> r11 = r23.iterator();
    L4:
        if (r11.hasNext() == false) goto L37;
        g r12 = r11.next();
        if (n(r25) == true) goto L7;
        Map<String, String> r16 = this.f9a.E().a();
        String r13 = r12.toString();
        byte[] r14 = r12.f10864z;
        if (r14 == null) goto L36;
        if (r14.length == 0) goto L36;
        d().r().n(this.f9a.x(), r12, this.f51j);
        if (this.f50i.f() == false) goto L15;
        n1.a r15 = m(r21);
        if (r15 == null) goto L22;
        if (r15.a(r24) == false) goto L22;
        d().R().h(MonitorKey.pack, MonitorState.f_backoff_ratio);
        d().P().g(f48m, "{} backoff request as ratio not allowed to send: {}", new Object[]{this.f52k, r13});
    L22:
        if (d().o() == false) goto L26;
        if (r12.Q(this.f9a.C()) == false) goto L26;
        d().P().g(f48m, "{} adjust terminate not allowed to send: {}", new Object[]{this.f52k, r13});
    L26:
        f1.g r17 = d().P();
        List<String> r18 = f48m;
        r17.o(r18, "{} send pack start: {}", new Object[]{this.f52k, r13});
        int r19 = d().r().k(r22, r12.f10864z, this.f9a, r12.N(), r12.S, r12.T, r16);
        r12.B = r19;
        d().P().o(r18, "{} send pack end: {}, resp code: {}", new Object[]{this.f52k, r13, Integer.valueOf(r19)});
        if (k1.a.a(r19) == true) goto L28;
        if (r19 == 200) goto L31;
        r10.f47b.add(r12);
        h1.b r20 = this.f51j;
        if (r20 == null) goto L35;
        r20.a(r19);
    L35:
        d().R().m(MonitorKey.log_send, "f_result_code:" + r19);
        p(r12.J(), false);
        goto L4
    L31:
        this.f50i.d();
        r10.f46a.add(r12);
        p(r12.J(), true);
        goto L4
    L28:
        this.f50i.c();
        r10.f47b.add(r12);
        d().R().m(MonitorKey.log_send, "f_result_code:" + r19);
        p(r12.J(), false);
        goto L37
    L15:
        d().R().h(MonitorKey.pack, MonitorState.f_congestion_control);
        d().P().g(f48m, "{} CongestionController not allowed to send: {}", new Object[]{this.f52k, r13});
    L36:
        r10.f46a.add(r12);
        d().R().h(MonitorKey.pack, MonitorState.f_send_check);
        d().P().g(f48m, "{} send empty pack: {}", new Object[]{this.f52k, r13});
        goto L4
    L7:
        d().P().o(f48m, "{} work is timeout, break send pack", new Object[]{this.f52k});
    L37:
        return r10;
    }

    private void p(Set<String> r10, boolean r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L9;
        m.d("event_upload_eid", new a(this, r10, r11));
        return;
    }

    private List<g> q(l1.b r10, int r11) {
        ArrayList r12 = new ArrayList();
        ArrayList r13 = new ArrayList();
        ArrayList r14 = new ArrayList();
        int r15 = d().Q();
        if (r11 != 4) goto L5;
        r15 = 8;
    L9:
        Iterator<g> r16 = r10.z(r15, this.f51j).iterator();
    L11:
        if (r16.hasNext() == false) goto L29;
        g r17 = r16.next();
        if (d().z() == null) goto L22;
        if (d().y() == null) goto L22;
        DataIsolateKey r18 = r17.K();
        if (r18 == null) goto L22;
        if (d().y().a(r18, r17.L()) == true) goto L22;
        d().P().o(f48m, "Pack:{} is not allowed send by isolate rule [{}, {}]", new Object[]{r17, r18, r17.L()});
    L22:
        if (r17.O() == true) goto L23;
        if (r17.P() == true) goto L26;
        r12.add(r17);
        goto L11
    L26:
        r14.add(r17);
        goto L11
    L23:
        r13.add(r17);
        goto L11
    L29:
        if (r14.isEmpty() == true) goto L32;
        r13.addAll(r14);
    L32:
        if (r13.isEmpty() == true) goto L34;
        r12.addAll(!r12.isEmpty() ? 1 : 0, r13);
    L34:
        return r12;
    L5:
        if (r11 != 12) goto L9;
        r15 = 16;
        goto L9
    }

    private void r(int r10, long r11) {
        List<g> r12 = q(this.f9a.x(), r10);
        if (r12.size() <= 0) goto L6;
        c.g r13 = o(this.f9a.v(), d().s().b(this.f9a, false, this.f51j), r12, r10, r11);
        d().P().o(f48m, this.f52k + " " + r13.f46a.size() + " " + r12.size(), new Object[0]);
        this.f9a.p(r13);
        return;
    }

    @Override // a1.a
    public boolean c(int r12) {
        long r10 = System.currentTimeMillis();
        e r11 = this.f9a.C();
        f1.g r13 = d().P();
        List<String> r14 = f48m;
        StringBuilder r15 = new StringBuilder();
        r15.append(this.f52k);
        r15.append(" start doWork curTs=");
        r15.append(r10);
        r15.append(", curSid=");
        if (r11 == null) goto L5;
        String r16 = r11.d();
    L6:
        r15.append(r16);
        r13.o(r14, r15.toString(), new Object[0]);
        if (d().k0() == true) goto L9;
    L12:
        if (r11 == null) goto L16;
        Bundle r17 = r11.g(r10, 50000);
        if (r17 == null) goto L16;
        d().n0("play_session", r17);
        d().flush();
    L16:
        l1.b r18 = this.f9a.x();
        g1.c r19 = this.f9a.y();
        if (r19.k() == false) goto L32;
        JSONObject r20 = o1.m.a(r19.e());
        if (r19.l(r20) == false) goto L28;
        j r21 = d().J();
        if (r21 == null) goto L23;
        r21.a(r20);
    L23:
        r18.t(r20, this.f51j, r12);
        if (n(r10) == true) goto L26;
        r(r12, r10);
    L38:
        return true;
    L26:
        d().P().o(r14, "{} work is timeout, will not do send.", new Object[]{this.f52k});
        goto L38
    L28:
        f1.g r110 = d().P();
        if (r20 == null) goto L31;
        StringBuilder r22 = new StringBuilder();
        r22.append(this.f52k);
        r22.append(" new header without valid did: ");
        r22.append(r20.optString("device_id"));
        r22.append(", iid: ");
        r22.append(r20.optString("install_id"));
        r110.g(r14, r22.toString(), new Object[0]);
    L36:
        d().R().h(MonitorKey.pack, MonitorState.f_device_none);
        return false;
    L31:
        r22 = new StringBuilder();
        r22.append(this.f52k);
        r22.append(" new header is null");
        r110.g(r14, r22.toString(), new Object[0]);
        goto L36
    L32:
        JSONObject r111 = r19.e();
        if (r111 == null) goto L35;
        d().P().g(r14, this.f52k + " device header without valid did: " + r111.optString("device_id") + ", iid: " + r111.optString("install_id"), new Object[0]);
        goto L36
    L35:
        d().P().g(r14, this.f52k + " device header is null", new Object[0]);
        goto L36
    L9:
        if (d().d0() == true) goto L12;
        d().P().g(r14, this.f52k + " not send events in tourist mode", new Object[0]);
        return true;
    L5:
        r16 = "null";
        goto L6
    }

    @Override // a1.a
    protected String f() {
        return this.f52k;
    }

    @Override // a1.a
    protected long[] g() {
        return this.f49h;
    }

    @Override // a1.a
    protected boolean i() {
        return !this.f11c;
    }

    @Override // a1.a
    protected long j() {
        h1.b r10 = this.f51j;
        if (r10 == null) goto L7;
        return r10.c();
    L7:
        return this.f9a.v().n();
    }

    void s(h1.b r10, int r11) {
        if (r10 != this.f51j) goto L6;
        this.f50i.g(r11);
        return;
    }
}
