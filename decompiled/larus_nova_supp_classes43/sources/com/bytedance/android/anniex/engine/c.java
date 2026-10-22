package com.bytedance.android.anniex.engine;

import android.content.MutableContextWrapper;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBDXBridge;
import com.lynx.tasm.t;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import w26.e;
import w26.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public LynxBDXBridge a;
    public com.bytedance.android.monitorV2.lynx.jsb.a b;

    public c(int r1) {
        this.a = null;
        this.b = null;
    }

    public final AnnieXLynxEngine a(String r10, MutableContextWrapper r11, t r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "bid");
        Intrinsics.checkNotNullParameter(r11, "contextWrapper");
        Intrinsics.checkNotNullParameter(r12, "builder");
        Intrinsics.checkNotNullParameter(r13, "sessionId");
        AnnieXLynxEngine r0 = new AnnieXLynxEngine(r10, r11, r12, r13);
        LynxBDXBridge r14 = this.a;
        if (r14 == null) goto L5;
        r0.c = r14;
    L5:
        com.bytedance.android.monitorV2.lynx.jsb.a r15 = this.b;
        if (r15 == null) goto L8;
        r0.d = r15;
    L8:
        Map r16 = x26.a.a;
        g r17 = (g) x26.a.a(g.class);
        if (r17 == null) goto L11;
        e r18 = (e) r17.n0(e.class);
    L13:
        if (r18 == null) goto L15;
        long r1 = r18.s2();
    L16:
        r0.h = r1;
        if (r1 >= 0) goto L19;
    L20:
        HybridLogger.i("AnnieXLynxEngine", "expireTime is invalid, use default value 15000", null, 12);
        r0.h = 15000;
    L22:
        if (r18 == null) goto L24;
        int r19 = r18.r2();
    L25:
        r0.g = r19;
        if (r19 >= 0) goto L28;
    L29:
        HybridLogger.i("AnnieXLynxEngine", "cacheNumber is invalid, use default value 5", null, 12);
        r0.g = 5;
    L30:
        return r0;
    L28:
        if (r19 <= 50) goto L30;
    L24:
        r19 = 5;
        goto L25
    L19:
        if (r1 <= 300000) goto L22;
    L15:
        r1 = 15000;
        goto L16
    L11:
        r18 = null;
        goto L13
    }
}
