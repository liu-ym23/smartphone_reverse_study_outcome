package com.larus.suggest.impl.wcb.request;

import com.larus.platform.model.chat.x;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import hx9.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public final l a;
    public final x b;
    public volatile boolean c;
    public volatile fx9.b d;

    public a(hx9.a r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = z2.a.H3();
        this.c = true;
    }

    public final void a(fx9.b r4) {
        Intrinsics.checkNotNullParameter(r4, "inputType");
        if (this.c == false) goto L6;
        this.d = r4;
        FLogger.a.i("WcbLog", "input triggered: " + r4.a);
        return;
    }
}
