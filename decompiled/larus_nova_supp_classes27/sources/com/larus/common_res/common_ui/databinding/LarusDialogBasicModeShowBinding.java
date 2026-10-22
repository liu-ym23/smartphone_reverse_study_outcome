package com.larus.common_res.common_ui.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.widget.UrlSpanTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDialogBasicModeShowBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final RelativeLayout b;
    public final UrlSpanTextView c;
    public final AppCompatTextView d;
    public final AppCompatTextView e;

    public final View getRoot() {
        return this.a;
    }

    public LarusDialogBasicModeShowBinding(ConstraintLayout r1, RelativeLayout r2, UrlSpanTextView r3, AppCompatTextView r4, AppCompatTextView r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
