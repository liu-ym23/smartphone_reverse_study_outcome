package com.larksuite.component.ui.imageview;

import android.graphics.Paint;
import android.text.TextPaint;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public final TextPaint a;
    public CharSequence b;
    public float c;
    public float d;

    public final float a() {
        float r0 = this.c;
        float r1 = 0.0f;
        if (r0 < 0.0f) goto L5;
        return r0;
    L5:
        CharSequence r2 = this.b;
        if (r2 != null) goto L8;
    L11:
        boolean r3 = true;
    L12:
        if (r3 == true) goto L15;
        r1 = this.a.measureText(r2, 0, r2.length());
    L15:
        this.c = r1;
        return r1;
    L8:
        if (r2.length() == 0) goto L11;
        r3 = false;
        goto L12
    }

    public b() {
        TextPaint r0 = new TextPaint(1);
        this.a = r0;
        this.c = -1.0f;
        this.d = -1.0f;
        r0.setTextAlign(Paint.Align.CENTER);
    }
}
