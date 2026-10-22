package com.bytedance.android.livesdk.interactivity.comment.newinput.view;

import android.animation.ValueAnimator;
import android.content.Context;
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
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/newinput/view/AudioRecordBtnView;", "Landroid/view/View;", "Lcom/bytedance/android/livesdk/interactivity/comment/newinput/view/AudioRecordBtnView$c;", "a", "Lcom/bytedance/android/livesdk/interactivity/comment/newinput/view/AudioRecordBtnView$c;", "getListener", "()Lcom/bytedance/android/livesdk/interactivity/comment/newinput/view/AudioRecordBtnView$c;", "setListener", "(Lcom/bytedance/android/livesdk/interactivity/comment/newinput/view/AudioRecordBtnView$c;)V", "listener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "c", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudioRecordBtnView extends View {
    public c a;
    public boolean b;
    public final int c;
    public final long d;
    public int e;
    public final Paint f;
    public final Paint g;
    public final Drawable h;
    public int i;
    public final ValueAnimator j;
    public final d k;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ ValueAnimator a;
        public final /* synthetic */ AudioRecordBtnView b;

        public a(ValueAnimator r1, AudioRecordBtnView r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            AudioRecordBtnView r3 = this.b;
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

        void d(boolean r1);
    }

    public static final class d implements Runnable {
        public final /* synthetic */ AudioRecordBtnView a;

        public d(AudioRecordBtnView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AudioRecordBtnView r0 = this.a;     // Catch: Throwable -> L6
            r0.e = 1;     // Catch: Throwable -> L6
            r0.j.start();     // Catch: Throwable -> L6
            c r1 = this.a.getListener();     // Catch: Throwable -> L6
            if (r1 == null) goto L9;
            r1.c();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    public AudioRecordBtnView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AudioRecordBtnView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a() {
        this.e = 2;
        this.j.cancel();
        this.i = s1.f(60.0f);
        invalidate();
    }

    public final c getListener() {
        return this.a;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r4) {
        Intrinsics.checkNotNullParameter(r4, "canvas");
        super.onDraw(r4);
        float r0 = r4.getWidth() / 2;
        if (this.e == 2) goto L5;
        r4.drawCircle(r0, r0, this.i, this.f);
        r4.drawCircle(r0, r0, (int) UtilityKotlinExtentionsKt.h(79.0f), this.g);
    L5:
        Drawable r1 = this.h;
        if (r1 == null) goto L9;
        r1.draw(r4);
        return;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r7) {
        if (r7 == null) goto L4;
        Integer r0 = Integer.valueOf(r7.getAction());
    L6:
        if (r0 != null) goto L9;
    L11:
        if (r0 != null) goto L14;
    L18:
        if (r0 != null) goto L21;
    L42:
        if (r0 != null) goto L45;
    L49:
        return true;
    L45:
        if (r0.intValue() != 3) goto L49;
        MainThreadPostUtils.d(this.k);
        this.b = true;
        a();
        c r8 = this.a;
        if (r8 == null) goto L49;
        r8.a();
        goto L49
    L21:
        if (r0.intValue() != 2) goto L42;
        int[] r1 = new int[2];
        getLocationOnScreen(r1);
        int r3 = r1[0];
        int r2 = r1[1];
        if (r7.getRawX() >= r3) goto L25;
    L31:
        boolean r9 = false;
    L33:
        if (r9 == this.b) goto L49;
        this.b = r9;
        if (r9 == false) goto L39;
        c r10 = this.a;
        if (r10 == null) goto L49;
        r10.d(false);
        goto L49
    L39:
        c r11 = this.a;
        if (r11 == null) goto L49;
        r11.d(true);
        goto L49
    L25:
        if (r7.getRawX() > (r3 + getWidth())) goto L31;
        if (r7.getRawY() < (r2 - this.c)) goto L31;
        if (r7.getRawY() > ((r2 + getHeight()) + this.c)) goto L31;
        r9 = true;
        goto L33
    L14:
        if (r0.intValue() != 1) goto L18;
        MainThreadPostUtils.d(this.k);
        a();
        c r4 = this.a;
        if (r4 == null) goto L49;
        r4.b(r7);
        goto L49
    L9:
        if (r0.intValue() != 0) goto L11;
        MainThreadPostUtils.d(this.k);
        MainThreadPostUtils.c(this.k, this.d);
        goto L49
    L4:
        r0 = null;
        goto L6
    }

    public final void setListener(c r1) {
        this.a = r1;
    }

    public AudioRecordBtnView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.b = true;
        this.c = 50;
        this.d = 200;
        this.e = 2;
        Paint r6 = new Paint();
        r6.setStyle(Paint.Style.FILL);
        r6.setColor(s1.h(2131108151));
        Unit r1 = Unit.INSTANCE;
        this.f = r6;
        Paint r7 = new Paint();
        r7.setStyle(Paint.Style.STROKE);
        r7.setStrokeWidth(UtilityKotlinExtentionsKt.i(1));
        r7.setColor(s1.h(2131108151));
        this.g = r7;
        Drawable r8 = s1.m(2131251919);
        if (r8 == null) goto L5;
        int r0 = s1.f(19.0f);
        int r2 = s1.f(120.0f) + r0;
        r8.setBounds(r0, r0, r2, r2);
    L6:
        this.h = r8;
        this.i = s1.f(60.0f);
        ValueAnimator r9 = ValueAnimator.ofInt(new int[]{s1.f(60.0f), s1.f(79.0f)});
        r9.setDuration(500);
        r9.setRepeatCount(-1);
        r9.setRepeatMode(2);
        r9.setInterpolator(new LinearInterpolator());
        r9.addUpdateListener(new a(r9, this));
        this.j = r9;
        this.k = new d(this);
        return;
    L5:
        r8 = null;
        goto L6
    }

    public /* synthetic */ AudioRecordBtnView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
