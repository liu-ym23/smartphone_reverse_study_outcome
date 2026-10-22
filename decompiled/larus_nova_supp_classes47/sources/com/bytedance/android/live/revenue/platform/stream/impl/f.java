package com.bytedance.android.live.revenue.platform.stream.impl;

import android.view.PixelCopy;
import io.reactivex.subjects.SingleSubject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f implements PixelCopy.OnPixelCopyFinishedListener {
    public final /* synthetic */ SingleSubject a;

    public f(SingleSubject r1) {
        this.a = r1;
    }

    @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
    public final void onPixelCopyFinished(int r2) {
        this.a.onSuccess(Integer.valueOf(r2));
    }
}
