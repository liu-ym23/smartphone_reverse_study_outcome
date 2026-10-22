package com.bytedance.android.livesdk.chatroom.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.s1;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010$\u001a\u00020#\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\b\b\u0002\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*R\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\"\u0010\u0017\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\u001b\u0010\u001a\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006+"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/view/VSLinkedAvatarContainer;", "Landroid/widget/FrameLayout;", "Landroid/graphics/Paint;", "a", "Lkotlin/Lazy;", "getMPaint", "()Landroid/graphics/Paint;", "mPaint", "", "b", "F", "getCenterX", "()F", "setCenterX", "(F)V", "centerX", "c", "getCenterY", "setCenterY", "centerY", "d", "getRadius", "setRadius", "radius", "e", "getMCirclePaint", "mCirclePaint", "", "f", "Z", "getEnableCircle", "()Z", "setEnableCircle", "(Z)V", "enableCircle", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSLinkedAvatarContainer extends FrameLayout {
    public static final /* synthetic */ int g = 0;
    public final Lazy a;
    public float b;
    public float c;
    public float d;
    public final Lazy e;
    public boolean f;

    public VSLinkedAvatarContainer(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public VSLinkedAvatarContainer(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final Paint getMCirclePaint() {
        return (Paint) this.e.getValue();
    }

    private final Paint getMPaint() {
        return (Paint) this.a.getValue();
    }

    public static float a() {
        Resources r0 = s1.getContext().getApplicationContext().getResources();
        return (WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density * 1) + 0.5f;
    }

    public final float getCenterX() {
        return this.b;
    }

    public final float getCenterY() {
        return this.c;
    }

    public final boolean getEnableCircle() {
        return this.f;
    }

    public final float getRadius() {
        return this.d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        super.dispatchDraw(r2);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        super.onDraw(r5);
        if (this.f == false) goto L6;
        r5.drawCircle(getWidth() / 2, getHeight() / 2, (getWidth() / 2) - a(), getMCirclePaint());
        return;
    }

    public final void setCenterX(float r1) {
        this.b = r1;
    }

    public final void setCenterY(float r1) {
        this.c = r1;
    }

    public final void setEnableCircle(boolean r1) {
        this.f = r1;
    }

    public final void setRadius(float r1) {
        this.d = r1;
    }

    public VSLinkedAvatarContainer(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LazyThreadSafetyMode r5 = LazyThreadSafetyMode.NONE;
        this.a = LazyKt.lazy(r5, VSLinkedAvatarContainer$mPaint$2.INSTANCE);
        this.e = LazyKt.lazy(r5, new VSLinkedAvatarContainer$mCirclePaint$2(this));
        setWillNotDraw(false);
        setLayerType(2, null);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas r5, View r6, long r7) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        if (r6 == null) goto L5;
        Object r0 = r6.getTag();
    L7:
        if (Intrinsics.areEqual(r0, "living_view") == false) goto L13;
        float r1 = this.d;
        if (r1 <= 0) goto L14;
        r5.drawCircle(this.b, this.c, r1, getMPaint());
    L14:
        return super.drawChild(r5, r6, r7);
    L13:
        return super.drawChild(r5, r6, r7);
    L5:
        r0 = null;
        goto L7
    }

    public /* synthetic */ VSLinkedAvatarContainer(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
