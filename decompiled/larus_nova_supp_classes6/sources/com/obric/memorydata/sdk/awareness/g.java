package com.obric.memorydata.sdk.awareness;

import android.os.IBinder;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class g implements Function0 {
    public final /* synthetic */ IBinder a;
    public final /* synthetic */ IBinder.DeathRecipient b;

    public /* synthetic */ g(IBinder r1, f r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        return Boolean.valueOf(this.a.unlinkToDeath(this.b, 0));
    }
}
