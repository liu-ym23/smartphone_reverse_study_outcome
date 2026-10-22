package p22;

import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingArea;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingFont;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g extends f<a> {
    public final a d;
    public final boolean e;

    public final class a extends e {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;

        public a(int r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
        }
    }

    public g(BarrageSettingArea r33, BarrageSettingFont r34, float r35, boolean r36) {
        Intrinsics.checkNotNullParameter(r33, "barrageArea");
        Intrinsics.checkNotNullParameter(r34, "barrageFont");
        super(r33, r34, r35);
        this.e = r36;
        int r1 = h.a[r34.ordinal()];
        if (r1 != 1) goto L5;
        int r24 = m.a(32.0f);
        int r25 = m.a(32.0f);
        int r26 = m.a(30.0f);
        int r27 = m.a(18.0f);
        int r28 = m.a(14.0f);
        int r29 = m.a(22.0f);
        int r30 = m.a(14.0f);
        int r31 = m.a(12.0f);
        m.a(20.0f);
        a r2 = new a(r24, r25, r26, r27, r28, r29, r30, r31);
    L15:
        this.d = r2;
        return;
    L5:
        if (r1 != 2) goto L7;
        int r15 = m.a(28.0f);
        int r16 = m.a(28.0f);
        int r17 = m.a(24.0f);
        int r18 = m.a(14.0f);
        int r19 = m.a(12.0f);
        int r20 = m.a(18.0f);
        int r21 = m.a(12.0f);
        int r23 = m.a(10.0f);
        m.a(16.0f);
        r2 = new a(r15, r16, r17, r18, r19, r20, r21, r23);
        goto L15
    L7:
        if (r1 != 3) goto L9;
        int r3 = m.a(24.0f);
        int r7 = m.a(24.0f);
        int r8 = m.a(18.0f);
        int r9 = m.a(10.0f);
        int r13 = m.a(10.0f);
        int r14 = m.a(14.0f);
        int r10 = m.a(10.0f);
        int r11 = m.a(8.0f);
        m.a(12.0f);
        r2 = new a(r3, r7, r8, r9, r13, r14, r10, r11);
        goto L15
    L9:
        if (r1 == 4) goto L11;
        int r110 = m.a(28.0f);
        int r111 = m.a(28.0f);
        int r112 = m.a(24.0f);
        int r113 = m.a(14.0f);
        int r114 = m.a(12.0f);
        int r115 = m.a(18.0f);
        int r116 = m.a(12.0f);
        int r210 = m.a(10.0f);
        m.a(16.0f);
        r2 = new a(r110, r111, r112, r113, r114, r115, r116, r210);
        goto L15
    L11:
        int r211 = m.a(20.0f);
        int r212 = m.a(20.0f);
        int r213 = m.a(18.0f);
        int r214 = m.a(14.0f);
        int r215 = m.a(10.0f);
        int r216 = m.a(14.0f);
        int r217 = m.a(10.0f);
        int r218 = m.a(8.0f);
        m.a(15.0f);
        r2 = new a(r211, r212, r213, r214, r215, r216, r217, r218);
        goto L15
    }
}
