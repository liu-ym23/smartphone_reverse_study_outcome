package com.larus.xbridge.custom;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.settings.value.e10;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class q1 extends bx7.c {
    public final String getName() {
        return "app.getAppDebugInfo";
    }

    public q1() {
    }

    public final void a(dx7.b r6, ux7.d.d r7, IvyBridgePlatformType r8) {
        Intrinsics.checkNotNullParameter(r6, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r7, "callback");
        Intrinsics.checkNotNullParameter(r8, "type");
        Pair[] r9 = new Pair[2];
        r9[0] = TuplesKt.to(LynxResourceModule.CODE_KEY, 1);
        LinkedHashMap r0 = new LinkedHashMap();
        e10 r1 = e10.a;
        qt9.o0 r2 = e10.e();
        String r3 = r2.b();
        String r4 = NameKeys.UnloadStrategy_No_Strategy;
        if (r3 != null) goto L5;
        r3 = NameKeys.UnloadStrategy_No_Strategy;
    L5:
        r0.put("first_install_time", r3);
        String r5 = r2.a();
        if (r5 == null) goto L9;
        r4 = r5;
    L9:
        r0.put("register_time", r4);
        Unit r10 = Unit.INSTANCE;
        r9[1] = TuplesKt.to(LynxResourceModule.DATA_KEY, r0);
        r7.invoke(MapsKt.mutableMapOf(r9));
    }
}
