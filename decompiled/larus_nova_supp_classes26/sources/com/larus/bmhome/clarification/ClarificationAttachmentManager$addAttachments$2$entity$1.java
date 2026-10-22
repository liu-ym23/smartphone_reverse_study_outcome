package com.larus.bmhome.clarification;

import android.net.Uri;
import com.larus.im.bean.message.UplinkFileEntity;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/im/bean/message/UplinkFileEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.clarification.ClarificationAttachmentManager$addAttachments$2$entity$1", f = "ClarificationAttachmentManager.kt", i = {}, l = {378}, m = "invokeSuspend", n = {}, s = {})
final class ClarificationAttachmentManager$addAttachments$2$entity$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super UplinkFileEntity>, Object> {
    final /* synthetic */ boolean $isFromDrive;
    final /* synthetic */ boolean $isFromFileBrowser;
    final /* synthetic */ Uri $uri;
    int label;
    final /* synthetic */ ClarificationAttachmentManager this$0;

    public ClarificationAttachmentManager$addAttachments$2$entity$1(ClarificationAttachmentManager r1, Uri r2, boolean r3, boolean r4, Continuation<? super ClarificationAttachmentManager$addAttachments$2$entity$1> r5) {
        this.this$0 = r1;
        this.$uri = r2;
        this.$isFromFileBrowser = r3;
        this.$isFromDrive = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ClarificationAttachmentManager$addAttachments$2$entity$1(this.this$0, this.$uri, this.$isFromFileBrowser, this.$isFromDrive, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super UplinkFileEntity> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        return r6;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        ClarificationAttachmentManager r7 = this.this$0;
        Uri r2 = this.$uri;
        boolean r3 = this.$isFromFileBrowser;
        boolean r4 = this.$isFromDrive;
        this.label = 1;
        r6 = ClarificationAttachmentManager.d(r7, r2, r3, r4, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
