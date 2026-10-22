package com.bytedance.android.livesdk.floatview.inner;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r<T> implements Observer {
    public final /* synthetic */ k a;

    public r(k r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        String r3 = (String) r2;
        if (r3 == null) goto L7;
        this.a.y.onError(r3);
        return;
    }
}
