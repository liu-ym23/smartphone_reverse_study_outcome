package com.larus.suggest.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusCardSuggestGridItemBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final SimpleDraweeView b;

    public final View getRoot() {
        return this.a;
    }

    public LarusCardSuggestGridItemBinding(ConstraintLayout r1, SimpleDraweeView r2, TextView r3, TextView r4, SimpleDraweeView r5) {
        this.a = r1;
        this.b = r5;
    }
}
