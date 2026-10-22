package v08;

import android.view.ViewGroup;
import com.larksuite.component.universe_design.button.UDButton;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(UDButton r2, UDButton r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "refView");
        if (r2.getLayoutParams().width >= r3.getWidth()) goto L6;
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        r0.width = RangesKt.coerceAtLeast(r2.getWidth(), r3.getWidth());
        r2.requestLayout();
        return;
    }
}
