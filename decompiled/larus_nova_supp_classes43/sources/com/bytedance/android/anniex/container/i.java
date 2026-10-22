package com.bytedance.android.anniex.container;

import android.view.View;
import com.bytedance.android.anniex.container.popup.SheetBaseBehavior;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i implements SheetBaseBehavior.b {
    public final /* synthetic */ d a;

    @Override // com.bytedance.android.anniex.container.popup.SheetBaseBehavior.b
    public final void a(View r1, int r10) {
        Intrinsics.checkNotNullParameter(r1, "bottomSheet");
    }

    public i(d r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.anniex.container.popup.SheetBaseBehavior.b
    public final void b(View r10, float r11) {
        Intrinsics.checkNotNullParameter(r10, "bottomSheet");
        ia.f.a r12 = this.a.b;
        if (r12 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("popupComponent");
        r12 = null;
    L5:
        r12.k(r11);
    }
}
