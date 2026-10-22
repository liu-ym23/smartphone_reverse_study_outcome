package com.bytedance.android.livesdk.event;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e0 extends d0 {

    public static final class a {
    }

    static {
    }

    public e0() {
        throw null;
    }

    public e0(String r9, ISendCommentEvent.Sender r10, Map r11) {
        Intrinsics.checkNotNullParameter(r9, "vsContent");
        Intrinsics.checkNotNullParameter(r10, "vsSender");
        Intrinsics.checkNotNullParameter(r11, "vsArgs");
        super(r9, r10, r11, null, null, false, 32);
    }
}
