package p22;

import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingArea;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingFont;
import com.bytedance.mt.protector.impl.color.ColorProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k extends f<b> {
    public static final int h = 0;
    public static final int i = 0;
    public static final int j = 0;
    public static final int k = 0;
    public static final int l = 0;
    public static final int m = 0;
    public final b d;
    public int[] e;
    public final int f;
    public final int g;

    public static final class a {
    }

    public final class b extends e {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final int i;
        public final int j;
        public final int k;
        public final int l;
        public final int m;
        public final int n;

        public b(int r7, int r8, int r9, int r10, int r11, int r13, int r14) {
            int r0 = k.k;
            int r1 = k.l;
            int r3 = m.a(16.0f);
            int r4 = k.i;
            int r5 = k.j;
            m.a(16.0f);
            int r2 = k.h;
            this.a = r7;
            this.b = r8;
            this.c = r9;
            this.d = r10;
            this.e = r11;
            this.f = r13;
            this.g = r14;
            this.h = r0;
            this.i = r1;
            this.j = r3;
            this.k = r4;
            this.l = r5;
            this.m = -1;
            this.n = r2;
        }
    }

    static {
        h = ColorProtector.parseColor("#80000000");
        i = ColorProtector.parseColor("#D1F4FF");
        j = ColorProtector.parseColor("#8000315E");
        k = ColorProtector.parseColor("#FFE8AE");
        l = ColorProtector.parseColor("#802F1600");
        m = m.a(24.0f);
    }

    public final void a(int r7) {
        int r8 = r7 - 1;
        if (this.a != BarrageSettingArea.FULL) goto L5;
        int r2 = r8 / 2;
        int[] r1 = {r2 - 1, r2};
    L6:
        this.e = r1;
        if (r8 > 0) goto L10;
        this.e = new int[]{0, 0};
        return;
    L10:
        return;
    L5:
        r1 = new int[]{r8 - 1, r8};
        goto L6
    }

    public k(BarrageSettingArea r28, BarrageSettingFont r29, float r30) {
        super(r28, r29, r30);
        if (r29 == null) goto L11;
        int r8 = l.a[r29.ordinal()];
        if (r8 != 1) goto L8;
        m.a(32.0f);
        int r18 = m.a(20.0f);
        int r19 = m.a(30.0f);
        int r20 = m.a(14.0f);
        int r21 = m.a(20.0f);
        int r23 = m.a(30.0f);
        int r24 = m.a(130.0f);
        int r25 = m.a(100.0f);
        m.a(50.0f);
        b r9 = new b(r18, r19, r20, r21, r23, r24, r25);
    L15:
        this.d = r9;
        this.e = new int[0];
        this.f = m.a(200.0f);
        m.a(140.0f);
        this.g = m.a(100.0f);
        m.a(40.0f);
        return;
    L8:
        if (r8 != 2) goto L10;
        m.a(28.0f);
        int r10 = m.a(16.0f);
        int r11 = m.a(24.0f);
        int r13 = m.a(13.0f);
        int r14 = m.a(16.0f);
        int r15 = m.a(24.0f);
        int r16 = m.a(100.0f);
        int r17 = m.a(75.0f);
        m.a(45.0f);
        r9 = new b(r10, r11, r13, r14, r15, r16, r17);
        goto L15
    L10:
        if (r8 != 3) goto L11;
        m.a(24.0f);
        int r26 = m.a(12.0f);
        int r27 = m.a(19.0f);
        int r210 = m.a(12.0f);
        int r211 = m.a(12.0f);
        int r212 = m.a(19.0f);
        int r213 = m.a(70.0f);
        int r214 = m.a(50.0f);
        m.a(40.0f);
        r9 = new b(r26, r27, r210, r211, r212, r213, r214);
    L11:
        m.a(28.0f);
        int r110 = m.a(16.0f);
        int r111 = m.a(24.0f);
        int r112 = m.a(13.0f);
        int r113 = m.a(16.0f);
        int r114 = m.a(24.0f);
        int r115 = m.a(100.0f);
        int r116 = m.a(75.0f);
        m.a(40.0f);
        r9 = new b(r110, r111, r112, r113, r114, r115, r116);
        goto L15
    }
}
