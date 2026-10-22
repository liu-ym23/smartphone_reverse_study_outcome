package com.bytedance.android.livesdk.interactivity.zdanmaku;

import com.bytedance.android.livesdk.interactivity.zdanmaku.attributes.PrivilegeDanmakuType;
import com.bytedance.live.artist.render.RenderEntity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i extends h {
    public uc2.b e;
    public int f;
    public f g;
    public g h;
    public final float i;
    public final int j;
    public float k;
    public float l;
    public int m;
    public boolean n;
    public int[] o;

    public final int i() {
        nf6.a r0 = new tc2.b(0);
        nf6.a r1 = b().e(tc2.b.class);
        if (r1 == null) goto L7;
        r0 = r1;
    L7:
        return ((tc2.b) r0).a;
    }

    public final int j() {
        nf6.a r0 = new tc2.c(-1);
        nf6.a r1 = b().e(tc2.c.class);
        if (r1 == null) goto L7;
        r0 = r1;
    L7:
        return ((tc2.c) r0).a;
    }

    public i() {
        this.f = -1;
        this.i = 6.0f;
        this.j = 5000;
    }

    public final int k() {
        tc2.i r0 = (tc2.i) b().e(tc2.i.class);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.a;
    }

    public final boolean l() {
        if (((PrivilegeDanmakuType) b().e(PrivilegeDanmakuType.class)) != PrivilegeDanmakuType.MultiLine) goto L5;
        return true;
    L5:
        return false;
    }

    public final void m(float r4, boolean r5) {
        if (r5 == false) goto L10;
        f r6 = this.g;
        if (r6 == null) goto L8;
        e r7 = r6.a(r4, this);
        if (r7 == null) goto L8;
    L9:
        RenderEntity r8 = b();
        tc2.g r1 = new tc2.g(r7.a);
        r8.getClass();
        r8.a(tc2.g.class, r1);
        d(-r7.a, 0.0f);
        return;
    L8:
        r7 = new e(0.0f);
        goto L9
    L10:
        f r9 = this.g;
        if (r9 == null) goto L14;
        e r10 = r9.a(r4, this);
        if (r10 == null) goto L14;
    L15:
        RenderEntity r11 = b();
        tc2.g r2 = new tc2.g(r10.a);
        r11.getClass();
        r11.a(tc2.g.class, r2);
        d(r10.a, 0.0f);
        return;
    L14:
        r10 = new e(0.0f);
        goto L15
    }
}
