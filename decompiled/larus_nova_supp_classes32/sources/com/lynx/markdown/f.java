package com.lynx.markdown;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.textra.BBufferInputStream;
import com.lynx.textra.JavaCanvasHelper;
import com.lynx.textra.TTText;
import com.lynx.textra.TTTextUtils;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f extends JavaCanvasHelper {
    public final h a;
    public final ArrayList<PointF> b;
    public float c;
    public float d;
    public Path e;

    @Override // com.lynx.textra.JavaCanvasHelper
    public final void restore() {
        super.restore();
        ArrayList<PointF> r0 = this.b;
        PointF r1 = (PointF) ListProtector.get(r0, r0.size() - 1);
        this.c = r1.x;
        this.d = r1.y;
        ArrayList<PointF> r2 = this.b;
        ListProtector.remove(r2, r2.size() - 1);
    }

    @Override // com.lynx.textra.JavaCanvasHelper
    public final void save() {
        super.save();
        this.b.add(new PointF(this.c, this.d));
    }

    public static Shader c(BBufferInputStream r11) throws IOException {
        float r2 = TTTextUtils.Dp2Px(r11.readFloat());
        float r3 = TTTextUtils.Dp2Px(r11.readFloat());
        float r4 = TTTextUtils.Dp2Px(r11.readFloat());
        float r5 = TTTextUtils.Dp2Px(r11.readFloat());
        int r0 = r11.readInt();
        int[] r6 = new int[r0];
        int r1 = 0;
        int r7 = 0;
    L3:
        if (r7 >= r0) goto L5;
        r6[r7] = r11.readInt();
        r7 = r7 + 1;
        goto L3
    L5:
        int r8 = r11.readInt();
        if (r8 != r0) goto L8;
        float[] r9 = new float[r8];
    L9:
        if (r1 >= r8) goto L15;
        float r10 = r11.readFloat();
        if (r9 == null) goto L13;
        r9[r1] = r10;
    L13:
        r1 = r1 + 1;
        goto L9
    L15:
        if (r0 >= 2) goto L18;
        return null;
    L18:
        return new LinearGradient(r2, r3, r4, r5, r6, r9, Shader.TileMode.CLAMP);
    L8:
        r9 = null;
        goto L9
    }

    public final void b(BBufferInputStream r10) throws IOException {
        byte r0 = r10.readByte();
        if (r0 != 0) goto L6;
        Path r11 = e(r10);
        this.canvas_.clipPath(r11);
        return;
    L6:
        if (r0 != 1) goto L20;
        Path r1 = e(r10);
        Paint r2 = this.paint_;
        d(r10, r2);
        int r12 = this.color_;
        if (r12 != 0) goto L10;
    L12:
        if (r12 == 0) goto L14;
        r2.setColor(r12);
        r2.setStyle(Paint.Style.FILL);
    L18:
        this.canvas_.drawPath(r1, r2);
        return;
    L14:
        int r13 = this.stroke_color_;
        if (r13 == 0) goto L17;
        r2.setColor(r13);
        r2.setStyle(Paint.Style.STROKE);
        goto L18
    L17:
        r2.setStyle(Paint.Style.FILL);
        goto L18
    L10:
        if (this.stroke_color_ != r12) goto L12;
        r2.setColor(r12);
        r2.setStyle(Paint.Style.FILL_AND_STROKE);
        goto L18
    L20:
        if (r0 != 2) goto L32;
        int r3 = r10.readInt();
        Path r4 = e(r10);
        Paint r5 = this.paint_;
        d(r10, r5);
        r5.setColor(this.color_);
        int r14 = this.color_;
        if (r14 != 0) goto L24;
    L26:
        if (r14 == 0) goto L29;
        r5.setStyle(Paint.Style.FILL);
        Canvas r15 = this.canvas_;
        Drawable r6 = this.a.a(r3);
        r15.clipPath(r4);
        r6.draw(r15);
    L29:
        if (this.stroke_color_ == 0) goto L47;
        r5.setStyle(Paint.Style.STROKE);
        r5.setColor(this.stroke_color_);
        Canvas r16 = this.canvas_;
        Drawable r7 = this.a.a(r3);
        r16.clipPath(r4);
        r7.draw(r16);
        return;
    L47:
        return;
    L24:
        if (this.stroke_color_ != r14) goto L26;
        r5.setStyle(Paint.Style.FILL_AND_STROKE);
        Canvas r17 = this.canvas_;
        Drawable r8 = this.a.a(r3);
        r17.clipPath(r4);
        r8.draw(r17);
        return;
    L32:
        if (r0 != 3) goto L38;
        Shader r9 = c(r10);
        float r18 = TTTextUtils.Dp2Px(r10.readFloat());
        float r19 = TTTextUtils.Dp2Px(r10.readFloat());
        float r20 = TTTextUtils.Dp2Px(r10.readFloat());
        float r21 = TTTextUtils.Dp2Px(r10.readFloat());
        Paint r22 = this.paint_;
        d(r10, r22);
        a(r22, r9);
        if (r9 == null) goto L51;
        this.canvas_.drawRect(r18, r19, r20, r21, r22);
        r22.setShader(null);
        return;
    L51:
        return;
    L38:
        if (r0 != 4) goto L50;
        Shader r23 = c(r10);
        Path r24 = e(r10);
        r10.readFloat();
        r10.readFloat();
        r10.readFloat();
        r10.readFloat();
        Paint r25 = this.paint_;
        d(r10, r25);
        a(r25, r23);
        if (r23 == null) goto L52;
        this.canvas_.drawPath(r24, r25);
        r25.setShader(null);
        return;
    L52:
        return;
    }

    @Override // com.lynx.textra.JavaCanvasHelper
    public final void drawRunDelegate(BBufferInputStream r15) {
        int r0 = r15.readInt();
        float r1 = TTTextUtils.Dp2Px(r15.readFloat());
        float r10 = TTTextUtils.Dp2Px(r15.readFloat());
        float r11 = TTTextUtils.Dp2Px(r15.readFloat());
        float r12 = TTTextUtils.Dp2Px(r15.readFloat());
        float r8 = TTTextUtils.Dp2Px(r15.readFloat());
        if (r8 <= 0.0f) goto L5;
        this.canvas_.save();
        Path r13 = new Path();
        r13.addRoundRect(r1, r10, r11, r12, r8, r8, Path.Direction.CW);
        this.canvas_.clipPath(r13);
    L5:
        Canvas r2 = this.canvas_;
        Drawable r3 = this.a.a(r0);
        r3.setBounds(new Rect((int) r1, (int) r10, (int) r11, (int) r12));
        r3.draw(r2);
        if (r8 <= 0.0f) goto L9;
        this.canvas_.restore();
        return;
    }

    public final Path e(BBufferInputStream r14) throws IOException {
        Path r0 = this.e;
        if (r0 != null) goto L5;
        this.e = new Path();
    L6:
        Path r1 = this.e;
        int r9 = r14.readInt();
        int r10 = 0;
    L7:
        if (r10 >= r9) goto L33;
        byte r2 = r14.readByte();
        if (r2 != 0) goto L12;
        float r3 = TTTextUtils.Dp2Px(r14.readFloat());
        float r4 = TTTextUtils.Dp2Px(r14.readFloat());
        float r5 = TTTextUtils.Dp2Px(r14.readFloat());
        float r6 = r14.readFloat();
        r1.addArc(r3 - r5, r4 - r5, r3 + r5, r4 + r5, r6, r14.readFloat() - r6);
    L32:
        r10 = r10 + 1;
        goto L7
    L12:
        if (r2 != 1) goto L15;
        r1.addOval(TTTextUtils.Dp2Px(r14.readFloat()), TTTextUtils.Dp2Px(r14.readFloat()), TTTextUtils.Dp2Px(r14.readFloat()), TTTextUtils.Dp2Px(r14.readFloat()), Path.Direction.CW);
        goto L32
    L15:
        if (r2 != 2) goto L18;
        r1.addRect(TTTextUtils.Dp2Px(r14.readFloat()), TTTextUtils.Dp2Px(r14.readFloat()), TTTextUtils.Dp2Px(r14.readFloat()), TTTextUtils.Dp2Px(r14.readFloat()), Path.Direction.CW);
        goto L32
    L18:
        if (r2 != 3) goto L21;
        r1.addRoundRect(TTTextUtils.Dp2Px(r14.readFloat()), TTTextUtils.Dp2Px(r14.readFloat()), TTTextUtils.Dp2Px(r14.readFloat()), TTTextUtils.Dp2Px(r14.readFloat()), TTTextUtils.Dp2Px(r14.readFloat()), TTTextUtils.Dp2Px(r14.readFloat()), Path.Direction.CW);
        goto L32
    L21:
        if (r2 != 4) goto L24;
        r1.moveTo(TTTextUtils.Dp2Px(r14.readFloat()), TTTextUtils.Dp2Px(r14.readFloat()));
        goto L32
    L24:
        if (r2 != 5) goto L27;
        r1.lineTo(TTTextUtils.Dp2Px(r14.readFloat()), TTTextUtils.Dp2Px(r14.readFloat()));
        goto L32
    L27:
        if (r2 != 6) goto L30;
        r1.cubicTo(TTTextUtils.Dp2Px(r14.readFloat()), TTTextUtils.Dp2Px(r14.readFloat()), TTTextUtils.Dp2Px(r14.readFloat()), TTTextUtils.Dp2Px(r14.readFloat()), TTTextUtils.Dp2Px(r14.readFloat()), TTTextUtils.Dp2Px(r14.readFloat()));
        goto L32
    L30:
        if (r2 != 7) goto L32;
        r1.quadTo(TTTextUtils.Dp2Px(r14.readFloat()), TTTextUtils.Dp2Px(r14.readFloat()), TTTextUtils.Dp2Px(r14.readFloat()), TTTextUtils.Dp2Px(r14.readFloat()));
        goto L32
    L33:
        return r1;
    L5:
        r0.rewind();
        goto L6
    }

    @Override // com.lynx.textra.JavaCanvasHelper
    public final void translate(BBufferInputStream r3) throws IOException {
        float r0 = TTTextUtils.Dp2Px(r3.readFloat());
        float r4 = TTTextUtils.Dp2Px(r3.readFloat());
        this.canvas_.translate(r0, r4);
        this.c += r0;
        this.d += r4;
    }

    public f(Canvas r2, h r3) {
        super(TTText.mFontManager);
        this.b = new ArrayList();
        this.canvas_ = r2;
        this.a = r3;
    }

    public final void a(Paint r4, Shader r5) {
        r4.setShader(r5);
        r4.setColor(-1);
        boolean r0 = false;
        if (this.color_ == 0) goto L5;
        boolean r6 = true;
    L7:
        if (this.stroke_color_ == 0) goto L9;
        r0 = true;
    L9:
        if (r6 == false) goto L12;
        if (r0 == false) goto L12;
        r4.setStyle(Paint.Style.FILL_AND_STROKE);
        return;
    L12:
        if (r0 == false) goto L14;
        r4.setStyle(Paint.Style.STROKE);
        return;
    L14:
        r4.setStyle(Paint.Style.FILL);
        return;
    L5:
        r6 = false;
        goto L7
    }

    public final void d(BBufferInputStream r3, Paint r4) throws IOException {
        boolean r0 = true;
        r4.setAntiAlias(true);
        r4.setShader(null);
        r4.setStrokeWidth(TTTextUtils.Dp2Px(r3.readFloat()));
        this.color_ = r3.readInt();
        this.stroke_color_ = r3.readInt();
        float r1 = TTTextUtils.Dp2Px(r3.readFloat());
        this.text_size_ = r1;
        r4.setTextSize(r1);
        byte r5 = r3.readByte();
        if ((r5 & 4) <= 0) goto L5;
        boolean r6 = true;
    L6:
        this.is_bold_ = r6;
        if ((r5 & 8) <= 0) goto L9;
        boolean r7 = true;
    L10:
        this.is_italic_ = r7;
        if ((r5 & 16) > 0) goto L14;
        r0 = false;
    L14:
        this.is_underline_ = r0;
        return;
    L9:
        r7 = false;
        goto L10
    L5:
        r6 = false;
        goto L6
    }
}
