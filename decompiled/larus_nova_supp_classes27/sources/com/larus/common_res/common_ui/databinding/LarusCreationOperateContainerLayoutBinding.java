package com.larus.common_res.common_ui.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.CreationOperateContainerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusCreationOperateContainerLayoutBinding implements ViewBinding {
    public final View a;
    public final Button b;
    public final ConstraintLayout c;
    public final AppCompatTextView d;
    public final ConstraintLayout e;
    public final ImageView f;
    public final AppCompatTextView g;

    public final View getRoot() {
        return this.a;
    }

    public LarusCreationOperateContainerLayoutBinding(CreationOperateContainerView r1, Button r2, ConstraintLayout r3, AppCompatTextView r4, ConstraintLayout r5, ImageView r6, AppCompatTextView r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
