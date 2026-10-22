package com.larksuite.framework.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 5*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u000256B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ3\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020#0&J\u0012\u0010*\u001a\u00020#2\b\u0010+\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010,\u001a\u00020#2\b\u0010+\u001a\u0004\u0018\u00010\u0002H\u0016J\u0015\u0010-\u001a\u00020#2\u0006\u0010)\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010.J\b\u0010/\u001a\u00020#H\u0002J\b\u00100\u001a\u00020#H\u0002J\u0010\u00101\u001a\u00020#2\u0006\u00102\u001a\u000203H\u0014J\u0010\u00104\u001a\u00020#2\u0006\u00102\u001a\u000203H\u0002R\u0012\u0010\f\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u00067"}, d2 = {"Lcom/larksuite/framework/ui/ViewTransitionContainer;", "ViewType", "Landroid/view/View;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "targetView", "Landroid/view/View;", "snapshot", "Landroid/graphics/Bitmap;", "snapshotPosition", "Landroid/graphics/PointF;", "transitionAnimator", "Landroid/animation/ValueAnimator;", "transitionType", "Lcom/larksuite/framework/ui/ViewTransitionContainer$TransitionType;", "getTransitionType", "()Lcom/larksuite/framework/ui/ViewTransitionContainer$TransitionType;", "setTransitionType", "(Lcom/larksuite/framework/ui/ViewTransitionContainer$TransitionType;)V", "transitionDuration", "", "getTransitionDuration$annotations", "()V", "getTransitionDuration", "()J", "setTransitionDuration", "(J)V", "update", "", "animate", "", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "view", "onViewAdded", "child", "onViewRemoved", "takeSnapshot", "(Landroid/view/View;)V", "startTransitionAnimator", "clearTransitionAnimator", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "drawSnapshotIfNeeded", "Companion", "TransitionType", "common-ui_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class ViewTransitionContainer<ViewType extends View> extends FrameLayout {
    public static final /* synthetic */ int g = 0;
    public ViewType a;
    public Bitmap b;
    public final PointF c;
    public ValueAnimator d;
    public TransitionType e;
    public long f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larksuite/framework/ui/ViewTransitionContainer$TransitionType;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "CROSS_FADE", "SLIDING_DOWN_FADE", "common-ui_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum TransitionType extends Enum<TransitionType> {
        public static final TransitionType CROSS_FADE = null;
        public static final TransitionType NONE = null;
        public static final TransitionType SLIDING_DOWN_FADE = null;
        public static final /* synthetic */ TransitionType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<TransitionType> getEntries() {
            return b;
        }

        static {
            TransitionType r0 = new TransitionType("NONE", 0);
            NONE = r0;
            TransitionType r1 = new TransitionType("CROSS_FADE", 1);
            CROSS_FADE = r1;
            TransitionType r3 = new TransitionType("SLIDING_DOWN_FADE", 2);
            SLIDING_DOWN_FADE = r3;
            TransitionType[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static TransitionType[] values() {
            return (TransitionType[]) a.clone();
        }

        public static TransitionType valueOf(String r1) {
            return (TransitionType) r27.a.a(TransitionType.class, r1);
        }

        public TransitionType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    static {
    }

    public ViewTransitionContainer(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ViewTransitionContainer(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public static /* synthetic */ void getTransitionDuration$annotations() {
    }

    public final long getTransitionDuration() {
        return this.f;
    }

    public final TransitionType getTransitionType() {
        return this.e;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r15) {
        Intrinsics.checkNotNullParameter(r15, "canvas");
        ValueAnimator r0 = this.d;
        if (r0 != null) goto L5;
    L39:
        super.dispatchDraw(r15);
        return;
    L5:
        if (Intrinsics.areEqual(r0.getAnimatedValue(), Float.valueOf(1.0f)) == true) goto L39;
        Bitmap r1 = this.b;
        Float r5 = null;
        if (r1 == null) goto L22;
        ValueAnimator r6 = this.d;
        if (r6 == null) goto L22;
        Object r7 = r6.getAnimatedValue();
        if ((r7 instanceof Float) == false) goto L16;
        Float r8 = (Float) r7;
    L17:
        if (r8 == null) goto L22;
        float r9 = r8.floatValue();
        int r10 = r15.saveLayerAlpha(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), (int) (255 * (1 - r9)));
        if (this.e != TransitionType.SLIDING_DOWN_FADE) goto L21;
        r15.translate(0.0f, (r1.getHeight() / 3.0f) * r9);
    L21:
        PointF r11 = this.c;
        r15.drawBitmap(r1, r11.x, r11.y, null);
        r15.restoreToCount(r10);
        goto L22
    L16:
        r8 = null;
    L22:
        ValueAnimator r2 = this.d;
        if (r2 == null) goto L25;
        Object r3 = r2.getAnimatedValue();
    L27:
        if ((r3 instanceof Float) == false) goto L29;
        r5 = (Float) r3;
    L29:
        if (r5 == null) goto L41;
        float r4 = r5.floatValue();
        int r12 = r15.saveLayerAlpha(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), (int) (255 * r4));
        if (this.e != TransitionType.SLIDING_DOWN_FADE) goto L37;
        ViewType r13 = this.a;
        if (r13 == null) goto L35;
        float r14 = r13.getHeight();
    L36:
        r15.translate(0.0f, ((-r14) / 3.0f) * (1 - r4));
        goto L37
    L35:
        r14 = 0.0f;
    L37:
        super.dispatchDraw(r15);
        r15.restoreToCount(r12);
        return;
    L41:
        return;
    L25:
        r3 = null;
        goto L27
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public final void onViewAdded(View r2) {
        super.onViewAdded(r2);
        if (this.a != null) goto L6;
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type ViewType of com.larksuite.framework.ui.ViewTransitionContainer");
        this.a = r2;
        return;
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View r2) {
        super.onViewRemoved(r2);
        if (Intrinsics.areEqual(this.a, r2) == false) goto L6;
        this.a = null;
        return;
    }

    public final void setTransitionDuration(long r1) {
        this.f = r1;
    }

    public final void setTransitionType(TransitionType r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.e = r2;
    }

    public final void update(boolean r5, Function1<? super ViewType, Unit> r6) {
        Intrinsics.checkNotNullParameter(r6, "update");
        ViewType r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r5 == true) goto L7;
    L26:
        r6.invoke(r0);
        return;
    L7:
        if (this.e == TransitionType.NONE) goto L26;
        ValueAnimator r7 = this.d;
        if (r7 == null) goto L13;
        r7.cancel();
    L13:
        if (r0.getWidth() != 0) goto L15;
    L18:
        r6.invoke(r0);
        if (this.b == null) goto L28;
        ValueAnimator r8 = this.d;
        if (r8 == null) goto L24;
        r8.cancel();
    L24:
        this.d = null;
        invalidate();
        ValueAnimator r9 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r9.setDuration(this.f);
        r9.addUpdateListener(new d(this));
        r9.addListener(new e(this));
        r9.start();
        this.d = r9;
        return;
    L28:
        return;
    L15:
        if (r0.getHeight() == 0) goto L18;
        Bitmap r10 = Bitmap.createBitmap(r0.getWidth(), r0.getHeight(), Bitmap.Config.ARGB_8888);
        this.b = r10;
        this.c.set(r0.getX(), r0.getY());
        r0.draw(new Canvas(r10));
        goto L18
    }

    public ViewTransitionContainer(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = new PointF(0.0f, 0.0f);
        setWillNotDraw(false);
        this.e = TransitionType.CROSS_FADE;
        this.f = 300;
    }

    public /* synthetic */ ViewTransitionContainer(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
