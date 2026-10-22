package com.bytedance.android.anniex.container;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.annie.business.container.AnnieXLiveCard;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class n extends AnnieXContainer implements ia.i {
    @Override // ia.b, ia.c
    public final void onCreate(Bundle r1) {
    }

    public n(com.bytedance.android.anniex.base.builder.d r10) {
        Intrinsics.checkNotNullParameter(r10, "builder");
        super(r10);
    }

    public final void q(ViewGroup r10) {
        setRootView(r10);
        if (r10 != null) goto L5;
        r10 = new FrameLayout(getContext());
    L5:
        setParentViewGroup(r10);
        initUi();
    }

    public final void r(AnnieXLiveCard.a r10) {
        Intrinsics.checkNotNullParameter(r10, "viewComponent");
        super.setUiComponent(r10);
    }
}
