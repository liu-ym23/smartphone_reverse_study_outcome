package com.larus.voicecall.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_ui.widget.CustomCircularProgressBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class LarusSubtitleHolderSingleImageBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final SimpleDraweeView b;
    public final CustomCircularProgressBar c;
    public final ImageView d;
    public final View e;

    public final View getRoot() {
        return this.a;
    }

    public LarusSubtitleHolderSingleImageBinding(ConstraintLayout r1, SimpleDraweeView r2, CustomCircularProgressBar r3, ImageView r4, View r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
