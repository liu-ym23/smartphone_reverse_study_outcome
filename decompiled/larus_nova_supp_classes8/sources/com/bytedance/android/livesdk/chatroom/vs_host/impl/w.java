package com.bytedance.android.livesdk.chatroom.vs_host.impl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.resolution.AudienceVideoResolutionManager;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.LiveCoreSDKData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.lang.ref.WeakReference;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class w implements vr1.s, com.bytedance.android.scope.o {
    public w() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // vr1.s
    public final String c() {
        int r0 = AudienceVideoResolutionManager.a;
        LiveCoreSDKData.Quality r1 = AudienceVideoResolutionManager.c;
        if (r1 == null) goto L6;
        String r2 = r1.getName();
        if (r2 == null) goto L6;
        return r2;
    L6:
        return "";
    }

    @Override // vr1.s
    public final Pair<WeakReference<View>, WeakReference<View>> getLivePlayerView() {
        WeakReference r4 = null;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L7;
        Room r2 = (Room) r1.getValue();
    L8:
        boolean r3 = false;
        if (r2 == null) goto L11;
        as0.a r5 = LivePlatformPlayerManager.e(r2.getId(), false);
    L12:
        if (r5 == null) goto L29;
        LivePlayerView r6 = r5.getLivePlayerView();
        if (r6 == null) goto L29;
        r4 = new WeakReference(r6);
        ILivePlayerClient r7 = r5.player();
        if (r7 != null) goto L18;
    L24:
        View r8 = r6.getRenderView();
        if (r8 == null) goto L28;
        WeakReference r9 = new WeakReference(r8);
    L31:
        return new Pair(r4, r9);
    L28:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L18:
        if (r7.gameExtraRenderController().isEnable() == false) goto L20;
    L21:
        r3 = true;
    L22:
        if (r3 != true) goto L24;
        r9 = new WeakReference(r6);
        goto L31
    L20:
        if (r7.extraRenderController().isGameRoom() == false) goto L22;
    L29:
        r9 = null;
        goto L31
    L11:
        r5 = null;
    L7:
        r2 = null;
        goto L8
    }

    @Override // vr1.s
    public final ILivePlayerClient currentClient() {
        return LivePlatformPlayerManager.f();
    }

    @Override // vr1.s
    public final void a(DataCenter r2) {
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r3 = ((IVSPlayerService) jc1.k.n(IVSPlayerService.class)).provideVSPlayerViewControlService(r2);
        if (r3 == null) goto L6;
        r3.setVisibilityStatus(false);
        return;
    }

    @Override // vr1.s
    public final void d(IBaseStreamUrl r2) {
        int r0 = AudienceVideoResolutionManager.a;
        if ((r2 instanceof StreamUrl) == true) goto L5;
        r2 = null;
    L5:
        AudienceVideoResolutionManager.v((StreamUrl) r2);
    }

    @Override // vr1.s
    public final void f(long r7, long r9, boolean r11) {
        ILiveService r0 = TTLiveSDKContext.getLiveService();
        if (r0 == null) goto L6;
        r0.saveFirstShowProgressToLocal(r7, r9, r11);
        return;
    }

    @Override // vr1.s
    public final VSPlayerService$createGestureViewManager$manager$1 g(Context r9, View r10, ViewGroup r11, com.bytedance.android.livesdk.chatroom.vs.gesture.g r12) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "targetView");
        Intrinsics.checkNotNullParameter(r11, "viewGroup");
        Intrinsics.checkNotNullParameter(r12, "vsGestureViewManager");
        return new VSPlayerService$createGestureViewManager$manager$1(r12, r10, r11, r9, r10, r11);
    }
}
