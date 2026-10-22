package com.bytedance.android.livesdk.floatview.inner;

import com.bytedance.android.live.core.log.ALogger;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s<T> implements Observer {
    public final /* synthetic */ k a;

    public s(k r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        if ((!Intrinsics.areEqual((Boolean) r2, Boolean.TRUE)) == true) goto L7;
        ALogger.i("VideoWatchingInnerFloatWindowView", "on playComplete");
        this.a.y.onPlayComplete();
        return;
    }
}
