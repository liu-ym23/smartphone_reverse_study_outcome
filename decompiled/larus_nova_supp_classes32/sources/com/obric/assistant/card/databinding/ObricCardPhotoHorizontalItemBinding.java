package com.obric.assistant.card.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class ObricCardPhotoHorizontalItemBinding implements ViewBinding {
    public final RelativeLayout a;
    public final SimpleDraweeView b;
    public final ImageView c;

    public final View getRoot() {
        return this.a;
    }

    public ObricCardPhotoHorizontalItemBinding(RelativeLayout r1, SimpleDraweeView r2, ImageView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
