package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AndroidLifecycleScopeProvider;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.backroom.LiveBackRoomStackManager;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.config.oj1;
import com.bytedance.android.livesdk.interactivity.api.quickcomment.event.BackRoomViewState;
import com.bytedance.android.livesdk.log.model.LiveVSLog;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.widget.CircleProgressView;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeMod;
import com.bytedance.android.livesdkapi.eventbus.JumpToOtherRoomEvent;
import com.bytedance.android.livesdkapi.eventbus.VSJumpCameraEvent;
import com.bytedance.android.livesdkapi.feed.ArgumentsBuilder;
import com.bytedance.common.utility.UIUtils;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s1 {
    public final int a;
    public final ViewGroup b;
    public HSImageView c;
    public TextView d;
    public CircleProgressView e;
    public final Lifecycle f;
    public ObjectAnimator g;
    public final Context h;
    public Long i;
    public Bundle j;
    public boolean k;
    public com.bytedance.android.live.base.model.g l;
    public Map<String, String> m;
    public int n;
    public BackRoomViewState.ChangeType o;
    public Disposable p;
    public ValueAnimator q;

    public static String b(int r1) {
        if (r1 != 17) goto L7;
        return "record";
    L7:
        if (r1 != 16) goto L11;
        return "premiere";
    L11:
        if (r1 != 15) goto L14;
        return "live";
    L14:
        return "";
    }

    public final boolean a(String r19) {
        Bundle r2 = this.j;
        if (r2 != null) goto L5;
        return false;
    L5:
        long r8 = r2.getLong("live.intent.extra.ITEM_ID", 0);
        Room r3 = this.l;
        if (r3 != null) goto L8;
    L10:
        if (r3 != null) goto L12;
    L14:
        int r4 = 1;
    L16:
        if (r4 != 1) goto L43;
        int r5 = this.j.getInt(VSConstants.EXTRA_ITEM_TYPE, 1);
        com.bytedance.android.livesdk.log.filter.o r12 = com.bytedance.android.livesdk.log.u.l().c(Room.class);
        com.bytedance.android.livesdk.log.filter.o r13 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        com.bytedance.android.livesdk.log.m0 r14 = new com.bytedance.android.livesdk.log.m0();
        r14.b("return_type", r19);
        ObjectAnimator r1 = this.g;
        if (r1 != null) goto L20;
        long r15 = 0;
    L21:
        r14.b("process_duration", String.valueOf(r15));
        r14.a(r12, new String[]{"room_id", "anchor_id"});
        r14.b("to_room_id", String.valueOf(this.j.getLong("live.intent.extra.ROOM_ID")));
        r14.b("to_anchor_id", com.bytedance.android.live.base.model.user.n0.c(this.j, "anchor_id"));
        Lazy r6 = LiveBackRoomStackManager.a;
        r14.b("layer_level", String.valueOf(LiveBackRoomStackManager.b(ContextUtil.contextToActivity(this.h)).size()));
        r14.b("orientation", String.valueOf(this.j.getInt("orientation", 0)));
        r14.a(r13, new String[]{"enter_from_merge", "enter_method", "action_type"});
        if (r5 == 16) goto L27;
        if (r5 == 17) goto L27;
        if (r5 == 15) goto L27;
        r14.b("to_room_type", "normal_room");
    L28:
        Room r7 = this.l;
        if ((r7 instanceof Room) == false) goto L34;
        if (r7.isMergeVSRoom() == false) goto L34;
        LiveVSLog.b r9 = LiveVSLog.r;
        Room r10 = this.l;
        r9.getClass();
        r14.c(LiveVSLog.b.a(r10).a());
    L34:
        if (this.j.containsKey("live.intent.extra.VS_LOG_EXTRA") == false) goto L42;
        LiveVSLog r11 = this.j.getParcelable("live.intent.extra.VS_LOG_EXTRA");
        if (r11 == null) goto L42;
        r14.b("to_vs_episode_id", r11.e);
        r14.b("to_vs_ep_group_id", r11.c);
        if (r11.i != EpisodeMod.EpisodeStageType.PREMIERE) goto L40;
        String r16 = "vs_premiere";
    L41:
        r14.b("to_room_type", r16);
        goto L42
    L40:
        r16 = "vs_live";
    L42:
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_return_click", r14.a, new Object[]{Room.class, new am2.x(), am2.n.f()});
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_return_last_click", r14.a, new Object[]{Room.class, new am2.x(), am2.n.f()});
    L48:
        RoomContext r17 = RoomContext.getShared();
        if (r17 != null) goto L51;
    L68:
        JumpToOtherRoomEvent r18 = new JumpToOtherRoomEvent(r8, com.bytedance.android.livesdk.chatroom.helper.a.a(this.j), true, true);
        r18.source = "sourceJumpToOtherLiveBackRoomViewControllerV2";
        xs2.b.a().post(r18);
        return true;
    L51:
        if (((Room) r17.getRoom().getValue()).getId() != r8) goto L68;
        long r20 = this.j.getLong("live.intent.extra.EXTRA_VS_CAMERA_ID", 0);
        long r110 = this.j.getLong("live.intent.extra.EXTRA_VS_MATCH_ID", 0);
        ALogger.i("LiveBackRoomViewControllerV2", "try jump to camera, cameraId:" + r20 + ", matchId:" + r110);
        if (r20 == 0) goto L68;
        if (dq1.b.b(r17.isVSRoom()) == true) goto L57;
        VSJumpCameraEvent r21 = new VSJumpCameraEvent();
        r21.setCameraId(r20);
        r21.setMatchId(r110);
        r21.setBackSource("jump_source_room_back");
        xs2.b.a().post(r21);
    L60:
        Lazy r22 = LiveBackRoomStackManager.a;
        LiveBackRoomStackManager.b(ContextUtil.contextToActivity(this.h)).popRoomInfo();
        if (this.d == null) goto L66;
        ValueAnimator r23 = this.q;
        if (r23 == null) goto L65;
        r23.cancel();
    L65:
        UIUtils.updateLayout(this.d, -2, -3);
    L66:
        c(r8);
        return true;
    L57:
        if (pm1.f.a() == null) goto L60;
        pm1.f.a().l4(Long.valueOf(r20), null, false, "jump_source_room_back", null);
    L27:
        r14.b("to_vs_episode_id", String.valueOf(this.j.getLong("live.intent.extra.VS_EPISODE_ID", 0)));
        r14.b("to_vs_ep_group_id", this.j.getString("live.intent.extra.EPISODE_GROUP_ID", ""));
        r14.b("to_room_type", "vs_room");
        r14.b("to_vs_episode_stage", b(r5));
        goto L28
    L20:
        r15 = r1.getCurrentPlayTime();
        goto L21
    L43:
        if (r4 == 15) goto L47;
        if (r4 == 16) goto L47;
        d("vs_video_return_last_click", r19);
    L47:
        d("vs_livesdk_return_last_click", r19);
        goto L48
    L12:
        if ((r3 instanceof Episode) == false) goto L14;
        r4 = 17;
        goto L16
    L8:
        if ((r3 instanceof Room) == false) goto L10;
        r4 = ArgumentsBuilder.getRoomType(r3);
        goto L16
    }

    public final void c(long r9) {
        Lazy r0 = LiveBackRoomStackManager.a;
        if (LiveBackRoomStackManager.b(ContextUtil.contextToActivity(this.h)).peekRoomInfo() == null) goto L5;
        this.j = LiveBackRoomStackManager.b(ContextUtil.contextToActivity(this.h)).peekRoomInfo();
    L7:
        if (this.j != null) goto L10;
        UIUtils.setViewVisibility(this.b, 8);
        f(0);
        return;
    L10:
        com.bytedance.android.livesdk.config.m0 r1 = com.bytedance.android.livesdk.config.m0.a;
        if (r1.getValue().enableOnlyBackPress() == false) goto L14;
        UIUtils.setViewVisibility(this.b, 8);
        f(0);
        return;
    L14:
        ImageModel r2 = this.j.getParcelable("pre_room_user_avatar");
        if ((r2 instanceof ImageModel) == false) goto L17;
        int r5 = this.a;
        ImageLoader.bindAvatar(this.c, r2, r5, r5);
    L17:
        this.b.setOnClickListener(new r1(this));
        CircleProgressView r3 = this.e;
        if (tb1.c.a == false) goto L20;
        int r4 = -54187;
    L21:
        r3.setBorderColor(r4);
        this.e.setBorderWidth(com.bytedance.android.live.core.utils.s1.f(1.5f));
        this.e.setCounterClockWise(false);
        long r6 = this.j.getInt("live.intent.extra.ITEM_TYPE");
        if (r6 != VSConstants.VS_EPISODE) goto L24;
    L29:
        this.b.setContentDescription(this.h.getString(2131915228));
        this.d.setText(2131915228);
    L30:
        String r7 = this.j.getString("live.intent.extra.ROOM_BACK_ENTRY_TEXT");
        if (TextUtils.isEmpty(r7) == true) goto L34;
        this.b.setContentDescription(r7);
        this.d.setText(r7);
    L34:
        if (r1.getValue().enableFixed() == true) goto L41;
        long r8 = r1.getValue().totalTime * BubbleId.PadCast;
        ObjectAnimator r10 = this.g;
        if (r10 == null) goto L38;
        r10.cancel();
    L38:
        ObjectAnimator r11 = ObjectAnimator.ofFloat(this.e, "progress", new float[]{360.0f, 0.0f});
        this.g = r11;
        if (r11 == null) goto L41;
        r11.setDuration(r8);
        this.g.addListener(new q1(this));
        this.g.start();
    L41:
        Context r12 = this.h;
        if ((r12 instanceof Activity) == false) goto L44;
        j(((Activity) r12).getRequestedOrientation(), null);
    L44:
        f(0);
        long r13 = r1.getValue().delayTime * BubbleId.PadCast;
        Disposable r14 = this.p;
        if (r14 != null) goto L47;
    L49:
        this.p = ((ObservableSubscribeProxy) Observable.just(this).delay(r13, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).as(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(this.f, Lifecycle.Event.ON_DESTROY)))).subscribe(new l1(), RxUtil.getNoOpThrowable());
        this.i = Long.valueOf(r9);
        this.k = true;
        if ((this.h instanceof FragmentActivity) == false) goto L54;
        ((ObservableSubscribeProxy) xs2.b.a().b(zg1.t0.class).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this.h))).subscribe(new m1(this));
        return;
    L54:
        return;
    L47:
        if (r14.isDisposed() == true) goto L49;
        this.p.dispose();
        goto L49
    L24:
        if (r6 == VSConstants.VS_FIRST_SHOW) goto L29;
        if (r6 == VSConstants.VS_LIVE) goto L29;
        this.b.setContentDescription(this.h.getString(2131915229));
        this.d.setText(2131915229);
        goto L30
    L20:
        r4 = -45517;
        goto L21
    L5:
        this.j = null;
        UIUtils.setViewVisibility(this.b, 8);
        goto L7
    }

    public final void f(final int r3) {
        if (this.b.getVisibility() != 0) goto L5;
        this.o = BackRoomViewState.ChangeType.VISIBLE;
        this.n = this.b.getRight();
        this.b.post(new n1(this, r3));
        return;
    L5:
        this.o = BackRoomViewState.ChangeType.GONE;
        this.n = 0;
        g(r3);
    }

    public final void g(int r7) {
        Long r0 = this.i;
        if (r0 != null) goto L5;
    L7:
        RoomContext r1 = RoomContext.getShared();
    L8:
        com.bytedance.android.livesdk.interactivity.api.h r2 = com.bytedance.android.livesdk.interactivity.api.i.a(r1, null);
        if (r2 == null) goto L12;
        r2.getBackRoomViewState().setValue(new BackRoomViewState(this.o, this.n));
        r2.getBackRoomChanged().post(new o52.a(new BackRoomViewState(this.o, this.n), r7));
        return;
    L12:
        return;
    L5:
        if (r0.longValue() <= 0) goto L7;
        r1 = RoomContext.getShared(null, this.i.longValue());
        goto L8
    }

    public final void h(boolean r2) {
        RoomContext r0 = RoomContext.getShared();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isVSSpecialDrawer() == false) goto L17;
        ViewGroup r1 = this.b;
        if (r1 == null) goto L19;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r1.getLayoutParams();
        if (r3 == null) goto L18;
        if (r2 == false) goto L13;
        r3.bottomMargin = com.bytedance.android.live.core.utils.s1.f(98.0f);
    L14:
        this.b.setLayoutParams(r3);
        return;
    L13:
        r3.bottomMargin = com.bytedance.android.live.core.utils.s1.f(52.0f);
        goto L14
    L18:
        return;
    L19:
        return;
    }

    public final void i(boolean r3) {
        ViewGroup r0 = this.b;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r3 == false) goto L9;
        r0.setVisibility(8);
    L20:
        f(0);
        return;
    L9:
        if (this.j == null) goto L20;
        ObjectAnimator r4 = this.g;
        if (r4 == null) goto L15;
        if (r4.isRunning() == false) goto L15;
    L16:
        boolean r5 = true;
    L18:
        if (r5 == false) goto L20;
        this.b.setVisibility(0);
    L15:
        if (com.bytedance.android.livesdk.config.m0.a.getValue().enableFixed() == true) goto L16;
        r5 = false;
        goto L18
    }

    public final void d(String r11, String r12) {
        long r0 = this.j.getLong("live.intent.extra.ROOM_ID", 0);
        int r4 = this.j.getInt(VSConstants.EXTRA_ITEM_TYPE, 1);
        Map r5 = this.m;
        if (r5 != null) goto L5;
        r5 = new HashMap();
    L5:
        HashMap r6 = new HashMap();
        r6.put("return_type", r12);
        ObjectAnimator r13 = this.g;
        if (r13 != null) goto L8;
        long r7 = 0;
    L9:
        r6.put("process_duration", String.valueOf(r7));
        Lazy r14 = LiveBackRoomStackManager.a;
        r6.put("layer_level", String.valueOf(LiveBackRoomStackManager.b(ContextUtil.contextToActivity(this.h)).size()));
        r6.put("orientation", String.valueOf(this.j.getInt("orientation", 0)));
        if (r4 != 16) goto L12;
    L17:
        r5.put("to_vs_episode_id", String.valueOf(this.j.getLong("live.intent.extra.VS_EPISODE_ID", 0)));
        r5.put("to_vs_ep_group_id", this.j.getString("live.intent.extra.EPISODE_GROUP_ID", ""));
        r5.put("to_room_type", "vs_room");
        r5.put("to_vs_episode_stage", b(r4));
    L18:
        r5.put("to_room_id", String.valueOf(r0));
        r5.put("to_anchor_id", com.bytedance.android.live.base.model.user.n0.c(this.j, "anchor_id"));
        r5.putAll(r6);
        com.bytedance.android.livesdk.vs.f.c.c(r11, r5, new Object[0]);
        return;
    L12:
        if (r4 == 17) goto L17;
        if (r4 == 15) goto L17;
        r5.put("to_room_type", "normal_room");
        goto L18
    L8:
        r7 = r13.getCurrentPlayTime();
        goto L9
    }

    public final void e(String r13, Map<String, String> r14) {
        long r0 = this.j.getLong("live.intent.extra.ITEM_ID", 0);
        int r4 = this.j.getInt(VSConstants.EXTRA_ITEM_TYPE, 1);
        if (r14 != null) goto L5;
        r14 = new HashMap();
    L5:
        Lazy r5 = LiveBackRoomStackManager.a;
        r14.put("layer_level", String.valueOf(LiveBackRoomStackManager.b(ContextUtil.contextToActivity(this.h)).size()));
        r14.put("orientation", String.valueOf(this.j.getInt("orientation", 0)));
        if (r4 != 16) goto L8;
    L12:
        r14.put("to_vs_episode_id", String.valueOf(this.j.getLong("live.intent.extra.VS_EPISODE_ID", 0)));
        r14.put("to_vs_ep_group_id", this.j.getString("live.intent.extra.EPISODE_GROUP_ID", ""));
        r14.put("to_room_type", "vs_room");
        r14.put("to_vs_episode_stage", b(r4));
    L13:
        if (r4 == 15) goto L16;
        if (r4 == 1) goto L16;
        if (r4 == 16) goto L16;
    L17:
        com.bytedance.android.livesdk.vs.f.c.c(r13, r14, new Object[0]);
        return;
    L16:
        r14.put("to_room_id", String.valueOf(r0));
        r14.put("to_anchor_id", com.bytedance.android.live.base.model.user.n0.c(this.j, "anchor_id"));
        goto L17
    L8:
        if (r4 == 17) goto L12;
        if (r4 == 15) goto L12;
        r14.put("to_room_type", "normal_room");
        goto L13
    }

    public final void j(int r4, Configuration r5) {
        if (this.j == null) goto L41;
        ObjectAnimator r0 = this.g;
        if (r0 == null) goto L9;
        if (r0.isRunning() == false) goto L9;
    L10:
        boolean r1 = true;
    L12:
        if (r1 == false) goto L41;
        if (r5 == null) goto L16;
    L18:
        RoomContext r2 = RoomContext.getShared();
        if (r4 == 1) goto L38;
        if (r5 != null) goto L22;
    L24:
        if (r2 != null) goto L26;
    L39:
        f(0);
        return;
    L26:
        if (r2.isVSSpecialDrawer() == false) goto L39;
        if (oj1.a.getValue().b() == false) goto L39;
        if (PadConfigUtils.c() == true) goto L32;
    L34:
        if (r4 != 0) goto L36;
    L37:
        i(false);
        h(true);
        goto L39
    L36:
        if (r4 != 8) goto L39;
    L32:
        if (r4 != 13) goto L34;
        i(false);
        h(true);
        goto L39
    L22:
        if (r5.orientation != 1) goto L24;
    L38:
        i(false);
        h(false);
        goto L39
    L16:
        if (com.bytedance.android.live.core.utils.s1.getResources() == null) goto L18;
        r5 = com.bytedance.android.live.core.utils.s1.getResources().getConfiguration();
    L9:
        if (com.bytedance.android.livesdk.config.m0.a.getValue().enableFixed() == true) goto L10;
        r1 = false;
    L41:
        i(true);
    }

    public s1(Context r2, Lifecycle r3, ViewGroup r4) {
        this.k = false;
        this.n = 0;
        this.o = BackRoomViewState.ChangeType.GONE;
        this.f = r3;
        this.b = r4;
        this.h = r2;
        if (r2 == null) goto L6;
        this.c = r4.findViewById(2131391990);
        this.d = (TextView) r4.findViewById(2131363786);
        this.e = r4.findViewById(2131365725);
        UIUtils.updateLayout(r4, -3, com.bytedance.android.live.core.utils.s1.f(26.0f));
    L6:
        this.a = (int) UIUtils.dip2Px(r2, 20.0f);
    }
}
