package com.bytedance.android.annie.business.lynx;

import kotlin.jvm.internal.Intrinsics;
import q26.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e extends com.bytedance.ies.bullet.lynx.b {
    public e() {
    }

    public final com.bytedance.ies.bullet.lynx.a a(s26.a r10, j r11) {
        Intrinsics.checkNotNullParameter(r10, "service");
        Intrinsics.checkNotNullParameter(r11, "context");
        return new d(r10, r11);
    }

    public final d b(s26.a r10, j r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "service");
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "sessionId");
        return new d(r10, r11, r12);
    }
}
