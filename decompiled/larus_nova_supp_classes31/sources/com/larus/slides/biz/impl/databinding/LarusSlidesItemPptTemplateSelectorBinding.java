package com.larus.slides.biz.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusSlidesItemPptTemplateSelectorBinding implements ViewBinding {
    public final LinearLayout a;
    public final CardView b;
    public final AppCompatImageView c;
    public final SimpleDraweeView d;
    public final AppCompatTextView e;

    public final View getRoot() {
        return this.a;
    }

    public LarusSlidesItemPptTemplateSelectorBinding(LinearLayout r1, CardView r2, AppCompatImageView r3, SimpleDraweeView r4, AppCompatTextView r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
