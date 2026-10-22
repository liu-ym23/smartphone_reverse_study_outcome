package com.ss.android.lark.picker.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PickerScenarioEntriesViewBinding implements ViewBinding {
    public final LinearLayout pickerScenarioEntryPermissionGroup;
    public final LinearLayout pickerScenarioEntryPersonnelType;
    private final LinearLayout rootView;

    public /* bridge */ /* synthetic */ View getRoot() {
        return m3337getRoot();
    }

    /* JADX INFO: renamed from: getRoot, reason: collision with other method in class */
    public LinearLayout m3337getRoot() {
        return this.rootView;
    }

    public static PickerScenarioEntriesViewBinding bind(View r3) {
        int r0 = 2131382279;
        LinearLayout r1 = (LinearLayout) ViewBindings.findChildViewById(r3, 2131382279);
        if (r1 == null) goto L9;
        r0 = 2131382280;
        LinearLayout r2 = (LinearLayout) ViewBindings.findChildViewById(r3, 2131382280);
        if (r2 == null) goto L9;
        return new PickerScenarioEntriesViewBinding((LinearLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }

    public static PickerScenarioEntriesViewBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    private PickerScenarioEntriesViewBinding(LinearLayout r1, LinearLayout r2, LinearLayout r3) {
        this.rootView = r1;
        this.pickerScenarioEntryPermissionGroup = r2;
        this.pickerScenarioEntryPersonnelType = r3;
    }

    public static PickerScenarioEntriesViewBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(2131564216, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }
}
