package com.larksuite.component.universe_design.menu.compose;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.Dp;
import com.larksuite.component.universe_design.compose.foundation.b0;
import com.larksuite.component.universe_design.compose.foundation.g0;
import com.larksuite.component.universe_design.compose.foundation.h0;
import com.larksuite.component.universe_design.compose.foundation.i0;
import com.larksuite.component.universe_design.compose.foundation.n;
import com.larksuite.component.universe_design.compose.foundation.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public static final PaddingValues a = null;
    public static final PaddingValues b = null;
    public static final float c = 0.0f;

    static {
        float r0 = 4;
        a = PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(r0));
        b = PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(16));
        c = Dp.constructor-impl(r0);
    }

    public static a a(Composer r29) {
        r29.startReplaceGroup(1798255843);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1798255843, 6, -1, "com.larksuite.component.universe_design.menu.compose.UDMenuDefaults.colors (UDMenu.kt:122)");
    L5:
        g0 r0 = i0.a(r29);
        h0 r2 = r0.d;
        long r3 = r2.h.b;
        long r5 = r2.g.b;
        n r4 = r0.b.a;
        long r7 = r4.b;
        long r9 = r4.a;
        long r11 = r0.b();
        h0 r6 = r0.d;
        b0 r13 = r6.f;
        long r14 = r13.c;
        o r1 = r0.a.d;
        a r25 = new a(r3, r5, r7, r9, r11, r14, r1.j, r13.d, r1.g, r6.g.a, r0.a());
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        r29.endReplaceGroup();
        return r25;
    }
}
