package com.bytedance.android.livesdk.interactivity.like;

import android.graphics.Bitmap;
import com.bytedance.android.live.core.utils.s1;
import io.reactivex.functions.Consumer;
import kotlin.random.Random;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class z<T> implements Consumer {
    public final /* synthetic */ DiggWidget.c a;

    public z(DiggWidget.c r1) {
        this.a = r1;
    }

    public final void accept(Object r6) {
        Long r7 = (Long) r6;
        this.a.e--;
        int r8 = s1.f(Random.Default.nextInt(10, 15));
        DiggWidget r0 = this.a.g;
        int r1 = DiggWidget.M1;
        Bitmap r2 = r0.Qq();
        if (r2 == null) goto L5;
        this.a.d(r2, -r8, 0);
    L5:
        Bitmap r3 = this.a.g.Qq();
        if (r3 == null) goto L9;
        this.a.d(r3, r8, 100);
        return;
    }
}
