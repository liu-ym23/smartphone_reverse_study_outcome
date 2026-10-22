package p22;

import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingArea;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingFont;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p extends f<a> {
    public int[] d;
    public final a e;

    public final class a extends e {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;

        public a(int r1, int r2, int r3, int r4, int r5, int r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    public final void a(int r4, boolean r5) {
        if (r5 == false) goto L6;
        this.d = new int[]{0, 1};
        return;
    L6:
        if (r4 >= 4) goto L8;
        int[] r6 = {0, RangesKt.coerceAtMost(2, r4 - 1)};
    L9:
        this.d = r6;
        return;
    L8:
        r6 = new int[]{1, RangesKt.coerceAtMost(3, r4 - 1)};
        goto L9
    }

    public p(BarrageSettingArea r23, BarrageSettingFont r24, float r25) {
        super(r23, r24, r25);
        this.d = new int[0];
        if (r24 == null) goto L11;
        int r6 = q.a[r24.ordinal()];
        if (r6 != 1) goto L8;
        a r7 = new a(m.a(20.0f), m.a(30.0f), m.a(28.0f), m.a(24.0f), m.a(10.0f), m.a(32.0f));
    L15:
        this.e = r7;
        return;
    L8:
        if (r6 != 2) goto L10;
        r7 = new a(m.a(16.0f), m.a(24.0f), m.a(20.0f), m.a(18.0f), m.a(10.0f), m.a(24.0f));
        goto L15
    L10:
        if (r6 != 3) goto L11;
        int r16 = m.a(12.0f);
        int r17 = m.a(18.0f);
        int r18 = m.a(17.0f);
        int r20 = m.a(8.0f);
        r7 = new a(r16, r17, r18, m.a(15.0f), r20, m.a(21.0f));
    L11:
        int r9 = m.a(16.0f);
        int r10 = m.a(24.0f);
        int r11 = m.a(20.0f);
        int r13 = m.a(10.0f);
        r7 = new a(r9, r10, r11, m.a(18.0f), r13, m.a(24.0f));
        goto L15
    }
}
