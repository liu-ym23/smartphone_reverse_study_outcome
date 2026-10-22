package com.larus.uaigc.createpage.utils;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.utils.e1;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class p {
    public static final void a(ConstraintLayout r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        View r0 = IAIChatUgcAIGCService.a.K(r5.getContext());
        r0.setId(2131387057);
        ConstraintLayout.LayoutParams r2 = new ConstraintLayout.LayoutParams(-1, 0);
        ((ViewGroup.MarginLayoutParams) r2).bottomMargin = i5.h();
        r0.setLayoutParams(r2);
        e1.o(r0);
        r5.addView(r0);
        ConstraintSet r1 = new ConstraintSet();
        r1.clone(r5);
        r1.connect(2131387057, 4, 2131365537, 4);
        r1.applyTo(r5);
    }
}
