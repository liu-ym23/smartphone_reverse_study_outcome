package com.larus.drive.sdk.impl.utils.file;

import com.larus.drive.sdk.impl.view.operation.download.DriveDownloadDialog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.utils.file.DriveDownloadManager$onDownloadFailed$1", f = "DriveDownloadManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DriveDownloadManager$onDownloadFailed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $taskId;
    int label;

    public DriveDownloadManager$onDownloadFailed$1(String r1, Continuation<? super DriveDownloadManager$onDownloadFailed$1> r2) {
        this.$taskId = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DriveDownloadManager$onDownloadFailed$1(this.$taskId, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r2);
        String r3 = this.$taskId;
        if (r3 != null) goto L7;
    L10:
        boolean r4 = true;
    L11:
        if (r4 == true) goto L13;
        CoroutineScope r5 = DriveDownloadManager.a;
        DriveDownloadManager.b = this.$taskId;
    L13:
        DriveDownloadManager.d = false;
        DriveDownloadManager.c = 0;
        DriveDownloadManager.b = null;
        WeakReference<DriveDownloadDialog> r0 = DriveDownloadManager.f;
        if (r0 == null) goto L18;
        DriveDownloadDialog r1 = r0.get();
        if (r1 == null) goto L18;
        r1.S90();
    L18:
        DriveDownloadManager.f = null;
        return Unit.INSTANCE;
    L7:
        if (StringsKt.isBlank(r3) == true) goto L10;
        r4 = false;
        goto L11
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
