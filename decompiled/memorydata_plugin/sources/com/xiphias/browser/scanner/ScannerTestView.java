package com.xiphias.browser.scanner;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0015R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/xiphias/browser/scanner/ScannerTestView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "paint", "Landroid/graphics/Paint;", EventBody.KEY_VALUE, "Landroid/graphics/Bitmap;", "bitmap", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScannerTestView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Paint f16316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Bitmap f16317b;

    public ScannerTestView(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6);
        Paint r7 = new Paint(1);
        r7.setStyle(Paint.Style.STROKE);
        r7.setColor(-16776961);
        r7.setStrokeWidth(10.0f);
        this.f16316a = r7;
    }

    public final Bitmap getBitmap() {
        return this.f16317b;
    }

    @Override // android.view.View
    public void onDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        if (this.f16317b != null) goto L5;
        return;
    L5:
        r10.drawColor(-1);
        float r0 = getWidth() - 50.0f;
        float r8 = getHeight() - 50.0f;
        r10.drawRect(50.0f, 50.0f, r0, r8, this.f16316a);
        Bitmap r1 = this.f16317b;
        Intrinsics.checkNotNull(r1);
        Bitmap r3 = this.f16317b;
        Intrinsics.checkNotNull(r3);
        int r4 = r3.getWidth();
        Bitmap r5 = this.f16317b;
        Intrinsics.checkNotNull(r5);
        Rect r2 = new Rect(0, 0, r4, r5.getHeight());
        int r6 = (int) 50.0f;
        r10.drawBitmap(r1, r2, new Rect(r6, r6, (int) r0, (int) r8), this.f16316a);
    }

    public final void setBitmap(Bitmap r1) {
        this.f16317b = r1;
        invalidate();
    }
}
