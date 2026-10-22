package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import b02.c;
import b02.d;
import b02.e;
import com.bytedance.android.live.core.utils.rxutils.j;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0003B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/view/combo/ComboIconAnimationView;", "Landroid/widget/FrameLayout;", BuildConfig.FLAVOR, "a", "J", "getGiftId", "()J", "setGiftId", "(J)V", "giftId", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ComboIconAnimationView extends FrameLayout {
    public static final float h = 0.0f;
    public static final float i = 0.0f;
    public static final float j = 0.0f;
    public static final float k = 0.0f;
    public long a;
    public Disposable b;
    public Disposable c;
    public Bitmap d;
    public final long e;
    public final long f;
    public final Random g;

    public static final class a {
    }

    public static final class b extends AnimatorListenerAdapter {
        public final /* synthetic */ ComboIconAnimationView a;
        public final /* synthetic */ View b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.removeView(this.b);
        }

        public b(ComboIconAnimationView r1, View r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public ComboIconAnimationView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ComboIconAnimationView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    static {
        h = s1.f(25.0f);
        i = s1.f(15.0f);
        j = s1.f(70.0f);
        k = s1.f(35.0f);
    }

    public final long getGiftId() {
        return this.a;
    }

    public final void c(int r5) {
        if (r5 != 0) goto L4;
        Disposable r6 = this.b;
        if (r6 == null) goto L15;
        r6.dispose();
        return;
    L15:
        return;
    L4:
        if (r5 != 66) goto L16;
        Disposable r7 = this.b;
        if (r7 == null) goto L9;
        r7.dispose();
    L9:
        j.a r8 = j.a;
        this.b = j.a(0, 2000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this), d.a, e.a);
        return;
    }

    public final void setGiftId(long r1) {
        this.a = r1;
    }

    public static View a(ComboIconAnimationView r1, Bitmap r2) {
        r1.getClass();
        ImageView r0 = new ImageView(r1.getContext());
        r0.setImageBitmap(r2);
        int r3 = (int) h;
        FrameLayout.LayoutParams r4 = new FrameLayout.LayoutParams(r3, r3);
        r4.gravity = 17;
        Unit r5 = Unit.INSTANCE;
        r0.setLayoutParams(r4);
        return r0;
    }

    public final void d(Bitmap r10, int r11) {
        int r13 = r11 % 2;
        if (r13 != 0) goto L5;
        View r14 = a(this, r10);
        addView(r14);
        float r4 = j;
        float r5 = -r4;
        Float r6 = Float.valueOf(r5);
        float r7 = -k;
        b(r14, TuplesKt.to(r6, Float.valueOf(r7)), 0);
        View r15 = a(this, r10);
        addView(r15);
        b(r15, TuplesKt.to(Float.valueOf(r4), Float.valueOf(r7)), 0);
        View r16 = a(this, r10);
        addView(r16);
        b(r16, TuplesKt.to(Float.valueOf(-i), Float.valueOf(r5)), 300);
        return;
    L5:
        if (r13 != 1) goto L11;
        View r17 = a(this, r10);
        addView(r17);
        float r8 = j;
        float r9 = -r8;
        Float r18 = Float.valueOf(r9);
        float r19 = k;
        b(r17, TuplesKt.to(r18, Float.valueOf(r19)), 0);
        View r110 = a(this, r10);
        addView(r110);
        b(r110, TuplesKt.to(Float.valueOf(r8), Float.valueOf(r19)), 0);
        View r111 = a(this, r10);
        addView(r111);
        b(r111, TuplesKt.to(Float.valueOf(i), Float.valueOf(r9)), 300);
        return;
    }

    public ComboIconAnimationView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.e = 600;
        this.f = 400;
        this.g = new Random();
    }

    public final void b(View r10, Pair<Float, Float> r11, long r13) {
        ObjectAnimator r1 = ObjectAnimator.ofFloat(r10, "translationX", new float[]{((Number) r11.getFirst()).floatValue()}).setDuration(this.e);
        ObjectAnimator r14 = ObjectAnimator.ofFloat(r10, "translationY", new float[]{((Number) r11.getSecond()).floatValue()}).setDuration(this.e);
        ObjectAnimator r4 = ObjectAnimator.ofFloat(r10, "alpha", new float[]{1.0f, 0.0f}).setDuration(this.e - this.f);
        r4.setStartDelay(this.f);
        AnimatorSet r5 = new AnimatorSet();
        r5.setStartDelay(r13);
        r5.playTogether(new Animator[]{r1, r14, r4});
        r5.addListener(new b(this, r10));
        r5.start();
    }

    public /* synthetic */ ComboIconAnimationView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
