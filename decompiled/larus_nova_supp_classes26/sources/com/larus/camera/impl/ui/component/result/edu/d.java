package com.larus.camera.impl.ui.component.result.edu;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d extends ViewOutlineProvider {
    public d() {
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r8, Outline r9) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (r9 == null) goto L6;
        r9.setAlpha(1.0f);
    L6:
        if (r9 == null) goto L9;
        r9.setRoundRect(0, 0, r8.getWidth(), r8.getHeight(), c7.c(12));
        return;
    }
}
