package com.larus.push.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.widget.CircleSimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusOpenPushReminderBubbleLeftStyleBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final CircleSimpleDraweeView b;

    public final View getRoot() {
        return this.a;
    }

    public LarusOpenPushReminderBubbleLeftStyleBinding(ConstraintLayout r1, CircleSimpleDraweeView r2, AppCompatImageView r3, TextView r4, TextView r5, TextView r6) {
        this.a = r1;
        this.b = r2;
    }
}
