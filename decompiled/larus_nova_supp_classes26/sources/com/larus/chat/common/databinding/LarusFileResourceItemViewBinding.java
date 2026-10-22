package com.larus.chat.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.layout.widget.ImageCoverEditView;
import com.larus.common_ui.widget.CircleProgressBarView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusFileResourceItemViewBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final FrameLayout b;
    public final TextView c;
    public final View d;
    public final ConstraintLayout e;
    public final ViewStub f;
    public final ViewStub g;
    public final FrameLayout h;
    public final FrameLayout i;
    public final AppCompatImageView j;
    public final CircleProgressBarView k;
    public final AppCompatTextView l;
    public final AppCompatImageView m;
    public final AppCompatTextView n;
    public final CircleProgressBarView o;
    public final FrameLayout p;
    public final FrameLayout q;
    public final SimpleDraweeView r;
    public final ImageCoverEditView s;
    public final FrameLayout t;
    public final AppCompatTextView u;

    public final View getRoot() {
        return this.a;
    }

    public static LarusFileResourceItemViewBinding a(LayoutInflater r25, ViewGroup r26) {
        ConstraintLayout r0 = r25.inflate(2131562333, r26, false);
        int r1 = 2131370399;
        FrameLayout r5 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131370399);
        if (r5 == null) goto L49;
        r1 = 2131370402;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r0, 2131370402);
        if (r6 == null) goto L49;
        r1 = 2131372430;
        View r7 = ViewBindings.findChildViewById(r0, 2131372430);
        if (r7 == null) goto L49;
        r1 = 2131372431;
        ConstraintLayout r8 = ViewBindings.findChildViewById(r0, 2131372431);
        if (r8 == null) goto L49;
        r1 = 2131372432;
        ViewStub r9 = (ViewStub) ViewBindings.findChildViewById(r0, 2131372432);
        if (r9 == null) goto L49;
        r1 = 2131372437;
        ViewStub r10 = (ViewStub) ViewBindings.findChildViewById(r0, 2131372437);
        if (r10 == null) goto L49;
        r1 = 2131372439;
        if (ViewBindings.findChildViewById(r0, 2131372439) == null) goto L49;
        r1 = 2131372440;
        FrameLayout r11 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131372440);
        if (r11 == null) goto L49;
        r1 = 2131372441;
        if (ViewBindings.findChildViewById(r0, 2131372441) == null) goto L49;
        r1 = 2131372442;
        FrameLayout r12 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131372442);
        if (r12 == null) goto L49;
        r1 = 2131372443;
        AppCompatImageView r13 = ViewBindings.findChildViewById(r0, 2131372443);
        if (r13 == null) goto L49;
        ConstraintLayout r4 = r0;
        r1 = 2131372445;
        CircleProgressBarView r14 = ViewBindings.findChildViewById(r0, 2131372445);
        if (r14 == null) goto L49;
        r1 = 2131372446;
        AppCompatTextView r15 = ViewBindings.findChildViewById(r0, 2131372446);
        if (r15 == null) goto L49;
        r1 = 2131372447;
        AppCompatImageView r16 = ViewBindings.findChildViewById(r0, 2131372447);
        if (r16 == null) goto L49;
        r1 = 2131372448;
        AppCompatTextView r17 = ViewBindings.findChildViewById(r0, 2131372448);
        if (r17 == null) goto L49;
        r1 = 2131372449;
        CircleProgressBarView r18 = ViewBindings.findChildViewById(r0, 2131372449);
        if (r18 == null) goto L49;
        r1 = 2131372450;
        FrameLayout r19 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131372450);
        if (r19 == null) goto L49;
        r1 = 2131372451;
        FrameLayout r20 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131372451);
        if (r20 == null) goto L49;
        r1 = 2131374931;
        SimpleDraweeView r21 = ViewBindings.findChildViewById(r0, 2131374931);
        if (r21 == null) goto L49;
        r1 = 2131374974;
        ImageCoverEditView r22 = ViewBindings.findChildViewById(r0, 2131374974);
        if (r22 == null) goto L49;
        r1 = 2131387598;
        FrameLayout r23 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131387598);
        if (r23 == null) goto L49;
        r1 = 2131387600;
        AppCompatTextView r24 = ViewBindings.findChildViewById(r0, 2131387600);
        if (r24 == null) goto L49;
        return new LarusFileResourceItemViewBinding(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    L49:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }

    public LarusFileResourceItemViewBinding(ConstraintLayout r3, FrameLayout r4, TextView r5, View r6, ConstraintLayout r7, ViewStub r8, ViewStub r9, FrameLayout r10, FrameLayout r11, AppCompatImageView r12, CircleProgressBarView r13, AppCompatTextView r14, AppCompatImageView r15, AppCompatTextView r16, CircleProgressBarView r17, FrameLayout r18, FrameLayout r19, SimpleDraweeView r20, ImageCoverEditView r21, FrameLayout r22, AppCompatTextView r23) {
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
        this.m = r15;
        this.n = r16;
        this.o = r17;
        this.p = r18;
        this.q = r19;
        this.r = r20;
        this.s = r21;
        this.t = r22;
        this.u = r23;
    }
}
