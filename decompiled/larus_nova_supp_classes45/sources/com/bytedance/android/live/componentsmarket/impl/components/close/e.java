package com.bytedance.android.live.componentsmarket.impl.components.close;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e extends TouchDelegate {
    @Override // android.view.TouchDelegate
    public final boolean onTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        return super.onTouchEvent(r2);
    }

    public e(Rect r1, View r2) {
        super(r1, r2);
    }
}
