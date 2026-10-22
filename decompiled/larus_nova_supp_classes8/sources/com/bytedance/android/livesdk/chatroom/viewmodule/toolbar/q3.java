package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcastgame.api.model.ReloadPanelType;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.b30;
import com.bytedance.android.livesdk.config.f30;
import com.bytedance.android.livesdk.config.g30;
import com.bytedance.android.livesdk.live.extension.plugin.api.effectsdk.ILiveWrappedEffectSDKService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q3 implements f10.a {
    public long a;
    public boolean b;
    public boolean c;
    public com.bytedance.android.live.broadcastgame.api.model.u d;

    public static final class a {
    }

    static {
    }

    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    public final /* synthetic */ void R9(View r1, DataCenter r2) {
    }

    public final /* synthetic */ void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    public final /* synthetic */ void Y6() {
    }

    public final /* synthetic */ void dv(e r1) {
    }

    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    public final /* synthetic */ void onHide(boolean r1) {
    }

    public final void p4(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
    }

    public final /* synthetic */ void setAlpha(float r1) {
    }

    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public q3(com.bytedance.android.live.broadcastgame.api.model.u r2) {
        Intrinsics.checkNotNullParameter(r2, "interactItem");
        this.d = r2;
    }

    public final boolean a(String r5) {
        LinkedHashMap r1 = new LinkedHashMap();
        String r2 = this.d.extra;
        LiveSeiUtil.i.getClass();     // Catch: Exception -> L5
        String r0 = (String) r1.put("relate_effect_id", LiveSeiUtil.c(r2).optString("relate_effect_id"));     // Catch: Exception -> L5
    L6:
        IBroadcastService r3 = jc1.k.f(IBroadcastService.class);
        if (r3 != null) goto L13;
        return false;
    L13:
        return r3.openPluginMiniApp(r5, this.d.e(), null, r1);
    }

    public final void onClick(View r22) {
        Intrinsics.checkNotNullParameter(r22, "view");
        long r4 = System.currentTimeMillis();
        if ((r4 - this.a) <= 500) goto L5;
        boolean r6 = false;
    L6:
        this.a = r4;
        if (r6 == false) goto L9;
        return;
    L9:
        IBroadcastService r5 = (IBroadcastService) va1.b.a.a.a(IBroadcastService.class);
        ILiveWrappedEffectSDKService.Companion.getClass();
        ILiveWrappedEffectSDKService r7 = ILiveWrappedEffectSDKService.a.a();
        if (r7 == null) goto L13;
        String r8 = r7.getSdkVersion();
        if (r8 == null) goto L13;
    L14:
        String r9 = this.d.extra;
        LiveSeiUtil.i.getClass();     // Catch: Exception -> L33
        JSONObject r10 = LiveSeiUtil.c(r9);     // Catch: Exception -> L33
        String r12 = r10.optString("button_schema_url");     // Catch: Exception -> L33
        int r13 = ln1.a.a.a;     // Catch: Exception -> L32
        JSONObject r14 = ln1.a.a.b(r10.optString("button_extra"));     // Catch: Exception -> L32
        String r15 = r10.optString("app_id");     // Catch: Exception -> L31
        String r16 = r10.optString("schema");     // Catch: Exception -> L30
        String r11 = r10.optString("plugin_type");     // Catch: Exception -> L28
        String r17 = String.valueOf(r10.optInt("engine_type"));     // Catch: Exception -> L27
        int r18 = r10.optInt("version_type", -1);     // Catch: Exception -> L26
        Unit r19 = Unit.INSTANCE;     // Catch: Exception -> L24
    L25:
        String r20 = r17;
    L36:
        g30 r110 = g30.a;
        if (((Boolean) r110.getValue()).booleanValue() == false) goto L39;
    L70:
        if (r5 == null) goto L74;
        List r21 = r5.getRunningInteractPluginIds();
        if (r21 == null) goto L74;
        boolean r23 = r21.contains(r15);
    L75:
        this.b = r23;
        if (r5 == null) goto L80;
        List r24 = r5.getRunningInteractPluginIds();
        if (r24 == null) goto L80;
        boolean r25 = r24.contains(r15);
    L81:
        if (r25 == false) goto L83;
        String r26 = "open";
        boolean r111 = true;
    L84:
        String r27 = r16;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L90;
        com.bytedance.live.datacontext.n r1 = r0.getDownLoadingInteractEffectId();
        if (r1 == null) goto L90;
        String r2 = (String) r1.getValue();
        if (r2 == null) goto L90;
    L91:
        Map r3 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("interact_app_id", r15), TuplesKt.to("status", r26), TuplesKt.to("interact_app_type", r11), TuplesKt.to("effect_sdk_version", r8), TuplesKt.to("downloading_id", r2), TuplesKt.to("engine_type", r20), TuplesKt.to("event_name", "live_broadcast_interact_dialog_event"), TuplesKt.to("extension_type_level2", "小程序")});
        if (r18 <= (-1)) goto L97;
        if (((Boolean) f30.a.getValue()).booleanValue() == false) goto L97;
        r3.put("version_type", String.valueOf(r18));
    L97:
        if (Intrinsics.areEqual(r22.getTag(), "button") == false) goto L137;
        IBroadcastService r28 = jc1.k.f(IBroadcastService.class);
        if (r14 == null) goto L101;
        Object r29 = r14.get("entrance_type");
    L102:
        if (r111 == true) goto L145;
        q3 r30 = this;
        if (((Boolean) r110.getValue()).booleanValue() == true) goto L129;
        if (r30.c == false) goto L129;
        Context r31 = r22.getContext();
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_anchor_interactive_extension_conflict_popup", MapsKt.mapOf(TuplesKt.to("action_type", "show")), new Object[]{IRoom.class});
        com.bytedance.android.livesdk.chatroom.view.e r32 = new com.bytedance.android.livesdk.chatroom.view.e(r31, r31.getString(2131917614), r31.getString(2131917613));
        com.bytedance.android.livesdk.widget.z0.a().getClass();
        com.bytedance.android.livesdk.widget.x0.d r33 = new com.bytedance.android.livesdk.widget.x0.d();
        r33.b = r31;
        r33.a = 4;
        r33.l = false;
        r33.f = r32;
        r3 r34 = r3.a;
        com.bytedance.android.livesdk.widget.x0.c[] r35 = r33.g;
        com.bytedance.android.livesdk.widget.x0.c r36 = r35[0];
        if (r36 != null) goto L124;
        r36 = new com.bytedance.android.livesdk.widget.x0.c();
        r35[0] = r36;
    L124:
        r36.a = "我知道了";
        r36.b = r34;
        com.bytedance.android.livesdk.widget.x0.c[] r37 = r33.g;
        com.bytedance.android.livesdk.widget.x0.c r38 = r37[0];
        if (r38 != null) goto L127;
        r38 = new com.bytedance.android.livesdk.widget.x0.c();
        r37[0] = r38;
    L127:
        r38.c = true;
        com.bytedance.android.livesdk.widget.x0.b.g(new com.bytedance.android.livesdk.widget.x0(r33.b, r33));
    L143:
        xs2.b.a().post(new com.bytedance.android.live.broadcastgame.api.model.f0(r30.d.e(), ReloadPanelType.FROM_CAHCE, false, r30.b, 4));
        return;
    L129:
        if (Intrinsics.areEqual(r29, "open_plugin") == false) goto L134;
        if (r30.a(r12) == false) goto L143;
        xs2.b.a().post(new d10.b(true));
        goto L143
    L134:
        if (Intrinsics.areEqual(r29, "open_url") == false) goto L136;
        dp1.a.a(r22, r12, r3, false);
        goto L143
    L136:
        com.bytedance.android.live.core.utils.f2.c("互动工具打开失败", 0);
        goto L143
    L145:
        int r39 = ln1.a.a.a;     // Catch: Exception -> L113
        if (r14 == null) goto L106;
        String r40 = JSONObjectProtectorUtils.getString(r14, "app_data");     // Catch: Exception -> L113
    L107:
        JSONObject r41 = ln1.a.a.b(r40);     // Catch: Exception -> L113
        if (r41 == null) goto L110;
        String r42 = JSONObjectProtectorUtils.getString(r41, "close_schema");     // Catch: Exception -> L113
    L111:
        dp1.a.a(r22, r42, r3, true);     // Catch: Exception -> L113
    L116:
        r30 = this;
        goto L143
    L110:
        r42 = null;
        goto L111
    L106:
        r40 = null;
    L114:
        if (r28 == null) goto L116;
        r30 = this;
        r28.closeInteractPluginCard(r30.d.e(), true);
        goto L143
    L101:
        r29 = null;
        goto L102
    L137:
        r30 = this;
        if (r111 == true) goto L140;
        dp1.a.a(r22, r27, r3, false);
        goto L143
    L140:
        if (r30.a(r12) == false) goto L143;
        xs2.b.a().post(new d10.b(true));
    L90:
        r2 = "";
        goto L91
    L83:
        r26 = "close";
        r111 = false;
    L80:
        r25 = false;
    L74:
        r23 = false;
        goto L75
    L39:
        if (b30.a.getValue().booleanValue() == false) goto L47;
        IBroadcastService r43 = (IBroadcastService) va1.b.a.a.a(IBroadcastService.class);
        if (r43 == null) goto L47;
        Set r44 = r43.getRunningInteractPlugins();
        if (r44 == null) goto L47;
        if ((!r44.isEmpty()) != true) goto L47;
    L58:
        boolean r45 = true;
    L60:
        if (r5 == null) goto L66;
        List r112 = r5.getRunningInteractPluginIds();
        if (r112 == null) goto L66;
        if (r112.isEmpty() == true) goto L66;
        boolean r113 = true;
    L67:
        if (r45 == true) goto L69;
        if (r113 == false) goto L70;
    L69:
        this.c = true;
    L66:
        r113 = false;
    L47:
        boolean r46 = com.bytedance.android.live.revenue.core.util.h.a;
        fa0.c r47 = com.bytedance.android.live.revenue.core.util.h.e(fa0.c.class);
        if (r47 == null) goto L59;
        fa0.a r48 = r47.o0();
        if (r48 == null) goto L59;
        if (r48.a == false) goto L59;
        Integer r49 = r48.getType();
        if (r49 == null) goto L59;
        if (r49.intValue() == 7) goto L58;
    L59:
        r45 = false;
    L29:
        r20 = r17;
        r18 = -1;
    L27:
        r17 = "";
    L28:
        r11 = "";
        r17 = r11;
    L35:
        r20 = "";
        r11 = r20;
        r18 = -1;
        r16 = null;
    L31:
        r15 = "";
    L34:
        r15 = "";
        r14 = null;
    L33:
        r12 = null;
    L13:
        r8 = "";
        goto L14
    L5:
        r6 = true;
        goto L6
    }

    public final void xg(com.bytedance.android.live.broadcastgame.api.model.u r2) {
        Intrinsics.checkNotNullParameter(r2, "interactItem");
        Intrinsics.checkNotNullParameter(r2, "interactItem");
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }
}
