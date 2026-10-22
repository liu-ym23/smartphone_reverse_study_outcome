package com.bytedance.android.livesdk.floatview.inner;

import am2.x;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.m2;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livesdk.config.by0;
import com.bytedance.android.livesdk.log.l0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdk.schema.interfaces.IRoomActionHandler;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.floatview.FloatWindowConfig;
import com.bytedance.android.livesdkapi.floatview.FloatWindowEnterConfig;
import com.bytedance.android.livesdkapi.floatview.IInnerFloatWindowManager;
import com.bytedance.android.livesdkapi.floatview.IInnerFloatWindowSceneInterceptor;
import com.bytedance.android.livesdkapi.floatview.InnerFloatViewTAG;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.view.IVideoFloatManager;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import zg1.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class VideoWatchingInnerFloatWindowManager implements IInnerFloatWindowManager, IInnerFloatWindowSceneInterceptor {
    public static final Lazy p = null;
    public String a;
    public Room b;
    public String c;
    public String d;
    public HashMap<String, String> e;
    public float f;
    public float g;
    public float h;
    public com.bytedance.android.livesdk.floatview.mob.b i;
    public k j;
    public FloatWindowEnterConfig k;
    public Long l;
    public final List<IVideoFloatManager.VideoFloatManagerListener> m;
    public CountDownTimer n;
    public boolean o;

    public static final class a {
    }

    public final boolean canShow() {
        return true;
    }

    public final void reset() {
        this.b = null;
        this.c = "";
        this.d = "";
        this.e = null;
        this.f = 8.0f;
        this.g = 8.0f;
        this.h = 44.0f;
        this.i = null;
        this.k = null;
        this.j = null;
        CountDownTimer r1 = this.n;
        if (r1 == null) goto L5;
        r1.cancel();
    L5:
        this.n = null;
    }

    static {
        p = LazyKt.lazy(VideoWatchingInnerFloatWindowManager$Companion$inst$2.INSTANCE);
    }

    public final rx1.g c() {
        return (rx1.g) rx1.l.a(this.a);
    }

    public VideoWatchingInnerFloatWindowManager() {
        this.a = InnerFloatViewTAG.TAG_VIDEO_PREVIEW.getTag();
        this.c = "";
        this.d = "";
        this.f = 8.0f;
        this.g = 8.0f;
        this.h = 44.0f;
        this.m = new ArrayList();
    }

    public final boolean dismissWindowWhenToDesktop() {
        return IInnerFloatWindowManager.DefaultImpls.dismissWindowWhenToDesktop(this);
    }

    public final boolean floatWindowEntityExists() {
        if (c() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean floatWindowIsShowing() {
        rx1.g r0 = c();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.l != true) goto L7;
        return true;
    }

    public final void hideFloatWindow() {
        rx1.g r0 = c();
        if (r0 == null) goto L10;
        KeyEvent.Callback r1 = r0.a.c;
        if ((r1 instanceof com.bytedance.android.livesdk.floatview.f) == false) goto L11;
        com.bytedance.android.livesdk.floatview.f r2 = (com.bytedance.android.livesdk.floatview.f) r1;
        r2.e();
        if (r0.l == false) goto L12;
        r0.c();
        r2.onPause();
        return;
    L12:
        return;
    L11:
        return;
    }

    public final boolean hideWindowWhenToDesktop() {
        return !isPlaying();
    }

    public final boolean isPlaying() {
        rx1.g r0 = c();
        if (r0 == null) goto L14;
        View r1 = r0.a.c;
        if ((r1 instanceof k) == false) goto L15;
        LivePlayerView r2 = ((k) r1).getMLivePlayerView();
        if (r2 == null) goto L16;
        ILivePlayerClient r3 = r2.getClient();
        if (r3 != null) goto L11;
        return false;
    L11:
        if (r3.isPlaying() != true) goto L18;
        return true;
    L18:
        return false;
    L16:
        return false;
    L15:
        return false;
    L14:
        return false;
    }

    public final void showFloatWindow() {
        rx1.g r0 = c();
        if (r0 != null) goto L5;
        return;
    L5:
        KeyEvent.Callback r1 = r0.a.c;
        if ((r1 instanceof com.bytedance.android.livesdk.floatview.f) == false) goto L16;
        com.bytedance.android.livesdk.floatview.f r2 = (com.bytedance.android.livesdk.floatview.f) r1;
        if (r2.isPaused() == false) goto L10;
    L11:
        r2.g();
    L13:
        if (r0.l == true) goto L17;
        r0.e();
        r2.onResume();
        return;
    L17:
        return;
    L10:
        if (isPlaying() == true) goto L13;
    }

    public final String tag() {
        return this.a;
    }

    public static final void b(VideoWatchingInnerFloatWindowManager r9) {
        Room r0 = r9.b;
        if (r0 == null) goto L32;
        Activity r3 = jc1.k.n(IHostApp.class).getTopActivity();
        if (Intrinsics.areEqual(r9.a, InnerFloatViewTAG.TAG_LOTTERY_PREVIEW.getTag()) == false) goto L8;
        String r1 = "lottery";
    L9:
        JSONObject r2 = new JSONObject();
        r2.put("trigger_scene", r1);
        r2.put("initial_page", "content");
        r2.put("return_windows_type", "in");
        r2.put("is_mini_auto_play", m2.b(r9.o));
        String r4 = r2.toString();
        IHostBusiness r5 = jc1.k.f(IHostBusiness.class);
        String r6 = null;
        if (r5 == null) goto L12;
        String r7 = r5.createJumpSourceBtmToken("c486697.d415351");
    L13:
        if (r3 == null) goto L31;
        ILiveActionHandler r8 = com.bytedance.android.livesdk.service.l.d().a();
        IRoomActionHandler.Params r10 = new IRoomActionHandler.Params().setRoomId(r0.id).setRequestId(r0.getRequestId()).setLogPb(r0.getLog_pb()).setEnterFromMerge(r9.c).setEnterMethod(r9.d).setRoom(r0);
        FloatWindowEnterConfig r11 = r9.k;
        if (r11 == null) goto L17;
        long[] r12 = r11.getRoomIds();
    L18:
        IRoomActionHandler.Params r13 = r10.setRoomIds(r12);
        FloatWindowEnterConfig r14 = r9.k;
        if (r14 == null) goto L21;
        String r15 = r14.getDrawUrl();
    L22:
        IRoomActionHandler.Params r16 = r13.setDrawUrls(r15).setIsClickMiniWindow(1);
        Bundle r17 = new Bundle();
        FloatWindowEnterConfig r18 = r9.k;
        if (r18 == null) goto L25;
        r6 = r18.getMultiTabEvent();
    L25:
        r17.putString("live.intent.extra.drawtab_page", r6);
        Unit r19 = Unit.INSTANCE;
        IRoomActionHandler.Params r20 = r16.setEnterLiveBundle(r17).setSourceBtmToken(r7);
        FloatWindowEnterConfig r21 = r9.k;
        if (r21 == null) goto L28;
        boolean r22 = r21.isFromXTab();
    L29:
        IBaseLiveActionHandler.DefaultImpls.openRoom$default(r8, r3, r20.setIsFromXTab(r22).setExtraParams(r4), null, 4, null);
        return;
    L28:
        r22 = false;
        goto L29
    L21:
        r15 = null;
        goto L22
    L17:
        r12 = null;
        goto L18
    L31:
        return;
    L12:
        r7 = null;
        goto L13
    L8:
        r1 = "";
        goto L9
    }

    public final void addVideoFloatManagerListener(IVideoFloatManager.VideoFloatManagerListener r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (((ArrayList) this.m).contains(r2) == true) goto L8;
        ((ArrayList) this.m).add(r2);
        r2.toString();
        ((ArrayList) this.m).size();
        return;
    }

    public final void removeVideoFloatManagerListener(IVideoFloatManager.VideoFloatManagerListener r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (((ArrayList) this.m).contains(r2) == false) goto L8;
        ((ArrayList) this.m).remove(r2);
        r2.toString();
        ((ArrayList) this.m).size();
        return;
    }

    public final void showFloat(IRoom r14, FloatWindowConfig r15) {
        Intrinsics.checkNotNullParameter(r15, "floatWindowConfig");
        Lazy r0 = p;
        VideoWatchingInnerFloatWindowManager r1 = (VideoWatchingInnerFloatWindowManager) r0.getValue();
        String r2 = h.a;
        String r3 = InnerFloatViewTAG.TAG_VIDEO_PREVIEW.getTag();
        if (h.a() == false) goto L5;
        r3 = InnerFloatViewTAG.TAG_LOTTERY_PREVIEW.getTag();
    L5:
        r1.a = r3;
        List<Pair<IInnerFloatWindowSceneInterceptor, Integer>> r4 = b.a;
        String r5 = l0.a("enter_from_merge", u.l().c(x.class));
        String r6 = l0.a("enter_method", u.l().c(x.class));
        HashMap<String, String> r7 = new HashMap();
        r7.put("action_type", l0.a("action_type", u.l().c(x.class)));
        r7.put("video_id", l0.a("video_id", u.l().c(x.class)));
        DataCenter r8 = b.c;
        Room r9 = null;
        if (r8 != null) goto L8;
        FloatWindowEnterConfig r10 = null;
    L9:
        this.o = r15.isAutoPlay();
        if (r15.getFromOuterService() == false) goto L13;
        r5 = r15.getEnterFromMerge();
        r6 = r15.getEnterMethod();
        r7 = r15.getLogExtras();
        r10 = r15.getEnterConfig();
    L13:
        if (Intrinsics.areEqual(this.a, InnerFloatViewTAG.TAG_LOTTERY_PREVIEW.getTag()) == false) goto L15;
        Long r16 = h.d();
    L16:
        VideoWatchingInnerFloatWindowManager r11 = (VideoWatchingInnerFloatWindowManager) r0.getValue();
        if (r14 == null) goto L19;
        r9 = (Room) jm2.a.e((vh7.c) r14);
    L19:
        if (r9 != null) goto L21;
        r11.getClass();
    L33:
        VideoWatchingInnerFloatWindowManager r17 = (VideoWatchingInnerFloatWindowManager) r0.getValue();
        rx1.g r18 = r17.c();
        if (r18 == null) goto L41;
        KeyEvent.Callback r12 = r18.a.c;
        if ((r12 instanceof com.bytedance.android.livesdk.floatview.f) == false) goto L41;
        Room r13 = r17.b;
        if (r13 == null) goto L41;
        r18.e();
        r18.c();
        com.bytedance.android.livesdk.floatview.f r19 = (com.bytedance.android.livesdk.floatview.f) r12;
        r19.h(r13, r17.o);
        r19.onStart();
    L41:
        xs2.b.a().post(new h1(58));
        return;
    L21:
        r11.b = r9;
        r11.c = r5;
        r11.d = r6;
        r11.e = r7;
        r11.k = r10;
        r11.l = r16;
        if (r11.c() != null) goto L33;
        r11.g = 8.0f;
        r11.f = 8.0f;
        r11.h = 56.0f;
        if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.c(r11.b).l1(PaidSceneEnum.ALL) == true) goto L26;
    L28:
        boolean r110 = false;
    L29:
        Application r20 = jc1.a.b();
        Map<String, rx1.b> r21 = rx1.l.a;
        rx1.l.a r22 = new rx1.l.a(r20);
        Application r23 = jc1.a.b();
        String r24 = r11.a;
        HashMap r25 = new HashMap();
        r25.put("enter_from_merge", r11.c);
        r25.put("enter_method", r11.d);
        HashMap<String, String> r26 = r11.e;
        if (r26 == null) goto L32;
        r25.putAll(r26);
    L32:
        Unit r27 = Unit.INSTANCE;
        k r28 = new k(r23, r24, r25);
        r11.i = r28.getFloatWindowLogger();
        r28.setFloatViewListener(new j(r11));
        r11.j = r28;
        r22.b = r28;
        r22.c = 0;
        r22.d = 0;
        r22.q = r11.a;
        r22.e = 3;
        AccelerateDecelerateInterpolator r29 = new AccelerateDecelerateInterpolator();
        r22.o = 200;
        r22.p = r29;
        r22.r = true;
        r22.u = r110;
        r22.t = true;
        r22.n = false;
        int r111 = (int) UIUtils.dip2Px(jc1.a.b(), r11.f);
        int r112 = (int) UIUtils.dip2Px(jc1.a.b(), 0.0f);
        int r30 = (int) UIUtils.dip2Px(jc1.a.b(), r11.g);
        int r31 = (int) UIUtils.dip2Px(jc1.a.b(), 0.0f);
        r22.j = r111;
        r22.l = r112;
        r22.k = r30;
        r22.m = r31;
        r22.s = new i(r11);
        r22.a();
        goto L33
    L26:
        if (by0.a.getValue().booleanValue() == false) goto L28;
        r110 = true;
        goto L29
    L15:
        r16 = null;
        goto L16
    L8:
        Room r32 = z.a;
        r10 = new FloatWindowEnterConfig((String) r8.get("data_live_inner_feed_url", ""), (long[]) r8.get("data_live_extra_room_ids", null), ((Boolean) r8.get("data_live_is_from_xtab", Boolean.FALSE)).booleanValue(), l0.a("drawtab_page", u.l().c(x.class)));
        goto L9
    }

    public final void dismissFloatWindow(long r1, String r3, boolean r4) {
        rx1.g r2 = c();
        if (r2 == null) goto L7;
        KeyEvent.Callback r5 = r2.a.c;
        if ((r5 instanceof com.bytedance.android.livesdk.floatview.f) == false) goto L7;
        ((com.bytedance.android.livesdk.floatview.f) r5).stop();
        r2.a();
        int r6 = f.a;
        Intrinsics.checkNotNullParameter("window become invisible", "msg");
        ALogger.i("InnerFloatWindowTracker", "window become invisible");
    L7:
        reset();
    }
}
