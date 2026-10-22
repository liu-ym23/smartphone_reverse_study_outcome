package com.google.android.material.datepicker;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.obric.cae.R;

/* JADX INFO: loaded from: classes.dex */
public final class l extends j0.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ i f4708d;

    public l(i r8) {
        this.f4708d = r8;
    }

    @Override // j0.a
    public final void d(View r8, k0.f r10) {
        View.AccessibilityDelegate r11 = this.f8370a;
        AccessibilityNodeInfo r12 = r10.f8890a;
        r11.onInitializeAccessibilityNodeInfo(r8, r12);
        i r13 = this.f4708d;
        if (r13.f4696x.getVisibility() != 0) goto L5;
        int r14 = R.string.mtrl_picker_toggle_to_year_selection;
    L6:
        r12.setHintText(r13.getString(r14));
        return;
    L5:
        r14 = R.string.mtrl_picker_toggle_to_day_selection;
        goto L6
    }
}
