package com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight;

import android.text.style.ClickableSpan;
import android.view.View;
import com.bytedance.android.livesdk.interactivity.publicscreen.highlight.comp.PSHighlightCommonComp;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class r extends nk6.a {
    public final /* synthetic */ PSHighlightRenderHelper.a a;

    public r(PSHighlightCommonComp.a r1) {
        this.a = r1;
    }

    public final void b(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.a.a(r2);
    }

    public final boolean a(View r2, ek6.c r3, ClickableSpan r4) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "action");
        Intrinsics.checkNotNullParameter(r4, "span");
        boolean r5 = this.a.b(r2, r3);
        if (r5 == true) goto L19;
        tb2.b r0 = null;
        if ((r3 instanceof ib2.a) == true) goto L7;
        r3 = null;
    L7:
        ib2.a r6 = (ib2.a) r3;
        if (r6 == null) goto L10;
        tb2.b r7 = r6.a;
    L12:
        if ((r7 instanceof tb2.e) == false) goto L15;
        r0 = r7;
    L15:
        tb2.e r1 = (tb2.e) r0;
        if (r1 != null) goto L18;
        return r5;
    L18:
        return tb2.f.a(r1);
    L10:
        r7 = null;
        goto L12
    L19:
        return r5;
    }
}
