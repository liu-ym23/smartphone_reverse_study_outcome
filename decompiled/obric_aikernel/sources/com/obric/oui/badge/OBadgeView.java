package com.obric.oui.badge;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\rB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/badge/OBadgeView;", "Lcom/obric/oui/text/OTextView;", "", "maxNumber", "", "setMaxNumberInCount", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OBadgeView extends OTextView {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static int f6223o;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f6224n;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
        f6223o = 99;
    }

    @JvmOverloads
    public OBadgeView(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public OBadgeView(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public OBadgeView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12, null, 8, null);
        b(r11);
    }

    public /* synthetic */ OBadgeView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    private final void b(AttributeSet r10) {
        c(r10);
        setLines(1);
    }

    private final void c(AttributeSet r10) {
        TypedArray r11 = getContext().obtainStyledAttributes(r10, l.OBadgeView);
        Intrinsics.checkNotNullExpressionValue(r11, "context.obtainStyledAttr…, R.styleable.OBadgeView)");
        this.f6224n = r11.getColor(l.OBadgeView_oui_badgeview_ellipsis_color, 0);
        r11.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas r10) {
        super.onDraw(r10);
        if (this.f6224n == 0) goto L13;
        float r11 = getWidth() / 2.0f;
        float r12 = getHeight() / 2.0f;
        Resources r13 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r13, "Resources.getSystem()");
        float r14 = TypedValue.applyDimension(1, (float) 1.5d, r13.getDisplayMetrics());
        Paint r15 = new Paint();
        r15.setColor(this.f6224n);
        r15.setAntiAlias(true);
        if (r10 == null) goto L8;
        r10.drawCircle(r11, r12, r14, r15);
    L8:
        if (r10 == null) goto L10;
        Resources r16 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r16, "Resources.getSystem()");
        r10.drawCircle(r11 - MathKt.roundToInt(TypedValue.applyDimension(1, 6, r16.getDisplayMetrics())), r12, r14, r15);
    L10:
        if (r10 == null) goto L14;
        Resources r17 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r17, "Resources.getSystem()");
        r10.drawCircle(r11 + MathKt.roundToInt(TypedValue.applyDimension(1, 6, r17.getDisplayMetrics())), r12, r14, r15);
        return;
    L14:
        return;
    }

    @Override // com.obric.oui.text.OTextView, android.widget.TextView, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // com.obric.oui.text.OTextView, android.widget.TextView, android.view.View
    protected void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
    }

    public final void setMaxNumberInCount(int r10) {
        f6223o = r10;
    }

    @Override // android.widget.TextView
    public void setText(CharSequence r10, TextView.BufferType r11) {
        Intrinsics.checkNotNullParameter(r10, "inText");
        if (TextUtils.isEmpty(r10) == false) goto L16;
    L13:
        super.setText(r10, r11);
        return;
    L16:
        Integer r12 = Integer.valueOf(r10.toString());     // Catch: Exception -> L11
        if (r12.intValue() <= f6223o) goto L8;
        StringBuilder r13 = new StringBuilder();     // Catch: Exception -> L11
        r13.append(f6223o);     // Catch: Exception -> L11
        r13.append('+');     // Catch: Exception -> L11
        r10 = r13.toString();     // Catch: Exception -> L11
    L15:
    L8:
        if (r12.intValue() >= 0) goto L15;
        r10 = "";
    L12:
        throw new IllegalArgumentException("Excepted a int but get " + getText());
    }
}
