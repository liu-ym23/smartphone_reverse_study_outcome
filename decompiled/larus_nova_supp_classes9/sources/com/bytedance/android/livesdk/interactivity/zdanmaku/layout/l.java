package com.bytedance.android.livesdk.interactivity.zdanmaku.layout;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import java.util.Comparator;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l implements Comparator<Integer> {
    public final /* synthetic */ m a;
    public final /* synthetic */ f b;

    public l(m r1, f r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.util.Comparator
    public final int compare(Integer r8, Integer r9) {
        int r10 = r8.intValue();
        int r11 = r9.intValue();
        float r0 = this.a.b.b(r10);
        float r1 = this.a.b.b(r11);
        float r3 = 0;
        float r4 = 6;
        if (r0 >= (r3 - UtilityKotlinExtentionsKt.h(r4))) goto L6;
        r0 = 0.0f;
    L6:
        if (r1 >= (r3 - UtilityKotlinExtentionsKt.h(r4))) goto L9;
        r1 = 0.0f;
    L9:
        if (r0 != r1) goto L16;
        int r2 = this.b.a(r10, 0);
        int r5 = this.b.a(r11, 0);
        if (r2 != r5) goto L15;
        return MathKt.getSign(r10 - r11);
    L15:
        return MathKt.getSign(r5 - r2);
    L16:
        return MathKt.getSign((int) (r0 - r1));
    }
}
