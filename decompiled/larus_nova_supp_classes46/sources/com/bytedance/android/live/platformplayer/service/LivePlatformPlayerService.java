package com.bytedance.android.live.platformplayer.service;

import android.content.Context;
import com.bytedance.android.live.core.setting.h1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.platformplayer.LivePlatformPlayer;
import com.bytedance.android.live.platformplayer.effect.VrEffectDownloader;
import com.bytedance.android.live.platformplayer.init.LivePlayerHostServiceImpl;
import com.bytedance.android.live.platformplayer.layout.LivePlayerWidget;
import com.bytedance.android.live.platformplayer.layout.f;
import com.bytedance.android.live.platformplayer.panel.StreamAutoAdapterService;
import com.bytedance.android.live.platformplayer.panel.h;
import com.bytedance.android.live.platformplayer.panel.i;
import com.bytedance.android.live.platformplayer.panel.l;
import com.bytedance.android.live.platformplayer.panel.o;
import com.bytedance.android.live.platformplayer.playback.LiveProgressBarWidget;
import com.bytedance.android.livesdk.chatroom.room.RoomSession;
import com.bytedance.android.livesdk.player.layout.LivePlayerLayoutContextObserver;
import com.bytedance.android.livesdk.player.layout.d;
import com.bytedance.android.livesdk.player.layout.e;
import com.bytedance.android.livesdk.player.layout.n;
import com.bytedance.android.livesdk.player.vr.VrBgImageEventController;
import com.bytedance.android.livesdkapi.model.EnterLeaveSurfaceRenderOpt;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerSpmLogger;
import com.bytedance.android.livesdkapi.roomplayer.IPlayerLogger;
import com.bytedance.android.livesdkapi.view.IRenderView;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xj1.r;
import zg1.i1;
import zg1.w1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/platformplayer/service/LivePlatformPlayerService;", "Lcom/bytedance/android/live/platformplayer/service/a;", "<init>", "()V", "platform-player-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePlatformPlayerService implements a {
    public final Lazy a;
    public final Lazy b;

    @Override // com.bytedance.android.live.platformplayer.service.a
    public final VrEffectDownloader T0() {
        return (VrEffectDownloader) this.b.getValue();
    }

    @Override // com.bytedance.android.live.platformplayer.service.a
    public final c b0() {
        return new c();
    }

    @Override // com.bytedance.android.live.platformplayer.service.a
    public final com.bytedance.android.live.platformplayer.effect.b c4() {
        return (com.bytedance.android.live.platformplayer.effect.b) this.a.getValue();
    }

    @Override // com.bytedance.android.live.platformplayer.service.a
    public final com.bytedance.android.live.platformplayer.layout.b getLivePlayerLayoutManager() {
        return new n(d.a());
    }

    @Override // com.bytedance.android.live.platformplayer.service.a
    public final VrBgImageEventController i3() {
        return new VrBgImageEventController();
    }

    @Override // com.bytedance.android.live.platformplayer.service.a
    public final LiveProgressBarWidget u1() {
        return new LiveProgressBarWidget();
    }

    public LivePlatformPlayerService() {
        this.a = LazyKt.lazy(LivePlatformPlayerService$effectHelper$2.INSTANCE);
        this.b = LazyKt.lazy(LivePlatformPlayerService$vrEffectDownloader$2.INSTANCE);
        k.l(a.class, this);
        is0.c.c().inject(new LivePlayerHostServiceImpl(), true);
        k.l(b.class, StreamAutoAdapterService.o);
        o r0 = (o) StreamAutoAdapterService.a.getValue();
        r0.getClass();
        RxUtilKt.c(xs2.b.a().b(ds0.b.class).subscribe(new h(r0)), r0.a);
        RxUtilKt.c(xs2.b.a().b(i1.class).subscribe(new i(r0)), r0.a);
        RxUtilKt.c(xs2.b.a().b(w1.class).subscribe(new com.bytedance.android.live.platformplayer.panel.k(r0), new l(r0)), r0.a);
    }

    @Override // com.bytedance.android.live.platformplayer.service.a
    public final void Z2() {
        Lazy r0 = StreamAutoAdapterService.a;
    }

    @Override // com.bytedance.android.live.platformplayer.service.a
    public final void t1() {
        boolean r0 = qo2.a.a;
    }

    @Override // com.bytedance.android.live.platformplayer.service.a
    public final void C1(ILivePlayerClient r9) {
        int r0 = wt2.b.a;
        if (r9 != null) goto L5;
        return;
    L5:
        if (((EnterLeaveSurfaceRenderOpt) h1.a.getValue()).enterOpt == false) goto L11;
        boolean r1 = r9.forceDrawOnceWhenSwitchSurface(true);
        IPlayerLogger r2 = r9.logger();
        if (r2 == null) goto L12;
        ILivePlayerSpmLogger.DefaultImpls.logPlayerClient$default(r2, "forceDrawOnce enter " + r1, null, false, null, 14, null);
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.live.platformplayer.service.a
    public final void F4(ILivePlayerClient r9) {
        int r0 = wt2.b.a;
        if (r9 != null) goto L5;
        return;
    L5:
        if (((EnterLeaveSurfaceRenderOpt) h1.a.getValue()).leaveOpt == false) goto L11;
        boolean r1 = r9.forceDrawOnceWhenSwitchSurface(true);
        IPlayerLogger r2 = r9.logger();
        if (r2 == null) goto L12;
        ILivePlayerSpmLogger.DefaultImpls.logPlayerClient$default(r2, "forceDrawOnce leave " + r1, null, false, null, 14, null);
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.live.platformplayer.service.a
    public final LivePlayerWidget S0(RoomSession r2) {
        Intrinsics.checkNotNullParameter(r2, "session");
        return new LivePlayerWidget(r2);
    }

    @Override // com.bytedance.android.live.platformplayer.service.a
    public final f getLivePlayerLayoutContext(com.bytedance.android.live.platformplayer.layout.d r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return LivePlayerLayoutContextObserver.a(r1);
    }

    @Override // com.bytedance.android.live.platformplayer.service.a
    public final com.bytedance.android.live.platformplayer.layout.c getLivePlayerPosition(IRenderView r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return new e(r2);
    }

    @Override // com.bytedance.android.live.platformplayer.service.a
    public final LivePlatformPlayer m2(long r2) {
        return new LivePlatformPlayer(r2);
    }

    @Override // com.bytedance.android.live.platformplayer.service.a
    public final com.bytedance.android.live.platformplayer.utils.b I(r r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "listen");
        Intrinsics.checkNotNullParameter(r3, "context");
        return new com.bytedance.android.live.platformplayer.utils.b(r2, r3);
    }
}
