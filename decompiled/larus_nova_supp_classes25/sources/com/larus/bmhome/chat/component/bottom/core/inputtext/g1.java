package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g1 extends ViewOutlineProvider {
    public g1() {
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r8, Outline r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        Intrinsics.checkNotNullParameter(r9, "outline");
        int r0 = l1.a(r8.getContext());
        r9.setRoundRect(0, 0, r8.getWidth(), r8.getHeight() + r0, r0);
    }
}
