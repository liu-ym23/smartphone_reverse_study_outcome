package com.larus.comments.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusCommentPanelLayoutBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final View b;
    public final FrameLayout c;

    public final View getRoot() {
        return this.a;
    }

    public LarusCommentPanelLayoutBinding(ConstraintLayout r1, View r2, FrameLayout r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
