package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcastgame.api.AudienceGameContext;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.CoreSettingUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.VSDataContext;
import com.bytedance.android.livesdk.chatroom.bl.PlatformMessageHelper;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.chatroom.widget.RoomWidget;
import com.bytedance.android.livesdk.config.fi1;
import com.bytedance.android.livesdk.interactivity.api.like.datacontext.DiggContext;
import com.bytedance.android.livesdk.message.model.p4;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Observable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class FollowGuideWidget extends RoomWidget implements View.OnClickListener, qo1.c {
    public boolean b;
    public Room c;
    public IUser d;
    public String e;
    public b f;
    public View g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public HSImageView l;
    public String m;
    public final Boolean n;
    public final a o;

    public class a implements View.OnAttachStateChangeListener {
        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r1) {
        }

        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r1) {
            PlatformMessageHelper.INSTANCE.onMessageFinish();
        }
    }

    public static final class b extends com.bytedance.android.livesdk.common.b {
        public final View b;
        public boolean c;

        @Override // com.bytedance.android.livesdk.common.b, android.app.Dialog, android.content.DialogInterface
        public final void dismiss() {
            if (this.c == true) goto L5;
            return;
        L5:
            Handler r0 = DialogLancet.resolveDialogHandler(this);
            if (r0 != null) goto L8;
        L10:
            DialogLancet.beforeDialogDismiss(this);
            super.dismiss();     // Catch: Throwable -> L13 Exception -> L15
        L19:
            DialogLancet.afterDialogDismiss(this);
            return;
        L13:
            th = move-exception;
            DialogLancet.afterDialogDismiss(this);
            throw th;
        L15:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
            if (r1 == null) goto L19;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
            goto L19
        L8:
            if (Looper.myLooper() == r0.getLooper()) goto L10;
            r0.post(DialogLancet.createDismissRunnable(this));
        }

        @Override // android.app.Dialog, android.view.Window.Callback
        public final void onAttachedToWindow() {
            super.onAttachedToWindow();
            this.c = true;
        }

        @Override // android.app.Dialog, android.view.Window.Callback
        public final void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            this.c = false;
        }

        @Override // com.bytedance.android.livesdk.common.b, android.app.Dialog
        public final void onStart() {
            super.onStart();
            if (getWindow() == null) goto L6;
            getWindow().setLayout(-1, -1);
            return;
        }

        @Override // com.bytedance.android.livesdk.common.b, android.app.Dialog
        public final void show() {
            if ((getContext() instanceof Activity) == false) goto L8;
            if (((Activity) getContext()).isFinishing() == false) goto L8;
            return;
        L8:
            if (isShowing() == false) goto L11;
            return;
        L11:
            if (DialogLancet.shouldBlockDialogShow(this) == false) goto L17;
            DialogLancet.handleBlockedDialogShow(this);
            return;
        L17:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
        L14:
            DialogLancet.beforeDialogShow(this);
            super.show();
            DialogLancet.afterDialogShow(this);
        }

        @Override // android.app.Dialog
        public final void onCreate(Bundle r1) {
            super.onCreate(r1);
            setContentView(this.b);
            setCanceledOnTouchOutside(true);
        }

        public b(Context r1, boolean r2, View r3) {
            super(r1, r2);
            this.c = false;
            this.b = r3;
        }
    }

    public final String getSpm() {
        return "a100.a100.a267";
    }

    public final /* synthetic */ void onAbilityClear() {
        IAbility.-CC.$default$onAbilityClear(this);
    }

    public final boolean Eg() {
        DiggContext.a r0 = DiggContext.Companion;
        DataCenter r1 = ((Widget) this).dataCenter;
        r0.getClass();
        if (DiggContext.a.a(r1) != null) goto L6;
        return false;
    L6:
        if (DiggContext.a.a(((Widget) this).dataCenter).getDiggWidget().getValue() != null) goto L9;
        return false;
    L9:
        return ((u32.k) DiggContext.a.a(((Widget) this).dataCenter).getDiggWidget().getValue()).Eg();
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.RoomWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        if (this.g != null) goto L6;
        FrameLayout r0 = new FrameLayout(((Widget) this).context);
        r0.setOnClickListener(new i0(this));
        com.bytedance.android.livesdk.r3.a(r0, com.bytedance.android.live.core.utils.s1.B(2131918650));
        View r1 = View.inflate(((Widget) this).context, 2131565467, r0);
        this.g = r1;
        r1.removeOnAttachStateChangeListener(this.o);
        this.g.addOnAttachStateChangeListener(this.o);
        this.l = this.g.findViewById(2131376019);
        this.h = (TextView) this.g.findViewById(2131390993);
        this.k = (TextView) this.g.findViewById(2131390648);
        this.i = (TextView) this.g.findViewById(2131390756);
        this.j = (TextView) this.g.findViewById(2131364730);
        this.f = new b(((Widget) this).context, this.b, r0);
    L6:
        this.j.setOnClickListener(this);
        if (ho1.a.o(getComponentContext()) == false) goto L10;
        ho1.a.p(getComponentContext(), qo1.c.class, this);
        return;
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        ho1.a.q(getComponentContext(), qo1.c.class);
    }

    public FollowGuideWidget(boolean r2) {
        this.d = null;
        this.n = Boolean.FALSE;
        this.o = new a();
        this.b = r2;
    }

    public static void wq(b r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r12) {
        if (this.d != null) goto L5;
    L82:
        wq(this.f);
        return;
    L5:
        if (((Widget) this).context == null) goto L82;
        if (r12.equals(this.j) == true) goto L10;
        return;
    L10:
        if (TTLiveSDKContext.getHostService().h().isLogin() == true) goto L14;
        com.bytedance.android.livesdk.user.f0 r13 = TTLiveSDKContext.getHostService().h();
        Context r3 = ((Widget) this).context;
        com.bytedance.android.livesdk.user.l.a r4 = new com.bytedance.android.livesdk.user.l.a();
        r4.a = CoreSettingUtil.getLoginPromptForFollow();
        r4.b = CoreSettingUtil.getLoginImageForFollow();
        r4.e = "live_detail";
        r4.g = "follow";
        r4.d = "live";
        r4.c = 1;
        r13.login(r3, new com.bytedance.android.livesdk.user.l(r4)).subscribe(new com.bytedance.android.livesdk.user.h());
        return;
    L14:
        if (this.c != null) goto L16;
        com.bytedance.android.livesdk.user.f0 r14 = TTLiveSDKContext.getHostService().h();
        com.bytedance.android.livesdk.user.b.b r5 = new com.bytedance.android.livesdk.user.b.b().c(this.d.getIdString()).e();
        r5.getClass();
        com.bytedance.android.livesdk.user.b.b r1 = r5.g("live").f(com.bytedance.android.livesdk.user.j.b(LiveFollowScene.FOLLOW_GUIDE));
        r1.getClass();
        String r6 = ((com.bytedance.android.livesdk.user.a.a) r1).a;
        String r8 = ((com.bytedance.android.livesdk.user.a.a) r1).b;
        long r7 = ((com.bytedance.android.livesdk.user.b.a) r1).e;
        HashMap r9 = ((com.bytedance.android.livesdk.user.b.a) r1).f;
        boolean r10 = ((com.bytedance.android.livesdk.user.b.a) r1).g;
        com.bytedance.android.livesdk.user.f0 r11 = r14;
        r11.getClass();
        Observable r15 = r11.Q(1, r6, r7, r8, r9, r10);
    L17:
        r15.subscribe(new l0(), new m0(this));
        if (this.n.booleanValue() == false) goto L26;
        com.bytedance.android.livesdk.vs.f r16 = com.bytedance.android.livesdk.vs.f.c;
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L22;
        r16 = com.bytedance.android.livesdk.vs.f.a(r0);
    L22:
        HashMap r2 = new HashMap();
        r2.put("to_user_id", this.d.getIdString());
        r2.put("vs_follow_position", "follow_card");
        r2.put("vs_click_relation_type", "audience_to_official_account");
        if (VSDataContext.getInteractionContext(((Widget) this).dataCenter) == null) goto L25;
        ((Boolean) VSDataContext.getInteractionContext(((Widget) this).dataCenter).isVSLive().getValue()).booleanValue();
    L25:
        r16.c("follow", r2, new Object[0]);
    L80:
        wq(this.f);
        return;
    L26:
        HashMap r17 = new HashMap();
        r17.put("scene_id", String.valueOf(BubbleId.AudiencePublicScreenConfig));
        r17.put("request_page", "follow_card");
        r17.put("request_id", this.e);
        r17.put("to_user_id", this.d.getIdString());
        r17.put("anchor_id", this.d.getIdString());
        Room r18 = this.c;
        if (r18 == null) goto L29;
        int r19 = com.bytedance.android.live.core.utils.h1.a;
        r17.put("live_type", com.bytedance.android.live.core.utils.i1.a(r18.getStreamType()));
        r17.put("room_id", String.valueOf(this.c.getId()));
    L29:
        xq(r17, this.c);
        int r20 = com.bytedance.android.live.core.utils.h1.a;
        r17.putAll(com.bytedance.android.live.core.utils.h1.a(this.c));
        yq(r17, new String[]{"enter_from_merge", "enter_method", "action_type"});
        String r21 = "1";
        if (jc1.k.f(IBroadcastService.class).isPlayingGame() == false) goto L32;
        Object r22 = "1";
    L33:
        r17.put("is_gaming", r22);
        r17.put("popup_reason", this.m);
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.V.getValue()).booleanValue() == false) goto L36;
        Object r23 = "1";
    L37:
        r17.put("is_screen_clear", r23);
        AudienceGameContext r24 = AudienceGameContext.getGameContext();
        if (r24 != null) goto L40;
    L42:
        r17.put("connection_type", jc1.k.f(IInteractService.class).getLinkConnectionType());
        r17.put("anchor_cnt", jc1.k.f(ILinkServiceExternal.class).getLinkAnchorCount());
        if (RoomContext.getShared() != null) goto L46;
        r17.put("if_clear_mode", "0");
    L50:
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_follow", r17, new Object[]{Room.class, am2.x.class, am2.u.class, am2.y.class, am2.n.f(), am2.q.class});
        if (com.bytedance.android.livesdk.utils.c1.b(((Widget) this).dataCenter) == false) goto L67;
        JSONObject r110 = new JSONObject();
        r110.put("anchor_id", this.d.getIdString());     // Catch: JSONException -> L57
        Room r25 = this.c;     // Catch: JSONException -> L57
        if (r25 == null) goto L59;
        r110.put("room_id", String.valueOf(r25.getId()));     // Catch: JSONException -> L57
    L59:
        com.bytedance.android.livesdk.chatroom.utils.k1.f(r110);
        ILiveDouPlusService r26 = jc1.k.f(ILiveDouPlusService.class);
        HashMap r27 = new HashMap();
        r27.put("ad_extra_data", r110.toString());
        Map r111 = com.bytedance.android.livesdk.utils.c1.e(((Widget) this).dataCenter);
        if (r111 != null) goto L62;
    L65:
        r26.logEvent(true, "live_ad", "follow", r27);
        goto L67
    L62:
        if (r111.isEmpty() == true) goto L65;
        r27.putAll(r111);
    L57:
        e = move-exception;
        e.printStackTrace();
    L67:
        if (com.bytedance.android.livesdk.utils.c1.c(((Widget) this).dataCenter) == false) goto L80;
        JSONObject r112 = new JSONObject();
        r112.put("anchor_id", this.d.getIdString());     // Catch: JSONException -> L73
        Room r28 = this.c;     // Catch: JSONException -> L73
        if (r28 == null) goto L75;
        r112.put("room_id", String.valueOf(r28.getId()));     // Catch: JSONException -> L73
    L75:
        com.bytedance.android.livesdk.chatroom.utils.k1.f(r112);
        ILiveDouPlusService r29 = jc1.k.f(ILiveDouPlusService.class);
        HashMap r30 = new HashMap();
        r30.put("ad_extra_data", r112.toString());
        Map r31 = com.bytedance.android.livesdk.utils.c1.f(((Widget) this).dataCenter);
        if (r31.isEmpty() == true) goto L79;
        r30.putAll(r31);
    L79:
        r29.logEvent(true, "live_ad", "follow", r30);
        com.bytedance.android.livesdk.utils.b3.a(((Widget) this).dataCenter, r112);
    L73:
        e = move-exception;
        e.printStackTrace();
        goto L75
    L46:
        if (((Boolean) RoomContext.getShared().isCleanMode().getValue()).booleanValue() == true) goto L49;
        r21 = "0";
    L49:
        r17.put("if_clear_mode", r21);
        goto L50
    L40:
        if (r24.getCurrentGame().getValue() == null) goto L42;
        r17.put("game_id", String.valueOf(((com.bytedance.android.live.broadcastgame.api.model.r) r24.getCurrentGame().getValue()).p()));
        r17.put("game_name", String.valueOf(((com.bytedance.android.live.broadcastgame.api.model.r) r24.getCurrentGame().getValue()).q()));
        goto L42
    L36:
        r23 = "0";
        goto L37
    L32:
        r22 = "0";
        goto L33
    L16:
        com.bytedance.android.livesdk.user.f0 r113 = TTLiveSDKContext.getHostService().h();
        com.bytedance.android.livesdk.user.b.b r32 = new com.bytedance.android.livesdk.user.b.b().c(this.d.getIdString()).e();
        r32.getClass();
        com.bytedance.android.livesdk.user.b.b r33 = r32.g("live").h(this.c.getId());
        this.c.getLabels();
        r33.getClass();
        com.bytedance.android.livesdk.user.b.b r34 = r33.f(com.bytedance.android.livesdk.user.j.b(LiveFollowScene.FOLLOW_GUIDE));
        r34.getClass();
        String r35 = ((com.bytedance.android.livesdk.user.a.a) r34).a;
        String r36 = ((com.bytedance.android.livesdk.user.a.a) r34).b;
        long r37 = ((com.bytedance.android.livesdk.user.b.a) r34).e;
        HashMap r38 = ((com.bytedance.android.livesdk.user.b.a) r34).f;
        boolean r114 = ((com.bytedance.android.livesdk.user.b.a) r34).g;
        com.bytedance.android.livesdk.user.f0 r39 = r113;
        r39.getClass();
        r15 = r39.Q(1, r35, r37, r36, r38, r114);
        goto L17
    }

    public static void xq(Map r5, Room r6) {
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.getExtra() != null) goto L7;
    L9:
        long r3 = r6.appId;
        if (r3 == 0) goto L13;
        HashMap r7 = (HashMap) r5;
        r7.put("anchor_aid", String.valueOf(r3));
        return;
    L13:
        return;
    L7:
        if (r6.getExtra().getXiguaUid() == 0) goto L9;
        HashMap r4 = (HashMap) r5;
        r4.put("xg_uid", String.valueOf(r6.getExtra().getXiguaUid()));
        goto L9
    }

    public final void yq(Map<String, String> r7, String... r8) {
        com.bytedance.android.livesdk.log.filter.n0 r0 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        if (r0 != null) goto L6;
        return;
    L6:
        if (r8.length < 1) goto L14;
        int r1 = r8.length;
        int r2 = 0;
    L9:
        if (r2 >= r1) goto L18;
        String r3 = r8[r2];
        if (((com.bytedance.android.livesdk.log.filter.a) r0).b.containsKey(r3) == false) goto L13;
        HashMap r5 = (HashMap) r7;
        r5.put(r3, (String) ((com.bytedance.android.livesdk.log.filter.a) r0).b.get(r3));
    L13:
        r2 = r2 + 1;
        goto L9
    L18:
        return;
    }

    @Override // qo1.c
    public final void Kd(Room r8, p4 r9, final DataCenter r10) {
        if (r8 != null) goto L4;
    L88:
        PlatformMessageHelper.INSTANCE.onMessageFinish();
        return;
    L4:
        if (isViewValid() == false) goto L88;
        com.bytedance.android.livesdk.chatroom.utils.p.b.getClass();
        int r0 = fi1.a;
        if (fi1.a.b() == false) goto L19;
        if (tb1.c.c == true) goto L19;
        if (VSDataContext.getInteractionContext(((Widget) this).dataCenter) != null) goto L12;
    L14:
        boolean r1 = false;
    L15:
        if (r1 == true) goto L19;
        PlatformMessageHelper.INSTANCE.onMessageFinish();
        return;
    L12:
        if (VSDataContext.getInteractionContext(((Widget) this).dataCenter).isVSRoom() == false) goto L14;
        r1 = true;
    L19:
        if (Eg() == false) goto L22;
        PlatformMessageHelper.INSTANCE.onMessageFinish();
        return;
    L22:
        RoomContext r2 = this.a;
        if (r2 != null) goto L25;
    L28:
        this.c = r8;
        IUser r3 = r8.author();
        String r4 = r8.getRequestId();
        this.d = r3;
        this.e = r4;
        IUser r5 = r8.author();
        User r11 = r8.getBaseOwner();
        if (isViewValid() == true) goto L31;
        PlatformMessageHelper.INSTANCE.onMessageFinish();
        return;
    L31:
        if (Eg() == false) goto L33;
        PlatformMessageHelper.INSTANCE.onMessageFinish();
        return;
    L33:
        String r6 = r9.getContent();
        long r7 = r11.getFollowInfo().getFollowStatus();
        if (TextUtils.isEmpty(r6) == false) goto L36;
    L85:
        PlatformMessageHelper.INSTANCE.onMessageFinish();
        return;
    L36:
        if (r7 == 1) goto L85;
        if (r7 == 2) goto L85;
        HSImageView r12 = this.l;
        if (r9.E() != null) goto L43;
        ImageModel r13 = r11.getAvatarThumb();
    L44:
        com.bytedance.android.livesdk.chatroom.utils.a1.y(r12, r13, 2131251677, com.bytedance.android.live.core.utils.s1.h(2131101254), t6.a(((Widget) this).context, 2.0f));
        this.h.setText(r5.getNickName());
        if (TextUtils.isEmpty(r9.P()) == false) goto L47;
        this.i.setVisibility(8);
    L48:
        this.k.setText(r9.getContent());
        this.m = r9.G();
        if (this.f.getWindow() != null) goto L51;
    L53:
        b r14 = this.f;
        if (DialogLancet.shouldBlockDialogShow(r14) == false) goto L91;
        DialogLancet.handleBlockedDialogShow(r14);
    L58:
        RoomContext r15 = this.a;
        if (r15 == null) goto L61;
        r15.getHasShowFollowGuideDialog().setValue(Boolean.TRUE);
    L61:
        com.bytedance.android.livesdk.f.d().a();
        this.f.setOnDismissListener(new j0(r10));
        if (r9.H() <= 0) goto L65;
        this.g.postDelayed(new k0(this), r9.H());
    L65:
        if (this.n.booleanValue() == false) goto L77;
        com.bytedance.android.livesdk.vs.f r16 = com.bytedance.android.livesdk.vs.f.c;
        DataCenter r17 = ((Widget) this).dataCenter;
        if (r17 == null) goto L69;
        r16 = com.bytedance.android.livesdk.vs.f.a(r17);
    L69:
        HashMap r18 = new HashMap();
        boolean r19 = ((Boolean) ((Widget) this).dataCenter.get("data_is_portrait", Boolean.TRUE)).booleanValue();
        this.b = r19;
        if (r19 == false) goto L72;
        r18.put("vs_screen_type", "portrait");
    L73:
        r18.put("popup_reason", this.m);
        if (VSDataContext.getInteractionContext(((Widget) this).dataCenter) == null) goto L76;
        ((Boolean) VSDataContext.getInteractionContext(((Widget) this).dataCenter).isVSLive().getValue()).booleanValue();
    L76:
        xq(r18, this.c);
        r16.c("follow_card_show", r18, new Object[0]);
        return;
    L72:
        r18.put("vs_screen_type", "landscape");
        goto L73
    L77:
        HashMap r20 = new HashMap();
        Room r110 = this.c;
        if (r110 == null) goto L80;
        r20.put("room_id", String.valueOf(r110.getId()));
    L80:
        r20.put("anchor_id", this.d.getIdString());
        r20.put("request_id", this.e);
        r20.put("popup_reason", this.m);
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.V.getValue()).booleanValue() == false) goto L83;
        String r21 = "1";
    L84:
        r20.put("is_screen_clear", r21);
        yq(r20, new String[]{"enter_from_merge", "enter_method"});
        xq(r20, this.c);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_follow_card_show", r20, new Object[0]);
        return;
    L83:
        r21 = "0";
        goto L84
    L91:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L90
    L57:
        DialogLancet.beforeDialogShow(r14);
        r14.show();
        DialogLancet.afterDialogShow(r14);
        goto L58
    L51:
        if (tb1.c.a == false) goto L53;
        this.f.getWindow().setDimAmount(0.0f);
        goto L53
    L47:
        this.i.setText(r9.P());
        this.i.setVisibility(0);
        goto L48
    L43:
        r13 = r9.E();
        goto L44
    L25:
        if (((Boolean) r2.getHasShownLinkFollowGuide().getValue()).booleanValue() == false) goto L28;
        ALogger.i("follow_guide", "intercept since hasShownLinkFollowGuide");
        PlatformMessageHelper.INSTANCE.onMessageFinish();
    }
}
