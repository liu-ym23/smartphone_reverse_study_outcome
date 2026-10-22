package com.facebook.drawee.generic;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.facebook.common.logging.FLogDefaultLoggingDelegate;
import com.facebook.drawee.components.DraweeEventTracker;
import com.facebook.drawee.debug.DebugControllerOverlayDrawable;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.VisibilityAwareDrawable;
import com.facebook.drawee.view.DraweeHolder;

/* JADX INFO: loaded from: classes2.dex */
public class RootDrawable extends ForwardingDrawable implements VisibilityAwareDrawable {
    public DebugControllerOverlayDrawable d;
    public DraweeHolder e;

    public RootDrawable(Drawable r5) {
        super(r5);
        this.d = null;
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas r10) {
        if (isVisible() == false) goto L22;
        DraweeHolder r5 = this.e;
        if (r5 != null) goto L8;
    L14:
        Drawable r11 = this.f7847a;
        if (r11 == null) goto L17;
        r11.draw(r10);
    L17:
        DebugControllerOverlayDrawable r12 = this.d;
        if (r12 == null) goto L21;
        r12.setBounds(getBounds());
        this.d.draw(r10);
        return;
    L21:
        return;
    L8:
        if (r5.f7936a == true) goto L14;
        Object[] r13 = {Integer.valueOf(System.identityHashCode(r5)), Integer.valueOf(System.identityHashCode(r5.e)), r5.toString()};
        if (FLogDefaultLoggingDelegate.f7658a.a(5) == false) goto L13;
        String r14 = String.format(null, "%x: Draw requested for a non-attached controller %x. %s", r13);
        Log.println(5, FLogDefaultLoggingDelegate.a("DraweeEventTracker"), r14);
    L13:
        r5.f7937b = true;
        r5.f7938c = true;
        r5.b();
        goto L14
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return -1;
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return -1;
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public final boolean setVisible(boolean r5, boolean r10) {
        DraweeHolder r11 = this.e;
        if (r11 == null) goto L13;
        if (r11.f7938c == r5) goto L13;
        DraweeEventTracker r12 = r11.f;
        if (r5 == false) goto L10;
        DraweeEventTracker.Event r13 = DraweeEventTracker.Event.f7769q;
    L11:
        r12.a(r13);
        r11.f7938c = r5;
        r11.b();
        goto L13
    L10:
        r13 = DraweeEventTracker.Event.f7770r;
    L13:
        return super.setVisible(r5, r10);
    }
}
