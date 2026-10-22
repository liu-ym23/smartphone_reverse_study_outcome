package com.larus.uaigc.createpage.utils;

import com.larus.bmhome.nestedfile.NestedFileCacheManagerService;
import com.larus.im.bean.message.NestedFileContent;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/im/bean/message/NestedFileContent;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.utils.UgcUploadingSendMessageProcessor$checkSendMessage$cachedNestedFileContent$1", f = "NestedFileSendMessageProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class UgcUploadingSendMessageProcessor$checkSendMessage$cachedNestedFileContent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super NestedFileContent>, Object> {
    final /* synthetic */ String $localNestedFileMessageId;
    int label;

    public UgcUploadingSendMessageProcessor$checkSendMessage$cachedNestedFileContent$1(String r1, Continuation<? super UgcUploadingSendMessageProcessor$checkSendMessage$cachedNestedFileContent$1> r2) {
        this.$localNestedFileMessageId = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new UgcUploadingSendMessageProcessor$checkSendMessage$cachedNestedFileContent$1(this.$localNestedFileMessageId, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super NestedFileContent> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        return NestedFileCacheManagerService.b.b6(this.$localNestedFileMessageId);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
