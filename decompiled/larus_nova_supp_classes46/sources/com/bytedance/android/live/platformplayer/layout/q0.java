package com.bytedance.android.live.platformplayer.layout;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.setting.m5;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.feature.api.FeatureType;
import com.bytedance.android.live.feature.api.IFeatureService;
import com.bytedance.android.live.matchroom.MatchRoomLandScapeAnimUtil;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.ui.CameraTransitionViewHolder;
import com.bytedance.android.livesdk.chatroom.ui.p5;
import com.bytedance.android.livesdk.chatroom.ui.q5;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.config.cu;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class q0<T> implements Observer {
    public final /* synthetic */ LivePlayerWidget a;

    public q0(LivePlayerWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r9) {
        Boolean r0 = Boolean.TRUE;
        if (Intrinsics.areEqual((Boolean) r9, r0) == true) goto L5;
        return;
    L5:
        if (((Boolean) cu.a.getValue()).booleanValue() == false) goto L7;
        LivePlayerWidget r10 = this.a;
        int r1 = LivePlayerWidget.V2;
        r10.Iq();
        this.a.Er("receive first frame callbck " + this.a.hashCode());
    L7:
        boolean r11 = MatchRoomLandScapeAnimUtil.a;
        MatchRoomLandScapeAnimUtil.o();
        VrUtils.e.getClass();
        if (VrUtils.d == (-1)) goto L26;
        IRoomContextService r12 = jc1.k.f(IRoomContextService.class);
        if (r12 == null) goto L16;
        com.bytedance.android.livesdk.chatroom.o r13 = IRoomContextService.a.a(r12, null, 0, 3);
        if (r13 == null) goto L16;
        com.bytedance.live.datacontext.m r14 = r13.getRoom();
        if (r14 == null) goto L16;
        IRoom r15 = (IRoom) r14.getValue();
    L18:
        if (VrUtils.A(r15, null) == true) goto L26;
        LivePlayerWidget r16 = this.a;
        int r7 = LivePlayerWidget.V2;
        if (r16.mr(true) < 1) goto L22;
        int r17 = 2;
    L23:
        ILivePlayerClient r8 = this.a.dr();
        if (r8 == null) goto L26;
        r8.setGyroStatusInitial(r17);
        goto L26
    L22:
        r17 = VrUtils.d;
    L16:
        r15 = null;
    L26:
        LivePlayerWidget r18 = this.a;
        int r19 = LivePlayerWidget.V2;
        r18.getClass();
        IRoomContextService r20 = jc1.k.f(IRoomContextService.class);
        if (r20 == null) goto L40;
        com.bytedance.android.livesdk.chatroom.o r21 = IRoomContextService.a.a(r20, null, 0, 3);
        if (r21 == null) goto L40;
        com.bytedance.live.datacontext.m r22 = r21.c2();
        if (r22 == null) goto L40;
        if (((Boolean) r22.getValue()).booleanValue() != true) goto L40;
        CameraTransitionViewHolder r23 = this.a.I;
        if (r23 == null) goto L41;
        View r2 = r23.a;
        if (r2 == null) goto L41;
        r2.animate().cancel();
        UtilityKotlinExtentionsKt.w(r2);
        r2.setAlpha(1.0f);
        r2.animate().alpha(0.0f).setDuration(150).withEndAction(new p5(r23, r2)).withStartAction(new q5(r23)).start();
    L41:
        LivePlayerWidget r24 = this.a;
        Pair<Integer, Integer> r3 = r24.lr();
        int r4 = ((Number) r3.component1()).intValue();
        int r5 = ((Number) r3.component2()).intValue();
        if (r4 == 0) goto L54;
        if (r5 == 0) goto L54;
        if (com.bytedance.android.livesdk.utils.landscape.b.a() == false) goto L54;
        ds0.d r6 = r24.U2;
        if (r4 <= r5) goto L50;
        boolean r25 = true;
    L51:
        r6.setVideoHorizontal(r25);
        if (r24.xr() == false) goto L54;
        r24.ks();
        goto L54
    L50:
        r25 = false;
    L54:
        ViewGroup r26 = ((Widget) this.a).containerView;
        if (r26 == null) goto L59;
        FrameLayout r27 = (FrameLayout) r26.findViewById(2131381829);
        if (r27 == null) goto L59;
        UtilityKotlinExtentionsKt.w(r27);
    L59:
        this.a.getClass();
        IFeatureService r28 = jc1.k.f(IFeatureService.class);
        if (r28 == null) goto L64;
        z90.a r29 = r28.getFeatureManager();
        if (r29 == null) goto L64;
        r29.i("cae_category", -1, FeatureType.MONITOR);
    L64:
        LivePlayerWidget r30 = this.a;
        if (r30.N2 == true) goto L69;
        r30.N2 = true;
        if (Intrinsics.areEqual(m5.a.getValue(), r0) == false) goto L69;
        y50.g.b("firstFrame");
    L69:
        this.a.mr(true);
        return;
    L40:
        this.a.hs();
        goto L41
    }
}
