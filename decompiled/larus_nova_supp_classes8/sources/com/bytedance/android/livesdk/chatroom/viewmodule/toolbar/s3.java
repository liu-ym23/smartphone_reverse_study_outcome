package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcastgame.api.model.ReloadPanelType;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.a30;
import com.bytedance.android.livesdk.config.b30;
import com.bytedance.android.livesdk.live.extension.plugin.api.effectsdk.ILiveWrappedEffectSDKService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
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
public final class s3 implements f10.a {
    public boolean a;
    public boolean b;
    public long c;
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

    public s3(com.bytedance.android.live.broadcastgame.api.model.u r2) {
        Intrinsics.checkNotNullParameter(r2, "interactItem");
        this.d = r2;
    }

    public final void onClick(View r23) {
        Intrinsics.checkNotNullParameter(r23, "view");
        long r4 = System.currentTimeMillis();
        if ((r4 - this.c) <= 500) goto L5;
        boolean r6 = false;
    L6:
        this.c = r4;
        if (r6 == false) goto L9;
        return;
    L9:
        ILiveWrappedEffectSDKService.Companion.getClass();
        ILiveWrappedEffectSDKService r5 = ILiveWrappedEffectSDKService.a.a();
        if (r5 == null) goto L13;
        String r7 = r5.getSdkVersion();
        if (r7 == null) goto L13;
    L14:
        String r8 = this.d.extra;
        LiveSeiUtil.i.getClass();     // Catch: Exception -> L36
        JSONObject r9 = LiveSeiUtil.c(r8);     // Catch: Exception -> L36
        String r10 = r9.optString("button_schema_url");     // Catch: Exception -> L36
        int r12 = ln1.a.a.a;     // Catch: Exception -> L35
        JSONObject r13 = ln1.a.a.b(r9.optString("button_extra"));     // Catch: Exception -> L35
        String r14 = r9.optString("schema");     // Catch: Exception -> L34
        String r15 = r9.optString("app_id");     // Catch: Exception -> L33
        String r16 = r9.optString("plugin_type");     // Catch: Exception -> L32
        String r11 = r9.optString("subscribe_type");     // Catch: Exception -> L31
        String r17 = r9.optString("single_month_price");     // Catch: Exception -> L30
        int r18 = r9.optInt("version_type", -1);     // Catch: Exception -> L29
        String r19 = String.valueOf(r9.optInt("engine_type"));     // Catch: Exception -> L28
        Unit r110 = Unit.INSTANCE;     // Catch: Exception -> L26
    L27:
        String r111 = "";
        int r20 = r18;
    L40:
        this.a = false;
        if (b30.a.getValue().booleanValue() == false) goto L76;
        va1.b r21 = va1.b.a.a;
        String r112 = r14;
        IBroadcastService r113 = (IBroadcastService) r21.a(IBroadcastService.class);
        if (r113 == null) goto L47;
        Set r114 = r113.getRunningInteractPlugins();
        if (r114 == null) goto L47;
        int r115 = r114.size();
    L48:
        IBroadcastService r22 = (IBroadcastService) r21.a(IBroadcastService.class);
        if (r22 == null) goto L51;
        boolean r24 = r22.isPluginRunning(r15);
    L52:
        this.a = r24;
        boolean r25 = com.bytedance.android.live.revenue.core.util.h.a;
        fa0.c r26 = com.bytedance.android.live.revenue.core.util.h.e(fa0.c.class);
        if (r26 == null) goto L72;
        fa0.a r27 = r26.o0();
        if (r27 == null) goto L72;
        if (this.a == true) goto L64;
        String r28 = r27.c;
        if (r28 == null) goto L64;
        LiveSeiUtil.i.getClass();     // Catch: Exception -> L62
        this.a = Intrinsics.areEqual(LiveSeiUtil.c(r28).optString("MiniAppID"), r15);     // Catch: Exception -> L62
        Unit r29 = Unit.INSTANCE;     // Catch: Exception -> L62
    L64:
        if (r27.a == false) goto L72;
        Integer r30 = r27.getType();
        if (r30 == null) goto L72;
        if (r30.intValue() != 7) goto L72;
        r115 = r115 + 1;
    L72:
        if (r115 < a30.a.getValue().intValue()) goto L74;
        boolean r31 = true;
    L75:
        this.b = r31;
    L95:
        IBroadcastService r32 = (IBroadcastService) va1.b.a.a.a(IBroadcastService.class);
        if (r32 == null) goto L102;
        List r33 = r32.getRunningInteractPluginIds();
        if (r33 == null) goto L102;
        if (r33.isEmpty() == true) goto L102;
        boolean r34 = true;
    L103:
        if (r34 == false) goto L105;
    L108:
        boolean r35 = true;
    L109:
        JSONObject r116 = r13;
        boolean r210 = r35;
        RoomContext r36 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r36 == null) goto L115;
        com.bytedance.live.datacontext.n r0 = r36.getDownLoadingInteractEffectId();
        if (r0 == null) goto L115;
        String r1 = (String) r0.getValue();
        if (r1 == null) goto L115;
    L116:
        Pair[] r37 = new Pair[12];
        r37[0] = TuplesKt.to("interact_app_id", r15);
        if (this.a == false) goto L119;
        String r117 = "open";
    L120:
        r37[1] = TuplesKt.to("status", r117);
        r37[2] = TuplesKt.to("interact_app_type", r16);
        r37[3] = TuplesKt.to("effect_sdk_version", r7);
        r37[4] = TuplesKt.to("extension_name", this.d.name);
        r37[5] = TuplesKt.to("extension_type_level2", "lynx");
        r37[6] = TuplesKt.to("use_type", r11);
        r37[7] = TuplesKt.to("engine_type", r19);
        r37[8] = TuplesKt.to("event_page", "interactive_extension_homepage");
        r37[9] = TuplesKt.to("event_name", "live_broadcast_interact_dialog_event");
        r37[10] = TuplesKt.to("price", r17);
        r37[11] = TuplesKt.to("downloading_id", r1);
        Map r2 = MapsKt.mutableMapOf(r37);
        if (r20 <= (-1)) goto L123;
        r2.put("version_type", String.valueOf(r20));
    L123:
        b30 r3 = b30.a;
        if (r3.getValue().booleanValue() == false) goto L127;
        r2.put("is_video_merge", "1");
    L127:
        if (Intrinsics.areEqual(r23.getTag(), "button") == false) goto L170;
        if (this.a == false) goto L140;
        if (r116 != null) goto L203;
    L179:
        xs2.b.a().post(new com.bytedance.android.live.broadcastgame.api.model.f0(this.d.e(), ReloadPanelType.FROM_CAHCE, false, false, 12));
        return;
    L203:
        JSONObject r38 = JSONObjectProtectorUtils.getJSONObject(r116, "app_data");     // Catch: Exception -> L137
        if (r38 == null) goto L179;
        String r39 = JSONObjectProtectorUtils.getString(r38, "close_schema");     // Catch: Exception -> L137
        if (r39 == null) goto L179;
        dp1.a.a(r23, r39, r2, true);     // Catch: Exception -> L137
    L137:
        e = move-exception;
        ALogger.e("ToolbarLiveInteractPluginBehavior", e.getMessage());
        goto L179
    L140:
        if (r210 == false) goto L156;
        Context r40 = r23.getContext();
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_anchor_interactive_extension_conflict_popup", MapsKt.mapOf(TuplesKt.to("action_type", "show")), new Object[]{IRoom.class});
        com.bytedance.android.livesdk.chatroom.view.e r41 = new com.bytedance.android.livesdk.chatroom.view.e(r40, null, null);
        if (this.b == false) goto L148;
        r41.setTitleText(r40.getString(2131917974));
        Object[] r42 = new Object[1];
        if (r3.getValue().booleanValue() == false) goto L146;
        Integer r43 = a30.a.getValue();
    L147:
        r42[0] = r43;
        r41.setContentText(r40.getString(2131917973, r42));
    L149:
        com.bytedance.android.livesdk.widget.z0.a().getClass();
        com.bytedance.android.livesdk.widget.x0.d r44 = new com.bytedance.android.livesdk.widget.x0.d();
        r44.b = r40;
        r44.a = 4;
        r44.l = false;
        r44.f = r41;
        t3 r45 = t3.a;
        com.bytedance.android.livesdk.widget.x0.c[] r46 = r44.g;
        com.bytedance.android.livesdk.widget.x0.c r47 = r46[0];
        if (r47 != null) goto L152;
        r47 = new com.bytedance.android.livesdk.widget.x0.c();
        r46[0] = r47;
    L152:
        r47.a = "我知道了";
        r47.b = r45;
        com.bytedance.android.livesdk.widget.x0.c[] r48 = r44.g;
        com.bytedance.android.livesdk.widget.x0.c r49 = r48[0];
        if (r49 != null) goto L155;
        r49 = new com.bytedance.android.livesdk.widget.x0.c();
        r48[0] = r49;
    L155:
        r49.c = true;
        com.bytedance.android.livesdk.widget.x0.b.g(new com.bytedance.android.livesdk.widget.x0(r44.b, r44));
        goto L179
    L146:
        r43 = 1;
        goto L147
    L148:
        r41.setTitleText(r40.getString(2131917614));
        r41.setContentText(r40.getString(2131917613));
        goto L149
    L156:
        if (r10 == null) goto L165;
        if (r10.length() <= 0) goto L160;
        boolean r50 = true;
    L162:
        if (r50 != true) goto L165;
        dp1.a.a(r23, r10, r2, false);
        xs2.b.a().post(new d10.b(true));
        goto L179
    L160:
        r50 = false;
    L165:
        if (this.a == false) goto L167;
        String r51 = "互动插件关闭失败";
    L168:
        com.bytedance.android.live.core.utils.f2.c(r51, 0);
        goto L179
    L167:
        r51 = "互动插件打开失败";
        goto L168
    L170:
        if (r210 == true) goto L172;
    L178:
        dp1.a.a(r23, r112, r2, false);
        goto L179
    L172:
        if (r3.getValue().booleanValue() == false) goto L178;
        if (this.b == false) goto L178;
        if (this.a == true) goto L178;
        r2.put("repel_status", "plugin");
        r2.put("count_limit", String.valueOf(a30.a.getValue().intValue()));
        goto L178
    L119:
        r117 = "close";
    L115:
        r1 = r111;
        goto L116
    L105:
        if (this.b == true) goto L108;
        r35 = false;
    L102:
        r34 = false;
        goto L103
    L74:
        r31 = false;
        goto L75
    L51:
        r24 = false;
    L47:
        r115 = 0;
        goto L48
    L76:
        r10 = r10;
        r112 = r14;
        boolean r52 = com.bytedance.android.live.revenue.core.util.h.a;
        fa0.c r53 = com.bytedance.android.live.revenue.core.util.h.e(fa0.c.class);
        if (r53 == null) goto L95;
        fa0.a r54 = r53.o0();
        if (r54 == null) goto L95;
        String r55 = r54.c;
        if (r55 == null) goto L86;
        LiveSeiUtil.i.getClass();     // Catch: Exception -> L84
        this.a = Intrinsics.areEqual(LiveSeiUtil.c(r55).optString("MiniAppID"), r15);     // Catch: Exception -> L84
        Unit r56 = Unit.INSTANCE;     // Catch: Exception -> L84
    L86:
        if (r54.a == false) goto L93;
        Integer r57 = r54.getType();
        if (r57 == null) goto L93;
        if (r57.intValue() != 7) goto L93;
        boolean r58 = true;
    L94:
        this.b = r58;
    L93:
        r58 = false;
    L28:
        r19 = "";
        r20 = r18;
        r111 = r19;
    L39:
        r19 = "";
        r111 = r19;
        r20 = -1;
    L30:
        r17 = "";
    L31:
        r17 = "";
        r11 = r17;
    L32:
        r17 = "";
        r11 = r17;
        r16 = r11;
    L33:
        r17 = "";
        r11 = r17;
        r15 = r11;
        r16 = r15;
    L38:
        r17 = "";
        r11 = r17;
        r15 = r11;
        r16 = r15;
        r14 = null;
    L37:
        r13 = null;
    L36:
        r10 = null;
    L13:
        r7 = "";
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
