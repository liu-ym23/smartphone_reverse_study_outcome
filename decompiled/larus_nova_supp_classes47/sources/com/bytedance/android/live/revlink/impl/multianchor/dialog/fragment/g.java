package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.google.android.material.tabs.TabLayout;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g implements View.OnTouchListener {
    public final /* synthetic */ AnchorInteractContainerFragment a;
    public final /* synthetic */ View b;

    public g(AnchorInteractContainerFragment r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r3, MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r3, "v");
        Intrinsics.checkNotNullParameter(r4, "event");
        if (r4.getAction() != 1) goto L28;
        com.bytedance.android.live.revlink.impl.pk.dialog.fragment.d r5 = this.a.q;
        if (r5 != null) goto L7;
    L21:
        TabLayout r6 = this.b.findViewById(2131387986);
        if (r6 == null) goto L26;
        KProperty[] r7 = com.bytedance.android.live.revlink.impl.behavior.o.a;
        TabLayout.Tab r8 = r6.getTabAt(0);
        if (r8 == null) goto L26;
        r8.select();
    L26:
        AnchorInteractContainerFragment r9 = this.a;
        KProperty[] r10 = com.bytedance.android.live.revlink.impl.behavior.o.a;
        AnchorInteractContainerFragment.ca0(r9, 0);
        return false;
    L7:
        if (r5.FL() != true) goto L21;
        com.bytedance.android.live.revlink.impl.pk.dialog.fragment.d r12 = this.a.q;
        if (r12 != null) goto L11;
    L13:
        ToastUtil.a(2131921457, 0);
        TabLayout r13 = this.b.findViewById(2131387986);
        if (r13 == null) goto L18;
        KProperty[] r0 = com.bytedance.android.live.revlink.impl.behavior.o.a;
        TabLayout.Tab r14 = r13.getTabAt(1);
        if (r14 == null) goto L18;
        r14.select();
    L18:
        AnchorInteractContainerFragment r15 = this.a;
        KProperty[] r1 = com.bytedance.android.live.revlink.impl.behavior.o.a;
        AnchorInteractContainerFragment.ca0(r15, 1);
        LiveFullLinkPKMonitor r16 = com.bytedance.android.live.revlink.impl.global.b.q();
        if (r16 == null) goto L29;
        r16.k("anchor_tab");
        return true;
    L29:
        return true;
    L11:
        if (r12.EV(true) == true) goto L13;
        return true;
    L28:
        return true;
    }
}
