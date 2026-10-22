package com.larus.uaigc.createpage.component.sendmessage;

import com.larus.bmhome.nestedfile.NestedFileCacheManagerService;
import com.larus.im.bean.message.UplinkFileEntity;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.sendmessage.CreationMultiAttachmentProcessor$handleImageUpload$1$successCallback$1$1$2$1", f = "CreationMultiAttachmentProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CreationMultiAttachmentProcessor$handleImageUpload$1$successCallback$1$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ UplinkFileEntity $entity;
    final /* synthetic */ String $localNestedFileMessageId;
    int label;

    public CreationMultiAttachmentProcessor$handleImageUpload$1$successCallback$1$1$2$1(String r1, UplinkFileEntity r2, Continuation<? super CreationMultiAttachmentProcessor$handleImageUpload$1$successCallback$1$1$2$1> r3) {
        this.$localNestedFileMessageId = r1;
        this.$entity = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CreationMultiAttachmentProcessor$handleImageUpload$1$successCallback$1$1$2$1(this.$localNestedFileMessageId, this.$entity, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        NestedFileCacheManagerService.b.k(this.$localNestedFileMessageId, this.$entity);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
