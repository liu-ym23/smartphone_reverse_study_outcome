package com.bytedance.android.livesdk.interactivity.roomintro.view;

import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class w implements LiveSwitchButton.e {
    public final /* synthetic */ RoomIntroDialogV2 a;

    public w(RoomIntroDialogV2 r1) {
        this.a = r1;
    }

    public final void d0(LiveSwitchButton r2, boolean r3) {
        RoomIntroDialogV2 r4 = this.a;
        int r0 = RoomIntroDialogV2.u;
        r4.X90(r3);
        if (r3 == true) goto L6;
        RoomIntroDialogV2.W90(this.a, false);
        return;
    }
}
