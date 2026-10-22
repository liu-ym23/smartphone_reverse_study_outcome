package u69;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.lisitem.OCardListItem;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public static final void a(OCardListItem r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        FrameLayout r0 = r3.getCardContainer();
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
    L6:
        if (r2 != null) goto L8;
    L12:
        if (r4 == null) goto L15;
        r4.intValue();
        Resources r5 = r3.getResources();
        int r6 = (int) ((WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics()).density * r4.intValue()) + 0.5f);
        LinearLayout r7 = r3.getTitleContainer();
        r7.setPaddingRelative(r6, r7.getPaddingTop(), r6, r7.getPaddingBottom());
        return;
    L15:
        return;
    L8:
        if (r2.getMarginStart() == 0) goto L10;
    L11:
        r2.setMarginStart(0);
        r2.setMarginEnd(0);
        r0.setLayoutParams(r2);
        goto L12
    L10:
        if (r2.getMarginEnd() == 0) goto L12;
    L5:
        r2 = null;
        goto L6
    }
}
