package com.bytedance.android.live.revlink.impl.pk.ui;

import android.view.View;
import com.bytedance.android.live.revenue.common.x0;
import com.bytedance.android.livesdk.link.model.s8;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l implements View.OnClickListener {
    public final /* synthetic */ PKRankUnlockView a;
    public final /* synthetic */ s8 b;

    public l(PKRankUnlockView r1, s8 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        s8 r6 = this.b;
        if (r6 == null) goto L5;
        String r7 = r6.getRuleSchema();
    L6:
        if (r7 != null) goto L8;
    L11:
        boolean r0 = true;
    L12:
        if (r0 == false) goto L14;
        return;
    L14:
        x0 r1 = new x0(r7);
        PKRankUnlockView r8 = this.a;
        r8.i = ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).U0(this.a.getContext(), r1.c(), this.a.l);
        HashMap r9 = new HashMap();
        r9.put("btn_type", "level");
        mz0.n r2 = new mz0.n();
        Map<String, String> r3 = r2.a;
        Intrinsics.checkNotNullParameter(r3, "map");
        Intrinsics.checkNotNullParameter(r9, "map");
        r3.putAll(r9);
        mz0.m r10 = new mz0.m();
        r10.b(LogCommon.ROOM);
        List<Object> r4 = r2.b;
        ArrayList r12 = (ArrayList) r4;
        r12.addAll(r10.a);
        cy0.e.a.getClass();
        cy0.j r13 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r14 = com.bytedance.android.scope.m.b(r13).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r14);
        ((mz0.i) ((f80.a) r14)).w3("livesdk_season_rank_detail_click", r2.a, r2.b);
        return;
    L8:
        if (r7.length() == 0) goto L11;
        r0 = false;
        goto L12
    L5:
        r7 = null;
        goto L6
    }
}
