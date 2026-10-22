package com.bytedance.android.annie.dialog;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.livesdk.pannel.SheetBaseBehavior;
import com.bytedance.android.livesdk.pannel.SheetBaseDialog;
import com.bytedance.android.livesdk.pannel.view.RadiusLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import x8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/annie/dialog/NoMarginSheetBaseDialog;", "Lcom/bytedance/android/livesdk/pannel/SheetBaseDialog;", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class NoMarginSheetBaseDialog extends SheetBaseDialog {
    public final void M0(View r10) {
        if (r10 != null) goto L5;
    L13:
        ((SheetBaseDialog) this).n = true;
        View r11 = ((SheetBaseDialog) this).o;
        if (r11 == null) goto L16;
        r11.setFocusable(false);
        r11.setImportantForAccessibility(2);
    L16:
        a.d("NoMarginSheetBaseDialog", "call disableTouchOutsizeA11yFocus with ture", false);
        return;
    L5:
        if (((SheetBaseDialog) this).s == false) goto L13;
        CoordinatorLayout.LayoutParams r1 = r10.getLayoutParams();
        if ((r1 instanceof CoordinatorLayout.LayoutParams) == false) goto L10;
        CoordinatorLayout.LayoutParams r12 = r1;
        ((ViewGroup.MarginLayoutParams) r12).leftMargin = 0;
        ((ViewGroup.MarginLayoutParams) r12).rightMargin = 0;
        ((ViewGroup.MarginLayoutParams) r12).topMargin = 0;
        ((ViewGroup.MarginLayoutParams) r12).bottomMargin = 0;
    L10:
        if ((r10 instanceof RadiusLayout) == false) goto L12;
        ((RadiusLayout) r10).setMaxHeight(0);
    L12:
        ((ViewGroup.LayoutParams) r1).width = -2;
        r10.setLayoutParams(r1);
        goto L13
    }

    public final void setCancelable(boolean r10) {
        super.setCancelable(r10);
        if (r10 == true) goto L13;
        if (AnnieConfigSettingKeys.ENABLE_DIALOG_PULL_DOWN_GESTURE_BY_FE_HANDLE_CLOSE.a().booleanValue() == false) goto L14;
        SheetBaseBehavior r11 = ((SheetBaseDialog) this).a;     // Catch: Exception -> L10
        if (r11 == null) goto L15;
        r11.a = true;     // Catch: Exception -> L10
        return;
    L15:
        return;
    L14:
        return;
    L16:
        return;
    }

    public NoMarginSheetBaseDialog(Context r10, boolean r11, boolean r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12, r13);
    }
}
