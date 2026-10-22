package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.dux.drawable.DoubleColorBallAnimationViewNewV2;
import com.bytedance.dux.drawable.DoubleColorBallAnimationViewOld;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class LiveDoubleColorBallAnimationView extends FrameLayout {
    public com.bytedance.dux.drawable.f a;
    public boolean b;

    public final boolean a() {
        com.bytedance.dux.drawable.f r0 = this.a;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isAnimating() == false) goto L7;
        return true;
    }

    public final void b() {
        com.bytedance.dux.drawable.f r0 = this.a;
        if (r0 == null) goto L6;
        r0.f();
        return;
    }

    public final void c() {
        this.a.b();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((this.a instanceof DoubleColorBallAnimationViewNewV2) == false) goto L13;
        if (getParent() != null) goto L7;
    L9:
        ViewGroup.LayoutParams r0 = getLayoutParams();
        if (r0 == null) goto L13;
        r0.width = dm4.a.b(32);
        r0.height = dm4.a.b(32);
        setLayoutParams(r0);
        goto L13
    L7:
        if ((getParent() instanceof ViewGroup) == false) goto L9;
        ((ViewGroup) getParent()).setClipChildren(false);
    L13:
        if (this.b == true) goto L15;
        return;
    L15:
        if (isShown() == false) goto L19;
        b();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    public LiveDoubleColorBallAnimationView(Context r2) {
        this(r2, null);
    }

    public void setCycleBias(int r3) {
        if (((Boolean) j40.v.a.getValue()).booleanValue() == true) goto L8;
        DoubleColorBallAnimationViewOld r0 = this.a;
        if ((r0 instanceof DoubleColorBallAnimationViewOld) == false) goto L9;
        r0.setCycleBias(r3);
        return;
    L9:
        return;
    }

    public void setProgress(float r2) {
        this.a.setProgress(r2);
    }

    public void setProgressBarInfo(int r2) {
        com.bytedance.dux.drawable.f r0 = this.a;
        if (r0 == null) goto L6;
        r0.setProgressBarInfo(r2);
        return;
    }

    public void setStartAnimationAfterAttach(boolean r1) {
        this.b = r1;
    }

    @Override // android.view.View
    public void setVisibility(int r1) {
        super.setVisibility(r1);
        if (r1 != 0) goto L5;
        b();
        return;
    L5:
        c();
    }

    public LiveDoubleColorBallAnimationView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public LiveDoubleColorBallAnimationView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = null;
        j40.v r4 = j40.v.a;
        this.b = !((Boolean) r4.getValue()).booleanValue();
        if (((Boolean) r4.getValue()).booleanValue() == false) goto L5;
        this.a = new DoubleColorBallAnimationViewNewV2(r1, "LiveSdk");
    L6:
        addView((View) this.a);
        return;
    L5:
        this.a = new DoubleColorBallAnimationViewOld(r1);
        goto L6
    }
}
