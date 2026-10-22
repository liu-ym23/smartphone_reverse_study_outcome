package com.ss.android.lark.desktopmode.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class DrawerContainerView extends FrameLayout {
    public DrawerContainerView(Context r1) {
        super(r1);
    }

    @Override // android.view.View
    public final boolean onGenericMotionEvent(MotionEvent r4) {
        if ((r4.getSource() & 2) == 0) goto L12;
        if (r4.getButtonState() != 2) goto L7;
    L10:
        return true;
    L7:
        if (r4.getAction() == 8) goto L10;
        return super.onGenericMotionEvent(r4);
    L12:
        return super.onGenericMotionEvent(r4);
    }

    public DrawerContainerView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public DrawerContainerView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
