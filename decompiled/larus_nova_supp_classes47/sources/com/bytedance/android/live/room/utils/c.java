package com.bytedance.android.live.room.utils;

import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.message.model.nm;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomSpecificSceneTypeInfo;
import com.bytedance.android.livesdkapi.depend.model.live.UnionLiveInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tlc.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean b(Room r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        RoomSpecificSceneTypeInfo r1 = r3.getSceneTypeInfo();
        if (r1 != null) goto L8;
        return false;
    L8:
        if (r1.isUnionLiveRoom() != true) goto L18;
        UnionLiveInfo r4 = r3.unionLiveInfo;
        if (r4 == null) goto L12;
        Boolean r5 = r4.hasRealGuestAnchor();
    L14:
        if (Intrinsics.areEqual(r5, Boolean.TRUE) == false) goto L19;
        return true;
    L19:
        return false;
    L12:
        r5 = null;
        goto L14
    L18:
        return false;
    }

    public static void a(DataCenter r6, d r7) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (r7 != null) goto L7;
        return;
    L7:
        if ((r7 instanceof nm) == false) goto L41;
        Room r0 = z.o(r6);
        UnionLiveInfo r8 = ((nm) r7).E();
        if (r8 != null) goto L11;
        return;
    L11:
        UnionLiveInfo r1 = r0.unionLiveInfo;
        boolean r2 = true;
        if (r1 != null) goto L14;
    L16:
        r0.unionLiveInfo = r8;
        if (r0.getSceneTypeInfo() == null) goto L23;
        RoomSpecificSceneTypeInfo r3 = r0.getSceneTypeInfo();
        if ((r3 instanceof RoomSpecificSceneTypeInfo) == true) goto L21;
        r3 = null;
    L21:
        if (r3 == null) goto L24;
        r3.setUnionLiveRoom(Intrinsics.areEqual(r8.hasRealGuestAnchor(), Boolean.TRUE));
    L24:
        r6.put("data_union_room_change", new Object());
        o r9 = u.l().c(Room.class);
        RoomSpecificSceneTypeInfo r4 = r0.getSceneTypeInfo();
        if (r4 != null) goto L27;
    L39:
        r9.getMap().remove("is_joint_room");
        r9.getMap().remove("joint_anchor_id");
        return;
    L27:
        if (r4.isUnionLiveRoom() != true) goto L39;
        r9.getMap().put("is_joint_room", DataType.TRUE);
        String r10 = (String) r6.get("data_joint_anchor_id", "");
        if (r10 != null) goto L31;
    L34:
        if (r2 == false) goto L36;
    L37:
        r10 = r0.getOwnerUserIdString();
    L38:
        r9.getMap().put("joint_anchor_id", r10);
        return;
    L36:
        if (DataType.FALSE.equals(r10) == false) goto L38;
    L31:
        if (StringsKt.isBlank(r10) == true) goto L34;
        r2 = false;
        goto L34
    L23:
        RoomSpecificSceneTypeInfo r5 = new RoomSpecificSceneTypeInfo();
        r5.setUnionLiveRoom(Intrinsics.areEqual(r8.hasRealGuestAnchor(), Boolean.TRUE));
        Unit r12 = Unit.INSTANCE;
        r0.setSceneTypeInfo(r5);
        goto L24
    L14:
        if (r1.equals(r8) != true) goto L16;
        return;
    }
}
