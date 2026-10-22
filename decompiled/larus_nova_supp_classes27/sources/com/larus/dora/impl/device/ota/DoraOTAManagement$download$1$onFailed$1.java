package com.larus.dora.impl.device.ota;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.log.engine.OTALogReason;
import com.ss.android.socialbase.downloader.exception.BaseException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.ota.DoraOTAManagement$download$1$onFailed$1", f = "DoraOTAManagement.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraOTAManagement$download$1$onFailed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DoraDevice $device;
    final /* synthetic */ BaseException $e;
    final /* synthetic */ z39.a $response;
    int label;

    public DoraOTAManagement$download$1$onFailed$1(BaseException r1, z39.a r2, DoraDevice r3, Continuation<? super DoraOTAManagement$download$1$onFailed$1> r4) {
        this.$e = r1;
        this.$response = r2;
        this.$device = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DoraOTAManagement$download$1$onFailed$1(this.$e, this.$response, this.$device, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r10);
        String r11 = DoraOTABuryPointManager.l;
        BaseException r12 = this.$e;
        if (r12 == null) goto L7;
        int r13 = r12.getErrorCode();
    L8:
        DoraOTABuryPointManager.d(r13);
        DoraOTAManagement r0 = DoraOTAManagement.a;
        z39.a r2 = this.$response;
        StringBuilder r14 = new StringBuilder();
        r14.append(OTALogReason.DOWNLOAD_OTA_FILE_FAILED.getMessage());
        r14.append('_');
        BaseException r4 = this.$e;
        String r8 = null;
        if (r4 == null) goto L11;
        Integer r5 = Boxing.boxInt(r4.getErrorCode());
    L12:
        r14.append(r5);
        DoraOTAManagement.A(r0, 0, r2, "download ota file failed", r14.toString(), this.$device, false, 96);
        k0 r15 = DoraOTAReporter.a;
        BaseException r16 = this.$e;
        if (r16 == null) goto L15;
        r8 = r16.getErrorMessage();
    L15:
        DoraOTAReporter.b(r8);
        return Unit.INSTANCE;
    L11:
        r5 = null;
        goto L12
    L7:
        r13 = 0;
        goto L8
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
