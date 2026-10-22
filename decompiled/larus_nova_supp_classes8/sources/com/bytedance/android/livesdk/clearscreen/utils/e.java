package com.bytedance.android.livesdk.clearscreen.utils;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragment;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final int a(ILiveRoomPlayFragment r3) {
        RoomContext.a r0 = RoomContext.Companion;
        if (r3 == null) goto L9;
        ILiveRoomPlayFragment r4 = r3.getRealAction();
        if (r4 == null) goto L9;
        IRoom r5 = r4.getCurRoom();
        if (r5 == null) goto L9;
        long r1 = r5.getId();
    L10:
        r0.getClass();
        RoomContext r6 = RoomContext.a.a(null, r1);
        if (r6 == null) goto L17;
        m r7 = r6.getCleanMode();
        if (r7 == null) goto L17;
        Integer r8 = (Integer) r7.getValue();
        if (r8 == null) goto L17;
        return r8.intValue();
    L17:
        return 0;
    L9:
        r1 = 0;
        goto L10
    }

    @JvmStatic
    public static final boolean b(ILiveRoomPlayFragment r3) {
        RoomContext.a r0 = RoomContext.Companion;
        if (r3 == null) goto L9;
        ILiveRoomPlayFragment r4 = r3.getRealAction();
        if (r4 == null) goto L9;
        IRoom r5 = r4.getCurRoom();
        if (r5 == null) goto L9;
        long r1 = r5.getRoomId();
    L10:
        r0.getClass();
        RoomContext r6 = RoomContext.a.a(null, r1);
        if (r6 != null) goto L15;
        return false;
    L15:
        return r6.isInSlideClean();
    L9:
        r1 = 0;
        goto L10
    }

    @JvmStatic
    public static final void c(boolean r3, ILiveRoomPlayFragment r4) {
        RoomContext.a r0 = RoomContext.Companion;
        if (r4 == null) goto L9;
        ILiveRoomPlayFragment r5 = r4.getRealAction();
        if (r5 == null) goto L9;
        IRoom r6 = r5.getCurRoom();
        if (r6 == null) goto L9;
        long r1 = r6.getRoomId();
    L10:
        r0.getClass();
        RoomContext r7 = RoomContext.a.a(null, r1);
        if (r7 == null) goto L14;
        r7.setInSlideClean(r3);
        return;
    L14:
        return;
    L9:
        r1 = 0;
        goto L10
    }

    @JvmStatic
    public static final boolean d(DataCenter r3, Room r4) {
        if (wt2.a.g() == false) goto L13;
        RoomContext.a r0 = RoomContext.Companion;
        if (r4 == null) goto L7;
        long r1 = r4.getRoomId();
    L8:
        r0.getClass();
        RoomContext r5 = RoomContext.a.a(r3, r1);
        if (r5 == null) goto L13;
        if (r5.isInSlideClean() != true) goto L13;
        return true;
    L7:
        r1 = 0;
    L13:
        return false;
    }
}
