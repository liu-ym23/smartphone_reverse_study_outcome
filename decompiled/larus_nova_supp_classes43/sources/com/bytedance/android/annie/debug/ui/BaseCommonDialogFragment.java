package com.bytedance.android.annie.debug.ui;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.annie.card.AnnieCard;
import com.bytedance.common.utility.UIUtils;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/annie/debug/ui/BaseCommonDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "annie-debug_release"}, k = 1, mv = {1, 4, 3})
public class BaseCommonDialogFragment extends DialogFragment {
    public AnnieCard d;

    public void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L8;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L9;
        float r10 = UIUtils.dip2Px(getContext(), 8.0f);
        GradientDrawable r11 = new GradientDrawable();
        r11.setCornerRadii(new float[]{r10, r10, r10, r10, r10, r10, r10, r10});
        r11.setGradientType(0);
        Context r12 = getContext();
        Intrinsics.checkNotNull(r12);
        r11.setColor(r12.getResources().getColor(2131100224));
        r1.setBackgroundDrawable(r11);
        return;
    L9:
        return;
    }

    public BaseCommonDialogFragment() {
    }
}
