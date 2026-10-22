package com.larus.platform.service;

import com.google.gson.JsonObject;
import com.larus.platform.api.IAppletJsbEventService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class k implements IAppletJsbEventService {
    public static final k a = null;
    public static final Lazy b = null;

    public k() {
    }

    static {
        a = new k();
        b = LazyKt.lazy(new j());
    }

    @Override // com.larus.platform.api.IAppletJsbEventService
    public final void a(IAppletJsbEventService.TriggeredEvent r2, JsonObject r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        IAppletJsbEventService r0 = (IAppletJsbEventService) b.getValue();
        if (r0 == null) goto L6;
        r0.a(r2, r3);
        return;
    }
}
