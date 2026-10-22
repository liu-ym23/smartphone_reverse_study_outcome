package com.ss.android.lark.conditional.access.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larksuite.component.ui.loading.LKUILoadingView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ScsWidgetLoadingViewBinding implements ViewBinding {
    public final LinearLayout a;
    public final LKUILoadingView b;
    public final LinearLayout c;
    public final TextView d;
    public final TextView e;

    public final View getRoot() {
        return this.a;
    }

    public static ScsWidgetLoadingViewBinding a(View r8) {
        int r0 = 2131378564;
        LKUILoadingView r4 = ViewBindings.findChildViewById(r8, 2131378564);
        if (r4 == null) goto L11;
        LinearLayout r5 = (LinearLayout) r8;
        r0 = 2131378984;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r8, 2131378984);
        if (r6 == null) goto L11;
        r0 = 2131378987;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r8, 2131378987);
        if (r7 == null) goto L11;
        return new ScsWidgetLoadingViewBinding(r5, r4, r5, r6, r7);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }

    public ScsWidgetLoadingViewBinding(LinearLayout r1, LKUILoadingView r2, LinearLayout r3, TextView r4, TextView r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
