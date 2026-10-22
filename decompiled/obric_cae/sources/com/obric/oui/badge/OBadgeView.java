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
import he.i;
import nb.a;

/* JADX INFO: loaded from: classes2.dex */
public final class OBadgeView extends OTextView {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static int f6182t = 99;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f6183s;

    public OBadgeView(Context r8, AttributeSet r10) {
        i.f(r8, "context");
        super(r8, r10, 0, 8);
        TypedArray r11 = getContext().obtainStyledAttributes(r10, a.f9488b);
        i.e(r11, "context.obtainStyledAttr…, R.styleable.OBadgeView)");
        this.f6183s = r11.getColor(0, 0);
        r11.recycle();
        setLines(1);
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"DrawAllocation"})
    public final void onDraw(Canvas r8) {
        super.onDraw(r8);
        if (this.f6183s == 0) goto L13;
        float r10 = getWidth() / 2.0f;
        float r11 = getHeight() / 2.0f;
        Resources r12 = Resources.getSystem();
        i.e(r12, "Resources.getSystem()");
        float r13 = TypedValue.applyDimension(1, (float) 1.5d, r12.getDisplayMetrics());
        Paint r14 = new Paint();
        r14.setColor(this.f6183s);
        r14.setAntiAlias(true);
        if (r8 == null) goto L8;
        r8.drawCircle(r10, r11, r13, r14);
    L8:
        if (r8 == null) goto L10;
        r8.drawCircle(r10 - android.aimedia.a.a("Resources.getSystem()", 1, 6), r11, r13, r14);
    L10:
        if (r8 == null) goto L14;
        r8.drawCircle(r10 + android.aimedia.a.a("Resources.getSystem()", 1, 6), r11, r13, r14);
        return;
    L14:
        return;
    }

    @Override // com.obric.oui.text.OTextView, android.widget.TextView, android.view.View
    public final void onLayout(boolean r8, int r10, int r11, int r12, int r13) {
        super.onLayout(r8, r10, r11, r12, r13);
    }

    @Override // com.obric.oui.text.OTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int r8, int r10) {
        super.onMeasure(r8, r10);
    }

    public final void setMaxNumberInCount(int r8) {
        f6182t = r8;
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence r8, TextView.BufferType r10) {
        i.f(r8, "inText");
        if (TextUtils.isEmpty(r8) == false) goto L16;
    L13:
        super.setText(r8, r10);
        return;
    L16:
        Integer r11 = Integer.valueOf(r8.toString());     // Catch: Exception -> L11
        if (r11.intValue() <= f6182t) goto L8;
        StringBuilder r12 = new StringBuilder();     // Catch: Exception -> L11
        r12.append(f6182t);     // Catch: Exception -> L11
        r12.append('+');     // Catch: Exception -> L11
        r8 = r12.toString();     // Catch: Exception -> L11
    L15:
    L8:
        if (r11.intValue() >= 0) goto L15;
        r8 = "";
    L12:
        throw new IllegalArgumentException("Excepted a int but get " + getText());
    }
}
