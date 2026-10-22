package com.larus.dora.o.impl.memory;

import com.larus.dora.o.impl.databinding.DoraOActivityMemoryDataBinding;
import com.obric.oui.tab.OTabLayoutBase;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c implements OTabLayoutBase.e {
    public final /* synthetic */ ODoraMemoryDataActivity a;
    public final /* synthetic */ DoraOActivityMemoryDataBinding b;

    public final void a(OTabLayoutBase.i r2) {
        Intrinsics.checkNotNullParameter(r2, "t");
    }

    public final void b(OTabLayoutBase.i r2) {
        Intrinsics.checkNotNullParameter(r2, "t");
    }

    public final void c(OTabLayoutBase.i r3) {
        Intrinsics.checkNotNullParameter(r3, "t");
        if (this.a.h == false) goto L5;
        return;
    L5:
        this.b.d.setCurrentItem(r3.d, true);
    }

    public c(ODoraMemoryDataActivity r1, DoraOActivityMemoryDataBinding r2) {
        this.a = r1;
        this.b = r2;
    }
}
