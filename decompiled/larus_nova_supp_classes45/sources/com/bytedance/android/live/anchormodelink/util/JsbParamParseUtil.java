package com.bytedance.android.live.anchormodelink.util;

import android.text.TextUtils;
import com.bytedance.android.live.anchormodelink.gift.i;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.plantform.model.LinkedListUserInfo;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import py.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class JsbParamParseUtil {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static i a(JsonObject r15) {
        Intrinsics.checkNotNullParameter(r15, "extraInfo");
        ArrayList r0 = new ArrayList();
        boolean r1 = true;
        JsonElement r16 = r15.get("params");     // Catch: Exception -> L124
        if (r16 == null) goto L123;
        JsonObject r17 = r16.getAsJsonObject();     // Catch: Exception -> L124
        if (r17 == null) goto L123;
        JsonElement r3 = r17.get("isAllowToSendGiftToGuest");     // Catch: Exception -> L124
        if (r3 == null) goto L12;
        boolean r4 = r3.getAsBoolean();     // Catch: Exception -> L124
    L130:
        JsonElement r18 = r17.get("linkedUserList");     // Catch: Exception -> L121
        if (r18 == null) goto L120;
        JsonArray r19 = r18.getAsJsonArray();     // Catch: Exception -> L121
        if (r19 == null) goto L120;
        JsbParamParseUtil$getGiftUserList$1 r5 = JsbParamParseUtil$getGiftUserList$1.INSTANCE;     // Catch: Exception -> L121
        int r6 = r19.size();     // Catch: Exception -> L121
        int r7 = 0;
    L19:
        if (r7 >= r6) goto L127;
        JsonObject r8 = r19.get(r7).getAsJsonObject();     // Catch: Exception -> L121
        LinkPlayerInfo r9 = new LinkPlayerInfo();     // Catch: Exception -> L121
        r9.userPosition = r7;     // Catch: Exception -> L121
        JsonElement r11 = r8.get("user_id");     // Catch: Exception -> L121
        String r12 = "";
        if (r11 == null) goto L25;
        String r13 = r11.getAsString();     // Catch: Exception -> L121
        if (r13 == null) goto L25;
    L26:
        JsonElement r14 = r8.get("user_open_id");     // Catch: Exception -> L121
        if (r14 == null) goto L30;
        String r110 = r14.getAsString();     // Catch: Exception -> L121
        if (r110 == null) goto L30;
    L31:
        JsonElement r111 = r8.get("sec_uid");     // Catch: Exception -> L121
        if (r111 == null) goto L35;
        String r112 = r111.getAsString();     // Catch: Exception -> L121
        if (r112 == null) goto L35;
    L36:
        JsonElement r113 = r8.get("nickname");     // Catch: Exception -> L121
        if (r113 == null) goto L42;
        String r114 = r113.getAsString();     // Catch: Exception -> L121
        if (r114 == null) goto L42;
        r12 = r114;
    L42:
        JsonElement r115 = r8.get("own_room_id");     // Catch: Exception -> L121
        if (r115 == null) goto L45;
        String r116 = r115.getAsString();     // Catch: Exception -> L121
    L46:
        User r117 = new User();     // Catch: Exception -> L121
        r117.setIdString(r13);     // Catch: Exception -> L121
        r117.setSecUid(r112);     // Catch: Exception -> L121
        r117.setNickName(r12);     // Catch: Exception -> L121
        r117.userOpenId = r110;     // Catch: Exception -> L121
        r117.setUserId(r13);     // Catch: Exception -> L121
        r117.set_ownRoom(new User.OwnRoom());     // Catch: Exception -> L121
        if (r116 != null) goto L49;
    L56:
        JsbParamParseUtil$getGiftUserList$1 r21 = JsbParamParseUtil$getGiftUserList$1.INSTANCE;     // Catch: Exception -> L121
        JsonElement r118 = r8.get("avatar_thumb_url");     // Catch: Exception -> L121
        if (r118 == null) goto L59;
        String r119 = r118.getAsString();     // Catch: Exception -> L121
    L60:
        String r120 = r21.invoke(r119);     // Catch: Exception -> L121
        if (r120 != null) goto L63;
    L66:
        boolean r121 = true;
    L67:
        if (r121 == true) goto L69;
        r117.setAvatarThumbImplicit(ImageModel.genBy(r120));     // Catch: Exception -> L121
        r117.setAvatarUrl(r120);     // Catch: Exception -> L121
    L69:
        JsonElement r122 = r8.get("avatar_medium_url");     // Catch: Exception -> L121
        if (r122 == null) goto L72;
        String r123 = r122.getAsString();     // Catch: Exception -> L121
    L73:
        String r22 = r21.invoke(r123);     // Catch: Exception -> L121
        if (r22 != null) goto L76;
    L79:
        boolean r124 = true;
    L80:
        if (r124 == true) goto L82;
        r117.setAvatarMediumImplicit(ImageModel.genBy(r22));     // Catch: Exception -> L121
        r117.setAVatarMediumStr(r22);     // Catch: Exception -> L121
    L82:
        r9.setUser(r117);     // Catch: Exception -> L121
        JsonElement r23 = r8.get("linkmic_id_str");     // Catch: Exception -> L121
        if (r23 == null) goto L85;
        String r24 = r23.getAsString();     // Catch: Exception -> L121
    L86:
        r9.setInteractId(r24);     // Catch: Exception -> L121
        JsonElement r25 = r8.get("linkmic_unique_id");     // Catch: Exception -> L121
        if (r25 == null) goto L89;
        String r26 = r25.getAsString();     // Catch: Exception -> L121
    L90:
        r9.setLinkMicUniqueIdStr(r26);     // Catch: Exception -> L121
        JsonElement r27 = r8.get("role_type");     // Catch: Exception -> L121
        if (r27 == null) goto L93;
        int r28 = r27.getAsInt();     // Catch: Exception -> L121
    L94:
        r9.setRoleType(r28);     // Catch: Exception -> L121
        JsonElement r29 = r8.get("link_type");     // Catch: Exception -> L121
        if (r29 == null) goto L97;
        int r31 = r29.getAsInt();     // Catch: Exception -> L121
    L98:
        r9.setLinkType(r31);     // Catch: Exception -> L121
        JsonElement r32 = r8.get("device_platform");     // Catch: Exception -> L121
        if (r32 == null) goto L101;
        String r33 = r32.getAsString();     // Catch: Exception -> L121
    L102:
        r9.devicePlatform = r33;     // Catch: Exception -> L121
        JsonElement r34 = r8.get("client_version");     // Catch: Exception -> L121
        if (r34 == null) goto L105;
        int r35 = r34.getAsInt();     // Catch: Exception -> L121
    L106:
        r9.clientVersion = r35;     // Catch: Exception -> L121
        JsonElement r36 = r8.get(OpenPlatformBaseDebugger.APP_ID);     // Catch: Exception -> L121
        if (r36 == null) goto L109;
        int r37 = r36.getAsInt();     // Catch: Exception -> L121
    L110:
        r9.appId = r37;     // Catch: Exception -> L121
        JsonElement r38 = r8.get("join_channel_time");     // Catch: Exception -> L121
        if (r38 == null) goto L113;
        int r39 = r38.getAsInt();     // Catch: Exception -> L121
    L114:
        long r41 = r39;
        JsonElement r42 = r8.get("current_time");     // Catch: Exception -> L121
        if (r42 == null) goto L117;
        int r43 = r42.getAsInt();     // Catch: Exception -> L121
    L118:
        long r125 = r43;
        LinkedListUserInfo r44 = new LinkedListUserInfo();     // Catch: Exception -> L121
        r44.joinChannelTime = r41;     // Catch: Exception -> L121
        r44.expectLeaveTime = 0;     // Catch: Exception -> L121
        r44.currentTime = r125;     // Catch: Exception -> L121
        r9.linkedListUserInfo = r44;     // Catch: Exception -> L121
        r9.isOpenSendGift = r4;     // Catch: Exception -> L121
        r0.add(r9);     // Catch: Exception -> L121
        r7 = r7 + 1;
        goto L19
    L117:
        r43 = 0;
        goto L118
    L113:
        r39 = 0;
        goto L114
    L109:
        r37 = 0;
        goto L110
    L105:
        r35 = 0;
        goto L106
    L101:
        r33 = null;
        goto L102
    L97:
        r31 = 0;
        goto L98
    L93:
        r28 = 0;
        goto L94
    L89:
        r26 = null;
        goto L90
    L85:
        r24 = null;
        goto L86
    L76:
        if (r22.length() == 0) goto L79;
        r124 = false;
        goto L80
    L72:
        r123 = null;
        goto L73
    L63:
        if (r120.length() == 0) goto L66;
        r121 = false;
        goto L67
    L59:
        r119 = null;
        goto L60
    L49:
        if (TextUtils.isEmpty(r116) == true) goto L56;
        o r45 = r117.get_ownRoom();     // Catch: Exception -> L121
        if ((r45 instanceof User.OwnRoom) == true) goto L53;
        r45 = null;
    L53:
        User.OwnRoom r46 = (User.OwnRoom) r45;     // Catch: Exception -> L121
        if (r46 == null) goto L56;
        r46.setRoomIdList(CollectionsKt.mutableListOf(new Long[]{Long.valueOf(CastLongProtector.parseLong(r116))}));     // Catch: Exception -> L121
        goto L56
    L45:
        r116 = null;
    L35:
        r112 = "";
    L30:
        r110 = "";
    L25:
        r13 = "";
    L127:
        return new i(r4, r0);
    L120:
        return null;
    L121:
        e = e;
        r1 = r4;
    L125:
        boolean r2 = iy.b.a;
        StringBuilder r47 = new StringBuilder("getGiftUserList parseJson error:");
        e.printStackTrace();
        r47.append(Unit.INSTANCE);
        iy.b.b(r47.toString());
        r4 = r1;
        goto L127
    L12:
        r4 = false;
    L123:
        return null;
    L124:
        e = e;
        goto L125
    }
}
