package p22;

import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingArea;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingFont;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends f<a> {
    public final a d;

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

    public c(BarrageSettingArea r18, BarrageSettingFont r19, float r20) {
        Intrinsics.checkNotNullParameter(r18, "barrageArea");
        Intrinsics.checkNotNullParameter(r19, "barrageFont");
        super(r18, r19, r20);
        int r0 = d.a[r19.ordinal()];
        if (r0 != 1) goto L5;
        m.a(32.0f);
        a r1 = new a(m.a(32.0f), m.a(60.0f), m.a(32.0f), m.a(20.0f), m.a(26.0f), m.a(22.0f));
    L15:
        this.d = r1;
        return;
    L5:
        if (r0 != 2) goto L7;
        m.a(28.0f);
        r1 = new a(m.a(28.0f), m.a(52.5f), m.a(28.0f), m.a(17.5f), m.a(24.0f), m.a(14.0f));
        goto L15
    L7:
        if (r0 != 3) goto L9;
        m.a(24.0f);
        r1 = new a(m.a(21.0f), m.a(40.5f), m.a(21.0f), m.a(13.5f), m.a(18.0f), m.a(12.0f));
        goto L15
    L9:
        if (r0 == 4) goto L11;
        m.a(28.0f);
        r1 = new a(m.a(28.0f), m.a(52.5f), m.a(28.0f), m.a(17.5f), m.a(24.0f), m.a(14.0f));
        goto L15
    L11:
        m.a(20.0f);
        r1 = new a(m.a(20.0f), m.a(37.5f), m.a(20.0f), m.a(12.5f), m.a(18.0f), m.a(14.0f));
        goto L15
    }
}
