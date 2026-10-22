package com.larus.share.impl.view;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class i0 extends ViewOutlineProvider {
    public i0() {
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r3, Outline r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "outline");
        r4.setOval(0, 0, r3.getWidth(), r3.getHeight());
    }
}
