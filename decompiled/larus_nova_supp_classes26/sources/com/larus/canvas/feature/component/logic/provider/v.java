package com.larus.canvas.feature.component.logic.provider;

import android.animation.ValueAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.larus.bmhome.bigimg.m1;
import com.larus.bmhome.bigimg.widget.CreationSidebarView;
import com.larus.gallery.impl.databinding.LarusLayoutGalleryCreationSideBarBinding;
import com.larus.utils.e1;
import com.larus.utils.y0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class v extends com.larus.gallery.api.t<ky8.a> {
    public final j f;
    public LarusLayoutGalleryCreationSideBarBinding g;
    public final Lazy h;
    public ValueAnimator i;
    public ky8.a j;
    public boolean k;

    public final void v() {
        ValueAnimator r0 = this.i;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.i = null;
    }

    public v(j r2) {
        Intrinsics.checkNotNullParameter(r2, "canvasGalleryContext");
        this.f = r2;
        this.h = LazyKt.lazy(new k(this));
        int r3 = r2.a;
        this.k = true;
    }

    public final View p(ViewGroup r11) {
        LarusLayoutGalleryCreationSideBarBinding r12 = LarusLayoutGalleryCreationSideBarBinding.a(LayoutInflater.from(getContext()), r11);
        this.g = r12;
        CreationSidebarView r0 = r12.b;
        if (r0 == null) goto L5;
        ic8.d r2 = ((jy9.e) this.h.getValue()).a;
        CreationSidebarView.S5(r0, ((jy9.e) this.h.getValue()).b, r2, ((jy9.e) this.h.getValue()).c, ((jy9.e) this.h.getValue()).d, ((jy9.e) this.h.getValue()).e, null, new n(this), null, 416);
    L5:
        LarusLayoutGalleryCreationSideBarBinding r13 = this.g;
        if (r13 != null) goto L10;
        return null;
    L10:
        return r13.a;
    }

    public final void w(Object r13, int r14) {
        ky8.a r15 = (ky8.a) r13;
        Intrinsics.checkNotNullParameter(r15, "data");
        ((com.larus.gallery.api.t) this).d = r15;
        this.j = r15;
        boolean r1 = true;
        if (r14 != this.f.a) goto L5;
        boolean r16 = true;
    L7:
        if (r16 == false) goto L28;
        if (this.k == false) goto L28;
        this.k = false;
        if (Intrinsics.areEqual(r15.a, "origin") == false) goto L17;
        LarusLayoutGalleryCreationSideBarBinding r17 = this.g;
        if (r17 == null) goto L56;
        CreationSidebarView r18 = r17.b;
        if (r18 == null) goto L57;
        e1.o(r18);
        return;
    L57:
        return;
    L56:
        return;
    L17:
        LarusLayoutGalleryCreationSideBarBinding r19 = this.g;
        if (r19 == null) goto L22;
        CreationSidebarView r110 = r19.b;
        if (r110 == null) goto L22;
        e1.x(r110);
    L22:
        LarusLayoutGalleryCreationSideBarBinding r111 = this.g;
        if (r111 == null) goto L59;
        CreationSidebarView r0 = r111.b;
        if (r0 == null) goto L60;
        CreationSidebarView.R5(r0, y0.j(r15.g), new m1(null, null, null, r15.i, r15.j, r15.c, 7), null, null, false, null, 48);
        return;
    L60:
        return;
    L59:
        return;
    L28:
        if (Intrinsics.areEqual(r15.a, "origin") == false) goto L42;
        LarusLayoutGalleryCreationSideBarBinding r112 = this.g;
        if (r112 == null) goto L39;
        CreationSidebarView r113 = r112.b;
        if (r113 == null) goto L39;
        if (r113.getVisibility() != 0) goto L36;
        boolean r114 = true;
    L37:
        if (r114 != true) goto L39;
    L40:
        if (r1 == false) goto L62;
        ValueAnimator r115 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r115.setDuration(this.f.c);
        r115.addUpdateListener(new l(this));
        r115.addListener(new t(this));
        this.i = r115;
        r115.start();
        return;
    L62:
        return;
    L36:
        r114 = false;
    L39:
        r1 = false;
        goto L40
    L42:
        LarusLayoutGalleryCreationSideBarBinding r116 = this.g;
        if (r116 == null) goto L52;
        CreationSidebarView r117 = r116.b;
        if (r117 == null) goto L52;
        if (r117.getVisibility() != 0) goto L49;
        boolean r118 = true;
    L50:
        if (r118 == true) goto L52;
    L53:
        if (r1 == false) goto L64;
        ValueAnimator r119 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r119.setDuration(this.f.c);
        r119.addUpdateListener(new m(this));
        r119.addListener(new u(this, r15));
        this.i = r119;
        r119.start();
        return;
    L64:
        return;
    L49:
        r118 = false;
    L52:
        r1 = false;
        goto L53
    L5:
        r16 = false;
        goto L7
    }
}
