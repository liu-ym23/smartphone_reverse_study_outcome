package com.larus.uaigc.creation.gallery.datasource;

import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.im.bean.message.Message;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/im/bean/message/Message;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.creation.gallery.datasource.CreationDataSourceHelper$getCreationTemplateTrackParams$repoReplyMessage$2$1", f = "CreationDataSourceHelper.kt", i = {}, l = {302}, m = "invokeSuspend", n = {}, s = {})
public final class CreationDataSourceHelper$getCreationTemplateTrackParams$repoReplyMessage$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Message>, Object> {
    final /* synthetic */ String $replyId;
    int label;

    public CreationDataSourceHelper$getCreationTemplateTrackParams$repoReplyMessage$2$1(String r1, Continuation<? super CreationDataSourceHelper$getCreationTemplateTrackParams$repoReplyMessage$2$1> r2) {
        this.$replyId = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationDataSourceHelper$getCreationTemplateTrackParams$repoReplyMessage$2$1(this.$replyId, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Message> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        return r4;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        IChatRepoService r5 = RepoDispatcherDelegate.b.e();
        String r2 = this.$replyId;
        this.label = 1;
        r4 = r5.E1(r2, this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
