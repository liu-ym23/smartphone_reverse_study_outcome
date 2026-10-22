package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraDialogNlApplistBinding implements ViewBinding {
    public final RoundConstraintLayout a;
    public final AppCompatTextView b;
    public final LinearLayout c;
    public final RecyclerView d;
    public final AppCompatTextView e;
    public final EditText f;
    public final NovaTitleBarEx g;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraDialogNlApplistBinding(RoundConstraintLayout r1, AppCompatTextView r2, LinearLayout r3, RecyclerView r4, AppCompatTextView r5, EditText r6, NovaTitleBarEx r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
