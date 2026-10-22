package com.bytedance.android.livesdk.floatview;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class z<T> implements Observer {
    public final /* synthetic */ VideoFloatWindowView a;

    public z(VideoFloatWindowView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r1) {
        Boolean r2 = (Boolean) r1;
        if (r2 != null) goto L6;
        return;
    L6:
        if (r2.booleanValue() == false) goto L9;
        this.a.D.onPlayDisplayed();
        return;
    }
}
