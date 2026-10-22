package com.larus.bmhome.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.layout.widget.CvsItemRightAction;
import com.larus.bmhome.view.ArcAvatarImageView;
import com.larus.common_ui.widget.AvatarTagView;
import com.larus.common_ui.widget.roundlayout.CircleFrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusItemConversationBinding implements ViewBinding {
    public final View a;
    public final SimpleDraweeView b;
    public final ArcAvatarImageView c;
    public final SimpleDraweeView d;
    public final RelativeLayout e;
    public final CircleFrameLayout f;
    public final AvatarTagView g;
    public final FrameLayout h;
    public final ConstraintLayout i;
    public final View j;
    public final View k;
    public final TextView l;
    public final ConstraintLayout m;
    public final View n;
    public final LinearLayout o;
    public final View p;
    public final View q;
    public final ConstraintLayout r;
    public final AppCompatImageView s;
    public final ConstraintLayout t;
    public final ProgressBar u;
    public final TextView v;
    public final CvsItemRightAction w;
    public final View x;
    public final TextView y;

    public final View getRoot() {
        return this.a;
    }

    public static LarusItemConversationBinding a(View r27) {
        int r0 = 2131363623;
        SimpleDraweeView r2 = ViewBindings.findChildViewById(r27, 2131363623);
        if (r2 == null) goto L55;
        r0 = 2131363645;
        ArcAvatarImageView r3 = (ArcAvatarImageView) ViewBindings.findChildViewById(r27, 2131363645);
        if (r3 == null) goto L55;
        r0 = 2131363663;
        SimpleDraweeView r4 = ViewBindings.findChildViewById(r27, 2131363663);
        if (r4 == null) goto L55;
        r0 = 2131363717;
        RelativeLayout r5 = (RelativeLayout) ViewBindings.findChildViewById(r27, 2131363717);
        if (r5 == null) goto L55;
        r0 = 2131363723;
        CircleFrameLayout r6 = ViewBindings.findChildViewById(r27, 2131363723);
        if (r6 == null) goto L55;
        r0 = 2131363736;
        AvatarTagView r7 = ViewBindings.findChildViewById(r27, 2131363736);
        if (r7 == null) goto L55;
        r0 = 2131364379;
        FrameLayout r8 = (FrameLayout) ViewBindings.findChildViewById(r27, 2131364379);
        if (r8 == null) goto L55;
        r0 = 2131364381;
        ConstraintLayout r9 = ViewBindings.findChildViewById(r27, 2131364381);
        if (r9 == null) goto L55;
        r0 = 2131364382;
        if (ViewBindings.findChildViewById(r27, 2131364382) == null) goto L55;
        r0 = 2131364383;
        View r10 = ViewBindings.findChildViewById(r27, 2131364383);
        if (r10 == null) goto L55;
        r0 = 2131364384;
        View r11 = ViewBindings.findChildViewById(r27, 2131364384);
        if (r11 == null) goto L55;
        r0 = 2131364566;
        TextView r12 = (TextView) ViewBindings.findChildViewById(r27, 2131364566);
        if (r12 == null) goto L55;
        r0 = 2131367794;
        ConstraintLayout r13 = ViewBindings.findChildViewById(r27, 2131367794);
        if (r13 == null) goto L55;
        r0 = 2131369197;
        View r14 = ViewBindings.findChildViewById(r27, 2131369197);
        if (r14 == null) goto L55;
        r0 = 2131371759;
        LinearLayout r15 = (LinearLayout) ViewBindings.findChildViewById(r27, 2131371759);
        if (r15 == null) goto L55;
        r0 = 2131373139;
        View r16 = ViewBindings.findChildViewById(r27, 2131373139);
        if (r16 == null) goto L55;
        r0 = 2131374270;
        View r17 = ViewBindings.findChildViewById(r27, 2131374270);
        if (r17 == null) goto L55;
        r0 = 2131375311;
        ConstraintLayout r18 = ViewBindings.findChildViewById(r27, 2131375311);
        if (r18 == null) goto L55;
        r0 = 2131376312;
        AppCompatImageView r19 = ViewBindings.findChildViewById(r27, 2131376312);
        if (r19 == null) goto L55;
        r0 = 2131378946;
        ConstraintLayout r20 = ViewBindings.findChildViewById(r27, 2131378946);
        if (r20 == null) goto L55;
        r0 = 2131378977;
        ProgressBar r21 = (ProgressBar) ViewBindings.findChildViewById(r27, 2131378977);
        if (r21 == null) goto L55;
        r0 = 2131380593;
        TextView r22 = (TextView) ViewBindings.findChildViewById(r27, 2131380593);
        if (r22 == null) goto L55;
        r0 = 2131384529;
        CvsItemRightAction r23 = ViewBindings.findChildViewById(r27, 2131384529);
        if (r23 == null) goto L55;
        r0 = 2131384531;
        View r24 = ViewBindings.findChildViewById(r27, 2131384531);
        if (r24 == null) goto L55;
        r0 = 2131388084;
        TextView r25 = (TextView) ViewBindings.findChildViewById(r27, 2131388084);
        if (r25 == null) goto L55;
        return new LarusItemConversationBinding(r27, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25);
    L55:
        throw new NullPointerException("Missing required view with ID: ".concat(r27.getResources().getResourceName(r0)));
    }

    public LarusItemConversationBinding(View r3, SimpleDraweeView r4, ArcAvatarImageView r5, SimpleDraweeView r6, RelativeLayout r7, CircleFrameLayout r8, AvatarTagView r9, FrameLayout r10, ConstraintLayout r11, View r12, View r13, TextView r14, ConstraintLayout r15, View r16, LinearLayout r17, View r18, View r19, ConstraintLayout r20, AppCompatImageView r21, ConstraintLayout r22, ProgressBar r23, TextView r24, CvsItemRightAction r25, View r26, TextView r27) {
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
        this.v = r24;
        this.w = r25;
        this.x = r26;
        this.y = r27;
    }
}
