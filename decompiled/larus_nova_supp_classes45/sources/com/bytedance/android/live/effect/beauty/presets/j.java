package com.bytedance.android.live.effect.beauty.presets;

import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ LiveBeautyPresetsFragment a;

    public j(LiveBeautyPresetsFragment r1) {
        this.a = r1;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "e");
        LiveBeautyPresetsFragment r0 = this.a;
        int r1 = LiveBeautyPresetsFragment.C;
        if (r0.U90().c == false) goto L11;
        RecyclerView r2 = this.a.l;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L8:
        if (r2.findChildViewUnder(r4.getX(), r4.getY()) != null) goto L11;
        this.a.U90().B2(false);
        return true;
    L11:
        return false;
    }
}
