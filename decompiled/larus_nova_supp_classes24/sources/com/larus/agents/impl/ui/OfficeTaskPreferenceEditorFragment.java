package com.larus.agents.impl.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.agents.api.OfficeTaskPreferenceSaveResult;
import com.larus.agents.api.OfficeTaskSettingsServiceDelegate;
import com.larus.agents.impl.databinding.LarusFragmentOfficeTaskPreferenceEditorBinding;
import com.larus.agents.impl.settings.KevaOfficeTaskPreferenceRepository;
import com.larus.common_ui.dialog.l0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
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
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0018\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u000eH\u0002J\u0018\u0010 \u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u000eH\u0002J\u0010\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u0014H\u0016J\u0010\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020\u0012H\u0002J\b\u0010'\u001a\u00020\u0012H\u0002J\b\u0010(\u001a\u00020\u0012H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/larus/agents/impl/ui/OfficeTaskPreferenceEditorFragment;", "Lcom/larus/agents/impl/ui/ExpandedTaskBottomSheetFragment;", "<init>", "()V", "binding", "Lcom/larus/agents/impl/databinding/LarusFragmentOfficeTaskPreferenceEditorBinding;", "loadingDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "loadJob", "Lkotlinx/coroutines/Job;", "hasUserEdited", "", "isApplyingLoadedInstruction", "draftInstruction", "", "localRepository", "Lcom/larus/agents/impl/settings/KevaOfficeTaskPreferenceRepository;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "applyLoadedInstruction", "targetBinding", "instruction", "applyInstruction", "onSaveInstanceState", "outState", "showSaveResult", "saveResult", "Lcom/larus/agents/api/OfficeTaskPreferenceSaveResult;", "showLoading", "dismissLoading", "onDestroyView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class OfficeTaskPreferenceEditorFragment extends ExpandedTaskBottomSheetFragment {
    public static final /* synthetic */ int m = 0;
    public LarusFragmentOfficeTaskPreferenceEditorBinding f;
    public l0 g;
    public Job h;
    public boolean i;
    public boolean j;
    public String k;
    public final KevaOfficeTaskPreferenceRepository l;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OfficeTaskPreferenceSaveResult.values().length];
            r0[OfficeTaskPreferenceSaveResult.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[OfficeTaskPreferenceSaveResult.MAX_CHARACTER_LIMIT_EXCEEDED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[OfficeTaskPreferenceSaveResult.SECURITY_RISK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[OfficeTaskPreferenceSaveResult.FAILURE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final class c implements TextWatcher {
        public final /* synthetic */ OfficeTaskPreferenceEditorFragment a;
        public final /* synthetic */ LarusFragmentOfficeTaskPreferenceEditorBinding b;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r3) {
            OfficeTaskPreferenceEditorFragment r0 = this.a;
            if (r0.j == true) goto L12;
            r0.i = true;
            if (r3 == null) goto L7;
            String r4 = r3.toString();
        L8:
            if (r4 != null) goto L10;
            r4 = "";
        L10:
            r0.k = r4;
            this.b.d.setEnabled(true);
            return;
        L7:
            r4 = null;
            goto L8
        }

        public c(OfficeTaskPreferenceEditorFragment r1, LarusFragmentOfficeTaskPreferenceEditorBinding r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    /* JADX INFO: renamed from: com.larus.agents.impl.ui.OfficeTaskPreferenceEditorFragment$onViewCreated$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larus.agents.impl.ui.OfficeTaskPreferenceEditorFragment$onViewCreated$3", f = "OfficeTaskPreferenceEditorFragment.kt", i = {}, l = {76, 89}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ LarusFragmentOfficeTaskPreferenceEditorBinding $panelBinding;
        int label;
        final /* synthetic */ OfficeTaskPreferenceEditorFragment this$0;

        public AnonymousClass3(OfficeTaskPreferenceEditorFragment r1, LarusFragmentOfficeTaskPreferenceEditorBinding r2, Continuation<? super AnonymousClass3> r3) {
            this.this$0 = r1;
            this.$panelBinding = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass3(this.this$0, this.$panelBinding, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L12;
            if (r2 == 1) goto L10;
            if (r2 != 2) goto L9;
            ResultKt.throwOnFailure(r10);     // Catch: Exception -> L51 CancellationException -> L53
        L43:
            String r11 = (String) r10;     // Catch: Exception -> L51 CancellationException -> L53
            OfficeTaskPreferenceEditorFragment r0 = this.this$0;     // Catch: Exception -> L51 CancellationException -> L53
            LarusFragmentOfficeTaskPreferenceEditorBinding r3 = this.$panelBinding;     // Catch: Exception -> L51 CancellationException -> L53
            if (r0.i == true) goto L60;
            if (r0.f != r3) goto L60;
            r0.j = true;     // Catch: Exception -> L51 CancellationException -> L53
            r3.c.setText(r11);     // Catch: Throwable -> L55
            r3.c.setSelection(r11.length());     // Catch: Throwable -> L55
            r0.j = false;     // Catch: Exception -> L51 CancellationException -> L53
        L55:
            th = move-exception;
            r0.j = false;     // Catch: Exception -> L51 CancellationException -> L53
            throw th;     // Catch: Exception -> L51 CancellationException -> L53
        L60:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L24 Exception -> L26 CancellationException -> L28
        L16:
            String r12 = ((com.larus.agents.impl.settings.b) r10).a;     // Catch: Throwable -> L24 Exception -> L26 CancellationException -> L28
            OfficeTaskPreferenceEditorFragment r4 = this.this$0;     // Catch: Throwable -> L24 Exception -> L26 CancellationException -> L28
            LarusFragmentOfficeTaskPreferenceEditorBinding r7 = this.$panelBinding;     // Catch: Throwable -> L24 Exception -> L26 CancellationException -> L28
            if (r4.i == false) goto L19;
        L33:
            LarusFragmentOfficeTaskPreferenceEditorBinding r13 = this.this$0.f;
            LarusFragmentOfficeTaskPreferenceEditorBinding r5 = this.$panelBinding;
            if (r13 == r5) goto L39;
        L40:
            OfficeTaskSettingsServiceDelegate r14 = OfficeTaskSettingsServiceDelegate.a;     // Catch: Exception -> L51 CancellationException -> L53
            this.label = 2;     // Catch: Exception -> L51 CancellationException -> L53
            r10 = r14.c(this);     // Catch: Exception -> L51 CancellationException -> L53
            if (r10 != r1) goto L43;
            return r1;
        L39:
            r5.d.setEnabled(true);
            goto L40
        L19:
            if (r4.f != r7) goto L33;
            r4.j = true;     // Catch: Throwable -> L24 Exception -> L26 CancellationException -> L28
            r7.c.setText(r12);     // Catch: Throwable -> L30
            r7.c.setSelection(r12.length());     // Catch: Throwable -> L30
            r4.j = false;     // Catch: Throwable -> L24 Exception -> L26 CancellationException -> L28
        L30:
            th = move-exception;
            r4.j = false;     // Catch: Throwable -> L24 Exception -> L26 CancellationException -> L28
            throw th;     // Catch: Throwable -> L24 Exception -> L26 CancellationException -> L28
        L12:
            ResultKt.throwOnFailure(r10);
            KevaOfficeTaskPreferenceRepository r15 = this.this$0.l;     // Catch: Throwable -> L24 Exception -> L26 CancellationException -> L28
            this.label = 1;     // Catch: Throwable -> L24 Exception -> L26 CancellationException -> L28
            r10 = r15.a(this);     // Catch: Throwable -> L24 Exception -> L26 CancellationException -> L28
            if (r10 != r1) goto L16;
            return r1;
        L24:
            th = move-exception;
            LarusFragmentOfficeTaskPreferenceEditorBinding r6 = this.this$0.f;
            LarusFragmentOfficeTaskPreferenceEditorBinding r8 = this.$panelBinding;
            if (r6 != r8) goto L66;
            r8.d.setEnabled(true);
        L66:
            throw th;
        L28:
            e = move-exception;
            throw e;     // Catch: Throwable -> L24
        L26:
            e = move-exception;
            FLogger.a.e("OfficeTaskPreferenceEditorFragment", "load cached preference failed: ".concat(e.getClass().getSimpleName()));     // Catch: Throwable -> L24
            LarusFragmentOfficeTaskPreferenceEditorBinding r16 = this.this$0.f;
            r5 = this.$panelBinding;
            if (r16 != r5) goto L40;
        L53:
            e = move-exception;
            throw e;
        L51:
            e = move-exception;
            FLogger.a.e("OfficeTaskPreferenceEditorFragment", "refresh preference failed: ".concat(e.getClass().getSimpleName()));
            goto L60
        }
    }

    static {
    }

    public final void dismissLoading() {
        l0 r0 = this.g;
        if (r0 != null) goto L5;
        return;
    L5:
        this.g = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        X90(r0);     // Catch: Throwable -> L8
        Object r2 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r3 = Result.exceptionOrNull-impl(r2);
        if (r3 == null) goto L16;
        FLogger.a.e("OfficeTaskPreferenceEditorFragment", "dismiss loading failed: ".concat(r3.getClass().getSimpleName()));
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    @Override // com.larus.agents.impl.ui.ExpandedTaskBottomSheetFragment
    public final void onDestroyView() {
        Job r0 = this.h;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.h = null;
        dismissLoading();
        this.f = null;
        super.onDestroyView();
    }

    public OfficeTaskPreferenceEditorFragment() {
        this.l = new KevaOfficeTaskPreferenceRepository();
    }

    public static void X90(l0 r3) {
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

    public final void onCreate(Bundle r2) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r2);
        if (r2 == null) goto L5;
        boolean r0 = r2.getBoolean("has_user_edited");
    L6:
        this.i = r0;
        if (r2 == null) goto L9;
        String r3 = r2.getString("draft_instruction");
    L10:
        this.k = r3;
        return;
    L9:
        r3 = null;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    public final void onSaveInstanceState(Bundle r3) {
        Intrinsics.checkNotNullParameter(r3, "outState");
        r3.putBoolean("has_user_edited", this.i);
        if (this.i == false) goto L8;
        String r0 = this.k;
        if (r0 != null) goto L7;
        r0 = "";
    L7:
        r3.putString("draft_instruction", r0);
    L8:
        super/*androidx.fragment.app.DialogFragment*/.onSaveInstanceState(r3);
    }

    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super.onViewCreated(r7, r8);
        Dialog r9 = getDialog();
        if (r9 == null) goto L5;
        r9.setOnShowListener(new com.larus.agents.impl.ui.b(this));
    L5:
        final LarusFragmentOfficeTaskPreferenceEditorBinding r10 = this.f;
        if (r10 != null) goto L8;
        return;
    L8:
        this.j = false;
        r10.c.setEnabled(true);
        r10.b.setOnClickListener(new com.larus.agents.impl.ui.c(this));
        r10.d.setEnabled(this.i);
        r10.c.addTextChangedListener(new c(this, r10));
        if (this.i == false) goto L19;
        String r0 = this.k;
        if (r0 != null) goto L13;
        r0 = "";
    L13:
        this.j = true;
        r10.c.setText(r0);     // Catch: Throwable -> L16
        r10.c.setSelection(r0.length());     // Catch: Throwable -> L16
        this.j = false;
    L16:
        th = move-exception;
        this.j = false;
        throw th;
    L19:
        this.h = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new AnonymousClass3(this, r10, null), 3, null);
        r10.d.setOnClickListener(new d(r10, this));
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        View r6 = r3.inflate(2131562418, r4, false);
        int r7 = 2131381397;
        AppCompatImageView r8 = ViewBindings.findChildViewById(r6, 2131381397);
        if (r8 == null) goto L11;
        r7 = 2131381398;
        AppCompatEditText r0 = ViewBindings.findChildViewById(r6, 2131381398);
        if (r0 == null) goto L11;
        r7 = 2131381400;
        AppCompatImageView r1 = ViewBindings.findChildViewById(r6, 2131381400);
        if (r1 == null) goto L11;
        LinearLayout r9 = (LinearLayout) r6;
        this.f = new LarusFragmentOfficeTaskPreferenceEditorBinding(r9, r8, r0, r1);
        return W90(r9);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r7)));
    }
}
