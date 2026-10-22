package com.bytedance.android.livesdk.chatroom.ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.matchroom.MatchRoomLandScapeAnimUtil;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.resolution.AudienceVideoResolutionManager;
import com.bytedance.android.livesdk.chatroom.room.RoomSession;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.VSPlayerViewControlContext;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdkapi.depend.model.live.IQuality;
import com.bytedance.android.livesdkapi.depend.model.live.LiveCoreSDKData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/LivePaidPlayerContainerWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "Lpu2/j;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePaidPlayerContainerWidget extends LiveWidget implements pu2.j, Observer<KVData> {
    public final String a;
    public AbsLivePlayerView b;
    public ViewGroup c;
    public h80.d<gs0.c> d;
    public final LinkedHashMap<PaidSceneEnum, com.bytedance.android.livesdk.vscore_api.paidlive.ability.l> e;
    public com.bytedance.android.livesdk.vscore_api.paidlive.ability.l f;
    public PaidSceneEnum g;
    public final RoomSession h;

    public static final class a {
    }

    static {
    }

    public final void ri() {
        h80.d<gs0.c> r0 = this.d;
        if (r0 == null) goto L8;
        gs0.c r1 = (gs0.c) r0.get();
        if (r1 == null) goto L9;
        r1.Jy();
        return;
    L9:
        return;
    }

    public final com.bytedance.android.livesdk.vscore_api.paidlive.c xq() {
        return com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.a(this.h.getRoomId(), null);
    }

    public final void zq() {
        ViewGroup.LayoutParams r2 = null;
        VideoViewParams r0 = (VideoViewParams) ((Widget) this).dataCenter.get("live_render_view_params", null);
        if (r0 == null) goto L26;
        AbsLivePlayerView r1 = this.b;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("playerView");
    L7:
        if (r1 == null) goto L13;
        IRenderView r3 = r1.getRenderView();
        if (r3 == null) goto L13;
        View r4 = r3.getSelfView();
        if (r4 == null) goto L13;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
    L15:
        if ((r5 instanceof FrameLayout.LayoutParams) == false) goto L18;
        r2 = r5;
    L18:
        FrameLayout.LayoutParams r6 = (FrameLayout.LayoutParams) r2;
        if (r6 == null) goto L21;
        int r7 = r6.topMargin;
    L22:
        if (r7 >= 0) goto L24;
        r7 = 0;
    L24:
        wq(r0.a, r0.b, r7);
        return;
    L21:
        r7 = r0.c;
    L13:
        r5 = null;
        goto L15
    }

    public final void Aq() {
        if (xq().w0().isInRoom() == false) goto L6;
        xq().J1(pu2.j.class, this);
        yq("registerAbility register instance:" + this + ", paidManageService:" + xq());
    L11:
        ((Widget) this).dataCenter.observe("live_render_view_params", this);
        return;
    L6:
        if (xq().w0().isPreview() == false) goto L9;
        ALogger.e(this.a, "wtf!!! onStart register in preview,skip register");
        goto L11
    L9:
        if (xq().isDefault() == false) goto L11;
        ALogger.e(this.a, "onStart register in default service ,skip register");
        goto L11
    }

    public final void onDestroy() {
        super.onDestroy();
        if (xq().w0().isInRoom() == false) goto L6;
        xq().J1(pu2.j.class, null);
        yq("onDestroy register null, paidManageService:" + xq());
    L11:
        this.f = null;
        this.g = null;
        return;
    L6:
        if (xq().w0().isPreview() == false) goto L9;
        ALogger.e(this.a, "wtf!!! onDestroy register in preview,skip register null");
        goto L11
    L9:
        if (xq().isDefault() == false) goto L11;
        ALogger.e(this.a, "onDestroy register in default service ,skip register null");
        goto L11
    }

    public final void onStart() {
        super.onStart();
        yq("onStart");
        Aq();
    }

    public LivePaidPlayerContainerWidget(RoomSession r2) {
        Intrinsics.checkNotNullParameter(r2, "session");
        this.h = r2;
        this.a = "LivePaidPlayerContainerWidget[" + hashCode() + ']';
        this.e = new LinkedHashMap();
    }

    public final boolean ed(PaidSceneEnum r3) {
        Intrinsics.checkNotNullParameter(r3, "paidScene");
        if (r3 != PaidSceneEnum.ALL) goto L5;
    L7:
        com.bytedance.android.livesdk.vscore_api.paidlive.ability.l r4 = this.f;
        if (r4 == null) goto L24;
        if (r4 == null) goto L13;
        View r5 = r4.getView();
        if (r5 == null) goto L13;
        ViewParent r6 = r5.getParent();
    L15:
        if (Intrinsics.areEqual(r6, this.c) == false) goto L25;
        com.bytedance.android.livesdk.vscore_api.paidlive.ability.l r7 = this.f;
        if (r7 == null) goto L26;
        View r8 = r7.getView();
        if (r8 != null) goto L21;
        return false;
    L21:
        if (r8.getVisibility() != 0) goto L28;
        return true;
    L28:
        return false;
    L26:
        return false;
    L25:
        return false;
    L13:
        r6 = null;
        goto L15
    L24:
        return false;
    L5:
        if (this.g == r3) goto L7;
        return false;
    }

    public final IQuality h9(String r4) {
        Intrinsics.checkNotNullParameter(r4, "sdkKey");
        Iterator r0 = AudienceVideoResolutionManager.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((LiveCoreSDKData.Quality) r1).sdkKey, r4) == false) goto L4;
    L10:
        return (IQuality) r1;
    L8:
        r1 = null;
        goto L10
    }

    public final void onChanged(Object r5) {
        KVData r6 = (KVData) r5;
        ViewGroup.LayoutParams r0 = null;
        if (r6 == null) goto L5;
        String r1 = r6.getKey();
    L6:
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.hashCode() == (-1882223254)) goto L12;
        return;
    L12:
        if (r1.equals("live_render_view_params") == false) goto L37;
        VideoViewParams r7 = (VideoViewParams) r6.getData();
        if (r7 == null) goto L38;
        AbsLivePlayerView r2 = this.b;
        if (r2 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("playerView");
    L18:
        if (r2 == null) goto L24;
        IRenderView r3 = r2.getRenderView();
        if (r3 == null) goto L24;
        View r4 = r3.getSelfView();
        if (r4 == null) goto L24;
        ViewGroup.LayoutParams r8 = r4.getLayoutParams();
    L26:
        if ((r8 instanceof FrameLayout.LayoutParams) == false) goto L29;
        r0 = r8;
    L29:
        FrameLayout.LayoutParams r9 = (FrameLayout.LayoutParams) r0;
        if (r9 == null) goto L32;
        int r10 = r9.topMargin;
    L33:
        if (r10 >= 0) goto L35;
        r10 = 0;
    L35:
        wq(r7.a, r7.b, r10);
        return;
    L32:
        r10 = r7.c;
    L24:
        r8 = null;
        goto L26
    L38:
        return;
    L37:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void re(PaidSceneEnum r5) {
        Intrinsics.checkNotNullParameter(r5, "paidScene");
        com.bytedance.android.livesdk.vscore_api.paidlive.ability.l r0 = this.e.get(r5);
        if (r0 == null) goto L18;
        ViewParent r1 = r0.getView().getParent();
        if ((r1 instanceof ViewGroup) == true) goto L7;
        r1 = null;
    L7:
        ViewGroup r2 = (ViewGroup) r1;
        if (r2 == null) goto L11;
        r2.removeView(r0.getView());
        r0.dc();
        yq("remove paid floating layer [" + r5 + ']');
    L11:
        if (Intrinsics.areEqual(this.f, r0) == false) goto L16;
        this.f = null;
        if (this.g != r5) goto L15;
        this.g = null;
    L15:
        yq("set currentLayerEndView null");
    L16:
        this.e.remove(r5);
        return;
    }

    public final void yq(String r2) {
        ALogger.i(this.a, r2);
    }

    public final String sk(boolean r8, String r9) {
        Intrinsics.checkNotNullParameter(r9, "targetResolutionName");
        DataCenter r0 = this.h.getDataCenter();
        IQuality r1 = null;
        Object r2 = null;
        r1 = null;
        r1 = null;
        r1 = null;
        if (r0 == null) goto L11;
        RoomContext r3 = RoomContext.a.c(RoomContext.Companion, this.h.getDataCenter(), 0, 2);
        if (r3 == null) goto L9;
        com.bytedance.live.datacontext.m r4 = r3.getCameraId();
        if (r4 == null) goto L9;
        Long r5 = (Long) r4.getValue();
    L10:
        Room r6 = com.bytedance.android.live.core.utils.z.a(r0, null, r5);
    L12:
        LiveCoreSDKData.Quality r7 = AudienceVideoResolutionManager.e();
        if (r7 == null) goto L15;
        String r10 = r7.getName();
    L17:
        if ((!Intrinsics.areEqual(r10, r9)) == false) goto L55;
        if (r6 != null) goto L20;
    L25:
        String r11 = null;
    L26:
        if (r6 != null) goto L28;
    L33:
        String r12 = null;
    L34:
        if (r6 != null) goto L36;
    L51:
        cs0.c r13 = new cs0.c(r9, r11, r12, r1);
        if (r8 == false) goto L54;
        r13.h = false;
        ((Widget) this).dataCenter.put("data_switch_resolution_toast_vs", Boolean.FALSE);
    L54:
        xs2.b.a().post(r13);
        goto L55
    L36:
        if (r6.isMultiPullDataValid() == true) goto L39;
        r6 = null;
    L39:
        if (r6 == null) goto L51;
        StreamUrl r14 = r6.getStreamUrl();
        if (r14 == null) goto L51;
        List r15 = r14.getQualityList();
        if (r15 == null) goto L51;
        Iterator r16 = r15.iterator();
    L46:
        if (r16.hasNext() == false) goto L50;
        Object r17 = r16.next();
        if (Intrinsics.areEqual(((IQuality) r17).getName(), r9) == false) goto L46;
        r2 = r17;
    L50:
        r1 = (IQuality) r2;
        goto L51
    L28:
        if (r6.isMultiPullDataValid() == true) goto L30;
        Room r18 = r6;
    L31:
        if (r18 == null) goto L33;
        r12 = r18.getSdkParams(r9);
        goto L34
    L30:
        r18 = null;
        goto L31
    L20:
        if (r6.isMultiPullDataValid() == true) goto L22;
        Room r19 = r6;
    L23:
        if (r19 == null) goto L25;
        r11 = r19.buildPullUrl(r9);
        goto L26
    L22:
        r19 = null;
    L55:
        return r10;
    L15:
        r10 = null;
    L9:
        r5 = null;
        goto L10
    L11:
        r6 = null;
        goto L12
    }

    public final void wq(int r3, int r4, int r5) {
        yq("adjustLayoutParams width : " + r3 + " , height : " + r4 + " , topMargin : " + r5);
        com.bytedance.android.livesdk.vscore_api.paidlive.ability.l r0 = this.f;
        if (r0 == null) goto L6;
        r0.n1(r3, r4, r5);
        return;
    }

    public final void z8(PaidSceneEnum r10, com.bytedance.android.livesdk.vscore_api.paidlive.ability.l r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "paidScene");
        Context r0 = ((Widget) this).context;
        IRenderView r2 = null;
        if ((r0 instanceof Activity) == true) goto L5;
        r0 = null;
    L5:
        Activity r1 = (Activity) r0;
        if (r1 == null) goto L14;
        if (r1.isFinishing() == false) goto L11;
        return;
    L11:
        if (r1.isDestroyed() == false) goto L14;
        return;
    L14:
        if (this.c != null) goto L17;
        yq("addPaidFloatingLayer failed! playerContainer is null!");
        return;
    L17:
        if (r11 == null) goto L19;
        View r4 = r11.getView();
    L20:
        if (r4 != null) goto L23;
        yq("addPaidFloatingLayer failed! androidView is null!");
        return;
    L23:
        VideoViewParams r3 = (VideoViewParams) ((Widget) this).dataCenter.get("live_render_view_params", null);
        AbsLivePlayerView r5 = this.b;
        if (r5 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("playerView");
    L26:
        if (r5 == null) goto L32;
        IRenderView r6 = r5.getRenderView();
        if (r6 == null) goto L32;
        View r7 = r6.getSelfView();
        if (r7 == null) goto L32;
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
    L34:
        if ((r8 instanceof FrameLayout.LayoutParams) == true) goto L36;
        r8 = null;
    L36:
        FrameLayout.LayoutParams r9 = (FrameLayout.LayoutParams) r8;
        if (r9 == null) goto L39;
        int r13 = r9.topMargin;
    L40:
        int r14 = 0;
        if (r13 >= 0) goto L44;
        r13 = 0;
    L44:
        if (r4.getParent() != null) goto L46;
    L93:
        ViewParent r15 = r4.getParent();     // Catch: Exception -> L64
        if ((r15 instanceof ViewGroup) == true) goto L60;
        r15 = null;
    L60:
        ViewGroup r16 = (ViewGroup) r15;     // Catch: Exception -> L64
        if (r16 == null) goto L65;
        r16.removeView(r4);     // Catch: Exception -> L64
    L65:
        yq("start paid floating layer");
        ViewGroup r17 = this.c;
        if (r17 == null) goto L68;
        r17.addView(r4);
    L68:
        if (r3 == null) goto L70;
        int r18 = r3.a;
    L71:
        if (r3 == null) goto L73;
        r14 = r3.b;
    L73:
        r11.n1(r18, r14, r13);
        this.e.put(r10, r11);
        IVSPlayerService r19 = (IVSPlayerService) jc1.k.f(IVSPlayerService.class);
        if (r19 == null) goto L86;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r20 = r19.provideVSPlayerViewControlService(((Widget) this).dataCenter);
        if (r20 == null) goto L86;
        VSPlayerViewControlContext r21 = r20.provideContext();
        if (r21 == null) goto L86;
        com.bytedance.live.datacontext.m<Boolean> r22 = r21.getPlayerViewIsInZoom();
        if (r22 == null) goto L86;
        if (((Boolean) r22.getValue()).booleanValue() != true) goto L86;
        nm1.p r23 = (nm1.p) pm1.h.d.c(nm1.p.class);
        if (r23 == null) goto L86;
        r23.c();
    L86:
        AbsLivePlayerView r24 = this.b;
        if (r24 != null) goto L89;
        Intrinsics.throwUninitializedPropertyAccessException("playerView");
    L89:
        if (r24 == null) goto L91;
        r2 = r24.getRenderView();
    L91:
        r11.Kb(r2, r12);
        this.f = r11;
        this.g = r10;
        MatchRoomLandScapeAnimUtil.c("PaidLivePlayerFloatLayerView", r4, false, true, false, 16);
        return;
    L70:
        r18 = 0;
    L64:
        yq("addPaidFloatingLayer: remove view error");
        goto L65
    L46:
        if ((!Intrinsics.areEqual(r4.getParent(), this.c)) == true) goto L93;
        if (Intrinsics.areEqual(r4.getParent(), this.c) == false) goto L86;
        yq("addPaidFloatingLayer: already add, refresh param");
        if (r3 == null) goto L53;
        int r25 = r3.a;
    L54:
        if (r3 == null) goto L56;
        r14 = r3.b;
    L56:
        r11.n1(r25, r14, r13);
        goto L86
    L53:
        r25 = 0;
        goto L54
    L39:
        r13 = r3.c;
    L32:
        r8 = null;
        goto L34
    L19:
        r4 = null;
        goto L20
    }
}
