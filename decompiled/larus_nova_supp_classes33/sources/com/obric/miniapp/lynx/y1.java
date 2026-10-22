package com.obric.miniapp.lynx;

import com.obric.oui.segmentedtab.OTabSegmentedLayout;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class y1 implements OTabSegmentedLayout.e {
    public final /* synthetic */ LynxOUIButtonGroupUI a;

    public final void a() {
    }

    public y1(LynxOUIButtonGroupUI r1) {
        this.a = r1;
    }

    public final void onSelect(int r3) {
        LynxOUIButtonGroupUI r0 = this.a;
        r0.e = r3;
        if (r0.p == true) goto L6;
        r0.M(r3, (String) CollectionsKt.getOrNull(r0.d, r3));
        return;
    }
}
