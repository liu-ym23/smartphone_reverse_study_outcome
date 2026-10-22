package com.bytedance.android.live.initialize.scheduler;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends Handler {
    public final /* synthetic */ WTOTaskScheduler a;

    @Override // android.os.Handler
    public final void handleMessage(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        super.handleMessage(r2);
        if (r2.what != 10000001) goto L6;
        this.a.k.invoke();
        return;
    }

    public a(WTOTaskScheduler r1, Looper r2) {
        this.a = r1;
        super(r2);
    }
}
