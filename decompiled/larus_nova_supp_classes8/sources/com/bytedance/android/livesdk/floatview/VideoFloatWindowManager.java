package com.bytedance.android.livesdk.floatview;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PowerManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.IHostGameCP;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.by0;
import com.bytedance.android.livesdk.floatview.mob.VideoFloatWindowLogger;
import com.bytedance.android.livesdk.player.State;
import com.bytedance.android.livesdk.vscore_api.paid.PaidInteractEntry;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IBaseEpisodeMod;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.view.IVideoFloatManager;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class VideoFloatWindowManager implements IFloatWindowManager {
    public static final q f = null;
    public static final Lazy g = null;
    public static final float h = 0.0f;
    public static final float i = 0.0f;
    public final String a;
    public Room b;
    public boolean c;
    public final List<IVideoFloatManager.VideoFloatManagerListener> d;
    public com.bytedance.android.livesdk.floatview.mob.b e;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/floatview/VideoFloatWindowManager$ActionType;", "", "SHOW", "CLICK", "MUTECLICK", "CLOSE", "RETURNCLICK", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ActionType extends Enum<ActionType> {
        public static final ActionType CLICK = null;
        public static final ActionType CLOSE = null;
        public static final ActionType MUTECLICK = null;
        public static final ActionType RETURNCLICK = null;
        public static final ActionType SHOW = null;
        public static final /* synthetic */ ActionType[] a = null;

        static {
            ActionType r1 = new ActionType("SHOW", 0);
            SHOW = r1;
            ActionType r2 = new ActionType("CLICK", 1);
            CLICK = r2;
            ActionType r3 = new ActionType("MUTECLICK", 2);
            MUTECLICK = r3;
            ActionType r4 = new ActionType("CLOSE", 3);
            CLOSE = r4;
            ActionType r5 = new ActionType("RETURNCLICK", 4);
            RETURNCLICK = r5;
            a = new ActionType[]{r1, r2, r3, r4, r5};
        }

        public static ActionType valueOf(String r1) {
            return (ActionType) r27.a.a(ActionType.class, r1);
        }

        public static ActionType[] values() {
            return (ActionType[]) a.clone();
        }

        public ActionType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a implements nz.s {
        public a() {
        }

        public final void b() {
        }

        public final void onCreate(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        public final void onPause(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        public final void onStart(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        public final void onStop(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        public final void a(Activity r4) {
            Intrinsics.checkNotNullParameter(r4, "activity");
            Iterator r0 = jc1.k.n(IHostApp.class).getAllLiveActivity().iterator();
        L4:
            if (r0.hasNext() == false) goto L17;
            Class r1 = (Class) r0.next();
            if (r1 == null) goto L4;
            if (r1.isAssignableFrom(r4.getClass()) != true) goto L4;
            ALogger.i("VideoFloatWindowManager", "hide because of liveActivity destroyed activity is " + r4.getClass());
            q r5 = VideoFloatWindowManager.f;
            IFloatWindowManager.a.a(b.a(), true, 1);
            return;
        }

        public final void c(Context r13) {
            q r0 = VideoFloatWindowManager.f;
            Room r1 = jc1.k.n(IRoomService.class).getCurrentRoom();
            if (r1 == null) goto L6;
            Object r2 = r1.getOwnerUserIdString();
            if (r2 == null) goto L6;
        L8:
            if (Intrinsics.areEqual(r2, jc1.k.n(IUserService.class).user().n()) == false) goto L11;
            ALogger.i("VideoFloatWindowManager", "cant show: isAnchor");
            return;
        L11:
            Room r3 = b.a().b;
            if (r3 == null) goto L14;
            long r4 = r3.getRoomId();
        L15:
            IBaseEpisodeMod r5 = null;
            if (com.bytedance.android.livesdk.vscore_api.paidlive.c.a.b(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.a(r4, null), PaidSceneEnum.PAID_ROOM, 2) == true) goto L20;
            ALogger.i("VideoFloatWindowManager", "cant show: PaidLiveUtils.hasFullWatchRight is false");
            return;
        L20:
            if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.a(r4, null).F0(PaidInteractEntry.CONTROL_ENTRY_FLOAT_WINDOW) == true) goto L23;
            ALogger.i("VideoFloatWindowManager", "cant show: paidManagerService check is false");
            return;
        L23:
            Integer r6 = (Integer) ((ge1.a) hd0.c.f()).b;
            if (r6 != null) goto L27;
        L28:
            ALogger.i("VideoFloatWindowManager", "cant show: LinkPlayerState != statle_idle");
            return;
        L27:
            if (r6.intValue() != 0) goto L28;
            ILivePlayerClient r7 = LivePlatformPlayerManager.f();
            if (r7 != null) goto L33;
        L160:
            ALogger.i("VideoFloatWindowManager", "cant show: player is released or in background");
            return;
        L33:
            if (r7.isPlaying() != true) goto L160;
            ILivePlayerClient r8 = LivePlatformPlayerManager.f();
            if (r8 != null) goto L37;
        L45:
            IHostGameCP r9 = jc1.k.f(IHostGameCP.class);
            if (r9 != null) goto L48;
        L51:
            if (r13 != null) goto L53;
            r13 = jc1.k.n(IHostApp.class).getTopActivity();
        L53:
            RoomContext r10 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            boolean r11 = false;
            if (r10 == null) goto L60;
            com.bytedance.live.datacontext.i r12 = r10.isEnterFromPreviewLiveMix();
            if (r12 == null) goto L60;
            Boolean r14 = (Boolean) r12.getValue();
            if (r14 == null) goto L60;
            boolean r15 = r14.booleanValue();
        L62:
            if ((r13 instanceof Activity) == false) goto L109;
            Iterator r16 = jc1.k.n(IHostApp.class).getAllWatchLiveActivity(r15).iterator();
            boolean r17 = false;
        L65:
            if (r16.hasNext() == false) goto L69;
            if (Intrinsics.areEqual(((Activity) r13).getClass(), (Class) r16.next()) == false) goto L65;
            r17 = true;
            goto L65
        L69:
            ALogger.d("VideoFloatWindowManager", "can show: " + r17);
            if (p.e() == false) goto L78;
            if (r17 == true) goto L73;
            return;
        L73:
            if (((Activity) r13).isInPictureInPictureMode() == true) goto L181;
            p.a = true;
            if (p.f == true) goto L77;
            Lazy r18 = VideoFloatWindowLogger.a;
            VideoFloatWindowLogger.a.a().getClass();
            VideoFloatWindowLogger.f();
            return;
        L77:
            p.f = false;
            return;
        L181:
            return;
        L78:
            q r19 = NewVideoInnerFloatManager.p;
            if (NewVideoInnerFloatManager.b.a().i() == false) goto L81;
            r17 = false;
        L81:
            if (r17 == false) goto L184;
            p.a = true;
            if (p.e == true) goto L85;
            Lazy r20 = VideoFloatWindowLogger.a;
            VideoFloatWindowLogger.a.a().getClass();
            VideoFloatWindowLogger.f();
        L87:
            if (p.d(r13) == false) goto L185;
            q r21 = VideoFloatWindowManager.f;
            b.a().getClass();
            if (VideoFloatWindowManager.d() == true) goto L91;
            return;
        L91:
            if (b.a().e() == true) goto L187;
            b.a().b = jc1.k.n(IRoomService.class).getCurrentRoom();
            Room r22 = b.a().b;
            if (r22 != null) goto L95;
            ALogger.i("VideoFloatWindowManager", "room is null");
            return;
        L95:
            if (r22.getEpisodeExtra2() == null) goto L100;
            EpisodeExtraInfo r23 = r22.getEpisodeExtra2();
            if (r23 == null) goto L99;
            r5 = r23.getEpisodeMod();
        L99:
            if (r5 == null) goto L100;
            return;
        L100:
            b.a().getClass();
        L106:
            th = move-exception;
            ALogger.e("VideoFloatWindowManager", th.toString());
            return;
        L102:
            if (Build.VERSION.SDK_INT < 26) goto L104;
            r13.startForegroundService(new Intent(r13, VideoFloatWindowService.class));     // Catch: Throwable -> L106
        L165:
            return;
        L104:
            r13.startService(new Intent(r13, VideoFloatWindowService.class));     // Catch: Throwable -> L106
            goto L165
        L187:
            return;
        L185:
            return;
        L85:
            p.e = false;
            goto L87
        L184:
            return;
        L109:
            List r24 = jc1.k.n(IHostApp.class).getAllWatchLiveActivity(r15);
            Activity r25 = jc1.k.n(IHostApp.class).getTopActivity();
            Iterator r26 = r24.iterator();
            boolean r27 = false;
        L111:
            if (r26.hasNext() == false) goto L119;
            Class r110 = (Class) r26.next();
            if (r25 == null) goto L115;
            Class<?> r111 = r25.getClass();
        L117:
            if (Intrinsics.areEqual(r111, r110) == false) goto L111;
            r27 = true;
            goto L111
        L115:
            r111 = null;
            goto L117
        L119:
            ALogger.d("VideoFloatWindowManager", "can show: " + r27);
            if (p.e() == false) goto L129;
            if (r27 == false) goto L191;
            if (r25 != null) goto L124;
            return;
        L124:
            if (r25.isInPictureInPictureMode() == true) goto L193;
            p.a = true;
            if (p.f == true) goto L128;
            Lazy r112 = VideoFloatWindowLogger.a;
            VideoFloatWindowLogger.a.a().getClass();
            VideoFloatWindowLogger.f();
            return;
        L128:
            p.f = false;
            return;
        L193:
            return;
        L191:
            return;
        L129:
            q r28 = NewVideoInnerFloatManager.p;
            if (NewVideoInnerFloatManager.b.a().i() == true) goto L133;
            r11 = r27;
        L133:
            if (r11 == false) goto L196;
            Lazy r29 = VideoFloatWindowLogger.a;
            VideoFloatWindowLogger.a.a().getClass();
            VideoFloatWindowLogger.f();
            p.a = true;
            if (p.d(r13) == false) goto L197;
            q r30 = VideoFloatWindowManager.f;
            b.a().getClass();
            if (VideoFloatWindowManager.d() == true) goto L139;
            return;
        L139:
            if (b.a().e() == true) goto L199;
            b.a().b = jc1.k.n(IRoomService.class).getCurrentRoom();
            Room r31 = b.a().b;
            if (r31 != null) goto L143;
            ALogger.i("VideoFloatWindowManager", "room is null");
            return;
        L143:
            if (r31.getEpisodeExtra2() == null) goto L148;
            EpisodeExtraInfo r32 = r31.getEpisodeExtra2();
            if (r32 == null) goto L147;
            r5 = r32.getEpisodeMod();
        L147:
            if (r5 == null) goto L148;
            return;
        L148:
            b.a().getClass();
        L156:
            th = move-exception;
            ALogger.e("VideoFloatWindowManager", th.toString());
            return;
        L150:
            if (Build.VERSION.SDK_INT < 26) goto L153;
            if (r13 == null) goto L162;
            r13.startForegroundService(new Intent(r13, VideoFloatWindowService.class));     // Catch: Throwable -> L156
        L162:
            return;
        L153:
            if (r13 == null) goto L162;
            r13.startService(new Intent(r13, VideoFloatWindowService.class));     // Catch: Throwable -> L156
            goto L162
        L199:
            return;
        L197:
            return;
        L196:
            return;
        L60:
            r15 = false;
            goto L62
        L48:
            if (r9.interceptLiveFloatWindow() != true) goto L51;
            ALogger.i("VideoFloatWindowManager", "gamecp intercept float window");
            return;
        L37:
            if (r8.isMute() != true) goto L45;
            ILivePlayerClient r33 = LivePlatformPlayerManager.f();
            if (r33 == null) goto L41;
            State r34 = r33.getCurrentState();
        L43:
            if ((r34 instanceof State.Background) == false) goto L45;
        L41:
            r34 = null;
            goto L43
        L14:
            r4 = 0;
        L6:
            r2 = 0L;
            goto L8
        }

        public final void onResume(Activity r8) {
            Intrinsics.checkNotNullParameter(r8, "activity");
            q r1 = VideoFloatWindowManager.f;
            boolean r2 = false;
            IFloatWindowManager.a.a(b.a(), false, 3);
            if (p.e() == false) goto L37;
            RoomContext r3 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r3 == null) goto L11;
            com.bytedance.live.datacontext.i r4 = r3.isEnterFromPreviewLiveMix();
            if (r4 == null) goto L11;
            Boolean r5 = (Boolean) r4.getValue();
            if (r5 == null) goto L11;
            r2 = r5.booleanValue();
        L11:
            List r6 = jc1.k.n(IHostApp.class).getAllWatchLiveActivity(r2);
            Activity r7 = jc1.k.n(IHostApp.class).getTopActivity();
            Iterator r9 = r6.iterator();
        L13:
            if (r9.hasNext() == false) goto L53;
            Class r10 = (Class) r9.next();
            if (r7 == null) goto L17;
            Class<?> r11 = r7.getClass();
        L19:
            if (Intrinsics.areEqual(r11, r10) == false) goto L13;
            if ((!Intrinsics.areEqual(r7, r8)) == false) goto L13;
            if (r7.isFinishing() == true) goto L13;
            int r12 = l.a;
            Intrinsics.checkNotNullParameter(r8, "context");
            Object r13 = r8.getSystemService("activity");
            if ((r13 instanceof ActivityManager) == true) goto L27;
            r13 = null;
        L27:
            ActivityManager r14 = (ActivityManager) r13;
            if (r14 == null) goto L30;
            List<ActivityManager.AppTask> r15 = r14.getAppTasks();
        L31:
            if (r15 == null) goto L13;
            if (r15.size() <= 0) goto L13;
            ActivityManager.AppTask r16 = (ActivityManager.AppTask) ListProtector.get(r15, r15.size() - 1);
            if (r16 == null) goto L13;
            r16.moveToFront();
            goto L13
        L30:
            r15 = null;
            goto L31
        L17:
            r11 = null;
            goto L19
        L53:
            return;
        }
    }

    public static final class b {
        public static VideoFloatWindowManager a() {
            return (VideoFloatWindowManager) VideoFloatWindowManager.g.getValue();
        }
    }

    public final boolean e() {
        Object r1 = jc1.a.b().getSystemService("keyguard");     // Catch: Exception -> L10
        if (r1 == null) goto L9;
        if (((KeyguardManager) r1).inKeyguardRestrictedInputMode() == true) goto L15;
        return false;
    L15:
        return true;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type android.app.KeyguardManager");     // Catch: Exception -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // com.bytedance.android.livesdk.floatview.IFloatWindowManager
    public final void reset() {
        this.b = null;
    }

    static {
        f = new q(jc1.a.b(), new a());
        g = LazyKt.lazy(VideoFloatWindowManager$Companion$instance$2.INSTANCE);
        h = 12.0f;
        i = 162.0f;
    }

    public final rx1.g c() {
        return (rx1.g) rx1.l.a(this.a);
    }

    @Override // com.bytedance.android.livesdk.floatview.IFloatWindowManager
    public final void showFloatWindow() {
        if (f.a == true) goto L5;
        return;
    L5:
        boolean r0 = p.a;
        if (p.d(jc1.a.b()) == true) goto L8;
        return;
    L8:
        if (this.c == true) goto L24;
        this.c = true;
        rx1.g r1 = c();
        if (r1 != null) goto L13;
    L17:
        VideoFloatWindowView r2 = new VideoFloatWindowView(jc1.a.b(), 0);
        this.e = r2.getFloatWindowLogger();
        r2.setFloatViewListener(new s(this));
        if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.c(b.a().b).l1(PaidSceneEnum.ALL) == true) goto L20;
    L22:
        boolean r3 = false;
    L23:
        Context r5 = s1.getContext();
        Map<String, rx1.b> r6 = rx1.l.a;
        rx1.l.a r7 = new rx1.l.a(r5);
        r7.b = r2;
        r7.c = 0;
        r7.d = 0;
        r7.q = this.a;
        r7.e = 2;
        int r4 = (int) UIUtils.dip2Px(jc1.a.b(), 12.0f);
        int r8 = (int) UIUtils.dip2Px(jc1.a.b(), 12.0f);
        r7.f = r4;
        r7.g = r8;
        AccelerateDecelerateInterpolator r9 = new AccelerateDecelerateInterpolator();
        r7.o = 300;
        r7.p = r9;
        r7.r = true;
        r7.t = true;
        r7.u = r3;
        r7.s = new t(this);
        r7.a();
        goto L24
    L20:
        if (by0.a.getValue().booleanValue() == false) goto L22;
        r3 = true;
        goto L23
    L13:
        if (r1.l != true) goto L17;
        rx1.g r10 = c();
        if (r10 == null) goto L17;
        r10.a();
    L24:
        Room r11 = b.a().b;
        if (r11 == null) goto L27;
        long r12 = r11.getRoomId();
    L29:
        if (com.bytedance.android.livesdk.vscore_api.paidlive.c.a.b(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.a(r12, null), PaidSceneEnum.PAID_ROOM, 2) == true) goto L33;
        ALogger.i("VideoFloatWindowManager", "showFloatWindow cant show: PaidLiveUtils.hasFullWatchRight is false");
        return;
    L33:
        if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.a(r12, null).F0(PaidInteractEntry.CONTROL_ENTRY_FLOAT_WINDOW) == true) goto L37;
        ALogger.i("VideoFloatWindowManager", "showFloatWindow cant show: paidManagerService check is false");
        return;
    L37:
        if (this.b == null) goto L50;
        rx1.g r13 = c();
        if (r13 != null) goto L41;
    L43:
        rx1.g r14 = c();
        if (r14 == null) goto L51;
        r14.e();
        r14.c();
        KeyEvent.Callback r15 = r14.a.c;
        if ((r15 instanceof f) == false) goto L52;
        ((f) r15).h(this.b, true);
        return;
    L52:
        return;
    L51:
        return;
    L41:
        if (r13.l != true) goto L43;
        return;
    L50:
        return;
    L27:
        r12 = 0;
        goto L29
    }

    public VideoFloatWindowManager() {
        this.a = "video_float_view";
        this.d = new ArrayList();
    }

    public static boolean d() {
        Object r0 = jc1.a.b().getSystemService("power");     // Catch: Throwable -> L11
        if (r0 == null) goto L10;
        PowerManager r1 = (PowerManager) r0;     // Catch: Throwable -> L11
        if (r1.isInteractive() == true) goto L16;
        if (r1.isScreenOn() == true) goto L16;
    L13:
        return false;
    L16:
        return true;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.os.PowerManager");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.printStackTrace();
        goto L13
    }

    @Override // com.bytedance.android.livesdk.floatview.IFloatWindowManager
    public final Room getCurRoom() {
        return this.b;
    }

    public static final DataCenter b(VideoFloatWindowManager r4) {
        r4.getClass();
        RoomContext r5 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r5 == null) goto L8;
        com.bytedance.live.datacontext.j r6 = r5.getDataCenter2();
        if (r6 != null) goto L7;
        return null;
    L7:
        return (DataCenter) r6.getValue();
    L8:
        return null;
    }

    @Override // com.bytedance.android.livesdk.floatview.IFloatWindowManager
    public final void addVideoFloatManagerListener(IVideoFloatManager.VideoFloatManagerListener r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (((ArrayList) this.d).contains(r2) == true) goto L8;
        ((ArrayList) this.d).add(r2);
        r2.toString();
        ((ArrayList) this.d).size();
        return;
    }

    @Override // com.bytedance.android.livesdk.floatview.IFloatWindowManager
    public final void removeVideoFloatManagerListener(IVideoFloatManager.VideoFloatManagerListener r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (((ArrayList) this.d).contains(r2) == false) goto L8;
        ((ArrayList) this.d).remove(r2);
        r2.toString();
        ((ArrayList) this.d).size();
        return;
    }

    @Override // com.bytedance.android.livesdk.floatview.IFloatWindowManager
    public final void setRoom(Room r1) {
        this.b = r1;
    }

    @Override // com.bytedance.android.livesdk.floatview.IFloatWindowManager
    public final void hideFloatWindow(boolean r4, boolean r5) {
        VideoFloatWindowService.Companion.stopService();
        com.bytedance.android.livesdk.floatview.mob.b r0 = this.e;
        Object r1 = null;
        if (r0 == null) goto L5;
        int r2 = com.bytedance.android.livesdk.floatview.mob.b.o;
        r0.l(r4, r5, null, null);
    L5:
        rx1.g r6 = c();
        if (r6 == null) goto L32;
        rx1.f r7 = r6.a;
        if (r7 == null) goto L10;
        KeyEvent.Callback r8 = r7.c;
    L12:
        if ((r8 instanceof f) == true) goto L14;
        r8 = null;
    L14:
        f r9 = (f) r8;
        if (r9 == null) goto L18;
        r9.stop();
    L18:
        if (r6.l == false) goto L20;
        r6.c();
    L20:
        rx1.f r10 = r6.a;
        if (r10 == null) goto L23;
        View r11 = r10.c;
    L25:
        if ((r11 instanceof f) == false) goto L28;
        r1 = r11;
    L28:
        f r3 = (f) r1;
        if (r3 == null) goto L33;
        r3.reset();
        return;
    L33:
        return;
    L23:
        r11 = null;
        goto L25
    L10:
        r8 = null;
        goto L12
    }

    public static void g(List r1, ActionType r2, boolean r3) {
        if (r1 != null) goto L4;
        return;
    L4:
        ArrayList r0 = new ArrayList(r1);
        int r4 = r.a[r2.ordinal()];
        if (r4 != 1) goto L7;
        Iterator r5 = r0.iterator();
    L41:
        if (r5.hasNext() == false) goto L75;
        IVideoFloatManager.VideoFloatManagerListener r6 = (IVideoFloatManager.VideoFloatManagerListener) r5.next();
        if (r6 == null) goto L41;
        r6.onShow();
        goto L41
    L75:
        return;
    L7:
        if (r4 != 2) goto L9;
        Iterator r7 = r0.iterator();
    L35:
        if (r7.hasNext() == false) goto L74;
        IVideoFloatManager.VideoFloatManagerListener r8 = (IVideoFloatManager.VideoFloatManagerListener) r7.next();
        if (r8 == null) goto L35;
        r8.onClick();
        goto L35
    L74:
        return;
    L9:
        if (r4 != 3) goto L11;
        Iterator r9 = r0.iterator();
    L29:
        if (r9.hasNext() == false) goto L73;
        IVideoFloatManager.VideoFloatManagerListener r10 = (IVideoFloatManager.VideoFloatManagerListener) r9.next();
        if (r10 == null) goto L29;
        r10.onMuteButtonClick(r3);
        goto L29
    L73:
        return;
    L11:
        if (r4 != 4) goto L13;
        Iterator r11 = r0.iterator();
    L23:
        if (r11.hasNext() == false) goto L72;
        IVideoFloatManager.VideoFloatManagerListener r12 = (IVideoFloatManager.VideoFloatManagerListener) r11.next();
        if (r12 == null) goto L23;
        r12.onClose(r3);
        goto L23
    L72:
        return;
    L13:
        if (r4 != 5) goto L45;
        Iterator r13 = r0.iterator();
    L17:
        if (r13.hasNext() == false) goto L71;
        IVideoFloatManager.VideoFloatManagerListener r14 = (IVideoFloatManager.VideoFloatManagerListener) r13.next();
        if (r14 == null) goto L17;
        r14.onReturnClick();
        goto L17
    L71:
        return;
    }
}
