package com.larus.common_res.common_ui.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusViewSearchBarBinding implements ViewBinding {
    public final RelativeLayout a;
    public final AppCompatImageView b;
    public final TextView c;
    public final AppCompatImageView d;
    public final AppCompatImageView e;
    public final EditText f;

    public final View getRoot() {
        return this.a;
    }

    public LarusViewSearchBarBinding(RelativeLayout r1, AppCompatImageView r2, TextView r3, AppCompatImageView r4, AppCompatImageView r5, EditText r6, LinearLayout r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
