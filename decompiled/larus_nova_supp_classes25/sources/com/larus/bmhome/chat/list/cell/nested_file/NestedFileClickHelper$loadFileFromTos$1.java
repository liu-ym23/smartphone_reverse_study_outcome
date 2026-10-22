package com.larus.bmhome.chat.list.cell.nested_file;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.common_ui.dialog.l0;
import com.larus.home.impl.sdk.n1;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.NestedFileLocalPath;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.im.bean.message.block.UploadLarkDoc;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.FlowDriveSdkService;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.nested_file.NestedFileClickHelper$loadFileFromTos$1", f = "NestedFileClickHelper.kt", i = {0}, l = {629}, m = "invokeSuspend", n = {"dialog"}, s = {"L$0"})
final class NestedFileClickHelper$loadFileFromTos$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $cxt;
    final /* synthetic */ Message $data;
    final /* synthetic */ lr8.a $delegate;
    final /* synthetic */ UplinkFileInfo $fileInfo;
    final /* synthetic */ String $key;
    final /* synthetic */ lr8.g $outerUrlResult;
    final /* synthetic */ String $targetFileName;
    Object L$0;
    int label;

    public NestedFileClickHelper$loadFileFromTos$1(Context r1, Message r2, String r3, UplinkFileInfo r4, lr8.g r5, String r6, lr8.a r7, Continuation<? super NestedFileClickHelper$loadFileFromTos$1> r8) {
        this.$cxt = r1;
        this.$data = r2;
        this.$key = r3;
        this.$fileInfo = r4;
        this.$outerUrlResult = r5;
        this.$targetFileName = r6;
        this.$delegate = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new NestedFileClickHelper$loadFileFromTos$1(this.$cxt, this.$data, this.$key, this.$fileInfo, this.$outerUrlResult, this.$targetFileName, this.$delegate, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static void INVOKEVIRTUAL_com_larus_bmhome_chat_list_cell_nested_file_NestedFileClickHelper$loadFileFromTos$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(l0 r3) {
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

    public static void INVOKEVIRTUAL_com_larus_bmhome_chat_list_cell_nested_file_NestedFileClickHelper$loadFileFromTos$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(l0 r1) {
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

    public final Object invokeSuspend(Object r18) {
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        String r9 = "";
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        l0 r1 = (l0) this.L$0;
        ResultKt.throwOnFailure(r18);
        l0 r10 = r1;
        Object r2 = r18;
    L26:
        NestedFileDownloader.a r3 = (NestedFileDownloader.a) r2;
        int r4 = r3.a;
        if (r4 != 0) goto L62;
        NestedFileClickHelper r5 = NestedFileClickHelper.a;
        Context r6 = this.$cxt;
        UplinkFileInfo r8 = this.$fileInfo;
        String r11 = r3.d;
        Message r12 = this.$data;
        String r13 = r8.getFileName();
        if (r13 == null) goto L32;
        r9 = r13;
    L32:
        String r14 = this.$key;
        lr8.a r15 = this.$delegate;
        r5.getClass();
        if (r11 == null) goto L38;
        ImFileUtil.a.getClass();
        if (ImFileUtil.B(r6, r11, r9, null) == false) goto L37;
        int r16 = MultimodalSendCostTrace.a;
        MultimodalSendCostTrace.f(r14, r8.getTosKey(), r12.getMessageId(), false, r8.getResourceId());
        goto L38
    L37:
        int r17 = com.larus.bmhome.chat.trace.multimodal.a.a;
        com.larus.bmhome.chat.trace.multimodal.a.d(r14, r12.getMessageId(), true, "message_file_open_third_party_error", r8.getTosKey(), r8.getResourceId());
    L38:
        Map r19 = r12.getBusinessExt();
        if (r19 == null) goto L42;
        String r20 = (String) r19.get("nested_file_local_path_list");
        if (r20 == null) goto L42;
    L43:
        if (r20 == null) goto L72;
        final List<NestedFileLocalPath> r21 = com.larus.bmhome.chat.sendimage.e.g(r20);
        if (r21 == null) goto L72;
        Iterator<T> r22 = r21.iterator();
    L48:
        if (r22.hasNext() == false) goto L52;
        Object r23 = r22.next();
        if (Intrinsics.areEqual(((NestedFileLocalPath) r23).getIdentifier(), r14) == false) goto L48;
    L53:
        NestedFileLocalPath r24 = (NestedFileLocalPath) r23;
        if (r24 == null) goto L56;
        r24.setPath(r11);
    L56:
        Intrinsics.checkNotNullParameter(r21, "<this>");
        String r25 = (String) com.larus.utils.l0.a(null, new com.larus.bmhome.chat.sendimage.a(r21));
        if (r25 == null) goto L72;
        CoroutineScope r110 = r15.c();
        if (r110 == null) goto L72;
        BuildersKt.launch$default(r110, Dispatchers.getIO(), null, new NestedFileClickHelper$onSuccess$3$1(r12, r25, r15, null), 2, null);
        goto L72
    L52:
        r23 = null;
    L72:
        INVOKEVIRTUAL_com_larus_bmhome_chat_list_cell_nested_file_NestedFileClickHelper$loadFileFromTos$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r10);
        return Unit.INSTANCE;
    L42:
        r20 = com.larus.bmhome.chat.sendimage.e.d(com.larus.bmhome.chat.bean.d.f(r12));
        goto L43
    L62:
        if (r4 != 1001) goto L64;
        r9 = "message_file_open_error_getUrl";
    L71:
        int r26 = com.larus.bmhome.chat.trace.multimodal.a.a;
        com.larus.bmhome.chat.trace.multimodal.a.d(this.$key, this.$data.getMessageId(), false, r9, this.$fileInfo.getTosKey(), this.$fileInfo.getResourceId());
        goto L72
    L64:
        if (r4 != 2002) goto L66;
        r9 = "message_file_open_download_errorcode: " + r3.b + " msg: " + r3.c;
        goto L71
    L66:
        if (r4 != 2003) goto L71;
        r9 = "message_file_open_download_errorcancel";
        goto L71
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r18);
        r10 = new l0(this.$cxt, 0.0f, false, 6);
        INVOKEVIRTUAL_com_larus_bmhome_chat_list_cell_nested_file_NestedFileClickHelper$loadFileFromTos$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r10);
        NestedFileClickHelper r27 = NestedFileClickHelper.a;
        Context r111 = this.$cxt;
        Message r28 = this.$data;
        String r29 = this.$key;
        UplinkFileInfo r30 = this.$fileInfo;
        r27.getClass();
        UploadLarkDoc r31 = NestedFileClickHelper.a(r28, r29, r30);
        if (r31 == null) goto L19;
        if (r111 == null) goto L19;
        FlowDriveSdkService r32 = FlowDriveSdkService.a;
        Long r33 = r31.getType();
        String r34 = r31.getTitle();
        if (r34 != null) goto L16;
        r34 = "";
    L16:
        String r112 = r32.g(r33, r34);
        IFlowSdkDepend r35 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r35 == null) goto L19;
        r35.N();
        boolean r36 = n1.a.y(r111, r31.getToken(), r112, r31.getUrl(), "click_attachment_in_chat");
    L20:
        if (r36 == false) goto L23;
        int r37 = MultimodalSendCostTrace.a;
        MultimodalSendCostTrace.f(this.$key, this.$fileInfo.getTosKey(), this.$data.getMessageId(), false, this.$fileInfo.getResourceId());
        INVOKEVIRTUAL_com_larus_bmhome_chat_list_cell_nested_file_NestedFileClickHelper$loadFileFromTos$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r10);
        return Unit.INSTANCE;
    L23:
        NestedFileDownloader r38 = NestedFileDownloader.a;
        Context r39 = this.$cxt;
        UplinkFileInfo r40 = this.$fileInfo;
        lr8.g r41 = this.$outerUrlResult;
        String r42 = this.$targetFileName;
        this.L$0 = r10;
        this.label = 1;
        r2 = r38.c(r39, r40, r41, r42, this);
        if (r2 != r7) goto L26;
        return r7;
    L19:
        r36 = false;
        goto L20
    }
}
