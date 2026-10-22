package com.bytedance.android.live.room.discovery.drawer.template;

import com.bytedance.android.live.ai.api.IAiService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.feature.api.IFeatureService;
import com.bytedance.android.livesdk.log.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements z90.a.b {
    public final /* synthetic */ IFeatureService a;
    public final /* synthetic */ LiveDrawerEntranceCommonWidget b;
    public final /* synthetic */ IAiService c;

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> void a(String r9, T r10) {
        Intrinsics.checkNotNullParameter(r9, "name");
        if (Intrinsics.areEqual("drawer_predict_value", r9) == false) goto L27;
        int r12 = ((Number) this.a.getFeatureManager().getFeature("drawer_predict_action", -1)).intValue();
        ALogger.d("LAI-Drawer", "drawer_predict_value: " + r10 + ", drawer_predict_action: " + r12);
        if (r12 != 1) goto L7;
        return;
    L7:
        if (r12 != 0) goto L12;
        if (this.b.B.g() == true) goto L12;
        return;
    L12:
        if (r12 == 2) goto L14;
    L16:
        HashMap r3 = new HashMap();
        String r13 = (String) MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(0, "preload"), TuplesKt.to(2, "runtimePreload"), TuplesKt.to(-1, "unknown")}).get(Integer.valueOf(r12));
        if (r13 == null) goto L19;
        r3.put("predict_action", r13);
    L19:
        r3.put("predict_value", String.valueOf(r10));
        if (r10 == 0) goto L26;
        if (((Boolean) r10).booleanValue() == false) goto L24;
        LiveDrawerEntranceCommonWidget r14 = this.b;
        List<String> r15 = LiveDrawerEntranceCommonWidget.G;
        r14.getClass();
        this.b.Jq((ArrayList) this.a.getFeatureManager().getFeature("drawer_predict_range_sec", new ArrayList()), r3);
    L24:
        u.l().sendLog("livesdk_liveai_drawer_predict", r3, new Object[0]);
        return;
    L26:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    L14:
        if (this.b.B.i() == true) goto L16;
        return;
    }

    public b(IFeatureService r1, LiveDrawerEntranceCommonWidget r2, IAiService r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
