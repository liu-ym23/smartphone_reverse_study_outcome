package com.larus.community.impl.update;

import com.larus.platform.api.l4;
import com.larus.platform.api.z3;
import com.larus.platform.service.q3;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class j implements l4 {
    public final /* synthetic */ String a;

    public j(String r1) {
        this.a = r1;
    }

    public final void a(String r8, com.larus.video.impl.sdk.a r9) {
        if (Intrinsics.areEqual(this.a, r8) == false) goto L8;
        FLogger.a.i("CreationLLMUpdateShowHelper", "preLoadVideoModel");
        Lazy r10 = q3.a;
        z3 r0 = q3.a();
        if (r0 == null) goto L9;
        z3.a.a(r0, r9, null, 30720000, null, 26);
        return;
    L9:
        return;
    }
}
