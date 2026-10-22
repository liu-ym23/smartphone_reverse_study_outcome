package com.larus.canvas.feature.component.logic.provider;

import android.animation.Animator;
import android.net.Uri;
import com.larus.bmhome.bigimg.m1;
import com.larus.bmhome.bigimg.widget.CreationSidebarView;
import com.larus.gallery.impl.databinding.LarusLayoutGalleryCreationSideBarBinding;
import com.larus.utils.e1;
import com.larus.utils.y0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class u implements Animator.AnimatorListener {
    public final /* synthetic */ v a;
    public final /* synthetic */ ky8.a b;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r11) {
        Intrinsics.checkNotNullParameter(r11, "animation");
        LarusLayoutGalleryCreationSideBarBinding r12 = this.a.g;
        if (r12 == null) goto L7;
        CreationSidebarView r13 = r12.b;
        if (r13 == null) goto L7;
        r13.setAlpha(1.0f);
    L7:
        LarusLayoutGalleryCreationSideBarBinding r14 = this.a.g;
        if (r14 == null) goto L13;
        CreationSidebarView r0 = r14.b;
        if (r0 == null) goto L14;
        Uri r1 = y0.j(this.b.g);
        ky8.a r2 = this.b;
        CreationSidebarView.R5(r0, r1, new m1(null, null, null, r2.i, r2.j, r2.c, 7), null, null, false, null, 48);
        return;
    L14:
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        LarusLayoutGalleryCreationSideBarBinding r3 = this.a.g;
        if (r3 == null) goto L7;
        CreationSidebarView r4 = r3.b;
        if (r4 == null) goto L7;
        e1.x(r4);
    L7:
        LarusLayoutGalleryCreationSideBarBinding r5 = this.a.g;
        if (r5 == null) goto L13;
        CreationSidebarView r6 = r5.b;
        if (r6 == null) goto L14;
        r6.setAlpha(0.0f);
        return;
    L14:
        return;
    }

    public u(v r1, ky8.a r2) {
        this.a = r1;
        this.b = r2;
    }
}
