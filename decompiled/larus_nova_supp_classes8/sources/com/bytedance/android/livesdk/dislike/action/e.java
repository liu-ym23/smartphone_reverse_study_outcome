package com.bytedance.android.livesdk.dislike.action;

import android.view.View;
import android.widget.ImageView;
import com.bytedance.android.live.core.setting.e0;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.chatroom.utils.k1;
import com.bytedance.android.livesdk.config.no;
import com.bytedance.android.livesdk.dislike.ActionsManager;
import com.bytedance.android.livesdk.dislike.layout.OptionDescItemLayoutV2;
import com.bytedance.android.livesdk.dispatch.utils.DispatchLogUtil;
import com.bytedance.android.livesdk.log.filter.n0;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import zg1.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e extends OptionAction {
    public final ActionsManager e;
    public final ActionsManager f;

    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final cz.c f() {
        return cz.c.e.c;
    }

    public e(ActionsManager r2) {
        Intrinsics.checkNotNullParameter(r2, "actionsManager");
        super(r2);
        this.f = r2;
        this.e = r2;
    }

    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final void a(View r9) {
        Intrinsics.checkNotNullParameter(r9, "v");
        if (am2.n.f().c().length() <= 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L9;
    L26:
        com.bytedance.android.livesdk.dislike.m r1 = this.e.c;
        if (r1 == null) goto L40;
        if (r1.c() != true) goto L40;
        if ((r9 instanceof OptionDescItemLayoutV2) == true) goto L33;
        r9 = null;
    L33:
        OptionDescItemLayoutV2 r10 = (OptionDescItemLayoutV2) r9;
        if (r10 == null) goto L38;
        ImageView r11 = r10.b;
        if (r11 == null) goto L38;
        r11.setImageResource(2131248564);
    L38:
        this.e.c.b();
        g(false);
        return;
    L40:
        if (com.bytedance.android.livesdk.model.b.e() == false) goto L48;
        ActionsManager r12 = this.e;
        if (r12 == null) goto L46;
        com.bytedance.android.livesdk.dislike.m r13 = r12.c;
        if (r13 == null) goto L46;
        r13.refreshData();
    L46:
        g(true);
        return;
    L48:
        if (com.bytedance.android.livesdk.dispatch.utils.a.a() == false) goto L50;
        Lazy r14 = DispatchLogUtil.a;
        DispatchLogUtil.d(0, DispatchLogUtil.InstanceType.DISLIKE);
        xs2.b.a().post(new h1(this.b));
        g(false);
        return;
    L50:
        xs2.b.a().post(new h1(37, this.b));
        g(false);
        return;
    L9:
        if (am2.n.f().c().length() <= 0) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == false) goto L26;
        JSONObject r3 = new JSONObject();
        Room r4 = this.b;
        if (r4 == null) goto L16;
        String r5 = r4.getAnchorId();
    L17:
        r3.put("anchor_id", r5);
        Room r6 = this.b;
        if (r6 == null) goto L20;
        String r7 = r6.getIdStr();
    L21:
        r3.put("room_id", r7);
        r3.put("enter_from_merge", k1.c());
        r3.put("enter_method", k1.d());
        r3.put("action_type", k1.b());
        r3.put("is_dou_plus_ad", am2.n.f().g());
        HashMap r8 = new HashMap();
        r8.put("value", am2.n.f().c());
        r8.put("ad_id", am2.n.f().a());
        r8.put("log_extra", am2.n.f().d());
        ILiveDouPlusService r15 = jc1.k.n(ILiveDouPlusService.class);
        HashMap r16 = new HashMap();
        r16.put("ad_extra_data", r3.toString());
        if (r8.isEmpty() == true) goto L25;
        r16.putAll(r8);
    L25:
        r16.put("refer", "dislike_longpress");
        r15.logEvent(true, "live_ad", "otherclick", r16);
        goto L26
    L20:
        r7 = null;
        goto L21
    L16:
        r5 = null;
        goto L17
    L11:
        r2 = false;
        goto L12
    L5:
        r0 = false;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final void b(View r3) {
        Intrinsics.checkNotNullParameter(r3, "v");
        if (com.bytedance.android.livesdk.model.b.e() == true) goto L10;
        com.bytedance.android.livesdk.dislike.m r0 = this.e.c;
        if (r0 != null) goto L7;
    L9:
        super.b(r3);
        return;
    L7:
        if (r0.c() != true) goto L9;
    L10:
        a(r3);
    }

    public final void g(boolean r17) {
        com.bytedance.android.livesdk.log.filter.o r1 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        String r4 = "";
        if (r1.getMap().containsKey("enter_from_merge") == false) goto L5;
        String r2 = (String) r1.getMap().get("enter_from_merge");
    L7:
        if (r1.getMap().containsKey("enter_method") == false) goto L9;
        String r5 = (String) r1.getMap().get("enter_method");
    L11:
        if (r1.getMap().containsKey("action_type") == false) goto L13;
        String r7 = (String) r1.getMap().get("action_type");
    L15:
        if (r1.getMap().containsKey("video_id") == false) goto L18;
        r4 = (String) r1.getMap().get("video_id");
    L18:
        if (tb1.c.a == false) goto L20;
        r2 = k1.c();
    L20:
        HashMap r3 = new HashMap();
        r3.put("enter_from_merge", r2);
        r3.put("enter_method", r5);
        r3.put("action_type", r7);
        r3.put("request_page", "long_press");
        Room r6 = this.b;
        String r8 = null;
        if (r6 == null) goto L23;
        String r9 = r6.getOwnerUserIdString();
    L24:
        r3.put("to_user_id", r9);
        r3.put("event_page", "live_detail");
        r3.put("is_vr_machine", VrUtils.o(this.f.f));
        r3.put("video_id", r4);
        String r10 = "1";
        if (r17 == false) goto L27;
        Object r11 = "1";
    L28:
        r3.put("is_expand", r11);
        if (r17 == false) goto L31;
        r3.put("layer_show_page", "live_detail");
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_dislike_sort_show", r3, new Object[]{am2.x.class, Room.class, am2.u.class, am2.n.f()});
    L55:
        HashMap r12 = new HashMap(r3);
        Room r13 = this.f.d;
        if (r13 == null) goto L58;
        r8 = r13.getAnchorId();
    L58:
        r12.put("anchor_id", String.valueOf(r8));
        r12.put("event_page", "live_detail");
        if (r17 == true) goto L62;
        r10 = "0";
    L62:
        r12.put("is_second_reason", r10);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_dislike_entrance_click", r12, new Object[]{am2.x.class, Room.class, am2.n.f()});
        if (no.a.getValue().a() == false) goto L66;
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_dislike_entrance_click_v2", r12, new Object[]{am2.x.class, Room.class, am2.n.f()});
        return;
    L66:
        return;
    L31:
        lc0.c r14 = jc1.k.n(ILinkServiceExternal.class).getMultiDataHolderExternal();
        com.bytedance.android.livesdk.log.filter.o r15 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        if ((r15 instanceof n0) == true) goto L34;
        r15 = null;
    L34:
        n0 r16 = (n0) r15;
        if (r16 == null) goto L48;
        String r18 = r16.D();
        if (r18 == null) goto L48;
        if (r18.length() <= 0) goto L41;
        boolean r19 = true;
    L42:
        if (r19 == true) goto L45;
        r18 = null;
    L45:
        if (r18 == null) goto L48;
        r3.put("group_member_id", r18);
        goto L48
    L41:
        r19 = false;
    L48:
        if (((Boolean) e0.a.getValue()).booleanValue() == false) goto L54;
        Room r110 = this.b;
        if (r110 == null) goto L54;
        String r111 = r110.getRequestId();
        if (r111 == null) goto L54;
        r3.put("request_id", r111);
    L54:
        com.bytedance.android.livesdk.log.g r112 = com.bytedance.android.livesdk.log.u.l();
        int r113 = am2.c0.b;
        r112.sendLog("livesdk_dislike", r3, new Object[]{am2.x.class, Room.class, am2.u.class, am2.n.f(), am2.c0.a.a(r14.v())});
        com.bytedance.android.livesdk.log.u.l().sendLog("live_dislike", r3, new Object[]{am2.x.class, Room.class, am2.n.f()});
        goto L55
    L27:
        r11 = "0";
        goto L28
    L23:
        r9 = null;
        goto L24
    L13:
        r7 = "";
        goto L15
    L9:
        r5 = "";
        goto L11
    L5:
        r2 = "";
        goto L7
    }
}
