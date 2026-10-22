package com.bytedance.android.livesdk.interactivity.like.view;

import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.config.eg;
import com.bytedance.android.livesdk.interactivity.api.base.utils.InteractivityOpt;
import com.bytedance.android.livesdk.interactivity.common.ViewPool;
import com.bytedance.android.livesdk.interactivity.like.utils.LikeAnimUtil;
import com.bytedance.android.livesdk.interactivity.like.w0;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.android.livesdk.utils.u4;
import com.bytedance.bdlocation.BuildConfig;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\r\u000eB\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tB!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/like/view/DiggTapOptimizeView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/interactivity/like/view/z;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attributeSet", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BuildConfig.FLAVOR, "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DiggTapOptimizeView extends FrameLayout implements z {
    public static final int d = 0;
    public final ConcurrentLinkedQueue<b> a;
    public final ViewPool b;
    public int c;

    public static final class a {
    }

    public final class b implements w0 {
        public int a;
        public float b;
        public float c;
        public ImageView d;
        public final Boolean e;
        public final ValueAnimator f;
        public final q4.b g;
        public final f32.i h;
        public final /* synthetic */ DiggTapOptimizeView i;

        @Override // com.bytedance.android.livesdk.interactivity.like.w0
        public final void pause() {
        }

        @Override // com.bytedance.android.livesdk.interactivity.like.w0
        public final void resume() {
        }

        @Override // com.bytedance.android.livesdk.interactivity.like.w0
        public final void clear() {
            if (this.e.booleanValue() == true) goto L10;
            q4.j.getClass();
            if (q4.a.a() == true) goto L10;
            ValueAnimator r0 = this.f;
            if (r0 == null) goto L14;
            r0.cancel();
            return;
        L14:
            return;
        L10:
            q4.b r1 = this.g;
            if (r1 == null) goto L16;
            r1.a();
            return;
        }

        public b(DiggTapOptimizeView r17, Bitmap r18, PointF r19, int r20, float r21, f32.i r23) {
            Intrinsics.checkNotNullParameter(r18, "bitmap");
            Intrinsics.checkNotNullParameter(r19, "startPointOnScreen");
            Intrinsics.checkNotNullParameter(r23, "degradeConfigV2");
            this.i = r17;
            this.h = r23;
            RectF r4 = new RectF();
            this.a = 255;
            this.c = 1.0f;
            Boolean r6 = (Boolean) InteractivityOpt.c(eg.a);
            this.e = r6;
            ImageView r7 = r17.b.a();
            this.d = r7;
            if (r7 != null) goto L5;
            ImageView r8 = new ImageView(r17.getContext());
            this.d = r8;
            r8.setScaleType(ImageView.ScaleType.FIT_CENTER);
            int r10 = DiggTapOptimizeView.d;
            r17.addView(r8, new ViewGroup.LayoutParams(r10, r10));
            r8.layout(0, 0, r10, r10);
        L5:
            ImageView r0 = this.d;
            if (r0 == null) goto L8;
            r0.setTranslationZ(r20);
            r0.setImageBitmap(r18);
            r0.setRotation(r21);
            r0.setAlpha(1.0f);
        L8:
            int r1 = -InteractivityOpt.a(36.0f);
            float r2 = r19.x;
            float r9 = DiggTapOptimizeView.d / 2;
            float r11 = r2 - r9;
            r4.left = r11;
            float r13 = r19.y;
            float r3 = r1;
            r4.top = (r13 - r9) + r3;
            r4.right = r2 + r9;
            r4.bottom = (r13 + r9) + r3;
            ImageView r5 = this.d;
            if (r5 == null) goto L12;
            r5.setTranslationX(r11);
            r5.setTranslationY((r19.y - r9) + r3);
        L12:
            if (r6.booleanValue() == true) goto L17;
            q4.j.getClass();
            if (q4.a.a() == true) goto L17;
            Ref.IntRef r14 = new Ref.IntRef();
            r14.element = 0;
            Keyframe r15 = Keyframe.ofFloat(0.23076923f, r21 - 8.0f);
            r15.setInterpolator(LikeAnimUtil.b());
            Unit r16 = Unit.INSTANCE;
            Keyframe r24 = Keyframe.ofFloat(0.46153846f, 3.0f + r21);
            r24.setInterpolator(LikeAnimUtil.b());
            Keyframe r25 = Keyframe.ofFloat(0.61538464f, r21);
            r25.setInterpolator(LikeAnimUtil.b());
            ValueAnimator r26 = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{(PropertyValuesHolder) LikeAnimUtil.h.getValue(), PropertyValuesHolder.ofKeyframe("rotate", new Keyframe[]{Keyframe.ofFloat(0.0f, r21), r15, r24, r25, Keyframe.ofFloat(1.0f, r21)}), (PropertyValuesHolder) LikeAnimUtil.i.getValue()});
            r26.setDuration(650);
            r26.setInterpolator(new LinearInterpolator());
            r26.addUpdateListener(new t(this, r14));
            r26.addListener(new u(this, r14));
            r26.start();
            this.f = r26;
            return;
        L17:
            q4.b r27 = u4.b(true, new DiggTapOptimizeView$RunningAnimation$createFrameAnimator$1(this, new com.bytedance.android.livesdk.interactivity.like.utils.a(0.0f, 1.5f, 0.0f, 0.23076923f), new AccelerateDecelerateInterpolator(), new com.bytedance.android.livesdk.interactivity.like.utils.a(1.5f, 1.35f, 0.23076923f, 0.46153846f), new com.bytedance.android.livesdk.interactivity.like.utils.a(1.35f, 1.35f, 0.46153846f, 0.61538464f), new com.bytedance.android.livesdk.interactivity.like.utils.a(1.35f, 2.35f, 0.61538464f, 1.0f), new com.bytedance.android.livesdk.interactivity.like.utils.a(0.0f, -8.0f, 0.0f, 0.23076923f), new com.bytedance.android.livesdk.interactivity.like.utils.a(-8.0f, 3.0f, 0.23076923f, 0.46153846f), new com.bytedance.android.livesdk.interactivity.like.utils.a(3.0f, 0.0f, 0.46153846f, 0.61538464f), new com.bytedance.android.livesdk.interactivity.like.utils.a(255.0f, 2.0f, 0.61538464f, 1.0f)));
            this.g = r27;
            r27.c();
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.like.view.z
    public final void load() {
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
    }

    static {
        d = s1.f(42.0f);
    }

    @Override // com.bytedance.android.livesdk.interactivity.like.view.z
    public final void clear() {
        Iterator<b> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().clear();
        r0.remove();
        goto L4
    L6:
        ViewPool r1 = this.b;
        if (r1 == null) goto L12;
        int r2 = r1.b.length;
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L11;
        r1.b[r3] = null;
        r3 = r3 + 1;
        goto L9
    L11:
        r1.c = 0;
    L12:
        removeAllViews();
    }

    public DiggTapOptimizeView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = new ConcurrentLinkedQueue();
        this.b = new ViewPool(5);
    }

    public DiggTapOptimizeView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attributeSet");
        super(r2, r3);
        this.a = new ConcurrentLinkedQueue();
        this.b = new ViewPool(5);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r1, int r2) {
        setMeasuredDimension(View.MeasureSpec.getSize(r1), View.MeasureSpec.getSize(r2));
    }

    public DiggTapOptimizeView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attributeSet");
        super(r2, r3, r4);
        this.a = new ConcurrentLinkedQueue();
        this.b = new ViewPool(5);
    }

    @Override // com.bytedance.android.livesdk.interactivity.like.view.z
    public final void a(Bitmap r9, PointF r10, PointF r11, int r13, float r14, f32.i r15) {
        Intrinsics.checkNotNullParameter(r9, "bitmap");
        Intrinsics.checkNotNullParameter(r10, "startPointOnScreen");
        Intrinsics.checkNotNullParameter(r11, "endPointOnScreen");
        Intrinsics.checkNotNullParameter(r15, "degradeConfigV2");
        this.a.add(new b(this, r9, r10, r13, r14, r15));
    }
}
