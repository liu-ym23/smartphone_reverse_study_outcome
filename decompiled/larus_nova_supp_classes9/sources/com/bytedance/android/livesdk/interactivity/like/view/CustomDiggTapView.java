package com.bytedance.android.livesdk.interactivity.like.view;

import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.config.eg;
import com.bytedance.android.livesdk.interactivity.common.ViewPool;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.android.livesdk.utils.u4;
import com.bytedance.bdlocation.BuildConfig;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0003\u0011\u0012\u0013B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB\u0019\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\t\u0010\rB!\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\t\u0010\u0010J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/like/view/CustomDiggTapView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/interactivity/like/view/y;", BuildConfig.FLAVOR, "size", BuildConfig.FLAVOR, "setBitmapSize", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attributeSet", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BuildConfig.FLAVOR, "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "c", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CustomDiggTapView extends FrameLayout implements y {
    public final ConcurrentLinkedQueue<c> a;
    public final ViewPool b;
    public int c;

    public final class a {
        public final ClosedFloatingPointRange<Float> a;
        public final float b;
        public final float c;
        public final float d;
        public final float e;

        public final float a(float r3, TimeInterpolator r4) {
            float r0 = this.d;
            float r5 = (r3 - r0) / (this.e - r0);
            if (r4 == null) goto L5;
            r4.getInterpolation(r5);
        L5:
            float r6 = this.b;
            return r6 + ((this.c - r6) * r5);
        }

        public a(float r1, float r2, float r3, float r4) {
            this.b = r1;
            this.c = r2;
            this.d = r3;
            this.e = r4;
            this.a = RangesKt.rangeTo(r3, r4);
        }
    }

    public static final class b {
    }

    public final class c {
        public int a;
        public float b;
        public float c;
        public ImageView d;
        public final Boolean e;
        public final ValueAnimator f;
        public final q4.b g;
        public final /* synthetic */ CustomDiggTapView h;

        public c(CustomDiggTapView r19, Bitmap r20, PointF r21, int r23, float r24) {
            Intrinsics.checkNotNullParameter(r20, "bitmap");
            Intrinsics.checkNotNullParameter(r21, "startPointOnScreen");
            this.h = r19;
            RectF r4 = new RectF();
            this.a = 255;
            this.c = 1.0f;
            Boolean r7 = (Boolean) eg.a.getValue();
            this.e = r7;
            ImageView r8 = r19.b.a();
            this.d = r8;
            if (r8 != null) goto L5;
            ImageView r9 = new ImageView(r19.getContext());
            this.d = r9;
            r9.setScaleType(ImageView.ScaleType.FIT_CENTER);
            int r10 = r19.c;
            r19.addView(r9, new ViewGroup.LayoutParams(r10, r10));
        L5:
            ImageView r11 = this.d;
            if (r11 == null) goto L8;
            r11.setTranslationZ(r23);
            r11.setImageBitmap(r20);
            r11.setRotation(r24);
            r11.setAlpha(1.0f);
        L8:
            float r1 = r21.x;
            float r13 = r19.c / 2;
            float r14 = r1 - r13;
            r4.left = r14;
            float r15 = r21.y;
            r4.top = r15 - r13;
            r4.right = r1 + r13;
            r4.bottom = r15 + r13;
            ImageView r2 = this.d;
            if (r2 == null) goto L12;
            r2.setTranslationX(r14);
            r2.setTranslationY(r21.y - (r19.c / 2));
        L12:
            if (r7.booleanValue() == true) goto L17;
            q4.j.getClass();
            if (q4.a.a() == true) goto L17;
            Ref.IntRef r0 = new Ref.IntRef();
            r0.element = 0;
            Keyframe r3 = Keyframe.ofFloat(0.23076923f, 1.5f);
            r3.setInterpolator(new AccelerateDecelerateInterpolator());
            Unit r16 = Unit.INSTANCE;
            Keyframe r5 = Keyframe.ofFloat(0.46153846f, 1.35f);
            r5.setInterpolator(new AccelerateDecelerateInterpolator());
            Keyframe r6 = Keyframe.ofFloat(0.61538464f, 1.35f);
            r6.setInterpolator(new AccelerateDecelerateInterpolator());
            Keyframe r17 = Keyframe.ofFloat(1.0f, 2.3f);
            r17.setInterpolator(new AccelerateDecelerateInterpolator());
            Keyframe[] r18 = {Keyframe.ofFloat(0.0f, 0.0f), r3, r5, r6, r17};
            Keyframe r25 = Keyframe.ofFloat(0.23076923f, r24 - 8.0f);
            r25.setInterpolator(new LinearInterpolator());
            Keyframe r26 = Keyframe.ofFloat(0.46153846f, 3.0f + r24);
            r26.setInterpolator(new LinearInterpolator());
            Keyframe r27 = Keyframe.ofFloat(0.61538464f, r24);
            r27.setInterpolator(new LinearInterpolator());
            Keyframe[] r28 = {Keyframe.ofFloat(0.0f, r24), r25, r26, r27, Keyframe.ofFloat(1.0f, r24)};
            Keyframe r29 = Keyframe.ofInt(1.0f, 0);
            r29.setInterpolator(new AccelerateDecelerateInterpolator());
            ValueAnimator r30 = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe("scale", r18), PropertyValuesHolder.ofKeyframe("rotate", r28), PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[]{Keyframe.ofInt(0.0f, 255), Keyframe.ofInt(0.61538464f, 255), r29})});
            r30.setDuration(650);
            r30.setInterpolator(new LinearInterpolator());
            r30.addUpdateListener(new i(this, r0));
            r30.addListener(new j(this, r0));
            r30.start();
            this.f = r30;
            return;
        L17:
            q4.b r31 = u4.b(true, new CustomDiggTapView$RunningAnimation$createFrameAnimator$1(this, new a(0.0f, 1.5f, 0.0f, 0.23076923f), new AccelerateDecelerateInterpolator(), new a(1.5f, 1.35f, 0.23076923f, 0.46153846f), new a(1.35f, 1.35f, 0.46153846f, 0.61538464f), new a(1.35f, 2.35f, 0.61538464f, 1.0f), new a(0.0f, -8.0f, 0.0f, 0.23076923f), new a(-8.0f, 3.0f, 0.23076923f, 0.46153846f), new a(3.0f, 0.0f, 0.46153846f, 0.61538464f), new a(255.0f, 2.0f, 0.61538464f, 1.0f)));
            this.g = r31;
            r31.c();
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.like.view.z
    public final void load() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.like.view.z
    public final void clear() {
        Iterator<c> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L17;
        c r1 = r0.next();
        if (r1.e.booleanValue() == true) goto L13;
        q4.j.getClass();
        if (q4.a.a() == true) goto L13;
        ValueAnimator r2 = r1.f;
        if (r2 == null) goto L16;
        r2.cancel();
    L16:
        r0.remove();
    L13:
        q4.b r3 = r1.g;
        if (r3 == null) goto L16;
        r3.a();
        goto L16
    L17:
        ViewPool r4 = this.b;
        if (r4 == null) goto L23;
        int r5 = r4.b.length;
        int r6 = 0;
    L20:
        if (r6 >= r5) goto L22;
        r4.b[r6] = null;
        r6 = r6 + 1;
        goto L20
    L22:
        r4.c = 0;
    L23:
        removeAllViews();
    }

    public CustomDiggTapView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = new ConcurrentLinkedQueue();
        this.b = new ViewPool(5);
        this.c = s1.f(42.0f);
    }

    @Override // com.bytedance.android.livesdk.interactivity.like.view.y
    public void setBitmapSize(float r1) {
        this.c = (int) r1;
    }

    public CustomDiggTapView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attributeSet");
        super(r2, r3);
        this.a = new ConcurrentLinkedQueue();
        this.b = new ViewPool(5);
        this.c = s1.f(42.0f);
    }

    public CustomDiggTapView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attributeSet");
        super(r2, r3, r4);
        this.a = new ConcurrentLinkedQueue();
        this.b = new ViewPool(5);
        this.c = s1.f(42.0f);
    }

    @Override // com.bytedance.android.livesdk.interactivity.like.view.z
    public final void a(Bitmap r7, PointF r8, PointF r9, int r10, float r11, f32.i r13) {
        Intrinsics.checkNotNullParameter(r7, "bitmap");
        Intrinsics.checkNotNullParameter(r8, "startPointOnScreen");
        Intrinsics.checkNotNullParameter(r9, "endPointOnScreen");
        Intrinsics.checkNotNullParameter(r13, "degradeConfigV2");
        this.a.add(new c(this, r7, r8, r10, r11));
    }
}
