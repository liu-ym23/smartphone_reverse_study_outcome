package com.larus.canvas.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusInstructionTabItemViewBinding implements ViewBinding {
    public final LinearLayout a;
    public final AppCompatImageView b;
    public final SimpleDraweeView c;
    public final AppCompatTextView d;
    public final AppCompatTextView e;

    public final View getRoot() {
        return this.a;
    }

    public LarusInstructionTabItemViewBinding(LinearLayout r1, AppCompatImageView r2, SimpleDraweeView r3, AppCompatTextView r4, AppCompatTextView r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
