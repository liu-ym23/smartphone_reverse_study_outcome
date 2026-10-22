package com.obric.assistant.ipc;

import kotlin.jvm.internal.Intrinsics;
import n38.a;
import n38.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class i implements j {
    public final /* synthetic */ k a;

    public i(k r1) {
        this.a = r1;
    }

    public final void a(a r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        k r0 = this.a;
        String r5 = "account_offline:" + r4.c + ':' + r4.d;
        r0.getClass();
        k.a(r5);
    }

    public final void b(a r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        k r0 = this.a;
        String r5 = "account_online:" + r4.c + ':' + r4.d;
        r0.getClass();
        k.b(r5);
    }
}
