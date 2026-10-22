package com.bytedance.android.live.room.api.visibilitycontrol;

import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public Disposable a;
    public final PublishSubject b;
    public final PublishSubject c;

    public final void a() {
        Disposable r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if ((!r0.isDisposed()) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L12;
        r0.dispose();
        return;
    }

    public f() {
        PublishSubject r0 = PublishSubject.create();
        this.b = r0;
        this.c = r0;
    }
}
