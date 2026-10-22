package com.bytedance.android.live.room.navi.tetris;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.core.tetris.layer.core.tetris.LiveTetris;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.room.IMiddlewareMicRoomService;
import com.bytedance.android.live.room.api.INavigationService;
import com.bytedance.android.live.room.api.userinfo.INavigationProxyService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.r;
import com.bytedance.android.livesdk.chatroom.ui.d9;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.common.MarqueeTextView;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.BaseEpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeBasic;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/room/navi/tetris/LandscapeRoomNavigatorTetris;", "Lcom/bytedance/android/live/core/tetris/layer/core/tetris/LiveTetris;", "Ld90/d;", "Lo70/a;", "Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/a;", "Lo70/b;", "event", "", "onEvent", "<init>", "()V", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeRoomNavigatorTetris extends LiveTetris<d90.d> implements o70.a, com.bytedance.android.livesdk.chatroom.vsplayer.model.a {
    public ViewGroup o;
    public ViewGroup p;
    public TextView q;
    public TextView r;
    public MarqueeTextView s;
    public Disposable t;
    public final LandscapeRoomNavigatorTetris$timerListener$1 u;

    public final List<Class<? extends o70.b>> Mg() {
        return CollectionsKt.listOf(bh1.a.class);
    }

    public LandscapeRoomNavigatorTetris() {
        this.u = new LandscapeRoomNavigatorTetris$timerListener$1(this);
    }

    public final void O() {
        IRoom r0 = d90.e.j(K());
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isMergeVSRoom() == false) goto L7;
    L34:
        TextView r1 = this.r;
        Disposable r2 = null;
        if (r1 == null) goto L61;
        INavigationProxyService r4 = (INavigationProxyService) jc1.k.f(INavigationProxyService.class);
        if (r4 == null) goto L41;
        l81.c r5 = r4.getDataCenterExtProxy();
        if (r5 == null) goto L41;
        EpisodeBasic r6 = r5.a(K().h);
    L42:
        if (r6 == null) goto L48;
        EpisodeMod r7 = r6.getMod();
        if (r7 == null) goto L48;
        if (((BaseEpisodeMod) r7).episodeStage != EpisodeMod.EpisodeStageType.PREMIERE) goto L48;
        String r8 = "首播";
    L49:
        if (r6 == null) goto L51;
        String r9 = r6.getCurrentPeriod();
    L53:
        if (TextUtils.isEmpty(r9) == false) goto L55;
        String r10 = r8.concat("  |  ");
    L60:
        r1.setText(r10);
        goto L61
    L55:
        StringBuilder r12 = new StringBuilder();
        r12.append(r8);
        r12.append("  |  ");
        if (r6 == null) goto L58;
        String r13 = r6.getCurrentPeriod();
    L59:
        r12.append(r13);
        r12.append("  ");
        r10 = r12.toString();
        goto L60
    L58:
        r13 = null;
        goto L59
    L51:
        r9 = null;
    L48:
        r8 = "直播";
    L41:
        r6 = null;
    L61:
        ViewGroup r3 = this.p;
        if (r3 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("mLlTitle");
    L64:
        if (r3 == null) goto L66;
        UtilityKotlinExtentionsKt.w(r3);
    L66:
        ViewGroup r14 = this.o;
        if (r14 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("mUserInfoLayout");
    L69:
        if (r14 == null) goto L72;
        UtilityKotlinExtentionsKt.t(r14);
    L72:
        if (wt2.e.a() == false) goto L116;
        TextView r15 = this.q;
        if (r15 == null) goto L76;
        r15.setVisibility(8);
    L76:
        MarqueeTextView r16 = this.s;
        boolean r17 = false;
        if (r16 == null) goto L79;
        r16.setVisibility(0);
    L79:
        MarqueeTextView r18 = this.s;
        if (r18 == null) goto L82;
        r18.setTextSize(1, 19.0f);
    L82:
        MarqueeTextView r19 = this.s;
        if (r19 == null) goto L85;
        r19.setIncludeFontPadding(true);
    L85:
        MarqueeTextView r20 = this.s;
        if (r20 == null) goto L88;
        r20.setSpeed(UtilityKotlinExtentionsKt.i(38));
    L88:
        MarqueeTextView r22 = this.s;
        if (r22 == null) goto L91;
        r22.post(new m(this));
    L91:
        r r23 = z51.a.e(K().h);
        if (r23 == null) goto L98;
        com.bytedance.live.datacontext.m r24 = r23.J();
        if (r24 == null) goto L98;
        Boolean r25 = (Boolean) r24.getValue();
        if (r25 == null) goto L98;
        r17 = r25.booleanValue();
    L98:
        if (r17 == false) goto L102;
        MarqueeTextView r26 = this.s;
        if (r26 == null) goto L105;
        r26.setTextWithEllipsis(V());
    L105:
        r r27 = z51.a.e(K().h);
        if (r27 == null) goto L108;
        com.bytedance.live.datacontext.j r28 = r27.n();
    L109:
        if (r28 != null) goto L111;
    L112:
        if (r28 == null) goto L114;
        final long r29 = 111;
        final long r30 = 1000;
        r28.e(new LandscapeRoomNavigatorTetris$startAnimationListener$1(r29, r30));
    L114:
        if (r28 == null) goto L119;
        r28.c(new LandscapeRoomNavigatorTetris$startAnimationListener$2(this));
    L119:
        o r32 = z51.a.h(K().h, 2);
        if (r32 == null) goto L126;
        com.bytedance.live.datacontext.m r33 = r32.q2();
        if (r33 == null) goto L126;
        Observable r34 = r33.a();
        if (r34 == null) goto L126;
        r2 = r34.subscribe(new n(this));
    L126:
        this.t = r2;
        return;
    L111:
        if (r28.hasValue() == true) goto L114;
    L108:
        r28 = null;
        goto L109
    L102:
        MarqueeTextView r35 = this.s;
        if (r35 == null) goto L105;
        r35.setTextWithFading(V());
        goto L105
    L116:
        TextView r36 = this.q;
        if (r36 == null) goto L119;
        r36.setText(V());
        goto L119
    L7:
        if (r0.isVsRoom() == true) goto L34;
        ViewGroup r37 = this.p;
        if (r37 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mLlTitle");
    L12:
        if (r37 == null) goto L14;
        UtilityKotlinExtentionsKt.t(r37);
    L14:
        ViewGroup r38 = this.o;
        if (r38 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mUserInfoLayout");
    L17:
        if (r38 == null) goto L19;
        UtilityKotlinExtentionsKt.w(r38);
    L19:
        IMiddlewareMicRoomService r39 = (IMiddlewareMicRoomService) jc1.k.f(IMiddlewareMicRoomService.class);
        ViewGroup r40 = this.o;
        if (r40 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mUserInfoLayout");
    L22:
        if (r40 == null) goto L129;
        if (r39 != null) goto L25;
    L33:
        LiveTetris.Q(this, ((INavigationService) jc1.k.n(INavigationService.class)).getUserInfoWidget(K().h), r40, false, null, 24);
        return;
    L25:
        if (r39.isMicRoom(r0) == false) goto L33;
        INavigationProxyService r42 = (INavigationProxyService) jc1.k.f(INavigationProxyService.class);
        if (r42 == null) goto L130;
        l81.o r43 = r42.getMicRoomService();
        if (r43 == null) goto L131;
        Class<? extends LiveRecyclableWidget> r44 = r43.getMicRoomOfficialInfoWidget();
        if (r44 == null) goto L132;
        LiveTetris.Q(this, r44, r40, false, null, 24);
        return;
    L132:
        return;
    L131:
        return;
    L130:
        return;
    }

    public final String V() {
        DataCenter r0 = K().h;
        String r1 = null;
        if (r0 == null) goto L5;
        IRoom r2 = a0.n(r0);
    L6:
        nm1.m r3 = pm1.f.l();
        if (r3 == null) goto L23;
        VSCameraInfo r4 = r3.K(K().h);
        if (r4 == null) goto L23;
        if (r4.cameraType != VSCameraType.CAMERA_TYPE_MATCH.getValue()) goto L23;
        nm1.m r5 = pm1.f.l();
        if (r5 == null) goto L18;
        VSCameraInfo r6 = r5.K(K().h);
        if (r6 == null) goto L18;
        String r7 = r6.title;
        if (r7 == null) goto L18;
        return r7;
    L18:
        if (r2 == null) goto L30;
        IEpisodeExtraInfo r8 = r2.getEpisodeExtra();
        if (r8 == null) goto L30;
        r1 = r8.getTitle();
    L30:
        return String.valueOf(r1);
    L23:
        if (r2 == null) goto L28;
        IEpisodeExtraInfo r9 = r2.getEpisodeExtra();
        if (r9 == null) goto L28;
        r1 = r9.getTitle();
    L28:
        return String.valueOf(r1);
    L5:
        r2 = null;
        goto L6
    }

    public final void onDestroy() {
        super/*com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris*/.onDestroy();
        MarqueeTextView r0 = this.s;
        if (r0 == null) goto L5;
        r0.cancelAnimation();
    L5:
        r r1 = z51.a.e(K().h);
        if (r1 == null) goto L12;
        com.bytedance.live.datacontext.j r2 = r1.n();
        if (r2 == null) goto L12;
        d9 r3 = (d9) r2.getValue();
        if (r3 == null) goto L12;
        r3.c(this.u);
    L12:
        Disposable r4 = this.t;
        if (r4 == null) goto L16;
        r4.dispose();
        return;
    }

    public final View G(t70.k r12) {
        Intrinsics.checkNotNullParameter(r12, "inflater");
        View r13 = r12.b(2131566553);
        this.o = (ViewGroup) r13.findViewById(2131392032);
        this.p = (ViewGroup) r13.findViewById(2131378908);
        this.q = (TextView) r13.findViewById(2131391606);
        this.r = (TextView) r13.findViewById(2131390479);
        this.s = r13.findViewById(2131379652);
        if (d90.e.i(K()) == false) goto L11;
        IVSPlayerService r0 = jc1.k.f(IVSPlayerService.class);
        if (r0 == null) goto L7;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r1 = r0.provideVSPlayerViewControlService(K().h);
    L8:
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r2 = r1;
        if (r2 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c.a.a(r2, PlayerViewControl.KEY.LandscapeRoomTitle, PlayerViewControl.Type.TOP, PlayerViewControl.Style.HIDE, r13, 0.0f, true, false, this, 272);
        goto L11
    L7:
        r1 = null;
    L11:
        return r13;
    }

    public final boolean canControlByPlayer(PlayerViewControl.KEY r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return d90.e.i(K());
    }

    public void onEvent(o70.b r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        if ((r3 instanceof bh1.a) == false) goto L19;
        boolean r4 = ((bh1.a) r3).a;
        r r0 = z51.a.e(K().h);
        if (r0 != null) goto L7;
    L10:
        if (r4 == false) goto L12;
    L11:
        int r5 = 0;
    L13:
        ViewGroup r1 = this.o;
        if (r1 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mUserInfoLayout");
    L16:
        if (r1 == null) goto L20;
        r1.setVisibility(r5);
        return;
    L20:
        return;
    L12:
        r5 = 4;
        goto L13
    L7:
        if (r0.isInVrLandscape(K().h) != true) goto L10;
        if (r4 == false) goto L11;
    }
}
