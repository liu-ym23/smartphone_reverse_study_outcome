package com.larus.drive.biz.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDriveFileItemBinding implements ViewBinding {
    public final FrameLayout a;
    public final ImageView b;
    public final SimpleDraweeView c;
    public final View d;
    public final TextView e;
    public final TextView f;

    public final View getRoot() {
        return this.a;
    }

    public LarusDriveFileItemBinding(FrameLayout r1, ImageView r2, SimpleDraweeView r3, View r4, TextView r5, TextView r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
