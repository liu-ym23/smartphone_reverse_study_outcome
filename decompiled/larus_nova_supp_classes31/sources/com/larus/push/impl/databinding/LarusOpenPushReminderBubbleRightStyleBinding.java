package com.larus.push.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.widget.CircleSimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusOpenPushReminderBubbleRightStyleBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final CircleSimpleDraweeView b;

    public final View getRoot() {
        return this.a;
    }

    public LarusOpenPushReminderBubbleRightStyleBinding(ConstraintLayout r1, CircleSimpleDraweeView r2, TextView r3, TextView r4, TextView r5) {
        this.a = r1;
        this.b = r2;
    }
}
