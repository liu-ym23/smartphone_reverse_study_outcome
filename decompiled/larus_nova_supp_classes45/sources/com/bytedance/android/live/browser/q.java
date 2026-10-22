package com.bytedance.android.live.browser;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.browser.utils.LiveBrowserDomainUtils;
import com.bytedance.android.live.browser.webview.fragment.BaseWebDialogFragment;
import com.bytedance.android.live.browser.webview.fragment.LiveAnnieFragment;
import com.bytedance.android.live.browser.webview.fragment.LiveAnnieXFragment;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.utils.g1;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livehostapi.foundation.depend.HostBoeParams;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.LiveInitSettingKeys;
import com.bytedance.android.livesdk.config.g91;
import com.bytedance.android.livesdk.config.ky0;
import com.bytedance.android.livesdk.log.filter.n0;
import com.bytedance.android.livesdk.log.filter.s0;
import com.bytedance.android.livesdk.utils.e4;
import com.bytedance.android.livesdk.utils.r3;
import com.bytedance.android.livesdk.v5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.live.core.utils.LiveCardReleaseOpt;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.common.applog.AppLog;
import io.reactivex.subjects.PublishSubject;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class q implements u {
    public final CopyOnWriteArrayList<DialogFragment> a;
    public final CopyOnWriteArrayList<WeakReference<DialogFragment>> b;
    public final Map<String, BaseWebDialogFragment> c;
    public final TokenCert d;
    public final TokenCert e;

    @Inject
    public v f;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.monitor.webview.a {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void a(String r3, JSONObject r4) {
            LiveSlardarMonitor.monitorStatusAndDurationDirect(r3, 0, null, r4);
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.browser.u
    public final LiveAnnieFragment c() {
        return new LiveAnnieFragment();
    }

    @Override // com.bytedance.android.live.browser.u
    public final LiveAnnieXFragment e() {
        return new LiveAnnieXFragment();
    }

    @Override // com.bytedance.android.live.browser.u
    public final void g() {
        if (LiveCardReleaseOpt.INSTANCE.useWeakRef() == false) goto L16;
        Iterator<WeakReference<DialogFragment>> r0 = this.b.iterator();
    L6:
        if (r0.hasNext() == false) goto L15;
        DialogFragment r3 = r0.next().get();
        if (r3 == null) goto L6;
        r3.dismissAllowingStateLoss();     // Catch: Exception -> L11
    L11:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r4 = DialogFragmentLancet.sLastShowStack;
        if (r4 == null) goto L6;
        com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L6
    L15:
        this.b.clear();
        return;
    L16:
        Iterator<DialogFragment> r1 = this.a.iterator();
    L18:
        if (r1.hasNext() == false) goto L26;
        r1.next().dismissAllowingStateLoss();     // Catch: Exception -> L22
    L22:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r5 = DialogFragmentLancet.sLastShowStack;
        if (r5 == null) goto L18;
        com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L18
    L26:
        this.a.clear();
    }

    public q() {
        this.a = new CopyOnWriteArrayList();
        this.b = new CopyOnWriteArrayList();
        this.c = new LinkedHashMap();
        TokenCert.Companion r0 = TokenCert.Companion;
        this.d = r0.with("bpea-live_webService_request_calendar_permission");
        this.e = r0.with("bpea-live_webService_request_calendar_write_permission");
        BrowserServiceImpl.Companion.getClass();
        s20.b r1 = (s20.b) BrowserServiceImpl.access$getDiComponent$cp();
        r1.getClass();
        v r2 = (v) r1.b.e.get();
        this.f = r2;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeService");
    L5:
        r2.registerExternalMethodFactory(g0.a).subscribe();
        v r3 = this.f;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeService");
    L8:
        r3.b(a0.c).subscribe();
    }

    @Override // com.bytedance.android.live.browser.u
    public final void a() {
        g91 r0 = LiveInitSettingKeys.get_LIVW_WEBVIEW_MONITOR_CONFIG();
        n30.f r1 = n30.f.a;
        com.bytedance.android.monitor.webview.b r2 = r1.e().buildConfig();
        r2.g = b.a;
        r2.f = new ly2.c();
        r2.m = r0.h();
        r2.h = LiveInitSettingKeys.get_WEBVIEW_MONITOR_SLARDAR_SWITCH_SET();
        r2.b = com.bytedance.android.monitor.webview.d.x();
        r2.p = r0.g();
        r2.i = r0.f();
        r2.j = r0.c();
        r1.e().d(r2);
    }

    @Override // com.bytedance.android.live.browser.u
    public final void d() {
        g91 r0 = LiveInitSettingKeys.get_LIVW_WEBVIEW_MONITOR_CONFIG();
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        com.bytedance.android.monitorV2.webview.c r1 = n30.f.a.e().b();
        r1.g = "webcast_cn_container";
        r1.f = r0.h();
        r1.d = LiveInitSettingKeys.get_WEBVIEW_MONITOR_SLARDAR_SWITCH_SET();
    L9:
        n30.f.a.e().c(r1);
        return;
    L5:
        v30.a r2 = n30.g.a;
        if (LiveInitSettingKeys.get_LIVE_WEBVIEW_USE_MONITOR() == false) goto L8;
        r2 = n30.e.b;
    L8:
        r1 = r2.b();
        r1.g = "webcast_cn_container";
        r1.f = r0.h();
        r1.d = LiveInitSettingKeys.get_WEBVIEW_MONITOR_SLARDAR_SWITCH_SET();
        goto L9
    }

    @Override // com.bytedance.android.live.browser.u
    public final String appendCommonParams(String r34) {
        Intrinsics.checkNotNullParameter(r34, LiveSlardarConstants.EXTRA_KEY_URL);
        RoomContext.Companion.getClass();
        RoomContext r5 = RoomContext.a.a(null, 0);
        if (r5 == null) goto L5;
        Room r6 = (Room) r5.getRoom().getValue();
    L6:
        if (r6 != null) goto L8;
        long r7 = 0;
    L10:
        if (r6 != null) goto L12;
        String r11 = "0";
    L14:
        if (r6 != null) goto L17;
        String r12 = String.valueOf(r11);
    L20:
        String r13 = jc1.k.f(IUserService.class).user().n();
        String r14 = jc1.k.f(IUserService.class).user().b().getCastSecUid();
        if (r6 != null) goto L23;
        String r15 = "";
    L24:
        if (r6 != null) goto L26;
        String r17 = "";
    L27:
        n0 r2 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        Room r21 = r6;
        String r8 = "action_type";
        if ((r2 instanceof n0) == false) goto L48;
        n0 r3 = r2;
        if (((com.bytedance.android.livesdk.log.filter.a) r3).b.containsKey("enter_from") == false) goto L33;
        String r4 = (String) ((com.bytedance.android.livesdk.log.filter.a) r3).b.get("enter_from");
    L33:
        if (((com.bytedance.android.livesdk.log.filter.a) r3).b.containsKey("source") == false) goto L36;
        String r9 = (String) ((com.bytedance.android.livesdk.log.filter.a) r3).b.get("source");
    L36:
        if (((com.bytedance.android.livesdk.log.filter.a) r3).b.containsKey("action_type") == false) goto L38;
        String r16 = (String) ((com.bytedance.android.livesdk.log.filter.a) r3).b.get("action_type");
    L40:
        if (((com.bytedance.android.livesdk.log.filter.a) r3).b.containsKey("video_id") == false) goto L42;
        String r18 = (String) ((com.bytedance.android.livesdk.log.filter.a) r3).b.get("video_id");
    L44:
        if (((com.bytedance.android.livesdk.log.filter.a) r3).b.containsKey("gd_label") == false) goto L46;
        String r19 = (String) ((com.bytedance.android.livesdk.log.filter.a) r3).b.get("gd_label");
    L47:
        Map r22 = ((com.bytedance.android.livesdk.log.filter.a) r3).b;
        Map r24 = com.bytedance.android.livesdk.log.e0.a;
        String r25 = (String) r22.get("enter_from_merge");
        String r23 = (String) r22.get("enter_method");
        String r26 = r19;
        String r27 = r16;
        String r28 = r18;
        String r110 = r25;
    L49:
        s0 r29 = com.bytedance.android.livesdk.log.u.l().c(Room.class);
        String r210 = r27;
        if ((r29 instanceof s0) == false) goto L52;
        String r111 = (String) ((com.bytedance.android.livesdk.log.filter.a) r29).b.get("lottery_id");
    L53:
        Uri r31 = UriProtector.parse(r34);
        String r211 = r111;
        List r112 = (List) LiveBrowserDomainUtils.a.getValue();
        boolean r212 = false;
        if (r31.getHost() == null) goto L62;
        Iterator r113 = r112.iterator();
    L57:
        if (r113.hasNext() == false) goto L62;
        String r32 = r8;
        if (x30.a.a(r31.getHost(), (String) r113.next()) == true) goto L60;
        r8 = r32;
        goto L57
    L60:
        boolean r33 = true;
    L63:
        if (r33 == true) goto L66;
        HashMap r35 = new HashMap();
        r35.put(LiveSlardarConstants.EXTRA_KEY_URL, r34);
        r35.put("safeJsbHostList", r112);
        LiveSlardarMonitor.monitorStatus(LiveSlardarConstants.suffixError(LiveSlardarConstants.SERVICE_WEBVIEW_JSB_SAFE_HOST), 1, r35);
    L66:
        Set r1 = UriProtector.getQueryParameterNames(r31);
        if (r33 == false) goto L219;
        if (r1 == null) goto L220;
        Uri.Builder r0 = UriProtector.parse(r34).buildUpon();
        if (r1.contains("room_id") == true) goto L75;
        if (r7 == 0) goto L75;
        r0.appendQueryParameter("room_id", String.valueOf(r7));
    L75:
        if (r1.contains("anchor_id") == true) goto L80;
        if (com.bytedance.android.live.base.model.user.n0.b(r11) == false) goto L80;
        r0.appendQueryParameter("anchor_id", String.valueOf(r11));
    L80:
        if (r1.contains("sec_anchor_id") == true) goto L83;
        r0.appendQueryParameter("sec_anchor_id", r12);
    L83:
        if (r1.contains("user_id") == true) goto L86;
        r0.appendQueryParameter("user_id", String.valueOf(r13));
    L86:
        if (r1.contains("sec_user_id") == true) goto L89;
        r0.appendQueryParameter("sec_user_id", r14);
    L89:
        if (r1.contains("enter_from_merge") == true) goto L92;
        r0.appendQueryParameter("enter_from_merge", r110);
    L92:
        if (r1.contains("enter_method") == true) goto L94;
        r0.appendQueryParameter("enter_method", r23);
    L94:
        String r36 = r32;
        if (r1.contains(r36) == true) goto L97;
        String r37 = r210;
        r0.appendQueryParameter(r36, r37);
    L99:
        if (r1.contains("log_pb") == true) goto L104;
        if (TextUtils.isEmpty(r15) == true) goto L104;
        r0.appendQueryParameter("log_pb", r15);
    L104:
        if (r1.contains("request_id") == true) goto L109;
        if (TextUtils.isEmpty(r17) == true) goto L109;
        r0.appendQueryParameter("request_id", r17);
    L109:
        if (r1.contains("video_id") == true) goto L114;
        if (TextUtils.isEmpty(r28) == true) goto L114;
        r0.appendQueryParameter("video_id", r28);
    L114:
        if (r1.contains(r36) == true) goto L119;
        if (TextUtils.isEmpty(r37) == true) goto L119;
        r0.appendQueryParameter(r36, r37);
    L119:
        if (r1.contains("gd_label") == true) goto L124;
        if (TextUtils.isEmpty(r26) == true) goto L124;
        r0.appendQueryParameter("gd_label", r26);
    L124:
        if (r1.contains("lottery_id") == true) goto L129;
        if (TextUtils.isEmpty(r211) == true) goto L129;
        r0.appendQueryParameter("lottery_id", r211);
    L129:
        if (r21 != null) goto L131;
    L137:
        if (r21 != null) goto L139;
    L149:
        if (r21 != null) goto L151;
    L157:
        if (r21 == null) goto L166;
        if (r1.contains("is_paidlive") == true) goto L166;
        if (r21.isPaidRoom() == false) goto L163;
        String r38 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L164:
        r0.appendQueryParameter("is_paidlive", r38);
        goto L166
    L163:
        r38 = "0";
    L166:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L176;
        HostBoeParams r39 = jc1.k.f(IHostContext.class).getHostBoeParams();
        if (r39 == null) goto L176;
        if (r39.getPpeEnable() == false) goto L172;
    L175:
        r0.appendQueryParameter("device_id", AppLog.v());
        goto L176
    L172:
        if (r39.getBoeEnable() == true) goto L175;
        if (((Boolean) ky0.a.getValue()).booleanValue() == true) goto L175;
    L176:
        if (r5 == null) goto L184;
        Map r41 = (Map) r5.getLiveActivityContext().getValue();
        if (r41 == null) goto L184;
        Iterator r42 = r41.entrySet().iterator();
    L181:
        if (r42.hasNext() == false) goto L184;
        Map.Entry r43 = (Map.Entry) r42.next();
        r0.appendQueryParameter((String) r43.getKey(), (String) r43.getValue());
    L184:
        if (((Boolean) v5.a.getValue()).booleanValue() == false) goto L192;
        int r44 = g1.a;
        if (r21 != null) goto L188;
    L190:
        String r45 = "unknown";
    L191:
        r0.appendQueryParameter("hybrid_live_scene", r45);
        ALogger.i("Hybrid_Params", "appendLiveCommonParam::: cur room scene  : ".concat(r45));
        goto L192
    L188:
        if (r21.getRoomId() == 0) goto L190;
        r45 = "during_live";
    L192:
        r0.appendQueryParameter("currency_name", r3.c());
        r0.appendQueryParameter("short_currency_name", r3.b());
        j40.m r46 = j40.m.a;
        r0.appendQueryParameter("currency_full_name", r46.getValue().getCoinFullDesc());
        r0.appendQueryParameter("point_name", r46.getValue().getPoint());
        r0.appendQueryParameter("recharge_desc", e4.a());
        if (r21 != null) goto L195;
    L204:
        lm1.b r47 = pm1.f.d(null);
        if (r47 == null) goto L213;
        if (r47.getEpisode().getValue() == null) goto L213;
        int r48 = am2.a0.L;
        Iterator r49 = ((HashMap) am2.a0.a.a((Episode) r47.getEpisode().getValue()).a()).entrySet().iterator();
    L210:
        if (r49.hasNext() == false) goto L213;
        Map.Entry r51 = (Map.Entry) r49.next();
        r0.appendQueryParameter((String) r51.getKey(), (String) r51.getValue());
    L213:
        return r0.build().toString();
    L195:
        if (r21.isMergeVSRoom() == false) goto L204;
        r0.appendQueryParameter("vs_is_merge", GamePromoteDataContext.GAME_TYPE_MOBILE);
        if (((Boolean) r5.isPortraitInteraction().getValue()).booleanValue() == false) goto L199;
        String r52 = "portrait";
    L200:
        r0.appendQueryParameter("vs_screen_type", r52);
        Iterator<Map.Entry<String, String>> r53 = AnnieParamUtil.i().entrySet().iterator();
    L202:
        if (r53.hasNext() == false) goto L204;
        Map.Entry<String, String> r54 = r53.next();
        r0.appendQueryParameter(r54.getKey(), r54.getValue());
        goto L202
    L199:
        r52 = "landscape";
        goto L200
    L151:
        if (r21.getDesireInfo() == null) goto L157;
        if (r21.getDesireInfo().desireIdStr == null) goto L157;
        if (r1.contains("desire_id") == true) goto L157;
        r0.appendQueryParameter("desire_id", r21.getDesireInfo().desireIdStr);
        goto L157
    L139:
        if (r1.contains("allow_exchange") == true) goto L149;
        com.bytedance.android.live.incentive.exchange.c r55 = (com.bytedance.android.live.incentive.exchange.c) qa0.c.b.getService(com.bytedance.android.live.incentive.exchange.c.class);
        if (r55 != null) goto L143;
    L145:
        if (r212 == false) goto L147;
        String r56 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L148:
        r0.appendQueryParameter("allow_exchange", r56);
        goto L149
    L147:
        r56 = "0";
        goto L148
    L143:
        if (r55.a() == false) goto L145;
        r212 = true;
        goto L145
    L131:
        if (r1.contains("allow_gift") == true) goto L137;
        if (r21.allowGift() == false) goto L135;
        String r57 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L136:
        r0.appendQueryParameter("allow_gift", r57);
        goto L137
    L135:
        r57 = "0";
        goto L136
    L97:
        r37 = r210;
        goto L99
    L220:
        return r34;
    L219:
        return r34;
    L62:
        r32 = r8;
        r33 = false;
        goto L63
    L52:
        r111 = "";
        goto L53
    L46:
        r19 = "";
        goto L47
    L42:
        r18 = "";
        goto L44
    L38:
        r16 = "";
        goto L40
    L48:
        r23 = "";
        r27 = r23;
        r110 = r27;
        r28 = r110;
        r26 = r28;
        goto L49
    L26:
        r17 = r6.getRequestId();
        goto L27
    L23:
        r15 = r6.getLog_pb();
        goto L24
    L17:
        if (r6.getBaseOwner() == null) goto L19;
        r12 = r6.getBaseOwner().getCastSecUid();
        goto L20
    L19:
        r12 = "";
        goto L20
    L12:
        r11 = r6.getOwnerUserIdString();
        goto L14
    L8:
        r7 = r6.getId();
        goto L10
    L5:
        r6 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.browser.u
    public final void b(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        throw new UnsupportedOperationException("主线直播不支持");
    }

    @Override // com.bytedance.android.live.browser.u
    public final com.bytedance.android.live.browser.webview.fragment.i createBrowserFragment(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "bundle");
        return new com.bytedance.android.live.browser.webview.fragment.i(r2);
    }

    @Override // com.bytedance.android.live.browser.u
    public final com.bytedance.android.live.browser.webview.fragment.i createSimpleBrowserFragment(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "bundle");
        return new com.bytedance.android.live.browser.webview.fragment.i(r2);
    }

    @Override // com.bytedance.android.live.browser.u
    public final boolean f(String r2) {
        Intrinsics.checkNotNullParameter(r2, LiveSlardarConstants.EXTRA_KEY_URL);
        return u30.e.a.getValue().a(r2);
    }

    @Override // com.bytedance.android.live.browser.u
    public final String appendFeedCommonParams(String r21, IRoom r22) {
        Intrinsics.checkNotNullParameter(r21, LiveSlardarConstants.EXTRA_KEY_URL);
        Intrinsics.checkNotNullParameter(r22, NewBroadcastMonitor.PAGE.ROOM);
        Room r1 = (Room) com.bytedance.android.live.base.model.m.b(r22, Room.class);
        if (r1 != null) goto L5;
        long r5 = 0;
    L6:
        String r7 = "0";
        if (r1 != null) goto L9;
        String r8 = "0";
    L10:
        String r9 = "";
        if (r1 != null) goto L14;
        String r11 = String.valueOf(r8);
    L17:
        String r12 = jc1.k.f(IUserService.class).user().n();
        String r13 = jc1.k.f(IUserService.class).user().b().getCastSecUid();
        if (r1 != null) goto L20;
        String r14 = "";
    L21:
        if (r1 == null) goto L24;
        r9 = r1.getRequestId();
    L24:
        Uri r15 = UriProtector.parse(r21);
        List r16 = (List) LiveBrowserDomainUtils.a.getValue();
        boolean r17 = false;
        if (r15.getHost() == null) goto L33;
        Iterator r4 = r16.iterator();
    L28:
        if (r4.hasNext() == false) goto L33;
        String r3 = (String) r4.next();
        Iterator r18 = r4;
        if (x30.a.a(r15.getHost(), r3) == true) goto L31;
        r4 = r18;
        goto L28
    L31:
        boolean r6 = true;
    L34:
        if (r6 == true) goto L37;
        HashMap r19 = new HashMap();
        r19.put(LiveSlardarConstants.EXTRA_KEY_URL, r21);
        r19.put("safeJsbHostList", r16);
        LiveSlardarMonitor.monitorStatus(LiveSlardarConstants.suffixError(LiveSlardarConstants.SERVICE_WEBVIEW_JSB_SAFE_HOST), 1, r19);
    L37:
        Set r2 = UriProtector.getQueryParameterNames(r15);
        if (r6 == false) goto L129;
        if (r2 == null) goto L130;
        Uri.Builder r0 = UriProtector.parse(r21).buildUpon();
        if (r2.contains("room_id") == true) goto L46;
        if (r5 == 0) goto L46;
        r0.appendQueryParameter("room_id", String.valueOf(r5));
    L46:
        if (r2.contains("anchor_id") == true) goto L51;
        if (com.bytedance.android.live.base.model.user.n0.b(r8) == false) goto L51;
        r0.appendQueryParameter("anchor_id", String.valueOf(r8));
    L51:
        if (r2.contains("sec_anchor_id") == true) goto L54;
        r0.appendQueryParameter("sec_anchor_id", r11);
    L54:
        if (r2.contains("user_id") == true) goto L57;
        r0.appendQueryParameter("user_id", String.valueOf(r12));
    L57:
        if (r2.contains("sec_user_id") == true) goto L60;
        r0.appendQueryParameter("sec_user_id", r13);
    L60:
        if (r2.contains("log_pb") == true) goto L65;
        if (TextUtils.isEmpty(r14) == true) goto L65;
        r0.appendQueryParameter("log_pb", r14);
    L65:
        if (r2.contains("request_id") == true) goto L70;
        if (TextUtils.isEmpty(r9) == true) goto L70;
        r0.appendQueryParameter("request_id", r9);
    L70:
        if (r1 != null) goto L72;
    L78:
        if (r1 != null) goto L80;
    L90:
        if (r1 != null) goto L92;
    L98:
        if (r1 == null) goto L106;
        if (r2.contains("is_paidlive") == true) goto L106;
        if (r1.isPaidRoom() == false) goto L104;
        r7 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L104:
        r0.appendQueryParameter("is_paidlive", r7);
    L106:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L117;
        HostBoeParams r23 = jc1.k.f(IHostContext.class).getHostBoeParams();
        if (r23 == null) goto L117;
        if (r23.getPpeEnable() == false) goto L112;
    L115:
        r0.appendQueryParameter("device_id", AppLog.v());
        goto L117
    L112:
        if (r23.getBoeEnable() == true) goto L115;
        if (((Boolean) ky0.a.getValue()).booleanValue() == true) goto L115;
    L117:
        if (((Boolean) v5.a.getValue()).booleanValue() == false) goto L125;
        int r24 = g1.a;
        if (r1 != null) goto L121;
    L123:
        String r25 = "unknown";
    L124:
        r0.appendQueryParameter("hybrid_live_scene", r25);
        ALogger.i("Hybrid_Params", "appendLiveCommonParam::: cur room scene  : ".concat(r25));
        goto L125
    L121:
        if (r1.getRoomId() == 0) goto L123;
        r25 = "during_live";
    L125:
        r0.appendQueryParameter("currency_name", r3.c());
        r0.appendQueryParameter("short_currency_name", r3.b());
        j40.m r26 = j40.m.a;
        r0.appendQueryParameter("currency_full_name", r26.getValue().getCoinFullDesc());
        r0.appendQueryParameter("point_name", r26.getValue().getPoint());
        r0.appendQueryParameter("recharge_desc", e4.a());
        return r0.build().toString();
    L92:
        if (r1.getDesireInfo() == null) goto L98;
        if (r1.getDesireInfo().desireIdStr == null) goto L98;
        if (r2.contains("desire_id") == true) goto L98;
        r0.appendQueryParameter("desire_id", r1.getDesireInfo().desireIdStr);
        goto L98
    L80:
        if (r2.contains("allow_exchange") == true) goto L90;
        com.bytedance.android.live.incentive.exchange.c r27 = (com.bytedance.android.live.incentive.exchange.c) qa0.c.b.getService(com.bytedance.android.live.incentive.exchange.c.class);
        if (r27 != null) goto L84;
    L86:
        if (r17 == false) goto L88;
        String r28 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L89:
        r0.appendQueryParameter("allow_exchange", r28);
        goto L90
    L88:
        r28 = "0";
        goto L89
    L84:
        if (r27.a() == false) goto L86;
        r17 = true;
        goto L86
    L72:
        if (r2.contains("allow_gift") == true) goto L78;
        if (r1.allowGift() == false) goto L76;
        String r29 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L77:
        r0.appendQueryParameter("allow_gift", r29);
        goto L78
    L76:
        r29 = "0";
        goto L77
    L130:
        return r21;
    L129:
        return r21;
    L33:
        r6 = false;
        goto L34
    L20:
        r14 = r1.getLog_pb();
        goto L21
    L14:
        if (r1.getBaseOwner() == null) goto L16;
        r11 = r1.getBaseOwner().getCastSecUid();
        goto L17
    L16:
        r11 = "";
        goto L17
    L9:
        r8 = r1.getOwnerUserIdString();
        goto L10
    L5:
        r5 = r1.getId();
        goto L6
    }

    @Override // com.bytedance.android.live.browser.u
    public final u30.a i(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, LiveSlardarConstants.EXTRA_KEY_URL);
        return new u30.a(r2, r3);
    }

    @Override // com.bytedance.android.live.browser.u
    public final r h(Context r2, PublishSubject r3, Fragment r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "permissionResponse");
        Intrinsics.checkNotNullParameter(r4, "fragment");
        return new r(this, r2, r3, r4);
    }
}
