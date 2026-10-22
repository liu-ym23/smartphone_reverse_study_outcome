package com.larus.camera.impl.result;

import android.content.Context;
import android.net.Uri;
import com.larus.camera.api.params.CameraResultOutOpenParams;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.result.CameraResultFirstFlow$requestImageReadPermission$1$1", f = "CameraResultFirstFlow.kt", i = {}, l = {122}, m = "invokeSuspend", n = {}, s = {})
final class CameraResultFirstFlow$requestImageReadPermission$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Uri $imageUri;
    final /* synthetic */ CameraResultOutOpenParams $params;
    int label;

    public CameraResultFirstFlow$requestImageReadPermission$1$1(Context r1, Uri r2, CameraResultOutOpenParams r3, Continuation<? super CameraResultFirstFlow$requestImageReadPermission$1$1> r4) {
        this.$context = r1;
        this.$imageUri = r2;
        this.$params = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CameraResultFirstFlow$requestImageReadPermission$1$1(this.$context, this.$imageUri, this.$params, r5);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        if (((Boolean) r6).booleanValue() == false) goto L14;
        CameraResultFirstFlow r7 = CameraResultFirstFlow.a;
        Context r2 = this.$context;
        CameraResultOutOpenParams r3 = this.$params;
        r7.getClass();
        Boxing.boxBoolean(CameraResultFirstFlow.j(r2, r3));
    L16:
        return Unit.INSTANCE;
    L14:
        FLogger.a.e("CameraResultFirstFlow", "image uri remains unreadable after permission request");
        goto L16
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        CameraResultFirstFlow r8 = CameraResultFirstFlow.a;
        Context r4 = this.$context;
        Uri r5 = this.$imageUri;
        this.label = 1;
        r8.getClass();
        r6 = BuildersKt.withContext(Dispatchers.getIO(), new CameraResultFirstFlow$canReadUri$2(r5, r4, null), this);
        if (r6 != r0) goto L12;
        return r0;
    }
}
