package com.bytedance.android.livesdk.floatview.inner;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p<T> implements Observer {
    public final /* synthetic */ k a;

    public p(k r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        String r3 = (String) r2;
        if (r3 == null) goto L10;
        this.a.y.getClass();
        com.bytedance.android.livesdk.floatview.mob.b r0 = this.a.w;
        if (r0 == null) goto L9;
        r0.n = r3;
        return;
    L9:
        return;
    }
}
