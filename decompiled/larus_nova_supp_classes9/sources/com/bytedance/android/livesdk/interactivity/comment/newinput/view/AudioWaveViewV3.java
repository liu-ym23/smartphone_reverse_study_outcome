package com.bytedance.android.livesdk.interactivity.comment.newinput.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.UIUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\rB\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u001b\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0006\u0010\nB#\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/newinput/view/AudioWaveViewV3;", "Landroid/widget/LinearLayout;", BuildConfig.FLAVOR, "getViewAnimatorHeight", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudioWaveViewV3 extends LinearLayout {
    public final ArrayList<View> a;
    public final ArrayList<ValueAnimator> b;
    public volatile short[] c;
    public final Random d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public final long k;
    public boolean l;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.comment.newinput.view.AudioWaveViewV3$a$a, reason: collision with other inner class name */
        public static final class C0129a extends AnimatorListenerAdapter {
            public final AudioWaveViewV3 a;
            public final ValueAnimator b;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r7) {
                Intrinsics.checkNotNullParameter(r7, "animation");
                AudioWaveViewV3 r8 = this.a;
                if (r8.l == false) goto L5;
                return;
            L5:
                ValueAnimator r0 = this.b;
                int r9 = AudioWaveViewV3.a(r8);
                r0.setIntValues(new int[]{this.a.f, r9});
                AudioWaveViewV3 r1 = this.a;
                r0.setDuration((r1.k * ((long) r9)) / ((long) r1.e));
                r0.start();
            }

            public C0129a(AudioWaveViewV3 r2, ValueAnimator r3) {
                Intrinsics.checkNotNullParameter(r2, "waveView");
                Intrinsics.checkNotNullParameter(r3, "animator");
                this.a = r2;
                this.b = r3;
            }
        }

        public static final class b implements ValueAnimator.AnimatorUpdateListener {
            public final View a;

            public b(View r2) {
                Intrinsics.checkNotNullParameter(r2, "animatorView");
                this.a = r2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator r3) {
                Intrinsics.checkNotNullParameter(r3, "animation");
                View r0 = this.a;
                ViewGroup.LayoutParams r1 = r0.getLayoutParams();
                Object r4 = r3.getAnimatedValue();
                if (r4 == null) goto L7;
                r1.height = ((Integer) r4).intValue();
                r0.requestLayout();
                return;
            L7:
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
        }
    }

    static {
    }

    public final void b() {
        this.l = false;
        Iterator<ValueAnimator> r1 = this.b.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ValueAnimator r2 = r1.next();
        int r3 = getViewAnimatorHeight();
        r2.setIntValues(new int[]{this.f, r3});
        r2.setDuration((this.k * ((long) r3)) / ((long) this.e));
        r2.start();
        goto L4
    }

    private final int getViewAnimatorHeight() {
        if (this.c == null) goto L19;
        short[] r0 = this.c;
        Intrinsics.checkNotNull(r0);
        if (r0.length != 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L19;
        short[] r2 = this.c;
        Intrinsics.checkNotNull(r2);
        Random r3 = this.d;
        short[] r4 = this.c;
        Intrinsics.checkNotNull(r4);
        float r5 = (3 * Math.abs(r2[r3.nextInt(r4.length)])) / 32767;
        double r6 = r5;
        if (r6 <= 0.6d) goto L14;
        return this.e;
    L14:
        if (r6 < 0.1d) goto L21;
        int r7 = this.e;
        int r8 = this.f;
        return RangesKt.coerceAtMost((int) (((r7 - r8) * r5) + r8), r7);
    L21:
        return this.f;
    L7:
        r1 = false;
    L19:
        return this.f;
    }

    public final void c() {
        Iterator<ValueAnimator> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().cancel();
        goto L4
    L6:
        this.l = true;
        this.c = null;
    }

    public AudioWaveViewV3(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public static final /* synthetic */ int a(AudioWaveViewV3 r0) {
        return r0.getViewAnimatorHeight();
    }

    public AudioWaveViewV3(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "changedView");
        if (r3 != 0) goto L5;
        return;
    L5:
        if (isAttachedToWindow() == false) goto L9;
        c();
        return;
    }

    public AudioWaveViewV3(Context r8, AttributeSet r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, r10);
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.d = new Random();
        this.l = true;
        if (r9 == null) goto L7;
        TypedArray r11 = r8.obtainStyledAttributes(r9, new int[]{2130975063, 2130975064, 2130975065, 2130975066, 2130975067, 2130975068, 2130975069, 2130975073, 2130975074});
        if (r11 == null) goto L7;
        this.e = (int) r11.getDimension(5, UIUtils.dip2Px(r8, 24.0f));
        this.f = (int) r11.getDimension(6, UIUtils.dip2Px(r8, 4.0f));
        this.g = (int) r11.getDimension(4, UIUtils.dip2Px(r8, 4.0f));
        this.h = (int) r11.getDimension(8, UIUtils.dip2Px(r8, 2.0f));
        this.i = (int) r11.getDimension(1, UIUtils.dip2Px(r8, 1.0f));
        this.j = r11.getInt(2, 13);
        this.k = r11.getInt(0, (int) 300);
        r11.recycle();
    L7:
        int r13 = this.j;
        int r2 = 0;
    L8:
        if (r2 >= r13) goto L10;
        View r3 = new View(r8);
        LinearLayout.LayoutParams r4 = new LinearLayout.LayoutParams(this.h, this.f);
        int r5 = this.g >> 1;
        r4.setMargins(r5, 0, r5, 0);
        r3.setLayoutParams(r4);
        GradientDrawable r6 = new GradientDrawable();
        r6.setCornerRadius(this.i);
        r6.setColor(-1);
        Unit r7 = Unit.INSTANCE;
        r3.setBackground(r6);
        this.a.add(r3);
        addView(r3);
        ArrayList<ValueAnimator> r14 = this.b;
        ValueAnimator r15 = ValueAnimator.ofInt(new int[]{1, 2});
        r15.setRepeatCount(1);
        r15.setRepeatMode(2);
        r15.setInterpolator(new AccelerateDecelerateInterpolator());
        r15.addUpdateListener(new a.b(r3));
        r15.addListener(new a.C0129a(this, r15));
        r14.add(r15);
        r2 = r2 + 1;
        goto L8
    }
}
