package com.bytedance.android.live.multilink.voicechat.impl.widget;

import com.bytedance.android.livesdk.config.nm;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class v implements com.bytedance.android.live.ui.b {
    public final /* synthetic */ MultiLinkVoiceChatRoomGuestWidget a;

    public final boolean a() {
        if (((Boolean) nm.a.getValue()).booleanValue() == false) goto L7;
        MultiLinkVoiceChatRoomGuestWidget r0 = this.a;
        int r1 = MultiLinkVoiceChatRoomGuestWidget.e3;
        if (r0.jr() == false) goto L7;
        return true;
    L7:
        return false;
    }

    public v(MultiLinkVoiceChatRoomGuestWidget r1) {
        this.a = r1;
    }
}
