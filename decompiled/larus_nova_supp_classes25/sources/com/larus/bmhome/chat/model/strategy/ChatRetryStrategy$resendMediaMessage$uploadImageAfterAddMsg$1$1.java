package com.larus.bmhome.chat.model.strategy;

import com.larus.bmhome.actionbar.model.MediaAttachment;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.helper.n0;
import com.larus.bmhome.chat.model.repo.ChatSender;
import com.larus.bmhome.chat.model.repo.u1$a;
import com.larus.bmhome.rc.FlowResourceScene;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.SendFile;
import com.larus.platform.model.upload.UploadDataType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.strategy.ChatRetryStrategy$resendMediaMessage$uploadImageAfterAddMsg$1$1", f = "ChatRetryStrategy.kt", i = {}, l = {331}, m = "invokeSuspend", n = {}, s = {})
public final class ChatRetryStrategy$resendMediaMessage$uploadImageAfterAddMsg$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<mr9.k, Unit> $callback;
    final /* synthetic */ ChatPageContext $chatPageContext;
    final /* synthetic */ wc9.e $conversation;
    final /* synthetic */ Ref.ObjectRef<SendFile> $fileContent;
    final /* synthetic */ String $fileExtension;
    final /* synthetic */ String $localResPath;
    final /* synthetic */ Message $msg;
    final /* synthetic */ Function1<mr9.k, Unit> $processCallback;
    final /* synthetic */ Map<String, String> $reqExt;
    int label;
    final /* synthetic */ ChatRetryStrategy this$0;

    public ChatRetryStrategy$resendMediaMessage$uploadImageAfterAddMsg$1$1(ChatRetryStrategy r1, Message r2, Map<String, String> r3, String r4, String r5, Function1<? super mr9.k, Unit> r6, Function1<? super mr9.k, Unit> r7, ChatPageContext r8, Ref.ObjectRef<SendFile> r9, wc9.e r10, Continuation<? super ChatRetryStrategy$resendMediaMessage$uploadImageAfterAddMsg$1$1> r11) {
        this.this$0 = r1;
        this.$msg = r2;
        this.$reqExt = r3;
        this.$localResPath = r4;
        this.$fileExtension = r5;
        this.$callback = r6;
        this.$processCallback = r7;
        this.$chatPageContext = r8;
        this.$fileContent = r9;
        this.$conversation = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
        return new ChatRetryStrategy$resendMediaMessage$uploadImageAfterAddMsg$1$1(this.this$0, this.$msg, this.$reqExt, this.$localResPath, this.$fileExtension, this.$callback, this.$processCallback, this.$chatPageContext, this.$fileContent, this.$conversation, r14);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r24) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r24);
        Object r3 = r24;
    L11:
        final MediaAttachment r8 = (MediaAttachment) r3;
        if (this.$msg.getContentType() != 6) goto L14;
        UploadDataType r4 = UploadDataType.IMAGE;
    L15:
        n0 r5 = n0.a;
        Map<String, String> r6 = this.$reqExt;
        if (r6 != null) goto L18;
        r6 = this.$msg.getExt();
    L18:
        r5.getClass();
        String r16 = n0.h(r6);
        final ChatRetryStrategy r7 = this.this$0;
        ChatSender r13 = r7.a.e;
        final String r14 = this.$localResPath;
        String r15 = this.$fileExtension;
        final Map<String, String> r9 = this.$reqExt;
        final Message r12 = this.$msg;
        final ChatPageContext r10 = this.$chatPageContext;
        final Ref.ObjectRef<SendFile> r11 = this.$fileContent;
        final wc9.e r17 = this.$conversation;
        Function1 r18 = new j(r9, r12, r7, r8, r14, r10, r11, r17);
        Function1<mr9.k, Unit> r19 = this.$callback;
        if (r19 != null) goto L21;
        r19 = this.$processCallback;
    L21:
        Function1 r20 = new k(r7, r12);
        Boolean r21 = Boxing.boxBoolean(ChatRetryStrategy.j(r16));
        String r22 = this.$msg.getLocalMessageId();
        this.this$0.getClass();
        int r23 = ChatRetryStrategy$b.a[r4.ordinal()];
        if (r23 != 1) goto L24;
        FlowResourceScene r25 = FlowResourceScene.ImageVLM;
    L34:
        UploadDataType r110 = r4;
        Function1<mr9.k, Unit> r111 = r19;
        u1$a.h(r13, r14, r15, r110, r18, r111, r20, r16, r21, null, r22, r25, null, 9408);
        return Unit.INSTANCE;
    L24:
        if (r23 != 2) goto L26;
    L32:
        r25 = FlowResourceScene.FileUpload;
        goto L34
    L26:
        if (r23 == 3) goto L32;
        if (r23 != 4) goto L31;
        r25 = FlowResourceScene.VideoUpload;
        goto L34
    L31:
        throw new NoWhenBranchMatchedException();
    L14:
        r4 = UploadDataType.FILE;
        goto L15
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r24);
        ChatRetryStrategy r26 = this.this$0;
        Message r27 = this.$msg;
        this.label = 1;
        r3 = ChatRetryStrategy.c(r26, r27, this);
        if (r3 != r1) goto L11;
        return r1;
    }
}
