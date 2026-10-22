package com.ss.android.lark.chat.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ss.android.lark.passportc.dwarf.UserScope;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class k2 implements m6b.q {
    public final List<b> a;
    public final List<a> b;
    public final m6b.r c;
    public final e2 d;

    public interface a {
        void a();
    }

    public interface b {
        void a(JSONObject r1);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.chat.service.impl.e2] */
    @Inject
    public k2(m6b.r r2) {
        this.a = new CopyOnWriteArrayList();
        this.b = new CopyOnWriteArrayList();
        this.d = new e2();
        this.c = r2;
    }

    @Override // m6b.q
    public final void G1(b r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        com.ss.android.lark.sdk.f.a(this.a, r3, new d2(this));
    }

    @Override // m6b.q
    public final void Ia(b r3) {
        List<b> r0 = this.a;
        m6b.r r1 = this.c;
        Objects.requireNonNull(r1);
        if (r3 == null) goto L28;
        monitor-enter(r0);
        r0.remove(r3);     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        if (r0.isEmpty() == false) goto L19;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L12:
        if (r0.isEmpty() == false) goto L14;
        r1.d();     // Catch: Throwable -> L16
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L19:
        return;
    L20:
        th = move-exception;
        throw th;
    }

    @Override // m6b.q
    public final void be(a r4) {
        List<a> r0 = this.b;
        final m6b.r r1 = this.c;
        Objects.requireNonNull(r1);
        com.ss.android.lark.sdk.f.b(r0, r4, new c2(r1));
    }

    @Override // m6b.q
    public final void je(a r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        com.ss.android.lark.sdk.f.a(this.b, r3, new f2(this));
    }
}
