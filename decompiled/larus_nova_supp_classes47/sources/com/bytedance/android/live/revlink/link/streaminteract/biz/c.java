package com.bytedance.android.live.revlink.link.streaminteract.biz;

import com.bytedance.android.live.revenuelink.e;
import com.bytedance.android.live.revenuelink.rtc.i;
import com.bytedance.android.live.revlink.link.domain.streammix.NormalStreamMixStrategy;
import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g;
import com.bytedance.android.livesdk.revenue.service.livecore.IRegion;
import com.bytedance.android.scope.o;
import fr2.p0;
import gr2.k;
import gr2.m;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import o51.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c extends p0 implements o {
    public NormalStreamMixStrategy b;
    public boolean c;
    public e d;
    public boolean e;
    public final i f;
    public final g g;

    public final void onStart() {
        if (this.c == true) goto L7;
        this.c = true;
        vc0.a r0 = vc0.b.a(this);
        this.f.I1(r0);
        this.f.f();
    L7:
        if (this.d != null) goto L10;
        this.d = this.f.P();
        return;
    }

    public final void onStop() {
        e r0 = this.d;
        if (r0 == null) goto L8;
        this.e = false;
        if (r0 == null) goto L9;
        r0.dispose();
        return;
    L9:
        return;
    }

    public c(i r2, g r3) {
        Intrinsics.checkNotNullParameter(r2, "rtcManager");
        Intrinsics.checkNotNullParameter(r3, "context");
        this.f = r2;
        this.g = r3;
    }

    public final boolean S(m r2, k r3) {
        NormalStreamMixStrategy r0 = this.b;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.S(r2, r3) != true) goto L7;
        return true;
    }

    public final String L3(int r6, int r7, List<? extends IRegion> r8) {
        Intrinsics.checkNotNullParameter(r8, "regions");
        Intrinsics.checkNotNullParameter(r8, "list");
        if (this.d != null) goto L5;
    L25:
        NormalStreamMixStrategy r1 = this.b;
        if (r1 == null) goto L28;
        String r9 = r1.L3(r6, r7, r8);
    L29:
        boolean r10 = b.a;
        Intrinsics.checkNotNullParameter(r9, "seiAppDataRaw");
        Intrinsics.checkNotNullParameter(r8, "regions");
        if (b.a == false) goto L32;
        b.d = r8;
        b.c.postValue(r9);
    L32:
        return r9;
    L28:
        r9 = "";
        goto L29
    L5:
        if ((!r8.isEmpty()) == false) goto L20;
        e r2 = this.d;
        if (r2 == null) goto L14;
        o51.e r3 = (o51.e) this.g.d.i.getValue();
        if (r3 == null) goto L11;
        f r4 = r3.a;
    L12:
        r2.a(Intrinsics.areEqual(r4, f.n.e));
        goto L14
    L11:
        r4 = null;
    L14:
        if (this.e == true) goto L25;
        e r5 = this.d;
        if (r5 == null) goto L18;
        e.a.getClass();
        r5.b("rtc_init");
    L18:
        this.e = true;
        goto L25
    L20:
        if (this.e == false) goto L25;
        e r12 = this.d;
        if (r12 == null) goto L24;
        r12.dispose();
    L24:
        this.e = false;
        goto L25
    }
}
