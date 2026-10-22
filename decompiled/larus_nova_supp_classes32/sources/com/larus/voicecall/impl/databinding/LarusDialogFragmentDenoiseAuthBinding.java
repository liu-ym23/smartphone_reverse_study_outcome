package com.larus.voicecall.impl.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.widget.UrlSpanTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class LarusDialogFragmentDenoiseAuthBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final AppCompatButton b;
    public final AppCompatTextView c;
    public final AppCompatImageView d;
    public final UrlSpanTextView e;

    public final View getRoot() {
        return this.a;
    }

    public LarusDialogFragmentDenoiseAuthBinding(ConstraintLayout r1, AppCompatButton r2, AppCompatTextView r3, AppCompatImageView r4, UrlSpanTextView r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
