package com.ss.android.lark.keyboard.biz.send.inject;

import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.UpLinkState;
import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.UplinkFileEntity;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.biz.send.inject.SendInnerEndPlugin$tryUploadNewEntities$1$1", f = "SendInnerEndPlugin.kt", i = {}, l = {186}, m = "invokeSuspend", n = {}, s = {})
final class SendInnerEndPlugin$tryUploadNewEntities$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $chatId;
    final /* synthetic */ UplinkFileEntity $entity;
    final /* synthetic */ String $uploadId;
    int label;
    final /* synthetic */ SendInnerEndPlugin this$0;

    public SendInnerEndPlugin$tryUploadNewEntities$1$1(SendInnerEndPlugin r1, UplinkFileEntity r2, String r3, String r4, Continuation<? super SendInnerEndPlugin$tryUploadNewEntities$1$1> r5) {
        this.this$0 = r1;
        this.$entity = r2;
        this.$chatId = r3;
        this.$uploadId = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new SendInnerEndPlugin$tryUploadNewEntities$1$1(this.this$0, this.$entity, this.$chatId, this.$uploadId, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L23:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        SendInnerEndPlugin r11 = this.this$0;
        UplinkFileEntity r2 = this.$entity;
        SendInnerEndPlugin.a r3 = SendInnerEndPlugin.q;
        String r12 = r11.l(r2);
        if (r12 != null) goto L11;
        r12 = "";
    L11:
        String r6 = r12;
        this.$entity.setUpLinkStatus(Boxing.boxInt(UpLinkState.PROCESSING.getValue()));
        if (this.$entity.getUpLinkProcess() == null) goto L18;
        Integer r13 = this.$entity.getUpLinkProcess();
        if (r13 != null) goto L17;
    L19:
        SendInnerEndPlugin r4 = this.this$0;
        String r5 = this.$chatId;
        String r7 = this.$uploadId;
        UplinkFileEntity r8 = this.$entity;
        this.label = 1;
        if (SendInnerEndPlugin.j(r4, r5, r7, r6, r8, this) != r0) goto L23;
        return r0;
    L17:
        if (r13.intValue() != (-1)) goto L19;
    L18:
        this.$entity.setUpLinkProcess(Boxing.boxInt(0));
        goto L19
    }
}
