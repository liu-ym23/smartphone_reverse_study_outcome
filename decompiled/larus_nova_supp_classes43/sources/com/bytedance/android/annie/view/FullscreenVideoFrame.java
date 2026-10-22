package com.bytedance.android.annie.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class FullscreenVideoFrame extends FrameLayout {
    public a a;

    public interface a {
        void onHideFullscreenVideoFrame();
    }

    public FullscreenVideoFrame(Context r1) {
        super(r1);
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    public void setListener(a r1) {
        this.a = r1;
    }

    public FullscreenVideoFrame(Context r1, AttributeSet r10) {
        super(r1, r10);
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int r10, KeyEvent r11) {
        if (r10 != 4) goto L10;
        a r12 = this.a;
        if (r12 == null) goto L11;
        r12.onHideFullscreenVideoFrame();
        return true;
    L11:
        return true;
    L10:
        return super.onKeyDown(r10, r11);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int r10, KeyEvent r11) {
        if (r10 != 4) goto L7;
        return true;
    L7:
        return super.onKeyUp(r10, r11);
    }

    public FullscreenVideoFrame(Context r1, AttributeSet r10, int r11) {
        super(r1, r10, r11);
        setFocusable(true);
        setFocusableInTouchMode(true);
    }
}
