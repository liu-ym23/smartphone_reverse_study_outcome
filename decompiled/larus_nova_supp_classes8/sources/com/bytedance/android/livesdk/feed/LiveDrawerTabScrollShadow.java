package com.bytedance.android.livesdk.feed;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class LiveDrawerTabScrollShadow extends View {
    public final Paint a;
    public int b;
    public final int c;
    public boolean d;
    public boolean e;

    public LiveDrawerTabScrollShadow(Context r2) {
        this(r2, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r13) {
        super.onDraw(r13);
        int r0 = this.c;
        if (this.d == false) goto L5;
        int r1 = this.b;
    L7:
        if (this.e == false) goto L9;
        int r2 = this.b;
    L10:
        int[] r9 = {r1, r0, r0, r2};
        RectF r3 = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        this.a.setShader(new LinearGradient(0.0f, 0.0f, r3.width(), 0.0f, r9, new float[]{0.0f, 0.09f, 0.91f, 1.0f}, Shader.TileMode.REPEAT));
        r13.drawRect(r3, this.a);
        return;
    L9:
        r2 = r0;
        goto L10
    L5:
        r1 = r0;
        goto L7
    }

    public void setShadowEdgeColorRes(int r1) {
        this.b = s1.h(r1);
        invalidate();
    }

    public LiveDrawerTabScrollShadow(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public LiveDrawerTabScrollShadow(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.b = s1.h(2131100641);
        this.c = s1.h(2131106784);
        this.d = false;
        this.e = false;
        Paint r4 = new Paint();
        this.a = r4;
        r4.setAntiAlias(true);
        r4.setStyle(Paint.Style.FILL);
    }
}
