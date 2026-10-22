package com.obric.oui.toast;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import androidx.core.content.res.ResourcesCompat;
import ea.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import o9.q;
import u8.c;
import u8.e;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0001\u000eB'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002¨\u0006\u000f"}, d2 = {"Lcom/obric/oui/toast/ToastBackgroundView;", "Landroid/widget/FrameLayout;", "", "height", "", "setupBackground", "getCornerRadius", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class ToastBackgroundView extends FrameLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f7759c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f7760g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final RectF f7761h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Paint f7762i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Paint f7763j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f7764k;

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
    public ToastBackgroundView(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public ToastBackgroundView(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public ToastBackgroundView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        Resources r13 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r13, "Resources.getSystem()");
        this.f7759c = MathKt.roundToInt(TypedValue.applyDimension(1, 24.0f, r13.getDisplayMetrics()));
        this.f7760g = 1.0f;
        this.f7761h = new RectF();
        Paint r14 = new Paint(1);
        r14.setStyle(Paint.Style.FILL);
        Unit r15 = Unit.INSTANCE;
        this.f7762i = r14;
        Paint r16 = new Paint(1);
        r16.setStyle(Paint.Style.STROKE);
        r16.setStrokeWidth(this.f7760g);
        this.f7763j = r16;
        setBackgroundColor(0);
        r14.setColor(getResources().getColor(c.oui_fill_toast_tooltip, null));
        r16.setColor(getResources().getColor(c.LineTertiary, null));
    }

    public /* synthetic */ ToastBackgroundView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    public final int getCornerRadius() {
        return this.f7759c;
    }

    @Override // android.view.View
    protected void onDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        if (this.f7764k == false) goto L5;
        float r11 = 2;
        this.f7761h.set(getPaddingLeft() + (this.f7760g / r11), getPaddingTop() + (this.f7760g / r11), (getWidth() - getPaddingRight()) - (this.f7760g / r11), (getHeight() - getPaddingBottom()) - (this.f7760g / r11));
        float r12 = this.f7759c * 1.0f;
        q.i(r10, this.f7761h, r12, this.f7762i);
        q.i(r10, this.f7761h, r12, this.f7763j);
    L5:
        super.onDraw(r10);
    }

    public final void setupBackground(int r10) {
        if (r10 != (this.f7759c * 2)) goto L5;
        setBackground(ResourcesCompat.getDrawable(getResources(), e.o_toast_background_capsule_form, null));
        boolean r11 = false;
    L6:
        this.f7764k = r11;
        b.a("ToastBackgroundView", "setupBackground: drawSelf = " + this.f7764k + ", height = " + r10);
        invalidate();
        return;
    L5:
        r11 = true;
        goto L6
    }
}
