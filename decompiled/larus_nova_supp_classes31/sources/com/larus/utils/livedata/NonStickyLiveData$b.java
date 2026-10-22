package com.larus.utils.livedata;

import androidx.lifecycle.Observer;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class NonStickyLiveData$b<T> implements Observer<T> {
    public final Observer<? super T> a;
    public final int b;
    public final /* synthetic */ NonStickyLiveData<T> c;

    public final void onChanged(T r3) {
        if (this.b < this.c.a) goto L5;
        return;
    L5:
        Observer<? super T> r0 = this.a;
        if (r0 == null) goto L9;
        r0.onChanged(r3);
        return;
    }

    public NonStickyLiveData$b(NonStickyLiveData r1, Observer<? super T> r2) {
        this.c = r1;
        this.a = r2;
        this.b = r1.a;
    }
}
