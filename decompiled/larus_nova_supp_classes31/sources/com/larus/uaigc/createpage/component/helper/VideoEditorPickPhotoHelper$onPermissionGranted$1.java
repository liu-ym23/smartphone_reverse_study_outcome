package com.larus.uaigc.createpage.component.helper;

import com.larus.platform.service.g;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.helper.VideoEditorPickPhotoHelper$onPermissionGranted$1", f = "VideoEditorPickPhotoHelper.kt", i = {}, l = {179}, m = "invokeSuspend", n = {}, s = {})
final class VideoEditorPickPhotoHelper$onPermissionGranted$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ f this$0;

    public VideoEditorPickPhotoHelper$onPermissionGranted$1(f r1, Continuation<? super VideoEditorPickPhotoHelper$onPermissionGranted$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new VideoEditorPickPhotoHelper$onPermissionGranted$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L15
    L13:
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L21;
        r8.printStackTrace();
        g.a.ensureNotReachHere(r8);
    L21:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
        f r9 = this.this$0;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L15
        FLogger.a.i("VideoEditorPickPhotoHelper", "onPermissionGranted emit");     // Catch: Throwable -> L15
        MutableSharedFlow<b> r10 = r9.g;     // Catch: Throwable -> L15
        b r3 = new b(0);     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        if (r10.emit(r3, this) != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }
}
