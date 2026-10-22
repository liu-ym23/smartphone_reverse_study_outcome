package com.larus.chat.gallery.impl.preview.datasource;

import androidx.lifecycle.LiveData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ f a;

    public /* synthetic */ e(f r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f r0 = this.a;
        r0.e.removeObserver(r0.g);
        LiveData<Integer> r1 = r0.f;
        if (r1 == null) goto L6;
        r1.removeObserver(r0.h);
        return;
    }
}
