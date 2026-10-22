package com.larus.bmhome.video.fragment;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class x extends ViewOutlineProvider {
    public x() {
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r8, Outline r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        Intrinsics.checkNotNullParameter(r9, "outline");
        r9.setRoundRect(0, 0, r8.getWidth(), r8.getHeight(), i5.h());
    }
}
