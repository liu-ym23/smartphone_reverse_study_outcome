package com.larus.bmhome.music.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.bigimg.download.CommonDownLoadLayout;
import com.larus.bmhome.bigimg.template.CommonTemplateLayout;
import com.larus.bmhome.music.widget.MusicPlayerSlidingInfoView;
import com.larus.bmhome.view.CreationOperateContainerView;
import com.larus.common_ui.video.progress.PlayerProgressView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusFragmentMusicPlayerDetailBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final ConstraintLayout b;
    public final AppCompatImageView c;
    public final AppCompatImageView d;
    public final CreationOperateContainerView e;
    public final CommonDownLoadLayout f;
    public final MusicPlayerSlidingInfoView g;
    public final PlayerProgressView h;
    public final CommonTemplateLayout i;
    public final FrameLayout j;
    public final FrameLayout k;

    public final View getRoot() {
        return this.a;
    }

    public static LarusFragmentMusicPlayerDetailBinding a(LayoutInflater r12, ViewGroup r13) {
        ConstraintLayout r14 = r12.inflate(2131562415, r13, false);
        ConstraintLayout r2 = r14;
        int r15 = 2131364679;
        AppCompatImageView r3 = ViewBindings.findChildViewById(r14, 2131364679);
        if (r3 == null) goto L25;
        r15 = 2131364767;
        AppCompatImageView r4 = ViewBindings.findChildViewById(r14, 2131364767);
        if (r4 == null) goto L25;
        r15 = 2131368277;
        CreationOperateContainerView r5 = (CreationOperateContainerView) ViewBindings.findChildViewById(r14, 2131368277);
        if (r5 == null) goto L25;
        r15 = 2131370179;
        CommonDownLoadLayout r6 = ViewBindings.findChildViewById(r14, 2131370179);
        if (r6 == null) goto L25;
        r15 = 2131380496;
        MusicPlayerSlidingInfoView r7 = (MusicPlayerSlidingInfoView) ViewBindings.findChildViewById(r14, 2131380496);
        if (r7 == null) goto L25;
        r15 = 2131381490;
        if (ViewBindings.findChildViewById(r14, 2131381490) == null) goto L25;
        r15 = 2131382471;
        PlayerProgressView r8 = ViewBindings.findChildViewById(r14, 2131382471);
        if (r8 == null) goto L25;
        r15 = 2131383377;
        CommonTemplateLayout r9 = ViewBindings.findChildViewById(r14, 2131383377);
        if (r9 == null) goto L25;
        r15 = 2131386121;
        FrameLayout r10 = (FrameLayout) ViewBindings.findChildViewById(r14, 2131386121);
        if (r10 == null) goto L25;
        r15 = 2131388807;
        FrameLayout r11 = (FrameLayout) ViewBindings.findChildViewById(r14, 2131388807);
        if (r11 == null) goto L25;
        return new LarusFragmentMusicPlayerDetailBinding(r2, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r15)));
    }

    public LarusFragmentMusicPlayerDetailBinding(ConstraintLayout r1, ConstraintLayout r2, AppCompatImageView r3, AppCompatImageView r4, CreationOperateContainerView r5, CommonDownLoadLayout r6, MusicPlayerSlidingInfoView r7, PlayerProgressView r8, CommonTemplateLayout r9, FrameLayout r10, FrameLayout r11) {
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
        this.k = r11;
    }
}
