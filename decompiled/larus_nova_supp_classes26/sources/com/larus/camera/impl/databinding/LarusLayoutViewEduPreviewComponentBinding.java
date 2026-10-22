package com.larus.camera.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.camera.impl.ui.component.result.edu.EduResultTabView;
import com.larus.camera.impl.widget.EduPreviewLoadingView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusLayoutViewEduPreviewComponentBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final FrameLayout b;
    public final EduPreviewLoadingView c;
    public final EduResultTabView d;
    public final FrameLayout e;
    public final TextView f;
    public final TextView g;

    public final View getRoot() {
        return this.a;
    }

    public LarusLayoutViewEduPreviewComponentBinding(ConstraintLayout r1, FrameLayout r2, EduPreviewLoadingView r3, EduResultTabView r4, FrameLayout r5, TextView r6, TextView r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
