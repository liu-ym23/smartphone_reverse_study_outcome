package d92;

import com.bytedance.android.livesdk.config.qf0;
import kotlin.jvm.internal.Intrinsics;
import z82.g;
import z82.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements c92.a {
    public final Float a;

    public a() {
        new b92.b();
        this.a = (Float) qf0.a.getValue();
    }

    @Override // c92.a
    public final z82.b a(a92.a r8) {
        Intrinsics.checkNotNullParameter(r8, "param");
        int r0 = (int) ((r8.b * 9.0f) / 16.0f);
        Integer r1 = h.a(r0, r8.a());
        if (r1 == null) goto L15;
        int r2 = r1.intValue();
        int r3 = (int) (this.a.floatValue() * ((int) (r0 / 0.5625f)));
        g r4 = r8.e;
        int r6 = 0;
        if (r8.c == true) goto L7;
        r4.getClass();
    L10:
        int r5 = 0;
    L11:
        int r7 = r3 + r5;
        if (r8.f == null) goto L17;
        r6 = z82.a.a();
    L17:
        return new z82.b(r0, r2, r7 + r6, (int) ((r8.a - r0) / 2.0f));
    L7:
        if (r4.a == false) goto L10;
        r5 = r4.b;
        goto L11
    L15:
        return null;
    }
}
