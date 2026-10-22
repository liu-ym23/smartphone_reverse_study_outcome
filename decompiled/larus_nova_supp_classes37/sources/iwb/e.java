package iwb;

import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e {
    public final a a;

    public final int a() {
        return RangesKt.coerceAtLeast(this.a.getWidth() - this.a.getFloatView$officesdk_minutes_base_ui_release().getWidth(), 0);
    }

    public final int b() {
        a r0 = this.a;
        int r1 = r0.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r1 <= 0) goto L5;
        int r2 = r0.getResources().getDimensionPixelSize(r1);
    L7:
        if (this.a.getHeight() > 0) goto L9;
        return r2;
    L9:
        return RangesKt.coerceAtLeast(((int) (this.a.getHeight() * 0.5f)) - r2, r2);
    L5:
        r2 = 0;
        goto L7
    }

    public final int d() {
        int r0 = -this.a.getFloatView$officesdk_minutes_base_ui_release().getWidth();
        a r1 = this.a;
        return (r0 + r1.g) + r1.h;
    }

    public final int e() {
        int r0 = this.a.getWidth();
        a r1 = this.a;
        return (r0 - r1.g) - r1.h;
    }

    public e(a r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        this.a = r2;
    }

    public final int c(int r6) {
        a r0 = this.a;
        int r1 = r0.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r1 <= 0) goto L5;
        int r2 = r0.getResources().getDimensionPixelSize(r1);
    L6:
        int r3 = RangesKt.coerceAtLeast(this.a.getHeight() - this.a.getFloatView$officesdk_minutes_base_ui_release().getHeight(), r2);
        return RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r6, r2), r3);
    L5:
        r2 = 0;
        goto L6
    }
}
