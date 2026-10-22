package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcastgame.api.AudienceGameContext;
import com.bytedance.android.live.core.setting.CoreSettingUtil;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.n61;
import com.bytedance.android.livesdk.log.model.FollowLog;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r8 extends com.bytedance.android.livesdk.common.b implements View.OnClickListener {
    public TextView b;
    public final Room c;
    public final User d;
    public boolean e;
    public boolean f;
    public DataCenter g;

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        this.f = false;
        super.onDetachedFromWindow();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f = true;
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
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(this);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
    }

    static {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r12) {
        if (r12.getId() != 2131373079) goto L38;
        if (TTLiveSDKContext.getHostService().h().isLogin() == true) goto L8;
        Bundle r13 = new Bundle();
        r13.putString("enter_from", "live_detail");
        r13.putString("action_type", "follow");
        r13.putString("source", "live");
        r13.putString("v1_source", "follow");
        com.bytedance.android.livesdk.user.f0 r14 = TTLiveSDKContext.getHostService().h();
        Context r2 = getContext();
        com.bytedance.android.livesdk.user.l.a r4 = new com.bytedance.android.livesdk.user.l.a();
        r4.a = CoreSettingUtil.getLoginPromptForFollow();
        r4.b = CoreSettingUtil.getLoginImageForFollow();
        r4.e = "live_detail";
        r4.g = "follow";
        r4.d = "live";
        r4.c = -1;
        r14.login(r2, new com.bytedance.android.livesdk.user.l(r4)).subscribe(new com.bytedance.android.livesdk.user.h());
        return;
    L8:
        if (this.e == true) goto L64;
        com.bytedance.android.livesdk.log.d.b(this.g, "live_ad", "follow", this.c.getAnchorId(), String.valueOf(this.c.getId()));
        if (com.bytedance.android.live.core.feed.a.a().c(Long.valueOf(this.c.getId())) == false) goto L13;
    L14:
        com.bytedance.android.livesdk.log.d.b(this.g, "draw_ad", "click", this.c.getAnchorId(), String.valueOf(this.c.getId()));
    L15:
        com.bytedance.android.livesdk.user.f0 r15 = TTLiveSDKContext.getHostService().h();
        com.bytedance.android.livesdk.user.b.a r0 = new com.bytedance.android.livesdk.user.d.b().c(this.d.getIdStr());
        this.c.getRequestId();
        com.bytedance.android.livesdk.user.d.b r1 = r0.e();
        r1.getClass();
        com.bytedance.android.livesdk.user.d.b r3 = r1.g("live_follow_popup").h(this.c.getId());
        this.c.getLabels();
        r3.getClass();
        com.bytedance.android.livesdk.user.d.b r5 = r3.f(com.bytedance.android.livesdk.user.j.b(LiveFollowScene.REMIND_DIALOG));
        r5.getClass();
        String r6 = ((com.bytedance.android.livesdk.user.a.a) r5).a;
        String r8 = ((com.bytedance.android.livesdk.user.a.a) r5).b;
        long r7 = ((com.bytedance.android.livesdk.user.b.a) r5).e;
        HashMap r9 = ((com.bytedance.android.livesdk.user.b.a) r5).f;
        boolean r10 = ((com.bytedance.android.livesdk.user.b.a) r5).g;
        com.bytedance.android.livesdk.user.f0 r11 = r15;
        r11.getClass();
        r11.Q(1, r6, r7, r8, r9, r10).observeOn(AndroidSchedulers.mainThread()).subscribe(new q8(this));
        this.e = true;
        long r16 = ((Integer) n61.b.getValue()).intValue();
        HashMap r17 = new HashMap();
        r17.put("follow_notice_duration", String.valueOf(r16));
        r17.put("growth_deepevent", String.valueOf(1));
        int r18 = com.bytedance.android.live.core.utils.h1.a;
        r17.put("live_type", com.bytedance.android.live.core.utils.i1.a(this.c.getStreamType()));
        r17.putAll(com.bytedance.android.live.core.utils.h1.a(this.c));
        String r19 = "1";
        if (jc1.k.f(IBroadcastService.class).isPlayingGame() == false) goto L18;
        Object r20 = "1";
    L19:
        r17.put("is_gaming", r20);
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.V.getValue()).booleanValue() == false) goto L22;
        Object r21 = "1";
    L23:
        r17.put("is_screen_clear", r21);
        AudienceGameContext r22 = AudienceGameContext.getGameContext();
        if (r22 != null) goto L26;
    L28:
        r17.put("connection_type", jc1.k.f(IInteractService.class).getLinkConnectionType());
        r17.put("anchor_cnt", jc1.k.f(ILinkServiceExternal.class).getLinkAnchorCount());
        if (RoomContext.getShared() != null) goto L32;
        r17.put("if_clear_mode", "0");
    L36:
        com.bytedance.android.livesdk.log.g r23 = com.bytedance.android.livesdk.log.u.l();
        am2.x r110 = new am2.x();
        r110.a = "live_interact";
        r110.b = "live_detail";
        r23.sendLog("livesdk_follow", r17, new Object[]{am2.u.class, new FollowLog("live_follow_popup", this.d.getIdString()), r110, Room.class, am2.y.class, am2.n.f(), am2.q.class});
        return;
    L32:
        if (((Boolean) RoomContext.getShared().isCleanMode().getValue()).booleanValue() == true) goto L35;
        r19 = "0";
    L35:
        r17.put("if_clear_mode", r19);
        goto L36
    L26:
        if (r22.getCurrentGame().getValue() == null) goto L28;
        r17.put("game_id", String.valueOf(((com.bytedance.android.live.broadcastgame.api.model.r) r22.getCurrentGame().getValue()).p()));
        r17.put("game_name", String.valueOf(((com.bytedance.android.live.broadcastgame.api.model.r) r22.getCurrentGame().getValue()).q()));
        goto L28
    L22:
        r21 = "0";
        goto L23
    L18:
        r20 = "0";
        goto L19
    L13:
        if (com.bytedance.android.live.core.feed.a.a().b(Long.valueOf(this.c.getId())) == false) goto L15;
    L64:
        return;
    L38:
        if (r12.getId() != 2131369150) goto L61;
        Handler r111 = DialogLancet.resolveDialogHandler(this);
        if (r111 != null) goto L42;
    L44:
        DialogLancet.beforeDialogDismiss(this);
        dismiss();     // Catch: Throwable -> L47 Exception -> L49
    L53:
        DialogLancet.afterDialogDismiss(this);
        return;
    L49:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L47
        Throwable r112 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L47
        if (r112 == null) goto L53;
        com.bytedance.crash.d.d(r112, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L42:
        if (Looper.myLooper() == r111.getLooper()) goto L44;
        r111.post(DialogLancet.createDismissRunnable(this));
        return;
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r6) {
        super.onCreate(r6);
        setContentView(2131565725);
        DataCenter r7 = this.g;
        Boolean r0 = Boolean.TRUE;
        if (r7.get("data_is_portrait", r0) == null) goto L5;
        boolean r8 = ((Boolean) this.g.get("data_is_portrait", r0)).booleanValue();
    L6:
        int r1 = com.bytedance.android.livesdk.utils.landscape.d.a;
        if ((!r8) == false) goto L11;
        Window r9 = getWindow();
        if (r9 == null) goto L11;
        r9.setDimAmount(0.0f);
        r9.setGravity(8388693);
        WindowManager.LayoutParams r2 = r9.getAttributes();
        r2.verticalMargin = com.bytedance.android.live.core.utils.s1.f(20.0f) / com.bytedance.android.livesdk.utils.t6.c(getContext());
        r2.horizontalMargin = com.bytedance.android.live.core.utils.s1.f(34.0f) / com.bytedance.android.livesdk.utils.t6.b(getContext());
        r9.setAttributes(r2);
    L11:
        ConstraintLayout r10 = findViewById(2131373090);
        ImageView r11 = (ImageView) findViewById(2131363623);
        TextView r3 = (TextView) findViewById(2131380593);
        findViewById(2131362583).setVisibility(8);
        TextView r4 = (TextView) findViewById(2131368849);
        TextView r5 = (TextView) findViewById(2131373079);
        this.b = r5;
        r5.setOnClickListener(this);
        com.bytedance.android.livesdk.chatroom.utils.a1.v(r11, this.d.getAvatarThumb(), 2131251889);
        com.bytedance.android.livesdk.r3.c(r11, this.d.getNickName(), false);
        r3.setText(this.d.getNickName());
        r4.setText(2131916691);
        r4.setVisibility(0);
        this.b.setVisibility(0);
        View r12 = findViewById(2131369150);
        if (r12 == null) goto L15;
        r12.setOnClickListener(this);
        com.bytedance.android.livesdk.r3.c(r12, com.bytedance.android.live.core.utils.s1.B(2131918650), true);
        return;
    L15:
        return;
    L5:
        r8 = true;
        goto L6
    }

    public r8(FragmentActivity r1, boolean r2, Room r3) {
        super(r1, r2);
        this.e = false;
        this.f = false;
        this.c = r3;
        this.d = r3.getBaseOwner();
    }
}
