package com.larus.photopicker.v2.impl;

import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class w implements Runnable {
    public final /* synthetic */ FrameLayout a;

    public /* synthetic */ w(FrameLayout r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FrameLayout r0 = this.a;
        int r1 = BottomPhotoPickerFragmentV3.C;
        if (r0.getChildCount() != 0) goto L11;
        ViewParent r2 = r0.getParent();
        if ((r2 instanceof ViewGroup) == false) goto L7;
        ViewGroup r3 = (ViewGroup) r2;
    L8:
        if (r3 == null) goto L12;
        r3.removeView(r0);
        return;
    L12:
        return;
    L7:
        r3 = null;
        goto L8
    }
}
