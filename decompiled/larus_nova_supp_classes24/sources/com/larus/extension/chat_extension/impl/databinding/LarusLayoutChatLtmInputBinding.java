package com.larus.extension.chat_extension.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class LarusLayoutChatLtmInputBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final AppCompatTextView b;
    public final LinearLayout c;
    public final AppCompatTextView d;
    public final AppCompatEditText e;
    public final ProgressBar f;
    public final AppCompatTextView g;

    public final View getRoot() {
        return this.a;
    }

    public LarusLayoutChatLtmInputBinding(ConstraintLayout r1, AppCompatTextView r2, LinearLayout r3, AppCompatTextView r4, AppCompatEditText r5, ProgressBar r6, AppCompatTextView r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
