package com.bytedance.android.livesdk.chatroom.ui.setting;

import android.content.Context;
import android.graphics.Rect;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.model.interact.IAudioSubtitleContent;
import com.bytedance.android.livesdk.chatroom.utils.b0;
import com.bytedance.android.livesdk.config.db;
import com.bytedance.android.livesdk.config.dd;
import com.bytedance.android.livesdk.config.ez;
import com.bytedance.android.livesdk.config.jb;
import com.bytedance.android.livesdk.config.ri;
import com.bytedance.android.livesdk.config.vg;
import com.bytedance.android.livesdk.utils.m5;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.interfaces.ListDialogAbility;
import com.bytedance.android.livesdkapi.model.LiveAudioSubtitleSetting;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import r52.d2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r {
    public Room a;
    public DataCenter b;
    public Context c;
    public LiveMode d;
    public final ListDialogAbility e;

    public static final class a {
    }

    static {
    }

    public final List<Object> b() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.i r1 = r0.getLiveMode();
        if (r1 == null) goto L9;
        LiveMode r2 = (LiveMode) r1.getValue();
        if (r2 == null) goto L9;
        this.d = r2;
    L9:
        ArrayList r3 = new ArrayList();
        r3.add(new u(this.e));
        r3.add(new s(this.e));
        return r3;
    }

    public r(ListDialogAbility r2) {
        Intrinsics.checkNotNullParameter(r2, "listDialogAbility");
        this.e = r2;
        this.d = LiveMode.UNDEFINED;
    }

    public static mx.o d(String r6) {
        return new mx.o(r6, 14.0f, new Rect(16, 14, 0, 5));
    }

    public final boolean c(Class<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "itemClass");
        if (Intrinsics.areEqual(r10, t.class) == false) goto L10;
        LiveMode r11 = this.d;
        if (r11 != LiveMode.VIDEO) goto L7;
    L279:
        return true;
    L7:
        if (r11 == LiveMode.MEDIA) goto L279;
        return false;
    L10:
        if (Intrinsics.areEqual(r10, k.class) == false) goto L13;
        return b0.d();
    L13:
        if (Intrinsics.areEqual(r10, d.class) == false) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(r10, l.class) == true) goto L279;
        if (Intrinsics.areEqual(r10, j.class) == true) goto L21;
        String r6 = "0";
        if (Intrinsics.areEqual(r10, x.class) == false) goto L54;
        Room r12 = this.a;
        if (r12 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L35:
        Map r13 = r12.anchorAbMap;
        if (r13 == null) goto L42;
        String r14 = (String) r13.get("live_anchor_new_replay_record_enable");
        if (r14 == null) goto L42;
        r6 = r14;
    L42:
        if (Intrinsics.areEqual(r6, "1") == false) goto L44;
        return false;
    L44:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.I0.getValue()).booleanValue() == false) goto L287;
        Room r15 = this.a;
        if (r15 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L49:
        if (r15.isHasCommerceGoods() == false) goto L279;
        if (jb.a.getValue().booleanValue() == false) goto L279;
        return false;
    L287:
        return false;
    L54:
        if (Intrinsics.areEqual(r10, v.class) == false) goto L77;
        Room r16 = this.a;
        if (r16 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L58:
        Map r17 = r16.anchorAbMap;
        if (r17 == null) goto L65;
        String r18 = (String) r17.get("live_anchor_new_replay_record_enable");
        if (r18 == null) goto L65;
        r6 = r18;
    L65:
        if (Intrinsics.areEqual(r6, "1") == true) goto L67;
        return false;
    L67:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.I0.getValue()).booleanValue() == false) goto L290;
        Room r19 = this.a;
        if (r19 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L72:
        if (r19.isHasCommerceGoods() == false) goto L279;
        if (jb.a.getValue().booleanValue() == false) goto L279;
        return false;
    L290:
        return false;
    L77:
        if (Intrinsics.areEqual(r10, m.class) == false) goto L96;
        int r110 = jc1.k.n(IInteractService.class).getCurrentScene();
        if (((LiveAudioSubtitleSetting) com.bytedance.android.live.core.setting.x.a.getValue()).getAnchorEnable() == false) goto L292;
        Room r0 = this.a;
        if (r0 != null) goto L84;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L84:
        if (r0.getStreamType() != LiveMode.AUDIO) goto L293;
        if (r110 == 5) goto L88;
        if (r110 == 16) goto L88;
        return false;
    L88:
        if (((IAudioSubtitleContent) b6.p0.getValue()).getStatus() == 3) goto L295;
        IInteractService r111 = jc1.k.n(IInteractService.class);
        Room r1 = this.a;
        if (r1 != null) goto L93;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L93:
        if (r111.subtitleHitNewStyleAB(r1) == false) goto L279;
        return false;
    L295:
        return false;
    L293:
        return false;
    L292:
        return false;
    L96:
        if (Intrinsics.areEqual(r10, n.class) == false) goto L125;
        String r112 = com.bytedance.android.live.liveinteract.revenue.game.c.a;
        int r113 = jc1.k.n(IInteractService.class).getCurrentScene();
        com.bytedance.android.live.core.setting.x r2 = com.bytedance.android.live.core.setting.x.a;
        if (((LiveAudioSubtitleSetting) r2.getValue()).getAnchorEnable() == false) goto L113;
        Room r7 = this.a;
        if (r7 != null) goto L103;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L103:
        if (r7.getStreamType() != LiveMode.AUDIO) goto L113;
        if (r113 == 5) goto L107;
        if (r113 != 16) goto L113;
    L107:
        if (((IAudioSubtitleContent) b6.p0.getValue()).getStatus() == 3) goto L113;
        IInteractService r5 = jc1.k.n(IInteractService.class);
        Room r8 = this.a;
        if (r8 != null) goto L112;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L112:
        if (r5.subtitleHitNewStyleAB(r8) == true) goto L279;
    L113:
        Room r9 = this.a;
        if (r9 != null) goto L117;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L117:
        if (r9.getStreamType() != LiveMode.AUDIO) goto L297;
        if (r113 == 0) goto L120;
        return false;
    L120:
        if (((IAudioSubtitleContent) b6.p0.getValue()).getStatus() != 3) goto L122;
        return false;
    L122:
        if (((LiveAudioSubtitleSetting) r2.getValue()).getRadioAnchorEnable() == true) goto L279;
        return false;
    L297:
        return false;
    L125:
        if (Intrinsics.areEqual(r10, LiveRealTimePlaybackSettingItem.class) == false) goto L137;
        int r114 = m5.a;
        if (m5.a(this.d) == false) goto L301;
        Room r115 = this.a;
        if (r115 != null) goto L132;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L132:
        if (r115.isHasCommerceGoods() == false) goto L279;
        if (tb1.c.c == true) goto L279;
        return false;
    L301:
        return false;
    L137:
        if (Intrinsics.areEqual(r10, y.class) == false) goto L151;
        db r116 = db.a;
        if (r116.getValue().getLive_anchor_support_media() == true) goto L141;
    L143:
        boolean r3 = false;
    L145:
        if (r116.getValue().getLive_anchor_clarity_open() == true) goto L147;
        return false;
    L147:
        if (this.d == LiveMode.VIDEO) goto L279;
        if (r3 == true) goto L279;
        return false;
    L141:
        if (this.d != LiveMode.MEDIA) goto L143;
        r3 = true;
        goto L145
    L151:
        if (Intrinsics.areEqual(r10, g.class) == false) goto L159;
        if (dd.a.getValue().booleanValue() == false) goto L305;
        Room r117 = this.a;
        if (r117 != null) goto L306;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L306:
        return r117.showBanUserCardSwitch;
    L305:
        return false;
    L159:
        if (Intrinsics.areEqual(r10, BroadcastWindowSettingItem.class) == false) goto L169;
        Room r118 = this.a;
        if (r118 != null) goto L164;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L164:
        if (r118.getStreamType() == LiveMode.AUDIO) goto L166;
        return false;
    L166:
        if (vg.a.getValue().booleanValue() == true) goto L279;
        return false;
    L169:
        if (Intrinsics.areEqual(r10, BroadcastVideoWindowSettingItem.class) == false) goto L179;
        Room r119 = this.a;
        if (r119 != null) goto L174;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L174:
        if (r119.getStreamType() == LiveMode.VIDEO) goto L176;
        return false;
    L176:
        if (ri.a.getValue().booleanValue() == true) goto L279;
        return false;
    L179:
        if (Intrinsics.areEqual(r10, ParticipateHourRankSettingItem.class) == false) goto L189;
        Integer r120 = (Integer) com.bytedance.android.livesdk.sharedpref.b.T2.getValue();
        if (r120 == null) goto L186;
        if (r120.intValue() != 3) goto L186;
        return false;
    L186:
        if (this.d != LiveMode.MEDIA) goto L279;
        return false;
    L189:
        if (Intrinsics.areEqual(r10, w.class) == false) goto L196;
        if (((Boolean) d2.a.getValue()).booleanValue() == true) goto L193;
        return false;
    L193:
        if (this.d != LiveMode.MEDIA) goto L279;
        return false;
    L196:
        if (Intrinsics.areEqual(r10, f.class) == false) goto L201;
        int r121 = us1.g.a;
        if (this.a != null) goto L315;
        Intrinsics.throwUninitializedPropertyAccessException("room");
        return false;
    L315:
        return false;
    L201:
        if (Intrinsics.areEqual(r10, AllowAudienceRequestExplainingProducts.class) == false) goto L208;
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.R0.getValue()).booleanValue() == true) goto L205;
        return false;
    L205:
        if (jb.a.getValue().booleanValue() == true) goto L279;
        return false;
    L208:
        if (Intrinsics.areEqual(r10, SyncCommerceExplainingToProductDetailPage.class) == false) goto L222;
        if (Intrinsics.areEqual((Boolean) com.bytedance.android.livesdk.sharedpref.b.L0.getValue(), Boolean.TRUE) == false) goto L217;
        DataCenter r122 = this.b;
        if (r122 != null) goto L215;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L215:
        if (z.o(r122).isHasCommerceGoods() == false) goto L217;
        return false;
    L217:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.P0.getValue()).booleanValue() == true) goto L219;
        return false;
    L219:
        if (jb.a.getValue().booleanValue() == true) goto L279;
        return false;
    L222:
        if (Intrinsics.areEqual(r10, LiveRoomCommentSettingItem.class) == true) goto L278;
        if (Intrinsics.areEqual(r10, AllowAudienceShareSettingItem.class) == true) goto L278;
        if (Intrinsics.areEqual(r10, com.bytedance.android.livesdk.chatroom.ui.setting.a.class) == false) goto L239;
        if (ez.a.getValue().booleanValue() == true) goto L231;
        return false;
    L231:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.c3.getValue()).booleanValue() == false) goto L323;
        Room r123 = this.a;
        if (r123 != null) goto L236;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L236:
        if (r123.getRoomAuthStatus().getEnableGift() == true) goto L279;
        return false;
    L323:
        return false;
    L239:
        if (Intrinsics.areEqual(r10, e.class) == false) goto L256;
        if (ez.a.getValue().booleanValue() == true) goto L243;
        return false;
    L243:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.c3.getValue()).booleanValue() == false) goto L326;
        Long r124 = (Long) com.bytedance.android.livesdk.sharedpref.b.d3.getValue();
        if (r124 != null) goto L248;
        return false;
    L248:
        if (r124.longValue() != 1) goto L327;
        Room r125 = this.a;
        if (r125 != null) goto L253;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L253:
        if (r125.getRoomAuthStatus().getEnableGift() == true) goto L279;
        return false;
    L327:
        return false;
    L326:
        return false;
    L256:
        if (Intrinsics.areEqual(r10, q.class) == true) goto L258;
        return false;
    L258:
        if (com.bytedance.android.livesdk.interactivity.api.asr.utils.a.a() == false) goto L279;
        Integer r4 = null;
        RoomContext r126 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r126 == null) goto L264;
        com.bytedance.live.datacontext.m r127 = r126.getMediaReviewStatus();
        if (r127 == null) goto L264;
        r4 = (Integer) r127.getValue();
    L264:
        if (r4 != null) goto L267;
    L268:
        if (r4 != null) goto L271;
    L272:
        if (r4 != null) goto L275;
        return false;
    L275:
        if (r4.intValue() == 3) goto L279;
        return false;
    L271:
        if (r4.intValue() == 2) goto L279;
    L267:
        if (r4.intValue() == 1) goto L279;
    L278:
        if (this.d == LiveMode.MEDIA) goto L279;
        return false;
    L21:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.I0.getValue()).booleanValue() == false) goto L283;
        Room r128 = this.a;
        if (r128 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L26:
        if (r128.isHasCommerceGoods() == true) goto L28;
        return false;
    L28:
        if (jb.a.getValue().booleanValue() == true) goto L279;
        return false;
    L283:
        return false;
    }

    public final void a(List<Object> r11, Class<?> r12) {
        if (c(r12) == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r12, ParticipateHourRankSettingItem.class) == false) goto L11;
        Context r0 = this.c;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("context");
    L9:
        Object r13 = new ParticipateHourRankSettingItem(r0);
    L111:
        ((ArrayList) r11).add(r13);
        return;
    L11:
        if (Intrinsics.areEqual(r12, l.class) == false) goto L17;
        Context r1 = this.c;
        if (r1 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("context");
    L15:
        r13 = new l(r1);
        goto L111
    L17:
        if (Intrinsics.areEqual(r12, d.class) == false) goto L20;
        r13 = new d();
        goto L111
    L20:
        if (Intrinsics.areEqual(r12, y.class) == false) goto L26;
        DataCenter r2 = this.b;
        if (r2 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L24:
        r13 = new y(r2, this.e);
        goto L111
    L26:
        if (Intrinsics.areEqual(r12, x.class) == false) goto L36;
        Context r4 = this.c;
        if (r4 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("context");
    L30:
        ListDialogAbility r5 = this.e;
        Function0<Boolean> r6 = new LiveRoomSettingItemProviderForAnchor$createInstance$1(this);
        Function0<Boolean> r7 = new LiveRoomSettingItemProviderForAnchor$createInstance$2(this);
        if (this.d != LiveMode.MEDIA) goto L33;
        boolean r8 = true;
    L34:
        r13 = new x(r4, r5, r6, r7, r8);
        goto L111
    L33:
        r8 = false;
        goto L34
    L36:
        if (Intrinsics.areEqual(r12, v.class) == false) goto L39;
        r13 = new v(this.e, new LiveRoomSettingItemProviderForAnchor$createInstance$3(this), new LiveRoomSettingItemProviderForAnchor$createInstance$4(this));
        goto L111
    L39:
        if (Intrinsics.areEqual(r12, m.class) == false) goto L45;
        Room r3 = this.a;
        if (r3 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L43:
        r13 = new m(r3, this.e);
        goto L111
    L45:
        if (Intrinsics.areEqual(r12, n.class) == false) goto L51;
        Context r9 = this.c;
        if (r9 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("context");
    L49:
        r13 = new n(r9, this.e);
        goto L111
    L51:
        if (Intrinsics.areEqual(r12, LiveRealTimePlaybackSettingItem.class) == false) goto L57;
        Context r10 = this.c;
        if (r10 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("context");
    L55:
        r13 = new LiveRealTimePlaybackSettingItem(r10, this.e, ((Boolean) com.bytedance.android.livesdk.sharedpref.b.M0.getValue()).booleanValue());
        goto L111
    L57:
        if (Intrinsics.areEqual(r12, j.class) == false) goto L69;
        Context r14 = this.c;
        if (r14 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("context");
    L61:
        ListDialogAbility r15 = this.e;
        Function0<Boolean> r16 = new LiveRoomSettingItemProviderForAnchor$createInstance$5(this);
        LiveMode r17 = this.d;
        Room r18 = this.a;
        if (r18 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L64:
        String r19 = r18.getAnchorId();
        if (r19 != null) goto L67;
        r19 = "";
    L67:
        r13 = new j(r14, r15, r16, r17, r19);
        goto L111
    L69:
        if (Intrinsics.areEqual(r12, f.class) == false) goto L72;
        r13 = new f(this.e);
        goto L111
    L72:
        if (Intrinsics.areEqual(r12, g.class) == false) goto L78;
        Room r20 = this.a;
        if (r20 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L76:
        r13 = new g(r20, this.e);
        goto L111
    L78:
        if (Intrinsics.areEqual(r12, SyncCommerceExplainingToProductDetailPage.class) == false) goto L84;
        Context r21 = this.c;
        if (r21 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("context");
    L82:
        r13 = new SyncCommerceExplainingToProductDetailPage(r21, this.e);
        goto L111
    L84:
        if (Intrinsics.areEqual(r12, AllowAudienceRequestExplainingProducts.class) == false) goto L90;
        Context r22 = this.c;
        if (r22 != null) goto L88;
        Intrinsics.throwUninitializedPropertyAccessException("context");
    L88:
        r13 = new AllowAudienceRequestExplainingProducts(r22, this.e);
        goto L111
    L90:
        if (Intrinsics.areEqual(r12, com.bytedance.android.livesdk.chatroom.ui.setting.a.class) == false) goto L96;
        Room r23 = this.a;
        if (r23 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L94:
        r13 = new com.bytedance.android.livesdk.chatroom.ui.setting.a(r23, this.e);
        goto L111
    L96:
        if (Intrinsics.areEqual(r12, e.class) == false) goto L105;
        Room r24 = this.a;
        if (r24 != null) goto L100;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L100:
        Context r25 = this.c;
        if (r25 != null) goto L103;
        Intrinsics.throwUninitializedPropertyAccessException("context");
    L103:
        r13 = new e(r24, r25);
        goto L111
    L105:
        if (Intrinsics.areEqual(r12, LiveRoomCommentSettingItem.class) == false) goto L110;
        DataCenter r26 = this.b;
        if (r26 != null) goto L109;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L109:
        r13 = new LiveRoomCommentSettingItem(r26);
        goto L111
    L110:
        r13 = r12.newInstance();
        goto L111
    }
}
