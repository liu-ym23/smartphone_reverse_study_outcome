package com.larus.common_res.common_ui.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDialogInputBinding implements ViewBinding {
    public final LinearLayout a;
    public final TextView b;
    public final TextView c;
    public final EditText d;
    public final TextView e;

    public final View getRoot() {
        return this.a;
    }

    public LarusDialogInputBinding(LinearLayout r1, TextView r2, TextView r3, EditText r4, TextView r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
