package com.bytedance.android.live.ktv.common.ordersong.feedback;

import com.bytedance.android.live.core.utils.d2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g extends d2 {
    public final /* synthetic */ KtvFeedbackDialog a;

    public g(KtvFeedbackDialog r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.core.utils.d2, android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        if (r1 == null) goto L7;
        String r5 = r1.toString();
        if (r5 == null) goto L8;
        KtvFeedbackDialog r6 = this.a;
        r6.n = r5;
        r6.Z90();
        return;
    L8:
        return;
    }
}
