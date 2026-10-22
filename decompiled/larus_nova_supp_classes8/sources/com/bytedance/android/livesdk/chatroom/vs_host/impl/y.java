package com.bytedance.android.livesdk.chatroom.vs_host.impl;

import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.tetris.widgets.RecyclableWidgetManager;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.model.PadOrientation;
import com.bytedance.android.livesdk.chatroom.model.z3;
import com.bytedance.android.livesdk.chatroom.utils.n3;
import com.bytedance.android.livesdk.chatroom.widget.i0;
import com.bytedance.android.livesdk.chatroom.widget.m0;
import com.bytedance.android.livesdk.chatroom.z0;
import com.bytedance.android.livesdk.landscape.ILandscapeSpiltManager;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.MultiCameraBasicInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.JsonObject;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class y implements com.bytedance.android.scope.o, vr1.u {
    public final DataCenter a;

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // vr1.u
    public final com.bytedance.live.datacontext.m<Boolean> A() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.a, 0, 2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getVsVerticalStream();
    }

    @Override // vr1.u
    public final com.bytedance.live.datacontext.m<MutableLiveData<Boolean>> B1() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.a, 0, 2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getNewBusinessMsgArrived();
    }

    @Override // vr1.u
    public final com.bytedance.live.datacontext.j<ViewModel> E() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.a, 0, 2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMultiCameraContext();
    }

    @Override // vr1.u
    public final com.bytedance.live.datacontext.j<i0> F() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getMultitabSizeGetter();
    }

    @Override // vr1.u
    public final z3 I() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.a, 0, 2);
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.n r1 = r0.getWidgetLoadedProperty();
        if (r1 == null) goto L7;
        return (z3) r1.getValue();
    L7:
        return null;
    }

    @Override // vr1.u
    public final boolean J() {
        if (RoomContext.a.c(RoomContext.Companion, this.a, 0, 2) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // vr1.u
    public final com.bytedance.live.datacontext.m<Integer> J0() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.a, 0, 2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getOpenPanelInRoom();
    }

    @Override // vr1.u
    public final com.bytedance.live.datacontext.n<xn1.a> K() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getLandscapeTabsManager();
    }

    @Override // vr1.u
    public final com.bytedance.live.datacontext.m<z0> K0() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.a, 0, 2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getSeiTimePair();
    }

    @Override // vr1.u
    public final com.bytedance.live.datacontext.n<JsonObject> L() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getCurrentMatchInfo();
    }

    @Override // vr1.u
    public final com.bytedance.android.livesdk.chatroom.msgboard.a L0() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.a, 0, 2);
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.j r1 = r0.getVsMsgBoardDataContext();
        if (r1 == null) goto L7;
        return (com.bytedance.android.livesdk.chatroom.msgboard.a) r1.getValue();
    L7:
        return null;
    }

    @Override // vr1.u
    public final com.bytedance.live.datacontext.j<m0> N() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.a, 0, 2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRoomUISizeGetter();
    }

    @Override // vr1.u
    public final ylc.e N0() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.a, 0, 2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return n3.g(r0);
    }

    @Override // vr1.u
    public final com.bytedance.live.datacontext.n<JsonObject> R() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getCurrentActiveTabId();
    }

    @Override // vr1.u
    public final com.bytedance.live.datacontext.i<Boolean> S() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.a, 0, 2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.isLiveEnd();
    }

    @Override // vr1.u
    public final com.bytedance.live.datacontext.m<Long> S0() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.a, 0, 2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCurrentMatchId();
    }

    @Override // vr1.u
    public final com.bytedance.live.datacontext.n<lh1.b> T0() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getTabHost();
    }

    @Override // vr1.u
    public final com.bytedance.live.datacontext.m<Integer> U() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.a, 0, 2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCleanMode();
    }

    @Override // vr1.u
    public final boolean X() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.a, 0, 2);
        if (r0 == null) goto L15;
        com.bytedance.live.datacontext.n r1 = r0.getLandscapeSpiltManager();
        if (r1 == null) goto L15;
        ILandscapeSpiltManager r2 = (ILandscapeSpiltManager) r1.getValue();
        if (r2 == null) goto L15;
        PropertyOwner r3 = r2.getState();
        if (r3 == null) goto L15;
        ILandscapeSpiltManager.State r4 = (ILandscapeSpiltManager.State) r3.a;
        if (r4 == null) goto L15;
        if (r4.willShow() != true) goto L15;
        return true;
    L15:
        return false;
    }

    @Override // vr1.u
    public final com.bytedance.live.datacontext.m<Boolean> X0() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.a, 0, 2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getStreamTransitionAnimating();
    }

    @Override // vr1.u
    public final com.bytedance.live.datacontext.m<String> Y() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.a, 0, 2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getSharePlatform();
    }

    @Override // vr1.u
    public final com.bytedance.live.datacontext.k<Boolean> Y0() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.a, 0, 2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMatchPlayerControlInitComplete();
    }

    @Override // vr1.u
    public final com.bytedance.live.datacontext.j<vlc.d> a() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.a, 0, 2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMessageManager();
    }

    @Override // vr1.u
    public final com.bytedance.live.datacontext.n<h80.d<GestureDetector.SimpleOnGestureListener>> b0() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getInteractionFragmentDoubleTap();
    }

    @Override // vr1.u
    public final ViewModel c() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.a, 0, 2);
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.j r1 = r0.getInteractiveComponentContext();
        if (r1 == null) goto L7;
        return (ViewModel) r1.getValue();
    L7:
        return null;
    }

    @Override // vr1.u
    public final com.bytedance.live.datacontext.m<Long> cameraId() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.a, 0, 2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCameraId();
    }

    @Override // vr1.u
    public final com.bytedance.live.datacontext.n<Rect> d() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.a, 0, 2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getSurfaceRenderViewRect();
    }

    @Override // vr1.u
    public final long d1() {
        DataCenter r0 = this.a;
        if (r0 != null) goto L5;
        return 0;
    L5:
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, r0, 0, 2);
        if (r1 != null) goto L8;
        return 0;
    L8:
        long r2 = System.currentTimeMillis();
        z0 r3 = (z0) r1.getSeiTimePair().getValue();
        return r3.a + (r2 - r3.b);
    }

    @Override // vr1.u
    public final boolean e0() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.a, 0, 2);
        if (r0 == null) goto L13;
        Room r1 = r0.getVsRoom();
        if (r1 == null) goto L13;
        EpisodeExtraInfo r2 = r1.getEpisodeComponentData();
        if (r2 == null) goto L13;
        MultiCameraBasicInfo r3 = r2.getMultiCameraBasicInfo();
        if (r3 == null) goto L13;
        if (r3.getSupportVSCore() != true) goto L13;
        return true;
    L13:
        return false;
    }

    @Override // vr1.u
    public final com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a0<pp1.c>> e1() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.a, 0, 2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getToolbarBubbleManager();
    }

    @Override // vr1.u
    public final com.bytedance.live.datacontext.m<Integer> f() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.a, 0, 2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getOrientationAfterChanged();
    }

    @Override // vr1.u
    public final com.bytedance.live.datacontext.j<cq1.a> f0() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.a, 0, 2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getBusinessConfigureData();
    }

    @Override // vr1.u
    public final com.bytedance.live.datacontext.n<?> g() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.a, 0, 2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getInteractionDataPrepared();
    }

    @Override // vr1.u
    public final com.bytedance.live.datacontext.j<?> h() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.a, 0, 2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getVsMsgBoardDataContext();
    }

    @Override // vr1.u
    public final com.bytedance.live.datacontext.m<Long> i() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.a, 0, 2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getContentId();
    }

    @Override // vr1.u
    public final com.bytedance.live.datacontext.m<Boolean> isCleanMode() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.a, 0, 2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.isCleanMode();
    }

    @Override // vr1.u
    public final boolean isPortraitInteraction() {
        RoomContext.a r0 = RoomContext.Companion;
        if (RoomContext.a.c(r0, this.a, 0, 2) != null) goto L5;
        return false;
    L5:
        RoomContext r1 = RoomContext.a.c(r0, this.a, 0, 2);
        if (r1 == null) goto L13;
        com.bytedance.live.datacontext.m r2 = r1.isPortraitInteraction();
        if (r2 == null) goto L14;
        Boolean r3 = (Boolean) r2.getValue();
        if (r3 != null) goto L12;
        return false;
    L12:
        return r3.booleanValue();
    L14:
        return false;
    L13:
        return false;
    }

    @Override // vr1.u
    public final Boolean isVSVerticalStream() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 != null) goto L5;
        return null;
    L5:
        return Boolean.valueOf(r0.isVSVerticalStream());
    }

    @Override // vr1.u
    public final com.bytedance.live.datacontext.m<Boolean> j() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.isBubbleInit();
    }

    @Override // vr1.u
    public final Room j0() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.a, 0, 2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getVsRoom();
    }

    @Override // vr1.u
    public final com.bytedance.live.datacontext.j<Unit> k() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.a, 0, 2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.isFirstFrameShown();
    }

    @Override // vr1.u
    public final IRoom k2() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.a, 0, 2);
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L7;
        return (Room) r1.getValue();
    L7:
        return null;
    }

    @Override // vr1.u
    public final com.bytedance.live.datacontext.n<h80.d<com.bytedance.android.live.core.tetris.layer.view.a>> n() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getLayerConfigGetter();
    }

    @Override // vr1.u
    public final User o() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L8;
        com.bytedance.live.datacontext.m r1 = r0.getUser();
        if (r1 != null) goto L7;
        return null;
    L7:
        return (User) r1.getValue();
    L8:
        return null;
    }

    @Override // vr1.u
    public final com.bytedance.live.datacontext.m<Boolean> o0() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.a, 0, 2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCameraMessageShared();
    }

    @Override // vr1.u
    public final com.bytedance.live.datacontext.n<JsonObject> p0() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getLastMatchInfo();
    }

    @Override // vr1.u
    public final com.bytedance.live.datacontext.j<Long> q() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.a, 0, 2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getFirstFrameTime();
    }

    @Override // vr1.u
    public final com.bytedance.live.datacontext.n<h80.d<Pair<Fragment, FragmentManager>>> s() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.a, 0, 2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getFragmentInfoGetter();
    }

    @Override // vr1.u
    public final com.bytedance.live.datacontext.n<PadOrientation> w() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.a, 0, 2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPadOrientation();
    }

    @Override // vr1.u
    public final com.bytedance.live.datacontext.n<RecyclableWidgetManager> w0() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getWidgetManager();
    }

    @Override // vr1.u
    public final com.bytedance.live.datacontext.n<h80.d<Function1<MotionEvent, Unit>>> x() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getInteractionFragmentSwipeListener();
    }

    @Override // vr1.u
    public final com.bytedance.live.datacontext.m<Boolean> x0() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.a, 0, 2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getVsLiveRecording();
    }

    @Override // vr1.u
    public final com.bytedance.live.datacontext.m<Boolean> x1() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.a, 0, 2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.isLandscapeLock();
    }

    @Override // vr1.u
    public final com.bytedance.live.datacontext.m<Boolean> y() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getVsVoteActivityToolbarShow();
    }

    @Override // vr1.u
    public final float y0() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.a, 0, 2);
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.getVsVerticalProgressBarHeight();
    }

    @Override // vr1.u
    public final com.bytedance.live.datacontext.n<Long> y7() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.a, 0, 2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCurTabId();
    }

    @Override // vr1.u
    public final com.bytedance.live.datacontext.m<Boolean> z1() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.a, 0, 2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMatchRoomMultiCameraPanelShowing();
    }

    public y(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.a = r2;
    }
}
