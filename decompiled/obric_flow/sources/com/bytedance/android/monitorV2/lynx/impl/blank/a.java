package com.bytedance.android.monitorV2.lynx.impl.blank;

import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.RenderNode;
import android.graphics.text.MeasuredText;
import android.text.TextUtils;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import com.bytedance.ai.event.MessageIndication;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends Canvas {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3662a;

    @Override // android.graphics.Canvas
    public final void drawARGB(int r5, int r10, int r11, int r12) {
        this.f3662a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawArc(RectF r5, float r10, float r11, boolean r12, Paint r13) {
        Intrinsics.checkNotNullParameter(r5, "oval");
        Intrinsics.checkNotNullParameter(r13, "paint");
        this.f3662a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawBitmap(Bitmap r5, float r10, float r11, Paint r12) {
        Intrinsics.checkNotNullParameter(r5, "bitmap");
        if (r5.getWidth() > 0) goto L5;
        return;
    L5:
        if (r5.getHeight() > 0) goto L7;
        return;
    L7:
        if (r5.isRecycled() == true) goto L12;
        this.f3662a = true;
        return;
    }

    @Override // android.graphics.Canvas
    public final void drawBitmapMesh(Bitmap r5, int r10, int r11, float[] r12, int r13, int[] r14, int r15, Paint r16) {
        Intrinsics.checkNotNullParameter(r5, "bitmap");
        Intrinsics.checkNotNullParameter(r12, "verts");
        if (r5.getWidth() > 0) goto L5;
        return;
    L5:
        if (r5.getHeight() > 0) goto L7;
        return;
    L7:
        if (r5.isRecycled() == true) goto L12;
        this.f3662a = true;
        return;
    }

    @Override // android.graphics.Canvas
    public final void drawCircle(float r5, float r10, float r11, Paint r12) {
        Intrinsics.checkNotNullParameter(r12, "paint");
        this.f3662a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawColor(int r5) {
        this.f3662a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawDoubleRoundRect(RectF r5, float r10, float r11, RectF r12, float r13, float r14, Paint r15) {
        Intrinsics.checkNotNullParameter(r5, "outer");
        Intrinsics.checkNotNullParameter(r12, "inner");
        Intrinsics.checkNotNullParameter(r15, "paint");
        if (r5.isEmpty() == true) goto L5;
    L8:
        this.f3662a = true;
        return;
    L5:
        if (r12.isEmpty() == false) goto L8;
    }

    @Override // android.graphics.Canvas
    public final void drawLine(float r5, float r10, float r11, float r12, Paint r13) {
        Intrinsics.checkNotNullParameter(r13, "paint");
        this.f3662a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawLines(float[] r5, int r10, int r11, Paint r12) {
        Intrinsics.checkNotNullParameter(r5, "pts");
        Intrinsics.checkNotNullParameter(r12, "paint");
        this.f3662a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawOval(RectF r5, Paint r10) {
        Intrinsics.checkNotNullParameter(r5, "oval");
        Intrinsics.checkNotNullParameter(r10, "paint");
        this.f3662a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawPaint(Paint r5) {
        Intrinsics.checkNotNullParameter(r5, "paint");
        this.f3662a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawPath(Path r5, Paint r10) {
        Intrinsics.checkNotNullParameter(r5, SVGRenderEngine.PATH);
        Intrinsics.checkNotNullParameter(r10, "paint");
        this.f3662a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawPicture(Picture r5) {
        Intrinsics.checkNotNullParameter(r5, "picture");
        if (r5.getWidth() > 0) goto L5;
        return;
    L5:
        if (r5.getHeight() <= 0) goto L9;
        this.f3662a = true;
        return;
    }

    @Override // android.graphics.Canvas
    public final void drawPoint(float r5, float r10, Paint r11) {
        Intrinsics.checkNotNullParameter(r11, "paint");
        this.f3662a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawPoints(float[] r5, int r10, int r11, Paint r12) {
        Intrinsics.checkNotNullParameter(r12, "paint");
        this.f3662a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawPosText(char[] r5, int r10, int r11, float[] r12, Paint r13) {
        Intrinsics.checkNotNullParameter(r5, MessageIndication.CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r12, OpenPageMethod.KEY_POS);
        Intrinsics.checkNotNullParameter(r13, "paint");
        if (TextUtils.isEmpty(new String(r5)) == false) goto L6;
        this.f3662a = true;
        return;
    }

    @Override // android.graphics.Canvas
    public final void drawRGB(int r5, int r10, int r11) {
        this.f3662a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawRect(RectF r5, Paint r10) {
        Intrinsics.checkNotNullParameter(r5, SVGRenderEngine.RECT);
        Intrinsics.checkNotNullParameter(r10, "paint");
        if (r5.isEmpty() == true) goto L6;
        this.f3662a = true;
        return;
    }

    @Override // android.graphics.Canvas
    public final void drawRenderNode(RenderNode r5) {
        Intrinsics.checkNotNullParameter(r5, "renderNode");
        this.f3662a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawRoundRect(RectF r5, float r10, float r11, Paint r12) {
        Intrinsics.checkNotNullParameter(r5, SVGRenderEngine.RECT);
        Intrinsics.checkNotNullParameter(r12, "paint");
        if (r5.isEmpty() == true) goto L6;
        this.f3662a = true;
        return;
    }

    @Override // android.graphics.Canvas
    public final void drawText(char[] r5, int r10, int r11, float r12, float r13, Paint r14) {
        Intrinsics.checkNotNullParameter(r5, MessageIndication.CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r14, "paint");
        if (TextUtils.isEmpty(new String(r5)) == true) goto L6;
        this.f3662a = true;
        return;
    }

    @Override // android.graphics.Canvas
    public final void drawTextOnPath(char[] r5, int r10, int r11, Path r12, float r13, float r14, Paint r15) {
        Intrinsics.checkNotNullParameter(r5, MessageIndication.CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r12, SVGRenderEngine.PATH);
        Intrinsics.checkNotNullParameter(r15, "paint");
        if (TextUtils.isEmpty(new String(r5)) == true) goto L6;
        this.f3662a = true;
        return;
    }

    @Override // android.graphics.Canvas
    public final void drawTextRun(char[] r5, int r10, int r11, int r12, int r13, float r14, float r15, boolean r16, Paint r17) {
        Intrinsics.checkNotNullParameter(r5, MessageIndication.CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r17, "paint");
        this.f3662a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawVertices(Canvas.VertexMode r5, int r10, float[] r11, int r12, float[] r13, int r14, int[] r15, int r16, short[] r17, int r18, int r19, Paint r110) {
        Intrinsics.checkNotNullParameter(r5, "mode");
        Intrinsics.checkNotNullParameter(r11, "verts");
        Intrinsics.checkNotNullParameter(r110, "paint");
        this.f3662a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawArc(float r5, float r10, float r11, float r12, float r13, float r14, boolean r15, Paint r16) {
        Intrinsics.checkNotNullParameter(r16, "paint");
        this.f3662a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawColor(long r5) {
        this.f3662a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawLines(float[] r5, Paint r10) {
        Intrinsics.checkNotNullParameter(r5, "pts");
        Intrinsics.checkNotNullParameter(r10, "paint");
        this.f3662a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawOval(float r5, float r10, float r11, float r12, Paint r13) {
        Intrinsics.checkNotNullParameter(r13, "paint");
        this.f3662a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawPoints(float[] r5, Paint r10) {
        Intrinsics.checkNotNullParameter(r5, "pts");
        Intrinsics.checkNotNullParameter(r10, "paint");
        this.f3662a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawTextRun(CharSequence r5, int r10, int r11, int r12, int r13, float r14, float r15, boolean r16, Paint r17) {
        Intrinsics.checkNotNullParameter(r5, MessageIndication.CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r17, "paint");
        this.f3662a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawBitmap(Bitmap r5, Rect r10, RectF r11, Paint r12) {
        Intrinsics.checkNotNullParameter(r5, "bitmap");
        Intrinsics.checkNotNullParameter(r11, "dst");
        if (r5.getWidth() > 0) goto L5;
        return;
    L5:
        if (r5.getHeight() > 0) goto L7;
        return;
    L7:
        if (r5.isRecycled() == true) goto L12;
        this.f3662a = true;
        return;
    }

    @Override // android.graphics.Canvas
    public final void drawColor(int r5, PorterDuff.Mode r10) {
        Intrinsics.checkNotNullParameter(r10, "mode");
        this.f3662a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawDoubleRoundRect(RectF r5, float[] r10, RectF r11, float[] r12, Paint r13) {
        Intrinsics.checkNotNullParameter(r5, "outer");
        Intrinsics.checkNotNullParameter(r10, "outerRadii");
        Intrinsics.checkNotNullParameter(r11, "inner");
        Intrinsics.checkNotNullParameter(r12, "innerRadii");
        Intrinsics.checkNotNullParameter(r13, "paint");
        if (r5.isEmpty() == true) goto L5;
    L8:
        this.f3662a = true;
        return;
    L5:
        if (r11.isEmpty() == false) goto L8;
    }

    @Override // android.graphics.Canvas
    public final void drawPicture(Picture r5, RectF r10) {
        Intrinsics.checkNotNullParameter(r5, "picture");
        Intrinsics.checkNotNullParameter(r10, "dst");
        if (r5.getWidth() > 0) goto L5;
        return;
    L5:
        if (r5.getHeight() <= 0) goto L9;
        this.f3662a = true;
        return;
    }

    @Override // android.graphics.Canvas
    public final void drawPosText(String r5, float[] r10, Paint r11) {
        Intrinsics.checkNotNullParameter(r5, MessageIndication.CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r10, OpenPageMethod.KEY_POS);
        Intrinsics.checkNotNullParameter(r11, "paint");
        if (TextUtils.isEmpty(r5) == false) goto L6;
        this.f3662a = true;
        return;
    }

    @Override // android.graphics.Canvas
    public final void drawRect(Rect r5, Paint r10) {
        Intrinsics.checkNotNullParameter(r5, "r");
        Intrinsics.checkNotNullParameter(r10, "paint");
        if (r5.isEmpty() == true) goto L6;
        this.f3662a = true;
        return;
    }

    @Override // android.graphics.Canvas
    public final void drawRoundRect(float r5, float r10, float r11, float r12, float r13, float r14, Paint r15) {
        Intrinsics.checkNotNullParameter(r15, "paint");
        if (new RectF(r5, r10, r11, r12).isEmpty() == true) goto L6;
        this.f3662a = true;
        return;
    }

    @Override // android.graphics.Canvas
    public final void drawText(String r5, float r10, float r11, Paint r12) {
        Intrinsics.checkNotNullParameter(r5, MessageIndication.CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r12, "paint");
        if (TextUtils.isEmpty(r5) == true) goto L6;
        this.f3662a = true;
        return;
    }

    @Override // android.graphics.Canvas
    public final void drawTextOnPath(String r5, Path r10, float r11, float r12, Paint r13) {
        Intrinsics.checkNotNullParameter(r5, MessageIndication.CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r10, SVGRenderEngine.PATH);
        Intrinsics.checkNotNullParameter(r13, "paint");
        if (TextUtils.isEmpty(r5) == true) goto L6;
        this.f3662a = true;
        return;
    }

    @Override // android.graphics.Canvas
    public final void drawTextRun(MeasuredText r5, int r10, int r11, int r12, int r13, float r14, float r15, boolean r16, Paint r17) {
        Intrinsics.checkNotNullParameter(r5, MessageIndication.CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r17, "paint");
        this.f3662a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawColor(int r5, BlendMode r10) {
        Intrinsics.checkNotNullParameter(r10, "mode");
        this.f3662a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawBitmap(Bitmap r5, Rect r10, Rect r11, Paint r12) {
        Intrinsics.checkNotNullParameter(r5, "bitmap");
        Intrinsics.checkNotNullParameter(r11, "dst");
        if (r5.getWidth() > 0) goto L5;
        return;
    L5:
        if (r5.getHeight() > 0) goto L7;
        return;
    L7:
        if (r5.isRecycled() == true) goto L12;
        this.f3662a = true;
        return;
    }

    @Override // android.graphics.Canvas
    public final void drawColor(long r5, BlendMode r10) {
        Intrinsics.checkNotNullParameter(r10, "mode");
        this.f3662a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawPicture(Picture r5, Rect r10) {
        Intrinsics.checkNotNullParameter(r5, "picture");
        Intrinsics.checkNotNullParameter(r10, "dst");
        if (r5.getWidth() > 0) goto L5;
        return;
    L5:
        if (r5.getHeight() <= 0) goto L9;
        this.f3662a = true;
        return;
    }

    @Override // android.graphics.Canvas
    public final void drawRect(float r5, float r10, float r11, float r12, Paint r13) {
        Intrinsics.checkNotNullParameter(r13, "paint");
        if (new RectF(r5, r10, r11, r12).isEmpty() == true) goto L6;
        this.f3662a = true;
        return;
    }

    @Override // android.graphics.Canvas
    public final void drawText(String r5, int r10, int r11, float r12, float r13, Paint r14) {
        Intrinsics.checkNotNullParameter(r5, MessageIndication.CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r14, "paint");
        if (TextUtils.isEmpty(r5) == true) goto L6;
        this.f3662a = true;
        return;
    }

    @Override // android.graphics.Canvas
    public final void drawBitmap(int[] r5, int r10, int r11, float r12, float r13, int r14, int r15, boolean r16, Paint r17) {
        Intrinsics.checkNotNullParameter(r5, "colors");
        this.f3662a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawText(CharSequence r5, int r10, int r11, float r12, float r13, Paint r14) {
        Intrinsics.checkNotNullParameter(r5, MessageIndication.CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r14, "paint");
        if (TextUtils.isEmpty(r5) == true) goto L6;
        this.f3662a = true;
        return;
    }

    @Override // android.graphics.Canvas
    public final void drawBitmap(int[] r5, int r10, int r11, int r12, int r13, int r14, int r15, boolean r16, Paint r17) {
        Intrinsics.checkNotNullParameter(r5, "colors");
        this.f3662a = true;
    }

    @Override // android.graphics.Canvas
    public final void drawBitmap(Bitmap r5, Matrix r10, Paint r11) {
        Intrinsics.checkNotNullParameter(r5, "bitmap");
        Intrinsics.checkNotNullParameter(r10, "matrix");
        if (r5.getWidth() > 0) goto L5;
        return;
    L5:
        if (r5.getHeight() > 0) goto L7;
        return;
    L7:
        if (r5.isRecycled() == true) goto L12;
        this.f3662a = true;
        return;
    }
}
