package com.bytedance.android.live.screenrotate.rotate;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements com.bytedance.android.live.room.api.screenrotation.rotate.d {
    public final DataCenter a;
    public final RoomContext b;

    @Override // com.bytedance.android.live.room.api.screenrotation.rotate.d
    public final RoomContext a() {
        return this.b;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.rotate.d
    public final DataCenter b() {
        return this.a;
    }

    public a(DataCenter r1, RoomContext r2) {
        this.a = r1;
        this.b = r2;
        if (r2 == null) goto L10;
        m r3 = r2.getRoom();
        if (r3 == null) goto L11;
        Room r4 = (Room) r3.getValue();
        if (r4 == null) goto L12;
        r4.getRoomId();
        return;
    L12:
        return;
    L11:
        return;
    }
}
