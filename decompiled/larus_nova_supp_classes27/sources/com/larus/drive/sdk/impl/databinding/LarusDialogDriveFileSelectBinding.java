package com.larus.drive.sdk.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.widget.ChatFileSelectorView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDialogDriveFileSelectBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final ImageView b;
    public final ImageView c;
    public final FrameLayout d;
    public final View e;
    public final ConstraintLayout f;
    public final ChatFileSelectorView g;
    public final TextView h;
    public final View i;

    public final View getRoot() {
        return this.a;
    }

    public LarusDialogDriveFileSelectBinding(ConstraintLayout r1, ImageView r2, ImageView r3, FrameLayout r4, View r5, ConstraintLayout r6, ChatFileSelectorView r7, TextView r8, View r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
    }
}
