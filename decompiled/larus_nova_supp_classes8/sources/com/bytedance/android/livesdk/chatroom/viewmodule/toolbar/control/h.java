package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control;

import com.bytedance.android.livesdkapi.depend.model.live.LoadStrategy;
import com.bytedance.android.livesdkapi.depend.model.live.MorePanelData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomOthersData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(Room r1) {
        if (r1 == null) goto L6;
        RoomOthersData r2 = r1.others;
        if (r2 == null) goto L6;
        MorePanelData r3 = r2.getMorePanelInfo();
    L7:
        if (r3 != null) goto L9;
    L11:
        return false;
    L9:
        if (r3.getLoadStrategy() != LoadStrategy.RoomData.getValue()) goto L11;
        return true;
    L6:
        r3 = null;
        goto L7
    }
}
