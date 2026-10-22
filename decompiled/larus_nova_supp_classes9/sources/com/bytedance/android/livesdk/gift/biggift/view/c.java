package com.bytedance.android.livesdk.gift.biggift.view;

import android.view.MotionEvent;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements View.OnTouchListener {
    public final /* synthetic */ BigGiftComboDialog a;

    public c(BigGiftComboDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r2, MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r2, "v");
        Intrinsics.checkNotNullParameter(r3, "event");
        return this.a.r.b(r2, r3);
    }
}
