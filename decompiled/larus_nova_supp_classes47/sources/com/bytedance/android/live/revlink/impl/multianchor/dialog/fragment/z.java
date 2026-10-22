package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class z implements View.OnClickListener {
    public final /* synthetic */ InteractRecordContainerFragment a;
    public final /* synthetic */ ViewGroup b;

    public z(InteractRecordContainerFragment r1, ViewGroup r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        TabLayout r3 = this.b.findViewById(2131387986);
        if (r3 == null) goto L7;
        TabLayout.Tab r4 = r3.getTabAt(1);
        if (r4 == null) goto L7;
        r4.select();
    L7:
        InteractRecordContainerFragment.ca0(this.a, 1);
    }
}
