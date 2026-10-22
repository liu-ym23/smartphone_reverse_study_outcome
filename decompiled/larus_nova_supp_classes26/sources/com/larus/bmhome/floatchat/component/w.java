package com.larus.bmhome.floatchat.component;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class w extends ViewOutlineProvider {
    public final /* synthetic */ View a;

    public w(View r1) {
        this.a = r1;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r9, Outline r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        Intrinsics.checkNotNullParameter(r10, "outline");
        float r7 = this.a.getContext().getResources().getDimension(v19.c.b(2130971299, this.a.getContext(), 2131166968));
        r10.setRoundRect(0, 0, r9.getWidth(), r9.getHeight() + ((int) r7), r7);
    }
}
