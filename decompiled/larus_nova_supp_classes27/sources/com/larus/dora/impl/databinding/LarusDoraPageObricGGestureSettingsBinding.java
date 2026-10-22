package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.dora.impl.view.DoraMovieView;
import com.obric.oui.segmentedtab.OTabSegmentedLayout;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraPageObricGGestureSettingsBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final LinearLayout b;
    public final LinearLayout c;
    public final View d;
    public final OTabSegmentedLayout e;
    public final OFloatingTitleBar f;
    public final ImageView g;
    public final DoraMovieView h;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraPageObricGGestureSettingsBinding(ConstraintLayout r1, LinearLayout r2, LinearLayout r3, View r4, OTabSegmentedLayout r5, OFloatingTitleBar r6, ImageView r7, DoraMovieView r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }
}
