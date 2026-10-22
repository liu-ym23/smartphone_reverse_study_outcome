package com.larus.commercecredit.impl.page;

import android.view.View;
import android.webkit.WebView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class u extends BottomSheetBehavior.BottomSheetCallback {
    public final /* synthetic */ CommerceCreditWebFragment a;

    public final void onSlide(View r1, float r2) {
        Intrinsics.checkNotNullParameter(r1, "bottomSheet");
    }

    public u(CommerceCreditWebFragment r1) {
        this.a = r1;
    }

    public final void onStateChanged(View r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "bottomSheet");
        FLogger.a.d("CommerceCreditWebFragment", "BottomSheet state changed: " + r4);
        WebView r5 = this.a.g;
        if (r5 == null) goto L6;
        r5.setTag(2131388155, Boolean.FALSE);
    L6:
        if (r4 != 5) goto L9;
        this.a.y();
        return;
    }
}
