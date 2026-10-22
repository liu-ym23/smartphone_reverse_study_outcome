package com.larksuite.component.ui.imageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0014J\u0010\u00102\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0002J\u000e\u00103\u001a\u00020.2\u0006\u00104\u001a\u00020\u000bJ\u0010\u00105\u001a\u00020.2\b\b\u0001\u00106\u001a\u00020\rJ\u000e\u00107\u001a\u00020.2\u0006\u00108\u001a\u00020\rJ\u0010\u00109\u001a\u00020.2\b\b\u0001\u0010:\u001a\u00020\rJ\u000e\u0010;\u001a\u00020.2\u0006\u0010<\u001a\u00020\rJ\u0010\u0010=\u001a\u00020.2\b\b\u0001\u0010>\u001a\u00020\u0007J\u0010\u0010?\u001a\u00020.2\b\u0010@\u001a\u0004\u0018\u00010\u0011J\b\u0010A\u001a\u00020.H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0017\u001a\u0004\b\u001f\u0010 R\u001a\u0010\"\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001b\u0010'\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0017\u001a\u0004\b(\u0010\u001bR\u001b\u0010*\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0017\u001a\u0004\b+\u0010 ¨\u0006B"}, d2 = {"Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView2;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mIsOval", "", "mRadius", "", "mBorderWidth", "mBorderColor", "mBorderDrawable", "Landroid/graphics/drawable/Drawable;", "mBoardPaint", "Landroid/graphics/Paint;", "getMBoardPaint", "()Landroid/graphics/Paint;", "mBoardPaint$delegate", "Lkotlin/Lazy;", "mBorderPath", "Landroid/graphics/Path;", "getMBorderPath", "()Landroid/graphics/Path;", "mBorderPath$delegate", "mBordRectF", "Landroid/graphics/RectF;", "getMBordRectF", "()Landroid/graphics/RectF;", "mBordRectF$delegate", "softwareRoundClipEnabled", "getSoftwareRoundClipEnabled", "()Z", "setSoftwareRoundClipEnabled", "(Z)V", "mClipPath", "getMClipPath", "mClipPath$delegate", "mClipRectF", "getMClipRectF", "mClipRectF$delegate", "draw", "", "canvas", "Landroid/graphics/Canvas;", "onDraw", "drawBorderIfNeed", "setOval", "isOval", "setRadius", "radius", "setRadiusInDp", "radiusInDp", "setBorderWidth", "width", "setBorderWidthInDp", "widthInDp", "setBorderColor", "borderColor", "setBorderDrawable", "drawable", "setClipOutlineIfNeed", "suite-ui_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public class LKUIRoundedImageView2 extends AppCompatImageView {
    private final Lazy mBoardPaint$delegate;
    private final Lazy mBordRectF$delegate;
    private int mBorderColor;
    private Drawable mBorderDrawable;
    private final Lazy mBorderPath$delegate;
    private float mBorderWidth;
    private final Lazy mClipPath$delegate;
    private final Lazy mClipRectF$delegate;
    private boolean mIsOval;
    private float mRadius;
    private boolean softwareRoundClipEnabled;

    public static final class a extends ViewOutlineProvider {
        public final /* synthetic */ LKUIRoundedImageView2 a;

        public a(LKUIRoundedImageView2 r1) {
            this.a = r1;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r9, Outline r10) {
            if (LKUIRoundedImageView2.access$getMIsOval$p(this.a) == false) goto L6;
            if (r10 == null) goto L9;
            r10.setOval(0, 0, this.a.getWidth(), this.a.getHeight());
            return;
        L9:
            return;
        L6:
            if (r10 == null) goto L11;
            r10.setRoundRect(0, 0, this.a.getWidth(), this.a.getHeight(), LKUIRoundedImageView2.access$getMRadius$p(this.a));
            return;
        }
    }

    public LKUIRoundedImageView2(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public LKUIRoundedImageView2(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    private final Paint getMBoardPaint() {
        return (Paint) this.mBoardPaint$delegate.getValue();
    }

    private final RectF getMBordRectF() {
        return (RectF) this.mBordRectF$delegate.getValue();
    }

    private final Path getMBorderPath() {
        return (Path) this.mBorderPath$delegate.getValue();
    }

    private final Path getMClipPath() {
        return (Path) this.mClipPath$delegate.getValue();
    }

    private final RectF getMClipRectF() {
        return (RectF) this.mClipRectF$delegate.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setClipOutlineIfNeed() {
        if (this.mIsOval == false) goto L5;
    L11:
        setOutlineProvider(new a(this));
        setClipToOutline(true);
    L12:
        invalidate();
        return;
    L5:
        if (this.mRadius != 0.0f) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L11;
        setClipToOutline(false);
        setOutlineProvider(null);
        goto L12
    L7:
        r0 = false;
        goto L8
    }

    public final boolean getSoftwareRoundClipEnabled() {
        return this.softwareRoundClipEnabled;
    }

    public static final /* synthetic */ boolean access$getMIsOval$p(LKUIRoundedImageView2 r0) {
        return r0.mIsOval;
    }

    public static final /* synthetic */ float access$getMRadius$p(LKUIRoundedImageView2 r0) {
        return r0.mRadius;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void drawBorderIfNeed(Canvas r8) {
        Drawable r0 = this.mBorderDrawable;
        if (r0 == null) goto L10;
        if (r0 == null) goto L6;
        r0.setBounds(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
    L6:
        Drawable r1 = this.mBorderDrawable;
        if (r1 == null) goto L23;
        r1.draw(r8);
        return;
    L23:
        return;
    L10:
        float r2 = this.mBorderWidth;
        if (r2 != 0.0f) goto L13;
        boolean r3 = true;
    L14:
        if (r3 == false) goto L16;
        return;
    L16:
        float r4 = (r2 * 1.0f) / 2;
        getMBordRectF().set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        getMBordRectF().inset(r4, r4);
        getMBoardPaint().setColor(this.mBorderColor);
        getMBoardPaint().setStrokeWidth(this.mBorderWidth);
        Path r5 = getMBorderPath();
        r5.reset();
        if (this.mIsOval == false) goto L19;
        r5.addOval(getMBordRectF(), Path.Direction.CW);
    L20:
        if (r8 == null) goto L24;
        r8.drawPath(r5, getMBoardPaint());
        return;
    L24:
        return;
    L19:
        RectF r6 = getMBordRectF();
        float r7 = this.mRadius;
        r5.addRoundRect(r6, r7, r7, Path.Direction.CW);
        goto L20
    L13:
        r3 = false;
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void draw(Canvas r6) {
        Intrinsics.checkNotNullParameter(r6, "canvas");
        if (this.softwareRoundClipEnabled == true) goto L5;
    L16:
        super/*android.widget.ImageView*/.draw(r6);
        return;
    L5:
        if (this.mIsOval == false) goto L7;
    L11:
        int r0 = r6.save();
        getMClipRectF().set(0.0f, 0.0f, getWidth(), getHeight());
        getMClipPath().reset();
        if (this.mIsOval == false) goto L14;
        getMClipPath().addOval(getMClipRectF(), Path.Direction.CW);
    L15:
        r6.clipPath(getMClipPath());
        super/*android.widget.ImageView*/.draw(r6);
        r6.restoreToCount(r0);
        return;
    L14:
        Path r1 = getMClipPath();
        RectF r2 = getMClipRectF();
        float r3 = this.mRadius;
        r1.addRoundRect(r2, r3, r3, Path.Direction.CW);
        goto L15
    L7:
        if (this.mRadius != 0.0f) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == true) goto L16;
    L9:
        r4 = false;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        super/*android.widget.ImageView*/.onDraw(r2);
        drawBorderIfNeed(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setBorderColor(int r1) {
        this.mBorderColor = r1;
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setBorderDrawable(Drawable r1) {
        this.mBorderDrawable = r1;
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setBorderWidth(float r1) {
        this.mBorderWidth = r1;
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setBorderWidthInDp(float r2) {
        setBorderWidth(j08.b.a(getContext(), r2));
    }

    public final void setOval(boolean r1) {
        this.mIsOval = r1;
        setClipOutlineIfNeed();
    }

    public final void setRadius(float r1) {
        this.mRadius = r1;
        setClipOutlineIfNeed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setRadiusInDp(float r2) {
        setRadius(j08.b.a(getContext(), r2));
    }

    public final void setSoftwareRoundClipEnabled(boolean r1) {
        this.softwareRoundClipEnabled = r1;
    }

    public LKUIRoundedImageView2(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        TypedArray r8 = r5.obtainStyledAttributes(r6, new int[]{2130969033, 2130969034, 2130969035, 2130973420, 2130973712}, 0, 0);
        float r9 = r8.getDimension(4, 0.0f);
        boolean r2 = r8.getBoolean(3, false);
        float r1 = r8.getDimension(2, 0.0f);
        int r10 = r8.getColor(0, ContextCompat.getColor(r5, 2131103452));
        Drawable r0 = r8.getDrawable(1);
        r8.recycle();
        setRadius(r9);
        setOval(r2);
        setBorderWidth(r1);
        setBorderColor(r10);
        setBorderDrawable(r0);
        this.mBoardPaint$delegate = LazyKt.lazy(LKUIRoundedImageView2$mBoardPaint$2.INSTANCE);
        this.mBorderPath$delegate = LazyKt.lazy(LKUIRoundedImageView2$mBorderPath$2.INSTANCE);
        this.mBordRectF$delegate = LazyKt.lazy(LKUIRoundedImageView2$mBordRectF$2.INSTANCE);
        this.mClipPath$delegate = LazyKt.lazy(LKUIRoundedImageView2$mClipPath$2.INSTANCE);
        this.mClipRectF$delegate = LazyKt.lazy(LKUIRoundedImageView2$mClipRectF$2.INSTANCE);
    }

    public /* synthetic */ LKUIRoundedImageView2(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }
}
