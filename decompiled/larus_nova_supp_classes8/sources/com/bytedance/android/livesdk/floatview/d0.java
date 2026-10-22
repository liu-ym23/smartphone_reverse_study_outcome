package com.bytedance.android.livesdk.floatview;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d0<T> implements Observer {
    public final /* synthetic */ VideoFloatWindowView a;

    public d0(VideoFloatWindowView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        Boolean r3 = (Boolean) r2;
        if (r3 == null) goto L7;
        this.a.D.onMute(r3.booleanValue());
        return;
    }
}
