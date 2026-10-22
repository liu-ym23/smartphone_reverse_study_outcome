package com.larus.bmhome.chat.standarduikit.localfileblock.viewmodel;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g implements vl8.f {
    public final /* synthetic */ h a;

    public g(h r1) {
        this.a = r1;
    }

    @Override // vl8.f
    public final void a(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        h r0 = this.a;
        a r1 = r0.a;
        if (r1 == null) goto L8;
        b r2 = r0.b;
        if (r2 == null) goto L9;
        r2.b(r3, r1);
        return;
    L9:
        return;
    }

    @Override // vl8.f
    public final void b(Context r3, vl8.d r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "onStateChanged");
        h r0 = this.a;
        a r1 = r0.a;
        if (r1 == null) goto L8;
        b r2 = r0.b;
        if (r2 == null) goto L9;
        r2.c(r3, r1, r4);
        return;
    L9:
        return;
    }
}
