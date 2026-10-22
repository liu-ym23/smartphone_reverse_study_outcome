package com.bytedance.android.livesdk.interactivity.barrage.utils.shoot;

import com.bytedance.android.livesdk.interactivity.barrage.utils.DanmakuStateHelper;
import com.bytedance.android.livesdk.interactivity.zdanmaku.layout.danmakuline.IHeatChangeController;
import com.bytedance.android.livesdk.interactivity.zdanmaku.widget.LandscapeDanmakuPresenterV2;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i extends h {
    public long d;
    public final DanmakuStateHelper e;
    public final com.bytedance.android.livesdk.interactivity.api.d f;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.barrage.utils.shoot.h
    public final com.bytedance.android.livesdk.interactivity.api.publicscreen.d m() {
        return (com.bytedance.android.livesdk.interactivity.api.publicscreen.d) ((LinkedList) this.c).pollFirst();
    }

    @Override // com.bytedance.android.livesdk.interactivity.barrage.utils.shoot.h, r22.a
    public final /* bridge */ /* synthetic */ com.bytedance.android.livesdk.interactivity.api.publicscreen.d j() {
        return m();
    }

    @Override // com.bytedance.android.livesdk.interactivity.barrage.utils.shoot.h, r22.a
    public final /* bridge */ /* synthetic */ void e(com.bytedance.android.livesdk.interactivity.api.publicscreen.d r1) {
        l(r1);
    }

    @Override // com.bytedance.android.livesdk.interactivity.barrage.utils.shoot.h
    public final void l(com.bytedance.android.livesdk.interactivity.api.publicscreen.d r13) {
        Intrinsics.checkNotNullParameter(r13, "danmaku");
        if (this.f.a() != IHeatChangeController.DanmakuHeat.NORMAL) goto L7;
        super.l(r13);
        return;
    L7:
        if (((LinkedList) this.c).size() < 200) goto L9;
        ((LinkedList) this.c).removeFirst();
    L9:
        long r0 = System.currentTimeMillis();
        long r4 = 3000;
        if ((r0 - this.d) <= r4) goto L12;
        this.d = r0;
        boolean r1 = true;
    L13:
        if (r1 == false) goto L86;
        int r2 = j.a[this.f.a().ordinal()];
        if (r2 == 1) goto L84;
        if (r2 == 2) goto L78;
        if (r2 == 3) goto L72;
        if (r2 == 4) goto L25;
        super.l(r13);
        return;
    L25:
        if (((LinkedList) this.c).size() < (this.f.f() * 10)) goto L62;
        if (((LinkedList) this.c).size() <= 0) goto L86;
        Iterator<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> r3 = this.c.iterator();
    L31:
        if (((LinkedList) this.c).size() <= (((double) (this.f.f() * 10)) * 0.5d)) goto L48;
        if (r3.hasNext() == false) goto L48;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.d r5 = r3.next();
        if ((r5 instanceof com.bytedance.android.livesdk.interactivity.api.publicscreen.f) == false) goto L31;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.f r6 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.f) r5;
        if ((System.currentTimeMillis() - r6.c()) >= r4) goto L43;
        long r8 = r6.getPriorityScore() % ((long) 100);
        if (r8 < 50) goto L42;
    L44:
        boolean r7 = false;
    L45:
        if (r7 == false) goto L31;
        r3.remove();
        goto L31
    L42:
        if (r8 == 0) goto L44;
    L43:
        r7 = true;
    L48:
        if (((LinkedList) this.c).size() <= (((double) (this.f.f() * 10)) * 0.5d)) goto L86;
    L50:
        if (((LinkedList) this.c).size() <= (((double) (this.f.f() * 10)) * 0.5d)) goto L86;
        if (r3.hasNext() == false) goto L86;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.d r9 = r3.next();
        if ((r9 instanceof com.bytedance.android.livesdk.interactivity.api.publicscreen.f) == false) goto L50;
        if (r9.getChatContent().length() <= 15) goto L58;
        boolean r10 = true;
    L59:
        if (r10 == false) goto L50;
        r3.remove();
        goto L50
    L58:
        r10 = false;
        goto L59
    L62:
        if (((LinkedList) this.c).size() >= (((double) (this.f.f() * 10)) * 0.5d)) goto L65;
        this.f.d();
        goto L86
    L65:
        if (((LinkedList) this.c).size() < (this.f.f() * 20)) goto L86;
    L67:
        if (((LinkedList) this.c).size() < (this.f.f() * 10)) goto L86;
        if (((LinkedList) this.c).size() <= 0) goto L86;
        ((LinkedList) this.c).removeFirst();
        goto L67
    L72:
        if (((LinkedList) this.c).size() < (this.f.f() * 10)) goto L75;
        this.f.e();
        goto L86
    L75:
        if (((LinkedList) this.c).size() >= (((double) (this.f.f() * 10)) * 0.5d)) goto L86;
        this.f.d();
        goto L86
    L78:
        if (((LinkedList) this.c).size() < (this.f.f() * 5)) goto L81;
        this.f.e();
        goto L86
    L81:
        if (((LinkedList) this.c).size() >= (((double) (this.f.f() * 5)) * 0.5d)) goto L86;
        this.f.d();
        goto L86
    L84:
        if (((LinkedList) this.c).size() < (this.f.f() * 5)) goto L86;
        this.f.e();
    L86:
        ((LinkedList) this.c).add(r13);
        k();
        return;
    L12:
        r1 = false;
        goto L13
    }

    public i(LandscapeDanmakuPresenterV2.d r2, LandscapeDanmakuPresenterV2.e r3) {
        Intrinsics.checkNotNullParameter(r2, "danmakuReceiver");
        Intrinsics.checkNotNullParameter(r3, "heatController");
        super(r2);
        this.f = r3;
        this.e = new DanmakuStateHelper(this, r3);
    }
}
