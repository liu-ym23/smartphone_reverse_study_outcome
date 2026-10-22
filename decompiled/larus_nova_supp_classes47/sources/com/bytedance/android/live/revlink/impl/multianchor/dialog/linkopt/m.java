package com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt;

import com.bytedance.android.live.revlink.impl.multianchor.match.MultiPkMatchContext;
import com.bytedance.android.livesdk.link.model.e0;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m<T> implements Consumer {
    public static final m a = null;

    static {
        a = new m();
    }

    public m() {
    }

    public final void accept(Object r8) {
        Boolean r9 = (Boolean) r8;
        MultiPkMatchContext r0 = com.bytedance.android.live.revlink.impl.global.b.G();
        if (r0 == null) goto L20;
        long r1 = ((Number) r0.getCountDownTime().getValue()).longValue();
        com.bytedance.android.livesdk.link.model.b0 r2 = (com.bytedance.android.livesdk.link.model.b0) r0.getSelfAutoMatchInfo().getValue();
        if (r2 == null) goto L7;
        long r3 = e0.a(r2);
    L9:
        if (r9.booleanValue() == true) goto L11;
        return;
    L11:
        if (1 > r1) goto L15;
        if (r3 <= r1) goto L15;
        return;
    L15:
        if ((com.bytedance.android.live.revlink.impl.multianchor.match.m.a() instanceof com.bytedance.android.live.revlink.impl.multianchor.match.c.a) == true) goto L17;
        return;
    L17:
        if (com.bytedance.android.live.revlink.impl.global.b.H() == null) goto L24;
        com.bytedance.android.live.revlink.impl.multianchor.match.f.k();
        return;
    L24:
        return;
    L7:
        r3 = 10;
        goto L9
    }
}
