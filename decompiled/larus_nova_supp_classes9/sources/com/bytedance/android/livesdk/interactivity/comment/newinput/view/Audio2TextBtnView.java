package com.bytedance.android.livesdk.interactivity.comment.newinput.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.bdlocation.BuildConfig;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0014\u0015B\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rB\u001b\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\f\u0010\u0010B#\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\f\u0010\u0013R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/newinput/view/Audio2TextBtnView;", "Landroid/view/View;", "Lcom/bytedance/android/livesdk/interactivity/comment/newinput/view/Audio2TextBtnView$c;", "d", "Lcom/bytedance/android/livesdk/interactivity/comment/newinput/view/Audio2TextBtnView$c;", "getListener", "()Lcom/bytedance/android/livesdk/interactivity/comment/newinput/view/Audio2TextBtnView$c;", "setListener", "(Lcom/bytedance/android/livesdk/interactivity/comment/newinput/view/Audio2TextBtnView$c;)V", "listener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BuildConfig.FLAVOR, "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "c", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Audio2TextBtnView extends View {
    public final float a;
    public final float b;
    public final long c;
    public c d;
    public int e;
    public final Paint f;
    public final Paint g;
    public final Drawable h;
    public int i;
    public final ValueAnimator j;
    public final d k;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ ValueAnimator a;
        public final /* synthetic */ Audio2TextBtnView b;

        public a(ValueAnimator r1, Audio2TextBtnView r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            Audio2TextBtnView r3 = this.b;
            Object r0 = this.a.getAnimatedValue();
            if (r0 == null) goto L7;
            r3.i = ((Integer) r0).intValue();
            this.b.invalidate();
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    public static final class b {
    }

    public interface c {
        void a();

        void b(MotionEvent r1);

        void c();
    }

    public static final class d implements Runnable {
        public final /* synthetic */ Audio2TextBtnView a;

        public d(Audio2TextBtnView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Audio2TextBtnView r0 = this.a;     // Catch: Throwable -> L12
            r0.e = 1;     // Catch: Throwable -> L12
            Drawable r1 = r0.h;     // Catch: Throwable -> L12
            if (r1 == null) goto L5;
            float r2 = r0.b;     // Catch: Throwable -> L12
            float r3 = r0.a;     // Catch: Throwable -> L12
            int r4 = (int) (r2 - r3);     // Catch: Throwable -> L12
            int r5 = ((int) (r3 * 2)) + r4;     // Catch: Throwable -> L12
            r1.setBounds(r4, r4, r5, r5);     // Catch: Throwable -> L12
        L5:
            ValueAnimator r6 = r0.j;     // Catch: Throwable -> L12
            if (r6 == null) goto L8;
            r6.start();     // Catch: Throwable -> L12
        L8:
            c r7 = this.a.getListener();     // Catch: Throwable -> L12
            if (r7 == null) goto L15;
            r7.c();     // Catch: Throwable -> L12
            return;
        L15:
            return;
        L12:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        }
    }

    static {
    }

    public final void a() {
        this.e = 2;
        ValueAnimator r0 = this.j;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.i = (int) this.a;
        invalidate();
    }

    public final c getListener() {
        return this.d;
    }

    public Audio2TextBtnView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r4) {
        Intrinsics.checkNotNullParameter(r4, "canvas");
        super.onDraw(r4);
        float r0 = r4.getWidth() / 2;
        if (this.e == 2) goto L5;
        r4.drawCircle(r0, r0, this.i, this.f);
        r4.drawCircle(r0, r0, this.b, this.g);
    L5:
        Drawable r1 = this.h;
        if (r1 == null) goto L9;
        r1.draw(r4);
        return;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r5) {
        if (r5 == null) goto L4;
        Integer r0 = Integer.valueOf(r5.getAction());
    L6:
        if (r0 != null) goto L9;
    L11:
        if (r0 != null) goto L14;
    L18:
        if (r0 != null) goto L21;
    L23:
        if (r0 != null) goto L26;
    L30:
        return true;
    L26:
        if (r0.intValue() != 3) goto L30;
        MainThreadPostUtils.d(this.k);
        a();
        c r6 = this.d;
        if (r6 == null) goto L30;
        r6.a();
        goto L30
    L21:
        if (r0.intValue() != 2) goto L23;
    L14:
        if (r0.intValue() != 1) goto L18;
        MainThreadPostUtils.d(this.k);
        a();
        c r1 = this.d;
        if (r1 == null) goto L30;
        r1.b(r5);
        goto L30
    L9:
        if (r0.intValue() != 0) goto L11;
        MainThreadPostUtils.d(this.k);
        MainThreadPostUtils.c(this.k, this.c);
        goto L30
    L4:
        r0 = null;
        goto L6
    }

    public final void setListener(c r1) {
        this.d = r1;
    }

    public Audio2TextBtnView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public Audio2TextBtnView(Context r7, AttributeSet r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r9);
        this.a = 60.0f;
        this.b = 79.0f;
        this.c = 200;
        this.e = 2;
        Paint r2 = new Paint();
        r2.setStyle(Paint.Style.FILL);
        r2.setColor(s1.h(2131108150));
        Unit r4 = Unit.INSTANCE;
        this.f = r2;
        Paint r3 = new Paint();
        r3.setStyle(Paint.Style.STROKE);
        r3.setStrokeWidth(UtilityKotlinExtentionsKt.i(1));
        r3.setColor(s1.h(2131108150));
        this.g = r3;
        Drawable r5 = s1.m(2131251916);
        if (r5 == null) goto L5;
        int r0 = (int) (79.0f - 60.0f);
        int r6 = ((int) (2 * 60.0f)) + r0;
        r5.setBounds(r0, r0, r6, r6);
    L6:
        this.h = r5;
        this.i = (int) 60.0f;
        this.k = new d(this);
        TypedArray r10 = r7.obtainStyledAttributes(r8, new int[]{2130970358, 2130973419});
        if (r10 == null) goto L13;
        float r1 = r10.getDimension(0, 0.0f);
        this.a = r1;
        float r11 = r10.getDimension(1, 0.0f);
        this.b = r11;
        if (r5 == null) goto L11;
        int r13 = (int) (r11 - r1);
        int r14 = ((int) (2 * r1)) + r13;
        r5.setBounds(r13, r13, r14, r14);
    L11:
        ValueAnimator r15 = ValueAnimator.ofInt(new int[]{(int) r1, (int) r11});
        r15.setDuration(500);
        r15.setRepeatCount(-1);
        r15.setRepeatMode(2);
        r15.setInterpolator(new LinearInterpolator());
        r15.addUpdateListener(new a(r15, this));
        this.j = r15;
        r10.recycle();
        return;
    L13:
        return;
    L5:
        r5 = null;
        goto L6
    }
}
