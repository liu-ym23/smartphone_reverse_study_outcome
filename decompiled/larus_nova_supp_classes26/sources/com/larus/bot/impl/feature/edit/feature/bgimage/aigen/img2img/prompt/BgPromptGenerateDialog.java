package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.bmhome.utils.x1;
import com.larus.bot.impl.common.util.j;
import com.larus.bot.impl.databinding.LarusDialogBgPromptGenerateBinding;
import com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.widget.PromptInputButtonView;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 -2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u000eH\u0016J&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u001bH\u0016J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!H\u0016J\u000e\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\fJ\u000e\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u0010J\u000f\u0010&\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0002\u0010'J\b\u0010(\u001a\u00020\u001bH\u0002J\u0017\u0010)\u001a\u0004\u0018\u00010\u001b2\u0006\u0010*\u001a\u00020+H\u0002¢\u0006\u0002\u0010,R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/prompt/BgPromptGenerateDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/bot/impl/databinding/LarusDialogBgPromptGenerateBinding;", "imeManager", "Lcom/larus/bmhome/utils/ImeManager;", "isImeShown", "", "hasBindObservers", "viewModel", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/prompt/IBgPromptGenerateViewModel;", "prePromptEditState", "", "initialPrompt", "", "getTheme", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "onDestroyView", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "bindViewModel", "vm", "initPrompt", "prompt", "initView", "()Lkotlin/Unit;", "bindObservers", "refreshState", "state", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/prompt/BgPromptGenerateUIState;", "(Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/prompt/BgPromptGenerateUIState;)Lkotlin/Unit;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BgPromptGenerateDialog extends BottomSheetDialogFragment {
    public static final /* synthetic */ int k = 0;
    public LarusDialogBgPromptGenerateBinding d;
    public x1 e;
    public boolean f;
    public boolean g;
    public i h;
    public int i;
    public String j;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnKeyListener {
        public final /* synthetic */ BgPromptGenerateDialog a;

        public b(BgPromptGenerateDialog r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public final boolean onKey(DialogInterface r1, int r2, KeyEvent r3) {
            if (r2 != 4) goto L13;
            FLogger.a.i("AIGenBgImageChooseDialog", "dismiss when key back");
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L7
            return true;
        L7:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r4 = DialogFragmentLancet.sLastShowStack;
            if (r4 == null) goto L17;
            com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return true;
        L17:
            return true;
        L13:
            return false;
        }
    }

    static {
    }

    public final int getTheme() {
        return 2131951931;
    }

    public BgPromptGenerateDialog() {
        this.j = "";
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        this.d = null;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        LarusDialogBgPromptGenerateBinding r0 = this.d;
        if (r0 == null) goto L8;
        r0.b.requestFocus();
        x1 r1 = this.e;
        if (r1 == null) goto L9;
        x1.d(r1, 3);
        return;
    L9:
        return;
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L7
        super/*androidx.fragment.app.DialogFragment*/.onDismiss(r2);     // Catch: Throwable -> L7
        i r3 = this.h;     // Catch: Throwable -> L7
        if (r3 == null) goto L5;
        r3.dispatchUIAction(d.c.a);     // Catch: Throwable -> L7
    L5:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L7:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.b, java.lang.Object] */
    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r5, r6);
        Dialog r7 = getDialog();
        if (r7 == null) goto L7;
        Window r8 = r7.getWindow();
        if (r8 == null) goto L7;
        r8.setSoftInputMode(5);
    L7:
        Dialog r9 = getDialog();
        if (r9 == null) goto L10;
        r9.setOnKeyListener(new b(this));
    L10:
        LarusDialogBgPromptGenerateBinding r10 = this.d;
        if (r10 == null) goto L17;
        ConstraintLayout r11 = r10.a;
        if (r11 == null) goto L17;
        ViewTreeObserver r12 = r11.getViewTreeObserver();
        if (r12 == null) goto L17;
        r12.addOnGlobalLayoutListener(new com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.a(this));
    L17:
        LarusDialogBgPromptGenerateBinding r13 = this.d;
        if (r13 == null) goto L25;
        r13.b.setText(this.j);
        AppCompatEditText r14 = r13.b;
        Editable r0 = r14.getText();
        if (r0 == null) goto L22;
        int r1 = r0.length();
    L23:
        r14.setSelection(r1);
        AppCompatEditText r15 = r13.b;
        ?? r2 = new com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.b(this);
        Intrinsics.checkNotNullParameter(r15, "<this>");
        Intrinsics.checkNotNullParameter(r2, "afterTextChanged");
        Ref.ObjectRef r3 = new Ref.ObjectRef();
        r3.element = "";
        r15.addTextChangedListener(new av8.a(r3, new Ref.IntRef(), r2, r15));
        e1.d(r13.c, new c(this));
        j.a(r13.b);
        Unit r16 = Unit.INSTANCE;
        return;
    L22:
        r1 = 0;
        goto L23
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        ConstraintLayout r5 = r2.inflate(2131562035, r3, false);
        int r6 = 2131383384;
        AppCompatEditText r7 = ViewBindings.findChildViewById(r5, 2131383384);
        if (r7 == null) goto L9;
        r6 = 2131383386;
        PromptInputButtonView r0 = (PromptInputButtonView) ViewBindings.findChildViewById(r5, 2131383386);
        if (r0 == null) goto L9;
        ConstraintLayout r8 = r5;
        LarusDialogBgPromptGenerateBinding r9 = new LarusDialogBgPromptGenerateBinding(r8, r7, r0);
        this.e = new x1(r7);
        this.d = r9;
        return r8;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }
}
