package com.larus.drive.sdk.impl.view.preview;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.bmhome.nestedfile.INestFileService;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.api.IShareService;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.common_ui.dialog.l0;
import com.larus.common_ui.widget.roundlayout.RoundLinearLayout;
import com.larus.dora.api.model.FlowDoraConnectReason;
import com.larus.drive.sdk.impl.databinding.LarusDialogAiFilePreviewShareBinding;
import com.larus.drive.sdk.impl.store.DrivePreviewRequestStore;
import com.larus.im.bean.message.FileType;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 52\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u001f\u001a\u00020\u0010H\u0016J\u0010\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u0010H\u0016J\u0018\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'H\u0082@¢\u0006\u0002\u0010(J\u0018\u0010)\u001a\u00020\u00102\u0006\u0010&\u001a\u00020'2\u0006\u0010*\u001a\u00020%H\u0002J\u001c\u0010+\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\r2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010%H\u0002J\u001a\u0010.\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'2\u0006\u0010/\u001a\u00020%H\u0002J\u0010\u00100\u001a\u00020\u00102\u0006\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u00020\u0010H\u0002J\u0018\u00104\u001a\u00020\u00102\u0006\u0010&\u001a\u00020'2\u0006\u0010/\u001a\u00020%H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/larus/drive/sdk/impl/view/preview/AiFilePreviewShareSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/drive/sdk/impl/databinding/LarusDialogAiFilePreviewShareBinding;", "sharePanelView", "Lcom/larus/bmhome/share/panel/AbsSharePanelView;", "resolveUrlJob", "Lkotlinx/coroutines/Job;", "saveDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "savingToSpace", "", "openResultReported", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getTheme", "", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onStart", "onCancel", "dialog", "Landroid/content/DialogInterface;", "onDestroyView", "resolveShareUrl", "", "session", "Lcom/larus/drive/sdk/impl/store/AiFilePreviewSession;", "(Lcom/larus/drive/sdk/impl/store/AiFilePreviewSession;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showSharePanel", "fileUrl", "reportOpenResult", FlowDoraConnectReason.SUCCESS, "errorCode", "resolveTraceFileType", "fileName", "openFileForwardPicker", "file", "Lcom/larus/bmhome/share/panel/HostForwardFileContent;", "requestDownloadCurrentFile", "saveToSpace", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AiFilePreviewShareSheet extends BottomSheetDialogFragment {
    public static final a j = null;
    public LarusDialogAiFilePreviewShareBinding d;
    public com.larus.bmhome.share.panel.a e;
    public Job f;
    public l0 g;
    public boolean h;
    public boolean i;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.drive.sdk.impl.view.preview.AiFilePreviewShareSheet$onViewCreated$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.drive.sdk.impl.view.preview.AiFilePreviewShareSheet$onViewCreated$3", f = "AiFilePreviewShareSheet.kt", i = {0}, l = {102}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ com.larus.drive.sdk.impl.store.a $session;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AiFilePreviewShareSheet this$0;

        public AnonymousClass3(AiFilePreviewShareSheet r1, com.larus.drive.sdk.impl.store.a r2, Continuation<? super AnonymousClass3> r3) {
            this.this$0 = r1;
            this.$session = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass3 r0 = new AnonymousClass3(this.this$0, this.$session, r5);
            r0.L$0 = r4;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public static void INVOKEVIRTUAL_com_larus_drive_sdk_impl_view_preview_AiFilePreviewShareSheet$onViewCreated$3_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(AiFilePreviewShareSheet r1) {
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

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r2 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            CoroutineScope r3 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r7);
        L11:
            String r8 = (String) r7;
            if (r8 == null) goto L18;
            if (StringsKt.isBlank(r8) == true) goto L18;
            r2 = false;
        L18:
            if (r2 == false) goto L24;
            FLogger.a.w("AiFilePreviewShare", "dismiss share sheet, reason=share_url_unavailable");
            AiFilePreviewShareSheet r9 = this.this$0;
            a r4 = AiFilePreviewShareSheet.j;
            r9.W90(false, "share_url_unavailable");
            Context r10 = this.this$0.getContext();
            if (r10 == null) goto L22;
            s.a.g(r10, 2131905676, false);
        L22:
            INVOKEVIRTUAL_com_larus_drive_sdk_impl_view_preview_AiFilePreviewShareSheet$onViewCreated$3_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(this.this$0);
            return Unit.INSTANCE;
        L24:
            AiFilePreviewShareSheet r5 = this.this$0;
            com.larus.drive.sdk.impl.store.a r6 = this.$session;
            Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L27
            AiFilePreviewShareSheet.V90(r5, r6, r8);     // Catch: Throwable -> L27
            Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L27
        L29:
            AiFilePreviewShareSheet r13 = this.this$0;
            Throwable r14 = Result.exceptionOrNull-impl(r12);
            if (r14 == null) goto L36;
            FLogger.a.e("AiFilePreviewShare", "show share panel failed, errorType=".concat(r14.getClass().getSimpleName()));
            a r15 = AiFilePreviewShareSheet.j;
            r13.W90(false, "share_panel_unavailable");
            Context r16 = r13.getContext();
            if (r16 == null) goto L34;
            s.a.g(r16, 2131905676, false);
        L34:
            INVOKEVIRTUAL_com_larus_drive_sdk_impl_view_preview_AiFilePreviewShareSheet$onViewCreated$3_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(r13);
        L36:
            return Unit.INSTANCE;
        L27:
            th = move-exception;
            Result.Companion r17 = Result.Companion;
            r12 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L29
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            CoroutineScope r18 = (CoroutineScope) this.L$0;
            AiFilePreviewShareSheet r20 = this.this$0;
            com.larus.drive.sdk.impl.store.a r21 = this.$session;
            this.L$0 = r18;
            this.label = 1;
            r7 = AiFilePreviewShareSheet.U90(r20, r21, this);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    public final int getTheme() {
        return 2131954335;
    }

    static {
        j = new a();
    }

    public final void onDestroyView() {
        Job r0 = this.f;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.f = null;
        l0 r1 = this.g;
        if (r1 == null) goto L8;
        T90(r1);
    L8:
        this.g = null;
        com.larus.bmhome.share.panel.a r2 = this.e;
        if (r2 == null) goto L11;
        r2.b();
    L11:
        this.e = null;
        this.d = null;
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*androidx.fragment.app.DialogFragment*/.onStart();
        BottomSheetDialog r0 = getDialog();
        if ((r0 instanceof BottomSheetDialog) == false) goto L5;
        BottomSheetDialog r1 = r0;
    L6:
        if (r1 == null) goto L11;
        FrameLayout r2 = (FrameLayout) r1.findViewById(2131368870);
        if (r2 == null) goto L12;
        r2.setBackgroundResource(R.color.transparent);
        BottomSheetBehavior r3 = BottomSheetBehavior.from(r2);
        r3.setSkipCollapsed(true);
        r3.setState(3);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public AiFilePreviewShareSheet() {
    }

    public static void S90(AiFilePreviewShareSheet r1) {
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

    public static void T90(l0 r3) {
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

    public final void onCancel(DialogInterface r3) {
        Intrinsics.checkNotNullParameter(r3, "dialog");
        W90(false, "cancel");
        super/*androidx.fragment.app.DialogFragment*/.onCancel(r3);
    }

    public final void onCreate(Bundle r2) {
        Context r0 = getContext();
        if (r0 == null) goto L7;
        Resources.Theme r1 = r0.getTheme();
        if (r1 == null) goto L7;
        v19.f.a(r1);
    L7:
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r2);
    }

    public final Dialog onCreateDialog(Bundle r3) {
        Dialog r4 = super.onCreateDialog(r3);
        Window r0 = r4.getWindow();
        if (r0 == null) goto L5;
        r0.setSoftInputMode(16);
    L5:
        return r4;
    }

    public final void W90(boolean r5, String r6) {
        if (this.i == false) goto L5;
        return;
    L5:
        Bundle r0 = getArguments();
        if (r0 == null) goto L19;
        String r1 = r0.getString("open_result_request_key");
        if (r1 != null) goto L10;
        return;
    L10:
        if ((!StringsKt.isBlank(r1)) == true) goto L13;
        r1 = null;
    L13:
        if (r1 == null) goto L21;
        this.i = true;
        FragmentManager r2 = getParentFragmentManager();
        Bundle r3 = new Bundle();
        r3.putBoolean("result_success", r5);
        if (r6 == null) goto L17;
        r3.putString("result_error_code", r6);
    L17:
        Unit r7 = Unit.INSTANCE;
        r2.setFragmentResult(r1, r3);
        return;
    L21:
        return;
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r8, r9);
        Bundle r10 = getArguments();
        if (r10 == null) goto L5;
        String r11 = r10.getString("request_id");
    L7:
        if (r11 == null) goto L20;
        DrivePreviewRequestStore r1 = DrivePreviewRequestStore.a;
        monitor-enter(r1);
        Intrinsics.checkNotNullParameter(r11, "requestId");     // Catch: Throwable -> L17
        DrivePreviewRequestStore.a r12 = DrivePreviewRequestStore.a(r11, true);     // Catch: Throwable -> L17
        if (r12 != null) goto L14;
        monitor-exit(r1);
        goto L20
    L14:
        com.larus.drive.sdk.impl.store.a r13 = r12.d;     // Catch: Throwable -> L17
        monitor-exit(r1);
    L22:
        if (r13 != null) goto L25;
        FLogger.a.w("AiFilePreviewShare", "dismiss share sheet because preview session is unavailable");
        W90(false, "session_unavailable");
        S90(this);
        return;
    L25:
        LarusDialogAiFilePreviewShareBinding r2 = this.d;
        if (r2 == null) goto L30;
        AppCompatImageView r3 = r2.b;
        if (r3 == null) goto L30;
        r3.setOnClickListener(new com.larus.drive.sdk.impl.view.preview.a(this));
    L30:
        LarusDialogAiFilePreviewShareBinding r4 = this.d;
        if (r4 == null) goto L46;
        AppCompatTextView r5 = r4.e;
        if (r5 == null) goto L46;
        String r6 = r13.e;
        if (r6 != null) goto L37;
    L42:
        r6 = r13.a.getCurrent().getTitle();
        if (r6 != null) goto L45;
        r6 = "";
    L45:
        r5.setText(r6);
        goto L46
    L37:
        if ((true ^ StringsKt.isBlank(r6)) == true) goto L40;
        r6 = null;
    L40:
        if (r6 == null) goto L42;
    L46:
        FLogger.a.i("AiFilePreviewShare", "share sheet opened");
        this.f = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new AnonymousClass3(this, r13, null), 3, null);
        return;
    L17:
        th = move-exception;
        throw th;
    L20:
        r13 = null;
        goto L22
    L5:
        r11 = null;
        goto L7
    }

    public static final Object U90(AiFilePreviewShareSheet r22, com.larus.drive.sdk.impl.store.a r23, Continuation r24) {
        r22.getClass();
        if ((r24 instanceof AiFilePreviewShareSheet$resolveShareUrl$1) == false) goto L7;
        AiFilePreviewShareSheet$resolveShareUrl$1 r2 = (AiFilePreviewShareSheet$resolveShareUrl$1) r24;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        Object r6 = null;
        boolean r8 = true;
        if (r5 == 0) goto L17;
        if (r5 != 1) goto L16;
        ResultKt.throwOnFailure(r1);     // Catch: Throwable -> L13
    L31:
        String r7 = (String) r1;     // Catch: Throwable -> L13
    L33:
        Object r0 = Result.constructor-impl(r7);     // Catch: Throwable -> L13
    L36:
        Throwable r9 = Result.exceptionOrNull-impl(r0);
        if (r9 == null) goto L40;
        FLogger.a.e("AiFilePreviewShare", "resolve share url failed, errorType=".concat(r9.getClass().getSimpleName()));
    L40:
        if (Result.isFailure-impl(r0) == true) goto L43;
        r6 = r0;
    L43:
        String r10 = (String) r6;
        if (r10 != null) goto L46;
    L49:
        if (r8 == true) goto L52;
        FLogger.a.i("AiFilePreviewShare", "resolve share url, source=dynamic");
        return r10;
    L52:
        if (Result.isSuccess-impl(r0) == false) goto L60;
        FLogger.a.w("AiFilePreviewShare", "resolve share url failed, reason=empty_result");
        return r10;
    L60:
        return r10;
    L46:
        if (StringsKt.isBlank(r10) == true) goto L49;
        r8 = false;
        goto L49
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r1);
        String r11 = r23.d;
        if (r11 != null) goto L20;
    L25:
        UplinkFileInfo r12 = new UplinkFileInfo(r23.e, r23.b, null, Boxing.boxInt(FileType.FileTypeFile.getValue()), null, r23.c, null, r23.f, null, null, 852, null);
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L13
        INestFileService r14 = (INestFileService) ServiceManager.get().getService(INestFileService.class);     // Catch: Throwable -> L13
        if (r14 == null) goto L32;
        Context r15 = r22.requireContext();     // Catch: Throwable -> L13
        r2.label = 1;     // Catch: Throwable -> L13
        r1 = r14.a(r15, r12, r2);     // Catch: Throwable -> L13
        if (r1 != r4) goto L31;
        return r4;
    L32:
        r7 = null;
        goto L33
    L20:
        if ((!StringsKt.isBlank(r11)) == true) goto L23;
        r11 = null;
    L23:
        if (r11 == null) goto L25;
        FLogger.a.i("AiFilePreviewShare", "resolve share url, source=direct");
        return r11;
    L13:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r2 = new AiFilePreviewShareSheet$resolveShareUrl$1(r22, r24);
        goto L8
    }

    public static final void V90(AiFilePreviewShareSheet r92, com.larus.drive.sdk.impl.store.a r93, String r94) {
        Context r10 = r92.getContext();
        if (r10 != null) goto L5;
        r92.W90(false, "fragment_unavailable");
        return;
    L5:
        FLogger r12 = FLogger.a;
        r12.i("AiFilePreviewShare", "create share panel");
        String r2 = r93.e;
        if (r2 != null) goto L8;
    L13:
        r2 = r93.a.getCurrent().getTitle();
        if (r2 != null) goto L16;
    L18:
        r2 = null;
    L19:
        if (r2 != null) goto L21;
        r2 = "file";
    L21:
        String r4 = r93.b;
        String r5 = r93.f;
        if (r5 != null) goto L24;
        r5 = "";
    L24:
        com.larus.bmhome.share.panel.c r3 = new com.larus.bmhome.share.panel.c(r4, r2, r5);
        ShareServiceDelegate r6 = ShareServiceDelegate.b;
        ShareScene r7 = ShareScene.BOT_FILE_PREVIEW;
        com.larus.bmhome.share.panel.b r8 = new com.larus.bmhome.share.panel.b(null, null, r94, null, null, null, null, r2, null, null, null, r94, r2, null, null, null, false, false, null, null, false, false, null, false, null, r3, 33548155);
        String r9 = r93.a.getCurrent().getFileExt();
        if (r9 == null) goto L41;
        String r11 = StringsKt.trim(r9).toString();
        if (r11 == null) goto L41;
        String r13 = StringsKt.removePrefix(r11, ".");
        if (r13 == null) goto L41;
        String r14 = r13.toLowerCase(Locale.ROOT);
        if (r14 == null) goto L41;
        if (r14.length() <= 0) goto L35;
        boolean r15 = true;
    L36:
        if (r15 == true) goto L39;
        r14 = null;
    L39:
        if (r14 == null) goto L41;
    L46:
        String r87 = r14;
    L48:
        com.larus.bmhome.share.panel.a r1 = IShareService.a.a(r6, r10, r7, r8, true, new com.larus.bmhome.share.panel.h(null, null, null, "preview", null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, MapsKt.mapOf(TuplesKt.to("message_forward", "select_more_conversations")), false, null, null, r87, null, -17, -1, 751), new c(r92, r3, r93, r2), null, 512);
        if (r1 != null) goto L51;
        r12.w("AiFilePreviewShare", "dismiss share sheet, reason=share_panel_unavailable");
        r92.W90(false, "share_panel_unavailable");
        s.a.g(r10, 2131905676, false);
        S90(r92);
        return;
    L51:
        r92.e = r1;
        LarusDialogAiFilePreviewShareBinding r16 = r92.d;
        if (r16 == null) goto L56;
        ProgressBar r17 = r16.d;
        if (r17 == null) goto L56;
        r17.setVisibility(8);
    L56:
        LarusDialogAiFilePreviewShareBinding r18 = r92.d;
        if (r18 == null) goto L61;
        FrameLayout r20 = r18.c;
        if (r20 == null) goto L61;
        r1.setVisibility(0);
        r20.addView(r1, new FrameLayout.LayoutParams(-1, -2));
    L61:
        r92.W90(true, null);
        r12.i("AiFilePreviewShare", "share panel shown");
        return;
    L35:
        r15 = false;
    L41:
        r14 = StringsKt.trim(StringsKt.substringAfterLast(r2, '.', "")).toString().toLowerCase(Locale.ROOT);
        if (r14.length() <= 0) goto L44;
        boolean r21 = true;
    L45:
        if (r21 == true) goto L46;
        r87 = null;
        goto L48
    L44:
        r21 = false;
        goto L45
    L16:
        if ((!StringsKt.isBlank(r2)) == false) goto L18;
    L8:
        if ((!StringsKt.isBlank(r2)) == true) goto L11;
        r2 = null;
    L11:
        if (r2 == null) goto L13;
        goto L13
    }

    public final View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        View r10 = r7.inflate(2131562028, r8, false);
        int r11 = 2131386068;
        AppCompatImageView r2 = ViewBindings.findChildViewById(r10, 2131386068);
        if (r2 == null) goto L13;
        r11 = 2131386114;
        FrameLayout r3 = (FrameLayout) ViewBindings.findChildViewById(r10, 2131386114);
        if (r3 == null) goto L13;
        r11 = 2131386122;
        ProgressBar r4 = (ProgressBar) ViewBindings.findChildViewById(r10, 2131386122);
        if (r4 == null) goto L13;
        r11 = 2131386144;
        AppCompatTextView r5 = ViewBindings.findChildViewById(r10, 2131386144);
        if (r5 == null) goto L13;
        RoundLinearLayout r12 = (RoundLinearLayout) r10;
        this.d = new LarusDialogAiFilePreviewShareBinding(r12, r2, r3, r4, r5);
        return r12;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }
}
