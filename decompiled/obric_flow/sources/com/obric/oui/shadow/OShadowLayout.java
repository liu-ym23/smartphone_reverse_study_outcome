package com.obric.oui.shadow;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.common.style.m;
import es.a;
import es.b;
import es.c;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/oui/shadow/OShadowLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OShadowLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f14399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f14400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f14401c;

    @JvmOverloads
    public OShadowLayout(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public final void a(Canvas r5, Path r10, RectF r11, m r12) {
        int r13 = r5.save();
        RectF r14 = new RectF(r11);
        r14.offset(r12.f12518c, r12.d);
        float r15 = -r12.e;
        r14.inset(r15, r15);
        r5.clipOutPath(r10);
        float r16 = this.f14401c;
        r5.drawRoundRect(r14, r16, r16, r12.f);
        r5.restoreToCount(r13);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r12) {
        Intrinsics.checkNotNullParameter(r12, "canvas");
        super.onDraw(r12);
        Path r5 = new Path();
        int r10 = getChildCount();
        int r11 = Integer.MAX_VALUE;
        int r13 = Integer.MIN_VALUE;
        int r14 = 0;
        int r15 = Integer.MAX_VALUE;
        int r16 = Integer.MIN_VALUE;
    L3:
        if (r14 >= r10) goto L9;
        int r17 = r14 + 1;
        View r18 = getChildAt(r14);
        ViewGroup.LayoutParams r19 = r18.getLayoutParams();
        if (r19 == null) goto L8;
        ViewGroup.MarginLayoutParams r20 = (ViewGroup.MarginLayoutParams) r19;
        r11 = Math.min(r11, r18.getLeft() - r20.leftMargin);
        r15 = Math.min(r15, r18.getTop() - r20.topMargin);
        r16 = Math.max(r16, r18.getRight() + r20.rightMargin);
        r13 = Math.max(r13, r18.getBottom() + r20.bottomMargin);
        r14 = r17;
        goto L3
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L9:
        RectF r21 = new RectF(r11, r15, r16, r13);
        float r22 = this.f14401c;
        r5.addRoundRect(r21, r22, r22, Path.Direction.CW);
        RectF r23 = new RectF();
        r5.computeBounds(r23, true);
        a(r12, r5, r23, this.f14399a);
        a(r12, r5, r23, this.f14400b);
    }

    @JvmOverloads
    public OShadowLayout(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OShadowLayout(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public OShadowLayout(Context r21, AttributeSet r22, int r23) {
        Intrinsics.checkNotNullParameter(r21, "context");
        super(r21, r22, r23);
        m r5 = m.f12515h;
        m r10 = r5.a();
        this.f14399a = r10;
        m r11 = r5.a();
        this.f14400b = r11;
        TypedArray r12 = r21.obtainStyledAttributes(r22, R$styleable.OShadowLayout, r23, 0);
        a[] r13 = ShadowToken.parse(r12.getString(R$styleable.OShadowLayout_oui_shadow));
        if (r13 != null) goto L5;
        int r14 = R$styleable.OShadowLayout_oui_firstShadowColor;
        int r15 = R$styleable.OShadowLayout_oui_firstShadowRadius;
        int r16 = R$styleable.OShadowLayout_oui_firstOffsetX;
        int r17 = R$styleable.OShadowLayout_oui_firstOffsetY;
        int r18 = R$styleable.OShadowLayout_oui_firstShadowSpread;
        Intrinsics.checkNotNullParameter(r12, "typedArray");
        r10.d(c.a(new b(r12.getColor(r14, 0), -1, r12.getDimension(r16, 0.0f), r12.getDimension(r17, 0.0f), r12.getDimension(r15, 0.0f), r12.getDimension(r18, 0.0f))));
        int r19 = R$styleable.OShadowLayout_oui_secondShadowColor;
        int r20 = R$styleable.OShadowLayout_oui_secondShadowRadius;
        int r24 = R$styleable.OShadowLayout_oui_secondOffsetX;
        int r25 = R$styleable.OShadowLayout_oui_secondOffsetY;
        int r110 = R$styleable.OShadowLayout_oui_secondShadowSpread;
        Intrinsics.checkNotNullParameter(r12, "typedArray");
        r11.d(c.a(new b(r12.getColor(r19, 0), -1, r12.getDimension(r24, 0.0f), r12.getDimension(r25, 0.0f), r12.getDimension(r20, 0.0f), r12.getDimension(r110, 0.0f))));
    L14:
        this.f14401c = r12.getDimension(R$styleable.OShadowLayout_oui_shadowCornerRadius, 0.0f);
        r12.recycle();
        setWillNotDraw(false);
        Math.max(Math.abs(r10.f12517b) + Math.abs(r10.f12518c), Math.abs(r11.f12517b) + Math.abs(r11.f12518c));
        Math.max(Math.abs(r10.f12517b) + Math.abs(r10.d), Math.abs(r11.f12517b) + Math.abs(r11.d));
        return;
    L5:
        if (r13.length != 0) goto L7;
        boolean r26 = true;
    L8:
        if (r26 == true) goto L11;
        r10.d(r13[0]);
    L11:
        if (r13.length <= 1) goto L14;
        r11.d(r13[1]);
        goto L14
    L7:
        r26 = false;
        goto L8
    }
}
