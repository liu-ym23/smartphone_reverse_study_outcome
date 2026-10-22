package com.larus.bmhome.clarification;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.larus.bmhome.chat.api.ChatApi;
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
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.clarification.ClarificationAttachmentPreviewer$openFileLegacy$1", f = "ClarificationAttachmentPreviewer.kt", i = {}, l = {202}, m = "invokeSuspend", n = {}, s = {})
final class ClarificationAttachmentPreviewer$openFileLegacy$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ UplinkFileEntity $entity;
    final /* synthetic */ UplinkFileInfo $fileInfo;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ t this$0;

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

    public ClarificationAttachmentPreviewer$openFileLegacy$1(UplinkFileInfo r1, t r2, UplinkFileEntity r3, Context r4, Continuation<? super ClarificationAttachmentPreviewer$openFileLegacy$1> r5) {
        this.$fileInfo = r1;
        this.this$0 = r2;
        this.$entity = r3;
        this.$context = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        ClarificationAttachmentPreviewer$openFileLegacy$1 r6 = new ClarificationAttachmentPreviewer$openFileLegacy$1(this.$fileInfo, this.this$0, this.$entity, this.$context, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static void INVOKEVIRTUAL_com_larus_bmhome_clarification_ClarificationAttachmentPreviewer$openFileLegacy$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(com.larus.common_ui.dialog.l0 r1) {
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

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        String r3 = null;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L24
    L14:
        FileUrlRespData r12 = (FileUrlRespData) ((com.larus.network.http.a) r11).b;     // Catch: Throwable -> L24
        if (r12 == null) goto L21;
        List r13 = r12.getFileUrlList();     // Catch: Throwable -> L24
        if (r13 == null) goto L21;
        FileUrlData r14 = (FileUrlData) CollectionsKt.firstOrNull(r13);     // Catch: Throwable -> L24
        if (r14 == null) goto L21;
        String r15 = r14.getMainUrl();     // Catch: Throwable -> L24
    L22:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L24
    L27:
        if (Result.isFailure-impl(r16) == false) goto L29;
        r16 = null;
    L29:
        String r17 = (String) r16;
    L32:
        if (r17 != null) goto L34;
    L37:
        if (r2 == false) goto L66;
        t r18 = this.this$0;
        UplinkFileEntity r4 = this.$entity;
        r18.getClass();
        Map r5 = r4.getExtra();
        if (r5 == null) goto L41;
        String r7 = (String) r5.get("originFileTypeString");
    L42:
        if (r7 == null) goto L60;
        int r6 = bq9.a.a;
        if (yc9.l1.k(r7) == false) goto L60;
        IFlowSdkDepend r8 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r8 == null) goto L65;
        r8.N();
        n1 r9 = n1.a;
        Context r10 = r18.a.getContext();
        if (r10 == null) goto L65;
        UplinkEntityContent r19 = r4.getUplinkEntityContent();
        if (r19 == null) goto L55;
        UplinkFileInfo r110 = r19.getUplinkFileInfo();
        if (r110 == null) goto L55;
        String r20 = r110.getTosKey();
    L56:
        Map r111 = r4.getExtra();
        if (r111 == null) goto L59;
        r3 = (String) r111.get("originUrl");
    L59:
        r9.y(r10, r20, r7, r3, "click_attachment_zone");
    L55:
        r20 = null;
    L65:
        return Unit.INSTANCE;
    L60:
        t19.s r21 = t19.s.a;
        Context r112 = r18.a.getContext();
        if (r112 == null) goto L65;
        r21.g(r112, 2131905676, false);
        goto L65
    L41:
        r7 = null;
        goto L42
    L66:
        com.larus.common_ui.dialog.l0 r22 = new com.larus.common_ui.dialog.l0(this.$context, 0.0f, false, 6);
        INVOKEVIRTUAL_com_larus_bmhome_clarification_ClarificationAttachmentPreviewer$openFileLegacy$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r22);
        ye8.b r23 = ChatInputService.b.f();
        Context r24 = this.$context;
        String r25 = this.$fileInfo.getFileName();
        if (r25 != null) goto L69;
        r25 = "";
    L69:
        ye8.b.a.a(r23, r24, r17, r25, new a(this.$context, this.$fileInfo, r22));
        return Unit.INSTANCE;
    L34:
        if (r17.length() == 0) goto L37;
        r2 = false;
    L21:
        r15 = null;
        goto L22
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r11);
        CoroutineScope r113 = (CoroutineScope) this.L$0;
        String r114 = this.$fileInfo.getTosKey();
        if (r114 == null) goto L30;
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L24
        Lazy r27 = ChatApi.a;     // Catch: Throwable -> L24
        ChatApi r28 = ChatApi.a.a();     // Catch: Throwable -> L24
        List r115 = CollectionsKt.listOf(r114);     // Catch: Throwable -> L24
        String r29 = UploadDataType.FILE.getType();     // Catch: Throwable -> L24
        this.label = 1;     // Catch: Throwable -> L24
        r28.getClass();     // Catch: Throwable -> L24
        r11 = ChatApi.e(r115, r29, this);     // Catch: Throwable -> L24
        if (r11 != r0) goto L14;
        return r0;
    L30:
        r17 = null;
    L24:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L27
    }
}
