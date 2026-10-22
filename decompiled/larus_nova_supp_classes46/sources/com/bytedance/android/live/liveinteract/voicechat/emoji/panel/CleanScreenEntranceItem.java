package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import android.view.View;
import com.bytedance.android.live.broadcastgame.api.interactgame.IGameDataService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class CleanScreenEntranceItem extends g {
    public final boolean f;
    public final Lazy g;

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final int d() {
        return 0;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final String j() {
        if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE) == false) goto L10;
        if (this.f == false) goto L8;
        return s1.B(2131920644);
    L8:
        return s1.B(2131920643);
    L10:
        if (this.f == false) goto L13;
        return ((rs1.a) this.g.getValue()).a().c();
    L13:
        return ((rs1.a) this.g.getValue()).b().c();
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final void a(HSImageView r3) {
        Intrinsics.checkNotNullParameter(r3, "icon");
        if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE) == false) goto L10;
        if (this.f == false) goto L7;
        int r0 = 2131251262;
    L8:
        r3.setActualImageResource(r0);
        return;
    L7:
        r0 = 2131251261;
        goto L8
    L10:
        if (this.f == false) goto L12;
        String r1 = ((rs1.a) this.g.getValue()).a().a();
    L13:
        ImageUtil.loadRoundImage(r3, qy.a.a(r1));
        return;
    L12:
        r1 = ((rs1.a) this.g.getValue()).b().a();
        goto L13
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final void k(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        IGameDataService r3 = com.bytedance.android.live.liveinteract.api.utils.m.a();
        if (r3 == null) goto L7;
        com.bytedance.live.datacontext.m r4 = r3.getClearScreen();
        if (r4 == null) goto L7;
        r4.setValue(Boolean.valueOf(!this.f));
    L7:
        ALogger.i("CleanScreenEntranceItem", "click");
        this.e.dismissDialog();
    }

    public CleanScreenEntranceItem(DataCenter r2, q0 r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "action");
        super(r3);
        IGameDataService r4 = com.bytedance.android.live.liveinteract.api.utils.m.a();
        if (r4 == null) goto L9;
        com.bytedance.live.datacontext.m r5 = r4.getClearScreen();
        if (r5 == null) goto L9;
        boolean r6 = true;
        if (((Boolean) r5.getValue()).booleanValue() != true) goto L9;
    L10:
        this.f = r6;
        this.g = LazyKt.lazy(CleanScreenEntranceItem$cleanScreenConfig$2.INSTANCE);
        return;
    L9:
        r6 = false;
        goto L10
    }
}
