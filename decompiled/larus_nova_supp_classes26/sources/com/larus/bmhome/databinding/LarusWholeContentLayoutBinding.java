package com.larus.bmhome.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusWholeContentLayoutBinding implements ViewBinding {
    public final CardView a;
    public final TextView b;
    public final CardView c;

    public final View getRoot() {
        return this.a;
    }

    public LarusWholeContentLayoutBinding(CardView r1, TextView r2, CardView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
