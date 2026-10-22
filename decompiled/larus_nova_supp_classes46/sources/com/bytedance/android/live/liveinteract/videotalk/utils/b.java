package com.bytedance.android.live.liveinteract.videotalk.utils;

import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends com.bytedance.android.live.liveinteract.plantform.base.i.a<ILinkPlayerInfoBridge> {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i.b
    public final void onOnlineListChanged(List<ILinkPlayerInfoBridge> r2) {
        if (r2 == null) goto L5;
        this.a.b(r2);
        return;
    }
}
