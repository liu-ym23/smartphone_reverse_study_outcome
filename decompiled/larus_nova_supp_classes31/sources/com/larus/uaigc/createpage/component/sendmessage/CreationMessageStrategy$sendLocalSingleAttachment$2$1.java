package com.larus.uaigc.createpage.component.sendmessage;

import com.larus.bmhome.view.AttachmentInfo;
import com.larus.im.bean.message.Message;
import com.larus.uaigc.bean.createpage.CreationSendMessageConfig;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
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
@DebugMetadata(c = "com.larus.uaigc.createpage.component.sendmessage.CreationMessageStrategy$sendLocalSingleAttachment$2$1", f = "CreationMessageStrategy.kt", i = {}, l = {560}, m = "invokeSuspend", n = {}, s = {})
public final class CreationMessageStrategy$sendLocalSingleAttachment$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AttachmentInfo $attachment;
    final /* synthetic */ CreationSendMessageConfig $config;
    final /* synthetic */ String $cvsId;
    final /* synthetic */ List<Message> $localMessageList;
    final /* synthetic */ String $localPath;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CreationMessageStrategy this$0;

    public CreationMessageStrategy$sendLocalSingleAttachment$2$1(CreationMessageStrategy r1, CreationSendMessageConfig r2, String r3, String r4, AttachmentInfo r5, List<Message> r6, Continuation<? super CreationMessageStrategy$sendLocalSingleAttachment$2$1> r7) {
        this.this$0 = r1;
        this.$config = r2;
        this.$cvsId = r3;
        this.$localPath = r4;
        this.$attachment = r5;
        this.$localMessageList = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        CreationMessageStrategy$sendLocalSingleAttachment$2$1 r8 = new CreationMessageStrategy$sendLocalSingleAttachment$2$1(this.this$0, this.$config, this.$cvsId, this.$localPath, this.$attachment, this.$localMessageList, r11);
        r8.L$0 = r10;
        return r8;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L15
    L13:
        Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L21;
        FLogger.a.e("CreationMessageStrategy", "sendLocalSingleAttachment handle prepared messages failed", r13);
    L21:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r11);
        CoroutineScope r14 = (CoroutineScope) this.L$0;
        CreationMessageStrategy r3 = this.this$0;
        CreationSendMessageConfig r4 = this.$config;
        String r5 = this.$cvsId;
        String r6 = this.$localPath;
        AttachmentInfo r7 = this.$attachment;
        List<Message> r8 = this.$localMessageList;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        if (CreationMessageStrategy.a(r3, r4, r5, r6, r7, r8, this) != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }
}
