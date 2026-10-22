package com.bytedance.android.livesdk.interactivity.like.view;

import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.config.eg;
import com.bytedance.android.livesdk.interactivity.api.base.utils.InteractivityOpt;
import com.bytedance.android.livesdk.interactivity.api.like.utils.DiggABHelper;
import com.bytedance.android.livesdk.interactivity.common.ViewPool;
import com.bytedance.android.livesdk.interactivity.like.utils.LikeAnimUtil;
import com.bytedance.android.livesdk.interactivity.like.w0;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.android.livesdk.utils.u4;
import com.bytedance.android.livesdk.widget.opt.MeasureOptFrameLayout;
import com.bytedance.bdlocation.BuildConfig;
import ec2.q0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.random.Random;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0003\r\u000e\u000fB\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tB!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/like/view/BottomSelfDiggOptimizeView;", "Lcom/bytedance/android/livesdk/widget/opt/MeasureOptFrameLayout;", "Lcom/bytedance/android/livesdk/interactivity/like/view/z;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attributeSet", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BuildConfig.FLAVOR, "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "c", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BottomSelfDiggOptimizeView extends MeasureOptFrameLayout implements z {
    public static final /* synthetic */ int h = 0;
    public final List<w0> a;
    public final boolean b;
    public final ViewPool c;
    public final List<Path> d;
    public int e;
    public boolean f;
    public int g;

    public static final class a {
    }

    public final class b implements w0 {
        public float a;
        public final Boolean b;
        public final ValueAnimator c;
        public final q4.b d;
        public ImageView e;
        public final d0 f;
        public final long g;
        public final /* synthetic */ BottomSelfDiggOptimizeView h;

        @Override // com.bytedance.android.livesdk.interactivity.like.w0
        public final void clear() {
            if (this.b.booleanValue() == true) goto L10;
            q4.j.getClass();
            if (q4.a.a() == true) goto L10;
            ValueAnimator r0 = this.c;
            if (r0 == null) goto L14;
            r0.cancel();
            return;
        L14:
            return;
        L10:
            q4.b r1 = this.d;
            if (r1 == null) goto L16;
            r1.a();
            return;
        }

        @Override // com.bytedance.android.livesdk.interactivity.like.w0
        public final void pause() {
            if (this.b.booleanValue() == true) goto L10;
            q4.j.getClass();
            if (q4.a.a() == true) goto L10;
            ValueAnimator r0 = this.c;
            if (r0 == null) goto L14;
            r0.pause();
            return;
        L14:
            return;
        L10:
            q4.b r1 = this.d;
            if (r1 == null) goto L16;
            r1.a.c.pause();
            return;
        }

        @Override // com.bytedance.android.livesdk.interactivity.like.w0
        public final void resume() {
            if (this.b.booleanValue() == true) goto L10;
            q4.j.getClass();
            if (q4.a.a() == true) goto L10;
            ValueAnimator r0 = this.c;
            if (r0 == null) goto L14;
            r0.resume();
            return;
        L14:
            return;
        L10:
            q4.b r1 = this.d;
            if (r1 == null) goto L16;
            r1.a.c.resume();
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(BottomSelfDiggOptimizeView r19, Bitmap r20, PointF r21, PointF r23, d0 r24, long r25) {
            Intrinsics.checkNotNullParameter(r20, "iconBitmap");
            Intrinsics.checkNotNullParameter(r21, "startPoint");
            Intrinsics.checkNotNullParameter(r23, "endPoint");
            Intrinsics.checkNotNullParameter(r24, "styleInfo");
            this.h = r19;
            this.f = r24;
            this.g = r25;
            Boolean r7 = (Boolean) InteractivityOpt.c(eg.a);
            this.b = r7;
            long r9 = System.nanoTime();
            int r11 = r24.i;
            int r13 = r24.j;
            float r14 = r24.l;
            float r15 = r24.k;
            float r16 = r24.m;
            float r10 = r24.n;
            ImageView r17 = r19.c.a();
            int r5 = 0;
            if (r17 != null) goto L5;
            r17 = new ImageView(r19.getContext());
            r17.setScaleType(ImageView.ScaleType.FIT_CENTER);
            r19.addView(r17, new ViewGroup.LayoutParams(r11, r13));
            r17.layout(0, 0, r11, r13);
        L5:
            r17.setImageBitmap(r20);
            r17.getLayoutParams().height = r13;
            r17.getLayoutParams().width = r11;
            r17.setRotation(r16);
            r17.setScaleX(r14);
            r17.setScaleY(r14);
            r17.setAlpha(r15);
            r17.setTranslationZ(r10);
            this.e = r17;
            if (r7.booleanValue() == true) goto L19;
            q4.j.getClass();
            if (q4.a.a() == true) goto L19;
            long r18 = r24.p;
            Ref.IntRef r1 = new Ref.IntRef();
            r1.element = 0;
            this.a = 0.0f;
            ImageView r110 = this.e;
            if (r110 == null) goto L13;
            r110.setAlpha(r19.g / 255.0f);
        L13:
            PropertyValuesHolder[] r8 = new PropertyValuesHolder[3];
            Keyframe r2 = Keyframe.ofObject(1.0f, r23);
            r2.setInterpolator(r24.o);
            Unit r3 = Unit.INSTANCE;
            PropertyValuesHolder r4 = PropertyValuesHolder.ofKeyframe("total", new Keyframe[]{Keyframe.ofObject(0.0f, r21), r2});
            r4.setEvaluator(new r82.b());
            r8[0] = r4;
            Keyframe r6 = Keyframe.ofFloat(250.0f / r18, 1.0f);
            r6.setInterpolator((TimeInterpolator) LikeAnimUtil.a.getValue());
            r8[1] = PropertyValuesHolder.ofKeyframe("iconScale", new Keyframe[]{Keyframe.ofFloat(0.0f, 0.0f), r6, Keyframe.ofFloat(1.0f, 1.0f)});
            if (r19.f == false) goto L16;
            PropertyValuesHolder r0 = (PropertyValuesHolder) LikeAnimUtil.e.getValue();
        L17:
            r8[2] = r0;
            ValueAnimator r26 = ValueAnimator.ofPropertyValuesHolder(r8);
            r26.setDuration(r18);
            r26.setInterpolator(new LinearInterpolator());
            r26.addUpdateListener(new com.bytedance.android.livesdk.interactivity.like.view.b(this, r18, r1));
            r26.addListener(new com.bytedance.android.livesdk.interactivity.like.view.c(this, r1));
            r26.setStartDelay(r25);
            r26.start();
            this.c = r26;
            Boolean r27 = com.bytedance.android.livesdk.interactivity.like.utils.k.a;
            com.bytedance.android.livesdk.interactivity.like.utils.k.d += System.nanoTime() - r9;
            com.bytedance.android.livesdk.interactivity.like.utils.k.e++;
            return;
        L16:
            r0 = (PropertyValuesHolder) LikeAnimUtil.d.getValue();
        L19:
            if ((!((ArrayList) r19.d).isEmpty()) == false) goto L22;
        L24:
            long r28 = this.g;
            long r29 = this.f.p;
            com.bytedance.android.livesdk.interactivity.like.utils.a r30 = new com.bytedance.android.livesdk.interactivity.like.utils.a(0.0f, 1.0f, 0.0f, 250.0f / r29);
            com.bytedance.android.livesdk.interactivity.like.utils.a r111 = new com.bytedance.android.livesdk.interactivity.like.utils.a(this.h.g, 0.0f, 0.75f, 1.0f);
            ImageView r31 = this.e;
            if (r31 == null) goto L27;
            r31.setAlpha(this.h.g / 255.0f);
        L27:
            q4.b r33 = u4.b(true, new BottomSelfDiggOptimizeView$OthersLikeAnimation$createFrameAnimator$1(this, r29, r28, r30, r111));
            this.d = r33;
            r33.c();
            return;
        L22:
            if (r5 >= 5) goto L24;
            int r34 = Random.Default.nextInt(-16, 16);
            int r35 = g.b;
            Path r36 = new Path();
            float r37 = r34;
            r36.moveTo(s1.f(41.0f) + r37, s1.f(200.0f));
            r36.quadTo((s1.f(41.0f) + r37) - (r35 / 2), s1.f(150.0f) / 2, s1.f(41.0f) + r37, s1.f(112.0f));
            ((ArrayList) r19.d).add(r36);
            r5 = r5 + 1;
            goto L22
        }
    }

    public final class c implements w0 {
        public float a;
        public float b;
        public final ValueAnimator c;
        public ImageView d;
        public ImageView e;
        public final d0 f;
        public final /* synthetic */ BottomSelfDiggOptimizeView g;

        @Override // com.bytedance.android.livesdk.interactivity.like.w0
        public final void clear() {
            this.c.cancel();
        }

        @Override // com.bytedance.android.livesdk.interactivity.like.w0
        public final void pause() {
            this.c.pause();
        }

        @Override // com.bytedance.android.livesdk.interactivity.like.w0
        public final void resume() {
            this.c.resume();
        }

        public final ImageView a(Bitmap r4, int r5, int r6, float r7, float r8, float r9, float r10) {
            ImageView r0 = this.g.c.a();
            if (r0 != null) goto L5;
            r0 = new ImageView(this.g.getContext());
            r0.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.g.addView(r0, new ViewGroup.LayoutParams(r5, r6));
            r0.layout(0, 0, r5, r6);
        L5:
            r0.setImageBitmap(r4);
            r0.getLayoutParams().height = r6;
            r0.getLayoutParams().width = r5;
            r0.setRotation(r9);
            r0.setScaleX(r7);
            r0.setScaleY(r7);
            r0.setAlpha(r8);
            r0.setTranslationZ(r10);
            return r0;
        }

        public c(BottomSelfDiggOptimizeView r25, Bitmap r26, PointF r27, PointF r28, d0 r29, boolean r30, Bitmap r31, long r33, int r34) {
            if ((r34 & 16) == 0) goto L5;
            boolean r14 = false;
        L7:
            if ((r34 & 32) == 0) goto L9;
            Bitmap r1 = null;
        L11:
            if ((r34 & 64) == 0) goto L13;
            long r6 = 0;
        L14:
            Intrinsics.checkNotNullParameter(r26, "iconBitmap");
            Intrinsics.checkNotNullParameter(r27, "startPoint");
            Intrinsics.checkNotNullParameter(r28, "endPoint");
            Intrinsics.checkNotNullParameter(r29, "styleInfo");
            this.g = r25;
            this.f = r29;
            this.a = 1.0f;
            if (r1 == null) goto L17;
            long r17 = r6;
            this.d = a(r1, r29.a, r29.b, r29.d, r29.c, r29.e, r29.f);
        L18:
            this.e = a(r26, r29.i, r29.j, r29.l, r29.k, r29.m, r29.n);
            long r0 = r29.p;
            Random.Default r2 = Random.Default;
            long r3 = r2.nextLong(250, 500);
            if (r14 == false) goto L21;
            int r4 = r2.nextInt(100, 200);
            int r19 = BottomSelfDiggOptimizeView.h;
            r25.getClass();
            long r15 = ((long) (r4 / 2)) + r3;
            Keyframe r11 = Keyframe.ofObject(1.0f, r28);
            r11.setInterpolator(r29.g);
            Unit r10 = Unit.INSTANCE;
            PropertyValuesHolder r7 = PropertyValuesHolder.ofKeyframe("total", new Keyframe[]{Keyframe.ofObject(0.0f, r27), r11});
            r7.setEvaluator(new r82.b());
            float r8 = r3;
            float r9 = 1000;
            float r13 = r8 / r9;
            float r16 = (50 + r8) / r9;
            Keyframe r5 = Keyframe.ofFloat(r16, 1.3f);
            r5.setInterpolator(LikeAnimUtil.a());
            Keyframe[] r18 = {Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(r13, 1.0f), r5, Keyframe.ofFloat(1.0f, 1.3f)};
            float r20 = 255;
            Keyframe r21 = Keyframe.ofInt((75 + r8) / r9, 0);
            r21.setInterpolator(r29.h);
            Keyframe[] r23 = {Keyframe.ofInt(0.0f, (int) (r29.c * r20)), Keyframe.ofInt(r13, (int) (r29.c * r20)), r21, Keyframe.ofInt(1.0f, 0)};
            Keyframe r24 = Keyframe.ofFloat(r16, 1.1f);
            r24.setInterpolator(LikeAnimUtil.a());
            float r35 = 100 + r8;
            float r110 = r35 / r9;
            Keyframe r111 = Keyframe.ofFloat(r110, 0.9f);
            r111.setInterpolator(LikeAnimUtil.a());
            Keyframe r36 = Keyframe.ofFloat((r35 + 1) / r9, 1.1f);
            r36.setInterpolator(LikeAnimUtil.a());
            Keyframe r37 = Keyframe.ofFloat((r8 + 200) / r9, 1.0f);
            r37.setInterpolator(LikeAnimUtil.a());
            Keyframe[] r38 = {Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(r13, 1.0f), r24, r111, r36, r37, Keyframe.ofFloat(1.0f, 1.0f)};
            Keyframe r39 = Keyframe.ofInt(r110, r25.g);
            r39.setInterpolator(LikeAnimUtil.a());
            Keyframe[] r40 = {Keyframe.ofInt(0.0f, 0), Keyframe.ofInt(r16, 0), r39, Keyframe.ofInt(1.0f, r25.g)};
            Keyframe r41 = Keyframe.ofInt(r15 / r9, r25.g);
            r41.setInterpolator(new DecelerateInterpolator());
            ValueAnimator r43 = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{r7, (PropertyValuesHolder) LikeAnimUtil.f.getValue(), (PropertyValuesHolder) LikeAnimUtil.g.getValue(), PropertyValuesHolder.ofKeyframe("selfScale", r18), PropertyValuesHolder.ofKeyframe("selfAlpha", r23), PropertyValuesHolder.ofKeyframe("iconScale", r38), PropertyValuesHolder.ofKeyframe("iconAlpha", r40), PropertyValuesHolder.ofKeyframe("iconAlpha2", new Keyframe[]{Keyframe.ofInt(0.0f, r25.g), r41, Keyframe.ofInt(1.0f, 0)})});
            r43.setDuration(1000);
            r43.addUpdateListener(new d(this, r3, r15));
            ValueAnimator r44 = r43;
            long r45 = r0;
        L28:
            r44.setDuration(r45);
            r44.setInterpolator(new LinearInterpolator());
            r44.addListener(new f(this));
            r44.setStartDelay(r17);
            r44.start();
            this.c = r44;
            return;
        L21:
            this.a = 0.0f;
            ImageView r46 = this.d;
            if (r46 == null) goto L24;
            r46.setAlpha(0.0f);
        L24:
            this.b = 0.0f;
            ImageView r47 = this.e;
            if (r47 == null) goto L27;
            r47.setAlpha(r25.g / 255.0f);
        L27:
            Keyframe r48 = Keyframe.ofObject(1.0f, r28);
            r48.setInterpolator(r29.o);
            Unit r49 = Unit.INSTANCE;
            PropertyValuesHolder r50 = PropertyValuesHolder.ofKeyframe("total", new Keyframe[]{Keyframe.ofObject(0.0f, r27), r48});
            r50.setEvaluator(new r82.a());
            r45 = r0;
            float r51 = r45;
            Keyframe r53 = Keyframe.ofFloat(250.0f / r51, 1.0f);
            r53.setInterpolator((TimeInterpolator) LikeAnimUtil.a.getValue());
            Keyframe[] r54 = {Keyframe.ofFloat(0.0f, 0.0f), r53, Keyframe.ofFloat(1.0f, 1.0f)};
            Keyframe r55 = Keyframe.ofInt(1.0f, 0);
            r55.setInterpolator(LikeAnimUtil.a());
            r44 = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{r50, PropertyValuesHolder.ofKeyframe("iconScale", r54), PropertyValuesHolder.ofKeyframe("iconAlpha", new Keyframe[]{Keyframe.ofInt(0.0f, r25.g), Keyframe.ofInt((r45 - (r45 / ((long) 4))) / r51, r25.g), r55})});
            r44.setDuration(r45);
            r44.addUpdateListener(new e(this, r45));
            goto L28
        L17:
            r17 = r6;
            goto L18
        L13:
            r6 = r33;
            goto L14
        L9:
            r1 = r31;
            goto L11
        L5:
            r14 = r30;
            goto L7
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.like.view.z
    public final void load() {
    }

    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
    }

    @Override // com.bytedance.android.livesdk.interactivity.like.view.z
    public final void clear() {
        Iterator<w0> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        w0 r1 = r0.next();
        r0.remove();
        r1.clear();
        goto L4
    }

    public BottomSelfDiggOptimizeView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = new LinkedList();
        this.b = ((fc2.b) q0.a.getValue()).diggHWEnable;
        this.c = new ViewPool(DiggABHelper.a().b());
        this.d = new ArrayList(0);
        this.g = 75;
    }

    public BottomSelfDiggOptimizeView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attributeSet");
        super(r2, r3);
        this.a = new LinkedList();
        this.b = ((fc2.b) q0.a.getValue()).diggHWEnable;
        this.c = new ViewPool(DiggABHelper.a().b());
        this.d = new ArrayList(0);
        this.g = 75;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r1, int r2) {
        setMeasuredDimension(View.MeasureSpec.getSize(r1), View.MeasureSpec.getSize(r2));
    }

    public BottomSelfDiggOptimizeView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attributeSet");
        super(r2, r3, r4);
        this.a = new LinkedList();
        this.b = ((fc2.b) q0.a.getValue()).diggHWEnable;
        this.c = new ViewPool(DiggABHelper.a().b());
        this.d = new ArrayList(0);
        this.g = 75;
    }

    public final void b(Bitmap r11, PointF r13, PointF r14, long r15) {
        Intrinsics.checkNotNullParameter(r11, "iconBitmap");
        Intrinsics.checkNotNullParameter(r13, "startPointOnScreen");
        Intrinsics.checkNotNullParameter(r14, "endPointOnScreen");
        List<w0> r0 = this.a;
        LinkedList r1 = (LinkedList) r0;
        r1.add(new b(this, r11, r13, r14, g.a(7), r15));
    }

    public final void c(Bitmap r15, Bitmap r16, PointF r17, PointF r18, int r19) {
        Intrinsics.checkNotNullParameter(r15, "selfBitmap");
        Intrinsics.checkNotNullParameter(r16, "iconBitmap");
        Intrinsics.checkNotNullParameter(r17, "startPointOnScreen");
        Intrinsics.checkNotNullParameter(r18, "endPointOnScreen");
        List<w0> r13 = this.a;
        LinkedList r14 = (LinkedList) r13;
        r14.add(new c(this, r16, r17, r18, g.a(r19), true, r15, 0, 64));
    }

    public final void d(Bitmap r15, PointF r16, PointF r17, int r18, long r19) {
        Intrinsics.checkNotNullParameter(r15, "iconBitmap");
        Intrinsics.checkNotNullParameter(r16, "startPointOnScreen");
        Intrinsics.checkNotNullParameter(r17, "endPointOnScreen");
        List<w0> r13 = this.a;
        LinkedList r14 = (LinkedList) r13;
        r14.add(new c(this, r15, r16, r17, g.a(r18), false, null, r19, 48));
    }

    @Override // com.bytedance.android.livesdk.interactivity.like.view.z
    public final void a(Bitmap r3, PointF r4, PointF r5, int r6, float r7, f32.i r8) {
        Intrinsics.checkNotNullParameter(r3, "bitmap");
        Intrinsics.checkNotNullParameter(r4, "startPointOnScreen");
        Intrinsics.checkNotNullParameter(r5, "endPointOnScreen");
        Intrinsics.checkNotNullParameter(r8, "degradeConfigV2");
        Intrinsics.checkNotNullParameter(r3, "bitmap");
        Intrinsics.checkNotNullParameter(r4, "startPointOnScreen");
        Intrinsics.checkNotNullParameter(r5, "endPointOnScreen");
        Intrinsics.checkNotNullParameter(r8, "degradeConfigV2");
    }
}
