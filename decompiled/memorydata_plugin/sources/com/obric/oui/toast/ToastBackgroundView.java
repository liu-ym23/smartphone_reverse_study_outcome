package com.obric.oui.toast;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.res.ResourcesCompat;
import com.obric.memorydata.plugin.R;
import com.obric.oui.c.i;
import com.obric.oui.color.d;
import com.obric.oui.common.util.h;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.c;
import com.obric.oui.material.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 #2\u00020\u0001:\u0001#B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0015\u001a\u00020\u0007J\u0006\u0010\u0016\u001a\u00020\u0010J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0014J\u0017\u0010\u001b\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010\u001dJ&\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u00072\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"H\u0007R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/obric/oui/toast/ToastBackgroundView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bgColor", "bgPaint", "Landroid/graphics/Paint;", "borderColor", "borderWidth", "cornerRadius", "drawSelf", "", "enableMaterial", "rectF", "Landroid/graphics/RectF;", "strokePaint", "getCornerRadius", "isDarkTheme", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "resolveColors", "originBgColor", "(Ljava/lang/Integer;)V", "setupBackground", "height", "materialSrcType", "materialBackdropTarget", "Landroid/view/View;", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ToastBackgroundView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14805a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f14806b;
    private final RectF c;
    private int d;
    private final Paint e;
    private final Paint f;
    private int g;
    private int h;
    private boolean i;
    private boolean j;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/toast/ToastBackgroundView$Companion;", "", "()V", "DEFAULT_CORNER_RADIUS", "", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f14805a = new a(null);
    }

    public ToastBackgroundView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public ToastBackgroundView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public ToastBackgroundView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r5);
        this.f14806b = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 24.0f);
        this.c = new RectF();
        boolean r8 = true;
        Paint r9 = new Paint(1);
        r9.setStyle(Paint.Style.FILL);
        this.e = r9;
        Paint r10 = new Paint(1);
        r10.setStyle(Paint.Style.STROKE);
        this.f = r10;
        if (l.a(r6) == true) goto L5;
    L7:
        r8 = false;
    L8:
        this.j = r8;
        Integer r11 = i.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"));
        setBackgroundColor(0);
        a(r11);
        return;
    L5:
        if (OMaterialHelper.d() == false) goto L7;
        goto L7
    }

    public /* synthetic */ ToastBackgroundView(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public static /* synthetic */ void a(ToastBackgroundView r0, int r1, int r2, View r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 3;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = null;
    L8:
        r0.a(r1, r2, r3);
    }

    private final void a(Integer r7) {
        if (r7 != null) goto L5;
        int r8 = ResourcesCompat.getColor(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_toast_background, TypedValues.Custom.S_COLOR, "oui_toast_background"), ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getTheme());
        if (this.e.getColor() == r8) goto L13;
        this.e.setColor(r8);
        this.d = r8;
        com.obric.oui.c.a.b.b("ToastBackgroundView", Intrinsics.stringPlus("resolveColors: bg=", Integer.valueOf(r8)));
        return;
    L13:
        return;
    L5:
        if (this.e.getColor() == r7.intValue()) goto L12;
        this.e.setColor(r7.intValue());
        this.d = r7.intValue();
        com.obric.oui.c.a.b.b("ToastBackgroundView", "resolveColors: bg=" + r7 + " from originBgColor");
        return;
    }

    public final void a(int r12, int r13, View r14) {
        if (this.j == false) goto L7;
        this.i = false;
        GradientDrawable r15 = new GradientDrawable();
        r15.setShape(0);
        r15.setCornerRadius(this.f14806b);
        r15.setColor(0);
        setBackground((Drawable) ZeusTransformUtils.preCheckCast(r15, Drawable.class, "com.obric.memorydata.plugin"));
        setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        l.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), (c[]) ZeusTransformUtils.preCheckCast(MaterialToken.OUI_Bg_Popup.invoke(Boolean.valueOf(!a())), c[].class, "com.obric.memorydata.plugin"), false, r13, null, 10, null);
        l.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r14);
        return;
    L7:
        if (r12 != (this.f14806b * 2)) goto L9;
        setBackground(ResourcesCompat.getDrawable(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.drawable.o_toast_background_capsule_form, "drawable", "o_toast_background_capsule_form"), ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getTheme()));
        this.i = false;
    L10:
        com.obric.oui.c.a.b.b("ToastBackgroundView", "setupBackground: drawSelf = " + this.i + ", height = " + r12);
        invalidate();
        return;
    L9:
        this.i = true;
        goto L10
    }

    public final boolean a() {
        int r0 = this.d;
        if (r0 != 0) goto L7;
        return i.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"));
    L7:
        return d.a(r0);
    }

    public final int getCornerRadius() {
        return this.f14806b;
    }

    @Override // android.view.View
    public void onDraw(Canvas r8) {
        Intrinsics.checkNotNullParameter(r8, "canvas");
        float r0 = this.f14806b * 1.0f;
        this.c.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        if (this.i == false) goto L5;
        r8.drawRoundRect(this.c, r0, r0, this.e);
    L5:
        int r1 = this.g;
        if (r1 <= 0) goto L8;
        this.f.setStrokeWidth(r1);
        this.f.setColor(this.h);
        r8.drawRoundRect(this.c, r0, r0, this.f);
    L8:
        super.onDraw(r8);
    }

    public final void setupBackground(int r7) {
        a(this, r7, 0, null, 6, null);
    }
}
