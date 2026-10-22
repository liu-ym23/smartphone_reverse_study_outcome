package com.larus.enterprise.impl.apptheme.repo;

import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.basic.experience.downgrade.api.FlowDowngradeServiceDelegate;
import com.larus.basic.experience.downgrade.api.IFlowDowngradeService;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import org.json.JSONObject;
import z89.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class ThemeConfigApi {
    public static final Lazy<ThemeConfigApi> a = null;

    public static final class a {
    }

    public ThemeConfigApi() {
    }

    static {
        a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new com.larus.enterprise.impl.apptheme.repo.a());
    }

    public final Object a(String r13, Continuation<? super com.larus.network.http.a<c>> r14) {
        if ((r14 instanceof ThemeConfigApi$requestThemeConfig$1) == false) goto L7;
        ThemeConfigApi$requestThemeConfig$1 r0 = (ThemeConfigApi$requestThemeConfig$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        ThemeConfigApi$requestThemeConfig$1 r10 = r0;
        Object r15 = r10.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r10.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r15);
    L18:
        return (com.larus.network.http.a) r15;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        FlowDowngradeServiceDelegate r4 = FlowDowngradeServiceDelegate.INSTANCE;
        JSONObject r5 = new JSONObject();
        r5.put("scene", r13);
        Unit r16 = Unit.INSTANCE;
        Map r9 = MapsKt.mapOf(TuplesKt.to("source", DowngradeSource.COLD_LAUNCH.getValue()));
        r10.label = 1;
        r15 = IFlowDowngradeService.a.b(r4, "Basic", c.class, "/alice/theme/config", r5, null, true, null, r9, r10, 944);
        if (r15 != r2) goto L18;
        return r2;
    L7:
        r0 = new ThemeConfigApi$requestThemeConfig$1(this, r14);
        goto L8
    }
}
