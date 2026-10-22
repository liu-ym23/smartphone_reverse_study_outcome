package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.util.JavaCalls;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h implements View.OnTouchListener {
    public final /* synthetic */ AnchorInteractContainerFragment a;
    public final /* synthetic */ View b;

    public h(AnchorInteractContainerFragment r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r6, MotionEvent r7) {
        Intrinsics.checkNotNullParameter(r6, "v");
        Intrinsics.checkNotNullParameter(r7, "event");
        f0 r8 = this.a.H;
        if (r8 != null) goto L5;
        return true;
    L5:
        if (r8.c == true) goto L8;
        return true;
    L8:
        if (r7.getAction() != 1) goto L50;
        f0 r9 = this.a.H;
        if (r9 == null) goto L24;
        View r10 = r9.a;
        if (r10 == null) goto L16;
        TabLayout r12 = r10.findViewById(2131387986);
        if (r12 == null) goto L16;
        KProperty[] r3 = com.bytedance.android.live.revlink.impl.behavior.o.a;
        TabLayout.Tab r13 = r12.getTabAt(2);
    L17:
        Object r14 = JavaCalls.getField(r13, "view");
        if ((r14 instanceof LinearLayout) == false) goto L24;
        LinearLayout r15 = (LinearLayout) r14;
        if (r15.getChildCount() <= 0) goto L24;
        if ((r15.getChildAt(r15.getChildCount() - 1) instanceof ImageView) == false) goto L24;
        r15.removeViewAt(r15.getChildCount() - 1);
    L16:
        r13 = null;
    L24:
        l51.a.c.setValue(null, l51.a.a[1], Boolean.TRUE);
        com.bytedance.android.live.revlink.impl.pk.dialog.fragment.d r16 = this.a.r;
        if (r16 != null) goto L27;
    L29:
        HashMap r17 = new HashMap();
        r17.put("source", "live_pk_icon");
        r17.put("room_status", "live");
        r17.put("anchor_connect_status", DataType.FALSE);
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r2 = com.bytedance.android.live.revlink.impl.global.b.l();
        if (r2 == null) goto L33;
        String r4 = r2.b;
        if (r4 == null) goto L33;
    L34:
        r17.put("from_page", r4);
        mz0.n r5 = new mz0.n();
        Map<String, String> r18 = r5.a;
        Intrinsics.checkNotNullParameter(r18, "map");
        Intrinsics.checkNotNullParameter(r17, "map");
        r18.putAll(r17);
        mz0.m r19 = new mz0.m();
        r19.b(LogCommon.ROOM);
        ((ArrayList) r5.b).addAll(r19.a);
        cy0.e.a.getClass();
        cy0.j r20 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r22 = com.bytedance.android.scope.m.b(r20).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r22);
        ((mz0.i) ((f80.a) r22)).w3("livesdk_season_rank_click", r5.a, r5.b);
        this.a.getClass();
        if (AnchorInteractContainerFragment.fa0() == false) goto L42;
        ToastUtil.a(2131918000, 0);
        TabLayout r23 = this.b.findViewById(2131387986);
        if (r23 == null) goto L41;
        KProperty[] r24 = com.bytedance.android.live.revlink.impl.behavior.o.a;
        TabLayout.Tab r25 = r23.getTabAt(0);
        if (r25 == null) goto L41;
        r25.select();
    L41:
        AnchorInteractContainerFragment r26 = this.a;
        KProperty[] r27 = com.bytedance.android.live.revlink.impl.behavior.o.a;
        AnchorInteractContainerFragment.ca0(r26, 0);
        return true;
    L42:
        TabLayout r28 = this.b.findViewById(2131387986);
        if (r28 == null) goto L47;
        KProperty[] r0 = com.bytedance.android.live.revlink.impl.behavior.o.a;
        TabLayout.Tab r29 = r28.getTabAt(2);
        if (r29 == null) goto L47;
        r29.select();
    L47:
        AnchorInteractContainerFragment r30 = this.a;
        KProperty[] r1 = com.bytedance.android.live.revlink.impl.behavior.o.a;
        AnchorInteractContainerFragment.ca0(r30, 2);
        return false;
    L33:
        r4 = "";
        goto L34
    L27:
        if (r16.EV(true) == true) goto L29;
        return true;
    L50:
        return true;
    }
}
