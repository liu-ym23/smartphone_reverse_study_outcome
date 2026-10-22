package com.bytedance.applog.p;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.applog.EventType;
import com.bytedance.applog.i;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import com.bytedance.applog.n.h;
import com.bytedance.applog.n.j;
import com.bytedance.applog.util.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<String> f1742a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f1743b;
    private final com.bytedance.applog.n.b c;
    private final com.bytedance.applog.k.c d;
    private final com.bytedance.applog.b e;

    static {
        f1742a = Collections.singletonList("BgSessionTaskModel");
    }

    b(com.bytedance.applog.b r1, com.bytedance.applog.n.b r2, com.bytedance.applog.k.c r3) {
        this.c = r2;
        this.d = r3;
        this.e = r1;
        this.f1743b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        a();
    }

    static /* synthetic */ d a(b r0) {
        return r0.c();
    }

    private void a(String r3) {
        if (r3 != null) goto L7;
        r3 = "";
    L7:
        SharedPreferences.Editor r2 = this.f1743b.getSharedPreferences(d(), 0).edit();     // Catch: Throwable -> L6
        r2.putString("key_task_session", r3);     // Catch: Throwable -> L6
        r2.apply();     // Catch: Throwable -> L6
        return;
    }

    private d c() {
        return d.a(this.f1743b.getSharedPreferences(d(), 0).getString("key_task_session", ""));
    }

    private String d() {
        if (this.e.f() == null) goto L6;
        return this.e.f().F();
    L6:
        return "applog_task@" + this.e.b();
    }

    private boolean d(d r18) {
        if (r18 != null) goto L40;
        return false;
    L40:
        final j r7 = new j();     // Catch: Throwable -> L35
        this.e.b(r7);     // Catch: Throwable -> L35
        r7.f1725b = r18.j();     // Catch: Throwable -> L35
        r7.d = r18.f();     // Catch: Throwable -> L35
        r7.B = 1;     // Catch: Throwable -> L35
        if (r18.a() == false) goto L9;
        r7.A = r18.c();     // Catch: Throwable -> L35
    L9:
        if (r18.b() == false) goto L11;
        r7.z = r18.d();     // Catch: Throwable -> L35
    L11:
        r7.v = r18.i();     // Catch: Throwable -> L35
        r7.w = r18.h();     // Catch: Throwable -> L35
        r7.y = Integer.valueOf(r18.g());     // Catch: Throwable -> L35
        if (r18.k() == null) goto L15;
        r7.C = r18.k().toString();     // Catch: Throwable -> L35
    L15:
        if (this.e.L() == false) goto L25;
        if (this.e.aS() == null) goto L25;
        if (this.e.aS().a(EventType.Terminate.value()) == false) goto L25;
        if (this.e.aS().a(EventType.Terminate.value(), r7.i(), new $$Lambda$5jZHixV5deJ9a8MgTQ_HG6H_dJA(r7)) == false) goto L25;
        this.e.aA().a(f1742a, "[Task] save session terminate to priority success", new Object[0]);     // Catch: Throwable -> L35
        return true;
    L25:
        if (this.d.e() == false) goto L37;
        JSONObject r5 = l.a(this.d.a());     // Catch: Throwable -> L35
        i r0 = this.e.z();     // Catch: Throwable -> L35
        if (r0 != null) goto L38;
    L33:
        this.e.aA().b(f1742a, "[Task] save task session to db : {}", new Object[]{r18});     // Catch: Throwable -> L35
        h r1 = new h();     // Catch: Throwable -> L35
        r1.a(this.e.b(), r5, null, r7, null, new JSONArray[]{null, null, null}, new long[]{-1, -1, -1}, null, null, 9);     // Catch: Throwable -> L35
        this.c.a(r1, true, null, null);     // Catch: Throwable -> L35
        return true;
    L38:
        r0.a(r5);     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        this.e.ab().a(StatsCountKeys.PACK_ERROR_COUNT);     // Catch: Throwable -> L35
        this.e.aA().a(f1742a, "header custom callback updateHeader error", th, new Object[0]);     // Catch: Throwable -> L35
    L37:
        return false;
    L35:
        th = move-exception;
        this.e.aA().a(f1742a, "[Task] Save task session to pack failed", th, new Object[0]);
        goto L37
    }

    public void a() {
        e.a().a(new AnonymousClass1(this));
    }

    public void a(d r1) {
        d(r1);
    }

    public void b() {
        this.e.aA().b(f1742a, "[Task] clear task session sp", new Object[0]);
        a("");
    }

    public void b(d r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        this.e.aA().b(f1742a, "[Task] saveTaskSessionToSp : {}", new Object[]{r5});
        a(r5.e());
    }

    public boolean c(d r7) {
        if (r7 != null) goto L5;
        return false;
    L5:
        this.e.aA().b(f1742a, "[Task] start to report session : {}", new Object[]{r7});
        if (d(r7) == false) goto L9;
        b();
        this.e.h();
        return true;
    L9:
        return false;
    }
}
