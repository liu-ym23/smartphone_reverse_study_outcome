package com.bytedance.android.live.multilink.voicechat.impl.widget;

import com.bytedance.android.livesdk.config.nm;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h implements com.bytedance.android.live.ui.b {
    public final /* synthetic */ MultiLinkVoiceChatRoomAnchorWidget a;

    public final boolean a() {
        if (((Boolean) nm.a.getValue()).booleanValue() == false) goto L7;
        MultiLinkVoiceChatRoomAnchorWidget r0 = this.a;
        int r1 = MultiLinkVoiceChatRoomAnchorWidget.E2;
        if (r0.Zq() == false) goto L7;
        return true;
    L7:
        return false;
    }

    public h(MultiLinkVoiceChatRoomAnchorWidget r1) {
        this.a = r1;
    }
}
