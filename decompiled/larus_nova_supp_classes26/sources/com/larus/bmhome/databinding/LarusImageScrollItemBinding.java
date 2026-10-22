package com.larus.bmhome.databinding;

import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.layout.widget.ImageCoverEditView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusImageScrollItemBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final FrameLayout b;
    public final ImageView c;
    public final ImageCoverEditView d;
    public final ImageView e;
    public final ProgressBar f;
    public final ViewStub g;
    public final ImageView h;
    public final LinearLayout i;
    public final AppCompatTextView j;
    public final SimpleDraweeView k;

    public final View getRoot() {
        return this.a;
    }

    public LarusImageScrollItemBinding(ConstraintLayout r1, FrameLayout r2, ImageView r3, ImageCoverEditView r4, ImageView r5, ProgressBar r6, ViewStub r7, ImageView r8, LinearLayout r9, AppCompatTextView r10, SimpleDraweeView r11) {
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
        this.k = r11;
    }
}
