package com.bytedance.android.live.openplatform.impl.minigameanchor.cast;

import com.bytedance.android.live.openplatform.api.minigame.datacontext.AnchorMiniGameDataContext;
import com.bytedance.android.live.openplatform.impl.minigameanchor.jsb.MiniGameCommonJsbContextService;
import com.bytedance.android.livesdk.utils.d4;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements Runnable {
    public final /* synthetic */ LiveMgCastContextService a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ String c;

    public d(LiveMgCastContextService r1, boolean r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        if (this.b == false) goto L30;
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r0 = AnchorMiniGameDataContext.a.a();
        s42.d r1 = null;
        if (r0 == null) goto L9;
        m<Boolean> r2 = r0.getOpenCamera();
        if (r2 == null) goto L9;
        Boolean r3 = (Boolean) r2.getValue();
    L11:
        if (Intrinsics.areEqual(r3, Boolean.FALSE) == false) goto L17;
        c r4 = this.a.a;
        if (r4 == null) goto L15;
        r4.setRadioMode(true);
    L15:
        this.a.n(true);
    L17:
        if (this.a.i == true) goto L19;
        j.a(true);
    L19:
        LiveMgCastContextService r5 = this.a;
        DataCenter r6 = r5.getOpenPlatformContext().getDataCenter();
        if (r6 == null) goto L22;
        r1 = (s42.d) r6.get("data_room_text_message_presenter", null);
    L22:
        r5.k(r1);
        DataCenter r7 = r5.getOpenPlatformContext().getDataCenter();
        if (r7 == null) goto L25;
        r7.observe("data_room_text_message_presenter", r5);
    L25:
        DataCenter r8 = r5.getOpenPlatformContext().getDataCenter();
        if (r8 == null) goto L32;
        vlc.d r9 = (vlc.d) r8.get("data_message_manager");
        if (r9 == null) goto L33;
        d4.b(r9, "WebcastRoomStatsMessage", r5);
        return;
    L33:
        return;
    L32:
        return;
    L9:
        r3 = null;
        goto L11
    L30:
        LiveMgCastContextService r10 = this.a;
        int r11 = LiveMgCastContextService.o;
        ((MiniGameCommonJsbContextService) r10.getOpenPlatformContext().getService(MiniGameCommonJsbContextService.class)).f();
        ((LiveMgCastContextService) this.a.getOpenPlatformContext().getService(LiveMgCastContextService.class)).q("", "getLiveCastResult fail: " + this.c);
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
