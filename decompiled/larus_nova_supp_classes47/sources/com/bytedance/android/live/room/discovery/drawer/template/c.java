package com.bytedance.android.live.room.discovery.drawer.template;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c extends g61.a.C0244a {
    public final /* synthetic */ LiveDrawerEntranceCommonWidget a;

    @Override // g61.a.C0244a, g61.a
    public final boolean a() {
        LiveDrawerEntranceCommonWidget r0 = this.a;
        r0.E = false;
        com.bytedance.android.live.core.view.a r1 = r0.l;
        if (r1 == null) goto L7;
        r1.j = false;
        return true;
    L7:
        return true;
    }

    @Override // g61.a.C0244a, g61.a
    public final boolean b() {
        LiveDrawerEntranceCommonWidget r0 = this.a;
        r0.E = true;
        com.bytedance.android.live.core.view.a r1 = r0.l;
        if (r1 == null) goto L7;
        r1.j = true;
        if (r1.b == false) goto L7;
        r1.a();
    L7:
        return true;
    }

    public c(LiveDrawerEntranceCommonWidget r1) {
        this.a = r1;
    }
}
