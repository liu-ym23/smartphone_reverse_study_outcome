package com.suite.lark.platform.component.cta.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.ss.android.lark.ui.CommonTitleBar;
import com.suite.lark.platform.component.cta.newstyle.widgets.CustomButtonGroup;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FragmentCtaDialogBinding implements ViewBinding {
    public final LKUIRoundableLayout a;
    public final RecyclerView b;
    public final CustomButtonGroup c;
    public final ImageView d;
    public final ConstraintLayout e;
    public final TextView f;
    public final TextView g;
    public final CommonTitleBar h;
    public final RecyclerView i;
    public final LKUIRoundableLayout j;

    public final View getRoot() {
        return this.a;
    }

    public FragmentCtaDialogBinding(LKUIRoundableLayout r1, RecyclerView r2, CustomButtonGroup r3, ImageView r4, ConstraintLayout r5, TextView r6, TextView r7, CommonTitleBar r8, RecyclerView r9, LKUIRoundableLayout r10) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
    }
}
