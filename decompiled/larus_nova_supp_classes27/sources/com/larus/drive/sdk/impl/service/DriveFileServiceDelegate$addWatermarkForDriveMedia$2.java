package com.larus.drive.sdk.impl.service;

import android.app.Dialog;
import com.bytedance.ee.bear.document.matermark.CCMWatermarkManager;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.office.base.service.IOfficeSdkServiceV2;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.service.DriveFileServiceDelegate$addWatermarkForDriveMedia$2", f = "DriveFileServiceDelegate.kt", i = {}, l = {589, 595}, m = "invokeSuspend", n = {}, s = {})
public final class DriveFileServiceDelegate$addWatermarkForDriveMedia$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Dialog $dialog;
    final /* synthetic */ IOfficeSdkServiceV2 $officeSdkService;
    final /* synthetic */ String $token;
    final /* synthetic */ int $type;
    int label;

    /* JADX INFO: renamed from: com.larus.drive.sdk.impl.service.DriveFileServiceDelegate$addWatermarkForDriveMedia$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.drive.sdk.impl.service.DriveFileServiceDelegate$addWatermarkForDriveMedia$2$1", f = "DriveFileServiceDelegate.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Dialog $dialog;
        final /* synthetic */ String $token;
        final /* synthetic */ int $type;
        int label;

        public AnonymousClass1(Dialog r1, String r2, int r3, Continuation<? super AnonymousClass1> r4) {
            this.$dialog = r1;
            this.$token = r2;
            this.$type = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.$dialog, this.$token, this.$type, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r5);
            if (this.$dialog.isShowing() == true) goto L8;
            FLogger.a.i("DriveFileServiceDelegate", "[addWatermarkForDriveMedia] Dialog not showing after sdk ready; skip; token=" + this.$token);
            return Unit.INSTANCE;
        L8:
            Lazy r6 = CCMWatermarkManager.a;
            ((zo5.b) CCMWatermarkManager.a.getValue()).j(this.$token, this.$type, this.$dialog);
            FLogger.a.i("DriveFileServiceDelegate", "[addWatermarkForDriveMedia] Watermark applied after sdk ready; token=" + this.$token);
            return Unit.INSTANCE;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public DriveFileServiceDelegate$addWatermarkForDriveMedia$2(IOfficeSdkServiceV2 r1, String r2, Dialog r3, int r4, Continuation<? super DriveFileServiceDelegate$addWatermarkForDriveMedia$2> r5) {
        this.$officeSdkService = r1;
        this.$token = r2;
        this.$dialog = r3;
        this.$type = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new DriveFileServiceDelegate$addWatermarkForDriveMedia$2(this.$officeSdkService, this.$token, this.$dialog, this.$type, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r3 = true;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r8);
    L23:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
    L13:
        if (r8 != null) goto L16;
        r3 = false;
    L16:
        if (r3 == true) goto L19;
        FLogger.a.e("DriveFileServiceDelegate", "[addWatermarkForDriveMedia] Await office sdk timeout; token=" + this.$token);
        return Unit.INSTANCE;
    L19:
        MainCoroutineDispatcher r9 = Dispatchers.getMain();
        AnonymousClass1 r2 = new AnonymousClass1(this.$dialog, this.$token, this.$type, null);
        this.label = 2;
        if (BuildersKt.withContext(r9, r2, this) != r0) goto L23;
        return r0;
    L10:
        ResultKt.throwOnFailure(r8);
        IOfficeSdkServiceV2 r10 = this.$officeSdkService;
        this.label = 1;
        r8 = r10.o0(DoraObricDeviceHomeViewModel.SCAN_TIMEOUT_MS, this);
        if (r8 != r0) goto L13;
        return r0;
    }
}
