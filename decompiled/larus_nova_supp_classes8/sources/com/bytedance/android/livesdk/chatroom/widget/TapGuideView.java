package com.bytedance.android.livesdk.chatroom.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class TapGuideView extends SlideGuideView {
    public TapGuideView(Context r3) {
        super(r3);
        LinearLayout.LayoutParams r4 = (LinearLayout.LayoutParams) this.a.getLayoutParams();
        r4.width = com.bytedance.android.live.core.utils.s1.f(160.0f);
        r4.height = com.bytedance.android.live.core.utils.s1.f(160.0f);
        this.a.setLayoutParams(r4);
    }

    public void setMultiLine(boolean r2) {
        this.c.setSingleLine(!r2);
    }

    public TapGuideView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public TapGuideView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
