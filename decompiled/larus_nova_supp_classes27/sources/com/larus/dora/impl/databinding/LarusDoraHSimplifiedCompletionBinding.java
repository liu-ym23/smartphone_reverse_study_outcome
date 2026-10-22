package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraHSimplifiedCompletionBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final SimpleDraweeView b;
    public final FrameLayout c;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraHSimplifiedCompletionBinding(ConstraintLayout r1, SimpleDraweeView r2, FrameLayout r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
