package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import android.view.View;
import com.bytedance.android.live.revlink.impl.pk.dialog.fragment.AnchorInteractSettingFragment;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i implements View.OnClickListener {
    public final /* synthetic */ AnchorInteractContainerFragment a;
    public final /* synthetic */ View b;

    public i(AnchorInteractContainerFragment r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        HashMap r5 = new HashMap();
        TabLayout r0 = this.b.findViewById(2131387986);
        if (r0 == null) goto L7;
        int r1 = r0.getSelectedTabPosition();
        KProperty[] r2 = com.bytedance.android.live.revlink.impl.behavior.o.a;
        if (r1 != 0) goto L7;
        String r3 = "connection";
    L8:
        r5.put("panel_type", r3);
        r5.put("pk_description", "routine");
        r5.put("pk_activity_type", "");
        w31.c r6 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r6 == null) goto L11;
        Map<String, String> r7 = r6.f();
    L12:
        r5.putAll(r7);
        mz0.n r8 = new mz0.n();
        Map<String, String> r9 = r8.a;
        Intrinsics.checkNotNullParameter(r9, "map");
        Intrinsics.checkNotNullParameter(r5, "map");
        r9.putAll(r5);
        mz0.m r10 = new mz0.m();
        r10.b(LogCommon.ROOM);
        List<Object> r12 = r8.b;
        ArrayList r13 = (ArrayList) r12;
        r13.addAll(r10.a);
        cy0.e.a.getClass();
        cy0.j r14 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r15 = com.bytedance.android.scope.m.b(r14).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r15);
        ((mz0.i) ((f80.a) r15)).w3("livesdk_pk_set_click", r8.a, r8.b);
        AnchorInteractContainerFragment r16 = this.a;
        int r17 = AnchorInteractContainerFragment.S;
        com.bytedance.android.live.revlink.impl.control.dialog.r r18 = r16.d;
        int r19 = AnchorInteractSettingFragment.H0;
        boolean r20 = r16.A;
        AnchorInteractSettingFragment r22 = new AnchorInteractSettingFragment();
        r22.f = new com.bytedance.android.live.revlink.impl.pk.dialog.presenter.a(r22);
        r22.d = r18;
        r22.Y = r20;
        r22.k0 = true;
        r18.zD(r22);
        return;
    L11:
        r7 = MapsKt.emptyMap();
    L7:
        r3 = "routine_pk";
        goto L8
    }
}
