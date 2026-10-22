package com.bytedance.android.livesdk.chatroom.utils;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class z implements com.bytedance.android.livesdk.log.filter.v {
    public static final com.bytedance.android.livesdk.log.b a = null;
    public static final z b = null;

    public z() {
    }

    static {
        b = new z();
        a = new com.bytedance.android.livesdk.log.b("GamePromoteInjector", null);
    }

    public final void Rd() {
        a.a("added");
    }

    public final void onRemove() {
        a.a("removed");
    }

    public final void L9(String r6, Map<String, String> r7) {
        Intrinsics.checkNotNullParameter(r6, "eventName");
        Intrinsics.checkNotNullParameter(r7, "params");
        switch(r6.hashCode()) {
            case -1122536402: goto L72;
            case -1115849514: goto L42;
            case -1103263308: goto L39;
            case -804282046: goto L36;
            case -505186085: goto L33;
            case 21313630: goto L30;
            case 479193863: goto L27;
            case 516631638: goto L24;
            case 1059589542: goto L21;
            case 1499179894: goto L18;
            case 1499265855: goto L15;
            case 2009019068: goto L12;
            case 2022034541: goto L9;
            case 2041791848: goto L6;
            default: goto L111;
        };
    L111:
        return;
    L6:
        if (r6.equals("livesdk_like") == false) goto L89;
    L43:
        com.bytedance.android.livesdk.log.filter.i r8 = com.bytedance.android.livesdk.log.u.l().c(am2.f.class);
        if ((r8 instanceof com.bytedance.android.livesdk.log.filter.i) == false) goto L102;
        Map r9 = ((com.bytedance.android.livesdk.log.filter.a) r8).b;
        if (r9 == null) goto L103;
        String r4 = (String) r9.get("enter_from");
        if (r4 == null) goto L50;
        r7.put("enter_from", r4);
    L50:
        String r5 = (String) r9.get("promote_game_id");
        if (r5 == null) goto L53;
        r7.put("promote_game_id", r5);
    L53:
        String r10 = (String) r9.get("promote_game_name");
        if (r10 == null) goto L56;
        r7.put("promote_game_name", r10);
    L56:
        String r11 = (String) r9.get("promote_scene");
        if (r11 == null) goto L59;
        r7.put("promote_scene", r11);
    L59:
        String r12 = (String) r9.get("order");
        if (r12 == null) goto L62;
        r7.put("order", r12);
    L62:
        String r13 = (String) r9.get("label");
        if (r13 == null) goto L65;
        r7.put("label", r13);
    L65:
        String r0 = (String) r9.get("promote_instance_id");
        if (r0 == null) goto L68;
        r7.put("dygame_promote_instance_id", r0);
    L68:
        String r14 = (String) r9.get("game_ranklist_id");
        if (r14 == null) goto L104;
        r7.put("game_ranklist_id", r14);
        return;
    L104:
        return;
    L103:
        return;
    L102:
        return;
    L89:
        return;
    L9:
        if (r6.equals("livesdk_watch_onemin") == false) goto L90;
    L73:
        com.bytedance.android.livesdk.log.filter.o r15 = com.bytedance.android.livesdk.log.u.l().c(am2.f.class);
        if (r15 != null) goto L76;
        return;
    L76:
        if ((r15 instanceof com.bytedance.android.livesdk.log.filter.i) == true) goto L79;
        r15 = null;
    L79:
        if (r15 == null) goto L108;
        Map r16 = r15.getMap();
        if (r16 == null) goto L109;
        String r1 = (String) r16.get("promote_instance_id");
        if (r1 == null) goto L85;
        r7.put("dygame_promote_instance_id", r1);
    L85:
        String r17 = (String) r16.get("game_ranklist_id");
        if (r17 == null) goto L110;
        r7.put("game_ranklist_id", r17);
        return;
    L110:
        return;
    L109:
        return;
    L108:
        return;
    L90:
        return;
    L12:
        if (r6.equals("livesdk_recharge_success") == true) goto L73;
        return;
    L15:
        if (r6.equals("livesdk_live_show") == true) goto L73;
        return;
    L18:
        if (r6.equals("livesdk_live_play") == true) goto L43;
        return;
    L21:
        if (r6.equals("livesdk_live_user_report") == true) goto L73;
        return;
    L24:
        if (r6.equals("livesdk_send_gift") == true) goto L43;
        return;
    L27:
        if (r6.equals("livesdk_rec_live_play") == true) goto L73;
        return;
    L30:
        if (r6.equals("livesdk_audience_live_message") == true) goto L43;
        return;
    L33:
        if (r6.equals("livesdk_unfollow") == true) goto L73;
        return;
    L36:
        if (r6.equals("livesdk_follow") == true) goto L43;
        return;
    L39:
        if (r6.equals("livesdk_dislike") == true) goto L73;
        return;
    L42:
        if (r6.equals("livesdk_live_duration") == true) goto L43;
        return;
    L72:
        if (r6.equals("livesdk_share") == true) goto L73;
    }
}
