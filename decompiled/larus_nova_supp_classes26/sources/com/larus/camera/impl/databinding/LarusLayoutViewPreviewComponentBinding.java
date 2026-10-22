package com.larus.camera.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.camera.impl.ui.component.result.general.viewpager.PreviewContainerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusLayoutViewPreviewComponentBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final Guideline b;
    public final RecyclerView c;
    public final PreviewContainerView d;
    public final Guideline e;
    public final View f;

    public final View getRoot() {
        return this.a;
    }

    public LarusLayoutViewPreviewComponentBinding(ConstraintLayout r1, Guideline r2, RecyclerView r3, PreviewContainerView r4, Guideline r5, View r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
