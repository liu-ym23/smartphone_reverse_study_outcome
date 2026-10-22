package com.larus.bmhome.chat.list.cell.send_file;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.input.ChatInputService;
import com.larus.bmhome.chat.sendimage.e;
import com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.common_ui.dialog.l0;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.SendFile;
import com.larus.im.bean.message.SendFileContent;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import ye8.b$a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.send_file.SendFileCell$setupImgViewAndTextView$1$1", f = "SendFileCell.kt", i = {0}, l = {176}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class SendFileCell$setupImgViewAndTextView$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $content;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $fileName;
    final /* synthetic */ SendFile $firstFile;
    final /* synthetic */ Message $msg;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SendFileCell this$0;

    public static final class a extends AbsDownloadListener {
        public l0 a;
        public final /* synthetic */ Message b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ SendFileCell e;
        public final /* synthetic */ SendFile f;

        public static void a(l0 r3) {
            Handler r0 = DialogLancet.resolveDialogHandler(r3);
            if (r0 != null) goto L5;
        L8:
            DialogLancet.beforeDialogDismiss(r3);
            r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
        L17:
            DialogLancet.afterDialogDismiss(r3);
            return;
        L13:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
            if (r1 == null) goto L17;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r3);
            throw th;
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L8;
            r0.post(DialogLancet.createDismissRunnable(r3));
        }

        public final void onCanceled(DownloadInfo r7) {
            FLogger.a.i("SendFileCell", "localID:" + this.b.getLocalMessageId() + ", fileName:" + this.c + " download onCanceled");
            l0 r8 = this.a;
            if (r8 == null) goto L5;
            a(r8);
        L5:
            int r9 = com.larus.bmhome.chat.trace.multimodal.a.a;
            String r10 = this.b.getLocalMessageId();
            if (r10 != null) goto L8;
            r10 = "";
        L8:
            String r0 = r10;
            String r1 = this.b.getMessageId();
            SendFile r11 = this.f;
            String r4 = null;
            if (r11 == null) goto L11;
            String r12 = r11.getTosKey();
        L12:
            SendFile r5 = this.f;
            if (r5 == null) goto L15;
            r4 = r5.getResourceId();
        L15:
            com.larus.bmhome.chat.trace.multimodal.a.d(r0, r1, false, "message_file_open_download_errorcancel", r12, r4);
            return;
        L11:
            r12 = null;
            goto L12
        }

        public final void onStart(DownloadInfo r5) {
            FLogger.a.i("SendFileCell", "localID:" + this.b.getLocalMessageId() + ", fileName:" + this.c + " download onStart");
            l0 r6 = new l0(this.d, 0.0f, false, 6);
            this.a = r6;
            if (DialogLancet.shouldBlockDialogShow(r6) == false) goto L9;
            DialogLancet.handleBlockedDialogShow(r6);
            return;
        L9:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
        L6:
            DialogLancet.beforeDialogShow(r6);
            r6.show();
            DialogLancet.afterDialogShow(r6);
        }

        public final void onSuccessed(DownloadInfo r12) {
            FLogger.a.i("SendFileCell", "localID:" + this.b.getLocalMessageId() + ", fileName:" + this.c + " download onSuccessed");
            l0 r0 = this.a;
            if (r0 == null) goto L5;
            a(r0);
        L5:
            SendFileCell r1 = this.e;
            Context r2 = this.d;
            Message r3 = this.b;
            String r4 = this.c;
            int r5 = SendFileCell.i;
            if (r12 == null) goto L39;
            r1.getClass();
            String r6 = r12.getTargetFilePath();
            if (r6 == null) goto L39;
            SendFileContent r7 = e.f(r3.getContent());
            ImFileUtil.a.getClass();
            boolean r8 = ImFileUtil.B(r2, r6, r4, null);
            String r9 = "";
            if (r8 == false) goto L28;
            int r10 = MultimodalSendCostTrace.a;
            String r11 = r3.getLocalMessageId();
            if (r11 == null) goto L15;
            r9 = r11;
        L15:
            List r13 = r7.getFileList();
            if (r13 == null) goto L20;
            SendFile r14 = (SendFile) CollectionsKt.firstOrNull(r13);
            if (r14 == null) goto L20;
            String r15 = r14.getTosKey();
        L21:
            String r16 = r3.getMessageId();
            List r17 = r7.getFileList();
            if (r17 == null) goto L26;
            SendFile r18 = (SendFile) CollectionsKt.firstOrNull(r17);
            if (r18 == null) goto L26;
            String r19 = r18.getResourceId();
        L27:
            MultimodalSendCostTrace.f(r9, r15, r16, false, r19);
        L26:
            r19 = null;
        L20:
            r15 = null;
            goto L21
        L28:
            int r20 = com.larus.bmhome.chat.trace.multimodal.a.a;
            String r21 = r3.getLocalMessageId();
            if (r21 != null) goto L31;
            String r22 = "";
        L32:
            String r23 = r3.getMessageId();
            List r24 = e.f(r3.getContent()).getFileList();
            if (r24 == null) goto L37;
            SendFile r25 = (SendFile) CollectionsKt.firstOrNull(r24);
            if (r25 == null) goto L37;
            String r26 = r25.getTosKey();
        L38:
            com.larus.bmhome.chat.trace.multimodal.a.d(r22, r23, true, "message_file_open_third_party_error", r26, null);
        L37:
            r26 = null;
            goto L38
        L31:
            r22 = r21;
        L39:
            CoroutineScope r27 = (CoroutineScope) r1.g.getValue();
            if (r27 == null) goto L43;
            BuildersKt.launch$default(r27, Dispatchers.getIO(), null, new SendFileCell$onSuccess$2(r3, r12, r1, null), 2, null);
            return;
        }

        public final void onFailed(DownloadInfo r7, BaseException r8) {
            FLogger.a.i("SendFileCell", "localID:" + this.b.getLocalMessageId() + ", fileName:" + this.c + " download onFailed");
            l0 r9 = this.a;
            if (r9 == null) goto L5;
            a(r9);
        L5:
            int r10 = com.larus.bmhome.chat.trace.multimodal.a.a;
            String r11 = this.b.getLocalMessageId();
            if (r11 != null) goto L8;
            r11 = "";
        L8:
            String r0 = r11;
            String r1 = this.b.getMessageId();
            StringBuilder r12 = new StringBuilder("message_file_open_download_errorcode: ");
            if (r8 == null) goto L11;
            Integer r4 = Integer.valueOf(r8.getErrorCode());
        L12:
            r12.append(r4);
            r12.append(" msg: ");
            if (r8 == null) goto L15;
            String r13 = r8.getErrorMessage();
        L16:
            r12.append(r13);
            String r14 = r12.toString();
            SendFile r15 = this.f;
            if (r15 == null) goto L19;
            String r5 = r15.getTosKey();
        L20:
            SendFile r16 = this.f;
            if (r16 == null) goto L23;
            String r6 = r16.getResourceId();
        L24:
            com.larus.bmhome.chat.trace.multimodal.a.d(r0, r1, false, r14, r5, r6);
            return;
        L23:
            r6 = null;
            goto L24
        L19:
            r5 = null;
            goto L20
        L15:
            r13 = null;
            goto L16
        L11:
            r4 = null;
            goto L12
        }

        public a(Message r1, String r2, Context r3, SendFileCell r4, SendFile r5) {
            this.b = r1;
            this.c = r2;
            this.d = r3;
            this.e = r4;
            this.f = r5;
        }
    }

    public SendFileCell$setupImgViewAndTextView$1$1(SendFileCell r1, String r2, Context r3, String r4, Message r5, SendFile r6, Continuation<? super SendFileCell$setupImgViewAndTextView$1$1> r7) {
        this.this$0 = r1;
        this.$content = r2;
        this.$context = r3;
        this.$fileName = r4;
        this.$msg = r5;
        this.$firstFile = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        SendFileCell$setupImgViewAndTextView$1$1 r8 = new SendFileCell$setupImgViewAndTextView$1$1(this.this$0, this.$content, this.$context, this.$fileName, this.$msg, this.$firstFile, r11);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r11);
    L11:
        String r12 = (String) r11;
        if (r12 == null) goto L14;
        Context r6 = this.$context;
        String r7 = this.$fileName;
        b$a.a(ChatInputService.b.f(), r6, r12, r7, new a(this.$msg, r7, r6, this.this$0, this.$firstFile));
    L25:
        return Unit.INSTANCE;
    L14:
        Message r13 = this.$msg;
        SendFile r3 = this.$firstFile;
        int r4 = com.larus.bmhome.chat.trace.multimodal.a.a;
        String r5 = r13.getLocalMessageId();
        if (r5 != null) goto L17;
        r5 = "";
    L17:
        String r8 = r5;
        String r9 = r13.getMessageId();
        String r14 = null;
        if (r3 == null) goto L20;
        String r10 = r3.getTosKey();
    L21:
        if (r3 == null) goto L23;
        r14 = r3.getResourceId();
    L23:
        com.larus.bmhome.chat.trace.multimodal.a.d(r8, r9, false, "message_file_open_error_getUrl", r10, r14);
        goto L25
    L20:
        r10 = null;
        goto L21
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        CoroutineScope r15 = (CoroutineScope) this.L$0;
        SendFileCell r16 = this.this$0;
        String r17 = this.$content;
        this.L$0 = r15;
        this.label = 1;
        r11 = SendFileCell.o(r16, r17, this);
        if (r11 != r0) goto L11;
        return r0;
    }
}
