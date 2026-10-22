package com.larus.bmhome.chat.list.cell.send_file;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.ChatRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.chat.sendimage.e;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.SendFile;
import com.larus.im.bean.message.SendFileContent;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.send_file.SendFileCell$onSuccess$2", f = "SendFileCell.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SendFileCell$onSuccess$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DownloadInfo $entity;
    final /* synthetic */ Message $msg;
    int label;
    final /* synthetic */ SendFileCell this$0;

    public static final class a implements IIMCallback<Message> {
        public final /* synthetic */ SendFileCell a;

        public final boolean mustInMain() {
            return true;
        }

        public a(SendFileCell r1) {
            this.a = r1;
        }

        public final void onFailure(IIMError r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
        }

        public final void onSuccess(Object r3) {
            Message r4 = (Message) r3;
            Intrinsics.checkNotNullParameter(r4, "result");
            q0 r0 = lf8.a.b(this.a);
            if (r0 == null) goto L9;
            String r1 = r4.getMessageId();
            if (r1 != null) goto L7;
            r1 = "";
        L7:
            r0.x7(r1, r4.getContentType());
            return;
        }
    }

    public SendFileCell$onSuccess$2(Message r1, DownloadInfo r2, SendFileCell r3, Continuation<? super SendFileCell$onSuccess$2> r4) {
        this.$msg = r1;
        this.$entity = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new SendFileCell$onSuccess$2(this.$msg, this.$entity, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r5);
        RepoDispatcher.a.getClass();
        ChatRepo r6 = RepoDispatcher.d;
        String r0 = this.$msg.getMessageId();
        if (r0 != null) goto L7;
        r0 = "";
    L7:
        SendFileContent r1 = e.f(this.$msg.getContent());
        DownloadInfo r2 = this.$entity;
        List r3 = r1.getFileList();
        if (r3 == null) goto L15;
        SendFile r4 = (SendFile) CollectionsKt.firstOrNull(r3);
        if (r4 == null) goto L15;
        if (r2 == null) goto L13;
        String r7 = r2.getTargetFilePath();
    L14:
        r4.setLocalResPath(r7);
        goto L15
    L13:
        r7 = null;
    L15:
        Unit r8 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r1, "content");
        r6.J1(r0, GsonProtectorUtils.toJson(e.i(), r1), new a(this.this$0));
        return Unit.INSTANCE;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
