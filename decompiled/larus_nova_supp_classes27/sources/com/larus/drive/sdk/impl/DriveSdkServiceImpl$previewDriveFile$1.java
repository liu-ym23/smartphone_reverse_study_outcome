package com.larus.drive.sdk.impl;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.drive.sdk.impl.gallery.DriveGalleryHelper;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import z79.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.DriveSdkServiceImpl$previewDriveFile$1", f = "DriveSdkServiceImpl.kt", i = {}, l = {924}, m = "invokeSuspend", n = {}, s = {})
final class DriveSdkServiceImpl$previewDriveFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ Bundle $args;
    final /* synthetic */ int $ccmType;
    final /* synthetic */ String $fileName;
    final /* synthetic */ String $fileToken;
    final /* synthetic */ LifecycleCoroutineScope $scope;
    int label;
    final /* synthetic */ DriveSdkServiceImpl this$0;

    public DriveSdkServiceImpl$previewDriveFile$1(String r1, String r2, int r3, FragmentActivity r4, LifecycleCoroutineScope r5, Bundle r6, DriveSdkServiceImpl r7, Continuation<? super DriveSdkServiceImpl$previewDriveFile$1> r8) {
        this.$fileName = r1;
        this.$fileToken = r2;
        this.$ccmType = r3;
        this.$activity = r4;
        this.$scope = r5;
        this.$args = r6;
        this.this$0 = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new DriveSdkServiceImpl$previewDriveFile$1(this.$fileName, this.$fileToken, this.$ccmType, this.$activity, this.$scope, this.$args, this.this$0, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r22) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r22);
        Object r3 = r22;
    L19:
        DriveFileItem r4 = (DriveFileItem) r3;
    L20:
        DriveFileItem r5 = r4;
        if (r5 != null) goto L24;
        FLogger.a.w("DriveSdkServiceImpl", "[previewDriveFile] fileItem is null, fileToken=" + this.$fileToken + ", ccmType=" + this.$ccmType);
        t19.s r6 = t19.s.a;
        FragmentActivity r7 = this.$activity;
        r6.getClass();
        t19.s.s(r7, 2131901792);
        return Unit.INSTANCE;
    L24:
        DriveGalleryHelper r8 = DriveGalleryHelper.a;
        DriveGalleryHelper.d(new b(this.$activity, r5, this.$scope, null, null, 112));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r22);
        String r9 = this.$fileName;
        if (r9 != null) goto L11;
    L16:
        CoroutineDispatcher r10 = Dispatchers.getIO();
        DriveSdkServiceImpl$previewDriveFile$1$fileItem$3 r11 = new DriveSdkServiceImpl$previewDriveFile$1$fileItem$3(this.this$0, this.$fileToken, this.$ccmType, null);
        this.label = 1;
        r3 = BuildersKt.withContext(r10, r11, this);
        if (r3 != r1) goto L19;
        return r1;
    L11:
        if ((!StringsKt.isBlank(r9)) == false) goto L13;
        String r12 = r9;
    L14:
        if (r12 == null) goto L16;
        int r13 = this.$ccmType;
        String r14 = this.$fileToken;
        int r15 = com.larus.drive.sdk.impl.utils.n.a;
        DriveFileType r18 = com.larus.drive.sdk.impl.utils.n.a(Boxing.boxInt(r13), r12);
        r4 = new DriveFileItem(r12, r14, "", r13, "", 0, 0, r18.getIconResId(), "", r18, 0, null);
        goto L20
    L13:
        r12 = null;
        goto L14
    }
}
