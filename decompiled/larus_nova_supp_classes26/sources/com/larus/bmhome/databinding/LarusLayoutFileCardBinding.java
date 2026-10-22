package com.larus.bmhome.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.FileNameView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusLayoutFileCardBinding implements ViewBinding {
    public final RelativeLayout a;
    public final FileNameView b;
    public final CardView c;
    public final AppCompatImageView d;
    public final LinearLayout e;
    public final TextView f;

    public final View getRoot() {
        return this.a;
    }

    public LarusLayoutFileCardBinding(RelativeLayout r1, FileNameView r2, CardView r3, AppCompatImageView r4, LinearLayout r5, TextView r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
