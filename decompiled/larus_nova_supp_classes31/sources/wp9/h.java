package wp9;

import android.view.View;
import androidx.core.view.ViewCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class h {
    public final View a;
    public int b;
    public int c;
    public int d;

    public final void a() {
        View r0 = this.a;
        ViewCompat.offsetTopAndBottom(r0, this.d - (r0.getTop() - this.b));
        View r1 = this.a;
        ViewCompat.offsetLeftAndRight(r1, 0 - (r1.getLeft() - this.c));
    }

    public h(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.a = r2;
    }
}
