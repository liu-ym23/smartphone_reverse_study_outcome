package com.bytedance.android.live.effect.soundeffect;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\rB\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u001b\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0006\u0010\nB#\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/effect/soundeffect/AudioWaveView;", "Landroid/widget/LinearLayout;", "", "getViewAnimatorHeight", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudioWaveView extends LinearLayout {
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
    public final int k;
    public final int l;
    public final long m;
    public boolean n;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.live.effect.soundeffect.AudioWaveView$a$a, reason: collision with other inner class name */
        public static final class C0188a extends AnimatorListenerAdapter {
            public final AudioWaveView a;
            public final ValueAnimator b;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r7) {
                Intrinsics.checkNotNullParameter(r7, "animation");
                AudioWaveView r8 = this.a;
                if (r8.n == false) goto L5;
                return;
            L5:
                ValueAnimator r0 = this.b;
                int r9 = AudioWaveView.a(r8);
                r0.setIntValues(new int[]{this.a.f, r9});
                AudioWaveView r1 = this.a;
                r0.setDuration((r1.m * ((long) r9)) / ((long) r1.e));
                r0.start();
            }

            public C0188a(AudioWaveView r2, ValueAnimator r3) {
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

    public AudioWaveView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public static final /* synthetic */ int a(AudioWaveView r0) {
        return r0.getViewAnimatorHeight();
    }

    public AudioWaveView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "changedView");
        if (r3 == 0) goto L11;
        Iterator<ValueAnimator> r4 = this.b.iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        r4.next().cancel();
        goto L6
    L8:
        this.n = true;
        this.c = null;
        return;
    }

    public AudioWaveView(Context r17, AttributeSet r18, int r19) {
        Intrinsics.checkNotNullParameter(r17, "context");
        super(r17, r18, r19);
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.d = new Random();
        this.n = true;
        int r5 = 0;
        if (r18 == null) goto L7;
        TypedArray r2 = r17.obtainStyledAttributes(r18, new int[]{2130975063, 2130975064, 2130975065, 2130975066, 2130975067, 2130975068, 2130975069, 2130975073, 2130975074});
        if (r2 == null) goto L7;
        this.e = (int) r2.getDimension(5, UIUtils.dip2Px(r17, 24.0f));
        this.f = (int) r2.getDimension(6, UIUtils.dip2Px(r17, 4.0f));
        this.g = (int) r2.getDimension(4, UIUtils.dip2Px(r17, 4.0f));
        this.h = (int) r2.getDimension(8, UIUtils.dip2Px(r17, 2.0f));
        this.i = (int) r2.getDimension(1, UIUtils.dip2Px(r17, 1.0f));
        this.j = r2.getColor(7, ColorProtector.parseColor("#FF6397"));
        this.k = r2.getColor(3, ColorProtector.parseColor("#FF307A"));
        this.l = r2.getInt(2, 13);
        this.m = r2.getInt(0, (int) 300);
        r2.recycle();
    L7:
        int r3 = Color.red(this.j);
        float r6 = (Color.red(this.k) - r3) / this.l;
        int r7 = Color.green(this.j);
        float r8 = (Color.green(this.k) - r7) / this.l;
        int r9 = Color.red(this.j);
        float r11 = Color.blue(this.k) - r9;
        int r12 = this.l;
        float r13 = r11 / r12;
        int r14 = 0;
    L8:
        if (r14 >= r12) goto L10;
        View r15 = new View(r17);
        LinearLayout.LayoutParams r16 = new LinearLayout.LayoutParams(this.h, this.f);
        int r4 = this.g >> 1;
        r16.setMargins(r4, r5, r4, r5);
        r15.setLayoutParams(r16);
        GradientDrawable r21 = new GradientDrawable();
        r21.setCornerRadius(this.i);
        float r110 = r14;
        r21.setColor(Color.rgb(((int) (r6 * r110)) + r3, ((int) (r8 * r110)) + r7, ((int) (r110 * r13)) + r9));
        Unit r22 = Unit.INSTANCE;
        r15.setBackground(r21);
        this.a.add(r15);
        addView(r15);
        ArrayList<ValueAnimator> r23 = this.b;
        ValueAnimator r111 = ValueAnimator.ofInt(new int[]{1, 2});
        r111.setRepeatCount(1);
        r111.setRepeatMode(2);
        r111.setInterpolator(new AccelerateDecelerateInterpolator());
        r111.addUpdateListener(new a.b(r15));
        r111.addListener(new a.C0188a(this, r111));
        r23.add(r111);
        r14 = r14 + 1;
        r5 = 0;
        goto L8
    }
}
