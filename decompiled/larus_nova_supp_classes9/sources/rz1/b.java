package rz1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.view.View;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revenue.common.RevBitmapTranslateUtils;
import com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.GiftIconMaskView;
import com.bytedance.common.utility.UIUtils;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public AnimatorSet a;
    public AnimatorSet b;
    public final GiftIconMaskView c;
    public final View d;

    public static final class a {
    }

    /* JADX INFO: renamed from: rz1.b$b, reason: collision with other inner class name */
    public static final class C0274b extends AnimatorListenerAdapter {
        public final /* synthetic */ b a;
        public final /* synthetic */ Function0 b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            b r4 = this.a;
            r4.c.setRepeatCount(1);
            r4.c.setShaderMode(1);
            r4.c.b();
            r4.c.setOnShaderAinmatorListener(new d(r4));
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.c.setVisibility(0);
            this.a.d.setVisibility(4);
            Function0 r3 = this.b;
            if (r3 == null) goto L6;
            r3.invoke();
            return;
        }

        public C0274b(b r1, Function0 r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public final void b() {
        AnimatorSet r0 = this.a;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        AnimatorSet r1 = this.a;
        if (r1 == null) goto L8;
        r1.removeAllListeners();
    L8:
        this.c.c();
        AnimatorSet r2 = this.b;
        if (r2 == null) goto L11;
        r2.cancel();
    L11:
        AnimatorSet r3 = this.b;
        if (r3 == null) goto L15;
        r3.removeAllListeners();
        return;
    }

    public final void a(Bitmap r9) {
        Intrinsics.checkNotNullParameter(r9, "bitmap");
        float r0 = UIUtils.dip2Px(this.c.getContext(), 52.0f);
        Bitmap r1 = RevBitmapTranslateUtils.a(r9);
        int r10 = (int) r0;
        if (r1 != null) goto L11;
    L7:
        Bitmap r11 = null;
    L8:
        this.c.a(r11);
        return;
    L11:
        int r4 = r1.getWidth();     // Catch: OutOfMemoryError -> L10
        int r5 = r1.getHeight();     // Catch: OutOfMemoryError -> L10
        float r13 = r10;
        Matrix r6 = new Matrix();     // Catch: OutOfMemoryError -> L10
        r6.postScale(r13 / r4, r13 / r5);     // Catch: OutOfMemoryError -> L10
        r11 = Bitmap.createBitmap(r1, 0, 0, r4, r5, r6, true);     // Catch: OutOfMemoryError -> L10
        goto L8
    }

    public final void c(Function0<Unit> r6) {
        if (this.a != null) goto L5;
        this.a = new AnimatorSet();
    L5:
        AnimatorSet r0 = this.a;
        if (r0 == null) goto L9;
        r0.cancel();
        r0.removeAllListeners();
        ObjectAnimator r1 = ObjectAnimator.ofFloat(this.c, "scaleX", new float[]{1.0f, 1.12f});
        ObjectAnimator r2 = ObjectAnimator.ofFloat(this.c, "scaleY", new float[]{1.0f, 1.12f});
        r0.play(r1).with(r2);
        r0.setDuration(200);
        r0.addListener(new C0274b(this, r6));
        r0.start();
        return;
    }

    public b(GiftIconMaskView r2, HSImageView r3) {
        Intrinsics.checkNotNullParameter(r2, "giftIconMaskView");
        Intrinsics.checkNotNullParameter(r3, "giftImageIcon");
        this.c = r2;
        this.d = r3;
    }
}
