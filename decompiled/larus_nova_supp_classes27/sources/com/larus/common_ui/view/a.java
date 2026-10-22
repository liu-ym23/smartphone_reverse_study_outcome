package com.larus.common_ui.view;

import android.view.MotionEvent;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class a implements View.OnTouchListener {
    public final /* synthetic */ View a;

    public /* synthetic */ a(View r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r2, MotionEvent r3) {
        View r4 = this.a;
        int r0 = BottomOverlayView.g;
        Intrinsics.checkNotNull(r3);
        MotionEvent r5 = MotionEvent.obtain(r3);
        r4.dispatchTouchEvent(r5);
        r5.recycle();
        return true;
    }
}
