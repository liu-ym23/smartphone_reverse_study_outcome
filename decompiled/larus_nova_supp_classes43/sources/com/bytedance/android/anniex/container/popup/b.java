package com.bytedance.android.anniex.container.popup;

import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements e {
    public final /* synthetic */ e a;
    public final /* synthetic */ SheetBaseDialog b;

    @Override // com.bytedance.android.anniex.container.popup.e
    public final boolean disableDragDown() {
        if (this.a.disableDragDown() == true) goto L10;
        SheetBaseDialog r0 = this.b;
        if (r0.h == false) goto L10;
        if (r0.b == true) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // com.bytedance.android.anniex.container.popup.e
    public final boolean a(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        return this.a.a(r10);
    }

    @Override // com.bytedance.android.anniex.container.popup.e
    public final boolean shouldInterceptSlide(int r10) {
        return this.a.shouldInterceptSlide(r10);
    }

    public b(e r1, SheetBaseDialog r10) {
        this.a = r1;
        this.b = r10;
    }
}
