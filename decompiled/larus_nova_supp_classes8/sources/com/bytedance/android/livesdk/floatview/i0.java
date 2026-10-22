package com.bytedance.android.livesdk.floatview;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.y6;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.zw;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.LiveFloatWindowStatus;
import com.bytedance.android.livesdkapi.model.PlayerInnerDrawerConfig;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerScene;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerClientContext;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerConfig;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.roomplayer.LiveRequest;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i0 implements Runnable {
    public final /* synthetic */ VideoFloatWindowView a;

    public i0(VideoFloatWindowView r1) {
        this.a = r1;
    }

    public final void a() {
        ILivePlayerScene r2 = null;
        if (this.a.getMLivePlayerView$livesdk_saasRelease() == null) goto L5;
        this.a.j();
        this.a.setMLivePlayerView$livesdk_saasRelease(null);
        ALogger.i("VideoFloatWindowView", "make LivePlayerView null");
    L5:
        LivePlayerConfig.Companion r0 = LivePlayerConfig.Companion;
        if (this.a.m != 0) goto L8;
        f.N0.getClass();
        ILivePlayerScene r3 = f.a.b;
    L9:
        Room r4 = this.a.h;
        if (r4 == null) goto L12;
        String r5 = String.valueOf(r4.id);
    L13:
        if (r5 != null) goto L15;
        r5 = "";
    L15:
        this.a.setMLivePlayerView$livesdk_saasRelease(new LivePlayerView(this.a.getContext(), r0.buildWith(r3, r5, this.a.n(), this.a.n())));
        ALogger.i("VideoFloatWindowView", "create new LivePlayerView");
        LivePlayerView r1 = this.a.getMLivePlayerView$livesdk_saasRelease();
        if (r1 == null) goto L24;
        ILivePlayerClient r6 = r1.getClient();
        if (r6 == null) goto L24;
        ILivePlayerScene r7 = r6.context().getCreateScene();
        ILivePlayerScene r8 = r6.context().getUseScene();
        boolean r9 = this.a.n();
        VideoFloatWindowView.b(this.a, r6);
        ALogger.i("VideoFloatWindowView", "isSharePlayer: " + (r9 ? 1 : 0) + ", creatScene: " + r7 + ", useScene: " + r8);
        com.bytedance.android.livesdk.log.g r10 = com.bytedance.android.livesdk.log.u.l();
        LinkedHashMap r11 = new LinkedHashMap();
        r11.put("isSharePlayer", String.valueOf(r9 ? 1 : 0));
        r11.put("creatScene", r7.getScene());
        r11.put("useScene", r8.getScene());
        if (zw.a.getValue().booleanValue() == false) goto L22;
        String r12 = "true";
    L23:
        r11.put("cancel_share_type_out", r12);
        Unit r13 = Unit.INSTANCE;
        r10.sendLog("livesdk_test_share_player", r11, new Object[0]);
        r6.getEventHub().getBackgroundHandlerRunning().observeForever(this.a.E);
        goto L24
    L22:
        r12 = "false";
    L24:
        VideoFloatWindowView r14 = this.a;
        Room r15 = r14.h;
        if (r15 == null) goto L141;
        LivePlayerView r16 = r14.getMLivePlayerView$livesdk_saasRelease();
        if (r16 == null) goto L29;
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
    L31:
        if (r17 == null) goto L44;
        LivePlayerView r18 = this.a.getMLivePlayerView$livesdk_saasRelease();
        if (r18 == null) goto L44;
        ViewGroup.LayoutParams r19 = r18.getLayoutParams();
        if (r19 == null) goto L44;
        if (r19.width != (-1)) goto L44;
        LivePlayerView r20 = this.a.getMLivePlayerView$livesdk_saasRelease();
        if (r20 == null) goto L44;
        ViewGroup.LayoutParams r21 = r20.getLayoutParams();
        if (r21 == null) goto L44;
        if (r21.height != (-1)) goto L44;
    L47:
        LivePlayerView r22 = this.a.getMLivePlayerView$livesdk_saasRelease();
        if (r22 == null) goto L50;
        r22.setVisibility(0);
    L50:
        LivePlayerView r23 = this.a.getMLivePlayerView$livesdk_saasRelease();
        if (r23 == null) goto L54;
        r23.setScaleType(2);
    L54:
        if (((RelativeLayout) this.a.a(2131372965)).indexOfChild(this.a.getMLivePlayerView$livesdk_saasRelease()) >= 0) goto L56;
        ((RelativeLayout) this.a.a(2131372965)).addView(this.a.getMLivePlayerView$livesdk_saasRelease());
    L56:
        LiveRequest r24 = this.a.i();
        LivePlayerView r25 = this.a.getMLivePlayerView$livesdk_saasRelease();
        if (r25 == null) goto L102;
        ILivePlayerClient r26 = r25.getClient();
        if (r26 == null) goto L102;
        LivePlayerClientContext r27 = r26.context();
        if (r27 == null) goto L102;
        if (r27.isSharedClient() != true) goto L102;
        LivePlayerView r28 = this.a.getMLivePlayerView$livesdk_saasRelease();
        if (r28 == null) goto L69;
        ILivePlayerClient r29 = r28.getClient();
        if (r29 == null) goto L69;
        String r30 = r29.getCurrentResolution();
    L71:
        if ((!Intrinsics.areEqual(r30, r24.getResolution())) == false) goto L101;
        ALogger.i("VideoFloatWindowView", "share player resolution need change to " + r24.getResolution());
        VideoFloatWindowView r31 = this.a;
        if (r31.m != 1) goto L82;
        LivePlayerView r32 = r31.getMLivePlayerView$livesdk_saasRelease();
        if (r32 == null) goto L80;
        ILivePlayerClient r33 = r32.getClient();
        if (r33 == null) goto L80;
        String r34 = r33.getCurrentResolution();
        if (r34 == null) goto L80;
    L81:
        r31.u = r34;
    L80:
        r34 = r24.getResolution();
    L82:
        VideoFloatWindowView r35 = this.a;
        if (r35.m == 1) goto L85;
    L87:
        int r36 = ((PlayerInnerDrawerConfig) y6.a.getValue()).getOptShareOuterFloatWindowResolutionStrategy();
    L88:
        if (r36 == 0) goto L96;
        if (r36 != 1) goto L102;
        LivePlayerView r37 = this.a.getMLivePlayerView$livesdk_saasRelease();
        if (r37 == null) goto L102;
        ILivePlayerClient r38 = r37.getClient();
        if (r38 == null) goto L102;
        r38.smoothSwitchResolution(r24.getResolution(), 2, true);
        goto L102
    L96:
        LivePlayerView r39 = this.a.getMLivePlayerView$livesdk_saasRelease();
        if (r39 == null) goto L102;
        ILivePlayerClient r40 = r39.getClient();
        if (r40 == null) goto L102;
        r40.switchResolution(r24.getResolution(), "share_outer_float_window_start", null);
        goto L102
    L85:
        if (VideoFloatWindowView.d(r35) < 0) goto L87;
        r36 = VideoFloatWindowView.d(this.a);
        goto L88
    L101:
        ALogger.i("VideoFloatWindowView", "current resolution is same to " + r24.getResolution());
    L69:
        r30 = null;
    L102:
        LivePlayerView r41 = this.a.getMLivePlayerView$livesdk_saasRelease();
        if (r41 == null) goto L105;
        r41.start(r24);
    L105:
        ALogger.i("VideoFloatWindowView", "start player");
        LivePlayerView r42 = this.a.getMLivePlayerView$livesdk_saasRelease();
        if (r42 == null) goto L124;
        ILivePlayerClient r43 = r42.getClient();
        if (r43 == null) goto L124;
        LifecycleOwner r44 = r43.getLifecycleOwner();
        if (r44 == null) goto L124;
        VideoFloatWindowView r45 = this.a;
        LivePlayerView r46 = r45.i;
        if (r46 == null) goto L124;
        ILivePlayerClient r47 = r46.getClient();
        if (r47 == null) goto L124;
        IRoomEventHub r48 = r47.getEventHub();
        r48.getFirstFrame().observe(r44, new z(r45));
        r48.getPlaying().observe(r44, new a0(r45, r47));
        r48.getSeiUpdate().observe(r44, new b0(r45));
        r48.getVideoSizeChanged().observe(r44, new c0(r45));
        r48.getPlayerMute().observe(r44, new d0(r45));
        r48.getPlayerMediaError().observe(r44, new e0(r45));
        r48.getPlayComplete().observe(r44, new f0(r45));
        if (r45.n() == false) goto L124;
        if (Intrinsics.areEqual((Boolean) r48.getFirstFrame().getValue(), Boolean.TRUE) == false) goto L124;
        r45.D.onPlayDisplayed();
        Pair r49 = (Pair) r48.getVideoSizeChanged().getValue();
        if (r49 == null) goto L124;
        r45.D.onVideoSizeChanged(((Number) r49.getFirst()).intValue(), ((Number) r49.getSecond()).intValue());
    L124:
        if (this.a.a(2131372953).isSelected() == false) goto L130;
        LivePlayerView r50 = this.a.getMLivePlayerView$livesdk_saasRelease();
        if (r50 == null) goto L130;
        ILivePlayerClient r51 = r50.getClient();
        if (r51 == null) goto L130;
        r51.mute("VideoFloatWindowView.float_mute");
    L130:
        RoomContext r52 = RoomContext.a.c(RoomContext.Companion, null, r15.getRoomId(), 1);
        if (r52 == null) goto L142;
        com.bytedance.live.datacontext.m r53 = r52.getFloatWindowStatus();
        if (r53 == null) goto L143;
        LiveFloatWindowStatus r54 = new LiveFloatWindowStatus();
        r54.setShow(true);
        LivePlayerView r55 = this.a.getMLivePlayerView$livesdk_saasRelease();
        if (r55 == null) goto L139;
        LivePlayerConfig r56 = r55.getConfig();
        if (r56 == null) goto L139;
        r2 = r56.getScene();
    L139:
        r54.setScene(r2);
        Unit r57 = Unit.INSTANCE;
        r53.setValue(r54);
        return;
    L143:
        return;
    L142:
        return;
    L44:
        ViewGroup.LayoutParams r58 = new ViewGroup.LayoutParams(-1, -1);
        LivePlayerView r59 = this.a.getMLivePlayerView$livesdk_saasRelease();
        if (r59 == null) goto L47;
        r59.setLayoutParams(r58);
        goto L47
    L29:
        r17 = null;
        goto L31
    L141:
        return;
    L12:
        r5 = null;
        goto L13
    L8:
        f.N0.getClass();
        r3 = f.a.a;
        goto L9
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
}
