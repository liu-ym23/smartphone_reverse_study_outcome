package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.view.View;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickSearchEntrance;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class v0 implements View.OnClickListener {
    public final /* synthetic */ GiftMVITabView a;

    public v0(GiftMVITabView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        mz0.n r5 = new mz0.n();
        mz0.m r0 = new mz0.m();
        r0.b(LogCommon.ROOM);
        com.bytedance.android.livesdk.revenue.log.i r1 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r1, "pageSourceLog");
        List r2 = r0.a;
        ArrayList r3 = (ArrayList) r2;
        r3.add(r1.a);
        List r6 = r5.b;
        ArrayList r7 = (ArrayList) r6;
        r7.addAll(r0.a);
        cy0.e.a.getClass();
        cy0.j r8 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r9 = com.bytedance.android.scope.m.b(r8).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r9);
        ((f80.a) r9).w3("livesdk_gift_search_button_click", r5.a, r5.b);
        this.a.o(new ClickSearchEntrance(true, false));
    }
}
