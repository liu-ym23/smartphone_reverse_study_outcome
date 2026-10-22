package com.bytedance.android.live.broadcastgame.opengame.service;

import android.content.Context;
import android.os.SystemClock;
import com.bytedance.android.live.broadcastgame.opengame.GameIntroCard;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.broadcastgame.openplatform.miniapp.card.IntroduceCardWidget;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/service/AudienceMiniGameIntroCardService;", "Ly10/a;", "Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;", "pluginContext", "<init>", "(Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;)V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceMiniGameIntroCardService implements y10.a {
    public final com.bytedance.android.live.broadcastgame.openplatform.miniapp.card.e a;
    public IntroduceCardWidget<com.bytedance.android.live.broadcastgame.api.openplatform.a> b;
    public final CompositeDisposable c;
    public long d;
    public com.bytedance.android.live.broadcastgame.api.openplatform.a e;
    public final PluginContext f;

    @Override // y10.a
    public final void g() {
    }

    public AudienceMiniGameIntroCardService(PluginContext r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        this.f = r2;
        this.a = new com.bytedance.android.live.broadcastgame.openplatform.miniapp.card.e();
        this.c = new CompositeDisposable();
    }

    public final void b(com.bytedance.android.live.broadcastgame.api.openplatform.a r15) {
        Intrinsics.checkNotNullParameter(r15, "gameIntroCardInfo");
        if (r15.k <= 1) goto L5;
        return;
    L5:
        DataCenter r0 = this.f.i;
        if (r0 == null) goto L8;
        Boolean r1 = (Boolean) r0.get("cmd_commerce_ad_show", Boolean.FALSE);
    L10:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L12;
        return;
    L12:
        long r4 = 0;
        RoomContext r2 = RoomContext.a.c(RoomContext.Companion, this.f.i, 0, 2);
        if (r2 == null) goto L17;
        j r3 = r2.getToolbarBubbleManager();
        if (r3 == null) goto L17;
        r3.c(new AudienceMiniGameIntroCardService$showCard$1(this));
    L17:
        IntroduceCardWidget<com.bytedance.android.live.broadcastgame.api.openplatform.a> r5 = new IntroduceCardWidget(this.f.getContext(), this.f.m.a);
        if (r5.c != null) goto L20;
        int r6 = com.bytedance.android.live.broadcastgame.openplatform.miniapp.card.b.a;
        Context r7 = r5.e;
        Intrinsics.checkNotNullParameter(r7, "ctx");
        r5.c = new GameIntroCard(r7, null, 6, 0);
    L20:
        GameIntroCard r8 = r5.c;
        if (r8 == null) goto L23;
        r8.setData(r15);
    L23:
        r5.t(new a(this));
        r5.q(new b(this, r15));
        this.b = r5;
        Long r9 = r15.j;
        if (r9 == null) goto L26;
        long r11 = r9.longValue();
    L27:
        long r12 = r11;
        IntroduceCardWidget<com.bytedance.android.live.broadcastgame.api.openplatform.a> r13 = this.b;
        if (r13 != null) goto L31;
        return;
    L31:
        if (r15.l == false) goto L33;
        r4 = 3000;
    L33:
        long r14 = r4;
        com.bytedance.android.live.broadcastgame.openplatform.miniapp.card.e r16 = this.a;
        int r17 = com.bytedance.android.live.broadcastgame.openplatform.miniapp.card.e.d;
        monitor-enter(r16);
    L41:
        th = move-exception;
        throw th;
    L36:
        if ((SystemClock.uptimeMillis() - r16.c) < 10000) goto L38;
        v.a();     // Catch: Throwable -> L41
        r16.a.clear();     // Catch: Throwable -> L41
    L38:
        monitor-exit(r16);
        this.a.a("load", new AudienceMiniGameIntroCardService$showCard$2(this, r13, r14, r15, r12));
        return;
    L26:
        r11 = 10;
        goto L27
    L8:
        r1 = null;
        goto L10
    }

    public static void a(final AudienceMiniGameIntroCardService r3, final boolean r4, final boolean r5, int r6) {
        if ((r6 & 1) == 0) goto L6;
        r4 = false;
    L6:
        if ((r6 & 2) == 0) goto L8;
        r5 = false;
    L8:
        final IntroduceCardWidget<com.bytedance.android.live.broadcastgame.api.openplatform.a> r7 = r3.b;
        if (r7 == null) goto L20;
        r3.c.clear();
        if (r7.b == false) goto L18;
        com.bytedance.android.live.broadcastgame.openplatform.miniapp.card.e r1 = r3.a;
        r1.a("隐藏卡片动画", new AudienceMiniGameIntroCardService$hideCard$1(r3, r7, r5));
        r1.a("dismiss widget", new AudienceMiniGameIntroCardService$hideCard$2(r3, r7, r4));
        RoomContext r8 = RoomContext.a.c(RoomContext.Companion, r3.f.i, 0, 2);
        if (r8 == null) goto L18;
        j r9 = r8.getToolbarBubbleManager();
        if (r9 == null) goto L18;
        r9.c(new AudienceMiniGameIntroCardService$hideCard$3(r3));
    L18:
        r3.a.a("unload widget", new AudienceMiniGameIntroCardService$hideCard$4(r7));
        return;
    }
}
