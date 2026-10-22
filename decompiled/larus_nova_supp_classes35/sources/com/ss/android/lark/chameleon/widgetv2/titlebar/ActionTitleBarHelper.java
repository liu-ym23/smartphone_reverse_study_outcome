package com.ss.android.lark.chameleon.widgetv2.titlebar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import swb.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ActionTitleBarHelper {
    public ActionTitleBarHelper() {
    }

    public static int getActionOutLeftPaddingInPixel() {
        return dip2px(9);
    }

    public static int getActionOutPaddingInPixel() {
        return dip2px(8);
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_ss_android_lark_chameleon_widgetv2_titlebar_ActionTitleBarHelper_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public static int dip2px(int r1) {
        return (int) ((r1 * INVOKEVIRTUAL_com_ss_android_lark_chameleon_widgetv2_titlebar_ActionTitleBarHelper_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()).density) + 0.5f);
    }

    public static void setDefaultTextStyle(TextView r2) {
        r2.setTextColor(r2.getResources().getColor(2131101059));
        r2.setSingleLine();
        r2.setGravity(16);
        r2.setEllipsize(TextUtils.TruncateAt.END);
    }

    public static View inflateAction(Context r6, IActionTitlebar.Action r7) {
        if ((r7 instanceof IActionTitlebar.ImageAction) == false) goto L13;
        final ImageView r0 = new ImageView(r6);
        IActionTitlebar.ImageAction r1 = (IActionTitlebar.ImageAction) r7;
        if (r1.getDrawable() == null) goto L7;
        r0.setImageDrawable(r1.getDrawable());
    L8:
        int r2 = r1.getTintRes();
        if (r2 == 0) goto L11;
        r0.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(r6, r2)));
    L11:
        r1.setOnDrawableUpdateListener(new AnonymousClass1(r0));
        p.a r3 = p.a;
        int r8 = p.a.a(r6, 10.0f);
        r0.setPadding(r8, r8, r8, r8);
        View r4 = r0;
    L24:
        if (r7.getBackground() == 0) goto L26;
        r4.setBackgroundResource(r7.getBackground());
    L26:
        return r4;
    L7:
        r0.setImageDrawable(AppCompatResources.getDrawable(r6, r7.getDrawableRes()));
        goto L8
    L13:
        if ((r7 instanceof IActionTitlebar.TextAction) == false) goto L20;
        IActionTitlebar.TextAction r5 = (IActionTitlebar.TextAction) r7;
        final TextView r9 = new TextView(r6);
        setDefaultTextStyle(r9);
        r9.setText(r7.getText());
        r9.setTextSize(r5.getTextSize());
        IActionTitlebar.TextAction r10 = (IActionTitlebar.TextAction) r7;
        if (r10.getColor() == (-1)) goto L17;
        r9.setTextColor(r6.getResources().getColorStateList(r5.getColor()));
    L18:
        r10.setOnTextColorChangedListener(new AnonymousClass2(r9));
        r10.setOnTextChangedListener(new AnonymousClass3(r9));
        r9.setPadding(getActionOutLeftPaddingInPixel(), 0, getActionOutPaddingInPixel(), 0);
        r4 = r9;
        goto L24
    L17:
        r9.setTextColor(r6.getResources().getColorStateList(2131101057));
        goto L18
    L20:
        if ((r7 instanceof IActionTitlebar.ViewAction) == false) goto L22;
        View r11 = ((IActionTitlebar.ViewAction) r7).getView();
        r11.setPadding(getActionOutLeftPaddingInPixel(), 0, getActionOutPaddingInPixel(), 0);
        r4 = r11;
        goto L24
    L22:
        r4 = null;
        goto L24
    }
}
