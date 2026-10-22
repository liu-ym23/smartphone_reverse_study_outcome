package com.bytedance.android.live.broadcastgame;

import com.bytedance.android.live.broadcastgame.api.AudienceGameContext;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.broadcastgame.api.openplatform.OpenPlatformMonitorUtils;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class s<T> implements Consumer {
    public final /* synthetic */ AudienceMagicBoxBehavior a;
    public final /* synthetic */ Function1 b;
    public final /* synthetic */ Function1 c;

    public s(AudienceMagicBoxBehavior r1, Function1 r2, Function1 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r12) {
        Pair r13 = (Pair) r12;
        com.bytedance.android.live.broadcastgame.opengame.message.f0 r0 = (com.bytedance.android.live.broadcastgame.opengame.message.f0) r13.component1();
        boolean r14 = ((Boolean) r13.component2()).booleanValue();
        int r1 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("MagicBoxBehavior", new Object[]{"entrance_info request success, isDisableEntrance: " + r14});
        AudienceGameContext.Companion.getClass();
        AudienceGameContext r2 = AudienceGameContext.a.a();
        if (r2 == null) goto L7;
        com.bytedance.live.datacontext.m<Boolean> r3 = r2.getDisableEntrance();
        if (r3 == null) goto L7;
        r3.setValue(Boolean.valueOf(r14));
    L7:
        InteractGameContext r4 = InteractGameContext.Companion.getContext();
        if (r4 == null) goto L30;
        com.bytedance.live.datacontext.n<com.bytedance.android.live.broadcastgame.api.model.i> r5 = r4.getGameOpenInfo();
        if (r5 == null) goto L30;
        if (r0 == null) goto L15;
        String r6 = r0.a;
        if (r6 == null) goto L15;
    L16:
        if (r0 == null) goto L18;
        long r7 = r0.f;
    L19:
        if (r0 == null) goto L22;
        String r8 = r0.i;
        if (r8 == null) goto L22;
    L23:
        if (r0 == null) goto L25;
        boolean r9 = r0.C;
    L26:
        if (r0 == null) goto L28;
        boolean r11 = r0.D;
    L29:
        r5.setValue(new com.bytedance.android.live.broadcastgame.api.model.i(r6, r7, r8, r9, r11));
        goto L30
    L28:
        r11 = false;
        goto L29
    L25:
        r9 = false;
    L22:
        r8 = "";
        goto L23
    L18:
        r7 = 0;
    L15:
        r6 = "";
    L30:
        if (r14 == true) goto L33;
        if (r0 == null) goto L33;
        this.b.invoke(r0);
        OpenPlatformMonitorUtils r15 = OpenPlatformMonitorUtils.c;
        com.bytedance.android.live.broadcastgame.api.openplatform.d r16 = this.a.c(r0);
        com.bytedance.android.live.broadcastgame.api.openplatform.e r17 = this.a.d();
        Intrinsics.checkNotNullParameter(r16, "appInfo");
        Intrinsics.checkNotNullParameter(r17, "launchParam");
        OpenPlatformMonitorUtils.d(r15, "ttlive_open_platform_request_status_enter", LiveTracingMonitor.EventType.SERVER_API_CALL, r16, r17).c();
        return;
    L33:
        this.c.invoke(null);
    }
}
