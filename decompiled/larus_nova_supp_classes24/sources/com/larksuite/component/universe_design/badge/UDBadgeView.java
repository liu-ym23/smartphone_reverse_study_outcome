package com.larksuite.component.universe_design.badge;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import h18.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001e\b\u0017\u0018\u00002\u00020\u0001:\u0001HB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ*\u0010#\u001a\u00020$2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\b\u0010%\u001a\u00020$H\u0002J\u0018\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\nH\u0014J\u0010\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020+H\u0014J\u000e\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020\u000fJ\u000e\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u00020\u0011J\u0010\u00100\u001a\u00020$2\b\b\u0001\u00101\u001a\u00020\nJ\u0010\u00102\u001a\u00020$2\b\b\u0001\u00103\u001a\u00020\nJ\u000e\u00104\u001a\u00020$2\u0006\u00105\u001a\u00020\u0011J\u0010\u00106\u001a\u00020$2\b\b\u0001\u00101\u001a\u00020\nJ\u0010\u00107\u001a\u00020$2\b\b\u0001\u00103\u001a\u00020\nJ\u000e\u00108\u001a\u00020$2\u0006\u00105\u001a\u00020\u0011J\u0010\u00109\u001a\u00020$2\b\b\u0001\u00101\u001a\u00020\nJ\u0010\u0010:\u001a\u00020$2\b\b\u0001\u00103\u001a\u00020\nJ\u0010\u0010;\u001a\u00020$2\b\b\u0001\u0010<\u001a\u00020\nJ\u000e\u0010;\u001a\u00020$2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010=\u001a\u00020$2\u0006\u0010>\u001a\u00020 J\u0010\u0010?\u001a\u00020$2\b\b\u0001\u0010@\u001a\u00020\nJ\u000e\u0010?\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010A\u001a\u00020$2\b\b\u0001\u0010\u001a\u001a\u00020\nJ\u0010\u0010B\u001a\u00020$2\b\b\u0001\u00103\u001a\u00020\nJ\u000e\u0010C\u001a\u00020$2\u0006\u0010\u0019\u001a\u00020\u0011J\u000e\u0010D\u001a\u00020$2\u0006\u0010>\u001a\u00020\u0011J\u000e\u0010E\u001a\u00020$2\u0006\u0010F\u001a\u00020\nJ\u0006\u0010G\u001a\u00020$R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/larksuite/component/universe_design/badge/UDBadgeView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "badgeType", "Lcom/larksuite/component/universe_design/badge/UDBadge$BadgeType;", "badgeSize", "", "badgeColor", "outerBorderWidth", "outerBorderColor", "innerBorderWidth", "innerBorderColor", "text", "", "textSize", "textColor", "textWidthPadding", "textMaxLength", "icon", "Landroid/graphics/drawable/Drawable;", "iconPadding", "Landroid/graphics/RectF;", "badge", "Lcom/larksuite/component/universe_design/badge/UDBadge;", "init", "", "updateModel", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setBadgeType", "type", "setBadgeSize", "size", "setBadgeColor", "color", "setBadgeColorRes", "colorRes", "setOuterBorderWidth", "width", "setOuterBorderColor", "setOuterBorderColorRes", "setInnerBorderWidth", "setInnerBorderColor", "setInnerBorderColorRes", "setIcon", "iconResId", "setIconPadding", "padding", "setText", "textResId", "setTextColor", "setTextColorRes", "setTextSize", "setTextWidthPadding", "setTextMaxLength", "maxLength", "applyChanges", "Builder", "universe-ui-badge_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public class UDBadgeView extends View {
    public UDBadge.BadgeType a;
    public float b;
    public int c;
    public float d;
    public int e;
    public float f;
    public int g;
    public String h;
    public float i;
    public int j;
    public float k;
    public int l;
    public Drawable m;
    public RectF n;
    public final UDBadge o;

    public final void b() {
        UDBadge r1 = this.o;
        UDBadge.c r2 = new UDBadge.c();
        UDBadge.BadgeType r3 = this.a;
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r2.a = r3;
        r2.b = this.b;
        r2.c = this.c;
        r2.d = this.d;
        r2.e = this.e;
        r2.f = this.f;
        r2.g = this.g;
        String r4 = this.h;
        r2.h = r4;
        r2.j = this.j;
        r2.i = this.i;
        r2.k = this.k;
        r2.l = this.m;
        r2.m = this.n;
        boolean r7 = false;
        if (this.a != UDBadge.BadgeType.TEXT) goto L23;
        if (r4 == null) goto L23;
        if (r4.length() <= 0) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == true) goto L11;
    L13:
        boolean r6 = false;
    L14:
        Drawable r8 = null;
        if (r6 == true) goto L18;
        r4 = null;
    L18:
        if (r4 == null) goto L23;
        Drawable r9 = getContext().getDrawable(2131255147);
        if (r9 == null) goto L22;
        r8 = r9.mutate();
        r8.setTint(UDColorUtils.getColor(getContext(), 2131106521));
    L22:
        r2.l = r8;
        UDBadge.BadgeType r10 = UDBadge.BadgeType.ICON;
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r2.a = r10;
        float r11 = d.a(getContext(), 4.0f);
        r2.m = new RectF(r11, 0.0f, r11, 0.0f);
        goto L23
    L11:
        if (r4.length() <= this.l) goto L13;
        r6 = true;
        goto L14
    L8:
        r5 = false;
    L23:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "newModel");
        if (r2.a == UDBadge.BadgeType.UNKNOWN) goto L70;
        if (r2.b <= 0.0f) goto L68;
        r1.b.update(r2);
        UDBadge.b r12 = r1.c;
        UDBadge.c r13 = r12.g.b;
        float r14 = r13.b;
        float r15 = 2;
        float r16 = r13.f * r15;
        float r17 = r14 - r16;
        float r19 = (r13.d * r15) + r16;
        int r20 = UDBadge.b.a.a[r13.a.ordinal()];
        if (r20 == 1) goto L57;
        if (r20 == 2) goto L31;
        RectF r21 = r12.d;
        r21.left = 0.0f;
        r21.top = 0.0f;
        float r22 = r17 + r19;
        r21.right = r22;
        r21.bottom = r22;
    L65:
        r1.d = r1.c.d.width();
        r1.e = r1.c.d.height();
        return;
    L31:
        UDBadge.c r23 = r12.g.b;
        Drawable r24 = r23.l;
        if (r24 == null) goto L65;
        RectF r25 = r23.m;
        if (r25 == null) goto L36;
        float r26 = r25.top;
    L37:
        if (r25 == null) goto L39;
        float r110 = r25.bottom;
    L40:
        if (r25 == null) goto L42;
        float r111 = r25.left;
    L43:
        if (r25 == null) goto L45;
        float r27 = r25.right;
    L46:
        float r29 = (r17 - r26) - r110;
        float r112 = r24.getIntrinsicWidth() * 1.0f;
        float r30 = r24.getIntrinsicHeight() * 1.0f;
        if (r30 != r29) goto L49;
        r7 = true;
    L49:
        if (r7 == true) goto L51;
        float r31 = (r29 / r30) * r112;
    L52:
        float r113 = (r111 + r31) + r27;
        if (r113 > r17) goto L56;
        r113 = r17;
    L56:
        RectF r32 = r12.d;
        r32.left = 0.0f;
        r32.top = 0.0f;
        r32.right = r113 + r19;
        r32.bottom = r17 + r19;
        RectF r33 = r12.f;
        float r34 = r31 / r15;
        r33.left = r32.centerX() - r34;
        float r35 = r29 / r15;
        r33.top = r12.d.centerY() - r35;
        r33.right = r12.d.centerX() + r34;
        r33.bottom = r12.d.centerY() + r35;
        goto L65
    L51:
        r29 = r30 * 1.0f;
        r31 = r112 * 1.0f;
        goto L52
    L45:
        r27 = 0.0f;
        goto L46
    L42:
        r111 = 0.0f;
        goto L43
    L39:
        r110 = 0.0f;
        goto L40
    L36:
        r26 = 0.0f;
        goto L37
    L57:
        String r36 = r12.g.b.h;
        if (TextUtils.isEmpty(r36) == true) goto L63;
        r12.c.setColor(r12.g.b.j);
        r12.c.setTextSize(r12.g.b.i);
        r12.c.setLetterSpacing(0.02f);
        float r37 = r12.c.measureText(r36);
        float r38 = (r12.g.b.k * r15) + r37;
        if (r38 > r17) goto L64;
        r38 = r17;
    L64:
        RectF r39 = r12.d;
        r39.left = 0.0f;
        r39.top = 0.0f;
        r39.right = r38 + r19;
        r39.bottom = r17 + r19;
        Paint.FontMetricsInt r40 = r12.c.getFontMetricsInt();
        float r41 = r12.d.centerY();
        int r42 = r40.descent;
        float r43 = ((r41 - r42) + ((r42 - r40.ascent) / 2)) - 0.5f;
        float r44 = (r12.d.centerX() - (r37 / r15)) - 0.5f;
        PointF r45 = r12.e;
        r45.x = r44;
        r45.y = r43;
        goto L65
    L63:
        r38 = r17;
        r37 = 0.0f;
        goto L64
    L68:
        throw new IllegalArgumentException("BadgeSize is 0, please set first.");
    L70:
        throw new IllegalArgumentException("BadgeType is unknown, please set first.");
    }

    public final void a() {
        b();
        if (isAttachedToWindow() == false) goto L6;
        requestLayout();
        invalidate();
        return;
    }

    public UDBadgeView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r9) {
        Intrinsics.checkNotNullParameter(r9, "canvas");
        super.onDraw(r9);
        UDBadge r1 = this.o;
        if (r9 != null) goto L5;
        r1.getClass();
        return;
    L5:
        UDBadge.b r2 = r1.c;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r9, "canvas");
        r2.a.setStyle(Paint.Style.STROKE);
        r2.a.setColor(r2.g.b.e);
        r2.a.setStrokeWidth(r2.g.b.d);
        UDBadge r0 = r2.g;
        float r3 = 2;
        float r4 = r0.b.d / r3;
        float r5 = UDBadge.a(r0);
        float r6 = UDBadge.b(r2.g);
        RectF r7 = new RectF();
        RectF r8 = r2.d;
        r7.left = (r8.left + r4) + r5;
        r7.top = (r8.top + r4) + r6;
        r7.right = (r8.right - r4) + r5;
        r7.bottom = (r8.bottom - r4) + r6;
        float r10 = Math.min(r7.height() / r3, r7.height() / r3);
        r9.drawRoundRect(r7, r10, r10, r2.a);
        r2.a.setStyle(Paint.Style.STROKE);
        r2.a.setColor(r2.g.b.g);
        r2.a.setStrokeWidth(r2.g.b.f);
        UDBadge r11 = r2.g;
        float r12 = r11.b.f / r3;
        float r13 = UDBadge.a(r11);
        float r14 = UDBadge.b(r2.g);
        RectF r15 = new RectF();
        RectF r16 = r2.d;
        r15.left = (r16.left + r12) + r13;
        r15.top = (r16.top + r12) + r14;
        r15.right = (r16.right - r12) + r13;
        r15.bottom = (r16.bottom - r12) + r14;
        float r17 = Math.min(r15.height() / r3, r15.height() / r3);
        r9.drawRoundRect(r15, r17, r17, r2.a);
        r2.b.setStyle(Paint.Style.FILL);
        r2.b.setColor(r2.g.b.c);
        UDBadge r19 = r2.g;
        UDBadge.c r20 = r19.b;
        float r21 = r20.d + r20.f;
        float r22 = UDBadge.a(r19);
        float r23 = UDBadge.b(r2.g);
        RectF r24 = new RectF();
        RectF r25 = r2.d;
        r24.left = (r25.left + r21) + r22;
        r24.top = (r25.top + r21) + r23;
        r24.right = (r25.right - r21) + r22;
        r24.bottom = (r25.bottom - r21) + r23;
        float r26 = Math.min(r24.height() / r3, r24.height() / r3);
        r9.drawRoundRect(r24, r26, r26, r2.b);
        UDBadge r27 = r2.g;
        UDBadge.c r29 = r27.b;
        UDBadge.BadgeType r30 = r29.a;
        if (r30 != UDBadge.BadgeType.TEXT) goto L12;
        String r31 = r29.h;
        if (r31 == null) goto L21;
        float r32 = UDBadge.a(r27);
        float r33 = UDBadge.b(r2.g);
        PointF r34 = r2.e;
        r9.drawText(r31, r34.x + r32, r34.y + r33, r2.c);
        return;
    L21:
        return;
    L12:
        if (r30 != UDBadge.BadgeType.ICON) goto L20;
        Drawable r35 = r29.l;
        if (r35 == null) goto L22;
        float r36 = UDBadge.a(r27);
        float r37 = UDBadge.b(r2.g);
        Rect r38 = new Rect();
        RectF r39 = r2.f;
        r38.left = (int) (r39.left + r36);
        r38.top = (int) (r39.top + r37);
        r38.right = (int) (r39.right + r36);
        r38.bottom = (int) (r39.bottom + r37);
        r35.setBounds(r38);
        r35.draw(r9);
        return;
    L22:
        return;
    }

    public final void setBadgeColor(int r1) {
        this.c = r1;
    }

    public final void setBadgeColorRes(int r2) {
        this.c = ContextCompat.getColor(getContext(), r2);
    }

    public final void setBadgeSize(float r1) {
        this.b = r1;
    }

    public final void setBadgeType(UDBadge.BadgeType r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        this.a = r2;
    }

    public final void setIcon(int r2) {
        this.m = ContextCompat.getDrawable(getContext(), r2);
    }

    public final void setIconPadding(RectF r2) {
        Intrinsics.checkNotNullParameter(r2, "padding");
        this.n = r2;
    }

    public final void setInnerBorderColor(int r1) {
        this.g = r1;
    }

    public final void setInnerBorderColorRes(int r2) {
        this.g = ContextCompat.getColor(getContext(), r2);
    }

    public final void setInnerBorderWidth(float r1) {
        this.f = r1;
    }

    public final void setOuterBorderColor(int r1) {
        this.e = r1;
    }

    public final void setOuterBorderColorRes(int r2) {
        this.e = ContextCompat.getColor(getContext(), r2);
    }

    public final void setOuterBorderWidth(float r1) {
        this.d = r1;
    }

    public final void setText(int r2) {
        this.h = getContext().getResources().getString(r2);
    }

    public final void setTextColor(int r1) {
        this.j = r1;
    }

    public final void setTextColorRes(int r2) {
        this.j = ContextCompat.getColor(getContext(), r2);
    }

    public final void setTextMaxLength(int r1) {
        this.l = r1;
    }

    public final void setTextSize(float r1) {
        this.i = r1;
    }

    public final void setTextWidthPadding(float r1) {
        this.k = r1;
    }

    public final void setIcon(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "icon");
        this.m = r2;
    }

    public final void setText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        this.h = r2;
    }

    public UDBadgeView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r1, int r2) {
        UDBadge r3 = this.o;
        float r4 = r3.d;
        setMeasuredDimension((int) r4, (int) r3.e);
    }

    public UDBadgeView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, r4, 0);
    }

    public UDBadgeView(Context r8, AttributeSet r9, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, r10, r11);
        UDBadge.BadgeType r0 = UDBadge.BadgeType.UNKNOWN;
        this.a = r0;
        this.l = 3;
        this.o = new UDBadge(getContext());
        TypedArray r2 = r8.obtainStyledAttributes(r9, new int[]{2130974845, 2130974846, 2130974847, 2130974848, 2130974849, 2130974850, 2130974851, 2130974852, 2130974853, 2130974854, 2130974855, 2130974856, 2130974857, 2130974858}, r10, r11);
        int r3 = r2.getInt(13, -1);
        if (r3 == 0) goto L9;
        if (r3 == 1) goto L8;
        if (r3 != 2) goto L10;
        r0 = UDBadge.BadgeType.ICON;
    L10:
        this.a = r0;
        this.b = r2.getDimension(7, d.a(r8, 16.0f));
        this.c = r2.getColor(0, 0);
        this.d = r2.getDimension(6, 0.0f);
        this.e = r2.getColor(5, 0);
        this.f = r2.getDimension(4, 0.0f);
        this.g = r2.getColor(3, 0);
        this.h = r2.getString(8);
        this.j = r2.getColor(9, 0);
        this.i = r2.getDimension(11, d.f(r8, 12.0f));
        this.k = r2.getDimension(12, 0.0f);
        this.l = r2.getInt(10, this.l);
        this.m = r2.getDrawable(1);
        float r12 = r2.getDimension(2, d.a(r8, 4.0f));
        this.n = new RectF(r12, r12, r12, r12);
        r2.recycle();
        if (r9 != null) goto L14;
        if (r10 != 0) goto L14;
        if (r11 != 0) goto L14;
        return;
    L14:
        b();
        return;
    L8:
        r0 = UDBadge.BadgeType.TEXT;
        goto L10
    L9:
        r0 = UDBadge.BadgeType.DOT;
        goto L10
    }
}
