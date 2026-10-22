package com.bytedance.android.live.lynx.components;

import com.bytedance.android.live.room.api.ILiveShareService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j implements com.bytedance.ies.web.jsbridge2.f.b {
    public final /* synthetic */ LiveLynxFragment a;

    public j(LiveLynxFragment r1) {
        this.a = r1;
    }

    public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
        return jc1.k.n(ILiveShareService.class).getSharePanelMethod(this.a);
    }
}
