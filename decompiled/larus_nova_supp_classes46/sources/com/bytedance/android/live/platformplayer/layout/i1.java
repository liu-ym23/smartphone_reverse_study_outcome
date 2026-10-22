package com.bytedance.android.live.platformplayer.layout;

import android.text.TextUtils;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.ui.InteractPlayViewManager;
import com.bytedance.android.livesdk.player.vr.VrBgImageEventController;
import com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i1<T> implements Observer {
    public final /* synthetic */ LivePlayerWidget a;

    public i1(LivePlayerWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r8) {
        Boolean r9 = (Boolean) r8;
        Boolean r0 = Boolean.TRUE;
        if ((!Intrinsics.areEqual(r9, r0)) == true) goto L62;
        LivePlayerWidget r1 = this.a;
        int r3 = LivePlayerWidget.V2;
        if (r1.dr() == null) goto L64;
        AbsLivePlayerView r2 = this.a.R8();
        if ((r2 instanceof LivePlayerView) == true) goto L10;
        r2 = null;
    L10:
        LivePlayerView r4 = (LivePlayerView) r2;
        if (r4 == null) goto L18;
        InteractPlayViewManager r5 = this.a.t;
        if (r5 == null) goto L18;
        Intrinsics.checkNotNullParameter(r4, "livePlayerView");
        if (r5.m() == true) goto L18;
        r5.i = r4;
        r5.h();
    L18:
        LivePlayerWidget r6 = this.a;
        ILivePlayerClient r7 = r6.dr();
        Intrinsics.checkNotNull(r7);
        LivePlayerWidget.xq(r6, r7.getLifecycleOwner());
        if (Intrinsics.areEqual(r9, r0) == false) goto L38;
        ILivePlayerClient r10 = this.a.dr();
        if (r10 == null) goto L23;
        IRoomEventHub r11 = r10.getEventHub();
    L25:
        if ((r11 instanceof IRoomEventHub) == true) goto L27;
        r11 = null;
    L27:
        if (r11 == null) goto L38;
        if (this.a.Zq() == false) goto L31;
        LivePlayerWidget r12 = this.a;
    L35:
        if (r12 == null) goto L38;
        this.a.Er("Start pulling stream, ready to observe a new VrBgImageEventController for vrBgLogUpdateOrSend");
        r11.getVrBgLogUpdateOrSend().observe(r12, new VrBgImageEventController());
        goto L38
    L31:
        ILivePlayerClient r13 = this.a.dr();
        if (r13 == null) goto L34;
        r12 = r13.getLifecycleOwner();
        goto L35
    L34:
        r12 = null;
        goto L35
    L23:
        r11 = null;
    L38:
        if (TextUtils.isEmpty(this.a.U2.getEnterRoomInfo().getLinkerMap()) == true) goto L40;
        this.a.Fq();
    L40:
        this.a.R8().setVisibility(0);
        ILivePlayerClient r14 = this.a.dr();
        Intrinsics.checkNotNull(r14);
        if ((!Intrinsics.areEqual((Boolean) r14.getEventHub().getPlaying().getValue(), r0)) == false) goto L55;
        IRoomContextService r15 = jc1.k.f(IRoomContextService.class);
        if (r15 == null) goto L50;
        com.bytedance.android.livesdk.chatroom.o r16 = IRoomContextService.a.a(r15, null, 0, 3);
        if (r16 == null) goto L50;
        com.bytedance.live.datacontext.m r17 = r16.c2();
        if (r17 == null) goto L50;
        if (((Boolean) r17.getValue()).booleanValue() == true) goto L55;
    L50:
        this.a.U2.e().getTryShowLoading().setValue(r0);
        ds0.d r18 = this.a.U2;
        if (r18.n == true) goto L55;
        if (r18.getEnterSmooth() == true) goto L55;
        this.a.Xk("start player");
    L55:
        com.bytedance.android.live.platformplayer.utils.g r19 = this.a.r;
        com.bytedance.android.live.platformplayer.utils.d r20 = r19.a;
        if (r20 == null) goto L58;
        r20.start();
    L58:
        com.bytedance.android.live.platformplayer.utils.e r21 = r19.b;
        if (r21 == null) goto L63;
        r21.start();
        return;
    L63:
        return;
    L64:
        return;
    }
}
