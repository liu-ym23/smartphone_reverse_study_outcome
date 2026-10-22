package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/normal/view/v2/GiftIconMaskView;", "Landroid/view/View;", BuildConfig.FLAVOR, "count", BuildConfig.FLAVOR, "setRepeatCount", "mode", "setShaderMode", "Lcom/bytedance/android/livesdk/gift/platform/business/normal/view/v2/GiftIconMaskView$b;", "onShaderAinmatorListener", "setOnShaderAinmatorListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftIconMaskView extends View {
    public final Paint a;
    public ValueAnimator b;
    public boolean c;
    public Bitmap d;
    public BitmapShader e;
    public int f;
    public int g;
    public b h;

    public static final class a {
    }

    public interface b {
        void onAnimationEnd(Animator r1);

        void onAnimationStart(Animator r1);
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ GiftIconMaskView a;

        public c(GiftIconMaskView r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r10) {
            Intrinsics.checkNotNullParameter(r10, "it");
            if ((r10.getAnimatedValue() instanceof Float) == false) goto L9;
            Object r11 = r10.getAnimatedValue();
            if (r11 == null) goto L8;
            float r4 = ((Float) r11).floatValue();
        L11:
            if (this.a.g != 0) goto L13;
            float r3 = r4;
            LinearGradient r13 = new LinearGradient(0.0f, s1.e(40.0f), r3, s1.e(40.0f) - r4, new int[]{0, -1, 0}, new float[]{0.3f, 0.5f, 0.7f}, Shader.TileMode.CLAMP);
        L14:
            BitmapShader r1 = this.a.e;
            Intrinsics.checkNotNull(r1);
            ComposeShader r0 = new ComposeShader(r13, r1, PorterDuff.Mode.DST_ATOP);
            this.a.a.setShader(r0);
            this.a.invalidate();
            return;
        L13:
            float r5 = r4;
            r13 = new LinearGradient(0.0f, 0.0f, r5, r4, new int[]{0, -1, 0}, new float[]{0.3f, 0.5f, 0.7f}, Shader.TileMode.CLAMP);
            goto L14
        L8:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        L9:
            r4 = 0.0f;
            goto L11
        }
    }

    public static final class d extends AnimatorListenerAdapter {
        public final /* synthetic */ GiftIconMaskView a;

        public d(GiftIconMaskView r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            GiftIconMaskView r0 = this.a;
            r0.c = false;
            b r1 = r0.h;
            if (r1 == null) goto L6;
            r1.onAnimationEnd(r3);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            GiftIconMaskView r0 = this.a;
            r0.c = true;
            b r1 = r0.h;
            if (r1 == null) goto L6;
            r1.onAnimationStart(r3);
            return;
        }
    }

    static {
    }

    public GiftIconMaskView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public GiftIconMaskView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void b() {
        if (this.e != null) goto L5;
        return;
    L5:
        if (getVisibility() == 8) goto L40;
        ValueAnimator r0 = this.b;
        if (r0 != null) goto L10;
    L20:
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{0.0f, s1.e(40.0f) * 3});
        this.b = r1;
        if (r1 == null) goto L23;
        r1.setDuration(800);
    L23:
        ValueAnimator r2 = this.b;
        if (r2 == null) goto L26;
        r2.addUpdateListener(new c(this));
    L26:
        int r3 = this.f;
        if (r3 <= 0) goto L31;
        ValueAnimator r4 = this.b;
        if (r4 == null) goto L31;
        r4.setRepeatCount(r3);
    L31:
        ValueAnimator r5 = this.b;
        if (r5 == null) goto L34;
        r5.addListener(new d(this));
    L34:
        ValueAnimator r6 = this.b;
        if (r6 == null) goto L39;
        r6.start();
        return;
    L39:
        return;
    L10:
        if (r0.isRunning() != true) goto L20;
        ValueAnimator r7 = this.b;
        if (r7 == null) goto L14;
        r7.cancel();
    L14:
        ValueAnimator r8 = this.b;
        if (r8 == null) goto L17;
        r8.removeAllListeners();
    L17:
        ValueAnimator r9 = this.b;
        if (r9 == null) goto L20;
        r9.removeAllUpdateListeners();
        goto L20
    }

    public final void c() {
        ValueAnimator r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isRunning() != true) goto L17;
        ValueAnimator r1 = this.b;
        if (r1 == null) goto L9;
        r1.cancel();
    L9:
        ValueAnimator r2 = this.b;
        if (r2 == null) goto L12;
        r2.removeAllListeners();
    L12:
        ValueAnimator r3 = this.b;
        if (r3 == null) goto L18;
        r3.removeAllUpdateListeners();
        return;
    L18:
        return;
    }

    public final void a(Bitmap r3) {
        if (r3 == null) goto L5;
        this.d = r3;
        Shader.TileMode r1 = Shader.TileMode.CLAMP;
        this.e = new BitmapShader(r3, r1, r1);
        invalidate();
        return;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r9) {
        Intrinsics.checkNotNullParameter(r9, "canvas");
        super.onDraw(r9);
        Bitmap r0 = this.d;     // Catch: Exception -> L14
        if (r0 == null) goto L13;
        Intrinsics.checkNotNull(r0);     // Catch: Exception -> L14
        if (r0.isRecycled() == false) goto L9;
        return;
    L9:
        if (this.c == false) goto L11;
        r9.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.a);     // Catch: Exception -> L14
    L17:
        return;
    L11:
        this.a.setShader(this.e);     // Catch: Exception -> L14
        r9.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.a);     // Catch: Exception -> L14
        goto L17
    L13:
        return;
    L14:
        e = move-exception;
        e.printStackTrace();
    }

    public final void setOnShaderAinmatorListener(b r2) {
        Intrinsics.checkNotNullParameter(r2, "onShaderAinmatorListener");
        this.h = r2;
    }

    public final void setRepeatCount(int r1) {
        this.f = r1;
    }

    public final void setShaderMode(int r1) {
        this.g = r1;
    }

    public GiftIconMaskView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new Paint();
    }

    public /* synthetic */ GiftIconMaskView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
