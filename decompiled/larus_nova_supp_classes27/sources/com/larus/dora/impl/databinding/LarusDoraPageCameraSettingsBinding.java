package com.larus.dora.impl.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextToggle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraPageCameraSettingsBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final AppCompatTextView b;
    public final ItemGroup c;
    public final ItemTextToggle d;
    public final View e;
    public final ItemTextToggle f;
    public final NovaTitleBarEx g;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraPageCameraSettingsBinding(ConstraintLayout r1, AppCompatTextView r2, ItemGroup r3, ItemTextToggle r4, View r5, ItemTextToggle r6, NovaTitleBarEx r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
