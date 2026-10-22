package com.larus.bmhome.chat.detail.code;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.network.SharePanelShowHelper;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 -2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JT\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001fJU\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u001a2\b\u0010$\u001a\u0004\u0018\u00010\u001a2\b\u0010%\u001a\u0004\u0018\u00010&2'\b\u0002\u0010'\u001a!\u0012\u0015\u0012\u0013\u0018\u00010)¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u000e\u0018\u00010(R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/larus/bmhome/chat/detail/code/CodeBlockDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_shareDetailData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/larus/bmhome/share/network/ShareDetailData;", "shareDetailData", "Landroidx/lifecycle/LiveData;", "getShareDetailData", "()Landroidx/lifecycle/LiveData;", "sharePanelShowHelper", "Lcom/larus/bmhome/share/network/SharePanelShowHelper;", "tryShowSharePanel", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "shareScene", "Lcom/larus/bmhome/share/ShareScene;", "loadingAbility", "Lcom/larus/bmhome/share/network/SharePanelShowLoadingAbility;", "shareContent", "Lcom/larus/bmhome/share/panel/FlowShareContent;", "eventParam", "Lcom/larus/bmhome/share/panel/SharePanelEventParam;", "conversationId", "", "messageId", "node", "Lcom/ixigua/lib/track/ITrackNode;", "codePreviewRequest", "Lcom/larus/bmhome/share/network/ShareCodePreviewRequest;", "saveContentToFile", "context", "Landroid/content/Context;", "content", "codeInfo", "loadDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "resultCallback", "Lkotlin/Function1;", "Ljava/io/File;", "Lkotlin/ParameterName;", "name", "file", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class CodeBlockDetailViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "CodeBlockDetailViewModel";
    private final MutableLiveData<com.larus.bmhome.share.network.i> _shareDetailData;
    private final LiveData<com.larus.bmhome.share.network.i> shareDetailData;
    private final SharePanelShowHelper sharePanelShowHelper;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.detail.code.CodeBlockDetailViewModel$saveContentToFile$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.detail.code.CodeBlockDetailViewModel$saveContentToFile$1", f = "CodeBlockDetailViewModel.kt", i = {1}, l = {87, 96}, m = "invokeSuspend", n = {"loadingDeferred"}, s = {"L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $codeInfo;
        final /* synthetic */ String $content;
        final /* synthetic */ Context $context;
        final /* synthetic */ com.larus.common_ui.dialog.l0 $loadDialog;
        final /* synthetic */ Function1<File, Unit> $resultCallback;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function1<? super File, Unit> r1, Context r2, String r3, String r4, com.larus.common_ui.dialog.l0 r5, Continuation<? super AnonymousClass1> r6) {
            this.$resultCallback = r1;
            this.$context = r2;
            this.$content = r3;
            this.$codeInfo = r4;
            this.$loadDialog = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            AnonymousClass1 r7 = new AnonymousClass1(this.$resultCallback, this.$context, this.$content, this.$codeInfo, this.$loadDialog, r10);
            r7.L$0 = r9;
            return r7;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public static void INVOKEVIRTUAL_com_larus_bmhome_chat_detail_code_CodeBlockDetailViewModel$saveContentToFile$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(com.larus.common_ui.dialog.l0 r3) {
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

        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            Deferred r2 = (Deferred) this.L$0;
            ResultKt.throwOnFailure(r13);
        L23:
            com.larus.common_ui.dialog.l0 r3 = this.$loadDialog;
            Function1<File, Unit> r4 = this.$resultCallback;
            File r14 = (File) r13;
            Job.DefaultImpls.cancel$default(r2, null, 1, null);
            if (r3 == null) goto L26;
            INVOKEVIRTUAL_com_larus_bmhome_chat_detail_code_CodeBlockDetailViewModel$saveContentToFile$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r3);
        L26:
            FLogger.a.d(CodeBlockDetailViewModel.TAG, "saveCodeToFile: shareFileDeferred dismiss loading");
            if (r4 == null) goto L30;
            r4.invoke(r14);
        L30:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            Function1<File, Unit> r5 = (Function1) this.L$0;
            ResultKt.throwOnFailure(r13);
        L18:
            r5.invoke(r13);
            goto L30
        L10:
            ResultKt.throwOnFailure(r13);
            CoroutineScope r15 = (CoroutineScope) this.L$0;
            Deferred r6 = BuildersKt.async$default(r15, Dispatchers.getIO(), null, new CodeBlockDetailViewModel$saveContentToFile$1$shareFileDeferred$1(this.$context, this.$content, this.$codeInfo, null), 2, null);
            if (r6.isCompleted() == false) goto L19;
            FLogger.a.d(CodeBlockDetailViewModel.TAG, "saveCodeToFile: shareFileDeferred is Complete");
            Function1<File, Unit> r16 = this.$resultCallback;
            if (r16 == null) goto L30;
            this.L$0 = r16;
            this.label = 1;
            Object r7 = r6.await(this);
            if (r7 != r0) goto L17;
            return r0;
        L17:
            r5 = r16;
            r13 = r7;
            goto L18
        L19:
            Deferred r17 = BuildersKt.async$default(r15, null, null, new CodeBlockDetailViewModel$saveContentToFile$1$loadingDeferred$1(r6, this.$loadDialog, null), 3, null);
            this.L$0 = r17;
            this.label = 2;
            Object r8 = r6.await(this);
            if (r8 != r0) goto L22;
            return r0;
        L22:
            r2 = r17;
            r13 = r8;
            goto L23
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ Unit yo(CodeBlockDetailViewModel r0, com.larus.bmhome.share.network.i r1) {
        return tryShowSharePanel$lambda$0(r0, r1);
    }

    public CodeBlockDetailViewModel() {
        MutableLiveData<com.larus.bmhome.share.network.i> r0 = new MutableLiveData();
        this._shareDetailData = r0;
        this.shareDetailData = r0;
        this.sharePanelShowHelper = new SharePanelShowHelper(ViewModelKt.getViewModelScope(this));
    }

    public final LiveData<com.larus.bmhome.share.network.i> getShareDetailData() {
        return this.shareDetailData;
    }

    private static final Unit tryShowSharePanel$lambda$0(CodeBlockDetailViewModel r1, com.larus.bmhome.share.network.i r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        r1._shareDetailData.postValue(r2);
        return Unit.INSTANCE;
    }

    public final void saveContentToFile(Context r12, String r13, String r14, com.larus.common_ui.dialog.l0 r15, Function1<? super File, Unit> r16) {
        Intrinsics.checkNotNullParameter(r12, "context");
        if (r13 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L14;
        FLogger.a.i(TAG, "saveCodeToFile: codeContent is null or empty");
        if (r16 == null) goto L16;
        r16.invoke(null);
        return;
    L16:
        return;
    L14:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(r16, r12, r13, r14, r15, null), 3, null);
        return;
    L5:
        if (r13.length() == 0) goto L8;
        r0 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void saveContentToFile$default(CodeBlockDetailViewModel r6, Context r7, String r8, String r9, com.larus.common_ui.dialog.l0 r10, Function1 r11, int r12, Object r13) {
        if ((r12 & 16) == 0) goto L5;
        r11 = null;
    L5:
        r6.saveContentToFile(r7, r8, r9, r10, r11);
    }

    public final void tryShowSharePanel(FragmentActivity r15, ShareScene r16, com.larus.bmhome.share.network.j r17, com.larus.bmhome.share.panel.b r18, com.larus.bmhome.share.panel.h r19, String r20, String r21, by7.e r22, com.larus.bmhome.share.network.h r23) {
        Intrinsics.checkNotNullParameter(r16, "shareScene");
        Intrinsics.checkNotNullParameter(r17, "loadingAbility");
        Intrinsics.checkNotNullParameter(r18, "shareContent");
        Intrinsics.checkNotNullParameter(r19, "eventParam");
        Intrinsics.checkNotNullParameter(r20, "conversationId");
        Intrinsics.checkNotNullParameter(r21, "messageId");
        Intrinsics.checkNotNullParameter(r22, "node");
        if (r15 != null) goto L5;
        return;
    L5:
        this.sharePanelShowHelper.c(r15, r17, r16, r19, r18, r20, r21, r22, false, r23, new f0(this));
    }

    public static /* synthetic */ void tryShowSharePanel$default(CodeBlockDetailViewModel r11, FragmentActivity r12, ShareScene r13, com.larus.bmhome.share.network.j r14, com.larus.bmhome.share.panel.b r15, com.larus.bmhome.share.panel.h r16, String r17, String r18, by7.e r19, com.larus.bmhome.share.network.h r20, int r21, Object r22) {
        if ((r21 & 256) == 0) goto L5;
        com.larus.bmhome.share.network.h r10 = null;
    L6:
        r11.tryShowSharePanel(r12, r13, r14, r15, r16, r17, r18, r19, r10);
        return;
    L5:
        r10 = r20;
        goto L6
    }
}
