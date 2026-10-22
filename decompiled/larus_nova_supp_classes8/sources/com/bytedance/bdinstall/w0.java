package com.bytedance.bdinstall;

import android.accounts.Account;
import android.content.Context;
import g84.b;
import g84.e;
import java.util.Map;
import k74.c;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class w0 implements b, v0$a {
    public n0 a;
    public c b;
    public final y c;

    public final void a(u r1) {
    }

    public final void b(Account r1) {
    }

    public final void c(Map r1) {
    }

    public final boolean d(JSONObject r1) {
        return false;
    }

    public final boolean e() {
        return false;
    }

    public final u f() {
        return null;
    }

    public final void h(Context r1, Map r2, boolean r3) {
    }

    public final void i(u r1) {
    }

    public final void j(u r1, long r2, t0 r4) {
    }

    public final boolean k() {
        return false;
    }

    public final void start() {
    }

    public final n0 g() {
        n0 r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }

    public final String getDid() {
        n0 r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a;
    }

    public w0(k r1) {
        this.c = r1;
        t.a("OTHER PROCESS IMPL");
    }

    public final void l(n0 r1) {
        this.a = r1;
    }

    public final void m(o0 r4, u r5) {
        r4.getContext();
        a1.a(r4.getContext()).b(r4.a(), "install_info", new u0(this));
        n.b(r4);
        e.b(r.class, new o(r4), String.valueOf(r4.a));
    }
}
