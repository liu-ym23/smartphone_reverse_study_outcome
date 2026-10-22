package com.bytedance.android.live.revlink.impl.pk.ui;

import android.view.View;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k implements View.OnClickListener {
    public final /* synthetic */ PKRankUnlockView a;

    public k(PKRankUnlockView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        this.a.k.invoke();
        HashMap r5 = new HashMap();
        r5.put("btn_type", "change_to_pk");
        mz0.n r0 = new mz0.n();
        Map<String, String> r1 = r0.a;
        Intrinsics.checkNotNullParameter(r1, "map");
        Intrinsics.checkNotNullParameter(r5, "map");
        r1.putAll(r5);
        mz0.m r6 = new mz0.m();
        r6.b(LogCommon.ROOM);
        List<Object> r2 = r0.b;
        ArrayList r3 = (ArrayList) r2;
        r3.addAll(r6.a);
        cy0.e.a.getClass();
        cy0.j r7 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r8 = com.bytedance.android.scope.m.b(r7).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r8);
        ((mz0.i) ((f80.a) r8)).w3("livesdk_season_rank_detail_click", r0.a, r0.b);
    }
}
