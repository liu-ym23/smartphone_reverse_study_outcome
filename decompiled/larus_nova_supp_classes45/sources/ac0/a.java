package ac0;

import com.bytedance.android.live.ktv.common.tuningpanel.model.TuningButtonType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public final TuningButtonType a;
    public final String b;
    public boolean c;
    public final boolean d;
    public float e;
    public final int f;

    public final TuningButtonType getType() {
        return this.a;
    }

    public a(TuningButtonType r4, String r5, boolean r6, boolean r7, float r8, int r9) {
        int r1 = 0;
        if ((r9 & 4) == 0) goto L6;
        r6 = false;
    L6:
        if ((r9 & 8) == 0) goto L9;
        r7 = true;
    L9:
        if ((r9 & 16) == 0) goto L12;
        r8 = 1.0f;
    L12:
        if ((r9 & 32) == 0) goto L14;
        r1 = 1;
    L14:
        Intrinsics.checkNotNullParameter(r4, "type");
        Intrinsics.checkNotNullParameter(r5, "title");
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r1;
    }
}
