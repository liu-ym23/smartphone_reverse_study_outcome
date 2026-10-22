package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import com.google.android.material.tabs.TabLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class x implements TabLayout.OnTabSelectedListener {
    public final /* synthetic */ InteractRecordContainerFragment a;

    public final void onTabReselected(TabLayout.Tab r2) {
        Intrinsics.checkNotNullParameter(r2, "tab");
    }

    public x(InteractRecordContainerFragment r1) {
        this.a = r1;
    }

    public final void onTabSelected(TabLayout.Tab r3) {
        Intrinsics.checkNotNullParameter(r3, "tab");
        if (r3.getText() != null) goto L5;
        return;
    L5:
        InteractRecordContainerFragment r0 = this.a;
        int r1 = InteractRecordContainerFragment.o;
        r0.da0(r3, true);
    }

    public final void onTabUnselected(TabLayout.Tab r3) {
        Intrinsics.checkNotNullParameter(r3, "tab");
        if (r3.getText() != null) goto L5;
        return;
    L5:
        InteractRecordContainerFragment r0 = this.a;
        int r1 = InteractRecordContainerFragment.o;
        r0.da0(r3, false);
    }
}
