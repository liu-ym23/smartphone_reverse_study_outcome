package com.larus.bmhome.upload;

import com.larus.bmhome.rc.FlowResourceScene;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.upload.ResourceUploader$cancelAllIdentifierUploadTask$1$1", f = "ResourceUploader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ResourceUploader$cancelAllIdentifierUploadTask$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $identifier;
    final /* synthetic */ ResourceUploader.a $reason;
    int label;

    public ResourceUploader$cancelAllIdentifierUploadTask$1$1(String r1, ResourceUploader.a r2, Continuation<? super ResourceUploader$cancelAllIdentifierUploadTask$1$1> r3) {
        this.$identifier = r1;
        this.$reason = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ResourceUploader$cancelAllIdentifierUploadTask$1$1(this.$identifier, this.$reason, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L22;
        ResultKt.throwOnFailure(r4);
        ConcurrentHashMap<String, mr9.j> r5 = com.larus.bmhome.upload.sdk.g.a;
        String r6 = this.$identifier;
        Intrinsics.checkNotNullParameter(r6, "identifier");
        Boolean r7 = com.larus.bmhome.upload.sdk.g.d.get(r6);
        boolean r1 = true;
        if (r7 == null) goto L7;
        boolean r8 = r7.booleanValue();
    L8:
        if (r8 == false) goto L19;
        ResourceCenter r9 = ResourceCenter.a;
        String r2 = this.$identifier;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r2, "identifier");
        if (ResourceCenter.g(r2) != FlowResourceScene.O_Server) goto L12;
    L14:
        r1 = false;
    L15:
        if (r1 == false) goto L19;
        ResourceUploader r10 = ResourceUploader.a;
        ResourceUploader.b(this.$identifier, this.$reason);
        return Unit.INSTANCE;
    L12:
        if (ResourceCenter.g(r2) == FlowResourceScene.O_Mobile_Tmp) goto L14;
    L19:
        FLogger.a.i("ResourceUploader", "[cancelAllIdentifierUploadTask] skip non-cancelable task: " + this.$identifier);
        return Unit.INSTANCE;
    L7:
        r8 = true;
        goto L8
    L22:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
