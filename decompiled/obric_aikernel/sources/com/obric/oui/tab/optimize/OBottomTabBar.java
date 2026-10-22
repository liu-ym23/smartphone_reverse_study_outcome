package com.obric.oui.tab.optimize;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.LinearLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import u8.c;
import u8.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0017\u0018B'\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\t¢\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R$\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/obric/oui/tab/optimize/OBottomTabBar;", "Landroid/widget/LinearLayout;", "Lcom/obric/oui/tab/optimize/OBottomTabBar$b;", "listener", "", "setOnTabSelectedListener", "", "show", "setShowTopLine", "", "<set-?>", "c", "I", "getSelectedIndex", "()I", "selectedIndex", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OBottomTabBar extends LinearLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f7607c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f7608g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Paint f7609h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f7610i;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    public interface b {
    }

    static {
        new a(null);
        new n9.a();
    }

    @JvmOverloads
    public OBottomTabBar(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public OBottomTabBar(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public OBottomTabBar(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.f7607c = -1;
        Paint r13 = new Paint();
        r13.setStyle(Paint.Style.FILL);
        r13.setColor(getResources().getColor(c.oui_line_2));
        Unit r14 = Unit.INSTANCE;
        this.f7609h = r13;
        setOrientation(0);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        Resources r15 = getResources();
        int r16 = d.oui_p_container_2;
        int r17 = (int) r15.getDimension(r16);
        Resources r18 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r18, "Resources.getSystem()");
        int r19 = MathKt.roundToInt(TypedValue.applyDimension(1, (float) 4.5d, r18.getDisplayMetrics()));
        int r20 = (int) getResources().getDimension(r16);
        Resources r21 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r21, "Resources.getSystem()");
        setPadding(r17, r19, r20, MathKt.roundToInt(TypedValue.applyDimension(1, 2, r21.getDisplayMetrics())));
        Resources r22 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r22, "Resources.getSystem()");
        float r23 = MathKt.roundToInt(TypedValue.applyDimension(1, 0.6f, r22.getDisplayMetrics()));
        this.f7608g = r23;
        r13.setStrokeWidth(r23);
        setWillNotDraw(false);
        this.f7610i = true;
    }

    public /* synthetic */ OBottomTabBar(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    public final int getSelectedIndex() {
        return this.f7607c;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas r10) {
        super.onDraw(r10);
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.f7610i == false) goto L10;
        r10.save();
        r10.drawLine(0.0f, this.f7608g / 2.0f, getWidth(), this.f7608g, this.f7609h);
        r10.restore();
        return;
    }

    public final void setOnTabSelectedListener(b r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
    }

    public final void setShowTopLine(boolean r10) {
        this.f7610i = r10;
        invalidate();
    }
}
