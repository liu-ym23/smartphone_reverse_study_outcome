package com.bytedance.android.livesdk.interactivity.chatchannel.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.c;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/view/ChatChannelBlurView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChatChannelBlurView extends FrameLayout {
    public ChatChannelBlurView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ChatChannelBlurView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "ev");
        return true;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        View r0 = findViewById(2131380211);
        View r1 = findViewById(2131371619);
        if (c.i == false) goto L8;
        if (r0 == null) goto L6;
        r0.setVisibility(8);
    L6:
        if (r1 == null) goto L13;
        r1.setVisibility(0);
        return;
    L13:
        return;
    L8:
        if (r0 == null) goto L10;
        r0.setVisibility(0);
    L10:
        if (r1 == null) goto L15;
        r1.setVisibility(8);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        super.onDraw(r2);
        ALogger.i("ChatChannelBlurView", "onDraw");
    }

    public ChatChannelBlurView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        TypedArray r5 = r2.obtainStyledAttributes(r3, new int[]{2130969026, 2130969815, 2130975001});
        int r6 = r5.getInt(0, 12);
        r5.recycle();
        if (c.i == false) goto L6;
        float r7 = r6;
        setRenderEffect(RenderEffect.createBlurEffect(r7, r7, Shader.TileMode.CLAMP));
        setWillNotDraw(false);
        setLayerType(2, null);
        return;
    }

    public /* synthetic */ ChatChannelBlurView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
