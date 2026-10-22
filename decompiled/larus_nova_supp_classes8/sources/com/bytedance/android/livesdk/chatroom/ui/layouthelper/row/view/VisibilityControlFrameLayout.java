package com.bytedance.android.livesdk.chatroom.ui.layouthelper.row.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class VisibilityControlFrameLayout extends FrameLayout {
    public final boolean a;

    public VisibilityControlFrameLayout(Context r1) {
        super(r1);
        this.a = true;
    }

    @Override // android.view.View
    public void setVisibility(int r2) {
        boolean r0 = this.a;
        super.setVisibility(r2);
    }

    public VisibilityControlFrameLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = true;
    }

    public VisibilityControlFrameLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = true;
    }
}
