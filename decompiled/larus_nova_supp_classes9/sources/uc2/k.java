package uc2;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k {
    public ArrayList<Integer> a;
    public final ArrayList<c> b;
    public final int[] c;
    public final int d;
    public final int[] e;

    public static final class a {
    }

    static {
    }

    public k(q72.a r4) {
        Intrinsics.checkNotNullParameter(r4, "initialConfig");
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = new int[]{3, 9};
        this.d = RangesKt.random(new IntRange(18, 36), Random.Default);
        this.e = new int[]{3, 9, 0, 6, 2, 4, 8, 10, 1, 5, 7, 11};
        int r0 = 0;
    L3:
        if (r0 >= 12) goto L5;
        this.b.add(new i(r0));
        r0 = r0 + 1;
        goto L3
    }

    public final void a(int r2, com.bytedance.android.livesdk.interactivity.zdanmaku.i r3) {
        Intrinsics.checkNotNullParameter(r3, "danmaku");
        Object r4 = ListProtector.get(this.b, r2);
        if (r4 == null) goto L7;
        ((i) r4).e.remove(r3);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.zdanmaku.layout.danmakuline.LiveRadiusDanmakuLine");
    }
}
