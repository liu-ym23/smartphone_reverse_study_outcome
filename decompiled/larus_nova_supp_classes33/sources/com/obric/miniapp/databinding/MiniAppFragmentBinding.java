package com.obric.miniapp.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.ai.view.input.FloatingSpeakerView;
import com.obric.miniapp.view.MiniAppActionBar;
import com.obric.oui.text.OTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class MiniAppFragmentBinding implements ViewBinding {
    public final LinearLayout a;
    public final ImageView b;
    public final FloatingSpeakerView c;
    public final MiniAppActionBar d;
    public final ProgressBar e;
    public final ConstraintLayout f;
    public final LinearLayout g;
    public final OTextView h;
    public final FrameLayout i;
    public final LinearLayout j;

    public final View getRoot() {
        return this.a;
    }

    public MiniAppFragmentBinding(LinearLayout r1, ImageView r2, FloatingSpeakerView r3, MiniAppActionBar r4, ProgressBar r5, ConstraintLayout r6, LinearLayout r7, OTextView r8, FrameLayout r9, LinearLayout r10) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
    }
}
