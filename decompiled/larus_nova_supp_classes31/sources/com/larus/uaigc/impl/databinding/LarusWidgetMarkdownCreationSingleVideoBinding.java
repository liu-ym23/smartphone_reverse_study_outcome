package com.larus.uaigc.impl.databinding;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.common_ui.video.VideoPlayView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusWidgetMarkdownCreationSingleVideoBinding implements ViewBinding {
    public final View a;
    public final ImageView b;
    public final ImageView c;
    public final ImageView d;
    public final ProgressBar e;
    public final TextView f;
    public final ViewStub g;
    public final ViewStub h;
    public final VideoPlayView i;

    public final View getRoot() {
        return this.a;
    }

    public static LarusWidgetMarkdownCreationSingleVideoBinding a(View r12) {
        int r0 = 2131382424;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r12, 2131382424);
        if (r4 == null) goto L21;
        r0 = 2131392276;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r12, 2131392276);
        if (r5 == null) goto L21;
        r0 = 2131392295;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r12, 2131392295);
        if (r6 == null) goto L21;
        r0 = 2131392296;
        ProgressBar r7 = (ProgressBar) ViewBindings.findChildViewById(r12, 2131392296);
        if (r7 == null) goto L21;
        r0 = 2131392301;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r12, 2131392301);
        if (r8 == null) goto L21;
        r0 = 2131392303;
        ViewStub r9 = (ViewStub) ViewBindings.findChildViewById(r12, 2131392303);
        if (r9 == null) goto L21;
        r0 = 2131392330;
        ViewStub r10 = (ViewStub) ViewBindings.findChildViewById(r12, 2131392330);
        if (r10 == null) goto L21;
        r0 = 2131392404;
        VideoPlayView r11 = ViewBindings.findChildViewById(r12, 2131392404);
        if (r11 == null) goto L21;
        return new LarusWidgetMarkdownCreationSingleVideoBinding(r12, r4, r5, r6, r7, r8, r9, r10, r11);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r0)));
    }

    public LarusWidgetMarkdownCreationSingleVideoBinding(View r1, ImageView r2, ImageView r3, ImageView r4, ProgressBar r5, TextView r6, ViewStub r7, ViewStub r8, VideoPlayView r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
    }
}
