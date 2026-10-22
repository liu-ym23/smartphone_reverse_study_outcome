package com.bytedance.android.live.room.incentiveinfo;

import com.bytedance.android.live.core.log.ALogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements u81.e.a {
    public final /* synthetic */ u81.d a;
    public final /* synthetic */ u81.e.a b;
    public final /* synthetic */ u81.d c;

    @Override // u81.e.a
    public final void a() {
        StringBuilder r0 = new StringBuilder("onEnterEnd：");
        u81.d r1 = this.c;
        if (r1 == null) goto L5;
        w81.a r2 = x81.a.c(r1);
    L6:
        r0.append(r2);
        ALogger.d("CarouselAnimController", r0.toString());
        this.b.a();
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // u81.e.a
    public final void b() {
        StringBuilder r0 = new StringBuilder("onExitStart：");
        u81.d r1 = this.a;
        if (r1 == null) goto L5;
        w81.a r2 = x81.a.c(r1);
    L6:
        r0.append(r2);
        ALogger.d("CarouselAnimController", r0.toString());
        this.b.b();
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // u81.e.a
    public final void c() {
        StringBuilder r0 = new StringBuilder("onExitEnd：");
        u81.d r1 = this.a;
        if (r1 == null) goto L5;
        w81.a r2 = x81.a.c(r1);
    L6:
        r0.append(r2);
        ALogger.d("CarouselAnimController", r0.toString());
        this.b.c();
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // u81.e.a
    public final void d() {
        StringBuilder r0 = new StringBuilder("onEnterStart：");
        u81.d r1 = this.c;
        if (r1 == null) goto L5;
        w81.a r2 = x81.a.c(r1);
    L6:
        r0.append(r2);
        ALogger.d("CarouselAnimController", r0.toString());
        this.b.d();
        return;
    L5:
        r2 = null;
        goto L6
    }

    public b(u81.d r1, f r2, u81.d r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
