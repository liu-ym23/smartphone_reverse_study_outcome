package com.bytedance.android.annie.business.latch;

import android.content.Context;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.annie.xbridge.mix.StateMethodFinder;
import com.bytedance.android.latch.LatchProcessOptions;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.sdk.xbridge.cn.optimize.OptimizeConfigKt;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBDXBridge;
import com.bytedance.sdk.xbridge.cn.protocol.MethodFinder;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.WritableMap;
import com.lynx.tasm.LynxView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d implements kx.b.a {
    public final String a;
    public final HashSet<String> b;
    public final LynxBDXBridge c;

    public final void release() {
        HybridLogger.f("AnnieBusinessLatchService", "======AnnieBusinessLatchJsBridgeHandlerImpl release=======", null, 12);
        this.c.A();
    }

    public final void a(String r10, JavaOnlyMap r11, kx.b.a.a r12) {
        Intrinsics.checkNotNullParameter(r10, "methodName");
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        HybridLogger r0 = HybridLogger.a;
        HybridLogger.f("AnnieBusinessLatchService", "handle: " + r10, null, 12);
        com.bytedance.sdk.xbridge.cn.platform.lynx.a r1 = new com.bytedance.sdk.xbridge.cn.platform.lynx.a(r10, r11, this.a);
        boolean r13 = true;
        ((le7.a) r1).J = true;
        Map r14 = x26.a.a;
        w26.g r15 = (w26.g) x26.a.a(w26.g.class);
        if (r15 == null) goto L9;
        w26.e r16 = (w26.e) r15.n0(w26.e.class);
        if (r16 == null) goto L9;
        Boolean r17 = r16.F1();
        if (r17 == null) goto L9;
        r13 = r17.booleanValue();
    L9:
        if (r13 == false) goto L43;
        ReadableMap r18 = r1.P;
        if ((r18 instanceof ReadableMap) == true) goto L14;
        r18 = null;
    L14:
        if (r18 == null) goto L43;
        if (Intrinsics.areEqual(r10, "fetch") == false) goto L19;
        String r19 = "headers";
    L22:
        if (r19 == null) goto L43;
        WritableMap r20 = r18.getMap(r19);
        if ((r20 instanceof WritableMap) == false) goto L26;
        WritableMap r21 = r20;
    L27:
        if (r21 != null) goto L34;
        r21 = new JavaOnlyMap();
        if ((r18 instanceof WritableMap) == false) goto L31;
        WritableMap r22 = (WritableMap) r18;
    L32:
        if (r22 == null) goto L34;
        r22.putMap(r19, r21);
        goto L34
    L31:
        r22 = null;
    L34:
        r21.putString("Anniex-Prefetch", "1");
        goto L43
    L26:
        r21 = null;
        goto L27
    L19:
        if (Intrinsics.areEqual(r10, "x.request") == false) goto L21;
        r19 = "header";
        goto L22
    L21:
        r19 = null;
    L43:
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L37
        this.c.o(r1, new c(r1, r10, r12));     // Catch: Throwable -> L37
        Object r24 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L37
    L39:
        Throwable r25 = Result.exceptionOrNull-impl(r24);
        if (r25 == null) goto L45;
        HybridLogger r110 = HybridLogger.a;
        HybridLogger.i("AnnieBusinessLatchService", "handle  " + r10 + " exception:. " + r25, null, 12);
        return;
    L45:
        return;
    L37:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r24 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L39
    }

    public d(Context r10, String r11, LatchProcessOptions r12, HashSet<String> r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "pageUrl");
        Intrinsics.checkNotNullParameter(r12, "options");
        Intrinsics.checkNotNullParameter(r13, "methodNames");
        this.a = r11;
        this.b = r13;
        HybridLogger.f("AnnieBusinessLatchService", "======new AnnieBusinessLatchJsBridgeHandlerImpl=======", null, 12);
        Boolean r14 = AnnieConfigSettingKeys.LATCH_PIPE_DATA.a();
        hx.a r15 = r12.d;
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type com.bytedance.android.annie.business.latch.AnnieBusinessLatchClient");
        LynxBDXBridge r0 = new LynxBDXBridge(r10, ((a) r15).b, "webcast");
        boolean r16 = r14.booleanValue();
        r0.o = r16;
        ((com.bytedance.sdk.xbridge.cn.platform.lynx.i) r0.n.getValue()).b.a = r16;
        LynxView r17 = new LynxView(r10);
        r0.E(r17);
        s26.d r18 = s26.d.c;
        k16.b r19 = s26.d.c.d("default_bid", k16.b.class);
        if (r19 == null) goto L8;
        m16.b r1 = new m16.b();
        r1.d(h16.e.class, new i(r10, r11, r0.k, r17));
        List r20 = r19.L(r1);
        r0.e(new StateMethodFinder(r1), 0);
        Iterator r21 = r20.iterator();
    L6:
        if (r21.hasNext() == false) goto L8;
        r0.d((MethodFinder) r21.next());
    L8:
        ArrayList r22 = new ArrayList();
        com.bytedance.sdk.xbridge.cn.optimize.c r23 = new com.bytedance.sdk.xbridge.cn.optimize.c(null, null, 31);
        r23.a = SetsKt.hashSetOf(new String[]{"bdx_thread_opt_all_schema"});
        r23.b = this.b;
        r22.add(r23);
        Unit r24 = Unit.INSTANCE;
        r0.F(true, r22);
        LinkedHashMap r25 = new LinkedHashMap();
        Lazy r26 = OptimizeConfigKt.a;
        r25.put("latch_skip_bpea", Boolean.valueOf(com.bytedance.ies.bullet.service.base.h.y0()));
        r25.put("latch_skip_auth", Boolean.valueOf(com.bytedance.ies.bullet.service.base.h.x0()));
        r25.put("mix_jsb_opt_switch", Boolean.valueOf(com.bytedance.ies.bullet.service.base.h.z0()));
        r0.f(r25);
        id7.c r27 = id7.c.a;
        id7.c.e = com.bytedance.ies.bullet.service.base.h.o();
        this.c = r0;
    }
}
