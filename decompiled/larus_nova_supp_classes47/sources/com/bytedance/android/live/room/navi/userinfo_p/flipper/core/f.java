package com.bytedance.android.live.room.navi.userinfo_p.flipper.core;

import com.bytedance.android.live.core.log.ALogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f implements w91.c.a {
    public final /* synthetic */ TabAnimDelegate a;
    public final /* synthetic */ w91.f b;
    public final /* synthetic */ w91.c.a c;
    public final /* synthetic */ w91.f d;

    @Override // w91.c.a
    public final void a() {
        String r0 = this.a.a;
        StringBuilder r1 = new StringBuilder("onEnterEnd：");
        w91.f r2 = this.d;
        if (r2 == null) goto L5;
        w91.e r3 = e.c(r2);
    L6:
        r1.append(r3);
        ALogger.d(r0, r1.toString());
        this.c.a();
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // w91.c.a
    public final void b() {
        String r0 = this.a.a;
        StringBuilder r1 = new StringBuilder("onExitStart：");
        w91.f r2 = this.b;
        if (r2 == null) goto L5;
        w91.e r3 = e.c(r2);
    L6:
        r1.append(r3);
        ALogger.d(r0, r1.toString());
        this.c.b();
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // w91.c.a
    public final void c() {
        String r0 = this.a.a;
        StringBuilder r1 = new StringBuilder("onExitEnd：");
        w91.f r2 = this.b;
        if (r2 == null) goto L5;
        w91.e r3 = e.c(r2);
    L6:
        r1.append(r3);
        ALogger.d(r0, r1.toString());
        this.c.c();
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // w91.c.a
    public final void d() {
        String r0 = this.a.a;
        StringBuilder r1 = new StringBuilder("onEnterStart：");
        w91.f r2 = this.d;
        if (r2 == null) goto L5;
        w91.e r3 = e.c(r2);
    L6:
        r1.append(r3);
        ALogger.d(r0, r1.toString());
        this.c.d();
        return;
    L5:
        r3 = null;
        goto L6
    }

    public f(TabAnimDelegate r1, w91.f r2, d r3, w91.f r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
