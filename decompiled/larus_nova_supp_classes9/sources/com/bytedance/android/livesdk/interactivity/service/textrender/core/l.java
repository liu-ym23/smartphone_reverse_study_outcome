package com.bytedance.android.livesdk.interactivity.service.textrender.core;

import java.util.Comparator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l implements Comparator<m> {
    public l() {
    }

    @Override // java.util.Comparator
    public final int compare(m r1, m r2) {
        m r3 = r1;
        m r4 = r2;
        if (r3 == null) goto L7;
        if (r4 == null) goto L7;
        return r3.b - r4.b;
    L7:
        return 0;
    }
}
