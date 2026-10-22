package com.larus.voicecall.impl.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0014J(\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0014J\u0010\u0010&\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010'\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0006\u0010(\u001a\u00020\u001eJ\u0010\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020\u0018H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/larus/voicecall/impl/video/RealtimeCallBrushView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBrushPaint", "Landroid/graphics/Paint;", "pathList", NameKeys.UnloadStrategy_No_Strategy, "Landroid/graphics/Path;", "pathDataList", "Lcom/larus/voicecall/impl/video/BrushPath;", "curPath", "curPathData", "canvasWidth", "canvasHeight", "bitmapCache", "Landroid/graphics/Bitmap;", "cacheCanvas", "Landroid/graphics/Canvas;", "onTouchEvent", NameKeys.UnloadStrategy_No_Strategy, "event", "Landroid/view/MotionEvent;", "onMeasure", NameKeys.UnloadStrategy_No_Strategy, "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "handleOnTouchEvent", "drawCurrentPath", "clear", "onDraw", "canvas", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeCallBrushView extends View {
    public final Paint a;
    public final List<Path> b;
    public final List<b> c;
    public Path d;
    public b e;
    public Bitmap f;
    public Canvas g;

    public RealtimeCallBrushView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public RealtimeCallBrushView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r4) {
        Intrinsics.checkNotNullParameter(r4, "canvas");
        super.onDraw(r4);
        Bitmap r0 = this.f;
        if (r0 == null) goto L5;
        r4.drawBitmap(r0, 0.0f, 0.0f, null);
    L5:
        Iterator r1 = ((ArrayList) this.b).iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        r4.drawPath((Path) r1.next(), this.a);
        goto L7
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r6) {
        if (r6 == null) goto L30;
        int r1 = r6.getAction();
        if (r1 == 0) goto L29;
        if (r1 != 1) goto L8;
        Path r2 = this.d;
        if (r2 == null) goto L25;
        r2.lineTo(r6.getX(), r6.getY());
        Canvas r3 = this.g;
        if (r3 == null) goto L24;
        r3.drawPath(r2, this.a);
    L24:
        invalidate();
    L25:
        b r4 = this.e;
        if (r4 == null) goto L28;
        r4.a.add(new a(r6.getX(), r6.getY()));
    L28:
        this.d = null;
        this.e = null;
        goto L30
    L8:
        if (r1 != 2) goto L30;
        Path r5 = this.d;
        if (r5 == null) goto L16;
        r5.lineTo(r6.getX(), r6.getY());
        Canvas r7 = this.g;
        if (r7 == null) goto L15;
        r7.drawPath(r5, this.a);
    L15:
        invalidate();
    L16:
        b r8 = this.e;
        if (r8 == null) goto L30;
        r8.a.add(new a(r6.getX(), r6.getY()));
        goto L30
    L29:
        Path r9 = new Path();
        r9.moveTo(r6.getX(), r6.getY());
        ((ArrayList) this.b).add(r9);
        this.d = r9;
        b r10 = new b(null);
        r10.a.add(new a(r6.getX(), r6.getY()));
        ((ArrayList) this.c).add(r10);
        this.e = r10;
    L30:
        return true;
    }

    @Override // android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        getMeasuredWidth();
        getMeasuredHeight();
    }

    public RealtimeCallBrushView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        Paint r5 = new Paint();
        this.a = r5;
        this.b = new ArrayList();
        this.c = new ArrayList();
        r5.setColor(ContextCompat.getColor(r2, 2131103268));
        r5.setStrokeWidth(i5.N());
        r5.setStrokeJoin(Paint.Join.ROUND);
        r5.setStrokeCap(Paint.Cap.ROUND);
        r5.setAntiAlias(true);
        r5.setStyle(Paint.Style.STROKE);
    }

    public /* synthetic */ RealtimeCallBrushView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        Bitmap r5 = Bitmap.createBitmap(r1, r2, Bitmap.Config.ARGB_8888);
        this.f = r5;
        this.g = new Canvas(r5);
    }
}
