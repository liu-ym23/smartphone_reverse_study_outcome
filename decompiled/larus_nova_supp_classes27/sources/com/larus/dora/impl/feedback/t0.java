package com.larus.dora.impl.feedback;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class t0 {
    public static final t0 a = null;

    static {
        a = new t0();
    }

    public t0() {
    }

    public final Object a(String r6, String r7, DoraFeedbackImage$compressImage$2$compressionJob$1.a r8, Continuation r9) {
        if ((r9 instanceof VideoCompressor$compressVideo$1) == false) goto L7;
        VideoCompressor$compressVideo$1 r0 = (VideoCompressor$compressVideo$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r10);
    L18:
        return ((Result) r10).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        CoroutineDispatcher r11 = Dispatchers.getIO();
        VideoCompressor$compressVideo$2 r4 = new VideoCompressor$compressVideo$2(r6, r7, r8, null);
        r0.label = 1;
        r10 = BuildersKt.withContext(r11, r4, r0);
        if (r10 != r2) goto L18;
        return r2;
    L7:
        r0 = new VideoCompressor$compressVideo$1(this, r9);
        goto L8
    }
}
