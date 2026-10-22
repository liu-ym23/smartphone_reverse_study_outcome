package com.larus.uaigc.createpage.component.sendmessage;

import com.larus.im.bean.message.ImageObj;
import com.larus.uaigc.createpage.utils.CreationMediaAttachmentExtUpdater;
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
@DebugMetadata(c = "com.larus.uaigc.createpage.component.sendmessage.CreationMultiAttachmentProcessor$handleImageUpload$1$successCallback$1$1$1$urlJob$1", f = "CreationMultiAttachmentProcessor.kt", i = {}, l = {536}, m = "invokeSuspend", n = {}, s = {})
public final class CreationMultiAttachmentProcessor$handleImageUpload$1$successCallback$1$1$1$urlJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ImageObj $imageOri;
    final /* synthetic */ mr9.l $result;
    Object L$0;
    int label;

    public CreationMultiAttachmentProcessor$handleImageUpload$1$successCallback$1$1$1$urlJob$1(ImageObj r1, mr9.l r2, Continuation<? super CreationMultiAttachmentProcessor$handleImageUpload$1$successCallback$1$1$1$urlJob$1> r3) {
        this.$imageOri = r1;
        this.$result = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CreationMultiAttachmentProcessor$handleImageUpload$1$successCallback$1$1$1$urlJob$1(this.$imageOri, this.$result, r4);
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
        ImageObj r2 = (ImageObj) this.L$0;
        ResultKt.throwOnFailure(r5);
    L15:
        r2.url = (String) r5;
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        ImageObj r6 = this.$imageOri;
        CreationMediaAttachmentExtUpdater r3 = CreationMediaAttachmentExtUpdater.a;
        String r4 = this.$result.a;
        if (r4 != null) goto L11;
        r4 = "";
    L11:
        this.L$0 = r6;
        this.label = 1;
        r3.getClass();
        Object r7 = CreationMediaAttachmentExtUpdater.b(r4, this);
        if (r7 != r0) goto L14;
        return r0;
    L14:
        r2 = r6;
        r5 = r7;
        goto L15
    }
}
