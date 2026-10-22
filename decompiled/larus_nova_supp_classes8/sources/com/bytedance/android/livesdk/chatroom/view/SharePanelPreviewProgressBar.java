package com.bytedance.android.livesdk.chatroom.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0011B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\b\u001a\u00020\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/view/SharePanelPreviewProgressBar;", "Landroid/view/View;", "", "", "c", "Lkotlin/Lazy;", "getMStrokeWidth", "()F", "mStrokeWidth", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SharePanelPreviewProgressBar extends View {
    public static final int e = 0;
    public float a;
    public float b;
    public final Lazy c;
    public final Paint d;

    public static final class a {
    }

    public SharePanelPreviewProgressBar(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SharePanelPreviewProgressBar(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final float getMStrokeWidth() {
        return ((Number) this.c.getValue()).floatValue();
    }

    static {
        e = ColorProtector.parseColor("#FFFFFF");
    }

    @Override // android.view.View
    public final void onDraw(Canvas r11) {
        Intrinsics.checkNotNullParameter(r11, "canvas");
        super.onDraw(r11);
        this.b = (getMeasuredWidth() * this.a) / 100;
        float r1 = 2;
        float r0 = (getPaddingTop() / r1) + (getMeasuredHeight() / r1);
        r11.drawLine(0.0f, r0, this.b, r0, this.d);
        float r2 = this.b;
        float r3 = getMStrokeWidth() / r1;
        r11.drawArc(new RectF(r2 - r3, r0 - r3, r2 + r3, r0 + r3), -90.0f, 180.0f, true, this.d);
    }

    public SharePanelPreviewProgressBar(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = LazyKt.lazy(new SharePanelPreviewProgressBar$mStrokeWidth$2(r2));
        Paint r5 = new Paint(1);
        r5.setAlpha(255);
        r5.setStrokeWidth(getMStrokeWidth());
        r5.setColor(e);
        Unit r6 = Unit.INSTANCE;
        this.d = r5;
    }

    public /* synthetic */ SharePanelPreviewProgressBar(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
