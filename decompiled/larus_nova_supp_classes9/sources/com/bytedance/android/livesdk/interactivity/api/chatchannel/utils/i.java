package com.bytedance.android.livesdk.interactivity.api.chatchannel.utils;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(String r2, String r3, String r4, String r5, String r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r2, "tabName");
        Intrinsics.checkNotNullParameter(r3, "showArea");
        Intrinsics.checkNotNullParameter(r4, "createType");
        Intrinsics.checkNotNullParameter(r5, "isOwner");
        Intrinsics.checkNotNullParameter(r6, "subType");
        Intrinsics.checkNotNullParameter(r7, "channelId");
        Intrinsics.checkNotNullParameter(r8, "createAppId");
        Map r9 = MapsKt.mapOf(new Pair[]{TuplesKt.to("tab_name", r2), TuplesKt.to("show_type", r3), TuplesKt.to("create_type", r4), TuplesKt.to("is_creator", r5), TuplesKt.to("sub_create_type", r6), TuplesKt.to("channel_id", r7), TuplesKt.to("create_app_id", r8)});
        j0.l().sendLog("livesdk_live_message_red_dot_reach", r9, new Object[]{am2.x.class, Room.class});
    }

    @JvmStatic
    public static final void a(boolean r6, String r7, String r8, boolean r9, String r10, String r11, String r13, boolean r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r7, "showType");
        Intrinsics.checkNotNullParameter(r8, "createType");
        Intrinsics.checkNotNullParameter(r10, "subCreateType");
        Intrinsics.checkNotNullParameter(r11, "channelId");
        Intrinsics.checkNotNullParameter(r13, "createAppId");
        Pair[] r0 = new Pair[9];
        r0[0] = TuplesKt.to("tab_name", "private_chat");
        String r1 = "1";
        if (r6 == false) goto L5;
        Object r16 = "1";
    L6:
        r0[1] = TuplesKt.to("is_red", r16);
        r0[2] = TuplesKt.to("show_type", r7);
        r0[3] = TuplesKt.to("create_type", r8);
        if (r9 == false) goto L9;
        Object r17 = "1";
    L10:
        r0[4] = TuplesKt.to("is_creator", r17);
        r0[5] = TuplesKt.to("sub_create_type", r10);
        r0[6] = TuplesKt.to("channel_id", r11);
        r0[7] = TuplesKt.to("create_app_id", r13);
        if (r14 == false) goto L13;
        Object r18 = "1";
    L14:
        r0[8] = TuplesKt.to("join_status", r18);
        Map r19 = MapsKt.mutableMapOf(r0);
        if (r15 == false) goto L17;
        r1 = "0";
    L17:
        if (r9 == true) goto L19;
        r19.put("is_qualified", r1);
    L19:
        MiddlewareRoomContext.a r20 = MiddlewareRoomContext.Companion;
        MiddlewareRoomContext r110 = MiddlewareRoomContext.a.c(r20, null, 0, 3);
        if (r110 == null) goto L26;
        com.bytedance.live.datacontext.i r111 = r110.isAnchor();
        if (r111 == null) goto L26;
        if (((Boolean) r111.getValue()).booleanValue() != true) goto L26;
        String r21 = "anchor";
    L36:
        r19.put("user_type", r21);
        j0.l().sendLog("livesdk_live_message_tab_show", r19, new Object[]{am2.x.class, Room.class});
        return;
    L26:
        MiddlewareRoomContext r23 = MiddlewareRoomContext.a.c(r20, null, 0, 3);
        if (r23 == null) goto L35;
        com.bytedance.live.datacontext.m r24 = r23.getUser();
        if (r24 == null) goto L35;
        User r25 = (User) r24.getValue();
        if (r25 == null) goto L35;
        if (com.bytedance.android.live.base.model.user.o.b(r25) != true) goto L35;
        r21 = "admin";
    L35:
        r21 = "user";
        goto L36
    L13:
        r18 = "0";
        goto L14
    L9:
        r17 = "0";
        goto L10
    L5:
        r16 = "0";
        goto L6
    }
}
