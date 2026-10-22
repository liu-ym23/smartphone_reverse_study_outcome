package com.larus.drive.biz.impl.file;

import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.biz.impl.file.DriveOfficeUploadGuard$checkBeforeOpenPicker$1", f = "DriveOfficeUploadGuard.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DriveOfficeUploadGuard$checkBeforeOpenPicker$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Fragment $fragment;
    final /* synthetic */ Function1<String, Unit> $onBlocked;
    final /* synthetic */ Function0<Unit> $onPassed;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public DriveOfficeUploadGuard$checkBeforeOpenPicker$1(Fragment r1, Function1<? super String, Unit> r2, Function0<Unit> r3, Continuation<? super DriveOfficeUploadGuard$checkBeforeOpenPicker$1> r4) {
        this.$fragment = r1;
        this.$onBlocked = r2;
        this.$onPassed = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DriveOfficeUploadGuard$checkBeforeOpenPicker$1(this.$fragment, this.$onBlocked, this.$onPassed, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L25;
        ResultKt.throwOnFailure(r3);
        int r4 = DriveOfficeUploadGuard.a;
        Fragment r5 = this.$fragment;
        if (r5.isAdded() == true) goto L7;
    L11:
        boolean r6 = false;
    L12:
        if (r6 == true) goto L16;
        this.$onBlocked.invoke("upload picker host unavailable");
        return Unit.INSTANCE;
    L16:
        if ((!t.i()) == true) goto L18;
        DriveOfficeUploadGuard.BlockReason r7 = DriveOfficeUploadGuard.BlockReason.UPLOAD_QUEUE_FULL;
    L19:
        if (r7 == null) goto L22;
        this.$onBlocked.invoke(DriveOfficeUploadGuard.c(this.$fragment, r7));
        return Unit.INSTANCE;
    L22:
        this.$onPassed.invoke();
        return Unit.INSTANCE;
    L18:
        r7 = null;
        goto L19
    L7:
        if (r5.isStateSaved() == true) goto L11;
        if (r5.getActivity() == null) goto L11;
        r6 = true;
        goto L12
    L25:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
