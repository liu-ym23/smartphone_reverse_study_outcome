package com.larus.chat.gallery.impl.preview.toolbar.action;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.preview.toolbar.action.DownloadAction$downloadVideoViaCreationRecord$3$1", f = "DownloadAction.kt", i = {}, l = {544}, m = "invokeSuspend", n = {}, s = {})
final class DownloadAction$downloadVideoViaCreationRecord$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $creationId;
    final /* synthetic */ String $messageId;
    final /* synthetic */ String $taskId;
    int label;

    public DownloadAction$downloadVideoViaCreationRecord$3$1(String r1, String r2, String r3, Continuation<? super DownloadAction$downloadVideoViaCreationRecord$3$1> r4) {
        this.$creationId = r1;
        this.$taskId = r2;
        this.$messageId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DownloadAction$downloadVideoViaCreationRecord$3$1(this.$creationId, this.$taskId, this.$messageId, r5);
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
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        com.larus.platform.service.e0 r7 = com.larus.platform.service.e0.a;
        String r2 = this.$creationId;
        String r3 = this.$taskId;
        String r4 = this.$messageId;
        this.label = 1;
        if (r7.h1(r2, r3, r4, this) != r0) goto L12;
        return r0;
    }
}
