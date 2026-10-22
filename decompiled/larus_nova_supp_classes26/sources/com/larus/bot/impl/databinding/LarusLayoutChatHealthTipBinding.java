package com.larus.bot.impl.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.widget.CircleSimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusLayoutChatHealthTipBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final AppCompatTextView b;
    public final AppCompatTextView c;
    public final AppCompatImageView d;
    public final View e;
    public final AppCompatTextView f;
    public final AppCompatTextView g;
    public final CircleSimpleDraweeView h;

    public final View getRoot() {
        return this.a;
    }

    public LarusLayoutChatHealthTipBinding(ConstraintLayout r1, AppCompatTextView r2, AppCompatTextView r3, AppCompatImageView r4, View r5, AppCompatTextView r6, AppCompatTextView r7, CircleSimpleDraweeView r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }
}
