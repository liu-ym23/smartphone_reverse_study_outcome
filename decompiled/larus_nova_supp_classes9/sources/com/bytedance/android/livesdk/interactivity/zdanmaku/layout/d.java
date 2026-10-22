package com.bytedance.android.livesdk.interactivity.zdanmaku.layout;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import java.util.Comparator;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements Comparator<Integer> {
    public int a;
    public int b;
    public final float c;
    public final /* synthetic */ e d;
    public final /* synthetic */ f e;

    public d(e r1, f r2) {
        this.d = r1;
        this.e = r2;
        this.c = UtilityKotlinExtentionsKt.h(6);
    }

    @Override // java.util.Comparator
    public final int compare(Integer r6, Integer r7) {
        int r8 = r6.intValue();
        int r9 = r7.intValue();
        float r0 = this.d.b.b(r8);
        float r1 = this.d.b.b(r9);
        float r2 = this.a - this.c;
        if (r0 >= r2) goto L6;
        r0 = 0.0f;
    L6:
        if (r1 >= r2) goto L9;
        r1 = 0.0f;
    L9:
        if (r0 != r1) goto L16;
        int r3 = this.e.a(r8, this.b);
        int r4 = this.e.a(r9, this.b);
        if (r3 != r4) goto L15;
        return MathKt.getSign(r8 - r9);
    L15:
        return MathKt.getSign(r4 - r3);
    L16:
        return MathKt.getSign((int) (r0 - r1));
    }
}
