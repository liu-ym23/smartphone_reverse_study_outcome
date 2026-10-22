package com.ss.android.lark.chat.chatwindow.chat.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.log.Log;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 $2\u00020\u0001:\u0001$B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u000bJ\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rJ(\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\rH\u0014J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020\u0000J\u0006\u0010#\u001a\u00020\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/view/IMCircleLoadingView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "paint", "Landroid/graphics/Paint;", "strokeWidth", BuildConfig.FLAVOR, "color", BuildConfig.FLAVOR, "rectF", "Landroid/graphics/RectF;", "paintShader", "Landroid/graphics/SweepGradient;", "loadingAnimator", "Landroid/animation/ObjectAnimator;", "setCircleStrokeWidth", "width", "setCircleColor", "onSizeChanged", BuildConfig.FLAVOR, SRStrategy.MEDIAINFO_KEY_WIDTH, "h", "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "isRunning", BuildConfig.FLAVOR, "startLoading", "stopLoading", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IMCircleLoadingView extends View {
    public final Paint a;
    public final float b;
    public final int c;
    public final RectF d;
    public ObjectAnimator e;

    public static final class a {
    }

    static {
    }

    public final void a() {
        if (getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        setVisibility(0);
    L9:
        if (this.e == null) goto L27;
        return;
    L27:
        ObjectAnimator r1 = ObjectAnimator.ofFloat(this, "rotation", new float[]{0.0f, 360.0f});     // Catch: Throwable -> L24
        this.e = r1;     // Catch: Throwable -> L24
        if (r1 == null) goto L14;
        r1.setDuration(1000);     // Catch: Throwable -> L24
    L14:
        ObjectAnimator r2 = this.e;     // Catch: Throwable -> L24
        if (r2 == null) goto L17;
        r2.setInterpolator(new LinearInterpolator());     // Catch: Throwable -> L24
    L17:
        ObjectAnimator r3 = this.e;     // Catch: Throwable -> L24
        if (r3 == null) goto L20;
        r3.setRepeatCount(-1);     // Catch: Throwable -> L24
    L20:
        ObjectAnimator r4 = this.e;     // Catch: Throwable -> L24
        if (r4 == null) goto L29;
        r4.start();     // Catch: Throwable -> L24
        return;
    L29:
        return;
    L24:
        th = move-exception;
        Log.e("IMCircleLoadingView", "startLoading error: " + th.getMessage());
        this.e = null;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void b() {
        if (getVisibility() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L10;
        setVisibility(8);
    L10:
        if (this.e != null) goto L12;
        return;
    L12:
        setVisibility(8);
        ObjectAnimator r1 = this.e;
        if (r1 == null) goto L22;
        r1.cancel();     // Catch: Throwable -> L16
    L18:
        this.e = null;
        return;
    L16:
        th = move-exception;
        Log.e("IMCircleLoadingView", "stopLoading error: " + th.getMessage());
        goto L18
    L22:
        return;
    L5:
        r0 = false;
        goto L7
    }

    public IMCircleLoadingView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r8) {
        Intrinsics.checkNotNullParameter(r8, "canvas");
        super.onDraw(r8);
        r8.drawArc(this.d, 0.0f, 360.0f, false, this.a);
    }

    public IMCircleLoadingView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        Paint r5 = new Paint(1);
        this.a = r5;
        this.b = 10.0f;
        this.c = ColorProtector.parseColor("#4A90E2");
        this.d = new RectF();
        float r0 = UIUtils.dp2px(r3, 3.0f);
        this.b = r0;
        this.c = UIUtils.getColor(r3, 2131102421);
        r5.setStyle(Paint.Style.STROKE);
        r5.setStrokeWidth(r0);
        r5.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r6, int r7, int r8, int r9) {
        super.onSizeChanged(r6, r7, r8, r9);
        float r10 = r6;
        float r11 = r7;
        int r3 = this.c;
        this.a.setShader(new SweepGradient(r10 / 2.0f, r11 / 2.0f, new int[]{0, 0, r3, r3}, new float[]{0.0f, 0.25f, 0.9f, 1.0f}));
        RectF r12 = this.d;
        float r13 = this.b;
        r12.set(r13, r13, r10 - r13, r11 - r13);
    }
}
