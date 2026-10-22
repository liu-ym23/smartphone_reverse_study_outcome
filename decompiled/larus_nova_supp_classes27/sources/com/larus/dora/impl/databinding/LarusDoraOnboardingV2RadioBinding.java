package com.larus.dora.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.dora.impl.view.DoraMovieView;
import com.larus.dora.impl.view.DoraUrlSpanTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraOnboardingV2RadioBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final DoraMovieView b;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraOnboardingV2RadioBinding(ConstraintLayout r1, DoraUrlSpanTextView r2, DoraMovieView r3) {
        this.a = r1;
        this.b = r3;
    }
}
