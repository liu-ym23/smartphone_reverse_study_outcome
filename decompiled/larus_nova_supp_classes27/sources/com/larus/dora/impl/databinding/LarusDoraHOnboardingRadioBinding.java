package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.dora.impl.view.DoraUrlSpanTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraHOnboardingRadioBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final VideoPlayView b;
    public final DoraTextView c;
    public final FrameLayout d;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraHOnboardingRadioBinding(ConstraintLayout r1, DoraUrlSpanTextView r2, VideoPlayView r3, DoraTextView r4, FrameLayout r5) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
