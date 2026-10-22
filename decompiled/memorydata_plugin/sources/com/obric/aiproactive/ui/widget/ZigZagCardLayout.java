package com.obric.aiproactive.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/aiproactive/ui/widget/ZigZagCardLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "paint", "Landroid/graphics/Paint;", "path", "Landroid/graphics/Path;", "zigZagHeight", "", "zigZagWidth", "cornerRadius", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ZigZagCardLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Paint f6928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Path f6929b;
    private final float c;
    private final float d;
    private final float e;

    public ZigZagCardLayout(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public ZigZagCardLayout(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public ZigZagCardLayout(Context r4, AttributeSet r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r6);
        Paint r9 = new Paint(1);
        r9.setColor(-1);
        r9.setStyle(Paint.Style.FILL);
        r9.setShadowLayer(8.0f, 0.0f, 4.0f, Color.parseColor("#1A000000"));
        this.f6928a = r9;
        this.f6929b = new Path();
        this.c = 12.0f;
        this.d = 24.0f;
        this.e = 24.0f;
        setWillNotDraw(false);
        setLayerType(1, null);
    }

    public /* synthetic */ ZigZagCardLayout(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    @Override // android.view.View
    public void onDraw(Canvas r7) {
        Intrinsics.checkNotNullParameter(r7, "canvas");
        float r0 = getWidth();
        float r1 = getHeight();
        this.f6929b.reset();
        this.f6929b.moveTo(0.0f, this.e);
        this.f6929b.quadTo(0.0f, 0.0f, this.e, 0.0f);
        this.f6929b.lineTo(r0 - this.e, 0.0f);
        this.f6929b.quadTo(r0, 0.0f, r0, this.e);
        this.f6929b.lineTo(r0, r1 - this.c);
        boolean r2 = true;
    L4:
        if (r0 <= 0.0f) goto L13;
        r0 = r0 - (this.d / 2.0f);
        if (r0 >= 0.0f) goto L8;
        r0 = 0.0f;
    L8:
        Path r3 = this.f6929b;
        if (r2 == false) goto L11;
        r3.lineTo(r0, r1);
    L12:
        r2 = !r2;
        goto L4
    L11:
        r3.lineTo(r0, r1 - this.c);
        goto L12
    L13:
        this.f6929b.lineTo(0.0f, this.e);
        this.f6929b.close();
        r7.drawPath(this.f6929b, this.f6928a);
        super.onDraw(r7);
    }
}
