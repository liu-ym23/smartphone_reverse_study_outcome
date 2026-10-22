package com.bytedance.android.livesdk.feedback.view.preview;

import android.view.ViewGroup;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s<T> implements Observer {
    public final /* synthetic */ n a;

    public s(n r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        Pair r4 = (Pair) r3;
        if (r4 == null) goto L12;
        int r0 = ((Number) r4.component1()).intValue();
        int r5 = ((Number) r4.component2()).intValue();
        if (1 > r5) goto L13;
        if (r0 <= r5) goto L11;
        float r6 = r5 / r0;
        int r1 = this.a.e.getWidth();
        float r2 = r1 * r6;
        ViewGroup.LayoutParams r7 = this.a.e.getLayoutParams();
        r7.width = r1;
        r7.height = (int) r2;
        this.a.e.setLayoutParams(r7);
        return;
    L11:
        return;
    L13:
        return;
    }
}
