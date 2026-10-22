package com.bytedance.android.live.liveinteract.interact.audience;

import com.bytedance.android.live.liveinteract.plantform.core.RtcManager;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.chatroom.utils.g0;
import com.bytedance.ies.sdk.widgets.Widget;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends com.bytedance.android.live.liveinteract.plantform.base.i.d {
    public final /* synthetic */ InteractAudienceAnchorWidget a;

    public a(InteractAudienceAnchorWidget r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
    public final void onOnlineListChanged(List<ILinkPlayerInfoBridge> r4) {
        Intrinsics.checkNotNullParameter(r4, "list");
        ArrayList r0 = new ArrayList(r4);
        ((Widget) this.a).dataCenter.put("data_online_changed_list", r0);
        g0.e(r0.size());
        RtcManager r1 = this.a.yq();
        if (r1 == null) goto L5;
        r1.f();
    L5:
        InteractAudienceAnchorWidget r2 = this.a;
        r2.y = Math.max(r2.y, r4.size());
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
    public final void b(String r1, String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "userId");
        this.a.yq().f();
    }
}
