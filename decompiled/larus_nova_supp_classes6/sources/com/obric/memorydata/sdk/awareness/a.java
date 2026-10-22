package com.obric.memorydata.sdk.awareness;

import android.os.IBinder;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class a implements Function0 {
    public final /* synthetic */ e.a a;

    public /* synthetic */ a(e.a r1) {
        this.a = r1;
    }

    public final Object invoke() {
        e.a r0 = this.a;
        IBinder.DeathRecipient r1 = r0.d;
        if (r1 == null) goto L7;
        IBinder r2 = r0.c;
        if (r2 == null) goto L7;
        return Boolean.valueOf(r2.unlinkToDeath(r1, 0));
    L7:
        return null;
    }
}
