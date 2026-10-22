package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.MmMockAwareRequestService;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.MmRecordFileHelper;
import com.ss.android.lark.passport.signinsdk_api.base.NetworkErrorResult;
import com.ss.android.lark.vfs.h;
import jvb.n;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRecordingUploadTask {
    public final String a;
    public final int b;
    public final String c;
    public final String d;
    public final int e;
    public final MmRecordingSource f;
    public final boolean g;
    public final String h;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MmRecordingUploadTask) == true) goto L8;
        return false;
    L8:
        MmRecordingUploadTask r6 = (MmRecordingUploadTask) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e) * 31;
        MmRecordingSource r1 = this.f;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (r0 + r2) * 31;
        if (this.g == false) goto L9;
        int r4 = 1231;
    L11:
        return r3 + r4;
    L9:
        r4 = 1237;
        goto L11
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmRecordingUploadTask(audioSegmentFilePath=" + this.a + ", segIndex=" + this.b + ", uploadIdentity=" + this.c + ", startMs=" + this.d + ", duration=" + this.e + ", source=" + this.f + ", useRecordingApi=" + this.g + ')';
    }

    public final Object b(com.ss.android.lark.officesdk.minutes.service.foundation.network.b r14, Continuation<? super Result<String>> r15) {
        if ((r15 instanceof MmRecordingUploadTask$sendAudioSegmentRequest$1) == false) goto L7;
        MmRecordingUploadTask$sendAudioSegmentRequest$1 r0 = (MmRecordingUploadTask$sendAudioSegmentRequest$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r16);
        return ((Result) r16).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        n r4 = new n(this.c, this.d, this.e, this.b, this.a, this.f, this.g);
        r0.label = 1;
        Object r17 = r14.c(String.class, r4, r0);
        if (r17 != r2) goto L18;
        return r2;
    L18:
        return r17;
    L7:
        r0 = new MmRecordingUploadTask$sendAudioSegmentRequest$1(this, r15);
        goto L8
    }

    public static final Object a(MmRecordingUploadTask r11, com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r12, Continuation r13) {
        r11.getClass();
        if ((r13 instanceof MmRecordingUploadTask$postAudioSegment$1) == false) goto L7;
        MmRecordingUploadTask$postAudioSegment$1 r0 = (MmRecordingUploadTask$postAudioSegment$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r14);
        Object r15 = ((Result) r14).unbox-impl();
    L29:
        if (Result.isSuccess-impl(r15) == false) goto L32;
        lvb.a.e(r11.h, "onSuccess: index:" + r11.b + ", httpCode:200, statusCode: 0");
        MmRecordingUploadResponse.a r16 = MmRecordingUploadResponse.Companion;
        Integer r17 = Boxing.boxInt(200);
        Integer r18 = Boxing.boxInt(0);
        r16.getClass();
        return MmRecordingUploadResponse.a.a(r17, r18);
    L32:
        ErrorResult r19 = Result.exceptionOrNull-impl(r15);
        if ((r19 instanceof ErrorResult) == false) goto L35;
        ErrorResult r110 = r19;
    L36:
        if (r110 != null) goto L43;
        Exception r111 = new Exception("unknown error");
        ErrorResult r112 = new ErrorResult(0);
        ErrorResult.access$002(r112, -1);
        ErrorResult.access$102(r112, NetworkErrorResult.UNKNOWN_BIZ_CODE);
        ErrorResult.access$202(r112, -1);
        ErrorResult.access$302(r112, r111);
        ErrorResult.access$402(r112, "");
        ErrorResult.access$502(r112, "");
        ErrorResult.access$602(r112, "");
        ErrorResult.access$702(r112, "");
        ErrorResult.access$802(r112, 0);
        ErrorResult.access$902(r112, null);
        ErrorResult.access$1002(r112, null);
        ErrorResult.access$1102(r112, null);
        throw r112;
    L43:
        throw r110;
    L35:
        r110 = null;
        goto L36
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r14);
    L24:
        MmRecordingUploadResponse.a r113 = MmRecordingUploadResponse.Companion;
        Integer r114 = Boxing.boxInt(200);
        Integer r115 = Boxing.boxInt(0);
        r113.getClass();
        return MmRecordingUploadResponse.a.a(r114, r115);
    L16:
        ResultKt.throwOnFailure(r14);
        lvb.a.e(r11.h, " [UploadTask]  task:" + r11);
        h r116 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.a;
        if (com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.c(r11.a).exists() == true) goto L20;
        lvb.a.h(r11.h, "not exist " + r11.a);
        MmRecordingUploadResponse.a r117 = MmRecordingUploadResponse.Companion;
        Integer r118 = Boxing.boxInt(200);
        Integer r119 = Boxing.boxInt(0);
        r117.getClass();
        return MmRecordingUploadResponse.a.a(r118, r119);
    L20:
        if (com.suite.lark.component.storage.ext.a.a(com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.c(r11.a), false) > 0) goto L25;
        lvb.a.h(r11.h, "empty file, path: " + r11.a);
        MmRecordFileHelper r120 = MmRecordFileHelper.a;
        String r121 = r11.a;
        r0.label = 1;
        r120.getClass();
        if (MmRecordFileHelper.b(r121, r0) != r2) goto L24;
        return r2;
    L25:
        MmMockAwareRequestService r122 = r12.M();
        r0.label = 2;
        r15 = r11.b(r122, r0);
        if (r15 != r2) goto L29;
        return r2;
    L7:
        r0 = new MmRecordingUploadTask$postAudioSegment$1(r11, r13);
        goto L8
    }

    public MmRecordingUploadTask(String r2, int r3, String r4, String r5, int r6, MmRecordingSource r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r2, "audioSegmentFilePath");
        Intrinsics.checkNotNullParameter(r4, "uploadIdentity");
        Intrinsics.checkNotNullParameter(r5, "startMs");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = "MmRecordingUploadTask_" + hashCode();
    }
}
