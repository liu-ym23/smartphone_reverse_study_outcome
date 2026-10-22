package com.obric.assistant.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricGuideForExperienceImproveBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final TextView b;
    public final OButton c;
    public final OButton d;
    public final OFloatingTitleBar e;
    public final FrameLayout f;

    public final View getRoot() {
        return this.a;
    }

    public ObricGuideForExperienceImproveBinding(ConstraintLayout r1, TextView r2, OButton r3, OButton r4, OFloatingTitleBar r5, FrameLayout r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
