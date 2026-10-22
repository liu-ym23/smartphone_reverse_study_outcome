package com.ss.android.lark.qrcode.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.math.MathUtils;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0014J\u0010\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020&H\u0002R\u0019\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006'"}, d2 = {"Lcom/ss/android/lark/qrcode/ui/QRCodeScanLayout;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "scanningBitmap", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "getScanningBitmap", "()Landroid/graphics/Bitmap;", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "dstRect", "Landroid/graphics/RectF;", "getDstRect", "()Landroid/graphics/RectF;", "loopDuration", "getLoopDuration", "()I", "startTime", "", "getStartTime", "()J", "setStartTime", "(J)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "calculateAlpha", "factor", "", "qrcode_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class QRCodeScanLayout extends View {
    public final Bitmap a;
    public final Paint b;
    public final RectF c;
    public final int d;
    public long e;

    public QRCodeScanLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public QRCodeScanLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final RectF getDstRect() {
        return this.c;
    }

    public final int getLoopDuration() {
        return this.d;
    }

    public final Paint getPaint() {
        return this.b;
    }

    public final Bitmap getScanningBitmap() {
        return this.a;
    }

    public final long getStartTime() {
        return this.e;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r18) {
        Intrinsics.checkNotNullParameter(r18, "canvas");
        super.onDraw(r18);
        if (this.e != 0) goto L5;
        this.e = SystemClock.uptimeMillis();
    L5:
        float r2 = getWidth();
        float r3 = (this.a.getHeight() / this.a.getWidth()) * r2;
        float r5 = (1.0f / this.d) * ((SystemClock.uptimeMillis() - this.e) % ((long) this.d));
        float r4 = (getHeight() - r3) * r5;
        this.b.setAlpha(MathKt.roundToInt(MathUtils.clamp(((double) 3) * Math.sin(((double) r5) * 3.141592653589793d), 0.0d, 1.0d) * ((double) 255)));
        RectF r6 = this.c;
        r6.top = r4;
        r6.bottom = r3 + r4;
        r6.right = r2;
        r18.drawBitmap(this.a, null, r6, this.b);
        invalidate();
    }

    public final void setStartTime(long r1) {
        this.e = r1;
    }

    public QRCodeScanLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = BitmapFactory.decodeResource(r2.getResources(), 2131233614);
        this.b = new Paint();
        this.c = new RectF();
        this.d = 3000;
    }

    public /* synthetic */ QRCodeScanLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
