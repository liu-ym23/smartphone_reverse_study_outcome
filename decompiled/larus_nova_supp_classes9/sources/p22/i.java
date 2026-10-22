package p22;

import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingArea;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingFont;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i extends f<a> {
    public final a d;

    public final class a extends e {
        public final int a;
        public final int b;
        public final String[] c;
        public final String[] d;

        public a(int r2, int r3, String[] r4, String[] r5) {
            Intrinsics.checkNotNullParameter(r4, "textColorArr");
            Intrinsics.checkNotNullParameter(r5, "textStrokeColorArr");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public i(BarrageSettingArea r4, BarrageSettingFont r5, float r6) {
        super(r4, r5, r6);
        if (r5 == null) goto L13;
        int r7 = j.a[r5.ordinal()];
        if (r7 != 1) goto L8;
        a r8 = new a(m.a(20.0f), m.a(32.0f), new String[]{"#ffffff"}, new String[]{"#e6000000"});
    L18:
        this.d = r8;
        return;
    L8:
        if (r7 != 2) goto L10;
        r8 = new a(m.a(16.0f), m.a(28.0f), new String[]{"#ffffff"}, new String[]{"#e6000000"});
        goto L18
    L10:
        if (r7 != 3) goto L12;
        r8 = new a(m.a(12.0f), m.a(24.0f), new String[]{"#ffffff"}, new String[]{"#e6000000"});
        goto L18
    L12:
        if (r7 != 4) goto L13;
        r8 = new a(m.a(14.0f), m.a(22.0f), new String[]{"#ffffff"}, new String[]{"#e6000000"});
    L13:
        r8 = new a(m.a(16.0f), m.a(28.0f), new String[]{"#ffffff"}, new String[]{"#e6000000"});
        goto L18
    }
}
