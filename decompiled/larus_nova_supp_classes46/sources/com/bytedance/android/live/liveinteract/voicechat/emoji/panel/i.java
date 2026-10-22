package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livesdk.chatroom.model.ILinkmicInteractEntrance;
import com.bytedance.android.livesdk.chatroom.model.j1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.LiveChatRoomPanelLynxConfig;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i {
    public static final List<ILinkmicInteractEntrance> a(List<ILinkmicInteractEntrance> r8) {
        ArrayList r0 = new ArrayList();
        if (r8 == null) goto L20;
        Iterator r1 = r8.iterator();
    L6:
        if (r1.hasNext() == false) goto L20;
        ILinkmicInteractEntrance r2 = (ILinkmicInteractEntrance) r1.next();
        long r3 = r2.getEntranceId();
        if (r3 != ILinkmicInteractEntrance.LinkmicInteractEntranceID.LINKMIC_INTERACT_ENTRANCE_ID_ADVENTURE_INVITE.getValue()) goto L10;
    L17:
        boolean r4 = true;
    L18:
        if (r4 == false) goto L6;
        r0.add(r2);
        goto L6
    L10:
        if (r3 == ILinkmicInteractEntrance.LinkmicInteractEntranceID.LINKMIC_INTERACT_ENTRANCE_ID_ADVENTURE_INVITE_LIST.getValue()) goto L17;
        if (r3 == ILinkmicInteractEntrance.LinkmicInteractEntranceID.LINKMIC_INTERACT_ENTRANCE_ID_ADVENTURE_SET_MVP.getValue()) goto L17;
        if (r3 == ILinkmicInteractEntrance.LinkmicInteractEntranceID.LINKMIC_INTERACT_ENTRANCE_ID_ADVENTURE_UNSET_MVP.getValue()) goto L17;
        r4 = false;
    L20:
        if (r8 == null) goto L22;
        r8.removeAll(r0);
    L22:
        return r0;
    }

    public static final String c(j1 r3) {
        Intrinsics.checkNotNullParameter(r3, "entranceList");
        String r0 = ((LiveChatRoomPanelLynxConfig) vm2.c.j.getValue(null, vm2.c.a[8])).getActivityUrl();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        Uri.Builder r1 = UriProtector.parse(r0).buildUpon();
        r1.appendQueryParameter("pos_list", GsonProtectorUtils.toJson(GsonHelper.get(), r3));
        return r1.build().toString();
    }

    public static final void d(List<b> r11) {
        Intrinsics.checkNotNullParameter(r11, "itemList");
        Iterator<T> r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L19;
        b r0 = (b) r12.next();
        long r1 = r0.j.getEntranceId();
        if (r1 == ILinkmicInteractEntrance.LinkmicInteractEntranceID.LINKMIC_INTERACT_ENTRANCE_ID_ADVENTURE_INVITE.getValue()) goto L7;
        if (r1 != ILinkmicInteractEntrance.LinkmicInteractEntranceID.LINKMIC_INTERACT_ENTRANCE_ID_ADVENTURE_INVITE_LIST.getValue()) goto L4;
        if (Intrinsics.areEqual(je0.d.b0(), r0.k) == false) goto L17;
        String r2 = "my_link_interact_panel";
    L18:
        int r3 = com.bytedance.android.live.liveinteract.utils.b.a;
        Intrinsics.checkNotNullParameter(r2, "requestPage");
        HashMap r4 = new HashMap();
        com.bytedance.android.live.liveinteract.utils.b.a(r4);
        r4.put("request_page", r2);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_room_meetgame_invite_message_icon_show", r4, new Object[]{IRoom.class, am2.x.class});
        goto L4
    L17:
        r2 = "other_link_interact_panel";
        goto L18
    L7:
        String r5 = r0.k.toString();
        boolean r6 = b.m(r0.k);
        int r7 = com.bytedance.android.live.liveinteract.utils.b.a;
        Intrinsics.checkNotNullParameter(r5, "toUserId");
        Intrinsics.checkNotNullParameter("link_interact_panel", "requestPage");
        HashMap r8 = new HashMap();
        com.bytedance.android.live.liveinteract.utils.b.a(r8);
        r8.put("to_user_id", r5);
        if (r6 == false) goto L10;
        String r9 = "anchor";
    L11:
        r8.put("to_user_type", r9);
        r8.put("request_page", "link_interact_panel");
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_room_meetgame_invite_icon_show", r8, new Object[]{IRoom.class, am2.x.class});
        goto L4
    L10:
        r9 = "guest";
        goto L11
    }

    public static final List<b> b(Context r5, q0 r6, List<? extends ILinkmicInteractEntrance> r7, String r8) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "action");
        Intrinsics.checkNotNullParameter(r7, "adventureList");
        Intrinsics.checkNotNullParameter(r8, "toUserId");
        ArrayList r0 = new ArrayList();
        Iterator<T> r1 = r7.iterator();
    L4:
        if (r1.hasNext() == false) goto L17;
        ILinkmicInteractEntrance r2 = (ILinkmicInteractEntrance) r1.next();
        if (r2 == null) goto L9;
        if (r2.getStatus() == ILinkmicInteractEntrance.LinkmicEntranceStatus.ENTRANCE_STATUS_UNKONWN.getValue()) goto L4;
    L9:
        if (r2 == null) goto L12;
        if (r2.getStatus() == ILinkmicInteractEntrance.LinkmicEntranceStatus.ENTRANCE_STATUS_SHUTDOWN.getValue()) goto L4;
    L12:
        List r3 = r2.getButtons();
        if (r3 == null) goto L4;
        if ((!r3.isEmpty()) != true) goto L4;
        ListProtector.add(r0, ((ArrayList) r7).indexOf(r2), new b(r5, r2, r6, r8));
        goto L4
    L17:
        return r0;
    }
}
