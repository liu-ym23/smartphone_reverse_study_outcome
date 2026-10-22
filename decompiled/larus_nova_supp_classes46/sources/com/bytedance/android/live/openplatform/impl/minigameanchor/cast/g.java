package com.bytedance.android.live.openplatform.impl.minigameanchor.cast;

import android.graphics.Rect;
import android.os.Bundle;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.AnchorMiniGameDataContext;
import com.bytedance.android.live.openplatform.impl.minigamecommon.event.BridgeContextService;
import com.bytedance.live.datacontext.m;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ LiveMgCastContextService a;

    public g(LiveMgCastContextService r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        Boolean r6 = (Boolean) r5;
        int r0 = qo0.a.a;
        qo0.a.c("LiveMgCastContextService", "open capture value changed: " + r6);
        c r1 = this.a.a;
        if (r1 == null) goto L8;
        r1.setRadioMode(!r6.booleanValue());
        if (r6.booleanValue() == true) goto L7;
        LiveMgCastContextService.f(this.a);
    L7:
        BridgeContextService r2 = (BridgeContextService) this.a.getOpenPlatformContext().getService(BridgeContextService.class);
        Bundle r3 = new Bundle();
        r3.putBoolean("camera_capture_status", r6.booleanValue());
        Unit r4 = Unit.INSTANCE;
        r2.g("command_live_cast_camera_capture_switch", r3);
        this.a.n(!r6.booleanValue());
    L8:
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r7 = AnchorMiniGameDataContext.a.a();
        if (r7 == null) goto L14;
        m<Rect> r8 = r7.getLittleWindowRect();
        if (r8 == null) goto L15;
        r8.setValue(this.a.n);
        return;
    L15:
        return;
    }
}
