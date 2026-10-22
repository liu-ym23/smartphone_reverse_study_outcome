package com.obric.assistant;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class h4 implements OnApplyWindowInsetsListener {
    public /* synthetic */ h4() {
    }

    public final WindowInsetsCompat onApplyWindowInsets(View r8, WindowInsetsCompat r9) {
        int r0 = ObricUIServiceImpl.b;
        Intrinsics.checkNotNullParameter(r8, "target");
        Intrinsics.checkNotNullParameter(r9, "insets");
        int r1 = r9.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
        if (r8.getPaddingBottom() == r1) goto L5;
        int r2 = r8.getPaddingStart();
        int r3 = r8.getPaddingTop();
        int r4 = r8.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r8.getClass().getSimpleName() + ",source:Obric side bar navigation insets,start:" + r2 + ",top:" + r3 + ",end:" + r4 + ",bottom:" + r1);
        r8.setPaddingRelative(r2, r3, r4, r1);
    L5:
        return r9;
    }
}
