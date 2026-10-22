package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g0 extends a {
    public boolean b;
    public boolean c;

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void attach() {
        this.b = true;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void detach() {
        this.b = false;
    }

    public g0() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a, com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final h.a b(List<ch0.e> r4) {
        Intrinsics.checkNotNullParameter(r4, "oldMergeDataList");
        return new h.a(true, r4, null);
    }

    public final void d(boolean r4, ILinkPlayerInfoBridge r5) {
        if (this.b == true) goto L5;
        return;
    L5:
        boolean r1 = false;
        if (this.c == r4) goto L12;
        this.c = r4;
        if (r4 == false) goto L10;
        a().Y0(new ch0.k(r5, true));
    L11:
        r1 = true;
        goto L12
    L10:
        a().Y0(new ch0.k(null, false));
    L12:
        if (r1 == false) goto L15;
        c();
        return;
    }
}
