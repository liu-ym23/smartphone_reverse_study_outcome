package com.larus.drive.sdk.impl.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusItemBaseFileSelectBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final AppCompatImageView b;
    public final View c;
    public final AppCompatTextView d;
    public final SimpleDraweeView e;
    public final AppCompatTextView f;

    public final View getRoot() {
        return this.a;
    }

    public LarusItemBaseFileSelectBinding(ConstraintLayout r1, AppCompatImageView r2, View r3, AppCompatTextView r4, SimpleDraweeView r5, AppCompatTextView r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
