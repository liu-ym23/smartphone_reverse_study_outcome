package com.larus.canvas.feature.component.resultdisplay.image.widget;

import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class q {
    public final ViewPager2 a;
    public int b;
    public boolean c;

    public final void a() {
        RecyclerView r0 = this.a.getChildAt(0);
        ImagePagerAdapter.PageVH r2 = null;
        if ((r0 instanceof RecyclerView) == false) goto L5;
        RecyclerView r1 = r0;
    L6:
        if (r1 == null) goto L8;
        RecyclerView.ViewHolder r3 = r1.findViewHolderForAdapterPosition(this.b);
    L10:
        if ((r3 instanceof ImagePagerAdapter.PageVH) == false) goto L12;
        ImagePagerAdapter.PageVH r4 = (ImagePagerAdapter.PageVH) r3;
    L13:
        if (r4 == null) goto L15;
        ((RecyclerView.ViewHolder) r4).itemView.setTranslationX(0.0f);
    L15:
        if (r1 == null) goto L17;
        RecyclerView.ViewHolder r5 = r1.findViewHolderForAdapterPosition(this.b - 1);
    L19:
        if ((r5 instanceof ImagePagerAdapter.PageVH) == false) goto L21;
        ImagePagerAdapter.PageVH r6 = (ImagePagerAdapter.PageVH) r5;
    L23:
        if (r6 == null) goto L25;
        r6.g.setTranslationX((((RecyclerView.ViewHolder) r6).itemView.getMeasuredWidth() - r6.g.getMeasuredWidth()) * 0.5f);
    L25:
        if (r1 == null) goto L27;
        RecyclerView.ViewHolder r7 = r1.findViewHolderForAdapterPosition(this.b + 1);
    L29:
        if ((r7 instanceof ImagePagerAdapter.PageVH) == false) goto L31;
        r2 = (ImagePagerAdapter.PageVH) r7;
    L31:
        if (r2 == null) goto L34;
        r2.g.setTranslationX((-(((RecyclerView.ViewHolder) r2).itemView.getMeasuredWidth() - r2.g.getMeasuredWidth())) * 0.5f);
        return;
    L34:
        return;
    L27:
        r7 = null;
        goto L29
    L21:
        r6 = null;
        goto L23
    L17:
        r5 = null;
        goto L19
    L12:
        r4 = null;
        goto L13
    L8:
        r3 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public q(ViewPager2 r2) {
        Intrinsics.checkNotNullParameter(r2, "viewPager");
        this.a = r2;
        this.b = 0;
    }

    public final void b(boolean r6, boolean r7) {
        RecyclerView r0 = this.a.getChildAt(0);
        ImagePagerAdapter.PageVH r2 = null;
        if ((r0 instanceof RecyclerView) == false) goto L5;
        RecyclerView r1 = r0;
    L6:
        if (r1 == null) goto L8;
        RecyclerView.ViewHolder r3 = r1.findViewHolderForAdapterPosition(this.b - 1);
    L10:
        if ((r3 instanceof ImagePagerAdapter.PageVH) == false) goto L12;
        ImagePagerAdapter.PageVH r4 = (ImagePagerAdapter.PageVH) r3;
    L13:
        if (r1 == null) goto L15;
        RecyclerView.ViewHolder r5 = r1.findViewHolderForAdapterPosition(this.b + 1);
    L17:
        if ((r5 instanceof ImagePagerAdapter.PageVH) == false) goto L19;
        r2 = (ImagePagerAdapter.PageVH) r5;
    L19:
        if (r7 == false) goto L42;
        if (r6 == true) goto L22;
    L64:
        this.a.setUserInputEnabled(!r6);
        return;
    L22:
        if (r4 == null) goto L32;
        View r8 = ((RecyclerView.ViewHolder) r4).itemView;
        if (r8 == null) goto L32;
        ViewPropertyAnimator r9 = r8.animate();
        if (r9 == null) goto L32;
        ViewPropertyAnimator r10 = r9.alpha(0.0f);
        if (r10 == null) goto L32;
        ViewPropertyAnimator r11 = r10.setDuration(200);
        if (r11 == null) goto L32;
        r11.start();
    L32:
        if (r2 == null) goto L64;
        View r12 = ((RecyclerView.ViewHolder) r2).itemView;
        if (r12 == null) goto L64;
        ViewPropertyAnimator r13 = r12.animate();
        if (r13 == null) goto L64;
        ViewPropertyAnimator r14 = r13.alpha(0.0f);
        if (r14 == null) goto L64;
        ViewPropertyAnimator r15 = r14.setDuration(200);
        if (r15 == null) goto L64;
        r15.start();
        goto L64
    L42:
        if (r4 == null) goto L49;
        View r16 = ((RecyclerView.ViewHolder) r4).itemView;
        if (r16 == null) goto L49;
        ViewPropertyAnimator r17 = r16.animate();
        if (r17 == null) goto L49;
        r17.cancel();
    L49:
        if (r4 == null) goto L53;
        View r18 = ((RecyclerView.ViewHolder) r4).itemView;
        if (r18 == null) goto L53;
        r18.setAlpha(1.0f);
    L53:
        if (r2 == null) goto L59;
        View r19 = ((RecyclerView.ViewHolder) r2).itemView;
        if (r19 == null) goto L59;
        ViewPropertyAnimator r20 = r19.animate();
        if (r20 == null) goto L59;
        r20.cancel();
    L59:
        if (r2 == null) goto L63;
        View r21 = ((RecyclerView.ViewHolder) r2).itemView;
        if (r21 == null) goto L63;
        r21.setAlpha(1.0f);
    L63:
        this.a.setClipToPadding(r6);
        this.a.setClipChildren(r6);
        goto L64
    L15:
        r5 = null;
        goto L17
    L12:
        r4 = null;
        goto L13
    L8:
        r3 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }
}
