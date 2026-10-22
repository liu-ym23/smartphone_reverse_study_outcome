package com.bytedance.android.livesdk.floatview;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c0<T> implements Observer {
    public final /* synthetic */ VideoFloatWindowView a;

    public c0(VideoFloatWindowView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        Pair r4 = (Pair) r3;
        if (r4 != null) goto L5;
        return;
    L5:
        if (((Number) r4.getFirst()).intValue() == 0) goto L10;
        VideoFloatWindowView.c r0 = this.a.D;
        int r1 = ((Number) r4.getFirst()).intValue();
        Object r5 = r4.getSecond();
        Intrinsics.checkNotNull(r5);
        r0.onVideoSizeChanged(r1, ((Number) r5).intValue());
        return;
    }
}
