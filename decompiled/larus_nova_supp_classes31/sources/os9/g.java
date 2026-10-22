package os9;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larus.common_ui.venus.ShapeLinearLayout;
import com.larus.reach.api.ReachButtonStyle;
import com.larus.reach.api.ReachButtonType;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class g {
    public static final List<a> a = null;

    public static final class a {
        public final int a;
        public final int b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a * 31) + this.b;
        }

        public final String toString() {
            return "ActionSlot(containerId=" + this.a + ", textId=" + this.b + ')';
        }

        public a(int r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b {
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ReachButtonType.values().length];
            r0[ReachButtonType.NORMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ReachButtonType.CLOSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public g() {
    }

    static {
        a = CollectionsKt.listOf(new a[]{new a(2131383737, 2131383738), new a(2131383734, 2131383735)});
    }

    public static int b(int r1, View r2) {
        Resources r3 = r2.getResources();
        return (int) ((r1 * WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).density) + 0.5f);
    }

    public static void a(ShapeLinearLayout r4, TextView r5, ReachButtonStyle r6) {
        if (r6 != ReachButtonStyle.PRIMARY) goto L5;
        boolean r7 = true;
    L6:
        if (r7 == false) goto L8;
        int r0 = ContextCompat.getColor(r4.getContext(), v19.c.b(2130972127, r4.getContext(), 2131103215));
    L9:
        Context r1 = r4.getContext();
        if (r7 == false) goto L12;
        int r2 = 2130972123;
    L13:
        Context r3 = r4.getContext();
        if (r7 == false) goto L16;
        int r8 = 2131103203;
    L17:
        int r9 = ContextCompat.getColor(r1, v19.c.b(r2, r3, r8));
        int r10 = ShapeLinearLayout.M;
        if (r0 == 0) goto L20;
        r4.b = r0;
    L20:
        r4.requestLayout();
        if (r5 == null) goto L24;
        r5.setTextColor(r9);
        return;
    L24:
        return;
    L16:
        r8 = 2131103136;
        goto L17
    L12:
        r2 = 2130972079;
        goto L13
    L8:
        r0 = ContextCompat.getColor(r4.getContext(), 2131103239);
        goto L9
    L5:
        r7 = false;
        goto L6
    }
}
