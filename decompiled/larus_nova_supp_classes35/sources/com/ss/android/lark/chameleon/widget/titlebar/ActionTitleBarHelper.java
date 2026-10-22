package com.ss.android.lark.chameleon.widget.titlebar;

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
import com.ss.android.lark.chameleon.util.UiUtils;

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

    public static DisplayMetrics INVOKEVIRTUAL_com_ss_android_lark_chameleon_widget_titlebar_ActionTitleBarHelper_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public static int dip2px(int r1) {
        return (int) ((r1 * INVOKEVIRTUAL_com_ss_android_lark_chameleon_widget_titlebar_ActionTitleBarHelper_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()).density) + 0.5f);
    }

    public static void setDefaultTextStyle(TextView r2) {
        r2.setTextColor(r2.getResources().getColor(2131103463));
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
        int r8 = UiUtils.dp2px(r6, 10.0f);
        r0.setPadding(r8, r8, r8, r8);
        View r3 = r0;
    L24:
        if (r7.getBackground() == 0) goto L26;
        r3.setBackgroundResource(r7.getBackground());
    L26:
        return r3;
    L7:
        r0.setImageDrawable(AppCompatResources.getDrawable(r6, r7.getDrawableRes()));
        goto L8
    L13:
        if ((r7 instanceof IActionTitlebar.TextAction) == false) goto L20;
        IActionTitlebar.TextAction r4 = (IActionTitlebar.TextAction) r7;
        final TextView r5 = new TextView(r6);
        setDefaultTextStyle(r5);
        r5.setText(r7.getText());
        r5.setTextSize(r4.getTextSize());
        IActionTitlebar.TextAction r9 = (IActionTitlebar.TextAction) r7;
        if (r9.getColor() == (-1)) goto L17;
        r5.setTextColor(r6.getResources().getColorStateList(r4.getColor()));
    L18:
        r9.setOnTextColorChangedListener(new AnonymousClass2(r5));
        r9.setOnTextChangedListener(new AnonymousClass3(r5));
        r5.setPadding(getActionOutLeftPaddingInPixel(), 0, getActionOutPaddingInPixel(), 0);
        r3 = r5;
        goto L24
    L17:
        r5.setTextColor(r6.getResources().getColorStateList(2131100788));
        goto L18
    L20:
        if ((r7 instanceof IActionTitlebar.ViewAction) == false) goto L22;
        View r10 = ((IActionTitlebar.ViewAction) r7).getView();
        r10.setPadding(getActionOutLeftPaddingInPixel(), 0, getActionOutPaddingInPixel(), 0);
        r3 = r10;
        goto L24
    L22:
        r3 = null;
        goto L24
    }
}
