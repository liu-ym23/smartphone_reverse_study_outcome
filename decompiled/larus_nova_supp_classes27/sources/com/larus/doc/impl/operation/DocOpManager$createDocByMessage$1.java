package com.larus.doc.impl.operation;

import android.content.Context;
import com.larus.doc.api.IDocService;
import com.larus.doc.api.IDocService$Companion;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.operation.DocOpManager$createDocByMessage$1", f = "DocOpManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DocOpManager$createDocByMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ String $currentPage;
    final /* synthetic */ String $docId;
    final /* synthetic */ String $docRealToken;
    final /* synthetic */ String $from;
    final /* synthetic */ boolean $isInMainConversation;
    final /* synthetic */ String $meetingRecordCreatePlatform;
    final /* synthetic */ String $messageId;
    int label;

    public DocOpManager$createDocByMessage$1(Context r1, String r2, String r3, boolean r4, String r5, String r6, String r7, String r8, String r9, Continuation<? super DocOpManager$createDocByMessage$1> r10) {
        this.$context = r1;
        this.$docId = r2;
        this.$conversationId = r3;
        this.$isInMainConversation = r4;
        this.$messageId = r5;
        this.$from = r6;
        this.$meetingRecordCreatePlatform = r7;
        this.$docRealToken = r8;
        this.$currentPage = r9;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        return new DocOpManager$createDocByMessage$1(this.$context, this.$docId, this.$conversationId, this.$isInMainConversation, this.$messageId, this.$from, this.$meetingRecordCreatePlatform, this.$docRealToken, this.$currentPage, r13);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r7);
        IDocService$Companion r8 = IDocService.a;
        Context r0 = this.$context;
        Pair[] r1 = new Pair[7];
        r1[0] = TuplesKt.to("key_doc_id", this.$docId);
        r1[1] = TuplesKt.to("create_doc_by_msg_conv_id", this.$conversationId);
        r1[2] = TuplesKt.to("argIsInMainConversation", Boxing.boxBoolean(this.$isInMainConversation));
        r1[3] = TuplesKt.to("argMessageId", this.$messageId);
        r1[4] = TuplesKt.to("key_doc_enter_from", this.$from);
        r1[5] = TuplesKt.to("key_meeting_record_create_platform", this.$meetingRecordCreatePlatform);
        String r2 = this.$docRealToken;
        if (r2 != null) goto L7;
    L9:
        r2 = null;
    L10:
        r1[6] = TuplesKt.to("key_offline_retry_doc_real_token", r2);
        r8.Z9(r0, com.larus.utils.f.c(r1), this.$currentPage);
        return Unit.INSTANCE;
    L7:
        if ((true ^ StringsKt.isBlank(r2)) == false) goto L9;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
