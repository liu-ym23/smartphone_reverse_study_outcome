package com.larus.slides.biz.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.slides.impl.select.IndefinitePagerIndicator;
import com.larus.slides.impl.select.widget.GenerateImageViewPagerContainer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusSlidesPageGenerateImageBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final TextView b;
    public final IndefinitePagerIndicator c;
    public final NovaTitleBarEx d;
    public final GenerateImageViewPagerContainer e;

    public final View getRoot() {
        return this.a;
    }

    public LarusSlidesPageGenerateImageBinding(ConstraintLayout r1, TextView r2, IndefinitePagerIndicator r3, NovaTitleBarEx r4, GenerateImageViewPagerContainer r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
