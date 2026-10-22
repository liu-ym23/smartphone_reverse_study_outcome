package com.bytedance.android.live.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RemoteViews;
import com.bytedance.android.live.ILiveCheckDraw;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@RemoteViews.RemoteView
public class LiveFrameLayout extends FrameLayout {
    public LiveFrameLayout(Context r1) {
        super(r1);
    }

    public LiveFrameLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public LiveFrameLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas r2, View r3, long r4) {
        if (ILiveCheckDraw.a(r3) == true) goto L5;
    L7:
        return false;
    L5:
        if (super.drawChild(r2, r3, r4) == false) goto L7;
        return true;
    }
}
