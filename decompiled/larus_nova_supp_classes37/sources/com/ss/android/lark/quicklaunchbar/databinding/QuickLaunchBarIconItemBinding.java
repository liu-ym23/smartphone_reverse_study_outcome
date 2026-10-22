package com.ss.android.lark.quicklaunchbar.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larksuite.component.universe_design.badge.UDBadgeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class QuickLaunchBarIconItemBinding implements ViewBinding {
    public final RelativeLayout a;
    public final UDBadgeView b;
    public final UDBadgeView c;
    public final ImageView d;
    public final TextView e;

    public final View getRoot() {
        return this.a;
    }

    public static QuickLaunchBarIconItemBinding a(View r8) {
        int r0 = 2131363832;
        UDBadgeView r4 = ViewBindings.findChildViewById(r8, 2131363832);
        if (r4 == null) goto L13;
        r0 = 2131363834;
        UDBadgeView r5 = ViewBindings.findChildViewById(r8, 2131363834);
        if (r5 == null) goto L13;
        r0 = 2131375915;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r8, 2131375915);
        if (r6 == null) goto L13;
        r0 = 2131390052;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r8, 2131390052);
        if (r7 == null) goto L13;
        return new QuickLaunchBarIconItemBinding((RelativeLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }

    public QuickLaunchBarIconItemBinding(RelativeLayout r1, UDBadgeView r2, UDBadgeView r3, ImageView r4, TextView r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
