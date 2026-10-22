package com.larus.avlink.record.page;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0010J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/avlink/record/page/UploadProgressView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "_trackPaint", "Landroid/graphics/Paint;", "_progressPaint", "_arcRect", "Landroid/graphics/RectF;", "_progress", "", "setProgress", "", "progress", "onDraw", "canvas", "Landroid/graphics/Canvas;", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class UploadProgressView extends View {
    public static final int e = 0;
    public static final int f = 0;
    public final Paint a;
    public final Paint b;
    public final RectF c;
    public float d;

    public static final class a {
    }

    public UploadProgressView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public UploadProgressView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    static {
        e = ColorProtector.parseColor("#CCCCCC");
        f = ColorProtector.parseColor("#0066FF");
    }

    @Override // android.view.View
    public final void onDraw(Canvas r8) {
        Intrinsics.checkNotNullParameter(r8, "canvas");
        super.onDraw(r8);
        float r0 = getWidth() * 0.12f;
        this.a.setStrokeWidth(r0);
        this.b.setStrokeWidth(r0);
        float r1 = r0 / 2.0f;
        this.c.set(r1, r1, getWidth() - r1, getHeight() - r1);
        r8.drawArc(this.c, 0.0f, 360.0f, false, this.a);
        r8.drawArc(this.c, -90.0f, this.d * 360.0f, false, this.b);
    }

    public final void setProgress(float r3) {
        float r4 = RangesKt.coerceIn(r3, 0.0f, 1.0f);
        if (r4 != this.d) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        this.d = r4;
        invalidate();
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public UploadProgressView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        Paint r5 = new Paint(1);
        r5.setStyle(Paint.Style.STROKE);
        r5.setColor(e);
        this.a = r5;
        Paint r6 = new Paint(1);
        r6.setStyle(Paint.Style.STROKE);
        r6.setColor(f);
        r6.setStrokeCap(Paint.Cap.ROUND);
        this.b = r6;
        this.c = new RectF();
    }

    public /* synthetic */ UploadProgressView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
