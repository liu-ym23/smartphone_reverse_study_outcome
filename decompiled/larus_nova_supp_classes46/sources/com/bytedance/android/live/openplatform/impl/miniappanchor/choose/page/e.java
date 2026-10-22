package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page;

import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements TabLayout.OnTabSelectedListener {
    public final /* synthetic */ MiniAppChooseContainerFragment a;

    public final void onTabReselected(TabLayout.Tab r1) {
    }

    public final void onTabUnselected(TabLayout.Tab r1) {
    }

    public e(MiniAppChooseContainerFragment r1) {
        this.a = r1;
    }

    public final void onTabSelected(TabLayout.Tab r4) {
        if (r4 == null) goto L19;
        Integer r0 = Integer.valueOf(r4.getPosition());
        if (r0.intValue() == this.a.p) goto L6;
        boolean r1 = true;
    L7:
        if (r1 == true) goto L10;
        r0 = null;
    L10:
        if (r0 == null) goto L15;
        int r2 = r0.intValue();
        if (r2 != 0) goto L14;
        this.a.U90();
    L14:
        this.a.p = r2;
    L15:
        Iterator r3 = ((ArrayList) this.a.h).iterator();
    L17:
        if (r3.hasNext() == false) goto L21;
        ((c) r3.next()).MX(r4.getPosition());
        goto L17
    L21:
        return;
    L6:
        r1 = false;
        goto L7
    }
}
