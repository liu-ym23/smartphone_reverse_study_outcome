package com.bytedance.ies.bullet.lynx.bridge;

import android.os.SystemClock;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.i;
import com.bytedance.ies.bullet.service.base.x;
import java.util.concurrent.Callable;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LynxBridgeModule f5609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f5610c;

    public /* synthetic */ d(LynxBridgeModule r5, long r10, int r11) {
        this.f5608a = r11;
        this.f5609b = r5;
        this.f5610c = r10;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch(this.f5608a) {
            case 0: goto L34;
            default: goto L4;
        };
    L4:
        LynxBridgeModule r5 = this.f5609b;
        long r10 = this.f5610c;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L10
        tc.c r12 = tc.c.f22119c;     // Catch: Throwable -> L10
        tc.c r13 = tc.c.f22119c;     // Catch: Throwable -> L10
        com.bytedance.ies.bullet.core.e r14 = LynxBridgeModule.access$getBulletContext$p(r5);     // Catch: Throwable -> L10
        if (r14 == null) goto L12;
        String r15 = r14.f;     // Catch: Throwable -> L10
        if (r15 == null) goto L12;
    L13:
        i r16 = (i) r13.a(i.class, r15);     // Catch: Throwable -> L10
        if (r16 == null) goto L29;
        x r17 = new x("bdx_monitor_bridge_init_duration");     // Catch: Throwable -> L10
        JSONObject r18 = new JSONObject();     // Catch: Throwable -> L10
        com.bytedance.ies.bullet.core.e r19 = LynxBridgeModule.access$getBulletContext$p(r5);     // Catch: Throwable -> L10
        if (r19 == null) goto L20;
        ad.a r20 = r19.f5303q;     // Catch: Throwable -> L10
        if (r20 == null) goto L20;
        String r21 = r20.f157a.toString();     // Catch: Throwable -> L10
    L21:
        r18.put("_full_url", r21);     // Catch: Throwable -> L10
        r17.e = r18;     // Catch: Throwable -> L10
        com.bytedance.ies.bullet.core.e r22 = LynxBridgeModule.access$getBulletContext$p(r5);     // Catch: Throwable -> L10
        if (r22 == null) goto L27;
        ad.a r23 = r22.f5303q;     // Catch: Throwable -> L10
        if (r23 == null) goto L27;
        String r24 = r23.a();     // Catch: Throwable -> L10
        if (r24 == null) goto L27;
    L28:
        r17.f6023b = r24;     // Catch: Throwable -> L10
        r17.f6024c = "lynx";     // Catch: Throwable -> L10
        r17.f6026i = Boolean.TRUE;     // Catch: Throwable -> L10
        JSONObject r25 = new JSONObject();     // Catch: Throwable -> L10
        r25.put(WsConstants.KEY_PLATFORM, 3);     // Catch: Throwable -> L10
        r17.g = r25;     // Catch: Throwable -> L10
        JSONObject r26 = new JSONObject();     // Catch: Throwable -> L10
        r26.put("init_bridge_time", r10);     // Catch: Throwable -> L10
        r17.f = r26;     // Catch: Throwable -> L10
        ((com.bytedance.ies.bullet.service.monitor.i) r16).d(r17);     // Catch: Throwable -> L10
    L27:
        r24 = "Unknown";
    L20:
        r21 = null;
    L29:
        boolean r27 = com.bytedance.ies.bullet.service.base.b.f5956a;     // Catch: Throwable -> L10
        com.bytedance.ies.bullet.service.base.b.d("init bridge end, time use == " + r10, LogLevel.f5953a, "XLynxKit");     // Catch: Throwable -> L10
        Object r28 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L33:
        return Result.m123boximpl(r28);
    L12:
        r15 = "default_bid";
    L10:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        r28 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L33
    L34:
        LynxBridgeModule r30 = this.f5609b;
        com.bytedance.ies.bullet.core.kit.bridge.e r31 = LynxBridgeModule.access$getBridgeRegistry(r30);
        if (r31 == null) goto L37;
        ((com.bytedance.ies.bullet.core.kit.bridge.d) r31).f();
    L37:
        LynxBridgeModule.access$doMonitorInitLog(r30, SystemClock.elapsedRealtime() - this.f5610c);
        return Unit.INSTANCE;
    }
}
