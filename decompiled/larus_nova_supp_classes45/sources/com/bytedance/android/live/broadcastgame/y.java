package com.bytedance.android.live.broadcastgame;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class y implements com.bytedance.android.live.broadcastgame.api.f {
    public WeakReference<AudienceGameWidget> a;

    public y() {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.f
    public final void a() {
        WeakReference<AudienceGameWidget> r0 = this.a;
        if (r0 == null) goto L10;
        AudienceGameWidget r1 = r0.get();
        if (r1 == null) goto L11;
        com.bytedance.android.live.broadcastgame.api.openplatform.b r2 = r1.a;
        if (r2 == null) goto L12;
        r2.k();
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.f
    public final void b() {
        WeakReference<AudienceGameWidget> r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.get() == null) goto L9;
        xs2.b.a().post(new com.bytedance.android.live.broadcastgame.api.openplatform.f("from_toolbar"));
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.f
    public final String getGameCategory() {
        WeakReference<AudienceGameWidget> r0 = this.a;
        if (r0 == null) goto L13;
        AudienceGameWidget r1 = r0.get();
        if (r1 == null) goto L14;
        com.bytedance.android.live.broadcastgame.api.openplatform.b r2 = r1.a;
        if (r2 == null) goto L15;
        String r3 = r2.getGameCategory();
        if (r3 != null) goto L12;
        return "";
    L12:
        return r3;
    L15:
        return "";
    L14:
        return "";
    L13:
        return "";
    }

    @Override // com.bytedance.android.live.broadcastgame.api.f
    public final AudienceGameWidget getAudienceGameWidget(boolean r2) {
        AudienceGameWidget r0 = new AudienceGameWidget(r2);
        this.a = new WeakReference(r0);
        return r0;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.f
    public final void onSei(String r3) {
        Intrinsics.checkNotNullParameter(r3, "seiMsg");
        WeakReference<AudienceGameWidget> r1 = this.a;
        if (r1 == null) goto L10;
        AudienceGameWidget r2 = r1.get();
        if (r2 == null) goto L11;
        Intrinsics.checkNotNullParameter(r3, "seiMsg");
        com.bytedance.android.live.broadcastgame.api.openplatform.b r0 = r2.a;
        if (r0 == null) goto L12;
        r0.j(r3);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.f
    public final void stopRunningPlugin(String r3) {
        Intrinsics.checkNotNullParameter(r3, "reason");
        WeakReference<AudienceGameWidget> r1 = this.a;
        if (r1 == null) goto L11;
        AudienceGameWidget r2 = r1.get();
        if (r2 == null) goto L12;
        Intrinsics.checkNotNullParameter(r3, "reason");
        com.bytedance.android.live.broadcastgame.api.openplatform.b r0 = r2.a;
        if (r0 == null) goto L9;
        r0.b(r3);
    L9:
        com.bytedance.android.live.broadcastgame.api.xplay.n.b.e(r3);
        return;
    L12:
        return;
    }
}
