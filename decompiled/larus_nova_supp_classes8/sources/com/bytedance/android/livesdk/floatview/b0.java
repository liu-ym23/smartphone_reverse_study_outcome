package com.bytedance.android.livesdk.floatview;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b0<T> implements Observer {
    public final /* synthetic */ VideoFloatWindowView a;

    public b0(VideoFloatWindowView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        String r3 = (String) r2;
        this.a.D.getClass();
        com.bytedance.android.livesdk.floatview.mob.b r0 = this.a.n;
        if (r0 == null) goto L6;
        r0.n = r3;
        return;
    }
}
