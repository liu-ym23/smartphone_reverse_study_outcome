package com.larus.dora.o.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraOFragmentDiaryMonthBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final FrameLayout b;
    public final OFloatingTitleBar c;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraOFragmentDiaryMonthBinding(ConstraintLayout r1, FrameLayout r2, OFloatingTitleBar r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
