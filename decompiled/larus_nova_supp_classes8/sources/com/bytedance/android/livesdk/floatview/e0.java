package com.bytedance.android.livesdk.floatview;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e0<T> implements Observer {
    public final /* synthetic */ VideoFloatWindowView a;

    public e0(VideoFloatWindowView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        String r3 = (String) r2;
        if (r3 == null) goto L7;
        this.a.D.onError(r3);
        return;
    }
}
