package com.bytedance.android.livesdk.floatview;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f0<T> implements Observer {
    public final /* synthetic */ VideoFloatWindowView a;

    public f0(VideoFloatWindowView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        if ((!Intrinsics.areEqual((Boolean) r2, Boolean.TRUE)) == true) goto L7;
        this.a.D.onPlayComplete();
        return;
    }
}
