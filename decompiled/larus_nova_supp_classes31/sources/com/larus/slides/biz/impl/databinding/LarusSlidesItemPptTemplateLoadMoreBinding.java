package com.larus.slides.biz.impl.databinding;

import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusSlidesItemPptTemplateLoadMoreBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final LinearLayoutCompat b;
    public final ProgressBar c;
    public final AppCompatTextView d;

    public final View getRoot() {
        return this.a;
    }

    public LarusSlidesItemPptTemplateLoadMoreBinding(ConstraintLayout r1, LinearLayoutCompat r2, ProgressBar r3, AppCompatTextView r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
