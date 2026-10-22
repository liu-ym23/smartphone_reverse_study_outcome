package com.ss.android.lark.chat.cot.detail.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.larksuite.framework.utils.UIUtils;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000 (2\u00020\u0001:\u0001(B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u000fH\u0014J\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"H\u0014J\u0017\u0010#\u001a\u00020\u001b2\n\b\u0001\u0010$\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010%J\u000e\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u000fR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006)"}, d2 = {"Lcom/ss/android/lark/chat/cot/detail/widget/FoldCircleImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "borderPaint", "Landroid/graphics/Paint;", "circlePath", "Landroid/graphics/Path;", "borderWidth", BuildConfig.FLAVOR, "borderColor", BuildConfig.FLAVOR, "radius", "borderRadius", "circleBackgroundColor", "circleBackgroundColorInt", "drawBorder", BuildConfig.FLAVOR, "getDrawBorder", "()Z", "setDrawBorder", "(Z)V", "onSizeChanged", BuildConfig.FLAVOR, SRStrategy.MEDIAINFO_KEY_WIDTH, "h", "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setCircleBackgroundColor", "color", "(Ljava/lang/Integer;)V", "setPaddings", "padding", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class FoldCircleImageView extends AppCompatImageView {
    public final Paint a;
    public final Path b;
    public final float c;
    public float d;
    public float e;
    public int f;
    public int g;
    public boolean h;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        Path r0 = this.b;
        int r1 = r5.save();
        r5.clipPath(r0);
        r5.drawColor(this.g);     // Catch: Throwable -> L8
        super/*android.widget.ImageView*/.onDraw(r5);     // Catch: Throwable -> L8
        r5.restoreToCount(r1);
        if (this.h == false) goto L13;
        r5.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, this.e, this.a);
        return;
    L13:
        return;
    L8:
        th = move-exception;
        r5.restoreToCount(r1);
        throw th;
    }

    public FoldCircleImageView(Context r5, AttributeSet r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6);
        Paint r7 = new Paint(1);
        this.a = r7;
        this.b = new Path();
        float r1 = UIUtils.dp2px(r5, 1.0f);
        this.c = r1;
        int r2 = UIUtils.getColor(r5, 2131100548);
        this.f = 2131100549;
        this.g = UIUtils.getColor(r5, 2131100549);
        this.h = true;
        r7.setStyle(Paint.Style.STROKE);
        r7.setColor(r2);
        r7.setStrokeWidth(r1);
        r7.setAntiAlias(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSizeChanged(int r2, int r3, int r4, int r5) {
        super/*android.widget.ImageView*/.onSizeChanged(r2, r3, r4, r5);
        float r6 = Math.min(r2, r3) / 2.0f;
        this.d = r6;
        this.e = r6 - (this.c / 2.0f);
        this.b.reset();
        this.b.addCircle(r2 / 2.0f, r3 / 2.0f, this.d, Path.Direction.CW);
    }
}
