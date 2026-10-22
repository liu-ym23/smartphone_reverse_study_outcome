package com.larus.business.debug.base.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.venus.ShapeButton;
import com.larus.common_ui.venus.ShapeLinearLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusDebugTutorDialogLayoutBinding implements ViewBinding {
    public final ShapeLinearLayout a;
    public final TextView b;
    public final ShapeButton c;
    public final ShapeButton d;
    public final ShapeButton e;
    public final TextView f;
    public final ShapeButton g;
    public final NestedScrollView h;
    public final TextView i;
    public final ImageView j;

    public final View getRoot() {
        return this.a;
    }

    public LarusDebugTutorDialogLayoutBinding(ShapeLinearLayout r1, TextView r2, ShapeButton r3, ShapeButton r4, ShapeButton r5, TextView r6, ShapeButton r7, NestedScrollView r8, TextView r9, ImageView r10) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
    }
}
