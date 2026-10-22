package com.bytedance.android.live.livepkaudience.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/view/DisallowTouchEventFrameLayout;", "Landroid/widget/FrameLayout;", "", "a", "I", "getBlockYTop", "()I", "setBlockYTop", "(I)V", "blockYTop", "b", "getBlockYBottom", "setBlockYBottom", "blockYBottom", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DisallowTouchEventFrameLayout extends FrameLayout {
    public int a;
    public int b;

    public DisallowTouchEventFrameLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DisallowTouchEventFrameLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final int getBlockYBottom() {
        return this.b;
    }

    public final int getBlockYTop() {
        return this.a;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r3) {
        if (r3 == null) goto L4;
        Integer r0 = Integer.valueOf(r3.getAction());
    L5:
        if (r0 != null) goto L8;
    L10:
        if (r0 != null) goto L13;
    L25:
        return super.onInterceptTouchEvent(r3);
    L13:
        if (r0.intValue() != 2) goto L25;
    L14:
        int r1 = this.a;
        if (r1 < 0) goto L25;
        int r2 = this.b;
        if (r2 < 0) goto L25;
        if (r2 <= r1) goto L25;
        if (r3.getY() <= this.a) goto L25;
        if (r3.getY() >= this.b) goto L25;
        requestDisallowInterceptTouchEvent(true);
        goto L25
    L8:
        if (r0.intValue() != 0) goto L10;
    L4:
        r0 = null;
        goto L5
    }

    public final void setBlockYBottom(int r1) {
        this.b = r1;
    }

    public final void setBlockYTop(int r1) {
        this.a = r1;
    }

    public DisallowTouchEventFrameLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ DisallowTouchEventFrameLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
