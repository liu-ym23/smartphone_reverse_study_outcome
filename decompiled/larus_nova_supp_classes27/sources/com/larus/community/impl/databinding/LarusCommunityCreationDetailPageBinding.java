package com.larus.community.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.community.impl.detail.bottomtools.CreationDetailBottomToolsView;
import com.larus.community.impl.detail.bottomtools.CreationDetailBottomToolsViewV2;
import com.larus.community.impl.detail.image.CreationDetailImageView;
import com.larus.community.impl.detail.prompt.CreationDetailPromptView;
import com.larus.community.impl.detail.video.CreationDetailVideoView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusCommunityCreationDetailPageBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final FrameLayout b;
    public final CreationDetailBottomToolsView c;
    public final CreationDetailBottomToolsViewV2 d;
    public final FrameLayout e;
    public final FrameLayout f;
    public final CreationDetailImageView g;
    public final CreationDetailPromptView h;
    public final CreationDetailVideoView i;
    public final ConstraintLayout j;
    public final ScrollView k;
    public final View l;

    public final View getRoot() {
        return this.a;
    }

    public LarusCommunityCreationDetailPageBinding(ConstraintLayout r1, FrameLayout r2, CreationDetailBottomToolsView r3, CreationDetailBottomToolsViewV2 r4, FrameLayout r5, FrameLayout r6, CreationDetailImageView r7, CreationDetailPromptView r8, CreationDetailVideoView r9, ConstraintLayout r10, ScrollView r11, View r12) {
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
        this.l = r12;
    }
}
