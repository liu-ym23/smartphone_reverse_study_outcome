package com.obric.oui.button;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000fB1\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0006\u001a\u00020\u0002¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/button/OButtonGroup;", "Lcom/obric/oui/button/OShadowFrame;", "", "minWidth", "", "setWidthMin", "getItemCount", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "a", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OButtonGroup extends OShadowFrame {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private ViewGroup f6263w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f6264x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private View f6265y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f6266z;

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
    public OButtonGroup(Context r10) {
        this(r10, null, 0, 0, 14, null);
    }

    @JvmOverloads
    public OButtonGroup(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 0, 12, null);
    }

    @JvmOverloads
    public OButtonGroup(Context r10, AttributeSet r11, int r12) {
        this(r10, r11, r12, 0, 8, null);
    }

    @JvmOverloads
    public OButtonGroup(Context r10, AttributeSet r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12, 0, 8, null);
        float r14 = 0;
        Resources r15 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r15, "Resources.getSystem()");
        MathKt.roundToInt(TypedValue.applyDimension(1, r14, r15.getDisplayMetrics()));
        Resources r16 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r16, "Resources.getSystem()");
        this.f6264x = MathKt.roundToInt(TypedValue.applyDimension(1, r14, r16.getDisplayMetrics()));
        TypedArray r17 = r10.obtainStyledAttributes(r11, l.OButtonGroup);
        Intrinsics.checkNotNullExpressionValue(r17, "context.obtainStyledAttr…R.styleable.OButtonGroup)");
        this.f6264x = r17.getDimensionPixelSize(l.OButtonGroup_oui_widgetMinWidth, 0);
        r17.getDimensionPixelSize(l.OButtonGroup_oui_widgetInnerItemMargin, 0);
        r17.getDimensionPixelSize(l.OButtonGroup_oui_OButtonGroupCapacity, 5);
        r17.recycle();
    }

    public /* synthetic */ OButtonGroup(Context r10, AttributeSet r11, int r12, int r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = 0;
    L9:
        if ((r14 & 8) == 0) goto L11;
        r13 = 0;
    L11:
        this(r10, r11, r12, r13);
    }

    private final void o(View r10) {
        boolean r11 = r10 instanceof o9.a;
        Object r12 = r10;
        if (r11 == true) goto L5;
        r12 = null;
    L5:
        o9.a r13 = (o9.a) r12;
        if (r13 == null) goto L9;
        r13.setChangeAlphaWhenPress(false);
        this.f6266z = true;
        return;
    }

    private final void p() {
        if (getItemCount() != 0) goto L5;
        int r10 = 8;
    L6:
        setVisibility(r10);
        return;
    L5:
        r10 = 0;
        goto L6
    }

    private final void r() {
        KeyEvent.Callback r10 = this.f6265y;
        if (r10 != null) goto L5;
    L12:
        this.f6265y = null;
        this.f6266z = false;
        return;
    L5:
        if (this.f6266z == false) goto L12;
        if ((r10 instanceof o9.a) == true) goto L9;
        r10 = null;
    L9:
        o9.a r11 = (o9.a) r10;
        if (r11 == null) goto L12;
        r11.setChangeAlphaWhenPress(true);
        goto L12
    }

    private final void s() {
        ViewGroup r10 = this.f6263w;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.getChildCount() != 1) goto L10;
        View r11 = r10.getChildAt(0);
        if (this.f6265y == r11) goto L9;
        r();
        this.f6265y = r11;
    L9:
        Intrinsics.checkNotNullExpressionValue(r11, "only");
        o(r11);
        return;
    L10:
        r();
    }

    @Override // com.obric.oui.button.OShadowFrame, com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_EVENT);
        boolean r11 = false;
        if (getItemCount() != 1) goto L5;
        boolean r12 = true;
    L6:
        boolean r13 = super.dispatchTouchEvent(r10);
        if (r12 == false) goto L27;
        int r14 = r10.getActionMasked();
        if (r14 == 0) goto L26;
        if (r14 != 1) goto L12;
    L25:
        getContentView().setPressed(r11);
        goto L27
    L12:
        if (r14 != 2) goto L14;
        float r15 = 0;
        if (r10.getX() < r15) goto L25;
        if (r10.getX() >= getWidth()) goto L25;
        if (r10.getY() < r15) goto L25;
        if (r10.getY() >= getHeight()) goto L25;
        r11 = true;
        goto L25
    L14:
        if (r14 == 3) goto L25;
    L26:
        getContentView().setPressed(true);
    L27:
        return r13;
    L5:
        r12 = false;
        goto L6
    }

    public final int getItemCount() {
        ViewGroup r10 = this.f6263w;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.getChildCount();
    }

    @Override // com.obric.oui.button.OShadowFrame
    public void j(Context r10, FrameLayout r11, AttributeSet r12, TypedArray r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "contentView");
        r11.removeAllViews();
        setChangeAlphaWhenPress(false);
        getContentView().setDuplicateParentStateEnabled(false);
        LinearLayout r14 = new LinearLayout(r10);
        r14.setOrientation(0);
        r14.setGravity(17);
        Unit r15 = Unit.INSTANCE;
        this.f6263w = r14;
        r11.addView(r14);
        setWidthMin(this.f6264x);
        getContentView().setWidthMin(this.f6264x);
        s();
        p();
    }

    public final View q(int r10) {
        ViewGroup r11 = this.f6263w;
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.getChildAt(r10);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, o9.b
    public void setWidthMin(int r10) {
        getLayoutHelper().setWidthMin(r10);
    }
}
