package com.larus.dora.impl.log;

import kotlin.jvm.internal.Intrinsics;
import t39.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class m implements w {
    public final /* synthetic */ String a;

    public m(String r1) {
        this.a = r1;
    }

    public final void a(boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "msg");
        g49.d.d("DoraLogManager", "upload log " + this.a + ". success: " + r3 + ", msg: " + r4);
    }
}
