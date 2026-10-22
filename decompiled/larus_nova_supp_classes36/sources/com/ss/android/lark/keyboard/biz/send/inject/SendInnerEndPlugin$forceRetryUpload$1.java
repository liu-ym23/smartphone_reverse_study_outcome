package com.ss.android.lark.keyboard.biz.send.inject;

import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.UplinkFileEntity;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.biz.send.inject.SendInnerEndPlugin$forceRetryUpload$1", f = "SendInnerEndPlugin.kt", i = {}, l = {308}, m = "invokeSuspend", n = {}, s = {})
final class SendInnerEndPlugin$forceRetryUpload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $chatId;
    final /* synthetic */ UplinkFileEntity $entity;
    final /* synthetic */ String $localPath;
    final /* synthetic */ String $uploadId;
    int label;
    final /* synthetic */ SendInnerEndPlugin this$0;

    public SendInnerEndPlugin$forceRetryUpload$1(SendInnerEndPlugin r1, String r2, String r3, String r4, UplinkFileEntity r5, Continuation<? super SendInnerEndPlugin$forceRetryUpload$1> r6) {
        this.this$0 = r1;
        this.$chatId = r2;
        this.$uploadId = r3;
        this.$localPath = r4;
        this.$entity = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new SendInnerEndPlugin$forceRetryUpload$1(this.this$0, this.$chatId, this.$uploadId, this.$localPath, this.$entity, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        SendInnerEndPlugin r2 = this.this$0;
        String r9 = this.$chatId;
        String r3 = this.$uploadId;
        String r4 = this.$localPath;
        UplinkFileEntity r5 = this.$entity;
        this.label = 1;
        if (SendInnerEndPlugin.j(r2, r9, r3, r4, r5, this) != r0) goto L12;
        return r0;
    }
}
