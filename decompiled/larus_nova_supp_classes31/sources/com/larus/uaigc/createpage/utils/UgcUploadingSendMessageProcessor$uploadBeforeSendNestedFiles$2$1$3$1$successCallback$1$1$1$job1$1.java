package com.larus.uaigc.createpage.utils;

import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.UplinkEntityContent;
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
@DebugMetadata(c = "com.larus.uaigc.createpage.utils.UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$1$successCallback$1$1$1$job1$1", f = "NestedFileSendMessageProcessor.kt", i = {}, l = {502}, m = "invokeSuspend", n = {}, s = {})
public final class UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$1$successCallback$1$1$1$job1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ UplinkFileEntity $entity;
    final /* synthetic */ mr9.l $result;
    Object L$0;
    int label;

    public UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$1$successCallback$1$1$1$job1$1(UplinkFileEntity r1, mr9.l r2, Continuation<? super UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$1$successCallback$1$1$1$job1$1> r3) {
        this.$entity = r1;
        this.$result = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$1$successCallback$1$1$1$job1$1(this.$entity, this.$result, r4);
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
    L21:
        r2.url = (String) r5;
    L23:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        UplinkEntityContent r6 = this.$entity.getUplinkEntityContent();
        if (r6 == null) goto L23;
        Image r7 = r6.getUplinkImageInfo();
        if (r7 == null) goto L23;
        ImageObj r8 = r7.imageOri;
        if (r8 == null) goto L23;
        CreationMediaAttachmentExtUpdater r3 = CreationMediaAttachmentExtUpdater.a;
        String r4 = this.$result.a;
        if (r4 != null) goto L17;
        r4 = "";
    L17:
        this.L$0 = r8;
        this.label = 1;
        r3.getClass();
        Object r9 = CreationMediaAttachmentExtUpdater.b(r4, this);
        if (r9 != r0) goto L20;
        return r0;
    L20:
        r2 = r8;
        r5 = r9;
        goto L21
    }
}
