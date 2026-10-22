package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.dora.impl.view.DoraTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraOnboardingV2WelcomeBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final ImageView b;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraOnboardingV2WelcomeBinding(ConstraintLayout r1, ImageView r2, DoraTextView r3) {
        this.a = r1;
        this.b = r2;
    }
}
