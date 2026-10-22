package com.ss.android.lark.chatwindow.view.readstate;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.larksuite.framework.utils.UIUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ReadStateView extends View {
    public int a;
    public float b;
    public float c;
    public final Paint d;
    public final Paint e;
    public final Paint f;
    public Drawable g;
    public int h;
    public int i;
    public int j;
    public float k;
    public final int l;

    public void setAllUnreadIcon(Drawable r1) {
    }

    public float getProgress() {
        return this.k;
    }

    public ReadStateView(Context r2) {
        this(r2, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r15) {
        super.onDraw(r15);
        int r0 = getMeasuredWidth() / 2;
        int r1 = getMeasuredHeight() - r0;
        float r2 = this.k;
        if (r2 != 1.0f) goto L7;
        int r3 = (int) (this.b + this.c);
        this.g.setBounds(r0 - r3, r1 - r3, r0 + r3, r1 + r3);
        this.g.draw(r15);
        return;
    L7:
        if (r2 != 0.0f) goto L9;
        Paint r4 = this.d;
    L10:
        r4.setStyle(Paint.Style.STROKE);
        r4.setStrokeWidth(this.c);
        r15.drawCircle(r0, r1, this.b, r4);
        return;
    L9:
        r4 = this.e;
        r4.setStyle(Paint.Style.FILL);
        this.e.setStrokeWidth(0.0f);
        int r5 = this.a;
        r15.drawArc(r0 - r5, r1 - r5, r0 + r5, r5 + r1, this.l, Math.min(Math.max(45.0f, this.k * 360.0f), 315.0f), true, this.e);
        goto L10
    }

    public void setAllReadColor(int r2) {
        this.j = r2;
        this.f.setColor(r2);
    }

    public void setAllReadIcon(Drawable r1) {
        this.g = r1;
    }

    public void setAllUnreadColor(int r2) {
        this.h = r2;
        this.d.setColor(r2);
    }

    public void setDefaultOrNightMode(Context r2) {
        ContextCompat.getDrawable(r2, 2131237594);
        this.h = ContextCompat.getColor(r2, 2131102455);
        this.g = ContextCompat.getDrawable(r2, 2131237593);
        this.j = ContextCompat.getColor(r2, 2131102453);
        this.d.setColor(this.h);
        this.f.setColor(this.j);
    }

    public void setProgress(float r2) {
        this.k = Math.max(Math.min(r2, 1.0f), 0.0f);
        invalidate();
    }

    public ReadStateView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public ReadStateView(Context r6, AttributeSet r7, int r8) {
        super(r6, r7, r8);
        this.a = UIUtils.dp2px(getContext(), 5.0f);
        UIUtils.dp2px(getContext(), 5.0f);
        this.b = UIUtils.dp2px(getContext(), 7.825f);
        this.c = UIUtils.dp2px(getContext(), 1.85f);
        Paint r9 = new Paint(1);
        this.d = r9;
        Paint r1 = new Paint(1);
        this.e = r1;
        Paint r2 = new Paint(1);
        this.f = r2;
        this.g = UIUtils.getDrawable(getContext(), 2131237593);
        this.h = -4012596;
        this.i = -15091320;
        this.j = -15091320;
        this.k = 0.0f;
        this.l = -90;
        if (r7 == null) goto L5;
        TypedArray r10 = r6.obtainStyledAttributes(r7, new int[]{2130968777, 2130968778, 2130968779, 2130968780, 2130973457, 2130973458});
        r10.getDrawable(3);
        r10.getDrawable(5);
        this.g = r10.getDrawable(1);
        this.h = r10.getColor(2, this.h);
        this.i = r10.getColor(4, this.i);
        this.j = r10.getColor(0, this.j);
        r10.recycle();
    L6:
        r9.setColor(this.h);
        r1.setColor(this.i);
        r2.setColor(this.j);
        setTag(2131388363, UIUtils.getString(r6, 2131914275));
        return;
    L5:
        setDefaultOrNightMode(r6);
        goto L6
    }
}
