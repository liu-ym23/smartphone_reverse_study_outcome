package com.lynx.smartrefresh.layout.header;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.lynx.smartrefresh.layout.SmartRefreshLayout;
import com.lynx.smartrefresh.layout.constant.RefreshState;
import m6a.f;
import m6a.h;
import m6a.i;
import p6a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class FalsifyHeader extends b implements f {
    public h d;

    public FalsifyHeader(Context r2) {
        this(r2, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r13) {
        super.dispatchDraw(r13);
        if (isInEditMode() == false) goto L6;
        int r0 = r6a.b.c(5.0f);
        Context r1 = getContext();
        Paint r7 = new Paint();
        r7.setStyle(Paint.Style.STROKE);
        r7.setColor(-858993460);
        r7.setStrokeWidth(r6a.b.c(1.0f));
        float r5 = r0;
        r7.setPathEffect(new DashPathEffect(new float[]{r5, r5, r5, r5}, 1.0f));
        r13.drawRect(r5, r5, getWidth() - r0, getBottom() - r0, r7);
        TextView r2 = new TextView(r1);
        r2.setText(r1.getString(2131914113, new Object[]{getClass().getSimpleName(), Float.valueOf(getHeight() / r6a.b.b)}));
        r2.setTextColor(-858993460);
        r2.setGravity(17);
        r2.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
        r2.layout(0, 0, getWidth(), getHeight());
        r2.draw(r13);
        return;
    }

    public FalsifyHeader(Context r2, AttributeSet r3) {
        super(r2, r3, 0);
    }

    @Override // p6a.b, m6a.g
    public final void j(SmartRefreshLayout.i r1, int r2, int r3) {
        this.d = r1;
    }

    @Override // p6a.b, m6a.g
    public final void k(i r1, int r2, int r3) {
        h r4 = this.d;
        if (r4 == null) goto L6;
        SmartRefreshLayout.i r5 = (SmartRefreshLayout.i) r4;
        r5.d(RefreshState.None);
        h r6 = this.d;
        SmartRefreshLayout.i r7 = (SmartRefreshLayout.i) r6;
        r7.d(RefreshState.RefreshFinish);
        return;
    }
}
