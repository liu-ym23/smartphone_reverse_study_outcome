package p22;

import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingArea;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingFont;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends f<C0259a> {
    public final C0259a d;

    /* JADX INFO: renamed from: p22.a$a, reason: collision with other inner class name */
    public final class C0259a extends e {
        public final int a;
        public final int b;
        public final int c;

        public C0259a(int r1, int r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public a(BarrageSettingArea r4, BarrageSettingFont r5, float r6) {
        super(r4, r5, r6);
        if (r5 == null) goto L13;
        int r7 = b.a[r5.ordinal()];
        if (r7 != 1) goto L8;
        C0259a r8 = new C0259a(m.a(20.0f), m.a(27.5f), m.a(46.0f));
    L18:
        this.d = r8;
        return;
    L8:
        if (r7 != 2) goto L10;
        r8 = new C0259a(m.a(16.0f), m.a(24.0f), m.a(42.0f));
        goto L18
    L10:
        if (r7 != 3) goto L12;
        r8 = new C0259a(m.a(12.0f), m.a(18.0f), m.a(29.0f));
        goto L18
    L12:
        if (r7 != 4) goto L13;
        r8 = new C0259a(m.a(16.0f), m.a(20.0f), m.a(38.0f));
    L13:
        r8 = new C0259a(m.a(16.0f), m.a(24.0f), m.a(42.0f));
        goto L18
    }
}
