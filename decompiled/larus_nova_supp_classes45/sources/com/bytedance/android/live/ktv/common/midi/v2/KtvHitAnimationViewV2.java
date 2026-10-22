package com.bytedance.android.live.ktv.common.midi.v2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002:\u0005\u0012\u0013\u0014\u0015\u0016B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/ktv/common/midi/v2/KtvHitAnimationViewV2;", "Landroid/widget/RelativeLayout;", "Lqb0/c;", "", "getMaxImageCache", "getAdvancedMaxImageCache", "Landroid/graphics/PointF;", "getStartPoint", "gap", "", "setAnimGap", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "c", "d", "e", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvHitAnimationViewV2 extends RelativeLayout implements qb0.c {
    public d a;
    public d b;
    public final List<RelativeLayout.LayoutParams> c;
    public final float d;
    public float e;
    public final Random f;
    public long g;
    public final int h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;
    public int m;
    public com.bytedance.android.live.ktv.common.midi.g n;
    public final List<Drawable> o;
    public final List<Drawable> p;
    public final List<Drawable> q;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public final View a;

        public a(View r2) {
            Intrinsics.checkNotNullParameter(r2, "target");
            this.a = r2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            Object r4 = r3.getAnimatedValue();
            if (r4 == null) goto L7;
            PointF r5 = (PointF) r4;
            this.a.setX(r5.x);
            this.a.setY(r5.y);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.PointF");
        }
    }

    public static final class b {
    }

    public static final class c implements d {
        public final List<ImageView> a;
        public final List<ImageView> b;
        public final int c;

        @Override // com.bytedance.android.live.ktv.common.midi.v2.KtvHitAnimationViewV2.d
        public final boolean b() {
            if (((ArrayList) this.a).size() <= 0) goto L5;
        L8:
            return true;
        L5:
            if (((ArrayList) this.b).size() < this.c) goto L8;
            return false;
        }

        @Override // com.bytedance.android.live.ktv.common.midi.v2.KtvHitAnimationViewV2.d
        public final void clear() {
            ((ArrayList) this.a).clear();
            ((ArrayList) this.b).clear();
        }

        public c(int r1) {
            this.c = r1;
            this.a = new ArrayList();
            this.b = new ArrayList();
        }

        @Override // com.bytedance.android.live.ktv.common.midi.v2.KtvHitAnimationViewV2.d
        public final void a(ImageView r2) {
            Intrinsics.checkNotNullParameter(r2, "imageView");
            if (((ArrayList) this.b).contains(r2) == false) goto L6;
            ((ArrayList) this.b).remove(r2);
        L6:
            if (((ArrayList) this.a).contains(r2) == true) goto L9;
            ((ArrayList) this.a).add(r2);
            return;
        }

        @Override // com.bytedance.android.live.ktv.common.midi.v2.KtvHitAnimationViewV2.d
        public final ImageView c(Context r3) {
            if (((ArrayList) this.b).size() < this.c) goto L7;
            return null;
        L7:
            if (((ArrayList) this.a).size() <= 0) goto L9;
            ImageView r4 = (ImageView) ListProtector.remove(this.a, 0);
        L10:
            ((ArrayList) this.b).add(r4);
            return r4;
        L9:
            r4 = new ImageView(r3);
            goto L10
        }
    }

    public interface d {
        void a(ImageView r1);

        boolean b();

        ImageView c(Context r1);

        void clear();
    }

    public static final class e implements d {
        public final List<ImageView> a;

        @Override // com.bytedance.android.live.ktv.common.midi.v2.KtvHitAnimationViewV2.d
        public final boolean b() {
            Iterator<T> r0 = this.a.iterator();
            boolean r1 = false;
        L4:
            if (r0.hasNext() == false) goto L8;
            if (((ImageView) r0.next()).getVisibility() == 0) goto L4;
            r1 = true;
            goto L4
        L8:
            return r1;
        }

        @Override // com.bytedance.android.live.ktv.common.midi.v2.KtvHitAnimationViewV2.d
        public final void clear() {
            Iterator<T> r0 = this.a.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((ImageView) r0.next()).setVisibility(4);
            goto L4
        }

        @Override // com.bytedance.android.live.ktv.common.midi.v2.KtvHitAnimationViewV2.d
        public final void a(ImageView r2) {
            Intrinsics.checkNotNullParameter(r2, "imageView");
            r2.setVisibility(4);
        }

        @Override // com.bytedance.android.live.ktv.common.midi.v2.KtvHitAnimationViewV2.d
        public final ImageView c(Context r5) {
            Iterator<T> r6 = this.a.iterator();
            ImageView r0 = null;
        L4:
            if (r6.hasNext() == false) goto L8;
            ImageView r1 = (ImageView) r6.next();
            if (r1.getVisibility() != 4) goto L4;
            r0 = r1;
            goto L4
        L8:
            return r0;
        }

        public e(ViewGroup r5, ViewGroup.LayoutParams r6, int r7) {
            Intrinsics.checkNotNullParameter(r5, "parent");
            Intrinsics.checkNotNullParameter(r6, "layoutParams");
            this.a = new ArrayList();
            Context r0 = r5.getContext();
            int r1 = 0;
        L3:
            if (r1 >= r7) goto L5;
            ImageView r2 = new ImageView(r0);
            r5.addView(r2, r6);
            r2.setVisibility(4);
            ((ArrayList) this.a).add(r2);
            r1 = r1 + 1;
            goto L3
        }
    }

    public static final class f extends AnimatorListenerAdapter {
        public final /* synthetic */ ImageView a;
        public final /* synthetic */ KtvHitAnimationViewV2 b;
        public final /* synthetic */ Ref.ObjectRef c;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationEnd(r2);
            if (KtvSettingHelper.z() == false) goto L5;
            this.a.setVisibility(4);
        L6:
            d r3 = (d) this.c.element;
            if (r3 == null) goto L10;
            r3.a(this.a);
            return;
        L10:
            return;
        L5:
            this.b.removeView(this.a);
            goto L6
        }

        public f(ImageView r1, KtvHitAnimationViewV2 r2, Ref.ObjectRef r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
    }

    public KtvHitAnimationViewV2(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KtvHitAnimationViewV2(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final int getAdvancedMaxImageCache() {
        com.bytedance.android.live.ktv.common.midi.g r0 = this.n;
        if (r0 == null) goto L6;
        return r0.D();
    L6:
        return vm2.h.w();
    }

    private final int getMaxImageCache() {
        com.bytedance.android.live.ktv.common.midi.g r0 = this.n;
        if (r0 != null) goto L7;
        return 4;
    L7:
        return r0.F();
    }

    private final PointF getStartPoint() {
        float r1 = this.d;
        int r2 = this.h;
        return new PointF(r1 - r2, (this.e + this.m) - r2);
    }

    @Override // qb0.c
    public final void b(com.bytedance.android.live.ktv.common.midi.g r4) {
        Intrinsics.checkNotNullParameter(r4, "strategy");
        d r0 = this.b;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        d r1 = this.a;
        if (r1 == null) goto L8;
        r1.clear();
    L8:
        this.n = r4;
        int r5 = this.f.nextInt(this.c.size());
        if (KtvSettingHelper.z() == false) goto L11;
        d r2 = new e(this, (ViewGroup.LayoutParams) ListProtector.get(this.c, r5), getMaxImageCache());
    L12:
        this.a = r2;
        if (KtvSettingHelper.z() == false) goto L15;
        d r3 = new e(this, (ViewGroup.LayoutParams) ListProtector.get(this.c, r5), getAdvancedMaxImageCache());
    L16:
        this.b = r3;
        return;
    L15:
        r3 = new c(getAdvancedMaxImageCache());
        goto L16
    L11:
        r2 = new c(getMaxImageCache());
        goto L12
    }

    @Override // qb0.c
    public void setAnimGap(int r1) {
        this.m = r1;
    }

    public final PointF c(PointF r5, PointF r6) {
        float r0 = r5.x - r6.x;
        int r7 = (int) ((r5.y - r6.y) + 1);
        if (r7 <= 0) goto L5;
        int r8 = this.f.nextInt(r7);
    L6:
        float r2 = r6.x + (r0 / 2);
        float r1 = this.h;
        return new PointF(r2 - r1, (r6.y + r8) - r1);
    L5:
        r8 = 0;
        goto L6
    }

    public KtvHitAnimationViewV2(Context r11, AttributeSet r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        super(r11, r12, r13);
        this.d = s1.f(92.0f);
        this.f = new Random();
        this.g = 2000;
        this.h = s1.f(2.0f);
        this.i = s1.f(70.0f);
        this.j = s1.f(30.0f);
        this.k = s1.f(80.0f);
        this.l = s1.f(40.0f);
        this.m = s1.f(0.0f);
        this.c = CollectionsKt.listOf(new RelativeLayout.LayoutParams(s1.f(14.0f), s1.f(14.0f)));
        this.o = CollectionsKt.listOf(s1.m(2131252074));
        this.p = CollectionsKt.listOf(new Drawable[]{s1.m(2131252074), s1.m(2131252075), s1.m(2131252076), s1.m(2131252077), s1.m(2131252078), s1.m(2131252077), s1.m(2131252078), s1.m(2131252077), s1.m(2131252078)});
        this.q = CollectionsKt.listOf(new Drawable[]{s1.m(2131252074), s1.m(2131252075), s1.m(2131252076)});
    }

    public /* synthetic */ KtvHitAnimationViewV2(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // qb0.c
    public final void a(float r19, float r21, Integer r22, int r23, boolean r24) {
        float r1 = r21;
        boolean r4 = r24;
        if (r4 == true) goto L9;
        d r6 = this.a;
        if (r6 != null) goto L7;
        return;
    L7:
        if (r6.b() == true) goto L9;
        return;
    L9:
        if (r4 == false) goto L15;
        d r7 = this.b;
        if (r7 != null) goto L13;
        return;
    L13:
        if (r7.b() == true) goto L15;
        return;
    L15:
        this.e = r1;
        if (KtvSettingHelper.z() == false) goto L20;
        com.bytedance.android.live.ktv.common.midi.g r8 = this.n;
        if (r8 == null) goto L23;
        List<Drawable> r9 = r8.M(r22, r4);
    L24:
        List<Drawable> r11 = r9;
        int r12 = 0;
        if (r11 != null) goto L27;
    L30:
        boolean r13 = true;
    L32:
        if (r13 == true) goto L34;
    L74:
        if (r23 < 0) goto L179;
        int r2 = 0;
    L76:
        int r14 = this.f.nextInt(r9.size());
        Ref.IntRef r15 = new Ref.IntRef();
        r15.element = this.f.nextInt(this.c.size());
        Ref.BooleanRef r16 = new Ref.BooleanRef();
        if (r4 == false) goto L79;
        boolean r17 = this.f.nextBoolean();
    L80:
        r16.element = r17;
        Ref.ObjectRef r18 = new Ref.ObjectRef();
        if (r4 == false) goto L83;
        d r25 = this.b;
    L84:
        r18.element = r25;
        Drawable r26 = (Drawable) ListProtector.get(r9, r14);
        if (r26 == null) goto L176;
        d r27 = (d) r18.element;
        if (r27 == null) goto L94;
        ImageView r28 = r27.c(getContext());
        if (r28 == null) goto L94;
        r28.setImageDrawable(r26);
        if (KtvSettingHelper.z() == true) goto L93;
        r28.setLayoutParams((ViewGroup.LayoutParams) ListProtector.get(this.c, r15.element));
    L93:
        r28.setX(r19);
        r28.setY(r1);
    L95:
        if (r28 == null) goto L176;
        if (KtvSettingHelper.z() == false) goto L99;
        r28.setVisibility(r12);
    L100:
        boolean r110 = r16.element;
        if (r4 == false) goto L103;
        int r111 = this.k;
    L104:
        if (r4 == false) goto L106;
        int r112 = this.l;
    L107:
        int r5 = this.f.nextInt((r111 * 2) / 3);
        int r29 = this.f.nextInt(r112);
        if (r110 == false) goto L110;
        float r113 = (((this.e + this.m) - r112) + r29) - this.h;
    L111:
        PointF r31 = new PointF(((this.d - r111) + r5) - this.h, r113 % getHeight());
        PointF r32 = getStartPoint();
        if (r4 == false) goto L114;
        int r114 = this.k;
    L115:
        if (r4 == false) goto L117;
        int r115 = this.l;
    L118:
        if (r4 == false) goto L120;
        long r116 = 2500;
    L121:
        float r117 = r32.x - r31.x;
        float r3 = r32.y - r31.y;
        this.g = (long) ((Math.sqrt((r117 * r117) + (r3 * r3)) / ((double) ((int) Math.sqrt((r114 * r114) + (r115 * r115))))) * r116);
        if (KtvSettingHelper.o() == false) goto L124;
    L127:
        ValueAnimator r33 = LiveDegradeFpsAnimator.ofObject(new com.bytedance.android.live.ktv.common.midi.a(c(r32, r31)), new Object[]{r32, r31}).setFpsConfig(KtvSettingHelper.k());
    L128:
        r33.addUpdateListener(new a(r28));
        r33.setTarget(r28);
        r33.setDuration(this.g);
        if (KtvSettingHelper.z() == false) goto L131;
        int r34 = 2;
        ValueAnimator r35 = LiveDegradeFpsAnimator.ofFloat(r28, LiveDegradeFpsAnimator.ROTATION, new float[]{0.0f, 360.0f}).setFpsConfig(KtvSettingHelper.k());
    L132:
        r35.setDuration(this.g);
        Unit r36 = Unit.INSTANCE;
        AnimatorSet r37 = new AnimatorSet();
        Animator[] r38 = new Animator[r34];
        r38[0] = r35;
        r38[1] = r33;
        r37.playTogether(r38);
        if (KtvSettingHelper.o() == false) goto L135;
    L138:
        float[] r39 = new float[r34];
        r39 = {x0494: FILL_ARRAY_DATA  (LINE:83887252), data: [0, 1065353216} // fill-array;
        Animator r41 = LiveDegradeFpsAnimator.ofFloat(r28, LiveDegradeFpsAnimator.ALPHA, r39).setFpsConfig(KtvSettingHelper.k());
    L140:
        if (KtvSettingHelper.o() == false) goto L142;
    L145:
        Animator r42 = LiveDegradeFpsAnimator.ofFloat(r28, LiveDegradeFpsAnimator.SCALE_X, new float[]{0.0f, 1.0f}).setFpsConfig(KtvSettingHelper.k());
    L147:
        if (KtvSettingHelper.o() == false) goto L149;
    L152:
        Animator r43 = LiveDegradeFpsAnimator.ofFloat(r28, LiveDegradeFpsAnimator.SCALE_Y, new float[]{0.0f, 1.0f}).setFpsConfig(KtvSettingHelper.k());
    L153:
        AnimatorSet r118 = new AnimatorSet();
        r118.setDuration(this.g / ((long) 3));
        r118.setInterpolator(new LinearInterpolator());
        r118.playTogether(new Animator[]{r41, r42, r43});
        r118.setTarget(r28);
        if (KtvSettingHelper.o() == false) goto L156;
    L159:
        Animator r44 = LiveDegradeFpsAnimator.ofFloat(r28, LiveDegradeFpsAnimator.ALPHA, new float[]{1.0f, 0.0f}).setFpsConfig(KtvSettingHelper.k());
    L161:
        if (KtvSettingHelper.o() == false) goto L163;
    L166:
        Animator r45 = LiveDegradeFpsAnimator.ofFloat(r28, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.0f, 0.0f}).setFpsConfig(KtvSettingHelper.k());
    L168:
        if (KtvSettingHelper.o() == false) goto L170;
    L173:
        Animator r46 = LiveDegradeFpsAnimator.ofFloat(r28, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.0f, 0.0f}).setFpsConfig(KtvSettingHelper.k());
    L174:
        AnimatorSet r47 = new AnimatorSet();
        r47.setDuration(this.g / ((long) 5));
        r47.setInterpolator(new LinearInterpolator());
        r47.setStartDelay(this.g - r47.getDuration());
        r47.playTogether(new Animator[]{r44, r45, r46});
        r47.setTarget(r28);
        AnimatorSet r48 = new AnimatorSet();
        r48.playTogether(new Animator[]{r118, r37, r47});
        r48.setInterpolator(new LinearInterpolator());
        r48.setTarget(r28);
        r48.addListener(new f(r28, this, r18));
        r48.start();
        goto L176
    L170:
        if (KtvSettingHelper.z() == true) goto L173;
        r46 = ObjectAnimator.ofFloat(r28, View.SCALE_Y, new float[]{1.0f, 0.0f});
        goto L174
    L163:
        if (KtvSettingHelper.z() == true) goto L166;
        r45 = ObjectAnimator.ofFloat(r28, View.SCALE_X, new float[]{1.0f, 0.0f});
        goto L168
    L156:
        if (KtvSettingHelper.z() == true) goto L159;
        r44 = ObjectAnimator.ofFloat(r28, View.ALPHA, new float[]{1.0f, 0.0f});
        goto L161
    L149:
        if (KtvSettingHelper.z() == true) goto L152;
        r43 = ObjectAnimator.ofFloat(r28, View.SCALE_Y, new float[]{0.0f, 1.0f});
        goto L153
    L142:
        if (KtvSettingHelper.z() == true) goto L145;
        r42 = ObjectAnimator.ofFloat(r28, View.SCALE_X, new float[]{0.0f, 1.0f});
        goto L147
    L135:
        if (KtvSettingHelper.z() == true) goto L138;
        float[] r49 = new float[r34];
        r49 = {x048c: FILL_ARRAY_DATA  (LINE:83887244), data: [0, 1065353216} // fill-array;
        r41 = ObjectAnimator.ofFloat(r28, View.ALPHA, r49);
        goto L140
    L131:
        r34 = 2;
        r35 = ObjectAnimator.ofFloat(r28, View.ROTATION, new float[]{0.0f, 360.0f});
        goto L132
    L124:
        if (KtvSettingHelper.z() == true) goto L127;
        r33 = ValueAnimator.ofObject(new com.bytedance.android.live.ktv.common.midi.a(c(r32, r31)), new Object[]{r32, r31});
        goto L128
    L120:
        r116 = 2000;
        goto L121
    L117:
        r115 = this.j;
        goto L118
    L114:
        r114 = this.i;
        goto L115
    L110:
        r113 = (((this.e + this.m) + r112) - r29) + this.h;
        goto L111
    L106:
        r112 = this.j;
        goto L107
    L103:
        r111 = this.i;
        goto L104
    L99:
        addView(r28);
    L94:
        r28 = null;
    L176:
        int r51 = r2;
        if (r51 == r23) goto L183;
        r1 = r21;
        r9 = r9;
        r2 = r51 + 1;
        r12 = 0;
        r4 = r24;
        goto L76
    L183:
        return;
    L83:
        r25 = this.a;
        goto L84
    L79:
        r17 = true;
        goto L80
    L179:
        return;
    L34:
        if (KtvSettingHelper.z() == false) goto L54;
        if (r22 != null) goto L38;
    L40:
        if (r22 != null) goto L43;
    L45:
        if (r22 != null) goto L48;
    L52:
        List<Drawable> r52 = this.o;
    L64:
        r9 = r52;
        goto L74
    L48:
        if (r22.intValue() != 3) goto L52;
        if (r4 == false) goto L51;
        r52 = this.p;
        goto L64
    L51:
        r52 = this.q;
        goto L64
    L43:
        if (r22.intValue() != 2) goto L45;
    L44:
        r52 = this.o;
        goto L64
    L38:
        if (r22.intValue() != 1) goto L40;
    L54:
        if (r22 != null) goto L57;
    L59:
        if (r22 != null) goto L62;
    L65:
        if (r22 != null) goto L68;
    L73:
        r52 = CollectionsKt.listOf(s1.m(2131252074));
        goto L64
    L68:
        if (r22.intValue() != 3) goto L73;
        if (r4 == false) goto L72;
        r52 = CollectionsKt.listOf(new Drawable[]{s1.m(2131252074), s1.m(2131252075), s1.m(2131252076), s1.m(2131252077), s1.m(2131252078), s1.m(2131252077), s1.m(2131252078), s1.m(2131252077), s1.m(2131252078)});
        goto L64
    L72:
        r52 = CollectionsKt.listOf(new Drawable[]{s1.m(2131252074), s1.m(2131252075), s1.m(2131252076)});
        goto L64
    L62:
        if (r22.intValue() != 2) goto L65;
    L63:
        r52 = CollectionsKt.listOf(s1.m(2131252074));
        goto L64
    L57:
        if (r22.intValue() != 1) goto L59;
    L27:
        if (r11.isEmpty() == true) goto L30;
        r13 = false;
    L23:
        r9 = null;
        goto L24
    L20:
        com.bytedance.android.live.ktv.common.midi.g r53 = this.n;
        if (r53 == null) goto L23;
        r9 = r53.N(r22, r4);
        goto L24
    }
}
