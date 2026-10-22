package com.larksuite.component.ui.layout.plus;

import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.core.content.ContextCompat;
import com.larksuite.component.ui.layout.ILKUILayout;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import j08.c;
import j08.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 Y2\u00020\u0001:\u0001YB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\"\u001a\u00020!H\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010 \u001a\u00020!H\u0002J\b\u0010'\u001a\u00020\u001eH\u0002J\b\u0010(\u001a\u00020$H\u0002J\u000e\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020\u000eJ\u0010\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020$H\u0002J\u000e\u0010/\u001a\u00020$2\u0006\u00100\u001a\u00020\u000eJ\u000e\u00101\u001a\u00020$2\u0006\u00102\u001a\u00020\tJ\u000e\u00103\u001a\u00020$2\u0006\u00104\u001a\u00020\tJ\u0010\u00105\u001a\u00020$2\b\b\u0001\u00106\u001a\u00020\u000eJ\u000e\u00107\u001a\u00020$2\u0006\u00108\u001a\u00020\tJ\u000e\u00109\u001a\u00020$2\u0006\u0010:\u001a\u00020\u000eJ&\u00107\u001a\u00020$2\u0006\u0010;\u001a\u00020\t2\u0006\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\t2\u0006\u0010>\u001a\u00020\tJ&\u00109\u001a\u00020$2\u0006\u0010?\u001a\u00020\t2\u0006\u0010@\u001a\u00020\t2\u0006\u0010A\u001a\u00020\t2\u0006\u0010B\u001a\u00020\tJ\u0006\u0010C\u001a\u00020\tJ\u0006\u0010D\u001a\u00020\tJ\u0006\u0010E\u001a\u00020\tJ\u0006\u0010F\u001a\u00020\tJ\u0006\u0010G\u001a\u00020\tJ(\u0010H\u001a\u00020$2\u0006\u0010I\u001a\u00020\u000e2\u0006\u0010J\u001a\u00020\u000e2\u0006\u0010K\u001a\u00020\u000e2\u0006\u0010L\u001a\u00020\u000eH\u0016J(\u0010M\u001a\u00020\u001e2\u0006\u0010N\u001a\u00020\t2\u0006\u0010O\u001a\u00020\t2\u0006\u0010P\u001a\u00020\t2\u0006\u0010Q\u001a\u00020\tH\u0002JH\u0010R\u001a\u00020S2\u0006\u0010N\u001a\u00020\t2\u0006\u0010O\u001a\u00020\t2\u0006\u0010P\u001a\u00020\t2\u0006\u0010Q\u001a\u00020\t2\u0006\u0010;\u001a\u00020\t2\u0006\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\t2\u0006\u0010>\u001a\u00020\tH\u0002J,\u0010T\u001a\u00020$*\u00020\u001e2\u0006\u0010U\u001a\u00020\t2\u0006\u0010V\u001a\u00020\t2\u0006\u0010W\u001a\u00020\t2\u0006\u0010X\u001a\u00020\u000eH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001b\u0010\u0017R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Lcom/larksuite/component/ui/layout/plus/RoundShapeLKUIPlus;", "Lcom/larksuite/component/ui/layout/plus/BaseInnerPlus;", "layout", "Lcom/larksuite/component/ui/layout/ILKUILayout;", "<init>", "(Lcom/larksuite/component/ui/layout/ILKUILayout;)V", "getPlusType", "Lcom/larksuite/component/ui/layout/plus/InnerPlusType;", "radiusLeftTop", "", "radiusRightTop", "radiusLeftBottom", "radiusRightBottom", "originPaddingLeft", "", "originPaddingTop", "originPaddingRight", "originPaddingBottom", "borderWidth", "boarderColor", "boardPaint", "Landroid/graphics/Paint;", "getBoardPaint", "()Landroid/graphics/Paint;", "boardPaint$delegate", "Lkotlin/Lazy;", "clearPaint", "getClearPaint", "clearPaint$delegate", "clearPath", "Landroid/graphics/Path;", "borderMode", "isVeryLargeThanScreen", "", "hasBorder", "onDelegateDispatchDrawEnd", "", "canvas", "Landroid/graphics/Canvas;", "getClearCanvasPath", "setClipOutline", "setPadding", "padding", "onDelegateSetPaddingStart", "paddingData", "Landroid/graphics/Rect;", "amendPadding", "setBorderMode", "mode", "setBorderWidth", "widthInDp", "setBorderWidthInPx", "widthInPx", "setBorderColor", "color", "setRadius", "radiusInDp", "setRadiusInPx", "radiusInPx", "leftTopRadiusInDp", "leftBottomRadiusInDp", "rightTopRadiusInDp", "rightBottomRadiusInDp", "leftTopRadius", "leftBottomRadius", "rightTopRadius", "rightBottomRadius", "getRadius", "getLeftTopRadius", "getLeftBottomRadius", "getRightTopRadius", "getRightBottomRadius", "onDelegateSizeChanged", "w", "h", "oldw", "oldh", "getBorderPath", "left", "top", "right", "bottom", "createPathKey", "", "arcTo", "x", "y", "radius", "rotations", "Companion", "suite-ui_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class RoundShapeLKUIPlus extends BaseInnerPlus {
    public static final a Companion = null;
    public static final int MODE_INSET = 1;
    public static final int MODE_OVERLAY = 0;
    private static final RoundShapeLKUIPlus$Companion$sPathCache$1 sPathCache = null;
    private final Lazy boardPaint$delegate;
    private int boarderColor;
    private int borderMode;
    private float borderWidth;
    private final Lazy clearPaint$delegate;
    private Path clearPath;
    private boolean isVeryLargeThanScreen;
    private int originPaddingBottom;
    private int originPaddingLeft;
    private int originPaddingRight;
    private int originPaddingTop;
    private float radiusLeftBottom;
    private float radiusLeftTop;
    private float radiusRightBottom;
    private float radiusRightTop;

    public static final class a {
        public a() {
        }
    }

    public static final class b extends ViewOutlineProvider {
        public final /* synthetic */ RoundShapeLKUIPlus a;

        public b(RoundShapeLKUIPlus r1) {
            this.a = r1;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r7, Outline r8) {
            if (r8 == null) goto L5;
            r8.setRoundRect(0, 0, this.a.getLayout().getWidth(), this.a.getLayout().getHeight(), RoundShapeLKUIPlus.access$getRadiusLeftTop$p(this.a));
            return;
        }
    }

    static {
        Companion = new a();
        sPathCache = new RoundShapeLKUIPlus$Companion$sPathCache$1();
    }

    private final void amendPadding() {
        if (this.borderMode != 1) goto L5;
        int r0 = (int) this.borderWidth;
    L6:
        getLayout().setPadding(this.originPaddingLeft + r0, this.originPaddingTop + r0, this.originPaddingRight + r0, this.originPaddingBottom + r0);
        return;
    L5:
        r0 = 0;
        goto L6
    }

    private final Paint getBoardPaint() {
        return (Paint) this.boardPaint$delegate.getValue();
    }

    private final Path getClearCanvasPath() {
        this.clearPath.reset();
        this.clearPath.set(getBorderPath(0.0f, 0.0f, getLayout().getWidth(), getLayout().getHeight()));
        this.clearPath.toggleInverseFillType();
        return this.clearPath;
    }

    private final Paint getClearPaint() {
        return (Paint) this.clearPaint$delegate.getValue();
    }

    private final boolean hasBorder() {
        if (this.borderWidth > 0.0f) goto L5;
    L7:
        return false;
    L5:
        if (this.boarderColor == 0) goto L7;
        return true;
    }

    private final void setClipOutline() {
        float r0 = this.radiusLeftTop;
        if (r0 != this.radiusRightTop) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L8;
    L18:
        getLayout().setClipToOutline(false);
        getLayout().setOutlineProvider(null);
    L19:
        getLayout().invalidate();
        return;
    L8:
        if (r0 != this.radiusLeftBottom) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == false) goto L18;
        if (r0 != this.radiusRightBottom) goto L15;
        boolean r3 = true;
    L16:
        if (r3 == false) goto L18;
        getLayout().setOutlineProvider(new b(this));
        getLayout().setClipToOutline(true);
        goto L19
    L15:
        r3 = false;
        goto L16
    L10:
        r2 = false;
        goto L11
    L5:
        r1 = false;
        goto L6
    }

    private final boolean isVeryLargeThanScreen() {
        c r0 = d.c(getContext());
        if (getLayout().getWidth() <= (r0.a * 2)) goto L5;
    L8:
        return true;
    L5:
        if (getLayout().getHeight() > (r0.b * 2)) goto L8;
        return false;
    }

    public final float getLeftBottomRadius() {
        return this.radiusLeftBottom;
    }

    public final float getLeftTopRadius() {
        return this.radiusLeftTop;
    }

    @Override // com.larksuite.component.ui.layout.plus.BaseInnerPlus
    public InnerPlusType getPlusType() {
        return InnerPlusType.ROUND_SHAPE;
    }

    public final float getRadius() {
        return this.radiusLeftTop;
    }

    public final float getRightBottomRadius() {
        return this.radiusRightBottom;
    }

    public final float getRightTopRadius() {
        return this.radiusRightTop;
    }

    public RoundShapeLKUIPlus(ILKUILayout r5) {
        Intrinsics.checkNotNullParameter(r5, "layout");
        super(r5);
        this.boardPaint$delegate = LazyKt.lazy(RoundShapeLKUIPlus$boardPaint$2.INSTANCE);
        this.clearPaint$delegate = LazyKt.lazy(RoundShapeLKUIPlus$clearPaint$2.INSTANCE);
        this.clearPath = new Path();
        TypedArray r6 = getContext().obtainStyledAttributes(getAttrs(), new int[]{2130973821, 2130973822, 2130973823, 2130973824, 2130973825, 2130973826, 2130973827, 2130973828}, 0, 0);
        float r0 = r6.getDimension(3, 0.0f);
        this.radiusLeftTop = r6.getDimension(5, r0);
        this.radiusLeftBottom = r6.getDimension(4, r0);
        this.radiusRightTop = r6.getDimension(7, r0);
        this.radiusRightBottom = r6.getDimension(6, r0);
        this.borderWidth = r6.getDimension(2, 0.0f);
        this.boarderColor = r6.getColor(0, ContextCompat.getColor(getContext(), 2131103452));
        this.borderMode = r6.getInt(1, 0);
        r6.recycle();
        this.originPaddingLeft = getLayout().getPaddingLeft();
        this.originPaddingTop = getLayout().getPaddingTop();
        this.originPaddingRight = getLayout().getPaddingRight();
        this.originPaddingBottom = getLayout().getPaddingBottom();
        if (this.borderWidth > 0.0f) goto L5;
        return;
    L5:
        if (this.borderMode != 1) goto L9;
        amendPadding();
        return;
    }

    public static final /* synthetic */ float access$getRadiusLeftTop$p(RoundShapeLKUIPlus r0) {
        return r0.radiusLeftTop;
    }

    @Override // com.larksuite.component.ui.layout.plus.a
    public void onDelegateDispatchDrawEnd(Canvas r8) {
        Intrinsics.checkNotNullParameter(r8, "canvas");
        if (getLayout().getClipToOutline() == false) goto L5;
    L7:
        boolean r3 = false;
    L18:
        e = move-exception;
        String r1 = e.getMessage();
        if (r1 != null) goto L22;
    L24:
        if (r3 == false) goto L28;
        throw e;
    L28:
        return;
    L22:
        if (StringsKt.contains$default(r1, "recycled bitmap", false, 2, null) == true) goto L24;
        r3 = true;
        goto L24
    L9:
        if (hasBorder() == false) goto L12;
        getBoardPaint().setColor(this.boarderColor);     // Catch: RuntimeException -> L18
        getBoardPaint().setStrokeWidth(this.borderWidth * 2);     // Catch: RuntimeException -> L18
        r8.drawPath(getBorderPath(0.0f, 0.0f, getLayout().getWidth(), getLayout().getHeight()), getBoardPaint());     // Catch: RuntimeException -> L18
    L12:
        if (getLayout().getClipToOutline() == false) goto L14;
    L16:
        getLayout().setLayerType(0, null);     // Catch: RuntimeException -> L18
        return;
    L14:
        if (this.isVeryLargeThanScreen == true) goto L16;
        getLayout().setLayerType(2, null);     // Catch: RuntimeException -> L18
        r8.drawPath(getClearCanvasPath(), getClearPaint());     // Catch: RuntimeException -> L18
        return;
    L5:
        if (this.isVeryLargeThanScreen == false) goto L7;
        r8.clipPath(getBorderPath(0.0f, 0.0f, getLayout().getWidth(), getLayout().getHeight()));
        goto L7
    }

    @Override // com.larksuite.component.ui.layout.plus.a
    public void onDelegateSetPaddingStart(Rect r7) {
        Intrinsics.checkNotNullParameter(r7, "paddingData");
        int r0 = r7.left;
        this.originPaddingLeft = r0;
        int r1 = r7.top;
        this.originPaddingTop = r1;
        int r2 = r7.right;
        this.originPaddingRight = r2;
        int r3 = r7.bottom;
        this.originPaddingBottom = r3;
        if (this.borderMode != 1) goto L5;
        int r4 = (int) this.borderWidth;
    L6:
        r7.left = r0 + r4;
        r7.top = r1 + r4;
        r7.right = r2 + r4;
        r7.bottom = r3 + r4;
        super.onDelegateSetPaddingStart(r7);
        return;
    L5:
        r4 = 0;
        goto L6
    }

    public final void setBorderColor(int r1) {
        this.boarderColor = r1;
        getLayout().invalidate();
    }

    public final void setBorderMode(int r2) {
        if (this.borderMode == r2) goto L5;
        boolean r0 = true;
    L6:
        this.borderMode = r2;
        amendPadding();
        if (r0 == false) goto L10;
        setClipOutline();
        return;
    L10:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setBorderWidth(float r2) {
        setBorderWidthInPx(j08.b.a(getContext(), r2));
    }

    public final void setBorderWidthInPx(float r3) {
        if (this.borderWidth != r3) goto L5;
        boolean r0 = true;
    L6:
        boolean r1 = !r0;
        this.borderWidth = r3;
        amendPadding();
        if (r1 == false) goto L10;
        setClipOutline();
        return;
    L10:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setPadding(int r2) {
        getLayout().setPadding(r2, r2, r2, r2);
    }

    public final void setRadius(float r2) {
        setRadiusInPx((int) j08.b.a(getContext(), r2));
    }

    public final void setRadiusInPx(int r1) {
        float r2 = r1;
        this.radiusLeftTop = r2;
        this.radiusLeftBottom = r2;
        this.radiusRightTop = r2;
        this.radiusRightBottom = r2;
        setClipOutline();
    }

    private final Path getBorderPath(float r17, float r19, float r110, float r20) {
        RoundShapeLKUIPlus$Companion$sPathCache$1 r14 = sPathCache;
        Path r0 = (Path) r14.get(createPathKey(r17, r19, r110, r20, this.radiusLeftTop, this.radiusLeftBottom, this.radiusRightTop, this.radiusRightBottom));
        if (r0 == null) goto L5;
        return r0;
    L5:
        Path r15 = new Path();
        r15.reset();
        r15.moveTo(this.radiusLeftTop + r17, r19);
        r15.lineTo(r110 - this.radiusRightTop, r19);
        float r4 = this.radiusRightTop;
        arcTo(r15, r110 - r4, r19 + r4, r4, -1);
        r15.lineTo(r110, r20 - this.radiusRightBottom);
        float r5 = this.radiusRightBottom;
        arcTo(r15, r110 - r5, r20 - r5, r5, 0);
        r15.lineTo(this.radiusLeftBottom + r17, r20);
        float r6 = this.radiusLeftBottom;
        arcTo(r15, r17 + r6, r20 - r6, r6, 1);
        r15.lineTo(r17, this.radiusLeftTop + r19);
        float r7 = this.radiusLeftTop;
        arcTo(r15, r17 + r7, r19 + r7, r7, 2);
        r15.lineTo(this.radiusLeftTop + r17, r19);
        r15.close();
        r14.put(createPathKey(r17, r19, r110, r20, this.radiusLeftTop, this.radiusLeftBottom, this.radiusRightTop, this.radiusRightBottom), r15);
        return r15;
    }

    @Override // com.larksuite.component.ui.layout.plus.a
    public void onDelegateSizeChanged(int r1, int r2, int r3, int r4) {
        super.onDelegateSizeChanged(r1, r2, r3, r4);
        this.isVeryLargeThanScreen = isVeryLargeThanScreen();
        setClipOutline();
    }

    public final void setRadius(float r2, float r3, float r4, float r5) {
        setRadiusInPx(j08.b.a(getContext(), r2), j08.b.a(getContext(), r3), j08.b.a(getContext(), r4), j08.b.a(getContext(), r5));
    }

    public final void setRadiusInPx(float r1, float r2, float r3, float r4) {
        this.radiusLeftTop = r1;
        this.radiusLeftBottom = r2;
        this.radiusRightTop = r3;
        this.radiusRightBottom = r4;
        setClipOutline();
    }

    private final void arcTo(Path r9, float r10, float r11, float r12, int r13) {
        r9.arcTo(r10 - r12, r11 - r12, r10 + r12, r11 + r12, r13 * 90.0f, 90.0f, false);
    }

    private final String createPathKey(float r3, float r4, float r5, float r6, float r7, float r8, float r9, float r10) {
        return "l:" + ((int) r3) + " ,t:" + ((int) r4) + " ,r:" + ((int) r5) + " ,b:" + ((int) r6) + " ,lt:" + ((int) r7) + ", lb = " + ((int) r8) + ", rt = " + ((int) r9) + " , rb = " + ((int) r10);
    }
}
