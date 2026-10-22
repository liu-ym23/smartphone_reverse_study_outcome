package io.noties.markwon.ext.onetex;

import android.graphics.Rect;
import wsc.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class k extends wsc.p {
    public final boolean a;

    public k(boolean r1) {
        this.a = r1;
    }

    @Override // wsc.p
    public final Rect a(a r4) {
        Rect r0 = r4.e.getBounds();
        int r5 = r4.g;
        int r1 = r0.width();
        if (this.a == false) goto L7;
        if (r1 <= r5) goto L7;
        return new Rect(0, 0, r5, (int) ((r5 / (r1 / r0.height())) + 0.5f));
    L7:
        return r0;
    }
}
