package com.larus.asr;

import com.larus.audio.audiov3.asr.AsrCallBackType;
import kotlin.jvm.internal.Intrinsics;
import n58.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class z2 {
    public final b a;

    public z2(b2 r1) {
        this.a = r1;
    }

    public final void a(String r12, String r13, String r14, long r15, String r17) {
        Intrinsics.checkNotNullParameter(r12, "taskId");
        Intrinsics.checkNotNullParameter(r13, "messageContent");
        Intrinsics.checkNotNullParameter(r14, "audioFilePath");
        Intrinsics.checkNotNullParameter("", "vid");
        b r0 = this.a;
        if (r0 == null) goto L6;
        b.a.a(r0, r12, AsrCallBackType.AS_SUCCESS, r13, r14, r15, "", r17, 448);
        return;
    }
}
