package com.bytedance.ai.bridge.method.system.location;

import com.bytedance.ai.event.MessageIndication;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i {
    public final /* synthetic */ f3.h<Object> a;

    public final void a() {
        Intrinsics.checkNotNullParameter("openLocation not supported", MessageIndication.MESSAGE_TYPE_MSG);
        f3.h<Object> r0 = this.a;
        int r10 = LocationAuthorization.a;
        f3.h.a.a(r0, "openLocation not supported", null, LocationAuthorization.b("openLocation not supported", 0), 6);
    }

    public i(f3.h<Object> r1) {
        this.a = r1;
    }
}
