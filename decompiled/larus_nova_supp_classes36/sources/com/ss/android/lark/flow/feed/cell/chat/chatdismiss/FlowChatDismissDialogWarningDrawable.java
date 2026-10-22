package com.ss.android.lark.flow.feed.cell.chat.chatdismiss;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowChatDismissDialogWarningDrawable extends Drawable {
    public final Context a;
    public final Lazy b;
    public final Lazy c;
    public final Paint d;
    public final Paint e;
    public final Path f;
    public final Path g;

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java")
    public final int getOpacity() {
        return -3;
    }

    public final Context getContext() {
        return this.a;
    }

    public FlowChatDismissDialogWarningDrawable(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        this.a = r4;
        Lazy r5 = LazyKt.lazy(new FlowChatDismissDialogWarningDrawable$strokePaintColor$2(this));
        this.b = r5;
        this.c = LazyKt.lazy(new FlowChatDismissDialogWarningDrawable$fillPaintColorRed$2(this));
        Paint r0 = new Paint(1);
        r0.setStyle(Paint.Style.FILL);
        this.d = r0;
        Paint r1 = new Paint(1);
        r1.setStyle(Paint.Style.STROKE);
        r1.setColor(((Number) r5.getValue()).intValue());
        r1.setStrokeWidth(2.0f);
        r1.setStrokeJoin(Paint.Join.ROUND);
        r1.setStrokeCap(Paint.Cap.ROUND);
        this.e = r1;
        this.f = new Path();
        this.g = new Path();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r27) {
        Intrinsics.checkNotNullParameter(r27, "canvas");
        Rect r2 = getBounds();
        float r3 = Math.min(r2.width(), r2.height()) / 22.0f;
        r27.save();
        r27.translate(r2.left, r2.top);
        r27.scale(r3, r3);
        this.d.setColor(((Number) this.c.getValue()).intValue());
        this.f.reset();
        this.f.moveTo(11.9902f, 1.0f);
        this.f.cubicTo(13.4876f, 1.0f, 14.9109f, 1.28714f, 16.25f, 1.86621f);
        this.f.cubicTo(17.5736f, 2.43859f, 18.7441f, 3.23242f, 19.7559f, 4.24414f);
        this.f.cubicTo(20.7671f, 5.25535f, 21.5605f, 6.42525f, 22.1328f, 7.74805f);
        this.f.lineTo(22.3369f, 8.25293f);
        this.f.cubicTo(22.7803f, 9.43863f, 23.0f, 10.69f, 23.0f, 12.0f);
        this.f.cubicTo(23.0f, 13.4974f, 22.7129f, 14.9207f, 22.1338f, 16.2598f);
        this.f.lineTo(22.1328f, 16.2617f);
        this.f.cubicTo(21.5602f, 17.5786f, 20.7667f, 18.7451f, 19.7559f, 19.7559f);
        this.f.cubicTo(18.7441f, 20.7676f, 17.5736f, 21.5614f, 16.25f, 22.1338f);
        this.f.cubicTo(14.9168f, 22.7131f, 13.4967f, 23.0f, 12.0f, 23.0f);
        this.f.cubicTo(10.5026f, 23.0f, 9.07934f, 22.7129f, 7.74023f, 22.1338f);
        this.f.lineTo(7.73828f, 22.1328f);
        this.f.cubicTo(6.42142f, 21.5602f, 5.25493f, 20.7667f, 4.24414f, 19.7559f);
        this.f.cubicTo(3.23335f, 18.7451f, 2.43976f, 17.5786f, 1.86719f, 16.2617f);
        this.f.lineTo(1.86621f, 16.2598f);
        this.f.cubicTo(1.28714f, 14.9207f, 1.0f, 13.4974f, 1.0f, 12.0f);
        this.f.cubicTo(1.0f, 10.5026f, 1.28733f, 9.08172f, 1.86719f, 7.74805f);
        this.f.cubicTo(2.43885f, 6.42675f, 3.22762f, 5.25709f, 4.23145f, 4.24609f);
        this.f.lineTo(4.23438f, 4.24414f);
        this.f.cubicTo(5.24517f, 3.23335f, 6.41165f, 2.43976f, 7.72852f, 1.86719f);
        this.f.lineTo(7.73047f, 1.86621f);
        this.f.cubicTo(9.06957f, 1.28715f, 10.4929f, 1.0f, 11.9902f, 1.0f);
        this.f.close();
        r27.drawPath(this.f, this.d);
        r27.drawPath(this.f, this.e);
        this.d.setColor(((Number) this.b.getValue()).intValue());
        this.g.reset();
        this.g.moveTo(12.0f, 13.8236f);
        this.g.cubicTo(12.5098f, 13.8236f, 12.768f, 13.5557f, 12.7745f, 13.0197f);
        this.g.lineTo(12.9216f, 7.68638f);
        this.g.cubicTo(12.9281f, 7.43148f, 12.8399f, 7.21906f, 12.6569f, 7.04913f);
        this.g.cubicTo(12.4804f, 6.87266f, 12.2582f, 6.78442f, 11.9902f, 6.78442f);
        this.g.cubicTo(11.7157f, 6.78442f, 11.4902f, 6.86939f, 11.3137f, 7.03933f);
        this.g.cubicTo(11.1438f, 7.20926f, 11.0621f, 7.42168f, 11.0686f, 7.67658f);
        this.g.lineTo(11.1961f, 13.0197f);
        this.g.cubicTo(11.2092f, 13.5557f, 11.4771f, 13.8236f, 12.0f, 13.8236f);
        this.g.close();
        r27.drawPath(this.g, this.d);
        r27.drawCircle(12.0f, 16.05f, 1.05f, this.d);
        r27.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r2) {
        this.d.setAlpha(r2);
        this.e.setAlpha(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r2) {
        this.d.setColorFilter(r2);
        this.e.setColorFilter(r2);
    }
}
