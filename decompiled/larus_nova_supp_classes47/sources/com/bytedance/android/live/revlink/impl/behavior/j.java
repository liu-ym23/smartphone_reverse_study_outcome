package com.bytedance.android.live.revlink.impl.behavior;

import com.bytedance.android.livesdk.link.model.q4;
import com.bytedance.android.livesdk.revenue.toolbar.BubbleOpenLocalPanel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j {
    public final d a;
    public final k b;

    public final void a(q4 r22) {
        if (r22 != null) goto L4;
        return;
    L4:
        d r1 = this.a;
        String r3 = r22.getBubbleText();
        PkPanelType.a r2 = PkPanelType.Companion;
        Integer r13 = Integer.valueOf(r22.getBubblePanel());
        r2.getClass();
        PkPanelType r4 = PkPanelType.a.a(r13);
        if (r4 != PkPanelType.PK) goto L9;
        BubbleOpenLocalPanel r5 = BubbleOpenLocalPanel.PkPanel;
    L12:
        r1.a(new zr2.e(r3, null, null, 0, null, null, 0, 0, null, 0, r5, null, null, null, 15358));
        return;
    L9:
        if (r4 != PkPanelType.Anchor) goto L11;
        r5 = BubbleOpenLocalPanel.LinkPanel;
        goto L12
    L11:
        r5 = null;
        goto L12
    }

    public j(d r2, k r3) {
        Intrinsics.checkNotNullParameter(r2, "button");
        Intrinsics.checkNotNullParameter(r3, "buttonHelper");
        this.a = r2;
        this.b = r3;
    }
}
