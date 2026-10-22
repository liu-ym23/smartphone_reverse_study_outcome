package com.larus.bmhome.chat.component.bottom.attachment;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.larus.bmhome.chat.api.ChatApi;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.input.ChatInputService;
import com.larus.bmhome.chat.resp.FileUrlData;
import com.larus.bmhome.chat.resp.FileUrlRespData;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.home.impl.sdk.n1;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.model.upload.UploadDataType;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import yc9.l1;
import ye8.b$a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.attachment.AttachmentPanelComponent$openAttachmentFileLegacy$1", f = "AttachmentPanelComponent.kt", i = {}, l = {3368}, m = "invokeSuspend", n = {}, s = {})
final class AttachmentPanelComponent$openAttachmentFileLegacy$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ UplinkFileEntity $entity;
    final /* synthetic */ UplinkFileInfo $fileInfo;
    int label;
    final /* synthetic */ AttachmentPanelComponent this$0;

    public static final class a extends AbsDownloadListener {
        public final /* synthetic */ Context a;
        public final /* synthetic */ UplinkFileInfo b;
        public final /* synthetic */ com.larus.common_ui.dialog.l0 c;

        public static void a(com.larus.common_ui.dialog.l0 r3) {
            Handler r0 = DialogLancet.resolveDialogHandler(r3);
            if (r0 != null) goto L5;
        L8:
            DialogLancet.beforeDialogDismiss(r3);
            r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
        L10:
            DialogLancet.afterDialogDismiss(r3);
            return;
        L11:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r3);
            throw th;
        L13:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
            if (r1 == null) goto L10;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
            goto L10
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L8;
            r0.post(DialogLancet.createDismissRunnable(r3));
        }

        public final void onCanceled(DownloadInfo r1) {
            a(this.c);
        }

        public final void onSuccessed(DownloadInfo r5) {
            if (r5 == null) goto L4;
            String r6 = r5.getTargetFilePath();
        L5:
            String r0 = "";
            if (r6 != null) goto L9;
            r6 = "";
        L9:
            if (r6.length() <= 0) goto L11;
            boolean r1 = true;
        L12:
            if (r1 == false) goto L18;
            ImFileUtil r2 = ImFileUtil.a;
            Context r3 = this.a;
            String r4 = this.b.getFileName();
            if (r4 == null) goto L17;
            r0 = r4;
        L17:
            String r7 = this.b.getMimeType();
            r2.getClass();
            ImFileUtil.B(r3, r6, r0, r7);
        L18:
            a(this.c);
            return;
        L11:
            r1 = false;
            goto L12
        L4:
            r6 = null;
            goto L5
        }

        public final void onFailed(DownloadInfo r1, BaseException r2) {
            a(this.c);
        }

        public a(Context r1, UplinkFileInfo r2, com.larus.common_ui.dialog.l0 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public AttachmentPanelComponent$openAttachmentFileLegacy$1(UplinkFileInfo r1, AttachmentPanelComponent r2, UplinkFileEntity r3, Context r4, Continuation<? super AttachmentPanelComponent$openAttachmentFileLegacy$1> r5) {
        this.$fileInfo = r1;
        this.this$0 = r2;
        this.$entity = r3;
        this.$context = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new AttachmentPanelComponent$openAttachmentFileLegacy$1(this.$fileInfo, this.this$0, this.$entity, this.$context, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static void INVOKEVIRTUAL_com_larus_bmhome_chat_component_bottom_attachment_AttachmentPanelComponent$openAttachmentFileLegacy$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(com.larus.common_ui.dialog.l0 r1) {
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        String r2 = null;
        boolean r3 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L15:
        FileUrlRespData r11 = (FileUrlRespData) ((com.larus.network.http.a) r10).b;
        if (r11 == null) goto L22;
        List<FileUrlData> r12 = r11.getFileUrlList();
        if (r12 == null) goto L22;
        FileUrlData r13 = (FileUrlData) CollectionsKt.firstOrNull(r12);
        if (r13 == null) goto L22;
        String r14 = r13.getMainUrl();
    L24:
        if (r14 != null) goto L26;
    L29:
        if (r3 == false) goto L54;
        AttachmentPanelComponent r15 = this.this$0;
        UplinkFileEntity r4 = this.$entity;
        int r5 = AttachmentPanelComponent.g2;
        r15.getClass();
        Map r6 = r4.getExtra();
        if (r6 == null) goto L53;
        String r7 = (String) r6.get("originFileTypeString");
        if (r7 == null) goto L53;
        int r8 = bq9.a.a;
        if (l1.k(r7) == false) goto L53;
        UplinkEntityContent r9 = r4.getUplinkEntityContent();
        if (r9 == null) goto L42;
        UplinkFileInfo r16 = r9.getUplinkFileInfo();
        if (r16 == null) goto L42;
        String r17 = r16.getTosKey();
    L44:
        if (r15.r6(r4) == true) goto L53;
        Map r18 = r4.getExtra();
        if (r18 == null) goto L49;
        r2 = (String) r18.get("originUrl");
    L49:
        String r19 = r2;
        IFlowSdkDepend r20 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r20 == null) goto L53;
        r20.N();
        n1.a.y(r15.getContext(), r17, r7, r19, "click_attachment_zone");
    L42:
        r17 = null;
    L53:
        return Unit.INSTANCE;
    L54:
        com.larus.common_ui.dialog.l0 r21 = new com.larus.common_ui.dialog.l0(this.$context, 0.0f, false, 6);
        INVOKEVIRTUAL_com_larus_bmhome_chat_component_bottom_attachment_AttachmentPanelComponent$openAttachmentFileLegacy$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r21);
        ye8.b r22 = ChatInputService.b.f();
        Context r23 = this.$context;
        String r24 = this.$fileInfo.getFileName();
        if (r24 != null) goto L57;
        r24 = "";
    L57:
        b$a.a(r22, r23, r14, r24, new a(this.$context, this.$fileInfo, r21));
        return Unit.INSTANCE;
    L26:
        if (r14.length() == 0) goto L29;
        r3 = false;
    L22:
        r14 = null;
        goto L24
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        UplinkFileInfo r110 = this.$fileInfo;
        if (r110 == null) goto L22;
        String r111 = r110.getTosKey();
        if (r111 == null) goto L22;
        Lazy<ChatApi> r25 = ChatApi.a;
        ChatApi r26 = ChatApi.a.a();
        List r112 = CollectionsKt.listOf(r111);
        String r27 = UploadDataType.FILE.getType();
        this.label = 1;
        r26.getClass();
        r10 = ChatApi.e(r112, r27, this);
        if (r10 != r0) goto L15;
        return r0;
    }
}
