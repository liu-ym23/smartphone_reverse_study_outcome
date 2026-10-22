package com.obric.memorydata.ui.custom;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"refreshThemeCardBackground", "", "Landroid/view/View;", "radiusDp", "", "corners", "Lcom/obric/memorydata/ui/custom/ThemeCardCorners;", "colorRes", "", "ui_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class c {
    public static final void a(View r4, float r5, ThemeCardCorners r6, int r7) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r6, "corners");
        float r8 = r5 * ZeusTransformUtils.getResources(r4, "com.obric.memorydata.plugin").getDisplayMetrics().density;
        GradientDrawable r1 = new GradientDrawable();
        r1.setShape(0);
        r1.setColor(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getColor(r7));
        float[] r9 = r6.resolveCornerRadii$ui_obricRelease(r8);
        if (r9 == null) goto L5;
        r1.setCornerRadii(r9);
    L6:
        r4.setBackground((Drawable) ZeusTransformUtils.preCheckCast(r1, Drawable.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        r1.setCornerRadius(r8);
        goto L6
    }

    public static /* synthetic */ void a(View r0, float r1, ThemeCardCorners r2, int r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = 20.0f;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = ThemeCardCorners.ALL;
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = ZeusTransformUtils.mapRes(R.color.oui_advanced_fill_list_item_card, TypedValues.Custom.S_COLOR, "oui_advanced_fill_list_item_card");
    L11:
        a(r0, r1, r2, r3);
    }
}
