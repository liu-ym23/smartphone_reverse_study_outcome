package i40;

import android.content.Context;
import com.bytedance.android.live.common.keyboard.MeasureLinearLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i extends b {
    public long c;
    public final long d;
    public final boolean e;
    public final boolean f;

    @Override // i40.b
    public final boolean a(Context r6, int r7) {
        d r8 = this.a.b(r6, r7);
        if (r8 != null) goto L6;
        return true;
    L6:
        if (this.c != 0) goto L9;
        this.c = System.currentTimeMillis();
    L9:
        if ((System.currentTimeMillis() - this.c) < this.d) goto L11;
    L20:
        this.c = System.currentTimeMillis();
        c(r8.a, r8.b);
        return true;
    L11:
        if (r8.a == true) goto L20;
        h.c("【hit invalid check】", this.e);
        if (this.f == false) goto L18;
        h.c("target section is " + h.d, this.e);
        if ("keyboard".equals(h.d) == false) goto L20;
        h.c("【invalid update measure, don't update for keyboard】", this.e);
        return false;
    L18:
        h.c("【invalid update measure, don't update】", this.e);
        return false;
    }

    public i(MeasureLinearLayout r3, int r4, boolean r5, boolean r6) {
        super(r3);
        this.c = 0;
        this.d = 200;
        this.e = false;
        this.f = false;
        this.a = new g(r6);
        this.d = r4;
        this.e = r6;
        this.f = r5;
    }
}
