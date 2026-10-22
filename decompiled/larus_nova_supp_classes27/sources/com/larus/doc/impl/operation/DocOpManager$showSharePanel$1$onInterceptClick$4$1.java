package com.larus.doc.impl.operation;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.DialogFragment;
import com.larus.bmhome.share.api.IShareService;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.l0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import t19.s;
import tx9.u0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.operation.DocOpManager$showSharePanel$1$onInterceptClick$4$1", f = "DocOpManager.kt", i = {}, l = {684, 685}, m = "invokeSuspend", n = {}, s = {})
public final class DocOpManager$showSharePanel$1$onInterceptClick$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $artifactMetaId;
    final /* synthetic */ Map<String, Object> $bizExtra;
    final /* synthetic */ by7.e $fragment;
    final /* synthetic */ Context $it;
    final /* synthetic */ l0 $loadingDialog;
    final /* synthetic */ String $resourceId;
    final /* synthetic */ jr9.a $shareItemConfig;
    final /* synthetic */ DialogFragment $sharePanelDialog;
    final /* synthetic */ String $showFrom;
    final /* synthetic */ String $title;
    final /* synthetic */ int $trackingResourceType;
    int label;

    /* JADX INFO: renamed from: com.larus.doc.impl.operation.DocOpManager$showSharePanel$1$onInterceptClick$4$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.doc.impl.operation.DocOpManager$showSharePanel$1$onInterceptClick$4$1$1", f = "DocOpManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $artifactMetaId;
        final /* synthetic */ by7.e $fragment;
        final /* synthetic */ Context $it;
        final /* synthetic */ l0 $loadingDialog;
        final /* synthetic */ String $resourceId;
        final /* synthetic */ String $result;
        final /* synthetic */ jr9.a $shareItemConfig;
        final /* synthetic */ DialogFragment $sharePanelDialog;
        final /* synthetic */ String $showFrom;
        final /* synthetic */ String $title;
        final /* synthetic */ int $trackingResourceType;
        int label;

        public AnonymousClass1(String r1, l0 r2, String r3, Context r4, jr9.a r5, String r6, String r7, String r8, int r9, by7.e r10, DialogFragment r11, Continuation<? super AnonymousClass1> r12) {
            this.$resourceId = r1;
            this.$loadingDialog = r2;
            this.$result = r3;
            this.$it = r4;
            this.$shareItemConfig = r5;
            this.$title = r6;
            this.$showFrom = r7;
            this.$artifactMetaId = r8;
            this.$trackingResourceType = r9;
            this.$fragment = r10;
            this.$sharePanelDialog = r11;
            super(2, r12);
        }

        public final Continuation<Unit> create(Object r14, Continuation<?> r15) {
            return new AnonymousClass1(this.$resourceId, this.$loadingDialog, this.$result, this.$it, this.$shareItemConfig, this.$title, this.$showFrom, this.$artifactMetaId, this.$trackingResourceType, this.$fragment, this.$sharePanelDialog, r15);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public static void INVOKEVIRTUAL_com_larus_doc_impl_operation_DocOpManager$showSharePanel$1$onInterceptClick$4$1$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(DialogFragment r1) {
            r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r2 = DialogFragmentLancet.sLastShowStack;
            if (r2 == null) goto L11;
            com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }

        public static void INVOKEVIRTUAL_com_larus_doc_impl_operation_DocOpManager$showSharePanel$1$onInterceptClick$4$1$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(l0 r3) {
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

        public final Object invokeSuspend(Object r40) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L22;
            ResultKt.throwOnFailure(r40);
            FLogger r1 = FLogger.a;
            StringBuilder r2 = new StringBuilder("getShareLink: ");
            r2.append(this.$resourceId);
            r2.append(" end loading, dialog is showing: ");
            l0 r3 = this.$loadingDialog;
            if (r3 == null) goto L7;
            Boolean r4 = Boxing.boxBoolean(r3.isShowing());
        L8:
            r2.append(r4);
            r1.i("DocOpManager", r2.toString());
            INVOKEVIRTUAL_com_larus_doc_impl_operation_DocOpManager$showSharePanel$1$onInterceptClick$4$1$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this.$loadingDialog);
            if (this.$result == null) goto L11;
            ShareServiceDelegate r5 = ShareServiceDelegate.b;
            IShareService.a.d(r5, this.$it, this.$shareItemConfig.b(), this.$shareItemConfig.c(), new com.larus.bmhome.share.panel.b(null, null, this.$result, null, null, null, null, this.$title, null, null, null, null, null, null, null, null, false, false, null, null, false, false, null, false, null, null, 67108731), null, 48);
            r5.d(this.$shareItemConfig.b(), this.$shareItemConfig.c(), null, "1");
        L13:
            if (this.$result == null) goto L15;
            String r6 = "1";
        L16:
            u0.f(this.$showFrom, r6, null, "share", this.$resourceId, this.$artifactMetaId, Boxing.boxInt(this.$trackingResourceType), null, null, this.$fragment, 388);
            DialogFragment r7 = this.$sharePanelDialog;
            if (r7 == null) goto L20;
            INVOKEVIRTUAL_com_larus_doc_impl_operation_DocOpManager$showSharePanel$1$onInterceptClick$4$1$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(r7);
        L20:
            return Unit.INSTANCE;
        L15:
            r6 = "0";
            goto L16
        L11:
            s r8 = s.a;
            Context r9 = this.$it;
            String r10 = AppHost.a.getApplication().getString(2131909350);
            r8.getClass();
            s.t(r9, r10);
            ShareServiceDelegate.b.d(this.$shareItemConfig.b(), this.$shareItemConfig.c(), null, "0");
            goto L13
        L7:
            r4 = null;
            goto L8
        L22:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public DocOpManager$showSharePanel$1$onInterceptClick$4$1(String r1, Map<String, ? extends Object> r2, l0 r3, Context r4, jr9.a r5, String r6, String r7, String r8, int r9, by7.e r10, DialogFragment r11, Continuation<? super DocOpManager$showSharePanel$1$onInterceptClick$4$1> r12) {
        this.$resourceId = r1;
        this.$bizExtra = r2;
        this.$loadingDialog = r3;
        this.$it = r4;
        this.$shareItemConfig = r5;
        this.$title = r6;
        this.$showFrom = r7;
        this.$artifactMetaId = r8;
        this.$trackingResourceType = r9;
        this.$fragment = r10;
        this.$sharePanelDialog = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r14, Continuation<?> r15) {
        return new DocOpManager$showSharePanel$1$onInterceptClick$4$1(this.$resourceId, this.$bizExtra, this.$loadingDialog, this.$it, this.$shareItemConfig, this.$title, this.$showFrom, this.$artifactMetaId, this.$trackingResourceType, this.$fragment, this.$sharePanelDialog, r15);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        ResultKt.throwOnFailure(r20);
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r20);
        Object r3 = r20;
    L13:
        String r7 = (String) r3;
        MainCoroutineDispatcher r4 = Dispatchers.getMain();
        AnonymousClass1 r15 = new AnonymousClass1(this.$resourceId, this.$loadingDialog, r7, this.$it, this.$shareItemConfig, this.$title, this.$showFrom, this.$artifactMetaId, this.$trackingResourceType, this.$fragment, this.$sharePanelDialog, null);
        this.label = 2;
        if (BuildersKt.withContext(r4, r15, this) != r1) goto L17;
        return r1;
    L10:
        ResultKt.throwOnFailure(r20);
        DocOpManager r5 = DocOpManager.a;
        String r6 = this.$resourceId;
        Map<String, Object> r8 = this.$bizExtra;
        this.label = 1;
        r3 = DocOpManager.b(r5, r6, r8, this);
        if (r3 != r1) goto L13;
        return r1;
    }
}
