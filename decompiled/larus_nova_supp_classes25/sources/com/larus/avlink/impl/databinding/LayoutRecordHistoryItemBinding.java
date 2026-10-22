package com.larus.avlink.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.avlink.record.page.UploadProgressView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class LayoutRecordHistoryItemBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final View b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final FrameLayout g;
    public final ImageView h;
    public final UploadProgressView i;

    public final View getRoot() {
        return this.a;
    }

    public LayoutRecordHistoryItemBinding(ConstraintLayout r1, View r2, TextView r3, TextView r4, TextView r5, TextView r6, FrameLayout r7, ImageView r8, UploadProgressView r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
    }
}
