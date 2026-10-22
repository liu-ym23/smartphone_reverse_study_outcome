package com.bytedance.android.livesdk.interactivity.api.chatchannel.utils;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.vscore_impl.component.tabs.MultiTabManagerImpl;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.abs.IRoomData;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final boolean a(RoomContext r1) {
        Intrinsics.checkNotNullParameter(r1, "roomContext");
        return b(r1, (IRoomData) r1.getRoom().getValue());
    }

    @JvmStatic
    public static final boolean c(RoomContext r3) {
        nm1.r r0 = pm1.f.o();
        boolean r1 = false;
        if (r0 == null) goto L14;
        r0.a();
        MultiTabManagerImpl r2 = MultiTabManagerImpl.e;
        if (r3 == null) goto L9;
        com.bytedance.live.datacontext.m r4 = r3.getRoom();
        if (r4 == null) goto L9;
        Room r5 = (Room) r4.getValue();
    L10:
        if (r3 == null) goto L13;
        r1 = r3.isVSVerticalStream();
    L13:
        return r2.j(r5, r1);
    L9:
        r5 = null;
        goto L10
    L14:
        return false;
    }

    @JvmStatic
    public static final boolean b(RoomContext r2, IRoomData r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        boolean r1 = e.a;
        if (e.a == true) goto L8;
        return false;
    L8:
        RoomAuthStatus r4 = r3.getRoomAuthStatus();
        if (r4 != null) goto L11;
    L13:
        RoomAuthStatus r5 = r3.getRoomAuthStatus();
        if (r5 != null) goto L16;
    L18:
        RoomAuthStatus r6 = r3.getRoomAuthStatus();
        if (r6 == null) goto L24;
        if (r6.isEnableRoomChannelByAnchor() == true) goto L24;
        return false;
    L24:
        if (c(r2) == false) goto L26;
        return false;
    L26:
        return true;
    L16:
        if (r5.isEnableRoomChannel() == true) goto L18;
        return false;
    L11:
        if (r4.getEnableChat() == true) goto L13;
        return false;
    }
}
