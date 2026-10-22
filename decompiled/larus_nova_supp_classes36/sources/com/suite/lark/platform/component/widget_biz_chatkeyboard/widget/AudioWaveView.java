package com.suite.lark.platform.component.widget_biz_chatkeyboard.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class AudioWaveView extends View {
    public final Paint a;
    public final Paint b;
    public final int c;
    public final int d;
    public final float e;
    public final float f;
    public final float g;
    public final float h;
    public final float i;
    public int j;
    public int k;
    public byte[] l;
    public int m;
    public final int n;

    public int getProgress() {
        return this.m;
    }

    public byte[] getWaveformBytes() {
        return this.l;
    }

    public AudioWaveView(Context r3) {
        super(r3);
        this.a = new Paint(1);
        this.b = new Paint(1);
        this.c = Color.rgb(255, 255, 255);
        this.d = Color.argb(51, 255, 255, 255);
        this.e = UIHelper.dp2px(2.0f);
        float r0 = UIHelper.dp2px(5.0f);
        this.f = r0;
        this.g = (UIHelper.dp2px(22.0f) - r0) / 2.0f;
        this.h = UIHelper.dp2px(2.0f);
        this.i = UIHelper.dp2px(4.0f);
        this.n = 100;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r28) {
        byte[] r1 = this.l;
        if (r1 == null) goto L35;
        int r2 = this.j;
        if (r2 == 0) goto L44;
        float r3 = r2 / (this.e + this.i);
        if (r3 > 0.1f) goto L10;
        return;
    L10:
        int r4 = 5;
        int r5 = (r1.length * 8) / 5;
        float r6 = r5 / r3;
        this.a.setColor(this.d);
        this.b.setColor(this.c);
        int r7 = 2;
        int r8 = this.k / 2;
        float r9 = 0.0f;
        int r10 = 0;
        int r11 = 0;
        int r12 = 0;
    L11:
        if (r10 >= r5) goto L45;
        if (r10 == r11) goto L14;
        int r26 = r5;
    L34:
        r10 = r10 + 1;
        r5 = r26;
        r4 = 5;
        r7 = 2;
        goto L11
    L14:
        int r13 = r11;
        int r14 = 0;
    L15:
        if (r11 != r13) goto L17;
        r9 = r9 + r6;
        r13 = (int) r9;
        r14 = r14 + 1;
        goto L15
    L17:
        int r15 = r10 * 5;
        int r16 = r15 / 8;
        int r17 = r15 - (r16 * 8);
        int r18 = 8 - r17;
        int r19 = 5 - r18;
        byte r20 = (byte) ((this.l[r16] >> r17) & ((r7 << (Math.min(r4, r18) - 1)) - 1));
        if (r19 <= 0) goto L22;
        int r110 = r16 + 1;
        byte[] r21 = this.l;
        if (r110 >= r21.length) goto L22;
        r20 = (byte) (((byte) (r20 << r19)) | (r21[r110] & ((r7 << (r19 - 1)) - 1)));
    L22:
        float r22 = this.j * ((this.m * 1.0f) / this.n);
        int r111 = 0;
    L23:
        if (r111 >= r14) goto L33;
        float r112 = this.e;
        float r23 = (int) (r12 * (this.i + r112));
        if (r23 <= r22) goto L27;
    L29:
        int r27 = r5;
        float r24 = r8;
        float r113 = r20;
        float r114 = r24 - Math.max(this.f / 2.0f, (this.g * r113) / 31.0f);
        float r115 = r23 + this.e;
        float r25 = r24 + Math.max(this.f / 2.0f, (this.g * r113) / 31.0f);
        float r29 = this.h;
        r28.drawRoundRect(r23, r114, r115, r25, r29, r29, this.a);
        if (r23 > r22) goto L32;
        float r116 = r24 - Math.max(this.f / 2.0f, (this.g * r113) / 31.0f);
        float r210 = r24 + Math.max(this.f / 2.0f, (this.g * r113) / 31.0f);
        float r30 = this.h;
        r28.drawRoundRect(r23, r116, r22, r210, r30, r30, this.b);
    L32:
        r12 = r12 + 1;
        r111 = r111 + 1;
        r5 = r27;
        goto L23
    L27:
        if ((r112 + r23) > r22) goto L29;
        float r117 = r8;
        r27 = r5;
        float r31 = r20;
        float r118 = r117 - Math.max(this.f / 2.0f, (this.g * r31) / 31.0f);
        float r119 = r23 + this.e;
        float r211 = r117 + Math.max(this.f / 2.0f, (this.g * r31) / 31.0f);
        float r32 = this.h;
        r28.drawRoundRect(r23, r118, r119, r211, r32, r32, this.b);
        goto L32
    L33:
        r26 = r5;
        r11 = r13;
        goto L34
    L45:
        return;
    L44:
        return;
    }

    public void setProgress(int r1) {
        this.m = r1;
        invalidate();
    }

    public void setWaveformBytes(byte[] r2) {
        if (r2 != null) goto L4;
    L7:
        this.l = new byte[64];
    L8:
        invalidate();
        return;
    L4:
        if (r2.length == 0) goto L7;
        this.l = r2;
        goto L8
    }

    public AudioWaveView(Context r2, AttributeSet r3) {
        super(r2, r3);
        this.a = new Paint(1);
        this.b = new Paint(1);
        this.c = Color.rgb(255, 255, 255);
        this.d = Color.argb(51, 255, 255, 255);
        this.e = UIHelper.dp2px(2.0f);
        float r4 = UIHelper.dp2px(5.0f);
        this.f = r4;
        this.g = (UIHelper.dp2px(22.0f) - r4) / 2.0f;
        this.h = UIHelper.dp2px(2.0f);
        this.i = UIHelper.dp2px(4.0f);
        this.n = 100;
    }

    public AudioWaveView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = new Paint(1);
        this.b = new Paint(1);
        this.c = Color.rgb(255, 255, 255);
        this.d = Color.argb(51, 255, 255, 255);
        this.e = UIHelper.dp2px(2.0f);
        float r4 = UIHelper.dp2px(5.0f);
        this.f = r4;
        this.g = (UIHelper.dp2px(22.0f) - r4) / 2.0f;
        this.h = UIHelper.dp2px(2.0f);
        this.i = UIHelper.dp2px(4.0f);
        this.n = 100;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        this.j = r1;
        this.k = r2;
    }
}
