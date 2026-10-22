package com.larus.profile.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.bigimg.widget.LeftCreationEditView;
import com.larus.bmhome.bigimg.widget.NumericIndicator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusCreationPagerLayoutBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final LeftCreationEditView b;
    public final NumericIndicator c;
    public final FrameLayout d;

    public final View getRoot() {
        return this.a;
    }

    public LarusCreationPagerLayoutBinding(ConstraintLayout r1, LeftCreationEditView r2, NumericIndicator r3, FrameLayout r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
