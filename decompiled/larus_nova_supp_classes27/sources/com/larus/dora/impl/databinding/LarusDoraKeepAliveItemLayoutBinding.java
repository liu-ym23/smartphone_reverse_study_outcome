package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.dora.impl.view.DoraTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraKeepAliveItemLayoutBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final SimpleDraweeView b;
    public final ImageView c;
    public final DoraTextView d;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraKeepAliveItemLayoutBinding(ConstraintLayout r1, SimpleDraweeView r2, ImageView r3, DoraTextView r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
