package com.bytedance.android.live.ktv.common.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.fresco.FrescoLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d extends com.bytedance.android.live.ktv.common.view.a {
    public static final /* synthetic */ int a = 0;

    public static final class a implements Animator.AnimatorListener {
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ HSImageView b;
        public final /* synthetic */ View c;
        public final /* synthetic */ View d;
        public final /* synthetic */ Function0 e;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            onAnimationEnd(r2);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.removeView(this.b);
            this.e.invoke();
        }

        public a(ViewGroup r1, HSImageView r2, View r3, View r4, Function0 r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [android.view.View, android.widget.ImageView, com.bytedance.android.live.core.widget.HSImageView, java.lang.Object] */
    public static void a(MusicPanel r16, View r17, View r18, Context r19, Function0 r21) {
        Intrinsics.checkNotNullParameter(r16, "panel");
        Intrinsics.checkNotNullParameter(r17, "endView");
        Intrinsics.checkNotNullParameter(r18, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r19, "context");
        Intrinsics.checkNotNullParameter(r21, "endAction");
        ALogger.i("cartAnimView", "startAnim:" + r16.v);
        Rect r2 = r16.v;
        if (r2.left <= 0) goto L12;
        Rect r7 = new Rect(r2);
        ?? r8 = new HSImageView(r19);
        r8.setLayoutParams(new ViewGroup.LayoutParams(r17.getHeight(), r17.getHeight()));
        if ((r18 instanceof ViewGroup) == true) goto L7;
        View r3 = null;
    L8:
        ViewGroup r4 = (ViewGroup) r3;
        if (r4 == 0) goto L11;
        r4.addView(r8);
        FrescoLoader.with(r19).roundAsCircle().load(r16.a.getCoverUrl()).actualScaleType(ImageView.ScaleType.FIT_XY).into(r8);
        Rect r9 = new Rect();
        r17.getGlobalVisibleRect(r9);
        int[] r1 = new int[2];
        r18.getLocationInWindow(r1);
        int r5 = r7.left;
        int r12 = r1[0];
        r7.left = r5 - r12;
        r7.right -= r12;
        int r6 = r7.top;
        int r11 = r1[1];
        r7.top = r6 - r11;
        r7.bottom -= r11;
        r9.left -= r12;
        r9.right -= r12;
        r9.top -= r11;
        r9.bottom -= r11;
        a r13 = new a(r4, r8, r17, r18, r21);
        Intrinsics.checkNotNullParameter(r7, "startViewRect");
        Intrinsics.checkNotNullParameter(r9, "endViewRect");
        Intrinsics.checkNotNullParameter(r8, "targetView");
        Intrinsics.checkNotNullParameter(r13, "l");
        PointF r14 = new PointF(r7.left, r7.top);
        int r15 = r9.bottom;
        int r22 = r9.top;
        int r23 = r15 - r22;
        PointF r24 = new PointF(((r9.left + r9.right) / 2) - (r23 / 2), (float) ((((double) (r22 + r15)) / 1.8d) - (((double) r23) / 1.8d)));
        float r25 = 2;
        ValueAnimator r26 = ValueAnimator.ofObject(new com.bytedance.android.live.ktv.common.view.a.C0219a(new PointF(r14.x, (r24.y + r14.y) / r25), new PointF((r14.x + r24.x) / r25, r24.y)), new Object[]{r14, r24});
        r26.addUpdateListener(new b(r8));
        r26.addListener(r13);
        r26.setDuration(375);
        r26.start();
    L11:
        Rect r27 = new Rect(-1, -1, -1, -1);
        Intrinsics.checkNotNullParameter(r27, "<set-?>");
        r16.v = r27;
        return;
    L7:
        r3 = r18;
        goto L8
    L12:
        r21.invoke();
    }
}
