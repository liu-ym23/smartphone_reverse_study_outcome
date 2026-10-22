package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0017B'\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002R\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/likeegg/ui/LikeEggProgressBar;", "Landroid/view/View;", BuildConfig.FLAVOR, "progressColor", BuildConfig.FLAVOR, "setProgressColor", "backgroundColor", "setProgressBackgroundColor", "progress", "setProgress", "Landroid/graphics/Paint;", "c", "Lkotlin/Lazy;", "getMBackgroundPaint", "()Landroid/graphics/Paint;", "mBackgroundPaint", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LikeEggProgressBar extends View {
    public final Paint a;
    public final Paint b;
    public final Lazy c;
    public int d;
    public final float e;
    public final RectF f;
    public final Path g;
    public final RectF h;

    public static final class a {
    }

    static {
    }

    public LikeEggProgressBar(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public LikeEggProgressBar(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final Paint getMBackgroundPaint() {
        return (Paint) this.c.getValue();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r9) {
        Intrinsics.checkNotNullParameter(r9, "canvas");
        float r1 = 2;
        float r0 = this.e / r1;
        this.f.set(r0, r0, getMeasuredWidth() - r0, getMeasuredHeight() - r0);
        r9.drawRoundRect(this.f, (getMeasuredHeight() / r1) - r0, (getMeasuredHeight() / r1) - r0, this.a);
        float r2 = this.e;
        float r3 = getMeasuredWidth() - this.e;
        float r4 = getMeasuredHeight() - this.e;
        float r5 = getMeasuredHeight() / r1;
        float r6 = this.e;
        float r7 = r5 - r6;
        float r8 = ((this.d / 10000) * (r3 - r2)) + r6;
        float r10 = r8 - (r1 * r7);
        this.f.set(r2, r2, r3, r4);
        r9.drawRoundRect(this.f, r7, r7, getMBackgroundPaint());
        if (this.d <= 0) goto L5;
        float r11 = r2 - 1;
        this.h.set(r10, r11, r8, r4);
        Path r13 = this.g;
        r13.reset();
        r13.moveTo(Math.min(r10, r2), r11);
        r13.lineTo(r8, r11);
        r13.arcTo(this.h, 270.0f, 180.0f);
        r13.lineTo(Math.min(r10, r2), r4);
        r13.close();
        r9.save();
        r9.clipPath(this.g);
        r9.drawRoundRect(this.f, r7, r7, this.b);
        r9.restore();
    L5:
        super.onDraw(r9);
    }

    public final void setProgress(int r1) {
        this.d = r1;
        invalidate();
    }

    public final void setProgressBackgroundColor(int r2) {
        getMBackgroundPaint().setColor(r2);
        invalidate();
    }

    public final void setProgressColor(int r2) {
        this.b.setColor(r2);
        invalidate();
    }

    public LikeEggProgressBar(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        setLayerType(1, null);
        Paint r5 = new Paint();
        r5.setColor(ColorProtector.parseColor("#4DFFE5F1"));
        r5.setAntiAlias(true);
        r5.setStyle(Paint.Style.STROKE);
        float r6 = 1;
        r5.setStrokeWidth(UtilityKotlinExtentionsKt.h(r6));
        Unit r0 = Unit.INSTANCE;
        this.a = r5;
        Paint r7 = new Paint();
        r7.setColor(ColorProtector.parseColor("#99FF3055"));
        r7.setAntiAlias(true);
        r7.setStyle(Paint.Style.FILL);
        this.b = r7;
        this.c = LazyKt.lazy(LikeEggProgressBar$mBackgroundPaint$2.INSTANCE);
        this.e = UtilityKotlinExtentionsKt.h(r6);
        this.f = new RectF();
        this.g = new Path();
        this.h = new RectF();
    }

    public /* synthetic */ LikeEggProgressBar(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
