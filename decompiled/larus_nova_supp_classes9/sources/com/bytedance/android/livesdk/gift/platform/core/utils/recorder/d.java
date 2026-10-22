package com.bytedance.android.livesdk.gift.platform.core.utils.recorder;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d {
    public final ErrorNo a;
    public final String b;

    public final String toString() {
        return "[" + this.a + "]:" + this.b;
    }

    public d(ErrorNo r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "errCode");
        Intrinsics.checkNotNullParameter(r3, "errTitle");
        this.a = r2;
        this.b = r3;
    }
}
