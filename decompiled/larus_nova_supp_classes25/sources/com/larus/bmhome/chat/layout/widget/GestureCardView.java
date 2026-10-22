package com.larus.bmhome.chat.layout.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.google.android.material.card.MaterialCardView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001 B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001fH\u0016R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0019R\u0012\u0010\u001a\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0019R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larus/bmhome/chat/layout/widget/GestureCardView;", "Lcom/google/android/material/card/MaterialCardView;", "Lcom/larus/common_ui/widget/ILastMotionView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lastMotionX", "", "getLastMotionX", "()Ljava/lang/Float;", "lastMotionY", "getLastMotionY", "lastMotionGesture", "Lcom/larus/common_ui/widget/LastMotionViewDelegate;", "isLongPressTriggered", "", "handler", "Landroid/os/Handler;", "touchSlop", "lastDownX", "Ljava/lang/Float;", "lastDownY", "longPressRunnable", "Ljava/lang/Runnable;", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class GestureCardView extends MaterialCardView implements z19.j {
    public final z19.r a;
    public boolean b;
    public final Handler c;
    public final int d;
    public Float e;
    public Float f;
    public final g0 g;

    public static final class a {
    }

    static {
    }

    public GestureCardView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public GestureCardView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public Float getLastMotionX() {
        return this.a.a;
    }

    public Float getLastMotionY() {
        return this.a.b;
    }

    public final boolean onInterceptTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "ev");
        int r0 = r5.getAction();
        if (r0 != 0) goto L5;
        this.e = Float.valueOf(r5.getX());
        this.f = Float.valueOf(r5.getY());
        this.b = false;
        this.c.postDelayed(this.g, ViewConfiguration.getLongPressTimeout());
    L22:
        this.a.a(r5);
        return this.b;
    L5:
        if (r0 != 1) goto L7;
        this.e = null;
        this.f = null;
        this.c.removeCallbacks(this.g);
        goto L22
    L7:
        if (r0 != 2) goto L9;
        Float r1 = this.e;
        Float r2 = this.f;
        if (r1 != null) goto L15;
    L16:
        if (r2 == null) goto L22;
        if (Math.abs(r5.getY() - r2.floatValue()) <= this.d) goto L22;
    L19:
        this.c.removeCallbacks(this.g);
        goto L22
    L15:
        if (Math.abs(r5.getX() - r1.floatValue()) > this.d) goto L19;
    L9:
        if (r0 == 3) goto L11;
        FLogger.a.d("SlopXXX", "event: " + r5.getAction() + ", x: " + r5.getX() + ", y: " + r5.getY());
        goto L22
    L11:
        this.c.removeCallbacks(this.g);
        goto L22
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.larus.bmhome.chat.layout.widget.g0] */
    public GestureCardView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new z19.r();
        this.c = new Handler(Looper.getMainLooper());
        this.d = ViewConfiguration.get(r2).getScaledTouchSlop();
        this.g = new g0(this);
    }

    public /* synthetic */ GestureCardView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
