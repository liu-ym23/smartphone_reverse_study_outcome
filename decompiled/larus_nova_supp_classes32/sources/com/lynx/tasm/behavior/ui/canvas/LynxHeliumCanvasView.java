package com.lynx.tasm.behavior.ui.canvas;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TextureView;
import com.lynx.tasm.base.LLog;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxHeliumCanvasView extends TextureView {
    public WeakReference<LynxHeliumCanvas> a;
    public boolean b;

    public LynxHeliumCanvas getCanvasUI() {
        WeakReference<LynxHeliumCanvas> r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get();
    }

    public LynxHeliumCanvasView(Context r1) {
        super(r1);
    }

    @Override // android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r3) {
        if (getParent() == null) goto L5;
        getParent().requestDisallowInterceptTouchEvent(this.b);
    L7:
        return super.dispatchTouchEvent(r3);
    L5:
        LLog.e("LynxHeliumCanvasView", "requestDisallowInterceptTouchEvent failed, parent is null.");
        goto L7
    }

    @Override // android.view.TextureView, android.view.View
    public void setBackgroundDrawable(Drawable r2) {
        if (r2 == null) goto L4;
        LLog.w("LynxHeliumCanvasView", "TextureView doesn't support displaying a foreground drawable");
    L4:
        super.setBackgroundDrawable(null);
    }

    public void setCanvasUI(LynxHeliumCanvas r2) {
        this.a = new WeakReference(r2);
    }

    public void setConsumeAllEvents(boolean r1) {
        this.b = r1;
    }

    @Override // android.view.TextureView, android.view.View
    public void setForeground(Drawable r2) {
        if (r2 == null) goto L4;
        LLog.w("LynxHeliumCanvasView", "TextureView doesn't support displaying a foreground drawable");
    L4:
        super.setForeground(null);
    }

    public LynxHeliumCanvasView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public LynxHeliumCanvasView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
