package com.obric.oui.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public class MockView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f13729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Paint f13730b;
    private Paint c;
    private Paint d;
    private boolean e;
    private boolean f;
    private Rect g;
    private int h;
    private int i;
    private int j;
    private int k;

    public MockView(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        super(r5);
        this.f13730b = new Paint();
        this.c = new Paint();
        this.d = new Paint();
        this.e = true;
        this.f = true;
        this.f13729a = null;
        this.g = new Rect();
        this.h = Color.argb(255, 0, 0, 0);
        this.i = Color.argb(255, 200, 200, 200);
        this.j = Color.argb(255, 50, 50, 50);
        this.k = 4;
        a(r5, null);
    }

    public MockView(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r5, r6);
        this.f13730b = new Paint();
        this.c = new Paint();
        this.d = new Paint();
        this.e = true;
        this.f = true;
        this.f13729a = null;
        this.g = new Rect();
        this.h = Color.argb(255, 0, 0, 0);
        this.i = Color.argb(255, 200, 200, 200);
        this.j = Color.argb(255, 50, 50, 50);
        this.k = 4;
        a(r5, r6);
    }

    public MockView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r6, r7, r5);
        this.f13730b = new Paint();
        this.c = new Paint();
        this.d = new Paint();
        this.e = true;
        this.f = true;
        this.f13729a = null;
        this.g = new Rect();
        this.h = Color.argb(255, 0, 0, 0);
        this.i = Color.argb(255, 200, 200, 200);
        this.j = Color.argb(255, 50, 50, 50);
        this.k = 4;
        a(r6, r7);
    }

    private void a(Context r8, AttributeSet r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r9, AttributeSet.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L27;
        TypedArray r12 = r10.obtainStyledAttributes(r11, R.styleable.MockView);
        int r0 = r12.getIndexCount();
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L25;
        int r3 = r12.getIndex(r2);
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.MockView_mock_label, "styleable", "MockView_mock_label")) goto L10;
        this.f13729a = r12.getString(r3);
    L24:
        r2 = r2 + 1;
        goto L5
    L10:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.MockView_mock_showDiagonals, "styleable", "MockView_mock_showDiagonals")) goto L13;
        this.e = r12.getBoolean(r3, this.e);
        goto L24
    L13:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.MockView_mock_diagonalsColor, "styleable", "MockView_mock_diagonalsColor")) goto L16;
        this.h = r12.getColor(r3, this.h);
        goto L24
    L16:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.MockView_mock_labelBackgroundColor, "styleable", "MockView_mock_labelBackgroundColor")) goto L19;
        this.j = r12.getColor(r3, this.j);
        goto L24
    L19:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.MockView_mock_labelColor, "styleable", "MockView_mock_labelColor")) goto L22;
        this.i = r12.getColor(r3, this.i);
        goto L24
    L22:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.MockView_mock_showLabel, "styleable", "MockView_mock_showLabel")) goto L24;
        this.f = r12.getBoolean(r3, this.f);
        goto L24
    L25:
        r12.recycle();
    L27:
        if (this.f13729a == null) goto L32;
    L29:
        this.f13730b.setColor(this.h);
        this.f13730b.setAntiAlias(true);
        this.c.setColor(this.i);
        this.c.setAntiAlias(true);
        this.d.setColor(this.j);
        this.k = Math.round(this.k * (ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics().xdpi / 160.0f));
        return;
    L32:
        this.f13729a = ZeusTransformUtils.getResources(r10, "com.obric.memorydata.plugin").getResourceEntryName(getId());     // Catch: Exception -> L31
        goto L29
    }

    @Override // android.view.View
    public void onDraw(Canvas r14) {
        super.onDraw(r14);
        int r0 = getWidth();
        int r1 = getHeight();
        if (this.e == false) goto L5;
        r0 = r0 - 1;
        r1 = r1 - 1;
        float r11 = r0;
        float r12 = r1;
        r14.drawLine(0.0f, 0.0f, r11, r12, this.f13730b);
        r14.drawLine(0.0f, r12, r11, 0.0f, this.f13730b);
        r14.drawLine(0.0f, 0.0f, r11, 0.0f, this.f13730b);
        r14.drawLine(r11, 0.0f, r11, r12, this.f13730b);
        r14.drawLine(r11, r12, 0.0f, r12, this.f13730b);
        r14.drawLine(0.0f, r12, 0.0f, 0.0f, this.f13730b);
    L5:
        String r2 = this.f13729a;
        if (r2 != null) goto L8;
        return;
    L8:
        if (this.f == false) goto L12;
        this.c.getTextBounds(r2, 0, r2.length(), this.g);
        float r3 = (r0 - this.g.width()) / 2.0f;
        float r4 = ((r1 - this.g.height()) / 2.0f) + this.g.height();
        this.g.offset((int) r3, (int) r4);
        Rect r5 = this.g;
        r5.set(r5.left - this.k, this.g.top - this.k, this.g.right + this.k, this.g.bottom + this.k);
        r14.drawRect(this.g, this.d);
        r14.drawText(this.f13729a, r3, r4, this.c);
        return;
    }
}
