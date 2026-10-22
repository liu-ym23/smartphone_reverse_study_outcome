package com.obric.assistant.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.widget.GradientTextView;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricItemPhoneOperationActionbarSkillHolderBinding implements ViewBinding {
    public final RoundConstraintLayout a;
    public final AppCompatImageView b;
    public final GradientTextView c;
    public final TextView d;

    public final View getRoot() {
        return this.a;
    }

    public ObricItemPhoneOperationActionbarSkillHolderBinding(RoundConstraintLayout r1, AppCompatImageView r2, GradientTextView r3, TextView r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
