package com.larus.drive.sdk.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.widget.ChatFileSelectorView;
import com.larus.common_ui.widget.roundlayout.RoundFrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDialogChatFileSelectBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final RoundFrameLayout b;
    public final RoundFrameLayout c;
    public final AppCompatImageView d;
    public final ConstraintLayout e;
    public final ChatFileSelectorView f;
    public final AppCompatTextView g;
    public final View h;
    public final LinearLayout i;
    public final RecyclerView j;
    public final ProgressBar k;
    public final AppCompatTextView l;

    public final View getRoot() {
        return this.a;
    }

    public LarusDialogChatFileSelectBinding(ConstraintLayout r1, RoundFrameLayout r2, RoundFrameLayout r3, AppCompatImageView r4, ConstraintLayout r5, ChatFileSelectorView r6, AppCompatTextView r7, View r8, LinearLayout r9, RecyclerView r10, ProgressBar r11, AppCompatTextView r12) {
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
        this.l = r12;
    }
}
