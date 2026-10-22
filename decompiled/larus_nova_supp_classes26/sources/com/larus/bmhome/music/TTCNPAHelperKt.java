package com.larus.bmhome.music;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.ttcnpa.TTCNPA;
import com.bytedance.ttcnpa.TtCnpaCallback;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.block.MusicCreationContent;
import com.larus.platform.service.z2;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class TTCNPAHelperKt {

    public static final class a implements TtCnpaCallback {
        public final /* synthetic */ Continuation<Integer> a;

        public a(SafeContinuation r1) {
            this.a = r1;
        }

        public final void onResult(int r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "errorDesc");
            Integer r4 = Integer.valueOf(r2);
            this.a.resumeWith(Result.constructor-impl(r4));
        }
    }

    public static final Object a(String r5, String r6, Continuation<? super Integer> r7) {
        if ((r7 instanceof TTCNPAHelperKt$appendTTCNPAFlag$1) == false) goto L7;
        TTCNPAHelperKt$appendTTCNPAFlag$1 r0 = (TTCNPAHelperKt$appendTTCNPAFlag$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        String r9 = (String) r0.L$1;
        String r10 = (String) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L28:
        return r8;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r6 = (String) r0.L$1;
        r5 = (String) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L23:
        r0.L$0 = r5;
        r0.L$1 = r6;
        r0.label = 2;
        SafeContinuation r11 = new SafeContinuation(IntrinsicsKt.intercepted(r0));
        TTCNPA.a.a(r5, r5, r6, new a(r11));
        r8 = r11.getOrThrow();
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L26;
        DebugProbesKt.probeCoroutineSuspended(r0);
    L26:
        if (r8 != r2) goto L28;
        return r2;
    L16:
        ResultKt.throwOnFailure(r8);
        if (z2.a.enableMusicSaveTtcnpa() == false) goto L19;
        TTCNPAHelper r12 = TTCNPAHelper.a;
        r0.L$0 = r5;
        r0.L$1 = r6;
        r0.label = 1;
        if (r12.a(r0) != r2) goto L23;
        return r2;
    L19:
        return Boxing.boxInt(0);
    L7:
        r0 = new TTCNPAHelperKt$appendTTCNPAFlag$1(r7);
        goto L8
    }

    public static final Object b(String r6, MusicCreationContent r7, Continuation<? super Integer> r8) {
        if ((r8 instanceof TTCNPAHelperKt$appendTTCNPAFlagOrDeleteFile$1) == false) goto L7;
        TTCNPAHelperKt$appendTTCNPAFlagOrDeleteFile$1 r0 = (TTCNPAHelperKt$appendTTCNPAFlagOrDeleteFile$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        r6 = (String) r0.L$0;
        ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L33
    L28:
        if (((Number) r9).intValue() == 0) goto L31;
        new PolarisFileWrapper(r6).delete();     // Catch: Throwable -> L33
        return Boxing.boxInt(102);
    L31:
        Object r10 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L33
    L36:
        if (Result.exceptionOrNull-impl(r10) == null) goto L40;
        new PolarisFileWrapper(r6).delete();
        return Boxing.boxInt(102);
    L40:
        return Boxing.boxInt(0);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r9);
        if (AppHost.a.isOversea() == true) goto L19;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L33
        String r12 = r7.getVid();     // Catch: Throwable -> L33
        if (r12 == null) goto L23;
        r0.L$0 = r6;     // Catch: Throwable -> L33
        r0.label = 1;     // Catch: Throwable -> L33
        r9 = a(r6, r12, r0);     // Catch: Throwable -> L33
        if (r9 != r2) goto L28;
        return r2;
    L23:
        return Boxing.boxInt(102);
    L19:
        return Boxing.boxInt(0);
    L33:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new TTCNPAHelperKt$appendTTCNPAFlagOrDeleteFile$1(r8);
        goto L8
    }
}
