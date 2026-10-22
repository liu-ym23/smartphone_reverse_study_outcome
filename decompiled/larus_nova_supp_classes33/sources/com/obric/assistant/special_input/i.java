package com.obric.assistant.special_input;

import com.obric.capabilitykit.common.ErrorCode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class i {
    public static final t0 a(t0 r10, Integer r11) {
        Intrinsics.checkNotNullParameter(r10, "currentState");
        if (r11 != null) goto L7;
        return t0.a(r10, false, false, false, false, 0, false, false, 63);
    L7:
        return t0.a(r10, false, false, false, false, r11.intValue(), true, true, 15);
    }

    public static final t0 b(t0 r10, Boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "currentState");
        if (r11 != null) goto L7;
        return t0.a(r10, false, false, false, false, 0, false, false, 119);
    L7:
        return t0.a(r10, r11.booleanValue(), true, true, true, 0, false, false, ErrorCode.DEVICE_LOCK_ERROR);
    }
}
