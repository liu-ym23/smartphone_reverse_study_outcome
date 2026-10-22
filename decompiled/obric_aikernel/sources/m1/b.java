package m1;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.applog.j;
import com.bytedance.applog.monitor.MonitorKey;
import com.bytedance.applog.monitor.MonitorState;
import java.util.Collections;
import java.util.List;
import l1.g;
import l1.i;
import o1.m;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final List<String> f10957e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l1.b f10959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final g1.c f10960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bytedance.applog.c f10961d;

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f10962c;

        a(b r10) {
            this.f10962c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            d r10 = b.a(this.f10962c);
            if (r10 == null) goto L5;
            this.f10962c.g(r10);
        L5:
            this.f10962c.b();
        }
    }

    static {
        f10957e = Collections.singletonList("BgSessionTaskModel");
    }

    b(com.bytedance.applog.c r10, l1.b r11, g1.c r12) {
        this.f10959b = r11;
        this.f10960c = r12;
        this.f10961d = r10;
        this.f10958a = r10.w();
        e();
    }

    static /* synthetic */ d a(b r10) {
        return r10.c();
    }

    private d c() {
        return d.b(this.f10958a.getSharedPreferences(d(), 0).getString("key_task_session", ""));
    }

    private String d() {
        if (this.f10961d.K() == null) goto L6;
        return this.f10961d.K().A();
    L6:
        return "applog_task@" + this.f10961d.getAppId();
    }

    private void f(d r15) {
        if (r15 != null) goto L34;
        return;
    L34:
        i r10 = new i();     // Catch: Throwable -> L31
        this.f10961d.l(r10);     // Catch: Throwable -> L31
        r10.f10828g = r15.i();     // Catch: Throwable -> L31
        r10.f10830i = r15.g();     // Catch: Throwable -> L31
        r10.F = 1;     // Catch: Throwable -> L31
        if (r15.k() == false) goto L9;
        r10.E = r15.e();     // Catch: Throwable -> L31
    L9:
        if (r15.j() == false) goto L11;
        r10.D = r15.d();     // Catch: Throwable -> L31
    L11:
        r10.f10866z = r15.c();     // Catch: Throwable -> L31
        r10.A = r15.f();     // Catch: Throwable -> L31
        r10.C = Integer.valueOf(r15.h());     // Catch: Throwable -> L31
        if (this.f10960c.k() == false) goto L25;
        JSONObject r11 = m.a(this.f10960c.e());     // Catch: Throwable -> L31
        if (this.f10960c.l(r11) == false) goto L20;
        j r12 = this.f10961d.J();     // Catch: Throwable -> L31
        if (r12 == null) goto L19;
        r12.a(r11);     // Catch: Throwable -> L31
    L19:
        this.f10961d.P().o(f10957e, "[Task] save task session to db : {}", new Object[]{r15});     // Catch: Throwable -> L31
        g r16 = new g();     // Catch: Throwable -> L31
        r16.V(this.f10961d.getAppId(), r11, null, r10, null, new JSONArray[]{null, null, null}, new long[]{-1, -1, -1}, null, null, 9);     // Catch: Throwable -> L31
        this.f10959b.k(r16, true, null, true, null);     // Catch: Throwable -> L31
        return;
    L20:
        if (r11 == null) goto L22;
        this.f10961d.P().m(f10957e, "[Task] saveTaskSession new header without valid did: " + r11.optString("device_id") + ", iid: " + r11.optString("install_id"), new Object[0]);     // Catch: Throwable -> L31
    L23:
        com.bytedance.applog.monitor.a r17 = this.f10961d.R();     // Catch: Throwable -> L31
        MonitorKey r13 = MonitorKey.pack;     // Catch: Throwable -> L31
        MonitorState r14 = MonitorState.f_device_none;     // Catch: Throwable -> L31
    L24:
        r17.h(r13, r14);     // Catch: Throwable -> L31
        return;
    L22:
        this.f10961d.P().m(f10957e, "[Task] saveTaskSession new header is null", new Object[0]);     // Catch: Throwable -> L31
        goto L23
    L25:
        JSONObject r18 = this.f10960c.e();     // Catch: Throwable -> L31
        if (r18 == null) goto L28;
        this.f10961d.P().m(f10957e, "[Task] saveTaskSession device header without valid did: " + r18.optString("device_id") + ", iid: " + r18.optString("install_id"), new Object[0]);     // Catch: Throwable -> L31
    L29:
        r17 = this.f10961d.R();     // Catch: Throwable -> L31
        r13 = MonitorKey.pack;     // Catch: Throwable -> L31
        r14 = MonitorState.f_device_none;     // Catch: Throwable -> L31
        goto L24
    L28:
        this.f10961d.P().m(f10957e, "[Task] saveTaskSession device header is null", new Object[0]);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        this.f10961d.P().u(f10957e, "[Task] Save task session failed", th, new Object[0]);
    }

    private void h(String r10) {
        if (r10 != null) goto L7;
        r10 = "";
    L7:
        SharedPreferences.Editor r11 = this.f10958a.getSharedPreferences(d(), 0).edit();     // Catch: Throwable -> L6
        r11.putString("key_task_session", r10);     // Catch: Throwable -> L6
        r11.apply();     // Catch: Throwable -> L6
        return;
    }

    public void b() {
        this.f10961d.P().o(f10957e, "[Task] clear task session sp", new Object[0]);
        h("");
    }

    public void e() {
        e.d().b(new a(this));
    }

    public void g(d r10) {
        f(r10);
    }

    public void i(d r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.f10961d.P().o(f10957e, "[Task] saveTaskSessionToSp : {}", new Object[]{r10});
        h(r10.o());
    }
}
