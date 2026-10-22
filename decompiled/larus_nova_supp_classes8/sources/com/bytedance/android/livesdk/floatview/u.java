package com.bytedance.android.livesdk.floatview;

import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class u<T> implements Consumer {
    public final /* synthetic */ VideoFloatWindowView a;
    public final /* synthetic */ long b;

    public u(VideoFloatWindowView r3) {
        this.a = r3;
        this.b = 6;
    }

    public final void accept(Object r7) {
        Long r8 = (Long) r7;
        ((TextView) this.a.a(2131372946)).setText(s1.C(2131916672, new Object[]{Long.valueOf((this.b - r8.longValue()) - 1)}));
        if (((this.b - r8.longValue()) - 1) != 0) goto L8;
        e r9 = this.a.b;
        if (r9 == null) goto L9;
        r9.b();
        return;
    L9:
        return;
    }
}
