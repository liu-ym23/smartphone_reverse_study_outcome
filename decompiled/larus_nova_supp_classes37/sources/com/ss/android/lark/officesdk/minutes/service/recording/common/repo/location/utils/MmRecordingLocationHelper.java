package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils;

import com.ss.android.lark.location.dto.LarkLocation;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.request.http.MmUploadLocationResponse;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.MmRecordingNetHelper;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRecordingLocationHelper {
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a a;
    public final String b;

    public static final class a {
    }

    public interface b {
        void a(LarkLocation r1);
    }

    static {
    }

    public MmRecordingLocationHelper(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r2) {
        Intrinsics.checkNotNullParameter(r2, "mmUccApi");
        this.a = r2;
        this.b = "MmRecordingLocationHelper";
    }

    public final Object a(String r14, double r15, double r17, String r19, MmRecordingSource r20, boolean r21, Continuation<? super Result<MmUploadLocationResponse>> r22) {
        if ((r22 instanceof MmRecordingLocationHelper$uploadMMLocation$1) == false) goto L7;
        MmRecordingLocationHelper$uploadMMLocation$1 r2 = (MmRecordingLocationHelper$uploadMMLocation$1) r22;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        MmRecordingLocationHelper$uploadMMLocation$1 r12 = r2;
        Object r1 = r12.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r12.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        ResultKt.throwOnFailure(r1);
        return ((Result) r1).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        MmRecordingNetHelper r6 = this.a.G();
        r12.label = 1;
        Object r7 = r6.z(r14, r15, r17, r19, r20, r21, r12);
        if (r7 != r4) goto L18;
        return r4;
    L18:
        return r7;
    L7:
        r2 = new MmRecordingLocationHelper$uploadMMLocation$1(this, r22);
        goto L8
    }
}
