package com.bytedance.android.live.search.impl.search;

import android.view.MotionEvent;
import android.widget.EditText;
import com.bytedance.android.live.search.impl.search.viewmodel.LiveSearchIntermediateViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class q implements LiveSearchIntermediateView.b {
    public final /* synthetic */ LiveSearchResultFragment a;

    public q(LiveSearchResultFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.search.impl.search.LiveSearchIntermediateView.b
    public final void c(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "ev");
        if (r2.getActionMasked() != 0) goto L12;
        LiveSearchIntermediateViewModel r3 = this.a.p;
        if (r3 != null) goto L7;
        return;
    L7:
        if (r3.canDismissKeyboardOnActionDown() != true) goto L14;
        int r4 = com.bytedance.android.live.search.impl.search.helper.a.a;
        com.bytedance.android.live.search.impl.search.helper.a.a(this.a.g);
        EditText r5 = this.a.g;
        if (r5 == null) goto L15;
        r5.setCursorVisible(false);
        return;
    L15:
        return;
    L14:
        return;
    }
}
