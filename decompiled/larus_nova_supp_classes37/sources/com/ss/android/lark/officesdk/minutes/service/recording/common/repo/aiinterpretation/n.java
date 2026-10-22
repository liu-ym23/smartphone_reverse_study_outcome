package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation;

import com.ss.android.lark.pb.videochat.SIStreamSyncInfo;
import com.ss.android.lark.pb.videochat.StreamSyncInfo;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class n {
    public static final n a = null;

    static {
        a = new n();
    }

    public n() {
    }

    public static m a(byte[] r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        SIStreamSyncInfo r5 = ((StreamSyncInfo) StreamSyncInfo.ADAPTER.decode(r4)).msiInfo;     // Catch: Throwable -> L12
        if (r5 == null) goto L6;
        Long r2 = r5.mseq_id;     // Catch: Throwable -> L12
    L7:
        if (r5 == null) goto L9;
        boolean r6 = Intrinsics.areEqual(r5.mchange_to_origin, Boolean.TRUE);     // Catch: Throwable -> L12
    L10:
        Object r7 = Result.constructor-impl(new m(r2, r6));     // Catch: Throwable -> L12
    L14:
        Throwable r3 = Result.exceptionOrNull-impl(r7);
        if (r3 == null) goto L18;
        lvb.a.b("MmAIInterpretationStreamSyncInfoParser", "[parse] failed: " + r3);
    L18:
        if (Result.isFailure-impl(r7) == true) goto L22;
        r0 = r7;
    L22:
        return (m) r0;
    L9:
        r6 = false;
        goto L10
    L6:
        r2 = null;
    L12:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }
}
