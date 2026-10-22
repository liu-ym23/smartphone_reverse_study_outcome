package com.bytedance.android.live.revlink.impl.pk.ui;

import android.view.View;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class v implements View.OnClickListener {
    public final /* synthetic */ PkTopTipView a;
    public final /* synthetic */ boolean b;

    public v(PkTopTipView r1) {
        this.a = r1;
        this.b = true;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        this.a._$_findCachedViewById(2131384838).setVisibility(8);
        int r5 = com.bytedance.android.live.revlink.impl.pk.utils.o.a;
        String r6 = String.valueOf(Calendar.getInstance().get(6));
        KProperty[] r0 = l51.a.a;
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        l51.a.r0.setValue(null, l51.a.a[79], r6);
        HashMap r7 = new HashMap();
        r7.put("hint_type", DataType.TRUE);
        if (this.b == false) goto L5;
        String r1 = "pk_tab";
    L6:
        r7.put("located_tab", r1);
        r7.put("button_type", "close");
        mz0.n r2 = new mz0.n();
        Map<String, String> r3 = r2.a;
        Intrinsics.checkNotNullParameter(r3, "map");
        Intrinsics.checkNotNullParameter(r7, "map");
        r3.putAll(r7);
        mz0.m r8 = new mz0.m();
        r8.b(LogCommon.ROOM);
        List<Object> r9 = r2.b;
        ArrayList r10 = (ArrayList) r9;
        r10.addAll(r8.a);
        cy0.e.a.getClass();
        cy0.j r12 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r13 = com.bytedance.android.scope.m.b(r12).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r13);
        ((mz0.i) ((f80.a) r13)).w3("livesdk_hint_bar_click", r2.a, r2.b);
        return;
    L5:
        r1 = "connection_tab";
        goto L6
    }
}
