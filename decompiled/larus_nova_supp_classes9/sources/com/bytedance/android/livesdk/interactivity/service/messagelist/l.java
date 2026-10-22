package com.bytedance.android.livesdk.interactivity.service.messagelist;

import io.reactivex.subjects.PublishSubject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l {
    public int a;
    public final PublishSubject<Integer> b;
    public final int c;
    public final PublishSubject<Integer> d;
    public IMessageListManager.b e;
    public long f;
    public boolean g;

    public l() {
        this.b = PublishSubject.create();
        this.c = -1;
        this.d = PublishSubject.create();
        this.g = true;
    }

    public final void a(int r2) {
        if (r2 != this.a) goto L5;
        return;
    L5:
        this.a = r2;
        this.b.onNext(Integer.valueOf(r2));
    }

    public final void onEvent(IMessageListManager.a r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        if (r4.getType() != IMessageListManager.MessageChangeType.INSERT_BOTTOM) goto L12;
        c r5 = r4.e;
        if (r5 != null) goto L7;
        return;
    L7:
        if (r5.a() != true) goto L14;
        this.f = System.currentTimeMillis();
        if (this.g == false) goto L15;
        a(this.a + 1);
        return;
    L15:
        return;
    L14:
        return;
    }
}
