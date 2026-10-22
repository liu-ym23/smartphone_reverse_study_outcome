package com.larus.slides.biz.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.view.FileExportTypeItemView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusPageSlidesExportChooseDialogBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final ImageView b;
    public final ProgressBar c;
    public final TextView d;
    public final FileExportTypeItemView e;
    public final FileExportTypeItemView f;
    public final LinearLayout g;

    public final View getRoot() {
        return this.a;
    }

    public LarusPageSlidesExportChooseDialogBinding(ConstraintLayout r1, ImageView r2, ProgressBar r3, TextView r4, FileExportTypeItemView r5, FileExportTypeItemView r6, LinearLayout r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
