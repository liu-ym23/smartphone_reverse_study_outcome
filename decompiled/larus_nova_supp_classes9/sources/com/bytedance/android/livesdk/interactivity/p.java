package com.bytedance.android.livesdk.interactivity;

import com.bytedance.android.live.openplatform.api.utils.SchemaInfo;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.utils.g4;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static /* synthetic */ Pair b(String r7, String r8, String r9, String r10, String r11, String r13) {
        return a(r7, r8, r9, r10, r11, r13, false);
    }

    @JvmStatic
    public static final Pair<String, Map<String, String>> a(String r8, String r9, String r10, String r11, String r13, String r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r9, "entranceForm");
        Intrinsics.checkNotNullParameter(r10, "enterFromMerge");
        Intrinsics.checkNotNullParameter(r11, "enterPosition");
        Intrinsics.checkNotNullParameter(r13, "location");
        Intrinsics.checkNotNullParameter(r14, "scene");
        SchemaInfo.a r2 = new SchemaInfo.a(r8);
        JSONObject r16 = new JSONObject();
        r16.put("normal_height_split_rate", "0.6");
        if (r15 == false) goto L5;
        r2.e("live_share", "1");
    L5:
        Intrinsics.checkNotNullParameter("launch_config", "key");
        Intrinsics.checkNotNullParameter(r16, "rawValue");
        LinkedHashMap r3 = r2.a;
        SchemaInfo.s.getClass();
        r3.put("launch_config", SchemaInfo.b.c(r16));
        r2.f(SchemaInfo.LaunchMode.HOST_STACK);
        r2.b("entrance_form", r9);
        RoomContext.a r17 = RoomContext.Companion;
        String r18 = null;
        RoomContext r6 = RoomContext.a.c(r17, null, 0, 3);
        if (r6 == null) goto L12;
        com.bytedance.live.datacontext.m r7 = r6.getRoom();
        if (r7 == null) goto L12;
        Room r19 = (Room) r7.getValue();
        if (r19 == null) goto L12;
        Long r20 = Long.valueOf(r19.id);
    L13:
        r2.b("room_id", String.valueOf(r20));
        RoomContext r21 = RoomContext.a.c(r17, null, 0, 3);
        if (r21 == null) goto L20;
        com.bytedance.live.datacontext.m r23 = r21.getRoom();
        if (r23 == null) goto L20;
        Room r24 = (Room) r23.getValue();
        if (r24 == null) goto L20;
        String r25 = r24.getRequestId();
    L21:
        r2.b("request_id", String.valueOf(r25));
        RoomContext r26 = RoomContext.a.c(r17, null, 0, 3);
        if (r26 == null) goto L28;
        com.bytedance.live.datacontext.m r27 = r26.getRoom();
        if (r27 == null) goto L28;
        Room r28 = (Room) r27.getValue();
        if (r28 == null) goto L28;
        String r29 = r28.getOwnerUserIdString();
    L29:
        r2.b("anchor_id", String.valueOf(r29));
        r2.b("live_enter_method", g4.e());
        r2.b("live_action_type", g4.c());
        r2.b("enter_from_merge", r10);
        r2.b("enter_position", r11);
        Intrinsics.checkNotNullParameter(r14, "scene");
        r2.a.put("scene", r14);
        Intrinsics.checkNotNullParameter("live", "launchFrom");
        r2.b("launch_from", "live");
        Intrinsics.checkNotNullParameter(r13, "location");
        r2.b("location", r13);
        SchemaInfo r110 = r2.c();
        if (r110 != null) goto L32;
        return null;
    L32:
        String r111 = r110.h();
        LinkedHashMap r4 = new LinkedHashMap();
        r4.put("_param_for_special", "micro_app");
        r4.put("mp_id", r110.a());
        JSONObject r5 = r110.b();
        String r30 = BuildConfig.FLAVOR;
        if (r5 == null) goto L36;
        String r31 = JSONObjectProtectorUtils.getString(r5, "entrance_form");
        if (r31 == null) goto L36;
    L37:
        r4.put("entrance_form", r31);
        JSONObject r33 = r110.b();
        if (r33 == null) goto L41;
        String r34 = JSONObjectProtectorUtils.getString(r33, "enter_from_merge");
        if (r34 == null) goto L41;
    L42:
        r4.put("enter_from_merge", r34);
        JSONObject r35 = r110.b();
        if (r35 == null) goto L46;
        String r36 = JSONObjectProtectorUtils.getString(r35, "enter_position");
        if (r36 == null) goto L46;
    L47:
        r4.put("enter_position", r36);
        String r37 = r110.d;
        boolean r112 = true;
        if (r37 == "UNINITIALIZED_STRING") goto L50;
        boolean r38 = true;
    L51:
        if (r38 == true) goto L54;
        r37 = null;
    L54:
        if (r37 != null) goto L56;
        r37 = String.valueOf(r110.c("scene"));
        r110.d = r37;
    L56:
        r4.put("scene", r37);
        String r39 = r110.l;
        if (r39 == "UNINITIALIZED_STRING") goto L59;
        boolean r40 = true;
    L60:
        if (r40 == true) goto L63;
        r39 = null;
    L63:
        if (r39 != null) goto L78;
        JSONObject r41 = r110.b();
        if (r41 == null) goto L67;
        r18 = r41.optString("launch_from");
    L67:
        if (r18 != null) goto L69;
    L72:
        if (r112 == true) goto L74;
        r39 = r18;
    L77:
        r110.l = r39;
        goto L78
    L74:
        r39 = r110.c("launch_from");
        if (r39 != null) goto L77;
        r39 = BuildConfig.FLAVOR;
        goto L77
    L69:
        if (r18.length() == 0) goto L72;
        r112 = false;
    L78:
        r4.put("launch_from", r39);
        r4.put("location", r110.d());
        String r43 = r110.f();
        if (r43 != null) goto L81;
        r43 = BuildConfig.FLAVOR;
    L81:
        r4.put("path", r43);
        String r44 = r110.g();
        if (r44 != null) goto L84;
        r44 = BuildConfig.FLAVOR;
    L84:
        r4.put("query", r44);
        JSONObject r45 = r110.b();
        if (r45 == null) goto L90;
        String r46 = r45.toString();
        if (r46 == null) goto L90;
        r30 = r46;
    L90:
        r4.put("bdp_log", r30);
        return new Pair(r111, r4);
    L59:
        r40 = false;
        goto L60
    L50:
        r38 = false;
    L46:
        r36 = BuildConfig.FLAVOR;
    L41:
        r34 = BuildConfig.FLAVOR;
    L36:
        r31 = BuildConfig.FLAVOR;
    L28:
        r29 = null;
    L20:
        r25 = null;
    L12:
        r20 = null;
        goto L13
    }
}
