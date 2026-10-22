package com.bytedance.android.livesdk.focus;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/focus/ExposureSeekBarView;", "Landroid/view/View;", "", "distance", "", "setProgress", "getSeekBarTotalLength", "getProgress", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExposureSeekBarView extends View {
    public final float a;
    public final float b;
    public final Bitmap c;
    public final float d;
    public final float e;
    public float f;
    public float g;
    public float h;
    public final Paint i;
    public final int j;
    public boolean k;
    public final Rect l;
    public final Rect m;

    public ExposureSeekBarView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ExposureSeekBarView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final float getProgress() {
        return this.h;
    }

    public final float getSeekBarTotalLength() {
        return this.a;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r17) {
        Intrinsics.checkNotNullParameter(r17, "canvas");
        super.onDraw(r17);
        float r1 = this.g;
        float r4 = this.h;
        float r10 = this.a;
        float r11 = this.b;
        double r12 = ((double) r1) + ((0.5d - ((double) r4)) * ((double) (r10 - (2 * r11))));
        float r2 = this.e;
        float r14 = r2 + ((this.d - r2) * r4);
        if (this.k == false) goto L10;
        float r15 = (float) r12;
        double r3 = ((double) r1) - (((double) r10) * 0.5d);
        float r5 = r15 - r11;
        if (r5 <= r3) goto L7;
        float r6 = this.f;
        r17.drawLine(r6, r5, r6, (float) r3, this.i);
    L7:
        double r7 = ((double) this.g) + (((double) this.a) * 0.5d);
        float r8 = r15 + this.b;
        if (r7 <= r8) goto L10;
        float r9 = this.f;
        r17.drawLine(r9, (float) r7, r9, r8, this.i);
    L10:
        float r13 = this.f;
        double r16 = r14;
        double r18 = r12 - r16;
        double r19 = r12 + r16;
        Rect r20 = this.l;
        r20.left = 0;
        r20.top = 0;
        r20.right = this.c.getWidth();
        r20.bottom = this.c.getHeight();
        Rect r21 = this.m;
        r21.left = (int) (r13 - r14);
        r21.top = (int) r18;
        r21.right = (int) (r13 + r14);
        r21.bottom = (int) r19;
        r17.drawBitmap(this.c, this.l, r21, this.i);
    }

    public final void setProgress(float r3) {
        float r0 = this.h + ((r3 / this.j) / this.a);
        if (r0 <= 1) goto L6;
        this.h = 1.0f;
    L9:
        this.k = true;
        invalidate();
        return;
    L6:
        if (r0 >= 0) goto L8;
        this.h = 0.0f;
        goto L9
    L8:
        this.h = r0;
        goto L9
    }

    public ExposureSeekBarView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = UtilityKotlinExtentionsKt.h(120);
        float r5 = UtilityKotlinExtentionsKt.h(1.5f);
        this.b = UtilityKotlinExtentionsKt.h(16);
        this.c = BitmapFactory.decodeResource(getContext().getResources(), 2131251721);
        this.d = UtilityKotlinExtentionsKt.h(11.5f);
        this.e = UtilityKotlinExtentionsKt.h(8.5f);
        this.h = 0.5f;
        Paint r6 = new Paint();
        this.i = r6;
        this.j = 10;
        this.l = new Rect();
        this.m = new Rect();
        r6.setColor(-1);
        r6.setStrokeWidth(r5);
        r6.setStrokeCap(Paint.Cap.ROUND);
        r6.setStrokeJoin(Paint.Join.ROUND);
        r6.setAntiAlias(true);
    }

    public /* synthetic */ ExposureSeekBarView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
