package com.bytedance.android.livesdk.chatroom.wornhole;

import android.os.Handler;
import androidx.lifecycle.LiveData;
import com.bytedance.android.live.ai.api.IAiService;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.strategy.api.IStrategyService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.adapter.LiveDetailPagerAdapter;
import com.bytedance.android.livesdk.config.ez0;
import com.bytedance.android.livesdk.config.fz0;
import com.bytedance.android.livesdk.config.ia;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragment;
import com.bytedance.android.livesdkapi.depend.live.LiveRoomState;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.WormholeConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveWormholeFeatureOpt;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.live.datacontext.m;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Calendar;
import java.util.LinkedHashMap;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class Wormhole {
    public LiveDetailPagerAdapter a;
    public int b;
    public boolean c;
    public ILiveRoomPageFragment d;
    public final com.bytedance.android.livesdk.chatroom.wornhole.b e;
    public final a f;
    public final b g;
    public final d h;
    public final c i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;

    public static final class a {
        public final /* synthetic */ Wormhole a;

        public final void a() {
            com.bytedance.android.livesdk.chatroom.wornhole.c.a("onPredictEnter " + this.a.b);
            Wormhole r0 = this.a;
            LiveDetailPagerAdapter r1 = r0.a;
            if (r1 == null) goto L62;
            int r2 = r0.b;
            if (r2 < 0) goto L62;
            Intrinsics.checkNotNull(r1);
            if (r2 >= r1.getCount()) goto L62;
            this.a.getClass();
            if (Wormhole.h() == false) goto L12;
            return;
        L12:
            LiveDetailPagerAdapter r3 = this.a.a;
            Intrinsics.checkNotNull(r3);
            ILiveRoomPlayFragment r4 = r3.i(this.a.b);
            if (((Boolean) this.a.j.getValue()).booleanValue() == false) goto L20;
            ILivePlayerClient r5 = LivePlatformPlayerManager.f();
            if (r5 == null) goto L20;
            if (r5.getHasFirstFrame() == true) goto L20;
            com.bytedance.android.livesdk.chatroom.wornhole.c.a("isFirstFrameLimit");
            return;
        L20:
            ILiveRoomPageFragment r6 = this.a.d;
            if (r6 == null) goto L29;
            ILiveRoomPageFragment r7 = r6.getRealAction();
            if (r7 == null) goto L29;
            ILiveRoomPlayFragment r8 = r7.getCurrentFragment();
            if (r8 == null) goto L29;
            ILiveRoomPlayFragment r9 = r8.getRealAction();
            if (r9 == null) goto L29;
            LiveRoomState r10 = r9.getCurState();
        L31:
            if (((Boolean) this.a.k.getValue()).booleanValue() == false) goto L39;
            if (r10 == LiveRoomState.LIVE_STARTED) goto L39;
            if (r10 == LiveRoomState.PREPARED) goto L39;
            com.bytedance.android.livesdk.chatroom.wornhole.c.a("isEnterSuccessLimit,CurState:" + r10);
            return;
        L39:
            if (((Boolean) this.a.l.getValue()).booleanValue() == false) goto L52;
            ILiveRoomPageFragment r11 = this.a.d;
            if (r11 == null) goto L52;
            ILiveRoomPageFragment r12 = r11.getRealAction();
            if (r12 == null) goto L52;
            ILiveRoomPlayFragment r13 = r12.getCurrentFragment();
            if (r13 == null) goto L52;
            ILiveRoomPlayFragment r14 = r13.getRealAction();
            if (r14 == null) goto L52;
            if (r14.isAllWidgetLoaded() == true) goto L52;
            com.bytedance.android.livesdk.chatroom.wornhole.c.a("isWidgetLoadLimit,");
            return;
        L52:
            if (r4 != null) goto L54;
        L60:
            com.bytedance.android.livesdk.chatroom.wornhole.c.a("task end, next fragment == null or isCurrentFragment");
            Wormhole r15 = this.a;
            r15.b = -1;
            r15.c = false;
            return;
        L54:
            if (this.a.g(r4) == true) goto L60;
            com.bytedance.android.livesdk.chatroom.wornhole.c.a("enterWormhole " + this.a.b);
            ILiveRoomPlayFragment r16 = r4.getRealAction();
            this.a.getClass();
            ez0 r17 = ez0.a;
            r16.enterWormhole(r17.getValue().mUseAbr);
            i0.c().removeCallbacks(this.a.g);
            i0.c().postDelayed(this.a.h, Wormhole.f().mNoStreamCheckDelayTime);
            i0.c().removeCallbacks(this.a.i);
            Handler r18 = i0.c();
            c r19 = this.a.i;
            long r20 = r17.getValue().mSurviveTime;
            if (r20 >= 0) goto L59;
            r20 = 5000;
        L59:
            r18.postDelayed(r19, r20);
            return;
        L29:
            r10 = null;
        L62:
            Wormhole r21 = this.a;
            r21.b = -1;
            r21.c = false;
        }

        public a(Wormhole r1) {
            this.a = r1;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ Wormhole a;

        public final void a() {
            Wormhole r0 = this.a;
            LiveDetailPagerAdapter r1 = r0.a;
            if (r1 == null) goto L88;
            int r2 = r0.b;
            if (r2 < 0) goto L88;
            Intrinsics.checkNotNull(r1);
            if (r2 >= r1.getCount()) goto L88;
            Wormhole r3 = this.a;
            if (r3.e(r3.b) == null) goto L88;
            Wormhole r4 = this.a;
            int r5 = r4.b;
            LiveDetailPagerAdapter r6 = r4.a;
            boolean r7 = true;
            if (r6 == null) goto L61;
            if (r5 < 0) goto L61;
            Intrinsics.checkNotNull(r6);
            if (r5 >= r6.getCount()) goto L61;
            IStrategyService r8 = k.f(IStrategyService.class);
            if (r8 == null) goto L22;
            LiveData r9 = IStrategyService.a.a(r8, "inner_wormhole", Boolean.TRUE, false, 12);
            if (r9 == null) goto L22;
            Boolean r10 = (Boolean) r9.getValue();
        L24:
            if (Intrinsics.areEqual(r10, Boolean.FALSE) == false) goto L27;
            com.bytedance.android.livesdk.chatroom.wornhole.c.a("innerWormhole false");
            goto L61
        L27:
            if (Wormhole.h() == false) goto L29;
            com.bytedance.android.livesdk.chatroom.wornhole.c.a("isInLimitStreamTime false");
            goto L61
        L29:
            ILiveRoomPlayFragment r11 = r4.e(r5);
            if (r11 == null) goto L61;
            if (r11.getRealAction().getStreamType() == null) goto L61;
            LiveWormholeFeatureOpt r12 = fz0.a.getValue();
            if (r12.getEnable() == true) goto L37;
        L53:
            int r13 = ez0.a.getValue().mSupportType;
            if (r13 == 0) goto L60;
            LiveMode r14 = r11.getRealAction().getStreamType();
            com.bytedance.android.livesdk.chatroom.wornhole.c.a("wormhole stream is " + r14.name());
            if (r13 != 1) goto L61;
            if (r14 != LiveMode.VIDEO) goto L61;
        L60:
            boolean r15 = true;
        L62:
            if (r15 == true) goto L65;
            com.bytedance.android.livesdk.chatroom.wornhole.c.a("this stream not support.");
            Wormhole r16 = this.a;
            r16.b = -1;
            r16.c = false;
            return;
        L65:
            com.bytedance.android.livesdk.chatroom.wornhole.b r17 = this.a.e;
            ez0 r18 = ez0.a;
            long r19 = r18.getValue().mSurviveTime;
            long r20 = 0;
            if (r19 >= 0) goto L69;
            r19 = 5000;
        L69:
            a r21 = this.a.f;
            r17.getClass();
            Intrinsics.checkNotNullParameter(r21, "aiCallback");
            if (r18.getValue().mUseAI == true) goto L72;
        L74:
            r7 = false;
        L75:
            if (r7 == false) goto L86;
            System.currentTimeMillis();
            JSONObject r22 = new JSONObject();
            r22.put("survive_time", r19);
            RoomContext r23 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r23 == null) goto L83;
            m r24 = r23.getRoom();
            if (r24 == null) goto L83;
            Room r25 = (Room) r24.getValue();
            if (r25 == null) goto L83;
            r20 = r25.id;
        L83:
            r22.put("room_id", r20);
            IAiService r26 = k.f(IAiService.class);
            if (r26 == null) goto L90;
            r26.predict(new wx.a(String.valueOf(System.currentTimeMillis()), r22, new com.bytedance.android.livesdk.chatroom.wornhole.a(r21)));
            return;
        L90:
            return;
        L86:
            LinkedHashMap r27 = new LinkedHashMap();
            r27.put("predict_type", "0");
            r27.put("duration", String.valueOf(0));
            u.l().sendLog("livesdk_wormhole_slide_predict", r27, new Object[0]);
            r21.a();
            return;
        L72:
            if (ia.a.getValue().b() == false) goto L74;
        L37:
            if (r12.getPullTimeEnable() == false) goto L43;
            double r28 = r11.getRealAction().getPullStreamAvg();
            if (r28 <= 0) goto L43;
            if (r28 >= r12.getPullTimeLimit()) goto L43;
            boolean r29 = false;
        L45:
            if (r12.getRevSend() == false) goto L51;
            mz.b r30 = r11.getRealAction().getExplicitInfo();
            if (r30 != null) goto L49;
        L50:
            r29 = false;
            goto L51
        L49:
            if (r30.d == false) goto L50;
        L51:
            if (r29 == true) goto L53;
        L43:
            r29 = true;
        L22:
            r10 = null;
        L61:
            r15 = false;
        L88:
            com.bytedance.android.livesdk.chatroom.wornhole.c.a("mPrePullTask env check fail.");
            Wormhole r31 = this.a;
            r31.b = -1;
            r31.c = false;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(Wormhole r1) {
            this.a = r1;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ Wormhole a;

        public c(Wormhole r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.android.livesdk.chatroom.wornhole.c.a("run mSurviveCheckTask");     // Catch: Throwable -> L4
            Wormhole r0 = this.a;     // Catch: Throwable -> L4
            r0.d(r0.b);     // Catch: Throwable -> L4
            Wormhole r1 = this.a;     // Catch: Throwable -> L4
            r1.b = -1;     // Catch: Throwable -> L4
            r1.c = false;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ Wormhole a;

        public d(Wormhole r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.getClass();     // Catch: Throwable -> L12
            if (Wormhole.f().mEnableNoStreamCheck == false) goto L15;
            com.bytedance.android.livesdk.chatroom.wornhole.c.a("mTimeOutCheckTask run...");     // Catch: Throwable -> L12
            Wormhole r0 = this.a;     // Catch: Throwable -> L12
            ILiveRoomPlayFragment r1 = r0.e(r0.b);     // Catch: Throwable -> L12
            if (r1 == null) goto L19;
            ILiveRoomPlayFragment r2 = r1.getRealAction();     // Catch: Throwable -> L12
            if (r2 != null) goto L9;
            return;
        L9:
            if (r2.isInWormhole() != true) goto L21;
            r1.getRealAction().wormholeNoStreamCheck();     // Catch: Throwable -> L12
            return;
        L21:
            return;
        L19:
            return;
        L15:
            return;
        L12:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L22;
            throw th;
        }
    }

    public static WormholeConfig f() {
        return ez0.a.getValue();
    }

    public static boolean h() {
        IStrategyService r0 = k.f(IStrategyService.class);
        if (r0 == null) goto L7;
        LiveData r1 = IStrategyService.a.a(r0, "is_peak_time", -1, false, 12);
        if (r1 == null) goto L7;
        Integer r2 = (Integer) r1.getValue();
    L9:
        if (r2 != null) goto L12;
    L15:
        if (r2 == null) goto L22;
        if (r2.intValue() != 0) goto L22;
        com.bytedance.android.livesdk.chatroom.wornhole.c.a("is not in limit stream time by factor...");
        return false;
    L22:
        if (f().mStreamLimitStartTime > 0) goto L24;
    L32:
        return false;
    L24:
        if (f().mStreamLimitEndTime <= 0) goto L32;
        int r3 = f().mStreamLimitStartTime;
        int r4 = f().mStreamLimitEndTime + 1;
        Calendar r5 = Calendar.getInstance();
        r5.setTimeInMillis(com.bytedance.android.livesdk.utils.ntp.a.a + System.currentTimeMillis());
        int r6 = (r5.get(11) * 60) + r5.get(12);
        if (r3 > r6) goto L32;
        if (r4 <= r6) goto L32;
        com.bytedance.android.livesdk.chatroom.wornhole.c.a("is in limit stream time...");
        return true;
    L12:
        if (r2.intValue() != 1) goto L15;
        com.bytedance.android.livesdk.chatroom.wornhole.c.a("is in limit stream time by factor...");
        return true;
    L7:
        r2 = null;
        goto L9
    }

    public Wormhole() {
        this.b = -1;
        this.e = new com.bytedance.android.livesdk.chatroom.wornhole.b();
        this.f = new a(this);
        this.g = new b(this);
        this.h = new d(this);
        this.i = new c(this);
        this.j = LazyKt.lazy(Wormhole$isFirstFrameLimit$2.INSTANCE);
        this.k = LazyKt.lazy(Wormhole$isEnterSuccessLimit$2.INSTANCE);
        this.l = LazyKt.lazy(Wormhole$isWidgetLoadLimit$2.INSTANCE);
    }

    public final void b(int r4) {
        if (ez0.a.getValue().mEnable == true) goto L5;
        return;
    L5:
        i0.c().removeCallbacks(this.g);
        i0.c().removeCallbacks(this.i);
        i0.c().removeCallbacks(this.h);
        int r0 = this.b;
        if (r0 <= 0) goto L22;
        if (r4 == r0) goto L22;
        LiveDetailPagerAdapter r5 = this.a;
        if (r5 == null) goto L22;
        if (r0 < 0) goto L22;
        Intrinsics.checkNotNull(r5);
        if (r0 >= r5.getCount()) goto L22;
        ILiveRoomPlayFragment r6 = e(r0);
        if (r6 == null) goto L22;
        com.bytedance.android.livesdk.chatroom.wornhole.c.a("exitWormhole " + r0);
        ILiveRoomPlayFragment r1 = r6.getRealAction();
        if (r1 == null) goto L19;
        r1.exitWormhole();
    L19:
        ILiveRoomPlayFragment r7 = r6.getRealAction();
        if (r7 == null) goto L22;
        r7.stopPlayerForNextRoomPrePullStream();
    L22:
        this.b = -1;
        this.c = false;
    }

    public final void c(int r4) {
        LiveDetailPagerAdapter r0 = this.a;
        if (r0 == null) goto L12;
        if (r4 < 0) goto L13;
        Intrinsics.checkNotNull(r0);
        if (r4 >= r0.getCount()) goto L15;
        ILiveRoomPlayFragment r1 = e(r4);
        if (r1 == null) goto L14;
        com.bytedance.android.livesdk.chatroom.wornhole.c.a("exitWormhole " + r4);
        r1.getRealAction().exitWormhole();
        return;
    L14:
        return;
    L15:
        return;
    L13:
        return;
    }

    public final void d(int r4) {
        LiveDetailPagerAdapter r0 = this.a;
        if (r0 == null) goto L19;
        if (r4 < 0) goto L20;
        Intrinsics.checkNotNull(r0);
        if (r4 >= r0.getCount()) goto L24;
        ILiveRoomPlayFragment r1 = e(r4);
        if (r1 != null) goto L11;
        return;
    L11:
        if (g(r1) == true) goto L22;
        com.bytedance.android.livesdk.chatroom.wornhole.c.a("exitWormhole " + r4);
        ILiveRoomPlayFragment r5 = r1.getRealAction();
        if (r5 == null) goto L15;
        r5.exitWormhole();
    L15:
        ILiveRoomPlayFragment r6 = r1.getRealAction();
        if (r6 == null) goto L23;
        r6.stopPlayerForNextRoomPrePullStream();
        return;
    L23:
        return;
    L22:
        return;
    L24:
        return;
    L20:
        return;
    }

    public final ILiveRoomPlayFragment e(int r3) {
        LiveDetailPagerAdapter r0 = this.a;
        if (r0 == null) goto L9;
        if (r3 >= 0) goto L6;
        return null;
    L6:
        if (r3 < r0.getCount()) goto L8;
        return null;
    L8:
        return r0.i(r3);
    L9:
        return null;
    }

    public final boolean g(ILiveRoomPlayFragment r4) {
        ILiveRoomPlayFragment r0 = r4.getRealAction();
        ILiveRoomPlayFragment r1 = null;
        if (r0 == null) goto L5;
        as0.a r2 = r0.roomPlayerContext();
    L6:
        if (r2 == null) goto L32;
        ILiveRoomPlayFragment r3 = r4.getRealAction();
        if (r3 == null) goto L12;
        as0.a r5 = r3.roomPlayerContext();
        if (r5 == null) goto L12;
        ILivePlayerClient r6 = r5.player();
    L13:
        if (r6 == null) goto L32;
        if (this.d == null) goto L32;
        ILiveRoomPlayFragment r7 = r4.getRealAction();
        if (r7 == null) goto L22;
        as0.a r8 = r7.roomPlayerContext();
        if (r8 == null) goto L22;
        ILivePlayerClient r9 = r8.player();
    L24:
        if (r9 == LivePlatformPlayerManager.f()) goto L31;
        ILiveRoomPageFragment r10 = this.d;
        if (r10 == null) goto L30;
        ILiveRoomPageFragment r11 = r10.getRealAction();
        if (r11 == null) goto L30;
        r1 = r11.getCurrentFragment();
    L30:
        if (r4 != r1) goto L32;
    L31:
        return true;
    L22:
        r9 = null;
    L12:
        r6 = null;
    L32:
        return false;
    L5:
        r2 = null;
        goto L6
    }

    public final void i(int r10) {
        if (r10 >= 0) goto L4;
        return;
    L4:
        if ((r10 + 1) == this.b) goto L6;
        return;
    L6:
        if (this.c == true) goto L18;
        this.c = true;
        i0.c().removeCallbacks(this.g);
        i0.c().removeCallbacks(this.i);
        i0.c().removeCallbacks(this.h);
        StringBuilder r11 = new StringBuilder("post mPrePullTask ");
        r11.append(this.b);
        r11.append("; delay ");
        ez0 r0 = ez0.a;
        long r1 = r0.getValue().mEnterDelay;
        long r3 = 1000;
        if (r1 >= 0) goto L11;
        r1 = 1000;
    L11:
        r11.append(r1);
        com.bytedance.android.livesdk.chatroom.wornhole.c.a(r11.toString());
        Handler r12 = i0.c();
        b r2 = this.g;
        long r7 = r0.getValue().mEnterDelay;
        if (r7 < 0) goto L14;
        r3 = r7;
    L14:
        r12.postDelayed(r2, r3);
        return;
    }

    public final void a(int r6, int r7) {
        ez0 r0 = ez0.a;
        if (r0.getValue().mEnable == true) goto L5;
        return;
    L5:
        LiveDetailPagerAdapter r1 = this.a;
        if (r1 == null) goto L57;
        if (r7 < 0) goto L58;
        Intrinsics.checkNotNull(r1);
        if (r7 >= r1.getCount()) goto L60;
        int r2 = this.b;
        if (r2 < 0) goto L14;
        return;
    L14:
        int r3 = r7 + 1;
        if (r3 != r2) goto L18;
        return;
    L18:
        if (r6 == (-1)) goto L34;
        LiveDetailPagerAdapter r4 = this.a;
        if (r4 == null) goto L34;
        if (r7 < 0) goto L34;
        Intrinsics.checkNotNull(r4);
        if (r7 >= r4.getCount()) goto L34;
        ILiveRoomPlayFragment r5 = e(r7);
        if (r5 != null) goto L28;
    L33:
        com.bytedance.android.livesdk.chatroom.wornhole.c.a("NOT Hit Wormhole!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! position " + r7);
    L36:
        if (r0.getValue().mUseAbr == false) goto L51;
        if (r6 == (-1)) goto L50;
        LiveDetailPagerAdapter r8 = this.a;
        if (r8 == null) goto L50;
        if (r7 < 0) goto L50;
        Intrinsics.checkNotNull(r8);
        if (r7 >= r8.getCount()) goto L50;
        ILiveRoomPlayFragment r9 = e(r7);
        if (r9 == null) goto L51;
        if (r9.getRealAction().isInWormhole() == false) goto L51;
        com.bytedance.android.livesdk.chatroom.wornhole.c.a("prePlaySwitchRes position " + r7);
        r9.getRealAction().prePlaySwitchRes();
    L50:
        com.bytedance.android.livesdk.chatroom.wornhole.c.a("invalidate position " + r7);
    L51:
        if (r7 > r6) goto L53;
        return;
    L53:
        this.b = r3;
        this.c = false;
        com.bytedance.android.livesdk.chatroom.wornhole.c.a("enterRoom " + r7);
        if (r6 == (-1)) goto L59;
        u.l().b("livesdk_wormhole_slide_all");
        return;
    L59:
        return;
    L28:
        if (r5.getRealAction().isInWormhole() == false) goto L33;
        com.bytedance.android.livesdk.chatroom.wornhole.c.a("Hit Wormhole................................... position " + r7);
        ILivePlayerClient r10 = LivePlatformPlayerManager.f();
        if (r10 == null) goto L32;
        r10.setPreplayShow(1);
    L32:
        u.l().b("livesdk_wormhole_slide_correct");
    L34:
        com.bytedance.android.livesdk.chatroom.wornhole.c.a("invalidate hit rate position " + r7);
        goto L36
    L60:
        return;
    L58:
        return;
    }
}
