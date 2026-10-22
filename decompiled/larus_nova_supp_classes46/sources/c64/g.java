package c64;

import android.util.Size;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g implements e {
    public final View a;

    @Override // c64.e
    public final Size getSize() {
        int r0 = this.a.getWidth();
        int r1 = this.a.getHeight();
        if (r0 != 0) goto L5;
        r0 = this.a.getMeasuredWidth();
    L5:
        if (r1 != 0) goto L8;
        r1 = this.a.getMeasuredHeight();
    L8:
        return new Size(r0, r1);
    }

    public g(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        this.a = r2;
    }
}
