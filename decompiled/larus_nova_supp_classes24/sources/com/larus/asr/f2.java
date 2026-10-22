package com.larus.asr;

import com.larus.audio.audiov3.config.task.sami.asr.AsrResultState;
import com.larus.audio.audiov3.task.asr.AsrEventEnum;
import kotlin.jvm.internal.Intrinsics;
import y58.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f2 {
    public final h68.d a;

    public f2(d.a r1) {
        this.a = r1;
    }

    public final void a(String r16, String r17, long r19, String r20, String r21, String r22) {
        Intrinsics.checkNotNullParameter(r16, "taskId");
        Intrinsics.checkNotNullParameter(r17, "messageContent");
        Intrinsics.checkNotNullParameter("", "vid");
        h68.d r13 = this.a;
        if (r13 == null) goto L6;
        r13.a(new b(r16, null, null, r17, "", r19, AsrResultState.SUCCESS, AsrEventEnum.ASR_SUCCESS, new y58.c(r20, r21, r22), 6));
        return;
    }
}
