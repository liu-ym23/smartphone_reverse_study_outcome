package com.bytedance.android.livesdk.floatview.inner;

import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ k a;
    public final /* synthetic */ long b;

    public l(k r3) {
        this.a = r3;
        this.b = 6;
    }

    public final void accept(Object r9) {
        Long r10 = (Long) r9;
        TextView r0 = this.a.l;
        if (r0 == null) goto L6;
        r0.setText(s1.C(2131916672, new Object[]{Long.valueOf((this.b - r10.longValue()) - 1)}));
    L6:
        if (((this.b - r10.longValue()) - 1) != 0) goto L11;
        com.bytedance.android.livesdk.floatview.e r11 = this.a.v;
        if (r11 == null) goto L12;
        r11.b();
        return;
    L12:
        return;
    }
}
