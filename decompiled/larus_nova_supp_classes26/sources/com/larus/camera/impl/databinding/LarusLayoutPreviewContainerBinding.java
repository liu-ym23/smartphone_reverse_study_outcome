package com.larus.camera.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.view.markableview.MarkableImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusLayoutPreviewContainerBinding implements ViewBinding {
    public final View a;
    public final MarkableImageView b;
    public final SimpleDraweeView c;
    public final FrameLayout d;

    public final View getRoot() {
        return this.a;
    }

    public LarusLayoutPreviewContainerBinding(View r1, MarkableImageView r2, SimpleDraweeView r3, FrameLayout r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
