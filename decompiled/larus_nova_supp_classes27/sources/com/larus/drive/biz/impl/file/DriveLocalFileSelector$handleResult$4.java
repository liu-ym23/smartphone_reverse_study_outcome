package com.larus.drive.biz.impl.file;

import android.content.Context;
import android.net.Uri;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.biz.impl.file.DriveLocalFileSelector$handleResult$4", f = "DriveLocalFileSelector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DriveLocalFileSelector$handleResult$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ u $listener;
    final /* synthetic */ int $requestCode;
    final /* synthetic */ List<Uri> $uris;
    int label;

    public DriveLocalFileSelector$handleResult$4(Context r1, List<Uri> r2, int r3, u r4, Continuation<? super DriveLocalFileSelector$handleResult$4> r5) {
        this.$context = r1;
        this.$uris = r2;
        this.$requestCode = r3;
        this.$listener = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new DriveLocalFileSelector$handleResult$4(this.$context, this.$uris, this.$requestCode, this.$listener, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r5);
        DriveLocalFileSelector.a(DriveLocalFileSelector.a, this.$context, this.$uris, this.$requestCode, this.$listener);     // Catch: Throwable -> L7
    L10:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        FLogger.a.e("DriveLocalFileSelector", "handleResultUris failed", th);
        this.$listener.b(th);
        goto L10
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
