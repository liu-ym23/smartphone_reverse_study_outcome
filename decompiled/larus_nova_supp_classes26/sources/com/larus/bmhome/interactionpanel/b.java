package com.larus.bmhome.interactionpanel;

import com.larus.bmhome.clarification.a2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b implements a2 {
    public final /* synthetic */ a a;
    public final /* synthetic */ String b;

    @Override // com.larus.bmhome.clarification.a2
    public final boolean a(m r3) {
        Intrinsics.checkNotNullParameter(r3, "entry");
        return this.a.b.g(r3.a, this.b);
    }

    public b(a r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.larus.bmhome.clarification.a2
    public final void b(m r2, boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "entry");
        Intrinsics.checkNotNullParameter(r4, "reason");
        if (r3 == false) goto L5;
        this.a.b.d(r2.a, this.b, r4);
        return;
    L5:
        this.a.b.b(r2.a, this.b, InteractionPanelSubmitResult.FAILURE);
    }
}
