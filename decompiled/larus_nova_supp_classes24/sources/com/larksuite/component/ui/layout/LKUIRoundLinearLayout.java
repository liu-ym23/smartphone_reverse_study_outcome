package com.larksuite.component.ui.layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0016\u0018\u0000 ^2\u00020\u00012\u00020\u0002:\u0001^B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010)\u001a\u00020#H\u0002J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0014J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010/\u001a\u00020 H\u0002J\b\u00100\u001a\u00020+H\u0002J\u000e\u00101\u001a\u00020+2\u0006\u00102\u001a\u00020\bJ(\u00101\u001a\u00020+2\u0006\u00103\u001a\u00020\b2\u0006\u00104\u001a\u00020\b2\u0006\u00105\u001a\u00020\b2\u0006\u00106\u001a\u00020\bH\u0016J\b\u00107\u001a\u00020+H\u0002J\u000e\u00108\u001a\u00020+2\u0006\u00109\u001a\u00020\bJ\u000e\u0010:\u001a\u00020+2\u0006\u0010;\u001a\u00020\fJ\u000e\u0010<\u001a\u00020+2\u0006\u0010=\u001a\u00020\fJ\u0010\u0010>\u001a\u00020+2\b\b\u0001\u0010?\u001a\u00020\bJ\u0010\u0010@\u001a\u00020+2\u0006\u0010A\u001a\u00020\fH\u0016J\u0010\u0010B\u001a\u00020+2\u0006\u0010C\u001a\u00020\bH\u0016J(\u0010@\u001a\u00020+2\u0006\u0010D\u001a\u00020\f2\u0006\u0010E\u001a\u00020\f2\u0006\u0010F\u001a\u00020\f2\u0006\u0010G\u001a\u00020\fH\u0016J(\u0010B\u001a\u00020+2\u0006\u0010H\u001a\u00020\f2\u0006\u0010I\u001a\u00020\f2\u0006\u0010J\u001a\u00020\f2\u0006\u0010K\u001a\u00020\fH\u0016J\b\u0010L\u001a\u00020\fH\u0016J\b\u0010M\u001a\u00020\fH\u0016J\b\u0010N\u001a\u00020\fH\u0016J\b\u0010O\u001a\u00020\fH\u0016J\b\u0010P\u001a\u00020\fH\u0016J(\u0010Q\u001a\u00020+2\u0006\u0010R\u001a\u00020\b2\u0006\u0010S\u001a\u00020\b2\u0006\u0010T\u001a\u00020\b2\u0006\u0010U\u001a\u00020\bH\u0014J(\u0010V\u001a\u00020 2\u0006\u00103\u001a\u00020\f2\u0006\u00104\u001a\u00020\f2\u0006\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020\fH\u0002JH\u0010W\u001a\u00020X2\u0006\u00103\u001a\u00020\f2\u0006\u00104\u001a\u00020\f2\u0006\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020\f2\u0006\u0010D\u001a\u00020\f2\u0006\u0010E\u001a\u00020\f2\u0006\u0010F\u001a\u00020\f2\u0006\u0010G\u001a\u00020\fH\u0002J,\u0010Y\u001a\u00020+*\u00020 2\u0006\u0010Z\u001a\u00020\f2\u0006\u0010[\u001a\u00020\f2\u0006\u0010\\\u001a\u00020\f2\u0006\u0010]\u001a\u00020\bH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001d\u0010\u0019R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006_"}, d2 = {"Lcom/larksuite/component/ui/layout/LKUIRoundLinearLayout;", "Landroid/widget/LinearLayout;", "Lcom/larksuite/component/ui/layout/LKUIRadiusSupportLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "radiusLeftTop", "", "radiusRightTop", "radiusLeftBottom", "radiusRightBottom", "originPaddingLeft", "originPaddingTop", "originPaddingRight", "originPaddingBottom", "borderWidth", "boarderColor", "boardPaint", "Landroid/graphics/Paint;", "getBoardPaint", "()Landroid/graphics/Paint;", "boardPaint$delegate", "Lkotlin/Lazy;", "clearPaint", "getClearPaint", "clearPaint$delegate", "clearPath", "Landroid/graphics/Path;", "borderMode", "isVeryLargeThanScreen", "", "softwareRoundClipEnabled", "getSoftwareRoundClipEnabled", "()Z", "setSoftwareRoundClipEnabled", "(Z)V", "hasBorder", "draw", "", "canvas", "Landroid/graphics/Canvas;", "dispatchDraw", "getClearCanvasPath", "setClipOutline", "setPadding", "padding", "left", "top", "right", "bottom", "amendPadding", "setBorderMode", "mode", "setBorderWidth", "widthInDp", "setBorderWidthInPx", "widthInPx", "setBorderColor", "color", "setRadius", "radiusInDp", "setRadiusInPx", "radiusInPx", "leftTopRadiusInDp", "leftBottomRadiusInDp", "rightTopRadiusInDp", "rightBottomRadiusInDp", "leftTopRadius", "leftBottomRadius", "rightTopRadius", "rightBottomRadius", "getRadius", "getLeftTopRadius", "getLeftBottomRadius", "getRightTopRadius", "getRightBottomRadius", "onSizeChanged", "w", "h", "oldw", "oldh", "getBorderPath", "createPathKey", "", "arcTo", "x", "y", "radius", "rotations", "Companion", "suite-ui_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public class LKUIRoundLinearLayout extends LinearLayout implements com.larksuite.component.ui.layout.b {
    public static final LKUIRoundLinearLayout$Companion$sPathCache$1 q = null;
    public float a;
    public float b;
    public float c;
    public float d;
    public int e;
    public int f;
    public int g;
    public int h;
    public float i;
    public int j;
    public final Lazy k;
    public final Lazy l;
    public final Path m;
    public int n;
    public boolean o;
    public boolean p;

    public static final class a {
    }

    public static final class b extends ViewOutlineProvider {
        public final /* synthetic */ LKUIRoundLinearLayout a;

        public b(LKUIRoundLinearLayout r1) {
            this.a = r1;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r7, Outline r8) {
            if (r8 == null) goto L5;
            r8.setRoundRect(0, 0, this.a.getWidth(), this.a.getHeight(), this.a.a);
            return;
        }
    }

    public LKUIRoundLinearLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public LKUIRoundLinearLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    static {
        q = new LKUIRoundLinearLayout$Companion$sPathCache$1();
    }

    private final Paint getBoardPaint() {
        return (Paint) this.k.getValue();
    }

    private final Path getClearCanvasPath() {
        this.m.reset();
        this.m.set(d(getWidth(), getHeight()));
        this.m.toggleInverseFillType();
        return this.m;
    }

    private final Paint getClearPaint() {
        return (Paint) this.l.getValue();
    }

    public final void a() {
        if (this.n != 1) goto L5;
        int r0 = (int) this.i;
    L6:
        super.setPadding(this.e + r0, this.f + r0, this.g + r0, this.h + r0);
        return;
    L5:
        r0 = 0;
        goto L6
    }

    public final void e() {
        float r0 = this.a;
        if (r0 != this.b) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L8;
    L18:
        setClipToOutline(false);
        setOutlineProvider(null);
    L19:
        invalidate();
        return;
    L8:
        if (r0 != this.c) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == false) goto L18;
        if (r0 != this.d) goto L15;
        boolean r3 = true;
    L16:
        if (r3 == false) goto L18;
        setOutlineProvider(new b(this));
        setClipToOutline(true);
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

    public float getLeftBottomRadius() {
        return this.c;
    }

    public float getLeftTopRadius() {
        return this.a;
    }

    public float getRadius() {
        return this.a;
    }

    public float getRightBottomRadius() {
        return this.d;
    }

    public float getRightTopRadius() {
        return this.b;
    }

    public final boolean getSoftwareRoundClipEnabled() {
        return this.p;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r8) {
        Intrinsics.checkNotNullParameter(r8, "canvas");
        if (this.p == false) goto L5;
    L9:
        boolean r0 = true;
        super.dispatchDraw(r8);     // Catch: RuntimeException -> L29
        if (this.i > 0.0f) goto L13;
    L15:
        boolean r4 = false;
    L16:
        if (r4 == false) goto L19;
        getBoardPaint().setColor(this.j);     // Catch: RuntimeException -> L29
        getBoardPaint().setStrokeWidth(this.i * 2);     // Catch: RuntimeException -> L29
        r8.drawPath(d(getWidth(), getHeight()), getBoardPaint());     // Catch: RuntimeException -> L29
    L19:
        if (this.p == true) goto L26;
        if (getClipToOutline() == true) goto L26;
        if (this.o == true) goto L26;
        setLayerType(2, null);     // Catch: RuntimeException -> L29
        r8.drawPath(getClearCanvasPath(), getClearPaint());     // Catch: RuntimeException -> L29
        return;
    L26:
        if (this.p == true) goto L40;
        setLayerType(0, null);     // Catch: RuntimeException -> L29
        return;
    L40:
        return;
    L13:
        if (this.j == 0) goto L15;
        r4 = true;
    L29:
        e = move-exception;
        String r5 = e.getMessage();
        if (r5 != null) goto L33;
    L35:
        r0 = false;
    L36:
        if (r0 == false) goto L41;
        throw e;
    L41:
        return;
    L33:
        if (StringsKt.contains$default(r5, "recycled bitmap", false, 2, null) == true) goto L35;
    L5:
        if (getClipToOutline() == true) goto L9;
        if (this.o == false) goto L9;
        r8.clipPath(d(getWidth(), getHeight()));
        goto L9
    }

    @Override // android.view.View
    public final void draw(Canvas r4) {
        Intrinsics.checkNotNullParameter(r4, "canvas");
        if (this.p == false) goto L5;
        int r0 = r4.save();
        r4.clipPath(d(getWidth(), getHeight()));
        super.draw(r4);
        r4.restoreToCount(r0);
        return;
    L5:
        super.draw(r4);
    }

    public final void setBorderColor(int r1) {
        this.j = r1;
        invalidate();
    }

    public final void setBorderMode(int r2) {
        if (this.n == r2) goto L5;
        boolean r0 = true;
    L6:
        this.n = r2;
        a();
        if (r0 == false) goto L10;
        e();
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
        if (this.i != r3) goto L5;
        boolean r0 = true;
    L6:
        boolean r1 = !r0;
        this.i = r3;
        a();
        if (r1 == false) goto L10;
        e();
        return;
    L10:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setPadding(int r1) {
        setPadding(r1, r1, r1, r1);
    }

    public void setRadius(float r2) {
        setRadiusInPx((int) j08.b.a(getContext(), r2));
    }

    public void setRadiusInPx(int r1) {
        float r2 = r1;
        this.a = r2;
        this.c = r2;
        this.b = r2;
        this.d = r2;
        e();
    }

    public final void setSoftwareRoundClipEnabled(boolean r1) {
        this.p = r1;
    }

    public final Path d(float r10, float r11) {
        LKUIRoundLinearLayout$Companion$sPathCache$1 r7 = q;
        Path r0 = (Path) r7.get(c(r10, r11, this.a, this.c, this.b, this.d));
        if (r0 == null) goto L5;
        return r0;
    L5:
        Path r8 = new Path();
        r8.reset();
        r8.moveTo(this.a + 0.0f, 0.0f);
        r8.lineTo(r10 - this.b, 0.0f);
        float r4 = this.b;
        b(r8, r10 - r4, 0.0f + r4, r4, -1);
        r8.lineTo(r10, r11 - this.d);
        float r5 = this.d;
        b(r8, r10 - r5, r11 - r5, r5, 0);
        r8.lineTo(this.c + 0.0f, r11);
        float r6 = this.c;
        b(r8, 0.0f + r6, r11 - r6, r6, 1);
        r8.lineTo(0.0f, this.a + 0.0f);
        float r9 = this.a;
        float r3 = 0.0f + r9;
        b(r8, r3, r3, r9, 2);
        r8.lineTo(this.a + 0.0f, 0.0f);
        r8.close();
        r7.put(c(r10, r11, this.a, this.c, this.b, this.d), r8);
        return r8;
    }

    public LKUIRoundLinearLayout(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        this.k = LazyKt.lazy(LKUIRoundLinearLayout$boardPaint$2.INSTANCE);
        this.l = LazyKt.lazy(LKUIRoundLinearLayout$clearPaint$2.INSTANCE);
        this.m = new Path();
        TypedArray r7 = r4.obtainStyledAttributes(r5, new int[]{2130973821, 2130973822, 2130973823, 2130973824, 2130973825, 2130973826, 2130973827, 2130973828}, 0, 0);
        float r8 = r7.getDimension(3, 0.0f);
        this.a = r7.getDimension(5, r8);
        this.c = r7.getDimension(4, r8);
        this.b = r7.getDimension(7, r8);
        this.d = r7.getDimension(6, r8);
        this.i = r7.getDimension(2, 0.0f);
        this.j = r7.getColor(0, ContextCompat.getColor(r4, 2131108717));
        this.n = r7.getInt(1, 0);
        r7.recycle();
        this.e = getPaddingLeft();
        this.f = getPaddingTop();
        this.g = getPaddingRight();
        this.h = getPaddingBottom();
        if (this.i > 0.0f) goto L5;
        return;
    L5:
        if (this.n != 1) goto L9;
        a();
        return;
    }

    public /* synthetic */ LKUIRoundLinearLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        j08.c r5 = j08.d.c(getContext());
        if (getWidth() <= (r5.a * 2)) goto L5;
    L8:
        boolean r6 = true;
    L9:
        this.o = r6;
        e();
        return;
    L5:
        if (getHeight() > (r5.b * 2)) goto L8;
        r6 = false;
        goto L9
    }

    @Override // android.view.View
    public final void setPadding(int r1, int r2, int r3, int r4) {
        this.e = r1;
        this.f = r2;
        this.g = r3;
        this.h = r4;
        a();
    }

    @Override // com.larksuite.component.ui.layout.b
    public final void setRadius(float r2, float r3, float r4, float r5) {
        float r6 = j08.b.a(getContext(), r2);
        float r7 = j08.b.a(getContext(), r3);
        float r8 = j08.b.a(getContext(), r4);
        float r9 = j08.b.a(getContext(), r5);
        this.a = r6;
        this.c = r7;
        this.b = r8;
        this.d = r9;
        e();
    }

    public final void b(Path r9, float r10, float r11, float r12, int r13) {
        r9.arcTo(r10 - r12, r11 - r12, r10 + r12, r11 + r12, r13 * 90.0f, 90.0f, false);
    }

    public final String c(float r3, float r4, float r5, float r6, float r7, float r8) {
        return "l:0 ,t:0 ,r:" + ((int) r3) + " ,b:" + ((int) r4) + " ,lt:" + ((int) r5) + ", lb = " + ((int) r6) + ", rt = " + ((int) r7) + " , rb = " + ((int) r8);
    }
}
