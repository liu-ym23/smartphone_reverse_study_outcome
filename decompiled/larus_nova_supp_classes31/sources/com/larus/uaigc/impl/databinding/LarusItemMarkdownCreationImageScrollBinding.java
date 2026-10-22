package com.larus.uaigc.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.layout.widget.ImageCoverEditView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusItemMarkdownCreationImageScrollBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final ImageView b;
    public final ImageCoverEditView c;
    public final ImageView d;
    public final ProgressBar e;
    public final ViewStub f;
    public final ImageView g;
    public final LinearLayout h;
    public final AppCompatTextView i;
    public final SimpleDraweeView j;

    public final View getRoot() {
        return this.a;
    }

    public static LarusItemMarkdownCreationImageScrollBinding a(LayoutInflater r12, ViewGroup r13) {
        ConstraintLayout r14 = r12.inflate(2131562585, r13, false);
        int r15 = 2131374966;
        ImageView r3 = (ImageView) ViewBindings.findChildViewById(r14, 2131374966);
        if (r3 == null) goto L23;
        r15 = 2131374974;
        ImageCoverEditView r4 = ViewBindings.findChildViewById(r14, 2131374974);
        if (r4 == null) goto L23;
        r15 = 2131374978;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r14, 2131374978);
        if (r5 == null) goto L23;
        r15 = 2131374979;
        ProgressBar r6 = (ProgressBar) ViewBindings.findChildViewById(r14, 2131374979);
        if (r6 == null) goto L23;
        r15 = 2131375019;
        ViewStub r7 = (ViewStub) ViewBindings.findChildViewById(r14, 2131375019);
        if (r7 == null) goto L23;
        r15 = 2131375066;
        ImageView r8 = (ImageView) ViewBindings.findChildViewById(r14, 2131375066);
        if (r8 == null) goto L23;
        r15 = 2131375086;
        LinearLayout r9 = (LinearLayout) ViewBindings.findChildViewById(r14, 2131375086);
        if (r9 == null) goto L23;
        r15 = 2131375087;
        AppCompatTextView r10 = ViewBindings.findChildViewById(r14, 2131375087);
        if (r10 == null) goto L23;
        r15 = 2131375091;
        SimpleDraweeView r11 = ViewBindings.findChildViewById(r14, 2131375091);
        if (r11 == null) goto L23;
        return new LarusItemMarkdownCreationImageScrollBinding(r14, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r15)));
    }

    public LarusItemMarkdownCreationImageScrollBinding(ConstraintLayout r1, ImageView r2, ImageCoverEditView r3, ImageView r4, ProgressBar r5, ViewStub r6, ImageView r7, LinearLayout r8, AppCompatTextView r9, SimpleDraweeView r10) {
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
