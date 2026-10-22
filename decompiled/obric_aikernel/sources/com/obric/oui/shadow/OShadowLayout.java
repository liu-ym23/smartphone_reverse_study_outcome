package com.obric.oui.shadow;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.RequiresApi;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/shadow/OShadowLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public class OShadowLayout extends FrameLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private y9.a f7367c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private y9.a f7368g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f7369h;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
    }

    @JvmOverloads
    public OShadowLayout(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public OShadowLayout(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public OShadowLayout(Context r28, AttributeSet r29, int r30) {
        Intrinsics.checkNotNullParameter(r28, "context");
        super(r28, r29, r30);
        this.f7367c = new y9.a(Color.parseColor("#00000000"), 0.0f, 0.0f, 0.0f, 0.0f, null, 32, null);
        this.f7368g = new y9.a(Color.parseColor("#00000000"), 0.0f, 0.0f, 0.0f, 0.0f, null, 32, null);
        TypedArray r10 = r28.obtainStyledAttributes(r29, l.OShadowLayout, r30, 0);
        Intrinsics.checkNotNullExpressionValue(r10, "context.obtainStyledAttr…wLayout, defStyleAttr, 0)");
        y9.a r11 = this.f7367c;
        int r12 = l.OShadowLayout_oui_firstShadowColor;
        int r13 = l.OShadowLayout_oui_firstShadowRadius;
        int r14 = l.OShadowLayout_oui_firstOffsetX;
        int r15 = l.OShadowLayout_oui_firstOffsetY;
        int r16 = l.OShadowLayout_oui_firstShadowSpread;
        b(r10, r11, r12, r13, r14, r15, r16);
        b(r10, this.f7368g, l.OShadowLayout_oui_secondShadowColor, l.OShadowLayout_oui_secondShadowRadius, l.OShadowLayout_oui_secondOffsetX, l.OShadowLayout_oui_secondOffsetY, r16);
        this.f7369h = r10.getDimension(l.OShadowLayout_oui_shadowCornerRadius, 0.0f);
        r10.recycle();
        setWillNotDraw(false);
        c();
    }

    public /* synthetic */ OShadowLayout(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @RequiresApi(26)
    private final void a(Canvas r10, Path r11, RectF r12, y9.a r13) {
        int r14 = r10.save();
        RectF r15 = new RectF(r12);
        r15.offset(r13.b(), r13.c());
        r15.inset(-r13.f(), -r13.f());
        r10.clipOutPath(r11);
        float r16 = this.f7369h;
        r10.drawRoundRect(r15, r16, r16, r13.d());
        r10.restoreToCount(r14);
    }

    private final void b(TypedArray r10, y9.a r11, int r12, int r13, int r14, int r15, int r16) {
        r11.g(r10.getColor(r12, Color.parseColor("#00000000")));
        r11.j(r10.getDimension(r13, 0.0f));
        r11.h(r10.getDimension(r14, 0.0f));
        r11.i(r10.getDimension(r15, 0.0f));
        r11.k(r10.getDimension(r16, 0.0f));
        r11.d().setColor(r11.a());
        if (r11.e() <= 0) goto L6;
        r11.d().setMaskFilter(new BlurMaskFilter(r11.e(), BlurMaskFilter.Blur.NORMAL));
        return;
    }

    private final void c() {
        Math.max(Math.abs(this.f7367c.b()) + Math.abs(this.f7367c.e()), Math.abs(this.f7368g.b()) + Math.abs(this.f7368g.e()));
        Math.max(Math.abs(this.f7367c.c()) + Math.abs(this.f7367c.e()), Math.abs(this.f7368g.c()) + Math.abs(this.f7368g.e()));
    }

    @Override // android.view.View
    @RequiresApi(26)
    protected void onDraw(Canvas r12) {
        Intrinsics.checkNotNullParameter(r12, "canvas");
        super.onDraw(r12);
        Path r10 = new Path();
        int r11 = getChildCount();
        int r13 = Integer.MIN_VALUE;
        int r14 = Integer.MAX_VALUE;
        int r15 = 0;
        int r16 = Integer.MIN_VALUE;
        int r17 = Integer.MAX_VALUE;
    L3:
        if (r15 >= r11) goto L5;
        View r18 = getChildAt(r15);
        Intrinsics.checkNotNullExpressionValue(r18, "child");
        ViewGroup.LayoutParams r19 = r18.getLayoutParams();
        Objects.requireNonNull(r19, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r20 = (ViewGroup.MarginLayoutParams) r19;
        r17 = Math.min(r17, r18.getLeft() - r20.leftMargin);
        r14 = Math.min(r14, r18.getTop() - r20.topMargin);
        r13 = Math.max(r13, r18.getRight() + r20.rightMargin);
        r16 = Math.max(r16, r18.getBottom() + r20.bottomMargin);
        r15 = r15 + 1;
        goto L3
    L5:
        RectF r21 = new RectF(r17, r14, r13, r16);
        float r22 = this.f7369h;
        r10.addRoundRect(r21, r22, r22, Path.Direction.CW);
        RectF r23 = new RectF();
        r10.computeBounds(r23, true);
        a(r12, r10, r23, this.f7367c);
        a(r12, r10, r23, this.f7368g);
    }
}
