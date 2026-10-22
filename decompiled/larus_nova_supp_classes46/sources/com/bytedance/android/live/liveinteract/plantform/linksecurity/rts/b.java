package com.bytedance.android.live.liveinteract.plantform.linksecurity.rts;

import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends i.a<ILinkPlayerInfoBridge> {
    public final /* synthetic */ RTSVideoWidget a;

    public b(RTSVideoWidget r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i.b
    public final void onOnlineListChanged(List<ILinkPlayerInfoBridge> r2) {
        this.a.xq(r2);
    }
}
