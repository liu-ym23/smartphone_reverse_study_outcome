package com.bytedance.android.livesdk.interactivity.roomintro.v2.secondarydialog;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.android.livesdk.interactivity.roomintro.v2.RoomIntroDataSource;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements LiveSwitchButton.e {
    public final /* synthetic */ PoiSelectDialog a;

    public b(PoiSelectDialog r1) {
        this.a = r1;
    }

    public final void d0(LiveSwitchButton r1, boolean r2) {
        RoomIntroDataSource r3 = this.a.d;
        if (r3 == null) goto L9;
        PropertyOwner<Boolean> r4 = r3.u;
        if (r4 != null) goto L7;
        ALogger.e("RoomIntroDialogV2", "poi is not useable");
        return;
    L7:
        r4.a(Boolean.valueOf(r2));
        return;
    }
}
