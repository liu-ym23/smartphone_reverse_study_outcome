package com.bytedance.android.livesdk.feedback.view.preview;

import android.animation.ObjectAnimator;
import com.bytedance.android.live.core.widget.HSImageView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q<T> implements Observer {
    public final /* synthetic */ n a;

    public q(n r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        if ((!Intrinsics.areEqual((Boolean) r4, Boolean.TRUE)) == true) goto L7;
        HSImageView r5 = this.a.c;
        ObjectAnimator r0 = ObjectAnimator.ofFloat(r5, "alpha", new float[]{1.0f, 0.0f});
        r0.setDuration(200);
        r0.addListener(new p(r5));
        r0.start();
        return;
    }
}
