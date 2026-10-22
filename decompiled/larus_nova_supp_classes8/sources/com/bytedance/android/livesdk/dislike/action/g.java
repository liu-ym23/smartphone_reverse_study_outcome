package com.bytedance.android.livesdk.dislike.action;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.utils.k1;
import com.bytedance.android.livesdk.dislike.ActionsManager;
import com.bytedance.android.livesdk.log.filter.n0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import zg1.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g extends OptionAction {
    public g(ActionsManager r2) {
        Intrinsics.checkNotNullParameter(r2, "actionsManager");
        super(r2);
    }

    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final void a(View r19) {
        Intrinsics.checkNotNullParameter(r19, "v");
        xs2.b.a().post(new h1(53, this.b));
        if (com.bytedance.android.livesdk.dislike.t.a() == false) goto L21;
        HashMap r1 = new HashMap();
        qt1.c.a(r1, this.b);
        r1.put("layer_show_page", "live_detail");
        r1.put("dislike_type", "dislike_content");
        com.bytedance.android.livesdk.log.filter.o r5 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        if ((r5 instanceof n0) == true) goto L7;
        r5 = null;
    L7:
        n0 r6 = (n0) r5;
        if (r6 == null) goto L20;
        String r7 = r6.D();
        if (r7 == null) goto L20;
        if (r7.length() <= 0) goto L14;
        boolean r9 = true;
    L15:
        if (r9 == false) goto L17;
        String r2 = r7;
    L18:
        if (r2 == null) goto L20;
        r1.put("group_member_id", r2);
        goto L20
    L17:
        r2 = null;
        goto L18
    L14:
        r9 = false;
    L20:
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_dislike", r1, new Object[]{am2.x.class, Room.class, am2.u.class, am2.n.f()});
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_dislike_sort_click", r1, new Object[]{am2.x.class, Room.class, am2.u.class, am2.n.f()});
        return;
    L21:
        com.bytedance.android.livesdk.log.filter.o r3 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        String r16 = "";
        if (r3.getMap().containsKey("enter_from_merge") == false) goto L24;
        String r14 = (String) r3.getMap().get("enter_from_merge");
    L26:
        if (r3.getMap().containsKey("enter_method") == false) goto L28;
        String r4 = (String) r3.getMap().get("enter_method");
    L30:
        if (r3.getMap().containsKey("action_type") == false) goto L32;
        String r13 = (String) r3.getMap().get("action_type");
    L33:
        String r17 = r14;
        if (r3.getMap().containsKey("video_id") == false) goto L36;
        r16 = (String) r3.getMap().get("video_id");
    L36:
        String r8 = r16;
        if (tb1.c.a == false) goto L39;
        String r10 = k1.c();
    L40:
        HashMap r11 = new HashMap();
        r11.put("enter_from_merge", r10);
        r11.put("enter_method", r4);
        r11.put("action_type", r13);
        r11.put("request_page", "long_press");
        Room r12 = this.b;
        if (r12 == null) goto L43;
        String r15 = r12.getOwnerUserIdString();
    L44:
        r11.put("to_user_id", String.valueOf(r15));
        r11.put("event_page", "live_detail");
        r11.put("video_id", r8);
        r11.put("dislike_type", "dislike_content");
        com.bytedance.android.livesdk.log.filter.o r18 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        if ((r18 instanceof n0) == true) goto L47;
        r18 = null;
    L47:
        n0 r20 = (n0) r18;
        if (r20 == null) goto L60;
        String r21 = r20.D();
        if (r21 == null) goto L60;
        if (r21.length() <= 0) goto L54;
        boolean r22 = true;
    L55:
        if (r22 == false) goto L57;
        String r23 = r21;
    L58:
        if (r23 == null) goto L60;
        r11.put("group_member_id", r23);
        goto L60
    L57:
        r23 = null;
        goto L58
    L54:
        r22 = false;
    L60:
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_dislike", r11, new Object[]{am2.x.class, Room.class, am2.n.f()});
        com.bytedance.android.livesdk.log.u.l().sendLog("live_dislike", r11, new Object[]{am2.x.class, Room.class, am2.n.f()});
        r11.put("layer_show_page", "live_detail");
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_dislike_sort_click", r11, new Object[]{am2.x.class, Room.class, am2.n.f()});
        return;
    L43:
        r15 = null;
        goto L44
    L39:
        r10 = r17;
        goto L40
    L32:
        r13 = "";
        goto L33
    L28:
        r4 = "";
        goto L30
    L24:
        r14 = "";
        goto L26
    }

    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final void d(Function1<? super Map<String, ? extends Object>, Unit> r5) {
        HashMap r6 = new HashMap();
        qt1.c.a(r6, this.b);
        r6.put("layer_show_page", "live_detail");
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_dislike_sort_show", r6, new Object[]{am2.x.class, Room.class, am2.u.class, am2.n.f()});
    }
}
