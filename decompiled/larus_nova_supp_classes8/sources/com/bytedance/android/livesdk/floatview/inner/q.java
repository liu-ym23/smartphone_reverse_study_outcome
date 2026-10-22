package com.bytedance.android.livesdk.floatview.inner;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q<T> implements Observer {
    public final /* synthetic */ k a;

    public q(k r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        Pair r4 = (Pair) r3;
        if (r4 != null) goto L5;
        return;
    L5:
        if (((Number) r4.getFirst()).intValue() != 0) goto L7;
        return;
    L7:
        if (((Number) r4.getSecond()).intValue() == 0) goto L13;
        this.a.y.onVideoSizeChanged(((Number) r4.getFirst()).intValue(), ((Number) r4.getSecond()).intValue());
        return;
    }
}
