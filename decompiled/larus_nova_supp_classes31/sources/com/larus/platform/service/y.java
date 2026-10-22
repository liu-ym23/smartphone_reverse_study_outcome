package com.larus.platform.service;

import com.larus.platform.api.SdkCalendarErrorCode;
import com.larus.platform.api.a5;
import com.larus.platform.api.b5;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class y implements com.larus.platform.api.v1 {
    public static final y a = null;
    public static final Lazy b = null;

    public y() {
    }

    static {
        a = new y();
        b = LazyKt.lazy(new x());
    }

    @Override // com.larus.platform.api.v1
    public final b5 a(a5 r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        com.larus.platform.api.v1 r0 = (com.larus.platform.api.v1) b.getValue();
        if (r0 == null) goto L7;
        b5 r4 = r0.a(r3);
        if (r4 == null) goto L7;
        return r4;
    L7:
        return new b5("calendar service is null", SdkCalendarErrorCode.Unknown);
    }

    @Override // com.larus.platform.api.v1
    public final b5 remove(String r3) {
        Intrinsics.checkNotNullParameter(r3, "eventId");
        com.larus.platform.api.v1 r0 = (com.larus.platform.api.v1) b.getValue();
        if (r0 == null) goto L7;
        b5 r4 = r0.remove(r3);
        if (r4 == null) goto L7;
        return r4;
    L7:
        return new b5("calendar service is null", SdkCalendarErrorCode.Unknown);
    }
}
