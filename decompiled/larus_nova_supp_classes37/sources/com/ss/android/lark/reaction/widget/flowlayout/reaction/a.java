package com.ss.android.lark.reaction.widget.flowlayout.reaction;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.reaction.loader.ReactionLoaderManager;
import com.ss.android.lark.reaction.widget.flowlayout.ReactionFlowLayout;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a extends d {
    public static final /* synthetic */ int m = 0;
    public final Context e;
    public final String f;
    public final ReactionFlowLayout.f g;
    public final int h;
    public final WeakReference<View> i;
    public final boolean j;
    public int k;
    public volatile Drawable l;

    /* JADX INFO: renamed from: com.ss.android.lark.reaction.widget.flowlayout.reaction.a$a, reason: collision with other inner class name */
    public static final class C0125a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ a a;
        public final /* synthetic */ View b;

        public C0125a(a r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r8) {
            Intrinsics.checkNotNullParameter(r8, "it");
            float r0 = this.a.h;
            Object r1 = r8.getAnimatedValue();
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.Float");
            float r2 = r0 * ((Float) r1).floatValue();
            float r3 = this.a.k;
            Object r9 = r8.getAnimatedValue();
            Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type kotlin.Float");
            float r4 = r3 * ((Float) r9).floatValue();
            a r10 = this.a;
            int r5 = r10.h;
            float r6 = 2;
            int r7 = r10.k;
            r10.l.setBounds((int) ((r5 - r2) / r6), (int) ((r7 - r4) / r6), (int) ((r5 + r2) / r6), (int) ((r7 + r4) / r6));
            this.b.invalidate();
        }
    }

    public static final class b implements Animator.AnimatorListener {
        public final /* synthetic */ a a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        public b(a r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            a r3 = this.a;
            r3.g.a(r3.f);
        }
    }

    @Override // com.ss.android.lark.reaction.widget.flowlayout.reaction.ClearCacheDynamicDrawableSpan
    public final Drawable b() {
        return this.l;
    }

    @Override // com.ss.android.lark.reaction.widget.flowlayout.reaction.d
    public final void c(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        if (this.j == false) goto L5;
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{1.0f, 0.75f, 1.0f});
        r0.setInterpolator(new AccelerateDecelerateInterpolator());
        r0.setDuration(220);
        r0.addUpdateListener(new C0125a(this, r4));
        r0.addListener(new b(this));
        r0.start();
        return;
    L5:
        this.g.a(this.f);
    }

    public final void d(Drawable r4) {
        if (r4 == null) goto L10;
        this.l = r4;
        int r0 = (this.h * r4.getIntrinsicHeight()) / r4.getIntrinsicWidth();
        this.k = r0;
        r4.setBounds(0, 0, this.h, r0);
        if (this.b == null) goto L6;
        this.b = null;
    L6:
        a();
        View r5 = this.i.get();
        if (r5 == null) goto L11;
        r5.invalidate();
        return;
    L11:
        return;
    }

    /* JADX WARN: Type inference failed for: r10v10, types: [com.ss.android.lark.reaction.widget.flowlayout.reaction.ClickableDrawableSpan$2] */
    public a(Context r8, String r9, ReactionFlowLayout.f r10, int r11, WeakReference r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r8, "mContext");
        Intrinsics.checkNotNullParameter(r9, "mReactionKey");
        Intrinsics.checkNotNullParameter(r10, "mReactionClickListener");
        Intrinsics.checkNotNullParameter(r12, "parentView");
        super(1);
        this.e = r8;
        this.f = r9;
        this.g = r10;
        this.h = r11;
        this.i = r12;
        this.j = r13;
        int r4 = ReactionTextView.p;
        this.k = r4;
        ReactionLoaderManager r14 = ReactionLoaderManager.b.a;
        int r5 = UIUtils.dp2px(r8, k2c.b.b(r9));
        int r6 = UIUtils.dp2px(r8, k2c.b.a(r9));
        if (r5 <= 134) goto L5;
        xsb.b r15 = new xsb.b(r8, r11, r4, r5, r6);
    L6:
        this.l = r15;
        this.l.setBounds(0, 0, r11, this.k);
        Bitmap r16 = ReactionLoaderManager.b(r9, new ClickableDrawableSpan$2(this));
        if (r16 == null) goto L10;
        d(new BitmapDrawable(r8.getResources(), r16));
        return;
    L10:
        return;
    L5:
        r15 = new xsb.b(r8, r11, r4, r6, r6);
        goto L6
    }

    @Override // com.ss.android.lark.reaction.widget.flowlayout.reaction.d, com.ss.android.lark.reaction.widget.flowlayout.reaction.ClearCacheDynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r1, CharSequence r2, int r3, int r4, float r5, int r6, int r7, int r8, Paint r9) {
        Intrinsics.checkNotNullParameter(r1, "canvas");
        Intrinsics.checkNotNullParameter(r9, "paint");
        Drawable r10 = this.l;
        Paint.FontMetricsInt r11 = r9.getFontMetricsInt();
        int r12 = ((((r11.descent + r7) + r7) + r11.ascent) / 2) - (r10.getBounds().bottom / 2);
        r1.save();
        r1.translate(r5, r12);
        r10.draw(r1);
        r1.restore();
    }
}
