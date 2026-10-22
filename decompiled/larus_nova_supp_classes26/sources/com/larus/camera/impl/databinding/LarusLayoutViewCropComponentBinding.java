package com.larus.camera.impl.databinding;

import android.view.View;
import android.widget.Button;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.crop.ImageCropView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusLayoutViewCropComponentBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final Button b;
    public final ImageCropView c;

    public final View getRoot() {
        return this.a;
    }

    public LarusLayoutViewCropComponentBinding(ConstraintLayout r1, Button r2, ImageCropView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
