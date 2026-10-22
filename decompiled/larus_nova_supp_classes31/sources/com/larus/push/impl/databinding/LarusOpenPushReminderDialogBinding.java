package com.larus.push.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusOpenPushReminderDialogBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final FrameLayout b;
    public final View c;
    public final View d;

    public final View getRoot() {
        return this.a;
    }

    public LarusOpenPushReminderDialogBinding(ConstraintLayout r1, AppCompatImageView r2, FrameLayout r3, View r4, View r5, TextView r6, TextView r7, TextView r8) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
