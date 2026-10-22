package com.bytedance.android.live.profile.ui.component.view;

import ak6.e;
import ak6.g;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements e {
    public final /* synthetic */ ProfileBadgeSuffixView a;
    public final /* synthetic */ int b;

    public final void a(g r2) {
        Intrinsics.checkNotNullParameter(r2, "rendResult");
        Intrinsics.checkNotNullParameter(r2, "rendResult");
    }

    public final void b(g r2) {
        Intrinsics.checkNotNullParameter(r2, "rendResult");
        this.a.c.setText(r2.a);
        int r3 = this.b;
        if (r3 <= 0) goto L6;
        int r4 = UtilityKotlinExtentionsKt.i(r3);
        a1.k(this.a.a, r4);
        a1.k(this.a.c, r4);
        this.a.a.setVisibility(0);
        this.a.c.setVisibility(0);
        return;
    }

    public b(ProfileBadgeSuffixView r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
