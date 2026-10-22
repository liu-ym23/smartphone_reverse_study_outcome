package com.obric.miniapp.lynx;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class p1 extends ViewOutlineProvider {
    public final /* synthetic */ int a;

    public p1(int r1) {
        this.a = r1;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r8, Outline r9) {
        Intrinsics.checkNotNullParameter(r8, "target");
        Intrinsics.checkNotNullParameter(r9, "outline");
        r9.setRoundRect(0, 0, r8.getWidth(), r8.getHeight(), this.a);
    }
}
