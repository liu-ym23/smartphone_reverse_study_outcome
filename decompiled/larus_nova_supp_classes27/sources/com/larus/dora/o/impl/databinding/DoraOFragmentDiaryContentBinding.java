package com.larus.dora.o.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.dora.o.impl.diary.week.OWeekCalendarBar;
import com.obric.oui.button.OButtonLink;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraOFragmentDiaryContentBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final OFloatingTitleBar b;
    public final FrameLayout c;
    public final TextView d;
    public final ProgressBar e;
    public final LinearLayout f;
    public final OButtonLink g;
    public final OWeekCalendarBar h;

    public final View getRoot() {
        return this.a;
    }

    public DoraOFragmentDiaryContentBinding(ConstraintLayout r1, OFloatingTitleBar r2, FrameLayout r3, TextView r4, ProgressBar r5, LinearLayout r6, OButtonLink r7, OWeekCalendarBar r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }
}
