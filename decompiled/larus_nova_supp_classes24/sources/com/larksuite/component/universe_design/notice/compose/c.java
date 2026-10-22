package com.larksuite.component.universe_design.notice.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import com.larksuite.component.universe_design.compose.foundation.g0;
import com.larksuite.component.universe_design.compose.foundation.i0;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[UDNoticeType.values().length];
            r0[UDNoticeType.Info.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[UDNoticeType.Success.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[UDNoticeType.Warning.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[UDNoticeType.Error.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
    }

    public static b a(UDNoticeType r17, Composer r19, int r110) {
        r19.startReplaceGroup(-365137038);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-365137038, r110, -1, "com.larksuite.component.universe_design.notice.compose.UDNoticeDefaults.colors (UDNotice.kt:179)");
    L5:
        g0 r0 = i0.a(r19);
        int r2 = a.a[r17.ordinal()];
        if (r2 != 1) goto L8;
        Pair r3 = TuplesKt.to(Color.box-impl(r0.d.e.b), Color.box-impl(r0.d.e.a));
    L19:
        long r5 = ((Color) r3.component1()).unbox-impl();
        long r9 = ((Color) r3.component2()).unbox-impl();
        b r4 = new b(r5, r0.b(), r9, r0.c.a.a, r0.a(), r0.a());
        if (ComposerKt.isTraceInProgress() == false) goto L22;
        ComposerKt.traceEventEnd();
    L22:
        r19.endReplaceGroup();
        return r4;
    L8:
        if (r2 != 2) goto L10;
        r3 = TuplesKt.to(Color.box-impl(r0.d.b.b), Color.box-impl(r0.d.b.a));
        goto L19
    L10:
        if (r2 != 3) goto L12;
        r3 = TuplesKt.to(Color.box-impl(r0.d.d.b), Color.box-impl(r0.d.d.a));
        goto L19
    L12:
        if (r2 != 4) goto L15;
        r3 = TuplesKt.to(Color.box-impl(r0.d.c.b), Color.box-impl(r0.d.c.a));
        goto L19
    L15:
        throw new NoWhenBranchMatchedException();
    }
}
