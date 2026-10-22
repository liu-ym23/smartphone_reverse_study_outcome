package com.larus.canvas.service;

import android.net.Uri;
import com.larus.utils.logger.FLogger;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.service.CanvasServiceImpl$requestImageReadPermission$1$1", f = "CanvasServiceImpl.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
final class CanvasServiceImpl$requestImageReadPermission$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Integer $displayId;
    final /* synthetic */ Uri $imageUri;
    final /* synthetic */ String $localUri;
    int label;
    final /* synthetic */ CanvasServiceImpl this$0;

    public CanvasServiceImpl$requestImageReadPermission$1$1(CanvasServiceImpl r1, Uri r2, String r3, Integer r4, Continuation<? super CanvasServiceImpl$requestImageReadPermission$1$1> r5) {
        this.this$0 = r1;
        this.$imageUri = r2;
        this.$localUri = r3;
        this.$displayId = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new CanvasServiceImpl$requestImageReadPermission$1$1(this.this$0, this.$imageUri, this.$localUri, this.$displayId, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        if (((Boolean) r5).booleanValue() == false) goto L14;
        CanvasServiceImpl r6 = this.this$0;
        String r2 = this.$localUri;
        Integer r3 = this.$displayId;
        int r4 = CanvasServiceImpl.c;
        r6.getClass();
        CanvasServiceImpl.g(r2, r3);
    L16:
        return Unit.INSTANCE;
    L14:
        FLogger.a.e("CanvasServiceImpl", "image uri remains unreadable after permission request");
        goto L16
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        CanvasServiceImpl r7 = this.this$0;
        Uri r8 = this.$imageUri;
        this.label = 1;
        int r9 = CanvasServiceImpl.c;
        r7.getClass();
        r5 = BuildersKt.withContext(Dispatchers.getIO(), new CanvasServiceImpl$canReadUri$2(r8, null), this);
        if (r5 != r0) goto L12;
        return r0;
    }
}
