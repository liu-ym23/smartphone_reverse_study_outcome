package com.larus.drive.sdk.impl;

import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.office.base.service.IOfficeSdkServiceV2;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
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
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.DriveLocalFilePreviewDelegate$prepare$2", f = "DriveLocalFilePreviewDelegate.kt", i = {0, 0}, l = {35}, m = "invokeSuspend", n = {"$this$withContext", "office"}, s = {"L$0", "L$1"})
public final class DriveLocalFilePreviewDelegate$prepare$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public DriveLocalFilePreviewDelegate$prepare$2(Continuation<? super DriveLocalFilePreviewDelegate$prepare$2> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        DriveLocalFilePreviewDelegate$prepare$2 r0 = new DriveLocalFilePreviewDelegate$prepare$2(r3);
        r0.L$0 = r2;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = false;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        IOfficeSdkServiceV2 r3 = (IOfficeSdkServiceV2) this.L$1;
        CoroutineScope r4 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r7);
    L16:
        boolean r8 = ((Boolean) r7).booleanValue();
        CoroutineScopeKt.ensureActive(r4);
        if (r8 == false) goto L25;
        gk5.e r9 = r3.q0();
        if (r9 == null) goto L21;
        com.bytedance.ee.drive.preview.d r10 = r9.Y2();
    L22:
        if (r10 == null) goto L25;
        r2 = true;
        goto L25
    L21:
        r10 = null;
    L25:
        return Boxing.boxBoolean(r2);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        r4 = (CoroutineScope) this.L$0;
        IOfficeSdkServiceV2 r11 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r11 == null) goto L11;
        IOfficeSdkServiceV2.a.b(r11, true, "pc_local_file_preview", 4);
        this.L$0 = r4;
        this.L$1 = r11;
        this.label = 1;
        Object r5 = r11.n0(DoraObricDeviceHomeViewModel.SCAN_TIMEOUT_MS, this);
        if (r5 != r0) goto L15;
        return r0;
    L15:
        r3 = r11;
        r7 = r5;
        goto L16
    L11:
        return Boxing.boxBoolean(false);
    }
}
