package com.larksuite.component.universe_design.menu;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public final View a;
    public final View b;
    public final int c;
    public final PositionAlign d;
    public final float e;

    public b(View r2, View r3, int r4, PositionAlign r5, float r6) {
        Intrinsics.checkNotNullParameter(r2, "uiView");
        Intrinsics.checkNotNullParameter(r3, "anchorView");
        Intrinsics.checkNotNullParameter(r5, "anchorAlign");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
