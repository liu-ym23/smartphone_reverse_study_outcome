package com.obric.oui.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.obric.oui.constraintlayout.widget.R$styleable;

/* JADX INFO: loaded from: classes3.dex */
public class MockView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f12942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f12943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f12944c;
    public boolean d;
    public boolean e;
    public String f;
    public final Rect g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f12945h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f12946i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f12947j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f12948k;

    public MockView(Context r5) {
        super(r5);
        this.f12942a = new Paint();
        this.f12943b = new Paint();
        this.f12944c = new Paint();
        this.d = true;
        this.e = true;
        this.f = null;
        this.g = new Rect();
        this.f12945h = Color.argb(255, 0, 0, 0);
        this.f12946i = Color.argb(255, 200, 200, 200);
        this.f12947j = Color.argb(255, 50, 50, 50);
        this.f12948k = 4;
        a(r5, null);
    }

    public final void a(Context r5, AttributeSet r10) {
        if (r10 == null) goto L26;
        TypedArray r11 = r5.obtainStyledAttributes(r10, R$styleable.MockView);
        int r12 = r11.getIndexCount();
        int r13 = 0;
    L4:
        if (r13 >= r12) goto L24;
        int r14 = r11.getIndex(r13);
        if (r14 != R$styleable.MockView_mock_label) goto L9;
        this.f = r11.getString(r14);
    L23:
        r13 = r13 + 1;
        goto L4
    L9:
        if (r14 != R$styleable.MockView_mock_showDiagonals) goto L12;
        this.d = r11.getBoolean(r14, this.d);
        goto L23
    L12:
        if (r14 != R$styleable.MockView_mock_diagonalsColor) goto L15;
        this.f12945h = r11.getColor(r14, this.f12945h);
        goto L23
    L15:
        if (r14 != R$styleable.MockView_mock_labelBackgroundColor) goto L18;
        this.f12947j = r11.getColor(r14, this.f12947j);
        goto L23
    L18:
        if (r14 != R$styleable.MockView_mock_labelColor) goto L21;
        this.f12946i = r11.getColor(r14, this.f12946i);
        goto L23
    L21:
        if (r14 != R$styleable.MockView_mock_showLabel) goto L23;
        this.e = r11.getBoolean(r14, this.e);
        goto L23
    L24:
        r11.recycle();
    L26:
        if (this.f == null) goto L31;
    L28:
        int r15 = this.f12945h;
        Paint r16 = this.f12942a;
        r16.setColor(r15);
        r16.setAntiAlias(true);
        int r17 = this.f12946i;
        Paint r18 = this.f12943b;
        r18.setColor(r17);
        r18.setAntiAlias(true);
        this.f12944c.setColor(this.f12947j);
        this.f12948k = Math.round((getResources().getDisplayMetrics().xdpi / 160.0f) * this.f12948k);
        return;
    L31:
        this.f = r5.getResources().getResourceEntryName(getId());     // Catch: Exception -> L30
        goto L28
    }

    @Override // android.view.View
    public void onDraw(Canvas r11) {
        super.onDraw(r11);
        int r5 = getWidth();
        int r10 = getHeight();
        if (this.d == false) goto L5;
        r5 = r5 - 1;
        r10 = r10 - 1;
        float r12 = r5;
        float r13 = r10;
        r11.drawLine(0.0f, 0.0f, r12, r13, this.f12942a);
        r11.drawLine(0.0f, r13, r12, 0.0f, this.f12942a);
        r11.drawLine(0.0f, 0.0f, r12, 0.0f, this.f12942a);
        r11.drawLine(r12, 0.0f, r12, r13, this.f12942a);
        r11.drawLine(r12, r13, 0.0f, r13, this.f12942a);
        r11.drawLine(0.0f, r13, 0.0f, 0.0f, this.f12942a);
    L5:
        String r14 = this.f;
        if (r14 != null) goto L8;
        return;
    L8:
        if (this.e == false) goto L12;
        int r15 = r14.length();
        Paint r16 = this.f12943b;
        Rect r17 = this.g;
        r16.getTextBounds(r14, 0, r15, r17);
        float r18 = (r5 - r17.width()) / 2.0f;
        float r19 = ((r10 - r17.height()) / 2.0f) + r17.height();
        r17.offset((int) r18, (int) r19);
        int r20 = r17.left;
        int r21 = this.f12948k;
        r17.set(r20 - r21, r17.top - r21, r17.right + r21, r17.bottom + r21);
        r11.drawRect(r17, this.f12944c);
        r11.drawText(this.f, r18, r19, r16);
        return;
    }

    public MockView(Context r5, AttributeSet r10) {
        super(r5, r10);
        this.f12942a = new Paint();
        this.f12943b = new Paint();
        this.f12944c = new Paint();
        this.d = true;
        this.e = true;
        this.f = null;
        this.g = new Rect();
        this.f12945h = Color.argb(255, 0, 0, 0);
        this.f12946i = Color.argb(255, 200, 200, 200);
        this.f12947j = Color.argb(255, 50, 50, 50);
        this.f12948k = 4;
        a(r5, r10);
    }

    public MockView(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.f12942a = new Paint();
        this.f12943b = new Paint();
        this.f12944c = new Paint();
        this.d = true;
        this.e = true;
        this.f = null;
        this.g = new Rect();
        this.f12945h = Color.argb(255, 0, 0, 0);
        this.f12946i = Color.argb(255, 200, 200, 200);
        this.f12947j = Color.argb(255, 50, 50, 50);
        this.f12948k = 4;
        a(r5, r10);
    }
}
