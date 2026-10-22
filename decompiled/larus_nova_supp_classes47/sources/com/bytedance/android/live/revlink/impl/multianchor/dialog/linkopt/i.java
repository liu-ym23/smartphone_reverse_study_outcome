package com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt;

import com.bytedance.android.live.revlink.impl.multianchor.match.MultiPkMatchContext;
import com.bytedance.android.live.revlink.impl.multianchor.ui.MultiAnchorRandomView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ MultiAnchorLinkUserInviteDialog a;

    public i(MultiAnchorLinkUserInviteDialog r1) {
        this.a = r1;
    }

    public final void accept(Object r6) {
        Long r7 = (Long) r6;
        if (r7.longValue() < 0) goto L15;
        MultiAnchorRandomView r0 = (MultiAnchorRandomView) this.a.S90(2131362584);
        if (r0 == null) goto L14;
        this.a.getClass();
        MultiPkMatchContext r1 = com.bytedance.android.live.revlink.impl.global.b.G();
        if (r1 == null) goto L11;
        com.bytedance.android.livesdk.link.model.b0 r2 = r1.currentAutoMatchInfo();
        if (r2 == null) goto L11;
    L12:
        r0.Y5(r7.longValue(), r2);
        return;
    L11:
        r2 = (com.bytedance.android.livesdk.link.model.b0) vh7.f.c(Object.class);
        goto L12
    L14:
        return;
    }
}
