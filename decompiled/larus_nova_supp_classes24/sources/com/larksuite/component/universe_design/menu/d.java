package com.larksuite.component.universe_design.menu;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.larksuite.component.universe_design.dimension.UDDimension;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d implements c.g {
    public final /* synthetic */ View a;
    public final /* synthetic */ c.e b;

    @Override // com.larksuite.component.universe_design.menu.c.g
    public final ViewGroup create(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        int r1 = h.a;
        View r2 = this.a;
        c.e r3 = this.b;
        UDDimension r4 = r3.h;
        UDDimension r5 = r3.i;
        UDDimension r6 = r3.j;
        UDDimension r7 = r3.k;
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r2, "customView");
        Intrinsics.checkNotNullParameter(r4, "leftPadding");
        Intrinsics.checkNotNullParameter(r5, "topPadding");
        Intrinsics.checkNotNullParameter(r6, "rightPadding");
        Intrinsics.checkNotNullParameter(r7, "bottomPadding");
        FrameLayout r0 = new FrameLayout(r9);
        r0.setBackground(ContextCompat.getDrawable(r9, 2131256312));
        r0.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        r0.setPadding((int) r4.toPixels(r9), (int) r5.toPixels(r9), (int) r6.toPixels(r9), (int) r7.toPixels(r9));
        r0.addView(r2);
        return r0;
    }

    public d(View r1, c.e r2) {
        this.a = r1;
        this.b = r2;
    }
}
