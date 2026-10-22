package v98;

import android.widget.PopupWindow;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d {
    public final RecyclerView a;
    public final int b;
    public final int c;
    public PopupWindow d;

    public final void a(int r5) {
        int r0 = this.c + RangesKt.coerceAtLeast(RangesKt.coerceAtLeast(r5, 0) - this.b, 0);
        if (this.a.getPaddingBottom() != r0) goto L5;
        return;
    L5:
        RecyclerView r6 = this.a;
        r6.setPadding(r6.getPaddingLeft(), this.a.getPaddingTop(), this.a.getPaddingRight(), r0);
    }

    public d(RecyclerView r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        this.a = r2;
        this.b = r3;
        this.c = r2.getPaddingBottom();
    }
}
