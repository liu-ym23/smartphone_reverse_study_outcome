package com.larus.bmhome.chat.layout.holder.progressloading;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import com.google.android.material.card.MaterialCardView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J.\u0010\u0017\u001a\u00020\u00142\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000bR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0018\u001a\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/larus/bmhome/chat/layout/holder/progressloading/RadiusCardView;", "Lcom/google/android/material/card/MaterialCardView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "tlRadius", "", "trRadius", "brRadius", "blRadius", "path", "Landroid/graphics/Path;", "getPath", "()Landroid/graphics/Path;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setRadius", "rectF", "Landroid/graphics/RectF;", "getRectF", "()Landroid/graphics/RectF;", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class RadiusCardView extends MaterialCardView {
    public float a;
    public float b;
    public float c;
    public float d;
    public final Path e;

    public RadiusCardView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public RadiusCardView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final RectF getRectF() {
        Rect r0 = new Rect();
        getDrawingRect(r0);
        return new RectF(r0);
    }

    public final Path getPath() {
        return this.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        this.e.reset();
        RectF r0 = getRectF();
        float r2 = this.a;
        float r3 = this.b;
        float r4 = this.c;
        float r6 = this.d;
        this.e.addRoundRect(r0, new float[]{r2, r2, r3, r3, r4, r4, r6, r6}, Path.Direction.CW);
        r5.clipPath(this.e, Region.Op.INTERSECT);
        super/*android.widget.FrameLayout*/.onDraw(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RadiusCardView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.e = new Path();
        setRadius(0.0f);
        TypedArray r5 = r2.obtainStyledAttributes(r3, new int[]{2130972153, 2130972154, 2130972155, 2130972156});
        this.a = r5.getDimension(2, 0.0f);
        this.b = r5.getDimension(3, 0.0f);
        this.c = r5.getDimension(1, 0.0f);
        this.d = r5.getDimension(0, 0.0f);
        setBackground(new ColorDrawable());
        r5.recycle();
    }

    public /* synthetic */ RadiusCardView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r3 & 4) == 0) goto L8;
        int r5 = 2130972688;
    L9:
        this(r1, r2, r5);
        return;
    L8:
        r5 = 0;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(float r1, float r2, float r3, float r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        invalidate();
    }
}
