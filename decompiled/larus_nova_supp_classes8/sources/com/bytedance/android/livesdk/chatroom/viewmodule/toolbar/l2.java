package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import com.bytedance.android.livesdkapi.depend.model.live.Room;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l2 implements BaseActionSheet.a {
    public l2() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.BaseActionSheet.a
    public final void onDismiss() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.BaseActionSheet.a
    public final void onShow() {
        com.bytedance.android.livesdk.log.u.l().sendLog("timing_off_option_show", null, new Object[]{Room.class, am2.x.class});
    }
}
