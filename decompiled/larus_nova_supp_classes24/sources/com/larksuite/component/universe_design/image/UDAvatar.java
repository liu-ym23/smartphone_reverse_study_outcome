package com.larksuite.component.universe_design.image;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import h18.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 >2\u00020\u0001:\u0002=>B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\"\u0010'\u001a\u00020(2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0014J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0002J\u0018\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020\nH\u0014J(\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\n2\u0006\u00102\u001a\u00020\nH\u0014J\u0018\u00103\u001a\u00020(2\u0006\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u00020\nH\u0002J\b\u00104\u001a\u00020(H\u0014J\r\u00105\u001a\u000206H\u0000¢\u0006\u0002\b7J\u0010\u00108\u001a\u00020(2\u0006\u00109\u001a\u00020:H\u0014J\u0012\u0010;\u001a\u00020(2\b\u00109\u001a\u0004\u0018\u00010:H\u0002J\b\u0010<\u001a\u00020\"H\u0002R$\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\"\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010#\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013R\u000e\u0010&\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/larksuite/component/universe_design/image/UDAvatar;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "value", "borderStyle", "getBorderStyle", "()I", "setBorderStyle", "(I)V", "borderColor", "getBorderColor", "setBorderColor", "borderWidth", "", "getBorderWidth", "()Ljava/lang/Float;", "setBorderWidth", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "borderPaint", "Landroid/graphics/Paint;", "cornerRadius", "isDrawBorderDelegate", "", "avatarSize", "getAvatarSize", "setAvatarSize", "avatarSizeInPixel", "init", "", "ta", "Landroid/content/res/TypedArray;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "updateOutline", "onAvatarSizeChanged", "drawBorderDelegate", "Landroid/widget/FrameLayout;", "drawBorderDelegate$universe_ui_avatar_release", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawBorder", "shouldDrawBorder", "AvatarOutlineProvider", "Companion", "universe-ui-avatar_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public class UDAvatar extends AppCompatImageView {
    public static final int AVATAR_EXTRA_SMALL = -5;
    public static final int AVATAR_LARGE = -1;
    public static final int AVATAR_MIDDLE = -2;
    public static final int AVATAR_MINI = -4;
    public static final int AVATAR_SMALL = -3;
    public static final int BORDER_CIRCLE = 0;
    public static final int BORDER_RECTANGULAR = 1;
    public static final b Companion = null;
    private int avatarSize;
    private int avatarSizeInPixel;
    private int borderColor;
    private Paint borderPaint;
    private int borderStyle;
    private Float borderWidth;
    private float cornerRadius;
    private boolean isDrawBorderDelegate;

    public static final class a extends ViewOutlineProvider {
        public final int a;
        public final int b;
        public final float c;

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r7, Outline r8) {
            if (r8 == null) goto L5;
            r8.setRoundRect(0, 0, this.a, this.b, this.c);
            return;
        }

        public a(int r1, int r2, float r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class b {
        public b() {
        }
    }

    static {
        Companion = new b();
    }

    private final boolean shouldDrawBorder() {
        if (this.isDrawBorderDelegate == false) goto L5;
    L13:
        return false;
    L5:
        if (this.borderColor == 0) goto L13;
        Float r0 = this.borderWidth;
        if (r0 == null) goto L9;
        float r1 = r0.floatValue();
    L11:
        if (r1 <= 0.0f) goto L13;
        return true;
    L9:
        r1 = 0.0f;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final FrameLayout drawBorderDelegate$universe_ui_avatar_release() {
        if (this.isDrawBorderDelegate == true) goto L14;
        this.isDrawBorderDelegate = true;
        FrameLayout r0 = new FrameLayout(getContext());
        GradientDrawable r1 = new GradientDrawable();
        Float r2 = this.borderWidth;
        if (r2 == null) goto L7;
        int r3 = (int) r2.floatValue();
    L8:
        r1.setStroke(r3, this.borderColor);
        r1.setCornerRadius(this.avatarSizeInPixel / 2.0f);
        r0.setBackground(r1);
        Float r4 = this.borderWidth;
        if (r4 == null) goto L11;
        int r5 = (int) r4.floatValue();
    L12:
        int r6 = r5 - 0;
        r0.setPadding(r6, r6, r6, r6);
        r0.addView(this, new FrameLayout.LayoutParams(-2, -2));
        this.avatarSizeInPixel -= r6;
        return r0;
    L11:
        r5 = 0;
        goto L12
    L7:
        r3 = 0;
        goto L8
    L14:
        ViewParent r7 = getParent();
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.widget.FrameLayout");
        return (FrameLayout) r7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAvatarSizeChanged() {
        int r0 = this.avatarSize;
        if (r0 == (-5)) goto L13;
        if (r0 == (-4)) goto L12;
        if (r0 == (-3)) goto L11;
        if (r0 == (-2)) goto L10;
        if (r0 == (-1)) goto L9;
        float r1 = r0;
    L14:
        this.avatarSizeInPixel = (int) r1;
        int r2 = this.avatarSize;
        if (r2 == (-5)) goto L26;
        if (r2 == (-4)) goto L25;
        if (r2 == (-3)) goto L24;
        if (r2 != (-2)) goto L20;
        float r3 = d.c(getContext(), 2131169349);
    L27:
        this.cornerRadius = r3;
        return;
    L20:
        if (r2 == (-1)) goto L22;
        r3 = d.c(getContext(), 2131169348);
        goto L27
    L22:
        r3 = d.c(getContext(), 2131169348);
        goto L27
    L24:
        r3 = d.c(getContext(), 2131169351);
        goto L27
    L25:
        r3 = d.c(getContext(), 2131169350);
        goto L27
    L26:
        r3 = d.c(getContext(), 2131169347);
        goto L27
    L9:
        r1 = d.c(getContext(), 2131169353);
        goto L14
    L10:
        r1 = d.c(getContext(), 2131169354);
        goto L14
    L11:
        r1 = d.c(getContext(), 2131169356);
        goto L14
    L12:
        r1 = d.c(getContext(), 2131169355);
        goto L14
    L13:
        r1 = d.c(getContext(), 2131169352);
        goto L14
    }

    public final int getAvatarSize() {
        return this.avatarSize;
    }

    public final int getBorderColor() {
        return this.borderColor;
    }

    public final int getBorderStyle() {
        return this.borderStyle;
    }

    public final Float getBorderWidth() {
        return this.borderWidth;
    }

    public UDAvatar(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void drawBorder(Canvas r8) {
        if (shouldDrawBorder() == true) goto L5;
        return;
    L5:
        Paint r0 = this.borderPaint;
        if (r0 == null) goto L12;
        Float r2 = this.borderWidth;
        if (r2 == null) goto L10;
        float r3 = r2.floatValue();
    L11:
        r0.setStrokeWidth(r3);
        goto L12
    L10:
        r3 = 0.0f;
    L12:
        Float r1 = this.borderWidth;
        if (r1 == null) goto L15;
        float r4 = r1.floatValue();
    L17:
        if (r4 <= 0.0f) goto L39;
        Paint r5 = this.borderPaint;
        if (r5 == null) goto L21;
        r5.setColor(this.borderColor);
    L21:
        Float r6 = this.borderWidth;
        if (r6 == null) goto L24;
        float r7 = r6.floatValue();
    L25:
        float r9 = r7 / 3;
        float r10 = getWidth() / 2.0f;
        float r11 = getHeight() / 2.0f;
        if (this.borderStyle != 0) goto L31;
        float r12 = Math.min(r10, r11) - r9;
        Paint r13 = this.borderPaint;
        if (r13 == null) goto L40;
        if (r8 == null) goto L41;
        r8.drawCircle(r10, r11, r12, r13);
        return;
    L41:
        return;
    L40:
        return;
    L31:
        RectF r14 = new RectF(r9, r9, getWidth() - r9, getHeight() - r9);
        float r15 = this.cornerRadius;
        if (r15 >= 0.0f) goto L34;
        r15 = Math.min(r10, r11) - r9;
    L34:
        Paint r16 = this.borderPaint;
        if (r16 == null) goto L43;
        if (r8 == null) goto L44;
        r8.drawRoundRect(r14, r15, r15, r16);
        return;
    L44:
        return;
    L43:
        return;
    L24:
        r7 = 0.0f;
        goto L25
    L39:
        return;
    L15:
        r4 = 0.0f;
        goto L17
    }

    private final void init(TypedArray r7) {
        this.cornerRadius = r7.getDimensionPixelSize(4, -1);
        int r0 = r7.getDimensionPixelSize(3, -1);
        if (r0 <= 0) goto L5;
        this.borderWidth = Float.valueOf(r0);
    L5:
        boolean r1 = true;
        this.borderColor = r7.getColor(1, 0);
        setBorderStyle(r7.getInt(2, 0));
        int r4 = r7.getType(5);
        if (r4 != 5) goto L9;
        setAvatarSize(r7.getDimensionPixelSize(5, 0));
        return;
    L9:
        if (16 <= r4) goto L11;
    L13:
        r1 = false;
    L14:
        if (r1 == false) goto L18;
        setAvatarSize(r7.getInt(5, -1));
        return;
    L18:
        return;
    L11:
        if (r4 >= 32) goto L13;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        super/*android.widget.ImageView*/.onDraw(r2);
        drawBorder(r2);
    }

    public final void setAvatarSize(int r1) {
        this.avatarSize = r1;
        onAvatarSizeChanged();
    }

    public final void setBorderColor(int r1) {
        this.borderColor = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setBorderStyle(int r2) {
        this.borderStyle = r2;
        updateOutline(getWidth(), getHeight());
    }

    public final void setBorderWidth(Float r1) {
        this.borderWidth = r1;
    }

    public UDAvatar(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void updateOutline(int r3, int r4) {
        if (r3 == 0) goto L12;
        if (r4 != 0) goto L6;
        return;
    L6:
        if (this.borderStyle == 0) goto L9;
        float r0 = this.cornerRadius;
        if (r0 < 0.0f) goto L9;
    L10:
        setOutlineProvider(new a(r3, r4, r0));
        return;
    L9:
        r0 = Math.min(r3, r4) / 2.0f;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onMeasure(int r1, int r2) {
        super/*android.widget.ImageView*/.onMeasure(r1, r2);
        int r3 = this.avatarSizeInPixel;
        setMeasuredDimension(r3, r3);
    }

    public UDAvatar(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, r4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void init(AttributeSet r4, int r5, int r6) {
        Paint r0 = new Paint();
        this.borderPaint = r0;
        r0.setStyle(Paint.Style.STROKE);
        r0.setAntiAlias(true);
        setScaleType(ImageView.ScaleType.CENTER_CROP);
        TypedArray r7 = getContext().obtainStyledAttributes(r4, new int[]{2130974835, 2130974836, 2130974837, 2130974838, 2130974839, 2130974840, 2130974841, 2130974842, 2130974843}, r5, r6);
        init(r7);
        r7.recycle();
        setClipToOutline(true);
    }

    public UDAvatar(Context r2, AttributeSet r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.avatarSize = -1;
        init(r3, r4, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super/*android.widget.ImageView*/.onSizeChanged(r1, r2, r3, r4);
        updateOutline(r1, r2);
    }
}
