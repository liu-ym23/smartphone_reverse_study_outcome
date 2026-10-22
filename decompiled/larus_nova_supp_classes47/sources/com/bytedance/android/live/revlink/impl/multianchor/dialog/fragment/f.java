package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.google.android.material.tabs.TabLayout;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f implements View.OnTouchListener {
    public final /* synthetic */ AnchorInteractContainerFragment a;
    public final /* synthetic */ View b;

    public f(AnchorInteractContainerFragment r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r3, MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r3, "v");
        Intrinsics.checkNotNullParameter(r4, "event");
        if (r4.getAction() != 1) goto L24;
        com.bytedance.android.live.revlink.impl.pk.dialog.fragment.d r5 = this.a.q;
        if (r5 != null) goto L7;
    L9:
        this.a.getClass();
        if (AnchorInteractContainerFragment.fa0() == false) goto L17;
        ToastUtil.a(2131918000, 0);
        TabLayout r6 = this.b.findViewById(2131387986);
        if (r6 == null) goto L16;
        KProperty[] r1 = com.bytedance.android.live.revlink.impl.behavior.o.a;
        TabLayout.Tab r7 = r6.getTabAt(0);
        if (r7 == null) goto L16;
        r7.select();
    L16:
        AnchorInteractContainerFragment r8 = this.a;
        KProperty[] r2 = com.bytedance.android.live.revlink.impl.behavior.o.a;
        AnchorInteractContainerFragment.ca0(r8, 0);
        return true;
    L17:
        TabLayout r9 = this.b.findViewById(2131387986);
        if (r9 == null) goto L22;
        KProperty[] r10 = com.bytedance.android.live.revlink.impl.behavior.o.a;
        TabLayout.Tab r12 = r9.getTabAt(1);
        if (r12 == null) goto L22;
        r12.select();
    L22:
        AnchorInteractContainerFragment r13 = this.a;
        KProperty[] r14 = com.bytedance.android.live.revlink.impl.behavior.o.a;
        AnchorInteractContainerFragment.ca0(r13, 1);
        return false;
    L7:
        if (r5.EV(true) == true) goto L9;
        return true;
    L24:
        return true;
    }
}
