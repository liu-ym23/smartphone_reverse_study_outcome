package com.obric.miniapp.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.widget.roundlayout.RoundLinearLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class MiniAppActivityUserGuideBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final LinearLayout b;
    public final LinearLayout c;
    public final RoundLinearLayout d;
    public final FrameLayout e;

    public final View getRoot() {
        return this.a;
    }

    public MiniAppActivityUserGuideBinding(ConstraintLayout r1, LinearLayout r2, LinearLayout r3, RoundLinearLayout r4, FrameLayout r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
