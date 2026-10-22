package com.larus.chat.common.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_ui.venus.ShapeConstraintLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusCardAwemeRecommendContentBinding implements ViewBinding {
    public final View a;
    public final LarusCardAwemeAuthorInfoBinding b;
    public final SimpleDraweeView c;
    public final ImageView d;
    public final ShapeConstraintLayout e;
    public final ShapeConstraintLayout f;
    public final AppCompatTextView g;

    public final View getRoot() {
        return this.a;
    }

    public LarusCardAwemeRecommendContentBinding(View r1, LarusCardAwemeAuthorInfoBinding r2, SimpleDraweeView r3, ImageView r4, ShapeConstraintLayout r5, ShapeConstraintLayout r6, AppCompatTextView r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
