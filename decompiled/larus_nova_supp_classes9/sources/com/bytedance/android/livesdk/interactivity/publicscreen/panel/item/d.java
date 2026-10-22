package com.bytedance.android.livesdk.interactivity.publicscreen.panel.item;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.AudiencePanelItemSymbol;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.l;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.v;
import com.bytedance.live.datacontext.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d extends b {
    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.panel.item.b
    public final int c() {
        return 2131565176;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.k
    public final boolean canShow() {
        return true;
    }

    public d() {
        super(AudiencePanelItemSymbol.MORE);
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.panel.item.b, com.bytedance.android.livesdk.interactivity.api.publicscreen.api.k
    public final void onClick(View r2) {
        super.onClick(r2);
        v r3 = this.d;
        if (r3 == null) goto L5;
        r3.l20(true);
    L5:
        com.bytedance.android.livesdk.interactivity.api.h r4 = com.bytedance.android.livesdk.interactivity.api.i.b(null, 3);
        if (r4 == null) goto L13;
        j<l> r5 = r4.getAudienceOperateManager();
        if (r5 == null) goto L14;
        l r6 = (l) r5.getValue();
        if (r6 == null) goto L15;
        r6.c();
        return;
    L15:
        return;
    L14:
        return;
    }
}
