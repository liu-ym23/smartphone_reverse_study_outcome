package com.larus.avlink.env.event;

import com.google.android.material.tabs.TabLayout;
import com.larus.avlink.impl.databinding.LarusActivityDoraMemoryDataBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class o implements TabLayout.OnTabSelectedListener {
    public final /* synthetic */ DoraEnvObserveMemoryDataActivity a;

    public final void onTabReselected(TabLayout.Tab r1) {
    }

    public final void onTabUnselected(TabLayout.Tab r1) {
    }

    public o(DoraEnvObserveMemoryDataActivity r1) {
        this.a = r1;
    }

    public final void onTabSelected(TabLayout.Tab r3) {
        if (r3 == null) goto L8;
        int r4 = r3.getPosition();
        LarusActivityDoraMemoryDataBinding r0 = this.a.g;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L6:
        r0.d.setCurrentItem(r4, true);
        return;
    }
}
