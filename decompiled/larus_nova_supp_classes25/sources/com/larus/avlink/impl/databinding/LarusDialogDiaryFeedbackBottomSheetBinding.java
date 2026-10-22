package com.larus.avlink.impl.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.chip.ChipGroup;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class LarusDialogDiaryFeedbackBottomSheetBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final ImageView b;
    public final EditText c;
    public final ChipGroup d;
    public final TextView e;
    public final TextView f;

    public final View getRoot() {
        return this.a;
    }

    public LarusDialogDiaryFeedbackBottomSheetBinding(ConstraintLayout r1, ImageView r2, EditText r3, ChipGroup r4, TextView r5, TextView r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
