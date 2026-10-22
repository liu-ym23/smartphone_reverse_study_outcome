package com.suite.lark.platform.component.widget_biz_setting.settingitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class SettingDividerView extends View {
    public int a;
    public int b;
    public float c;
    public float d;
    public Paint e;
    public Paint f;

    public SettingDividerView(Context r1) {
        super(r1);
        a(null);
    }

    public final void a(AttributeSet r6) {
        if (r6 != null) goto L5;
        this.a = getResources().getColor(2131100548);
        this.b = getResources().getColor(2131103353);
        this.c = 0.0f;
        this.d = 0.0f;
    L6:
        Paint r7 = new Paint();
        this.e = r7;
        r7.setColor(this.a);
        this.e.setStyle(Paint.Style.FILL_AND_STROKE);
        Paint r8 = new Paint();
        this.f = r8;
        r8.setColor(this.b);
        this.f.setStyle(Paint.Style.FILL_AND_STROKE);
        return;
    L5:
        TypedArray r9 = getContext().obtainStyledAttributes(r6, new int[]{2130969024, 2130972515, 2130973796, 2130974114});
        this.a = r9.getColor(0, getResources().getColor(2131100548));
        this.b = r9.getColor(3, getResources().getColor(2131103353));
        this.c = r9.getDimension(1, 0.0f);
        this.d = r9.getDimension(2, 0.0f);
        r9.recycle();
        goto L6
    }

    @Override // android.view.View
    public final void draw(Canvas r15) {
        float r3 = this.c;
        if (r3 <= 0.0f) goto L6;
        r15.drawRect(0.0f, 0.0f, r3, getHeight(), this.e);
    L6:
        if (this.d <= 0.0f) goto L8;
        r15.drawRect(getWidth() - this.d, 0.0f, getWidth(), getHeight(), this.e);
    L8:
        r15.drawRect(this.c, 0.0f, getWidth() - this.d, getHeight(), this.f);
    }

    public void setBlankColor(int r2) {
        this.a = r2;
        this.e.setColor(r2);
        invalidate();
    }

    public void setLeftBlankWidth(float r1) {
        this.c = r1;
        invalidate();
    }

    public void setRightBlankWidth(float r1) {
        this.d = r1;
        invalidate();
    }

    public void setSolidColor(int r2) {
        this.b = r2;
        this.f.setColor(r2);
        invalidate();
    }

    public SettingDividerView(Context r1, AttributeSet r2) {
        super(r1, r2);
        a(r2);
    }

    public SettingDividerView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        a(r2);
    }
}
