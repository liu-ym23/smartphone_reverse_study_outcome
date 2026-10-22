package com.larus.chat.common.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.TextAnswerMultiActionButton;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusLayoutTextMessageMultiActionButtonBinding implements ViewBinding {
    public final View a;
    public final LinearLayout b;
    public final View c;
    public final AppCompatImageView d;
    public final FrameLayout e;
    public final AppCompatImageView f;
    public final TextView g;

    public final View getRoot() {
        return this.a;
    }

    public LarusLayoutTextMessageMultiActionButtonBinding(TextAnswerMultiActionButton r1, LinearLayout r2, View r3, AppCompatImageView r4, FrameLayout r5, AppCompatImageView r6, TextView r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
