package com.obric.flow.cardlistpage.ui.settings;

import android.graphics.Rect;
import android.view.View;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.orecyclerview.widget.h0;
import com.obric.oui.orecyclerview.widget.u0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11821a;

    @Override // com.obric.oui.orecyclerview.widget.h0
    public final void a(Rect r5, View r10, RecyclerView r11, u0 r12) {
        Intrinsics.checkNotNullParameter(r5, "outRect");
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r11, "parent");
        Intrinsics.checkNotNullParameter(r12, "state");
        if (r11.D(r10) != (r12.b() - 1)) goto L5;
        r5.bottom = this.f11821a;
        return;
    L5:
        r5.bottom = 0;
    }
}
