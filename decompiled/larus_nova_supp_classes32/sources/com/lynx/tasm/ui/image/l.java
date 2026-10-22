package com.lynx.tasm.ui.image;

import com.lynx.tasm.LynxError;
import com.obric.aivoice.core.data.NameKeys;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class l {
    public l() {
    }

    public boolean isPendingLoad() {
        return false;
    }

    public void onImageDstSize(int r1, int r2) {
    }

    public void onImageLoadFailed(String r1) {
    }

    public void onImageLoadFailed(String r1, int r2, int r3) {
    }

    public void onImageLoadSuccess(int r1, int r2) {
    }

    public void onImageStartLoad() {
    }

    public void onImageLoadFailed(LynxError r3, int r4, int r5) {
        if (r3 == null) goto L4;
        String r6 = r3.getSummaryMessage() + ": " + r3.getRootCause();
    L5:
        onImageLoadFailed(r6, r4, r5);
        return;
    L4:
        r6 = NameKeys.UnloadStrategy_No_Strategy;
        goto L5
    }
}
