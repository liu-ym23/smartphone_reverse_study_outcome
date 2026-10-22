package com.larus.community.impl.detail.prompt;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.larus.bmhome.utils.c4;
import com.larus.platform.api.Image;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\r\u001a\u00020\f2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J&\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u00172\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u0017H\u0002J\u001a\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010#\u001a\u00020\fH\u0016J\b\u0010$\u001a\u00020\fH\u0016J\u0010\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020'H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/larus/community/impl/detail/prompt/CreationDetailPromptRefVideoViewerDialogV2;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "coverImage", "Lcom/larus/platform/api/Image;", "videoModelString", "", "eventParam", "Lcom/larus/bmhome/utils/VideoDetailEventParams;", "dismissListener", "Lkotlin/Function0;", "", "setOnDismissListener", "listener", "getTheme", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initView", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "dismiss", "dismissAllowingStateLoss", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationDetailPromptRefVideoViewerDialogV2 extends DialogFragment {
    public static final /* synthetic */ int h = 0;
    public Image d;
    public String e;
    public c4 f;
    public Function0<Unit> g;

    public static final class a {
    }

    static {
    }

    public final int getTheme() {
        return 2131952450;
    }

    public final void dismiss() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        super.dismiss();     // Catch: Exception -> L5 Throwable -> L11
    L9:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L9;
        com.bytedance.crash.d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final void dismissAllowingStateLoss() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        super.dismissAllowingStateLoss();     // Catch: Exception -> L5 Throwable -> L11
    L9:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L9;
        com.bytedance.crash.d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public CreationDetailPromptRefVideoViewerDialogV2() {
    }

    public static void S90(CreationDetailPromptRefVideoViewerDialogV2 r1) {
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

    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        if (r1 == null) goto L6;
        S90(this);
        return;
    }

    public final Dialog onCreateDialog(Bundle r3) {
        Dialog r4 = super.onCreateDialog(r3);
        Window r0 = r4.getWindow();
        if (r0 == null) goto L5;
        r0.setLayout(-1, -1);
    L5:
        Window r1 = r4.getWindow();
        if (r1 == null) goto L8;
        r1.setDimAmount(0.85f);
    L8:
        return r4;
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L13
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        super.onDismiss(r2);     // Catch: Throwable -> L9
        Function0<Unit> r3 = this.g;     // Catch: Throwable -> L9
        if (r3 == null) goto L6;
        r3.invoke();     // Catch: Throwable -> L9
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Result.constructor-impl(r4);     // Catch: Throwable -> L9
    L11:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L6:
        r4 = null;
    L9:
        th = move-exception;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L13
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void onViewCreated(View r41, Bundle r42) {
        Intrinsics.checkNotNullParameter(r41, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r41, r42);
        r41.setOnClickListener(new m(this));
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L23
        FragmentTransaction r1 = getChildFragmentManager().beginTransaction();     // Catch: Throwable -> L23
        IAIChatUgcAIGCService.Companion r2 = IAIChatUgcAIGCService.a;     // Catch: Throwable -> L23
        String r5 = this.e;     // Catch: Throwable -> L23
        Image r3 = this.d;     // Catch: Throwable -> L23
        if (r3 == null) goto L6;
        String r17 = r3.a;     // Catch: Throwable -> L23
    L7:
        if (r3 == null) goto L9;
        Integer r21 = Integer.valueOf((int) r3.c);     // Catch: Throwable -> L23
    L10:
        Image r4 = this.d;     // Catch: Throwable -> L23
        if (r4 == null) goto L13;
        Integer r20 = Integer.valueOf((int) r4.d);     // Catch: Throwable -> L23
    L14:
        nr9.g r15 = new nr9.g(null, r5, null, null, null, null, new nr9.f(r17, null, null, r20, r21, null, 38), null, null, null, 957);     // Catch: Throwable -> L23
        c4 r6 = this.f;     // Catch: Throwable -> L23
        if (r6 != null) goto L17;
        r6 = new c4(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383);     // Catch: Throwable -> L23
    L17:
        Fragment r7 = r2.V(r15, r6);     // Catch: Throwable -> L23
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r1, r7, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131384840) == true) goto L21;
        r1 = r1.replace(2131384840, r7);     // Catch: Throwable -> L23
    L21:
        Object r8 = Result.constructor-impl(Integer.valueOf(r1.commitAllowingStateLoss()));     // Catch: Throwable -> L23
    L25:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L31;
        FLogger.a.w("CreationDetailPromptRefVideoViewerDialog", r9);
        S90(this);
        return;
    L31:
        return;
    L13:
        r20 = null;
        goto L14
    L9:
        r21 = null;
        goto L10
    L6:
        r17 = null;
    L23:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    }

    public final void show(FragmentManager r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L10
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Throwable -> L10
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r3, r1);     // Catch: Throwable -> L10
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, this, r1) == false) goto L16;
    L8:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L10
        return;
    L16:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13 Throwable -> L10
    L7:
        super.show(r2, r3);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131562000, r3, false);
    }
}
